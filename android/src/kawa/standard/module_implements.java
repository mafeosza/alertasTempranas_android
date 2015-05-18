// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_implements extends Syntax
{

    public static final module_implements module_implements;

    public module_implements()
    {
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        pair = ((Pair) (pair.getCdr()));
        int j = LList.listLength(pair, false);
        if (j < 0)
        {
            translator.syntaxError((new StringBuilder()).append("improper argument list for ").append(getName()).toString());
            return;
        }
        scopeexp = new ClassType[j];
        for (int i = 0; i < j; i++)
        {
            pair = (Pair)pair;
            scopeexp[i] = (ClassType)translator.exp2Type(pair);
            pair = ((Pair) (pair.getCdr()));
        }

        pair = translator.getModule();
        pair.setInterfaces(scopeexp);
        pair.setFlag(0x20000);
    }

    static 
    {
        module_implements = new module_implements();
        module_implements.setName("module-implements");
    }
}
