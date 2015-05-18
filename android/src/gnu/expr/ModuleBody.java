// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.text.WriterManager;
import kawa.Shell;

// Referenced classes of package gnu.expr:
//            ModuleMethod

public abstract class ModuleBody extends Procedure0
{

    private static int exitCounter;
    private static boolean mainPrintValues;
    protected boolean runDone;

    public ModuleBody()
    {
    }

    public static void exitDecrement()
    {
        gnu/expr/ModuleBody;
        JVM INSTR monitorenter ;
        int i = exitCounter;
        if (i <= 0) goto _L2; else goto _L1
_L1:
        i--;
        if (i != 0) goto _L4; else goto _L3
_L3:
        System.exit(0);
_L2:
        gnu/expr/ModuleBody;
        JVM INSTR monitorexit ;
        return;
_L4:
        exitCounter = i;
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public static void exitIncrement()
    {
        gnu/expr/ModuleBody;
        JVM INSTR monitorenter ;
        if (exitCounter == 0)
        {
            exitCounter++;
        }
        exitCounter++;
        gnu/expr/ModuleBody;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean getMainPrintValues()
    {
        return mainPrintValues;
    }

    public static void runCleanup(CallContext callcontext, Throwable throwable, Consumer consumer)
    {
        Throwable throwable1;
        throwable1 = throwable;
        if (throwable != null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        callcontext.runUntilDone();
        throwable1 = throwable;
_L2:
label0:
        {
            callcontext.consumer = consumer;
            if (throwable1 == null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            if (throwable1 instanceof RuntimeException)
            {
                throw (RuntimeException)throwable1;
            }
            break label0;
        }
        throwable1;
        if (true) goto _L2; else goto _L1
_L1:
        if (throwable1 instanceof Error)
        {
            throw (Error)throwable1;
        } else
        {
            throw new WrappedException(throwable1);
        }
    }

    public static void setMainPrintValues(boolean flag)
    {
        mainPrintValues = flag;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        if (callcontext.pc == 0)
        {
            run(callcontext);
        }
    }

    public Object apply0()
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        match0(callcontext);
        return callcontext.runUntilValue();
    }

    public Object apply0(ModuleMethod modulemethod)
        throws Throwable
    {
        return applyN(modulemethod, Values.noArgs);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
        throws Throwable
    {
        return applyN(modulemethod, new Object[] {
            obj
        });
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        throws Throwable
    {
        return applyN(modulemethod, new Object[] {
            obj, obj1
        });
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
        throws Throwable
    {
        return applyN(modulemethod, new Object[] {
            obj, obj1, obj2
        });
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        throws Throwable
    {
        return applyN(modulemethod, new Object[] {
            obj, obj1, obj2, obj3
        });
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
        throws Throwable
    {
        int i;
        int j;
        i = aobj.length;
        j = modulemethod.numArgs();
        if (i < (j & 0xfff) || j >= 0 && i > j >> 12) goto _L2; else goto _L1
_L1:
        i;
        JVM INSTR tableswitch 0 4: default 68
    //                   0 78
    //                   1 84
    //                   2 93
    //                   3 105
    //                   4 120;
           goto _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        throw new WrongArguments(modulemethod, i);
_L3:
        return apply0(modulemethod);
_L4:
        return apply1(modulemethod, aobj[0]);
_L5:
        return apply2(modulemethod, aobj[0], aobj[1]);
_L6:
        return apply3(modulemethod, aobj[0], aobj[1], aobj[2]);
_L7:
        return apply4(modulemethod, aobj[0], aobj[1], aobj[2], aobj[3]);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (j > 0)
        {
            return 0xfff10000 | j;
        }
        if (i < 0)
        {
            return matchN(modulemethod, ProcedureN.noArgs, callcontext);
        } else
        {
            callcontext.count = 0;
            callcontext.where = 0;
            callcontext.next = 0;
            callcontext.proc = modulemethod;
            return 0;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (j > 1)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i >>= 12;
            if (i < 1)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.count = 1;
                callcontext.where = 1;
                callcontext.next = 0;
                callcontext.proc = modulemethod;
                return 0;
            }
        } else
        {
            return matchN(modulemethod, new Object[] {
                obj
            }, callcontext);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (j > 2)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i >>= 12;
            if (i < 2)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.count = 2;
                callcontext.where = 33;
                callcontext.next = 0;
                callcontext.proc = modulemethod;
                return 0;
            }
        } else
        {
            return matchN(modulemethod, new Object[] {
                obj, obj1
            }, callcontext);
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (j > 3)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i >>= 12;
            if (i < 3)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.count = 3;
                callcontext.where = 801;
                callcontext.next = 0;
                callcontext.proc = modulemethod;
                return 0;
            }
        } else
        {
            return matchN(modulemethod, new Object[] {
                obj, obj1, obj2
            }, callcontext);
        }
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (j > 4)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            i >>= 12;
            if (i < 4)
            {
                return 0xfff20000 | i;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.count = 4;
                callcontext.where = 17185;
                callcontext.next = 0;
                callcontext.proc = modulemethod;
                return 0;
            }
        } else
        {
            return matchN(modulemethod, new Object[] {
                obj, obj1, obj2, obj3
            }, callcontext);
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (aobj.length < j)
        {
            return 0xfff10000 | j;
        }
        if (i >= 0)
        {
            switch (aobj.length)
            {
            default:
                i >>= 12;
                if (aobj.length > i)
                {
                    return 0xfff20000 | i;
                }
                break;

            case 0: // '\0'
                return match0(modulemethod, callcontext);

            case 1: // '\001'
                return match1(modulemethod, aobj[0], callcontext);

            case 2: // '\002'
                return match2(modulemethod, aobj[0], aobj[1], callcontext);

            case 3: // '\003'
                return match3(modulemethod, aobj[0], aobj[1], aobj[2], callcontext);

            case 4: // '\004'
                return match4(modulemethod, aobj[0], aobj[1], aobj[2], aobj[3], callcontext);
            }
        }
        callcontext.values = aobj;
        callcontext.count = aobj.length;
        callcontext.where = 0;
        callcontext.next = 0;
        callcontext.proc = modulemethod;
        return 0;
    }

    public void run()
    {
        this;
        JVM INSTR monitorenter ;
        if (!runDone)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        runDone = true;
        this;
        JVM INSTR monitorexit ;
        run(((Consumer) (VoidConsumer.instance)));
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void run(Consumer consumer)
    {
        CallContext callcontext;
        Consumer consumer1;
        callcontext = CallContext.getInstance();
        consumer1 = callcontext.consumer;
        callcontext.consumer = consumer;
        run(callcontext);
        consumer = null;
_L2:
        runCleanup(callcontext, consumer, consumer1);
        return;
        consumer;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void run(CallContext callcontext)
        throws Throwable
    {
    }

    public final void runAsMain()
    {
        WriterManager.instance.registerShutdownHook();
        CallContext callcontext;
        callcontext = CallContext.getInstance();
        if (!getMainPrintValues())
        {
            break MISSING_BLOCK_LABEL_49;
        }
        OutPort outport = OutPort.outDefault();
        callcontext.consumer = Shell.getOutputConsumer(outport);
        run(callcontext);
        callcontext.runUntilDone();
        outport.freshLine();
_L1:
        OutPort.runCleanups();
        exitDecrement();
        return;
        try
        {
            run();
            callcontext.runUntilDone();
        }
        catch (Throwable throwable)
        {
            throwable.printStackTrace();
            OutPort.runCleanups();
            System.exit(-1);
            return;
        }
          goto _L1
    }
}
