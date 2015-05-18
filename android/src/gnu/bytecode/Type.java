// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import gnu.kawa.util.AbstractWeakHashTable;
import java.io.PrintWriter;
import java.util.HashMap;

// Referenced classes of package gnu.bytecode:
//            PrimType, ObjectType, ClassType, Method, 
//            ArrayType, CodeAttr

public abstract class Type
    implements java.lang.reflect.Type
{
    static class ClassToTypeMap extends AbstractWeakHashTable
    {

        protected Class getKeyFromValue(Type type)
        {
            return type.reflectClass;
        }

        protected volatile Object getKeyFromValue(Object obj)
        {
            return getKeyFromValue((Type)obj);
        }

        protected boolean matches(Class class1, Class class2)
        {
            return class1 == class2;
        }

        ClassToTypeMap()
        {
        }
    }


    public static final PrimType booleanType;
    public static final Method booleanValue_method;
    public static final ClassType boolean_ctype;
    public static final PrimType boolean_type;
    public static final PrimType byteType;
    public static final PrimType byte_type;
    public static final PrimType charType;
    public static final PrimType char_type;
    public static final Method clone_method;
    public static final PrimType doubleType;
    public static final Method doubleValue_method;
    public static final PrimType double_type;
    public static final ObjectType errorType = new ClassType("(error type)");
    public static final PrimType floatType;
    public static final Method floatValue_method;
    public static final PrimType float_type;
    public static final PrimType intType;
    public static final Method intValue_method;
    public static final PrimType int_type;
    public static final ClassType java_lang_Class_type;
    public static final ClassType javalangBooleanType;
    public static final ClassType javalangClassType;
    public static final ClassType javalangNumberType;
    public static final ClassType javalangObjectType;
    public static ClassType javalangStringType;
    public static final ClassType javalangThrowableType;
    public static final PrimType longType;
    public static final Method longValue_method;
    public static final PrimType long_type;
    static ClassToTypeMap mapClassToType;
    static HashMap mapNameToType;
    public static final PrimType neverReturnsType;
    public static final ObjectType nullType = new ObjectType("(type of null)");
    public static final ClassType number_type;
    public static final ClassType objectType;
    public static final ClassType pointer_type;
    public static final PrimType shortType;
    public static final PrimType short_type;
    public static final ClassType string_type;
    public static final ClassType throwable_type;
    public static final ClassType toStringType;
    public static final Method toString_method;
    public static final ClassType tostring_type;
    public static final Type typeArray0[];
    public static final PrimType voidType;
    public static final PrimType void_type;
    ArrayType array_type;
    protected Class reflectClass;
    String signature;
    int size;
    String this_name;

    protected Type()
    {
    }

    public Type(Type type)
    {
        this_name = type.this_name;
        signature = type.signature;
        size = type.size;
        reflectClass = type.reflectClass;
    }

    Type(String s, String s1)
    {
        this_name = s;
        signature = s1;
    }

    public static Type getType(String s)
    {
        HashMap hashmap = mapNameToType;
        hashmap;
        JVM INSTR monitorenter ;
        Type type = (Type)hashmap.get(s);
        Object obj = type;
        if (type != null) goto _L2; else goto _L1
_L1:
        if (!s.endsWith("[]"))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = ArrayType.make(s);
_L3:
        hashmap.put(s, obj);
_L2:
        hashmap;
        JVM INSTR monitorexit ;
        return ((Type) (obj));
        obj = new ClassType(s);
        obj.flags = ((ClassType) (obj)).flags | 0x10;
          goto _L3
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static boolean isMoreSpecific(Type atype[], Type atype1[])
    {
        if (atype.length != atype1.length)
        {
            return false;
        }
        int i = atype.length;
        do
        {
            int j = i - 1;
            if (j >= 0)
            {
                i = j;
                if (!atype[j].isSubtype(atype1[j]))
                {
                    return false;
                }
            } else
            {
                return true;
            }
        } while (true);
    }

    public static boolean isValidJavaTypeName(String s)
    {
_L2:
        return false;
        boolean flag = false;
        int i;
        for (i = s.length(); i > 2 && s.charAt(i - 1) == ']' && s.charAt(i - 2) == '['; i -= 2) { }
        int j = 0;
        while (j < i) 
        {
            char c = s.charAt(j);
            if (c == '.')
            {
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_103;
                }
                flag = false;
            } else
            if (flag ? Character.isJavaIdentifierPart(c) : Character.isJavaIdentifierStart(c))
            {
                flag = true;
            } else
            {
                break MISSING_BLOCK_LABEL_103;
            }
            j++;
        }
        if (j == i)
        {
            return true;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static Type lookupType(String s)
    {
        synchronized (mapNameToType)
        {
            s = (Type)hashmap.get(s);
        }
        return s;
        s;
        hashmap;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static Type lowestCommonSuperType(Type type, Type type1)
    {
        if (type != neverReturnsType) goto _L2; else goto _L1
_L1:
        Type type2 = type1;
_L4:
        return type2;
_L2:
        type2 = type;
        if (type1 == neverReturnsType)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (type == null || type1 == null)
        {
            return null;
        }
        if (!(type instanceof PrimType) || !(type1 instanceof PrimType))
        {
            break; /* Loop/switch isn't completed */
        }
        type2 = type;
        if (type != type1)
        {
            type = ((PrimType)type).promotedType();
            type2 = type;
            if (type != ((PrimType)type1).promotedType())
            {
                return null;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (type.isSubtype(type1))
        {
            return type1;
        }
        type2 = type;
        if (!type1.isSubtype(type))
        {
            if (!(type instanceof ClassType) || !(type1 instanceof ClassType))
            {
                return objectType;
            }
            type = (ClassType)type;
            type1 = (ClassType)type1;
            if (type.isInterface() || type1.isInterface())
            {
                return objectType;
            } else
            {
                return lowestCommonSuperType(((Type) (type.getSuperclass())), ((Type) (type1.getSuperclass())));
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static Type make(Class class1)
    {
        gnu/bytecode/Type;
        JVM INSTR monitorenter ;
        if (mapClassToType == null) goto _L2; else goto _L1
_L1:
        Object obj = (Type)mapClassToType.get(class1);
        if (obj == null) goto _L2; else goto _L3
_L3:
        class1 = ((Class) (obj));
_L6:
        gnu/bytecode/Type;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        if (!class1.isArray()) goto _L5; else goto _L4
_L4:
        obj = ArrayType.make(make(class1.getComponentType()));
_L7:
        registerTypeForClass(class1, ((Type) (obj)));
        class1 = ((Class) (obj));
          goto _L6
_L5:
        if (class1.isPrimitive())
        {
            throw new Error("internal error - primitive type not found");
        }
        break MISSING_BLOCK_LABEL_83;
        class1;
        gnu/bytecode/Type;
        JVM INSTR monitorexit ;
        throw class1;
        String s = class1.getName();
        HashMap hashmap = mapNameToType;
        hashmap;
        JVM INSTR monitorenter ;
        Type type = (Type)hashmap.get(s);
        if (type == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj = type;
        if (type.reflectClass == class1)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj = type;
        if (type.reflectClass == null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        obj = new ClassType(s);
        obj.flags = ((ClassType) (obj)).flags | 0x10;
        mapNameToType.put(s, obj);
        hashmap;
        JVM INSTR monitorexit ;
          goto _L7
        class1;
        hashmap;
        JVM INSTR monitorexit ;
        throw class1;
          goto _L6
    }

    public static void printSignature(String s, int i, int j, PrintWriter printwriter)
    {
        if (j != 0)
        {
            char c = s.charAt(i);
            if (j == 1)
            {
                s = signatureToPrimitive(c);
                if (s != null)
                {
                    printwriter.print(s.getName());
                    return;
                }
            } else
            {
                if (c == '[')
                {
                    printSignature(s, i + 1, j - 1, printwriter);
                    printwriter.print("[]");
                    return;
                }
                if (c == 'L' && j > 2 && s.indexOf(';', i) == (j - 1) + i)
                {
                    printwriter.print(s.substring(i + 1, (j - 1) + i).replace('/', '.'));
                    return;
                } else
                {
                    printwriter.append(s, i, j - i);
                    return;
                }
            }
        }
    }

    public static void registerTypeForClass(Class class1, Type type)
    {
        gnu/bytecode/Type;
        JVM INSTR monitorenter ;
        ClassToTypeMap classtotypemap1 = mapClassToType;
        ClassToTypeMap classtotypemap;
        classtotypemap = classtotypemap1;
        if (classtotypemap1 != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        classtotypemap = new ClassToTypeMap();
        mapClassToType = classtotypemap;
        type.reflectClass = class1;
        classtotypemap.put(class1, type);
        gnu/bytecode/Type;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    public static int signatureLength(String s)
    {
        return signatureLength(s, 0);
    }

    public static int signatureLength(String s, int i)
    {
        if (s.length() > i)
        {
            char c = s.charAt(i);
            int j = 0;
            for (; c == '['; c = s.charAt(i))
            {
                j++;
                i++;
            }

            if (signatureToPrimitive(c) != null)
            {
                return j + 1;
            }
            if (c == 'L')
            {
                int k = s.indexOf(';', i);
                if (k > 0)
                {
                    return (j + k + 1) - i;
                }
            }
        }
        return -1;
    }

    public static String signatureToName(String s)
    {
        int j = s.length();
        if (j != 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        char c;
        int i;
        c = s.charAt(0);
        if (j == 1)
        {
            PrimType primtype = signatureToPrimitive(c);
            if (primtype != null)
            {
                return primtype.getName();
            }
        }
        if (c != '[')
        {
            continue; /* Loop/switch isn't completed */
        }
        boolean flag = true;
        i = ((flag) ? 1 : 0);
        if (1 < j)
        {
            i = ((flag) ? 1 : 0);
            if (s.charAt(1) == '[')
            {
                i = 1 + 1;
            }
        }
        s = signatureToName(s.substring(i));
        if (s == null) goto _L1; else goto _L3
_L3:
        StringBuffer stringbuffer = new StringBuffer(50);
        stringbuffer.append(s);
        do
        {
            i--;
            if (i >= 0)
            {
                stringbuffer.append("[]");
            } else
            {
                return stringbuffer.toString();
            }
        } while (true);
        if (c != 'L' || j <= 2 || s.indexOf(';') != j - 1) goto _L1; else goto _L4
_L4:
        return s.substring(1, j - 1).replace('/', '.');
    }

    public static PrimType signatureToPrimitive(char c)
    {
        switch (c)
        {
        default:
            return null;

        case 66: // 'B'
            return byteType;

        case 67: // 'C'
            return charType;

        case 68: // 'D'
            return doubleType;

        case 70: // 'F'
            return floatType;

        case 83: // 'S'
            return shortType;

        case 73: // 'I'
            return intType;

        case 74: // 'J'
            return longType;

        case 90: // 'Z'
            return booleanType;

        case 86: // 'V'
            return voidType;
        }
    }

    public static Type signatureToType(String s)
    {
        return signatureToType(s, 0, s.length());
    }

    public static Type signatureToType(String s, int i, int j)
    {
        if (j != 0) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        char c;
        c = s.charAt(i);
        if (j == 1)
        {
            PrimType primtype = signatureToPrimitive(c);
            if (primtype != null)
            {
                return primtype;
            }
        }
        if (c != '[')
        {
            continue; /* Loop/switch isn't completed */
        }
        s = signatureToType(s, i + 1, j - 1);
        if (s == null) goto _L1; else goto _L3
_L3:
        return ArrayType.make(s);
        if (c != 'L' || j <= 2 || s.indexOf(';', i) != (j - 1) + i) goto _L1; else goto _L4
_L4:
        return ClassType.make(s.substring(i + 1, (j - 1) + i).replace('/', '.'));
    }

    protected static int swappedCompareResult(int i)
    {
        int j;
        if (i == 1)
        {
            j = -1;
        } else
        {
            j = i;
            if (i == -1)
            {
                return 1;
            }
        }
        return j;
    }

    public abstract Object coerceFromObject(Object obj);

    public Object coerceToObject(Object obj)
    {
        return obj;
    }

    public abstract int compare(Type type);

    public void emitCoerceFromObject(CodeAttr codeattr)
    {
        throw new Error((new StringBuilder()).append("unimplemented emitCoerceFromObject for ").append(this).toString());
    }

    public void emitCoerceToObject(CodeAttr codeattr)
    {
    }

    public void emitConvertFromPrimitive(Type type, CodeAttr codeattr)
    {
        type.emitCoerceToObject(codeattr);
    }

    public void emitIsInstance(CodeAttr codeattr)
    {
        codeattr.emitInstanceof(this);
    }

    public Type getImplementationType()
    {
        return this;
    }

    public final String getName()
    {
        return this_name;
    }

    public Type getRealType()
    {
        return this;
    }

    public Class getReflectClass()
    {
        return reflectClass;
    }

    public String getSignature()
    {
        return signature;
    }

    public final int getSize()
    {
        return size;
    }

    public int getSizeInWords()
    {
        return size <= 4 ? 1 : 2;
    }

    public int hashCode()
    {
        String s = toString();
        if (s == null)
        {
            return 0;
        } else
        {
            return s.hashCode();
        }
    }

    public boolean isExisting()
    {
        return true;
    }

    public boolean isInstance(Object obj)
    {
        return getReflectClass().isInstance(obj);
    }

    public final boolean isSubtype(Type type)
    {
        int i = compare(type);
        return i == -1 || i == 0;
    }

    public final boolean isVoid()
    {
        return size == 0;
    }

    public Type promote()
    {
        Object obj = this;
        if (size < 4)
        {
            obj = intType;
        }
        return ((Type) (obj));
    }

    protected void setName(String s)
    {
        this_name = s;
    }

    public void setReflectClass(Class class1)
    {
        reflectClass = class1;
    }

    protected void setSignature(String s)
    {
        signature = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Type ").append(getName()).toString();
    }

    static 
    {
        byteType = new PrimType("byte", "B", 1, Byte.TYPE);
        shortType = new PrimType("short", "S", 2, Short.TYPE);
        intType = new PrimType("int", "I", 4, Integer.TYPE);
        longType = new PrimType("long", "J", 8, Long.TYPE);
        floatType = new PrimType("float", "F", 4, Float.TYPE);
        doubleType = new PrimType("double", "D", 8, Double.TYPE);
        booleanType = new PrimType("boolean", "Z", 1, Boolean.TYPE);
        charType = new PrimType("char", "C", 2, Character.TYPE);
        voidType = new PrimType("void", "V", 0, Void.TYPE);
        byte_type = byteType;
        short_type = shortType;
        int_type = intType;
        long_type = longType;
        float_type = floatType;
        double_type = doubleType;
        boolean_type = booleanType;
        char_type = charType;
        void_type = voidType;
        mapNameToType = new HashMap();
        mapNameToType.put("byte", byteType);
        mapNameToType.put("short", shortType);
        mapNameToType.put("int", intType);
        mapNameToType.put("long", longType);
        mapNameToType.put("float", floatType);
        mapNameToType.put("double", doubleType);
        mapNameToType.put("boolean", booleanType);
        mapNameToType.put("char", charType);
        mapNameToType.put("void", voidType);
        neverReturnsType = new PrimType(voidType);
        neverReturnsType.this_name = "(never-returns)";
        javalangStringType = ClassType.make("java.lang.String");
        toStringType = new ClassType("java.lang.String");
        javalangObjectType = ClassType.make("java.lang.Object");
        objectType = javalangObjectType;
        javalangBooleanType = ClassType.make("java.lang.Boolean");
        javalangThrowableType = ClassType.make("java.lang.Throwable");
        typeArray0 = new Type[0];
        toString_method = objectType.getDeclaredMethod("toString", 0);
        javalangNumberType = ClassType.make("java.lang.Number");
        clone_method = Method.makeCloneMethod(objectType);
        intValue_method = javalangNumberType.addMethod("intValue", typeArray0, intType, 1);
        longValue_method = javalangNumberType.addMethod("longValue", typeArray0, longType, 1);
        floatValue_method = javalangNumberType.addMethod("floatValue", typeArray0, floatType, 1);
        doubleValue_method = javalangNumberType.addMethod("doubleValue", typeArray0, doubleType, 1);
        booleanValue_method = javalangBooleanType.addMethod("booleanValue", typeArray0, booleanType, 1);
        javalangClassType = ClassType.make("java.lang.Class");
        pointer_type = javalangObjectType;
        string_type = javalangStringType;
        tostring_type = toStringType;
        java_lang_Class_type = javalangClassType;
        boolean_ctype = javalangBooleanType;
        throwable_type = javalangThrowableType;
        number_type = javalangNumberType;
    }
}
