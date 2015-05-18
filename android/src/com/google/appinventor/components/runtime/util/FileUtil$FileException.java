// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.errors.RuntimeError;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            FileUtil

public static class msgNumber extends RuntimeError
{

    private final int msgNumber;

    public int getErrorMessageNumber()
    {
        return msgNumber;
    }

    public (int i)
    {
        msgNumber = i;
    }
}
