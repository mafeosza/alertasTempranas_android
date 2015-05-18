// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package gnu.bytecode:
//            ClassType, ConstantPool, CpoolClass, SourceFileAttr, 
//            Method, CodeAttr, LineNumbersAttr, LocalVarsAttr, 
//            Scope, Label, Variable, Member, 
//            SignatureAttr, StackMapTableAttr, Field, RuntimeAnnotationsAttr, 
//            ConstantValueAttr, InnerClassesAttr, EnclosingMethodAttr, SourceDebugExtAttr, 
//            MiscAttr, AttrContainer, Attribute, CpoolUtf8

public class ClassFileInput extends DataInputStream
{

    ClassType ctype;
    InputStream str;

    public ClassFileInput(ClassType classtype, InputStream inputstream)
        throws IOException, ClassFormatError
    {
        super(inputstream);
        ctype = classtype;
        if (!readHeader())
        {
            throw new ClassFormatError("invalid magic number");
        } else
        {
            classtype.constants = readConstants();
            readClassInfo();
            readFields();
            readMethods();
            readAttributes(classtype);
            return;
        }
    }

    public ClassFileInput(InputStream inputstream)
        throws IOException
    {
        super(inputstream);
    }

    public static ClassType readClassType(InputStream inputstream)
        throws IOException, ClassFormatError
    {
        ClassType classtype = new ClassType();
        new ClassFileInput(classtype, inputstream);
        return classtype;
    }

    CpoolClass getClassConstant(int i)
    {
        return (CpoolClass)ctype.constants.getForced(i, 7);
    }

    public Attribute readAttribute(String s, int i, AttrContainer attrcontainer)
        throws IOException
    {
        if (s != "SourceFile" || !(attrcontainer instanceof ClassType)) goto _L2; else goto _L1
_L1:
        attrcontainer = new SourceFileAttr(readUnsignedShort(), (ClassType)attrcontainer);
_L4:
        return attrcontainer;
_L2:
label0:
        {
            if (s == "Code" && (attrcontainer instanceof Method))
            {
                s = new CodeAttr((Method)attrcontainer);
                s.fixup_count = -1;
                s.setMaxStack(readUnsignedShort());
                s.setMaxLocals(readUnsignedShort());
                attrcontainer = new byte[readInt()];
                readFully(attrcontainer);
                s.setCode(attrcontainer);
                int j = readUnsignedShort();
                for (i = 0; i < j; i++)
                {
                    s.addHandler(readUnsignedShort(), readUnsignedShort(), readUnsignedShort(), readUnsignedShort());
                }

                readAttributes(s);
                return s;
            }
            if (s == "LineNumberTable" && (attrcontainer instanceof CodeAttr))
            {
                int k = readUnsignedShort() * 2;
                s = new short[k];
                for (i = 0; i < k; i++)
                {
                    s[i] = readShort();
                }

                return new LineNumbersAttr(s, (CodeAttr)attrcontainer);
            }
            if (s != "LocalVariableTable" || !(attrcontainer instanceof CodeAttr))
            {
                break label0;
            }
            attrcontainer = (CodeAttr)attrcontainer;
            LocalVarsAttr localvarsattr = new LocalVarsAttr(attrcontainer);
            Object obj = localvarsattr.getMethod();
            if (localvarsattr.parameter_scope == null)
            {
                localvarsattr.parameter_scope = ((Method) (obj)).pushScope();
            }
            s = localvarsattr.parameter_scope;
            if (((Scope) (s)).end == null)
            {
                s.end = new Label(((CodeAttr) (attrcontainer)).PC);
            }
            obj = ((Method) (obj)).getConstants();
            int k2 = readUnsignedShort();
            int k1 = ((Scope) (s)).start.position;
            int l = ((Scope) (s)).end.position;
            i = 0;
            do
            {
                attrcontainer = localvarsattr;
                if (i >= k2)
                {
                    break;
                }
                Variable variable;
                int l1;
label1:
                {
                    variable = new Variable();
                    int j2 = readUnsignedShort();
                    int i2 = j2 + readUnsignedShort();
                    attrcontainer = s;
                    if (j2 == k1)
                    {
                        l1 = l;
                        attrcontainer = s;
                        if (i2 == l)
                        {
                            break label1;
                        }
                    }
                    for (attrcontainer = s; ((Scope) (attrcontainer)).parent != null && (j2 < ((Scope) (attrcontainer)).start.position || i2 > ((Scope) (attrcontainer)).end.position); attrcontainer = ((Scope) (attrcontainer)).parent) { }
                    s = new Scope(new Label(j2), new Label(i2));
                    s.linkChild(attrcontainer);
                    k1 = j2;
                    l1 = i2;
                    attrcontainer = s;
                }
                attrcontainer.addVariable(variable);
                variable.setName(readUnsignedShort(), ((ConstantPool) (obj)));
                variable.setSignature(readUnsignedShort(), ((ConstantPool) (obj)));
                variable.offset = readUnsignedShort();
                i++;
                l = l1;
                s = attrcontainer;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (s == "Signature" && (attrcontainer instanceof Member))
        {
            return new SignatureAttr(readUnsignedShort(), (Member)attrcontainer);
        }
        if (s == "StackMapTable" && (attrcontainer instanceof CodeAttr))
        {
            s = new byte[i];
            readFully(s, 0, i);
            return new StackMapTableAttr(s, (CodeAttr)attrcontainer);
        }
        if ((s == "RuntimeVisibleAnnotations" || s == "RuntimeInvisibleAnnotations") && ((attrcontainer instanceof Field) || (attrcontainer instanceof Method) || (attrcontainer instanceof ClassType)))
        {
            byte abyte0[] = new byte[i];
            readFully(abyte0, 0, i);
            return new RuntimeAnnotationsAttr(s, abyte0, attrcontainer);
        }
        if (s == "ConstantValue" && (attrcontainer instanceof Field))
        {
            return new ConstantValueAttr(readUnsignedShort());
        }
        if (s == "InnerClasses" && (attrcontainer instanceof ClassType))
        {
            int i1 = readUnsignedShort() * 4;
            s = new short[i1];
            for (i = 0; i < i1; i++)
            {
                s[i] = readShort();
            }

            return new InnerClassesAttr(s, (ClassType)attrcontainer);
        }
        if (s == "EnclosingMethod" && (attrcontainer instanceof ClassType))
        {
            return new EnclosingMethodAttr(readUnsignedShort(), readUnsignedShort(), (ClassType)attrcontainer);
        }
        if (s == "Exceptions" && (attrcontainer instanceof Method))
        {
            s = (Method)attrcontainer;
            int j1 = readUnsignedShort();
            attrcontainer = new short[j1];
            for (i = 0; i < j1; i++)
            {
                attrcontainer[i] = readShort();
            }

            s.setExceptions(attrcontainer);
            return s.getExceptionAttr();
        }
        if (s == "SourceDebugExtension" && (attrcontainer instanceof ClassType))
        {
            s = new SourceDebugExtAttr((ClassType)attrcontainer);
            attrcontainer = new byte[i];
            readFully(attrcontainer, 0, i);
            s.data = attrcontainer;
            s.dlength = i;
            return s;
        } else
        {
            attrcontainer = new byte[i];
            readFully(attrcontainer, 0, i);
            return new MiscAttr(s, attrcontainer);
        }
    }

    public int readAttributes(AttrContainer attrcontainer)
        throws IOException
    {
        Object obj;
        int i;
        int j;
        j = readUnsignedShort();
        obj = attrcontainer.getAttributes();
        i = 0;
_L8:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Attribute attribute = ((Attribute) (obj));
        if (obj == null) goto _L4; else goto _L3
_L3:
        attribute = ((Attribute) (obj)).getNext();
        if (attribute != null) goto _L6; else goto _L5
_L5:
        attribute = ((Attribute) (obj));
_L4:
        int k = readUnsignedShort();
        obj = (CpoolUtf8)ctype.constants.getForced(k, 1);
        int l = readInt();
        ((CpoolUtf8) (obj)).intern();
        Attribute attribute1 = readAttribute(((CpoolUtf8) (obj)).string, l, attrcontainer);
        obj = attribute;
        if (attribute1 != null)
        {
            if (attribute1.getNameIndex() == 0)
            {
                attribute1.setNameIndex(k);
            }
            if (attribute == null)
            {
                attrcontainer.setAttributes(attribute1);
            } else
            {
                if (attrcontainer.getAttributes() == attribute1)
                {
                    attrcontainer.setAttributes(attribute1.getNext());
                    attribute1.setNext(null);
                }
                attribute.setNext(attribute1);
            }
            obj = attribute1;
        }
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        obj = attribute;
        if (true) goto _L3; else goto _L2
_L2:
        return j;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void readClassInfo()
        throws IOException
    {
        ctype.access_flags = readUnsignedShort();
        ctype.thisClassIndex = readUnsignedShort();
        String s = getClassConstant(ctype.thisClassIndex).name.string;
        ctype.this_name = s.replace('/', '.');
        ctype.setSignature((new StringBuilder()).append("L").append(s).append(";").toString());
        ctype.superClassIndex = readUnsignedShort();
        int j;
        if (ctype.superClassIndex == 0)
        {
            ctype.setSuper((ClassType)null);
        } else
        {
            String s2 = getClassConstant(ctype.superClassIndex).name.string;
            ctype.setSuper(s2.replace('/', '.'));
        }
        j = readUnsignedShort();
        if (j > 0)
        {
            ctype.interfaces = new ClassType[j];
            ctype.interfaceIndexes = new int[j];
            for (int i = 0; i < j; i++)
            {
                int k = readUnsignedShort();
                ctype.interfaceIndexes[i] = k;
                String s1 = ((CpoolClass)ctype.constants.getForced(k, 7)).name.string.replace('/', '.');
                ctype.interfaces[i] = ClassType.make(s1);
            }

        }
    }

    public ConstantPool readConstants()
        throws IOException
    {
        return new ConstantPool(this);
    }

    public void readFields()
        throws IOException
    {
        int j = readUnsignedShort();
        ConstantPool constantpool = ctype.constants;
        for (int i = 0; i < j; i++)
        {
            int k = readUnsignedShort();
            int l = readUnsignedShort();
            int i1 = readUnsignedShort();
            Field field = ctype.addField();
            field.setName(l, constantpool);
            field.setSignature(i1, constantpool);
            field.flags = k;
            readAttributes(field);
        }

    }

    public void readFormatVersion()
        throws IOException
    {
        int i = readUnsignedShort();
        int j = readUnsignedShort();
        ctype.classfileFormatVersion = 0x10000 * j + i;
    }

    public boolean readHeader()
        throws IOException
    {
        if (readInt() != 0xcafebabe)
        {
            return false;
        } else
        {
            readFormatVersion();
            return true;
        }
    }

    public void readMethods()
        throws IOException
    {
        int j = readUnsignedShort();
        for (int i = 0; i < j; i++)
        {
            int k = readUnsignedShort();
            int l = readUnsignedShort();
            int i1 = readUnsignedShort();
            Method method = ctype.addMethod(null, k);
            method.setName(l);
            method.setSignature(i1);
            readAttributes(method);
        }

    }

    public final void skipAttribute(int i)
        throws IOException
    {
        int k;
        for (int j = 0; j < i; j += k)
        {
            int l = (int)skip(i - j);
            k = l;
            if (l != 0)
            {
                continue;
            }
            if (read() < 0)
            {
                throw new EOFException("EOF while reading class files attributes");
            }
            k = 1;
        }

    }
}
