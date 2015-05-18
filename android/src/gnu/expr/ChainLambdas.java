// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ExpExpVisitor, ClassExp, LambdaExp, ScopeExp, 
//            Declaration, Compilation, Expression

public class ChainLambdas extends ExpExpVisitor
{

    public ChainLambdas()
    {
    }

    public static void chainLambdas(Expression expression, Compilation compilation)
    {
        ChainLambdas chainlambdas = new ChainLambdas();
        chainlambdas.setContext(compilation);
        chainlambdas.visit(expression, null);
    }

    protected Expression visitClassExp(ClassExp classexp, ScopeExp scopeexp)
    {
        LambdaExp lambdaexp = currentLambda;
        if (lambdaexp != null && !(lambdaexp instanceof ClassExp))
        {
            classexp.nextSibling = lambdaexp.firstChild;
            lambdaexp.firstChild = classexp;
        }
        visitScopeExp(classexp, scopeexp);
        return classexp;
    }

    protected volatile Object visitClassExp(ClassExp classexp, Object obj)
    {
        return visitClassExp(classexp, (ScopeExp)obj);
    }

    protected Expression visitLambdaExp(LambdaExp lambdaexp, ScopeExp scopeexp)
    {
        Object obj = currentLambda;
        if (obj != null && !(obj instanceof ClassExp))
        {
            lambdaexp.nextSibling = ((LambdaExp) (obj)).firstChild;
            obj.firstChild = lambdaexp;
        }
        lambdaexp.outer = scopeexp;
        lambdaexp.firstChild = null;
        lambdaexp.visitChildrenOnly(this, lambdaexp);
        lambdaexp.visitProperties(this, lambdaexp);
        obj = null;
        LambdaExp lambdaexp1;
        for (scopeexp = lambdaexp.firstChild; scopeexp != null; scopeexp = lambdaexp1)
        {
            lambdaexp1 = ((LambdaExp) (scopeexp)).nextSibling;
            scopeexp.nextSibling = ((LambdaExp) (obj));
            obj = scopeexp;
        }

        lambdaexp.firstChild = ((LambdaExp) (obj));
        if (lambdaexp.getName() == null && lambdaexp.nameDecl != null)
        {
            lambdaexp.setName(lambdaexp.nameDecl.getName());
        }
        lambdaexp.setIndexes();
        if (lambdaexp.mustCompile())
        {
            comp.mustCompileHere();
        }
        return lambdaexp;
    }

    protected volatile Object visitLambdaExp(LambdaExp lambdaexp, Object obj)
    {
        return visitLambdaExp(lambdaexp, (ScopeExp)obj);
    }

    protected Expression visitScopeExp(ScopeExp scopeexp, ScopeExp scopeexp1)
    {
        scopeexp.outer = scopeexp1;
        scopeexp.visitChildren(this, scopeexp);
        scopeexp.setIndexes();
        if (scopeexp.mustCompile())
        {
            comp.mustCompileHere();
        }
        return scopeexp;
    }

    protected volatile Object visitScopeExp(ScopeExp scopeexp, Object obj)
    {
        return visitScopeExp(scopeexp, (ScopeExp)obj);
    }
}
