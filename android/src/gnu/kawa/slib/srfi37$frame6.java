// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi37

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 11, null, 0);
    final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 12, null, -4096);
     staticLink;
    Object x;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 11)
        {
            return lambda22();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        if (modulemethod.selector == 12)
        {
            return lambda23$V(aobj);
        } else
        {
            return super.applyN(modulemethod, aobj);
        }
    }

    Object lambda22()
    {
        gnu.kawa.functions.Apply apply = Scheme.apply;
        Object obj = x;
         ;
        try
        {
             = (x)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "option-processor", 0, obj);
        }
        return apply.applyN(new Object[] {
            srfi37.optionProcessor(), x, staticLink.staticLink.x, staticLink.x, staticLink.staticLink.staticLink.seeds
        });
    }

    Object lambda23$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.staticLink.staticLink.staticLink.ambda5scanArgs(staticLink.staticLink.staticLink.args, ((Object) (aobj)));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 11)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        if (modulemethod.selector == 12)
        {
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        } else
        {
            return super.matchN(modulemethod, aobj, callcontext);
        }
    }

    public ()
    {
    }
}
