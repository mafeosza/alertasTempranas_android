// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.mapping.Symbol;

// Referenced classes of package gnu.expr:
//            Expression, Declaration

public abstract class AccessExp extends Expression
{

    Declaration binding;
    private Declaration context;
    Object symbol;

    public AccessExp()
    {
    }

    public final Declaration contextDecl()
    {
        return context;
    }

    public final Declaration getBinding()
    {
        return binding;
    }

    public final String getName()
    {
        if (symbol instanceof Symbol)
        {
            return ((Symbol)symbol).getName();
        } else
        {
            return symbol.toString();
        }
    }

    public final String getSimpleName()
    {
        if (symbol instanceof String)
        {
            return (String)symbol;
        }
        if (symbol instanceof Symbol)
        {
            Symbol symbol1 = (Symbol)symbol;
            if (symbol1.hasEmptyNamespace())
            {
                return symbol1.getLocalName();
            }
        }
        return null;
    }

    public final Object getSymbol()
    {
        return symbol;
    }

    public final void setBinding(Declaration declaration)
    {
        binding = declaration;
    }

    public final void setContextDecl(Declaration declaration)
    {
        context = declaration;
    }

    public String string_name()
    {
        return symbol.toString();
    }
}
