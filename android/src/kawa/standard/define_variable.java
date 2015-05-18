// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

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

public class define_variable extends Syntax
{

    public static final define_variable define_variable;

    public define_variable()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj3 = pair.getCdr();
        obj1 = null;
        obj2 = null;
        pair = ((Pair) (obj2));
        obj = obj1;
        if (!(obj3 instanceof Pair)) goto _L2; else goto _L1
_L1:
        Object obj4;
        obj3 = (Pair)obj3;
        obj4 = ((Pair) (obj3)).getCar();
        if (!(obj4 instanceof String) && !(obj4 instanceof Symbol)) goto _L4; else goto _L3
_L3:
        translator = translator.syntaxError((new StringBuilder()).append(getName()).append(" is only allowed in a <body>").toString());
_L11:
        return translator;
_L4:
        pair = ((Pair) (obj2));
        obj = obj1;
        if (!(obj4 instanceof Declaration)) goto _L2; else goto _L5
_L5:
        pair = (Declaration)((Pair) (obj3)).getCar();
        obj2 = ((Pair) (obj3)).getCdr();
        if (!(obj2 instanceof Pair)) goto _L7; else goto _L6
_L6:
        obj = (Pair)obj2;
        if (((Pair) (obj)).getCdr() != LList.Empty) goto _L7; else goto _L8
_L8:
        obj = translator.rewrite(((Pair) (obj)).getCar());
_L2:
        if (pair == null)
        {
            return translator.syntaxError((new StringBuilder()).append("invalid syntax for ").append(getName()).toString());
        }
        break; /* Loop/switch isn't completed */
_L7:
        obj = obj1;
        if (obj2 != LList.Empty)
        {
            pair = null;
            obj = obj1;
        }
        if (true) goto _L2; else goto _L9
_L9:
        if (obj == null)
        {
            return QuoteExp.voidExp;
        }
        SetExp setexp = new SetExp(pair, ((Expression) (obj)));
        setexp.setDefining(true);
        setexp.setSetIfUnbound(true);
        translator = setexp;
        if (pair != null)
        {
            setexp.setBinding(pair);
            translator = ((Translator) (obj));
            if (((Declaration) (pair)).context instanceof ModuleExp)
            {
                translator = ((Translator) (obj));
                if (pair.getCanWrite())
                {
                    translator = null;
                }
            }
            pair.noteValue(translator);
            return setexp;
        }
        if (true) goto _L11; else goto _L10
_L10:
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Pair pair1;
label0:
        {
            if (!(pair.getCdr() instanceof Pair))
            {
                return super.scanForDefinitions(pair, vector, scopeexp, translator);
            }
            Pair pair2 = (Pair)pair.getCdr();
            Object obj = pair2.getCar();
            if (!(obj instanceof String))
            {
                pair1 = pair;
                if (!(obj instanceof Symbol))
                {
                    break label0;
                }
            }
            if (scopeexp.lookup(obj) != null)
            {
                translator.error('e', (new StringBuilder()).append("duplicate declaration for '").append(obj).append("'").toString());
            }
            scopeexp = scopeexp.addDeclaration(obj);
            translator.push(scopeexp);
            scopeexp.setSimple(false);
            scopeexp.setPrivate(true);
            scopeexp.setFlag(0x10040000L);
            scopeexp.setCanRead(true);
            scopeexp.setCanWrite(true);
            scopeexp.setIndirectBinding(true);
            pair1 = Translator.makePair(pair, this, Translator.makePair(pair2, scopeexp, pair2.getCdr()));
        }
        vector.addElement(pair1);
        return true;
    }

    static 
    {
        define_variable = new define_variable();
        define_variable.setName("define-variable");
    }
}
