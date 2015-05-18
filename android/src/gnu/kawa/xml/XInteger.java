// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.math.IntNum;

// Referenced classes of package gnu.kawa.xml:
//            XIntegerType

public class XInteger extends IntNum
{

    private XIntegerType type;

    XInteger(IntNum intnum, XIntegerType xintegertype)
    {
        words = intnum.words;
        ival = intnum.ival;
        type = xintegertype;
    }

    public XIntegerType getIntegerType()
    {
        return type;
    }
}
