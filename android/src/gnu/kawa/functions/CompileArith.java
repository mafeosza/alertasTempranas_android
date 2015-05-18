// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.IgnoreTarget;
import gnu.expr.InlineCalls;
import gnu.expr.Inlineable;
import gnu.expr.PrimProcedure;
import gnu.expr.QuoteExp;
import gnu.expr.StackTarget;
import gnu.expr.Target;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.mapping.Procedure;
import gnu.math.IntNum;

// Referenced classes of package gnu.kawa.functions:
//            AddOp, BitwiseOp, DivideOp, ArithOp, 
//            Arithmetic, NumberPredicate

public class CompileArith
    implements Inlineable
{

    public static CompileArith $Mn;
    public static CompileArith $Pl;
    int op;
    Procedure proc;

    CompileArith(Object obj, int i)
    {
        proc = (Procedure)obj;
        op = i;
    }

    static int adjustReturnKind(int i, int j)
    {
        if (j < 4 || j > 7 || i <= 0) goto _L2; else goto _L1
_L1:
        j;
        JVM INSTR tableswitch 4 7: default 48
    //                   4 50
    //                   5 58
    //                   6 48
    //                   7 73;
           goto _L2 _L3 _L4 _L2 _L5
_L2:
        return i;
_L3:
        if (i <= 4)
        {
            return 6;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i <= 10 && i != 7)
        {
            return 8;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (i <= 10)
        {
            return 4;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public static boolean appropriateIntConstant(Expression aexpression[], int i, InlineCalls inlinecalls)
    {
        inlinecalls = inlinecalls.fixIntValue(aexpression[i]);
        if (inlinecalls != null)
        {
            aexpression[i] = inlinecalls;
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean appropriateLongConstant(Expression aexpression[], int i, InlineCalls inlinecalls)
    {
        inlinecalls = inlinecalls.fixLongValue(aexpression[i]);
        if (inlinecalls != null)
        {
            aexpression[i] = inlinecalls;
            return true;
        } else
        {
            return false;
        }
    }

    public static CompileArith forBitwise(Object obj)
    {
        return new CompileArith(obj, ((BitwiseOp)obj).op);
    }

    public static CompileArith forDiv(Object obj)
    {
        return new CompileArith(obj, ((DivideOp)obj).op);
    }

    public static CompileArith forMul(Object obj)
    {
        return new CompileArith(obj, 3);
    }

    public static int getReturnKind(int i, int j, int k)
    {
label0:
        {
            if (k >= 9 && k <= 12)
            {
                return i;
            }
            if (i > 0)
            {
                k = j;
                if (i <= j)
                {
                    break label0;
                }
                k = j;
                if (j <= 0)
                {
                    break label0;
                }
            }
            k = i;
        }
        return k;
    }

    public static Expression pairwise(Procedure procedure, Expression expression, Expression aexpression[], InlineCalls inlinecalls)
    {
        int j = aexpression.length;
        Object obj = aexpression[0];
        for (int i = 1; i < j; i++)
        {
            obj = new ApplyExp(expression, new Expression[] {
                obj, aexpression[i]
            });
            Expression expression1 = inlinecalls.maybeInline(((ApplyExp) (obj)), null, procedure);
            if (expression1 != null)
            {
                obj = expression1;
            }
        }

        return ((Expression) (obj));
    }

    public static Expression validateApplyAdd(AddOp addop, ApplyExp applyexp, InlineCalls inlinecalls)
    {
        Expression aexpression[] = applyexp.getArgs();
        inlinecalls = applyexp;
        if (aexpression.length == 1)
        {
            inlinecalls = applyexp;
            if (addop.plusOrMinus < 0)
            {
                addop = aexpression[0].getType();
                inlinecalls = applyexp;
                if (addop instanceof PrimType)
                {
                    char c = addop.getSignature().charAt(0);
                    inlinecalls = null;
                    boolean flag = false;
                    int i = ((flag) ? 1 : 0);
                    addop = inlinecalls;
                    if (c != 'V')
                    {
                        i = ((flag) ? 1 : 0);
                        addop = inlinecalls;
                        if (c != 'Z')
                        {
                            if (c == 'C')
                            {
                                addop = inlinecalls;
                                i = ((flag) ? 1 : 0);
                            } else
                            if (c == 'D')
                            {
                                i = 119;
                                addop = LangPrimType.doubleType;
                            } else
                            if (c == 'F')
                            {
                                i = 118;
                                addop = LangPrimType.floatType;
                            } else
                            if (c == 'J')
                            {
                                i = 117;
                                addop = LangPrimType.longType;
                            } else
                            {
                                i = 116;
                                addop = LangPrimType.intType;
                            }
                        }
                    }
                    inlinecalls = applyexp;
                    if (addop != null)
                    {
                        inlinecalls = new ApplyExp(PrimProcedure.makeBuiltinUnary(i, addop), aexpression);
                    }
                }
            }
        }
        return inlinecalls;
    }

    public static Expression validateApplyArithOp(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        int l = ((ArithOp)procedure).op;
        applyexp.visitArgs(inlinecalls);
        type = applyexp.getArgs();
        int i;
        if (type.length > 2)
        {
            type = pairwise(procedure, applyexp.getFunction(), type, inlinecalls);
        } else
        {
            Expression expression = applyexp.inlineIfConstant(procedure, inlinecalls);
            if (expression != applyexp)
            {
                return expression;
            }
            i = 0;
            if (type.length == 2 || type.length == 1)
            {
                int j = Arithmetic.classifyType(type[0].getType());
                if (type.length == 2 && (l < 9 || l > 12))
                {
                    int i1 = Arithmetic.classifyType(type[1].getType());
                    int k = getReturnKind(j, i1, l);
                    i = k;
                    if (k == 4)
                    {
                        if (j == 1 && appropriateIntConstant(type, 1, inlinecalls))
                        {
                            i = 1;
                        } else
                        if (i1 == 1 && appropriateIntConstant(type, 0, inlinecalls))
                        {
                            i = 1;
                        } else
                        if (j == 2 && appropriateLongConstant(type, 1, inlinecalls))
                        {
                            i = 2;
                        } else
                        {
                            i = k;
                            if (i1 == 2)
                            {
                                i = k;
                                if (appropriateLongConstant(type, 0, inlinecalls))
                                {
                                    i = 2;
                                }
                            }
                        }
                    }
                } else
                {
                    i = j;
                }
                i = adjustReturnKind(i, l);
                applyexp.setType(Arithmetic.kindType(i));
            }
            type = applyexp;
            if (inlinecalls.getCompilation().mustCompile)
            {
                switch (l)
                {
                case 3: // '\003'
                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
                case 12: // '\f'
                case 13: // '\r'
                case 14: // '\016'
                case 15: // '\017'
                default:
                    return applyexp;

                case 1: // '\001'
                case 2: // '\002'
                    return validateApplyAdd((AddOp)procedure, applyexp, inlinecalls);

                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                    return validateApplyDiv((DivideOp)procedure, applyexp, inlinecalls);

                case 16: // '\020'
                    type = applyexp;
                    break;
                }
                continue;
            }
        }
        do
        {
            return type;
        } while (i <= 0);
        return validateApplyNot(applyexp, i, inlinecalls);
    }

    public static Expression validateApplyDiv(DivideOp divideop, ApplyExp applyexp, InlineCalls inlinecalls)
    {
        inlinecalls = applyexp.getArgs();
        divideop = applyexp;
        if (inlinecalls.length == 1)
        {
            divideop = QuoteExp.getInstance(IntNum.one());
            inlinecalls = inlinecalls[0];
            divideop = new ApplyExp(applyexp.getFunction(), new Expression[] {
                divideop, inlinecalls
            });
        }
        return divideop;
    }

    public static Expression validateApplyNot(ApplyExp applyexp, int i, InlineCalls inlinecalls)
    {
        Object obj = applyexp;
        if (applyexp.getArgCount() == 1)
        {
            obj = applyexp.getArg(0);
            if (i == 1 || i == 2)
            {
                applyexp = QuoteExp.getInstance(IntNum.minusOne());
                obj = inlinecalls.visitApplyOnly(new ApplyExp(BitwiseOp.xor, new Expression[] {
                    obj, applyexp
                }), null);
            } else
            {
                if (i == 4)
                {
                    inlinecalls = "gnu.math.BitOps";
                } else
                if (i == 3)
                {
                    inlinecalls = "java.meth.BigInteger";
                } else
                {
                    inlinecalls = null;
                }
                obj = applyexp;
                if (inlinecalls != null)
                {
                    return new ApplyExp(ClassType.make(inlinecalls).getDeclaredMethod("not", 1), applyexp.getArgs());
                }
            }
        }
        return ((Expression) (obj));
    }

    public static Expression validateApplyNumberCompare(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        applyexp.visitArgs(inlinecalls);
        inlinecalls = applyexp.inlineIfConstant(procedure, inlinecalls);
        if (inlinecalls != applyexp)
        {
            return inlinecalls;
        } else
        {
            return applyexp;
        }
    }

    public static Expression validateApplyNumberPredicate(ApplyExp applyexp, InlineCalls inlinecalls, Type type, Procedure procedure)
    {
        int i = ((NumberPredicate)procedure).op;
        type = applyexp.getArgs();
        type[0] = inlinecalls.visit(type[0], LangObjType.integerType);
        applyexp.setType(Type.booleanType);
        return applyexp;
    }

    public void compile(ApplyExp applyexp, Compilation compilation, Target target)
    {
        Object obj;
        Object obj1;
        Expression aexpression[];
        int i;
        int j;
        int k;
        int l;
        int i1;
        aexpression = applyexp.getArgs();
        k = aexpression.length;
        if (k == 0)
        {
            compilation.compileConstant(((ArithOp)proc).defaultResult(), target);
            return;
        }
        if (k == 1 || (target instanceof IgnoreTarget))
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
        l = Arithmetic.classifyType(aexpression[0].getType());
        i1 = Arithmetic.classifyType(aexpression[1].getType());
        j = getReturnKind(l, i1, op);
        obj = Arithmetic.kindType(j);
        if (j == 0 || k != 2)
        {
            ApplyExp.compile(applyexp, compilation, target);
            return;
        }
        i = Arithmetic.classifyType(target.getType());
        if ((i == 1 || i == 2) && j >= 1 && j <= 4)
        {
            j = i;
            if (i == 1)
            {
                obj = LangPrimType.intType;
                i = j;
            } else
            {
                obj = LangPrimType.longType;
                i = j;
            }
        } else
        if ((i == 8 || i == 7) && j > 2 && j <= 10)
        {
            j = i;
            if (i == 7)
            {
                obj = LangPrimType.floatType;
            } else
            {
                obj = LangPrimType.doubleType;
            }
            i = j;
        } else
        if (j == 7)
        {
            obj = LangPrimType.floatType;
            i = j;
        } else
        if (j == 8 || j == 9)
        {
            i = 8;
            obj = LangPrimType.doubleType;
        } else
        {
            i = j;
        }
_L22:
        j = i;
        if (op < 4) goto _L2; else goto _L1
_L1:
        j = i;
        if (op > 8) goto _L2; else goto _L3
_L3:
        obj1 = (DivideOp)proc;
        if (((DivideOp) (obj1)).op != 4) goto _L5; else goto _L4
_L4:
        j = i;
        if (i <= 4) goto _L2; else goto _L6
_L6:
        j = i;
        if (i >= 6) goto _L2; else goto _L7
_L7:
        if (i > 9) goto _L5; else goto _L8
_L8:
        j = i;
_L2:
        if (op == 4 && j <= 10 && j != 8 && j != 7)
        {
            if (j == 6 || j > 4)
            {
                if (j == 6)
                {
                    applyexp = Arithmetic.typeRatNum;
                } else
                {
                    applyexp = Arithmetic.typeRealNum;
                }
                obj = applyexp;
                obj1 = applyexp.getDeclaredMethod("divide", 2);
                applyexp = ((ApplyExp) (obj));
                obj = obj1;
            } else
            {
                applyexp = Arithmetic.typeIntNum;
                obj = Arithmetic.typeRatNum.getDeclaredMethod("make", 2);
            }
            obj1 = StackTarget.getInstance(applyexp);
            aexpression[0].compile(compilation, ((Target) (obj1)));
            aexpression[1].compile(compilation, ((Target) (obj1)));
            compilation.getCode().emitInvokeStatic(((gnu.bytecode.Method) (obj)));
            obj1 = applyexp;
        } else
        {
label0:
            {
                if (j != 4 || op != 1 && op != 3 && op != 2 && op != 13 && op != 14 && op != 15 && op != 7 && op != 8 && (op < 9 || op > 11))
                {
                    break label0;
                }
                compileIntNum(aexpression[0], aexpression[1], l, i1, compilation);
                obj1 = obj;
            }
        }
_L16:
        target.compileFromStack(compilation, ((Type) (obj1)));
        return;
_L5:
label1:
        {
            if ((((DivideOp) (obj1)).op != 5 || i > 10 || i == 7) && (((DivideOp) (obj1)).op != 4 || i != 10))
            {
                break label1;
            }
            j = 8;
        }
          goto _L2
        if (((DivideOp) (obj1)).op != 7 && (((DivideOp) (obj1)).op != 6 || i > 4))
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        if (((DivideOp) (obj1)).getRoundingMode() == 3) goto _L2; else goto _L9
_L9:
        j = i;
        if (i == 4) goto _L2; else goto _L10
_L10:
        j = i;
        if (i == 7) goto _L2; else goto _L11
_L11:
        j = i;
        if (i == 8) goto _L2; else goto _L12
_L12:
        if (((DivideOp) (obj1)).op != 8)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        if (((DivideOp) (obj1)).getRoundingMode() == 3) goto _L2; else goto _L13
_L13:
        j = i;
        if (i == 4) goto _L2; else goto _L14
_L14:
        ApplyExp.compile(applyexp, compilation, target);
        return;
        CodeAttr codeattr;
        if (j != 1 && j != 2 && (j != 7 && j != 8 || op > 8 && op < 13))
        {
            break MISSING_BLOCK_LABEL_1041;
        }
        applyexp = StackTarget.getInstance(((Type) (obj)));
        codeattr = compilation.getCode();
        i = 0;
_L19:
        obj1 = obj;
        if (i >= k) goto _L16; else goto _L15
_L15:
        obj1 = applyexp;
        if (i == 1)
        {
            obj1 = applyexp;
            if (op >= 9)
            {
                obj1 = applyexp;
                if (op <= 12)
                {
                    obj1 = StackTarget.getInstance(Type.intType);
                }
            }
        }
        aexpression[i].compile(compilation, ((Target) (obj1)));
        if (i != 0) goto _L18; else goto _L17
_L17:
        i++;
        applyexp = ((ApplyExp) (obj1));
          goto _L19
_L18:
        switch (j)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 7: // '\007'
        case 8: // '\b'
            if (op == 9)
            {
                applyexp = Type.intType;
                codeattr.emitInvokeStatic(ClassType.make("gnu.math.IntNum").getDeclaredMethod("shift", new Type[] {
                    obj, applyexp
                }));
            } else
            {
                codeattr.emitBinop(primitiveOpcode(), (PrimType)((Type) (obj)).getImplementationType());
            }
            break;
        }
        if (true) goto _L17; else goto _L20
_L20:
        ApplyExp.compile(applyexp, compilation, target);
        return;
        if (true) goto _L22; else goto _L21
_L21:
    }

    public boolean compileIntNum(Expression expression, Expression expression1, int i, int j, Compilation compilation)
    {
        Object obj3;
        PrimType primtype;
        Object obj4;
        LangObjType langobjtype;
        CodeAttr codeattr;
        if (op == 2 && (expression1 instanceof QuoteExp))
        {
            Object obj = expression1.valueIfConstant();
            long l;
            boolean flag;
            if (j <= 2)
            {
                l = ((Number)obj).longValue();
                if (l > 0xffffffff80000000L && l <= 0x7fffffffL)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
            } else
            if (obj instanceof IntNum)
            {
                obj = (IntNum)obj;
                l = ((IntNum) (obj)).longValue();
                flag = ((IntNum) (obj)).inRange(0xffffffff80000001L, 0x7fffffffL);
            } else
            {
                flag = false;
                l = 0L;
            }
            if (flag)
            {
                return $Pl.compileIntNum(expression, ((Expression) (QuoteExp.getInstance(Integer.valueOf((int)(-l))))), i, 1, compilation);
            }
        }
        int k;
        if (op == 1 || op == 3)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        Object obj1;
        if (k != 0)
        {
            k = i;
            if (InlineCalls.checkIntValue(expression) != null)
            {
                k = 1;
            }
            if (InlineCalls.checkIntValue(expression1) != null)
            {
                j = 1;
            }
            if (k == 1 && j != 1)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (i != 0 && (!expression.side_effects() || !expression1.side_effects()))
            {
                return compileIntNum(expression1, expression, j, k, compilation);
            }
            if (k == 1)
            {
                obj3 = Type.intType;
            } else
            {
                obj3 = Arithmetic.typeIntNum;
            }
            if (j == 1)
            {
                obj1 = Type.intType;
            } else
            {
                obj1 = Arithmetic.typeIntNum;
            }
        } else
        if (op >= 9 && op <= 12)
        {
            obj3 = Arithmetic.typeIntNum;
            obj1 = Type.intType;
            i = 0;
        } else
        {
            obj1 = Arithmetic.typeIntNum;
            obj3 = obj1;
            i = 0;
        }
        expression.compile(compilation, ((Type) (obj3)));
        expression1.compile(compilation, ((Type) (obj1)));
        codeattr = compilation.getCode();
        primtype = ((PrimType) (obj1));
        if (i != 0)
        {
            codeattr.emitSwap();
            obj3 = Arithmetic.typeIntNum;
            primtype = LangPrimType.intType;
        }
        expression = null;
        expression1 = null;
        obj4 = null;
        langobjtype = Arithmetic.typeIntNum;
        op;
        JVM INSTR tableswitch 1 15: default 400
    //                   1 471
    //                   2 522
    //                   3 536
    //                   4 592
    //                   5 592
    //                   6 592
    //                   7 592
    //                   8 592
    //                   9 749
    //                   10 715
    //                   11 715
    //                   12 400
    //                   13 550
    //                   14 554
    //                   15 564;
           goto _L1 _L2 _L3 _L4 _L5 _L5 _L5 _L5 _L5 _L6 _L7 _L7 _L1 _L8 _L9 _L10
_L1:
        throw new Error();
_L2:
        expression = "add";
        compilation = langobjtype;
        expression1 = obj4;
_L12:
        Type atype[] = expression1;
        if (expression1 == null)
        {
            atype = new Type[2];
            atype[0] = obj3;
            atype[1] = primtype;
        }
        codeattr.emitInvokeStatic(compilation.getMethod(expression, atype));
        return true;
_L3:
        expression = "sub";
        expression1 = obj4;
        compilation = langobjtype;
        continue; /* Loop/switch isn't completed */
_L4:
        expression = "times";
        expression1 = obj4;
        compilation = langobjtype;
        continue; /* Loop/switch isn't completed */
_L8:
        expression1 = "and";
_L9:
        expression = expression1;
        if (expression1 == null)
        {
            expression = "ior";
        }
_L10:
        Object obj2 = expression;
        if (expression == null)
        {
            obj2 = "xor";
        }
        compilation = ClassType.make("gnu.math.BitOps");
        expression1 = obj4;
        expression = ((Expression) (obj2));
        continue; /* Loop/switch isn't completed */
_L5:
        String s;
        DivideOp divideop;
        if (op == 8)
        {
            s = "remainder";
        } else
        {
            s = "quotient";
        }
        divideop = (DivideOp)proc;
        if (op == 8 && divideop.rounding_mode == 1)
        {
            expression = "modulo";
            expression1 = obj4;
            compilation = langobjtype;
        } else
        {
            expression1 = obj4;
            compilation = langobjtype;
            expression = s;
            if (divideop.rounding_mode != 3)
            {
                codeattr.emitPushInt(divideop.rounding_mode);
                expression1 = new Type[3];
                expression1[0] = obj3;
                expression1[1] = primtype;
                expression1[2] = Type.intType;
                compilation = langobjtype;
                expression = s;
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (op == 10)
        {
            expression = "shiftLeft";
        } else
        {
            expression = "shiftRight";
        }
        compilation = ClassType.make("gnu.kawa.functions.BitwiseOp");
        expression1 = obj4;
        continue; /* Loop/switch isn't completed */
_L6:
        expression = "shift";
        expression1 = obj4;
        compilation = langobjtype;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public int getReturnKind(Expression aexpression[])
    {
        int i1 = aexpression.length;
        if (i1 != 0) goto _L2; else goto _L1
_L1:
        int k = 4;
_L4:
        return k;
_L2:
        ClassType classtype = Type.pointer_type;
        int i = 0;
        int j = 0;
        do
        {
            k = i;
            if (j >= i1)
            {
                continue;
            }
label0:
            {
                int l = Arithmetic.classifyType(aexpression[j].getType());
                if (j != 0 && l != 0)
                {
                    k = i;
                    if (l <= i)
                    {
                        break label0;
                    }
                }
                k = l;
            }
            j++;
            i = k;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Type getReturnType(Expression aexpression[])
    {
        return Arithmetic.kindType(adjustReturnKind(getReturnKind(aexpression), op));
    }

    public int primitiveOpcode()
    {
        switch (op)
        {
        case 9: // '\t'
        default:
            return -1;

        case 1: // '\001'
            return 96;

        case 2: // '\002'
            return 100;

        case 3: // '\003'
            return 104;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
            return 108;

        case 8: // '\b'
            return 112;

        case 10: // '\n'
            return 120;

        case 11: // '\013'
            return 122;

        case 12: // '\f'
            return 124;

        case 13: // '\r'
            return 126;

        case 14: // '\016'
            return 128;

        case 15: // '\017'
            return 130;
        }
    }

    static 
    {
        $Pl = new CompileArith(AddOp.$Pl, 1);
        $Mn = new CompileArith(AddOp.$Mn, 2);
    }
}
