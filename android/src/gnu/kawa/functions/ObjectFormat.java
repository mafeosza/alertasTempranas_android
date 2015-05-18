// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.AbstractFormat;
import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.ParsePosition;
import kawa.standard.Scheme;

public class ObjectFormat extends ReportFormat
{

    private static ObjectFormat plainFormat;
    private static ObjectFormat readableFormat;
    int maxChars;
    boolean readable;

    public ObjectFormat(boolean flag)
    {
        readable = flag;
        maxChars = 0xc0000000;
    }

    public ObjectFormat(boolean flag, int i)
    {
        readable = flag;
        maxChars = i;
    }

    public static int format(Object aobj[], int i, Writer writer, int j, boolean flag)
        throws IOException
    {
        if (i >= aobj.length)
        {
            aobj = "#<missing format argument>";
            i--;
            flag = false;
            j = -1;
        } else
        {
            aobj = ((Object []) (aobj[i]));
        }
        format(((Object) (aobj)), writer, j, flag);
        return i + 1;
    }

    public static boolean format(Object obj, Writer writer, int i, boolean flag)
        throws IOException
    {
        if (i < 0 && (writer instanceof OutPort))
        {
            print(obj, (OutPort)writer, flag);
            return true;
        }
        if (i < 0 && (writer instanceof CharArrayWriter))
        {
            writer = new OutPort(writer);
            print(obj, writer, flag);
            writer.close();
            return true;
        }
        CharArrayWriter chararraywriter = new CharArrayWriter();
        OutPort outport = new OutPort(chararraywriter);
        print(obj, outport, flag);
        outport.close();
        int j = chararraywriter.size();
        if (i < 0 || j <= i)
        {
            chararraywriter.writeTo(writer);
            return true;
        } else
        {
            writer.write(chararraywriter.toCharArray(), 0, i);
            return false;
        }
    }

    public static ObjectFormat getInstance(boolean flag)
    {
        if (flag)
        {
            if (readableFormat == null)
            {
                readableFormat = new ObjectFormat(true);
            }
            return readableFormat;
        }
        if (plainFormat == null)
        {
            plainFormat = new ObjectFormat(false);
        }
        return plainFormat;
    }

    private static void print(Object obj, OutPort outport, boolean flag)
    {
        AbstractFormat abstractformat1;
        boolean flag1;
        flag1 = outport.printReadable;
        abstractformat1 = outport.objectFormat;
        outport.printReadable = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        AbstractFormat abstractformat = Scheme.writeFormat;
_L1:
        outport.objectFormat = abstractformat;
        abstractformat.writeObject(obj, outport);
        outport.printReadable = flag1;
        outport.objectFormat = abstractformat1;
        return;
        abstractformat = Scheme.displayFormat;
          goto _L1
        obj;
        outport.printReadable = flag1;
        outport.objectFormat = abstractformat1;
        throw obj;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k = getParam(maxChars, -1, aobj, i);
        int j = i;
        if (maxChars == 0xa0000000)
        {
            j = i + 1;
        }
        return format(aobj, j, writer, k, readable);
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new RuntimeException("ObjectFormat.parseObject - not implemented");
    }
}
