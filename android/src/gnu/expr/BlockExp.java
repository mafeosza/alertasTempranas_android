// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            Expression, BlockExitException, ExitExp, Compilation, 
//            StackTarget, Target, Declaration, ExpVisitor

public class BlockExp extends Expression
{

    Expression body;
    Expression exitBody;
    Target exitTarget;
    ExitableBlock exitableBlock;
    Declaration label;

    public BlockExp()
    {
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object obj = body.eval(callcontext);
_L2:
        callcontext.writeValue(obj);
        return;
        BlockExitException blockexitexception;
        blockexitexception;
        if (blockexitexception.exit.block != this)
        {
            throw blockexitexception;
        }
        blockexitexception = blockexitexception.exit.result;
        if (exitBody != null)
        {
            blockexitexception = ((BlockExitException) (exitBody.eval(callcontext)));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void compile(Compilation compilation, Target target)
    {
        CodeAttr codeattr = compilation.getCode();
        Object obj;
        if (exitBody == null && (target instanceof StackTarget))
        {
            obj = target.getType();
        } else
        {
            obj = null;
        }
        exitableBlock = codeattr.startExitableBlock(((gnu.bytecode.Type) (obj)), true);
        if (exitBody == null)
        {
            obj = target;
        } else
        {
            obj = Target.Ignore;
        }
        exitTarget = ((Target) (obj));
        body.compileWithPosition(compilation, target);
        if (exitBody != null)
        {
            obj = new Label(codeattr);
            codeattr.emitGoto(((Label) (obj)));
            codeattr.endExitableBlock();
            exitBody.compileWithPosition(compilation, target);
            ((Label) (obj)).define(codeattr);
        } else
        {
            codeattr.endExitableBlock();
        }
        exitableBlock = null;
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Block", ")", 2);
        if (label != null)
        {
            outport.print(' ');
            outport.print(label.getName());
        }
        outport.writeSpaceLinear();
        body.print(outport);
        if (exitBody != null)
        {
            outport.writeSpaceLinear();
            outport.print("else ");
            exitBody.print(outport);
        }
        outport.endLogicalBlock(")");
    }

    public void setBody(Expression expression)
    {
        body = expression;
    }

    public void setBody(Expression expression, Expression expression1)
    {
        body = expression;
        exitBody = expression1;
    }

    public void setLabel(Declaration declaration)
    {
        label = declaration;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitBlockExp(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        body = expvisitor.visitAndUpdate(body, obj);
        if (expvisitor.exitValue == null && exitBody != null)
        {
            exitBody = expvisitor.visitAndUpdate(exitBody, obj);
        }
    }
}
