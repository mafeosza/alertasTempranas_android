// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            LetExp, Expression, QuoteExp, LambdaExp, 
//            Compilation, Declaration, ExpVisitor, Target

public class CatchClause extends LetExp
{

    CatchClause next;

    public CatchClause()
    {
        super(new Expression[] {
            QuoteExp.voidExp
        });
    }

    public CatchClause(LambdaExp lambdaexp)
    {
        this();
        Declaration declaration = lambdaexp.firstDecl();
        lambdaexp.remove(null, declaration);
        add(declaration);
        body = lambdaexp.body;
    }

    public CatchClause(Object obj, ClassType classtype)
    {
        this();
        addDeclaration(obj, classtype);
    }

    public void compile(Compilation compilation, Target target)
    {
        CodeAttr codeattr = compilation.getCode();
        gnu.bytecode.Variable variable = firstDecl().allocateVariable(codeattr);
        codeattr.enterScope(getVarScope());
        codeattr.emitCatchStart(variable);
        body.compileWithPosition(compilation, target);
        codeattr.emitCatchEnd();
        codeattr.popScope();
    }

    protected Object evalVariable(int i, CallContext callcontext)
        throws Throwable
    {
        return callcontext.value1;
    }

    public final Expression getBody()
    {
        return body;
    }

    public final CatchClause getNext()
    {
        return next;
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.writeSpaceLinear();
        outport.startLogicalBlock("(Catch", ")", 2);
        outport.writeSpaceFill();
        decls.printInfo(outport);
        outport.writeSpaceLinear();
        body.print(outport);
        outport.endLogicalBlock(")");
    }

    public final void setBody(Expression expression)
    {
        body = expression;
    }

    public final void setNext(CatchClause catchclause)
    {
        next = catchclause;
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        body = expvisitor.visitAndUpdate(body, obj);
    }
}
