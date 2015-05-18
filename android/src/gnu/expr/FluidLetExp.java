// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Scope;
import gnu.bytecode.Type;
import gnu.bytecode.Variable;
import gnu.mapping.OutPort;

// Referenced classes of package gnu.expr:
//            LetExp, Compilation, Declaration, Target, 
//            Expression, IgnoreTarget, StackTarget, ExpVisitor

public class FluidLetExp extends LetExp
{

    public FluidLetExp(Expression aexpression[])
    {
        super(aexpression);
    }

    private void doInits(Declaration declaration, int i, Variable avariable[], Compilation compilation, Variable variable)
    {
        if (i >= inits.length)
        {
            return;
        } else
        {
            CodeAttr codeattr = compilation.getCode();
            avariable[i] = codeattr.addLocal(Type.pointer_type);
            declaration.allocateVariable(codeattr);
            declaration.base.load(null, 2, compilation, Target.pushObject);
            codeattr.emitDup();
            codeattr.emitStore(declaration.getVariable());
            inits[i].compile(compilation, Target.pushObject);
            doInits(declaration.nextDecl(), i + 1, avariable, compilation, variable);
            codeattr.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setWithSave", 1));
            codeattr.emitStore(avariable[i]);
            return;
        }
    }

    public void compile(Compilation compilation, Target target)
    {
        CodeAttr codeattr = compilation.getCode();
        Object obj;
        Type type;
        Object obj1;
        Variable avariable[];
        Variable variable;
        int i;
        if (target instanceof IgnoreTarget)
        {
            type = null;
        } else
        {
            type = getType();
        }
        if (type == null)
        {
            obj = Target.Ignore;
        } else
        if (type == Type.pointer_type)
        {
            obj = Target.pushObject;
        } else
        {
            obj = new StackTarget(type);
        }
        obj1 = getVarScope();
        codeattr.enterScope(((Scope) (obj1)));
        variable = ((Scope) (obj1)).addVariable(codeattr, Compilation.typeCallContext, null);
        compilation.loadCallContext();
        codeattr.emitStore(variable);
        avariable = new Variable[inits.length];
        obj1 = firstDecl();
        doInits(((Declaration) (obj1)), 0, avariable, compilation, variable);
        codeattr.emitTryStart(true, type);
        body.compileWithPosition(compilation, ((Target) (obj)));
        codeattr.emitFinallyStart();
        i = 0;
        for (obj = obj1; i < inits.length; obj = ((Declaration) (obj)).nextDecl())
        {
            ((Declaration) (obj)).load(null, 2, compilation, Target.pushObject);
            codeattr.emitLoad(avariable[i]);
            codeattr.emitInvokeVirtual(Compilation.typeLocation.getDeclaredMethod("setRestore", 1));
            i++;
        }

        codeattr.emitTryCatchEnd();
        popScope(codeattr);
        if (type != null)
        {
            target.compileFromStack(compilation, type);
        }
    }

    protected boolean mustCompile()
    {
        return true;
    }

    public void print(OutPort outport)
    {
        print(outport, "(FluidLet", ")");
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitFluidLetExp(this, obj);
    }
}
