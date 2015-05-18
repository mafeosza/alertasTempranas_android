// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.appinventor.components.runtime.util.AppInvHTTPD;
import com.google.appinventor.components.runtime.util.RetValManager;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Form, PhoneStatus

public class ReplForm extends Form
{

    private static final String REPL_ASSET_DIR = "/sdcard/AppInventor/assets/";
    public static ReplForm topform;
    private boolean IsUSBRepl;
    private boolean assetsLoaded;
    private AppInvHTTPD httpdServer;
    private boolean isDirect;
    private Object replResult;
    private String replResultFormName;

    public ReplForm()
    {
        httpdServer = null;
        IsUSBRepl = false;
        assetsLoaded = false;
        isDirect = false;
        replResult = null;
        replResultFormName = null;
        topform = this;
    }

    private void checkAssetDir()
    {
        File file = new File("/sdcard/AppInventor/assets/");
        if (!file.exists())
        {
            file.mkdirs();
        }
    }

    void HandleReturnValues()
    {
        Log.d("ReplForm", (new StringBuilder()).append("HandleReturnValues() Called, replResult = ").append(replResult).toString());
        if (replResult != null)
        {
            OtherScreenClosed(replResultFormName, replResult);
            Log.d("ReplForm", "Called OtherScreenClosed");
            replResult = null;
        }
    }

    public void addSettingsButton(Menu menu)
    {
        menu.add(0, 0, 3, "Settings").setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final ReplForm this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                PhoneStatus.doSettings();
                return true;
            }

            
            {
                this$0 = ReplForm.this;
                super();
            }
        }).setIcon(0x1080093);
    }

    protected void closeApplicationFromBlocks()
    {
        runOnUiThread(new Runnable() {

            final ReplForm this$0;

            public void run()
            {
                Toast.makeText(ReplForm.this, "Closing forms is not currently supported during development.", 1).show();
            }

            
            {
                this$0 = ReplForm.this;
                super();
            }
        });
    }

    protected void closeForm(Intent intent)
    {
        RetValManager.popScreen("Not Yet");
    }

    public boolean isAssetsLoaded()
    {
        return assetsLoaded;
    }

    public boolean isDirect()
    {
        return isDirect;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.d("ReplForm", "onCreate");
        processExtras(getIntent(), false);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);
        addSettingsButton(menu);
        return true;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (httpdServer != null)
        {
            httpdServer.stop();
            httpdServer = null;
        }
        finish();
        System.exit(0);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        Log.d("ReplForm", "onNewIntent Called");
        processExtras(intent, true);
    }

    protected void onResume()
    {
        super.onResume();
    }

    protected void onStop()
    {
        super.onStop();
    }

    protected void processExtras(Intent intent, boolean flag)
    {
label0:
        {
            intent = intent.getExtras();
            if (intent != null)
            {
                Log.d("ReplForm", (new StringBuilder()).append("extras: ").append(intent).toString());
                for (Iterator iterator = intent.keySet().iterator(); iterator.hasNext(); Log.d("ReplForm", (new StringBuilder()).append("Extra Key: ").append((String)iterator.next()).toString())) { }
            }
            if (intent != null && intent.getBoolean("rundirect"))
            {
                Log.d("ReplForm", (new StringBuilder()).append("processExtras rundirect is true and restart is ").append(flag).toString());
                isDirect = true;
                assetsLoaded = true;
                if (flag)
                {
                    clear();
                    if (httpdServer == null)
                    {
                        break label0;
                    }
                    httpdServer.resetSeq();
                }
            }
            return;
        }
        startHTTPD(true);
        intent = httpdServer;
        AppInvHTTPD.setHmacKey("emulator");
    }

    public void setAssetsLoaded()
    {
        assetsLoaded = true;
    }

    public void setFormName(String s)
    {
        formName = s;
        Log.d("ReplForm", (new StringBuilder()).append("formName is now ").append(s).toString());
    }

    public void setIsUSBrepl()
    {
        IsUSBRepl = true;
    }

    protected void setResult(Object obj)
    {
        Log.d("ReplForm", (new StringBuilder()).append("setResult: ").append(obj).toString());
        replResult = obj;
        replResultFormName = formName;
    }

    public void startHTTPD(boolean flag)
    {
        try
        {
            if (httpdServer == null)
            {
                checkAssetDir();
                httpdServer = new AppInvHTTPD(8001, new File("/sdcard/AppInventor/assets/"), flag, this);
                Log.i("ReplForm", "started AppInvHTTPD");
            }
            return;
        }
        catch (IOException ioexception)
        {
            Log.e("ReplForm", (new StringBuilder()).append("Setting up NanoHTTPD: ").append(ioexception.toString()).toString());
        }
    }

    protected void startNewForm(String s, Object obj)
    {
        if (obj != null)
        {
            startupValue = jsonEncodeForForm(obj, "open another screen with start value");
        }
        RetValManager.pushScreen(s, obj);
    }
}
