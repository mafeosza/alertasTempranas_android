// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConsumerTarget;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.Inlineable;
import gnu.expr.Special;
import gnu.expr.Target;
import gnu.lists.Consumable;
import gnu.mapping.CallContext;
import gnu.mapping.MethodProc;
import gnu.mapping.Procedure;

public class AppendValues extends MethodProc
    implements Inlineable
{

    public static final AppendValues appendValues = new AppendValues();

    public AppendValues()
    {
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyAppendValues");
    }

    public void apply(CallContext callcontext)
    {
        Special special = Special.dfault;
        do
        {
            Object obj = callcontext.getNextArg(special);
            if (obj == special)
            {
                return;
            }
            if (obj instanceof Consumable)
            {
                ((Consumable)obj).consume(callcontext.consumer);
            } else
            {
                callcontext.writeValue(obj);
            }
        } while (true);
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Expression aexpression[] = applyexp.getArgs();
        int j = aexpression.length;
        if ((target instanceof ConsumerTarget) || (target instanceof IgnoreTarget))
        {
            for (int i = 0; i < j; i++)
            {
                aexpression[i].compileWithPosition(compilation, target);
            }

        } else
        {
            ConsumerTarget.compileUsingConsumer(applyexp, compilation, target);
        }
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Compilation.typeObject;
    }

}
