// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            Expression, CatchClause, Declaration, Compilation, 
//            StackTarget, ConsumerTarget, IgnoreTarget, ConditionalTarget, 
//            Target, ExpVisitor

public class TryExp extends Expression
{

    CatchClause catch_clauses;
    Expression finally_clause;
    Expression try_clause;

    public TryExp(Expression expression, Expression expression1)
    {
        try_clause = expression;
        finally_clause = expression1;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        try_clause.apply(callcontext);
        callcontext.runUntilDone();
        if (finally_clause != null)
        {
            finally_clause.eval(callcontext);
        }
_L2:
        return;
        Throwable throwable;
        throwable;
        CatchClause catchclause = catch_clauses;
_L3:
        if (catchclause == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        if (!((ClassType)catchclause.firstDecl().getTypeExp().eval(callcontext)).isInstance(throwable))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        callcontext.value1 = throwable;
        catchclause.apply(callcontext);
        if (finally_clause == null) goto _L2; else goto _L1
_L1:
        finally_clause.eval(callcontext);
        return;
        catchclause = catchclause.next;
          goto _L3
        throw throwable;
        Exception exception;
        exception;
        if (finally_clause != null)
        {
            finally_clause.eval(callcontext);
        }
        throw exception;
    }

    public void compile(Compilation compilation, Target target)
    {
        CodeAttr codeattr = compilation.getCode();
        Target target1;
        Object obj;
        boolean flag;
        if (finally_clause != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((target instanceof StackTarget) || (target instanceof ConsumerTarget) || (target instanceof IgnoreTarget) || (target instanceof ConditionalTarget) && finally_clause == null)
        {
            target1 = target;
        } else
        {
            target1 = Target.pushValue(target.getType());
        }
        if (target1 instanceof StackTarget)
        {
            obj = target1.getType();
        } else
        {
            obj = null;
        }
        codeattr.emitTryStart(flag, ((Type) (obj)));
        try_clause.compileWithPosition(compilation, target1);
        for (obj = catch_clauses; obj != null; obj = ((CatchClause) (obj)).getNext())
        {
            ((CatchClause) (obj)).compile(compilation, target1);
        }

        if (finally_clause != null)
        {
            codeattr.emitFinallyStart();
            finally_clause.compileWithPosition(compilation, Target.Ignore);
            codeattr.emitFinallyEnd();
        }
        codeattr.emitTryCatchEnd();
        if (target1 != target)
        {
            target.compileFromStack(compilation, target.getType());
        }
    }

    public final CatchClause getCatchClauses()
    {
        return catch_clauses;
    }

    public final Expression getFinallyClause()
    {
        return finally_clause;
    }

    public Type getType()
    {
        if (catch_clauses == null)
        {
            return try_clause.getType();
        } else
        {
            return super.getType();
        }
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Try", ")", 2);
        outport.writeSpaceFill();
        try_clause.print(outport);
        for (CatchClause catchclause = catch_clauses; catchclause != null; catchclause = catchclause.getNext())
        {
            catchclause.print(outport);
        }

        if (finally_clause != null)
        {
            outport.writeSpaceLinear();
            outport.print(" finally: ");
            finally_clause.print(outport);
        }
        outport.endLogicalBlock(")");
    }

    public final void setCatchClauses(CatchClause catchclause)
    {
        catch_clauses = catchclause;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitTryExp(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        try_clause = expvisitor.visitAndUpdate(try_clause, obj);
        for (CatchClause catchclause = catch_clauses; expvisitor.exitValue == null && catchclause != null; catchclause = catchclause.getNext())
        {
            expvisitor.visit(catchclause, obj);
        }

        if (expvisitor.exitValue == null && finally_clause != null)
        {
            finally_clause = expvisitor.visitAndUpdate(finally_clause, obj);
        }
    }
}
