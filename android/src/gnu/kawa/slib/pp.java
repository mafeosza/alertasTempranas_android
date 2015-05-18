// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.math.IntNum;
import kawa.lib.ports;

// Referenced classes of package gnu.kawa.slib:
//            genwrite

public class pp extends ModuleBody
{
    public class frame extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        Object port;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 1)
            {
                return lambda1(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Boolean lambda1(Object obj)
        {
            ports.display(obj, port);
            return Boolean.TRUE;
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return super.match1(modulemethod, obj, callcontext);
            }
        }

        public frame()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
            modulemethod.setProperty("source-location", "pp.scm:9");
            lambda$Fn1 = modulemethod;
        }
    }


    public static final pp $instance;
    static final IntNum Lit0 = IntNum.make(79);
    static final SimpleSymbol Lit1;
    public static final ModuleMethod pretty$Mnprint;

    public pp()
    {
        ModuleInfo.register(this);
    }

    public static Object prettyPrint(Object obj)
    {
        return prettyPrint(obj, ports.current$Mnoutput$Mnport.apply0());
    }

    public static Object prettyPrint(Object obj, Object obj1)
    {
        frame frame1 = new frame();
        frame1.port = obj1;
        return genwrite.genericWrite(obj, Boolean.FALSE, Lit0, frame1.Fn1);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 2)
        {
            return prettyPrint(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 2)
        {
            return prettyPrint(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 2)
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit1 = (SimpleSymbol)(new SimpleSymbol("pretty-print")).readResolve();
        $instance = new pp();
        pretty$Mnprint = new ModuleMethod($instance, 2, Lit1, 8193);
        $instance.run();
    }
}
