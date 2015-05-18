// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipArchive
{

    public ZipArchive()
    {
    }

    public static long copy(InputStream inputstream, OutputStream outputstream, byte abyte0[])
        throws IOException
    {
        long l = 0L;
        do
        {
            int i = inputstream.read(abyte0);
            if (i <= 0)
            {
                return l;
            }
            outputstream.write(abyte0, 0, i);
            l += i;
        } while (true);
    }

    public static void copy(InputStream inputstream, String s, byte abyte0[])
        throws IOException
    {
        File file = new File(s);
        Object obj = file.getParent();
        if (obj != null)
        {
            obj = new File(((String) (obj)));
            if (!((File) (obj)).exists())
            {
                System.err.println((new StringBuilder()).append("mkdirs:").append(((File) (obj)).mkdirs()).toString());
            }
        }
        if (s.charAt(s.length() - 1) != '/')
        {
            s = new BufferedOutputStream(new FileOutputStream(file));
            copy(inputstream, ((OutputStream) (s)), abyte0);
            s.close();
        }
    }

    public static void main(String args[])
        throws IOException
    {
        Object obj;
        Object obj1;
        if (args.length < 2)
        {
            usage();
        }
        obj = args[0];
        obj1 = args[1];
        if (!((String) (obj)).equals("t") && !((String) (obj)).equals("p") && !((String) (obj)).equals("x")) goto _L2; else goto _L1
_L1:
        PrintStream printstream;
        byte abyte0[];
        printstream = System.out;
        abyte0 = new byte[1024];
        if (args.length != 2) goto _L4; else goto _L3
_L3:
        args = new ZipInputStream(new BufferedInputStream(new FileInputStream(((String) (obj1)))));
_L9:
        obj1 = args.getNextEntry();
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        Object obj3 = ((ZipEntry) (obj1)).getName();
        if (!((String) (obj)).equals("t")) goto _L8; else goto _L7
_L7:
        printstream.print(((String) (obj3)));
        printstream.print(" size: ");
        printstream.println(((ZipEntry) (obj1)).getSize());
          goto _L9
_L6:
        return;
_L8:
label0:
        {
            if (!((String) (obj)).equals("p"))
            {
                break label0;
            }
            copy(args, printstream, abyte0);
        }
          goto _L9
        copy(args, ((String) (obj3)), abyte0);
          goto _L9
_L4:
        obj3 = new ZipFile(((String) (obj1)));
        int i = 2;
_L13:
        if (i >= args.length) goto _L6; else goto _L10
_L10:
        String s = args[i];
        ZipEntry zipentry = ((ZipFile) (obj3)).getEntry(s);
        if (zipentry != null)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        System.err.println((new StringBuilder()).append("zipfile ").append(((String) (obj1))).append(":").append(args[i]).append(" - not found").toString());
        System.exit(-1);
        break MISSING_BLOCK_LABEL_609;
        if (((String) (obj)).equals("t"))
        {
            printstream.print(s);
            printstream.print(" size: ");
            printstream.println(zipentry.getSize());
            break MISSING_BLOCK_LABEL_609;
        }
        if (((String) (obj)).equals("p"))
        {
            copy(((ZipFile) (obj3)).getInputStream(zipentry), printstream, abyte0);
            break MISSING_BLOCK_LABEL_609;
        }
        copy(((ZipFile) (obj3)).getInputStream(zipentry), s, abyte0);
        break MISSING_BLOCK_LABEL_609;
_L2:
        if (!((String) (obj)).equals("q"))
        {
            break MISSING_BLOCK_LABEL_605;
        }
        obj = new ZipOutputStream(new FileOutputStream(((String) (obj1))));
        i = 2;
_L12:
        if (i >= args.length)
        {
            break; /* Loop/switch isn't completed */
        }
        File file = new File(args[i]);
        if (!file.exists())
        {
            throw new IOException((new StringBuilder()).append(args[i]).append(" - not found").toString());
        }
        if (!file.canRead())
        {
            throw new IOException((new StringBuilder()).append(args[i]).append(" - not readable").toString());
        }
        int j = (int)file.length();
        Object obj2 = new FileInputStream(file);
        byte abyte1[] = new byte[j];
        if (((FileInputStream) (obj2)).read(abyte1) != j)
        {
            throw new IOException((new StringBuilder()).append(args[i]).append(" - read error").toString());
        }
        ((FileInputStream) (obj2)).close();
        obj2 = new ZipEntry(args[i]);
        ((ZipEntry) (obj2)).setSize(j);
        ((ZipEntry) (obj2)).setTime(file.lastModified());
        ((ZipOutputStream) (obj)).putNextEntry(((ZipEntry) (obj2)));
        ((ZipOutputStream) (obj)).write(abyte1, 0, j);
        i++;
        if (true) goto _L12; else goto _L11
_L11:
        try
        {
            ((ZipOutputStream) (obj)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String args[])
        {
            System.err.println((new StringBuilder()).append("I/O Exception:  ").append(args).toString());
        }
          goto _L6
        usage();
        return;
        i++;
          goto _L13
    }

    private static void usage()
    {
        System.err.println("zipfile [ptxq] archive [file ...]");
        System.exit(-1);
    }
}
