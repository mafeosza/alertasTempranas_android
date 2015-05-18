// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.kawa.reflect.InstanceOf;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.mapping.CallContext;
import gnu.mapping.HasSetter;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.functions:
//            Convert, NamedPartSetter

class NamedPart extends ProcedureN
    implements HasSetter, Externalizable
{

    Object container;
    char kind;
    Object member;
    MethodProc methods;

    public NamedPart(Object obj, Object obj1, char c)
    {
        container = obj;
        member = obj1;
        kind = c;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateNamedPart");
    }

    public NamedPart(Object obj, String s, char c, MethodProc methodproc)
    {
        this(obj, s, c);
        methods = methodproc;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        apply(callcontext.getArgs(), callcontext);
    }

    public void apply(Object aobj[], CallContext callcontext)
        throws Throwable
    {
        if (kind == 'S')
        {
            methods.checkN(aobj, callcontext);
            return;
        }
        if (kind == 'M')
        {
            int i = aobj.length;
            Object aobj1[] = new Object[i + 1];
            aobj1[0] = container;
            System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 1, i);
            methods.checkN(aobj1, callcontext);
            return;
        } else
        {
            callcontext.writeValue(applyN(aobj));
            return;
        }
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        String s;
        switch (kind)
        {
        default:
            throw new Error((new StringBuilder()).append("unknown part ").append(member).append(" in ").append(container).toString());

        case 73: // 'I'
            return Scheme.instanceOf.apply2(aobj[0], container);

        case 67: // 'C'
            return Convert.as.apply2(container, aobj[0]);

        case 78: // 'N'
            Object aobj1[] = new Object[aobj.length + 1];
            aobj1[0] = container;
            System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj1)), 1, aobj.length);
            return Invoke.make.applyN(aobj1);

        case 83: // 'S'
            return methods.applyN(aobj);

        case 77: // 'M'
            Object aobj2[] = new Object[aobj.length + 1];
            aobj2[0] = container;
            System.arraycopy(((Object) (aobj)), 0, ((Object) (aobj2)), 1, aobj.length);
            return methods.applyN(aobj2);

        case 68: // 'D'
            s = member.toString().substring(1);
            break;
        }
        if (aobj.length == 0)
        {
            return SlotGet.staticField((ClassType)container, s);
        } else
        {
            return SlotGet.field(((Type)container).coerceFromObject(aobj[0]), s);
        }
    }

    public Procedure getSetter()
    {
        if (kind == 'D')
        {
            return new NamedPartSetter(this);
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("procedure '").append(getName()).append("' has no setter").toString());
        }
    }

    public int numArgs()
    {
        if (kind == 'I' || kind == 'C')
        {
            return 4097;
        }
        return kind != 'D' ? -4096 : 4096;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        kind = objectinput.readChar();
        container = (Procedure)objectinput.readObject();
        member = (Procedure)objectinput.readObject();
    }

    public void set0(Object obj)
        throws Throwable
    {
        String s;
        switch (kind)
        {
        default:
            throw new Error((new StringBuilder()).append("invalid setter for ").append(this).toString());

        case 68: // 'D'
            s = member.toString().substring(1);
            break;
        }
        SlotSet.setStaticField((ClassType)container, s, obj);
    }

    public void set1(Object obj, Object obj1)
        throws Throwable
    {
        String s;
        switch (kind)
        {
        default:
            throw new Error((new StringBuilder()).append("invalid setter for ").append(this).toString());

        case 68: // 'D'
            s = member.toString().substring(1);
            break;
        }
        SlotSet.setField(((Type)container).coerceFromObject(obj), s, obj1);
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(container);
        objectoutput.writeObject(member);
        objectoutput.writeChar(kind);
    }
}
