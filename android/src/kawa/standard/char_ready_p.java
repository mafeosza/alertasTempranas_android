// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class char_ready_p
{

    public char_ready_p()
    {
    }

    public static boolean ready(Object obj)
    {
        if (obj instanceof InputStream)
        {
            if (((InputStream)obj).available() > 0)
            {
                return true;
            }
        } else
        {
            try
            {
                if (obj instanceof Reader)
                {
                    return ((Reader)obj).ready();
                } else
                {
                    throw new ClassCastException("invalid argument to char-ready?");
                }
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        return false;
    }
}
