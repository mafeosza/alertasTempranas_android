// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;

// Referenced classes of package gnu.expr:
//            ReferenceExp, Declaration, IgnoreTarget, Compilation, 
//            Target, ClassExp, ModuleExp, ScopeExp, 
//            ExpVisitor

public class ThisExp extends ReferenceExp
{

    static int EVAL_TO_CONTEXT = 2;
    public static final String THIS_NAME = new String("$this$");
    ScopeExp context;

    public ThisExp()
    {
        super(THIS_NAME);
    }

    public ThisExp(ClassType classtype)
    {
        this(new Declaration(THIS_NAME, classtype));
    }

    public ThisExp(Declaration declaration)
    {
        super(THIS_NAME, declaration);
    }

    public ThisExp(ScopeExp scopeexp)
    {
        super(THIS_NAME);
        context = scopeexp;
    }

    public static ThisExp makeGivingContext(ScopeExp scopeexp)
    {
        scopeexp = new ThisExp(scopeexp);
        scopeexp.flags = ((ThisExp) (scopeexp)).flags | EVAL_TO_CONTEXT;
        return scopeexp;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        if (isForContext())
        {
            callcontext.writeValue(context);
            return;
        } else
        {
            super.apply(callcontext);
            return;
        }
    }

    public void compile(Compilation compilation, Target target)
    {
        if (target instanceof IgnoreTarget)
        {
            return;
        }
        if (isForContext())
        {
            CodeAttr codeattr = compilation.getCode();
            if (compilation.method.getStaticFlag())
            {
                codeattr.emitGetStatic(compilation.moduleInstanceMainField);
            } else
            {
                codeattr.emitPushThis();
            }
            target.compileFromStack(compilation, getType());
            return;
        } else
        {
            super.compile(compilation, target);
            return;
        }
    }

    public ScopeExp getContextScope()
    {
        return context;
    }

    public final Type getType()
    {
        if (binding != null)
        {
            return binding.getType();
        }
        if ((context instanceof ClassExp) || (context instanceof ModuleExp))
        {
            return context.getType();
        } else
        {
            return Type.pointer_type;
        }
    }

    public final boolean isForContext()
    {
        return (flags & EVAL_TO_CONTEXT) != 0;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitThisExp(this, obj);
    }

}
