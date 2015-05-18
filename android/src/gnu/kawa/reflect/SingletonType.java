// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.reflect:
//            OccurrenceType

public class SingletonType extends ObjectType
{

    static final SingletonType instance = new SingletonType("singleton");

    public SingletonType(String s)
    {
        super(s);
    }

    public static Object coerceToSingleton(Object obj)
    {
        Object obj1 = obj;
        if (obj instanceof Values)
        {
            obj1 = ((Values)obj).canonicalize();
        }
        if (obj1 == null || (obj1 instanceof Values))
        {
            throw new ClassCastException("value is not a singleton");
        } else
        {
            return obj1;
        }
    }

    public static final SingletonType getInstance()
    {
        return instance;
    }

    public Object coerceFromObject(Object obj)
    {
        return coerceToSingleton(obj);
    }

    public int compare(Type type)
    {
        byte byte0 = -1;
        int j = OccurrenceType.itemCountRange(type);
        int i = j & 0xfff;
        j >>= 12;
        if (j == 0 || i > 1)
        {
            i = -3;
        } else
        {
            if (i == 1 && j == 1)
            {
                return Type.pointer_type.compare(type);
            }
            j = Type.pointer_type.compare(type);
            i = byte0;
            if (j != 0)
            {
                i = byte0;
                if (j != -1)
                {
                    return -2;
                }
            }
        }
        return i;
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        codeattr.emitInvokeStatic(ClassType.make("gnu.kawa.reflect.SingletonType").getDeclaredMethod("coerceToSingleton", 1));
    }

    public Type getImplementationType()
    {
        return Type.pointer_type;
    }

    public Class getReflectClass()
    {
        return getImplementationType().getReflectClass();
    }

    public boolean isInstance(Object obj)
    {
        return obj != null && !(obj instanceof Values);
    }

}
