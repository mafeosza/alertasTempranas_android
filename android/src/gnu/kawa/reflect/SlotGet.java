// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Member;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package gnu.kawa.reflect:
//            SlotSet, ClassMethods

public class SlotGet extends Procedure2
    implements HasSetter, Inlineable
{

    public static final SlotGet field;
    static Class noClasses[] = new Class[0];
    public static final SlotGet slotRef;
    public static final SlotGet staticField;
    boolean isStatic;
    Procedure setter;

    public SlotGet(String s, boolean flag)
    {
        super(s);
        isStatic = flag;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotGet");
    }

    public SlotGet(String s, boolean flag, Procedure procedure)
    {
        this(s, flag);
        setter = procedure;
    }

    static Class coerceToClass(Object obj)
    {
        if (obj instanceof Class)
        {
            return (Class)obj;
        }
        if (obj instanceof Type)
        {
            return ((Type)obj).getReflectClass();
        } else
        {
            throw new RuntimeException("argument is neither Class nor Type");
        }
    }

    public static Object field(Object obj, String s)
    {
        return field.apply2(obj, s);
    }

    public static Object getSlotValue(boolean flag, Object obj, String s, String s1, String s2, String s3, Language language)
    {
        Class class1;
        Object obj1;
        if (flag)
        {
            class1 = coerceToClass(obj);
        } else
        {
            class1 = obj.getClass();
        }
        if (s1 != "length" || !class1.isArray()) goto _L2; else goto _L1
_L1:
        obj1 = Integer.valueOf(Array.getLength(obj));
_L4:
        return obj1;
_L2:
        obj1 = class1;
        if (s1 == "class") goto _L4; else goto _L3
_L3:
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = flag2;
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        try
        {
            obj1 = class1.getField(s1);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            obj1 = null;
        }
        flag1 = flag2;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_164;
        }
        if (flag && (((Field) (obj1)).getModifiers() & 8) == 0)
        {
            throw new RuntimeException((new StringBuilder()).append("cannot access non-static field '").append(s1).append('\'').toString());
        }
        obj1 = language.coerceToObject(((Field) (obj1)).getType(), ((Field) (obj1)).get(obj));
        return obj1;
        IllegalAccessException illegalaccessexception;
        illegalaccessexception;
        flag1 = true;
_L7:
        if (s2 == null) goto _L6; else goto _L5
_L5:
        illegalaccessexception = class1.getMethod(s2, noClasses);
        s = illegalaccessexception;
        s3 = s2;
        s2 = s;
        break MISSING_BLOCK_LABEL_191;
        exception;
        exception.printStackTrace();
        flag1 = flag2;
          goto _L7
_L6:
        s2 = ClassExp.slotToMethodName("get", s);
          goto _L5
        s2;
        if (s3 == null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        s = s3;
_L9:
        s2 = class1.getMethod(s, noClasses);
        s3 = s;
          goto _L8
        s = ClassExp.slotToMethodName("is", s);
          goto _L9
        obj = s2.invoke(obj, Values.noArgs);
        obj = language.coerceToObject(s2.getReturnType(), obj);
        return obj;
_L8:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_310;
        }
        Exception exception;
        try
        {
            if ((s2.getModifiers() & 8) == 0)
            {
                throw new RuntimeException((new StringBuilder()).append("cannot call non-static getter method '").append(s3).append('\'').toString());
            }
            break MISSING_BLOCK_LABEL_310;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw WrappedException.wrapIfNeeded(((InvocationTargetException) (obj)).getTargetException());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag1 = true;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (flag1)
        {
            throw new RuntimeException((new StringBuilder()).append("illegal access for field ").append(s1).toString());
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("no such field ").append(s1).append(" in ").append(class1.getName()).toString());
        }
    }

    public static Member lookupMember(ObjectType objecttype, String s, ClassType classtype)
    {
        gnu.bytecode.Field field1 = objecttype.getField(Compilation.mangleNameIfNeeded(s), -1);
        if (field1 == null) goto _L2; else goto _L1
_L1:
        ClassType classtype1;
        classtype1 = classtype;
        if (classtype == null)
        {
            classtype1 = Type.pointer_type;
        }
        if (!classtype1.isAccessible(field1, objecttype)) goto _L2; else goto _L3
_L3:
        return field1;
_L2:
        if ((objecttype = objecttype.getMethod(ClassExp.slotToMethodName("get", s), Type.typeArray0)) != null)
        {
            return objecttype;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static ApplyExp makeGetField(Expression expression, String s)
    {
        s = new QuoteExp(s);
        return new ApplyExp(field, new Expression[] {
            expression, s
        });
    }

    public static Object staticField(Object obj, String s)
    {
        return staticField.apply2(obj, s);
    }

    public Object apply2(Object obj, Object obj1)
    {
        String s = null;
        Object obj4 = null;
        Object obj5 = null;
        Object obj3 = null;
        Object obj2;
        if (obj1 instanceof gnu.bytecode.Field)
        {
            obj1 = ((gnu.bytecode.Field)obj1).getName();
            s = Compilation.demangleName(((String) (obj1)), true);
        } else
        if (obj1 instanceof gnu.bytecode.Method)
        {
            obj1 = ((gnu.bytecode.Method)obj1).getName();
            obj4 = Compilation.demangleName(((String) (obj1)), false);
            if (((String) (obj1)).startsWith("get"))
            {
                obj3 = obj5;
                obj2 = obj1;
            } else
            {
                obj2 = s;
                obj3 = obj5;
                if (((String) (obj1)).startsWith("is"))
                {
                    obj2 = s;
                    obj3 = obj1;
                }
            }
            obj1 = null;
            s = ((String) (obj4));
            obj4 = obj2;
        } else
        if ((obj1 instanceof SimpleSymbol) || (obj1 instanceof CharSequence))
        {
            s = obj1.toString();
            obj1 = Compilation.mangleNameIfNeeded(s);
        } else
        {
            throw new WrongType(this, 2, obj1, "string");
        }
        if ("class".equals(obj1))
        {
            obj2 = "class";
        } else
        {
            obj2 = obj1;
            if ("length".equals(obj1))
            {
                obj2 = "length";
            }
        }
        return getSlotValue(isStatic, obj, s, ((String) (obj2)), ((String) (obj4)), ((String) (obj3)), Language.getDefaultLanguage());
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Object obj2 = applyexp.getArgs();
        Object obj = obj2[0];
        Expression expression = obj2[1];
        Object obj1 = compilation.getLanguage();
        CodeAttr codeattr;
        if (isStatic)
        {
            obj = ((Language) (obj1)).getTypeFor(((Expression) (obj)));
        } else
        {
            obj = ((Expression) (obj)).getType();
        }
        codeattr = compilation.getCode();
        if ((obj instanceof ObjectType) && (expression instanceof QuoteExp))
        {
            ObjectType objecttype = (ObjectType)obj;
            Object obj3 = ((QuoteExp)expression).getValue();
            if (obj3 instanceof gnu.bytecode.Field)
            {
                obj = (gnu.bytecode.Field)obj3;
                boolean flag;
                if ((((gnu.bytecode.Field) (obj)).getModifiers() & 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                obj2 = obj2[0];
                if (flag)
                {
                    applyexp = Target.Ignore;
                } else
                {
                    applyexp = Target.pushValue(objecttype);
                }
                ((Expression) (obj2)).compile(compilation, applyexp);
                if (flag)
                {
                    if (true)
                    {
                        codeattr.emitGetStatic(((gnu.bytecode.Field) (obj)));
                    }
                } else
                {
                    codeattr.emitGetField(((gnu.bytecode.Field) (obj)));
                }
                target.compileFromStack(compilation, ((Language) (obj1)).getLangTypeFor(((gnu.bytecode.Field) (obj)).getType()));
                return;
            }
            if (obj3 instanceof gnu.bytecode.Method)
            {
                obj = (gnu.bytecode.Method)obj3;
                ((gnu.bytecode.Method) (obj)).getModifiers();
                boolean flag1 = ((gnu.bytecode.Method) (obj)).getStaticFlag();
                obj1 = obj2[0];
                if (flag1)
                {
                    applyexp = Target.Ignore;
                } else
                {
                    applyexp = Target.pushValue(objecttype);
                }
                ((Expression) (obj1)).compile(compilation, applyexp);
                if (flag1)
                {
                    codeattr.emitInvokeStatic(((gnu.bytecode.Method) (obj)));
                } else
                {
                    codeattr.emitInvoke(((gnu.bytecode.Method) (obj)));
                }
                target.compileFromStack(compilation, ((gnu.bytecode.Method) (obj)).getReturnType());
                return;
            }
        }
        obj1 = ClassMethods.checkName(expression);
        if ((obj instanceof ArrayType) && "length".equals(obj1) && !isStatic)
        {
            obj2[0].compile(compilation, Target.pushValue(((Type) (obj))));
            codeattr.emitArrayLength();
            target.compileFromStack(compilation, LangPrimType.intType);
            return;
        } else
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        if (aexpression.length == 2)
        {
            Expression expression = aexpression[0];
            aexpression = aexpression[1];
            if (aexpression instanceof QuoteExp)
            {
                Object obj = ((QuoteExp)aexpression).getValue();
                if (obj instanceof gnu.bytecode.Field)
                {
                    return ((gnu.bytecode.Field)obj).getType();
                }
                if (obj instanceof gnu.bytecode.Method)
                {
                    return ((gnu.bytecode.Method)obj).getReturnType();
                }
                if (!isStatic && (expression.getType() instanceof ArrayType) && "length".equals(ClassMethods.checkName(aexpression, true)))
                {
                    return LangPrimType.intType;
                }
            }
        }
        return Type.pointer_type;
    }

    public Procedure getSetter()
    {
        if (setter == null)
        {
            return super.getSetter();
        } else
        {
            return setter;
        }
    }

    public void set2(Object obj, Object obj1, Object obj2)
    {
        SlotSet.apply(isStatic, obj, (String)obj1, obj2);
    }

    public void setN(Object aobj[])
    {
        int i = aobj.length;
        if (i != 3)
        {
            throw new WrongArguments(getSetter(), i);
        } else
        {
            set2(aobj[0], aobj[1], aobj[2]);
            return;
        }
    }

    static 
    {
        field = new SlotGet("field", false, SlotSet.set$Mnfield$Ex);
        slotRef = new SlotGet("slot-ref", false, SlotSet.set$Mnfield$Ex);
        staticField = new SlotGet("static-field", true, SlotSet.set$Mnstatic$Mnfield$Ex);
    }
}
