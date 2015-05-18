// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.expr.Expression;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class function extends Syntax
{

    Syntax lambda;

    public function(Syntax syntax)
    {
        lambda = syntax;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        pair = ((Pair) (pair.getCdr()));
        if (pair instanceof Pair)
        {
            pair = (Pair)pair;
            if (pair.getCdr() != LList.Empty)
            {
                return translator.syntaxError("too many forms after 'function'");
            }
            pair = ((Pair) (pair.getCar()));
            if ((pair instanceof String) || (pair instanceof Symbol))
            {
                pair = new ReferenceExp(pair);
                pair.setProcedureName(true);
                pair.setFlag(8);
                return pair;
            }
            if (pair instanceof Pair)
            {
                pair = (Pair)pair;
                Object obj = pair.getCar();
                if ((obj instanceof String) ? "lambda".equals(obj) : (obj instanceof Symbol) && "lambda".equals(((Symbol)obj).getName()))
                {
                    return lambda.rewriteForm(pair, translator);
                }
            }
        }
        return translator.syntaxError("function must be followed by name or lambda expression");
    }
}
