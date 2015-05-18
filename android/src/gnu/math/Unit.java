// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;


// Referenced classes of package gnu.math:
//            Quantity, NamedUnit, BaseUnit, Dimensions, 
//            MulUnit, DFloNum, IntNum, RealNum, 
//            DQuantity, Complex, Numeric

public abstract class Unit extends Quantity
{

    public static BaseUnit Empty;
    public static double NON_COMBINABLE;
    public static final Unit cm;
    public static final NamedUnit date;
    public static final BaseUnit duration;
    public static final BaseUnit gram = new BaseUnit("g", "Mass");
    public static final Unit hour;
    public static final Unit in;
    public static final BaseUnit meter;
    public static final Unit minute;
    public static final Unit mm;
    public static final NamedUnit month;
    public static final Unit pica;
    public static final Unit pt;
    public static final Unit radian;
    public static final NamedUnit second;
    static NamedUnit table[] = new NamedUnit[100];
    Unit base;
    Dimensions dims;
    double factor;
    MulUnit products;

    Unit()
    {
        factor = 1.0D;
    }

    public static Unit define(String s, double d, Unit unit1)
    {
        return new NamedUnit(s, d, unit1);
    }

    public static Unit define(String s, DQuantity dquantity)
    {
        return new NamedUnit(s, dquantity);
    }

    public static Unit divide(Unit unit1, Unit unit2)
    {
        return times(unit1, 1, unit2, -1);
    }

    public static NamedUnit lookup(String s)
    {
        return NamedUnit.lookup(s);
    }

    public static NamedUnit make(String s, Quantity quantity)
    {
        return NamedUnit.make(s, quantity);
    }

    public static Unit pow(Unit unit1, int i)
    {
        return times(unit1, i, Empty, 0);
    }

    static Unit times(Unit unit1, int i, Unit unit2, int j)
    {
        Object obj1;
        int l;
label0:
        {
            l = i;
            Object obj = unit2;
            int k = j;
            if (unit1 == unit2)
            {
                l = i + j;
                obj = Empty;
                k = 0;
            }
            if (l != 0)
            {
                obj1 = unit1;
                unit2 = ((Unit) (obj));
                i = k;
                if (unit1 != Empty)
                {
                    break label0;
                }
            }
            unit2 = Empty;
            i = 0;
            l = k;
            obj1 = obj;
        }
        if (i == 0 || unit2 == Empty)
        {
            if (l == 1)
            {
                return ((Unit) (obj1));
            }
            if (l == 0)
            {
                return Empty;
            }
        }
        if (obj1 instanceof MulUnit)
        {
            unit1 = (MulUnit)obj1;
            if (((MulUnit) (unit1)).unit1 == unit2)
            {
                return times(unit2, ((MulUnit) (unit1)).power1 * l + i, ((MulUnit) (unit1)).unit2, ((MulUnit) (unit1)).power2 * l);
            }
            if (((MulUnit) (unit1)).unit2 == unit2)
            {
                return times(((MulUnit) (unit1)).unit1, ((MulUnit) (unit1)).power1 * l, unit2, ((MulUnit) (unit1)).power2 * l + i);
            }
            if (unit2 instanceof MulUnit)
            {
                MulUnit mulunit = (MulUnit)unit2;
                if (((MulUnit) (unit1)).unit1 == mulunit.unit1 && ((MulUnit) (unit1)).unit2 == mulunit.unit2)
                {
                    return times(((MulUnit) (unit1)).unit1, ((MulUnit) (unit1)).power1 * l + mulunit.power1 * i, ((MulUnit) (unit1)).unit2, ((MulUnit) (unit1)).power2 * l + mulunit.power2 * i);
                }
                if (((MulUnit) (unit1)).unit1 == mulunit.unit2 && ((MulUnit) (unit1)).unit2 == mulunit.unit1)
                {
                    return times(((MulUnit) (unit1)).unit1, ((MulUnit) (unit1)).power1 * l + mulunit.power2 * i, ((MulUnit) (unit1)).unit2, ((MulUnit) (unit1)).power2 * l + mulunit.power1 * i);
                }
            }
        }
        if (unit2 instanceof MulUnit)
        {
            unit1 = (MulUnit)unit2;
            if (((MulUnit) (unit1)).unit1 == obj1)
            {
                return times(((Unit) (obj1)), ((MulUnit) (unit1)).power1 * i + l, ((MulUnit) (unit1)).unit2, ((MulUnit) (unit1)).power2 * i);
            }
            if (((MulUnit) (unit1)).unit2 == obj1)
            {
                return times(((MulUnit) (unit1)).unit1, ((MulUnit) (unit1)).power1 * i, ((Unit) (obj1)), ((MulUnit) (unit1)).power2 * i + l);
            }
        }
        return MulUnit.make(((Unit) (obj1)), l, unit2, i);
    }

    public static Unit times(Unit unit1, Unit unit2)
    {
        return times(unit1, 1, unit2, 1);
    }

    public final Dimensions dimensions()
    {
        return dims;
    }

    public final double doubleValue()
    {
        return factor;
    }

    public String getName()
    {
        return null;
    }

    public int hashCode()
    {
        return dims.hashCode();
    }

    public boolean isExact()
    {
        return false;
    }

    public final boolean isZero()
    {
        return false;
    }

    public Complex number()
    {
        return DFloNum.one();
    }

    public Numeric power(IntNum intnum)
    {
        if (intnum.words != null)
        {
            throw new ArithmeticException("Unit raised to bignum power");
        } else
        {
            return pow(this, intnum.ival);
        }
    }

    public Unit sqrt()
    {
        if (this == Empty)
        {
            return this;
        } else
        {
            throw new RuntimeException("unimplemented Unit.sqrt");
        }
    }

    public String toString()
    {
        String s = getName();
        if (s != null)
        {
            return s;
        }
        if (this == Empty)
        {
            return "unit";
        } else
        {
            return (new StringBuilder()).append(Double.toString(factor)).append("<unnamed unit>").toString();
        }
    }

    public String toString(double d)
    {
        String s = Double.toString(d);
        if (this == Empty)
        {
            return s;
        } else
        {
            return (new StringBuilder()).append(s).append(toString()).toString();
        }
    }

    public String toString(RealNum realnum)
    {
        return toString(realnum.doubleValue());
    }

    public Unit unit()
    {
        return this;
    }

    static 
    {
        Empty = new BaseUnit();
        Dimensions.Empty.bases[0] = Empty;
        NON_COMBINABLE = 0.0D;
        meter = new BaseUnit("m", "Length");
        duration = new BaseUnit("duration", "Time");
        cm = define("cm", 0.01D, meter);
        mm = define("mm", 0.10000000000000001D, cm);
        in = define("in", 0.025399999999999999D, meter);
        pt = define("pt", 0.00035277779999999998D, meter);
        pica = define("pica", 0.0042333329999999997D, meter);
        radian = define("rad", 1.0D, Empty);
        date = new NamedUnit("date", NON_COMBINABLE, duration);
        second = new NamedUnit("s", NON_COMBINABLE, duration);
        month = new NamedUnit("month", NON_COMBINABLE, duration);
        minute = define("min", 60D, second);
        hour = define("hour", 60D, minute);
    }
}
