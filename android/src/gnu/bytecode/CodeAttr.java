// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;

// Referenced classes of package gnu.bytecode:
//            Attribute, AttrContainer, Method, ClassType, 
//            Type, UninitializedType, ArrayType, PrimType, 
//            ObjectType, ConstantPool, TryState, Label, 
//            CpoolClass, LocalVarsAttr, Scope, Variable, 
//            StackMapTableAttr, LineNumbersAttr, ClassTypeWriter, IfState, 
//            ExitableBlock, SwitchState, Field, CpoolEntry, 
//            CpoolValue2, SourceDebugExtAttr

public class CodeAttr extends Attribute
    implements AttrContainer
{

    public static final int DONT_USE_JSR = 2;
    static final int FIXUP_CASE = 3;
    static final int FIXUP_DEFINE = 1;
    static final int FIXUP_DELETE3 = 8;
    static final int FIXUP_GOTO = 4;
    static final int FIXUP_JSR = 5;
    static final int FIXUP_LINE_NUMBER = 15;
    static final int FIXUP_LINE_PC = 14;
    static final int FIXUP_MOVE = 9;
    static final int FIXUP_MOVE_TO_END = 10;
    static final int FIXUP_NONE = 0;
    static final int FIXUP_SWITCH = 2;
    static final int FIXUP_TRANSFER = 6;
    static final int FIXUP_TRANSFER2 = 7;
    static final int FIXUP_TRY = 11;
    static final int FIXUP_TRY_END = 12;
    static final int FIXUP_TRY_HANDLER = 13;
    public static final int GENERATE_STACK_MAP_TABLE = 1;
    public static boolean instructionLineMode = false;
    int PC;
    int SP;
    Attribute attributes;
    byte code[];
    ExitableBlock currentExitableBlock;
    short exception_table[];
    int exception_table_length;
    int exitableBlockLevel;
    int fixup_count;
    Label fixup_labels[];
    int fixup_offsets[];
    int flags;
    IfState if_stack;
    LineNumbersAttr lines;
    Type local_types[];
    public LocalVarsAttr locals;
    private int max_locals;
    private int max_stack;
    Label previousLabel;
    SourceDebugExtAttr sourceDbgExt;
    public StackMapTableAttr stackMap;
    public Type stack_types[];
    TryState try_stack;
    private boolean unreachable_here;
    boolean varsSetInCurrentBlock[];

    public CodeAttr(Method method)
    {
        super("Code");
        addToFrontOf(method);
        method.code = this;
        if (method.getDeclaringClass().getClassfileMajorVersion() >= 50)
        {
            flags = flags | 3;
        }
    }

    private int adjustTypedOp(char c)
    {
        switch (c)
        {
        default:
            return 4;

        case 73: // 'I'
            return 0;

        case 74: // 'J'
            return 1;

        case 70: // 'F'
            return 2;

        case 68: // 'D'
            return 3;

        case 66: // 'B'
        case 90: // 'Z'
            return 5;

        case 67: // 'C'
            return 6;

        case 83: // 'S'
            return 7;
        }
    }

    private int adjustTypedOp(Type type)
    {
        return adjustTypedOp(type.getSignature().charAt(0));
    }

    public static final String calculateSplit(String s)
    {
        int j1 = s.length();
        StringBuffer stringbuffer = new StringBuffer(20);
        int k = 0;
        int j = 0;
        int i = 0;
        while (i < j1) 
        {
            char c = s.charAt(i);
            int l;
            int i1;
            if (c >= '\u0800')
            {
                c = '\003';
            } else
            if (c >= '\200' || c == 0)
            {
                c = '\002';
            } else
            {
                c = '\001';
            }
            i1 = j;
            l = k;
            if (j + c > 65535)
            {
                stringbuffer.append((char)(i - k));
                l = i;
                i1 = 0;
            }
            j = i1 + c;
            i++;
            k = l;
        }
        stringbuffer.append((char)(j1 - k));
        return stringbuffer.toString();
    }

    public static boolean castNeeded(Type type, Type type1)
    {
        Type type2 = type;
        Type type3 = type1;
        if (type instanceof UninitializedType)
        {
            type2 = ((UninitializedType)type).getImplementationType();
            type3 = type1;
        }
        do
        {
            if (type2 == type3)
            {
                return false;
            }
            if ((type3 instanceof ClassType) && (type2 instanceof ClassType) && ((ClassType)type2).isSubclass((ClassType)type3))
            {
                return false;
            }
            if ((type3 instanceof ArrayType) && (type2 instanceof ArrayType))
            {
                type3 = ((ArrayType)type3).getComponentType();
                type2 = ((ArrayType)type2).getComponentType();
            } else
            {
                return true;
            }
        } while (true);
    }

    private void emitBinop(int i)
    {
        Type type = popType().promote();
        Type type1 = popType();
        Type type2 = type1.promote();
        if (type2 != type || !(type2 instanceof PrimType))
        {
            throw new Error("non-matching or bad types in binary operation");
        } else
        {
            emitTypedOp(i, type2);
            pushType(type1);
            return;
        }
    }

    private void emitBinop(int i, char c)
    {
        popType();
        popType();
        emitTypedOp(i, c);
        pushType(Type.signatureToPrimitive(c));
    }

    private void emitCheckcast(Type type, int i)
    {
        reserve(3);
        popType();
        put1(i);
        if (type instanceof ObjectType)
        {
            putIndex2(getConstants().addClass((ObjectType)type));
            return;
        } else
        {
            throw new Error((new StringBuilder()).append("unimplemented type ").append(type).append(" in emitCheckcast/emitInstanceof").toString());
        }
    }

    private final void emitFieldop(Field field, int i)
    {
        reserve(3);
        put1(i);
        putIndex2(getConstants().addFieldRef(field));
    }

    private void emitShift(int i)
    {
        Type type = popType().promote();
        Type type1 = popType();
        Type type2 = type1.promote();
        if (type2 != Type.intType && type2 != Type.longType)
        {
            throw new Error("the value shifted must be an int or a long");
        }
        if (type != Type.intType)
        {
            throw new Error("the amount of shift must be an int");
        } else
        {
            emitTypedOp(i, type2);
            pushType(type1);
            return;
        }
    }

    private void emitTryEnd(boolean flag)
    {
        if (try_stack.tryClauseDone)
        {
            return;
        }
        try_stack.tryClauseDone = true;
        if (try_stack.finally_subr != null)
        {
            try_stack.exception = addLocal(Type.javalangThrowableType);
        }
        gotoFinallyOrEnd(flag);
        try_stack.end_try = getLabel();
    }

    private void emitTypedOp(int i, char c)
    {
        reserve(1);
        put1(adjustTypedOp(c) + i);
    }

    private void emitTypedOp(int i, Type type)
    {
        reserve(1);
        put1(adjustTypedOp(type) + i);
    }

    private final int fixupKind(int i)
    {
        return fixup_offsets[i] & 0xf;
    }

    private final int fixupOffset(int i)
    {
        return fixup_offsets[i] >> 4;
    }

    private void gotoFinallyOrEnd(boolean flag)
    {
        if (reachableHere())
        {
            if (try_stack.saved_result != null)
            {
                emitStore(try_stack.saved_result);
            }
            if (try_stack.end_label == null)
            {
                try_stack.end_label = new Label();
            }
            if (try_stack.finally_subr == null || useJsr())
            {
                if (try_stack.finally_subr != null)
                {
                    emitJsr(try_stack.finally_subr);
                }
                emitGoto(try_stack.end_label);
            } else
            {
                if (try_stack.exitCases != null)
                {
                    emitPushInt(0);
                }
                emitPushNull();
                if (!flag)
                {
                    emitGoto(try_stack.finally_subr);
                    return;
                }
            }
        }
    }

    private Label mergeLabels(Label label, Label label1)
    {
        if (label != null)
        {
            label1.setTypes(label);
        }
        return label1;
    }

    private void print(String s, int i, PrintWriter printwriter)
    {
        int j = 0;
        int k = -1;
        for (; i >= 0; i--)
        {
            j = k + 1;
            k = s.indexOf(';', j);
        }

        printwriter.write(s, j, k - j);
    }

    private int readInt(int i)
    {
        return readUnsignedShort(i) << 16 | readUnsignedShort(i + 2);
    }

    private int readUnsignedShort(int i)
    {
        return (code[i] & 0xff) << 8 | code[i + 1] & 0xff;
    }

    private int words(Type atype[])
    {
        int i = 0;
        int j = atype.length;
        do
        {
            j--;
            if (j >= 0)
            {
                if (atype[j].size > 4)
                {
                    i += 2;
                } else
                {
                    i++;
                }
            } else
            {
                return i;
            }
        } while (true);
    }

    public void addHandler(int i, int j, int k, int l)
    {
        int j1 = exception_table_length * 4;
        if (exception_table != null) goto _L2; else goto _L1
_L1:
        exception_table = new short[20];
_L4:
        short aword0[] = exception_table;
        int i1 = j1 + 1;
        aword0[j1] = (short)i;
        aword0 = exception_table;
        i = i1 + 1;
        aword0[i1] = (short)j;
        aword0 = exception_table;
        j = i + 1;
        aword0[i] = (short)k;
        exception_table[j] = (short)l;
        exception_table_length = exception_table_length + 1;
        return;
_L2:
        if (exception_table.length <= j1)
        {
            short aword1[] = new short[exception_table.length * 2];
            System.arraycopy(exception_table, 0, aword1, 0, j1);
            exception_table = aword1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void addHandler(Label label, Label label1, ClassType classtype)
    {
        ConstantPool constantpool = getConstants();
        int i;
        if (classtype == null)
        {
            i = 0;
        } else
        {
            i = constantpool.addClass(classtype).index;
        }
        fixupAdd(11, label);
        fixupAdd(12, i, label1);
        label1 = new Label();
        label1.localTypes = label.localTypes;
        label1.stackTypes = new Type[1];
        if (classtype == null)
        {
            label = Type.javalangThrowableType;
        } else
        {
            label = classtype;
        }
        label1.stackTypes[0] = label;
        setTypes(label1);
        fixupAdd(13, 0, label1);
    }

    public Variable addLocal(Type type)
    {
        return locals.current_scope.addVariable(this, type, null);
    }

    public Variable addLocal(Type type, String s)
    {
        return locals.current_scope.addVariable(this, type, s);
    }

    public void addParamLocals()
    {
        Method method = getMethod();
        if ((method.access_flags & 8) == 0)
        {
            addLocal(method.classfile).setParameter(true);
        }
        int j = method.arg_types.length;
        for (int i = 0; i < j; i++)
        {
            addLocal(method.arg_types[i]).setParameter(true);
        }

    }

    public void assignConstants(ClassType classtype)
    {
        if (locals != null && locals.container == null && !locals.isEmpty())
        {
            locals.addToFrontOf(this);
        }
        processFixups();
        if (stackMap != null && stackMap.numEntries > 0)
        {
            stackMap.addToFrontOf(this);
        }
        if (instructionLineMode)
        {
            if (lines == null)
            {
                lines = new LineNumbersAttr(this);
            }
            lines.linenumber_count = 0;
            int j = getCodeLength();
            for (int i = 0; i < j; i++)
            {
                lines.put(i, i);
            }

        }
        super.assignConstants(classtype);
        Attribute.assignConstants(this, classtype);
    }

    public int beginFragment(Label label)
    {
        return beginFragment(new Label(), label);
    }

    public int beginFragment(Label label, Label label1)
    {
        int i = fixup_count;
        fixupAdd(10, label1);
        label.define(this);
        return i;
    }

    public void disAssemble(ClassTypeWriter classtypewriter, int i, int j)
    {
        int k;
        int j1;
        k = 0;
        j1 = i;
_L3:
        int k1;
        boolean flag;
        if (j1 >= j)
        {
            break MISSING_BLOCK_LABEL_2029;
        }
        i = j1 + 1;
        k1 = code[j1] & 0xff;
        String s = Integer.toString(j1);
        flag = false;
        int l = s.length();
        do
        {
            l++;
            if (l > 3)
            {
                break;
            }
            classtypewriter.print(' ');
        } while (true);
        classtypewriter.print(s);
        classtypewriter.print(": ");
        if (k1 >= 120) goto _L2; else goto _L1
_L1:
        int i1;
        if (k1 < 87)
        {
            if (k1 < 3)
            {
                print("nop;aconst_null;iconst_m1;", k1, classtypewriter);
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 < 9)
            {
                classtypewriter.print("iconst_");
                classtypewriter.print(k1 - 3);
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 < 16)
            {
                char c;
                if (k1 < 11)
                {
                    c = 'l';
                    i1 = k1 - 9;
                } else
                if (k1 < 14)
                {
                    c = 'f';
                    i1 = k1 - 11;
                } else
                {
                    c = 'd';
                    i1 = k1 - 14;
                }
                classtypewriter.print(c);
                classtypewriter.print("const_");
                classtypewriter.print(i1);
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 < 21)
            {
                if (k1 < 18)
                {
                    print("bipush ;sipush ;", k1 - 16, classtypewriter);
                    if (k1 == 16)
                    {
                        i1 = code[i];
                        i++;
                    } else
                    {
                        i1 = (short)readUnsignedShort(i);
                        i += 2;
                    }
                    classtypewriter.print(i1);
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    if (k1 == 18)
                    {
                        i1 = 1;
                    } else
                    {
                        i1 = 2;
                    }
                    print("ldc;ldc_w;ldc2_w;", k1 - 18, classtypewriter);
                }
            } else
            {
                String s1;
                if (k1 < 54)
                {
                    s1 = "load";
                } else
                {
                    s1 = "store";
                    k1 -= 33;
                }
                if (k1 < 26)
                {
                    i1 = -1;
                    j1 = k1 - 21;
                } else
                if (k1 < 46)
                {
                    j1 = k1 - 26;
                    i1 = j1 % 4;
                    j1 >>= 2;
                } else
                {
                    i1 = -2;
                    j1 = k1 - 46;
                }
                classtypewriter.print("ilfdabcs".charAt(j1));
                if (i1 == -2)
                {
                    classtypewriter.write(97);
                }
                classtypewriter.print(s1);
                if (i1 >= 0)
                {
                    classtypewriter.write(95);
                    classtypewriter.print(i1);
                    j1 = k;
                    k1 = i;
                } else
                {
                    k1 = i;
                    j1 = k;
                    if (i1 == -1)
                    {
                        if (k != 0)
                        {
                            k = readUnsignedShort(i);
                            k1 = i + 2;
                            i = k;
                        } else
                        {
                            k = code[i] & 0xff;
                            k1 = i + 1;
                            i = k;
                        }
                        j1 = 0;
                        classtypewriter.print(' ');
                        classtypewriter.print(i);
                    }
                }
                i = k1;
                i1 = ((flag) ? 1 : 0);
                k = j1;
            }
        } else
        if (k1 < 96)
        {
            print("pop;pop2;dup;dup_x1;dup_x2;dup2;dup2_x1;dup2_x2;swap;", k1 - 87, classtypewriter);
            i1 = ((flag) ? 1 : 0);
        } else
        {
            classtypewriter.print("ilfda".charAt((k1 - 96) % 4));
            print("add;sub;mul;div;rem;neg;", k1 - 96 >> 2, classtypewriter);
            i1 = ((flag) ? 1 : 0);
        }
_L4:
        if (i1 > 0)
        {
            char c1;
            byte abyte1[];
            int l1;
            int i2;
            if (i1 == 1)
            {
                byte abyte0[] = code;
                j1 = i + 1;
                i1 = abyte0[i] & 0xff;
                i = j1;
            } else
            {
                i1 = readUnsignedShort(i);
                i += 2;
            }
            classtypewriter.printConstantOperand(i1);
        }
        classtypewriter.println();
        j1 = i;
        if (true) goto _L3; else goto _L2
_L2:
        if (k1 < 170)
        {
            if (k1 < 132)
            {
                if ((k1 & 1) == 0)
                {
                    c1 = 'i';
                } else
                {
                    c1 = 'l';
                }
                classtypewriter.print(c1);
                print("shl;shr;ushr;and;or;xor;", k1 - 120 >> 1, classtypewriter);
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 == 132)
            {
                classtypewriter.print("iinc");
                if (k == 0)
                {
                    abyte1 = code;
                    i1 = i + 1;
                    j1 = abyte1[i] & 0xff;
                    abyte1 = code;
                    i = i1 + 1;
                    i1 = abyte1[i1];
                } else
                {
                    j1 = readUnsignedShort(i);
                    i += 2;
                    i1 = (short)readUnsignedShort(i);
                    i += 2;
                    k = 0;
                }
                classtypewriter.print(' ');
                classtypewriter.print(j1);
                classtypewriter.print(' ');
                classtypewriter.print(i1);
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 < 148)
            {
                classtypewriter.print("ilfdi".charAt((k1 - 133) / 3));
                classtypewriter.print('2');
                classtypewriter.print("lfdifdildilfbcs".charAt(k1 - 133));
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 < 153)
            {
                print("lcmp;fcmpl;fcmpg;dcmpl;dcmpg;", k1 - 148, classtypewriter);
                i1 = ((flag) ? 1 : 0);
            } else
            if (k1 < 169)
            {
                if (k1 < 159)
                {
                    classtypewriter.print("if");
                    print("eq;ne;lt;ge;gt;le;", k1 - 153, classtypewriter);
                } else
                if (k1 < 167)
                {
                    if (k1 < 165)
                    {
                        classtypewriter.print("if_icmp");
                    } else
                    {
                        classtypewriter.print("if_acmp");
                        k1 -= 6;
                    }
                    print("eq;ne;lt;ge;gt;le;", k1 - 159, classtypewriter);
                } else
                {
                    print("goto;jsr;", k1 - 167, classtypewriter);
                }
                i1 = (short)readUnsignedShort(i);
                classtypewriter.print(' ');
                classtypewriter.print(j1 + i1);
                i += 2;
                i1 = ((flag) ? 1 : 0);
            } else
            {
                classtypewriter.print("ret ");
                if (k != 0)
                {
                    k = readUnsignedShort(i) + 2;
                } else
                {
                    k = code[i] & 0xff;
                    i++;
                }
                j1 = 0;
                classtypewriter.print(k);
                i1 = ((flag) ? 1 : 0);
                k = j1;
            }
        } else
        if (k1 < 172)
        {
            i1 = i;
            if (fixup_count <= 0)
            {
                i1 = i + 3 & -4;
            }
            i2 = readInt(i1);
            i = i1 + 4;
            if (k1 == 170)
            {
                classtypewriter.print("tableswitch");
                k1 = readInt(i);
                i += 4;
                l1 = readInt(i);
                i += 4;
                classtypewriter.print(" low: ");
                classtypewriter.print(k1);
                classtypewriter.print(" high: ");
                classtypewriter.print(l1);
                classtypewriter.print(" default: ");
                classtypewriter.print(j1 + i2);
                do
                {
                    i1 = i;
                    if (k1 > l1)
                    {
                        break;
                    }
                    i1 = readInt(i);
                    i += 4;
                    classtypewriter.println();
                    classtypewriter.print("  ");
                    classtypewriter.print(k1);
                    classtypewriter.print(": ");
                    classtypewriter.print(j1 + i1);
                    k1++;
                } while (true);
            } else
            {
                classtypewriter.print("lookupswitch");
                i1 = readInt(i);
                i += 4;
                classtypewriter.print(" npairs: ");
                classtypewriter.print(i1);
                classtypewriter.print(" default: ");
                classtypewriter.print(j1 + i2);
                do
                {
                    k1 = i1 - 1;
                    i1 = i;
                    if (k1 < 0)
                    {
                        break;
                    }
                    i1 = readInt(i);
                    i += 4;
                    l1 = readInt(i);
                    i += 4;
                    classtypewriter.println();
                    classtypewriter.print("  ");
                    classtypewriter.print(i1);
                    classtypewriter.print(": ");
                    classtypewriter.print(j1 + l1);
                    i1 = k1;
                } while (true);
            }
            i = i1;
            i1 = ((flag) ? 1 : 0);
        } else
        if (k1 < 178)
        {
            if (k1 < 177)
            {
                classtypewriter.print("ilfda".charAt(k1 - 172));
            }
            classtypewriter.print("return");
            i1 = ((flag) ? 1 : 0);
        } else
        if (k1 < 182)
        {
            print("getstatic;putstatic;getfield;putfield;", k1 - 178, classtypewriter);
            i1 = 2;
        } else
        if (k1 < 185)
        {
            classtypewriter.print("invoke");
            print("virtual;special;static;", k1 - 182, classtypewriter);
            i1 = 2;
        } else
        if (k1 == 185)
        {
            classtypewriter.print("invokeinterface (");
            i1 = readUnsignedShort(i);
            i += 2;
            j1 = code[i];
            classtypewriter.print((new StringBuilder()).append(j1 & 0xff).append(" args)").toString());
            classtypewriter.printConstantOperand(i1);
            i += 2;
            i1 = ((flag) ? 1 : 0);
        } else
        if (k1 < 196)
        {
            print("186;new;newarray;anewarray;arraylength;athrow;checkcast;instanceof;monitorenter;monitorexit;", k1 - 186, classtypewriter);
            if (k1 == 187 || k1 == 189 || k1 == 192 || k1 == 193)
            {
                i1 = 2;
            } else
            {
                if (k1 != 188)
                {
                    break MISSING_BLOCK_LABEL_2008;
                }
                abyte1 = code;
                i1 = i + 1;
                i = abyte1[i];
                classtypewriter.print(' ');
                if (i >= 4 && i <= 11)
                {
                    print("boolean;char;float;double;byte;short;int;long;", i - 4, classtypewriter);
                    i = i1;
                    i1 = ((flag) ? 1 : 0);
                } else
                {
                    classtypewriter.print(i);
                    i = i1;
                    i1 = ((flag) ? 1 : 0);
                }
            }
        } else
        if (k1 == 196)
        {
            classtypewriter.print("wide");
            k = 1;
            i1 = ((flag) ? 1 : 0);
        } else
        if (k1 == 197)
        {
            classtypewriter.print("multianewarray");
            i1 = readUnsignedShort(i);
            j1 = i + 2;
            classtypewriter.printConstantOperand(i1);
            abyte1 = code;
            i = j1 + 1;
            i1 = abyte1[j1];
            classtypewriter.print(' ');
            classtypewriter.print(i1 & 0xff);
            i1 = ((flag) ? 1 : 0);
        } else
        if (k1 < 200)
        {
            print("ifnull;ifnonnull;", k1 - 198, classtypewriter);
            i1 = (short)readUnsignedShort(i);
            classtypewriter.print(' ');
            classtypewriter.print(j1 + i1);
            i += 2;
            i1 = ((flag) ? 1 : 0);
        } else
        {
label0:
            {
                if (k1 >= 202)
                {
                    break label0;
                }
                print("goto_w;jsr_w;", k1 - 200, classtypewriter);
                i1 = readInt(i);
                classtypewriter.print(' ');
                classtypewriter.print(j1 + i1);
                i += 4;
                i1 = ((flag) ? 1 : 0);
            }
        }
          goto _L4
        classtypewriter.print(k1);
        i1 = ((flag) ? 1 : 0);
          goto _L4
    }

    public final void emitAdd()
    {
        emitBinop(96);
    }

    public final void emitAdd(char c)
    {
        emitBinop(96, c);
    }

    public final void emitAdd(PrimType primtype)
    {
        emitBinop(96, primtype);
    }

    public final void emitAnd()
    {
        emitBinop(126);
    }

    public final void emitArrayLength()
    {
        if (!(popType() instanceof ArrayType))
        {
            throw new Error("non-array type in emitArrayLength");
        } else
        {
            reserve(1);
            put1(190);
            pushType(Type.intType);
            return;
        }
    }

    public void emitArrayLoad()
    {
        popType();
        Type type = ((ArrayType)popType().getImplementationType()).getComponentType();
        emitTypedOp(46, type);
        pushType(type);
    }

    public void emitArrayLoad(Type type)
    {
        popType();
        popType();
        emitTypedOp(46, type);
        pushType(type);
    }

    public void emitArrayStore()
    {
        popType();
        popType();
        emitTypedOp(79, ((ArrayType)popType().getImplementationType()).getComponentType());
    }

    public void emitArrayStore(Type type)
    {
        popType();
        popType();
        popType();
        emitTypedOp(79, type);
    }

    public void emitBinop(int i, Type type)
    {
        popType();
        popType();
        emitTypedOp(i, type);
        pushType(type);
    }

    public void emitCatchEnd()
    {
        gotoFinallyOrEnd(false);
        try_stack.try_type = null;
    }

    public void emitCatchStart(Variable variable)
    {
        emitTryEnd(false);
        setTypes(try_stack.start_try.localTypes, Type.typeArray0);
        if (try_stack.try_type != null)
        {
            emitCatchEnd();
        }
        ClassType classtype;
        if (variable == null)
        {
            classtype = null;
        } else
        {
            classtype = (ClassType)variable.getType();
        }
        try_stack.try_type = classtype;
        addHandler(try_stack.start_try, try_stack.end_try, classtype);
        if (variable != null)
        {
            emitStore(variable);
        }
    }

    public void emitCheckcast(Type type)
    {
        if (castNeeded(topType(), type))
        {
            emitCheckcast(type, 192);
            pushType(type);
        }
    }

    public final void emitConvert(Type type, Type type1)
    {
        String s;
        String s1;
        byte byte0;
        s = type1.getSignature();
        s1 = type.getSignature();
        byte0 = -1;
        if (s.length() == 1) goto _L2; else goto _L1
_L1:
        char c = byte0;
        if (s1.length() != 1) goto _L3; else goto _L2
_L2:
        char c2;
        c2 = s.charAt(0);
        c = s1.charAt(0);
        if (c != c2) goto _L5; else goto _L4
_L4:
        return;
_L5:
        char c1;
        if (type.size < 4)
        {
            c = 'I';
        }
        c1 = c;
        if (type1.size < 4)
        {
            emitConvert(type, ((Type) (Type.intType)));
            c1 = 'I';
        }
        if (c1 == c2) goto _L4; else goto _L6
_L6:
        c = byte0;
        c1;
        JVM INSTR tableswitch 68 74: default 148
    //                   68 423
    //                   69 152
    //                   70 355
    //                   71 152
    //                   72 152
    //                   73 168
    //                   74 283;
           goto _L7 _L8 _L9 _L10 _L9 _L9 _L11 _L12
_L9:
        break; /* Loop/switch isn't completed */
_L7:
        c = byte0;
_L3:
        if (c < 0)
        {
            throw new Error("unsupported CodeAttr.emitConvert");
        } else
        {
            reserve(1);
            popType();
            put1(c);
            pushType(type1);
            return;
        }
_L11:
        switch (c2)
        {
        default:
            c = byte0;
            break;

        case 66: // 'B'
            c = '\221';
            break;

        case 67: // 'C'
            c = '\222';
            break;

        case 83: // 'S'
            c = '\223';
            break;

        case 74: // 'J'
            c = '\205';
            break;

        case 70: // 'F'
            c = '\206';
            break;

        case 68: // 'D'
            c = '\207';
            break;
        }
        if (true) goto _L3; else goto _L13
_L13:
_L12:
        switch (c2)
        {
        case 69: // 'E'
        case 71: // 'G'
        case 72: // 'H'
        default:
            c = byte0;
            break;

        case 68: // 'D'
            c = '\212';
            break;

        case 73: // 'I'
            c = '\210';
            break;

        case 70: // 'F'
            c = '\211';
            break;
        }
        if (true) goto _L3; else goto _L14
_L14:
_L10:
        switch (c2)
        {
        default:
            c = byte0;
            break;

        case 68: // 'D'
            c = '\215';
            break;

        case 73: // 'I'
            c = '\213';
            break;

        case 74: // 'J'
            c = '\214';
            break;
        }
        if (true) goto _L3; else goto _L15
_L15:
_L8:
        switch (c2)
        {
        case 71: // 'G'
        case 72: // 'H'
        default:
            c = byte0;
            break;

        case 70: // 'F'
            c = '\220';
            break;

        case 73: // 'I'
            c = '\216';
            break;

        case 74: // 'J'
            c = '\217';
            break;
        }
        if (true) goto _L3; else goto _L16
_L16:
    }

    public final void emitDiv()
    {
        emitBinop(108);
    }

    public void emitDup()
    {
        reserve(1);
        Type type = topType();
        byte byte0;
        if (type.size <= 4)
        {
            byte0 = 89;
        } else
        {
            byte0 = 92;
        }
        put1(byte0);
        pushType(type);
    }

    public void emitDup(int i)
    {
        emitDup(i, 0);
    }

    public void emitDup(int i, int j)
    {
        Type type1;
        Type type2;
        Type type3;
        Type type7;
        if (i == 0)
        {
            return;
        }
        reserve(1);
        type7 = popType();
        type2 = null;
        if (i == 1)
        {
            if (type7.size > 4)
            {
                throw new Error("using dup for 2-word type");
            }
        } else
        {
            if (i != 2)
            {
                throw new Error("invalid size to emitDup");
            }
            if (type7.size <= 4)
            {
                Type type = popType();
                type2 = type;
                if (type.size > 4)
                {
                    throw new Error("dup will cause invalid types on stack");
                }
            }
        }
        type1 = null;
        type3 = null;
        if (j != 0) goto _L2; else goto _L1
_L1:
        if (i == 1)
        {
            i = 89;
        } else
        {
            i = 92;
        }
_L4:
        put1(i);
        if (type2 != null)
        {
            pushType(type2);
        }
        pushType(type7);
        if (type3 != null)
        {
            pushType(type3);
        }
        if (type1 != null)
        {
            pushType(type1);
        }
        if (type2 != null)
        {
            pushType(type2);
        }
        pushType(type7);
        return;
_L2:
        if (j != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        Type type4;
        if (i == 1)
        {
            i = 90;
        } else
        {
            i = 93;
        }
        type4 = popType();
        type1 = type4;
        if (type4.size > 4)
        {
            throw new Error("dup will cause invalid types on stack");
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (j == 2)
        {
            Type type5;
            if (i == 1)
            {
                j = 91;
            } else
            {
                j = 94;
            }
            type5 = popType();
            i = j;
            type1 = type5;
            if (type5.size <= 4)
            {
                Type type6 = popType();
                i = j;
                type1 = type5;
                type3 = type6;
                if (type6.size > 4)
                {
                    throw new Error("dup will cause invalid types on stack");
                }
            }
        } else
        {
            throw new Error("emitDup:  invalid offset");
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public void emitDup(Type type)
    {
        byte byte0;
        if (type.size > 4)
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        emitDup(byte0, 0);
    }

    public void emitDupX()
    {
        reserve(1);
        Type type = popType();
        Type type1 = popType();
        if (type1.size <= 4)
        {
            byte byte0;
            if (type.size <= 4)
            {
                byte0 = 90;
            } else
            {
                byte0 = 93;
            }
            put1(byte0);
        } else
        {
            byte byte1;
            if (type.size <= 4)
            {
                byte1 = 91;
            } else
            {
                byte1 = 94;
            }
            put1(byte1);
        }
        pushType(type);
        pushType(type1);
        pushType(type);
    }

    public final void emitElse()
    {
        Label label = if_stack.end_label;
        if (reachableHere())
        {
            Label label1 = new Label(this);
            if_stack.end_label = label1;
            int i = SP - if_stack.start_stack_size;
            if_stack.stack_growth = i;
            if (i > 0)
            {
                if_stack.then_stacked_types = new Type[i];
                System.arraycopy(stack_types, if_stack.start_stack_size, if_stack.then_stacked_types, 0, i);
            } else
            {
                if_stack.then_stacked_types = new Type[0];
            }
            emitGoto(label1);
        } else
        {
            if_stack.end_label = null;
        }
        while (SP > if_stack.start_stack_size) 
        {
            popType();
        }
        SP = if_stack.start_stack_size;
        if (label != null)
        {
            label.define(this);
        }
        if_stack.doing_else = true;
    }

    public final void emitFi()
    {
        boolean flag1 = false;
        if (if_stack.doing_else) goto _L2; else goto _L1
_L1:
        boolean flag;
        flag = flag1;
        if (reachableHere())
        {
            flag = flag1;
            if (SP != if_stack.start_stack_size)
            {
                throw new Error((new StringBuilder()).append("at PC ").append(PC).append(" then clause grows stack with no else clause").toString());
            }
        }
          goto _L3
_L2:
        if (if_stack.then_stacked_types == null) goto _L5; else goto _L4
_L4:
        int i = if_stack.start_stack_size + if_stack.stack_growth;
        if (reachableHere()) goto _L7; else goto _L6
_L6:
        if (if_stack.stack_growth > 0)
        {
            System.arraycopy(if_stack.then_stacked_types, 0, stack_types, if_stack.start_stack_size, if_stack.stack_growth);
        }
        SP = i;
        flag = flag1;
_L3:
        if (if_stack.end_label != null)
        {
            if_stack.end_label.define(this);
        }
        if (flag)
        {
            setUnreachable();
        }
        if_stack = if_stack.previous;
        return;
_L7:
        flag = flag1;
        if (SP != i)
        {
            throw new Error((new StringBuilder()).append("at PC ").append(PC).append(": SP at end of 'then' was ").append(i).append(" while SP at end of 'else' was ").append(SP).toString());
        }
        continue; /* Loop/switch isn't completed */
_L5:
        flag = flag1;
        if (unreachable_here)
        {
            flag = true;
        }
        if (true) goto _L3; else goto _L8
_L8:
    }

    public void emitFinallyEnd()
    {
        if (useJsr())
        {
            emitRet(try_stack.finally_ret_addr);
        } else
        if (try_stack.end_label == null && try_stack.exitCases == null)
        {
            emitThrow();
        } else
        {
            emitStore(try_stack.exception);
            emitLoad(try_stack.exception);
            emitIfNotNull();
            emitLoad(try_stack.exception);
            emitThrow();
            emitElse();
            ExitableBlock exitableblock = try_stack.exitCases;
            if (exitableblock != null)
            {
                SwitchState switchstate = startSwitch();
                while (exitableblock != null) 
                {
                    ExitableBlock exitableblock1 = exitableblock.nextCase;
                    exitableblock.nextCase = null;
                    exitableblock.currentTryState = null;
                    TryState trystate = TryState.outerHandler(try_stack.previous, exitableblock.initialTryState);
                    if (trystate == exitableblock.initialTryState)
                    {
                        switchstate.addCaseGoto(exitableblock.switchCase, this, exitableblock.endLabel);
                    } else
                    {
                        switchstate.addCase(exitableblock.switchCase, this);
                        exitableblock.exit(trystate);
                    }
                    exitableblock = exitableblock1;
                }
                try_stack.exitCases = null;
                switchstate.addDefault(this);
                switchstate.finish(this);
            }
            emitFi();
            setUnreachable();
        }
        popScope();
        try_stack.finally_subr = null;
    }

    public void emitFinallyStart()
    {
        emitTryEnd(true);
        if (try_stack.try_type != null)
        {
            emitCatchEnd();
        }
        try_stack.end_try = getLabel();
        pushScope();
        if (useJsr())
        {
            SP = 0;
            emitCatchStart(null);
            emitStore(try_stack.exception);
            emitJsr(try_stack.finally_subr);
            emitLoad(try_stack.exception);
            emitThrow();
        } else
        {
            setUnreachable();
            int i = beginFragment(new Label(this));
            addHandler(try_stack.start_try, try_stack.end_try, Type.javalangThrowableType);
            if (try_stack.saved_result != null)
            {
                emitStoreDefaultValue(try_stack.saved_result);
            }
            if (try_stack.exitCases != null)
            {
                emitPushInt(-1);
                emitSwap();
            }
            emitGoto(try_stack.finally_subr);
            endFragment(i);
        }
        try_stack.finally_subr.define(this);
        if (useJsr())
        {
            ClassType classtype = Type.objectType;
            try_stack.finally_ret_addr = addLocal(classtype);
            pushType(classtype);
            emitStore(try_stack.finally_ret_addr);
        }
    }

    public final void emitGetField(Field field)
    {
        popType();
        pushType(field.type);
        emitFieldop(field, 180);
    }

    public final void emitGetStatic(Field field)
    {
        pushType(field.type);
        emitFieldop(field, 178);
    }

    public final void emitGoto(Label label)
    {
        label.setTypes(this);
        fixupAdd(4, label);
        reserve(3);
        put1(167);
        PC = PC + 2;
        setUnreachable();
    }

    public final void emitGotoIfCompare1(Label label, int i)
    {
        popType();
        reserve(3);
        emitTransfer(label, i);
    }

    public final void emitGotoIfCompare2(Label label, int i)
    {
        char c = '\0';
        if (i < 153 || i > 158)
        {
            throw new Error("emitGotoIfCompare2: logop must be one of ifeq...ifle");
        }
        Type type = popType().promote();
        Type type1 = popType().promote();
        reserve(4);
        char c1 = type1.getSignature().charAt(0);
        char c2 = type.getSignature().charAt(0);
        if (i == 155 || i == 158)
        {
            c = '\001';
        }
        if (c1 == 'I' && c2 == 'I')
        {
            i += 6;
        } else
        if (c1 == 'J' && c2 == 'J')
        {
            put1(148);
        } else
        if (c1 == 'F' && c2 == 'F')
        {
            if (c != 0)
            {
                c = '\225';
            } else
            {
                c = '\226';
            }
            put1(c);
        } else
        if (c1 == 'D' && c2 == 'D')
        {
            if (c != 0)
            {
                c = '\227';
            } else
            {
                c = '\230';
            }
            put1(c);
        } else
        if ((c1 == 'L' || c1 == '[') && (c2 == 'L' || c2 == '[') && i <= 154)
        {
            i += 12;
        } else
        {
            throw new Error("invalid types to emitGotoIfCompare2");
        }
        emitTransfer(label, i);
    }

    public final void emitGotoIfEq(Label label)
    {
        emitGotoIfCompare2(label, 153);
    }

    public final void emitGotoIfEq(Label label, boolean flag)
    {
        char c;
        if (flag)
        {
            c = '\232';
        } else
        {
            c = '\231';
        }
        emitGotoIfCompare2(label, c);
    }

    public final void emitGotoIfGe(Label label)
    {
        emitGotoIfCompare2(label, 156);
    }

    public final void emitGotoIfGt(Label label)
    {
        emitGotoIfCompare2(label, 157);
    }

    public final void emitGotoIfIntEqZero(Label label)
    {
        emitGotoIfCompare1(label, 153);
    }

    public final void emitGotoIfIntGeZero(Label label)
    {
        emitGotoIfCompare1(label, 156);
    }

    public final void emitGotoIfIntGtZero(Label label)
    {
        emitGotoIfCompare1(label, 157);
    }

    public final void emitGotoIfIntLeZero(Label label)
    {
        emitGotoIfCompare1(label, 158);
    }

    public final void emitGotoIfIntLtZero(Label label)
    {
        emitGotoIfCompare1(label, 155);
    }

    public final void emitGotoIfIntNeZero(Label label)
    {
        emitGotoIfCompare1(label, 154);
    }

    public final void emitGotoIfLe(Label label)
    {
        emitGotoIfCompare2(label, 158);
    }

    public final void emitGotoIfLt(Label label)
    {
        emitGotoIfCompare2(label, 155);
    }

    public final void emitGotoIfNE(Label label)
    {
        emitGotoIfCompare2(label, 154);
    }

    public final void emitIOr()
    {
        emitBinop(128);
    }

    public final void emitIfCompare1(int i)
    {
        IfState ifstate = new IfState(this);
        if (popType().promote() != Type.intType)
        {
            throw new Error("non-int type to emitIfCompare1");
        } else
        {
            reserve(3);
            emitTransfer(ifstate.end_label, i);
            ifstate.start_stack_size = SP;
            return;
        }
    }

    public final void emitIfEq()
    {
        IfState ifstate = new IfState(this);
        emitGotoIfNE(ifstate.end_label);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfGe()
    {
        IfState ifstate = new IfState(this);
        emitGotoIfLt(ifstate.end_label);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfGt()
    {
        IfState ifstate = new IfState(this);
        emitGotoIfLe(ifstate.end_label);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfIntCompare(int i)
    {
        IfState ifstate = new IfState(this);
        popType();
        popType();
        reserve(3);
        emitTransfer(ifstate.end_label, i);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfIntEqZero()
    {
        emitIfCompare1(154);
    }

    public final void emitIfIntLEqZero()
    {
        emitIfCompare1(157);
    }

    public final void emitIfIntLt()
    {
        emitIfIntCompare(162);
    }

    public final void emitIfIntNotZero()
    {
        emitIfCompare1(153);
    }

    public final void emitIfLe()
    {
        IfState ifstate = new IfState(this);
        emitGotoIfGt(ifstate.end_label);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfLt()
    {
        IfState ifstate = new IfState(this);
        emitGotoIfGe(ifstate.end_label);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfNEq()
    {
        IfState ifstate = new IfState(this);
        emitGotoIfEq(ifstate.end_label);
        ifstate.start_stack_size = SP;
    }

    public final void emitIfNotNull()
    {
        emitIfRefCompare1(198);
    }

    public final void emitIfNull()
    {
        emitIfRefCompare1(199);
    }

    public final void emitIfRefCompare1(int i)
    {
        IfState ifstate = new IfState(this);
        if (!(popType() instanceof ObjectType))
        {
            throw new Error("non-ref type to emitIfRefCompare1");
        } else
        {
            reserve(3);
            emitTransfer(ifstate.end_label, i);
            ifstate.start_stack_size = SP;
            return;
        }
    }

    public final void emitIfThen()
    {
        new IfState(this, null);
    }

    public void emitInc(Variable variable, short word0)
    {
        if (variable.dead())
        {
            throw new Error("attempting to increment dead variable");
        }
        int i = variable.offset;
        if (i < 0 || !variable.isSimple())
        {
            throw new Error((new StringBuilder()).append("attempting to increment unassigned variable").append(variable.getName()).append(" simple:").append(variable.isSimple()).append(", offset: ").append(i).toString());
        }
        reserve(6);
        if (variable.getType().getImplementationType().promote() != Type.intType)
        {
            throw new Error("attempting to increment non-int variable");
        }
        boolean flag;
        if (i > 255 || word0 > 255 || word0 < -256)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            put1(196);
            put1(132);
            put2(i);
            put2(word0);
            return;
        } else
        {
            put1(132);
            put1(i);
            put1(word0);
            return;
        }
    }

    public void emitInstanceof(Type type)
    {
        emitCheckcast(type, 193);
        pushType(Type.booleanType);
    }

    public void emitInvoke(Method method)
    {
        char c;
        if ((method.access_flags & 8) != 0)
        {
            c = '\270';
        } else
        if (method.classfile.isInterface())
        {
            c = '\271';
        } else
        if ("<init>".equals(method.getName()))
        {
            c = '\267';
        } else
        {
            c = '\266';
        }
        emitInvokeMethod(method, c);
    }

    public void emitInvokeInterface(Method method)
    {
        emitInvokeMethod(method, 185);
    }

    public void emitInvokeMethod(Method method, int i)
    {
        boolean flag2 = true;
        int j;
        boolean flag;
        boolean flag1;
        int j1;
        if (i == 185)
        {
            j = 5;
        } else
        {
            j = 3;
        }
        reserve(j);
        j1 = method.arg_types.length;
        if (i == 184)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (i == 183 && "<init>".equals(method.getName()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((method.access_flags & 8) != 0)
        {
            j = ((flag2) ? 1 : 0);
        } else
        {
            j = 0;
        }
        if (flag1 != j)
        {
            throw new Error((new StringBuilder()).append("emitInvokeXxx static flag mis-match method.flags=").append(method.access_flags).toString());
        }
        j = j1;
        if (!flag1)
        {
            j = j1;
            if (!flag)
            {
                j = j1 + 1;
            }
        }
        put1(i);
        putIndex2(getConstants().addMethodRef(method));
        int i1 = j;
        if (i == 185)
        {
            put1(words(method.arg_types) + 1);
            put1(0);
            i1 = j;
        }
        do
        {
            i1--;
            if (i1 >= 0)
            {
                Type type = popType();
                if (type instanceof UninitializedType)
                {
                    throw new Error((new StringBuilder()).append("passing ").append(type).append(" as parameter").toString());
                }
            } else
            {
                if (flag)
                {
                    Type type1 = popType();
                    if (!(type1 instanceof UninitializedType))
                    {
                        throw new Error("calling <init> on already-initialized object");
                    }
                    ClassType classtype = ((UninitializedType)type1).ctype;
                    for (i = 0; i < SP; i++)
                    {
                        if (stack_types[i] == type1)
                        {
                            stack_types[i] = classtype;
                        }
                    }

                    Variable avariable[] = locals.used;
                    if (avariable == null)
                    {
                        i = 0;
                    } else
                    {
                        i = avariable.length;
                    }
                    do
                    {
                        int k = i - 1;
                        if (k < 0)
                        {
                            break;
                        }
                        Variable variable = avariable[k];
                        i = k;
                        if (variable != null)
                        {
                            i = k;
                            if (variable.type == type1)
                            {
                                variable.type = classtype;
                                i = k;
                            }
                        }
                    } while (true);
                    if (local_types == null)
                    {
                        i = 0;
                    } else
                    {
                        i = local_types.length;
                    }
                    do
                    {
                        int l = i - 1;
                        if (l < 0)
                        {
                            break;
                        }
                        i = l;
                        if (local_types[l] == type1)
                        {
                            local_types[l] = classtype;
                            i = l;
                        }
                    } while (true);
                }
                if (method.return_type.size != 0)
                {
                    pushType(method.return_type);
                }
                return;
            }
        } while (true);
    }

    public void emitInvokeSpecial(Method method)
    {
        emitInvokeMethod(method, 183);
    }

    public void emitInvokeStatic(Method method)
    {
        emitInvokeMethod(method, 184);
    }

    public void emitInvokeVirtual(Method method)
    {
        emitInvokeMethod(method, 182);
    }

    public final void emitJsr(Label label)
    {
        fixupAdd(5, label);
        reserve(3);
        put1(168);
        PC = PC + 2;
    }

    public final void emitLoad(Variable variable)
    {
        if (variable.dead())
        {
            throw new Error("attempting to push dead variable");
        }
        int i = variable.offset;
        if (i < 0 || !variable.isSimple())
        {
            throw new Error((new StringBuilder()).append("attempting to load from unassigned variable ").append(variable).append(" simple:").append(variable.isSimple()).append(", offset: ").append(i).toString());
        }
        Type type = variable.getType().promote();
        reserve(4);
        int j = adjustTypedOp(type);
        if (i <= 3)
        {
            put1(j * 4 + 26 + i);
        } else
        {
            emitMaybeWide(j + 21, i);
        }
        pushType(variable.getType());
    }

    void emitMaybeWide(int i, int j)
    {
        if (j >= 256)
        {
            put1(196);
            put1(i);
            put2(j);
            return;
        } else
        {
            put1(i);
            put1(j);
            return;
        }
    }

    public final void emitMonitorEnter()
    {
        popType();
        reserve(1);
        put1(194);
    }

    public final void emitMonitorExit()
    {
        popType();
        reserve(1);
        put1(195);
    }

    public final void emitMul()
    {
        emitBinop(104);
    }

    public void emitNew(ClassType classtype)
    {
        reserve(3);
        Label label = new Label(this);
        label.defineRaw(this);
        put1(187);
        putIndex2(getConstants().addClass(classtype));
        pushType(new UninitializedType(classtype, label));
    }

    void emitNewArray(int i)
    {
        reserve(2);
        put1(188);
        put1(i);
    }

    public void emitNewArray(Type type)
    {
        emitNewArray(type, 1);
    }

    public void emitNewArray(Type type, int i)
    {
        if (popType().promote() != Type.intType)
        {
            throw new Error("non-int dim. spec. in emitNewArray");
        }
        if (!(type instanceof PrimType)) goto _L2; else goto _L1
_L1:
        type.getSignature().charAt(0);
        JVM INSTR lookupswitch 8: default 112
    //                   66: 123
    //                   67: 179
    //                   68: 168
    //                   70: 162
    //                   73: 150
    //                   74: 156
    //                   83: 144
    //                   90: 174;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        throw new Error("bad PrimType in emitNewArray");
_L4:
        i = 8;
_L18:
        emitNewArray(i);
_L13:
        pushType(new ArrayType(type));
        return;
_L10:
        i = 9;
        continue; /* Loop/switch isn't completed */
_L8:
        i = 10;
        continue; /* Loop/switch isn't completed */
_L9:
        i = 11;
        continue; /* Loop/switch isn't completed */
_L7:
        i = 6;
        continue; /* Loop/switch isn't completed */
_L6:
        i = 7;
        continue; /* Loop/switch isn't completed */
_L11:
        i = 4;
        continue; /* Loop/switch isn't completed */
_L5:
        i = 5;
        continue; /* Loop/switch isn't completed */
_L2:
        if (!(type instanceof ObjectType))
        {
            break; /* Loop/switch isn't completed */
        }
        reserve(3);
        put1(189);
        putIndex2(getConstants().addClass((ObjectType)type));
        if (true) goto _L13; else goto _L12
_L12:
        if (!(type instanceof ArrayType))
        {
            break MISSING_BLOCK_LABEL_319;
        }
        reserve(4);
        put1(197);
        putIndex2(getConstants().addClass(new ArrayType(type)));
        if (i < 1 || i > 255)
        {
            throw new Error("dims out of range in emitNewArray");
        }
        put1(i);
_L16:
        i--;
        if (i <= 0) goto _L13; else goto _L14
_L14:
        if (popType().promote() == Type.intType) goto _L16; else goto _L15
_L15:
        throw new Error("non-int dim. spec. in emitNewArray");
        throw new Error("unimplemented type in emitNewArray");
        if (true) goto _L18; else goto _L17
_L17:
    }

    public final void emitNot(Type type)
    {
        emitPushConstant(1, type);
        emitAdd();
        emitPushConstant(1, type);
        emitAnd();
    }

    public void emitPop(int i)
    {
        while (i > 0) 
        {
            reserve(1);
            if (popType().size > 4)
            {
                put1(88);
            } else
            if (i > 1)
            {
                if (popType().size > 4)
                {
                    put1(87);
                    reserve(1);
                }
                put1(88);
                i--;
            } else
            {
                put1(87);
            }
            i--;
        }
    }

    public void emitPrimop(int i, int j, Type type)
    {
        reserve(1);
        do
        {
            j--;
            if (j >= 0)
            {
                popType();
            } else
            {
                put1(i);
                pushType(type);
                return;
            }
        } while (true);
    }

    public final void emitPushClass(ObjectType objecttype)
    {
        emitPushConstant(getConstants().addClass(objecttype));
        pushType(Type.javalangClassType);
    }

    public final void emitPushConstant(int i, Type type)
    {
        switch (type.getSignature().charAt(0))
        {
        default:
            throw new Error("bad type to emitPushConstant");

        case 66: // 'B'
        case 67: // 'C'
        case 73: // 'I'
        case 83: // 'S'
        case 90: // 'Z'
            emitPushInt(i);
            return;

        case 74: // 'J'
            emitPushLong(i);
            return;

        case 70: // 'F'
            emitPushFloat(i);
            return;

        case 68: // 'D'
            emitPushDouble(i);
            return;
        }
    }

    public final void emitPushConstant(CpoolEntry cpoolentry)
    {
        reserve(3);
        int i = cpoolentry.index;
        if (cpoolentry instanceof CpoolValue2)
        {
            put1(20);
            put2(i);
            return;
        }
        if (i < 256)
        {
            put1(18);
            put1(i);
            return;
        } else
        {
            put1(19);
            put2(i);
            return;
        }
    }

    public void emitPushDefaultValue(Type type)
    {
        type = type.getImplementationType();
        if (type instanceof PrimType)
        {
            emitPushConstant(0, type);
            return;
        } else
        {
            emitPushNull();
            return;
        }
    }

    public void emitPushDouble(double d)
    {
        int i = (int)d;
        if ((double)i == d && i >= -128 && i < 128)
        {
            if (i == 0 || i == 1)
            {
                reserve(1);
                put1(i + 14);
                if (i == 0 && Double.doubleToLongBits(d) != 0L)
                {
                    reserve(1);
                    put1(119);
                }
            } else
            {
                emitPushInt(i);
                reserve(1);
                popType();
                put1(135);
            }
        } else
        {
            emitPushConstant(getConstants().addDouble(d));
        }
        pushType(Type.doubleType);
    }

    public void emitPushFloat(float f)
    {
        int i = (int)f;
        if ((float)i == f && i >= -128 && i < 128)
        {
            if (i >= 0 && i <= 2)
            {
                reserve(1);
                put1(i + 11);
                if (i == 0 && Float.floatToIntBits(f) != 0)
                {
                    reserve(1);
                    put1(118);
                }
            } else
            {
                emitPushInt(i);
                reserve(1);
                popType();
                put1(134);
            }
        } else
        {
            emitPushConstant(getConstants().addFloat(f));
        }
        pushType(Type.floatType);
    }

    public final void emitPushInt(int i)
    {
        reserve(3);
        if (i >= -1 && i <= 5)
        {
            put1(i + 3);
        } else
        if (i >= -128 && i < 128)
        {
            put1(16);
            put1(i);
        } else
        if (i >= -32768 && i < 32768)
        {
            put1(17);
            put2(i);
        } else
        {
            emitPushConstant(getConstants().addInt(i));
        }
        pushType(Type.intType);
    }

    public void emitPushLong(long l)
    {
        if (l == 0L || l == 1L)
        {
            reserve(1);
            put1((int)l + 9);
        } else
        if ((long)(int)l == l)
        {
            emitPushInt((int)l);
            reserve(1);
            popType();
            put1(133);
        } else
        {
            emitPushConstant(getConstants().addLong(l));
        }
        pushType(Type.longType);
    }

    public void emitPushNull()
    {
        reserve(1);
        put1(1);
        pushType(Type.nullType);
    }

    public final void emitPushPrimArray(Object obj, ArrayType arraytype)
    {
        Type type;
        int i;
        int j;
        char c;
        type = arraytype.getComponentType();
        j = Array.getLength(obj);
        emitPushInt(j);
        emitNewArray(type);
        c = type.getSignature().charAt(0);
        i = 0;
_L26:
        if (i >= j) goto _L2; else goto _L1
_L1:
        double d;
        float f;
        long l;
        l = 0L;
        f = 0.0F;
        d = 0.0D;
        c;
        JVM INSTR lookupswitch 8: default 128
    //                   66: 338
    //                   67: 311
    //                   68: 428
    //                   70: 401
    //                   73: 257
    //                   74: 231
    //                   83: 284
    //                   90: 365;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L3:
        emitDup(arraytype);
        emitPushInt(i);
        c;
        JVM INSTR lookupswitch 8: default 216
    //                   66: 453
    //                   67: 453
    //                   68: 481
    //                   70: 472
    //                   73: 453
    //                   74: 463
    //                   83: 453
    //                   90: 453;
           goto _L12 _L13 _L13 _L14 _L15 _L13 _L16 _L13 _L13
_L12:
        emitArrayStore(type);
_L17:
        i++;
        continue; /* Loop/switch isn't completed */
_L9:
        long l1;
        l1 = ((long[])(long[])obj)[i];
        l = l1;
        if (l1 != 0L) goto _L18; else goto _L17
_L18:
        break; /* Loop/switch isn't completed */
_L8:
        l1 = ((int[])(int[])obj)[i];
        l = l1;
        if (l1 != 0L) goto _L19; else goto _L17
_L19:
        break; /* Loop/switch isn't completed */
_L10:
        l1 = ((short[])(short[])obj)[i];
        l = l1;
        if (l1 != 0L) goto _L20; else goto _L17
_L20:
        break; /* Loop/switch isn't completed */
_L5:
        l1 = ((char[])(char[])obj)[i];
        l = l1;
        if (l1 != 0L) goto _L21; else goto _L17
_L21:
        break; /* Loop/switch isn't completed */
_L4:
        l1 = ((byte[])(byte[])obj)[i];
        l = l1;
        if (l1 != 0L) goto _L22; else goto _L17
_L22:
        break; /* Loop/switch isn't completed */
_L11:
        long l2;
        if (((boolean[])(boolean[])obj)[i])
        {
            l2 = 1L;
        } else
        {
            l2 = 0L;
        }
        l = l2;
        if (l2 != 0L) goto _L23; else goto _L17
_L23:
        break; /* Loop/switch isn't completed */
_L7:
        float f1;
        f1 = ((float[])(float[])obj)[i];
        f = f1;
        if ((double)f1 != 0.0D) goto _L24; else goto _L17
_L24:
        break; /* Loop/switch isn't completed */
_L6:
        double d1;
        d1 = ((double[])(double[])obj)[i];
        d = d1;
        if (d1 != 0.0D) goto _L3; else goto _L17
_L13:
        emitPushInt((int)l);
          goto _L12
_L16:
        emitPushLong(l);
          goto _L12
_L15:
        emitPushFloat(f);
          goto _L12
_L14:
        emitPushDouble(d);
          goto _L12
_L2:
        return;
        if (true) goto _L26; else goto _L25
_L25:
    }

    public final void emitPushString(String s)
    {
        if (s == null)
        {
            emitPushNull();
        } else
        {
            int i = s.length();
            String s1 = calculateSplit(s);
            int i1 = s1.length();
            if (i1 <= 1)
            {
                emitPushConstant(getConstants().addString(s));
                pushType(Type.javalangStringType);
                return;
            }
            if (i1 == 2)
            {
                i = s1.charAt(0);
                emitPushString(s.substring(0, i));
                emitPushString(s.substring(i));
                emitInvokeVirtual(Type.javalangStringType.getDeclaredMethod("concat", 1));
            } else
            {
                ClassType classtype = ClassType.make("java.lang.StringBuffer");
                emitNew(classtype);
                emitDup(classtype);
                emitPushInt(i);
                emitInvokeSpecial(classtype.getDeclaredMethod("<init>", new Type[] {
                    Type.intType
                }));
                Method method = classtype.getDeclaredMethod("append", new Type[] {
                    Type.javalangStringType
                });
                int k = 0;
                for (int j = 0; j < i1; j++)
                {
                    emitDup(classtype);
                    int l = k + s1.charAt(j);
                    emitPushString(s.substring(k, l));
                    emitInvokeVirtual(method);
                    k = l;
                }

                emitInvokeVirtual(Type.toString_method);
            }
            if (s == s.intern())
            {
                emitInvokeVirtual(Type.javalangStringType.getDeclaredMethod("intern", 0));
                return;
            }
        }
    }

    public final void emitPushThis()
    {
        emitLoad(locals.used[0]);
    }

    public final void emitPutField(Field field)
    {
        popType();
        popType();
        emitFieldop(field, 181);
    }

    public final void emitPutStatic(Field field)
    {
        popType();
        emitFieldop(field, 179);
    }

    final void emitRawReturn()
    {
        if (getMethod().getReturnType().size == 0)
        {
            reserve(1);
            put1(177);
        } else
        {
            emitTypedOp(172, popType().promote());
        }
        setUnreachable();
    }

    public final void emitRem()
    {
        emitBinop(112);
    }

    public void emitRet(Variable variable)
    {
        int i = variable.offset;
        if (i < 256)
        {
            reserve(2);
            put1(169);
            put1(i);
            return;
        } else
        {
            reserve(4);
            put1(196);
            put1(169);
            put2(i);
            return;
        }
    }

    public final void emitReturn()
    {
        if (try_stack != null)
        {
            new Error();
        }
        emitRawReturn();
    }

    public final void emitShl()
    {
        emitShift(120);
    }

    public final void emitShr()
    {
        emitShift(122);
    }

    public void emitStore(Variable variable)
    {
        int i = variable.offset;
        if (i < 0 || !variable.isSimple())
        {
            throw new Error((new StringBuilder()).append("attempting to store in unassigned ").append(variable).append(" simple:").append(variable.isSimple()).append(", offset: ").append(i).toString());
        }
        variable = variable.getType().promote();
        noteVarType(i, variable);
        reserve(4);
        popType();
        int j = adjustTypedOp(variable);
        if (i <= 3)
        {
            put1(j * 4 + 59 + i);
            return;
        } else
        {
            emitMaybeWide(j + 54, i);
            return;
        }
    }

    public void emitStoreDefaultValue(Variable variable)
    {
        emitPushDefaultValue(variable.getType());
        emitStore(variable);
    }

    public final void emitSub()
    {
        emitBinop(100);
    }

    public final void emitSub(char c)
    {
        emitBinop(100, c);
    }

    public final void emitSub(PrimType primtype)
    {
        emitBinop(100, primtype);
    }

    public void emitSwap()
    {
        reserve(1);
        Type type = popType();
        Type type1 = popType();
        if (type.size > 4 || type1.size > 4)
        {
            pushType(type1);
            pushType(type);
            emitDupX();
            emitPop(1);
            return;
        } else
        {
            pushType(type);
            put1(95);
            pushType(type1);
            return;
        }
    }

    public void emitTailCall(boolean flag, Scope scope)
    {
        if (flag)
        {
            Method method = getMethod();
            int i;
            int j;
            if ((method.access_flags & 8) != 0)
            {
                i = 0;
            } else
            {
                i = 1;
            }
            j = method.arg_types.length;
            do
            {
                int k = j - 1;
                if (k < 0)
                {
                    break;
                }
                if (method.arg_types[k].size > 4)
                {
                    j = 2;
                } else
                {
                    j = 1;
                }
                i += j;
                j = k;
            } while (true);
            j = method.arg_types.length;
            do
            {
                int l = j - 1;
                if (l < 0)
                {
                    break;
                }
                if (method.arg_types[l].size > 4)
                {
                    j = 2;
                } else
                {
                    j = 1;
                }
                i -= j;
                emitStore(locals.used[i]);
                j = l;
            } while (true);
        }
        emitGoto(scope.start);
    }

    public final void emitThen()
    {
        if_stack.start_stack_size = SP;
    }

    public final void emitThrow()
    {
        popType();
        reserve(1);
        put1(191);
        setUnreachable();
    }

    final void emitTransfer(Label label, int i)
    {
        label.setTypes(this);
        fixupAdd(6, label);
        put1(i);
        PC = PC + 2;
    }

    public void emitTryCatchEnd()
    {
        Variable avariable[];
        if (try_stack.finally_subr != null)
        {
            emitFinallyEnd();
        }
        avariable = try_stack.savedStack;
        if (try_stack.end_label != null) goto _L2; else goto _L1
_L1:
        setUnreachable();
_L4:
        if (try_stack.saved_result != null || avariable != null)
        {
            popScope();
        }
        try_stack = try_stack.previous;
        return;
_L2:
        setTypes(try_stack.start_try.localTypes, Type.typeArray0);
        try_stack.end_label.define(this);
        if (avariable != null)
        {
            int i = avariable.length;
            do
            {
                int j = i - 1;
                if (j < 0)
                {
                    break;
                }
                Variable variable = avariable[j];
                i = j;
                if (variable != null)
                {
                    emitLoad(variable);
                    i = j;
                }
            } while (true);
        }
        if (try_stack.saved_result != null)
        {
            emitLoad(try_stack.saved_result);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void emitTryEnd()
    {
        emitTryEnd(false);
    }

    public void emitTryStart(boolean flag, Type type)
    {
        Type type1 = type;
        if (type != null)
        {
            type1 = type;
            if (type.isVoid())
            {
                type1 = null;
            }
        }
        type = null;
        if (type1 != null || SP > 0)
        {
            pushScope();
        }
        if (SP > 0)
        {
            Variable avariable[] = new Variable[SP];
            int i = 0;
            do
            {
                type = avariable;
                if (SP <= 0)
                {
                    break;
                }
                type = addLocal(topType());
                emitStore(type);
                avariable[i] = type;
                i++;
            } while (true);
        }
        TryState trystate = new TryState(this);
        trystate.savedStack = type;
        int j;
        if (local_types == null)
        {
            j = 0;
        } else
        {
            j = local_types.length;
        }
        do
        {
            if (j <= 0 || local_types[j - 1] != null)
            {
                if (j == 0)
                {
                    type = Type.typeArray0;
                } else
                {
                    type = new Type[j];
                    System.arraycopy(local_types, 0, type, 0, j);
                }
                trystate.start_try.localTypes = type;
                if (type1 != null)
                {
                    trystate.saved_result = addLocal(type1);
                }
                if (flag)
                {
                    trystate.finally_subr = new Label();
                }
                return;
            }
            j--;
        } while (true);
    }

    public final void emitUshr()
    {
        emitShift(124);
    }

    public void emitWithCleanupCatch(Variable variable)
    {
        emitTryEnd();
        Type atype[];
        int i;
        if (SP > 0)
        {
            atype = new Type[SP];
            System.arraycopy(stack_types, 0, atype, 0, SP);
            SP = 0;
        } else
        {
            atype = null;
        }
        try_stack.savedTypes = atype;
        try_stack.saved_result = variable;
        i = SP;
        emitCatchStart(variable);
    }

    public void emitWithCleanupDone()
    {
        Variable variable = try_stack.saved_result;
        try_stack.saved_result = null;
        if (variable != null)
        {
            emitLoad(variable);
        }
        emitThrow();
        emitCatchEnd();
        Type atype[] = try_stack.savedTypes;
        emitTryCatchEnd();
        if (atype != null)
        {
            SP = atype.length;
            if (SP >= stack_types.length)
            {
                stack_types = atype;
                return;
            } else
            {
                System.arraycopy(atype, 0, stack_types, 0, SP);
                return;
            }
        } else
        {
            SP = 0;
            return;
        }
    }

    public void emitWithCleanupStart()
    {
        int i = SP;
        SP = 0;
        emitTryStart(false, null);
        SP = i;
    }

    public final void emitXOr()
    {
        emitBinop(130);
    }

    public void endExitableBlock()
    {
        ExitableBlock exitableblock = currentExitableBlock;
        exitableblock.finish();
        currentExitableBlock = exitableblock.outer;
    }

    public void endFragment(int i)
    {
        fixup_offsets[i] = fixup_count << 4 | 0xa;
        Label label = fixup_labels[i];
        fixupAdd(9, 0, null);
        label.define(this);
    }

    public void enterScope(Scope scope)
    {
        scope.setStartPC(this);
        locals.enterScope(scope);
    }

    final void fixupAdd(int i, int j, Label label)
    {
        int k;
        if (label != null && i != 1 && i != 0 && i != 2 && i != 11)
        {
            label.needsStackMapEntry = true;
        }
        k = fixup_count;
        if (k != 0) goto _L2; else goto _L1
_L1:
        fixup_offsets = new int[30];
        fixup_labels = new Label[30];
_L4:
        fixup_offsets[k] = j << 4 | i;
        fixup_labels[k] = label;
        fixup_count = k + 1;
        return;
_L2:
        if (fixup_count == fixup_offsets.length)
        {
            int l = k * 2;
            Object aobj[] = new Label[l];
            System.arraycopy(fixup_labels, 0, ((Object) (aobj)), 0, k);
            fixup_labels = ((Label []) (aobj));
            aobj = new int[l];
            System.arraycopy(fixup_offsets, 0, ((Object) (aobj)), 0, k);
            fixup_offsets = ((int []) (aobj));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void fixupAdd(int i, Label label)
    {
        fixupAdd(i, PC, label);
    }

    public final void fixupChain(Label label, Label label1)
    {
        fixupAdd(9, 0, label1);
        label.defineRaw(this);
    }

    public Variable getArg(int i)
    {
        return locals.parameter_scope.getVariable(i);
    }

    public final Attribute getAttributes()
    {
        return attributes;
    }

    public byte[] getCode()
    {
        return code;
    }

    public int getCodeLength()
    {
        return PC;
    }

    public final ConstantPool getConstants()
    {
        return getMethod().classfile.constants;
    }

    public Scope getCurrentScope()
    {
        return locals.current_scope;
    }

    public final TryState getCurrentTry()
    {
        return try_stack;
    }

    public Label getLabel()
    {
        Label label = new Label();
        label.defineRaw(this);
        return label;
    }

    public final int getLength()
    {
        return getCodeLength() + 12 + exception_table_length * 8 + Attribute.getLengthAll(this);
    }

    public int getMaxLocals()
    {
        return max_locals;
    }

    public int getMaxStack()
    {
        return max_stack;
    }

    public final Method getMethod()
    {
        return (Method)getContainer();
    }

    public final int getPC()
    {
        return PC;
    }

    public final int getSP()
    {
        return SP;
    }

    byte invert_opcode(byte byte0)
    {
        byte0 &= 0xff;
        if (byte0 >= 153 && byte0 <= 166 || byte0 >= 198 && byte0 <= 199)
        {
            return (byte)(byte0 ^ 1);
        } else
        {
            throw new Error("unknown opcode to invert_opcode");
        }
    }

    public final boolean isInTry()
    {
        return try_stack != null;
    }

    public Variable lookup(String s)
    {
        for (Scope scope = locals.current_scope; scope != null; scope = scope.parent)
        {
            Variable variable = scope.lookup(s);
            if (variable != null)
            {
                return variable;
            }
        }

        return null;
    }

    void noteParamTypes()
    {
label0:
        {
            Method method = getMethod();
            int i = 0;
            if ((method.access_flags & 8) == 0)
            {
                ClassType classtype = method.classfile;
                Object obj = classtype;
                if ("<init>".equals(method.getName()))
                {
                    obj = classtype;
                    if (!"java.lang.Object".equals(classtype.getName()))
                    {
                        obj = UninitializedType.uninitializedThis((ClassType)classtype);
                    }
                }
                noteVarType(0, ((Type) (obj)));
                i = 0 + 1;
            }
            int l = method.arg_types.length;
            int k = 0;
            int j;
            for (j = i; k < l; j = i)
            {
                Type type = method.arg_types[k];
                i = j + 1;
                noteVarType(j, type);
                j = type.getSizeInWords();
                do
                {
                    j--;
                    if (j <= 0)
                    {
                        break;
                    }
                    i++;
                } while (true);
                k++;
            }

            if ((flags & 1) == 0)
            {
                break label0;
            }
            stackMap = new StackMapTableAttr();
            int ai[] = new int[j + 20];
            i = 0;
            for (k = 0; i < j; k++)
            {
                int i1;
label1:
                {
                    i1 = stackMap.encodeVerificationType(local_types[i], this);
                    ai[k] = i1;
                    int j1 = i1 & 0xff;
                    if (j1 != 3)
                    {
                        i1 = i;
                        if (j1 != 4)
                        {
                            break label1;
                        }
                    }
                    i1 = i + 1;
                }
                i = i1 + 1;
            }

            stackMap.encodedLocals = ai;
            stackMap.countLocals = k;
            stackMap.encodedStack = new int[10];
            stackMap.countStack = 0;
        }
    }

    public void noteVarType(int i, Type type)
    {
        int l = type.getSizeInWords();
        int j;
        int k;
        if (local_types == null)
        {
            local_types = new Type[i + l + 20];
        } else
        if (i + l > local_types.length)
        {
            Type atype[] = new Type[(i + l) * 2];
            System.arraycopy(local_types, 0, atype, 0, local_types.length);
            local_types = atype;
        }
        local_types[i] = type;
        if (varsSetInCurrentBlock == null)
        {
            varsSetInCurrentBlock = new boolean[local_types.length];
        } else
        if (varsSetInCurrentBlock.length <= i)
        {
            type = new boolean[local_types.length];
            System.arraycopy(varsSetInCurrentBlock, 0, type, 0, varsSetInCurrentBlock.length);
            varsSetInCurrentBlock = type;
        }
        varsSetInCurrentBlock[i] = true;
        j = l;
        k = i;
        if (i > 0)
        {
            type = local_types[i - 1];
            j = l;
            k = i;
            if (type != null)
            {
                j = l;
                k = i;
                if (type.getSizeInWords() == 2)
                {
                    local_types[i - 1] = null;
                    k = i;
                    j = l;
                }
            }
        }
        do
        {
            j--;
            if (j > 0)
            {
                type = local_types;
                k++;
                type[k] = null;
            } else
            {
                return;
            }
        } while (true);
    }

    public Scope popScope()
    {
        Scope scope = locals.current_scope;
        locals.current_scope = scope.parent;
        scope.freeLocals(this);
        scope.end = getLabel();
        return scope;
    }

    public final Type popType()
    {
        if (SP <= 0)
        {
            throw new Error((new StringBuilder()).append("popType called with empty stack ").append(getMethod()).toString());
        }
        Type atype[] = stack_types;
        int i = SP - 1;
        SP = i;
        Type type = atype[i];
        if (type.size == 8 && !popType().isVoid())
        {
            throw new Error("missing void type on stack");
        } else
        {
            return type;
        }
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", max_stack:");
        classtypewriter.print(max_stack);
        classtypewriter.print(", max_locals:");
        classtypewriter.print(max_locals);
        classtypewriter.print(", code_length:");
        int i = getCodeLength();
        classtypewriter.println(i);
        disAssemble(classtypewriter, 0, i);
        if (exception_table_length > 0)
        {
            classtypewriter.print("Exceptions (count: ");
            classtypewriter.print(exception_table_length);
            classtypewriter.println("):");
            int k = exception_table_length;
            int j = 0;
            do
            {
                k--;
                if (k < 0)
                {
                    break;
                }
                classtypewriter.print("  start: ");
                classtypewriter.print(exception_table[j] & 0xffff);
                classtypewriter.print(", end: ");
                classtypewriter.print(exception_table[j + 1] & 0xffff);
                classtypewriter.print(", handler: ");
                classtypewriter.print(exception_table[j + 2] & 0xffff);
                classtypewriter.print(", type: ");
                int l = exception_table[j + 3] & 0xffff;
                if (l == 0)
                {
                    classtypewriter.print("0 /* finally */");
                } else
                {
                    classtypewriter.printOptionalIndex(l);
                    classtypewriter.printConstantTersely(l, 7);
                }
                classtypewriter.println();
                j += 4;
            } while (true);
        }
        classtypewriter.printAttributes(this);
    }

    public void processFixups()
    {
        int j;
        int k;
        int i1;
        if (fixup_count <= 0)
        {
            return;
        }
        k = 0;
        i1 = fixup_count;
        fixupAdd(9, 0, null);
        j = 0;
_L12:
        Object obj;
        int i;
        int l;
        int j1;
        int k1;
        int l1;
        l1 = fixup_offsets[j];
        k1 = l1 >> 4;
        obj = fixup_labels[j];
        i = k;
        l = j;
        j1 = i1;
        l1 & 0xf;
        JVM INSTR tableswitch 0 14: default 144
    //                   0 165
    //                   1 191
    //                   2 213
    //                   3 165
    //                   4 226
    //                   5 287
    //                   6 318
    //                   7 144
    //                   8 165
    //                   9 369
    //                   10 349
    //                   11 155
    //                   12 144
    //                   13 144
    //                   14 178;
           goto _L1 _L2 _L3 _L4 _L2 _L5 _L6 _L7 _L1 _L2 _L8 _L9 _L10 _L1 _L1 _L11
_L7:
        break MISSING_BLOCK_LABEL_318;
_L9:
        break MISSING_BLOCK_LABEL_349;
_L8:
        break MISSING_BLOCK_LABEL_369;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        throw new Error("unexpected fixup");
_L10:
        l = j + 2;
        i = k;
_L13:
        j = l + 1;
        k = i;
          goto _L12
_L11:
        l = j + 1;
        i = k;
          goto _L13
_L3:
        obj.position = ((Label) (obj)).position + k;
        i = k;
        l = j;
          goto _L13
_L4:
        i = k + 3;
        l = j;
          goto _L13
_L5:
        if (((Label) (obj)).first_fixup != j + 1 || fixupOffset(j + 1) != k1 + 3) goto _L6; else goto _L14
_L14:
        fixup_offsets[j] = k1 << 4 | 8;
        fixup_labels[j] = null;
        i = k - 3;
        l = j;
          goto _L13
_L6:
        i = k;
        l = j;
        if (PC >= 32768)
        {
            i = k + 2;
            l = j;
        }
          goto _L13
        i = k;
        l = j;
        if (PC >= 32768)
        {
            i = k + 5;
            l = j;
        }
          goto _L13
        fixup_labels[i1] = fixup_labels[j + 1];
        j1 = k1;
        Label label;
        if (j + 1 >= fixup_count)
        {
            i = PC;
        } else
        {
            i = fixupOffset(fixup_labels[j + 1].first_fixup);
        }
        fixup_offsets[j] = i << 4 | 9;
        if (obj != null) goto _L16; else goto _L15
_L15:
        l1 = PC;
        l = 0;
        i = 0;
_L28:
        if (i >= fixup_count) goto _L18; else goto _L17
_L16:
        j = ((Label) (obj)).first_fixup;
        k = (i + k) - fixupOffset(j);
        i1 = j1;
          goto _L12
_L17:
        j = fixup_offsets[i];
        j1 = j & 0xf;
        label = fixup_labels[i];
        obj = label;
        if (label != null)
        {
            obj = label;
            if (label.position < 0)
            {
                throw new Error((new StringBuilder()).append("undefined label ").append(label).toString());
            }
        }
        while (obj != null && j1 >= 4 && j1 <= 7 && ((Label) (obj)).first_fixup + 1 < fixup_count && fixup_offsets[((Label) (obj)).first_fixup + 1] == (fixup_offsets[((Label) (obj)).first_fixup] & 0xf | 4)) 
        {
            obj = fixup_labels[((Label) (obj)).first_fixup + 1];
            fixup_labels[i] = ((Label) (obj));
        }
        k1 = j >> 4;
        j = l;
        i1 = i;
        k = l1;
        j1;
        JVM INSTR tableswitch 0 14: default 716
    //                   0 756
    //                   1 809
    //                   2 833
    //                   3 756
    //                   4 865
    //                   5 865
    //                   6 865
    //                   7 716
    //                   8 790
    //                   9 975
    //                   10 716
    //                   11 727
    //                   12 716
    //                   13 716
    //                   14 773;
           goto _L19 _L20 _L21 _L22 _L20 _L23 _L23 _L23 _L19 _L24 _L25 _L19 _L26 _L19 _L19 _L27
_L23:
        break MISSING_BLOCK_LABEL_865;
_L25:
        break MISSING_BLOCK_LABEL_975;
_L20:
        break; /* Loop/switch isn't completed */
_L19:
        throw new Error("unexpected fixup");
_L26:
        i1 = i + 2;
        fixup_labels[i1].position = k1 + l;
        k = l1;
        j = l;
_L29:
        i = i1 + 1;
        l = j;
        l1 = k;
          goto _L28
_L27:
        i1 = i + 1;
        j = l;
        k = l1;
          goto _L29
_L24:
        j = l - 3;
        k = l1 - 3;
        i1 = i;
          goto _L29
_L21:
        obj.position = k1 + l;
        j = l;
        i1 = i;
        k = l1;
          goto _L29
_L22:
        k = 3 - (k1 + l) & 3;
        j = l + k;
        k = l1 + k;
        i1 = i;
          goto _L29
        j = ((Label) (obj)).position - (k1 + l);
        if ((short)j == j)
        {
            fixup_offsets[i] = k1 << 4 | 7;
            j = l;
            i1 = i;
            k = l1;
        } else
        {
            if (j1 == 6)
            {
                j = 5;
            } else
            {
                j = 2;
            }
            k = l + j;
            if (j1 == 6)
            {
                j = 5;
            } else
            {
                j = 2;
            }
            l = l1 + j;
            j = k;
            i1 = i;
            k = l;
        }
          goto _L29
        if (obj != null) goto _L30; else goto _L18
_L18:
        Object obj1;
        byte abyte0[];
        byte byte1;
        abyte0 = new byte[l1];
        byte1 = -1;
        l = 0;
        k = fixupOffset(0);
        obj1 = null;
        j = 0;
        break MISSING_BLOCK_LABEL_1003;
_L30:
        i = ((Label) (obj)).first_fixup;
        l = (k1 + l) - fixupOffset(i);
          goto _L28
_L41:
        Label label1;
        for (i = 0; j < k; i++)
        {
            abyte0[i] = code[j];
            j++;
        }

        i1 = fixup_offsets[l] & 0xf;
        label1 = fixup_labels[l];
        obj = obj1;
        if (obj1 != null)
        {
            obj = obj1;
            if (((Label) (obj1)).position < i)
            {
                stackMap.emitStackMapEntry(((Label) (obj1)), this);
                obj = null;
            }
        }
        if (obj != null && ((Label) (obj)).position > i)
        {
            throw new Error("labels out of order");
        }
        i1;
        JVM INSTR tableswitch 0 14: default 1212
    //                   0 1223
    //                   1 1274
    //                   2 1602
    //                   3 1212
    //                   4 1426
    //                   5 1426
    //                   6 1426
    //                   7 1344
    //                   8 1325
    //                   9 2018
    //                   10 1212
    //                   11 1865
    //                   12 1212
    //                   13 1212
    //                   14 1954;
           goto _L31 _L32 _L33 _L34 _L31 _L35 _L35 _L35 _L36 _L37 _L38 _L31 _L39 _L31 _L31 _L40
_L31:
        throw new Error("unexpected fixup");
_L32:
        int i2;
        i2 = byte1;
        obj1 = obj;
        k = j;
        j = i;
_L42:
        l++;
        j1 = fixupOffset(l);
        i1 = k;
        i = j;
        k = j1;
        j = i1;
        byte1 = i2;
          goto _L41
_L33:
        if (stackMap != null && label1 != null && label1.stackTypes != null && label1.needsStackMapEntry)
        {
            obj1 = mergeLabels(((Label) (obj)), label1);
            k = j;
            j = i;
            i2 = byte1;
        } else
        {
            k = j;
            j = i;
            obj1 = obj;
            i2 = byte1;
        }
          goto _L42
_L37:
        k = j + 3;
        j = i;
        obj1 = obj;
        i2 = byte1;
          goto _L42
_L36:
        k = label1.position - i;
        i1 = i + 1;
        abyte0[i] = code[j];
        j1 = i1 + 1;
        abyte0[i1] = (byte)(k >> 8);
        i = j1 + 1;
        abyte0[j1] = (byte)(k & 0xff);
        k = j + 3;
        j = i;
        obj1 = obj;
        i2 = byte1;
          goto _L42
_L35:
        k = label1.position - i;
        byte byte0 = code[j];
        if (i1 == 6)
        {
            byte0 = invert_opcode(byte0);
            i1 = i + 1;
            abyte0[i] = byte0;
            j1 = i1 + 1;
            abyte0[i1] = 0;
            i = j1 + 1;
            abyte0[j1] = 8;
            byte0 = -56;
        } else
        {
            byte0 += 33;
        }
        i1 = i + 1;
        abyte0[i] = byte0;
        i = i1 + 1;
        abyte0[i1] = (byte)(k >> 24);
        i1 = i + 1;
        abyte0[i] = (byte)(k >> 16);
        i = i1 + 1;
        abyte0[i1] = (byte)(k >> 8);
        abyte0[i] = (byte)(k & 0xff);
        k = j + 3;
        j = i + 1;
        obj1 = obj;
        i2 = byte1;
          goto _L42
_L34:
        k = 3 - i & 3;
        obj1 = code;
        j1 = j + 1;
        abyte0[i] = obj1[j];
        j = i + 1;
        do
        {
            k--;
            if (k < 0)
            {
                break;
            }
            abyte0[j] = 0;
            j++;
        } while (true);
        break MISSING_BLOCK_LABEL_2143;
_L43:
        k1++;
        l = fixupOffset(k1);
        j = j1;
        k = i1;
        while (j < l) 
        {
            abyte0[k] = code[j];
            j++;
            k++;
        }
        l = fixup_labels[k1].position - i;
        i1 = k + 1;
        abyte0[k] = (byte)(l >> 24);
        k = i1 + 1;
        abyte0[i1] = (byte)(l >> 16);
        i1 = k + 1;
        abyte0[k] = (byte)(l >> 8);
        abyte0[i1] = (byte)(l & 0xff);
        j1 = j + 4;
        i1++;
_L44:
        j = i1;
        l = k1;
        k = j1;
        obj1 = obj;
        i2 = byte1;
        if (k1 >= fixup_count)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i1;
        l = k1;
        k = j1;
        obj1 = obj;
        i2 = byte1;
        if (fixupKind(k1 + 1) != 3) goto _L42; else goto _L43
_L39:
        label1 = fixup_labels[l + 2];
        k = fixupOffset(l + 1);
        obj1 = obj;
        if (stackMap != null)
        {
            obj1 = mergeLabels(((Label) (obj)), label1);
        }
        addHandler(fixup_labels[l].position, fixup_labels[l + 1].position, i, k);
        l += 2;
        k = j;
        j = i;
        i2 = byte1;
          goto _L42
_L40:
        if (lines == null)
        {
            lines = new LineNumbersAttr(this);
        }
        l++;
        i2 = fixupOffset(l);
        if (i2 != byte1)
        {
            lines.put(i2, i);
        }
        k = j;
        j = i;
        obj1 = obj;
          goto _L42
_L38:
        if (label1 == null)
        {
            if (l1 != i)
            {
                throw new Error((new StringBuilder()).append("PC confusion new_pc:").append(i).append(" new_size:").append(l1).toString());
            } else
            {
                PC = l1;
                code = abyte0;
                fixup_count = 0;
                fixup_labels = null;
                fixup_offsets = null;
                return;
            }
        }
        l = label1.first_fixup;
        j = fixupOffset(l);
        k = j;
        if (label1.position != i)
        {
            throw new Error("bad pc");
        }
        obj1 = obj;
          goto _L41
        i1 = j;
        k1 = l;
          goto _L44
    }

    public Scope pushScope()
    {
        Scope scope = new Scope();
        if (locals == null)
        {
            locals = new LocalVarsAttr(getMethod());
        }
        enterScope(scope);
        if (locals.parameter_scope == null)
        {
            locals.parameter_scope = scope;
        }
        return scope;
    }

    public final void pushType(Type type)
    {
        if (type.size == 0)
        {
            throw new Error("pushing void type onto stack");
        }
        if (stack_types != null && stack_types.length != 0) goto _L2; else goto _L1
_L1:
        stack_types = new Type[20];
_L4:
        if (type.size == 8)
        {
            Type atype[] = stack_types;
            int i = SP;
            SP = i + 1;
            atype[i] = Type.voidType;
        }
        Type atype1[] = stack_types;
        int j = SP;
        SP = j + 1;
        atype1[j] = type;
        if (SP > max_stack)
        {
            max_stack = SP;
        }
        return;
_L2:
        if (SP + 1 >= stack_types.length)
        {
            Type atype2[] = new Type[stack_types.length * 2];
            System.arraycopy(stack_types, 0, atype2, 0, SP);
            stack_types = atype2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void put1(int i)
    {
        byte abyte0[] = code;
        int j = PC;
        PC = j + 1;
        abyte0[j] = (byte)i;
        unreachable_here = false;
    }

    public final void put2(int i)
    {
        byte abyte0[] = code;
        int j = PC;
        PC = j + 1;
        abyte0[j] = (byte)(i >> 8);
        abyte0 = code;
        j = PC;
        PC = j + 1;
        abyte0[j] = (byte)i;
        unreachable_here = false;
    }

    public final void put4(int i)
    {
        byte abyte0[] = code;
        int j = PC;
        PC = j + 1;
        abyte0[j] = (byte)(i >> 24);
        abyte0 = code;
        j = PC;
        PC = j + 1;
        abyte0[j] = (byte)(i >> 16);
        abyte0 = code;
        j = PC;
        PC = j + 1;
        abyte0[j] = (byte)(i >> 8);
        abyte0 = code;
        j = PC;
        PC = j + 1;
        abyte0[j] = (byte)i;
        unreachable_here = false;
    }

    public final void putIndex2(CpoolEntry cpoolentry)
    {
        put2(cpoolentry.index);
    }

    public final void putLineNumber(int i)
    {
        int j = i;
        if (sourceDbgExt != null)
        {
            j = sourceDbgExt.fixLine(i);
        }
        fixupAdd(14, null);
        fixupAdd(15, j, null);
    }

    public final void putLineNumber(String s, int i)
    {
        if (s != null)
        {
            getMethod().classfile.setSourceFile(s);
        }
        putLineNumber(i);
    }

    public final boolean reachableHere()
    {
        return !unreachable_here;
    }

    public final void reserve(int i)
    {
        if (code == null)
        {
            code = new byte[i + 100];
        } else
        if (PC + i > code.length)
        {
            byte abyte0[] = new byte[code.length * 2 + i];
            System.arraycopy(code, 0, abyte0, 0, PC);
            code = abyte0;
            return;
        }
    }

    public final void setAttributes(Attribute attribute)
    {
        attributes = attribute;
    }

    public void setCode(byte abyte0[])
    {
        code = abyte0;
        PC = abyte0.length;
    }

    public void setCodeLength(int i)
    {
        PC = i;
    }

    public void setMaxLocals(int i)
    {
        max_locals = i;
    }

    public void setMaxStack(int i)
    {
        max_stack = i;
    }

    public final void setReachable(boolean flag)
    {
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        unreachable_here = flag;
    }

    public final void setTypes(Label label)
    {
        setTypes(label.localTypes, label.stackTypes);
    }

    public final void setTypes(Type atype[], Type atype1[])
    {
        int k = atype1.length;
        int i = atype.length;
        if (local_types != null)
        {
            if (i > 0)
            {
                System.arraycopy(atype, 0, local_types, 0, i);
            }
            for (; i < local_types.length; i++)
            {
                local_types[i] = null;
            }

        }
        if (stack_types == null || k > stack_types.length)
        {
            stack_types = new Type[k];
        } else
        {
            int j = k;
            while (j < stack_types.length) 
            {
                stack_types[j] = null;
                j++;
            }
        }
        System.arraycopy(atype1, 0, stack_types, 0, k);
        SP = k;
    }

    public final void setUnreachable()
    {
        unreachable_here = true;
    }

    public ExitableBlock startExitableBlock(Type type, boolean flag)
    {
        type = new ExitableBlock(type, this, flag);
        type.outer = currentExitableBlock;
        currentExitableBlock = type;
        return type;
    }

    public SwitchState startSwitch()
    {
        SwitchState switchstate = new SwitchState(this);
        switchstate.switchValuePushed(this);
        return switchstate;
    }

    public final Type topType()
    {
        return stack_types[SP - 1];
    }

    boolean useJsr()
    {
        return (flags & 2) == 0;
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(max_stack);
        dataoutputstream.writeShort(max_locals);
        dataoutputstream.writeInt(PC);
        dataoutputstream.write(code, 0, PC);
        dataoutputstream.writeShort(exception_table_length);
        int j = exception_table_length;
        int i = 0;
        do
        {
            j--;
            if (j >= 0)
            {
                dataoutputstream.writeShort(exception_table[i]);
                dataoutputstream.writeShort(exception_table[i + 1]);
                dataoutputstream.writeShort(exception_table[i + 2]);
                dataoutputstream.writeShort(exception_table[i + 3]);
                i += 4;
            } else
            {
                Attribute.writeAll(this, dataoutputstream);
                return;
            }
        } while (true);
    }

}
