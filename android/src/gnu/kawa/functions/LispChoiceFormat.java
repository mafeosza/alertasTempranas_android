// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

class LispChoiceFormat extends ReportFormat
{

    Format choices[];
    boolean lastIsDefault;
    int param;
    boolean skipIfFalse;
    boolean testBoolean;

    LispChoiceFormat()
    {
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int j = 0;
        if (!testBoolean) goto _L2; else goto _L1
_L1:
        Format format1;
        Format aformat[] = choices;
        if (aobj[i] != Boolean.FALSE)
        {
            j = 1;
        }
        format1 = aformat[j];
        i++;
_L4:
        return ReportFormat.format(format1, aobj, i, writer, fieldposition);
_L2:
label0:
        {
            int k;
label1:
            {
label2:
                {
                    if (skipIfFalse)
                    {
                        break label0;
                    }
                    int l = getParam(param, 0xa0000000, aobj, i);
                    k = i;
                    if (param == 0xa0000000)
                    {
                        k = i + 1;
                    }
                    if (l >= 0)
                    {
                        i = l;
                        if (l < choices.length)
                        {
                            break label2;
                        }
                    }
                    if (!lastIsDefault)
                    {
                        break label1;
                    }
                    i = choices.length - 1;
                }
                format1 = choices[i];
                i = k;
                continue; /* Loop/switch isn't completed */
            }
            return k;
        }
        if (aobj[i] == Boolean.FALSE)
        {
            return i + 1;
        }
        format1 = choices[0];
        if (true) goto _L4; else goto _L3
_L3:
    }
}
