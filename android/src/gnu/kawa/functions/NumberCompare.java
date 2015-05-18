// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.ConditionalTarget;
import gnu.expr.Expression;
import gnu.expr.IfExp;
import gnu.expr.Inlineable;
import gnu.expr.Language;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.math.RatNum;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package gnu.kawa.functions:
//            Arithmetic

public class NumberCompare extends ProcedureN
    implements Inlineable
{

    static final int RESULT_EQU = 0;
    static final int RESULT_GRT = 1;
    static final int RESULT_LSS = -1;
    static final int RESULT_NAN = -2;
    static final int RESULT_NEQ = -3;
    public static final int TRUE_IF_EQU = 8;
    public static final int TRUE_IF_GRT = 16;
    public static final int TRUE_IF_LSS = 4;
    public static final int TRUE_IF_NAN = 2;
    public static final int TRUE_IF_NEQ = 1;
    int flags;
    Language language;

    public static boolean $Eq(Object obj, Object obj1)
    {
        return apply2(8, obj, obj1);
    }

    public static boolean $Eq$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!$Eq(obj, obj1))
            {
                break label0;
            }
            flag = flag1;
            if (!$Eq(obj1, obj2))
            {
                break label0;
            }
            if (aobj.length != 0)
            {
                flag = flag1;
                if (!$Eq(obj2, aobj[0]))
                {
                    break label0;
                }
                flag = flag1;
                if (!applyN(8, aobj))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean $Gr(Object obj, Object obj1)
    {
        return apply2(16, obj, obj1);
    }

    public static boolean $Gr$Eq(Object obj, Object obj1)
    {
        return apply2(24, obj, obj1);
    }

    public static boolean $Gr$Eq$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!$Gr$Eq(obj, obj1))
            {
                break label0;
            }
            flag = flag1;
            if (!$Gr$Eq(obj1, obj2))
            {
                break label0;
            }
            if (aobj.length != 0)
            {
                flag = flag1;
                if (!$Gr$Eq(obj2, aobj[0]))
                {
                    break label0;
                }
                flag = flag1;
                if (!applyN(24, aobj))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean $Gr$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!$Gr(obj, obj1))
            {
                break label0;
            }
            flag = flag1;
            if (!$Gr(obj1, obj2))
            {
                break label0;
            }
            if (aobj.length != 0)
            {
                flag = flag1;
                if (!$Gr(obj2, aobj[0]))
                {
                    break label0;
                }
                flag = flag1;
                if (!applyN(16, aobj))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean $Ls(Object obj, Object obj1)
    {
        return apply2(4, obj, obj1);
    }

    public static boolean $Ls$Eq(Object obj, Object obj1)
    {
        return apply2(12, obj, obj1);
    }

    public static boolean $Ls$Eq$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!$Ls$Eq(obj, obj1))
            {
                break label0;
            }
            flag = flag1;
            if (!$Ls$Eq(obj1, obj2))
            {
                break label0;
            }
            if (aobj.length != 0)
            {
                flag = flag1;
                if (!$Ls$Eq(obj2, aobj[0]))
                {
                    break label0;
                }
                flag = flag1;
                if (!applyN(12, aobj))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public static boolean $Ls$V(Object obj, Object obj1, Object obj2, Object aobj[])
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (!$Ls(obj, obj1))
            {
                break label0;
            }
            flag = flag1;
            if (!$Ls(obj1, obj2))
            {
                break label0;
            }
            if (aobj.length != 0)
            {
                flag = flag1;
                if (!$Ls(obj2, aobj[0]))
                {
                    break label0;
                }
                flag = flag1;
                if (!applyN(4, aobj))
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public NumberCompare()
    {
    }

    public static boolean apply2(int i, Object obj, Object obj1)
    {
        return (1 << compare(obj, obj1, true) + 3 & i) != 0;
    }

    static boolean applyN(int i, Object aobj[])
    {
        for (int j = 0; j < aobj.length - 1; j++)
        {
            if (!apply2(i, aobj[j], aobj[j + 1]))
            {
                return false;
            }
        }

        return true;
    }

    public static boolean applyWithPromotion(int i, Object obj, Object obj1)
    {
        return checkCompareCode(compare(obj, obj1, false), i);
    }

    public static boolean checkCompareCode(int i, int j)
    {
        return (1 << i + 3 & j) != 0;
    }

    static int classify(Expression expression)
    {
        int j = Arithmetic.classifyType(expression.getType());
        int i = j;
        if (j == 4)
        {
            i = j;
            if (expression instanceof QuoteExp)
            {
                expression = ((Expression) (((QuoteExp)expression).getValue()));
                i = j;
                if (expression instanceof IntNum)
                {
                    int k = ((IntNum)expression).intLength();
                    if (k < 32)
                    {
                        i = 1;
                    } else
                    {
                        i = j;
                        if (k < 64)
                        {
                            return 2;
                        }
                    }
                }
            }
        }
        return i;
    }

    public static int compare(Object obj, int i, Object obj1, int j, boolean flag)
    {
        if (i < 0 || j < 0)
        {
            return -3;
        }
        int k;
        if (i < j)
        {
            k = j;
        } else
        {
            k = i;
        }
        k;
        JVM INSTR tableswitch 1 9: default 72
    //                   1 90
    //                   2 116
    //                   3 150
    //                   4 162
    //                   5 174
    //                   6 186
    //                   7 198
    //                   8 260
    //                   9 260;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L9
_L1:
        return Arithmetic.asNumeric(obj).compare(Arithmetic.asNumeric(obj1));
_L2:
        i = Arithmetic.asInt(obj);
        j = Arithmetic.asInt(obj1);
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
_L3:
        long l = Arithmetic.asLong(obj);
        long l1 = Arithmetic.asLong(obj1);
        if (l < l1)
        {
            return -1;
        }
        return l <= l1 ? 0 : 1;
_L4:
        return Arithmetic.asBigInteger(obj).compareTo(Arithmetic.asBigInteger(obj1));
_L5:
        return IntNum.compare(Arithmetic.asIntNum(obj), Arithmetic.asIntNum(obj1));
_L6:
        return Arithmetic.asBigDecimal(obj).compareTo(Arithmetic.asBigDecimal(obj1));
_L7:
        return RatNum.compare(Arithmetic.asRatNum(obj), Arithmetic.asRatNum(obj1));
_L8:
        if (!flag || i > 6 && j > 6)
        {
            float f = Arithmetic.asFloat(obj);
            float f1 = Arithmetic.asFloat(obj1);
            if (f > f1)
            {
                return 1;
            }
            if (f < f1)
            {
                return -1;
            }
            return f != f1 ? -2 : 0;
        }
_L9:
        if (flag && (i <= 6 || j <= 6)) goto _L1; else goto _L10
_L10:
        double d = Arithmetic.asDouble(obj);
        double d1 = Arithmetic.asDouble(obj1);
        if (d > d1)
        {
            return 1;
        }
        if (d < d1)
        {
            return -1;
        }
        return d != d1 ? -2 : 0;
    }

    public static int compare(Object obj, Object obj1, boolean flag)
    {
        return compare(obj, Arithmetic.classifyValue(obj), obj1, Arithmetic.classifyValue(obj1), flag);
    }

    public static NumberCompare make(Language language1, String s, int i)
    {
        NumberCompare numbercompare = new NumberCompare();
        numbercompare.language = language1;
        numbercompare.setName(s);
        numbercompare.flags = i;
        numbercompare.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileArith:validateApplyNumberCompare");
        return numbercompare;
    }

    public Object apply2(Object obj, Object obj1)
    {
        return getLanguage().booleanObject(apply2(flags, obj, obj1));
    }

    public Object applyN(Object aobj[])
    {
        return getLanguage().booleanObject(applyN(flags, aobj));
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Object obj3 = applyexp.getArgs();
        if (obj3.length != 2) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        CodeAttr codeattr;
        int i1;
        int j1;
        obj1 = obj3[0];
        obj2 = obj3[1];
        i1 = classify(((Expression) (obj1)));
        j1 = classify(((Expression) (obj2)));
        codeattr = compilation.getCode();
        if (i1 <= 0 || j1 <= 0 || i1 > 10 || j1 > 10 || i1 == 6 && j1 == 6) goto _L2; else goto _L3
_L3:
        Object obj;
        int i;
        int j;
        int k;
        int l;
        if (!(target instanceof ConditionalTarget))
        {
            IfExp.compile(applyexp, QuoteExp.trueExp, QuoteExp.falseExp, compilation, target);
            return;
        }
        j = flags;
        i = j;
        if (j == 1)
        {
            i = 20;
        }
        obj = obj1;
        applyexp = ((ApplyExp) (obj2));
        l = i1;
        k = j1;
        j = i;
        if (i1 > 4) goto _L5; else goto _L4
_L4:
        obj = obj1;
        applyexp = ((ApplyExp) (obj2));
        l = i1;
        k = j1;
        j = i;
        if (j1 > 4) goto _L5; else goto _L6
_L6:
        if (i1 > 2) goto _L8; else goto _L7
_L7:
        obj = obj1;
        applyexp = ((ApplyExp) (obj2));
        l = i1;
        k = j1;
        j = i;
        if (j1 <= 2) goto _L5; else goto _L8
_L8:
        Type atype[];
        atype = new Type[2];
        atype[0] = Arithmetic.typeIntNum;
        if (j1 > 2) goto _L10; else goto _L9
_L9:
        atype[1] = Type.longType;
        j = i;
        applyexp = ((ApplyExp) (obj3));
_L24:
        obj = new ApplyExp(new PrimProcedure(Arithmetic.typeIntNum.getMethod("compare", atype)), applyexp);
        applyexp = new QuoteExp(IntNum.zero());
        k = 1;
        l = 1;
_L5:
        Expression aexpression[];
        if (l <= 1 && k <= 1)
        {
            obj1 = Type.intType;
        } else
        if (l <= 2 && k <= 2)
        {
            obj1 = Type.longType;
        } else
        {
            obj1 = Type.doubleType;
        }
        obj2 = new StackTarget(((Type) (obj1)));
        obj3 = (ConditionalTarget)target;
        obj1 = obj;
        target = applyexp;
        i = j;
        if (obj instanceof QuoteExp)
        {
            obj1 = obj;
            target = applyexp;
            i = j;
            if (!(applyexp instanceof QuoteExp))
            {
                obj1 = applyexp;
                target = ((Target) (obj));
                i = j;
                if (j != 8)
                {
                    obj1 = applyexp;
                    target = ((Target) (obj));
                    i = j;
                    if (j != 20)
                    {
                        i = j ^ 0x14;
                        target = ((Target) (obj));
                        obj1 = applyexp;
                    }
                }
            }
        }
        if (((ConditionalTarget) (obj3)).trueBranchComesFirst)
        {
            applyexp = ((ConditionalTarget) (obj3)).ifFalse;
        } else
        {
            applyexp = ((ConditionalTarget) (obj3)).ifTrue;
        }
        j = i;
        if (((ConditionalTarget) (obj3)).trueBranchComesFirst)
        {
            j = i ^ 0x1c;
        }
        j;
        JVM INSTR lookupswitch 6: default 492
    //                   4: 740
    //                   8: 732
    //                   12: 764
    //                   16: 724
    //                   20: 748
    //                   24: 756;
           goto _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L11:
        i = 0;
_L21:
        ((Expression) (obj1)).compile(compilation, ((Target) (obj2)));
        if (l > 1 || k > 1 || !(target instanceof QuoteExp)) goto _L19; else goto _L18
_L18:
        obj = ((QuoteExp)target).getValue();
        if (!(obj instanceof IntNum) || !((IntNum)obj).isZero()) goto _L19; else goto _L20
_L20:
        codeattr.emitGotoIfCompare1(applyexp, i);
_L22:
        ((ConditionalTarget) (obj3)).emitGotoFirstBranch(codeattr);
        return;
_L10:
        if (i1 <= 2 && ((obj1 instanceof QuoteExp) || (obj2 instanceof QuoteExp) || (obj1 instanceof ReferenceExp) || (obj2 instanceof ReferenceExp)))
        {
            atype[1] = Type.longType;
            aexpression = new Expression[2];
            aexpression[0] = ((Expression) (obj2));
            aexpression[1] = ((Expression) (obj1));
            applyexp = aexpression;
            j = i;
            if (i != 8)
            {
                applyexp = aexpression;
                j = i;
                if (i != 20)
                {
                    j = i ^ 0x14;
                    applyexp = aexpression;
                }
            }
        } else
        {
            atype[1] = Arithmetic.typeIntNum;
            applyexp = ((ApplyExp) (obj3));
            j = i;
        }
        continue; /* Loop/switch isn't completed */
_L15:
        i = 157;
          goto _L21
_L13:
        i = 153;
          goto _L21
_L12:
        i = 155;
          goto _L21
_L16:
        i = 154;
          goto _L21
_L17:
        i = 156;
          goto _L21
_L14:
        i = 158;
          goto _L21
_L19:
        target.compile(compilation, ((Target) (obj2)));
        codeattr.emitGotoIfCompare2(applyexp, i);
          goto _L22
_L2:
        ApplyExp.compile(applyexp, compilation, target);
        return;
        if (true) goto _L24; else goto _L23
_L23:
    }

    protected final Language getLanguage()
    {
        return language;
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Type.booleanType;
    }

    public int numArgs()
    {
        return -4094;
    }
}
