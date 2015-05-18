// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.lists.Convert;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.text.Char;

public class KawaConvert extends Convert
{

    public static Convert instance = new KawaConvert();

    public KawaConvert()
    {
    }

    public static Convert getInstance()
    {
        return instance;
    }

    public static void setInstance(Convert convert)
    {
        instance = convert;
    }

    public Object byteToObject(byte byte0)
    {
        return IntNum.make(byte0);
    }

    public Object byteToObjectUnsigned(byte byte0)
    {
        return IntNum.make(byte0 & 0xff);
    }

    public Object charToObject(char c)
    {
        return Char.make(c);
    }

    public Object doubleToObject(double d)
    {
        return DFloNum.make(d);
    }

    public Object floatToObject(float f)
    {
        return DFloNum.make(f);
    }

    public Object intToObject(int i)
    {
        return IntNum.make(i);
    }

    public Object intToObjectUnsigned(int i)
    {
        return IntNum.make((long)i & 0xffffffffL);
    }

    public Object longToObject(long l)
    {
        return IntNum.make(l);
    }

    public Object longToObjectUnsigned(long l)
    {
        return IntNum.makeU(l);
    }

    public char objectToChar(Object obj)
    {
        return ((Char)obj).charValue();
    }

    public Object shortToObject(short word0)
    {
        return IntNum.make(word0);
    }

    public Object shortToObjectUnsigned(short word0)
    {
        return IntNum.make(0xffff & word0);
    }

}
