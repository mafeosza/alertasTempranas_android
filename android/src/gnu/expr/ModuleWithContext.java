// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.mapping.CallContext;
import gnu.mapping.ProcedureN;

// Referenced classes of package gnu.expr:
//            ModuleBody, ModuleMethod

public abstract class ModuleWithContext extends ModuleBody
{

    public ModuleWithContext()
    {
    }

    public Object apply0(ModuleMethod modulemethod)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        modulemethod.check0(callcontext);
        return callcontext.runUntilValue();
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        modulemethod.check1(obj, callcontext);
        return callcontext.runUntilValue();
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        modulemethod.check2(obj, obj1, callcontext);
        return callcontext.runUntilValue();
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        modulemethod.check3(obj, obj1, obj2, callcontext);
        return callcontext.runUntilValue();
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        modulemethod.check4(obj, obj1, obj2, obj3, callcontext);
        return callcontext.runUntilValue();
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        modulemethod.checkN(aobj, callcontext);
        return callcontext.runUntilValue();
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        int i = modulemethod.numArgs();
        int j = i & 0xfff;
        if (j > 0)
        {
            return 0xfff10000 | j;
        }
        callcontext.count = 0;
        callcontext.where = 0;
        if (i < 0)
        {
            return matchN(modulemethod, ProcedureN.noArgs, callcontext);
        } else
        {
            callcontext.next = 0;
            callcontext.proc = this;
            callcontext.pc = modulemethod.selector;
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
                callcontext.proc = this;
                callcontext.pc = modulemethod.selector;
                return 0;
            }
        } else
        {
            callcontext.where = 0;
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
                callcontext.proc = this;
                callcontext.pc = modulemethod.selector;
                return 0;
            }
        } else
        {
            callcontext.where = 0;
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
                callcontext.proc = this;
                callcontext.pc = modulemethod.selector;
                return 0;
            }
        } else
        {
            callcontext.where = 0;
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
                callcontext.proc = this;
                callcontext.pc = modulemethod.selector;
                return 0;
            }
        } else
        {
            callcontext.where = 0;
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
        callcontext.proc = this;
        callcontext.pc = modulemethod.selector;
        return 0;
    }
}
