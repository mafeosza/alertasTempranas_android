// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.mapping.Procedure;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            testing

public class  extends ModuleBody
{

    Object p;

    public Object lambda4loop(Object obj)
    {
        if (obj == p)
        {
            return lists.cdr.apply1(obj);
        } else
        {
            return lists.cons(lists.car.apply1(obj), lambda4loop(lists.cdr.apply1(obj)));
        }
    }

    public ()
    {
    }
}
