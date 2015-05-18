// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.reflect;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.lists.FString;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;

// Referenced classes of package gnu.kawa.reflect:
//            SlotGet, Invoke, SlotSet

public class CompileReflect
{

    public CompileReflect()
    {
    }

    public static int checkKnownClass(Type type, Compilation compilation)
    {
        if ((type instanceof ClassType) && type.isExisting())
        {
            try
            {
                type.getReflectClass();
            }
            catch (Exception exception)
            {
                compilation.error('e', (new StringBuilder()).append("unknown class: ").append(type.getName()).toString());
                return -1;
            }
            return 1;
        } else
        {
            return 0;
        }
    }

    public static ApplyExp inlineClassName(ApplyExp applyexp, int i, InlineCalls inlinecalls)
    {
        Compilation compilation;
        Object obj;
label0:
        {
            compilation = inlinecalls.getCompilation();
            obj = compilation.getLanguage();
            inlinecalls = applyexp.getArgs();
            if (inlinecalls.length > i)
            {
                obj = ((Language) (obj)).getTypeFor(inlinecalls[i]);
                if (obj instanceof Type)
                {
                    break label0;
                }
            }
            return applyexp;
        }
        checkKnownClass(((Type) (obj)), compilation);
        Expression aexpression[] = new Expression[inlinecalls.length];
        System.arraycopy(inlinecalls, 0, aexpression, 0, inlinecalls.length);
        aexpression[i] = new QuoteExp(obj);
        inlinecalls = new ApplyExp(applyexp.getFunction(), aexpression);
        inlinecalls.setLine(applyexp);
        return inlinecalls;
    }

    public static Expression validateApplyInstanceOf(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        type = inlineClassName(applyexp, 1, inlinecalls);
        applyexp = type.getArgs();
        if (applyexp.length == 2)
        {
            procedure = applyexp[0];
            applyexp = applyexp[1];
            if (applyexp instanceof QuoteExp)
            {
                applyexp = ((ApplyExp) (((QuoteExp)applyexp).getValue()));
                if (applyexp instanceof Type)
                {
                    inlinecalls = (Type)applyexp;
                    applyexp = inlinecalls;
                    if (inlinecalls instanceof PrimType)
                    {
                        applyexp = ((PrimType)inlinecalls).boxedType();
                    }
                    if (procedure instanceof QuoteExp)
                    {
                        if (applyexp.isInstance(((QuoteExp)procedure).getValue()))
                        {
                            return QuoteExp.trueExp;
                        } else
                        {
                            return QuoteExp.falseExp;
                        }
                    }
                    if (!procedure.side_effects())
                    {
                        int i = applyexp.compare(procedure.getType());
                        if (i == 1 || i == 0)
                        {
                            return QuoteExp.trueExp;
                        }
                        if (i == -3)
                        {
                            return QuoteExp.falseExp;
                        }
                    }
                }
            }
        }
        return type;
    }

    public static Expression validateApplySlotGet(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        Language language;
        Expression aexpression[];
        Expression expression;
        Compilation compilation;
        Object obj2;
        boolean flag1;
        applyexp.visitArgs(inlinecalls);
        compilation = inlinecalls.getCompilation();
        language = compilation.getLanguage();
        flag1 = ((SlotGet)procedure).isStatic;
        aexpression = applyexp.getArgs();
        expression = aexpression[0];
        obj2 = aexpression[1];
        type = ((Type) (((Expression) (obj2)).valueIfConstant()));
        if ((type instanceof String) || (type instanceof FString)) goto _L2; else goto _L1
_L1:
        Object obj1 = applyexp;
        if (!(type instanceof Symbol)) goto _L3; else goto _L2
_L2:
        String s2;
        int i;
        s2 = type.toString();
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        obj1 = language.getTypeFor(expression);
        i = checkKnownClass(((Type) (obj1)), compilation);
        if (i >= 0) goto _L5; else goto _L4
_L4:
        obj1 = applyexp;
_L3:
        return ((Expression) (obj1));
_L5:
        Object obj;
        if ("class".equals(s2))
        {
            if (i > 0)
            {
                return QuoteExp.getInstance(((Type) (obj1)).getReflectClass());
            } else
            {
                return new ApplyExp(Compilation.typeType.getDeclaredMethod("getReflectClass", 0), new Expression[] {
                    expression
                });
            }
        }
        obj = obj1;
        type = applyexp;
        if (obj1 != null)
        {
            type = new QuoteExp(obj1);
            type = new ApplyExp(applyexp.getFunction(), new Expression[] {
                type, obj2
            });
            type.setLine(applyexp);
            obj = obj1;
        }
_L7:
        obj1 = type;
        if (obj instanceof ArrayType) goto _L3; else goto _L6
_L6:
        Field field;
        if (!(obj instanceof ObjectType))
        {
            break MISSING_BLOCK_LABEL_699;
        }
        obj1 = (ObjectType)obj;
        boolean flag;
        if (compilation.curClass != null)
        {
            applyexp = compilation.curClass;
        } else
        {
            applyexp = compilation.mainClass;
        }
        obj2 = SlotGet.lookupMember(((ObjectType) (obj1)), s2, applyexp);
        if (!(obj2 instanceof Field))
        {
            break MISSING_BLOCK_LABEL_450;
        }
        field = (Field)obj2;
        if ((field.getModifiers() & 8) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1 && !flag)
        {
            return new ErrorExp((new StringBuilder()).append("cannot access non-static field `").append(s2).append("' using `").append(procedure.getName()).append('\'').toString(), compilation);
        }
        break MISSING_BLOCK_LABEL_384;
        obj = expression.getType();
        type = applyexp;
          goto _L7
        if (applyexp != null && !applyexp.isAccessible(field, ((ObjectType) (obj1))))
        {
            return new ErrorExp((new StringBuilder()).append("field ").append(field.getDeclaringClass().getName()).append('.').append(s2).append(" is not accessible here").toString(), compilation);
        }
        break MISSING_BLOCK_LABEL_595;
        if (obj2 instanceof Method)
        {
            Method method = (Method)obj2;
            ClassType classtype = method.getDeclaringClass();
            int j = method.getModifiers();
            boolean flag2 = method.getStaticFlag();
            if (flag1 && !flag2)
            {
                return new ErrorExp((new StringBuilder()).append("cannot call non-static getter method `").append(s2).append("' using `").append(procedure.getName()).append('\'').toString(), compilation);
            }
            if (applyexp != null && !applyexp.isAccessible(classtype, ((ObjectType) (obj1)), j))
            {
                return new ErrorExp((new StringBuilder()).append("method ").append(method).append(" is not accessible here").toString(), compilation);
            }
        }
        if (obj2 != null)
        {
            applyexp = new QuoteExp(obj2);
            applyexp = new ApplyExp(type.getFunction(), new Expression[] {
                expression, applyexp
            });
            applyexp.setLine(type);
            return applyexp;
        }
        if (obj != Type.pointer_type && compilation.warnUnknownMember())
        {
            compilation.error('e', (new StringBuilder()).append("no slot `").append(s2).append("' in ").append(((ObjectType) (obj1)).getName()).toString());
        }
        procedure = Compilation.mangleNameIfNeeded(s2).intern();
        String s = ClassExp.slotToMethodName("get", s2);
        String s1 = ClassExp.slotToMethodName("is", s2);
        Invoke invoke = Invoke.invokeStatic;
        QuoteExp quoteexp = QuoteExp.getInstance("gnu.kawa.reflect.SlotGet");
        QuoteExp quoteexp1 = QuoteExp.getInstance("getSlotValue");
        if (flag1)
        {
            applyexp = QuoteExp.trueExp;
        } else
        {
            applyexp = QuoteExp.falseExp;
        }
        applyexp = new ApplyExp(invoke, new Expression[] {
            quoteexp, quoteexp1, applyexp, aexpression[0], QuoteExp.getInstance(s2), QuoteExp.getInstance(procedure), QuoteExp.getInstance(s), QuoteExp.getInstance(s1), QuoteExp.getInstance(language)
        });
        applyexp.setLine(type);
        return inlinecalls.visitApplyOnly(applyexp, null);
    }

    public static Expression validateApplySlotSet(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        procedure = (SlotSet)procedure;
        type = applyexp;
        if (((SlotSet) (procedure)).isStatic)
        {
            type = applyexp;
            if (inlinecalls.getCompilation().mustCompile)
            {
                type = inlineClassName(applyexp, 0, inlinecalls);
            }
        }
        if (((SlotSet) (procedure)).returnSelf && type.getArgCount() == 3)
        {
            applyexp = type.getArg(0).getType();
        } else
        {
            applyexp = Type.voidType;
        }
        type.setType(applyexp);
        return type;
    }

    public static Expression validateApplyTypeSwitch(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        type = applyexp.getArgs();
        for (int i = 1; i < type.length; i++)
        {
            if (type[i] instanceof LambdaExp)
            {
                procedure = (LambdaExp)type[i];
                procedure.setInlineOnly(true);
                procedure.returnContinuation = applyexp;
                procedure.inlineHome = inlinecalls.getCurrentLambda();
            }
        }

        return applyexp;
    }
}
