// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.ecmascript;

import gnu.mapping.Procedure;

// Referenced classes of package gnu.ecmascript:
//            BinaryOp

public class Reserved
{

    public static final int BREAK_TOKEN = 35;
    public static final int CONTINUE_TOKEN = 34;
    public static final int ELSE_TOKEN = 38;
    public static final int FOR_TOKEN = 33;
    public static final int FUNCTION_TOKEN = 41;
    public static final int IF_TOKEN = 31;
    public static final int LESS_OP = 5;
    public static final int LSHIFT_OP = 4;
    public static final int MINUS_OP = 2;
    public static final int NEW_TOKEN = 39;
    public static final int PLUS_OP = 1;
    public static final int RETURN_TOKEN = 36;
    public static final int THIS_TOKEN = 40;
    public static final int TIMES_OP = 3;
    public static final int VAR_TOKEN = 30;
    public static final int WHILE_TOKEN = 32;
    public static final int WITH_TOKEN = 37;
    static final Reserved opBitAnd = new Reserved("&", 5, 0);
    static final Reserved opBitOr = new Reserved("|", 3, 0);
    static final Reserved opBitXor = new Reserved("^", 4, 0);
    static final Reserved opBoolAnd = new Reserved("&&", 2, 0);
    static final Reserved opBoolOr = new Reserved("||", 1, 0);
    static final Reserved opDivide = new Reserved("/", 10, 0);
    static final Reserved opEqual = new Reserved("=", 6, 0);
    static final Reserved opGreater = new Reserved(">", 7, 0);
    static final Reserved opGreaterEqual = new Reserved(">=", 7, 0);
    static final Reserved opLess = new Reserved("<", 7, 5);
    static final Reserved opLessEqual = new Reserved("<=", 7, 0);
    static final Reserved opLshift = new Reserved("<<", 8, 4);
    static final Reserved opMinus = new Reserved("-", 9, 2);
    static Reserved opMinusMinus;
    static final Reserved opNotEqual = new Reserved("!=", 6, 0);
    static final Reserved opPlus = new Reserved("+", 9, 1);
    static Reserved opPlusPlus;
    static final Reserved opRemainder = new Reserved("%", 10, 0);
    static final Reserved opRshiftSigned = new Reserved(">>", 8, 0);
    static final Reserved opRshiftUnsigned = new Reserved(">>>", 8, 0);
    static final Reserved opTimes = new Reserved("*", 10, 3);
    String name;
    int prio;
    Procedure proc;

    public Reserved(String s, int i)
    {
        name = s;
        prio = i;
    }

    public Reserved(String s, int i, int j)
    {
        name = s;
        prio = i;
        proc = new BinaryOp(s, j);
    }

    public Reserved(String s, int i, Procedure procedure)
    {
        name = s;
        prio = i;
        proc = procedure;
    }

    public boolean isAssignmentOp()
    {
        return false;
    }

    public String toString()
    {
        return (new StringBuilder()).append("[Reserved \"").append(name).append("\" prio:").append(prio).append("]").toString();
    }

}
