// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            testing

public class lambda.Fn10 extends ModuleBody
{

    Object first;
    final ModuleMethod lambda$Fn10;
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 2, null, 0);
    final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn7;
    final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn9 = new ModuleMethod(this, 6, null, 0);
    Object r;
    LList rest;
    Object saved$Mnrunner;
    Object saved$Mnrunner$1;

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply0(modulemethod);

        case 2: // '\002'
            return lambda6();

        case 3: // '\003'
            return lambda7();

        case 4: // '\004'
            return lambda8();

        case 5: // '\005'
            return lambda9();

        case 6: // '\006'
            return lambda10();

        case 7: // '\007'
            return lambda11();
        }
    }

    Object lambda10()
    {
        return Scheme.apply.apply3(testing.test$Mnapply, first, rest);
    }

    Object lambda11()
    {
        return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(saved$Mnrunner);
    }

    Object lambda6()
    {
        return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(first);
    }

    Object lambda7()
    {
        return Scheme.apply.apply2(testing.test$Mnapply, rest);
    }

    Object lambda8()
    {
        return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(saved$Mnrunner$1);
    }

    Object lambda9()
    {
        return ((Procedure)testing.test$Mnrunner$Mncurrent).apply1(r);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match0(modulemethod, callcontext);

        case 7: // '\007'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 6: // '\006'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 5: // '\005'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 4: // '\004'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 3: // '\003'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 2: // '\002'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 0);
        modulemethod.setProperty("source-location", "testing.scm:897");
        lambda$Fn7 = modulemethod;
        modulemethod = new ModuleMethod(this, 7, null, 0);
        modulemethod.setProperty("source-location", "testing.scm:897");
        lambda$Fn10 = modulemethod;
    }
}
