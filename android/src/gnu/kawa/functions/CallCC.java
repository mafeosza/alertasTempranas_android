// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;
import kawa.lang.Continuation;

// Referenced classes of package gnu.kawa.functions:
//            CompileMisc

public class CallCC extends MethodProc
    implements Inlineable
{

    public static final CallCC callcc = new CallCC();

    CallCC()
    {
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyCallCC");
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Procedure procedure = (Procedure)callcontext.value1;
        Continuation continuation = new Continuation(callcontext);
        procedure.check1(continuation, callcontext);
        procedure = callcontext.proc;
        callcontext.proc = null;
        try
        {
            procedure.apply(callcontext);
            callcontext.runUntilDone();
            continuation.invoked = true;
            return;
        }
        catch (Throwable throwable)
        {
            Continuation.handleException$X(throwable, continuation, callcontext);
        }
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        CompileMisc.compileCallCC(applyexp, compilation, target, this);
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.pointer_type;
    }

    public int match1(Object obj, CallContext callcontext)
    {
        if (!(obj instanceof Procedure))
        {
            return 0xfff40000;
        } else
        {
            return super.match1(obj, callcontext);
        }
    }

    public int numArgs()
    {
        return 4097;
    }

}
