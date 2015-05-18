// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ExpVisitor, Expression

public abstract class ExpExpVisitor extends ExpVisitor
{

    public ExpExpVisitor()
    {
    }

    protected Expression defaultValue(Expression expression, Object obj)
    {
        return expression;
    }

    protected volatile Object defaultValue(Expression expression, Object obj)
    {
        return defaultValue(expression, obj);
    }

    protected Expression update(Expression expression, Expression expression1)
    {
        return expression1;
    }

    protected volatile Expression update(Expression expression, Object obj)
    {
        return update(expression, (Expression)obj);
    }
}
