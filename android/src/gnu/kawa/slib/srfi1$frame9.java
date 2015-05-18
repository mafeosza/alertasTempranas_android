// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.mapping.Procedure;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class  extends ModuleBody
{

    Object knil;
    Procedure kons;

    public Object lambda17recur(Object obj)
    {
        Object obj1 = srfi1.$PcCdrs(obj);
        if (lists.isNull(obj1))
        {
            return knil;
        } else
        {
            return Scheme.apply.apply2(kons, srfi1.$PcCars$Pl(obj, lambda17recur(obj1)));
        }
    }

    public Object lambda18recur(Object obj)
    {
        if (srfi1.isNullList(obj) != Boolean.FALSE)
        {
            return knil;
        } else
        {
            Object obj1 = lists.car.apply1(obj);
            return kons.apply2(obj1, lambda18recur(lists.cdr.apply1(obj)));
        }
    }

    public ()
    {
    }
}
