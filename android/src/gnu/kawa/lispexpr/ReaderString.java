// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.mapping.InPort;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, LispReader

public class ReaderString extends ReadTableEntry
{

    public ReaderString()
    {
    }

    public static String readString(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        char c;
        LineBufferedReader linebufferedreader;
        int i1;
        i1 = lexer.tokenBufferLength;
        linebufferedreader = lexer.getPort();
        c = '\0';
        int k = i;
        j = k;
        if (linebufferedreader instanceof InPort)
        {
            c = ((InPort)linebufferedreader).readState;
            ((InPort)linebufferedreader).readState = (char)i;
            j = k;
        }
_L13:
        if (j != 13) goto _L2; else goto _L1
_L1:
        int l = linebufferedreader.read();
        j = l;
        if (l == 10)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = l;
_L4:
        if (j != i)
        {
            break; /* Loop/switch isn't completed */
        }
        String s = (new String(lexer.tokenBuffer, i1, lexer.tokenBufferLength - i1)).intern();
        lexer.tokenBufferLength = i1;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c;
        }
        return s;
_L2:
        if (linebufferedreader.pos >= linebufferedreader.limit || j == 10)
        {
            break MISSING_BLOCK_LABEL_180;
        }
        char ac[];
        ac = linebufferedreader.buffer;
        j = linebufferedreader.pos;
        linebufferedreader.pos = j + 1;
        j = ac[j];
        continue; /* Loop/switch isn't completed */
        j = linebufferedreader.read();
        if (true) goto _L4; else goto _L3
_L8:
        if (j >= 0)
        {
            break MISSING_BLOCK_LABEL_199;
        }
        lexer.eofError("unexpected EOF in string literal");
        lexer.tokenBufferAppend(j);
        continue; /* Loop/switch isn't completed */
        Exception exception;
        exception;
        lexer.tokenBufferLength = i1;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c;
        }
        throw exception;
_L9:
        if (linebufferedreader.getConvertCR())
        {
            l = 10;
        } else
        {
            l = 13;
            j = 32;
        }
        lexer.tokenBufferAppend(l);
        continue; /* Loop/switch isn't completed */
_L10:
        if (!(lexer instanceof LispReader)) goto _L6; else goto _L5
_L5:
        l = ((LispReader)lexer).readEscape();
          goto _L7
_L6:
        l = linebufferedreader.read();
          goto _L7
_L3:
        j;
        JVM INSTR lookupswitch 2: default 312
    //                   13: 235
    //                   92: 256;
           goto _L8 _L9 _L10
_L7:
        j = l;
        if (l != -2) goto _L8; else goto _L11
_L11:
        j = 10;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        return readString(lexer, i, j);
    }
}
