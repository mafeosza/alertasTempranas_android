// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.reflect.ArrayGet;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.math.Numeric;
import gnu.text.Char;
import java.io.Externalizable;

// Referenced classes of package gnu.kawa.functions:
//            Setter, IsEqv, SetArrayExp, SetListExp

public class CompilationHelpers
{

    public static final Declaration setterDecl;
    static final Field setterField;
    static final ClassType setterType;
    static final ClassType typeList = ClassType.make("java.util.List");

    public CompilationHelpers()
    {
    }

    private static boolean nonNumeric(Expression expression)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (expression instanceof QuoteExp)
        {
            expression = ((Expression) (((QuoteExp)expression).getValue()));
            flag = flag1;
            if (!(expression instanceof Numeric))
            {
                flag = flag1;
                if (!(expression instanceof Char))
                {
                    flag = flag1;
                    if (!(expression instanceof Symbol))
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    public static Expression validateApplyToArgs(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        Expression aexpression1[];
        int i;
        aexpression1 = applyexp.getArgs();
        i = aexpression1.length - 1;
        if (i < 0) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        Compilation compilation;
        Language language;
        obj = aexpression1[0];
        procedure = ((Procedure) (obj));
        if (!((Expression) (obj)).getFlag(1))
        {
            if (obj instanceof LambdaExp)
            {
                procedure = new Expression[i];
                System.arraycopy(aexpression1, 1, procedure, 0, i);
                return inlinecalls.visit((new ApplyExp(((Expression) (obj)), procedure)).setLine(applyexp), type);
            }
            procedure = inlinecalls.visit(((Expression) (obj)), null);
            aexpression1[0] = procedure;
        }
        obj1 = procedure.getType().getRealType();
        compilation = inlinecalls.getCompilation();
        language = compilation.getLanguage();
        if (((Type) (obj1)).isSubtype(Compilation.typeProcedure))
        {
            Expression aexpression[] = new Expression[i];
            System.arraycopy(aexpression1, 1, aexpression, 0, i);
            aexpression = new ApplyExp(procedure, aexpression);
            aexpression.setLine(applyexp);
            return procedure.validateApply(aexpression, inlinecalls, type, null);
        }
        aexpression = null;
        if (CompileReflect.checkKnownClass(((Type) (obj1)), compilation) >= 0) goto _L4; else goto _L3
_L3:
        procedure = aexpression;
_L5:
        if (procedure != null)
        {
            procedure.setLine(applyexp);
            return inlinecalls.visitApplyOnly(procedure, type);
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (((Type) (obj1)).isSubtype(Compilation.typeType) || language.getTypeFor(procedure, false) != null)
        {
            procedure = new ApplyExp(Invoke.make, aexpression1);
        } else
        if (obj1 instanceof ArrayType)
        {
            procedure = new ApplyExp(new ArrayGet(((ArrayType)obj1).getComponentType()), aexpression1);
        } else
        {
            procedure = aexpression;
            if (obj1 instanceof ClassType)
            {
                obj1 = (ClassType)obj1;
                procedure = aexpression;
                if (((ClassType) (obj1)).isSubclass(typeList))
                {
                    procedure = aexpression;
                    if (i == 1)
                    {
                        procedure = new ApplyExp(((ClassType) (obj1)).getMethod("get", new Type[] {
                            Type.intType
                        }), aexpression1);
                    }
                }
            }
        }
        if (true) goto _L5; else goto _L2
_L2:
        applyexp.visitArgs(inlinecalls);
        return applyexp;
    }

    public static Expression validateIsEqv(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        inlinecalls = applyexp.getArgs();
        if (nonNumeric(inlinecalls[0]) || nonNumeric(inlinecalls[1]))
        {
            applyexp = new ApplyExp(((IsEqv)procedure).isEq, inlinecalls);
        }
        return applyexp;
    }

    public static Expression validateSetter(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        type = applyexp.getArgs();
        inlinecalls = applyexp;
        if (type.length != 1) goto _L2; else goto _L1
_L1:
        inlinecalls = type[0];
        procedure = inlinecalls.getType();
        if (!(procedure instanceof ArrayType)) goto _L4; else goto _L3
_L3:
        inlinecalls = new SetArrayExp(inlinecalls, (ArrayType)procedure);
_L2:
        return inlinecalls;
_L4:
        if (!(procedure instanceof ClassType) || !((ClassType)procedure).isSubclass(typeList))
        {
            break; /* Loop/switch isn't completed */
        }
        inlinecalls = applyexp;
        if (!(applyexp instanceof SetListExp))
        {
            return new SetListExp(applyexp.getFunction(), type);
        }
        if (true) goto _L2; else goto _L5
_L5:
        type = inlinecalls;
        if (inlinecalls instanceof ReferenceExp)
        {
            procedure = ((ReferenceExp)inlinecalls).getBinding();
            type = inlinecalls;
            if (procedure != null)
            {
                type = procedure.getValue();
            }
        }
        inlinecalls = applyexp;
        if (type instanceof QuoteExp)
        {
            type = ((Type) (((QuoteExp)type).getValue()));
            inlinecalls = applyexp;
            if (type instanceof Procedure)
            {
                type = ((Procedure)type).getSetter();
                inlinecalls = applyexp;
                if (type instanceof Procedure)
                {
                    if (type instanceof Externalizable)
                    {
                        return new QuoteExp(type);
                    }
                    type = Declaration.getDeclaration((Procedure)type);
                    inlinecalls = applyexp;
                    if (type != null)
                    {
                        return new ReferenceExp(type);
                    }
                }
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    static 
    {
        setterType = ClassType.make("gnu.kawa.functions.Setter");
        setterField = setterType.getDeclaredField("setter");
        setterDecl = new Declaration("setter", setterField);
        setterDecl.noteValue(new QuoteExp(Setter.setter));
    }
}
