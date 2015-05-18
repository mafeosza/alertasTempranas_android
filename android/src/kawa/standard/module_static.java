// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.ModuleExp;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class module_static extends Syntax
{

    public static final module_static module_static;

    public module_static()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        pair = ((Pair) (pair.getCdr()));
        if (scopeexp instanceof ModuleExp) goto _L2; else goto _L1
_L1:
        translator.error('e', (new StringBuilder()).append("'").append(getName()).append("' not at module level").toString());
_L4:
        return true;
_L2:
        vector = (ModuleExp)scopeexp;
        if (!(pair instanceof Pair))
        {
            break; /* Loop/switch isn't completed */
        }
        Pair pair1 = (Pair)pair;
        if (pair1.getCdr() != LList.Empty || !(pair1.getCar() instanceof Boolean))
        {
            break; /* Loop/switch isn't completed */
        }
        if (pair1.getCar() == Boolean.FALSE)
        {
            vector.setFlag(0x10000);
        } else
        {
            vector.setFlag(32768);
        }
_L5:
        if (vector.getFlag(0x10000) && vector.getFlag(32768))
        {
            translator.error('e', "inconsistent module-static specifiers");
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
label0:
        {
            if (!(pair instanceof Pair))
            {
                break label0;
            }
            Pair pair2 = (Pair)pair;
            if (pair2.getCdr() != LList.Empty || !(pair2.getCar() instanceof Pair))
            {
                break label0;
            }
            pair2 = (Pair)pair2.getCar();
            if (!translator.matches(pair2.getCar(), "quote"))
            {
                break label0;
            }
            pair = (Pair)pair2.getCdr();
            if (pair != LList.Empty && (pair.getCar() instanceof SimpleSymbol) && pair.getCar().toString() == "init-run")
            {
                vector.setFlag(32768);
                vector.setFlag(0x40000);
            } else
            {
                translator.error('e', (new StringBuilder()).append("invalid quoted symbol for '").append(getName()).append('\'').toString());
                return false;
            }
        }
          goto _L5
        vector.setFlag(0x10000);
        while (pair != LList.Empty) 
        {
label1:
            {
                if (pair instanceof Pair)
                {
                    pair = (Pair)pair;
                    if (pair.getCar() instanceof Symbol)
                    {
                        break label1;
                    }
                }
                translator.error('e', (new StringBuilder()).append("invalid syntax in '").append(getName()).append('\'').toString());
                return false;
            }
            Declaration declaration = scopeexp.getNoDefine((Symbol)pair.getCar());
            if (declaration.getFlag(512L))
            {
                Translator.setLine(declaration, pair);
            }
            declaration.setFlag(2048L);
            pair = ((Pair) (pair.getCdr()));
        }
          goto _L5
    }

    static 
    {
        module_static = new module_static();
        module_static.setName("module-static");
    }
}
