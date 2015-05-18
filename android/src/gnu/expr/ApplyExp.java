// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.kawa.util.IdentityHashTable;
import gnu.mapping.CallContext;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.text.SourceMessages;

// Referenced classes of package gnu.expr:
//            Expression, QuoteExp, PrimProcedure, Inlineable, 
//            LambdaExp, IgnoreTarget, ReferenceExp, Declaration, 
//            Compilation, Target, ConsumerTarget, StackTarget, 
//            SetExp, InlineCalls, ExpVisitor

public class ApplyExp extends Expression
{

    public static final int INLINE_IF_CONSTANT = 4;
    public static final int MAY_CONTAIN_BACK_JUMP = 8;
    public static final int TAILCALL = 2;
    Expression args[];
    LambdaExp context;
    Expression func;
    public ApplyExp nextCall;
    protected Type type;

    public ApplyExp(Method method, Expression aexpression[])
    {
        func = new QuoteExp(new PrimProcedure(method));
        args = aexpression;
    }

    public ApplyExp(Expression expression, Expression aexpression[])
    {
        func = expression;
        args = aexpression;
    }

    public ApplyExp(Procedure procedure, Expression aexpression[])
    {
        func = new QuoteExp(procedure);
        args = aexpression;
    }

    public static Inlineable asInlineable(Procedure procedure)
    {
        if (procedure instanceof Inlineable)
        {
            return (Inlineable)procedure;
        } else
        {
            return (Inlineable)Procedure.compilerKey.get(procedure);
        }
    }

    public static void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        compile(applyexp, compilation, target, false);
    }

    static void compile(ApplyExp applyexp, Compilation compilation, Target target, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Expression expression;
        int i1;
        i1 = applyexp.args.length;
        expression = applyexp.func;
        obj5 = null;
        obj = null;
        obj3 = null;
        obj1 = null;
        obj2 = null;
        obj4 = null;
        if (!(expression instanceof LambdaExp)) goto _L2; else goto _L1
_L1:
        obj3 = (LambdaExp)expression;
        obj = obj3;
        if (((LambdaExp) (obj3)).getName() != null) goto _L4; else goto _L3
_L3:
        obj1 = null;
        obj = obj3;
_L11:
        if (!flag || !(obj1 instanceof Procedure)) goto _L6; else goto _L5
_L5:
        obj3 = (Procedure)obj1;
        if (!(target instanceof IgnoreTarget) || !((Procedure) (obj3)).isSideEffectFree()) goto _L8; else goto _L7
_L7:
        for (int i = 0; i < i1; i++)
        {
            applyexp.args[i].compile(compilation, target);
        }

          goto _L9
_L2:
        if (expression instanceof ReferenceExp)
        {
            obj2 = (ReferenceExp)expression;
            obj1 = ((ReferenceExp) (obj2)).contextDecl();
            obj2 = ((ReferenceExp) (obj2)).binding;
            do
            {
label0:
                {
                    if (obj2 != null && ((Declaration) (obj2)).isAlias() && (((Declaration) (obj2)).value instanceof ReferenceExp))
                    {
                        obj3 = (ReferenceExp)((Declaration) (obj2)).value;
                        if (obj1 == null && !((Declaration) (obj2)).needsContext() && ((ReferenceExp) (obj3)).binding != null)
                        {
                            break label0;
                        }
                    }
                    obj3 = obj4;
                    if (!((Declaration) (obj2)).getFlag(0x10000L))
                    {
                        Expression expression1 = ((Declaration) (obj2)).getValue();
                        ((Declaration) (obj2)).getName();
                        obj2 = obj5;
                        if (expression1 != null)
                        {
                            obj2 = obj5;
                            if (expression1 instanceof LambdaExp)
                            {
                                obj2 = (LambdaExp)expression1;
                            }
                        }
                        obj = obj2;
                        obj3 = obj4;
                        if (expression1 != null)
                        {
                            obj = obj2;
                            obj3 = obj4;
                            if (expression1 instanceof QuoteExp)
                            {
                                obj3 = ((QuoteExp)expression1).getValue();
                                obj = obj2;
                            }
                        }
                    }
                    obj2 = obj1;
                    obj1 = obj3;
                    continue; /* Loop/switch isn't completed */
                }
                obj2 = ((ReferenceExp) (obj3)).binding;
                obj1 = ((ReferenceExp) (obj3)).contextDecl();
            } while (true);
        }
        obj = obj3;
        if (expression instanceof QuoteExp)
        {
            obj3 = ((QuoteExp)expression).getValue();
            obj = obj1;
            obj1 = obj3;
            continue; /* Loop/switch isn't completed */
        }
          goto _L4
_L8:
        try
        {
            flag = inlineCompile(((Procedure) (obj3)), applyexp, compilation, target);
        }
        // Misplaced declaration of an exception variable
        catch (ApplyExp applyexp)
        {
            compilation.getMessages().error('e', (new StringBuilder()).append("caught exception in inline-compiler for ").append(obj1).append(" - ").append(applyexp).toString(), applyexp);
            return;
        }
        if (!flag) goto _L6; else goto _L9
_L9:
        return;
_L6:
        int k;
        obj3 = compilation.getCode();
        if (obj != null)
        {
            if (((LambdaExp) (obj)).max_args >= 0 && i1 > ((LambdaExp) (obj)).max_args || i1 < ((LambdaExp) (obj)).min_args)
            {
                throw new Error((new StringBuilder()).append("internal error - wrong number of parameters for ").append(obj).toString());
            }
            int j = ((LambdaExp) (obj)).getCallConvention();
            if (compilation.inlineOk(((Expression) (obj))) && (j <= 2 || j == 3 && !applyexp.isTailCall()))
            {
                Method method = ((LambdaExp) (obj)).getMethod(i1);
                if (method != null)
                {
                    obj1 = new PrimProcedure(method, ((LambdaExp) (obj)));
                    flag = method.getStaticFlag();
                    boolean flag1 = false;
                    boolean flag2 = false;
                    if (!flag || ((LambdaExp) (obj)).declareClosureEnv() != null)
                    {
                        flag1 = flag2;
                        if (flag)
                        {
                            flag1 = true;
                        }
                        if (compilation.curLambda == obj)
                        {
                            if (((LambdaExp) (obj)).closureEnv != null)
                            {
                                obj = ((LambdaExp) (obj)).closureEnv;
                            } else
                            {
                                obj = ((LambdaExp) (obj)).thisVariable;
                            }
                            ((CodeAttr) (obj3)).emitLoad(((Variable) (obj)));
                        } else
                        if (obj2 != null)
                        {
                            ((Declaration) (obj2)).load(null, 0, compilation, Target.pushObject);
                        } else
                        {
                            ((LambdaExp) (obj)).getOwningLambda().loadHeapFrame(compilation);
                        }
                    }
                    if (flag1)
                    {
                        obj = Type.voidType;
                    } else
                    {
                        obj = null;
                    }
                    ((PrimProcedure) (obj1)).compile(((Type) (obj)), applyexp, compilation, target);
                    return;
                }
            }
        }
        if (applyexp.isTailCall() && obj != null && obj == compilation.curLambda)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        if (obj != null && ((LambdaExp) (obj)).getInlineOnly() && k == 0 && ((LambdaExp) (obj)).min_args == i1)
        {
            pushArgs(((LambdaExp) (obj)), applyexp.args, null, compilation);
            if (((LambdaExp) (obj)).getFlag(128))
            {
                popParams(((CodeAttr) (obj3)), ((LambdaExp) (obj)), null, false);
                ((CodeAttr) (obj3)).emitTailCall(false, ((LambdaExp) (obj)).getVarScope());
                return;
            } else
            {
                obj.flags = ((LambdaExp) (obj)).flags | 0x80;
                applyexp = compilation.curLambda;
                compilation.curLambda = ((LambdaExp) (obj));
                ((LambdaExp) (obj)).allocChildClasses(compilation);
                ((LambdaExp) (obj)).allocParameters(compilation);
                popParams(((CodeAttr) (obj3)), ((LambdaExp) (obj)), null, false);
                ((LambdaExp) (obj)).enterFunction(compilation);
                ((LambdaExp) (obj)).body.compileWithPosition(compilation, target);
                ((LambdaExp) (obj)).compileEnd(compilation);
                ((LambdaExp) (obj)).generateApplyMethods(compilation);
                ((CodeAttr) (obj3)).popScope();
                compilation.curLambda = applyexp;
                return;
            }
        }
        if (compilation.curLambda.isHandlingTailCalls() && (applyexp.isTailCall() || (target instanceof ConsumerTarget)) && !compilation.curLambda.getInlineOnly())
        {
            obj = Compilation.typeCallContext;
            expression.compile(compilation, new StackTarget(Compilation.typeProcedure));
            if (i1 <= 4)
            {
                for (k = 0; k < i1; k++)
                {
                    applyexp.args[k].compileWithPosition(compilation, Target.pushObject);
                }

                compilation.loadCallContext();
                ((CodeAttr) (obj3)).emitInvoke(Compilation.typeProcedure.getDeclaredMethod((new StringBuilder()).append("check").append(i1).toString(), i1 + 1));
            } else
            {
                compileToArray(applyexp.args, compilation);
                compilation.loadCallContext();
                ((CodeAttr) (obj3)).emitInvoke(Compilation.typeProcedure.getDeclaredMethod("checkN", 2));
            }
            if (applyexp.isTailCall())
            {
                ((CodeAttr) (obj3)).emitReturn();
                return;
            }
            if (((ConsumerTarget)target).isContextTarget())
            {
                compilation.loadCallContext();
                ((CodeAttr) (obj3)).emitInvoke(((ClassType) (obj)).getDeclaredMethod("runUntilDone", 0));
                return;
            } else
            {
                compilation.loadCallContext();
                ((CodeAttr) (obj3)).emitLoad(((ConsumerTarget)target).getConsumerVariable());
                ((CodeAttr) (obj3)).emitInvoke(((ClassType) (obj)).getDeclaredMethod("runUntilValue", 1));
                return;
            }
        }
        if (k == 0)
        {
            expression.compile(compilation, new StackTarget(Compilation.typeProcedure));
        }
        if (k != 0)
        {
            if (((LambdaExp) (obj)).min_args != ((LambdaExp) (obj)).max_args)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        if (i1 > 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj1 = null;
        if (flag)
        {
            compileToArray(applyexp.args, compilation);
            applyexp = Compilation.applyNmethod;
            break MISSING_BLOCK_LABEL_1176;
        } else
        {
            if (k != 0)
            {
                obj1 = new int[applyexp.args.length];
                pushArgs(((LambdaExp) (obj)), applyexp.args, ((int []) (obj1)), compilation);
                applyexp = null;
                continue;
            }
            int l = 0;
            do
            {
label1:
                {
                    if (l < i1)
                    {
                        applyexp.args[l].compileWithPosition(compilation, Target.pushObject);
                        if (((CodeAttr) (obj3)).reachableHere())
                        {
                            break label1;
                        }
                    }
                    applyexp = Compilation.applymethods[i1];
                    continue;
                }
                l++;
            } while (true);
        }
        do
        {
            if (!((CodeAttr) (obj3)).reachableHere())
            {
                compilation.error('e', "unreachable code");
                return;
            }
            if (k != 0)
            {
                popParams(((CodeAttr) (obj3)), ((LambdaExp) (obj)), ((int []) (obj1)), flag);
                ((CodeAttr) (obj3)).emitTailCall(false, ((LambdaExp) (obj)).getVarScope());
                return;
            } else
            {
                ((CodeAttr) (obj3)).emitInvokeVirtual(applyexp);
                target.compileFromStack(compilation, Type.pointer_type);
                return;
            }
        } while (true);
_L4:
        obj1 = null;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static void compileToArray(Expression aexpression[], Compilation compilation)
    {
        CodeAttr codeattr = compilation.getCode();
        if (aexpression.length == 0)
        {
            codeattr.emitGetStatic(Compilation.noArgsField);
        } else
        {
            codeattr.emitPushInt(aexpression.length);
            codeattr.emitNewArray(Type.pointer_type);
            int i = 0;
            while (i < aexpression.length) 
            {
                Expression expression = aexpression[i];
                if (compilation.usingCPStyle() && !(expression instanceof QuoteExp) && !(expression instanceof ReferenceExp))
                {
                    expression.compileWithPosition(compilation, Target.pushObject);
                    codeattr.emitSwap();
                    codeattr.emitDup(1, 1);
                    codeattr.emitSwap();
                    codeattr.emitPushInt(i);
                    codeattr.emitSwap();
                } else
                {
                    codeattr.emitDup(Compilation.objArrayType);
                    codeattr.emitPushInt(i);
                    expression.compileWithPosition(compilation, Target.pushObject);
                }
                codeattr.emitArrayStore(Type.pointer_type);
                i++;
            }
        }
    }

    static Expression derefFunc(Expression expression)
    {
        Expression expression1 = expression;
        if (expression instanceof ReferenceExp)
        {
            Declaration declaration = Declaration.followAliases(((ReferenceExp)expression).binding);
            expression1 = expression;
            if (declaration != null)
            {
                expression1 = expression;
                if (!declaration.getFlag(0x10000L))
                {
                    expression1 = declaration.getValue();
                }
            }
        }
        return expression1;
    }

    static boolean inlineCompile(Procedure procedure, ApplyExp applyexp, Compilation compilation, Target target)
        throws Throwable
    {
        procedure = asInlineable(procedure);
        if (procedure == null)
        {
            return false;
        } else
        {
            procedure.compile(applyexp, compilation, target);
            return true;
        }
    }

    private static void popParams(CodeAttr codeattr, int i, int j, int ai[], Declaration declaration, Variable variable)
    {
label0:
        {
            if (j > 0)
            {
                Declaration declaration1 = declaration.nextDecl();
                Variable variable1;
                if (declaration.getVariable() == null)
                {
                    variable1 = variable;
                } else
                {
                    variable1 = variable.nextVar();
                }
                popParams(codeattr, i + 1, j - 1, ai, declaration1, variable1);
                if (!declaration.ignorable())
                {
                    if (ai == null || ai[i] == 0x10000)
                    {
                        break label0;
                    }
                    codeattr.emitInc(variable, (short)ai[i]);
                }
            }
            return;
        }
        codeattr.emitStore(variable);
    }

    private static void popParams(CodeAttr codeattr, LambdaExp lambdaexp, int ai[], boolean flag)
    {
        Variable variable1 = lambdaexp.getVarScope().firstVar();
        Declaration declaration = lambdaexp.firstDecl();
        Variable variable = variable1;
        if (variable1 != null)
        {
            variable = variable1;
            if (variable1.getName() == "this")
            {
                variable = variable1.nextVar();
            }
        }
        variable1 = variable;
        if (variable != null)
        {
            variable1 = variable;
            if (variable.getName() == "$ctx")
            {
                variable1 = variable.nextVar();
            }
        }
        variable = variable1;
        if (variable1 != null)
        {
            variable = variable1;
            if (variable1.getName() == "argsArray")
            {
                if (flag)
                {
                    popParams(codeattr, 0, 1, null, declaration, variable1);
                    return;
                }
                variable = variable1.nextVar();
            }
        }
        popParams(codeattr, 0, lambdaexp.min_args, ai, declaration, variable);
    }

    private static void pushArgs(LambdaExp lambdaexp, Expression aexpression[], int ai[], Compilation compilation)
    {
        int i;
        int j;
        lambdaexp = lambdaexp.firstDecl();
        j = aexpression.length;
        i = 0;
_L2:
        Expression expression;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        expression = aexpression[i];
        if (!lambdaexp.ignorable())
        {
            break; /* Loop/switch isn't completed */
        }
        expression.compile(compilation, Target.Ignore);
_L5:
        lambdaexp = lambdaexp.nextDecl();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (ai == null) goto _L4; else goto _L3
_L3:
        int k;
        k = SetExp.canUseInc(expression, lambdaexp);
        ai[i] = k;
        if (k != 0x10000) goto _L5; else goto _L4
_L4:
        expression.compileWithPosition(compilation, StackTarget.getInstance(lambdaexp.getType()));
          goto _L5
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object obj = func.eval(callcontext);
        int j = args.length;
        Object aobj[] = new Object[j];
        for (int i = 0; i < j; i++)
        {
            aobj[i] = args[i].eval(callcontext);
        }

        ((Procedure)obj).checkN(aobj, callcontext);
    }

    public void compile(Compilation compilation, Target target)
    {
        compile(this, compilation, target, true);
    }

    public Expression deepCopy(IdentityHashTable identityhashtable)
    {
        Expression expression = deepCopy(func, identityhashtable);
        identityhashtable = deepCopy(args, identityhashtable);
        if (expression == null && func != null || identityhashtable == null && args != null)
        {
            return null;
        } else
        {
            identityhashtable = new ApplyExp(expression, identityhashtable);
            identityhashtable.flags = getFlags();
            return identityhashtable;
        }
    }

    public Expression getArg(int i)
    {
        return args[i];
    }

    public final int getArgCount()
    {
        return args.length;
    }

    public final Expression[] getArgs()
    {
        return args;
    }

    public final Expression getFunction()
    {
        return func;
    }

    public final Object getFunctionValue()
    {
        if (func instanceof QuoteExp)
        {
            return ((QuoteExp)func).getValue();
        } else
        {
            return null;
        }
    }

    public final Type getType()
    {
        Object obj;
        if (type != null)
        {
            return type;
        }
        obj = derefFunc(func);
        type = Type.objectType;
        if (!(obj instanceof QuoteExp)) goto _L2; else goto _L1
_L1:
        obj = ((QuoteExp)obj).getValue();
        if (obj instanceof Procedure)
        {
            type = ((Procedure)obj).getReturnType(args);
        }
_L4:
        return type;
_L2:
        if (obj instanceof LambdaExp)
        {
            type = ((LambdaExp)obj).getReturnType();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Type getTypeRaw()
    {
        return type;
    }

    public final Expression inlineIfConstant(Procedure procedure, InlineCalls inlinecalls)
    {
        return inlineIfConstant(procedure, inlinecalls.getMessages());
    }

    public final Expression inlineIfConstant(Procedure procedure, SourceMessages sourcemessages)
    {
        Object aobj[];
        int i;
        i = args.length;
        aobj = new Object[i];
_L10:
        i--;
        if (i < 0) goto _L2; else goto _L1
_L1:
        Object obj;
        Expression expression;
        expression = args[i];
        obj = expression;
        if (!(expression instanceof ReferenceExp)) goto _L4; else goto _L3
_L3:
        Declaration declaration;
        declaration = ((ReferenceExp)expression).getBinding();
        obj = expression;
        if (declaration == null) goto _L4; else goto _L5
_L5:
        expression = declaration.getValue();
        obj = expression;
        if (expression != QuoteExp.undefined_exp) goto _L4; else goto _L6
_L6:
        return this;
_L4:
        if (!(obj instanceof QuoteExp)) goto _L6; else goto _L7
_L7:
        aobj[i] = ((QuoteExp)obj).getValue();
        continue; /* Loop/switch isn't completed */
_L2:
        obj = new QuoteExp(procedure.applyN(aobj), type);
        return ((Expression) (obj));
        Throwable throwable;
        throwable;
        if (sourcemessages == null) goto _L6; else goto _L8
_L8:
        sourcemessages.error('w', (new StringBuilder()).append("call to ").append(procedure).append(" throws ").append(throwable).toString());
        return this;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public final boolean isTailCall()
    {
        return getFlag(2);
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Apply", ")", 2);
        if (isTailCall())
        {
            outport.print(" [tailcall]");
        }
        if (type != null && type != Type.pointer_type)
        {
            outport.print(" => ");
            outport.print(type);
        }
        outport.writeSpaceFill();
        printLineColumn(outport);
        func.print(outport);
        for (int i = 0; i < args.length; i++)
        {
            outport.writeSpaceLinear();
            args[i].print(outport);
        }

        outport.endLogicalBlock(")");
    }

    public void setArg(int i, Expression expression)
    {
        args[i] = expression;
    }

    public void setArgs(Expression aexpression[])
    {
        args = aexpression;
    }

    public void setFunction(Expression expression)
    {
        func = expression;
    }

    public final void setTailCall(boolean flag)
    {
        setFlag(flag, 2);
    }

    public final void setType(Type type1)
    {
        type = type1;
    }

    public boolean side_effects()
    {
        Object obj = derefFunc(func).valueIfConstant();
        if (!(obj instanceof Procedure) || !((Procedure)obj).isSideEffectFree()) goto _L2; else goto _L1
_L1:
        Expression aexpression[];
        int i;
        int j;
        aexpression = args;
        j = aexpression.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!aexpression[i].side_effects()) goto _L3; else goto _L2
_L2:
        return true;
_L3:
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        return false;
    }

    public String toString()
    {
        if (this == LambdaExp.unknownContinuation)
        {
            return "ApplyExp[unknownContinuation]";
        }
        StringBuilder stringbuilder = (new StringBuilder()).append("ApplyExp/");
        int i;
        if (args == null)
        {
            i = 0;
        } else
        {
            i = args.length;
        }
        return stringbuilder.append(i).append('[').append(func).append(']').toString();
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitApplyExp(this, obj);
    }

    public void visitArgs(InlineCalls inlinecalls)
    {
        args = inlinecalls.visitExps(args, args.length, null);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        func = expvisitor.visitAndUpdate(func, obj);
        if (expvisitor.exitValue == null)
        {
            args = expvisitor.visitExps(args, args.length, obj);
        }
    }
}
