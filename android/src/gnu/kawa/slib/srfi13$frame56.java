// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.UnboundLocationException;
import kawa.lib.characters;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    Object bound;
    final ModuleMethod lambda$Fn134 = new ModuleMethod(this, 112, null, 0);
    final ModuleMethod lambda$Fn135 = new ModuleMethod(this, 113, null, 8194);
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 112)
        {
            return lambda134();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 113)
        {
            return lambda135(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda134()
    {
        ModuleMethod modulemethod = srfi13.string$Mnhash;
        Object obj = s;
        Object obj1 = srfi13.loc$rest;
        try
        {
            obj1 = ((Location) (obj1)).get();
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            unboundlocationexception.setLine("srfi13.scm", 912, 55);
            throw unboundlocationexception;
        }
        return srfi13.stringParseFinalStart$PlEnd(modulemethod, obj, obj1);
    }

    Object lambda135(Object obj, Object obj1)
    {
        return srfi13.$PcStringHash(s, characters.char$Mn$Grinteger, bound, obj, obj1);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 112)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 113)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return super.match2(modulemethod, obj, obj1, callcontext);
        }
    }

    public ception()
    {
    }
}
