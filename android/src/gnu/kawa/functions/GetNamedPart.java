// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.SlotGet;
import gnu.mapping.HasNamedParts;
import gnu.mapping.HasSetter;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Symbol;
import gnu.mapping.Values;

// Referenced classes of package gnu.kawa.functions:
//            NamedPart, SetNamedPart

public class GetNamedPart extends Procedure2
    implements HasSetter
{

    public static final String CAST_METHOD_NAME = "@";
    public static final String CLASSTYPE_FOR = "<>";
    public static final String INSTANCEOF_METHOD_NAME = "instance?";
    public static final GetNamedPart getNamedPart;

    public GetNamedPart()
    {
    }

    public static Object getMemberPart(Object obj, String s)
        throws Throwable
    {
        Object obj1;
        try
        {
            obj1 = SlotGet.field(obj, s);
        }
        catch (Throwable throwable)
        {
            gnu.mapping.MethodProc methodproc = ClassMethods.apply((ClassType)ClassType.make(obj.getClass()), Compilation.mangleName(s), '\0', Language.getDefaultLanguage());
            if (methodproc != null)
            {
                return new NamedPart(obj, s, 'M', methodproc);
            } else
            {
                throw new RuntimeException((new StringBuilder()).append("no part '").append(s).append("' in ").append(obj).toString());
            }
        }
        return obj1;
    }

    public static Object getNamedPart(Object obj, Symbol symbol)
        throws Throwable
    {
        Object obj1;
        String s;
        s = symbol.getName();
        if (obj instanceof HasNamedParts)
        {
            return ((HasNamedParts)obj).get(s);
        }
        obj1 = obj;
        if (obj instanceof Class)
        {
            obj1 = Type.make((Class)obj);
        }
        if (!(obj1 instanceof Package))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        obj = ((Package)obj1).getName();
        obj = ClassType.getContextClass((new StringBuilder()).append(((String) (obj))).append('.').append(s).toString());
        return obj;
        obj;
        if (obj1 instanceof Type)
        {
            return getTypePart((Type)obj1, s);
        } else
        {
            return getMemberPart(obj1, symbol.toString());
        }
    }

    public static Object getTypePart(Type type, String s)
        throws Throwable
    {
        if (s.equals("<>"))
        {
            return type;
        }
        if (type instanceof ObjectType)
        {
            if (s.equals("instance?"))
            {
                return new NamedPart(type, s, 'I');
            }
            if (s.equals("@"))
            {
                return new NamedPart(type, s, 'C');
            }
            if (s.equals("new"))
            {
                return new NamedPart(type, s, 'N');
            }
            if (s.equals(".length") || s.length() > 1 && s.charAt(0) == '.' && (type instanceof ClassType))
            {
                return new NamedPart(type, s, 'D');
            }
        }
        if (type instanceof ClassType)
        {
            Object obj;
            try
            {
                obj = SlotGet.staticField(type, s);
            }
            catch (Throwable throwable)
            {
                return ClassMethods.apply(ClassMethods.classMethods, type, s);
            }
            return obj;
        } else
        {
            return getMemberPart(type, s);
        }
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        if (obj instanceof Values)
        {
            obj = ((Object) (((Values)obj).getValues()));
            Values values = new Values();
            for (int i = 0; i < obj.length; i++)
            {
                Values.writeValues(apply2(obj[i], obj1), values);
            }

            return values.canonicalize();
        }
        if (obj1 instanceof Symbol)
        {
            obj1 = (Symbol)obj1;
        } else
        {
            obj1 = Namespace.EmptyNamespace.getSymbol(obj1.toString().intern());
        }
        return getNamedPart(obj, ((Symbol) (obj1)));
    }

    public Procedure getSetter()
    {
        return SetNamedPart.setNamedPart;
    }

    static 
    {
        getNamedPart = new GetNamedPart();
        getNamedPart.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileNamedPart:validateGetNamedPart");
    }
}
