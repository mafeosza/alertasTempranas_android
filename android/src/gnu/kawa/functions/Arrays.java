// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.lists.GeneralArray;
import gnu.lists.SimpleVector;
import gnu.mapping.Procedure;
import gnu.mapping.Values;
import gnu.math.IntNum;

public class Arrays
{

    static final int shapeStrides[] = {
        2, 1
    };
    static final int zeros2[] = new int[2];

    public Arrays()
    {
    }

    public static int effectiveIndex(Array array, Procedure procedure, Object aobj[], int ai[])
        throws Throwable
    {
        procedure = ((Procedure) (procedure.applyN(aobj)));
        if (procedure instanceof Values)
        {
            procedure = (Values)procedure;
            int j = 0;
            int i = 0;
            do
            {
                j = procedure.nextPos(j);
                if (j == 0)
                {
                    break;
                }
                ai[i] = ((Number)procedure.getPosPrevious(j)).intValue();
                i++;
            } while (true);
        } else
        {
            ai[0] = ((Number)procedure).intValue();
        }
        return array.getEffectiveIndex(ai);
    }

    public static Array make(Array array, Object obj)
    {
        int k = array.getSize(0);
        int ai2[] = new int[k];
        int ai[] = null;
        int i = 1;
        int j = k;
        do
        {
            j--;
            if (j >= 0)
            {
                int l = ((Number)array.getRowMajor(j * 2)).intValue();
                int i1 = ((Number)array.getRowMajor(j * 2 + 1)).intValue() - l;
                ai2[j] = i1;
                int ai1[] = ai;
                if (l != 0)
                {
                    ai1 = ai;
                    if (ai == null)
                    {
                        ai1 = new int[k];
                    }
                    ai1[j] = l;
                }
                i *= i1;
                ai = ai1;
            } else
            {
                return GeneralArray.makeSimple(ai, ai2, new FVector(i, obj));
            }
        } while (true);
    }

    public static Array makeSimple(Array array, SimpleVector simplevector)
    {
        int j = array.getSize(0);
        int ai2[] = new int[j];
        int ai[] = null;
        int i = j;
        do
        {
            int k = i - 1;
            if (k < 0)
            {
                break;
            }
            int l = ((Number)array.getRowMajor(k * 2)).intValue();
            ai2[k] = ((Number)array.getRowMajor(k * 2 + 1)).intValue() - l;
            i = k;
            if (l != 0)
            {
                int ai1[] = ai;
                if (ai == null)
                {
                    ai1 = new int[j];
                }
                ai1[k] = l;
                i = k;
                ai = ai1;
            }
        } while (true);
        return GeneralArray.makeSimple(ai, ai2, simplevector);
    }

    public static Array shape(Object aobj[])
    {
        int i = aobj.length;
        if ((i & 1) != 0)
        {
            throw new RuntimeException("shape: not an even number of arguments");
        } else
        {
            aobj = new FVector(aobj);
            int ai[] = zeros2;
            int ai1[] = shapeStrides;
            return ((FVector) (aobj)).transpose(ai, new int[] {
                i >> 1, 2
            }, 0, ai1);
        }
    }

    public static Array shareArray(Array array, Array array1, Procedure procedure)
        throws Throwable
    {
        Object aobj[];
        int ai[];
        int ai1[];
        int i;
        boolean flag;
        int k;
        i = array1.getSize(0);
        aobj = new Object[i];
        ai = new int[i];
        ai1 = new int[i];
        flag = false;
        k = i;
        do
        {
            int i1 = k - 1;
            if (i1 < 0)
            {
                break;
            }
            Object obj = array1.getRowMajor(i1 * 2);
            aobj[i1] = obj;
            k = ((Number)obj).intValue();
            ai1[i1] = k;
            int k1 = ((Number)array1.getRowMajor(i1 * 2 + 1)).intValue() - k;
            ai[i1] = k1;
            k = i1;
            if (k1 <= 0)
            {
                flag = true;
                k = i1;
            }
        } while (true);
        k = array.rank();
        array1 = new int[i];
        if (!flag) goto _L2; else goto _L1
_L1:
        i = 0;
_L4:
        return array.transpose(ai1, ai, i, array1);
_L2:
        int ai2[] = new int[k];
        int j = effectiveIndex(array, procedure, aobj, ai2);
        do
        {
            int l = i - 1;
            i = j;
            if (l < 0)
            {
                continue;
            }
            i = ai[l];
            int j1 = ai1[l];
            if (i <= 1)
            {
                array1[l] = 0;
                i = l;
            } else
            {
                Object obj1 = aobj[l];
                aobj[l] = IntNum.make(j1 + 1);
                array1[l] = effectiveIndex(array, procedure, aobj, ai2) - j;
                aobj[l] = obj1;
                i = l;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
