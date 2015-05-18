// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.LetExp;
import gnu.expr.QuoteExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Macro;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class let_syntax extends Syntax
{

    public static final let_syntax let_syntax = new let_syntax(false, "let-syntax");
    public static final let_syntax letrec_syntax = new let_syntax(true, "letrec-syntax");
    boolean recursive;

    public let_syntax(boolean flag, String s)
    {
        super(s);
        recursive = flag;
    }

    private void push(LetExp letexp, Translator translator, Stack stack)
    {
        translator.push(letexp);
        if (stack != null)
        {
            int i = stack.size();
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                translator.pushRenamedAlias((Declaration)stack.pop());
            } while (true);
        }
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        if (!(obj instanceof Pair))
        {
            return translator.syntaxError("missing let-syntax arguments");
        }
        Object obj1 = (Pair)obj;
        obj = ((Pair) (obj1)).getCar();
        Object obj6 = ((Pair) (obj1)).getCdr();
        int i1 = Translator.listLength(obj);
        if (i1 < 0)
        {
            return translator.syntaxError("bindings not a proper list");
        }
        obj1 = null;
        int i = 0;
        Expression aexpression[] = new Expression[i1];
        Declaration adeclaration[] = new Declaration[i1];
        Macro amacro[] = new Macro[i1];
        Pair apair[] = new Pair[i1];
        SyntaxForm asyntaxform[] = new SyntaxForm[i1];
        LetExp letexp = new LetExp(aexpression);
        SyntaxForm syntaxform = null;
        int j = 0;
        while (j < i1) 
        {
            Object obj2;
            for (obj2 = obj; obj2 instanceof SyntaxForm; obj2 = syntaxform.getDatum())
            {
                syntaxform = (SyntaxForm)obj2;
            }

            obj = syntaxform;
            Pair pair = (Pair)obj2;
            Object obj3 = pair.getCar();
            obj2 = obj3;
            if (obj3 instanceof SyntaxForm)
            {
                obj = (SyntaxForm)obj3;
                obj2 = ((SyntaxForm) (obj)).getDatum();
            }
            if (!(obj2 instanceof Pair))
            {
                return translator.syntaxError((new StringBuilder()).append(getName()).append(" binding is not a pair").toString());
            }
            obj2 = (Pair)obj2;
            Object obj4 = ((Pair) (obj2)).getCar();
            obj3 = obj;
            for (; obj4 instanceof SyntaxForm; obj4 = ((SyntaxForm) (obj3)).getDatum())
            {
                obj3 = (SyntaxForm)obj4;
            }

            if (!(obj4 instanceof String) && !(obj4 instanceof Symbol))
            {
                return translator.syntaxError((new StringBuilder()).append("variable in ").append(getName()).append(" binding is not a symbol").toString());
            }
            Object obj5 = ((Pair) (obj2)).getCdr();
            obj2 = obj;
            for (; obj5 instanceof SyntaxForm; obj5 = ((SyntaxForm) (obj2)).getDatum())
            {
                obj2 = (SyntaxForm)obj5;
            }

            if (!(obj5 instanceof Pair))
            {
                return translator.syntaxError((new StringBuilder()).append(getName()).append(" has no value for '").append(obj4).append("'").toString());
            }
            obj = (Pair)obj5;
            if (((Pair) (obj)).getCdr() != LList.Empty)
            {
                return translator.syntaxError((new StringBuilder()).append("let binding for '").append(obj4).append("' is improper list").toString());
            }
            obj4 = new Declaration(obj4);
            obj5 = Macro.make(((Declaration) (obj4)));
            amacro[j] = ((Macro) (obj5));
            apair[j] = ((Pair) (obj));
            asyntaxform[j] = ((SyntaxForm) (obj2));
            letexp.addDeclaration(((Declaration) (obj4)));
            int l;
            if (obj3 == null)
            {
                obj = null;
            } else
            {
                obj = ((SyntaxForm) (obj3)).getScope();
            }
            obj3 = obj1;
            l = i;
            if (obj != null)
            {
                obj3 = translator.makeRenamedAlias(((Declaration) (obj4)), ((gnu.expr.ScopeExp) (obj)));
                obj = obj1;
                if (obj1 == null)
                {
                    obj = new Stack();
                }
                ((Stack) (obj)).push(obj3);
                l = i + 1;
                obj3 = obj;
            }
            if (obj2 != null)
            {
                obj = ((SyntaxForm) (obj2)).getScope();
            } else
            if (recursive)
            {
                obj = letexp;
            } else
            {
                obj = translator.currentScope();
            }
            ((Macro) (obj5)).setCapturedScope(((gnu.expr.ScopeExp) (obj)));
            adeclaration[j] = ((Declaration) (obj4));
            aexpression[j] = QuoteExp.nullExp;
            obj = pair.getCdr();
            j++;
            obj1 = obj3;
            i = l;
        }
        if (recursive)
        {
            push(letexp, translator, ((Stack) (obj1)));
        }
        obj = translator.currentMacroDefinition;
        for (int k = 0; k < i1; k++)
        {
            Macro macro = amacro[k];
            translator.currentMacroDefinition = macro;
            Expression expression = translator.rewrite_car(apair[k], asyntaxform[k]);
            aexpression[k] = expression;
            Declaration declaration = adeclaration[k];
            macro.expander = expression;
            declaration.noteValue(new QuoteExp(macro));
            if (expression instanceof LambdaExp)
            {
                LambdaExp lambdaexp = (LambdaExp)expression;
                lambdaexp.nameDecl = declaration;
                lambdaexp.setSymbol(declaration.getSymbol());
            }
        }

        translator.currentMacroDefinition = ((Macro) (obj));
        if (!recursive)
        {
            push(letexp, translator, ((Stack) (obj1)));
        }
        obj = translator.rewrite_body(obj6);
        translator.pop(letexp);
        translator.popRenamedAlias(i);
        return ((Expression) (obj));
    }

}
