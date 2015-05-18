// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            MiscAttr, Label, Type, UninitializedType, 
//            PrimType, CodeAttr, ObjectType, ConstantPool, 
//            CpoolClass, ClassTypeWriter, Method

public class StackMapTableAttr extends MiscAttr
{

    public static boolean compressStackMapTable = true;
    int countLocals;
    int countStack;
    int encodedLocals[];
    int encodedStack[];
    int numEntries;
    int prevPosition;

    public StackMapTableAttr()
    {
        super("StackMapTable", null, 0, 0);
        prevPosition = -1;
        put2(0);
    }

    public StackMapTableAttr(byte abyte0[], CodeAttr codeattr)
    {
        super("StackMapTable", abyte0, 0, abyte0.length);
        prevPosition = -1;
        addToFrontOf(codeattr);
        numEntries = u2(0);
    }

    static int[] reallocBuffer(int ai[], int i)
    {
        int ai1[];
        if (ai == null)
        {
            ai1 = new int[i + 10];
        } else
        {
            ai1 = ai;
            if (i > ai.length)
            {
                int ai2[] = new int[i + 10];
                System.arraycopy(ai, 0, ai2, 0, ai.length);
                return ai2;
            }
        }
        return ai1;
    }

    public void emitStackMapEntry(Label label, CodeAttr codeattr)
    {
        int i;
        int l;
        int j2;
        int k2;
        j2 = label.position - prevPosition - 1;
        int k1 = label.localTypes.length;
        if (k1 > encodedLocals.length)
        {
            int ai[] = new int[encodedLocals.length + k1];
            System.arraycopy(encodedLocals, 0, ai, 0, countLocals);
            encodedLocals = ai;
        }
        k2 = label.stackTypes.length;
        if (k2 > encodedStack.length)
        {
            int ai1[] = new int[encodedStack.length + k2];
            System.arraycopy(encodedStack, 0, ai1, 0, countStack);
            encodedStack = ai1;
        }
        l = 0;
        int j = 0;
        i = 0;
label0:
        do
        {
            int i1;
label1:
            {
                if (j >= k1)
                {
                    break label0;
                }
                int i3 = encodedLocals[i];
                int l2 = encodeVerificationType(label.localTypes[j], codeattr);
                i1 = l;
                if (i3 == l2)
                {
                    i1 = l;
                    if (l == i)
                    {
                        i1 = i + 1;
                    }
                }
                encodedLocals[i] = l2;
                if (l2 != 3)
                {
                    l = j;
                    if (l2 != 4)
                    {
                        break label1;
                    }
                }
                l = j + 1;
            }
            j = l + 1;
            i++;
            l = i1;
        } while (true);
          goto _L1
_L8:
        int k;
        int j1;
        int i2;
        for (; k > 0 && encodedLocals[k - 1] == 0; k--) { }
        i = 0;
        for (j1 = 0; i < k2; j1++)
        {
            int l1 = encodedStack[j1];
            Type type = label.stackTypes[i];
            l1 = i;
            Object obj = type;
            if (type == Type.voidType)
            {
                obj = label.stackTypes;
                l1 = i + 1;
                obj = obj[l1];
            }
            i = encodeVerificationType(((Type) (obj)), codeattr);
            encodedStack[j1] = i;
            i = l1 + 1;
        }

        i2 = k - countLocals;
        if (!compressStackMapTable || i2 != 0 || k != l || j1 > 1) goto _L3; else goto _L2
_L2:
        if (j1 == 0)
        {
            if (j2 <= 63)
            {
                put1(j2);
            } else
            {
                put1(251);
                put2(j2);
            }
        } else
        {
            if (j2 <= 63)
            {
                put1(j2 + 64);
            } else
            {
                put1(247);
                put2(j2);
            }
            emitVerificationType(encodedStack[0]);
        }
_L5:
        countLocals = k;
        countStack = j1;
        prevPosition = label.position;
        numEntries = numEntries + 1;
        return;
_L3:
        if (!compressStackMapTable || j1 != 0 || k >= countLocals || l != k || i2 < -3)
        {
            break; /* Loop/switch isn't completed */
        }
        put1(i2 + 251);
        put2(j2);
        if (true) goto _L5; else goto _L4
_L4:
        if (!compressStackMapTable || j1 != 0 || countLocals != l || i2 > 3)
        {
            break; /* Loop/switch isn't completed */
        }
        put1(i2 + 251);
        put2(j2);
        i = 0;
        while (i < i2) 
        {
            emitVerificationType(encodedLocals[l + i]);
            i++;
        }
        if (true) goto _L5; else goto _L6
_L6:
        put1(255);
        put2(j2);
        put2(k);
        for (i = 0; i < k; i++)
        {
            emitVerificationType(encodedLocals[i]);
        }

        put2(j1);
        i = 0;
        while (i < j1) 
        {
            emitVerificationType(encodedStack[i]);
            i++;
        }
        if (true) goto _L5; else goto _L1
_L1:
        k = i;
        if (true) goto _L8; else goto _L7
_L7:
    }

    void emitVerificationType(int i)
    {
        int j = i & 0xff;
        put1(j);
        if (j >= 7)
        {
            put2(i >> 8);
        }
    }

    int encodeVerificationType(Type type, CodeAttr codeattr)
    {
        if (type == null)
        {
            return 0;
        }
        if (type instanceof UninitializedType)
        {
            type = ((UninitializedType)type).label;
            if (type == null)
            {
                return 6;
            } else
            {
                return ((Label) (type)).position << 8 | 8;
            }
        }
        type = type.getImplementationType();
        if (type instanceof PrimType)
        {
            switch (type.signature.charAt(0))
            {
            default:
                return 0;

            case 66: // 'B'
            case 67: // 'C'
            case 73: // 'I'
            case 83: // 'S'
            case 90: // 'Z'
                return 1;

            case 74: // 'J'
                return 4;

            case 70: // 'F'
                return 2;

            case 68: // 'D'
                return 3;
            }
        }
        if (type == Type.nullType)
        {
            return 5;
        } else
        {
            return codeattr.getConstants().addClass((ObjectType)type).index << 8 | 7;
        }
    }

    int extractVerificationType(int i, int j)
    {
        int k;
label0:
        {
            if (j != 7)
            {
                k = j;
                if (j != 8)
                {
                    break label0;
                }
            }
            k = j | u2(i + 1) << 8;
        }
        return k;
    }

    int extractVerificationTypes(int i, int j, int k, int ai[])
    {
        int l = i;
        i = k;
        k = j;
        j = l;
        do
        {
            int i1 = k - 1;
            if (i1 >= 0)
            {
                if (j >= dataLength)
                {
                    k = -1;
                } else
                {
                    k = data[j];
                    int j1 = extractVerificationType(j, k);
                    if (k == 7 || k == 8)
                    {
                        k = 3;
                    } else
                    {
                        k = 1;
                    }
                    j += k;
                    k = j1;
                }
                ai[i] = k;
                i++;
                k = i1;
            } else
            {
                return j;
            }
        } while (true);
    }

    public Method getMethod()
    {
        return ((CodeAttr)container).getMethod();
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", number of entries: ");
        classtypewriter.println(numEntries);
        int j = 2;
        int k = -1;
        Method method = getMethod();
        int ai[] = null;
        int i;
        int l;
        int i1;
        if (method.getStaticFlag())
        {
            i = 0;
        } else
        {
            i = 1;
        }
        i1 = i + method.arg_types.length;
        l = 0;
        i = j;
        j = i1;
        do
        {
            if (l >= numEntries || i >= dataLength)
            {
                return;
            }
            int j1 = i + 1;
            int j2 = u1(i);
            i = k + 1;
            if (j2 <= 127)
            {
                k = i + (j2 & 0x3f);
                i = j1;
            } else
            {
                if (j1 + 1 >= dataLength)
                {
                    return;
                }
                k = i + u2(j1);
                i = j1 + 2;
            }
            classtypewriter.print("  offset: ");
            classtypewriter.print(k);
            if (j2 <= 63)
            {
                classtypewriter.println(" - same_frame");
            } else
            if (j2 <= 127 || j2 == 247)
            {
                String s;
                if (j2 <= 127)
                {
                    s = " - same_locals_1_stack_item_frame";
                } else
                {
                    s = " - same_locals_1_stack_item_frame_extended";
                }
                classtypewriter.println(s);
                ai = reallocBuffer(ai, 1);
                i = extractVerificationTypes(i, 1, 0, ai);
                printVerificationTypes(ai, 0, 1, classtypewriter);
            } else
            {
                if (j2 <= 246)
                {
                    classtypewriter.print(" - tag reserved for future use - ");
                    classtypewriter.println(j2);
                    return;
                }
                if (j2 <= 250)
                {
                    int k1 = 251 - j2;
                    classtypewriter.print(" - chop_frame - undefine ");
                    classtypewriter.print(k1);
                    classtypewriter.println(" locals");
                    j -= k1;
                } else
                if (j2 == 251)
                {
                    classtypewriter.println(" - same_frame_extended");
                } else
                if (j2 <= 254)
                {
                    int l1 = j2 - 251;
                    classtypewriter.print(" - append_frame - define ");
                    classtypewriter.print(l1);
                    classtypewriter.println(" more locals");
                    ai = reallocBuffer(ai, j + l1);
                    i = extractVerificationTypes(i, l1, j, ai);
                    printVerificationTypes(ai, j, l1, classtypewriter);
                    j += l1;
                } else
                {
                    if (i + 1 >= dataLength)
                    {
                        return;
                    }
                    j = u2(i);
                    classtypewriter.print(" - full_frame.  Locals count: ");
                    classtypewriter.println(j);
                    ai = reallocBuffer(ai, j);
                    int i2 = extractVerificationTypes(i + 2, j, 0, ai);
                    printVerificationTypes(ai, 0, j, classtypewriter);
                    if (i2 + 1 >= dataLength)
                    {
                        return;
                    }
                    int k2 = u2(i2);
                    classtypewriter.print("    (end of locals)");
                    i = Integer.toString(k).length();
                    do
                    {
                        i--;
                        if (i < 0)
                        {
                            break;
                        }
                        classtypewriter.print(' ');
                    } while (true);
                    classtypewriter.print("       Stack count: ");
                    classtypewriter.println(k2);
                    ai = reallocBuffer(ai, k2);
                    i = extractVerificationTypes(i2 + 2, k2, 0, ai);
                    printVerificationTypes(ai, 0, k2, classtypewriter);
                }
            }
            if (i < 0)
            {
                classtypewriter.println("<ERROR - missing data>");
                return;
            }
            l++;
        } while (true);
    }

    void printVerificationType(int i, ClassTypeWriter classtypewriter)
    {
        int j = i & 0xff;
        switch (j)
        {
        default:
            classtypewriter.print((new StringBuilder()).append("<bad verification type tag ").append(j).append('>').toString());
            return;

        case 0: // '\0'
            classtypewriter.print("top/unavailable");
            return;

        case 1: // '\001'
            classtypewriter.print("integer");
            return;

        case 2: // '\002'
            classtypewriter.print("float");
            return;

        case 3: // '\003'
            classtypewriter.print("double");
            return;

        case 4: // '\004'
            classtypewriter.print("long");
            return;

        case 5: // '\005'
            classtypewriter.print("null");
            return;

        case 6: // '\006'
            classtypewriter.print("uninitialized this");
            return;

        case 7: // '\007'
            i >>= 8;
            classtypewriter.printOptionalIndex(i);
            classtypewriter.printConstantTersely(i, 7);
            return;

        case 8: // '\b'
            classtypewriter.print("uninitialized object created at ");
            break;
        }
        classtypewriter.print(i >> 8);
    }

    void printVerificationTypes(int ai[], int i, int j, ClassTypeWriter classtypewriter)
    {
        int k = 0;
        int l = 0;
        do
        {
label0:
            {
label1:
                {
                    if (l >= i + j)
                    {
                        break label0;
                    }
                    int i1 = ai[l];
                    int j1 = i1 & 0xff;
                    if (l >= i)
                    {
                        classtypewriter.print("  ");
                        if (k < 100)
                        {
                            if (k < 10)
                            {
                                classtypewriter.print(' ');
                            }
                            classtypewriter.print(' ');
                        }
                        classtypewriter.print(k);
                        classtypewriter.print(": ");
                        printVerificationType(i1, classtypewriter);
                        classtypewriter.println();
                    }
                    i1 = k + 1;
                    if (j1 != 3)
                    {
                        k = i1;
                        if (j1 != 4)
                        {
                            break label1;
                        }
                    }
                    k = i1 + 1;
                }
                l++;
                continue;
            }
            return;
        } while (true);
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        put2(0, numEntries);
        super.write(dataoutputstream);
    }

}
