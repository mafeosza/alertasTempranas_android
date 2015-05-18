// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;

public class call_with_values extends Procedure2
{

    public static final call_with_values callWithValues;

    public call_with_values()
    {
    }

    public static Object callWithValues(Procedure procedure, Procedure procedure1)
        throws Throwable
    {
        procedure = ((Procedure) (procedure.apply0()));
        if (procedure instanceof Values)
        {
            return ((Values)procedure).call_with(procedure1);
        } else
        {
            return procedure1.apply1(procedure);
        }
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Procedure.checkArgCount(this, 2);
        Object aobj[] = callcontext.getArgs();
        Object obj = ((Procedure)aobj[0]).apply0();
        Procedure procedure = (Procedure)aobj[1];
        if (obj instanceof Values)
        {
            procedure.checkN(((Values)obj).getValues(), callcontext);
            return;
        } else
        {
            procedure.check1(obj, callcontext);
            return;
        }
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        return callWithValues((Procedure)obj, (Procedure)obj1);
    }

    static 
    {
        callWithValues = new call_with_values();
        callWithValues.setName("call-with-values");
    }
}
