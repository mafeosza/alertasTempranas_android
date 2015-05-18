// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.q2.lang;

import gnu.kawa.lispexpr.ReaderDispatchMisc;
import gnu.text.Lexer;
import gnu.text.LineBufferedReader;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.q2.lang:
//            Q2Read

class Q2ReaderParens extends ReaderDispatchMisc
{

    Q2ReaderParens()
    {
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        char c;
        lexer = (Q2Read)lexer;
        c = lexer.pushNesting('(');
        Object obj;
        obj = lexer.readCommand(true);
        if (lexer.getPort().read() != 41)
        {
            lexer.error("missing ')'");
        }
        lexer.popNesting(c);
        return obj;
        Exception exception;
        exception;
        lexer.popNesting(c);
        throw exception;
    }
}
