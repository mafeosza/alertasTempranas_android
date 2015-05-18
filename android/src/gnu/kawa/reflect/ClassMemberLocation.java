// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;

// Referenced classes of package gnu.kawa.reflect:
//            StaticFieldLocation, FieldLocation

public abstract class ClassMemberLocation extends Location
{

    Object instance;
    String mname;
    Field rfield;
    ClassType type;

    public ClassMemberLocation(Object obj, ClassType classtype, String s)
    {
        instance = obj;
        type = classtype;
        mname = s;
    }

    public ClassMemberLocation(Object obj, Class class1, String s)
    {
        instance = obj;
        type = (ClassType)Type.make(class1);
        mname = s;
    }

    public ClassMemberLocation(Object obj, Field field)
    {
        instance = obj;
        rfield = field;
        mname = field.getName();
    }

    public static void define(Object obj, Field field, String s, Language language, Environment environment)
        throws IllegalAccessException
    {
        Object obj2 = field.get(obj);
        Object obj1 = Type.make(field.getType());
        boolean flag1 = ((Type) (obj1)).isSubtype(Compilation.typeLocation);
        ((Type) (obj1)).isSubtype(Compilation.typeProcedure);
        int i = field.getModifiers();
        String s1;
        boolean flag;
        if ((i & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && (obj2 instanceof Named) && !flag1)
        {
            obj1 = ((Named)obj2).getSymbol();
        } else
        {
            obj1 = Compilation.demangleName(field.getName(), true);
        }
        if (obj1 instanceof Symbol)
        {
            obj1 = (Symbol)obj1;
        } else
        {
            s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            obj1 = Symbol.make(s1, obj1.toString().intern());
        }
        s1 = null;
        s = null;
        if (flag1 && flag)
        {
            obj = (Location)obj2;
        } else
        {
            s = s1;
            if (flag)
            {
                s = ((String) (language.getEnvPropertyFor(field, obj2)));
            }
            if ((i & 8) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj = new StaticFieldLocation(field);
            } else
            {
                obj = new FieldLocation(obj, field);
            }
        }
        environment.addLocation(((Symbol) (obj1)), s, ((Location) (obj)));
    }

    public static void defineAll(Object obj, Language language, Environment environment)
        throws IllegalAccessException
    {
        Field afield[] = obj.getClass().getFields();
        int i = afield.length;
        do
        {
            int j = i - 1;
            if (j < 0)
            {
                break;
            }
            Field field = afield[j];
            String s = field.getName();
            i = j;
            if (!s.startsWith("$Prvt$"))
            {
                i = j;
                if (!s.endsWith("$instance"))
                {
                    define(obj, field, null, language, environment);
                    i = j;
                }
            }
        } while (true);
    }

    public Object get(Object obj)
    {
        Field field = getRField();
        if (field == null)
        {
            return obj;
        }
        try
        {
            obj = field.get(instance);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw WrappedException.wrapIfNeeded(((Throwable) (obj)));
        }
        return obj;
    }

    public ClassType getDeclaringClass()
    {
        return type;
    }

    public final Object getInstance()
    {
        return instance;
    }

    public String getMemberName()
    {
        return mname;
    }

    public Class getRClass()
    {
        Object obj = rfield;
        if (obj != null)
        {
            return ((Field) (obj)).getDeclaringClass();
        }
        try
        {
            obj = type.getReflectClass();
        }
        catch (Exception exception)
        {
            return null;
        }
        return ((Class) (obj));
    }

    public Field getRField()
    {
        Field field1 = rfield;
        Field field = field1;
        if (field1 == null)
        {
            try
            {
                field = type.getReflectClass().getField(mname);
                rfield = field;
            }
            catch (Exception exception)
            {
                return null;
            }
        }
        return field;
    }

    public boolean isBound()
    {
        return getRField() != null;
    }

    public boolean isConstant()
    {
        return getRField() != null && (rfield.getModifiers() & 0x10) != 0;
    }

    public void set(Object obj)
    {
        setup();
        try
        {
            rfield.set(instance, obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw WrappedException.wrapIfNeeded(((Throwable) (obj)));
        }
    }

    public final void setInstance(Object obj)
    {
        instance = obj;
    }

    void setup()
    {
        if (rfield != null)
        {
            break MISSING_BLOCK_LABEL_27;
        }
        Class class1;
        try
        {
            class1 = type.getReflectClass();
        }
        catch (RuntimeException runtimeexception)
        {
            UnboundLocationException unboundlocationexception = new UnboundLocationException(null, (new StringBuilder()).append("Unbound location - ").append(runtimeexception.toString()).toString());
            unboundlocationexception.initCause(runtimeexception);
            throw unboundlocationexception;
        }
        rfield = class1.getField(mname);
        return;
        NoSuchFieldException nosuchfieldexception;
        nosuchfieldexception;
        UnboundLocationException unboundlocationexception1 = new UnboundLocationException(null, (new StringBuilder()).append("Unbound location  - no field ").append(mname).append(" in ").append(type.getName()).toString());
        unboundlocationexception1.initCause(nosuchfieldexception);
        throw unboundlocationexception1;
    }
}
