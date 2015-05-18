// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.net.Uri;
import android.webkit.MimeTypeMap;
import java.io.File;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, ComponentContainer, Form

public class Sharing extends AndroidNonvisibleComponent
{

    public Sharing(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
    }

    public void ShareFile(String s)
    {
        ShareFileWithMessage(s, "");
    }

    public void ShareFileWithMessage(String s, String s1)
    {
        String s2 = s;
        if (!s.startsWith("file://"))
        {
            s2 = (new StringBuilder()).append("file://").append(s).toString();
        }
        s = Uri.parse(s2);
        if ((new File(s.getPath())).isFile())
        {
            s2 = s2.substring(s2.lastIndexOf(".") + 1).toLowerCase();
            s2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(s2);
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", s);
            intent.setType(s2);
            if (s1.length() > 0)
            {
                intent.putExtra("android.intent.extra.TEXT", s1);
            }
            form.startActivity(intent);
            return;
        }
        s = "ShareFile";
        if (s1.equals(""))
        {
            s = "ShareFileWithMessage";
        }
        form.dispatchErrorOccurredEvent(this, s, 2001, new Object[] {
            s2
        });
    }

    public void ShareMessage(String s)
    {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", s);
        intent.setType("text/plain");
        form.startActivity(intent);
    }
}
