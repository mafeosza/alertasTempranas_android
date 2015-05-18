// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.math:
//            Quantity, CComplex, Complex, Unit, 
//            RealNum

public class CQuantity extends Quantity
    implements Externalizable
{

    Complex num;
    Unit unt;

    public CQuantity(Complex complex, Unit unit1)
    {
        num = complex;
        unt = unit1;
    }

    public CQuantity(RealNum realnum, RealNum realnum1, Unit unit1)
    {
        num = new CComplex(realnum, realnum1);
        unt = unit1;
    }

    public boolean isExact()
    {
        return num.isExact();
    }

    public boolean isZero()
    {
        return num.isZero();
    }

    public Complex number()
    {
        return num;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        num = (Complex)objectinput.readObject();
        unt = (Unit)objectinput.readObject();
    }

    public Unit unit()
    {
        return unt;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(num);
        objectoutput.writeObject(unt);
    }
}
