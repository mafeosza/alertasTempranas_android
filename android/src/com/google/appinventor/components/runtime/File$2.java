// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Referenced classes of package com.google.appinventor.components.runtime:
//            File, Form

class val.text
    implements Runnable
{

    final com.google.appinventor.components.runtime.File this$0;
    final boolean val$append;
    final String val$filename;
    final String val$text;

    public void run()
    {
        String s = File.access$100(com.google.appinventor.components.runtime.File.this, val$filename);
        Object obj = new File(s);
        if (!((File) (obj)).exists())
        {
            try
            {
                ((File) (obj)).createNewFile();
            }
            catch (IOException ioexception)
            {
                if (val$append)
                {
                    form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "AppendTo", 2103, new Object[] {
                        s
                    });
                    return;
                } else
                {
                    form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "SaveFile", 2103, new Object[] {
                        s
                    });
                    return;
                }
            }
        }
        try
        {
            obj = new FileOutputStream(((File) (obj)), val$append);
            OutputStreamWriter outputstreamwriter = new OutputStreamWriter(((java.io.OutputStream) (obj)));
            outputstreamwriter.write(val$text);
            outputstreamwriter.flush();
            outputstreamwriter.close();
            ((FileOutputStream) (obj)).close();
            return;
        }
        catch (IOException ioexception1) { }
        if (val$append)
        {
            form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "AppendTo", 2104, new Object[] {
                s
            });
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.File.this, "SaveFile", 2104, new Object[] {
                s
            });
            return;
        }
    }

    ()
    {
        this$0 = final_file;
        val$filename = s;
        val$append = flag;
        val$text = String.this;
        super();
    }
}
