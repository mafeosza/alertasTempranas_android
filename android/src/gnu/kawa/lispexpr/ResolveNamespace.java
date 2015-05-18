// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class ResolveNamespace extends Syntax
{

    public static final ResolveNamespace resolveNamespace;
    public static final ResolveNamespace resolveQName = new ResolveNamespace("$resolve-qname", true);
    boolean resolvingQName;

    public ResolveNamespace(String s, boolean flag)
    {
        super(s);
        resolvingQName = flag;
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        Pair pair1 = (Pair)pair.getCdr();
        Namespace namespace = translator.namespaceResolvePrefix(translator.rewrite_car(pair1, false));
        pair = namespace;
        if (namespace == null)
        {
            pair = pair1.getCar().toString();
            if (pair == "[default-element-namespace]")
            {
                pair = Namespace.EmptyNamespace;
            } else
            {
                Object obj = translator.pushPositionOf(pair1);
                translator.error('e', (new StringBuilder()).append("unknown namespace prefix ").append(pair).toString());
                translator.popPositionOf(obj);
                pair = Namespace.valueOf(pair, pair);
            }
        }
        if (resolvingQName)
        {
            return new QuoteExp(pair.getSymbol(((Pair)pair1.getCdr()).getCar().toString()));
        } else
        {
            return new QuoteExp(pair);
        }
    }

    static 
    {
        resolveNamespace = new ResolveNamespace("$resolve-namespace$", false);
        resolveNamespace.setName("$resolve-namespace$");
    }
}
