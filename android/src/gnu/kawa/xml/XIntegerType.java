// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.kawa.functions.Arithmetic;
import gnu.math.IntNum;
import gnu.math.RealNum;
import java.math.BigDecimal;

// Referenced classes of package gnu.kawa.xml:
//            XDataType, XInteger

public class XIntegerType extends XDataType
{

    public static final XIntegerType byteType;
    public static final XIntegerType intType;
    public static final XIntegerType integerType;
    public static final XIntegerType longType;
    public static final XIntegerType negativeIntegerType;
    public static final XIntegerType nonNegativeIntegerType;
    public static final XIntegerType nonPositiveIntegerType;
    public static final XIntegerType positiveIntegerType;
    public static final XIntegerType shortType;
    static ClassType typeIntNum = ClassType.make("gnu.math.IntNum");
    public static final XIntegerType unsignedByteType;
    public static final XIntegerType unsignedIntType;
    public static final XIntegerType unsignedLongType;
    public static final XIntegerType unsignedShortType;
    boolean isUnsignedType;
    public final IntNum maxValue;
    public final IntNum minValue;

    public XIntegerType(Object obj, XDataType xdatatype, int i, IntNum intnum, IntNum intnum1)
    {
        super(obj, typeIntNum, i);
        minValue = intnum;
        maxValue = intnum1;
        baseType = xdatatype;
    }

    public XIntegerType(String s, XDataType xdatatype, int i, IntNum intnum, IntNum intnum1)
    {
        this(s, xdatatype, i, intnum, intnum1);
        isUnsignedType = s.startsWith("unsigned");
    }

    public Object cast(Object obj)
    {
        if (obj instanceof Boolean)
        {
            if (((Boolean)obj).booleanValue())
            {
                obj = IntNum.one();
            } else
            {
                obj = IntNum.zero();
            }
            return valueOf(((IntNum) (obj)));
        }
        if (obj instanceof IntNum)
        {
            return valueOf((IntNum)obj);
        }
        if (obj instanceof BigDecimal)
        {
            return valueOf(Arithmetic.asIntNum((BigDecimal)obj));
        }
        if (obj instanceof RealNum)
        {
            return valueOf(((RealNum)obj).toExactInt(3));
        }
        if (obj instanceof Number)
        {
            return valueOf(RealNum.toExactInt(((Number)obj).doubleValue(), 3));
        } else
        {
            return super.cast(obj);
        }
    }

    public Object coerceFromObject(Object obj)
    {
        return valueOf((IntNum)obj);
    }

    public boolean isInstance(Object obj)
    {
        if (obj instanceof IntNum)
        {
            if (this == integerType)
            {
                return true;
            }
            if (obj instanceof XInteger)
            {
                obj = ((XInteger)obj).getIntegerType();
            } else
            {
                obj = integerType;
            }
            while (obj != null) 
            {
                if (obj == this)
                {
                    return true;
                }
                obj = ((XDataType) (obj)).baseType;
            }
        }
        return false;
    }

    public boolean isUnsignedType()
    {
        return isUnsignedType;
    }

    public IntNum valueOf(IntNum intnum)
    {
        Object obj = intnum;
        if (this != integerType)
        {
            if (minValue != null && IntNum.compare(intnum, minValue) < 0 || maxValue != null && IntNum.compare(intnum, maxValue) > 0)
            {
                throw new ClassCastException((new StringBuilder()).append("cannot cast ").append(intnum).append(" to ").append(name).toString());
            }
            obj = new XInteger(intnum, this);
        }
        return ((IntNum) (obj));
    }

    public IntNum valueOf(String s, int i)
    {
        return valueOf(IntNum.valueOf(s.trim(), i));
    }

    public Object valueOf(String s)
    {
        return valueOf(IntNum.valueOf(s.trim(), 10));
    }

    static 
    {
        integerType = new XIntegerType("integer", decimalType, 5, null, null);
        longType = new XIntegerType("long", integerType, 8, IntNum.make(0x8000000000000000L), IntNum.make(0x7fffffffffffffffL));
        intType = new XIntegerType("int", longType, 9, IntNum.make(0x80000000), IntNum.make(0x7fffffff));
        shortType = new XIntegerType("short", intType, 10, IntNum.make(-32768), IntNum.make(32767));
        byteType = new XIntegerType("byte", shortType, 11, IntNum.make(-128), IntNum.make(127));
        nonPositiveIntegerType = new XIntegerType("nonPositiveInteger", integerType, 6, null, IntNum.zero());
        negativeIntegerType = new XIntegerType("negativeInteger", nonPositiveIntegerType, 7, null, IntNum.minusOne());
        nonNegativeIntegerType = new XIntegerType("nonNegativeInteger", integerType, 12, IntNum.zero(), null);
        unsignedLongType = new XIntegerType("unsignedLong", nonNegativeIntegerType, 13, IntNum.zero(), IntNum.valueOf("18446744073709551615"));
        unsignedIntType = new XIntegerType("unsignedInt", unsignedLongType, 14, IntNum.zero(), IntNum.make(0xffffffffL));
        unsignedShortType = new XIntegerType("unsignedShort", unsignedIntType, 15, IntNum.zero(), IntNum.make(65535));
        unsignedByteType = new XIntegerType("unsignedByte", unsignedShortType, 16, IntNum.zero(), IntNum.make(255));
        positiveIntegerType = new XIntegerType("positiveInteger", nonNegativeIntegerType, 17, IntNum.one(), null);
    }
}
