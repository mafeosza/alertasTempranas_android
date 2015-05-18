// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.Sequence;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;

public class ArraySet extends ProcedureN
{

    public static final ArraySet arraySet = new ArraySet();

    public ArraySet()
    {
    }

    public static void arraySet(Array array, Sequence sequence, Object obj)
    {
        int j = sequence.size();
        int ai[] = new int[j];
        for (int i = 0; i < j; i++)
        {
            ai[i] = ((Number)sequence.get(i)).intValue();
        }

        array.set(ai, obj);
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
        throws Throwable
    {
        if (obj1 instanceof Sequence)
        {
            arraySet((Array)obj, (Sequence)obj1, obj2);
            return Values.empty;
        } else
        {
            return super.apply3(obj, obj1, obj2);
        }
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        Array array = (Array)aobj[0];
        if (aobj.length == 3)
        {
            Object obj = aobj[1];
            if (obj instanceof Sequence)
            {
                arraySet(array, (Sequence)obj, aobj[2]);
                return Values.empty;
            }
        }
        int j = aobj.length - 2;
        int ai[] = new int[j];
        int i = j;
        do
        {
            i--;
            if (i >= 0)
            {
                ai[i] = ((Number)aobj[i + 1]).intValue();
            } else
            {
                array.set(ai, aobj[j + 1]);
                return Values.empty;
            }
        } while (true);
    }

}
