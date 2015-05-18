// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            Expression, Compilation, Target, IgnoreTarget, 
//            ConsumerTarget, ExpVisitor

public class SynchronizedExp extends Expression
{

    Expression body;
    Expression object;

    public SynchronizedExp(Expression expression, Expression expression1)
    {
        object = expression;
        body = expression1;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object obj1;
        synchronized (object.eval(callcontext))
        {
            obj1 = body.eval(callcontext);
        }
        callcontext.writeValue(obj1);
        return;
        callcontext;
        obj;
        JVM INSTR monitorexit ;
        throw callcontext;
    }

    public void compile(Compilation compilation, Target target)
    {
        CodeAttr codeattr = compilation.getCode();
        object.compile(compilation, Target.pushObject);
        codeattr.emitDup(1);
        gnu.bytecode.Variable variable = codeattr.pushScope().addVariable(codeattr, Type.pointer_type, null);
        codeattr.emitStore(variable);
        codeattr.emitMonitorEnter();
        Type type;
        if ((target instanceof IgnoreTarget) || (target instanceof ConsumerTarget))
        {
            type = null;
        } else
        {
            type = target.getType();
        }
        codeattr.emitTryStart(false, type);
        body.compileWithPosition(compilation, target);
        codeattr.emitLoad(variable);
        codeattr.emitMonitorExit();
        codeattr.emitTryEnd();
        codeattr.emitCatchStart(null);
        codeattr.emitLoad(variable);
        codeattr.emitMonitorExit();
        codeattr.emitThrow();
        codeattr.emitCatchEnd();
        codeattr.emitTryCatchEnd();
        codeattr.popScope();
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.print("(Synchronized ");
        object.print(outport);
        outport.print(" ");
        body.print(outport);
        outport.print(")");
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitSynchronizedExp(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        object = expvisitor.visitAndUpdate(object, obj);
        if (expvisitor.exitValue == null)
        {
            body = expvisitor.visitAndUpdate(body, obj);
        }
    }
}
