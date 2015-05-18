// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.expr.BeginExp;
import gnu.expr.Expression;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package gnu.commonlisp.lang:
//            CommonLisp

public class setq extends Syntax
{

    public setq()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Object obj2;
        obj2 = pair.getCdr();
        pair = null;
_L7:
        if (obj2 == LList.Empty) goto _L2; else goto _L1
_L1:
        if (obj2 instanceof Pair) goto _L4; else goto _L3
_L3:
        Object obj = translator.syntaxError("invalid syntax for setq");
_L6:
        return ((Expression) (obj));
_L4:
        Object obj3;
        obj2 = (Pair)obj2;
        obj = ((Pair) (obj2)).getCar();
        if (!(obj instanceof Symbol) && !(obj instanceof String))
        {
            if (obj == CommonLisp.FALSE)
            {
                obj = "nil";
            } else
            {
                return translator.syntaxError("invalid variable name in setq");
            }
        }
        obj2 = ((Pair) (obj2)).getCdr();
        if (!(obj2 instanceof Pair))
        {
            return translator.syntaxError("wrong number of arguments for setq");
        }
        obj2 = (Pair)obj2;
        obj3 = translator.rewrite(((Pair) (obj2)).getCar());
        obj2 = ((Pair) (obj2)).getCdr();
        obj3 = new SetExp(obj, ((Expression) (obj3)));
        ((SetExp) (obj3)).setFlag(8);
        if (obj2 != LList.Empty)
        {
            break; /* Loop/switch isn't completed */
        }
        ((SetExp) (obj3)).setHasValue(true);
        obj = obj3;
        if (pair == null) goto _L6; else goto _L5
_L5:
        Object obj1 = pair;
        if (pair == null)
        {
            obj1 = new Vector(10);
        }
        ((Vector) (obj1)).addElement(obj3);
        pair = ((Pair) (obj1));
          goto _L7
_L2:
        if (pair == null)
        {
            return CommonLisp.nilExpr;
        } else
        {
            translator = new Expression[pair.size()];
            pair.copyInto(translator);
            return new BeginExp(translator);
        }
    }
}
