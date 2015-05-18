// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;

// Referenced classes of package gnu.mapping:
//            Symbol, Namespace

public class SimpleSymbol extends Symbol
{

    public SimpleSymbol()
    {
    }

    public SimpleSymbol(String s)
    {
        super(Namespace.EmptyNamespace, s);
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        name = ((String)objectinput.readObject()).intern();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return Namespace.EmptyNamespace.getSymbol(getName().intern());
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getName());
    }
}
