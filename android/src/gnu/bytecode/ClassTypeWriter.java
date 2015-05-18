// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

// Referenced classes of package gnu.bytecode:
//            ClassType, ConstantPool, Attribute, AttrContainer, 
//            Access, CpoolEntry, CpoolUtf8, Type, 
//            Field, Method

public class ClassTypeWriter extends PrintWriter
{

    public static final int PRINT_CONSTANT_POOL = 1;
    public static final int PRINT_CONSTANT_POOL_INDEXES = 2;
    public static final int PRINT_EXTRAS = 8;
    public static final int PRINT_VERBOSE = 15;
    public static final int PRINT_VERSION = 4;
    ClassType ctype;
    int flags;

    public ClassTypeWriter(ClassType classtype, OutputStream outputstream, int i)
    {
        super(outputstream);
        ctype = classtype;
        flags = i;
    }

    public ClassTypeWriter(ClassType classtype, Writer writer, int i)
    {
        super(writer);
        ctype = classtype;
        flags = i;
    }

    public static void print(ClassType classtype, PrintStream printstream, int i)
    {
        classtype = new ClassTypeWriter(classtype, printstream, i);
        classtype.print();
        classtype.flush();
    }

    public static void print(ClassType classtype, PrintWriter printwriter, int i)
    {
        classtype = new ClassTypeWriter(classtype, printwriter, i);
        classtype.print();
        classtype.flush();
    }

    CpoolEntry getCpoolEntry(int i)
    {
        CpoolEntry acpoolentry[] = ctype.constants.pool;
        if (acpoolentry == null || i < 0 || i >= acpoolentry.length)
        {
            return null;
        } else
        {
            return acpoolentry[i];
        }
    }

    public void print()
    {
        if ((flags & 4) != 0)
        {
            print("Classfile format major version: ");
            print(ctype.getClassfileMajorVersion());
            print(", minor version: ");
            print(ctype.getClassfileMinorVersion());
            println('.');
        }
        if ((flags & 1) != 0)
        {
            printConstantPool();
        }
        printClassInfo();
        printFields();
        printMethods();
        printAttributes();
    }

    public void print(ClassType classtype)
    {
        ctype = classtype;
        print();
    }

    public void printAttributes()
    {
        ClassType classtype = ctype;
        println();
        print("Attributes (count: ");
        print(Attribute.count(classtype));
        println("):");
        printAttributes(((AttrContainer) (classtype)));
    }

    public void printAttributes(AttrContainer attrcontainer)
    {
        for (attrcontainer = attrcontainer.getAttributes(); attrcontainer != null; attrcontainer = ((Attribute) (attrcontainer)).next)
        {
            attrcontainer.print(this);
        }

    }

    public void printClassInfo()
    {
        println();
        print("Access flags:");
        print(Access.toString(ctype.getModifiers(), 'C'));
        println();
        print("This class: ");
        printOptionalIndex(ctype.thisClassIndex);
        printConstantTersely(ctype.thisClassIndex, 7);
        print(" super: ");
        int ai[];
        int i;
        if (ctype.superClassIndex == -1)
        {
            print("<unknown>");
        } else
        if (ctype.superClassIndex == 0)
        {
            print("0");
        } else
        {
            printOptionalIndex(ctype.superClassIndex);
            printConstantTersely(ctype.superClassIndex, 7);
        }
        println();
        print("Interfaces (count: ");
        ai = ctype.interfaceIndexes;
        if (ai == null)
        {
            i = 0;
        } else
        {
            i = ai.length;
        }
        print(i);
        print("):");
        println();
        for (int j = 0; j < i; j++)
        {
            print("- Implements: ");
            int k = ai[j];
            printOptionalIndex(k);
            printConstantTersely(k, 7);
            println();
        }

    }

    final void printConstantOperand(int i)
    {
        CpoolEntry cpoolentry;
label0:
        {
            print(' ');
            printOptionalIndex(i);
            CpoolEntry acpoolentry[] = ctype.constants.pool;
            if (acpoolentry != null && i >= 0 && i < acpoolentry.length)
            {
                cpoolentry = acpoolentry[i];
                if (cpoolentry != null)
                {
                    break label0;
                }
            }
            print("<invalid constant index>");
            return;
        }
        print('<');
        cpoolentry.print(this, 1);
        print('>');
    }

    public void printConstantPool()
    {
        CpoolEntry acpoolentry[] = ctype.constants.pool;
        int j = ctype.constants.count;
        int i = 1;
        while (i <= j) 
        {
            CpoolEntry cpoolentry = acpoolentry[i];
            if (cpoolentry != null)
            {
                print('#');
                print(cpoolentry.index);
                print(": ");
                cpoolentry.print(this, 2);
                println();
            }
            i++;
        }
    }

    final void printConstantTersely(int i, int j)
    {
        printConstantTersely(getCpoolEntry(i), j);
    }

    final void printConstantTersely(CpoolEntry cpoolentry, int i)
    {
        if (cpoolentry == null)
        {
            print("<invalid constant index>");
            return;
        }
        if (cpoolentry.getTag() != i)
        {
            print("<unexpected constant type ");
            cpoolentry.print(this, 1);
            print('>');
            return;
        } else
        {
            cpoolentry.print(this, 0);
            return;
        }
    }

    final void printContantUtf8AsClass(int i)
    {
        Object obj = getCpoolEntry(i);
        if (obj != null && ((CpoolEntry) (obj)).getTag() == 1)
        {
            obj = ((CpoolUtf8)obj).string;
            Type.printSignature(((String) (obj)), 0, ((String) (obj)).length(), this);
            return;
        } else
        {
            printConstantTersely(i, 1);
            return;
        }
    }

    public void printFields()
    {
        println();
        print("Fields (count: ");
        print(ctype.fields_count);
        print("):");
        println();
        int i = 0;
        for (Field field = ctype.fields; field != null; field = field.next)
        {
            print("Field name: ");
            if (field.name_index != 0)
            {
                printOptionalIndex(field.name_index);
            }
            print(field.getName());
            print(Access.toString(field.flags, 'F'));
            print(" Signature: ");
            if (field.signature_index != 0)
            {
                printOptionalIndex(field.signature_index);
            }
            printSignature(field.type);
            println();
            printAttributes(field);
            i++;
        }

    }

    public void printMethod(Method method)
    {
        println();
        print("Method name:");
        if (method.name_index != 0)
        {
            printOptionalIndex(method.name_index);
        }
        print('"');
        print(method.getName());
        print('"');
        print(Access.toString(method.access_flags, 'M'));
        print(" Signature: ");
        if (method.signature_index != 0)
        {
            printOptionalIndex(method.signature_index);
        }
        print('(');
        for (int i = 0; i < method.arg_types.length; i++)
        {
            if (i > 0)
            {
                print(',');
            }
            printSignature(method.arg_types[i]);
        }

        print(')');
        printSignature(method.return_type);
        println();
        printAttributes(method);
    }

    public void printMethods()
    {
        println();
        print("Methods (count: ");
        print(ctype.methods_count);
        print("):");
        println();
        for (Method method = ctype.methods; method != null; method = method.next)
        {
            printMethod(method);
        }

    }

    void printName(String s)
    {
        print(s);
    }

    public final void printOptionalIndex(int i)
    {
        if ((flags & 2) != 0)
        {
            print('#');
            print(i);
            print('=');
        }
    }

    public final void printOptionalIndex(CpoolEntry cpoolentry)
    {
        printOptionalIndex(cpoolentry.index);
    }

    public final void printQuotedString(String s)
    {
        int i;
        int k;
        print('"');
        k = s.length();
        i = 0;
_L2:
        char c;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        c = s.charAt(i);
        if (c != '"')
        {
            break; /* Loop/switch isn't completed */
        }
        print("\\\"");
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (c >= ' ' && c < '\177')
        {
            print(c);
        } else
        {
label0:
            {
                if (c != '\n')
                {
                    break label0;
                }
                print("\\n");
            }
        }
          goto _L3
        int j;
        print("\\u");
        j = 4;
_L5:
        j--;
        if (j < 0) goto _L3; else goto _L4
_L4:
        print(Character.forDigit(c >> j * 4 & 0xf, 16));
          goto _L5
          goto _L3
        print('"');
        return;
    }

    public final int printSignature(String s, int i)
    {
        int k = s.length();
        if (i >= k)
        {
            print("<empty signature>");
            return i;
        }
        int j = Type.signatureLength(s, i);
        if (j > 0)
        {
            String s1 = Type.signatureToName(s.substring(i, i + j));
            if (s1 != null)
            {
                print(s1);
                return i + j;
            }
        }
        char c = s.charAt(i);
        if (c != '(')
        {
            print(c);
            return i + 1;
        }
        j = i + 1;
        print(c);
        i = 0;
        do
        {
            if (j >= k)
            {
                print("<truncated method signature>");
                return j;
            }
            char c1 = s.charAt(j);
            if (c1 == ')')
            {
                print(c1);
                return printSignature(s, j + 1);
            }
            if (i > 0)
            {
                print(',');
            }
            j = printSignature(s, j);
            i++;
        } while (true);
    }

    public final void printSignature(Type type)
    {
        if (type == null)
        {
            print("<unknown type>");
            return;
        } else
        {
            printSignature(type.getSignature());
            return;
        }
    }

    public final void printSignature(String s)
    {
        int i = printSignature(s, 0);
        if (i < s.length())
        {
            print("<trailing junk:");
            print(s.substring(i));
            print('>');
        }
    }

    public void printSpaces(int i)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                print(' ');
            } else
            {
                return;
            }
        } while (true);
    }

    public void setClass(ClassType classtype)
    {
        ctype = classtype;
    }

    public void setFlags(int i)
    {
        flags = i;
    }
}
