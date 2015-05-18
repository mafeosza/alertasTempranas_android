// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.Target;
import gnu.mapping.ProcedureN;

// Referenced classes of package gnu.kawa.functions:
//            AppendValues

class CompileTimeContinuation extends ProcedureN
    implements Inlineable
{

    Target blockTarget;
    ExitableBlock exitableBlock;

    CompileTimeContinuation()
    {
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        throw new Error("internal error");
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        compilation.getCode();
        applyexp = applyexp.getArgs();
        int j = applyexp.length;
        int i;
        if ((blockTarget instanceof IgnoreTarget) || (blockTarget instanceof ConsumerTarget))
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            target.getType();
        }
        if (i != 0 || j == 1)
        {
            for (i = 0; i < j; i++)
            {
                applyexp[i].compileWithPosition(compilation, blockTarget);
            }

        } else
        {
            target = AppendValues.appendValues;
            target.compile(new ApplyExp(target, applyexp), compilation, blockTarget);
        }
        exitableBlock.exit();
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.neverReturnsType;
    }
}
