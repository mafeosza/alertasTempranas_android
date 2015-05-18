// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.Language;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1;

public class Not extends Procedure1
{

    Language language;

    public Not(Language language1)
    {
        language = language1;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyNot");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileMisc:forNot");
    }

    public Not(Language language1, String s)
    {
        this(language1);
        setName(s);
    }

    public Object apply1(Object obj)
    {
        Language language1 = language;
        boolean flag;
        if (!language.isTrue(obj))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return language1.booleanObject(flag);
    }
}
