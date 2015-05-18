// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.errors;


// Referenced classes of package com.google.appinventor.components.runtime.errors:
//            RuntimeError

public class YailRuntimeError extends RuntimeError
{

    private String errorType;

    public YailRuntimeError(String s, String s1)
    {
        super(s);
        errorType = s1;
    }

    public String getErrorType()
    {
        return errorType;
    }
}
