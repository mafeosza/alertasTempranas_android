// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ExpVisitor, Expression, ApplyExp, LetExp, 
//            FluidLetExp, BeginExp

public class PushApply extends ExpVisitor
{

    public PushApply()
    {
    }

    public static void pushApply(Expression expression)
    {
        (new PushApply()).visit(expression, null);
    }

    protected Expression defaultValue(Expression expression, Void void1)
    {
        return expression;
    }

    protected volatile Object defaultValue(Expression expression, Object obj)
    {
        return defaultValue(expression, (Void)obj);
    }

    protected Expression update(Expression expression, Expression expression1)
    {
        return expression1;
    }

    protected volatile Expression update(Expression expression, Object obj)
    {
        return update(expression, (Expression)obj);
    }

    protected Expression visitApplyExp(ApplyExp applyexp, Void void1)
    {
        Object obj = applyexp.func;
        if ((obj instanceof LetExp) && !(obj instanceof FluidLetExp))
        {
            obj = (LetExp)obj;
            Expression expression = ((LetExp) (obj)).body;
            obj.body = applyexp;
            applyexp.func = expression;
            return (Expression)visit(((Expression) (obj)), void1);
        }
        if (obj instanceof BeginExp)
        {
            obj = (BeginExp)obj;
            Expression aexpression[] = ((BeginExp) (obj)).exps;
            int i = ((BeginExp) (obj)).exps.length - 1;
            applyexp.func = aexpression[i];
            aexpression[i] = applyexp;
            return (Expression)visit(((Expression) (obj)), void1);
        } else
        {
            applyexp.visitChildren(this, void1);
            return applyexp;
        }
    }

    protected volatile Object visitApplyExp(ApplyExp applyexp, Object obj)
    {
        return visitApplyExp(applyexp, (Void)obj);
    }
}
