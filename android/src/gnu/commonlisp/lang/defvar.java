// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package gnu.commonlisp.lang:
//            CommonLisp

public class defvar extends Syntax
{

    boolean force;

    public defvar(boolean flag)
    {
        force = flag;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj;
        Declaration declaration;
        Pair pair1;
        Declaration declaration1;
        Object obj1;
        Object obj2;
        obj2 = pair.getCdr();
        declaration1 = null;
        pair1 = null;
        obj1 = null;
        declaration = obj1;
        pair = declaration1;
        obj = pair1;
        if (!(obj2 instanceof Pair)) goto _L2; else goto _L1
_L1:
        obj2 = (Pair)obj2;
        declaration = obj1;
        pair = declaration1;
        obj = pair1;
        if (!(((Pair) (obj2)).getCar() instanceof Declaration)) goto _L2; else goto _L3
_L3:
        declaration1 = (Declaration)((Pair) (obj2)).getCar();
        pair = ((Pair) (declaration1.getSymbol()));
        if (!(((Pair) (obj2)).getCdr() instanceof Pair)) goto _L5; else goto _L4
_L4:
        pair1 = (Pair)((Pair) (obj2)).getCdr();
        obj = translator.rewrite(pair1.getCar());
        declaration = declaration1;
        if (pair1.getCdr() == LList.Empty);
_L2:
        if (pair != null) goto _L7; else goto _L6
_L6:
        pair = translator.syntaxError((new StringBuilder()).append("invalid syntax for ").append(getName()).toString());
_L9:
        return pair;
_L5:
        declaration = declaration1;
        obj = pair1;
        if (((Pair) (obj2)).getCdr() != LList.Empty)
        {
            pair = null;
            declaration = declaration1;
            obj = pair1;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        translator = ((Translator) (obj));
        if (obj == null)
        {
            if (!force)
            {
                break; /* Loop/switch isn't completed */
            }
            translator = CommonLisp.nilExpr;
        }
        obj = new SetExp(pair, translator);
        if (!force)
        {
            ((SetExp) (obj)).setSetIfUnbound(true);
        }
        ((SetExp) (obj)).setDefining(true);
        pair = ((Pair) (obj));
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
            return ((Expression) (obj));
        }
        if (true) goto _L9; else goto _L8
_L8:
        return new QuoteExp(pair);
        if (true) goto _L2; else goto _L10
_L10:
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
label0:
        {
            if (!(pair.getCdr() instanceof Pair))
            {
                return super.scanForDefinitions(pair, vector, scopeexp, translator);
            }
            Pair pair1 = (Pair)pair.getCdr();
            Object obj1 = pair1.getCar();
            Object obj;
            if (!(obj1 instanceof String))
            {
                obj = pair;
                if (!(obj1 instanceof Symbol))
                {
                    break label0;
                }
            }
            obj = scopeexp.lookup(obj1);
            if (obj == null)
            {
                translator = new Declaration(obj1);
                translator.setFlag(0x10000000L);
                scopeexp.addDeclaration(translator);
            } else
            {
                translator.error('w', (new StringBuilder()).append("duplicate declaration for `").append(obj1).append("'").toString());
                translator = ((Translator) (obj));
            }
            pair = Translator.makePair(pair, this, Translator.makePair(pair1, translator, pair1.getCdr()));
            obj = pair;
            if (scopeexp instanceof ModuleExp)
            {
                translator.setCanRead(true);
                translator.setCanWrite(true);
                obj = pair;
            }
        }
        vector.addElement(obj);
        return true;
    }
}
