// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReaderMisc

public abstract class ReadTableEntry
{

    public static final ReadTableEntry brace = new ReaderMisc(2);
    public static final ReadTableEntry constituent = new ReaderMisc(2);
    public static final ReadTableEntry illegal = new ReaderMisc(0);
    public static final ReadTableEntry multipleEscape = new ReaderMisc(4);
    public static final ReadTableEntry singleEscape = new ReaderMisc(3);
    public static final ReadTableEntry whitespace = new ReaderMisc(1);

    public ReadTableEntry()
    {
    }

    public static ReadTableEntry getConstituentInstance()
    {
        return constituent;
    }

    public static ReadTableEntry getDigitInstance()
    {
        return constituent;
    }

    public static ReadTableEntry getIllegalInstance()
    {
        return illegal;
    }

    public static ReadTableEntry getMultipleEscapeInstance()
    {
        return multipleEscape;
    }

    public static ReadTableEntry getSingleEscapeInstance()
    {
        return singleEscape;
    }

    public static ReadTableEntry getWhitespaceInstance()
    {
        return whitespace;
    }

    public int getKind()
    {
        return 5;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        throw new Error("invalid character");
    }

}
