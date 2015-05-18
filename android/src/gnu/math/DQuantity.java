// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.math:
//            Quantity, Unit, Dimensions, RealNum, 
//            Numeric, DFloNum, Complex

public class DQuantity extends Quantity
    implements Externalizable
{

    double factor;
    Unit unt;

    public DQuantity(double d, Unit unit1)
    {
        factor = d;
        unt = unit1;
    }

    public static DQuantity add(DQuantity dquantity, DQuantity dquantity1, double d)
    {
        if (dquantity.dimensions() != dquantity1.dimensions())
        {
            throw new ArithmeticException("units mis-match");
        } else
        {
            double d1 = dquantity1.unit().factor / dquantity.unit().factor;
            return new DQuantity(dquantity.factor + d * d1 * dquantity1.factor, dquantity.unit());
        }
    }

    public static DQuantity divide(DQuantity dquantity, DQuantity dquantity1)
    {
        return new DQuantity(dquantity.factor / dquantity1.factor, Unit.divide(dquantity.unit(), dquantity1.unit()));
    }

    public static DQuantity times(DQuantity dquantity, DQuantity dquantity1)
    {
        return new DQuantity(dquantity.factor * dquantity1.factor, Unit.times(dquantity.unit(), dquantity1.unit()));
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof DQuantity)
        {
            return add(this, (DQuantity)obj, i);
        }
        if (dimensions() == Dimensions.Empty && (obj instanceof RealNum))
        {
            return new DQuantity(factor + (double)i * ((RealNum)obj).doubleValue(), unit());
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
        if (dimensions() == Dimensions.Empty && (numeric instanceof RealNum))
        {
            return new DFloNum(((RealNum)numeric).doubleValue() + (double)i * factor);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof DQuantity)
        {
            obj = (DQuantity)obj;
            if (dimensions() == ((DQuantity) (obj)).dimensions())
            {
                return new DFloNum((factor * unit().doubleValue()) / (((DQuantity) (obj)).factor * ((DQuantity) (obj)).unit().factor));
            } else
            {
                return divide(this, ((DQuantity) (obj)));
            }
        }
        if (obj instanceof RealNum)
        {
            return new DQuantity(factor / ((RealNum)obj).doubleValue(), unit());
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
        if (numeric instanceof RealNum)
        {
            return new DQuantity(((RealNum)numeric).doubleValue() / factor, Unit.divide(Unit.Empty, unit()));
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public final double doubleValue()
    {
        return factor * unt.factor;
    }

    public boolean isExact()
    {
        return false;
    }

    public boolean isZero()
    {
        return factor == 0.0D;
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof DQuantity)
        {
            return times(this, (DQuantity)obj);
        }
        if (obj instanceof RealNum)
        {
            return new DQuantity(factor * ((RealNum)obj).doubleValue(), unit());
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
        if (numeric instanceof RealNum)
        {
            return new DQuantity(((RealNum)numeric).doubleValue() * factor, unit());
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public final Complex number()
    {
        return new DFloNum(factor);
    }

    public final RealNum re()
    {
        return new DFloNum(factor);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        factor = objectinput.readDouble();
        unt = (Unit)objectinput.readObject();
    }

    public final Unit unit()
    {
        return unt;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeDouble(factor);
        objectoutput.writeObject(unt);
    }
}
