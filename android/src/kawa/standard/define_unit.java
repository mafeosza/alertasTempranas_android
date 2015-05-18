// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.math.BaseUnit;
import gnu.math.Quantity;
import gnu.math.Unit;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            Scheme

public class define_unit extends Syntax
{

    public static final define_unit define_base_unit;
    public static final define_unit define_unit;
    boolean base;

    public define_unit(boolean flag)
    {
        base = flag;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Declaration declaration;
        String s;
        Pair pair1;
        ClassType classtype;
label0:
        {
            pair = ((Pair) (pair.getCdr()));
            if (pair instanceof Pair)
            {
                pair1 = (Pair)pair;
                if (pair1.getCar() instanceof Declaration)
                {
                    break label0;
                }
            }
            return translator.syntaxError((new StringBuilder()).append("invalid syntax for ").append(getName()).toString());
        }
        declaration = (Declaration)pair1.getCar();
        s = ((Symbol)declaration.getSymbol()).getLocalPart();
        classtype = ClassType.make("gnu.math.Unit");
        declaration.setType(classtype);
        pair = declaration.getValue();
        if (!(pair instanceof QuoteExp) || !(((QuoteExp)pair).getValue() instanceof Unit)) goto _L2; else goto _L1
_L1:
        translator = new SetExp(declaration, pair);
        translator.setDefining(true);
        declaration.noteValue(pair);
        return translator;
_L2:
        if (base)
        {
            pair = null;
            if (pair1.getCdr() != LList.Empty)
            {
                pair = ((Pair)pair1.getCdr()).getCar().toString();
            }
            pair = new QuoteExp(BaseUnit.make(s, pair));
            continue; /* Loop/switch isn't completed */
        }
        if (!(pair1.getCdr() instanceof Pair))
        {
            return translator.syntaxError("missing value for define-unit");
        }
        pair = translator.rewrite(((Pair)pair1.getCdr()).getCar());
        if (pair instanceof QuoteExp)
        {
            translator = ((Translator) (((QuoteExp)pair).getValue()));
            if (translator instanceof Quantity)
            {
                pair = new QuoteExp(Unit.make(s, (Quantity)translator));
                continue; /* Loop/switch isn't completed */
            }
        }
        pair = Invoke.makeInvokeStatic(classtype, "make", new Expression[] {
            new QuoteExp(s), pair
        });
        if (true) goto _L1; else goto _L3
_L3:
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        if (!(pair.getCdr() instanceof Pair)) goto _L2; else goto _L1
_L1:
        Pair pair1;
        Object obj;
        pair1 = (Pair)pair.getCdr();
        obj = pair1.getCar();
        if (!(obj instanceof SimpleSymbol)) goto _L2; else goto _L3
_L3:
        String s;
        s = obj.toString();
        obj = scopeexp.getDefine(Scheme.unitNamespace.getSymbol(s), 'w', translator);
        translator.push(((Declaration) (obj)));
        Translator.setLine(((Declaration) (obj)), pair1);
        ((Declaration) (obj)).setFlag(16384L);
        if (scopeexp instanceof ModuleExp)
        {
            ((Declaration) (obj)).setCanRead(true);
        }
        translator = null;
        if (!base || pair1.getCdr() != LList.Empty) goto _L5; else goto _L4
_L4:
        scopeexp = BaseUnit.make(s, (String)null);
_L6:
        if (scopeexp != null)
        {
            ((Declaration) (obj)).noteValue(new QuoteExp(scopeexp));
        }
        vector.addElement(Translator.makePair(pair, this, Translator.makePair(pair1, obj, pair1.getCdr())));
        return true;
_L5:
        scopeexp = translator;
        if (pair1.getCdr() instanceof Pair)
        {
            Object obj1 = ((Pair)pair1.getCdr()).getCar();
            if (base && (obj1 instanceof CharSequence))
            {
                scopeexp = BaseUnit.make(s, obj1.toString());
            } else
            {
                scopeexp = translator;
                if (!base)
                {
                    scopeexp = translator;
                    if (obj1 instanceof Quantity)
                    {
                        scopeexp = Unit.make(s, (Quantity)obj1);
                    }
                }
            }
        }
        if (true) goto _L6; else goto _L2
_L2:
        translator.error('e', "missing name in define-unit");
        return false;
    }

    static 
    {
        define_unit = new define_unit(false);
        define_unit.setName("define-unit");
        define_base_unit = new define_unit(true);
        define_base_unit.setName("define-base-unit");
    }
}
