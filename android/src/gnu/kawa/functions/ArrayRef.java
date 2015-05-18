// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.Sequence;
import gnu.mapping.ProcedureN;

public class ArrayRef extends ProcedureN
{

    public static final ArrayRef arrayRef = new ArrayRef();

    public ArrayRef()
    {
    }

    public static Object arrayRef(Array array, Sequence sequence)
    {
        int j = sequence.size();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = ((Number)sequence.get(i)).intValue();
        }

        return array.get(ai);
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        if (obj1 instanceof Sequence)
        {
            return arrayRef((Array)obj, (Sequence)obj1);
        } else
        {
            return super.apply2(obj, obj1);
        }
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        Array array = (Array)aobj[0];
        if (aobj.length == 2)
        {
            Object obj = aobj[1];
            if (obj instanceof Sequence)
            {
                return arrayRef(array, (Sequence)obj);
            }
        }
        int ai[] = new int[aobj.length - 1];
        int i = aobj.length - 1;
        do
        {
            i--;
            if (i >= 0)
            {
                ai[i] = ((Number)aobj[i + 1]).intValue();
            } else
            {
                return array.get(ai);
            }
        } while (true);
    }

}
