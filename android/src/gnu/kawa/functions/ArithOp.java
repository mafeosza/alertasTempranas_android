// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.mapping.ProcedureN;
import gnu.math.IntNum;

// Referenced classes of package gnu.kawa.functions:
//            Arithmetic

public abstract class ArithOp extends ProcedureN
{

    static final int ADD = 1;
    public static final int AND = 13;
    public static final int ASHIFT_GENERAL = 9;
    public static final int ASHIFT_LEFT = 10;
    public static final int ASHIFT_RIGHT = 11;
    public static final int DIVIDE_GENERIC = 4;
    public static final int DIVIDE_INEXACT = 5;
    public static final int IOR = 14;
    public static final int LSHIFT_RIGHT = 12;
    public static final int MODULO = 8;
    static final int MUL = 3;
    public static final int NOT = 16;
    public static final int QUOTIENT = 6;
    public static final int QUOTIENT_EXACT = 7;
    static final int SUB = 2;
    public static final int XOR = 15;
    final int op;

    public ArithOp(String s, int i)
    {
        super(s);
        op = i;
    }

    public static int classify(Type type)
    {
        byte byte0 = 4;
        if (!(type instanceof PrimType)) goto _L2; else goto _L1
_L1:
        char c = type.getSignature().charAt(0);
        if (c != 'V' && c != 'Z' && c != 'C') goto _L4; else goto _L3
_L3:
        byte0 = 0;
_L6:
        return byte0;
_L4:
        if (c == 'D' || c == 'F')
        {
            return 3;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!type.isSubtype(Arithmetic.typeIntNum))
        {
            if (type.isSubtype(Arithmetic.typeDFloNum))
            {
                return 3;
            }
            if (type.isSubtype(Arithmetic.typeRealNum))
            {
                return 2;
            }
            return !type.isSubtype(Arithmetic.typeNumeric) ? 0 : 1;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Object defaultResult()
    {
        return IntNum.zero();
    }

    public boolean isSideEffectFree()
    {
        return true;
    }
}
