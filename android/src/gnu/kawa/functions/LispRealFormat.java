// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.math.ExponentialFormat;
import gnu.math.FixedRealFormat;
import gnu.math.RealNum;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

class LispRealFormat extends ReportFormat
{

    int arg1;
    int arg2;
    int arg3;
    int arg4;
    int arg5;
    int arg6;
    int arg7;
    int argsUsed;
    boolean internalPad;
    char op;
    boolean showPlus;

    LispRealFormat()
    {
        int i;
        if (arg1 == 0xb0000000 || arg2 == 0xb0000000 || arg3 == 0xb0000000 || arg4 == 0xb0000000 || arg5 == 0xb0000000 || arg6 == 0xb0000000 || arg7 == 0xb0000000)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        argsUsed = i;
        if (arg1 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
        if (arg2 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
        if (arg3 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
        if (arg4 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
        if (arg5 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
        if (arg6 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
        if (arg7 == 0xa0000000)
        {
            argsUsed = argsUsed + 2;
        }
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        StringBuffer stringbuffer = new StringBuffer(100);
        Format format1 = resolve(aobj, i);
        i += argsUsed >> 1;
        format1.format((RealNum)aobj[i], stringbuffer, fieldposition);
        writer.write(stringbuffer.toString());
        return i + 1;
    }

    public Format resolve(Object aobj[], int i)
    {
        if (op == '$')
        {
            FixedRealFormat fixedrealformat = new FixedRealFormat();
            int i1 = getParam(arg1, 2, aobj, i);
            int j = i;
            if (arg1 == 0xa0000000)
            {
                j = i + 1;
            }
            int k1 = getParam(arg2, 1, aobj, j);
            i = j;
            if (arg2 == 0xa0000000)
            {
                i = j + 1;
            }
            int i2 = getParam(arg3, 0, aobj, i);
            j = i;
            if (arg3 == 0xa0000000)
            {
                j = i + 1;
            }
            char c = getParam(arg4, ' ', aobj, j);
            if (arg4 != 0xa0000000);
            fixedrealformat.setMaximumFractionDigits(i1);
            fixedrealformat.setMinimumIntegerDigits(k1);
            fixedrealformat.width = i2;
            fixedrealformat.padChar = c;
            fixedrealformat.internalPad = internalPad;
            fixedrealformat.showPlus = showPlus;
            return fixedrealformat;
        }
        if (op == 'F')
        {
            FixedRealFormat fixedrealformat1 = new FixedRealFormat();
            int j1 = getParam(arg1, 0, aobj, i);
            int k = i;
            if (arg1 == 0xa0000000)
            {
                k = i + 1;
            }
            int l1 = getParam(arg2, -1, aobj, k);
            i = k;
            if (arg2 == 0xa0000000)
            {
                i = k + 1;
            }
            int j2 = getParam(arg3, 0, aobj, i);
            k = i;
            if (arg3 == 0xa0000000)
            {
                k = i + 1;
            }
            fixedrealformat1.overflowChar = getParam(arg4, '\0', aobj, k);
            i = k;
            if (arg4 == 0xa0000000)
            {
                i = k + 1;
            }
            char c1 = getParam(arg5, ' ', aobj, i);
            if (arg5 != 0xa0000000);
            fixedrealformat1.setMaximumFractionDigits(l1);
            fixedrealformat1.setMinimumIntegerDigits(0);
            fixedrealformat1.width = j1;
            fixedrealformat1.scale = j2;
            fixedrealformat1.padChar = c1;
            fixedrealformat1.internalPad = internalPad;
            fixedrealformat1.showPlus = showPlus;
            return fixedrealformat1;
        }
        ExponentialFormat exponentialformat = new ExponentialFormat();
        exponentialformat.exponentShowSign = true;
        exponentialformat.width = getParam(arg1, 0, aobj, i);
        int l = i;
        if (arg1 == 0xa0000000)
        {
            l = i + 1;
        }
        exponentialformat.fracDigits = getParam(arg2, -1, aobj, l);
        i = l;
        if (arg2 == 0xa0000000)
        {
            i = l + 1;
        }
        exponentialformat.expDigits = getParam(arg3, 0, aobj, i);
        l = i;
        if (arg3 == 0xa0000000)
        {
            l = i + 1;
        }
        exponentialformat.intDigits = getParam(arg4, 1, aobj, l);
        i = l;
        if (arg4 == 0xa0000000)
        {
            i = l + 1;
        }
        exponentialformat.overflowChar = getParam(arg5, '\0', aobj, i);
        l = i;
        if (arg5 == 0xa0000000)
        {
            l = i + 1;
        }
        exponentialformat.padChar = getParam(arg6, ' ', aobj, l);
        i = l;
        if (arg6 == 0xa0000000)
        {
            i = l + 1;
        }
        exponentialformat.exponentChar = getParam(arg7, 'E', aobj, i);
        if (arg7 != 0xa0000000);
        boolean flag;
        if (op == 'G')
        {
            flag = true;
        } else
        {
            flag = false;
        }
        exponentialformat.general = flag;
        exponentialformat.showPlus = showPlus;
        return exponentialformat;
    }
}
