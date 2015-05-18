// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.math:
//            RatNum, IntNum, Numeric, RealNum

public class IntFraction extends RatNum
    implements Externalizable
{

    IntNum den;
    IntNum num;

    IntFraction()
    {
    }

    public IntFraction(IntNum intnum, IntNum intnum1)
    {
        num = intnum;
        den = intnum1;
    }

    public static IntFraction neg(IntFraction intfraction)
    {
        return new IntFraction(IntNum.neg(intfraction.numerator()), intfraction.denominator());
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof RatNum)
        {
            return RatNum.add(this, (RatNum)obj, i);
        }
        if (!(obj instanceof Numeric))
        {
            throw new IllegalArgumentException();
        } else
        {
            return ((Numeric)obj).addReversed(this, i);
        }
    }

    public Numeric addReversed(Numeric numeric, int i)
    {
        if (!(numeric instanceof RatNum))
        {
            throw new IllegalArgumentException();
        } else
        {
            return RatNum.add((RatNum)numeric, this, i);
        }
    }

    public final int compare(Object obj)
    {
        if (obj instanceof RatNum)
        {
            return RatNum.compare(this, (RatNum)obj);
        } else
        {
            return ((RealNum)obj).compareReversed(this);
        }
    }

    public int compareReversed(Numeric numeric)
    {
        return RatNum.compare((RatNum)numeric, this);
    }

    public final IntNum denominator()
    {
        return den;
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof RatNum)
        {
            return RatNum.divide(this, (RatNum)obj);
        }
        if (!(obj instanceof Numeric))
        {
            throw new IllegalArgumentException();
        } else
        {
            return ((Numeric)obj).divReversed(this);
        }
    }

    public Numeric divReversed(Numeric numeric)
    {
        if (!(numeric instanceof RatNum))
        {
            throw new IllegalArgumentException();
        } else
        {
            return RatNum.divide((RatNum)numeric, this);
        }
    }

    public double doubleValue()
    {
        boolean flag1 = num.isNegative();
        if (den.isZero())
        {
            if (flag1)
            {
                return (-1.0D / 0.0D);
            }
            return !num.isZero() ? (1.0D / 0.0D) : (0.0D / 0.0D);
        }
        IntNum intnum1 = num;
        IntNum intnum = intnum1;
        if (flag1)
        {
            intnum = IntNum.neg(intnum1);
        }
        int j = intnum.intLength();
        int k = den.intLength();
        int i = 0;
        intnum1 = intnum;
        if (j < k + 54)
        {
            i = (k + 54) - j;
            intnum1 = IntNum.shift(intnum, i);
            i = -i;
        }
        IntNum intnum2 = new IntNum();
        intnum = new IntNum();
        IntNum.divide(intnum1, den, intnum2, intnum, 3);
        intnum1 = intnum2.canonicalize();
        boolean flag;
        if (!intnum.canonicalize().isZero())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return intnum1.roundToDouble(i, flag1, flag);
    }

    public final boolean isNegative()
    {
        return num.isNegative();
    }

    public long longValue()
    {
        return toExactInt(4).longValue();
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof RatNum)
        {
            return RatNum.times(this, (RatNum)obj);
        }
        if (!(obj instanceof Numeric))
        {
            throw new IllegalArgumentException();
        } else
        {
            return ((Numeric)obj).mulReversed(this);
        }
    }

    public Numeric mulReversed(Numeric numeric)
    {
        if (!(numeric instanceof RatNum))
        {
            throw new IllegalArgumentException();
        } else
        {
            return RatNum.times((RatNum)numeric, this);
        }
    }

    public Numeric neg()
    {
        return neg(this);
    }

    public final IntNum numerator()
    {
        return num;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        num = (IntNum)objectinput.readObject();
        den = (IntNum)objectinput.readObject();
    }

    public final int sign()
    {
        return num.sign();
    }

    public String toString(int i)
    {
        return (new StringBuilder()).append(num.toString(i)).append('/').append(den.toString(i)).toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(num);
        objectoutput.writeObject(den);
    }
}
