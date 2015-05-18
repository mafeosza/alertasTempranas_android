// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

public class NamedException extends RuntimeException
{

    Object args[];
    Symbol name;

    public NamedException(Symbol symbol, Object aobj[])
    {
        name = symbol;
        args = aobj;
    }

    public Object applyHandler(Object obj, Procedure procedure)
        throws Throwable
    {
        checkMatch(obj);
        return procedure.applyN(args);
    }

    public void checkMatch(Object obj)
    {
        if (obj != name && obj != Boolean.TRUE)
        {
            throw this;
        } else
        {
            return;
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("#<ERROR");
        boolean flag = false;
        int j = args.length;
        int i = ((flag) ? 1 : 0);
        if (j > 1)
        {
            i = ((flag) ? 1 : 0);
            if (args[0] == "misc-error")
            {
                i = 0 + 1;
            }
        }
        for (; i < j; i++)
        {
            stringbuffer.append(' ');
            stringbuffer.append(args[i]);
        }

        stringbuffer.append(">");
        return stringbuffer.toString();
    }
}
