// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.mapping.Procedure;
import kawa.standard.Scheme;

// Referenced classes of package kawa.lib:
//            srfi95, lists

public class  extends ModuleBody
{

    Object key;
    Object less$Qu;

    public Object lambda1loop(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        if (Scheme.applyToArgs.apply3(less$Qu, obj4, obj1) != Boolean.FALSE)
        {
            if (lists.isNull(obj5))
            {
                return lists.cons(obj3, lists.cons(obj, obj2));
            } else
            {
                return lists.cons(obj3, lambda1loop(obj, obj1, obj2, lists.car.apply1(obj5), Scheme.applyToArgs.apply2(key, lists.car.apply1(obj5)), lists.cdr.apply1(obj5)));
            }
        }
        if (lists.isNull(obj2))
        {
            return lists.cons(obj, lists.cons(obj3, obj5));
        } else
        {
            return lists.cons(obj, lambda1loop(lists.car.apply1(obj2), Scheme.applyToArgs.apply2(key, lists.car.apply1(obj2)), lists.cdr.apply1(obj2), obj3, obj4, obj5));
        }
    }

    public ()
    {
    }
}
