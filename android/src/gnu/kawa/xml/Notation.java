// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.mapping.Symbol;

public class Notation
{

    Symbol qname;

    public Notation()
    {
    }

    public boolean equals(Notation notation, Notation notation1)
    {
        return notation.qname.equals(notation1.qname);
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof Notation) && equals(this, (Notation)obj);
    }

    public int hashCode()
    {
        return qname.hashCode();
    }
}
