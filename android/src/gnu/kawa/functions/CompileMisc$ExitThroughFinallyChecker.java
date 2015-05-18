// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Declaration;
import gnu.expr.ExpVisitor;
import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.expr.TryExp;

// Referenced classes of package gnu.kawa.functions:
//            CompileMisc

static class  extends ExpVisitor
{

    Declaration decl;

    public static boolean check(Declaration declaration, Expression expression)
    {
          = new <init>();
        .decl = declaration;
        .visit(expression, null);
        return .exitValue != null;
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

    ()
    {
    }
}
