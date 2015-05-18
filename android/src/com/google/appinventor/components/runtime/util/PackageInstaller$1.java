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
//            PackageInstaller

static final class val.form
    implements Runnable
{

    final Form val$form;
    final String val$inurl;

    public void run()
    {
        Object obj;
        Object obj1;
        FileOutputStream fileoutputstream;
        byte abyte0[];
        obj1 = (new URL(val$inurl)).openConnection();
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
                val$form.dispatchErrorOccurredEvent(val$form, "PackageInstaller", 1101, new Object[] {
                    val$inurl
                });
                return;
            }
        }
          goto _L1
        ((InputStream) (obj1)).close();
        fileoutputstream.close();
        Log.d("PackageInstaller(AppInventor)", (new StringBuilder()).append("About to Install package from ").append(val$inurl).toString());
        obj1 = new Intent("android.intent.action.VIEW");
        ((Intent) (obj1)).setDataAndType(Uri.fromFile(new File((new StringBuilder()).append(obj).append("/package.apk").toString())), "application/vnd.android.package-archive");
        val$form.startActivity(((Intent) (obj1)));
        return;
    }

    (String s, Form form1)
    {
        val$inurl = s;
        val$form = form1;
        super();
    }
}
