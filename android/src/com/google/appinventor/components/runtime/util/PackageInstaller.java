// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.google.appinventor.components.runtime.Form;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            AsynchUtil

public class PackageInstaller
{

    private static final String LOG_TAG = "PackageInstaller(AppInventor)";
    private static final String REPL_ASSET_DIR = "/sdcard/AppInventor/assets/";

    private PackageInstaller()
    {
    }

    public static void doPackageInstall(Form form, String s)
    {
        AsynchUtil.runAsynchronously(new Runnable(s, form) {

            final Form val$form;
            final String val$inurl;

            public void run()
            {
                Object obj;
                Object obj1;
                FileOutputStream fileoutputstream;
                byte abyte0[];
                obj1 = (new URL(inurl)).openConnection();
                obj = new File("/sdcard/AppInventor/assets/");
                obj1 = new BufferedInputStream(((URLConnection) (obj1)).getInputStream());
                fileoutputstream = new FileOutputStream(new File((new StringBuilder()).append(obj).append("/package.apk").toString()));
                abyte0 = new byte[32768];
_L1:
                int i = ((InputStream) (obj1)).read(abyte0, 0, 32768);
label0:
                {
                    if (i <= 0)
                    {
                        break label0;
                    }
                    try
                    {
                        fileoutputstream.write(abyte0, 0, i);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        form.dispatchErrorOccurredEvent(form, "PackageInstaller", 1101, new Object[] {
                            inurl
                        });
                        return;
                    }
                }
                  goto _L1
                ((InputStream) (obj1)).close();
                fileoutputstream.close();
                Log.d("PackageInstaller(AppInventor)", (new StringBuilder()).append("About to Install package from ").append(inurl).toString());
                obj1 = new Intent("android.intent.action.VIEW");
                ((Intent) (obj1)).setDataAndType(Uri.fromFile(new File((new StringBuilder()).append(obj).append("/package.apk").toString())), "application/vnd.android.package-archive");
                form.startActivity(((Intent) (obj1)));
                return;
            }

            
            {
                inurl = s;
                form = form1;
                super();
            }
        });
    }
}
