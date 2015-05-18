// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.math.IntNum;

// Referenced classes of package gnu.mapping:
//            ValueStack, Values, WrongArguments, Procedure

public class CallContext
{

    public static final int ARG_IN_IVALUE1 = 5;
    public static final int ARG_IN_IVALUE2 = 6;
    public static final int ARG_IN_VALUE1 = 1;
    public static final int ARG_IN_VALUE2 = 2;
    public static final int ARG_IN_VALUE3 = 3;
    public static final int ARG_IN_VALUE4 = 4;
    public static final int ARG_IN_VALUES_ARRAY = 0;
    static ThreadLocal currentContext = new ThreadLocal();
    public Consumer consumer;
    public int count;
    public Object evalFrames[][];
    public int ivalue1;
    public int ivalue2;
    public int next;
    public int pc;
    public Procedure proc;
    public Object value1;
    public Object value2;
    public Object value3;
    public Object value4;
    public Object values[];
    public ValueStack vstack;
    public int where;

    public CallContext()
    {
        vstack = new ValueStack();
        consumer = vstack;
    }

    public static CallContext getInstance()
    {
        CallContext callcontext1 = getOnlyInstance();
        CallContext callcontext = callcontext1;
        if (callcontext1 == null)
        {
            callcontext = new CallContext();
            setInstance(callcontext);
        }
        return callcontext;
    }

    public static CallContext getOnlyInstance()
    {
        return (CallContext)currentContext.get();
    }

    public static void setInstance(CallContext callcontext)
    {
        Thread.currentThread();
        currentContext.set(callcontext);
    }

    public final void cleanupFromContext(int i)
    {
        ValueStack valuestack = vstack;
        char ac[] = valuestack.data;
        int j = ac[i - 2] << 16 | ac[i - 1] & 0xffff;
        consumer = (Consumer)valuestack.objects[j];
        valuestack.objects[j] = null;
        valuestack.oindex = j;
        valuestack.gapStart = i - 3;
    }

    Object getArgAsObject(int i)
    {
        if (i >= 8) goto _L2; else goto _L1
_L1:
        where >> i * 4 & 0xf;
        JVM INSTR tableswitch 1 6: default 56
    //                   1 63
    //                   2 68
    //                   3 73
    //                   4 78
    //                   5 83
    //                   6 91;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L2:
        return values[i];
_L3:
        return value1;
_L4:
        return value2;
_L5:
        return value3;
_L6:
        return value4;
_L7:
        return IntNum.make(ivalue1);
_L8:
        return IntNum.make(ivalue2);
    }

    public int getArgCount()
    {
        return count;
    }

    public Object[] getArgs()
    {
        if (where != 0) goto _L2; else goto _L1
_L1:
        Object aobj[] = values;
_L4:
        return aobj;
_L2:
        int j = count;
        next = 0;
        Object aobj1[] = new Object[j];
        int i = 0;
        do
        {
            aobj = aobj1;
            if (i >= j)
            {
                continue;
            }
            aobj1[i] = getNextArg();
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final Object getFromContext(int i)
        throws Throwable
    {
        runUntilDone();
        Object obj = vstack;
        obj = Values.make(((gnu.lists.TreeList) (obj)), i, ((ValueStack) (obj)).gapStart);
        cleanupFromContext(i);
        return obj;
    }

    public Object getNextArg()
    {
        if (next >= count)
        {
            throw new WrongArguments(null, count);
        } else
        {
            int i = next;
            next = i + 1;
            return getArgAsObject(i);
        }
    }

    public Object getNextArg(Object obj)
    {
        if (next >= count)
        {
            return obj;
        } else
        {
            int i = next;
            next = i + 1;
            return getArgAsObject(i);
        }
    }

    public int getNextIntArg()
    {
        if (next >= count)
        {
            throw new WrongArguments(null, count);
        } else
        {
            int i = next;
            next = i + 1;
            return ((Number)getArgAsObject(i)).intValue();
        }
    }

    public int getNextIntArg(int i)
    {
        if (next >= count)
        {
            return i;
        } else
        {
            i = next;
            next = i + 1;
            return ((Number)getArgAsObject(i)).intValue();
        }
    }

    public final Object[] getRestArgsArray(int i)
    {
        Object aobj[] = new Object[count - i];
        int j = 0;
        for (; i < count; i++)
        {
            aobj[j] = getArgAsObject(i);
            j++;
        }

        return aobj;
    }

    public final LList getRestArgsList(int i)
    {
        LList llist = LList.Empty;
        Object obj = llist;
        Pair pair1 = null;
        while (i < count) 
        {
            Pair pair = new Pair(getArgAsObject(i), llist);
            if (pair1 == null)
            {
                obj = pair;
            } else
            {
                pair1.setCdr(pair);
            }
            i++;
            pair1 = pair;
        }
        return ((LList) (obj));
    }

    public void lastArg()
    {
        if (next < count)
        {
            throw new WrongArguments(null, count);
        } else
        {
            values = null;
            return;
        }
    }

    public void runUntilDone()
        throws Throwable
    {
        do
        {
            Procedure procedure = proc;
            if (procedure == null)
            {
                return;
            }
            proc = null;
            procedure.apply(this);
        } while (true);
    }

    public final Object runUntilValue()
        throws Throwable
    {
        Consumer consumer1;
        ValueStack valuestack;
        int i;
        int j;
        consumer1 = consumer;
        valuestack = vstack;
        consumer = valuestack;
        i = valuestack.gapStart;
        j = valuestack.oindex;
        Object obj;
        runUntilDone();
        obj = Values.make(valuestack, i, valuestack.gapStart);
        consumer = consumer1;
        valuestack.gapStart = i;
        valuestack.oindex = j;
        return obj;
        Exception exception;
        exception;
        consumer = consumer1;
        valuestack.gapStart = i;
        valuestack.oindex = j;
        throw exception;
    }

    public final void runUntilValue(Consumer consumer1)
        throws Throwable
    {
        Consumer consumer2;
        consumer2 = consumer;
        consumer = consumer1;
        runUntilDone();
        consumer = consumer2;
        return;
        consumer1;
        consumer = consumer2;
        throw consumer1;
    }

    public final int startFromContext()
    {
        ValueStack valuestack = vstack;
        int i = valuestack.find(consumer);
        valuestack.ensureSpace(3);
        int j = valuestack.gapStart;
        char ac[] = valuestack.data;
        int k = j + 1;
        ac[j] = '\uF102';
        valuestack.setIntN(k, i);
        i = k + 2;
        consumer = valuestack;
        valuestack.gapStart = i;
        return i;
    }

    public void writeValue(Object obj)
    {
        Values.writeValues(obj, consumer);
    }

}
