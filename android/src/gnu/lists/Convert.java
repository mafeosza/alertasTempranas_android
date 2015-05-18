// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


public class Convert
{

    public static Convert instance = new Convert();

    public Convert()
    {
    }

    public static Convert getInstance()
    {
        return instance;
    }

    public static double parseDouble(String s)
    {
        return Double.parseDouble(s);
    }

    public static void setInstance(Convert convert)
    {
        instance = convert;
    }

    public static boolean toBoolean(Object obj)
    {
        return instance.objectToBoolean(obj);
    }

    public static byte toByte(Object obj)
    {
        return instance.objectToByte(obj);
    }

    public static byte toByteUnsigned(Object obj)
    {
        return instance.objectToByteUnsigned(obj);
    }

    public static char toChar(Object obj)
    {
        return instance.objectToChar(obj);
    }

    public static double toDouble(Object obj)
    {
        return instance.objectToDouble(obj);
    }

    public static float toFloat(Object obj)
    {
        return instance.objectToFloat(obj);
    }

    public static int toInt(Object obj)
    {
        return instance.objectToInt(obj);
    }

    public static int toIntUnsigned(Object obj)
    {
        return instance.objectToIntUnsigned(obj);
    }

    public static long toLong(Object obj)
    {
        return instance.objectToLong(obj);
    }

    public static long toLongUnsigned(Object obj)
    {
        return instance.objectToLongUnsigned(obj);
    }

    public static Object toObject(byte byte0)
    {
        return instance.byteToObject(byte0);
    }

    public static Object toObject(char c)
    {
        return instance.charToObject(c);
    }

    public static Object toObject(double d)
    {
        return instance.doubleToObject(d);
    }

    public static Object toObject(float f)
    {
        return instance.floatToObject(f);
    }

    public static Object toObject(int i)
    {
        return instance.intToObject(i);
    }

    public static Object toObject(long l)
    {
        return instance.longToObject(l);
    }

    public static Object toObject(short word0)
    {
        return instance.shortToObject(word0);
    }

    public static Object toObject(boolean flag)
    {
        return instance.booleanToObject(flag);
    }

    public static Object toObjectUnsigned(byte byte0)
    {
        return instance.byteToObjectUnsigned(byte0);
    }

    public static Object toObjectUnsigned(int i)
    {
        return instance.intToObjectUnsigned(i);
    }

    public static Object toObjectUnsigned(long l)
    {
        return instance.longToObjectUnsigned(l);
    }

    public static Object toObjectUnsigned(short word0)
    {
        return instance.shortToObjectUnsigned(word0);
    }

    public static short toShort(Object obj)
    {
        return instance.objectToShort(obj);
    }

    public static short toShortUnsigned(Object obj)
    {
        return instance.objectToShortUnsigned(obj);
    }

    public Object booleanToObject(boolean flag)
    {
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public Object byteToObject(byte byte0)
    {
        return new Byte(byte0);
    }

    public Object byteToObjectUnsigned(byte byte0)
    {
        return new Integer(byte0 & 0xff);
    }

    public Object charToObject(char c)
    {
        return new Character(c);
    }

    public Object doubleToObject(double d)
    {
        return new Double(d);
    }

    public Object floatToObject(float f)
    {
        return new Float(f);
    }

    public Object intToObject(int i)
    {
        return new Integer(i);
    }

    public Object intToObjectUnsigned(int i)
    {
        if (i >= 0)
        {
            return new Integer(i);
        } else
        {
            return new Long((long)i & 0xffffffffL);
        }
    }

    public Object longToObject(long l)
    {
        return new Long(l);
    }

    public Object longToObjectUnsigned(long l)
    {
        return new Long(l);
    }

    public boolean objectToBoolean(Object obj)
    {
        return !(obj instanceof Boolean) || ((Boolean)obj).booleanValue();
    }

    public byte objectToByte(Object obj)
    {
        return ((Number)obj).byteValue();
    }

    public byte objectToByteUnsigned(Object obj)
    {
        return ((Number)obj).byteValue();
    }

    public char objectToChar(Object obj)
    {
        return ((Character)obj).charValue();
    }

    public double objectToDouble(Object obj)
    {
        return ((Number)obj).doubleValue();
    }

    public float objectToFloat(Object obj)
    {
        return ((Number)obj).floatValue();
    }

    public int objectToInt(Object obj)
    {
        return ((Number)obj).intValue();
    }

    public int objectToIntUnsigned(Object obj)
    {
        return ((Number)obj).intValue();
    }

    public long objectToLong(Object obj)
    {
        return ((Number)obj).longValue();
    }

    public long objectToLongUnsigned(Object obj)
    {
        return ((Number)obj).longValue();
    }

    public short objectToShort(Object obj)
    {
        return ((Number)obj).shortValue();
    }

    public short objectToShortUnsigned(Object obj)
    {
        return ((Number)obj).shortValue();
    }

    public Object shortToObject(short word0)
    {
        return new Short(word0);
    }

    public Object shortToObjectUnsigned(short word0)
    {
        return new Integer(0xffff & word0);
    }

}
