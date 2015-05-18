// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.mapping.Procedure;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class  extends ModuleBody
{

    Procedure maybe$Mn$Eq;

    public Object lambda31recur(Object obj)
    {
        if (srfi1.isNullList(obj) == Boolean.FALSE)
        {
            Object obj1 = lists.car.apply1(obj);
            Object obj2 = lists.cdr.apply1(obj);
            Object obj3 = lambda31recur(srfi1.delete$Ex(obj1, obj2, maybe$Mn$Eq));
            if (obj2 != obj3)
            {
                return lists.cons(obj1, obj3);
            }
        }
        return obj;
    }

    public ()
    {
    }
}
