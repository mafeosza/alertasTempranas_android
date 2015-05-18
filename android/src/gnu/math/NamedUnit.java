// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

// Referenced classes of package gnu.math:
//            Unit, DQuantity, Quantity, RealNum

public class NamedUnit extends Unit
    implements Externalizable
{

    Unit base;
    NamedUnit chain;
    String name;
    double scale;

    public NamedUnit()
    {
    }

    public NamedUnit(String s, double d, Unit unit)
    {
        name = s;
        base = unit;
        scale = d;
        init();
    }

    public NamedUnit(String s, DQuantity dquantity)
    {
        name = s.intern();
        scale = dquantity.factor;
        base = dquantity.unt;
        init();
    }

    public static NamedUnit lookup(String s)
    {
        String s1 = s.intern();
        int i = s1.hashCode();
        int j = table.length;
        for (s = table[(0x7fffffff & i) % j]; s != null; s = ((NamedUnit) (s)).chain)
        {
            if (((NamedUnit) (s)).name == s1)
            {
                return s;
            }
        }

        return null;
    }

    public static NamedUnit lookup(String s, double d, Unit unit)
    {
        String s1 = s.intern();
        int i = s1.hashCode();
        int j = table.length;
        for (s = table[(0x7fffffff & i) % j]; s != null; s = ((NamedUnit) (s)).chain)
        {
            if (((NamedUnit) (s)).name == s1 && ((NamedUnit) (s)).scale == d && ((NamedUnit) (s)).base == unit)
            {
                return s;
            }
        }

        return null;
    }

    public static NamedUnit make(String s, double d, Unit unit)
    {
        NamedUnit namedunit1 = lookup(s, d, unit);
        NamedUnit namedunit = namedunit1;
        if (namedunit1 == null)
        {
            namedunit = new NamedUnit(s, d, unit);
        }
        return namedunit;
    }

    public static NamedUnit make(String s, Quantity quantity)
    {
        double d;
        NamedUnit namedunit;
        Unit unit;
        if (quantity instanceof DQuantity)
        {
            d = ((DQuantity)quantity).factor;
        } else
        {
            if (quantity.imValue() != 0.0D)
            {
                throw new ArithmeticException((new StringBuilder()).append("defining ").append(s).append(" using complex value").toString());
            }
            d = quantity.re().doubleValue();
        }
        unit = quantity.unit();
        namedunit = lookup(s, d, unit);
        quantity = namedunit;
        if (namedunit == null)
        {
            quantity = new NamedUnit(s, d, unit);
        }
        return quantity;
    }

    public String getName()
    {
        return name;
    }

    protected void init()
    {
        factor = scale * base.factor;
        dims = base.dims;
        name = name.intern();
        int i = (0x7fffffff & name.hashCode()) % table.length;
        chain = table[i];
        table[i] = this;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        name = objectinput.readUTF();
        scale = objectinput.readDouble();
        base = (Unit)objectinput.readObject();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        NamedUnit namedunit = lookup(name, scale, base);
        if (namedunit != null)
        {
            return namedunit;
        } else
        {
            init();
            return this;
        }
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeUTF(name);
        objectoutput.writeDouble(scale);
        objectoutput.writeObject(base);
    }
}
