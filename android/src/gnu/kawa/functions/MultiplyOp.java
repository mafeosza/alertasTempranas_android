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

public class MultiplyOp extends ArithOp
{

    public static final MultiplyOp $St = new MultiplyOp("*");

    public MultiplyOp(String s)
    {
        super(s, 3);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forMul");
    }

    public static Object apply(Object obj, Object obj1)
    {
        return ((Numeric)obj).mul(obj1);
    }

    public Object applyN(Object aobj[])
    {
        int i1 = aobj.length;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = IntNum.one();
_L4:
        return obj1;
_L2:
        Object obj;
        int i;
        int j;
        obj = (Number)aobj[0];
        j = Arithmetic.classifyValue(obj);
        i = 1;
_L15:
        obj1 = obj;
        if (i >= i1) goto _L4; else goto _L3
_L3:
        int k;
        obj1 = aobj[i];
        int l = Arithmetic.classifyValue(obj1);
        k = j;
        if (j < l)
        {
            k = l;
        }
        k;
        JVM INSTR tableswitch 1 9: default 120
    //                   1 145
    //                   2 165
    //                   3 185
    //                   4 200
    //                   5 215
    //                   6 230
    //                   7 245
    //                   8 265
    //                   9 285;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L14:
        break MISSING_BLOCK_LABEL_285;
_L5:
        obj = Arithmetic.asNumeric(obj).mul(Arithmetic.asNumeric(obj1));
_L16:
        i++;
        j = k;
          goto _L15
_L6:
        obj = new Integer(Arithmetic.asInt(obj) * Arithmetic.asInt(obj1));
          goto _L16
_L7:
        obj = new Long(Arithmetic.asLong(obj) * Arithmetic.asLong(obj1));
          goto _L16
_L8:
        obj = Arithmetic.asBigInteger(obj).multiply(Arithmetic.asBigInteger(obj1));
          goto _L16
_L9:
        obj = IntNum.times(Arithmetic.asIntNum(obj), Arithmetic.asIntNum(obj1));
          goto _L16
_L10:
        obj = Arithmetic.asBigDecimal(obj).multiply(Arithmetic.asBigDecimal(obj1));
          goto _L16
_L11:
        obj = RatNum.times(Arithmetic.asRatNum(obj), Arithmetic.asRatNum(obj1));
          goto _L16
_L12:
        obj = new Float(Arithmetic.asFloat(obj) * Arithmetic.asFloat(obj1));
          goto _L16
_L13:
        obj = new Double(Arithmetic.asDouble(obj) * Arithmetic.asDouble(obj1));
          goto _L16
        obj = new DFloNum(Arithmetic.asDouble(obj) * Arithmetic.asDouble(obj1));
          goto _L16
    }

    public Object defaultResult()
    {
        return IntNum.one();
    }

}
