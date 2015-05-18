// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            RunnableClosure, Environment, Procedure, CallContext, 
//            InPort, OutPort

public class Future extends Thread
{

    public RunnableClosure closure;

    public Future(Procedure procedure)
    {
        closure = new RunnableClosure(procedure);
    }

    public Future(Procedure procedure, CallContext callcontext)
    {
        closure = new RunnableClosure(procedure, callcontext);
    }

    public Future(Procedure procedure, InPort inport, OutPort outport, OutPort outport1)
    {
        closure = new RunnableClosure(procedure, inport, outport, outport1);
    }

    public static Future make(Procedure procedure, Environment environment, InPort inport, OutPort outport, OutPort outport1)
    {
        environment = Environment.setSaveCurrent(environment);
        procedure = new Future(procedure, inport, outport, outport1);
        Environment.restoreCurrent(environment);
        return procedure;
        procedure;
        Environment.restoreCurrent(environment);
        throw procedure;
    }

    public final CallContext getCallContext()
    {
        return closure.getCallContext();
    }

    public void run()
    {
        closure.run();
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("#<future ");
        stringbuffer.append(getName());
        stringbuffer.append(">");
        return stringbuffer.toString();
    }

    public Object waitForResult()
        throws Throwable
    {
        Throwable throwable;
        try
        {
            join();
        }
        catch (InterruptedException interruptedexception)
        {
            throw new RuntimeException("thread join [force] was interrupted");
        }
        throwable = closure.exception;
        if (throwable != null)
        {
            throw throwable;
        } else
        {
            return closure.result;
        }
    }
}
