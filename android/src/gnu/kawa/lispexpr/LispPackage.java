// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

// Referenced classes of package gnu.kawa.lispexpr:
//            NamespaceUse

public class LispPackage extends Namespace
{

    Namespace exported;
    NamespaceUse imported;
    NamespaceUse importing;
    LList shadowingSymbols;

    public LispPackage()
    {
        shadowingSymbols = LList.Empty;
    }

    private void addToShadowingSymbols(Symbol symbol)
    {
        for (Object obj = shadowingSymbols; obj != LList.Empty; obj = ((Pair) (obj)).getCdr())
        {
            obj = (Pair)obj;
            if (((Pair) (obj)).getCar() == symbol)
            {
                return;
            }
        }

        shadowingSymbols = new Pair(symbol, shadowingSymbols);
    }

    private boolean removeFromShadowingSymbols(Symbol symbol)
    {
        Pair pair = null;
        for (Object obj = shadowingSymbols; obj != LList.Empty;)
        {
            Pair pair1 = (Pair)obj;
            obj = pair1.getCdr();
            if (pair1.getCar() == symbol)
            {
                if (pair == null)
                {
                    shadowingSymbols = (LList)obj;
                } else
                {
                    pair.setCdr(obj);
                }
                return true;
            }
            pair = pair1;
        }

        return false;
    }

    public boolean isPresent(String s)
    {
        boolean flag = false;
        if (lookupPresent(s, s.hashCode(), false) != null)
        {
            flag = true;
        }
        return flag;
    }

    public Symbol lookup(String s, int i, boolean flag)
    {
        Symbol symbol = exported.lookup(s, i, false);
        if (symbol != null)
        {
            return symbol;
        }
        symbol = lookupInternal(s, i);
        if (symbol != null)
        {
            return symbol;
        }
        for (NamespaceUse namespaceuse = imported; namespaceuse != null; namespaceuse = namespaceuse.nextImported)
        {
            Symbol symbol1 = lookup(s, i, false);
            if (symbol1 != null)
            {
                return symbol1;
            }
        }

        if (flag)
        {
            return add(new Symbol(this, s), i);
        } else
        {
            return null;
        }
    }

    public Symbol lookupPresent(String s, int i, boolean flag)
    {
        Symbol symbol1 = exported.lookup(s, i, false);
        Symbol symbol = symbol1;
        if (symbol1 == null)
        {
            symbol = super.lookup(s, i, flag);
        }
        return symbol;
    }

    public void shadow(String s)
    {
        addToShadowingSymbols(lookupPresent(s, s.hashCode(), true));
    }

    public void shadowingImport(Symbol symbol)
    {
        Object obj = symbol.getName();
        ((String) (obj)).hashCode();
        obj = lookupPresent(((String) (obj)), ((String) (obj)).hashCode(), false);
        if (obj != null && obj != symbol)
        {
            unintern(((Symbol) (obj)));
        }
        addToShadowingSymbols(symbol);
    }

    public boolean unintern(Symbol symbol)
    {
        String s;
        int i;
        boolean flag;
        flag = false;
        s = symbol.getName();
        i = s.hashCode();
        if (exported.lookup(s, i, false) != symbol) goto _L2; else goto _L1
_L1:
        exported.remove(symbol);
_L6:
        symbol.setNamespace(null);
        if (!removeFromShadowingSymbols(symbol));
        flag = true;
_L4:
        return flag;
_L2:
        if (super.lookup(s, i, false) != symbol) goto _L4; else goto _L3
_L3:
        super.remove(symbol);
        if (true) goto _L6; else goto _L5
_L5:
    }
}
