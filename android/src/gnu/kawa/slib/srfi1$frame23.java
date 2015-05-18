// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class  extends ModuleBody
{

    Procedure pred;

    public Object lambda34recur(Object obj)
    {
        if (srfi1.isNullList(obj) != Boolean.FALSE)
        {
            return LList.Empty;
        }
        Object obj1 = lists.car.apply1(obj);
        if (pred.apply1(obj1) != Boolean.FALSE)
        {
            return lists.cons(obj1, lambda34recur(lists.cdr.apply1(obj)));
        } else
        {
            return LList.Empty;
        }
    }

    public ()
    {
    }
}
