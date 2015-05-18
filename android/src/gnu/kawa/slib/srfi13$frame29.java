// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class s extends ModuleBody
{
    public class srfi13.frame30 extends ModuleBody
    {

        Object end1;
        final ModuleMethod lambda$Fn66 = new ModuleMethod(this, 60, null, 0);
        final ModuleMethod lambda$Fn67 = new ModuleMethod(this, 61, null, 8194);
        Object rest;
        Object start1;
        srfi13.frame29 staticLink;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 60)
            {
                return lambda66();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 61)
            {
                return lambda67(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda66()
        {
            return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncompare$Mnci, staticLink.s2, rest);
        }

        Object lambda67(Object obj, Object obj1)
        {
            return srfi13.$PcStringCompareCi(staticLink.s1, start1, end1, staticLink.s2, obj, obj1, staticLink.proc$Ls, staticLink.proc$Eq, staticLink.proc$Gr);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 60)
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
            if (modulemethod.selector == 61)
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

        public srfi13.frame30()
        {
        }
    }


    final ModuleMethod lambda$Fn64 = new ModuleMethod(this, 62, null, 0);
    final ModuleMethod lambda$Fn65 = new ModuleMethod(this, 63, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object proc$Eq;
    Object proc$Gr;
    Object proc$Ls;
    Object s1;
    Object s2;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 62)
        {
            return lambda64();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 63)
        {
            return lambda65(obj, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    Object lambda64()
    {
        return srfi13.stringParseStart$PlEnd(srfi13.string$Mncompare$Mnci, s1, maybe$Mnstarts$Plends);
    }

    Object lambda65(Object obj, Object obj1, Object obj2)
    {
        maybe.Mnstarts.Plends plends = new <init>();
        plends.staticLink = this;
        plends.rest = obj;
        plends.start1 = obj1;
        plends.end1 = obj2;
        return call_with_values.callWithValues(plends.Fn66, plends.Fn67);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 62)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 63)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        } else
        {
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);
        }
    }

    public s()
    {
    }
}
