// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.FluidLetExp;
import gnu.expr.NameLookup;
import gnu.expr.ReferenceExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class fluid_let extends Syntax
{

    public static final fluid_let fluid_let;
    Expression defaultInit;
    boolean star;

    public fluid_let()
    {
        star = false;
    }

    public fluid_let(boolean flag, Expression expression)
    {
        star = flag;
        defaultInit = expression;
    }

    public Expression rewrite(Object obj, Object obj1, Translator translator)
    {
        Object obj2;
        Object obj5;
        FluidLetExp fluidletexp;
        Object obj3;
        Expression aexpression[];
        Pair pair;
        Declaration declaration;
        int i;
        int j;
        if (star)
        {
            i = 1;
        } else
        {
            i = LList.length(obj);
        }
        aexpression = new Expression[i];
        fluidletexp = new FluidLetExp(aexpression);
        j = 0;
_L5:
        if (j >= i)
        {
            break MISSING_BLOCK_LABEL_458;
        }
        pair = (Pair)obj;
        obj5 = translator.pushPositionOf(pair);
        obj2 = pair.getCar();
        if (!(obj2 instanceof String) && !(obj2 instanceof Symbol)) goto _L2; else goto _L1
_L1:
        obj = defaultInit;
_L3:
        declaration = fluidletexp.addDeclaration(obj2);
        obj3 = translator.lexical.lookup(obj2, false);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_131;
        }
        ((Declaration) (obj3)).maybeIndirectBinding(translator);
        declaration.base = ((Declaration) (obj3));
        ((Declaration) (obj3)).setFluid(true);
        ((Declaration) (obj3)).setCanWrite(true);
        declaration.setCanWrite(true);
        declaration.setFluid(true);
        declaration.setIndirectBinding(true);
        obj3 = obj;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_167;
        }
        obj3 = new ReferenceExp(obj2);
        aexpression[j] = ((Expression) (obj3));
        declaration.noteValue(null);
        obj = pair.getCdr();
        translator.popPositionOf(obj5);
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        Object obj4;
        if (!(obj2 instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_409;
        }
        obj4 = (Pair)obj2;
        if (!(((Pair) (obj4)).getCar() instanceof String) && !(((Pair) (obj4)).getCar() instanceof Symbol) && !(((Pair) (obj4)).getCar() instanceof SyntaxForm))
        {
            break MISSING_BLOCK_LABEL_409;
        }
        obj2 = ((Pair) (obj4)).getCar();
        obj = obj2;
        if (obj2 instanceof SyntaxForm)
        {
            obj = ((SyntaxForm)obj2).getDatum();
        }
        if (((Pair) (obj4)).getCdr() != LList.Empty)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        obj4 = defaultInit;
        obj2 = obj;
        obj = obj4;
          goto _L3
        if (((Pair) (obj4)).getCdr() instanceof Pair)
        {
            obj2 = (Pair)((Pair) (obj4)).getCdr();
            if (((Pair) (obj2)).getCdr() == LList.Empty)
            {
                break MISSING_BLOCK_LABEL_389;
            }
        }
        obj = translator.syntaxError((new StringBuilder()).append("bad syntax for value of ").append(obj).append(" in ").append(getName()).toString());
        translator.popPositionOf(obj5);
        return ((Expression) (obj));
        obj4 = translator.rewrite(((Pair) (obj2)).getCar());
        obj2 = obj;
        obj = obj4;
          goto _L3
        obj = translator.syntaxError((new StringBuilder()).append("invalid ").append(getName()).append(" syntax").toString());
        translator.popPositionOf(obj5);
        return ((Expression) (obj));
        obj;
        translator.popPositionOf(obj5);
        throw obj;
        translator.push(fluidletexp);
        if (star && obj != LList.Empty)
        {
            fluidletexp.body = rewrite(obj, obj1, translator);
        } else
        {
            fluidletexp.body = translator.rewrite_body(obj1);
        }
        translator.pop(fluidletexp);
        return fluidletexp;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        if (!(obj instanceof Pair))
        {
            return translator.syntaxError("missing let arguments");
        } else
        {
            obj = (Pair)obj;
            return rewrite(((Pair) (obj)).getCar(), ((Pair) (obj)).getCdr(), translator);
        }
    }

    static 
    {
        fluid_let = new fluid_let();
        fluid_let.setName("fluid-set");
    }
}
