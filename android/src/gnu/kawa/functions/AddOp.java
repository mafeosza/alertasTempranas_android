// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package gnu.kawa.functions:
//            ArithOp, Arithmetic

public class AddOp extends ArithOp
{

    public static final AddOp $Mn = new AddOp("-", -1);
    public static final AddOp $Pl = new AddOp("+", 1);
    int plusOrMinus;

    public static Object $Mn(Object obj)
    {
        switch (Arithmetic.classifyValue(obj))
        {
        default:
            return Arithmetic.asNumeric(obj).neg();

        case 1: // '\001'
            return new Integer(-Arithmetic.asInt(obj));

        case 2: // '\002'
            return new Long(-Arithmetic.asLong(obj));

        case 3: // '\003'
            return Arithmetic.asBigInteger(obj).negate();

        case 4: // '\004'
            return IntNum.neg(Arithmetic.asIntNum(obj));

        case 5: // '\005'
            return Arithmetic.asBigDecimal(obj).negate();

        case 6: // '\006'
            return RatNum.neg(Arithmetic.asRatNum(obj));

        case 7: // '\007'
            return new Float(-Arithmetic.asFloat(obj));

        case 8: // '\b'
            return new Double(-Arithmetic.asDouble(obj));

        case 9: // '\t'
            return new DFloNum(-Arithmetic.asDouble(obj));
        }
    }

    public static Object $Mn(Object obj, Object obj1)
    {
        return apply2(-1, obj, obj1);
    }

    public static Object $Mn$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        return applyN(-1, apply2(-1, apply2(-1, obj, obj1), obj2), aobj);
    }

    public static Object $Pl(Object obj, Object obj1)
    {
        return apply2(1, obj, obj1);
    }

    public static Object $Pl$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        return applyN(1, apply2(1, apply2(1, obj, obj1), obj2), aobj);
    }

    public AddOp(String s, int i)
    {
        int j;
        if (i > 0)
        {
            j = 1;
        } else
        {
            j = 2;
        }
        super(s, j);
        plusOrMinus = 1;
        plusOrMinus = i;
        if (i > 0)
        {
            s = "gnu.kawa.functions.CompileArith:$Pl";
        } else
        {
            s = "gnu.kawa.functions.CompileArith:$Mn";
        }
        Procedure.compilerKey.set(this, s);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
    }

    public static Object apply2(int i, Object obj, Object obj1)
    {
        int j = Arithmetic.classifyValue(obj);
        int l = Arithmetic.classifyValue(obj1);
        if (j < l)
        {
            j = l;
        }
        double d1;
        double d3;
        switch (j)
        {
        default:
            return Arithmetic.asNumeric(obj).add(Arithmetic.asNumeric(obj1), i);

        case 1: // '\001'
            int k = Arithmetic.asInt(obj);
            int i1 = Arithmetic.asInt(obj1);
            if (i > 0)
            {
                i = k + i1;
            } else
            {
                i = k - i1;
            }
            return new Integer(i);

        case 2: // '\002'
            long l1 = Arithmetic.asLong(obj);
            long l2 = Arithmetic.asLong(obj1);
            if (i > 0)
            {
                l1 += l2;
            } else
            {
                l1 -= l2;
            }
            return new Long(l1);

        case 3: // '\003'
            obj = Arithmetic.asBigInteger(obj);
            obj1 = Arithmetic.asBigInteger(obj1);
            if (i > 0)
            {
                return ((BigInteger) (obj)).add(((BigInteger) (obj1)));
            } else
            {
                return ((BigInteger) (obj)).subtract(((BigInteger) (obj1)));
            }

        case 4: // '\004'
            return IntNum.add(Arithmetic.asIntNum(obj), Arithmetic.asIntNum(obj1), i);

        case 5: // '\005'
            obj = Arithmetic.asBigDecimal(obj);
            obj1 = Arithmetic.asBigDecimal(obj1);
            if (i > 0)
            {
                return ((BigDecimal) (obj)).add(((BigDecimal) (obj1)));
            } else
            {
                return ((BigDecimal) (obj)).subtract(((BigDecimal) (obj1)));
            }

        case 6: // '\006'
            return RatNum.add(Arithmetic.asRatNum(obj), Arithmetic.asRatNum(obj1), i);

        case 7: // '\007'
            float f = Arithmetic.asFloat(obj);
            float f1 = Arithmetic.asFloat(obj1);
            if (i > 0)
            {
                f += f1;
            } else
            {
                f -= f1;
            }
            return new Float(f);

        case 8: // '\b'
            double d = Arithmetic.asDouble(obj);
            double d2 = Arithmetic.asDouble(obj1);
            if (i > 0)
            {
                d += d2;
            } else
            {
                d -= d2;
            }
            return new Double(d);

        case 9: // '\t'
            d1 = Arithmetic.asDouble(obj);
            d3 = Arithmetic.asDouble(obj1);
            break;
        }
        if (i > 0)
        {
            d1 += d3;
        } else
        {
            d1 -= d3;
        }
        return new DFloNum(d1);
    }

    public static Object applyN(int i, Object obj, Object aobj[])
    {
        int k = aobj.length;
        for (int j = 0; j < k; j++)
        {
            obj = apply2(i, obj, aobj[j]);
        }

        return obj;
    }

    public static Object applyN(int i, Object aobj[])
    {
        int k = aobj.length;
        if (k != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = IntNum.zero();
_L4:
        return obj1;
_L2:
        Object obj = aobj[0];
        if (k == 1 && i < 0)
        {
            return $Mn(obj);
        }
        int j = 1;
        do
        {
            obj1 = obj;
            if (j >= k)
            {
                continue;
            }
            obj = apply2(i, obj, aobj[j]);
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object applyN(Object aobj[])
    {
        return applyN(plusOrMinus, aobj);
    }

}
