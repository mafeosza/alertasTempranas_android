// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class prog1 extends Syntax
{

    public static final prog1 prog1 = new prog1("prog1", 1);
    public static final prog1 prog2 = new prog1("prog2", 2);
    int index;

    public prog1(String s, int i)
    {
        index = i;
        setName(s);
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        int j = LList.length(obj);
        if (j < index)
        {
            return translator.syntaxError((new StringBuilder()).append("too few expressions in ").append(getName()).toString());
        }
        if (index == 2)
        {
            obj = (Pair)obj;
            return new BeginExp(translator.rewrite(((Pair) (obj)).getCar()), prog1.rewrite(((Pair) (obj)).getCdr(), translator));
        }
        Expression aexpression1[] = new Expression[1];
        LetExp letexp = new LetExp(aexpression1);
        Expression aexpression[] = new Expression[j];
        obj = (Pair)obj;
        aexpression1[0] = translator.rewrite(((Pair) (obj)).getCar());
        obj = ((Pair) (obj)).getCdr();
        for (int i = 0; i < j - 1; i++)
        {
            obj = (Pair)obj;
            aexpression[i] = translator.rewrite(((Pair) (obj)).getCar());
            obj = ((Pair) (obj)).getCdr();
        }

        aexpression[j - 1] = new ReferenceExp(letexp.addDeclaration((Object)null));
        letexp.body = BeginExp.canonicalize(aexpression);
        translator.mustCompileHere();
        return letexp;
    }

}
