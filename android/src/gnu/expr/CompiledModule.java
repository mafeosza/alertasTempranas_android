// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import java.io.Writer;
import kawa.Shell;

// Referenced classes of package gnu.expr:
//            Language, ModuleExp, ModuleBody

public class CompiledModule
{

    Object cookie;
    Language language;
    ModuleExp mexp;

    public CompiledModule(ModuleExp moduleexp, Object obj, Language language1)
    {
        mexp = moduleexp;
        cookie = obj;
        language = language1;
    }

    public static CompiledModule make(Class class1, Language language1)
    {
        return new CompiledModule(null, class1, language1);
    }

    public void evalModule(Environment environment, CallContext callcontext)
        throws Throwable
    {
        Language language1;
        Environment environment1;
        language1 = Language.setSaveCurrent(language);
        environment1 = Environment.setSaveCurrent(environment);
        ModuleExp.evalModule2(environment, callcontext, language, mexp, cookie);
        Language.restoreCurrent(language1);
        Environment.restoreCurrent(environment1);
        return;
        environment;
        Language.restoreCurrent(language1);
        Environment.restoreCurrent(environment1);
        throw environment;
    }

    public void evalModule(Environment environment, OutPort outport)
        throws Throwable
    {
        CallContext callcontext;
        gnu.lists.Consumer consumer;
        gnu.lists.AbstractFormat abstractformat;
        callcontext = CallContext.getInstance();
        consumer = callcontext.consumer;
        boolean flag = ModuleBody.getMainPrintValues();
        abstractformat = outport.objectFormat;
        Object obj;
        if (flag)
        {
            obj = Shell.getOutputConsumer(outport);
        } else
        {
            obj = new VoidConsumer();
        }
        callcontext.consumer = ((gnu.lists.Consumer) (obj));
        evalModule(environment, callcontext);
        if (callcontext.consumer instanceof Writer)
        {
            ((Writer)callcontext.consumer).flush();
        }
        callcontext.consumer = consumer;
        outport.objectFormat = abstractformat;
        return;
        environment;
        if (callcontext.consumer instanceof Writer)
        {
            ((Writer)callcontext.consumer).flush();
        }
        callcontext.consumer = consumer;
        outport.objectFormat = abstractformat;
        throw environment;
    }

    public Object evalToResultValue(Environment environment, CallContext callcontext)
        throws Throwable
    {
        int i = callcontext.startFromContext();
        try
        {
            evalModule(environment, callcontext);
            environment = ((Environment) (callcontext.getFromContext(i)));
        }
        // Misplaced declaration of an exception variable
        catch (Environment environment)
        {
            callcontext.cleanupFromContext(i);
            throw environment;
        }
        return environment;
    }
}
