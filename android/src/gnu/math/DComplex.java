// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.math:
//            Complex, Dimensions, Numeric, Unit, 
//            DFloNum, CComplex, RealNum

public class DComplex extends Complex
    implements Externalizable
{

    double imag;
    double real;

    public DComplex()
    {
    }

    public DComplex(double d, double d1)
    {
        real = d;
        imag = d1;
    }

    public static DComplex div(double d, double d1, double d2, double d3)
    {
        if (Math.abs(d2) <= Math.abs(d3))
        {
            double d4 = d2 / d3;
            d3 *= 1.0D + d4 * d4;
            d2 = d * d4 + d1;
            d1 = d1 * d4 - d;
            d = d3;
        } else
        {
            double d5 = d3 / d2;
            d3 = d2 * (1.0D + d5 * d5);
            d2 = d + d1 * d5;
            d1 -= d * d5;
            d = d3;
        }
        return new DComplex(d2 / d, d1 / d);
    }

    public static Complex log(double d, double d1)
    {
        return make(Math.log(Math.hypot(d, d1)), Math.atan2(d1, d));
    }

    public static DComplex power(double d, double d1, double d2, double d3)
    {
        double d4 = Math.log(Math.hypot(d, d1));
        d = Math.atan2(d1, d);
        return Complex.polar(Math.exp(d4 * d2 - d3 * d), d3 * d4 + d2 * d);
    }

    public static Complex sqrt(double d, double d1)
    {
        double d2 = Math.hypot(d, d1);
        if (d2 == 0.0D)
        {
            d = d2;
            d1 = d2;
        } else
        if (d > 0.0D)
        {
            d2 = Math.sqrt(0.5D * (d2 + d));
            d = d1 / d2 / 2D;
            d1 = d2;
        } else
        {
            d2 = Math.sqrt(0.5D * (d2 - d));
            d = d2;
            if (d1 < 0.0D)
            {
                d = -d2;
            }
            d1 = d1 / d / 2D;
        }
        return new DComplex(d1, d);
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof Complex)
        {
            obj = (Complex)obj;
            if (((Complex) (obj)).dimensions() != Dimensions.Empty)
            {
                throw new ArithmeticException("units mis-match");
            } else
            {
                return new DComplex(real + (double)i * ((Complex) (obj)).reValue(), imag + (double)i * ((Complex) (obj)).imValue());
            }
        } else
        {
            return ((Numeric)obj).addReversed(this, i);
        }
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof Complex)
        {
            obj = (Complex)obj;
            return div(real, imag, ((Complex) (obj)).doubleValue(), ((Complex) (obj)).doubleImagValue());
        } else
        {
            return ((Numeric)obj).divReversed(this);
        }
    }

    public double doubleImagValue()
    {
        return imag;
    }

    public double doubleValue()
    {
        return real;
    }

    public boolean equals(Object obj)
    {
        if (obj != null && (obj instanceof Complex))
        {
            if (((Complex) (obj = (Complex)obj)).unit() == Unit.Empty && Double.doubleToLongBits(real) == Double.doubleToLongBits(((Complex) (obj)).reValue()) && Double.doubleToLongBits(imag) == Double.doubleToLongBits(((Complex) (obj)).imValue()))
            {
                return true;
            }
        }
        return false;
    }

    public RealNum im()
    {
        return new DFloNum(imag);
    }

    public boolean isExact()
    {
        return false;
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof Complex)
        {
            obj = (Complex)obj;
            if (((Complex) (obj)).unit() == Unit.Empty)
            {
                double d = ((Complex) (obj)).reValue();
                double d1 = ((Complex) (obj)).imValue();
                return new DComplex(real * d - imag * d1, real * d1 + imag * d);
            } else
            {
                return Complex.times(this, ((Complex) (obj)));
            }
        } else
        {
            return ((Numeric)obj).mulReversed(this);
        }
    }

    public final Numeric neg()
    {
        return new DComplex(-real, -imag);
    }

    public RealNum re()
    {
        return new DFloNum(real);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        real = objectinput.readDouble();
        imag = objectinput.readDouble();
    }

    public Complex toExact()
    {
        return new CComplex(DFloNum.toExact(real), DFloNum.toExact(imag));
    }

    public volatile Numeric toExact()
    {
        return toExact();
    }

    public String toString()
    {
        Object obj = "";
        String s1;
        if (real == (1.0D / 0.0D))
        {
            obj = "#i";
            s1 = "1/0";
        } else
        if (real == (-1.0D / 0.0D))
        {
            obj = "#i";
            s1 = "-1/0";
        } else
        if (Double.isNaN(real))
        {
            obj = "#i";
            s1 = "0/0";
        } else
        {
            s1 = Double.toString(real);
        }
        if (Double.doubleToLongBits(imag) == 0L)
        {
            return (new StringBuilder()).append(((String) (obj))).append(s1).toString();
        }
        String s;
        Object obj1;
        if (imag == (1.0D / 0.0D))
        {
            obj1 = "#i";
            s = "+1/0i";
        } else
        if (imag == (-1.0D / 0.0D))
        {
            obj1 = "#i";
            s = "-1/0i";
        } else
        if (Double.isNaN(imag))
        {
            obj1 = "#i";
            s = "+0/0i";
        } else
        {
            String s2 = (new StringBuilder()).append(Double.toString(imag)).append("i").toString();
            s = s2;
            obj1 = obj;
            if (s2.charAt(0) != '-')
            {
                s = (new StringBuilder()).append("+").append(s2).toString();
                obj1 = obj;
            }
        }
        obj = new StringBuilder();
        if (Double.doubleToLongBits(real) != 0L)
        {
            obj1 = (new StringBuilder()).append(((String) (obj1))).append(s1).toString();
        }
        return ((StringBuilder) (obj)).append(((String) (obj1))).append(s).toString();
    }

    public String toString(int i)
    {
        if (i == 10)
        {
            return toString();
        } else
        {
            return (new StringBuilder()).append("#d").append(toString()).toString();
        }
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeDouble(real);
        objectoutput.writeDouble(imag);
    }
}
