// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.lang.ref.WeakReference;

// Referenced classes of package gnu.mapping:
//            Symbol, Namespace

class SymbolRef extends WeakReference
{

    SymbolRef next;

    SymbolRef(Symbol symbol, Namespace namespace)
    {
        super(symbol);
    }

    Symbol getSymbol()
    {
        return (Symbol)get();
    }

    public String toString()
    {
        return (new StringBuilder()).append("SymbolRef[").append(getSymbol()).append("]").toString();
    }
}
