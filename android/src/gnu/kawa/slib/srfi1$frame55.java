// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import kawa.lang.Continuation;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class  extends ModuleBody
{

    Continuation abort;

    public Object lambda74recur(Object obj)
    {
        if (lists.isPair(obj))
        {
            Object obj1 = lists.car.apply1(obj);
            if (srfi1.isNullList(obj1) != Boolean.FALSE)
            {
                return abort.apply1(LList.Empty);
            } else
            {
                return lists.cons(lists.cdr.apply1(obj1), lambda74recur(lists.cdr.apply1(obj)));
            }
        } else
        {
            return LList.Empty;
        }
    }

    public ()
    {
    }
}
