// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.List;

// Referenced classes of package gnu.bytecode:
//            ObjectType, Type, ClassType, Filter

public class ArrayType extends ObjectType
    implements Externalizable
{

    public Type elements;

    public ArrayType(Type type)
    {
        this(type, (new StringBuilder()).append(type.getName()).append("[]").toString());
    }

    ArrayType(Type type, String s)
    {
        this_name = s;
        elements = type;
    }

    public static ArrayType make(Type type)
    {
        ArrayType arraytype1 = type.array_type;
        ArrayType arraytype = arraytype1;
        if (arraytype1 == null)
        {
            arraytype = new ArrayType(type, (new StringBuilder()).append(type.getName()).append("[]").toString());
            type.array_type = arraytype;
        }
        return arraytype;
    }

    static ArrayType make(String s)
    {
        Type type = Type.getType(s.substring(0, s.length() - 2));
        ArrayType arraytype1 = type.array_type;
        ArrayType arraytype = arraytype1;
        if (arraytype1 == null)
        {
            arraytype = new ArrayType(type, s);
            type.array_type = arraytype;
        }
        return arraytype;
    }

    public int compare(Type type)
    {
        if (type == nullType)
        {
            return 1;
        }
        if (type instanceof ArrayType)
        {
            return elements.compare(((ArrayType)type).elements);
        }
        return !type.getName().equals("java.lang.Object") && type != toStringType ? -3 : -1;
    }

    public Type getComponentType()
    {
        return elements;
    }

    public Type getImplementationType()
    {
        Type type = elements.getImplementationType();
        if (elements == type)
        {
            return this;
        } else
        {
            return make(type);
        }
    }

    public String getInternalName()
    {
        return getSignature();
    }

    public int getMethods(Filter filter, int i, List list)
    {
        int j = 0;
        if (i > 0)
        {
            int k = Type.objectType.getMethods(filter, 0, list);
            j = k;
            if (i > 1)
            {
                j = k;
                if (filter.select(Type.clone_method))
                {
                    if (list != null)
                    {
                        list.add(Type.clone_method);
                    }
                    j = k + 1;
                }
            }
        }
        return j;
    }

    public Class getReflectClass()
    {
        try
        {
            if (reflectClass == null)
            {
                reflectClass = Class.forName(getInternalName().replace('/', '.'), false, elements.getReflectClass().getClassLoader());
            }
            flags = flags | 0x10;
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            if ((flags & 0x10) != 0)
            {
                RuntimeException runtimeexception = new RuntimeException((new StringBuilder()).append("no such array class: ").append(getName()).toString());
                runtimeexception.initCause(classnotfoundexception);
                throw runtimeexception;
            }
        }
        return reflectClass;
    }

    public String getSignature()
    {
        if (signature == null)
        {
            setSignature((new StringBuilder()).append("[").append(elements.getSignature()).toString());
        }
        return signature;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        elements = (Type)objectinput.readObject();
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        ArrayType arraytype = elements.array_type;
        if (arraytype != null)
        {
            return arraytype;
        } else
        {
            elements.array_type = this;
            return this;
        }
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(elements);
    }
}
