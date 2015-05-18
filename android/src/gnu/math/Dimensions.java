// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;


// Referenced classes of package gnu.math:
//            BaseUnit, Unit

public class Dimensions
{

    public static Dimensions Empty = new Dimensions();
    private static Dimensions hashTable[] = new Dimensions[100];
    BaseUnit bases[];
    private Dimensions chain;
    int hash_code;
    short powers[];

    private Dimensions()
    {
        bases = new BaseUnit[1];
        bases[0] = Unit.Empty;
        enterHash(0);
    }

    Dimensions(BaseUnit baseunit)
    {
        bases = new BaseUnit[2];
        powers = new short[1];
        bases[0] = baseunit;
        bases[1] = Unit.Empty;
        powers[0] = 1;
        enterHash(baseunit.index);
    }

    private Dimensions(Dimensions dimensions, int i, Dimensions dimensions1, int j, int k)
    {
        int l;
        int i1;
        int k1;
        hash_code = k;
        for (l = 0; dimensions.bases[l] != Unit.Empty; l++) { }
        for (i1 = 0; dimensions1.bases[i1] != Unit.Empty; i1++) { }
        l = l + i1 + 1;
        bases = new BaseUnit[l];
        powers = new short[l];
        k1 = 0;
        l = 0;
        i1 = 0;
_L7:
        BaseUnit baseunit;
        BaseUnit baseunit1;
        baseunit = dimensions.bases[i1];
        baseunit1 = dimensions1.bases[l];
        if (baseunit.index >= baseunit1.index) goto _L2; else goto _L1
_L1:
        int j1;
        j1 = dimensions.powers[i1] * i;
        i1++;
_L4:
        if ((short)j1 != j1)
        {
            throw new ArithmeticException("overflow in dimensions");
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (baseunit1.index >= baseunit.index)
        {
            break; /* Loop/switch isn't completed */
        }
        baseunit = baseunit1;
        j1 = dimensions1.powers[l] * j;
        l++;
        if (true) goto _L4; else goto _L3
_L3:
        if (baseunit1 == Unit.Empty)
        {
            bases[k1] = Unit.Empty;
            enterHash(k);
            return;
        }
        int j2 = dimensions.powers[i1] * i + dimensions1.powers[l] * j;
        int l1 = i1 + 1;
        int i2 = l + 1;
        i1 = l1;
        l = i2;
        j1 = j2;
        if (j2 == 0)
        {
            i1 = l1;
            l = i2;
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L5
_L5:
        bases[k1] = baseunit;
        powers[k1] = (short)j1;
        k1++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private void enterHash(int i)
    {
        hash_code = i;
        i = (0x7fffffff & i) % hashTable.length;
        chain = hashTable[i];
        hashTable[i] = this;
    }

    private boolean matchesProduct(Dimensions dimensions, int i, Dimensions dimensions1, int j)
    {
        int k;
        int l;
        int j1;
        l = 0;
        k = 0;
        j1 = 0;
_L8:
        BaseUnit baseunit;
        BaseUnit baseunit1;
        baseunit = dimensions.bases[l];
        baseunit1 = dimensions1.bases[k];
        if (baseunit.index >= baseunit1.index) goto _L2; else goto _L1
_L1:
        int i1;
        i1 = dimensions.powers[l] * i;
        l++;
_L6:
        if (bases[j1] == baseunit && powers[j1] == i1)
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        return false;
_L2:
        if (baseunit1.index < baseunit.index)
        {
            baseunit = baseunit1;
            i1 = dimensions1.powers[k] * j;
            k++;
            continue; /* Loop/switch isn't completed */
        }
        if (baseunit1 != Unit.Empty)
        {
            break; /* Loop/switch isn't completed */
        }
        if (bases[j1] == baseunit1)
        {
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        int i2 = dimensions.powers[l] * i + dimensions1.powers[k] * j;
        int k1 = l + 1;
        int l1 = k + 1;
        l = k1;
        k = l1;
        i1 = i2;
        if (i2 == 0)
        {
            l = k1;
            k = l1;
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L6; else goto _L5
_L5:
        j1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Dimensions product(Dimensions dimensions, int i, Dimensions dimensions1, int j)
    {
        int k = dimensions.hashCode() * i + dimensions1.hashCode() * j;
        int l = hashTable.length;
        for (Dimensions dimensions2 = hashTable[(0x7fffffff & k) % l]; dimensions2 != null; dimensions2 = dimensions2.chain)
        {
            if (dimensions2.hash_code == k && dimensions2.matchesProduct(dimensions, i, dimensions1, j))
            {
                return dimensions2;
            }
        }

        return new Dimensions(dimensions, i, dimensions1, j, k);
    }

    public int getPower(BaseUnit baseunit)
    {
        for (int i = 0; bases[i].index <= baseunit.index; i++)
        {
            if (bases[i] == baseunit)
            {
                return powers[i];
            }
        }

        return 0;
    }

    public final int hashCode()
    {
        return hash_code;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; bases[i] != Unit.Empty; i++)
        {
            if (i > 0)
            {
                stringbuffer.append('*');
            }
            stringbuffer.append(bases[i]);
            short word0 = powers[i];
            if (word0 != 1)
            {
                stringbuffer.append('^');
                stringbuffer.append(word0);
            }
        }

        return stringbuffer.toString();
    }

}
