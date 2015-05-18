// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.kawa.reflect.SlotSet;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class SetNamedInstancePart extends Procedure2
    implements Externalizable
{

    String pname;

    public SetNamedInstancePart()
    {
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateSetNamedInstancePart");
    }

    public SetNamedInstancePart(String s)
    {
        this();
        setPartName(s);
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        SlotSet.setField(obj, pname, obj1);
        return Values.empty;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setPartName((String)objectinput.readObject());
    }

    public void setPartName(String s)
    {
        setName((new StringBuilder()).append("set-instance-part:.").append(s).toString());
        pname = s;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(pname);
    }
}
