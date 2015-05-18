// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.text.SourceLocator;
import gnu.text.SourceMessages;

// Referenced classes of package gnu.expr:
//            Compilation, ErrorExp, Expression, Declaration, 
//            ScopeExp, LambdaExp, SetExp, ApplyExp, 
//            BeginExp, BlockExp, ClassExp, ExitExp, 
//            FluidLetExp, IfExp, LangExp, LetExp, 
//            ModuleExp, ObjectExp, QuoteExp, ReferenceExp, 
//            SynchronizedExp, ThisExp, TryExp

public class ExpVisitor
    implements SourceLocator
{

    Compilation comp;
    protected LambdaExp currentLambda;
    protected Object exitValue;
    protected SourceMessages messages;

    public ExpVisitor()
    {
        currentLambda = null;
        exitValue = null;
    }

    protected Object defaultValue(Expression expression, Object obj)
    {
        return null;
    }

    public void error(char c, String s)
    {
        char c1 = c;
        if (c == 'w')
        {
            c1 = c;
            if (comp.warnAsError())
            {
                c1 = 'e';
            }
        }
        if (messages != null)
        {
            messages.error(c1, s);
            return;
        } else
        {
            new Error((new StringBuilder()).append("internal error: ").append(s).toString());
            return;
        }
    }

    public final int getColumnNumber()
    {
        return messages.getColumnNumber();
    }

    public Compilation getCompilation()
    {
        return comp;
    }

    public final LambdaExp getCurrentLambda()
    {
        return currentLambda;
    }

    public Object getExitValue()
    {
        return exitValue;
    }

    public final String getFileName()
    {
        return messages.getFileName();
    }

    public final int getLineNumber()
    {
        return messages.getLineNumber();
    }

    public SourceMessages getMessages()
    {
        return messages;
    }

    public String getPublicId()
    {
        return messages.getPublicId();
    }

    public String getSystemId()
    {
        return messages.getSystemId();
    }

    public boolean isStableSourceLocation()
    {
        return false;
    }

    public Expression noteError(String s)
    {
        if (messages != null)
        {
            messages.error('e', s);
        }
        return new ErrorExp(s);
    }

    public void setColumn(int i)
    {
        messages.setColumn(i);
    }

    public void setContext(Compilation compilation)
    {
        comp = compilation;
        messages = compilation.getMessages();
    }

    public void setFile(String s)
    {
        messages.setFile(s);
    }

    public void setLine(int i)
    {
        messages.setLine(i);
    }

    public void setLine(String s, int i, int j)
    {
        messages.setLine(s, i, j);
    }

    protected Expression update(Expression expression, Object obj)
    {
        return expression;
    }

    public Object visit(Expression expression, Object obj)
    {
        int i = expression.getLineNumber();
        if (messages != null && i > 0)
        {
            String s = messages.getFileName();
            int j = messages.getLineNumber();
            int k = messages.getColumnNumber();
            messages.setLine(expression.getFileName(), i, expression.getColumnNumber());
            expression = ((Expression) (expression.visit(this, obj)));
            messages.setLine(s, j, k);
            return expression;
        } else
        {
            return expression.visit(this, obj);
        }
    }

    public Expression visitAndUpdate(Expression expression, Object obj)
    {
        return update(expression, visit(expression, obj));
    }

    protected Object visitApplyExp(ApplyExp applyexp, Object obj)
    {
        return visitExpression(applyexp, obj);
    }

    protected Object visitBeginExp(BeginExp beginexp, Object obj)
    {
        return visitExpression(beginexp, obj);
    }

    protected Object visitBlockExp(BlockExp blockexp, Object obj)
    {
        return visitExpression(blockexp, obj);
    }

    protected Object visitClassExp(ClassExp classexp, Object obj)
    {
        return visitLambdaExp(classexp, obj);
    }

    protected final void visitDeclarationType(Declaration declaration)
    {
        Expression expression = declaration.typeExp;
        if (expression != null)
        {
            Expression expression1 = visitAndUpdate(expression, null);
            if (expression1 != expression)
            {
                declaration.setTypeExp(expression1);
            }
        }
    }

    protected final void visitDeclarationTypes(ScopeExp scopeexp)
    {
        for (scopeexp = scopeexp.firstDecl(); scopeexp != null; scopeexp = scopeexp.nextDecl())
        {
            visitDeclarationType(scopeexp);
        }

    }

    public void visitDefaultArgs(LambdaExp lambdaexp, Object obj)
    {
        lambdaexp.defaultArgs = visitExps(lambdaexp.defaultArgs, obj);
    }

    protected Object visitExitExp(ExitExp exitexp, Object obj)
    {
        return visitExpression(exitexp, obj);
    }

    protected Object visitExpression(Expression expression, Object obj)
    {
        expression.visitChildren(this, obj);
        return defaultValue(expression, obj);
    }

    public Expression[] visitExps(Expression aexpression[], int i, Object obj)
    {
        for (int j = 0; j < i && exitValue == null; j++)
        {
            aexpression[j] = visitAndUpdate(aexpression[j], obj);
        }

        return aexpression;
    }

    public Expression[] visitExps(Expression aexpression[], Object obj)
    {
        if (aexpression == null)
        {
            return null;
        } else
        {
            return visitExps(aexpression, aexpression.length, obj);
        }
    }

    protected Object visitFluidLetExp(FluidLetExp fluidletexp, Object obj)
    {
        return visitLetExp(fluidletexp, obj);
    }

    protected Object visitIfExp(IfExp ifexp, Object obj)
    {
        return visitExpression(ifexp, obj);
    }

    protected Object visitLambdaExp(LambdaExp lambdaexp, Object obj)
    {
        return visitScopeExp(lambdaexp, obj);
    }

    protected Object visitLangExp(LangExp langexp, Object obj)
    {
        return visitExpression(langexp, obj);
    }

    protected Object visitLetExp(LetExp letexp, Object obj)
    {
        return visitScopeExp(letexp, obj);
    }

    protected Object visitModuleExp(ModuleExp moduleexp, Object obj)
    {
        return visitLambdaExp(moduleexp, obj);
    }

    protected Object visitObjectExp(ObjectExp objectexp, Object obj)
    {
        return visitClassExp(objectexp, obj);
    }

    protected Object visitQuoteExp(QuoteExp quoteexp, Object obj)
    {
        return visitExpression(quoteexp, obj);
    }

    protected Object visitReferenceExp(ReferenceExp referenceexp, Object obj)
    {
        return visitExpression(referenceexp, obj);
    }

    protected Object visitScopeExp(ScopeExp scopeexp, Object obj)
    {
        visitDeclarationTypes(scopeexp);
        return visitExpression(scopeexp, obj);
    }

    protected Object visitSetExp(SetExp setexp, Object obj)
    {
        Declaration declaration = setexp.binding;
        boolean flag;
        if (declaration != null && declaration.value == setexp.new_value)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setexp.new_value = visitSetExpValue(setexp.new_value, obj, setexp.getBinding());
        if (flag && setexp.isDefining())
        {
            declaration.value = setexp.new_value;
            if (setexp.new_value instanceof LambdaExp)
            {
                ((LambdaExp)setexp.new_value).nameDecl = declaration;
            }
        }
        return defaultValue(setexp, obj);
    }

    protected Expression visitSetExpValue(Expression expression, Object obj, Declaration declaration)
    {
        return visitAndUpdate(expression, obj);
    }

    protected Object visitSynchronizedExp(SynchronizedExp synchronizedexp, Object obj)
    {
        return visitExpression(synchronizedexp, obj);
    }

    protected Object visitThisExp(ThisExp thisexp, Object obj)
    {
        return visitReferenceExp(thisexp, obj);
    }

    protected Object visitTryExp(TryExp tryexp, Object obj)
    {
        return visitExpression(tryexp, obj);
    }
}
