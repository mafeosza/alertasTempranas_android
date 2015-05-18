// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipInputStream;

// Referenced classes of package gnu.bytecode:
//            ClassFileInput, ClassType, ClassTypeWriter, ObjectType, 
//            AttrContainer, Attribute, ConstantPool

public class dump extends ClassFileInput
{

    ClassTypeWriter writer;

    dump(InputStream inputstream, ClassTypeWriter classtypewriter)
        throws IOException, ClassFormatError
    {
        super(inputstream);
        ctype = new ClassType();
        readFormatVersion();
        readConstants();
        readClassInfo();
        readFields();
        readMethods();
        readAttributes(ctype);
        classtypewriter.print(ctype);
        classtypewriter.flush();
    }

    public static void main(String args[])
    {
        ClassTypeWriter classtypewriter;
        int i;
        int j;
        j = args.length;
        classtypewriter = new ClassTypeWriter(null, System.out, 0);
        if (j == 0)
        {
            usage(System.err);
        }
        i = 0;
_L2:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_686;
        }
        obj = args[i];
        if (!((String) (obj)).equals("-verbose") && !((String) (obj)).equals("--verbose"))
        {
            break; /* Loop/switch isn't completed */
        }
        classtypewriter.setFlags(15);
_L10:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (!uriSchemeSpecified(((String) (obj)))) goto _L4; else goto _L3
_L3:
        boolean flag1 = ((String) (obj)).startsWith("jar:");
        Object obj1;
        boolean flag;
        obj1 = obj;
        flag = flag1;
        if (!flag1) goto _L6; else goto _L5
_L5:
        String s = ((String) (obj)).substring(4);
        Object obj3 = obj;
        int k;
        if (uriSchemeSpecified(s))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        k = s.indexOf('!');
        obj3 = obj;
        if (k < 0)
        {
            break MISSING_BLOCK_LABEL_192;
        }
        obj = (new File(s.substring(0, k))).toURI().toURL().toString();
        obj3 = (new StringBuilder()).append("jar:").append(((String) (obj))).append(s.substring(k)).toString();
        obj1 = obj3;
        flag = flag1;
        if (s.indexOf("!/") >= 0) goto _L6; else goto _L7
_L7:
        k = ((String) (obj3)).lastIndexOf('!');
        if (k > 0) goto _L9; else goto _L8
_L8:
        flag = false;
        obj1 = obj3;
_L6:
        obj3 = new URL(((String) (obj1)));
        obj = ((URL) (obj3)).openConnection().getInputStream();
_L12:
        process(((InputStream) (obj)), ((String) (obj1)), classtypewriter);
          goto _L10
        obj;
        ((IOException) (obj)).printStackTrace();
        System.err.println("caught ");
        System.err.print(obj);
        System.exit(-1);
          goto _L10
_L9:
        obj1 = obj3;
        flag = flag1;
        if (((String) (obj3)).indexOf('/', k) >= 0) goto _L6; else goto _L11
_L11:
        obj = ((String) (obj3)).substring(k + 1).replace('.', '/');
        obj1 = (new StringBuilder()).append(((String) (obj3)).substring(0, k + 1)).append('/').append(((String) (obj))).append(".class").toString();
        flag = flag1;
          goto _L6
        ZipException zipexception;
        zipexception;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_407;
        }
        obj3 = ((URL) (obj3)).getFile();
        k = ((String) (obj3)).lastIndexOf('!');
        obj = obj3;
        if (k <= 0)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        obj = ((String) (obj3)).substring(0, k);
        (new URL(((String) (obj)))).openConnection().getInputStream();
_L13:
        try
        {
            throw zipexception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        System.err.print("File for URL ");
        System.err.print(((String) (obj1)));
        System.err.println(" not found.");
        System.exit(-1);
        obj = null;
          goto _L12
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        System.err.print("Jar File for URL ");
        System.err.print(((String) (obj)));
        System.err.println(" not found.");
        System.exit(-1);
          goto _L13
        obj;
        System.err.print("Error opening zip archive ");
        System.err.print(((String) (obj1)));
        System.err.println(" not found.");
        ((ZipException) (obj)).printStackTrace();
        if (((ZipException) (obj)).getCause() != null)
        {
            ((ZipException) (obj)).getCause().printStackTrace();
        }
        System.exit(-1);
        obj = null;
          goto _L12
_L4:
        filenotfoundexception = new FileInputStream(((String) (obj)));
        obj1 = obj;
        obj = filenotfoundexception;
          goto _L12
        Object obj2;
        obj2;
        obj2 = ObjectType.getContextClass(((String) (obj))).getClassLoader();
_L14:
        filenotfoundexception = (new StringBuilder()).append(((String) (obj)).replace('.', '/')).append(".class").toString();
        obj2 = ((ClassLoader) (obj2)).getResource(filenotfoundexception);
        filenotfoundexception = ((URL) (obj2)).openConnection().getInputStream();
        obj2 = ((URL) (obj2)).toString();
        obj = filenotfoundexception;
          goto _L12
        obj2;
        obj2 = ObjectType.getContextClassLoader();
          goto _L14
        obj2;
        System.err.print("File ");
        System.err.print(((String) (obj)));
        System.err.println(" not found.");
        System.exit(-1);
        obj2 = null;
          goto _L14
        obj2;
        System.err.print("Can't find .class file for class ");
        System.err.print(((String) (obj)));
        System.err.print(" - ");
        System.err.println(obj2);
        System.exit(-1);
        Object obj4 = null;
        obj2 = obj;
        obj = obj4;
          goto _L12
          goto _L10
    }

    public static void process(InputStream inputstream, String s, ClassTypeWriter classtypewriter)
        throws IOException
    {
        inputstream = new BufferedInputStream(inputstream);
        inputstream.mark(5);
        int i = readMagic(inputstream);
        if (i == 0xcafebabe)
        {
            classtypewriter.print("Reading .class from ");
            classtypewriter.print(s);
            classtypewriter.println('.');
            new dump(inputstream, classtypewriter);
            return;
        }
        if (i == 0x504b0304)
        {
            inputstream.reset();
            classtypewriter.print("Reading classes from archive ");
            classtypewriter.print(s);
            classtypewriter.println('.');
            inputstream = new ZipInputStream(inputstream);
            do
            {
                s = inputstream.getNextEntry();
                if (s != null)
                {
                    String s1 = s.getName();
                    if (s.isDirectory())
                    {
                        classtypewriter.print("Archive directory: ");
                        classtypewriter.print(s1);
                        classtypewriter.println('.');
                    } else
                    {
                        classtypewriter.println();
                        if (readMagic(inputstream) == 0xcafebabe)
                        {
                            classtypewriter.print("Reading class member: ");
                            classtypewriter.print(s1);
                            classtypewriter.println('.');
                            new dump(inputstream, classtypewriter);
                        } else
                        {
                            classtypewriter.print("Skipping non-class member: ");
                            classtypewriter.print(s1);
                            classtypewriter.println('.');
                        }
                    }
                } else
                {
                    System.exit(-1);
                    return;
                }
            } while (true);
        } else
        {
            System.err.println((new StringBuilder()).append("File ").append(s).append(" is not a valid .class file").toString());
            System.exit(-1);
            return;
        }
    }

    public static void process(InputStream inputstream, String s, OutputStream outputstream, int i)
        throws IOException
    {
        process(inputstream, s, new ClassTypeWriter(null, outputstream, i));
    }

    public static void process(InputStream inputstream, String s, Writer writer1, int i)
        throws IOException
    {
        process(inputstream, s, new ClassTypeWriter(null, writer1, i));
    }

    static int readMagic(InputStream inputstream)
        throws IOException
    {
        int j = 0;
        int i = 0;
        do
        {
            int k;
label0:
            {
                if (i < 4)
                {
                    k = inputstream.read();
                    if (k >= 0)
                    {
                        break label0;
                    }
                }
                return j;
            }
            j = j << 8 | k & 0xff;
            i++;
        } while (true);
    }

    static int uriSchemeLength(String s)
    {
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            char c = s.charAt(i);
            if (c == ':')
            {
                return i;
            }
            if (i != 0 ? !Character.isLetterOrDigit(c) && c != '+' && c != '-' && c != '.' : !Character.isLetter(c))
            {
                return -1;
            }
        }

        return -1;
    }

    static boolean uriSchemeSpecified(String s)
    {
        int i;
        boolean flag;
label0:
        {
label1:
            {
                flag = true;
                boolean flag1 = false;
                i = uriSchemeLength(s);
                if (i != 1 || File.separatorChar != '\\')
                {
                    break label0;
                }
                i = s.charAt(0);
                if (i >= 97)
                {
                    flag = flag1;
                    if (i <= 122)
                    {
                        break label1;
                    }
                }
                if (i >= 65)
                {
                    flag = flag1;
                    if (i <= 90)
                    {
                        break label1;
                    }
                }
                flag = true;
            }
            return flag;
        }
        if (i <= 0)
        {
            flag = false;
        }
        return flag;
    }

    public static void usage(PrintStream printstream)
    {
        printstream.println("Prints and dis-assembles the contents of JVM .class files.");
        printstream.println("Usage: [--verbose] class-or-jar ...");
        printstream.println("where a class-or-jar can be one of:");
        printstream.println("- a fully-qualified class name; or");
        printstream.println("- the name of a .class file, or a URL reference to one; or");
        printstream.println("- the name of a .jar or .zip archive file, or a URL reference to one.");
        printstream.println("If a .jar/.zip archive is named, all its.class file members are printed.");
        printstream.println();
        printstream.println("You can name a single .class member of an archive with a jar: URL,");
        printstream.println("which looks like: jar:jar-spec!/p1/p2/cl.class");
        printstream.println("The jar-spec can be a URL or the name of the .jar file.");
        printstream.println("You can also use the shorthand syntax: jar:jar-spec!p1.p2.cl");
        System.exit(-1);
    }

    public Attribute readAttribute(String s, int i, AttrContainer attrcontainer)
        throws IOException
    {
        return super.readAttribute(s, i, attrcontainer);
    }

    public ConstantPool readConstants()
        throws IOException
    {
        ctype.constants = super.readConstants();
        return ctype.constants;
    }
}
