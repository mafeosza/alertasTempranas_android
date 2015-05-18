// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.ExitableBlock;
import gnu.bytecode.Label;
import gnu.bytecode.Type;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.mapping.Values;

// Referenced classes of package gnu.expr:
//            Expression, Compilation, ConditionalTarget, QuoteExp, 
//            Language, ReferenceExp, ExitExp, BlockExp, 
//            IgnoreTarget, ExpVisitor, Target

public class IfExp extends Expression
{

    Expression else_clause;
    Expression test;
    Expression then_clause;

    public IfExp(Expression expression, Expression expression1, Expression expression2)
    {
        test = expression;
        then_clause = expression1;
        else_clause = expression2;
    }

    public static void compile(Expression expression, Expression expression1, Expression expression2, Compilation compilation, Target target)
    {
        Label label;
        CodeAttr codeattr;
        boolean flag;
        boolean flag1;
        Object obj = compilation.getLanguage();
        codeattr = compilation.getCode();
        Label label1 = null;
        if ((target instanceof ConditionalTarget) && (expression2 instanceof QuoteExp))
        {
            flag = true;
            if (((Language) (obj)).isTrue(((QuoteExp)expression2).getValue()))
            {
                label = ((ConditionalTarget)target).ifTrue;
            } else
            {
                label = ((ConditionalTarget)target).ifFalse;
            }
        } else
        {
label0:
            {
                label = label1;
                if (!(expression2 instanceof ExitExp))
                {
                    break label0;
                }
                label = label1;
                if (!(((ExitExp)expression2).result instanceof QuoteExp))
                {
                    break label0;
                }
                BlockExp blockexp = ((ExitExp)expression2).block;
                label = label1;
                if (!(blockexp.exitTarget instanceof IgnoreTarget))
                {
                    break label0;
                }
                label1 = blockexp.exitableBlock.exitIsGoto();
                label = label1;
                if (label1 == null)
                {
                    break label0;
                }
                flag = true;
                label = label1;
            }
        }
_L1:
        label1 = label;
        if (label == null)
        {
            label1 = new Label(codeattr);
        }
        if (expression == expression1 && (target instanceof ConditionalTarget) && (expression1 instanceof ReferenceExp))
        {
            flag1 = true;
            label = ((ConditionalTarget)target).ifTrue;
        } else
        {
            flag1 = false;
            label = new Label(codeattr);
        }
        obj = new ConditionalTarget(label, label1, ((Language) (obj)));
        if (flag1)
        {
            obj.trueBranchComesFirst = false;
        }
        expression.compile(compilation, ((Target) (obj)));
        codeattr.emitIfThen();
        if (!flag1)
        {
            label.define(codeattr);
            expression = compilation.callContextVar;
            expression1.compileWithPosition(compilation, target);
            compilation.callContextVar = expression;
        }
        if (!flag)
        {
            codeattr.emitElse();
            label1.define(codeattr);
            expression = compilation.callContextVar;
            if (expression2 == null)
            {
                compilation.compileConstant(Values.empty, target);
            } else
            {
                expression2.compileWithPosition(compilation, target);
            }
            compilation.callContextVar = expression;
        } else
        {
            codeattr.setUnreachable();
        }
        codeattr.emitFi();
        return;
        flag = false;
          goto _L1
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        if (getLanguage().isTrue(test.eval(callcontext)))
        {
            then_clause.apply(callcontext);
        } else
        if (else_clause != null)
        {
            else_clause.apply(callcontext);
            return;
        }
    }

    public void compile(Compilation compilation, Target target)
    {
        Expression expression = test;
        Expression expression1 = then_clause;
        Object obj;
        if (else_clause == null)
        {
            obj = QuoteExp.voidExp;
        } else
        {
            obj = else_clause;
        }
        compile(expression, expression1, ((Expression) (obj)), compilation, target);
    }

    public Expression getElseClause()
    {
        return else_clause;
    }

    protected final Language getLanguage()
    {
        return Language.getDefaultLanguage();
    }

    public Expression getTest()
    {
        return test;
    }

    public Expression getThenClause()
    {
        return then_clause;
    }

    public Type getType()
    {
        Type type = then_clause.getType();
        Object obj;
        if (else_clause == null)
        {
            obj = Type.voidType;
        } else
        {
            obj = else_clause.getType();
        }
        return Language.unionType(type, ((Type) (obj)));
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(If ", false, ")");
        outport.setIndentation(-2, false);
        test.print(outport);
        outport.writeSpaceLinear();
        then_clause.print(outport);
        if (else_clause != null)
        {
            outport.writeSpaceLinear();
            else_clause.print(outport);
        }
        outport.endLogicalBlock(")");
    }

    Expression select(boolean flag)
    {
        if (flag)
        {
            return then_clause;
        }
        if (else_clause == null)
        {
            return QuoteExp.voidExp;
        } else
        {
            return else_clause;
        }
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitIfExp(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        test = expvisitor.visitAndUpdate(test, obj);
        if (expvisitor.exitValue == null)
        {
            then_clause = expvisitor.visitAndUpdate(then_clause, obj);
        }
        if (expvisitor.exitValue == null && else_clause != null)
        {
            else_clause = expvisitor.visitAndUpdate(else_clause, obj);
        }
    }
}
