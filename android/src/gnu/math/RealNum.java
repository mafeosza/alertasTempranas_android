// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.math.BigDecimal;

// Referenced classes of package gnu.math:
//            Complex, DFloNum, RatNum, IntNum, 
//            DComplex, Numeric

public abstract class RealNum extends Complex
    implements Comparable
{

    public RealNum()
    {
    }

    public static RealNum add(RealNum realnum, RealNum realnum1, int i)
    {
        return (RealNum)(RealNum)realnum.add(realnum1, i);
    }

    public static RealNum asRealNumOrNull(Object obj)
    {
        if (obj instanceof RealNum)
        {
            return (RealNum)obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double))
        {
            return new DFloNum(((Number)obj).doubleValue());
        } else
        {
            return RatNum.asRatNumOrNull(obj);
        }
    }

    public static RealNum divide(RealNum realnum, RealNum realnum1)
    {
        return (RealNum)(RealNum)realnum.div(realnum1);
    }

    public static RealNum times(RealNum realnum, RealNum realnum1)
    {
        return (RealNum)(RealNum)realnum.mul(realnum1);
    }

    public static IntNum toExactInt(double d)
    {
        if (Double.isInfinite(d) || Double.isNaN(d))
        {
            throw new ArithmeticException((new StringBuilder()).append("cannot convert ").append(d).append(" to exact integer").toString());
        }
        long l = Double.doubleToLongBits(d);
        boolean flag;
        int i;
        if (l < 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = (int)(l >> 52) & 0x7ff;
        l &= 0xfffffffffffffL;
        if (i == 0)
        {
            l <<= 1;
        } else
        {
            l |= 0x10000000000000L;
        }
        if (i <= 1075)
        {
            i = 1075 - i;
            if (i > 53)
            {
                return IntNum.zero();
            }
            l >>= i;
            if (flag)
            {
                l = -l;
            }
            return IntNum.make(l);
        }
        if (flag)
        {
            l = -l;
        }
        return IntNum.shift(IntNum.make(l), i - 1075);
    }

    public static IntNum toExactInt(double d, int i)
    {
        return toExactInt(toInt(d, i));
    }

    public static double toInt(double d, int i)
    {
        switch (i)
        {
        default:
            return d;

        case 1: // '\001'
            return Math.floor(d);

        case 2: // '\002'
            return Math.ceil(d);

        case 3: // '\003'
            if (d < 0.0D)
            {
                return Math.ceil(d);
            } else
            {
                return Math.floor(d);
            }

        case 4: // '\004'
            return Math.rint(d);
        }
    }

    public static IntNum toScaledInt(double d, int i)
    {
        return toScaledInt(DFloNum.toExact(d), i);
    }

    public static IntNum toScaledInt(RatNum ratnum, int i)
    {
        Object obj = ratnum;
        if (i != 0)
        {
            obj = IntNum.ten();
            IntNum intnum;
            int j;
            if (i < 0)
            {
                j = -i;
            } else
            {
                j = i;
            }
            intnum = IntNum.power(((IntNum) (obj)), j);
            obj = ratnum.numerator();
            ratnum = ratnum.denominator();
            if (i >= 0)
            {
                obj = IntNum.times(((IntNum) (obj)), intnum);
            } else
            {
                ratnum = IntNum.times(ratnum, intnum);
            }
            obj = RatNum.make(((IntNum) (obj)), ratnum);
        }
        return ((RatNum) (obj)).toExactInt(4);
    }

    public static String toStringDecimal(String s)
    {
        int l = s.indexOf('E');
        if (l >= 0)
        {
            int i1 = s.length();
            char c1 = s.charAt(i1 - 1);
            if (c1 != 'y' && c1 != 'N')
            {
                StringBuffer stringbuffer = new StringBuffer(i1 + 10);
                boolean flag;
                if (s.charAt(0) == '-')
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (s.charAt(l + 1) != '-')
                {
                    throw new Error((new StringBuilder()).append("not implemented: toStringDecimal given non-negative exponent: ").append(s).toString());
                }
                int i = 0;
                for (int k = l + 2; k < i1; k++)
                {
                    i = i * 10 + (s.charAt(k) - 48);
                }

                if (flag)
                {
                    stringbuffer.append('-');
                }
                stringbuffer.append("0.");
                do
                {
                    i--;
                    if (i <= 0)
                    {
                        break;
                    }
                    stringbuffer.append('0');
                } while (true);
                i = 0;
                do
                {
                    int j = i + 1;
                    char c = s.charAt(i);
                    if (c != 'E')
                    {
                        boolean flag1;
                        if (c != '-')
                        {
                            i = 1;
                        } else
                        {
                            i = 0;
                        }
                        if (c != '.')
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        if (flag1 & i && (c != '0' || j < l))
                        {
                            stringbuffer.append(c);
                            i = j;
                        } else
                        {
                            i = j;
                        }
                    } else
                    {
                        return stringbuffer.toString();
                    }
                } while (true);
            }
        }
        return s;
    }

    public static int toStringScientific(String s, StringBuffer stringbuffer)
    {
        int i;
        int j;
        int k;
        int i1;
        if (s.charAt(0) == '-')
        {
            j = 1;
        } else
        {
            j = 0;
        }
        if (j != 0)
        {
            stringbuffer.append('-');
        }
        if (j != 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i1 = s.length();
        if (s.charAt(i) != '0') goto _L2; else goto _L1
_L1:
        k = i;
_L9:
        if (k == i1)
        {
            stringbuffer.append("0");
            i = 0;
            break MISSING_BLOCK_LABEL_67;
        }
        j = k + 1;
        c = s.charAt(k);
        if (c < '0' || c > '9' || c == '0' && j != i1) goto _L4; else goto _L3
_L3:
        stringbuffer.append(c);
        stringbuffer.append('.');
        if (c == '0')
        {
            i = 0;
        } else
        {
            i = (i - j) + 2;
        }
        if (j != i1)
        {
            break MISSING_BLOCK_LABEL_368;
        }
        stringbuffer.append('0');
          goto _L5
_L8:
        j = i;
        l = k;
        if (k >= i1) goto _L7; else goto _L6
_L6:
        stringbuffer.append(s.charAt(k));
        k++;
          goto _L8
_L4:
        k = j;
          goto _L9
_L2:
        if (j != 0)
        {
            j = 2;
        } else
        {
            j = 1;
        }
        k = (i1 - j - i1) + s.indexOf('.');
        j = i + 1;
        stringbuffer.append(s.charAt(i));
        stringbuffer.append('.');
        i = j;
        do
        {
            j = k;
            l = i;
            if (i >= i1)
            {
                break;
            }
            char c1 = s.charAt(i);
            if (c1 != '.')
            {
                stringbuffer.append(c1);
            }
            i++;
        } while (true);
          goto _L7
_L5:
        k = stringbuffer.length();
        j = -1;
        char c;
        int l;
        do
        {
            k--;
            l = stringbuffer.charAt(k);
            if (l != 48)
            {
                break;
            }
            j = k;
        } while (true);
        if (l == 46)
        {
            j = k + 2;
        }
        if (j >= 0)
        {
            stringbuffer.setLength(j);
        }
        return i;
_L7:
        i = j;
          goto _L5
        k = j;
          goto _L8
    }

    public static String toStringScientific(double d)
    {
        return toStringScientific(Double.toString(d));
    }

    public static String toStringScientific(float f)
    {
        return toStringScientific(Float.toString(f));
    }

    public static String toStringScientific(String s)
    {
        if (s.indexOf('E') < 0)
        {
            int i = s.length();
            char c = s.charAt(i - 1);
            if (c != 'y' && c != 'N')
            {
                StringBuffer stringbuffer = new StringBuffer(i + 10);
                i = toStringScientific(s, stringbuffer);
                stringbuffer.append('E');
                stringbuffer.append(i);
                return stringbuffer.toString();
            }
        }
        return s;
    }

    public Numeric abs()
    {
        Object obj = this;
        if (isNegative())
        {
            obj = neg();
        }
        return ((Numeric) (obj));
    }

    public abstract Numeric add(Object obj, int i);

    public BigDecimal asBigDecimal()
    {
        return new BigDecimal(doubleValue());
    }

    public int compareTo(Object obj)
    {
        return compare(obj);
    }

    public abstract Numeric div(Object obj);

    public Complex exp()
    {
        return new DFloNum(Math.exp(doubleValue()));
    }

    public final RealNum im()
    {
        return IntNum.zero();
    }

    public abstract boolean isNegative();

    public boolean isZero()
    {
        return sign() == 0;
    }

    public Complex log()
    {
        double d = doubleValue();
        if (d < 0.0D)
        {
            return DComplex.log(d, 0.0D);
        } else
        {
            return new DFloNum(Math.log(d));
        }
    }

    public RealNum max(RealNum realnum)
    {
        Object obj;
        boolean flag;
        if (isExact() && realnum.isExact())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (grt(realnum))
        {
            realnum = this;
        }
        obj = realnum;
        if (!flag)
        {
            obj = realnum;
            if (realnum.isExact())
            {
                obj = new DFloNum(realnum.doubleValue());
            }
        }
        return ((RealNum) (obj));
    }

    public RealNum min(RealNum realnum)
    {
        Object obj;
        boolean flag;
        if (isExact() && realnum.isExact())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!grt(realnum))
        {
            realnum = this;
        }
        obj = realnum;
        if (!flag)
        {
            obj = realnum;
            if (realnum.isExact())
            {
                obj = new DFloNum(realnum.doubleValue());
            }
        }
        return ((RealNum) (obj));
    }

    public abstract Numeric mul(Object obj);

    public final RealNum re()
    {
        return this;
    }

    public RealNum rneg()
    {
        return (RealNum)neg();
    }

    public abstract int sign();

    public final Complex sin()
    {
        return new DFloNum(Math.sin(doubleValue()));
    }

    public final Complex sqrt()
    {
        double d = doubleValue();
        if (d >= 0.0D)
        {
            return new DFloNum(Math.sqrt(d));
        } else
        {
            return DComplex.sqrt(d, 0.0D);
        }
    }

    public volatile Complex toExact()
    {
        return toExact();
    }

    public volatile Numeric toExact()
    {
        return toExact();
    }

    public RatNum toExact()
    {
        return DFloNum.toExact(doubleValue());
    }

    public IntNum toExactInt(int i)
    {
        return toExactInt(doubleValue(), i);
    }

    public volatile Complex toInexact()
    {
        return toInexact();
    }

    public volatile Numeric toInexact()
    {
        return toInexact();
    }

    public RealNum toInexact()
    {
        Object obj = this;
        if (isExact())
        {
            obj = new DFloNum(doubleValue());
        }
        return ((RealNum) (obj));
    }

    public RealNum toInt(int i)
    {
        return new DFloNum(toInt(doubleValue(), i));
    }

    public IntNum toScaledInt(int i)
    {
        return toScaledInt(toExact(), i);
    }
}
