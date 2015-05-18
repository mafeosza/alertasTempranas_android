// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.lists.LList;
import gnu.mapping.Procedure;
import kawa.lib.lists;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi1

public class  extends ModuleBody
{

    Procedure f;
    Object zero;

    public Object lambda19recur(Object obj)
    {
        Object obj1 = srfi1.$PcCdrs(obj);
        if (lists.isNull(obj1))
        {
            return zero;
        } else
        {
            return Scheme.apply.apply2(f, srfi1.append$Ex$V(new Object[] {
                obj, LList.list1(lambda19recur(obj1))
            }));
        }
    }

    public Object lambda20recur(Object obj)
    {
        if (srfi1.isNullList(obj) != Boolean.FALSE)
        {
            return zero;
        } else
        {
            return f.apply2(obj, lambda20recur(lists.cdr.apply1(obj)));
        }
    }

    public ()
    {
    }
}
