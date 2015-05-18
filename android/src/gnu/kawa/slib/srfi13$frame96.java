// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import kawa.lib.lists;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    Object _fldfinal;

    public Object lambda223recur(Object obj)
    {
        if (lists.isPair(obj))
        {
            Object obj1 = srfi13.loc$delim;
            try
            {
                obj1 = ((Location) (obj1)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1857, 13);
                throw obj;
            }
            return lists.cons(obj1, lists.cons(lists.car.apply1(obj), lambda223recur(lists.cdr.apply1(obj))));
        } else
        {
            return _fldfinal;
        }
    }

    public ception()
    {
    }
}
