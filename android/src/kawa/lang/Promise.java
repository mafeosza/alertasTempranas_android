// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.lists.Consumer;
import gnu.mapping.Future;
import gnu.mapping.Procedure;
import gnu.text.Printable;

public class Promise
    implements Printable
{

    Object result;
    Procedure thunk;

    public Promise(Procedure procedure)
    {
        thunk = procedure;
    }

    public static Object force(Object obj)
        throws Throwable
    {
        Object obj1;
        if (obj instanceof Promise)
        {
            obj1 = ((Promise)obj).force();
        } else
        {
            if (obj instanceof Future)
            {
                return ((Future)obj).waitForResult();
            }
            obj1 = obj;
            if (obj instanceof java.util.concurrent.Future)
            {
                return ((java.util.concurrent.Future)obj).get();
            }
        }
        return obj1;
    }

    public Object force()
        throws Throwable
    {
        if (result == null)
        {
            Object obj = thunk.apply0();
            if (result == null)
            {
                result = obj;
            }
        }
        return result;
    }

    public void print(Consumer consumer)
    {
        if (result == null)
        {
            consumer.write("#<promise - not forced yet>");
            return;
        } else
        {
            consumer.write("#<promise - forced to a ");
            consumer.write(result.getClass().getName());
            consumer.write(62);
            return;
        }
    }
}
