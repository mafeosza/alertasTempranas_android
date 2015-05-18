// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Type;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.OutPort;
import gnu.text.Options;
import java.util.Vector;

// Referenced classes of package gnu.expr:
//            Expression, QuoteExp, Target, Compilation, 
//            ExpVisitor

public class BeginExp extends Expression
{

    Vector compileOptions;
    Expression exps[];
    int length;

    public BeginExp()
    {
    }

    public BeginExp(Expression expression, Expression expression1)
    {
        exps = new Expression[2];
        exps[0] = expression;
        exps[1] = expression1;
        length = 2;
    }

    public BeginExp(Expression aexpression[])
    {
        exps = aexpression;
        length = aexpression.length;
    }

    public static final Expression canonicalize(Expression expression)
    {
        if (expression instanceof BeginExp)
        {
            BeginExp beginexp = (BeginExp)expression;
            if (beginexp.compileOptions == null)
            {
                int i = beginexp.length;
                if (i == 0)
                {
                    return QuoteExp.voidExp;
                }
                if (i == 1)
                {
                    return canonicalize(beginexp.exps[0]);
                }
            }
        }
        return expression;
    }

    public static final Expression canonicalize(Expression aexpression[])
    {
        int i = aexpression.length;
        if (i == 0)
        {
            return QuoteExp.voidExp;
        }
        if (i == 1)
        {
            return canonicalize(aexpression[0]);
        } else
        {
            return new BeginExp(aexpression);
        }
    }

    public final void add(Expression expression)
    {
        if (exps == null)
        {
            exps = new Expression[8];
        }
        if (length == exps.length)
        {
            Expression aexpression[] = new Expression[length * 2];
            System.arraycopy(exps, 0, aexpression, 0, length);
            exps = aexpression;
        }
        Expression aexpression1[] = exps;
        int i = length;
        length = i + 1;
        aexpression1[i] = expression;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        gnu.lists.Consumer consumer;
        int i;
        int j;
        j = length;
        consumer = callcontext.consumer;
        callcontext.consumer = VoidConsumer.instance;
        i = 0;
_L2:
        if (i >= j - 1)
        {
            break; /* Loop/switch isn't completed */
        }
        exps[i].eval(callcontext);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        callcontext.consumer = consumer;
        exps[i].apply(callcontext);
        return;
        Exception exception;
        exception;
        callcontext.consumer = consumer;
        throw exception;
    }

    public void compile(Compilation compilation, Target target)
    {
        pushOptions(compilation);
        int j = length;
        int i = 0;
_L2:
        if (i >= j - 1)
        {
            break; /* Loop/switch isn't completed */
        }
        exps[i].compileWithPosition(compilation, Target.Ignore);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        exps[i].compileWithPosition(compilation, target);
        popOptions(compilation);
        return;
        target;
        popOptions(compilation);
        throw target;
    }

    public final int getExpressionCount()
    {
        return length;
    }

    public final Expression[] getExpressions()
    {
        return exps;
    }

    public Type getType()
    {
        return exps[length - 1].getType();
    }

    protected boolean mustCompile()
    {
        return false;
    }

    public void popOptions(Compilation compilation)
    {
        if (compileOptions != null && compilation != null)
        {
            compilation.currentOptions.popOptionValues(compileOptions);
        }
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Begin", ")", 2);
        outport.writeSpaceFill();
        printLineColumn(outport);
        if (compileOptions != null)
        {
            outport.writeSpaceFill();
            outport.startLogicalBlock("(CompileOptions", ")", 2);
            int k = compileOptions.size();
            for (int i = 0; i < k; i += 3)
            {
                Object obj = compileOptions.elementAt(i);
                Object obj1 = compileOptions.elementAt(i + 2);
                outport.writeSpaceFill();
                outport.startLogicalBlock("", "", 2);
                outport.print(obj);
                outport.print(':');
                outport.writeSpaceLinear();
                outport.print(obj1);
                outport.endLogicalBlock("");
            }

            outport.endLogicalBlock(")");
        }
        int l = length;
        for (int j = 0; j < l; j++)
        {
            outport.writeSpaceLinear();
            exps[j].print(outport);
        }

        outport.endLogicalBlock(")");
    }

    public void pushOptions(Compilation compilation)
    {
        if (compileOptions != null && compilation != null)
        {
            compilation.currentOptions.pushOptionValues(compileOptions);
        }
    }

    public void setCompileOptions(Vector vector)
    {
        compileOptions = vector;
    }

    public final void setExpressions(Expression aexpression[])
    {
        exps = aexpression;
        length = aexpression.length;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        pushOptions(expvisitor.comp);
        obj = expvisitor.visitBeginExp(this, obj);
        popOptions(expvisitor.comp);
        return obj;
        obj;
        popOptions(expvisitor.comp);
        throw obj;
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
        exps = expvisitor.visitExps(exps, length, obj);
    }
}
