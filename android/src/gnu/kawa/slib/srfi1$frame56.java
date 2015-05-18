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

    Object last$Mnelt;

    public Object lambda75recur(Object obj)
    {
        if (lists.isPair(obj))
        {
            return lists.cons(lists.caar.apply1(obj), lambda75recur(lists.cdr.apply1(obj)));
        } else
        {
            return LList.list1(last$Mnelt);
        }
    }

    public ()
    {
    }
}
