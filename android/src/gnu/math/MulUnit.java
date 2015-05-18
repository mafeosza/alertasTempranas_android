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
//            Unit, Dimensions

class MulUnit extends Unit
    implements Externalizable
{

    MulUnit next;
    int power1;
    int power2;
    Unit unit1;
    Unit unit2;

    MulUnit(Unit unit, int i, Unit unit3, int j)
    {
        unit1 = unit;
        unit2 = unit3;
        power1 = i;
        power2 = j;
        dims = Dimensions.product(unit.dims, i, unit3.dims, j);
        if (i == 1)
        {
            factor = unit.factor;
        } else
        {
            factor = Math.pow(unit.factor, i);
        }
        if (j < 0)
        {
            i = -j;
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                factor = factor / unit3.factor;
            } while (true);
        } else
        {
            do
            {
                j--;
                if (j < 0)
                {
                    break;
                }
                factor = factor * unit3.factor;
            } while (true);
        }
        next = unit.products;
        unit.products = this;
    }

    MulUnit(Unit unit, Unit unit3, int i)
    {
        this(unit, 1, unit3, i);
    }

    static MulUnit lookup(Unit unit, int i, Unit unit3, int j)
    {
        for (MulUnit mulunit = unit.products; mulunit != null; mulunit = mulunit.next)
        {
            if (mulunit.unit1 == unit && mulunit.unit2 == unit3 && mulunit.power1 == i && mulunit.power2 == j)
            {
                return mulunit;
            }
        }

        return null;
    }

    public static MulUnit make(Unit unit, int i, Unit unit3, int j)
    {
        MulUnit mulunit = lookup(unit, i, unit3, j);
        if (mulunit != null)
        {
            return mulunit;
        } else
        {
            return new MulUnit(unit, i, unit3, j);
        }
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        unit1 = (Unit)objectinput.readObject();
        power1 = objectinput.readInt();
        unit2 = (Unit)objectinput.readObject();
        power2 = objectinput.readInt();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        MulUnit mulunit = lookup(unit1, power1, unit2, power2);
        if (mulunit != null)
        {
            return mulunit;
        } else
        {
            return this;
        }
    }

    public Unit sqrt()
    {
        if ((power1 & 1) == 0 && (power2 & 1) == 0)
        {
            return times(unit1, power1 >> 1, unit2, power2 >> 1);
        } else
        {
            return super.sqrt();
        }
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer(60);
        stringbuffer.append(unit1);
        if (power1 != 1)
        {
            stringbuffer.append('^');
            stringbuffer.append(power1);
        }
        if (power2 != 0)
        {
            stringbuffer.append('*');
            stringbuffer.append(unit2);
            if (power2 != 1)
            {
                stringbuffer.append('^');
                stringbuffer.append(power2);
            }
        }
        return stringbuffer.toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(unit1);
        objectoutput.writeInt(power1);
        objectoutput.writeObject(unit2);
        objectoutput.writeInt(power2);
    }
}
