// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.mapping.ProcedureN;
import gnu.mapping.Symbol;
import kawa.lang.GenericError;
import kawa.lang.NamedException;

// Referenced classes of package kawa.standard:
//            prim_throw

public class throw_name extends ProcedureN
{

    public static final throw_name throwName = new throw_name();

    public throw_name()
    {
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        if (aobj.length > 0)
        {
            Object obj = aobj[0];
            if (obj instanceof Throwable)
            {
                if (aobj.length == 1)
                {
                    prim_throw.throw_it(obj);
                }
            } else
            if (obj instanceof Symbol)
            {
                throw new NamedException((Symbol)obj, aobj);
            }
        }
        throw new GenericError("bad arguments to throw");
    }

}
