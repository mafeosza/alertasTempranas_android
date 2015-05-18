// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Special;
import kawa.lang.Lambda;
import kawa.repl;

// Referenced classes of package kawa.standard:
//            Scheme

public class SchemeCompilation
{

    public static final Lambda lambda;
    public static final repl repl;

    public SchemeCompilation()
    {
    }

    static 
    {
        lambda = new Lambda();
        repl = new repl(Scheme.instance);
        lambda.setKeywords(Special.optional, Special.rest, Special.key);
    }
}
