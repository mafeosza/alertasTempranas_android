// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.PatternScope;
import kawa.lang.Quote;
import kawa.lang.SyntaxTemplate;
import kawa.lang.Translator;

public class syntax extends Quote
{

    static final Method makeTemplateScopeMethod;
    public static final syntax quasiSyntax = new syntax("quasisyntax", true);
    public static final syntax syntax = new syntax("syntax", false);
    static final ClassType typeTemplateScope;

    public syntax(String s, boolean flag)
    {
        super(s, flag);
    }

    static Expression makeSyntax(Object obj, Translator translator)
    {
        SyntaxTemplate syntaxtemplate = new SyntaxTemplate(obj, null, translator);
        QuoteExp quoteexp = QuoteExp.nullExp;
        PatternScope patternscope = translator.patternScope;
        obj = quoteexp;
        if (patternscope != null)
        {
            obj = quoteexp;
            if (patternscope.matchArray != null)
            {
                obj = new ReferenceExp(patternscope.matchArray);
            }
        }
        quoteexp = new QuoteExp(syntaxtemplate);
        translator = new ReferenceExp(translator.templateScopeDecl);
        return new ApplyExp(ClassType.make("kawa.lang.SyntaxTemplate").getDeclaredMethod("execute", 2), new Expression[] {
            quoteexp, obj, translator
        });
    }

    protected boolean expandColonForms()
    {
        return false;
    }

    protected Expression leaf(Object obj, Translator translator)
    {
        return makeSyntax(obj, translator);
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Declaration declaration;
label0:
        {
            if (pair.getCdr() instanceof Pair)
            {
                pair = (Pair)(Pair)pair.getCdr();
                if (pair.getCdr() == LList.Empty)
                {
                    break label0;
                }
            }
            return translator.syntaxError("syntax forms requires a single form");
        }
        declaration = translator.templateScopeDecl;
        if (declaration == null)
        {
            translator.letStart();
            Object obj = new ApplyExp(makeTemplateScopeMethod, Expression.noExpressions);
            obj = translator.letVariable(null, typeTemplateScope, ((Expression) (obj)));
            ((Declaration) (obj)).setCanRead();
            translator.templateScopeDecl = ((Declaration) (obj));
            translator.letEnter();
        }
        pair = ((Pair) (pair.getCar()));
        Expression expression;
        int i;
        if (isQuasi)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        expression = coerceExpression(expand(pair, i, translator), translator);
        pair = expression;
        if (declaration != null)
        {
            break MISSING_BLOCK_LABEL_132;
        }
        pair = translator.letDone(expression);
        translator.templateScopeDecl = declaration;
        return pair;
        pair;
        translator.templateScopeDecl = declaration;
        throw pair;
    }

    static 
    {
        typeTemplateScope = ClassType.make("kawa.lang.TemplateScope");
        makeTemplateScopeMethod = typeTemplateScope.getDeclaredMethod("make", 0);
    }
}
