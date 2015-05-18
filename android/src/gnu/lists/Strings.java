// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.PrintWriter;

// Referenced classes of package gnu.lists:
//            CharSeq

public class Strings
{

    public Strings()
    {
    }

    public static void makeCapitalize(CharSeq charseq)
    {
        char c = ' ';
        int j = charseq.length();
        int i = 0;
        while (i < j) 
        {
            char c1 = charseq.charAt(i);
            if (!Character.isLetterOrDigit(c))
            {
                c = Character.toTitleCase(c1);
            } else
            {
                c = Character.toLowerCase(c1);
            }
            charseq.setCharAt(i, c);
            i++;
        }
    }

    public static void makeLowerCase(CharSeq charseq)
    {
        int i = charseq.length();
        do
        {
            i--;
            if (i >= 0)
            {
                charseq.setCharAt(i, Character.toLowerCase(charseq.charAt(i)));
            } else
            {
                return;
            }
        } while (true);
    }

    public static void makeUpperCase(CharSeq charseq)
    {
        int i = charseq.length();
        do
        {
            i--;
            if (i >= 0)
            {
                charseq.setCharAt(i, Character.toUpperCase(charseq.charAt(i)));
            } else
            {
                return;
            }
        } while (true);
    }

    public static void printQuoted(CharSequence charsequence, PrintWriter printwriter, int i)
    {
        int j;
        int k;
        k = charsequence.length();
        printwriter.print('"');
        j = 0;
_L8:
        char c;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        c = charsequence.charAt(j);
        if (c != '\\' && c != '"') goto _L2; else goto _L1
_L1:
        printwriter.print('\\');
_L4:
        printwriter.print(c);
_L5:
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        if (i <= 0) goto _L4; else goto _L3
_L3:
        if (c == '\n')
        {
            printwriter.print("\\n");
        } else
        if (c == '\r')
        {
            printwriter.print("\\r");
        } else
        if (c == '\t')
        {
            printwriter.print("\\t");
        } else
        if (c == '\007')
        {
            printwriter.print("\\a");
        } else
        if (c == '\b')
        {
            printwriter.print("\\b");
        } else
        {
            if (c != '\013')
            {
                continue; /* Loop/switch isn't completed */
            }
            printwriter.print("\\v");
        }
          goto _L5
        if (c != '\f') goto _L4; else goto _L6
_L6:
        printwriter.print("\\f");
          goto _L5
        printwriter.print('"');
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }
}
