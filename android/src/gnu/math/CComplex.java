// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.math:
//            Complex, RealNum

public class CComplex extends Complex
    implements Externalizable
{

    RealNum imag;
    RealNum real;

    public CComplex()
    {
    }

    public CComplex(RealNum realnum, RealNum realnum1)
    {
        real = realnum;
        imag = realnum1;
    }

    public RealNum im()
    {
        return imag;
    }

    public RealNum re()
    {
        return real;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        real = (RealNum)objectinput.readObject();
        imag = (RealNum)objectinput.readObject();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(real);
        objectoutput.writeObject(imag);
    }
}
