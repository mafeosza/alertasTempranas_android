// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.text.Char;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;

class LispCharacterFormat extends ReportFormat
{

    int charVal;
    int count;
    boolean seenAt;
    boolean seenColon;

    LispCharacterFormat()
    {
    }

    public static LispCharacterFormat getInstance(int i, int j, boolean flag, boolean flag1)
    {
        LispCharacterFormat lispcharacterformat = new LispCharacterFormat();
        lispcharacterformat.count = j;
        lispcharacterformat.charVal = i;
        lispcharacterformat.seenAt = flag;
        lispcharacterformat.seenColon = flag1;
        return lispcharacterformat;
    }

    public static void printChar(int i, boolean flag, boolean flag1, Writer writer)
        throws IOException
    {
        if (flag)
        {
            print(writer, Char.toScmReadableString(i));
            return;
        }
        if (flag1)
        {
            if (i < 32)
            {
                writer.write(94);
                writer.write(i + 64);
                return;
            }
            if (i >= 127)
            {
                print(writer, "#\\x");
                print(writer, Integer.toString(i, 16));
                return;
            } else
            {
                writer.write(i);
                return;
            }
        } else
        {
            writer.write(i);
            return;
        }
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        int l = getParam(count, 1, aobj, i);
        int j = i;
        if (count == 0xa0000000)
        {
            j = i + 1;
        }
        char c = getParam(charVal, '?', aobj, j);
        int k = l;
        i = j;
        if (charVal == 0xa0000000)
        {
            i = j + 1;
            k = l;
        }
        do
        {
            k--;
            if (k >= 0)
            {
                printChar(c, seenAt, seenColon, writer);
            } else
            {
                return i;
            }
        } while (true);
    }
}
