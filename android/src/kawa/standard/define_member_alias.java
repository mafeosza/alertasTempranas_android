// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.kawa.reflect.Invoke;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class define_member_alias extends Syntax
{

    public static final define_member_alias define_member_alias;

    public define_member_alias()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
label0:
        {
            pair = ((Pair) (pair.getCdr()));
            if (pair instanceof Pair)
            {
                pair = (Pair)pair;
                if ((pair.getCar() instanceof String) || (pair.getCar() instanceof Declaration))
                {
                    break label0;
                }
            }
            return translator.syntaxError((new StringBuilder()).append("missing name in ").append(getName()).toString());
        }
        if (!(pair.getCdr() instanceof Pair)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        Object obj = pair.getCar();
        Expression expression;
        if (obj instanceof Declaration)
        {
            obj = ((Declaration)obj).getName();
        } else
        {
            obj = (String)obj;
        }
        pair = (Pair)pair.getCdr();
        obj1 = null;
        expression = translator.rewrite(pair.getCar());
        obj2 = pair.getCdr();
        if (obj2 != LList.Empty) goto _L4; else goto _L3
_L3:
        pair = new QuoteExp(Compilation.mangleName(((String) (obj))));
_L5:
        if (pair != null)
        {
            return Invoke.makeInvokeStatic(ClassType.make("gnu.kawa.reflect.ClassMemberConstraint"), "define", new Expression[] {
                new QuoteExp(obj), expression, pair
            });
        }
        break; /* Loop/switch isn't completed */
_L4:
        pair = obj1;
        if (obj2 instanceof Pair)
        {
            obj2 = (Pair)obj2;
            pair = obj1;
            if (((Pair) (obj2)).getCdr() == LList.Empty)
            {
                pair = translator.rewrite(((Pair) (obj2)).getCar());
            }
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
            if ((pair.getCdr() instanceof Pair) && !(translator.currentScope() instanceof ModuleExp))
            {
                pair1 = (Pair)pair.getCdr();
                if (pair1.getCar() instanceof String)
                {
                    break label0;
                }
            }
            return super.scanForDefinitions(pair, vector, scopeexp, translator);
        }
        scopeexp = scopeexp.addDeclaration((String)pair1.getCar(), Compilation.typeSymbol);
        scopeexp.setIndirectBinding(true);
        vector.addElement(Translator.makePair(pair, this, Translator.makePair(pair1, scopeexp, pair1.getCdr())));
        return true;
    }

    static 
    {
        define_member_alias = new define_member_alias();
        define_member_alias.setName("define-member-alias");
    }
}
