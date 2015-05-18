// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class append extends ProcedureN
{

    public static final append append;

    public append()
    {
    }

    public static Object append$V(Object aobj[])
    {
        int i = aobj.length;
        if (i != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = LList.Empty;
_L4:
        return obj1;
_L2:
        Object obj = aobj[i - 1];
        i--;
        do
        {
            i--;
            obj1 = obj;
            if (i < 0)
            {
                continue;
            }
            Object obj3 = aobj[i];
            Object obj2 = null;
            obj1 = null;
            while (obj3 instanceof Pair) 
            {
                Pair pair = (Pair)obj3;
                obj3 = new Pair(pair.getCar(), null);
                if (obj2 == null)
                {
                    obj1 = obj3;
                } else
                {
                    ((Pair) (obj2)).setCdr(obj3);
                }
                obj2 = obj3;
                obj3 = pair.getCdr();
            }
            if (obj3 != LList.Empty)
            {
                throw new WrongType(append, i + 1, aobj[i], "list");
            }
            if (obj2 != null)
            {
                ((Pair) (obj2)).setCdr(obj);
            } else
            {
                obj1 = obj;
            }
            obj = obj1;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object applyN(Object aobj[])
    {
        return append$V(aobj);
    }

    static 
    {
        append = new append();
        append.setName("append");
    }
}
