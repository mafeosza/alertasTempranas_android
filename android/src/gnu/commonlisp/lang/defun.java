// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LambdaExp;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class defun extends Syntax
{

    Lambda lambdaSyntax;

    public defun(Lambda lambda)
    {
        lambdaSyntax = lambda;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Declaration declaration;
        Object obj;
        obj = pair.getCdr();
        pair = null;
        declaration = null;
        if (!(obj instanceof Pair)) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj = (Pair)obj;
        obj1 = ((Pair) (obj)).getCar();
        if (!(obj1 instanceof Symbol) && !(obj1 instanceof String)) goto _L4; else goto _L3
_L3:
        pair = obj1.toString();
_L5:
        if (pair != null && (((Pair) (obj)).getCdr() instanceof Pair))
        {
            obj1 = (Pair)((Pair) (obj)).getCdr();
            obj = new LambdaExp();
            lambdaSyntax.rewrite(((LambdaExp) (obj)), ((Pair) (obj1)).getCar(), ((Pair) (obj1)).getCdr(), translator, null);
            ((LambdaExp) (obj)).setSymbol(pair);
            if (obj1 instanceof PairWithPosition)
            {
                ((LambdaExp) (obj)).setLocation((PairWithPosition)obj1);
            }
            translator = ((Translator) (obj));
            obj = new SetExp(pair, translator);
            ((SetExp) (obj)).setDefining(true);
            ((SetExp) (obj)).setFuncDef(true);
            if (declaration != null)
            {
                ((SetExp) (obj)).setBinding(declaration);
                pair = translator;
                if (declaration.context instanceof ModuleExp)
                {
                    pair = translator;
                    if (declaration.getCanWrite())
                    {
                        pair = null;
                    }
                }
                declaration.noteValue(pair);
            }
            return ((Expression) (obj));
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (obj1 instanceof Declaration)
        {
            declaration = (Declaration)obj1;
            pair = ((Pair) (declaration.getSymbol()));
        }
        if (true) goto _L5; else goto _L2
_L2:
        return translator.syntaxError((new StringBuilder()).append("invalid syntax for ").append(getName()).toString());
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Pair pair1;
label0:
        {
            if (pair.getCdr() instanceof Pair)
            {
                pair1 = (Pair)pair.getCdr();
                if ((pair1.getCar() instanceof String) || (pair1.getCar() instanceof Symbol))
                {
                    break label0;
                }
            }
            return super.scanForDefinitions(pair, vector, scopeexp, translator);
        }
        Object obj = pair1.getCar();
        Declaration declaration = scopeexp.lookup(obj);
        if (declaration == null)
        {
            translator = new Declaration(obj);
            translator.setProcedureDecl(true);
            scopeexp.addDeclaration(translator);
        } else
        {
            translator.error('w', (new StringBuilder()).append("duplicate declaration for `").append(obj).append("'").toString());
            translator = declaration;
        }
        if (scopeexp instanceof ModuleExp)
        {
            translator.setCanRead(true);
        }
        vector.addElement(Translator.makePair(pair, this, Translator.makePair(pair1, translator, pair1.getCdr())));
        return true;
    }
}
