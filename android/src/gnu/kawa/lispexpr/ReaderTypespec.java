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
//            ReadTableEntry, ReadTable, LispReader

public class ReaderTypespec extends ReadTableEntry
{

    public ReaderTypespec()
    {
    }

    public int getKind()
    {
        return 6;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        char c;
        LineBufferedReader linebufferedreader;
        Object obj;
        int l;
        l = lexer.tokenBufferLength;
        linebufferedreader = lexer.getPort();
        obj = ReadTable.getCurrent();
        c = '\0';
        lexer.tokenBufferAppend(i);
        j = i;
        if (linebufferedreader instanceof InPort)
        {
            c = ((InPort)linebufferedreader).readState;
            ((InPort)linebufferedreader).readState = (char)i;
        }
        i = 0;
_L7:
        if (linebufferedreader.pos >= linebufferedreader.limit || j == 10) goto _L2; else goto _L1
_L1:
        char ac[];
        ac = linebufferedreader.buffer;
        j = linebufferedreader.pos;
        linebufferedreader.pos = j + 1;
        j = ac[j];
_L8:
        if (j != 92) goto _L4; else goto _L3
_L3:
        if (!(lexer instanceof LispReader)) goto _L6; else goto _L5
_L5:
        j = ((LispReader)lexer).readEscape();
          goto _L7
_L2:
        j = linebufferedreader.read();
          goto _L8
_L6:
        j = linebufferedreader.read();
          goto _L7
_L13:
        if (((ReadTable) (obj)).lookup(j).getKind() != 2) goto _L10; else goto _L9
_L9:
        lexer.tokenBufferAppend(j);
          goto _L7
        Exception exception;
        exception;
        lexer.tokenBufferLength = l;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c;
        }
        throw exception;
_L10:
        lexer.unread(j);
        exception = (new String(lexer.tokenBuffer, l, lexer.tokenBufferLength - l)).intern();
        lexer.tokenBufferLength = l;
        if (linebufferedreader instanceof InPort)
        {
            ((InPort)linebufferedreader).readState = c;
        }
        return exception;
_L4:
        int k;
        k = i;
        if (i != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k = i;
        if (j != 91)
        {
            break; /* Loop/switch isn't completed */
        }
        k = 1;
        i = 1;
        if (true) goto _L9; else goto _L11
_L11:
        i = k;
        if (k == 0) goto _L13; else goto _L12
_L12:
        i = k;
        if (j != 93) goto _L13; else goto _L14
_L14:
        i = 0;
        k = 0;
        if (true) goto _L9; else goto _L15
_L15:
        i = k;
          goto _L13
    }
}
