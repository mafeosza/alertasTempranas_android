// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.functions.CompilationHelpers;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            Scheme

public class set_b extends Syntax
{

    public static final set_b set;

    public set_b()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj;
        obj = pair.getCdr();
        pair = null;
        for (; obj instanceof SyntaxForm; obj = pair.getDatum())
        {
            pair = (SyntaxForm)obj;
        }

        if (obj instanceof Pair) goto _L2; else goto _L1
_L1:
        pair = translator.syntaxError("missing name");
_L4:
        return pair;
_L2:
        Object obj1;
label0:
        {
            obj = (Pair)obj;
            obj1 = translator.rewrite_car(((Pair) (obj)), pair);
            for (obj = ((Pair) (obj)).getCdr(); obj instanceof SyntaxForm; obj = pair.getDatum())
            {
                pair = (SyntaxForm)obj;
            }

            if (obj instanceof Pair)
            {
                obj = (Pair)obj;
                if (((Pair) (obj)).getCdr() == LList.Empty)
                {
                    break label0;
                }
            }
            return translator.syntaxError("missing or extra arguments to set!");
        }
        Expression expression = translator.rewrite_car(((Pair) (obj)), pair);
        if (obj1 instanceof ApplyExp)
        {
            pair = (ApplyExp)obj1;
            Expression aexpression[] = pair.getArgs();
            int k = aexpression.length;
            boolean flag = false;
            translator = pair.getFunction();
            pair = translator;
            int j = k;
            int i = ((flag) ? 1 : 0);
            if (aexpression.length > 0)
            {
                pair = translator;
                j = k;
                i = ((flag) ? 1 : 0);
                if (translator instanceof ReferenceExp)
                {
                    pair = translator;
                    j = k;
                    i = ((flag) ? 1 : 0);
                    if (((ReferenceExp)translator).getBinding() == Scheme.applyFieldDecl)
                    {
                        i = 1;
                        j = k - 1;
                        pair = aexpression[0];
                    }
                }
            }
            translator = new Expression[j + 1];
            System.arraycopy(aexpression, i, translator, 0, j);
            translator[j] = expression;
            return new ApplyExp(new ApplyExp(new ReferenceExp(CompilationHelpers.setterDecl), new Expression[] {
                pair
            }), translator);
        }
        if (!(obj1 instanceof ReferenceExp))
        {
            return translator.syntaxError("first set! argument is not a variable name");
        }
        pair = (ReferenceExp)obj1;
        obj1 = pair.getBinding();
        aexpression = new SetExp(pair.getSymbol(), expression);
        aexpression.setContextDecl(pair.contextDecl());
        pair = aexpression;
        if (obj1 != null)
        {
            ((Declaration) (obj1)).setCanWrite(true);
            aexpression.setBinding(((Declaration) (obj1)));
            obj1 = Declaration.followAliases(((Declaration) (obj1)));
            if (obj1 != null)
            {
                ((Declaration) (obj1)).noteValue(expression);
            }
            if (((Declaration) (obj1)).getFlag(16384L))
            {
                return translator.syntaxError((new StringBuilder()).append("constant variable ").append(((Declaration) (obj1)).getName()).append(" is set!").toString());
            }
            pair = aexpression;
            if (((Declaration) (obj1)).context != translator.mainLambda)
            {
                pair = aexpression;
                if (((Declaration) (obj1)).context instanceof ModuleExp)
                {
                    pair = aexpression;
                    if (!((Declaration) (obj1)).getFlag(0x10000000L))
                    {
                        pair = aexpression;
                        if (!((Declaration) (obj1)).context.getFlag(0x100000))
                        {
                            translator.error('w', ((Declaration) (obj1)), "imported variable ", " is set!");
                            return aexpression;
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        set = new set_b();
        set.setName("set!");
    }
}
