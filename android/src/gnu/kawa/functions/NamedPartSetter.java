// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.Procedure;
import gnu.mapping.Setter;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.kawa.functions:
//            NamedPart

class NamedPartSetter extends Setter
    implements Externalizable
{

    public NamedPartSetter(NamedPart namedpart)
    {
        super(namedpart);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPartSetter");
    }

    Procedure getGetter()
    {
        return getter;
    }

    public int numArgs()
    {
        return ((NamedPart)getter).kind != 'D' ? -4096 : 8193;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        getter = (Procedure)objectinput.readObject();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getter);
    }
}
