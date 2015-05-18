// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ClassExp;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.SetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            location

public class define_alias extends Syntax
{

    public static final define_alias define_alias;

    public define_alias()
    {
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        return translator.syntaxError("define-alias is only allowed in a <body>");
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        Object obj;
        obj = pair.getCdr();
        pair = null;
        for (; obj instanceof SyntaxForm; obj = pair.getDatum())
        {
            pair = (SyntaxForm)obj;
        }

        if (!(obj instanceof Pair)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        obj2 = (Pair)obj;
        obj1 = pair;
        for (obj = ((Pair) (obj2)).getCar(); obj instanceof SyntaxForm; obj = ((SyntaxForm) (obj1)).getDatum())
        {
            obj1 = (SyntaxForm)obj;
        }

        for (obj2 = ((Pair) (obj2)).getCdr(); obj2 instanceof SyntaxForm; obj2 = pair.getDatum())
        {
            pair = (SyntaxForm)obj2;
        }

        if (!(obj instanceof String) && !(obj instanceof Symbol) || !(obj2 instanceof Pair)) goto _L2; else goto _L3
_L3:
        obj2 = (Pair)obj2;
        if (((Pair) (obj2)).getCdr() != LList.Empty) goto _L2; else goto _L4
_L4:
        scopeexp = translator.define(obj, ((SyntaxForm) (obj1)), scopeexp);
        scopeexp.setIndirectBinding(true);
        scopeexp.setAlias(true);
        pair = translator.rewrite_car(((Pair) (obj2)), pair);
        if (!(pair instanceof ReferenceExp)) goto _L6; else goto _L5
_L5:
        obj = (ReferenceExp)pair;
        obj1 = Declaration.followAliases(((ReferenceExp) (obj)).getBinding());
        if (obj1 == null) goto _L8; else goto _L7
_L7:
        obj1 = ((Declaration) (obj1)).getValue();
        if (!(obj1 instanceof ClassExp) && !(obj1 instanceof ModuleExp)) goto _L8; else goto _L9
_L9:
        scopeexp.setIndirectBinding(false);
        scopeexp.setFlag(16384L);
_L10:
        translator.mustCompileHere();
        translator.push(scopeexp);
        obj = new SetExp(scopeexp, pair);
        translator.setLineOf(((Expression) (obj)));
        scopeexp.noteValue(pair);
        ((SetExp) (obj)).setDefining(true);
        vector.addElement(obj);
        return true;
_L8:
        ((ReferenceExp) (obj)).setDontDereference(true);
        continue; /* Loop/switch isn't completed */
_L6:
        if (pair instanceof QuoteExp)
        {
            scopeexp.setIndirectBinding(false);
            scopeexp.setFlag(16384L);
        } else
        {
            pair = location.rewrite(pair, translator);
            scopeexp.setType(ClassType.make("gnu.mapping.Location"));
        }
        if (true) goto _L10; else goto _L2
_L2:
        translator.error('e', "invalid syntax for define-alias");
        return false;
    }

    static 
    {
        define_alias = new define_alias();
        define_alias.setName("define-alias");
    }
}
