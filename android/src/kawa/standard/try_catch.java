// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.CatchClause;
import gnu.expr.Compilation;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.TryExp;
import gnu.lists.FVector;
import kawa.lang.Lambda;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            SchemeCompilation

public class try_catch
{

    public try_catch()
    {
    }

    public static Expression rewrite(Object obj, Object obj1)
    {
        Translator translator = (Translator)Compilation.getCurrent();
        Expression expression = translator.rewrite(obj);
        Object obj2 = null;
        obj = null;
        FVector fvector = (FVector)obj1;
        int j = fvector.size();
        int i = 0;
        obj1 = obj2;
        while (i < j) 
        {
            Object obj3 = SchemeCompilation.lambda.rewrite(fvector.get(i), translator);
            if (obj3 instanceof ErrorExp)
            {
                return ((Expression) (obj3));
            }
            if (!(obj3 instanceof LambdaExp))
            {
                return translator.syntaxError("internal error with try-catch");
            }
            obj3 = new CatchClause((LambdaExp)obj3);
            if (obj1 == null)
            {
                obj = obj3;
            } else
            {
                ((CatchClause) (obj1)).setNext(((CatchClause) (obj3)));
            }
            obj1 = obj3;
            i++;
        }
        if (expression instanceof ErrorExp)
        {
            return expression;
        } else
        {
            obj1 = new TryExp(expression, null);
            ((TryExp) (obj1)).setCatchClauses(((CatchClause) (obj)));
            return ((Expression) (obj1));
        }
    }
}
