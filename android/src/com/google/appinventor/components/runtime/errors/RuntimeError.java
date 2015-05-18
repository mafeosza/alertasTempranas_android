// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.errors;


// Referenced classes of package com.google.appinventor.components.runtime.errors:
//            ArrayIndexOutOfBoundsError, IllegalArgumentError, UninitializedInstanceError

public abstract class RuntimeError extends RuntimeException
{

    protected RuntimeError()
    {
    }

    protected RuntimeError(String s)
    {
        super(s);
    }

    public static RuntimeError convertToRuntimeError(Throwable throwable)
    {
        if (throwable instanceof RuntimeError)
        {
            return (RuntimeError)throwable;
        }
        if (throwable instanceof ArrayIndexOutOfBoundsException)
        {
            return new ArrayIndexOutOfBoundsError();
        }
        if (throwable instanceof IllegalArgumentException)
        {
            return new IllegalArgumentError();
        }
        if (throwable instanceof NullPointerException)
        {
            return new UninitializedInstanceError();
        } else
        {
            throw new UnsupportedOperationException(throwable);
        }
    }
}
