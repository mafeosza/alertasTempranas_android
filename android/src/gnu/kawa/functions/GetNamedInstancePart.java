// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.kawa.functions:
//            SetNamedInstancePart

public class GetNamedInstancePart extends ProcedureN
    implements Externalizable, HasSetter
{

    boolean isField;
    String pname;

    public GetNamedInstancePart()
    {
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedInstancePart");
    }

    public GetNamedInstancePart(String s)
    {
        this();
        setPartName(s);
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        checkArgCount(this, aobj.length);
        if (isField)
        {
            return SlotGet.field(aobj[0], pname);
        } else
        {
            Object aobj1[] = new Object[aobj.length + 1];
            aobj1[0] = aobj[0];
            aobj1[1] = pname;
            System.arraycopy(((Object) (aobj)), 1, ((Object) (aobj1)), 2, aobj.length - 1);
            return Invoke.invoke.applyN(aobj1);
        }
    }

    public Procedure getSetter()
    {
        if (!isField)
        {
            throw new RuntimeException("no setter for instance method call");
        } else
        {
            return new SetNamedInstancePart(pname);
        }
    }

    public int numArgs()
    {
        return !isField ? -4095 : 4097;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setPartName((String)objectinput.readObject());
    }

    public void setPartName(String s)
    {
        setName((new StringBuilder()).append("get-instance-part:").append(s).toString());
        if (s.length() > 1 && s.charAt(0) == '.')
        {
            isField = true;
            pname = s.substring(1);
            return;
        } else
        {
            isField = false;
            pname = s;
            return;
        }
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        String s;
        if (isField)
        {
            s = (new StringBuilder()).append(".").append(pname).toString();
        } else
        {
            s = pname;
        }
        objectoutput.writeObject(s);
    }
}
