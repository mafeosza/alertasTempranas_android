// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import gnu.math.RealNum;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Arithmetic
{

    public static final int BIGDECIMAL_CODE = 5;
    public static final int BIGINTEGER_CODE = 3;
    public static final int DOUBLE_CODE = 8;
    public static final int FLOAT_CODE = 7;
    public static final int FLONUM_CODE = 9;
    public static final int INTNUM_CODE = 4;
    public static final int INT_CODE = 1;
    public static final int LONG_CODE = 2;
    public static final int NUMERIC_CODE = 11;
    public static final int RATNUM_CODE = 6;
    public static final int REALNUM_CODE = 10;
    static LangObjType typeDFloNum;
    static LangObjType typeIntNum;
    static ClassType typeNumber = ClassType.make("java.lang.Number");
    static ClassType typeNumeric = ClassType.make("gnu.math.Numeric");
    static LangObjType typeRatNum;
    static LangObjType typeRealNum;

    public Arithmetic()
    {
    }

    public static BigDecimal asBigDecimal(Object obj)
    {
        if (obj instanceof BigDecimal)
        {
            return (BigDecimal)obj;
        }
        if (obj instanceof BigInteger)
        {
            return new BigDecimal((BigInteger)obj);
        }
        if ((obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte))
        {
            return BigDecimal.valueOf(((Number)obj).longValue());
        } else
        {
            return new BigDecimal(obj.toString());
        }
    }

    public static BigInteger asBigInteger(Object obj)
    {
        if (obj instanceof BigInteger)
        {
            return (BigInteger)obj;
        }
        if (obj instanceof IntNum)
        {
            return new BigInteger(obj.toString());
        } else
        {
            return BigInteger.valueOf(((Number)obj).longValue());
        }
    }

    public static double asDouble(Object obj)
    {
        return ((Number)obj).doubleValue();
    }

    public static float asFloat(Object obj)
    {
        return ((Number)obj).floatValue();
    }

    public static int asInt(Object obj)
    {
        return ((Number)obj).intValue();
    }

    public static IntNum asIntNum(Object obj)
    {
        if (obj instanceof IntNum)
        {
            return (IntNum)obj;
        }
        if (obj instanceof BigInteger)
        {
            return IntNum.valueOf(obj.toString(), 10);
        }
        if (obj instanceof BigDecimal)
        {
            return asIntNum((BigDecimal)obj);
        } else
        {
            return IntNum.make(((Number)obj).longValue());
        }
    }

    public static IntNum asIntNum(BigDecimal bigdecimal)
    {
        return IntNum.valueOf(bigdecimal.toBigInteger().toString(), 10);
    }

    public static IntNum asIntNum(BigInteger biginteger)
    {
        return IntNum.valueOf(biginteger.toString(), 10);
    }

    public static long asLong(Object obj)
    {
        return ((Number)obj).longValue();
    }

    public static Numeric asNumeric(Object obj)
    {
        Numeric numeric = Numeric.asNumericOrNull(obj);
        if (numeric != null)
        {
            return numeric;
        } else
        {
            return (Numeric)obj;
        }
    }

    public static RatNum asRatNum(Object obj)
    {
        if (obj instanceof RatNum)
        {
            return (RatNum)obj;
        }
        if (obj instanceof BigInteger)
        {
            return IntNum.valueOf(obj.toString(), 10);
        }
        if (obj instanceof BigDecimal)
        {
            return RatNum.valueOf((BigDecimal)obj);
        } else
        {
            return IntNum.make(((Number)obj).longValue());
        }
    }

    public static int classifyType(Type type)
    {
        byte byte0 = 8;
        if (!(type instanceof PrimType)) goto _L2; else goto _L1
_L1:
        char c = type.getSignature().charAt(0);
        if (c != 'V' && c != 'Z' && c != 'C') goto _L4; else goto _L3
_L3:
        byte0 = 0;
_L6:
        return byte0;
_L4:
        if (c != 'D')
        {
            if (c == 'F')
            {
                return 7;
            }
            return c != 'J' ? 1 : 2;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        String s = type.getName();
        if (type.isSubtype(typeIntNum))
        {
            return 4;
        }
        if (type.isSubtype(typeRatNum))
        {
            return 6;
        }
        if (type.isSubtype(typeDFloNum))
        {
            return 9;
        }
        if (!"java.lang.Double".equals(s))
        {
            if ("java.lang.Float".equals(s))
            {
                return 7;
            }
            if ("java.lang.Long".equals(s))
            {
                return 2;
            }
            if ("java.lang.Integer".equals(s) || "java.lang.Short".equals(s) || "java.lang.Byte".equals(s))
            {
                return 1;
            }
            if ("java.math.BigInteger".equals(s))
            {
                return 3;
            }
            if ("java.math.BigDecimal".equals(s))
            {
                return 5;
            }
            if (type.isSubtype(typeRealNum))
            {
                return 10;
            }
            return !type.isSubtype(typeNumeric) ? 0 : 11;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static int classifyValue(Object obj)
    {
        byte byte1 = -1;
        if (!(obj instanceof Numeric)) goto _L2; else goto _L1
_L1:
        if (!(obj instanceof IntNum)) goto _L4; else goto _L3
_L3:
        byte byte0 = 4;
_L6:
        return byte0;
_L4:
        if (obj instanceof RatNum)
        {
            return 6;
        }
        if (obj instanceof DFloNum)
        {
            return 9;
        }
        return !(obj instanceof RealNum) ? 11 : 10;
_L2:
        byte0 = byte1;
        if (obj instanceof Number)
        {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte))
            {
                return 1;
            }
            if (obj instanceof Long)
            {
                return 2;
            }
            if (obj instanceof Float)
            {
                return 7;
            }
            if (obj instanceof Double)
            {
                return 8;
            }
            if (obj instanceof BigInteger)
            {
                return 3;
            }
            byte0 = byte1;
            if (obj instanceof BigDecimal)
            {
                return 5;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object convert(Object obj, int i)
    {
        i;
        JVM INSTR tableswitch 1 11: default 60
    //                   1 67
    //                   2 87
    //                   3 107
    //                   4 112
    //                   5 117
    //                   6 122
    //                   7 127
    //                   8 144
    //                   9 161
    //                   10 183
    //                   11 178;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L1:
        Object obj1 = (Number)obj;
_L14:
        return obj1;
_L2:
        obj1 = obj;
        if (obj instanceof Integer) goto _L14; else goto _L13
_L13:
        return Integer.valueOf(((Number)obj).intValue());
_L3:
        obj1 = obj;
        if (obj instanceof Long) goto _L14; else goto _L15
_L15:
        return Long.valueOf(((Number)obj).longValue());
_L4:
        return asBigInteger(obj);
_L5:
        return asIntNum(obj);
_L6:
        return asBigDecimal(obj);
_L7:
        return asRatNum(obj);
_L8:
        obj1 = obj;
        if (obj instanceof Float) goto _L14; else goto _L16
_L16:
        return Float.valueOf(asFloat(obj));
_L9:
        obj1 = obj;
        if (obj instanceof Double) goto _L14; else goto _L17
_L17:
        return Double.valueOf(asDouble(obj));
_L10:
        obj1 = obj;
        if (obj instanceof DFloNum) goto _L14; else goto _L18
_L18:
        return DFloNum.make(asDouble(obj));
_L12:
        return asNumeric(obj);
_L11:
        return (RealNum)asNumeric(obj);
    }

    public static boolean isExact(Number number)
    {
        if (number instanceof Numeric)
        {
            return ((Numeric)number).isExact();
        }
        return !(number instanceof Double) && !(number instanceof Float) && !(number instanceof BigDecimal);
    }

    public static Type kindType(int i)
    {
        switch (i)
        {
        default:
            return Type.pointer_type;

        case 1: // '\001'
            return LangPrimType.intType;

        case 2: // '\002'
            return LangPrimType.longType;

        case 3: // '\003'
            return ClassType.make("java.math.BigInteger");

        case 4: // '\004'
            return typeIntNum;

        case 5: // '\005'
            return ClassType.make("java.math.BigDecimal");

        case 6: // '\006'
            return typeRatNum;

        case 7: // '\007'
            return LangPrimType.floatType;

        case 8: // '\b'
            return LangPrimType.doubleType;

        case 9: // '\t'
            return typeDFloNum;

        case 10: // '\n'
            return typeRealNum;

        case 11: // '\013'
            return typeNumeric;
        }
    }

    public static Number toExact(Number number)
    {
        if (!(number instanceof Numeric)) goto _L2; else goto _L1
_L1:
        Object obj = ((Numeric)number).toExact();
_L4:
        return ((Number) (obj));
_L2:
        if ((number instanceof Double) || (number instanceof Float))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = number;
        if (!(number instanceof BigDecimal)) goto _L4; else goto _L3
_L3:
        return DFloNum.toExact(number.doubleValue());
    }

    public static Number toInexact(Number number)
    {
        Object obj;
        if (number instanceof Numeric)
        {
            obj = ((Numeric)number).toInexact();
        } else
        {
            obj = number;
            if (!(number instanceof Double))
            {
                obj = number;
                if (!(number instanceof Float))
                {
                    obj = number;
                    if (!(number instanceof BigDecimal))
                    {
                        return Double.valueOf(number.doubleValue());
                    }
                }
            }
        }
        return ((Number) (obj));
    }

    public static String toString(Object obj, int i)
    {
        classifyValue(obj);
        JVM INSTR tableswitch 1 9: default 56
    //                   1 65
    //                   2 74
    //                   3 83
    //                   4 92
    //                   5 101
    //                   6 56
    //                   7 115
    //                   8 129
    //                   9 129;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L1 _L7 _L8 _L8
_L1:
        return asNumeric(obj).toString(i);
_L2:
        return Integer.toString(asInt(obj), i);
_L3:
        return Long.toString(asLong(obj), i);
_L4:
        return asBigInteger(obj).toString(i);
_L5:
        return asIntNum(obj).toString(i);
_L6:
        if (i == 10)
        {
            return asBigDecimal(obj).toString();
        }
_L7:
        if (i == 10)
        {
            return Float.toString(asFloat(obj));
        }
_L8:
        if (i != 10) goto _L1; else goto _L9
_L9:
        return Double.toString(asDouble(obj));
    }

    static 
    {
        typeDFloNum = LangObjType.dflonumType;
        typeRatNum = LangObjType.rationalType;
        typeRealNum = LangObjType.realType;
        typeIntNum = LangObjType.integerType;
    }
}
