// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.PrintStream;
import java.io.PrintWriter;

// Referenced classes of package gnu.text:
//            SourceLocator, LineBufferedReader

public class SourceError
    implements SourceLocator
{

    public String code;
    public int column;
    public Throwable fakeException;
    public String filename;
    public int line;
    public String message;
    public SourceError next;
    public char severity;

    public SourceError(char c, SourceLocator sourcelocator, String s)
    {
        this(c, sourcelocator.getFileName(), sourcelocator.getLineNumber(), sourcelocator.getColumnNumber(), s);
    }

    public SourceError(char c, String s, int i, int j, String s1)
    {
        severity = c;
        filename = s;
        line = i;
        column = j;
        message = s1;
    }

    public SourceError(LineBufferedReader linebufferedreader, char c, String s)
    {
        this(c, linebufferedreader.getName(), linebufferedreader.getLineNumber() + 1, linebufferedreader.getColumnNumber(), s);
        if (column >= 0)
        {
            column = column + 1;
        }
    }

    public int getColumnNumber()
    {
        if (column == 0)
        {
            return -1;
        } else
        {
            return column;
        }
    }

    public String getFileName()
    {
        return filename;
    }

    public int getLineNumber()
    {
        if (line == 0)
        {
            return -1;
        } else
        {
            return line;
        }
    }

    public String getPublicId()
    {
        return null;
    }

    public String getSystemId()
    {
        return filename;
    }

    public boolean isStableSourceLocation()
    {
        return true;
    }

    public void print(PrintWriter printwriter)
    {
        printwriter.print(this);
    }

    public void println(PrintStream printstream)
    {
        String s = toString();
        do
        {
            int i = s.indexOf('\n');
            if (i < 0)
            {
                printstream.println(s);
                return;
            }
            printstream.println(s.substring(0, i));
            s = s.substring(i + 1);
        } while (true);
    }

    public void println(PrintWriter printwriter)
    {
        String s = toString();
        do
        {
            int i = s.indexOf('\n');
            if (i < 0)
            {
                printwriter.println(s);
                return;
            }
            printwriter.println(s.substring(0, i));
            s = s.substring(i + 1);
        } while (true);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        Object obj;
        if (filename == null)
        {
            obj = "<unknown>";
        } else
        {
            obj = filename;
        }
        stringbuffer.append(((String) (obj)));
        if (line > 0 || column > 0)
        {
            stringbuffer.append(':');
            stringbuffer.append(line);
            if (column > 0)
            {
                stringbuffer.append(':');
                stringbuffer.append(column);
            }
        }
        stringbuffer.append(": ");
        if (severity == 'w')
        {
            stringbuffer.append("warning - ");
        }
        stringbuffer.append(message);
        if (code != null)
        {
            stringbuffer.append(" [");
            stringbuffer.append(code);
            stringbuffer.append("]");
        }
        if (fakeException != null)
        {
            obj = fakeException.getStackTrace();
            for (int i = 0; i < obj.length; i++)
            {
                stringbuffer.append("\n");
                stringbuffer.append("    ");
                stringbuffer.append(obj[i].toString());
            }

        }
        return stringbuffer.toString();
    }
}
