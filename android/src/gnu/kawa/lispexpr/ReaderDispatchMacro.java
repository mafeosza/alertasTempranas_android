// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.mapping.Procedure;
import gnu.math.IntNum;
import gnu.text.Char;
import gnu.text.Lexer;
import gnu.text.SyntaxException;
import java.io.IOException;

// Referenced classes of package gnu.kawa.lispexpr:
//            ReaderMisc

public class ReaderDispatchMacro extends ReaderMisc
{

    Procedure procedure;

    public ReaderDispatchMacro(Procedure procedure1)
    {
        super(5);
        procedure = procedure1;
    }

    public Procedure getProcedure()
    {
        return procedure;
    }

    public Object read(Lexer lexer, int i, int j)
        throws IOException, SyntaxException
    {
        Object obj = lexer.getPort();
        try
        {
            obj = procedure.apply3(obj, Char.make(i), IntNum.make(j));
        }
        // Misplaced declaration of an exception variable
        catch (Lexer lexer)
        {
            throw lexer;
        }
        // Misplaced declaration of an exception variable
        catch (Lexer lexer)
        {
            throw lexer;
        }
        catch (Throwable throwable)
        {
            lexer.fatal((new StringBuilder()).append("reader macro '").append(procedure).append("' threw: ").append(throwable).toString());
            return null;
        }
        return obj;
    }
}
