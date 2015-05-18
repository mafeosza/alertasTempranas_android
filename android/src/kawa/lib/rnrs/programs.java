// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.rnrs;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.numbers;

public class programs extends ModuleBody
{

    public static final programs $instance;
    static final IntNum Lit0 = IntNum.make(0);
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    public static final ModuleMethod command$Mnline;
    public static final ModuleMethod exit;

    public programs()
    {
        ModuleInfo.register(this);
    }

    public static LList commandLine()
    {
        return lists.cons("kawa", LList.makeList(ApplicationMainSupport.commandLineArgArray, 0));
    }

    public static void exit()
    {
        exit(Lit0);
    }

    public static void exit(Object obj)
    {
        OutPort.runCleanups();
        int i;
        if (numbers.isInteger(obj))
        {
            try
            {
                i = ((Number)obj).intValue();
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "status", -2, obj);
            }
        } else
        if (obj != Boolean.FALSE)
        {
            i = 0;
        } else
        {
            i = -1;
        }
        System.exit(i);
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply0(modulemethod);

        case 1: // '\001'
            return commandLine();

        case 2: // '\002'
            exit();
            break;
        }
        return Values.empty;
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 2)
        {
            exit(obj);
            return Values.empty;
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match0(modulemethod, callcontext);

        case 2: // '\002'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 1: // '\001'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit2 = (SimpleSymbol)(new SimpleSymbol("exit")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("command-line")).readResolve();
        $instance = new programs();
        programs programs1 = $instance;
        command$Mnline = new ModuleMethod(programs1, 1, Lit1, 0);
        exit = new ModuleMethod(programs1, 2, Lit2, 4096);
        $instance.run();
    }
}
