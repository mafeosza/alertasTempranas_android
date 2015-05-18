// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.mapping.InPort;
import gnu.mapping.WrappedException;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CompileFile
{

    public CompileFile()
    {
    }

    public static final Compilation read(InPort inport, SourceMessages sourcemessages)
        throws IOException, SyntaxException
    {
        return Language.getDefaultLanguage().parse(inport, sourcemessages, 0);
    }

    public static final Compilation read(String s, SourceMessages sourcemessages)
        throws IOException, SyntaxException
    {
        try
        {
            InPort inport = InPort.openFile(s);
            sourcemessages = read(inport, sourcemessages);
            inport.close();
        }
        // Misplaced declaration of an exception variable
        catch (SourceMessages sourcemessages)
        {
            throw new WrappedException((new StringBuilder()).append("compile-file: file not found: ").append(s).toString(), sourcemessages);
        }
        // Misplaced declaration of an exception variable
        catch (SourceMessages sourcemessages)
        {
            throw new WrappedException((new StringBuilder()).append("compile-file: read-error: ").append(s).toString(), sourcemessages);
        }
        return sourcemessages;
    }
}
