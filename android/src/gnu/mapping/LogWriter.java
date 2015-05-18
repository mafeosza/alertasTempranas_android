// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class LogWriter extends FilterWriter
{

    private Writer log;

    public LogWriter(Writer writer)
    {
        super(writer);
    }

    public void close()
        throws IOException
    {
        if (log != null)
        {
            log.close();
        }
        super.close();
    }

    public void closeLogFile()
        throws IOException
    {
        if (log != null)
        {
            log.close();
        }
        log = null;
    }

    public void echo(char ac[], int i, int j)
        throws IOException
    {
        if (log != null)
        {
            log.write(ac, i, j);
        }
    }

    public void flush()
        throws IOException
    {
        if (log != null)
        {
            log.flush();
        }
        super.flush();
    }

    public final Writer getLogFile()
    {
        return log;
    }

    public void setLogFile(Writer writer)
    {
        log = writer;
    }

    public void setLogFile(String s)
        throws IOException
    {
        log = new PrintWriter(new BufferedWriter(new FileWriter(s)));
    }

    public void write(int i)
        throws IOException
    {
        if (log != null)
        {
            log.write(i);
        }
        super.write(i);
    }

    public void write(String s, int i, int j)
        throws IOException
    {
        if (log != null)
        {
            log.write(s, i, j);
        }
        super.write(s, i, j);
    }

    public void write(char ac[], int i, int j)
        throws IOException
    {
        if (log != null)
        {
            log.write(ac, i, j);
        }
        super.write(ac, i, j);
    }
}
