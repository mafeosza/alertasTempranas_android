// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;

// Referenced classes of package gnu.text:
//            ReportFormat

public class PadFormat extends ReportFormat
{

    Format fmt;
    int minWidth;
    char padChar;
    int where;

    public PadFormat(Format format1, int i)
    {
        this(format1, i, ' ', 100);
    }

    public PadFormat(Format format1, int i, char c, int j)
    {
        fmt = format1;
        minWidth = i;
        padChar = c;
        where = j;
    }

    public static int format(Format format1, Object aobj[], int i, Writer writer, char c, int j, int k, int l, 
            int i1, FieldPosition fieldposition)
        throws IOException
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
                            StringBuffer stringbuffer = new StringBuffer(200);
                            int j1;
                            if (format1 instanceof ReportFormat)
                            {
                                i = ((ReportFormat)format1).format(aobj, i, stringbuffer, fieldposition);
                            } else
                            if (format1 instanceof MessageFormat)
                            {
                                format1.format(((Object) (aobj)), stringbuffer, fieldposition);
                                i = aobj.length;
                            } else
                            {
                                format1.format(aobj[i], stringbuffer, fieldposition);
                                i++;
                            }
                            j1 = stringbuffer.length();
                            l = padNeeded(j1, j, k, l);
                            k = 0;
                            aobj = stringbuffer.toString();
                            if (l <= 0)
                            {
                                break label1;
                            }
                            format1 = ((Format) (aobj));
                            j = i1;
                            if (i1 != -1)
                            {
                                break label2;
                            }
                            format1 = ((Format) (aobj));
                            if (j1 <= 0)
                            {
                                break label3;
                            }
                            j = ((String) (aobj)).charAt(0);
                            if (j == 45 || j == 43)
                            {
                                k = 0 + 1;
                                writer.write(j);
                            }
                            j = k;
                            if (j1 - k <= 2)
                            {
                                break label4;
                            }
                            j = k;
                            if (((String) (aobj)).charAt(k) != '0')
                            {
                                break label4;
                            }
                            writer.write(48);
                            k++;
                            i1 = ((String) (aobj)).charAt(k);
                            if (i1 != 120)
                            {
                                j = k;
                                if (i1 != 88)
                                {
                                    break label4;
                                }
                            }
                            j = k + 1;
                            writer.write(i1);
                        }
                        format1 = ((Format) (aobj));
                        if (j > 0)
                        {
                            format1 = ((String) (aobj)).substring(j);
                        }
                    }
                    j = 0;
                }
                k = (l * j) / 100;
                j = l - k;
                do
                {
                    j--;
                    if (j < 0)
                    {
                        break;
                    }
                    writer.write(c);
                } while (true);
                writer.write(format1);
                j = k;
                do
                {
                    j--;
                    if (j < 0)
                    {
                        break;
                    }
                    writer.write(c);
                } while (true);
                break label0;
            }
            writer.write(((String) (aobj)));
        }
        return i;
    }

    public static int padNeeded(int i, int j, int k, int l)
    {
        int j1 = i + l;
        int i1 = j1;
        l = k;
        if (k <= 1)
        {
            l = j - j1;
            i1 = j1;
        }
        for (; i1 < j; i1 += l) { }
        return i1 - i;
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        return format(fmt, aobj, i, writer, padChar, minWidth, 1, 0, where, fieldposition);
    }
}
