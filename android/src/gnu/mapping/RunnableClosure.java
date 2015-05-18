// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.util.concurrent.Callable;

// Referenced classes of package gnu.mapping:
//            CallContext, Environment, InPort, OutPort, 
//            Procedure

public class RunnableClosure
    implements Callable, Runnable
{

    static int nrunnables = 0;
    Procedure action;
    CallContext context;
    private OutPort err;
    Throwable exception;
    private InPort in;
    String name;
    private OutPort out;
    Object result;

    public RunnableClosure(Procedure procedure)
    {
        this(procedure, CallContext.getInstance());
    }

    public RunnableClosure(Procedure procedure, CallContext callcontext)
    {
        callcontext = (new StringBuilder()).append("r");
        int i = nrunnables;
        nrunnables = i + 1;
        setName(callcontext.append(i).toString());
        action = procedure;
    }

    public RunnableClosure(Procedure procedure, InPort inport, OutPort outport, OutPort outport1)
    {
        this(procedure, CallContext.getInstance());
        in = inport;
        out = outport;
        err = outport1;
    }

    public Object call()
        throws Exception
    {
        run();
        Throwable throwable = exception;
        if (throwable != null)
        {
            if (throwable instanceof Exception)
            {
                throw (Exception)throwable;
            }
            if (throwable instanceof Error)
            {
                throw (Error)throwable;
            } else
            {
                throw new RuntimeException(throwable);
            }
        } else
        {
            return result;
        }
    }

    public final CallContext getCallContext()
    {
        return context;
    }

    public String getName()
    {
        return name;
    }

    Object getResult()
        throws Throwable
    {
        Throwable throwable = exception;
        if (throwable != null)
        {
            throw throwable;
        } else
        {
            return result;
        }
    }

    public void run()
    {
        Environment environment;
        String s;
        try
        {
            environment = Environment.getCurrent();
            s = getName();
        }
        catch (Throwable throwable)
        {
            exception = throwable;
            return;
        }
        if (environment == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        if (environment.getSymbol() != null || s == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        environment.setName(s);
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_97;
        }
        context = CallContext.getInstance();
_L2:
        if (in != null)
        {
            InPort.setInDefault(in);
        }
        if (out != null)
        {
            OutPort.setOutDefault(out);
        }
        if (err != null)
        {
            OutPort.setErrDefault(err);
        }
        result = action.apply0();
        return;
        CallContext.setInstance(context);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void setName(String s)
    {
        name = s;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("#<runnable ");
        stringbuffer.append(getName());
        stringbuffer.append(">");
        return stringbuffer.toString();
    }

}
