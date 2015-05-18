// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.lists.PairWithPosition;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReadTableEntry, LispReader

public class ReaderQuote extends ReadTableEntry
{

    Object magicSymbol;
    Object magicSymbol2;
    char next;

    public ReaderQuote(Object obj)
    {
        magicSymbol = obj;
    }

    public ReaderQuote(Object obj, char c, Object obj1)
    {
        next = c;
        magicSymbol = obj;
        magicSymbol2 = obj1;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        Object obj;
        LispReader lispreader;
        String s;
        lispreader = (LispReader)lexer;
        s = lispreader.getName();
        i = lispreader.getLineNumber();
        j = lispreader.getColumnNumber();
        obj = magicSymbol;
        lexer = ((Lexer) (obj));
        if (next == 0) goto _L2; else goto _L1
_L1:
        int k = lispreader.read();
        if (k != next) goto _L4; else goto _L3
_L3:
        lexer = ((Lexer) (magicSymbol2));
_L2:
        k = lispreader.getLineNumber();
        int l = lispreader.getColumnNumber();
        return PairWithPosition.make(lexer, PairWithPosition.make(lispreader.readObject(), lispreader.makeNil(), s, k + 1, l + 1), s, i + 1, j + 1);
_L4:
        lexer = ((Lexer) (obj));
        if (k >= 0)
        {
            lispreader.unread(k);
            lexer = ((Lexer) (obj));
        }
        if (true) goto _L2; else goto _L5
_L5:
    }
}
