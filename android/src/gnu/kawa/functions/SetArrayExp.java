// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.QuoteExp;
import gnu.kawa.reflect.ArraySet;
import gnu.kawa.reflect.Invoke;

class SetArrayExp extends ApplyExp
{

    public static final ClassType typeSetArray = ClassType.make("gnu.kawa.functions.SetArray");
    Type elementType;

    public SetArrayExp(Expression expression, ArrayType arraytype)
    {
        super(Invoke.make, new Expression[] {
            new QuoteExp(typeSetArray), expression
        });
        elementType = arraytype.getComponentType();
    }

    public Expression validateApply(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Declaration declaration)
    {
        applyexp.visitArgs(inlinecalls);
        declaration = applyexp.getArgs();
        if (declaration.length == 2)
        {
            applyexp = getArgs()[1];
            Expression expression = declaration[0];
            declaration = declaration[1];
            applyexp = inlinecalls.visitApplyOnly(new ApplyExp(new ArraySet(elementType), new Expression[] {
                applyexp, expression, declaration
            }), type);
        }
        return applyexp;
    }

}
