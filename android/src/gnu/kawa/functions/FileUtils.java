// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import java.io.File;
import java.io.IOException;

public class FileUtils
{

    public FileUtils()
    {
    }

    public static File createTempFile(String s)
        throws IOException
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "kawa~d.tmp";
        }
        int i = s1.indexOf('~');
        File file = null;
        String s2;
        if (i < 0)
        {
            s = s1;
            s1 = ".tmp";
        } else
        {
            s = s1.substring(0, i);
            s1 = s1.substring(i + 2);
        }
        i = s.indexOf(File.separatorChar);
        s2 = s;
        if (i >= 0)
        {
            file = new File(s.substring(0, i));
            s2 = s.substring(i + 1);
        }
        return File.createTempFile(s2, s1, file);
    }
}
