// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import kawa.lib.characters;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class s extends ModuleBody
{
    public class srfi13.frame84 extends ModuleBody
    {

        final ModuleMethod lambda$Fn191 = new ModuleMethod(this, 164, null, 0);
        final ModuleMethod lambda$Fn192 = new ModuleMethod(this, 165, null, 8194);
        Object rest;
        srfi13.frame83 staticLink;
        Object t$Mnend;
        Object t$Mnstart;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 164)
            {
                return lambda191();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 165)
            {
                return lambda192(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda191()
        {
            return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mncontains, staticLink.pattern, rest);
        }

        Object lambda192(Object obj, Object obj1)
        {
            return srfi13.$PcKmpSearch(staticLink.pattern, staticLink.text, characters.char$Eq$Qu, obj, obj1, t$Mnstart, t$Mnend);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 164)
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
            if (modulemethod.selector == 165)
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

        public srfi13.frame84()
        {
        }
    }


    final ModuleMethod lambda$Fn189 = new ModuleMethod(this, 166, null, 0);
    final ModuleMethod lambda$Fn190 = new ModuleMethod(this, 167, null, 12291);
    LList maybe$Mnstarts$Plends;
    Object pattern;
    Object text;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 166)
        {
            return lambda189();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 167)
        {
            return lambda190(obj, obj1, obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    Object lambda189()
    {
        return srfi13.stringParseStart$PlEnd(srfi13.string$Mncontains, text, maybe$Mnstarts$Plends);
    }

    Object lambda190(Object obj, Object obj1, Object obj2)
    {
        maybe.Mnstarts.Plends plends = new <init>();
        plends.staticLink = this;
        plends.rest = obj;
        plends.Mnstart = obj1;
        plends.Mnend = obj2;
        return call_with_values.callWithValues(plends.Fn191, plends.Fn192);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 166)
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
        if (modulemethod.selector == 167)
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
