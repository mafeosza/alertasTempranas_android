// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.expr.QuoteExp;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure0;

public class ConstantFunction0 extends Procedure0
{

    final QuoteExp constant;
    final Object value;

    public ConstantFunction0(String s, QuoteExp quoteexp)
    {
        super(s);
        value = quoteexp.getValue();
        constant = quoteexp;
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyConstantFunction0");
    }

    public ConstantFunction0(String s, Object obj)
    {
        this(s, QuoteExp.getInstance(obj));
    }

    public Object apply0()
    {
        return value;
    }
}
