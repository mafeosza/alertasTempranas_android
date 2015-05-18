// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipLoader extends ClassLoader
{

    private Vector loadedClasses;
    int size;
    ZipFile zar;
    private String zipname;

    public ZipLoader(String s)
        throws IOException
    {
        zipname = s;
        zar = new ZipFile(s);
        size = 0;
        s = zar.entries();
        do
        {
            if (!s.hasMoreElements())
            {
                break;
            }
            if (!((ZipEntry)s.nextElement()).isDirectory())
            {
                size = size + 1;
            }
        } while (true);
        loadedClasses = new Vector(size);
    }

    public void close()
        throws IOException
    {
        if (zar != null)
        {
            zar.close();
        }
        zar = null;
    }

    public Class loadAllClasses()
        throws IOException
    {
        Enumeration enumeration = zar.entries();
        Class class1;
        Object obj;
        for (class1 = null; enumeration.hasMoreElements(); class1 = ((Class) (obj)))
        {
            obj = (ZipEntry)enumeration.nextElement();
            Object obj1 = ((ZipEntry) (obj)).getName().replace('/', '.');
            String s = ((String) (obj1)).substring(0, ((String) (obj1)).length() - "/class".length());
            int i = (int)((ZipEntry) (obj)).getSize();
            obj = zar.getInputStream(((ZipEntry) (obj)));
            byte abyte0[] = new byte[i];
            (new DataInputStream(((java.io.InputStream) (obj)))).readFully(abyte0);
            abyte0 = defineClass(s, abyte0, 0, i);
            obj = class1;
            if (class1 == null)
            {
                obj = abyte0;
            }
            loadedClasses.addElement(s);
            loadedClasses.addElement(abyte0);
        }

        close();
        return class1;
    }

    public Class loadClass(String s, boolean flag)
        throws ClassNotFoundException
    {
        int i = loadedClasses.indexOf(s);
        if (i < 0) goto _L2; else goto _L1
_L1:
        Object obj = (Class)loadedClasses.elementAt(i + 1);
_L4:
        if (flag)
        {
            resolveClass(((Class) (obj)));
        }
        return ((Class) (obj));
_L2:
        if (zar == null && loadedClasses.size() == size * 2)
        {
            obj = Class.forName(s);
            continue; /* Loop/switch isn't completed */
        }
        boolean flag1 = false;
        String s1 = (new StringBuilder()).append(s.replace('.', '/')).append(".class").toString();
        if (zar == null)
        {
            try
            {
                zar = new ZipFile(zipname);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new ClassNotFoundException((new StringBuilder()).append("IOException while loading ").append(s1).append(" from ziparchive \"").append(s).append("\": ").append(((IOException) (obj)).toString()).toString());
            }
            flag1 = true;
        }
        obj = zar.getEntry(s1);
        if (obj == null)
        {
            if (flag1)
            {
                try
                {
                    close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    throw new RuntimeException((new StringBuilder()).append("failed to close \"").append(zipname).append("\"").toString());
                }
            }
            obj = Class.forName(s);
            continue; /* Loop/switch isn't completed */
        }
        Class class1;
        try
        {
            int j = (int)((ZipEntry) (obj)).getSize();
            obj = zar.getInputStream(((ZipEntry) (obj)));
            byte abyte0[] = new byte[j];
            (new DataInputStream(((java.io.InputStream) (obj)))).readFully(abyte0);
            class1 = defineClass(s, abyte0, 0, j);
            loadedClasses.addElement(s);
            loadedClasses.addElement(class1);
        }
        catch (IOException ioexception)
        {
            throw new ClassNotFoundException((new StringBuilder()).append("IOException while loading ").append(s1).append(" from ziparchive \"").append(s).append("\": ").append(ioexception.toString()).toString());
        }
        obj = class1;
        if (size * 2 != loadedClasses.size())
        {
            continue; /* Loop/switch isn't completed */
        }
        close();
        obj = class1;
        if (true) goto _L4; else goto _L3
_L3:
    }
}
