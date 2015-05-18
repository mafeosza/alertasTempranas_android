// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;


// Referenced classes of package gnu.expr:
//            ExpExpVisitor, Compilation, NameLookup, ModuleExp, 
//            LetExp, Expression, ReferenceExp, ScopeExp, 
//            SetExp, Declaration

public class ResolveNames extends ExpExpVisitor
{

    protected NameLookup lookup;

    public ResolveNames()
    {
    }

    public ResolveNames(Compilation compilation)
    {
        setContext(compilation);
        lookup = compilation.lexical;
    }

    public Declaration lookup(Expression expression, Object obj, boolean flag)
    {
        return lookup.lookup(obj, flag);
    }

    protected void push(ScopeExp scopeexp)
    {
        lookup.push(scopeexp);
    }

    public void resolveModule(ModuleExp moduleexp)
    {
        Compilation compilation = Compilation.setSaveCurrent(comp);
        push(moduleexp);
        moduleexp.visitChildren(this, null);
        Compilation.restoreCurrent(compilation);
        return;
        moduleexp;
        Compilation.restoreCurrent(compilation);
        throw moduleexp;
    }

    protected Expression visitLetExp(LetExp letexp, Void void1)
    {
        visitDeclarationTypes(letexp);
        letexp.visitInitializers(this, void1);
        push(letexp);
        letexp.body = (Expression)visit(letexp.body, void1);
        lookup.pop(letexp);
        return letexp;
    }

    protected volatile Object visitLetExp(LetExp letexp, Object obj)
    {
        return visitLetExp(letexp, (Void)obj);
    }

    protected Expression visitReferenceExp(ReferenceExp referenceexp, Void void1)
    {
        if (referenceexp.getBinding() == null)
        {
            void1 = lookup(referenceexp, referenceexp.getSymbol(), referenceexp.isProcedureName());
            if (void1 != null)
            {
                referenceexp.setBinding(void1);
            }
        }
        return referenceexp;
    }

    protected volatile Object visitReferenceExp(ReferenceExp referenceexp, Object obj)
    {
        return visitReferenceExp(referenceexp, (Void)obj);
    }

    protected Expression visitScopeExp(ScopeExp scopeexp, Void void1)
    {
        visitDeclarationTypes(scopeexp);
        push(scopeexp);
        scopeexp.visitChildren(this, void1);
        lookup.pop(scopeexp);
        return scopeexp;
    }

    protected volatile Object visitScopeExp(ScopeExp scopeexp, Object obj)
    {
        return visitScopeExp(scopeexp, (Void)obj);
    }

    protected Expression visitSetExp(SetExp setexp, Void void1)
    {
        if (setexp.binding == null)
        {
            Declaration declaration = lookup(setexp, setexp.getSymbol(), setexp.isFuncDef());
            if (declaration != null)
            {
                declaration.setCanWrite(true);
            }
            setexp.binding = declaration;
        }
        return (Expression)super.visitSetExp(setexp, void1);
    }

    protected volatile Object visitSetExp(SetExp setexp, Object obj)
    {
        return visitSetExp(setexp, (Void)obj);
    }
}
