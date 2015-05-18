// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Vector;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            with_compile_options

public class module_compile_options extends Syntax
{

    public static final module_compile_options module_compile_options;

    public module_compile_options()
    {
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return null;
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        if (with_compile_options.getOptions(pair.getCdr(), null, this, translator) != LList.Empty)
        {
            translator.error('e', (new StringBuilder()).append(getName()).append(" key must be a keyword").toString());
        }
        return true;
    }

    static 
    {
        module_compile_options = new module_compile_options();
        module_compile_options.setName("module-compile-options");
    }
}
