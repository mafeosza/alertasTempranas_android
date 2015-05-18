// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayType;
import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Field;
import gnu.bytecode.Method;
import gnu.bytecode.ObjectType;
import gnu.bytecode.PrimType;
import gnu.bytecode.Type;
import gnu.lists.FString;
import gnu.mapping.Symbol;
import gnu.mapping.Table2D;
import gnu.mapping.Values;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.IdentityHashMap;
import java.util.regex.Pattern;

// Referenced classes of package gnu.expr:
//            Compilation, Literal, StackTarget

public class LitTable
    implements ObjectOutput
{

    static Table2D staticTable = new Table2D(100);
    Compilation comp;
    IdentityHashMap literalTable;
    Literal literalsChain;
    int literalsCount;
    ClassType mainClass;
    int stackPointer;
    Type typeStack[];
    Object valueStack[];

    public LitTable(Compilation compilation)
    {
        literalTable = new IdentityHashMap(100);
        valueStack = new Object[20];
        typeStack = new Type[20];
        comp = compilation;
        mainClass = compilation.mainClass;
    }

    private void store(Literal literal, boolean flag, CodeAttr codeattr)
    {
        if (literal.field != null)
        {
            if (!flag)
            {
                codeattr.emitDup(literal.type);
            }
            codeattr.emitPutStatic(literal.field);
        }
        literal.flags = literal.flags | 8;
    }

    public void close()
    {
    }

    public void emit()
        throws IOException
    {
        for (Literal literal = literalsChain; literal != null; literal = literal.next)
        {
            writeObject(literal.value);
        }

        for (Literal literal1 = literalsChain; literal1 != null; literal1 = literal1.next)
        {
            emit(literal1, true);
        }

        literalTable = null;
        literalsCount = 0;
    }

    void emit(Literal literal, boolean flag)
    {
        CodeAttr codeattr = comp.getCode();
        if (literal.value != null) goto _L2; else goto _L1
_L1:
        if (!flag)
        {
            codeattr.emitPushNull();
        }
_L4:
        return;
_L2:
        if (literal.value instanceof String)
        {
            if (!flag)
            {
                codeattr.emitPushString(literal.value.toString());
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if ((literal.flags & 8) != 0)
        {
            if (!flag)
            {
                codeattr.emitGetStatic(literal.field);
                return;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (!(literal.value instanceof Object[]))
        {
            break; /* Loop/switch isn't completed */
        }
        int j = literal.argValues.length;
        Type type = ((ArrayType)literal.type).getComponentType();
        codeattr.emitPushInt(j);
        codeattr.emitNewArray(type);
        store(literal, flag, codeattr);
        int i = 0;
        while (i < j) 
        {
            Literal literal1 = (Literal)literal.argValues[i];
            if (literal1.value != null)
            {
                codeattr.emitDup(type);
                codeattr.emitPushInt(i);
                emit(literal1, false);
                codeattr.emitArrayStore(type);
            }
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (literal.type instanceof ArrayType)
        {
            codeattr.emitPushPrimArray(literal.value, (ArrayType)literal.type);
            store(literal, flag, codeattr);
            return;
        }
        if (literal.value instanceof Class)
        {
            Object obj = (Class)literal.value;
            if (((Class) (obj)).isPrimitive())
            {
                String s = ((Class) (obj)).getName();
                obj = s;
                if (s.equals("int"))
                {
                    obj = "integer";
                }
                codeattr.emitGetStatic(ClassType.make((new StringBuilder()).append("java.lang.").append(Character.toUpperCase(((String) (obj)).charAt(0))).append(((String) (obj)).substring(1)).toString()).getDeclaredField("TYPE"));
            } else
            {
                comp.loadClassRef((ObjectType)Type.make(((Class) (obj))));
            }
            store(literal, flag, codeattr);
            return;
        }
        if ((literal.value instanceof ClassType) && !((ClassType)literal.value).isExisting())
        {
            comp.loadClassRef((ClassType)literal.value);
            Method method1 = Compilation.typeType.getDeclaredMethod("valueOf", 1);
            Method method = method1;
            if (method1 == null)
            {
                method = Compilation.typeType.getDeclaredMethod("make", 1);
            }
            codeattr.emitInvokeStatic(method);
            codeattr.emitCheckcast(Compilation.typeClassType);
            store(literal, flag, codeattr);
            return;
        }
        ClassType classtype = (ClassType)literal.type;
        Object obj1;
        Object obj2;
        boolean flag1;
        boolean flag3;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        if ((literal.flags & 4) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj1 = null;
        obj2 = null;
        flag3 = false;
        flag5 = false;
        flag4 = flag1;
        if (!flag1)
        {
            obj1 = obj2;
            if (!(literal.value instanceof Symbol))
            {
                obj1 = getMethod(classtype, "valueOf", literal, true);
            }
            obj2 = obj1;
            if (obj1 == null)
            {
                obj2 = obj1;
                if (!(literal.value instanceof Values))
                {
                    obj1 = "make";
                    if (literal.value instanceof Pattern)
                    {
                        obj1 = "compile";
                    }
                    obj2 = getMethod(classtype, ((String) (obj1)), literal, true);
                }
            }
            boolean flag2;
            if (obj2 != null)
            {
                flag2 = true;
            } else
            {
                flag2 = flag5;
                if (literal.argTypes.length > 0)
                {
                    obj2 = getMethod(classtype, "<init>", literal, false);
                    flag2 = flag5;
                }
            }
            flag3 = flag2;
            obj1 = obj2;
            flag4 = flag1;
            if (obj2 == null)
            {
                flag4 = true;
                obj1 = obj2;
                flag3 = flag2;
            }
        }
        if (flag4)
        {
            obj1 = getMethod(classtype, "set", literal, false);
        }
        if (obj1 == null && literal.argTypes.length > 0)
        {
            error((new StringBuilder()).append("no method to construct ").append(literal.type).toString());
        }
        if (flag3)
        {
            putArgs(literal, codeattr);
            codeattr.emitInvokeStatic(((Method) (obj1)));
        } else
        if (flag4)
        {
            codeattr.emitNew(classtype);
            codeattr.emitDup(classtype);
            codeattr.emitInvokeSpecial(classtype.getDeclaredMethod("<init>", 0));
        } else
        {
            codeattr.emitNew(classtype);
            codeattr.emitDup(classtype);
            putArgs(literal, codeattr);
            codeattr.emitInvokeSpecial(((Method) (obj1)));
        }
        if (flag3 || (literal.value instanceof Values))
        {
            obj2 = null;
        } else
        {
            obj2 = classtype.getDeclaredMethod("readResolve", 0);
        }
        if (obj2 != null)
        {
            codeattr.emitInvokeVirtual(((Method) (obj2)));
            classtype.emitCoerceFromObject(codeattr);
        }
        if (flag && (!flag4 || obj1 == null))
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        store(literal, flag6, codeattr);
        if (flag4 && obj1 != null)
        {
            if (!flag)
            {
                codeattr.emitDup(classtype);
            }
            putArgs(literal, codeattr);
            codeattr.emitInvokeVirtual(((Method) (obj1)));
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    void error(String s)
    {
        throw new Error(s);
    }

    public Literal findLiteral(Object obj)
    {
        if (obj != null) goto _L2; else goto _L1
_L1:
        Literal literal = Literal.nullLiteral;
_L4:
        return literal;
_L2:
        Object obj1;
        obj1 = (Literal)literalTable.get(obj);
        literal = ((Literal) (obj1));
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        Class class1;
        Type type;
        if (comp.immediate)
        {
            return new Literal(obj, this);
        }
        class1 = obj.getClass();
        type = Type.make(class1);
        Table2D table2d = staticTable;
        table2d;
        JVM INSTR monitorenter ;
        literal = (Literal)staticTable.get(obj, null, null);
        if (literal == null) goto _L6; else goto _L5
_L5:
        obj1 = literal;
        if (literal.value == obj) goto _L7; else goto _L6
_L6:
        obj1 = literal;
        if (!(type instanceof ClassType)) goto _L7; else goto _L8
_L8:
        Object obj2 = (ClassType)type;
_L16:
        obj1 = literal;
        if (staticTable.get(class1, Boolean.TRUE, null) != null) goto _L7; else goto _L9
_L9:
        staticTable.put(class1, Boolean.TRUE, class1);
        obj1 = ((ClassType) (obj2)).getFields();
_L15:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_309;
        }
        int i = ((Field) (obj1)).getModifiers();
        obj2 = literal;
        if ((i & 0x19) != 25) goto _L11; else goto _L10
_L10:
        Object obj3 = ((Field) (obj1)).getReflectField().get(null);
        obj2 = literal;
        if (obj3 == null) goto _L11; else goto _L12
_L12:
        boolean flag = class1.isInstance(obj3);
        if (flag) goto _L14; else goto _L13
_L13:
        obj2 = literal;
_L11:
        obj1 = ((Field) (obj1)).getNext();
        literal = ((Literal) (obj2));
          goto _L15
_L14:
        Literal literal1;
        literal1 = new Literal(obj3, ((Field) (obj1)), this);
        staticTable.put(obj3, null, literal1);
        obj2 = literal;
        if (obj == obj3)
        {
            obj2 = literal1;
        }
          goto _L11
        obj2;
        error((new StringBuilder()).append("caught ").append(obj2).append(" getting static field ").append(obj1).toString());
        obj2 = literal;
          goto _L11
        obj;
        table2d;
        JVM INSTR monitorexit ;
        throw obj;
        class1 = class1.getSuperclass();
        if (class1 != null)
        {
            break MISSING_BLOCK_LABEL_342;
        }
        obj1 = literal;
_L7:
        table2d;
        JVM INSTR monitorexit ;
        if (obj1 != null)
        {
            literalTable.put(obj, obj1);
            return ((Literal) (obj1));
        } else
        {
            return new Literal(obj, type, this);
        }
        obj2 = (ClassType)Type.make(class1);
          goto _L16
    }

    public void flush()
    {
    }

    Method getMethod(ClassType classtype, String s, Literal literal, boolean flag)
    {
        Method method;
        Method method1;
        Type atype1[];
        Type atype3[];
        int l;
        int j2;
        long l3;
        atype3 = literal.argTypes;
        method1 = classtype.getDeclaredMethods();
        j2 = atype3.length;
        method = null;
        l3 = 0L;
        l = 0;
        atype1 = null;
_L5:
        if (method1 == null) goto _L2; else goto _L1
_L1:
        if (s.equals(method1.getName())) goto _L4; else goto _L3
_L3:
        Object obj;
        Object obj1;
        int i2;
        long l4;
        l4 = l3;
        obj1 = method;
        obj = atype1;
        i2 = l;
_L7:
        method1 = method1.getNext();
        l = i2;
        atype1 = ((Type []) (obj));
        method = ((Method) (obj1));
        l3 = l4;
          goto _L5
_L4:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (flag != method1.getStaticFlag()) goto _L7; else goto _L6
_L6:
        Type atype2[];
        int i;
        int i1;
        long l2;
        l2 = 0L;
        atype2 = method1.getParameterTypes();
        i = 0;
        i1 = 0;
_L21:
label0:
        {
            if (i != j2 || i1 != atype2.length)
            {
                break MISSING_BLOCK_LABEL_370;
            }
            if (method != null && (l3 == 0L || l2 != 0L))
            {
                break label0;
            }
            obj1 = method1;
            obj = atype2;
            i2 = l;
            l4 = l2;
        }
          goto _L7
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (l2 != 0L) goto _L7; else goto _L8
_L8:
        int k;
        i = 0;
        k = 0;
        i1 = j2;
_L15:
        i2 = i1 - 1;
        i1 = i;
        l = k;
        if (i2 < 0) goto _L10; else goto _L9
_L9:
        int k2;
        k2 = atype1[i2].compare(atype2[i2]);
        l = k;
        if (k2 == 1) goto _L12; else goto _L11
_L11:
        l = 1;
        k = 1;
        if (i == 0) goto _L12; else goto _L13
_L13:
        l = k;
        i1 = i;
_L10:
        if (i1 != 0)
        {
            method = method1;
            atype1 = atype2;
        }
        if (i1 != 0 && l)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i2 = i;
        obj = atype1;
        obj1 = method;
        l4 = l3;
          goto _L7
_L12:
        i1 = i2;
        k = l;
        if (k2 == -1) goto _L15; else goto _L14
_L14:
        k2 = 1;
        i = 1;
        i1 = i2;
        k = l;
        if (!l) goto _L15; else goto _L16
_L16:
        i1 = k2;
          goto _L10
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (i == j2) goto _L7; else goto _L17
_L17:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (i1 == atype2.length) goto _L7; else goto _L18
_L18:
        Type type1;
        Type type2;
        type1 = atype3[i];
        type2 = atype2[i1];
        if (!type1.isSubtype(type2)) goto _L20; else goto _L19
_L19:
        i++;
        i1++;
          goto _L21
_L20:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (!(type2 instanceof ArrayType)) goto _L7; else goto _L22
_L22:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (i1 >= 64) goto _L7; else goto _L23
_L23:
        if (type1 == Type.intType) goto _L25; else goto _L24
_L24:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (type1 != Type.shortType) goto _L7; else goto _L25
_L25:
        i2 = ((Number)literal.argValues[i]).intValue();
        k = i2;
        if (i2 < 0)
        {
            k = i2;
            if (classtype.getName().equals("gnu.math.IntNum"))
            {
                k = i2 + 0x80000000;
            }
        }
        type1 = ((ArrayType)type2).getComponentType();
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (k < 0) goto _L7; else goto _L26
_L26:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
        if (i + k >= j2) goto _L7; else goto _L27
_L27:
        i2 = k;
_L29:
        do
        {
            i2--;
            if (i2 < 0)
            {
                break MISSING_BLOCK_LABEL_737;
            }
            obj = atype3[i + i2 + 1];
            if (!(type1 instanceof PrimType))
            {
                continue; /* Loop/switch isn't completed */
            }
        } while (type1.getSignature() == ((Type) (obj)).getSignature());
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
          goto _L7
        if (((Type) (obj)).isSubtype(type1)) goto _L29; else goto _L28
_L28:
        i2 = l;
        obj = atype1;
        obj1 = method;
        l4 = l3;
          goto _L7
        i += k;
        l2 |= 1 << i1;
          goto _L19
_L2:
        if (!l) goto _L31; else goto _L30
_L30:
        s = null;
_L33:
        return s;
_L31:
        s = method;
        if (l3 == 0L) goto _L33; else goto _L32
_L32:
        Type atype[];
        s = ((String) (new Object[atype1.length]));
        atype = new Type[atype1.length];
        k = 0;
        l = 0;
_L35:
        if (k == j2)
        {
            literal.argValues = s;
            literal.argTypes = atype;
            return method;
        }
        obj1 = atype1[l];
        if (((long)(1 << l) & l3) != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        s[l] = literal.argValues[k];
        atype[l] = literal.argTypes[k];
_L36:
        k++;
        l++;
        if (true) goto _L35; else goto _L34
_L34:
        int j1 = ((Number)literal.argValues[k]).intValue();
        flag = classtype.getName().equals("gnu.math.IntNum");
        int j = j1;
        if (flag)
        {
            j = j1 + 0x80000000;
        }
        Type type = ((ArrayType)obj1).getComponentType();
        atype[l] = ((Type) (obj1));
        s[l] = Array.newInstance(type.getReflectClass(), j);
        Object aobj[] = literal.argValues;
        if (flag)
        {
            int ai[] = (int[])(int[])s[l];
            for (int k1 = j; k1 > 0; k1--)
            {
                ai[j - k1] = ((Integer)aobj[k + k1]).intValue();
            }

        } else
        {
            int l1 = j;
            do
            {
                l1--;
                if (l1 < 0)
                {
                    break;
                }
                Array.set(s[l], l1, aobj[k + 1 + l1]);
            } while (true);
        }
        obj1 = new Literal(s[l], ((Type) (obj1)));
        if (type instanceof ObjectType)
        {
            obj1.argValues = (Object[])(Object[])s[l];
        }
        s[l] = obj1;
        k += j;
          goto _L36
        if (true) goto _L35; else goto _L37
_L37:
          goto _L7
    }

    void push(Object obj, Type type)
    {
        if (stackPointer >= valueStack.length)
        {
            Object aobj[] = new Object[valueStack.length * 2];
            Type atype[] = new Type[typeStack.length * 2];
            System.arraycopy(((Object) (valueStack)), 0, ((Object) (aobj)), 0, stackPointer);
            System.arraycopy(typeStack, 0, atype, 0, stackPointer);
            valueStack = aobj;
            typeStack = atype;
        }
        valueStack[stackPointer] = obj;
        typeStack[stackPointer] = type;
        stackPointer = stackPointer + 1;
    }

    void putArgs(Literal literal, CodeAttr codeattr)
    {
        codeattr = literal.argTypes;
        int j = codeattr.length;
        int i = 0;
        while (i < j) 
        {
            Object obj = literal.argValues[i];
            if (obj instanceof Literal)
            {
                emit((Literal)obj, false);
            } else
            {
                comp.compileConstant(obj, new StackTarget(codeattr[i]));
            }
            i++;
        }
    }

    public void write(int i)
        throws IOException
    {
        error("cannot handle call to write(int) when externalizing literal");
    }

    public void write(byte abyte0[])
        throws IOException
    {
        error("cannot handle call to write(byte[]) when externalizing literal");
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        error("cannot handle call to write(byte[],int,int) when externalizing literal");
    }

    public void writeBoolean(boolean flag)
    {
        push(new Boolean(flag), Type.booleanType);
    }

    public void writeByte(int i)
    {
        push(new Byte((byte)i), Type.byteType);
    }

    public void writeBytes(String s)
        throws IOException
    {
        error("cannot handle call to writeBytes(String) when externalizing literal");
    }

    public void writeChar(int i)
    {
        push(new Character((char)i), Type.charType);
    }

    public void writeChars(String s)
    {
        push(s, Type.string_type);
    }

    public void writeDouble(double d)
    {
        push(new Double(d), Type.doubleType);
    }

    public void writeFloat(float f)
    {
        push(new Float(f), Type.floatType);
    }

    public void writeInt(int i)
    {
        push(new Integer(i), Type.intType);
    }

    public void writeLong(long l)
    {
        push(new Long(l), Type.longType);
    }

    public void writeObject(Object obj)
        throws IOException
    {
        Literal literal = findLiteral(obj);
        if ((literal.flags & 3) == 0) goto _L2; else goto _L1
_L1:
        if (literal.field == null && obj != null && !(obj instanceof String))
        {
            literal.assign(this);
        }
        if ((literal.flags & 2) == 0)
        {
            literal.flags = literal.flags | 4;
        }
_L5:
        push(literal, literal.type);
        return;
_L2:
        int j;
        literal.flags = literal.flags | 1;
        j = stackPointer;
        if (!(obj instanceof FString) || ((FString)obj).size() >= 65535) goto _L4; else goto _L3
_L3:
        push(obj.toString(), Type.string_type);
_L6:
        int i = stackPointer - j;
        if (i == 0)
        {
            literal.argValues = Values.noArgs;
            literal.argTypes = Type.typeArray0;
        } else
        {
            literal.argValues = new Object[i];
            literal.argTypes = new Type[i];
            System.arraycopy(((Object) (valueStack)), j, ((Object) (literal.argValues)), 0, i);
            System.arraycopy(typeStack, j, literal.argTypes, 0, i);
            stackPointer = j;
        }
        literal.flags = literal.flags | 2;
        if (true) goto _L5; else goto _L4
_L4:
        if (obj instanceof Externalizable)
        {
            ((Externalizable)obj).writeExternal(this);
        } else
        if (obj instanceof Object[])
        {
            obj = ((Object) ((Object[])(Object[])obj));
            i = 0;
            while (i < obj.length) 
            {
                writeObject(obj[i]);
                i++;
            }
        } else
        if (obj != null && !(obj instanceof String) && !(literal.type instanceof ArrayType))
        {
            if (obj instanceof BigInteger)
            {
                writeChars(obj.toString());
            } else
            if (obj instanceof BigDecimal)
            {
                obj = (BigDecimal)obj;
                writeObject(((BigDecimal) (obj)).unscaledValue());
                writeInt(((BigDecimal) (obj)).scale());
            } else
            if (obj instanceof Integer)
            {
                push(obj, Type.intType);
            } else
            if (obj instanceof Short)
            {
                push(obj, Type.shortType);
            } else
            if (obj instanceof Byte)
            {
                push(obj, Type.byteType);
            } else
            if (obj instanceof Long)
            {
                push(obj, Type.longType);
            } else
            if (obj instanceof Double)
            {
                push(obj, Type.doubleType);
            } else
            if (obj instanceof Float)
            {
                push(obj, Type.floatType);
            } else
            if (obj instanceof Character)
            {
                push(obj, Type.charType);
            } else
            if (obj instanceof Class)
            {
                push(obj, Type.java_lang_Class_type);
            } else
            if (obj instanceof Pattern)
            {
                obj = (Pattern)obj;
                push(((Pattern) (obj)).pattern(), Type.string_type);
                push(Integer.valueOf(((Pattern) (obj)).flags()), Type.intType);
            } else
            {
                error((new StringBuilder()).append(obj.getClass().getName()).append(" does not implement Externalizable").toString());
            }
        }
          goto _L6
    }

    public void writeShort(int i)
    {
        push(new Short((short)i), Type.shortType);
    }

    public void writeUTF(String s)
    {
        push(s, Type.string_type);
    }

}
