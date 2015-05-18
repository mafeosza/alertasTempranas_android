// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, LispReader, ReadTable

public class ReaderColon extends ReadTableEntry
{

    public ReaderColon()
    {
    }

    public int getKind()
    {
        return 6;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        lexer = (LispReader)lexer;
        ReadTable readtable = ReadTable.getCurrent();
        int k = ((LispReader) (lexer)).tokenBufferLength;
        j = i;
        if (i == readtable.postfixLookupOperator)
        {
            j = lexer.read();
            if (j == 58)
            {
                return readtable.makeSymbol("::");
            }
            lexer.tokenBufferAppend(i);
        }
        return lexer.readAndHandleToken(j, k, readtable);
    }
}
