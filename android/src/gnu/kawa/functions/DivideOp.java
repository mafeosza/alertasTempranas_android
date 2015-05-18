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
import gnu.math.RealNum;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

// Referenced classes of package gnu.kawa.functions:
//            ArithOp, Arithmetic

public class DivideOp extends ArithOp
{

    public static final DivideOp $Sl = new DivideOp("/", 4);
    public static final DivideOp div;
    public static final DivideOp div0;
    public static final DivideOp idiv;
    public static final DivideOp mod;
    public static final DivideOp mod0;
    public static final DivideOp modulo;
    public static final DivideOp quotient;
    public static final DivideOp remainder;
    int rounding_mode;

    public DivideOp(String s, int i)
    {
        super(s, i);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forDiv");
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        int j1 = aobj.length;
        if (j1 != 0) goto _L2; else goto _L1
_L1:
        aobj = IntNum.one();
_L20:
        return ((Object) (aobj));
_L2:
        Object obj1;
        int j;
        int i1;
        obj1 = (Number)aobj[0];
        if (j1 == 1)
        {
            return apply2(IntNum.one(), obj1);
        }
        j = Arithmetic.classifyValue(obj1);
        i1 = 1;
_L35:
        if (i1 >= j1) goto _L4; else goto _L3
_L3:
        Object obj;
        int i;
        int k;
        int l;
        obj = aobj[i1];
        k = Arithmetic.classifyValue(obj);
        i = j;
        if (j < k)
        {
            i = k;
        }
        j = i;
        l = i;
        k = j;
        if (i >= 4) goto _L6; else goto _L5
_L5:
        op;
        JVM INSTR tableswitch 4 5: default 128
    //                   4 320
    //                   5 320;
           goto _L7 _L8 _L8
_L7:
        if (rounding_mode != 3) goto _L10; else goto _L9
_L9:
        l = i;
        k = j;
        if (i == 1)
        {
            break; /* Loop/switch isn't completed */
        }
        if (i != 2) goto _L10; else goto _L11
_L11:
        k = j;
        l = i;
_L6:
        if (op != 5 || l > 10) goto _L13; else goto _L12
_L12:
        k = 10;
        i = l;
        j = k;
        if (l != 8)
        {
            i = l;
            j = k;
            if (l != 7)
            {
                i = 9;
                j = k;
            }
        }
_L23:
        j;
        JVM INSTR tableswitch 1 9: default 272
    //                   1 393
    //                   2 531
    //                   3 272
    //                   4 595
    //                   5 723
    //                   6 272
    //                   7 272
    //                   8 272
    //                   9 950;
           goto _L14 _L15 _L16 _L14 _L17 _L18 _L14 _L14 _L14 _L19
_L14:
        obj1 = Arithmetic.asNumeric(obj1);
        Object obj2 = Arithmetic.asNumeric(obj);
        double d;
        double d1;
        double d2;
        BigDecimal bigdecimal;
        long l1;
        long l2;
        if (op == 8 && ((Numeric) (obj2)).isZero())
        {
            aobj = ((Object []) (obj1));
            if (!((Numeric) (obj2)).isExact())
            {
                return ((Numeric) (obj1)).toInexact();
            }
        } else
        {
            Numeric numeric = ((Numeric) (obj1)).div(obj2);
            obj = numeric;
            if (op == 8)
            {
                obj = ((Numeric) (obj1)).sub(((RealNum)numeric).toInt(getRoundingMode()).mul(obj2));
            }
            switch (op)
            {
            case 7: // '\007'
                obj = ((RealNum)obj).toExactInt(rounding_mode);
                i = 4;
                j = 4;
                break;

            case 6: // '\006'
                obj = ((RealNum)obj).toInt(rounding_mode);
                break;

            case 5: // '\005'
                obj = ((Numeric) (obj)).toInexact();
                break;
            }
            continue; /* Loop/switch isn't completed */
        }
          goto _L20
_L8:
        l = 4;
        k = 4;
          goto _L6
_L10:
        k = 4;
        l = i;
          goto _L6
_L13:
        if (k == 8) goto _L22; else goto _L21
_L21:
        i = l;
        j = k;
        if (k != 7) goto _L23; else goto _L22
_L22:
        k = 9;
        i = l;
        j = k;
        if (op == 7)
        {
            i = 9;
            j = k;
        }
          goto _L23
_L15:
        k = Arithmetic.asInt(obj1);
        l = Arithmetic.asInt(obj);
        op;
        JVM INSTR tableswitch 8 8: default 428
    //                   8 521;
           goto _L24 _L25
_L24:
        k /= l;
_L36:
        obj = Integer.valueOf(k);
_L39:
        obj1 = obj;
        if (i == j) goto _L27; else goto _L26
_L26:
        obj1 = obj;
        i;
        JVM INSTR tableswitch 1 8: default 504
    //                   1 1233
    //                   2 1246
    //                   3 1285
    //                   4 508
    //                   5 508
    //                   6 508
    //                   7 1259
    //                   8 1272;
           goto _L28 _L29 _L30 _L31 _L32 _L32 _L32 _L33 _L34
_L32:
        break; /* Loop/switch isn't completed */
_L28:
        obj1 = obj;
_L27:
        i1++;
        j = i;
          goto _L35
_L25:
        k %= l;
          goto _L36
_L16:
        l1 = Arithmetic.asLong(obj1);
        l2 = Arithmetic.asLong(obj);
        op;
        JVM INSTR tableswitch 8 8: default 568
    //                   8 585;
           goto _L37 _L38
_L37:
        l1 /= l2;
_L40:
        obj = Long.valueOf(l1);
          goto _L39
_L38:
        l1 %= l2;
          goto _L40
_L17:
        switch (op)
        {
        case 5: // '\005'
        default:
            obj = obj1;
            break;

        case 4: // '\004'
            obj = RatNum.make(Arithmetic.asIntNum(obj1), Arithmetic.asIntNum(obj));
            if (obj instanceof IntNum)
            {
                i = 4;
            } else
            {
                i = 6;
            }
            j = i;
            break;

        case 6: // '\006'
        case 7: // '\007'
            obj = IntNum.quotient(Arithmetic.asIntNum(obj1), Arithmetic.asIntNum(obj), getRoundingMode());
            break;

        case 8: // '\b'
            obj = IntNum.remainder(Arithmetic.asIntNum(obj1), Arithmetic.asIntNum(obj), getRoundingMode());
            break;
        }
        if (true) goto _L39; else goto _L41
_L41:
_L18:
        bigdecimal = Arithmetic.asBigDecimal(obj1);
        obj2 = Arithmetic.asBigDecimal(obj);
        getRoundingMode();
        JVM INSTR tableswitch 1 5: default 776
    //                   1 851
    //                   2 859
    //                   3 867
    //                   4 776
    //                   5 875;
           goto _L42 _L43 _L44 _L45 _L42 _L46
_L42:
        obj = RoundingMode.HALF_EVEN;
_L47:
        obj = new MathContext(0, ((RoundingMode) (obj)));
        switch (op)
        {
        case 5: // '\005'
        default:
            obj = obj1;
            break;

        case 4: // '\004'
            obj = bigdecimal.divide(((BigDecimal) (obj2)));
            break;

        case 6: // '\006'
            obj = bigdecimal.divideToIntegralValue(((BigDecimal) (obj2)), ((MathContext) (obj)));
            break;

        case 7: // '\007'
            obj = bigdecimal.divideToIntegralValue(((BigDecimal) (obj2)), ((MathContext) (obj))).toBigInteger();
            j = 3;
            i = 3;
            break;

        case 8: // '\b'
            obj = bigdecimal.remainder(((BigDecimal) (obj2)), ((MathContext) (obj)));
            break;
        }
        break; /* Loop/switch isn't completed */
_L43:
        obj = RoundingMode.FLOOR;
          goto _L47
_L44:
        obj = RoundingMode.CEILING;
          goto _L47
_L45:
        obj = RoundingMode.DOWN;
          goto _L47
_L46:
        if (((BigDecimal) (obj2)).signum() < 0)
        {
            obj = RoundingMode.CEILING;
        } else
        {
            obj = RoundingMode.FLOOR;
        }
        if (true) goto _L42; else goto _L48
_L48:
        if (true) goto _L39; else goto _L49
_L49:
_L19:
        d1 = Arithmetic.asDouble(obj1);
        d2 = Arithmetic.asDouble(obj);
        switch (op)
        {
        default:
            obj = obj1;
            break;

        case 4: // '\004'
        case 5: // '\005'
            obj = DFloNum.make(d1 / d2);
            break;

        case 6: // '\006'
            obj = Double.valueOf(RealNum.toInt(d1 / d2, getRoundingMode()));
            break;

        case 7: // '\007'
            obj = RealNum.toExactInt(d1 / d2, getRoundingMode());
            j = 4;
            i = 4;
            break;

        case 8: // '\b'
            d = d1;
            if (d2 != 0.0D)
            {
                d = d1 - RealNum.toInt(d1 / d2, getRoundingMode()) * d2;
            }
            obj = DFloNum.make(d);
            break;
        }
        continue; /* Loop/switch isn't completed */
_L29:
        obj1 = Integer.valueOf(((Number) (obj)).intValue());
          goto _L27
_L30:
        obj1 = Long.valueOf(((Number) (obj)).longValue());
          goto _L27
_L33:
        obj1 = Float.valueOf(((Number) (obj)).floatValue());
          goto _L27
_L34:
        obj1 = Double.valueOf(((Number) (obj)).doubleValue());
          goto _L27
_L31:
        obj1 = Arithmetic.asBigInteger(obj);
          goto _L27
        if (true) goto _L39; else goto _L50
_L50:
_L4:
        return obj1;
          goto _L35
    }

    public int getRoundingMode()
    {
        return rounding_mode;
    }

    public int numArgs()
    {
        return op != 4 ? 8194 : -4095;
    }

    static 
    {
        idiv = new DivideOp("idiv", 7);
        quotient = new DivideOp("quotient", 6);
        remainder = new DivideOp("remainder", 8);
        modulo = new DivideOp("modulo", 8);
        div = new DivideOp("div", 6);
        mod = new DivideOp("mod", 8);
        div0 = new DivideOp("div0", 6);
        mod0 = new DivideOp("mod0", 8);
        idiv.rounding_mode = 3;
        quotient.rounding_mode = 3;
        remainder.rounding_mode = 3;
        modulo.rounding_mode = 1;
        div.rounding_mode = 5;
        mod.rounding_mode = 5;
        div0.rounding_mode = 4;
        mod0.rounding_mode = 4;
    }
}
