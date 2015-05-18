// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


public class WrappedException extends RuntimeException
{

    public WrappedException()
    {
    }

    public WrappedException(String s)
    {
        super(s);
    }

    public WrappedException(String s, Throwable throwable)
    {
        super(s, throwable);
    }

    public WrappedException(Throwable throwable)
    {
        this(throwable.toString(), throwable);
    }

    public static RuntimeException wrapIfNeeded(Throwable throwable)
    {
        if (throwable instanceof RuntimeException)
        {
            return (RuntimeException)throwable;
        } else
        {
            return new WrappedException(throwable);
        }
    }

    public Throwable getException()
    {
        return getCause();
    }

    public String toString()
    {
        return getMessage();
    }
}
