// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.Procedure1or2;
import gnu.text.SourceMessages;
import java.util.Stack;

// Referenced classes of package kawa.lang:
//            Translator

public class Eval extends Procedure1or2
{

    public static final Eval eval;
    static final String evalFunctionName = "atEvalLevel$";

    public Eval()
    {
    }

    public static Object eval(Object obj, Environment environment)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        int i = callcontext.startFromContext();
        try
        {
            eval(obj, environment, callcontext);
            obj = callcontext.getFromContext(i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            callcontext.cleanupFromContext(i);
            throw obj;
        }
        return obj;
    }

    public static void eval(Object obj, Environment environment, CallContext callcontext)
        throws Throwable
    {
        if (obj instanceof PairWithPosition)
        {
            obj = new PairWithPosition((PairWithPosition)obj, obj, LList.Empty);
        } else
        {
            obj = new PairWithPosition(obj, LList.Empty);
            ((PairWithPosition) (obj)).setFile("<eval>");
        }
        evalBody(obj, environment, new SourceMessages(), callcontext);
    }

    public static Object evalBody(Object obj, Environment environment, SourceMessages sourcemessages)
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        int i = callcontext.startFromContext();
        try
        {
            evalBody(obj, environment, sourcemessages, callcontext);
            obj = callcontext.getFromContext(i);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            callcontext.cleanupFromContext(i);
            throw obj;
        }
        return obj;
    }

    public static void evalBody(Object obj, Environment environment, SourceMessages sourcemessages, CallContext callcontext)
        throws Throwable
    {
        Environment environment1;
        Object obj1;
        obj1 = Language.getDefaultLanguage();
        environment1 = Environment.getCurrent();
        if (environment == environment1)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        Environment.setCurrent(environment);
        ModuleExp moduleexp;
        Compilation compilation;
        obj1 = new Translator(((Language) (obj1)), sourcemessages, NameLookup.getInstance(environment, ((Language) (obj1))));
        obj1.immediate = true;
        ((Translator) (obj1)).setState(3);
        ((Translator) (obj1)).setSharedModuleDefs(true);
        moduleexp = ((Translator) (obj1)).pushNewModule((String)null);
        compilation = Compilation.setSaveCurrent(((Compilation) (obj1)));
        int i = ((Translator) (obj1)).formStack.size();
        ((Translator) (obj1)).scanBody(obj, moduleexp, false);
        obj1.firstForm = i;
        ((Translator) (obj1)).finishModule(moduleexp);
        Compilation.restoreCurrent(compilation);
        if (obj instanceof PairWithPosition)
        {
            moduleexp.setFile(((PairWithPosition)obj).getFileName());
        }
        obj = (new StringBuilder()).append("atEvalLevel$");
        int j = ModuleExp.interactiveCounter + 1;
        ModuleExp.interactiveCounter = j;
        moduleexp.setName(((StringBuilder) (obj)).append(j).toString());
        ModuleExp.evalModule(environment, callcontext, ((Compilation) (obj1)), null, null);
        if (sourcemessages.seenErrors())
        {
            throw new RuntimeException((new StringBuilder()).append("invalid syntax in eval form:\n").append(sourcemessages.toString(20)).toString());
        }
        break MISSING_BLOCK_LABEL_242;
        obj;
        if (environment != environment1)
        {
            Environment.setCurrent(environment1);
        }
        throw obj;
        obj;
        Compilation.restoreCurrent(compilation);
        throw obj;
        if (environment != environment1)
        {
            Environment.setCurrent(environment1);
        }
        return;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Procedure.checkArgCount(this, callcontext.count);
        Object obj = callcontext.getNextArg();
        Environment environment1 = (Environment)callcontext.getNextArg(null);
        Environment environment = environment1;
        if (environment1 == null)
        {
            environment = Environment.user();
        }
        callcontext.lastArg();
        eval(obj, environment, callcontext);
    }

    public Object apply1(Object obj)
        throws Throwable
    {
        return eval(obj, Environment.user());
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        return eval(obj, (Environment)obj1);
    }

    static 
    {
        eval = new Eval();
        eval.setName("eval");
    }
}
