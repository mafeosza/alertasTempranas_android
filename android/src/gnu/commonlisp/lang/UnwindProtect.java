// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.expr.Expression;
import gnu.expr.TryExp;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class UnwindProtect extends Syntax
{

    public UnwindProtect()
    {
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        if (!(obj instanceof Pair))
        {
            return translator.syntaxError("invalid syntax for unwind-protect");
        } else
        {
            obj = (Pair)obj;
            return new TryExp(translator.rewrite(((Pair) (obj)).getCar()), translator.rewrite_body(((Pair) (obj)).getCdr()));
        }
    }
}
