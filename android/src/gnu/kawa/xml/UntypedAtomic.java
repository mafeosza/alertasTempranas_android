// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;


public class UntypedAtomic
{

    String text;

    public UntypedAtomic(String s)
    {
        text = s;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof UntypedAtomic) && text.equals(((UntypedAtomic)obj).text);
    }

    public int hashCode()
    {
        return text.hashCode();
    }

    public String toString()
    {
        return text;
    }
}
