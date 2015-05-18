// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import gnu.lists.Consumer;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;

// Referenced classes of package gnu.text:
//            Char, Printable

public abstract class ReportFormat extends Format
{

    public static final int PARAM_FROM_COUNT = 0xb0000000;
    public static final int PARAM_FROM_LIST = 0xa0000000;
    public static final int PARAM_UNSPECIFIED = 0xc0000000;

    public ReportFormat()
    {
    }

    public static int format(Format format1, Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        if (format1 instanceof ReportFormat)
        {
            return ((ReportFormat)format1).format(aobj, i, writer, fieldposition);
        }
        StringBuffer stringbuffer = new StringBuffer();
        int j;
        if (format1 instanceof MessageFormat)
        {
            i = format(format1, aobj, i, stringbuffer, fieldposition);
        } else
        {
            format1.format(aobj[i], stringbuffer, fieldposition);
            i++;
        }
        j = stringbuffer.length();
        format1 = new char[j];
        stringbuffer.getChars(0, j, format1, 0);
        writer.write(format1);
        return i;
    }

    public static int format(Format format1, Object aobj[], int i, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (format1 instanceof ReportFormat)
        {
            return ((ReportFormat)format1).format(aobj, i, stringbuffer, fieldposition);
        }
        int j;
        if (format1 instanceof MessageFormat)
        {
            j = aobj.length - i;
            if (i > 0)
            {
                Object aobj1[] = new Object[aobj.length - i];
                System.arraycopy(((Object) (aobj)), i, ((Object) (aobj1)), 0, aobj1.length);
                aobj = aobj1;
            }
        } else
        {
            aobj = ((Object []) (aobj[i]));
            j = 1;
        }
        format1.format(((Object) (aobj)), stringbuffer, fieldposition);
        return i + j;
    }

    protected static char getParam(int i, char c, Object aobj[], int j)
    {
        return (char)getParam(i, c, aobj, j);
    }

    protected static int getParam(int i, int j, Object aobj[], int k)
    {
        if (i != 0xb0000000) goto _L2; else goto _L1
_L1:
        int l = aobj.length - k;
_L4:
        return l;
_L2:
        if (i != 0xa0000000)
        {
            break; /* Loop/switch isn't completed */
        }
        l = j;
        if (aobj != null)
        {
            return getParam(aobj[k], j);
        }
        if (true) goto _L4; else goto _L3
_L3:
        l = j;
        if (i != 0xc0000000)
        {
            return i;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static int getParam(Object obj, int i)
    {
        if (obj instanceof Number)
        {
            i = ((Number)obj).intValue();
        } else
        {
            if (obj instanceof Character)
            {
                return ((Character)obj).charValue();
            }
            if (obj instanceof Char)
            {
                return ((Char)obj).charValue();
            }
        }
        return i;
    }

    public static int nextArg(int i)
    {
        return 0xffffff & i;
    }

    public static void print(Writer writer, String s)
        throws IOException
    {
        if (writer instanceof PrintWriter)
        {
            ((PrintWriter)writer).print(s);
            return;
        } else
        {
            writer.write(s.toCharArray());
            return;
        }
    }

    public static void print(Object obj, Consumer consumer)
    {
        if (obj instanceof Printable)
        {
            ((Printable)obj).print(consumer);
            return;
        }
        if (obj == null)
        {
            obj = "null";
        } else
        {
            obj = obj.toString();
        }
        consumer.write(((String) (obj)));
    }

    public static int result(int i, int j)
    {
        return i << 24 | j;
    }

    public static int resultCode(int i)
    {
        return i >>> 24;
    }

    public int format(Object obj, int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        if (obj instanceof Object[])
        {
            return format((Object[])(Object[])obj, i, writer, fieldposition);
        } else
        {
            return format(new Object[] {
                obj
            }, i, writer, fieldposition);
        }
    }

    public abstract int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException;

    public int format(Object aobj[], int i, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        CharArrayWriter chararraywriter = new CharArrayWriter();
        try
        {
            i = format(aobj, i, ((Writer) (chararraywriter)), fieldposition);
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new Error((new StringBuilder()).append("unexpected exception: ").append(((Object) (aobj))).toString());
        }
        if (i < 0)
        {
            return i;
        } else
        {
            stringbuffer.append(chararraywriter.toCharArray());
            return i;
        }
    }

    public StringBuffer format(Object obj, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        format((Object[])(Object[])obj, 0, stringbuffer, fieldposition);
        return stringbuffer;
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new Error("ReportFormat.parseObject - not implemented");
    }
}
