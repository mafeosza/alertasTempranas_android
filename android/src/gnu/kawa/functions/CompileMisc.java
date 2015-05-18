// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.ConsumerTarget;
import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.expr.TryExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.CompileReflect;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.lists.LList;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.WrongArguments;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.functions:
//            CompileTimeContinuation, Convert, ConstantFunction0, Map, 
//            ValuesMap, Not

public class CompileMisc
    implements Inlineable
{
    static class ExitThroughFinallyChecker extends ExpVisitor
    {

        Declaration decl;

        public static boolean check(Declaration declaration, Expression expression)
        {
            ExitThroughFinallyChecker exitthroughfinallychecker = new ExitThroughFinallyChecker();
            exitthroughfinallychecker.decl = declaration;
            exitthroughfinallychecker.visit(expression, null);
            return exitthroughfinallychecker.exitValue != null;
        }

        protected Expression defaultValue(Expression expression, TryExp tryexp)
        {
            return expression;
        }

        protected volatile Object defaultValue(Expression expression, Object obj)
        {
            return defaultValue(expression, (TryExp)obj);
        }

        protected Expression visitReferenceExp(ReferenceExp referenceexp, TryExp tryexp)
        {
            if (decl == referenceexp.getBinding() && tryexp != null)
            {
                exitValue = Boolean.TRUE;
            }
            return referenceexp;
        }

        protected volatile Object visitReferenceExp(ReferenceExp referenceexp, Object obj)
        {
            return visitReferenceExp(referenceexp, (TryExp)obj);
        }

        protected Expression visitTryExp(TryExp tryexp, TryExp tryexp1)
        {
            if (tryexp.getFinallyClause() != null)
            {
                tryexp1 = tryexp;
            }
            visitExpression(tryexp, tryexp1);
            return tryexp;
        }

        protected volatile Object visitTryExp(TryExp tryexp, Object obj)
        {
            return visitTryExp(tryexp, (TryExp)obj);
        }

        ExitThroughFinallyChecker()
        {
        }
    }


    static final int CONVERT = 2;
    static final int NOT = 3;
    static Method coerceMethod;
    public static final ClassType typeContinuation = ClassType.make("kawa.lang.Continuation");
    static ClassType typeType;
    int code;
    Procedure proc;

    public CompileMisc(Procedure procedure, int i)
    {
        proc = procedure;
        code = i;
    }

    private static LambdaExp canInlineCallCC(ApplyExp applyexp)
    {
        applyexp = applyexp.getArgs();
        if (applyexp.length == 1)
        {
            applyexp = applyexp[0];
            if (applyexp instanceof LambdaExp)
            {
                applyexp = (LambdaExp)applyexp;
                if (((LambdaExp) (applyexp)).min_args == 1 && ((LambdaExp) (applyexp)).max_args == 1 && !applyexp.firstDecl().getCanWrite())
                {
                    return applyexp;
                }
            }
        }
        return null;
    }

    public static void compileCallCC(ApplyExp applyexp, Compilation compilation, Target target, Procedure procedure)
    {
        procedure = canInlineCallCC(applyexp);
        if (procedure == null)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
        CodeAttr codeattr = compilation.getCode();
        Object obj = procedure.firstDecl();
        if (((Declaration) (obj)).isSimple() && !((Declaration) (obj)).getCanRead() && !((Declaration) (obj)).getCanWrite())
        {
            CompileTimeContinuation compiletimecontinuation = new CompileTimeContinuation();
            if (target instanceof StackTarget)
            {
                applyexp = target.getType();
            } else
            {
                applyexp = null;
            }
            compiletimecontinuation.exitableBlock = codeattr.startExitableBlock(applyexp, ExitThroughFinallyChecker.check(((Declaration) (obj)), ((LambdaExp) (procedure)).body));
            compiletimecontinuation.blockTarget = target;
            ((Declaration) (obj)).setValue(new QuoteExp(compiletimecontinuation));
            ((LambdaExp) (procedure)).body.compile(compilation, target);
            codeattr.endExitableBlock();
            return;
        }
        obj = codeattr.pushScope().addVariable(codeattr, typeContinuation, null);
        Declaration declaration = new Declaration(((gnu.bytecode.Variable) (obj)));
        codeattr.emitNew(typeContinuation);
        codeattr.emitDup(typeContinuation);
        compilation.loadCallContext();
        codeattr.emitInvokeSpecial(typeContinuation.getDeclaredMethod("<init>", 1));
        codeattr.emitStore(((gnu.bytecode.Variable) (obj)));
        if ((target instanceof IgnoreTarget) || (target instanceof ConsumerTarget))
        {
            applyexp = null;
        } else
        {
            applyexp = Type.objectType;
        }
        codeattr.emitTryStart(false, applyexp);
        (new ApplyExp(procedure, new Expression[] {
            new ReferenceExp(declaration)
        })).compile(compilation, target);
        if (codeattr.reachableHere())
        {
            codeattr.emitLoad(((gnu.bytecode.Variable) (obj)));
            codeattr.emitPushInt(1);
            codeattr.emitPutField(typeContinuation.getField("invoked"));
        }
        codeattr.emitTryEnd();
        codeattr.emitCatchStart(null);
        codeattr.emitLoad(((gnu.bytecode.Variable) (obj)));
        if (target instanceof ConsumerTarget)
        {
            compilation.loadCallContext();
            codeattr.emitInvokeStatic(typeContinuation.getDeclaredMethod("handleException$X", 3));
        } else
        {
            codeattr.emitInvokeStatic(typeContinuation.getDeclaredMethod("handleException", 2));
            target.compileFromStack(compilation, Type.objectType);
        }
        codeattr.emitCatchEnd();
        codeattr.emitTryCatchEnd();
        codeattr.popScope();
    }

    public static void compileConvert(Convert convert, ApplyExp applyexp, Compilation compilation, Target target)
    {
        applyexp = applyexp.getArgs();
        if (applyexp.length != 2)
        {
            throw new Error((new StringBuilder()).append("wrong number of arguments to ").append(convert.getName()).toString());
        }
        convert = compilation.getCode();
        Type type = Scheme.getTypeValue(applyexp[0]);
        if (type != null)
        {
            applyexp[1].compile(compilation, Target.pushValue(type));
            if (convert.reachableHere())
            {
                target.compileFromStack(compilation, type);
            }
            return;
        }
        if (typeType == null)
        {
            typeType = ClassType.make("gnu.bytecode.Type");
        }
        if (coerceMethod == null)
        {
            coerceMethod = typeType.addMethod("coerceFromObject", Compilation.apply1args, Type.pointer_type, 1);
        }
        applyexp[0].compile(compilation, LangObjType.typeClassType);
        applyexp[1].compile(compilation, Target.pushObject);
        convert.emitInvokeVirtual(coerceMethod);
        target.compileFromStack(compilation, Type.pointer_type);
    }

    public static CompileMisc forConvert(Object obj)
    {
        return new CompileMisc((Procedure)obj, 2);
    }

    public static CompileMisc forNot(Object obj)
    {
        return new CompileMisc((Procedure)obj, 3);
    }

    public static Expression validateApplyAppendValues(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        type = applyexp.getArgs();
        if (type.length == 1)
        {
            inlinecalls = type[0];
        } else
        {
            if (type.length == 0)
            {
                return QuoteExp.voidExp;
            }
            type = applyexp.inlineIfConstant(procedure, inlinecalls);
            inlinecalls = type;
            if (type == applyexp)
            {
                return applyexp;
            }
        }
        return inlinecalls;
    }

    public static Expression validateApplyCallCC(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        type = canInlineCallCC(applyexp);
        if (type != null)
        {
            type.setInlineOnly(true);
            type.returnContinuation = applyexp;
            type.inlineHome = inlinecalls.getCurrentLambda();
            type = type.firstDecl();
            if (!type.getFlag(8192L))
            {
                type.setType(typeContinuation);
            }
        }
        applyexp.visitArgs(inlinecalls);
        return applyexp;
    }

    public static Expression validateApplyConstantFunction0(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        int i = applyexp.getArgCount();
        if (i != 0 && inlinecalls != null)
        {
            return inlinecalls.noteError(WrongArguments.checkArgCount(procedure, i));
        } else
        {
            return ((ConstantFunction0)procedure).constant;
        }
    }

    public static Expression validateApplyConvert(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        type = inlinecalls.getCompilation();
        Object obj = type.getLanguage();
        procedure = applyexp.getArgs();
        if (procedure.length == 2)
        {
            procedure[0] = inlinecalls.visit(procedure[0], null);
            obj = ((Language) (obj)).getTypeFor(procedure[0]);
            if (obj instanceof Type)
            {
                procedure[0] = new QuoteExp(obj);
                procedure[1] = inlinecalls.visit(procedure[1], ((Type) (obj)));
                CompileReflect.checkKnownClass(((Type) (obj)), type);
                applyexp.setType(((Type) (obj)));
                return applyexp;
            }
        }
        applyexp.visitArgs(inlinecalls);
        return applyexp;
    }

    public static Expression validateApplyFormat(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        procedure = Type.objectType;
        type = applyexp.getArgs();
        inlinecalls = procedure;
        if (type.length > 0)
        {
            inlinecalls = ClassType.make("gnu.kawa.functions.Format");
            Object obj = type[0].valueIfConstant();
            Type type1 = type[0].getType();
            if (obj == Boolean.FALSE || type1.isSubtype(LangObjType.stringType))
            {
                int i;
                if (obj == Boolean.FALSE)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                applyexp = new Expression[(type.length + 1) - i];
                applyexp[0] = new QuoteExp(Integer.valueOf(0), Type.intType);
                System.arraycopy(type, i, applyexp, 1, applyexp.length - 1);
                applyexp = new ApplyExp(inlinecalls.getDeclaredMethod("formatToString", 2), applyexp);
                applyexp.setType(Type.javalangStringType);
                return applyexp;
            }
            if (obj == Boolean.TRUE || type1.isSubtype(ClassType.make("java.io.Writer")))
            {
                applyexp = type;
                if (obj == Boolean.TRUE)
                {
                    applyexp = new Expression[type.length];
                    applyexp[0] = QuoteExp.nullExp;
                    System.arraycopy(type, 1, applyexp, 1, type.length - 1);
                }
                applyexp = new ApplyExp(inlinecalls.getDeclaredMethod("formatToWriter", 3), applyexp);
                applyexp.setType(Type.voidType);
                return applyexp;
            }
            inlinecalls = procedure;
            if (type1.isSubtype(ClassType.make("java.io.OutputStream")))
            {
                inlinecalls = Type.voidType;
            }
        }
        applyexp.setType(inlinecalls);
        return null;
    }

    public static Expression validateApplyMakeProcedure(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        Expression aexpression[];
        int k;
        int i1;
        int k1;
        applyexp.visitArgs(inlinecalls);
        aexpression = applyexp.getArgs();
        k1 = aexpression.length;
        inlinecalls = null;
        i1 = 0;
        procedure = null;
        k = 0;
_L8:
        if (k >= k1) goto _L2; else goto _L1
_L1:
        type = aexpression[k];
        if (!(type instanceof QuoteExp)) goto _L4; else goto _L3
_L3:
        Object obj = ((QuoteExp)type).getValue();
        if (!(obj instanceof Keyword)) goto _L4; else goto _L5
_L5:
        int i;
        String s = ((Keyword)obj).getName();
        int j1 = k + 1;
        Expression expression1 = aexpression[j1];
        if (s == "name")
        {
            i = i1;
            k = j1;
            type = inlinecalls;
            obj = procedure;
            if (expression1 instanceof QuoteExp)
            {
                obj = ((QuoteExp)expression1).getValue().toString();
                type = inlinecalls;
                k = j1;
                i = i1;
            }
        } else
        {
            i = i1;
            k = j1;
            type = inlinecalls;
            obj = procedure;
            if (s == "method")
            {
                i = i1 + 1;
                type = expression1;
                k = j1;
                obj = procedure;
            }
        }
_L6:
        k++;
        i1 = i;
        inlinecalls = type;
        procedure = ((Procedure) (obj));
        continue; /* Loop/switch isn't completed */
_L4:
        i = i1 + 1;
        obj = procedure;
        if (true) goto _L6; else goto _L2
_L2:
        if (i1 == 1 && (inlinecalls instanceof LambdaExp))
        {
            type = (LambdaExp)inlinecalls;
            int j = 0;
            do
            {
                applyexp = inlinecalls;
                if (j >= k1)
                {
                    break;
                }
                applyexp = aexpression[j];
                int l = j;
                if (applyexp instanceof QuoteExp)
                {
                    applyexp = ((ApplyExp) (((QuoteExp)applyexp).getValue()));
                    l = j;
                    if (applyexp instanceof Keyword)
                    {
                        applyexp = ((Keyword)applyexp).getName();
                        j++;
                        Expression expression = aexpression[j];
                        if (applyexp == "name")
                        {
                            type.setName(procedure);
                            l = j;
                        } else
                        {
                            l = j;
                            if (applyexp != "method")
                            {
                                type.setProperty(Namespace.EmptyNamespace.getSymbol(applyexp), expression);
                                l = j;
                            }
                        }
                    }
                }
                j = l + 1;
            } while (true);
        }
        return applyexp;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Expression validateApplyMap(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        Map map = (Map)procedure;
        boolean flag1 = map.collect;
        applyexp.visitArgs(inlinecalls);
        Expression aexpression[] = applyexp.getArgs();
        int i = aexpression.length;
        if (i < 2)
        {
            return applyexp;
        }
        i--;
        type = aexpression[0];
        LetExp letexp;
        LambdaExp lambdaexp;
        Declaration declaration;
        Declaration adeclaration[];
        LetExp letexp1;
        Object obj;
        Declaration adeclaration1[];
        boolean flag;
        int j;
        if (!type.side_effects())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        procedure = new LetExp(new Expression[] {
            type
        });
        obj = procedure.addDeclaration("%proc", Compilation.typeProcedure);
        ((Declaration) (obj)).noteValue(aexpression[0]);
        applyexp = new Expression[1];
        letexp = new LetExp(applyexp);
        procedure.setBody(letexp);
        if (flag1)
        {
            j = i + 1;
        } else
        {
            j = i;
        }
        lambdaexp = new LambdaExp(j);
        applyexp[0] = lambdaexp;
        declaration = letexp.addDeclaration("%loop");
        declaration.noteValue(lambdaexp);
        applyexp = new Expression[i];
        letexp1 = new LetExp(applyexp);
        adeclaration = new Declaration[i];
        adeclaration1 = new Declaration[i];
        for (j = 0; j < i; j++)
        {
            String s = (new StringBuilder()).append("arg").append(j).toString();
            adeclaration[j] = lambdaexp.addDeclaration(s);
            adeclaration1[j] = letexp1.addDeclaration(s, Compilation.typePair);
            applyexp[j] = new ReferenceExp(adeclaration[j]);
            adeclaration1[j].noteValue(applyexp[j]);
        }

        Expression aexpression2[];
        Expression aexpression3[];
        if (flag1)
        {
            applyexp = lambdaexp.addDeclaration("result");
        } else
        {
            applyexp = null;
        }
        aexpression3 = new Expression[i + 1];
        if (flag1)
        {
            j = i + 1;
        } else
        {
            j = i;
        }
        aexpression2 = new Expression[j];
        for (j = 0; j < i; j++)
        {
            aexpression3[j + 1] = inlinecalls.visitApplyOnly(SlotGet.makeGetField(new ReferenceExp(adeclaration1[j]), "car"), null);
            aexpression2[j] = inlinecalls.visitApplyOnly(SlotGet.makeGetField(new ReferenceExp(adeclaration1[j]), "cdr"), null);
        }

        if (!flag)
        {
            type = new ReferenceExp(((Declaration) (obj)));
        }
        aexpression3[0] = type;
        obj = inlinecalls.visitApplyOnly(new ApplyExp(new ReferenceExp(map.applyFieldDecl), aexpression3), null);
        if (flag1)
        {
            type = new ReferenceExp(applyexp);
            aexpression2[i] = Invoke.makeInvokeStatic(Compilation.typePair, "make", new Expression[] {
                obj, type
            });
        }
        type = inlinecalls.visitApplyOnly(new ApplyExp(new ReferenceExp(declaration), aexpression2), null);
        Expression aexpression1[];
        if (!flag1)
        {
            type = new BeginExp(((Expression) (obj)), type);
        }
        lambdaexp.body = type;
        letexp1.setBody(lambdaexp.body);
        lambdaexp.body = letexp1;
        if (flag1)
        {
            j = i + 1;
        } else
        {
            j = i;
        }
        aexpression1 = new Expression[j];
        obj = new QuoteExp(LList.Empty);
        j = i;
        do
        {
            j--;
            if (j < 0)
            {
                break;
            }
            ReferenceExp referenceexp = new ReferenceExp(adeclaration[j]);
            if (flag1)
            {
                type = new ReferenceExp(applyexp);
            } else
            {
                type = QuoteExp.voidExp;
            }
            lambdaexp.body = new IfExp(inlinecalls.visitApplyOnly(new ApplyExp(map.isEq, new Expression[] {
                referenceexp, obj
            }), null), type, lambdaexp.body);
            aexpression1[j] = aexpression[j + 1];
        } while (true);
        if (flag1)
        {
            aexpression1[i] = ((Expression) (obj));
        }
        inlinecalls = inlinecalls.visitApplyOnly(new ApplyExp(new ReferenceExp(declaration), aexpression1), null);
        applyexp = inlinecalls;
        if (flag1)
        {
            applyexp = Invoke.makeInvokeStatic(Compilation.scmListType, "reverseInPlace", new Expression[] {
                inlinecalls
            });
        }
        letexp.setBody(applyexp);
        if (flag)
        {
            return letexp;
        } else
        {
            return procedure;
        }
    }

    public static Expression validateApplyNot(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        applyexp.setType(inlinecalls.getCompilation().getLanguage().getTypeFor(Boolean.TYPE));
        return applyexp.inlineIfConstant(procedure, inlinecalls);
    }

    public static Expression validateApplyValuesMap(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        type = ValuesMap.canInline(applyexp, (ValuesMap)procedure);
        if (type != null)
        {
            type.setInlineOnly(true);
            type.returnContinuation = applyexp;
            type.inlineHome = inlinecalls.getCurrentLambda();
        }
        return applyexp;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        switch (code)
        {
        default:
            throw new Error();

        case 2: // '\002'
            compileConvert((Convert)proc, applyexp, compilation, target);
            return;

        case 3: // '\003'
            compileNot((Not)proc, applyexp, compilation, target);
            break;
        }
    }

    public void compileNot(Not not, ApplyExp applyexp, Compilation compilation, Target target)
    {
        applyexp = applyexp.getArgs()[0];
        not = not.language;
        if (target instanceof ConditionalTarget)
        {
            target = (ConditionalTarget)target;
            not = new ConditionalTarget(((ConditionalTarget) (target)).ifFalse, ((ConditionalTarget) (target)).ifTrue, not);
            boolean flag;
            if (!((ConditionalTarget) (target)).trueBranchComesFirst)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            not.trueBranchComesFirst = flag;
            applyexp.compile(compilation, not);
            return;
        }
        CodeAttr codeattr = compilation.getCode();
        Type type = target.getType();
        if ((target instanceof StackTarget) && type.getSignature().charAt(0) == 'Z')
        {
            applyexp.compile(compilation, target);
            codeattr.emitNot(target.getType());
            return;
        } else
        {
            QuoteExp quoteexp = QuoteExp.getInstance(not.booleanObject(true));
            IfExp.compile(applyexp, QuoteExp.getInstance(not.booleanObject(false)), quoteexp, compilation, target);
            return;
        }
    }

}
