// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Member;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.CheckedTarget;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.Target;
import gnu.lists.FString;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure3;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import java.lang.reflect.InvocationTargetException;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.reflect:
//            SlotGet

public class SlotSet extends Procedure3
    implements Inlineable
{

    public static final SlotSet set$Mnfield$Ex = new SlotSet("set-field!", false);
    public static final SlotSet set$Mnstatic$Mnfield$Ex = new SlotSet("set-static-field!", true);
    public static final SlotSet setFieldReturnObject;
    static final Type type1Array[] = new Type[1];
    boolean isStatic;
    boolean returnSelf;

    public SlotSet(String s, boolean flag)
    {
        super(s);
        isStatic = flag;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.reflect.CompileReflect:validateApplySlotSet");
    }

    public static void apply(boolean flag, Object obj, Object obj1, Object obj2)
    {
        Class class1;
        Object obj3;
        String s;
        java.lang.reflect.Field field;
        Language language;
        boolean flag1;
        language = Language.getDefaultLanguage();
        flag1 = false;
        if ((obj1 instanceof String) || (obj1 instanceof FString) || (obj1 instanceof Symbol))
        {
            s = obj1.toString();
            obj3 = Compilation.mangleNameIfNeeded(s);
            if (flag)
            {
                class1 = SlotGet.coerceToClass(obj);
            } else
            {
                class1 = obj.getClass();
            }
        } else
        {
            s = ((Member)obj1).getName();
            obj3 = s;
            class1 = null;
        }
        if (!(obj1 instanceof Field))
        {
            break MISSING_BLOCK_LABEL_116;
        }
        field = ((Field)obj1).getReflectField();
_L1:
        field.set(obj, language.coerceFromObject(field.getType(), obj2));
        return;
        field = class1.getField(((String) (obj3)));
          goto _L1
        Object obj4;
        obj4;
        flag1 = true;
_L13:
        boolean flag2 = obj1 instanceof Method;
        if (!flag2) goto _L3; else goto _L2
_L2:
        obj1 = obj3;
_L6:
        flag = flag2;
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        boolean flag3 = ((String) (obj1)).startsWith("set");
        flag = flag2;
        if (!flag3)
        {
            flag = false;
        }
        if (!flag) goto _L5; else goto _L4
_L4:
        obj3 = (new StringBuilder()).append("get").append(((String) (obj1)).substring(3)).toString();
_L7:
        obj3 = class1.getMethod(((String) (obj3)), SlotGet.noClasses);
_L8:
        Class aclass[] = new Class[1];
        aclass[0] = ((java.lang.reflect.Method) (obj3)).getReturnType();
        class1.getMethod(((String) (obj1)), aclass).invoke(obj, new Object[] {
            language.coerceFromObject(aclass[0], obj2)
        });
        return;
        obj;
        throw WrappedException.wrapIfNeeded(((InvocationTargetException) (obj)).getTargetException());
_L3:
        obj1 = ClassExp.slotToMethodName("set", s);
          goto _L6
_L5:
        obj3 = ClassExp.slotToMethodName("get", s);
          goto _L7
        Exception exception;
        exception;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        exception = (new StringBuilder()).append("is").append(((String) (obj1)).substring(3)).toString();
_L9:
        exception = class1.getMethod(exception, SlotGet.noClasses);
          goto _L8
        exception = ClassExp.slotToMethodName("is", s);
          goto _L9
        obj;
        flag1 = true;
_L11:
        if (flag1)
        {
            throw new RuntimeException((new StringBuilder()).append("illegal access for field ").append(s).toString());
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("no such field ").append(s).append(" in ").append(class1.getName()).toString());
        }
        obj;
        if (true) goto _L11; else goto _L10
_L10:
        aclass;
        if (true) goto _L13; else goto _L12
_L12:
    }

    static void compileSet(Procedure procedure, ObjectType objecttype, Expression expression, Object obj, Compilation compilation)
    {
        Object obj1;
        boolean flag;
        objecttype = compilation.getCode();
        obj1 = compilation.getLanguage();
        boolean flag1;
        if ((procedure instanceof SlotSet) && ((SlotSet)procedure).isStatic)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(obj instanceof Field)) goto _L2; else goto _L1
_L1:
        obj = (Field)obj;
        flag1 = ((Field) (obj)).getStaticFlag();
        obj1 = ((Language) (obj1)).getLangTypeFor(((Field) (obj)).getType());
        if (flag && !flag1)
        {
            compilation.error('e', (new StringBuilder()).append("cannot access non-static field `").append(((Field) (obj)).getName()).append("' using `").append(procedure.getName()).append('\'').toString());
        }
        expression.compile(compilation, CheckedTarget.getInstance(((Type) (obj1))));
        if (!flag1) goto _L4; else goto _L3
_L3:
        objecttype.emitPutStatic(((Field) (obj)));
_L6:
        return;
_L4:
        objecttype.emitPutField(((Field) (obj)));
        return;
_L2:
        if (obj instanceof Method)
        {
            obj = (Method)obj;
            boolean flag2 = ((Method) (obj)).getStaticFlag();
            if (flag && !flag2)
            {
                compilation.error('e', (new StringBuilder()).append("cannot call non-static getter method `").append(((Method) (obj)).getName()).append("' using `").append(procedure.getName()).append('\'').toString());
            }
            expression.compile(compilation, CheckedTarget.getInstance(((Language) (obj1)).getLangTypeFor(((Method) (obj)).getParameterTypes()[0])));
            if (flag2)
            {
                objecttype.emitInvokeStatic(((Method) (obj)));
            } else
            {
                objecttype.emitInvoke(((Method) (obj)));
            }
            if (!((Method) (obj)).getReturnType().isVoid())
            {
                objecttype.emitPop(1);
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Member lookupMember(ObjectType objecttype, String s, ClassType classtype)
    {
        Field field = objecttype.getField(Compilation.mangleNameIfNeeded(s), -1);
        if (field == null) goto _L2; else goto _L1
_L1:
        ClassType classtype1;
        classtype1 = classtype;
        if (classtype == null)
        {
            classtype1 = Type.pointer_type;
        }
        if (!classtype1.isAccessible(field, objecttype)) goto _L2; else goto _L3
_L3:
        return field;
_L2:
        if ((objecttype = objecttype.getMethod(ClassExp.slotToMethodName("set", s), type1Array)) != null)
        {
            return objecttype;
        }
        if (true) goto _L3; else goto _L4
_L4:
    }

    public static void setField(Object obj, String s, Object obj1)
    {
        apply(false, obj, s, obj1);
    }

    public static void setStaticField(Object obj, String s, Object obj1)
    {
        apply(true, obj, s, obj1);
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
    {
        apply(isStatic, obj, obj1, obj2);
        if (returnSelf)
        {
            return obj;
        } else
        {
            return Values.empty;
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Expression aexpression[] = applyexp.getArgs();
        int i = aexpression.length;
        if (i != 3)
        {
            if (i < 3)
            {
                applyexp = "too few";
            } else
            {
                applyexp = "too many";
            }
            compilation.error('e', (new StringBuilder()).append(applyexp).append(" arguments to `").append(getName()).append('\'').toString());
            compilation.compileConstant(null, target);
            return;
        }
        Object obj = aexpression[0];
        Object obj1 = aexpression[1];
        Object obj2 = aexpression[2];
        if (isStatic)
        {
            obj2 = Scheme.exp2Type(((Expression) (obj)));
        } else
        {
            obj2 = ((Expression) (obj)).getType();
        }
        obj = null;
        if ((obj2 instanceof ObjectType) && (obj1 instanceof QuoteExp))
        {
            obj1 = ((QuoteExp)obj1).getValue();
            ObjectType objecttype = (ObjectType)obj2;
            ClassType classtype;
            if (compilation.curClass != null)
            {
                classtype = compilation.curClass;
            } else
            {
                classtype = compilation.mainClass;
            }
            if ((obj1 instanceof String) || (obj1 instanceof FString) || (obj1 instanceof Symbol))
            {
                String s = obj1.toString();
                Member member = lookupMember(objecttype, s, classtype);
                obj1 = s;
                obj = member;
                if (member == null)
                {
                    obj1 = s;
                    obj = member;
                    if (obj2 != Type.pointer_type)
                    {
                        obj1 = s;
                        obj = member;
                        if (compilation.warnUnknownMember())
                        {
                            compilation.error('w', (new StringBuilder()).append("no slot `").append(s).append("' in ").append(objecttype.getName()).toString());
                            obj = member;
                            obj1 = s;
                        }
                    }
                }
            } else
            if (obj1 instanceof Member)
            {
                obj = (Member)obj1;
                obj1 = ((Member) (obj)).getName();
            } else
            {
                obj1 = null;
            }
            if (obj != null)
            {
                boolean flag;
                if ((((Member) (obj)).getModifiers() & 8) != 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (classtype != null && !classtype.isAccessible(((Member) (obj)), objecttype))
                {
                    compilation.error('e', (new StringBuilder()).append("slot '").append(((String) (obj1))).append("' in ").append(((Member) (obj)).getDeclaringClass().getName()).append(" not accessible here").toString());
                }
                obj1 = aexpression[0];
                if (flag)
                {
                    applyexp = Target.Ignore;
                } else
                {
                    applyexp = Target.pushValue(objecttype);
                }
                ((Expression) (obj1)).compile(compilation, applyexp);
                if (returnSelf)
                {
                    compilation.getCode().emitDup(objecttype.getImplementationType());
                }
                compileSet(this, objecttype, aexpression[2], obj, compilation);
                if (returnSelf)
                {
                    target.compileFromStack(compilation, objecttype);
                    return;
                } else
                {
                    compilation.compileConstant(Values.empty, target);
                    return;
                }
            }
        }
        ApplyExp.compile(applyexp, compilation, target);
    }

    static 
    {
        setFieldReturnObject = new SlotSet("set-field-return-object!", false);
        setFieldReturnObject.returnSelf = true;
    }
}
