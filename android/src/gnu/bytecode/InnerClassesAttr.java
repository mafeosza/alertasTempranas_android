// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package gnu.bytecode:
//            Attribute, ClassType, CpoolClass, ConstantPool, 
//            CpoolUtf8, ClassTypeWriter, Access

public class InnerClassesAttr extends Attribute
{

    int count;
    short data[];

    public InnerClassesAttr(ClassType classtype)
    {
        super("InnerClasses");
        addToFrontOf(classtype);
    }

    public InnerClassesAttr(short aword0[], ClassType classtype)
    {
        this(classtype);
        count = (short)(aword0.length >> 2);
        data = aword0;
    }

    public static InnerClassesAttr getFirstInnerClasses(Attribute attribute)
    {
        do
        {
            if (attribute == null || (attribute instanceof InnerClassesAttr))
            {
                return (InnerClassesAttr)attribute;
            }
            attribute = attribute.next;
        } while (true);
    }

    void addClass(CpoolClass cpoolclass, ClassType classtype)
    {
        short word0 = 0;
        int i = count;
        count = i + 1;
        int j = i * 4;
        ClassType classtype1;
        Object obj;
        if (data == null)
        {
            data = new short[16];
        } else
        if (j >= data.length)
        {
            short aword0[] = new short[j * 2];
            System.arraycopy(data, 0, aword0, 0, j);
            data = aword0;
        }
        classtype = classtype.constants;
        classtype1 = (ClassType)cpoolclass.getClassType();
        obj = classtype1.getSimpleName();
        if (obj == null || ((String) (obj)).length() == 0)
        {
            i = 0;
        } else
        {
            i = classtype.addUtf8(((String) (obj))).index;
        }
        data[j] = (short)cpoolclass.index;
        cpoolclass = classtype1.getDeclaringClass();
        obj = data;
        if (cpoolclass != null)
        {
            word0 = (short)classtype.addClass(cpoolclass).index;
        }
        obj[j + 1] = word0;
        data[j + 2] = (short)i;
        i = classtype1.getModifiers();
        data[j + 3] = (short)(i & 0xffffffdf);
    }

    public void assignConstants(ClassType classtype)
    {
        super.assignConstants(classtype);
    }

    public int getLength()
    {
        return count * 8 + 2;
    }

    public void print(ClassTypeWriter classtypewriter)
    {
        ConstantPool constantpool;
        ClassType classtype;
        int i;
        classtype = (ClassType)container;
        if (data == null)
        {
            constantpool = null;
        } else
        {
            constantpool = classtype.getConstants();
        }
        classtypewriter.print("Attribute \"");
        classtypewriter.print(getName());
        classtypewriter.print("\", length:");
        classtypewriter.print(getLength());
        classtypewriter.print(", count: ");
        classtypewriter.println(count);
        i = 0;
_L10:
        if (i >= count) goto _L2; else goto _L1
_L1:
        String s;
        Object obj;
        CpoolClass cpoolclass;
        int j;
        int l;
        if (constantpool == null)
        {
            j = 0;
        } else
        {
            j = data[i * 4] & 0xffff;
        }
        if (constantpool == null || j == 0)
        {
            cpoolclass = null;
        } else
        {
            cpoolclass = constantpool.getForcedClass(j);
        }
        if (cpoolclass != null && (cpoolclass.clas instanceof ClassType))
        {
            obj = (ClassType)cpoolclass.clas;
        } else
        {
            obj = null;
        }
        classtypewriter.print(' ');
        if (j == 0 && obj != null)
        {
            l = ((ClassType) (obj)).getModifiers();
        } else
        {
            l = data[i * 4 + 3] & 0xffff;
        }
        classtypewriter.print(Access.toString(l, 'I'));
        classtypewriter.print(' ');
        if (j == 0 && obj != null)
        {
            s = ((ClassType) (obj)).getSimpleName();
        } else
        {
            int i1 = data[i * 4 + 2] & 0xffff;
            if (constantpool == null || i1 == 0)
            {
                s = "(Anonymous)";
            } else
            {
                classtypewriter.printOptionalIndex(i1);
                s = ((CpoolUtf8)(CpoolUtf8)constantpool.getForced(i1, 1)).string;
            }
        }
        classtypewriter.print(s);
        classtypewriter.print(" = ");
        if (cpoolclass != null)
        {
            s = cpoolclass.getClassName();
        } else
        {
            s = "(Unknown)";
        }
        classtypewriter.print(s);
        classtypewriter.print("; ");
        if (j != 0 || obj == null) goto _L4; else goto _L3
_L3:
        obj = ((ClassType) (obj)).getName();
        j = ((String) (obj)).lastIndexOf('.');
        s = ((String) (obj));
        if (j > 0)
        {
            s = ((String) (obj)).substring(j + 1);
        }
        j = s.lastIndexOf('$') + 1;
        if (j >= s.length()) goto _L6; else goto _L5
_L5:
        j = s.charAt(j);
        if (j < 48 || j > 57) goto _L6; else goto _L7
_L7:
        classtypewriter.print("not a member");
_L8:
        classtypewriter.println();
        i++;
        continue; /* Loop/switch isn't completed */
_L6:
        classtypewriter.print("member of ");
        classtypewriter.print(classtype.getName());
        continue; /* Loop/switch isn't completed */
_L4:
        int k = data[i * 4 + 1] & 0xffff;
        if (k == 0)
        {
            classtypewriter.print("not a member");
        } else
        {
            classtypewriter.print("member of ");
            classtypewriter.print(((CpoolClass)constantpool.getForced(k, 7)).getStringName());
        }
        if (true) goto _L8; else goto _L2
_L2:
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void write(DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeShort(count);
        for (int i = 0; i < count; i++)
        {
            dataoutputstream.writeShort(data[i * 4]);
            dataoutputstream.writeShort(data[i * 4 + 1]);
            dataoutputstream.writeShort(data[i * 4 + 2]);
            dataoutputstream.writeShort(data[i * 4 + 3]);
        }

    }
}
