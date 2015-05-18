// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

// Referenced classes of package gnu.lists:
//            Sequence

public class EofClass
    implements Externalizable
{

    public static final EofClass eofValue = new EofClass();

    public EofClass()
    {
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return Sequence.eofValue;
    }

    public final String toString()
    {
        return "#!eof";
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
    }

}
