// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.util.Log;
import com.google.appinventor.components.runtime.util.GingerbreadUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, OnStopListener, OnResumeListener, OnPauseListener, 
//            OnNewIntentListener, Deleteable, ComponentContainer, Form, 
//            EventDispatcher

public class NearField extends AndroidNonvisibleComponent
    implements OnStopListener, OnResumeListener, OnPauseListener, OnNewIntentListener, Deleteable
{

    private static final String TAG = "nearfield";
    private Activity activity;
    private NfcAdapter nfcAdapter;
    private boolean readMode;
    protected int requestCode;
    private String tagContent;
    private String textToWrite;
    private int writeType;

    public NearField(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        readMode = true;
        tagContent = "";
        textToWrite = "";
        activity = componentcontainer.$context();
        writeType = 1;
        if (SdkLevel.getLevel() >= 9)
        {
            componentcontainer = GingerbreadUtil.newNfcAdapter(activity);
        } else
        {
            componentcontainer = null;
        }
        nfcAdapter = componentcontainer;
        form.registerForOnResume(this);
        form.registerForOnNewIntent(this);
        form.registerForOnPause(this);
        Log.d("nearfield", "Nearfield component created");
    }

    public String LastMessage()
    {
        Log.d("nearfield", "String message method stared");
        return tagContent;
    }

    public void ReadMode(boolean flag)
    {
        Log.d("nearfield", (new StringBuilder()).append("Read mode set to").append(flag).toString());
        readMode = flag;
        if (!readMode && SdkLevel.getLevel() >= 9)
        {
            GingerbreadUtil.enableNFCWriteMode(activity, nfcAdapter, textToWrite);
        }
    }

    public boolean ReadMode()
    {
        Log.d("nearfield", "boolean method stared");
        return readMode;
    }

    public void TagRead(String s)
    {
        Log.d("nearfield", (new StringBuilder()).append("Tag read: got message ").append(s).toString());
        tagContent = s;
        EventDispatcher.dispatchEvent(this, "TagRead", new Object[] {
            s
        });
    }

    public void TagWritten()
    {
        Log.d("nearfield", (new StringBuilder()).append("Tag written: ").append(textToWrite).toString());
        EventDispatcher.dispatchEvent(this, "TagWritten", new Object[0]);
    }

    public String TextToWrite()
    {
        Log.d("nearfield", "String message method stared");
        return textToWrite;
    }

    public void TextToWrite(String s)
    {
        Log.d("nearfield", (new StringBuilder()).append("Text to write set to").append(s).toString());
        textToWrite = s;
        if (!readMode && writeType == 1 && SdkLevel.getLevel() >= 9)
        {
            GingerbreadUtil.enableNFCWriteMode(activity, nfcAdapter, textToWrite);
        }
    }

    public int WriteType()
    {
        return writeType;
    }

    public void onDelete()
    {
    }

    public void onNewIntent(Intent intent)
    {
        Log.d("nearfield", (new StringBuilder()).append("Nearfield on onNewIntent.  Intent is: ").append(intent).toString());
        resolveIntent(intent);
    }

    public void onPause()
    {
        Log.d("nearfield", "OnPause method started.");
        if (nfcAdapter != null)
        {
            GingerbreadUtil.disableNFCAdapter(activity, nfcAdapter);
        }
    }

    public void onResume()
    {
        Intent intent = activity.getIntent();
        Log.d("nearfield", (new StringBuilder()).append("Nearfield on onResume.  Intent is: ").append(intent).toString());
    }

    public void onStop()
    {
    }

    void resolveIntent(Intent intent)
    {
        Log.d("nearfield", (new StringBuilder()).append("resolve intent. Intent is: ").append(intent).toString());
        if (SdkLevel.getLevel() >= 9)
        {
            GingerbreadUtil.resolveNFCIntent(intent, this);
        }
    }
}
