// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.Externalizable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

// Referenced classes of package gnu.bytecode:
//            ObjectType, AttrContainer, Member, Type, 
//            Field, Method, ConstantPool, CpoolClass, 
//            EnclosingMethodAttr, InnerClassesAttr, Attribute, Filter, 
//            SourceDebugExtAttr, SourceFileAttr, CpoolEntry

public class ClassType extends ObjectType
    implements AttrContainer, Externalizable, Member
{
    static class AbstractMethodFilter
        implements Filter
    {

        public static final AbstractMethodFilter instance = new AbstractMethodFilter();

        public boolean select(Object obj)
        {
            return ((gnu.bytecode.Method)obj).isAbstract();
        }


        AbstractMethodFilter()
        {
        }
    }


    public static final int JDK_1_1_VERSION = 0x2d0003;
    public static final int JDK_1_2_VERSION = 0x2e0000;
    public static final int JDK_1_3_VERSION = 0x2f0000;
    public static final int JDK_1_4_VERSION = 0x300000;
    public static final int JDK_1_5_VERSION = 0x310000;
    public static final int JDK_1_6_VERSION = 0x320000;
    public static final int JDK_1_7_VERSION = 0x330000;
    public static final ClassType noClasses[] = new ClassType[0];
    int Code_name_index;
    int ConstantValue_name_index;
    int LineNumberTable_name_index;
    int LocalVariableTable_name_index;
    int access_flags;
    Attribute attributes;
    int classfileFormatVersion;
    ConstantPool constants;
    public gnu.bytecode.Method constructor;
    boolean emitDebugInfo;
    Member enclosingMember;
    gnu.bytecode.Field fields;
    int fields_count;
    ClassType firstInnerClass;
    int interfaceIndexes[];
    ClassType interfaces[];
    gnu.bytecode.Field last_field;
    gnu.bytecode.Method last_method;
    gnu.bytecode.Method methods;
    int methods_count;
    ClassType nextInnerClass;
    SourceDebugExtAttr sourceDbgExt;
    ClassType superClass;
    int superClassIndex;
    int thisClassIndex;

    public ClassType()
    {
        classfileFormatVersion = 0x2d0003;
        superClassIndex = -1;
        emitDebugInfo = true;
    }

    public ClassType(String s)
    {
        classfileFormatVersion = 0x2d0003;
        superClassIndex = -1;
        emitDebugInfo = true;
        setName(s);
    }

    public static ClassType make(String s)
    {
        return (ClassType)Type.getType(s);
    }

    public static ClassType make(String s, ClassType classtype)
    {
        s = make(s);
        if (((ClassType) (s)).superClass == null)
        {
            s.setSuper(classtype);
        }
        return s;
    }

    public static byte[] to_utf8(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L4:
        return abyte0;
_L2:
        int j1 = s.length();
        int i = 0;
        int j = 0;
        while (j < j1) 
        {
            char c = s.charAt(j);
            if (c > 0 && c <= '\177')
            {
                i++;
            } else
            if (c <= '\u07FF')
            {
                i += 2;
            } else
            {
                i += 3;
            }
            j++;
        }
        byte abyte1[] = new byte[i];
        j = 0;
        i = 0;
        do
        {
            abyte0 = abyte1;
            if (j >= j1)
            {
                continue;
            }
            char c1 = s.charAt(j);
            if (c1 > 0 && c1 <= '\177')
            {
                int k = i + 1;
                abyte1[i] = (byte)c1;
                i = k;
            } else
            if (c1 <= '\u07FF')
            {
                int l = i + 1;
                abyte1[i] = (byte)(c1 >> 6 & 0x1f | 0xc0);
                abyte1[l] = (byte)(c1 >> 0 & 0x3f | 0x80);
                i = l + 1;
            } else
            {
                int i1 = i + 1;
                abyte1[i] = (byte)(c1 >> 12 & 0xf | 0xe0);
                int k1 = i1 + 1;
                abyte1[i1] = (byte)(c1 >> 6 & 0x3f | 0x80);
                i = k1 + 1;
                abyte1[k1] = (byte)(c1 >> 0 & 0x3f | 0x80);
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    void addEnclosingMember()
    {
        this;
        JVM INSTR monitorenter ;
        int i = flags;
        if ((i & 0x18) == 16) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        Object obj1;
        obj1 = getReflectClass();
        flags = flags | 8;
        obj = ((Class) (obj1)).getEnclosingClass();
        if (obj == null) goto _L1; else goto _L3
_L3:
        Method method;
        if (((Class) (obj1)).isMemberClass())
        {
            break MISSING_BLOCK_LABEL_100;
        }
        method = ((Class) (obj1)).getEnclosingMethod();
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        enclosingMember = addMethod(method);
          goto _L1
        obj;
        throw obj;
        obj1 = ((Class) (obj1)).getEnclosingConstructor();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        enclosingMember = addMethod(((Constructor) (obj1)));
          goto _L1
        enclosingMember = (ClassType)Type.make(((Class) (obj)));
          goto _L1
    }

    public gnu.bytecode.Field addField()
    {
        return new gnu.bytecode.Field(this);
    }

    public gnu.bytecode.Field addField(String s)
    {
        gnu.bytecode.Field field = new gnu.bytecode.Field(this);
        field.setName(s);
        return field;
    }

    public final gnu.bytecode.Field addField(String s, Type type)
    {
        gnu.bytecode.Field field = new gnu.bytecode.Field(this);
        field.setName(s);
        field.setType(type);
        return field;
    }

    public final gnu.bytecode.Field addField(String s, Type type, int i)
    {
        s = addField(s, type);
        s.flags = i;
        return s;
    }

    public void addFields()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1 = getReflectClass();
        Field afield[] = ((Class) (obj1)).getDeclaredFields();
_L3:
        int j = afield.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = afield[i];
        if ("this$0".equals(((Field) (obj1)).getName()))
        {
            flags = flags | 0x20;
        }
        addField(((Field) (obj1)).getName(), Type.make(((Field) (obj1)).getType()), ((Field) (obj1)).getModifiers());
        i++;
        if (true) goto _L2; else goto _L1
        Object obj;
        obj;
        obj = ((Class) (obj1)).getFields();
          goto _L3
_L1:
        flags = flags | 1;
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public void addInterface(ClassType classtype)
    {
        if (interfaces != null && interfaces.length != 0) goto _L2; else goto _L1
_L1:
        int i;
        i = 0;
        interfaces = new ClassType[1];
_L4:
        interfaces[i] = classtype;
        return;
_L2:
        i = interfaces.length;
        int j = i;
        do
        {
            int k = j - 1;
            if (k < 0)
            {
                break;
            }
            j = k;
            if (interfaces[k] == classtype)
            {
                return;
            }
        } while (true);
        ClassType aclasstype[] = new ClassType[i + 1];
        System.arraycopy(interfaces, 0, aclasstype, 0, i);
        interfaces = aclasstype;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void addMemberClass(ClassType classtype)
    {
        ClassType classtype2 = null;
        for (ClassType classtype1 = firstInnerClass; classtype1 != null; classtype1 = classtype1.nextInnerClass)
        {
            if (classtype1 == classtype)
            {
                return;
            }
            classtype2 = classtype1;
        }

        if (classtype2 == null)
        {
            firstInnerClass = classtype;
            return;
        } else
        {
            classtype2.nextInnerClass = classtype;
            return;
        }
    }

    public void addMemberClasses()
    {
        this;
        JVM INSTR monitorenter ;
        int i = flags;
        if ((i & 0x14) == 16) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Class aclass[];
        int j;
        Class class1 = getReflectClass();
        flags = flags | 4;
        aclass = class1.getClasses();
        j = aclass.length;
        if (j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 0;
_L4:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        addMemberClass((ClassType)Type.make(aclass[i]));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L1; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    gnu.bytecode.Method addMethod()
    {
        return new gnu.bytecode.Method(this, 0);
    }

    public gnu.bytecode.Method addMethod(String s)
    {
        return addMethod(s, 0);
    }

    public gnu.bytecode.Method addMethod(String s, int i)
    {
        gnu.bytecode.Method method = new gnu.bytecode.Method(this, i);
        method.setName(s);
        return method;
    }

    public gnu.bytecode.Method addMethod(String s, int i, Type atype[], Type type)
    {
        this;
        JVM INSTR monitorenter ;
        gnu.bytecode.Method method = getDeclaredMethod(s, atype);
        if (method == null) goto _L2; else goto _L1
_L1:
        if (!type.equals(method.getReturnType())) goto _L2; else goto _L3
_L3:
        int j = method.access_flags;
        if ((j & i) != i) goto _L2; else goto _L4
_L4:
        s = method;
_L6:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = addMethod(s, i);
        s.arg_types = atype;
        s.return_type = type;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public gnu.bytecode.Method addMethod(String s, String s1, int i)
    {
        s = addMethod(s, i);
        s.setSignature(s1);
        return s;
    }

    public gnu.bytecode.Method addMethod(String s, Type atype[], Type type, int i)
    {
        return addMethod(s, i, atype, type);
    }

    public gnu.bytecode.Method addMethod(Constructor constructor1)
    {
        Class aclass[] = constructor1.getParameterTypes();
        int j = constructor1.getModifiers();
        int i = aclass.length;
        constructor1 = new Type[i];
        do
        {
            i--;
            if (i >= 0)
            {
                constructor1[i] = Type.make(aclass[i]);
            } else
            {
                return addMethod("<init>", j, ((Type []) (constructor1)), ((Type) (Type.voidType)));
            }
        } while (true);
    }

    public gnu.bytecode.Method addMethod(Method method)
    {
        int j = method.getModifiers();
        Class aclass[] = method.getParameterTypes();
        int i = aclass.length;
        Type atype[] = new Type[i];
        do
        {
            i--;
            if (i >= 0)
            {
                atype[i] = Type.make(aclass[i]);
            } else
            {
                Type type = Type.make(method.getReturnType());
                return addMethod(method.getName(), j, atype, type);
            }
        } while (true);
    }

    public void addMethods(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        flags = flags | 2;
        Object aobj[] = class1.getDeclaredMethods();
_L1:
        int j = aobj.length;
        int i;
        SecurityException securityexception;
        Object obj;
        for (i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_73;
        }

        obj = aobj[i];
        if (!((Method) (obj)).getDeclaringClass().equals(class1))
        {
            break MISSING_BLOCK_LABEL_132;
        }
        break MISSING_BLOCK_LABEL_59;
        securityexception;
        securityexception = class1.getMethods();
          goto _L1
        addMethod(((Method) (obj)));
        break MISSING_BLOCK_LABEL_132;
        class1;
        throw class1;
        securityexception = class1.getDeclaredConstructors();
_L2:
        j = securityexception.length;
        for (i = 0; i >= j; i++)
        {
            break MISSING_BLOCK_LABEL_130;
        }

        obj = securityexception[i];
        if (!((Constructor) (obj)).getDeclaringClass().equals(class1))
        {
            break MISSING_BLOCK_LABEL_141;
        }
        break MISSING_BLOCK_LABEL_120;
        securityexception;
        securityexception = class1.getConstructors();
          goto _L2
        addMethod(((Constructor) (obj)));
        break MISSING_BLOCK_LABEL_141;
    }

    public final void addModifiers(int i)
    {
        access_flags = access_flags | i;
    }

    public gnu.bytecode.Method checkSingleAbstractMethod()
    {
        gnu.bytecode.Method method;
        gnu.bytecode.Method amethod[];
        int i;
        int j;
        amethod = getAbstractMethods();
        j = amethod.length;
        method = null;
        i = 0;
_L5:
        gnu.bytecode.Method method1 = method;
        if (i >= j) goto _L2; else goto _L1
_L1:
        gnu.bytecode.Method method2;
        method1 = amethod[i];
        method2 = getMethod(method1.getName(), method1.getParameterTypes());
        if (method2 == null || method2.isAbstract()) goto _L4; else goto _L3
_L3:
        i++;
          goto _L5
_L4:
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        method1 = null;
_L2:
        return method1;
        method = method1;
          goto _L3
    }

    public void cleanupAfterCompilation()
    {
        for (gnu.bytecode.Method method = methods; method != null; method = method.getNext())
        {
            method.cleanupAfterCompilation();
        }

        constants = null;
        attributes = null;
        sourceDbgExt = null;
    }

    public int compare(Type type)
    {
        byte byte0 = -1;
        if (type != nullType) goto _L2; else goto _L1
_L1:
        return 1;
_L2:
        if (!(type instanceof ClassType))
        {
            return swappedCompareResult(type.compare(this));
        }
        String s = getName();
        if (s != null && s.equals(type.getName()))
        {
            return 0;
        }
        type = (ClassType)type;
        if (isSubclass(type))
        {
            return -1;
        }
        if (type.isSubclass(this))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (this == toStringType)
        {
            if (type != Type.javalangObjectType)
            {
                byte0 = 1;
            }
            return byte0;
        }
        if (type != toStringType)
        {
            break; /* Loop/switch isn't completed */
        }
        if (this != Type.javalangObjectType)
        {
            return -1;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (isInterface())
        {
            if (type != Type.javalangObjectType)
            {
                byte0 = -2;
            }
            return byte0;
        }
        if (type.isInterface())
        {
            if (this != Type.javalangObjectType)
            {
                return -2;
            }
        } else
        {
            return -3;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public final int countMethods(Filter filter, int i)
    {
        Vector vector = new Vector();
        getMethods(filter, i, vector);
        return vector.size();
    }

    public void doFixups()
    {
        if (constants == null)
        {
            constants = new ConstantPool();
        }
        if (thisClassIndex == 0)
        {
            thisClassIndex = constants.addClass(this).index;
        }
        if (superClass == this)
        {
            setSuper((ClassType)null);
        }
        if (superClassIndex < 0)
        {
            int i;
            int k;
            if (superClass == null)
            {
                i = 0;
            } else
            {
                i = constants.addClass(superClass).index;
            }
            superClassIndex = i;
        }
        if (interfaces != null && interfaceIndexes == null)
        {
            k = interfaces.length;
            interfaceIndexes = new int[k];
            for (i = 0; i < k; i++)
            {
                interfaceIndexes[i] = constants.addClass(interfaces[i]).index;
            }

        }
        for (gnu.bytecode.Field field = fields; field != null; field = field.next)
        {
            field.assign_constants(this);
        }

        for (gnu.bytecode.Method method = methods; method != null; method = method.next)
        {
            method.assignConstants();
        }

        if (!(enclosingMember instanceof gnu.bytecode.Method)) goto _L2; else goto _L1
_L1:
        EnclosingMethodAttr enclosingmethodattr1 = EnclosingMethodAttr.getFirstEnclosingMethod(getAttributes());
        EnclosingMethodAttr enclosingmethodattr = enclosingmethodattr1;
        if (enclosingmethodattr1 == null)
        {
            enclosingmethodattr = new EnclosingMethodAttr(this);
        }
        enclosingmethodattr.method = (gnu.bytecode.Method)enclosingMember;
_L4:
        for (ClassType classtype = firstInnerClass; classtype != null; classtype = classtype.nextInnerClass)
        {
            constants.addClass(classtype);
        }

        break; /* Loop/switch isn't completed */
_L2:
        if (enclosingMember instanceof ClassType)
        {
            constants.addClass((ClassType)enclosingMember);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj = InnerClassesAttr.getFirstInnerClasses(getAttributes());
        if (obj != null)
        {
            ((InnerClassesAttr) (obj)).setSkipped(true);
        }
        Attribute.assignConstants(this, this);
        int j = 1;
        while (j <= constants.count) 
        {
            Object obj1 = constants.pool[j];
            if (!(obj1 instanceof CpoolClass))
            {
                obj1 = obj;
            } else
            {
                CpoolClass cpoolclass = (CpoolClass)obj1;
                obj1 = obj;
                if (cpoolclass.clas instanceof ClassType)
                {
                    obj1 = obj;
                    if (((ClassType)cpoolclass.clas).getEnclosingMember() != null)
                    {
                        obj1 = obj;
                        if (obj == null)
                        {
                            obj1 = new InnerClassesAttr(this);
                        }
                        ((InnerClassesAttr) (obj1)).addClass(cpoolclass, this);
                    }
                }
            }
            j++;
            obj = obj1;
        }
        if (obj != null)
        {
            ((InnerClassesAttr) (obj)).setSkipped(false);
            ((InnerClassesAttr) (obj)).assignConstants(this);
        }
        return;
    }

    public gnu.bytecode.Method[] getAbstractMethods()
    {
        return getMethods(AbstractMethodFilter.instance, 2);
    }

    public final Attribute getAttributes()
    {
        return attributes;
    }

    public short getClassfileMajorVersion()
    {
        return (short)(classfileFormatVersion >> 16);
    }

    public short getClassfileMinorVersion()
    {
        return (short)(classfileFormatVersion & 0xffff);
    }

    public int getClassfileVersion()
    {
        return classfileFormatVersion;
    }

    public final CpoolEntry getConstant(int i)
    {
        if (constants == null || constants.pool == null || i > constants.count)
        {
            return null;
        } else
        {
            return constants.pool[i];
        }
    }

    public final ConstantPool getConstants()
    {
        return constants;
    }

    public ClassType getDeclaredClass(String s)
    {
        addMemberClasses();
        for (ClassType classtype = firstInnerClass; classtype != null; classtype = classtype.nextInnerClass)
        {
            if (s.equals(classtype.getSimpleName()))
            {
                return classtype;
            }
        }

        return null;
    }

    public gnu.bytecode.Field getDeclaredField(String s)
    {
        for (gnu.bytecode.Field field = getFields(); field != null; field = field.next)
        {
            if (s.equals(field.name))
            {
                return field;
            }
        }

        return null;
    }

    public gnu.bytecode.Method getDeclaredMethod(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        gnu.bytecode.Method method1 = null;
        gnu.bytecode.Method method;
        gnu.bytecode.Method method2;
        int j;
        if ("<init>".equals(s) && hasOuterLink())
        {
            j = 1;
        } else
        {
            j = 0;
        }
        method = getDeclaredMethods();
_L2:
        if (method == null)
        {
            break; /* Loop/switch isn't completed */
        }
        method2 = method1;
        if (!s.equals(method.getName()))
        {
            break MISSING_BLOCK_LABEL_143;
        }
        method2 = method1;
        if (i + j != method.getParameterTypes().length)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        if (method1 == null)
        {
            break MISSING_BLOCK_LABEL_140;
        }
        throw new Error((new StringBuilder()).append("ambiguous call to getDeclaredMethod(\"").append(s).append("\", ").append(i).append(")\n - ").append(method1).append("\n - ").append(method).toString());
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        method2 = method;
        method = method.next;
        method1 = method2;
        if (true) goto _L2; else goto _L1
_L1:
        return method1;
    }

    public gnu.bytecode.Method getDeclaredMethod(String s, Type atype[])
    {
        gnu.bytecode.Method method;
        int i;
        if ("<init>".equals(s) && hasOuterLink())
        {
            i = 1;
        } else
        {
            i = 0;
        }
        method = getDeclaredMethods();
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_166;
        }
        if (s.equals(method.getName()))
        {
            break; /* Loop/switch isn't completed */
        }
_L4:
        method = method.next;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_25;
_L1:
        Type atype1[];
        int j;
        atype1 = method.getParameterTypes();
        if (atype == null || atype == atype1 && i == 0)
        {
            return method;
        }
        j = atype.length;
        if (j != atype1.length - i) goto _L4; else goto _L3
_L3:
        Type type;
        Type type1;
        int k;
label0:
        do
        {
            do
            {
                do
                {
                    k = j - 1;
                    if (k < 0)
                    {
                        break label0;
                    }
                    type = atype1[k + i];
                    type1 = atype[k];
                    j = k;
                } while (type == type1);
                j = k;
            } while (type1 == null);
            j = k;
        } while (type.getSignature().equals(type1.getSignature()));
        if (k >= 0) goto _L4; else goto _L5
_L5:
        return method;
        return null;
    }

    public final gnu.bytecode.Method getDeclaredMethods()
    {
        this;
        JVM INSTR monitorenter ;
        gnu.bytecode.Method method;
        if ((flags & 0x12) == 16)
        {
            addMethods(getReflectClass());
        }
        method = methods;
        this;
        JVM INSTR monitorexit ;
        return method;
        Exception exception;
        exception;
        throw exception;
    }

    public ClassType getDeclaringClass()
    {
        addEnclosingMember();
        if (enclosingMember instanceof ClassType)
        {
            return (ClassType)enclosingMember;
        } else
        {
            return null;
        }
    }

    public Member getEnclosingMember()
    {
        addEnclosingMember();
        return enclosingMember;
    }

    public gnu.bytecode.Field getField(String s)
    {
        return getField(s, 1);
    }

    public gnu.bytecode.Field getField(String s, int i)
    {
        this;
        JVM INSTR monitorenter ;
        ClassType classtype = this;
_L10:
        Object obj = classtype.getDeclaredField(s);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (i == -1) goto _L4; else goto _L3
_L3:
        int j = ((gnu.bytecode.Field) (obj)).getModifiers();
        if ((j & i) == 0) goto _L2; else goto _L4
_L4:
        s = ((String) (obj));
_L8:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        ClassType aclasstype[] = classtype.getInterfaces();
        if (aclasstype == null) goto _L6; else goto _L5
_L5:
        j = 0;
_L11:
        if (j >= aclasstype.length) goto _L6; else goto _L7
_L7:
        obj = aclasstype[j].getField(s, i);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        s = ((String) (obj));
          goto _L8
_L6:
        obj = classtype.getSuperclass();
        classtype = ((ClassType) (obj));
        if (obj != null) goto _L10; else goto _L9
_L9:
        s = null;
          goto _L8
        s;
        throw s;
        j++;
          goto _L11
    }

    public final int getFieldCount()
    {
        return fields_count;
    }

    public final gnu.bytecode.Field getFields()
    {
        this;
        JVM INSTR monitorenter ;
        gnu.bytecode.Field field;
        if ((flags & 0x11) == 16)
        {
            addFields();
        }
        field = fields;
        this;
        JVM INSTR monitorexit ;
        return field;
        Exception exception;
        exception;
        throw exception;
    }

    public ClassType[] getInterfaces()
    {
        this;
        JVM INSTR monitorenter ;
        if (interfaces != null || (flags & 0x10) == 0 || getReflectClass() == null) goto _L2; else goto _L1
_L1:
        Class aclass[];
        int j;
        aclass = reflectClass.getInterfaces();
        j = aclass.length;
        if (j != 0) goto _L4; else goto _L3
_L3:
        ClassType aclasstype[] = noClasses;
_L6:
        interfaces = aclasstype;
        int i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        interfaces[i] = (ClassType)Type.make(aclass[i]);
        i++;
        if (true) goto _L5; else goto _L2
_L4:
        aclasstype = new ClassType[j];
          goto _L6
_L2:
        aclasstype = interfaces;
        this;
        JVM INSTR monitorexit ;
        return aclasstype;
        Exception exception;
        exception;
        throw exception;
    }

    public gnu.bytecode.Method[] getMatchingMethods(String s, Type atype[], int i)
    {
        int j = 0;
        Vector vector = new Vector(10);
        gnu.bytecode.Method method = methods;
        while (method != null) 
        {
            int k;
            if (!s.equals(method.getName()))
            {
                k = j;
            } else
            {
                k = j;
                if ((i & 8) == (method.access_flags & 8))
                {
                    k = j;
                    if ((i & 1) <= (method.access_flags & 1))
                    {
                        k = j;
                        if (method.arg_types.length == atype.length)
                        {
                            k = j + 1;
                            vector.addElement(method);
                        }
                    }
                }
            }
            method = method.getNext();
            j = k;
        }
        s = new gnu.bytecode.Method[j];
        vector.copyInto(s);
        return s;
    }

    public gnu.bytecode.Method getMethod(String s, Type atype[])
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = this;
_L4:
        Object obj1 = ((ClassType) (obj)).getDeclaredMethod(s, atype);
        if (obj1 == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
_L6:
        this;
        JVM INSTR monitorexit ;
        return ((gnu.bytecode.Method) (obj));
_L2:
        obj1 = ((ClassType) (obj)).getSuperclass();
        obj = obj1;
        if (obj1 != null) goto _L4; else goto _L3
_L3:
        obj1 = this;
_L9:
        ClassType aclasstype[] = ((ClassType) (obj1)).getInterfaces();
        int i;
        if (aclasstype == null)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        i = 0;
_L7:
        gnu.bytecode.Method method;
        if (i >= aclasstype.length)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        method = aclasstype[i].getDeclaredMethod(s, atype);
        obj = method;
        if (method != null) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
        obj = ((ClassType) (obj1)).getSuperclass();
        obj1 = obj;
        if (obj != null) goto _L9; else goto _L8
_L8:
        obj = null;
          goto _L6
        s;
        throw s;
    }

    public gnu.bytecode.Method getMethod(Method method)
    {
        String s = method.getName();
        Class aclass[] = method.getParameterTypes();
        Type atype[] = new Type[aclass.length];
        int i = aclass.length;
        do
        {
            i--;
            if (i >= 0)
            {
                atype[i] = Type.make(aclass[i]);
            } else
            {
                return addMethod(s, method.getModifiers(), atype, Type.make(method.getReturnType()));
            }
        } while (true);
    }

    public final int getMethodCount()
    {
        return methods_count;
    }

    public int getMethods(Filter filter, int i, List list)
    {
        ClassType classtype;
        String s;
        int j;
        j = 0;
        s = null;
        classtype = this;
_L9:
        gnu.bytecode.Method method;
        String s1;
        int k;
        k = j;
        if (classtype == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        s1 = classtype.getPackageName();
        method = classtype.getDeclaredMethods();
_L5:
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        if (classtype == this) goto _L2; else goto _L1
_L1:
        k = method.getModifiers();
        if ((k & 2) == 0) goto _L4; else goto _L3
_L3:
        k = j;
_L7:
        method = method.getNext();
        j = k;
          goto _L5
_L4:
        if ((k & 5) != 0) goto _L2; else goto _L6
_L6:
        k = j;
        if (!s1.equals(s)) goto _L7; else goto _L2
_L2:
        k = j;
        if (filter.select(method))
        {
            if (list != null)
            {
                list.add(method);
            }
            k = j + 1;
        }
          goto _L7
        s = s1;
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_148;
        }
        k = j;
        return k;
        int l = j;
        if (i > 1)
        {
            ClassType aclasstype[] = classtype.getInterfaces();
            l = j;
            if (aclasstype != null)
            {
                int i1 = 0;
                do
                {
                    l = j;
                    if (i1 >= aclasstype.length)
                    {
                        break;
                    }
                    j += aclasstype[i1].getMethods(filter, i, list);
                    i1++;
                } while (true);
            }
        }
        classtype = classtype.getSuperclass();
        j = l;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public int getMethods(Filter filter, int i, gnu.bytecode.Method amethod[], int j)
    {
        Vector vector = new Vector();
        getMethods(filter, i, ((List) (vector)));
        int k = vector.size();
        for (i = 0; i < k; i++)
        {
            amethod[j + i] = (gnu.bytecode.Method)vector.elementAt(i);
        }

        return k;
    }

    public final gnu.bytecode.Method getMethods()
    {
        return methods;
    }

    public gnu.bytecode.Method[] getMethods(Filter filter, int i)
    {
        Vector vector = new Vector();
        getMethods(filter, i, ((List) (vector)));
        int j = vector.size();
        filter = new gnu.bytecode.Method[j];
        for (i = 0; i < j; i++)
        {
            filter[i] = (gnu.bytecode.Method)vector.elementAt(i);
        }

        return filter;
    }

    public gnu.bytecode.Method[] getMethods(Filter filter, boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return getMethods(filter, i);
    }

    public final int getModifiers()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        if (access_flags == 0 && (flags & 0x10) != 0 && getReflectClass() != null)
        {
            access_flags = reflectClass.getModifiers();
        }
        i = access_flags;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public ClassType getOuterLinkType()
    {
        if (!hasOuterLink())
        {
            return null;
        } else
        {
            return (ClassType)getDeclaredField("this$0").getType();
        }
    }

    public String getPackageName()
    {
        String s = getName();
        int i = s.lastIndexOf('.');
        if (i < 0)
        {
            return "";
        } else
        {
            return s.substring(0, i);
        }
    }

    public String getSimpleName()
    {
        this;
        JVM INSTR monitorenter ;
        if ((flags & 0x10) == 0) goto _L2; else goto _L1
_L1:
        Object obj = getReflectClass();
        if (obj == null) goto _L2; else goto _L3
_L3:
        String s = reflectClass.getSimpleName();
_L7:
        this;
        JVM INSTR monitorexit ;
        return s;
        Object obj1;
        obj1;
_L2:
        int i;
        s = getName();
        i = s.lastIndexOf('.');
        obj1 = s;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj1 = s.substring(i + 1);
        i = ((String) (obj1)).lastIndexOf('$');
        s = ((String) (obj1));
        if (i < 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j = ((String) (obj1)).length();
        i++;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        char c = ((String) (obj1)).charAt(i);
        if (c < '0' || c > '9')
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        s = ((String) (obj1)).substring(i);
        if (true) goto _L7; else goto _L6
_L6:
        obj1;
        throw obj1;
    }

    public final boolean getStaticFlag()
    {
        return (getModifiers() & 8) != 0;
    }

    public ClassType getSuperclass()
    {
        this;
        JVM INSTR monitorenter ;
        ClassType classtype;
        if (superClass == null && !isInterface() && !"java.lang.Object".equals(getName()) && (flags & 0x10) != 0 && getReflectClass() != null)
        {
            superClass = (ClassType)make(reflectClass.getSuperclass());
        }
        classtype = superClass;
        this;
        JVM INSTR monitorexit ;
        return classtype;
        Exception exception;
        exception;
        throw exception;
    }

    public final boolean hasOuterLink()
    {
        getFields();
        return (flags & 0x20) != 0;
    }

    public final boolean implementsInterface(ClassType classtype)
    {
        ClassType classtype1;
        if (this != classtype)
        {
            if ((classtype1 = getSuperclass()) == null || !classtype1.implementsInterface(classtype))
            {
label0:
                {
                    ClassType aclasstype[] = getInterfaces();
                    if (aclasstype == null)
                    {
                        break label0;
                    }
                    int i = aclasstype.length;
                    int j;
                    do
                    {
                        j = i - 1;
                        if (j < 0)
                        {
                            break label0;
                        }
                        i = j;
                    } while (!aclasstype[j].implementsInterface(classtype));
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    public boolean isAccessible(ClassType classtype, ObjectType objecttype, int i)
    {
        int j = classtype.getModifiers();
        if ((i & 1) == 0 || (j & 1) == 0)
        {
            String s = getName();
            String s1 = classtype.getName();
            if (!s.equals(s1))
            {
                if ((i & 2) != 0)
                {
                    return false;
                }
                int k = s.lastIndexOf('.');
                if (k >= 0)
                {
                    s = s.substring(0, k);
                } else
                {
                    s = "";
                }
                k = s1.lastIndexOf('.');
                if (k >= 0)
                {
                    s1 = s1.substring(0, k);
                } else
                {
                    s1 = "";
                }
                if (!s.equals(s1))
                {
                    if ((j & 1) == 0)
                    {
                        return false;
                    }
                    if ((i & 4) == 0 || !isSubclass(classtype) || (objecttype instanceof ClassType) && !((ClassType)objecttype).isSubclass(this))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isAccessible(Member member, ObjectType objecttype)
    {
        if (member.getStaticFlag())
        {
            objecttype = null;
        }
        return isAccessible(member.getDeclaringClass(), objecttype, member.getModifiers());
    }

    public final boolean isInterface()
    {
        return (getModifiers() & 0x200) != 0;
    }

    public final boolean isSubclass(ClassType classtype)
    {
        boolean flag1 = true;
        if (!classtype.isInterface()) goto _L2; else goto _L1
_L1:
        boolean flag = implementsInterface(classtype);
_L4:
        return flag;
_L2:
        if (this != toStringType)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (classtype == javalangStringType) goto _L4; else goto _L3
_L3:
        if (this != javalangStringType)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (classtype == toStringType) goto _L4; else goto _L5
_L5:
        ClassType classtype1 = this;
label0:
        do
        {
label1:
            {
                if (classtype1 == null)
                {
                    break label1;
                }
                flag = flag1;
                if (classtype1 == classtype)
                {
                    break label0;
                }
                classtype1 = classtype1.getSuperclass();
            }
        } while (true);
        if (true) goto _L4; else goto _L6
_L6:
        return false;
    }

    public final boolean isSubclass(String s)
    {
        ClassType classtype = this;
        ClassType classtype1;
        do
        {
            if (s.equals(classtype.getName()))
            {
                return true;
            }
            classtype1 = classtype.getSuperclass();
            classtype = classtype1;
        } while (classtype1 != null);
        return false;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setName(objectinput.readUTF());
        flags = flags | 0x10;
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        String s = getName();
        HashMap hashmap = mapNameToType;
        hashmap;
        JVM INSTR monitorenter ;
        Type type = (Type)hashmap.get(s);
        if (type == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        hashmap;
        JVM INSTR monitorexit ;
        return type;
        hashmap.put(s, this);
        hashmap;
        JVM INSTR monitorexit ;
        return this;
        Exception exception;
        exception;
        hashmap;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final void setAttributes(Attribute attribute)
    {
        attributes = attribute;
    }

    public void setClassfileVersion(int i)
    {
        classfileFormatVersion = i;
    }

    public void setClassfileVersion(int i, int j)
    {
        classfileFormatVersion = (i & 0xffff) * 0x10000 + j * 65535;
    }

    public void setClassfileVersionJava5()
    {
        setClassfileVersion(0x310000);
    }

    public void setEnclosingMember(Member member)
    {
        enclosingMember = member;
    }

    public final void setInterface(boolean flag)
    {
        if (flag)
        {
            access_flags = access_flags | 0x600;
            return;
        } else
        {
            access_flags = access_flags & 0xfffffdff;
            return;
        }
    }

    public void setInterfaces(ClassType aclasstype[])
    {
        interfaces = aclasstype;
    }

    public final void setModifiers(int i)
    {
        access_flags = i;
    }

    public void setName(String s)
    {
        this_name = s;
        setSignature((new StringBuilder()).append("L").append(s.replace('.', '/')).append(";").toString());
    }

    public final gnu.bytecode.Field setOuterLink(ClassType classtype)
    {
        if ((flags & 0x10) != 0)
        {
            throw new Error((new StringBuilder()).append("setOuterLink called for existing class ").append(getName()).toString());
        }
        Object obj = getDeclaredField("this$0");
        Object obj1;
        if (obj == null)
        {
            gnu.bytecode.Field field = addField("this$0", classtype);
            flags = flags | 0x20;
            obj = methods;
            do
            {
                obj1 = field;
                if (obj == null)
                {
                    break;
                }
                if ("<init>".equals(((gnu.bytecode.Method) (obj)).getName()))
                {
                    if (((gnu.bytecode.Method) (obj)).code != null)
                    {
                        throw new Error((new StringBuilder()).append("setOuterLink called when ").append(obj).append(" has code").toString());
                    }
                    obj1 = ((gnu.bytecode.Method) (obj)).arg_types;
                    Type atype[] = new Type[obj1.length + 1];
                    System.arraycopy(obj1, 0, atype, 1, obj1.length);
                    atype[0] = classtype;
                    obj.arg_types = atype;
                    obj.signature = null;
                }
                obj = ((gnu.bytecode.Method) (obj)).getNext();
            } while (true);
        } else
        {
            obj1 = obj;
            if (!classtype.equals(((gnu.bytecode.Field) (obj)).getType()))
            {
                throw new Error((new StringBuilder()).append("inconsistent setOuterLink call for ").append(getName()).toString());
            }
        }
        return ((gnu.bytecode.Field) (obj1));
    }

    public void setSourceFile(String s)
    {
        if (sourceDbgExt != null)
        {
            sourceDbgExt.addFile(s);
            if (sourceDbgExt.fileCount > 1)
            {
                return;
            }
        }
        String s1 = SourceFileAttr.fixSourceFile(s);
        int i = s1.lastIndexOf('/');
        s = s1;
        if (i >= 0)
        {
            s = s1.substring(i + 1);
        }
        SourceFileAttr.setSourceFile(this, s);
    }

    public void setStratum(String s)
    {
        if (sourceDbgExt == null)
        {
            sourceDbgExt = new SourceDebugExtAttr(this);
        }
        sourceDbgExt.addStratum(s);
    }

    public void setSuper(ClassType classtype)
    {
        superClass = classtype;
    }

    public void setSuper(String s)
    {
        if (s == null)
        {
            s = Type.pointer_type;
        } else
        {
            s = make(s);
        }
        setSuper(((ClassType) (s)));
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassType ").append(getName()).toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeUTF(getName());
    }

    public byte[] writeToArray()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(500);
        try
        {
            writeToStream(bytearrayoutputstream);
        }
        catch (IOException ioexception)
        {
            throw new InternalError(ioexception.toString());
        }
        return bytearrayoutputstream.toByteArray();
    }

    public void writeToFile()
        throws IOException
    {
        writeToFile((new StringBuilder()).append(this_name.replace('.', File.separatorChar)).append(".class").toString());
    }

    public void writeToFile(String s)
        throws IOException
    {
        s = new BufferedOutputStream(new FileOutputStream(s));
        writeToStream(s);
        s.close();
    }

    public void writeToStream(OutputStream outputstream)
        throws IOException
    {
        DataOutputStream dataoutputstream = new DataOutputStream(outputstream);
        doFixups();
        dataoutputstream.writeInt(0xcafebabe);
        dataoutputstream.writeShort(getClassfileMinorVersion());
        dataoutputstream.writeShort(getClassfileMajorVersion());
        if (constants == null)
        {
            dataoutputstream.writeShort(1);
        } else
        {
            constants.write(dataoutputstream);
        }
        dataoutputstream.writeShort(access_flags);
        dataoutputstream.writeShort(thisClassIndex);
        dataoutputstream.writeShort(superClassIndex);
        if (interfaceIndexes == null)
        {
            dataoutputstream.writeShort(0);
        } else
        {
            int j = interfaceIndexes.length;
            dataoutputstream.writeShort(j);
            int i = 0;
            while (i < j) 
            {
                dataoutputstream.writeShort(interfaceIndexes[i]);
                i++;
            }
        }
        dataoutputstream.writeShort(fields_count);
        for (outputstream = fields; outputstream != null; outputstream = ((gnu.bytecode.Field) (outputstream)).next)
        {
            outputstream.write(dataoutputstream, this);
        }

        dataoutputstream.writeShort(methods_count);
        for (outputstream = methods; outputstream != null; outputstream = ((gnu.bytecode.Method) (outputstream)).next)
        {
            outputstream.write(dataoutputstream, this);
        }

        Attribute.writeAll(this, dataoutputstream);
        flags = flags | 3;
    }

}
