// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            pregexp

public class lambda.Fn19 extends ModuleBody
{

    Procedure fk;
    Object i;
    Object k;
    final ModuleMethod lambda$Fn18;
    final ModuleMethod lambda$Fn19;
    _cls1 staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 5)
        {
            return lambda26fk();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 6: // '\006'
            return lambda27(obj);

        case 7: // '\007'
            return lambda28(obj);
        }
    }

    public Object lambda26fk()
    {
        return Scheme.applyToArgs.apply2(staticLink.staticLink.sk, i);
    }

    Object lambda27(Object obj)
    {
        if (staticLink.staticLink.Qu ? Scheme.numEqu.apply2(obj, i) != Boolean.FALSE : staticLink.staticLink.Qu)
        {
            pregexp.pregexpError$V(new Object[] {
                pregexp.Lit101, pregexp.Lit110
            });
        }
        obj = staticLink.lambda24loupQ(AddOp.$Pl.apply2(k, pregexp.Lit8), obj);
        if (obj != Boolean.FALSE)
        {
            return obj;
        } else
        {
            return lambda26fk();
        }
    }

    Object lambda28(Object obj)
    {
        return staticLink.lambda24loupQ(AddOp.$Pl.apply2(k, pregexp.Lit8), obj);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 5)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 5, pregexp.Lit111, 0);
        modulemethod.setProperty("source-location", "pregexp.scm:612");
        fk = modulemethod;
        modulemethod = new ModuleMethod(this, 6, null, 4097);
        modulemethod.setProperty("source-location", "pregexp.scm:617");
        lambda$Fn18 = modulemethod;
        modulemethod = new ModuleMethod(this, 7, null, 4097);
        modulemethod.setProperty("source-location", "pregexp.scm:628");
        lambda$Fn19 = modulemethod;
    }
}
