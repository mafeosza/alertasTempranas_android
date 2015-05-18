// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.LazyPropertyKey;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import gnu.math.BitOps;
import gnu.math.IntNum;
import java.math.BigInteger;

// Referenced classes of package gnu.kawa.functions:
//            ArithOp, Arithmetic

public class BitwiseOp extends ArithOp
{

    public static final BitwiseOp and = new BitwiseOp("bitwise-and", 13);
    public static final BitwiseOp ashift = new BitwiseOp("bitwise-arithmetic-shift", 9);
    public static final BitwiseOp ashiftl = new BitwiseOp("bitwise-arithmetic-shift-left", 10);
    public static final BitwiseOp ashiftr = new BitwiseOp("bitwise-arithmetic-shift-right", 11);
    public static final BitwiseOp ior = new BitwiseOp("bitwise-ior", 14);
    public static final BitwiseOp not = new BitwiseOp("bitwise-not", 16);
    public static final BitwiseOp xor = new BitwiseOp("bitwise-xor", 15);

    public BitwiseOp(String s, int i)
    {
        super(s, i);
        setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyArithOp");
        Procedure.compilerKey.set(this, "*gnu.kawa.functions.CompileArith:forBitwise");
    }

    public static int checkNonNegativeShift(Procedure procedure, int i)
    {
        if (i < 0)
        {
            throw new WrongType(procedure, 2, Integer.valueOf(i), "non-negative integer");
        } else
        {
            return i;
        }
    }

    public static IntNum shiftLeft(IntNum intnum, int i)
    {
        return IntNum.shift(intnum, checkNonNegativeShift(ashiftl, i));
    }

    public static IntNum shiftRight(IntNum intnum, int i)
    {
        return IntNum.shift(intnum, -checkNonNegativeShift(ashiftr, i));
    }

    public Object adjustResult(IntNum intnum, int i)
    {
        switch (i)
        {
        default:
            return intnum;

        case 1: // '\001'
            return Integer.valueOf(intnum.intValue());

        case 2: // '\002'
            return Long.valueOf(intnum.longValue());

        case 3: // '\003'
            return new BigInteger(intnum.toString());
        }
    }

    public Object apply1(Object obj)
    {
        if (op == 16)
        {
            int i = Arithmetic.classifyValue(obj);
            return adjustResult(BitOps.not(LangObjType.coerceIntNum(obj)), i);
        } else
        {
            return apply2(defaultResult(), obj);
        }
    }

    public Object apply2(Object obj, Object obj1)
    {
        int i;
        i = Arithmetic.classifyValue(obj);
        int j = Arithmetic.classifyValue(obj1);
        if ((op < 9 || op > 12) && i > 0 && (i <= j || j <= 0))
        {
            i = j;
        }
        obj = LangObjType.coerceIntNum(obj);
        obj1 = LangObjType.coerceIntNum(obj1);
        op;
        JVM INSTR tableswitch 9 15: default 100
    //                   9 145
    //                   10 145
    //                   11 145
    //                   12 100
    //                   13 114
    //                   14 127
    //                   15 136;
           goto _L1 _L2 _L2 _L2 _L1 _L3 _L4 _L5
_L1:
        throw new Error();
_L3:
        obj = BitOps.and(((IntNum) (obj)), ((IntNum) (obj1)));
_L7:
        return adjustResult(((IntNum) (obj)), i);
_L4:
        obj = BitOps.ior(((IntNum) (obj)), ((IntNum) (obj1)));
        continue; /* Loop/switch isn't completed */
_L5:
        obj = BitOps.xor(((IntNum) (obj)), ((IntNum) (obj1)));
        continue; /* Loop/switch isn't completed */
_L2:
        int k;
label0:
        {
            int l = ((IntNum) (obj1)).intValue();
            if (op != 11)
            {
                k = l;
                if (op != 10)
                {
                    break label0;
                }
            }
            checkNonNegativeShift(this, l);
            k = l;
            if (op == 11)
            {
                k = -l;
            }
        }
        obj = IntNum.shift(((IntNum) (obj)), k);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Object applyN(Object aobj[])
    {
        int j = aobj.length;
        if (j != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = defaultResult();
_L4:
        return obj1;
_L2:
        if (j == 1)
        {
            return apply1(aobj[0]);
        }
        Object obj = aobj[0];
        int i = 1;
        do
        {
            obj1 = obj;
            if (i >= j)
            {
                continue;
            }
            obj = apply2(obj, aobj[i]);
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Object defaultResult()
    {
        if (op == 13)
        {
            return IntNum.minusOne();
        } else
        {
            return IntNum.zero();
        }
    }

    public int numArgs()
    {
        if (op >= 9 && op <= 12)
        {
            return 8194;
        }
        return op != 16 ? -4096 : 4097;
    }

}
