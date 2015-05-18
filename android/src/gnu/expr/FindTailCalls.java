// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.kawa.functions.AppendValues;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package gnu.expr:
//            ExpExpVisitor, ScopeExp, Declaration, LambdaExp, 
//            ReferenceExp, ApplyExp, Compilation, ClassExp, 
//            QuoteExp, Expression, BeginExp, BlockExp, 
//            FluidLetExp, IfExp, LetExp, SetExp, 
//            SynchronizedExp, TryExp, CatchClause

public class FindTailCalls extends ExpExpVisitor
{

    public FindTailCalls()
    {
    }

    public static void findTailCalls(Expression expression, Compilation compilation)
    {
        FindTailCalls findtailcalls = new FindTailCalls();
        findtailcalls.setContext(compilation);
        findtailcalls.visit(expression, expression);
    }

    public void postVisitDecls(ScopeExp scopeexp)
    {
        for (scopeexp = scopeexp.firstDecl(); scopeexp != null; scopeexp = scopeexp.nextDecl())
        {
            Object obj = scopeexp.getValue();
            if (obj instanceof LambdaExp)
            {
                LambdaExp lambdaexp = (LambdaExp)obj;
                if (scopeexp.getCanRead())
                {
                    lambdaexp.setCanRead(true);
                }
                if (scopeexp.getCanCall())
                {
                    lambdaexp.setCanCall(true);
                }
            }
            if (!scopeexp.getFlag(1024L) || !(obj instanceof ReferenceExp))
            {
                continue;
            }
            obj = ((ReferenceExp)obj).contextDecl();
            if (obj != null && ((Declaration) (obj)).isPrivate())
            {
                ((Declaration) (obj)).setFlag(0x80000L);
            }
        }

    }

    protected Expression visitApplyExp(ApplyExp applyexp, Expression expression)
    {
        Object obj;
        boolean flag;
        Object obj1;
        if (expression == currentLambda.body)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            applyexp.setTailCall(true);
        }
        applyexp.context = currentLambda;
        obj1 = null;
        if (applyexp.func instanceof ReferenceExp)
        {
            Object obj2 = Declaration.followAliases(((ReferenceExp)applyexp.func).binding);
            obj = obj1;
            if (obj2 != null)
            {
                if (!((Declaration) (obj2)).getFlag(2048L))
                {
                    applyexp.nextCall = ((Declaration) (obj2)).firstCall;
                    obj2.firstCall = applyexp;
                }
                obj = getCompilation();
                ((Declaration) (obj2)).setCanCall();
                if (!((Compilation) (obj)).mustCompile)
                {
                    ((Declaration) (obj2)).setCanRead();
                }
                obj2 = ((Declaration) (obj2)).getValue();
                obj = obj1;
                if (obj2 instanceof LambdaExp)
                {
                    obj = (LambdaExp)obj2;
                }
            }
        } else
        if ((applyexp.func instanceof LambdaExp) && !(applyexp.func instanceof ClassExp))
        {
            obj = (LambdaExp)applyexp.func;
            visitLambdaExp(((LambdaExp) (obj)), false);
            ((LambdaExp) (obj)).setCanCall(true);
        } else
        if ((applyexp.func instanceof QuoteExp) && ((QuoteExp)applyexp.func).getValue() == AppendValues.appendValues)
        {
            obj = obj1;
        } else
        {
            applyexp.func = visitExpression(applyexp.func, applyexp.func);
            obj = obj1;
        }
        break MISSING_BLOCK_LABEL_140;
        if (obj != null && ((LambdaExp) (obj)).returnContinuation != expression && (obj != currentLambda || !flag))
        {
            if (flag)
            {
                if (((LambdaExp) (obj)).tailCallers == null)
                {
                    obj.tailCallers = new HashSet();
                }
                ((LambdaExp) (obj)).tailCallers.add(currentLambda);
            } else
            if (((LambdaExp) (obj)).returnContinuation == null)
            {
                obj.returnContinuation = expression;
                obj.inlineHome = currentLambda;
            } else
            {
                obj.returnContinuation = LambdaExp.unknownContinuation;
                obj.inlineHome = null;
            }
        }
        applyexp.args = visitExps(applyexp.args);
        return applyexp;
    }

    protected volatile Object visitApplyExp(ApplyExp applyexp, Object obj)
    {
        return visitApplyExp(applyexp, (Expression)obj);
    }

    protected Expression visitBeginExp(BeginExp beginexp, Expression expression)
    {
        int j = beginexp.length - 1;
        int i = 0;
        while (i <= j) 
        {
            Expression aexpression[] = beginexp.exps;
            Expression expression2 = beginexp.exps[i];
            Expression expression1;
            if (i == j)
            {
                expression1 = expression;
            } else
            {
                expression1 = beginexp.exps[i];
            }
            aexpression[i] = (Expression)expression2.visit(this, expression1);
            i++;
        }
        return beginexp;
    }

    protected volatile Object visitBeginExp(BeginExp beginexp, Object obj)
    {
        return visitBeginExp(beginexp, (Expression)obj);
    }

    protected Expression visitBlockExp(BlockExp blockexp, Expression expression)
    {
        blockexp.body = (Expression)blockexp.body.visit(this, expression);
        if (blockexp.exitBody != null)
        {
            blockexp.exitBody = (Expression)blockexp.exitBody.visit(this, blockexp.exitBody);
        }
        return blockexp;
    }

    protected volatile Object visitBlockExp(BlockExp blockexp, Object obj)
    {
        return visitBlockExp(blockexp, (Expression)obj);
    }

    protected Expression visitClassExp(ClassExp classexp, Expression expression)
    {
        LambdaExp lambdaexp;
        lambdaexp = currentLambda;
        currentLambda = classexp;
        expression = classexp.firstChild;
_L2:
        if (expression == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (exitValue != null)
        {
            break; /* Loop/switch isn't completed */
        }
        visitLambdaExp(expression, false);
        expression = ((LambdaExp) (expression)).nextSibling;
        if (true) goto _L2; else goto _L1
_L1:
        currentLambda = lambdaexp;
        return classexp;
        classexp;
        currentLambda = lambdaexp;
        throw classexp;
    }

    protected volatile Object visitClassExp(ClassExp classexp, Object obj)
    {
        return visitClassExp(classexp, (Expression)obj);
    }

    protected Expression visitExpression(Expression expression, Expression expression1)
    {
        return (Expression)super.visitExpression(expression, expression);
    }

    protected volatile Object visitExpression(Expression expression, Object obj)
    {
        return visitExpression(expression, (Expression)obj);
    }

    public Expression[] visitExps(Expression aexpression[])
    {
        int j = aexpression.length;
        for (int i = 0; i < j; i++)
        {
            Expression expression = aexpression[i];
            aexpression[i] = (Expression)visit(expression, expression);
        }

        return aexpression;
    }

    protected Expression visitFluidLetExp(FluidLetExp fluidletexp, Expression expression)
    {
        for (expression = fluidletexp.firstDecl(); expression != null; expression = expression.nextDecl())
        {
            expression.setCanRead(true);
            if (((Declaration) (expression)).base != null)
            {
                ((Declaration) (expression)).base.setCanRead(true);
            }
        }

        visitLetDecls(fluidletexp);
        fluidletexp.body = (Expression)fluidletexp.body.visit(this, fluidletexp.body);
        postVisitDecls(fluidletexp);
        return fluidletexp;
    }

    protected volatile Object visitFluidLetExp(FluidLetExp fluidletexp, Object obj)
    {
        return visitFluidLetExp(fluidletexp, (Expression)obj);
    }

    protected Expression visitIfExp(IfExp ifexp, Expression expression)
    {
        ifexp.test = (Expression)ifexp.test.visit(this, ifexp.test);
        ifexp.then_clause = (Expression)ifexp.then_clause.visit(this, expression);
        Expression expression1 = ifexp.else_clause;
        if (expression1 != null)
        {
            ifexp.else_clause = (Expression)expression1.visit(this, expression);
        }
        return ifexp;
    }

    protected volatile Object visitIfExp(IfExp ifexp, Object obj)
    {
        return visitIfExp(ifexp, (Expression)obj);
    }

    protected Expression visitLambdaExp(LambdaExp lambdaexp, Expression expression)
    {
        visitLambdaExp(lambdaexp, true);
        return lambdaexp;
    }

    protected volatile Object visitLambdaExp(LambdaExp lambdaexp, Object obj)
    {
        return visitLambdaExp(lambdaexp, (Expression)obj);
    }

    final void visitLambdaExp(LambdaExp lambdaexp, boolean flag)
    {
        LambdaExp lambdaexp1;
        lambdaexp1 = currentLambda;
        currentLambda = lambdaexp;
        if (flag)
        {
            lambdaexp.setCanRead(true);
        }
        if (lambdaexp.defaultArgs != null)
        {
            lambdaexp.defaultArgs = visitExps(lambdaexp.defaultArgs);
        }
        if (exitValue != null || lambdaexp.body == null) goto _L2; else goto _L1
_L1:
        Expression expression;
        expression = lambdaexp.body;
        if (!lambdaexp.getInlineOnly())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        Object obj = lambdaexp;
_L3:
        lambdaexp.body = (Expression)expression.visit(this, obj);
_L2:
        currentLambda = lambdaexp1;
        postVisitDecls(lambdaexp);
        return;
        obj = lambdaexp.body;
          goto _L3
        lambdaexp;
        currentLambda = lambdaexp1;
        throw lambdaexp;
    }

    void visitLetDecls(LetExp letexp)
    {
        Declaration declaration = letexp.firstDecl();
        int j = letexp.inits.length;
        for (int i = 0; i < j;)
        {
            Expression expression;
label0:
            {
                Expression expression1 = visitSetExp(declaration, letexp.inits[i]);
                expression = expression1;
                if (expression1 != QuoteExp.undefined_exp)
                {
                    break label0;
                }
                Expression expression2 = declaration.getValue();
                if (!(expression2 instanceof LambdaExp))
                {
                    expression = expression1;
                    if (expression2 == expression1)
                    {
                        break label0;
                    }
                    expression = expression1;
                    if (!(expression2 instanceof QuoteExp))
                    {
                        break label0;
                    }
                }
                expression = expression2;
            }
            letexp.inits[i] = expression;
            i++;
            declaration = declaration.nextDecl();
        }

    }

    protected Expression visitLetExp(LetExp letexp, Expression expression)
    {
        visitLetDecls(letexp);
        letexp.body = (Expression)letexp.body.visit(this, expression);
        postVisitDecls(letexp);
        return letexp;
    }

    protected volatile Object visitLetExp(LetExp letexp, Object obj)
    {
        return visitLetExp(letexp, (Expression)obj);
    }

    protected Expression visitReferenceExp(ReferenceExp referenceexp, Expression expression)
    {
        expression = Declaration.followAliases(referenceexp.binding);
        if (expression == null) goto _L2; else goto _L1
_L1:
        Type type = ((Declaration) (expression)).type;
        if (type == null || !type.isVoid()) goto _L4; else goto _L3
_L3:
        expression = QuoteExp.voidExp;
_L6:
        return expression;
_L4:
        expression.setCanRead(true);
_L2:
        Declaration declaration = referenceexp.contextDecl();
        expression = referenceexp;
        if (declaration != null)
        {
            declaration.setCanRead(true);
            return referenceexp;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected volatile Object visitReferenceExp(ReferenceExp referenceexp, Object obj)
    {
        return visitReferenceExp(referenceexp, (Expression)obj);
    }

    final Expression visitSetExp(Declaration declaration, Expression expression)
    {
        if (declaration != null && declaration.getValue() == expression && (expression instanceof LambdaExp) && !(expression instanceof ClassExp) && !declaration.isPublic())
        {
            declaration = (LambdaExp)expression;
            visitLambdaExp(declaration, false);
            return declaration;
        } else
        {
            return (Expression)expression.visit(this, expression);
        }
    }

    protected Expression visitSetExp(SetExp setexp, Expression expression)
    {
        Object obj = setexp.binding;
        expression = ((Expression) (obj));
        if (obj != null)
        {
            expression = ((Expression) (obj));
            if (((Declaration) (obj)).isAlias())
            {
                if (setexp.isDefining())
                {
                    setexp.new_value = (Expression)setexp.new_value.visit(this, setexp.new_value);
                    return setexp;
                }
                expression = Declaration.followAliases(((Declaration) (obj)));
            }
        }
        obj = setexp.contextDecl();
        if (obj != null)
        {
            ((Declaration) (obj)).setCanRead(true);
        }
        obj = visitSetExp(((Declaration) (expression)), setexp.new_value);
        if (expression != null && (((Declaration) (expression)).context instanceof LetExp) && obj == expression.getValue() && ((obj instanceof LambdaExp) || (obj instanceof QuoteExp)))
        {
            return QuoteExp.voidExp;
        } else
        {
            setexp.new_value = ((Expression) (obj));
            return setexp;
        }
    }

    protected volatile Object visitSetExp(SetExp setexp, Object obj)
    {
        return visitSetExp(setexp, (Expression)obj);
    }

    protected Expression visitSynchronizedExp(SynchronizedExp synchronizedexp, Expression expression)
    {
        synchronizedexp.object = (Expression)synchronizedexp.object.visit(this, synchronizedexp.object);
        synchronizedexp.body = (Expression)synchronizedexp.body.visit(this, synchronizedexp.body);
        return synchronizedexp;
    }

    protected volatile Object visitSynchronizedExp(SynchronizedExp synchronizedexp, Object obj)
    {
        return visitSynchronizedExp(synchronizedexp, (Expression)obj);
    }

    protected Expression visitTryExp(TryExp tryexp, Expression expression)
    {
        Object obj;
        if (tryexp.finally_clause == null)
        {
            obj = expression;
        } else
        {
            obj = tryexp.try_clause;
        }
        tryexp.try_clause = (Expression)tryexp.try_clause.visit(this, obj);
        obj = tryexp.catch_clauses;
        while (exitValue == null && obj != null) 
        {
            Expression expression1;
            if (tryexp.finally_clause == null)
            {
                expression1 = expression;
            } else
            {
                expression1 = ((CatchClause) (obj)).body;
            }
            obj.body = (Expression)((CatchClause) (obj)).body.visit(this, expression1);
            obj = ((CatchClause) (obj)).getNext();
        }
        expression = tryexp.finally_clause;
        if (expression != null)
        {
            tryexp.finally_clause = (Expression)expression.visit(this, expression);
        }
        return tryexp;
    }

    protected volatile Object visitTryExp(TryExp tryexp, Object obj)
    {
        return visitTryExp(tryexp, (Expression)obj);
    }
}
