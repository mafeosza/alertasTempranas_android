// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;


// Referenced classes of package gnu.math:
//            Quantity, RealNum, DComplex, CComplex, 
//            IntNum, DFloNum, Numeric

public abstract class Complex extends Quantity
{

    private static CComplex imMinusOne;
    private static CComplex imOne;

    public Complex()
    {
    }

    public static Complex add(Complex complex, Complex complex1, int i)
    {
        return make(RealNum.add(complex.re(), complex1.re(), i), RealNum.add(complex.im(), complex1.im(), i));
    }

    public static int compare(Complex complex, Complex complex1)
    {
        int i = complex.im().compare(complex1.im());
        if (i != 0)
        {
            return i;
        } else
        {
            return complex.re().compare(complex1.re());
        }
    }

    public static Complex divide(Complex complex, Complex complex1)
    {
        if (!complex.isExact() || !complex1.isExact())
        {
            return DComplex.div(complex.doubleRealValue(), complex.doubleImagValue(), complex1.doubleRealValue(), complex1.doubleImagValue());
        } else
        {
            RealNum realnum = complex.re();
            complex = complex.im();
            RealNum realnum1 = complex1.re();
            RealNum realnum3 = complex1.im();
            complex1 = RealNum.add(RealNum.times(realnum1, realnum1), RealNum.times(realnum3, realnum3), 1);
            RealNum realnum2 = RealNum.add(RealNum.times(realnum, realnum1), RealNum.times(complex, realnum3), 1);
            complex = RealNum.add(RealNum.times(complex, realnum1), RealNum.times(realnum, realnum3), -1);
            return make(RealNum.divide(realnum2, complex1), RealNum.divide(complex, complex1));
        }
    }

    public static boolean equals(Complex complex, Complex complex1)
    {
        return complex.re().equals(complex1.re()) && complex.im().equals(complex.im());
    }

    public static CComplex imMinusOne()
    {
        if (imMinusOne == null)
        {
            imMinusOne = new CComplex(IntNum.zero(), IntNum.minusOne());
        }
        return imMinusOne;
    }

    public static CComplex imOne()
    {
        if (imOne == null)
        {
            imOne = new CComplex(IntNum.zero(), IntNum.one());
        }
        return imOne;
    }

    public static Complex make(double d, double d1)
    {
        if (d1 == 0.0D)
        {
            return new DFloNum(d);
        } else
        {
            return new DComplex(d, d1);
        }
    }

    public static Complex make(RealNum realnum, RealNum realnum1)
    {
        if (realnum1.isZero())
        {
            return realnum;
        }
        if (!realnum.isExact() || !realnum1.isExact())
        {
            return new DComplex(realnum.doubleValue(), realnum1.doubleValue());
        } else
        {
            return new CComplex(realnum, realnum1);
        }
    }

    public static Complex neg(Complex complex)
    {
        return make(complex.re().rneg(), complex.im().rneg());
    }

    public static DComplex polar(double d, double d1)
    {
        return new DComplex(Math.cos(d1) * d, Math.sin(d1) * d);
    }

    public static DComplex polar(RealNum realnum, RealNum realnum1)
    {
        return polar(realnum.doubleValue(), realnum1.doubleValue());
    }

    public static Complex power(Complex complex, Complex complex1)
    {
        if (complex1 instanceof IntNum)
        {
            return (Complex)complex.power((IntNum)complex1);
        }
        double d = complex.doubleRealValue();
        double d1 = complex.doubleImagValue();
        double d2 = complex1.doubleRealValue();
        double d3 = complex1.doubleImagValue();
        if (d1 == 0.0D && d3 == 0.0D && (d >= 0.0D || Double.isInfinite(d) || Double.isNaN(d)))
        {
            return new DFloNum(Math.pow(d, d2));
        } else
        {
            return DComplex.power(d, d1, d2, d3);
        }
    }

    public static Complex times(Complex complex, Complex complex1)
    {
        RealNum realnum = complex.re();
        complex = complex.im();
        RealNum realnum1 = complex1.re();
        complex1 = complex1.im();
        return make(RealNum.add(RealNum.times(realnum, realnum1), RealNum.times(complex, complex1), -1), RealNum.add(RealNum.times(realnum, complex1), RealNum.times(complex, realnum1), 1));
    }

    public Numeric abs()
    {
        return new DFloNum(Math.hypot(doubleRealValue(), doubleImagValue()));
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof Complex)
        {
            return add(this, (Complex)obj, i);
        } else
        {
            return ((Numeric)obj).addReversed(this, i);
        }
    }

    public Numeric addReversed(Numeric numeric, int i)
    {
        if (numeric instanceof Complex)
        {
            return add((Complex)numeric, this, i);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public RealNum angle()
    {
        return new DFloNum(Math.atan2(doubleImagValue(), doubleRealValue()));
    }

    public int compare(Object obj)
    {
        if (!(obj instanceof Complex))
        {
            return ((Numeric)obj).compareReversed(this);
        } else
        {
            return compare(this, (Complex)obj);
        }
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof Complex)
        {
            return divide(this, (Complex)obj);
        } else
        {
            return ((Numeric)obj).divReversed(this);
        }
    }

    public Numeric divReversed(Numeric numeric)
    {
        if (numeric instanceof Complex)
        {
            return divide((Complex)numeric, this);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public double doubleImagValue()
    {
        return im().doubleValue();
    }

    public final double doubleRealValue()
    {
        return doubleValue();
    }

    public double doubleValue()
    {
        return re().doubleValue();
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Complex))
        {
            return false;
        } else
        {
            return equals(this, (Complex)obj);
        }
    }

    public Complex exp()
    {
        return polar(Math.exp(doubleRealValue()), doubleImagValue());
    }

    public boolean isExact()
    {
        return re().isExact() && im().isExact();
    }

    public boolean isZero()
    {
        return re().isZero() && im().isZero();
    }

    public Complex log()
    {
        return DComplex.log(doubleRealValue(), doubleImagValue());
    }

    public long longValue()
    {
        return re().longValue();
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof Complex)
        {
            return times(this, (Complex)obj);
        } else
        {
            return ((Numeric)obj).mulReversed(this);
        }
    }

    public Numeric mulReversed(Numeric numeric)
    {
        if (numeric instanceof Complex)
        {
            return times((Complex)numeric, this);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Numeric neg()
    {
        return neg(this);
    }

    public Complex number()
    {
        return this;
    }

    public Complex sqrt()
    {
        return DComplex.sqrt(doubleRealValue(), doubleImagValue());
    }

    public Complex toExact()
    {
        RealNum realnum = re();
        RealNum realnum1 = im();
        RatNum ratnum = realnum.toExact();
        RatNum ratnum1 = realnum1.toExact();
        if (ratnum == realnum && ratnum1 == realnum1)
        {
            return this;
        } else
        {
            return new CComplex(ratnum, ratnum1);
        }
    }

    public volatile Numeric toExact()
    {
        return toExact();
    }

    public Complex toInexact()
    {
        if (isExact())
        {
            return this;
        } else
        {
            return new DComplex(re().doubleValue(), im().doubleValue());
        }
    }

    public volatile Numeric toInexact()
    {
        return toInexact();
    }

    public String toString(int i)
    {
        String s1;
        if (im().isZero())
        {
            s1 = re().toString(i);
        } else
        {
            s1 = (new StringBuilder()).append(im().toString(i)).append("i").toString();
            String s = s1;
            if (s1.charAt(0) != '-')
            {
                s = (new StringBuilder()).append("+").append(s1).toString();
            }
            s1 = s;
            if (!re().isZero())
            {
                return (new StringBuilder()).append(re().toString(i)).append(s).toString();
            }
        }
        return s1;
    }
}
