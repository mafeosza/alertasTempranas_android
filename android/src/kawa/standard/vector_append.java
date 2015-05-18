// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongType;

public class vector_append extends ProcedureN
{

    public static final vector_append vectorAppend = new vector_append("vector-append");

    public vector_append(String s)
    {
        super(s);
    }

    public static FVector apply$V(Object aobj[])
    {
        Object aobj1[];
        int i;
        int j1;
        int k1;
        i = 0;
        k1 = aobj.length;
        int j = k1;
        do
        {
            j--;
            if (j < 0)
            {
                break;
            }
            Object obj = aobj[j];
            if (obj instanceof FVector)
            {
                i += ((FVector)obj).size();
            } else
            {
                int i1 = LList.listLength(obj, false);
                if (i1 < 0)
                {
                    throw new WrongType(vectorAppend, j, obj, "list or vector");
                }
                i += i1;
            }
        } while (true);
        aobj1 = new Object[i];
        i = 0;
        j1 = 0;
_L2:
        Object obj1;
        int l;
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        obj1 = aobj[j1];
        if (!(obj1 instanceof FVector))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (FVector)obj1;
        int l1 = ((FVector) (obj1)).size();
        for (int k = 0; k < l1;)
        {
            aobj1[i] = ((FVector) (obj1)).get(k);
            k++;
            i++;
        }

        l = i;
_L4:
        j1++;
        i = l;
        if (true) goto _L2; else goto _L1
_L1:
        l = i;
        if (!(obj1 instanceof Pair)) goto _L4; else goto _L3
_L3:
        l = i;
        if (obj1 == LList.Empty) goto _L4; else goto _L5
_L5:
        obj1 = (Pair)obj1;
        aobj1[i] = ((Pair) (obj1)).getCar();
        obj1 = ((Pair) (obj1)).getCdr();
        i++;
          goto _L3
          goto _L4
        return new FVector(aobj1);
    }

    public Object applyN(Object aobj[])
    {
        return apply$V(aobj);
    }

}
