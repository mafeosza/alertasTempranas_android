// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            CodeAttr, Label, Variable, ExitableBlock, 
//            Type, ClassType

public class TryState
{

    Label end_label;
    Label end_try;
    Variable exception;
    ExitableBlock exitCases;
    Variable finally_ret_addr;
    Label finally_subr;
    TryState previous;
    Variable savedStack[];
    Type savedTypes[];
    Variable saved_result;
    Label start_try;
    boolean tryClauseDone;
    ClassType try_type;

    public TryState(CodeAttr codeattr)
    {
        previous = codeattr.try_stack;
        codeattr.try_stack = this;
        start_try = codeattr.getLabel();
    }

    static TryState outerHandler(TryState trystate, TryState trystate1)
    {
        for (; trystate != trystate1 && (trystate.finally_subr == null || trystate.tryClauseDone); trystate = trystate.previous) { }
        return trystate;
    }
}
