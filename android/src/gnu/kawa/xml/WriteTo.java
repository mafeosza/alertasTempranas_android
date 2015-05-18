// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.mapping.OutPort;
import gnu.mapping.Procedure2;
import gnu.mapping.Values;
import gnu.text.Path;
import gnu.xml.XMLPrinter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class WriteTo extends Procedure2
{

    public static final WriteTo writeTo = new WriteTo();
    public static final WriteTo writeToIfChanged;
    boolean ifChanged;

    public WriteTo()
    {
    }

    public static void writeTo(Object obj, Path path, OutputStream outputstream)
        throws Throwable
    {
        outputstream = new OutPort(outputstream, path);
        XMLPrinter xmlprinter = new XMLPrinter(outputstream, false);
        if ("html".equals(path.getExtension()))
        {
            xmlprinter.setStyle("html");
        }
        Values.writeValues(obj, xmlprinter);
        outputstream.close();
    }

    public static void writeTo(Object obj, Object obj1)
        throws Throwable
    {
        obj1 = Path.valueOf(obj1);
        writeTo(obj, ((Path) (obj1)), ((Path) (obj1)).openOutputStream());
    }

    public static void writeToIfChanged(Object obj, Object obj1)
        throws Throwable
    {
        obj1 = Path.valueOf(obj1);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        writeTo(obj, ((Path) (obj1)), bytearrayoutputstream);
        obj = bytearrayoutputstream.toByteArray();
        BufferedInputStream bufferedinputstream = new BufferedInputStream(((Path) (obj1)).openInputStream());
        int i = 0;
_L2:
        int j = bufferedinputstream.read();
        byte byte0;
        if (i == obj.length)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
          goto _L1
_L5:
        try
        {
            bufferedinputstream.close();
        }
        catch (Throwable throwable) { }
        obj1 = new BufferedOutputStream(((Path) (obj1)).openOutputStream());
        ((OutputStream) (obj1)).write(((byte []) (obj)));
        ((OutputStream) (obj1)).close();
        return;
_L6:
        bufferedinputstream.close();
        return;
_L4:
        if (byte0 != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        byte0 = obj[i];
        if (byte0 != j)
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
          goto _L2
_L1:
        if (j >= 0) goto _L4; else goto _L3
_L3:
        if (byte0 != 0) goto _L6; else goto _L5
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        if (ifChanged)
        {
            writeToIfChanged(obj, obj1.toString());
        } else
        {
            writeTo(obj, obj1.toString());
        }
        return Values.empty;
    }

    static 
    {
        writeToIfChanged = new WriteTo();
        writeToIfChanged.ifChanged = true;
    }
}
