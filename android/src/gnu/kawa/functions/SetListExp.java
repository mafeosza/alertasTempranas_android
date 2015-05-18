// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.Invoke;

class SetListExp extends ApplyExp
{

    public SetListExp(Expression expression, Expression aexpression[])
    {
        super(expression, aexpression);
    }

    public Expression validateApply(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Declaration declaration)
    {
        applyexp.visitArgs(inlinecalls);
        declaration = applyexp.getArgs();
        if (declaration.length == 2)
        {
            applyexp = getArgs()[0];
            QuoteExp quoteexp = QuoteExp.getInstance("set");
            Expression expression = Compilation.makeCoercion(declaration[0], Type.intType);
            declaration = declaration[1];
            applyexp = Compilation.makeCoercion(inlinecalls.visitApplyOnly(new ApplyExp(Invoke.invoke, new Expression[] {
                applyexp, quoteexp, expression, declaration
            }), type), Type.voidType);
        }
        return applyexp;
    }
}
