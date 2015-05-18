// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;


// Referenced classes of package gnu.math:
//            Numeric, Complex, Unit, DFloNum, 
//            DQuantity, CQuantity, RealNum, Dimensions

public abstract class Quantity extends Numeric
{

    public Quantity()
    {
    }

    public static Quantity add(Quantity quantity, Quantity quantity1, int i)
    {
        if (quantity.unit() == quantity1.unit())
        {
            return make(Complex.add(quantity.number(), quantity1.number(), i), quantity.unit());
        }
        if (quantity.dimensions() != quantity1.dimensions())
        {
            throw new ArithmeticException("units mis-match");
        } else
        {
            double d = quantity.unit().doubleValue();
            return make((quantity.reValue() + (double)i * quantity1.reValue()) / d, (quantity.imValue() + (double)i * quantity1.imValue()) / d, quantity.unit());
        }
    }

    public static int compare(Quantity quantity, Quantity quantity1)
    {
        if (quantity.unit() == quantity1.unit())
        {
            return Complex.compare(quantity.number(), quantity1.number());
        }
        if (quantity.dimensions() != quantity1.dimensions() || quantity.imValue() != quantity1.imValue())
        {
            return -3;
        } else
        {
            return DFloNum.compare(quantity.reValue(), quantity1.reValue());
        }
    }

    public static Quantity divide(Quantity quantity, Quantity quantity1)
    {
        Unit unit1 = Unit.divide(quantity.unit(), quantity1.unit());
        return make((Complex)quantity.number().div(quantity1.number()), unit1);
    }

    public static Quantity make(double d, double d1, Unit unit1)
    {
        if (unit1 == Unit.Empty)
        {
            return Complex.make(d, d1);
        }
        if (d1 == 0.0D)
        {
            return new DQuantity(d, unit1);
        } else
        {
            return new CQuantity(new DFloNum(d), new DFloNum(d1), unit1);
        }
    }

    public static Quantity make(Complex complex, Unit unit1)
    {
        if (unit1 == Unit.Empty)
        {
            return complex;
        }
        if (complex instanceof DFloNum)
        {
            return new DQuantity(complex.doubleValue(), unit1);
        } else
        {
            return new CQuantity(complex, unit1);
        }
    }

    public static Quantity make(RealNum realnum, RealNum realnum1, Unit unit1)
    {
        if (unit1 == Unit.Empty)
        {
            return Complex.make(realnum, realnum1);
        }
        if (realnum1.isZero() && (!realnum.isExact() || !realnum1.isExact()))
        {
            return new DQuantity(realnum.doubleValue(), unit1);
        } else
        {
            return new CQuantity(realnum, realnum1, unit1);
        }
    }

    public static Quantity times(Quantity quantity, Quantity quantity1)
    {
        Unit unit1 = Unit.times(quantity.unit(), quantity1.unit());
        return make((Complex)quantity.number().mul(quantity1.number()), unit1);
    }

    public Numeric abs()
    {
        return make((Complex)number().abs(), unit());
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof Quantity)
        {
            return add(this, (Quantity)obj, i);
        } else
        {
            return ((Numeric)obj).addReversed(this, i);
        }
    }

    public Numeric addReversed(Numeric numeric, int i)
    {
        if (numeric instanceof Quantity)
        {
            return add((Quantity)numeric, this, i);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public int compare(Object obj)
    {
        if (!(obj instanceof Quantity))
        {
            return ((Numeric)obj).compareReversed(this);
        } else
        {
            return compare(this, (Quantity)obj);
        }
    }

    public int compareReversed(Numeric numeric)
    {
        if (numeric instanceof Quantity)
        {
            return compare((Quantity)numeric, this);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Dimensions dimensions()
    {
        return unit().dimensions();
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof Quantity)
        {
            return divide(this, (Quantity)obj);
        } else
        {
            return ((Numeric)obj).divReversed(this);
        }
    }

    public Numeric divReversed(Numeric numeric)
    {
        if (numeric instanceof Quantity)
        {
            return divide((Quantity)numeric, this);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public double doubleImagValue()
    {
        return unit().doubleValue() * im().doubleValue();
    }

    public double doubleValue()
    {
        return unit().doubleValue() * re().doubleValue();
    }

    public RealNum im()
    {
        return number().im();
    }

    public final double imValue()
    {
        return doubleImagValue();
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof Quantity)
        {
            return times(this, (Quantity)obj);
        } else
        {
            return ((Numeric)obj).mulReversed(this);
        }
    }

    public Numeric mulReversed(Numeric numeric)
    {
        if (numeric instanceof Quantity)
        {
            return times((Quantity)numeric, this);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Numeric neg()
    {
        return make((Complex)number().neg(), unit());
    }

    public abstract Complex number();

    public RealNum re()
    {
        return number().re();
    }

    public final double reValue()
    {
        return doubleValue();
    }

    public String toString(int i)
    {
        String s = number().toString(i);
        if (unit() == Unit.Empty)
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append(unit().toString()).toString();
        }
    }

    public Unit unit()
    {
        return Unit.Empty;
    }
}
