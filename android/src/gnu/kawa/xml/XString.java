// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;


// Referenced classes of package gnu.kawa.xml:
//            XStringType

public class XString
    implements CharSequence
{

    public String text;
    private XStringType type;

    XString(String s, XStringType xstringtype)
    {
        text = s;
        type = xstringtype;
    }

    public char charAt(int i)
    {
        return text.charAt(i);
    }

    public XStringType getStringType()
    {
        return type;
    }

    public int length()
    {
        return text.length();
    }

    public CharSequence subSequence(int i, int j)
    {
        return text.substring(i, j);
    }

    public String toString()
    {
        return text;
    }
}
