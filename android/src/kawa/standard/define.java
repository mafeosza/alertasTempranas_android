// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            SchemeCompilation

public class define extends Syntax
{

    public static final define defineRaw;
    Lambda lambda;

    public define(Lambda lambda1)
    {
        lambda = lambda1;
    }

    String getName(int i)
    {
        if ((i & 4) != 0)
        {
            return "define-private";
        }
        if ((i & 8) != 0)
        {
            return "define-constant";
        } else
        {
            return "define";
        }
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj1 = (Pair)pair.getCdr();
        pair = (Pair)((Pair) (obj1)).getCdr();
        Object obj = (Pair)((Pair)pair.getCdr()).getCdr();
        obj1 = Translator.stripSyntax(((Pair) (obj1)).getCar());
        int i = ((Number)Translator.stripSyntax(pair.getCar())).intValue();
        boolean flag;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!(obj1 instanceof Declaration))
        {
            pair = translator.syntaxError((new StringBuilder()).append(getName(i)).append(" is only allowed in a <body>").toString());
        } else
        {
            obj1 = (Declaration)obj1;
            if (((Declaration) (obj1)).getFlag(8192L))
            {
                pair = ((Declaration) (obj1)).getTypeExp();
                if (pair instanceof LangExp)
                {
                    ((Declaration) (obj1)).setType(translator.exp2Type((Pair)((LangExp)pair).getLangValue()));
                }
            }
            if ((i & 2) != 0)
            {
                pair = (LambdaExp)((Declaration) (obj1)).getValue();
                obj = ((Pair) (obj)).getCdr();
                lambda.rewriteBody(pair, obj, translator);
                obj = pair;
                if (!Compilation.inlineOk)
                {
                    ((Declaration) (obj1)).noteValue(null);
                    obj = pair;
                }
            } else
            {
                pair = translator.rewrite(((Pair) (obj)).getCar());
                if ((((Declaration) (obj1)).context instanceof ModuleExp) && !flag && ((Declaration) (obj1)).getCanWrite())
                {
                    obj = null;
                } else
                {
                    obj = pair;
                }
                ((Declaration) (obj1)).noteValue(((Expression) (obj)));
                obj = pair;
            }
            obj = new SetExp(((Declaration) (obj1)), ((Expression) (obj)));
            ((SetExp) (obj)).setDefining(true);
            pair = ((Pair) (obj));
            if (flag)
            {
                pair = ((Pair) (obj));
                if (!(translator.currentScope() instanceof ModuleExp))
                {
                    translator.error('w', (new StringBuilder()).append("define-private not at top level ").append(translator.currentScope()).toString());
                    return ((Expression) (obj));
                }
            }
        }
        return pair;
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        Pair pair2 = (Pair)pair.getCdr();
        Pair pair1 = (Pair)pair2.getCdr();
        Pair pair3 = (Pair)pair1.getCdr();
        Object obj3 = (Pair)pair3.getCdr();
        Object obj = null;
        Object obj1;
        for (obj1 = pair2.getCar(); obj1 instanceof SyntaxForm; obj1 = ((SyntaxForm) (obj)).getDatum())
        {
            obj = (SyntaxForm)obj1;
        }

        int i = ((Number)Translator.stripSyntax(pair1.getCar())).intValue();
        Object obj2;
        Object obj4;
        boolean flag;
        boolean flag1;
        if ((i & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 8) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        translator.currentScope();
        obj2 = translator.namespaceResolve(obj1);
        obj1 = obj2;
        if (!(obj2 instanceof Symbol))
        {
            translator.error('e', (new StringBuilder()).append("'").append(obj2).append("' is not a valid identifier").toString());
            obj1 = null;
        }
        obj2 = translator.pushPositionOf(pair2);
        obj1 = translator.define(obj1, ((SyntaxForm) (obj)), scopeexp);
        translator.popPositionOf(obj2);
        obj4 = ((Declaration) (obj1)).getSymbol();
        if (flag)
        {
            ((Declaration) (obj1)).setFlag(0x1000000L);
            ((Declaration) (obj1)).setPrivate(true);
        }
        if (flag1)
        {
            ((Declaration) (obj1)).setFlag(16384L);
        }
        ((Declaration) (obj1)).setFlag(0x40000L);
        obj = pair1;
        if ((i & 2) != 0)
        {
            LambdaExp lambdaexp = new LambdaExp();
            lambdaexp.setSymbol(obj4);
            if (Compilation.inlineOk)
            {
                ((Declaration) (obj1)).setProcedureDecl(true);
                ((Declaration) (obj1)).setType(Compilation.typeProcedure);
                lambdaexp.nameDecl = ((Declaration) (obj1));
            }
            obj4 = ((Pair) (obj3)).getCar();
            obj3 = ((Pair) (obj3)).getCdr();
            Translator.setLine(lambdaexp, pair2);
            lambda.rewriteFormals(lambdaexp, obj4, translator, null);
            Object obj5 = lambda.rewriteAttrs(lambdaexp, obj3, translator);
            obj = pair1;
            if (obj5 != obj3)
            {
                obj = new Pair(pair1.getCar(), new Pair(pair3.getCar(), new Pair(obj4, obj5)));
            }
            ((Declaration) (obj1)).noteValue(lambdaexp);
        }
        if ((scopeexp instanceof ModuleExp) && !flag && (!Compilation.inlineOk || translator.sharedModuleDefs()))
        {
            ((Declaration) (obj1)).setCanWrite(true);
        }
        if ((i & 1) != 0)
        {
            ((Declaration) (obj1)).setTypeExp(new LangExp(pair3));
            ((Declaration) (obj1)).setFlag(8192L);
        }
        pair = Translator.makePair(pair, this, Translator.makePair(pair2, obj1, obj));
        Translator.setLine(((Declaration) (obj1)), pair2);
        translator.formStack.addElement(pair);
    }

    static 
    {
        defineRaw = new define(SchemeCompilation.lambda);
    }
}
