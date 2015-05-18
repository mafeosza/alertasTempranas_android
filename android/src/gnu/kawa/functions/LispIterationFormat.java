// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

// Referenced classes of package gnu.kawa.functions:
//            LispFormat

class LispIterationFormat extends ReportFormat
{

    boolean atLeastOnce;
    Format body;
    int maxIterations;
    boolean seenAt;
    boolean seenColon;

    LispIterationFormat()
    {
    }

    public static int format(Format format1, int i, Object aobj[], int j, Writer writer, boolean flag, boolean flag1)
        throws IOException
    {
        int k = 0;
_L8:
        if (k != i || i == -1) goto _L2; else goto _L1
_L1:
        int l = j;
_L4:
        return l;
_L2:
        if (j != aobj.length)
        {
            break; /* Loop/switch isn't completed */
        }
        l = j;
        if (k > 0) goto _L4; else goto _L3
_L3:
        l = j;
        if (!flag1) goto _L4; else goto _L5
_L5:
        int j1;
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        Object aobj1[] = LispFormat.asArray(aobj[j]);
        if (aobj1 != null);
        j1 = ReportFormat.format(format1, aobj1, 0, writer, null);
        j++;
        l = j;
        if (ReportFormat.resultCode(j1) == 242) goto _L4; else goto _L6
_L6:
        k++;
        if (true) goto _L8; else goto _L7
_L7:
        int i1 = ReportFormat.format(format1, aobj, j, writer, null);
        j = i1;
        if (i1 < 0)
        {
            return ReportFormat.nextArg(i1);
        }
          goto _L6
        if (true) goto _L8; else goto _L9
_L9:
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int k = getParam(maxIterations, -1, aobj, i);
        int j = i;
        if (maxIterations == 0xa0000000)
        {
            j = i + 1;
        }
        Format format1 = body;
        fieldposition = format1;
        i = j;
        if (format1 == null)
        {
            i = j + 1;
            fieldposition = ((FieldPosition) (aobj[j]));
            if (fieldposition instanceof Format)
            {
                fieldposition = (Format)fieldposition;
            } else
            {
                try
                {
                    fieldposition = new LispFormat(fieldposition.toString());
                }
                // Misplaced declaration of an exception variable
                catch (FieldPosition fieldposition)
                {
                    print(writer, "<invalid argument for \"~{~}\" format>");
                    return aobj.length;
                }
            }
        }
        if (seenAt)
        {
            return format(((Format) (fieldposition)), k, aobj, i, writer, seenColon, atLeastOnce);
        }
        aobj = ((Object []) (aobj[i]));
        Object aobj1[] = LispFormat.asArray(((Object) (aobj)));
        if (aobj1 == null)
        {
            writer.write((new StringBuilder()).append("{").append(((Object) (aobj))).append("}".toString()).toString());
        } else
        {
            format(((Format) (fieldposition)), k, aobj1, 0, writer, seenColon, atLeastOnce);
        }
        return i + 1;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("LispIterationFormat[");
        stringbuffer.append(body);
        stringbuffer.append("]");
        return stringbuffer.toString();
    }
}
