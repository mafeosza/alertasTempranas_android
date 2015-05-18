// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package gnu.math:
//            IntNum, RatNum, DFloNum

public abstract class Numeric extends Number
{

    public static final int CEILING = 2;
    public static final int FLOOR = 1;
    public static final int NONNEG_MOD = 5;
    public static final int ROUND = 4;
    public static final int TRUNCATE = 3;

    public Numeric()
    {
    }

    public static Numeric asNumericOrNull(Object obj)
    {
        if (obj instanceof Numeric)
        {
            return (Numeric)obj;
        }
        if ((obj instanceof BigInteger) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Byte) || (obj instanceof Integer))
        {
            return IntNum.asIntNumOrNull(obj);
        }
        if (obj instanceof BigDecimal)
        {
            return RatNum.asRatNumOrNull(obj);
        }
        if ((obj instanceof Float) || (obj instanceof Double))
        {
            return new DFloNum(((Number)obj).doubleValue());
        } else
        {
            return null;
        }
    }

    public abstract Numeric abs();

    public final Numeric add(Object obj)
    {
        return add(obj, 1);
    }

    public abstract Numeric add(Object obj, int i);

    public Numeric addReversed(Numeric numeric, int i)
    {
        throw new IllegalArgumentException();
    }

    public int compare(Object obj)
    {
        return -3;
    }

    public int compareReversed(Numeric numeric)
    {
        throw new IllegalArgumentException();
    }

    public abstract Numeric div(Object obj);

    public Numeric divReversed(Numeric numeric)
    {
        throw new IllegalArgumentException();
    }

    public Numeric div_inv()
    {
        return IntNum.one().div(this);
    }

    public boolean equals(Object obj)
    {
        while (obj == null || !(obj instanceof Numeric) || compare(obj) != 0) 
        {
            return false;
        }
        return true;
    }

    public float floatValue()
    {
        return (float)doubleValue();
    }

    public boolean geq(Object obj)
    {
        return compare(obj) >= 0;
    }

    public boolean grt(Object obj)
    {
        return compare(obj) > 0;
    }

    public int intValue()
    {
        return (int)longValue();
    }

    public abstract boolean isExact();

    public abstract boolean isZero();

    public long longValue()
    {
        return (long)doubleValue();
    }

    public abstract Numeric mul(Object obj);

    public Numeric mulReversed(Numeric numeric)
    {
        throw new IllegalArgumentException();
    }

    public Numeric mul_ident()
    {
        return IntNum.one();
    }

    public abstract Numeric neg();

    public Numeric power(IntNum intnum)
    {
        if (!intnum.isNegative()) goto _L2; else goto _L1
_L1:
        Object obj = power(IntNum.neg(intnum)).div_inv();
_L4:
        return ((Numeric) (obj));
_L2:
        obj = this;
        IntNum intnum2 = null;
        IntNum intnum1 = intnum;
        do
        {
label0:
            {
                intnum = intnum2;
                if (intnum1.isOdd())
                {
                    if (intnum2 == null)
                    {
                        intnum = ((IntNum) (obj));
                    } else
                    {
                        intnum = intnum2.mul(obj);
                    }
                }
                intnum1 = IntNum.shift(intnum1, -1);
                if (!intnum1.isZero())
                {
                    break label0;
                }
                obj = intnum;
                if (intnum == null)
                {
                    return mul_ident();
                }
            }
            if (true)
            {
                continue;
            }
            obj = ((Numeric) (obj)).mul(obj);
            intnum2 = intnum;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Numeric sub(Object obj)
    {
        return add(obj, -1);
    }

    public Numeric toExact()
    {
        return this;
    }

    public Numeric toInexact()
    {
        return this;
    }

    public String toString()
    {
        return toString(10);
    }

    public abstract String toString(int i);
}
