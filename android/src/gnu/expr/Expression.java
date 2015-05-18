// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.kawa.reflect.OccurrenceType;
import gnu.kawa.util.IdentityHashTable;
import gnu.lists.Consumer;
import gnu.mapping.CallContext;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Environment;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0;
import gnu.text.Printable;
import gnu.text.SourceLocator;
import java.io.PrintWriter;

// Referenced classes of package gnu.expr:
//            BeginExp, Target, LetExp, ApplyExp, 
//            ReferenceExp, LambdaExp, Compilation, IfExp, 
//            QuoteExp, Declaration, StackTarget, CheckedTarget, 
//            InlineCalls, ExpVisitor

public abstract class Expression extends Procedure0
    implements Printable, SourceLocator
{

    protected static final int NEXT_AVAIL_FLAG = 2;
    public static final int VALIDATED = 1;
    public static final Expression noExpressions[] = new Expression[0];
    String filename;
    protected int flags;
    int position;

    public Expression()
    {
    }

    public static void compileButFirst(Expression expression, Compilation compilation)
    {
        if (expression instanceof BeginExp)
        {
            expression = (BeginExp)expression;
            int j = ((BeginExp) (expression)).length;
            if (j != 0)
            {
                expression = ((BeginExp) (expression)).exps;
                compileButFirst(expression[0], compilation);
                int i = 1;
                while (i < j) 
                {
                    expression[i].compileWithPosition(compilation, Target.Ignore);
                    i++;
                }
            }
        }
    }

    protected static Expression deepCopy(Expression expression)
    {
        return deepCopy(expression, new IdentityHashTable());
    }

    public static Expression deepCopy(Expression expression, IdentityHashTable identityhashtable)
    {
        if (expression == null)
        {
            return null;
        }
        Object obj = identityhashtable.get(expression);
        if (obj != null)
        {
            return (Expression)obj;
        } else
        {
            Expression expression1 = expression.deepCopy(identityhashtable);
            identityhashtable.put(expression, expression1);
            return expression1;
        }
    }

    public static Expression[] deepCopy(Expression aexpression[], IdentityHashTable identityhashtable)
    {
        if (aexpression != null) goto _L2; else goto _L1
_L1:
        Expression aexpression1[] = null;
_L4:
        return aexpression1;
_L2:
        int j = aexpression.length;
        Expression aexpression2[] = new Expression[j];
        int i = 0;
        do
        {
            aexpression1 = aexpression2;
            if (i >= j)
            {
                continue;
            }
            Expression expression = aexpression[i];
            Expression expression1 = deepCopy(expression, identityhashtable);
            if (expression1 == null && expression != null)
            {
                return null;
            }
            aexpression2[i] = expression1;
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static Expression makeWhile(Object obj, Object obj1, Compilation compilation)
    {
        Expression aexpression[] = new Expression[1];
        LetExp letexp = new LetExp(aexpression);
        Declaration declaration = letexp.addDeclaration("%do%loop");
        ApplyExp applyexp = new ApplyExp(new ReferenceExp(declaration), noExpressions);
        LambdaExp lambdaexp = new LambdaExp();
        compilation.push(lambdaexp);
        lambdaexp.body = new IfExp(compilation.parse(obj), new BeginExp(compilation.parse(obj1), applyexp), QuoteExp.voidExp);
        lambdaexp.setName("%do%loop");
        compilation.pop(lambdaexp);
        aexpression[0] = lambdaexp;
        declaration.noteValue(lambdaexp);
        letexp.setBody(new ApplyExp(new ReferenceExp(declaration), noExpressions));
        return letexp;
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        throw new RuntimeException((new StringBuilder()).append("internal error - ").append(getClass()).append(".eval called").toString());
    }

    public final Object apply0()
        throws Throwable
    {
        CallContext callcontext = CallContext.getInstance();
        check0(callcontext);
        return callcontext.runUntilValue();
    }

    public final void compile(Compilation compilation, Type type)
    {
        compile(compilation, StackTarget.getInstance(type));
    }

    public final void compile(Compilation compilation, Declaration declaration)
    {
        compile(compilation, CheckedTarget.getInstance(declaration));
    }

    public abstract void compile(Compilation compilation, Target target);

    public final void compileNotePosition(Compilation compilation, Target target, Expression expression)
    {
        String s = compilation.getFileName();
        int i = compilation.getLineNumber();
        int j = compilation.getColumnNumber();
        compilation.setLine(expression);
        compile(compilation, target);
        compilation.setLine(s, i, j);
    }

    public final void compileWithPosition(Compilation compilation, Target target)
    {
        int i = getLineNumber();
        if (i > 0)
        {
            compilation.getCode().putLineNumber(getFileName(), i);
            compileNotePosition(compilation, target, this);
            return;
        } else
        {
            compile(compilation, target);
            return;
        }
    }

    public final void compileWithPosition(Compilation compilation, Target target, Expression expression)
    {
        int i = expression.getLineNumber();
        if (i > 0)
        {
            compilation.getCode().putLineNumber(expression.getFileName(), i);
            compileNotePosition(compilation, target, expression);
            return;
        } else
        {
            compile(compilation, target);
            return;
        }
    }

    protected Expression deepCopy(IdentityHashTable identityhashtable)
    {
        return null;
    }

    public final Object eval(CallContext callcontext)
        throws Throwable
    {
        int i = callcontext.startFromContext();
        Object obj;
        try
        {
            match0(callcontext);
            obj = callcontext.getFromContext(i);
        }
        catch (Throwable throwable)
        {
            callcontext.cleanupFromContext(i);
            throw throwable;
        }
        return obj;
    }

    public final Object eval(Environment environment)
        throws Throwable
    {
        Object obj;
        obj = CallContext.getInstance();
        environment = Environment.setSaveCurrent(environment);
        obj = eval(((CallContext) (obj)));
        Environment.restoreCurrent(environment);
        return obj;
        Exception exception;
        exception;
        Environment.restoreCurrent(environment);
        throw exception;
    }

    public final int getColumnNumber()
    {
        int j = position & 0xfff;
        int i = j;
        if (j == 0)
        {
            i = -1;
        }
        return i;
    }

    public final String getFileName()
    {
        return filename;
    }

    public boolean getFlag(int i)
    {
        return (flags & i) != 0;
    }

    public int getFlags()
    {
        return flags;
    }

    public final int getLineNumber()
    {
        int j = position >> 12;
        int i = j;
        if (j == 0)
        {
            i = -1;
        }
        return i;
    }

    public String getPublicId()
    {
        return null;
    }

    public String getSystemId()
    {
        return filename;
    }

    public Type getType()
    {
        return Type.pointer_type;
    }

    public boolean isSingleValue()
    {
        return OccurrenceType.itemCountIsOne(getType());
    }

    public boolean isStableSourceLocation()
    {
        return true;
    }

    public final int match0(CallContext callcontext)
    {
        callcontext.proc = this;
        callcontext.pc = 0;
        return 0;
    }

    protected abstract boolean mustCompile();

    public final void print(Consumer consumer)
    {
        if (consumer instanceof OutPort)
        {
            print((OutPort)consumer);
            return;
        }
        if (consumer instanceof PrintWriter)
        {
            consumer = new OutPort((PrintWriter)consumer);
            print(((OutPort) (consumer)));
            consumer.close();
            return;
        } else
        {
            CharArrayOutPort chararrayoutport = new CharArrayOutPort();
            print(((OutPort) (chararrayoutport)));
            chararrayoutport.close();
            chararrayoutport.writeTo(consumer);
            return;
        }
    }

    public abstract void print(OutPort outport);

    public void printLineColumn(OutPort outport)
    {
        int i = getLineNumber();
        if (i > 0)
        {
            outport.print("line:");
            outport.print(i);
            i = getColumnNumber();
            if (i > 0)
            {
                outport.print(':');
                outport.print(i);
            }
            outport.writeSpaceFill();
        }
    }

    public final void setFile(String s)
    {
        filename = s;
    }

    public void setFlag(int i)
    {
        flags = flags | i;
    }

    public void setFlag(boolean flag, int i)
    {
        if (flag)
        {
            flags = flags | i;
            return;
        } else
        {
            flags = flags & ~i;
            return;
        }
    }

    public final Expression setLine(Expression expression)
    {
        setLocation(expression);
        return this;
    }

    public final void setLine(int i)
    {
        setLine(i, 0);
    }

    public final void setLine(int i, int j)
    {
        int k = i;
        if (i < 0)
        {
            k = 0;
        }
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        position = (k << 12) + i;
    }

    public void setLine(Compilation compilation)
    {
        int i = compilation.getLineNumber();
        if (i > 0)
        {
            setFile(compilation.getFileName());
            setLine(i, compilation.getColumnNumber());
        }
    }

    public final void setLocation(SourceLocator sourcelocator)
    {
        filename = sourcelocator.getFileName();
        setLine(sourcelocator.getLineNumber(), sourcelocator.getColumnNumber());
    }

    public boolean side_effects()
    {
        return true;
    }

    public String toString()
    {
        String s1 = getClass().getName();
        String s = s1;
        if (s1.startsWith("gnu.expr."))
        {
            s = s1.substring(9);
        }
        return (new StringBuilder()).append(s).append("@").append(Integer.toHexString(hashCode())).toString();
    }

    public Expression validateApply(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Declaration declaration)
    {
        applyexp.args = inlinecalls.visitExps(applyexp.args, null);
        return applyexp;
    }

    public Object valueIfConstant()
    {
        return null;
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitExpression(this, obj);
    }

    protected void visitChildren(ExpVisitor expvisitor, Object obj)
    {
    }

}
