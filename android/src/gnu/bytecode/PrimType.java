// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;


// Referenced classes of package gnu.bytecode:
//            Type, ClassType, ArrayType, CodeAttr, 
//            Method

public class PrimType extends Type
{

    private static final String numberHierarchy = "A:java.lang.Byte;B:java.lang.Short;C:java.lang.Integer;D:java.lang.Long;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;";

    protected PrimType(PrimType primtype)
    {
        super(primtype.this_name, primtype.signature);
        size = primtype.size;
        reflectClass = primtype.reflectClass;
    }

    public PrimType(String s, String s1, int i, Class class1)
    {
        super(s, s1);
        size = i;
        reflectClass = class1;
        Type.registerTypeForClass(class1, this);
    }

    public static boolean booleanValue(Object obj)
    {
        return !(obj instanceof Boolean) || ((Boolean)obj).booleanValue();
    }

    public static int compare(PrimType primtype, PrimType primtype1)
    {
        byte byte0;
        byte byte1;
        char c;
        char c1;
        byte0 = -3;
        byte1 = -1;
        c = primtype.signature.charAt(0);
        c1 = primtype1.signature.charAt(0);
        if (c != c1) goto _L2; else goto _L1
_L1:
        int i = 0;
_L4:
        return i;
_L2:
        if (c == 'V')
        {
            return 1;
        }
        i = byte1;
        if (c1 == 'V')
        {
            continue; /* Loop/switch isn't completed */
        }
        if (c == 'Z' || c1 == 'Z')
        {
            return -3;
        }
        if (c != 'C')
        {
            break; /* Loop/switch isn't completed */
        }
        i = byte1;
        if (primtype1.size <= 2)
        {
            return -3;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (c1 == 'C')
        {
            i = byte0;
            if (primtype.size > 2)
            {
                i = 1;
            }
            return i;
        }
        if (c == 'D')
        {
            return 1;
        }
        i = byte1;
        if (c1 != 'D')
        {
            if (c == 'F')
            {
                return 1;
            }
            i = byte1;
            if (c1 != 'F')
            {
                if (c == 'J')
                {
                    return 1;
                }
                i = byte1;
                if (c1 != 'J')
                {
                    if (c == 'I')
                    {
                        return 1;
                    }
                    i = byte1;
                    if (c1 != 'I')
                    {
                        if (c == 'S')
                        {
                            return 1;
                        }
                        i = byte1;
                        if (c1 != 'S')
                        {
                            return -3;
                        }
                    }
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private static char findInHierarchy(String s)
    {
        int i = "A:java.lang.Byte;B:java.lang.Short;C:java.lang.Integer;D:java.lang.Long;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".indexOf(s) - 2;
        if (i < 0)
        {
            return '\0';
        } else
        {
            return "A:java.lang.Byte;B:java.lang.Short;C:java.lang.Integer;D:java.lang.Long;E:gnu.math.IntNum;E:java.gnu.math.BitInteger;G:gnu.math.RatNum;H:java.lang.Float;I:java.lang.Double;I:gnu.math.DFloNum;J:gnu.math.RealNum;K:gnu.math.Complex;L:gnu.math.Quantity;K:gnu.math.Numeric;N:java.lang.Number;".charAt(i);
        }
    }

    public ClassType boxedType()
    {
        getSignature().charAt(0);
        JVM INSTR lookupswitch 8: default 84
    //                   66: 103
    //                   67: 97
    //                   68: 133
    //                   70: 127
    //                   73: 115
    //                   74: 121
    //                   83: 109
    //                   90: 91;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
        String s = null;
_L11:
        return ClassType.make(s);
_L9:
        s = "java.lang.Boolean";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "java.lang.Character";
        continue; /* Loop/switch isn't completed */
_L2:
        s = "java.lang.Byte";
        continue; /* Loop/switch isn't completed */
_L8:
        s = "java.lang.Short";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "java.lang.Integer";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "java.lang.Long";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "java.lang.Float";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "java.lang.Double";
        if (true) goto _L11; else goto _L10
_L10:
    }

    public char charValue(Object obj)
    {
        return ((Character)obj).charValue();
    }

    public Object coerceFromObject(Object obj)
    {
        if (obj.getClass() == reflectClass)
        {
            return obj;
        }
        char c;
        if (signature == null || signature.length() != 1)
        {
            c = ' ';
        } else
        {
            c = signature.charAt(0);
        }
        switch (c)
        {
        default:
            throw new ClassCastException((new StringBuilder()).append("don't know how to coerce ").append(obj.getClass().getName()).append(" to ").append(getName()).toString());

        case 66: // 'B'
            return Byte.valueOf(((Number)obj).byteValue());

        case 83: // 'S'
            return Short.valueOf(((Number)obj).shortValue());

        case 73: // 'I'
            return Integer.valueOf(((Number)obj).intValue());

        case 74: // 'J'
            return Long.valueOf(((Number)obj).longValue());

        case 70: // 'F'
            return Float.valueOf(((Number)obj).floatValue());

        case 68: // 'D'
            return Double.valueOf(((Number)obj).doubleValue());

        case 90: // 'Z'
            return Boolean.valueOf(((Boolean)obj).booleanValue());
        }
    }

    public int compare(Type type)
    {
        boolean flag = false;
        if (!(type instanceof PrimType)) goto _L2; else goto _L1
_L1:
        if (type.getImplementationType() == type) goto _L4; else goto _L3
_L3:
        int j = swappedCompareResult(type.compare(this));
_L16:
        return j;
_L4:
        return compare(this, (PrimType)type);
_L2:
        String s;
        int i;
        if (!(type instanceof ClassType))
        {
            if (type instanceof ArrayType)
            {
                return -3;
            } else
            {
                return swappedCompareResult(type.compare(this));
            }
        }
        j = signature.charAt(0);
        s = type.getName();
        if (s == null)
        {
            return -1;
        }
        i = 0;
        j;
        JVM INSTR lookupswitch 9: default 172
    //                   66: 231
    //                   67: 220
    //                   68: 261
    //                   70: 255
    //                   73: 243
    //                   74: 249
    //                   83: 237
    //                   86: 205
    //                   90: 207;
           goto _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L8:
        break MISSING_BLOCK_LABEL_261;
_L5:
        break; /* Loop/switch isn't completed */
_L7:
        break; /* Loop/switch isn't completed */
_L18:
        if (i != 0)
        {
            char c = findInHierarchy(s);
            if (c != 0)
            {
                j = ((flag) ? 1 : 0);
                if (c != i)
                {
                    return c >= i ? -1 : 1;
                }
                continue; /* Loop/switch isn't completed */
            }
        }
        break MISSING_BLOCK_LABEL_269;
_L13:
        return 1;
_L14:
        j = ((flag) ? 1 : 0);
        if (s.equals("java.lang.Boolean")) goto _L16; else goto _L15
_L15:
        if (!s.equals("java.lang.Character")) goto _L18; else goto _L17
_L17:
        return 0;
_L6:
        i = 65;
          goto _L18
_L12:
        i = 66;
          goto _L18
_L10:
        i = 67;
          goto _L18
_L11:
        i = 68;
          goto _L18
_L9:
        i = 72;
          goto _L18
        i = 73;
          goto _L18
        return !s.equals("java.lang.Object") && type != toStringType ? -3 : -1;
        if (true) goto _L16; else goto _L19
_L19:
    }

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        char c;
        if (signature == null || signature.length() != 1)
        {
            c = ' ';
        } else
        {
            c = signature.charAt(0);
        }
        if (c == 'Z')
        {
            codeattr.emitCheckcast(javalangBooleanType);
            codeattr.emitInvokeVirtual(booleanValue_method);
            return;
        }
        if (c == 'V')
        {
            codeattr.emitPop(1);
            return;
        }
        codeattr.emitCheckcast(javalangNumberType);
        if (c == 'I' || c == 'S' || c == 'B')
        {
            codeattr.emitInvokeVirtual(intValue_method);
            return;
        }
        if (c == 'J')
        {
            codeattr.emitInvokeVirtual(longValue_method);
            return;
        }
        if (c == 'D')
        {
            codeattr.emitInvokeVirtual(doubleValue_method);
            return;
        }
        if (c == 'F')
        {
            codeattr.emitInvokeVirtual(floatValue_method);
            return;
        } else
        {
            super.emitCoerceFromObject(codeattr);
            return;
        }
    }

    public void emitCoerceToObject(CodeAttr codeattr)
    {
        char c = getSignature().charAt(0);
        ClassType classtype = boxedType();
        if (c == 'Z')
        {
            codeattr.emitIfIntNotZero();
            codeattr.emitGetStatic(classtype.getDeclaredField("TRUE"));
            codeattr.emitElse();
            codeattr.emitGetStatic(classtype.getDeclaredField("FALSE"));
            codeattr.emitFi();
            return;
        }
        Object obj = new Type[1];
        obj[0] = this;
        if (codeattr.getMethod().getDeclaringClass().classfileFormatVersion >= 0x310000)
        {
            obj = classtype.getDeclaredMethod("valueOf", ((Type []) (obj)));
        } else
        {
            obj = classtype.getDeclaredMethod("<init>", ((Type []) (obj)));
            codeattr.emitNew(classtype);
            codeattr.emitDupX();
            codeattr.emitSwap();
        }
        codeattr.emitInvoke(((Method) (obj)));
    }

    public void emitIsInstance(CodeAttr codeattr)
    {
        char c;
        if (signature == null || signature.length() != 1)
        {
            c = ' ';
        } else
        {
            c = signature.charAt(0);
        }
        if (c == 'Z')
        {
            javalangBooleanType.emitIsInstance(codeattr);
            return;
        }
        if (c == 'V')
        {
            codeattr.emitPop(1);
            codeattr.emitPushInt(1);
            return;
        } else
        {
            javalangNumberType.emitIsInstance(codeattr);
            return;
        }
    }

    public Type promotedType()
    {
        switch (signature.charAt(0))
        {
        default:
            return getImplementationType();

        case 66: // 'B'
        case 67: // 'C'
        case 73: // 'I'
        case 83: // 'S'
        case 90: // 'Z'
            return Type.intType;
        }
    }
}
