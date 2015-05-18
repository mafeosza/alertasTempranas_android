// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class constant_fold extends Syntax
{

    public static final constant_fold constant_fold;

    public constant_fold()
    {
    }

    static Object checkConstant(Expression expression, Translator translator)
    {
        translator = null;
        if (expression instanceof QuoteExp)
        {
            translator = ((Translator) (((QuoteExp)expression).getValue()));
        } else
        if (expression instanceof ReferenceExp)
        {
            expression = (ReferenceExp)expression;
            translator = expression.getBinding();
            if (translator == null || translator.getFlag(0x10000L))
            {
                return Environment.user().get(expression.getName(), null);
            } else
            {
                return Declaration.followAliases(translator).getConstantValue();
            }
        }
        return translator;
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        obj = translator.rewrite(obj);
        if (!(obj instanceof ApplyExp))
        {
            return ((Expression) (obj));
        }
        ApplyExp applyexp = (ApplyExp)obj;
        Object obj1 = checkConstant(applyexp.getFunction(), translator);
        if (!(obj1 instanceof Procedure))
        {
            return ((Expression) (obj));
        }
        Expression aexpression[] = applyexp.getArgs();
        int i = aexpression.length;
        Object aobj[] = new Object[i];
        do
        {
            i--;
            if (i < 0)
            {
                break;
            }
            Object obj2 = checkConstant(aexpression[i], translator);
            if (obj2 == null)
            {
                return ((Expression) (obj));
            }
            aobj[i] = obj2;
        } while (true);
        try
        {
            obj = new QuoteExp(((Procedure)obj1).applyN(aobj));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Expression expression = translator.syntaxError("caught exception in constant-fold:");
            translator.syntaxError(((Throwable) (obj)).toString());
            return expression;
        }
        return ((Expression) (obj));
    }

    static 
    {
        constant_fold = new constant_fold();
        constant_fold.setName("constant-fold");
    }
}
