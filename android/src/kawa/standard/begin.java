// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class begin extends Syntax
{

    public static final begin begin;

    public begin()
    {
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        return translator.rewrite_body(obj);
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        scopeexp = translator.scanBody(pair.getCdr(), scopeexp, true);
        if (scopeexp != LList.Empty)
        {
            translator.formStack.add(Translator.makePair(pair, pair.getCar(), scopeexp));
        }
    }

    static 
    {
        begin = new begin();
        begin.setName("begin");
    }
}
