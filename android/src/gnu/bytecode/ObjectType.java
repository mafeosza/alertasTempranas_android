// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.util.List;
import java.util.Vector;

// Referenced classes of package gnu.bytecode:
//            Type, CodeAttr, ClassType, ArrayType, 
//            Field, Method, Filter

public class ObjectType extends Type
{

    static final int ADD_ENCLOSING_DONE = 8;
    static final int ADD_FIELDS_DONE = 1;
    static final int ADD_MEMBERCLASSES_DONE = 4;
    static final int ADD_METHODS_DONE = 2;
    static final int EXISTING_CLASS = 16;
    static final int HAS_OUTER_LINK = 32;
    public int flags;

    protected ObjectType()
    {
        size = 4;
    }

    public ObjectType(String s)
    {
        this_name = s;
        size = 4;
    }

    public static Class getContextClass(String s)
        throws ClassNotFoundException
    {
        Class class1;
        try
        {
            class1 = Class.forName(s, false, gnu/bytecode/ObjectType.getClassLoader());
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return Class.forName(s, false, getContextClassLoader());
        }
        return class1;
    }

    public static ClassLoader getContextClassLoader()
    {
        ClassLoader classloader;
        try
        {
            classloader = ClassLoader.getSystemClassLoader();
        }
        catch (SecurityException securityexception)
        {
            return gnu/bytecode/ObjectType.getClassLoader();
        }
        return classloader;
    }

    public Object coerceFromObject(Object obj)
    {
        Object obj1 = obj;
        if (obj != null)
        {
            if (this == Type.toStringType)
            {
                obj1 = obj.toString();
            } else
            {
                Class class1 = getReflectClass();
                Class class2 = obj.getClass();
                obj1 = obj;
                if (!class1.isAssignableFrom(class2))
                {
                    throw new ClassCastException((new StringBuilder()).append("don't know how to coerce ").append(class2.getName()).append(" to ").append(getName()).toString());
                }
            }
        }
        return obj1;
    }

    public int compare(Type type)
    {
        return type != nullType ? -1 : 0;
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        if (this == Type.toStringType)
        {
            codeattr.emitDup();
            codeattr.emitIfNull();
            codeattr.emitPop(1);
            codeattr.emitPushNull();
            codeattr.emitElse();
            codeattr.emitInvokeVirtual(Type.toString_method);
            codeattr.emitFi();
        } else
        if (this != Type.objectType)
        {
            codeattr.emitCheckcast(this);
            return;
        }
    }

    public Field getField(String s, int i)
    {
        return null;
    }

    public Type getImplementationType()
    {
        Object obj;
        if (this == nullType)
        {
            obj = objectType;
        } else
        {
            obj = this;
            if (this == toStringType)
            {
                return javalangStringType;
            }
        }
        return ((Type) (obj));
    }

    public String getInternalName()
    {
        return getName().replace('.', '/');
    }

    public Method getMethod(String s, Type atype[])
    {
        return Type.objectType.getMethod(s, atype);
    }

    public int getMethods(Filter filter, int i, List list)
    {
        return Type.objectType.getMethods(filter, i, list);
    }

    public final int getMethods(Filter filter, int i, Vector vector, String s)
    {
        return Type.objectType.getMethods(filter, i, vector, s);
    }

    public Class getReflectClass()
    {
        try
        {
            if (reflectClass == null)
            {
                reflectClass = getContextClass(getInternalName().replace('/', '.'));
            }
            flags = flags | 0x10;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            if ((flags & 0x10) != 0)
            {
                RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append("no such class: ").append(getName()).toString());
                runtimeexception.initCause(classnotfoundexception);
                throw runtimeexception;
            }
        }
        return reflectClass;
    }

    public final boolean isExisting()
    {
        boolean flag = false;
        Type type1 = getImplementationType();
        Type type = type1;
        if (type1 instanceof ArrayType)
        {
            type = ((ArrayType)type1).getComponentType();
        }
        if (type == this)
        {
            return (flags & 0x10) != 0;
        }
        if (!(type instanceof ObjectType) || ((ObjectType)type).isExisting())
        {
            flag = true;
        }
        return flag;
    }

    public boolean isInstance(Object obj)
    {
        if (this == nullType)
        {
            return obj == null;
        } else
        {
            return super.isInstance(obj);
        }
    }

    public Type promote()
    {
        Object obj = this;
        if (this == nullType)
        {
            obj = objectType;
        }
        return ((Type) (obj));
    }

    public final void setExisting(boolean flag)
    {
        if (flag)
        {
            flags = flags | 0x10;
            return;
        } else
        {
            flags = flags & 0xffffffef;
            return;
        }
    }
}
