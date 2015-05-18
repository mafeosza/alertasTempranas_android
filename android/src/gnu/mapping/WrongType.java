// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.bytecode.Type;

// Referenced classes of package gnu.mapping:
//            WrappedException, Procedure, MethodProc

public class WrongType extends WrappedException
{

    public static final int ARG_CAST = -4;
    public static final int ARG_DESCRIPTION = -3;
    public static final int ARG_UNKNOWN = -1;
    public static final int ARG_VARNAME = -2;
    public Object argValue;
    public Object expectedType;
    public int number;
    public Procedure proc;
    public String procname;

    public WrongType(int i, Object obj, Type type)
    {
        number = i;
        argValue = obj;
        expectedType = type;
    }

    public WrongType(Procedure procedure, int i, ClassCastException classcastexception)
    {
        super(classcastexception);
        proc = procedure;
        procname = procedure.getName();
        number = i;
    }

    public WrongType(Procedure procedure, int i, Object obj)
    {
        proc = procedure;
        procname = procedure.getName();
        number = i;
        argValue = obj;
    }

    public WrongType(Procedure procedure, int i, Object obj, Type type)
    {
        proc = procedure;
        procname = procedure.getName();
        number = i;
        argValue = obj;
        expectedType = type;
    }

    public WrongType(Procedure procedure, int i, Object obj, String s)
    {
        this(procedure.getName(), i, obj, s);
        proc = procedure;
    }

    public WrongType(ClassCastException classcastexception, Procedure procedure, int i, Object obj)
    {
        this(procedure, i, classcastexception);
        argValue = obj;
    }

    public WrongType(ClassCastException classcastexception, String s, int i, Object obj)
    {
        this(s, i, classcastexception);
        argValue = obj;
    }

    public WrongType(String s, int i, ClassCastException classcastexception)
    {
        super(classcastexception);
        procname = s;
        number = i;
    }

    public WrongType(String s, int i, Object obj, String s1)
    {
        procname = s;
        number = i;
        argValue = obj;
        expectedType = s1;
    }

    public WrongType(String s, int i, String s1)
    {
        super(null, null);
        procname = s;
        number = i;
        expectedType = s1;
    }

    public static WrongType make(ClassCastException classcastexception, Procedure procedure, int i)
    {
        return new WrongType(procedure, i, classcastexception);
    }

    public static WrongType make(ClassCastException classcastexception, Procedure procedure, int i, Object obj)
    {
        classcastexception = new WrongType(procedure, i, classcastexception);
        classcastexception.argValue = obj;
        return classcastexception;
    }

    public static WrongType make(ClassCastException classcastexception, String s, int i)
    {
        return new WrongType(s, i, classcastexception);
    }

    public static WrongType make(ClassCastException classcastexception, String s, int i, Object obj)
    {
        classcastexception = new WrongType(s, i, classcastexception);
        classcastexception.argValue = obj;
        return classcastexception;
    }

    public String getMessage()
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        Object obj;
        if (number == -3)
        {
            stringbuffer.append(procname);
        } else
        if (number == -4 || number == -2)
        {
            stringbuffer.append("Value");
        } else
        {
            stringbuffer.append("Argument ");
            if (number > 0)
            {
                stringbuffer.append('#');
                stringbuffer.append(number);
            }
        }
        if (argValue != null)
        {
            stringbuffer.append(" (");
            obj = argValue.toString();
            Object obj1;
            if (((String) (obj)).length() > 50)
            {
                stringbuffer.append(((String) (obj)).substring(0, 47));
                stringbuffer.append("...");
            } else
            {
                stringbuffer.append(((String) (obj)));
            }
            stringbuffer.append(")");
        }
        if (procname != null && number != -3)
        {
            if (number == -2)
            {
                obj = " for variable '";
            } else
            {
                obj = " to '";
            }
            stringbuffer.append(((String) (obj)));
            stringbuffer.append(procname);
            stringbuffer.append("'");
        }
        stringbuffer.append(" has wrong type");
        if (argValue != null)
        {
            stringbuffer.append(" (");
            stringbuffer.append(argValue.getClass().getName());
            stringbuffer.append(")");
        }
        obj1 = expectedType;
        obj = obj1;
        if (obj1 == null)
        {
            obj = obj1;
            if (number > 0)
            {
                obj = obj1;
                if (proc instanceof MethodProc)
                {
                    obj = ((MethodProc)proc).getParameterType(number - 1);
                }
            }
        }
        if (obj != null && obj != Type.pointer_type)
        {
            stringbuffer.append(" (expected: ");
            Object obj2;
            if (obj instanceof Type)
            {
                obj2 = ((Type)obj).getName();
            } else
            {
                obj2 = obj;
                if (obj instanceof Class)
                {
                    obj2 = ((Class)obj).getName();
                }
            }
            stringbuffer.append(obj2);
            stringbuffer.append(")");
        }
        obj = getCause();
        if (obj != null)
        {
            obj = ((Throwable) (obj)).getMessage();
            if (obj != null)
            {
                stringbuffer.append(" (");
                stringbuffer.append(((String) (obj)));
                stringbuffer.append(')');
            }
        }
        return stringbuffer.toString();
    }
}
