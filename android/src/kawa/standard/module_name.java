// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleExp;
import gnu.expr.QuoteExp;
import gnu.expr.ScopeExp;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class module_name extends Syntax
{

    public static final module_name module_name;

    public module_name()
    {
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        Object obj;
        Object obj2;
        Object obj3;
        String s1;
        pair = ((Pair) (pair.getCdr()));
        obj = null;
        for (; pair instanceof SyntaxForm; pair = ((Pair) (((SyntaxForm) (obj)).getDatum())))
        {
            obj = (SyntaxForm)pair;
        }

        if (pair instanceof Pair)
        {
            pair = ((Pair) (((Pair)pair).getCar()));
            obj2 = obj;
        } else
        {
            pair = null;
            obj2 = obj;
        }
        for (; pair instanceof SyntaxForm; pair = ((Pair) (((SyntaxForm) (obj2)).getDatum())))
        {
            obj2 = (SyntaxForm)pair;
        }

        s1 = null;
        obj3 = null;
        obj = null;
        if (!(pair instanceof Pair)) goto _L2; else goto _L1
_L1:
        Pair pair1 = (Pair)pair;
        if (pair1.getCar() != "quote") goto _L2; else goto _L3
_L3:
        pair = ((Pair) (pair1.getCdr()));
        if (!(pair instanceof Pair)) goto _L5; else goto _L4
_L4:
        pair = (Pair)pair;
        if (pair.getCdr() == LList.Empty && (pair.getCar() instanceof String)) goto _L6; else goto _L5
_L5:
        scopeexp = "invalid quoted symbol for 'module-name'";
        pair = s1;
        obj2 = obj;
_L8:
        if (scopeexp != null)
        {
            translator.formStack.add(translator.syntaxError(scopeexp));
            return;
        }
        break; /* Loop/switch isn't completed */
_L6:
        pair = (String)pair.getCar();
        obj2 = obj;
        scopeexp = obj3;
        continue; /* Loop/switch isn't completed */
_L2:
        if ((pair instanceof FString) || (pair instanceof String))
        {
            pair = pair.toString();
            obj2 = obj;
            scopeexp = obj3;
        } else
        if (pair instanceof Symbol)
        {
            s1 = pair.toString();
            int i = s1.length();
            obj = s1;
            if (i > 2)
            {
                obj = s1;
                if (s1.charAt(0) == '<')
                {
                    obj = s1;
                    if (s1.charAt(i - 1) == '>')
                    {
                        obj = s1.substring(1, i - 1);
                    }
                }
            }
            obj2 = translator.define(pair, ((SyntaxForm) (obj2)), scopeexp);
            scopeexp = obj3;
            pair = ((Pair) (obj));
        } else
        {
            scopeexp = "un-implemented expression in module-name";
            obj2 = obj;
            pair = s1;
        }
        if (true) goto _L8; else goto _L7
_L7:
        int j = pair.lastIndexOf('.');
        Object obj1 = pair;
        if (j >= 0)
        {
            translator.classPrefix = pair.substring(0, j + 1);
            scopeexp = pair;
            pair = ((Pair) (obj1));
        } else
        {
            scopeexp = (new StringBuilder()).append(translator.classPrefix).append(pair).toString();
            pair = (new StringBuilder()).append(translator.classPrefix).append(Compilation.mangleName(scopeexp)).toString();
        }
        obj1 = translator.getModule();
        if (translator.mainClass != null) goto _L10; else goto _L9
_L9:
        translator.mainClass = new ClassType(pair);
_L12:
        ((ModuleExp) (obj1)).setType(translator.mainClass);
        ((ModuleExp) (obj1)).setName(scopeexp);
        if (obj2 != null)
        {
            ((Declaration) (obj2)).noteValue(new QuoteExp(translator.mainClass, Compilation.typeClass));
            ((Declaration) (obj2)).setFlag(0x1004000L);
            if (((ModuleExp) (obj1)).outer == null)
            {
                ((Declaration) (obj2)).setFlag(2048L);
            }
            ((Declaration) (obj2)).setPrivate(true);
            ((Declaration) (obj2)).setType(Compilation.typeClass);
        }
        translator.mustCompileHere();
        return;
_L10:
        String s = translator.mainClass.getName();
        if (s == null)
        {
            translator.mainClass.setName(pair);
        } else
        if (!s.equals(pair))
        {
            translator.syntaxError((new StringBuilder()).append("duplicate module-name: old name: ").append(s).toString());
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    static 
    {
        module_name = new module_name();
        module_name.setName("module-name");
    }
}
