// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.AbstractFormat;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PrintConsumer;
import gnu.text.Path;
import gnu.text.PrettyWriter;
import gnu.text.Printable;
import gnu.text.WriterManager;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.NumberFormat;

// Referenced classes of package gnu.mapping:
//            LogWriter, ThreadLocation, Environment

public class OutPort extends PrintConsumer
    implements Printable
{

    private static OutPort errInitial;
    public static final ThreadLocation errLocation;
    static Writer logFile;
    static OutPort outInitial;
    public static final ThreadLocation outLocation;
    private Writer base;
    protected PrettyWriter bout;
    NumberFormat numberFormat;
    public AbstractFormat objectFormat;
    Path path;
    public boolean printReadable;
    protected Object unregisterRef;

    protected OutPort(OutPort outport, boolean flag)
    {
        this(((Writer) (outport)), outport.bout, flag);
    }

    public OutPort(OutputStream outputstream)
    {
        this(outputstream, ((Path) (null)));
    }

    public OutPort(OutputStream outputstream, Path path1)
    {
        this(((Writer) (new OutputStreamWriter(outputstream))), true, path1);
    }

    public OutPort(Writer writer)
    {
        PrettyWriter prettywriter;
        if (writer instanceof OutPort)
        {
            prettywriter = ((OutPort)writer).bout;
        } else
        {
            prettywriter = new PrettyWriter(writer, false);
        }
        this(writer, prettywriter, false);
    }

    public OutPort(Writer writer, Path path1)
    {
        this(writer, false, false);
        path = path1;
    }

    protected OutPort(Writer writer, PrettyWriter prettywriter, boolean flag)
    {
        super(prettywriter, flag);
        bout = prettywriter;
        base = writer;
        if (closeOnExit())
        {
            unregisterRef = WriterManager.instance.register(prettywriter);
        }
    }

    protected OutPort(Writer writer, boolean flag)
    {
        PrettyWriter prettywriter;
        if (writer instanceof OutPort)
        {
            prettywriter = ((OutPort)writer).bout;
        } else
        {
            prettywriter = new PrettyWriter(writer, true);
        }
        this(writer, prettywriter, flag);
    }

    public OutPort(Writer writer, boolean flag, Path path1)
    {
        this(writer, false, flag);
        path = path1;
    }

    public OutPort(Writer writer, boolean flag, boolean flag1)
    {
        this(writer, new PrettyWriter(writer, flag), flag1);
    }

    public OutPort(Writer writer, boolean flag, boolean flag1, Path path1)
    {
        this(writer, new PrettyWriter(writer, flag), flag1);
        path = path1;
    }

    public static void closeLogFile()
        throws IOException
    {
        if (logFile != null)
        {
            logFile.close();
            logFile = null;
        }
        if (outInitial.base instanceof LogWriter)
        {
            ((LogWriter)outInitial.base).setLogFile((Writer)null);
        }
        if (errInitial.base instanceof LogWriter)
        {
            ((LogWriter)errInitial.base).setLogFile((Writer)null);
        }
    }

    public static OutPort errDefault()
    {
        return (OutPort)errLocation.get();
    }

    protected static final boolean isWordChar(char c)
    {
        return Character.isJavaIdentifierPart(c) || c == '-' || c == '+';
    }

    public static OutPort openFile(Object obj)
        throws IOException
    {
        Object obj1 = Environment.user().get("port-char-encoding");
        Path path1 = Path.valueOf(obj);
        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(path1.openOutputStream());
        if (obj1 == null || obj1 == Boolean.TRUE)
        {
            obj = new OutputStreamWriter(bufferedoutputstream);
        } else
        {
            obj = obj1;
            if (obj1 == Boolean.FALSE)
            {
                obj = "8859_1";
            }
            obj = new OutputStreamWriter(bufferedoutputstream, obj.toString());
        }
        return new OutPort(((Writer) (obj)), path1);
    }

    public static OutPort outDefault()
    {
        return (OutPort)outLocation.get();
    }

    public static void runCleanups()
    {
        WriterManager.instance.run();
    }

    public static void setErrDefault(OutPort outport)
    {
        errLocation.set(outport);
    }

    public static void setLogFile(String s)
        throws IOException
    {
        if (logFile != null)
        {
            closeLogFile();
        }
        logFile = new PrintWriter(new BufferedWriter(new FileWriter(s)));
        if (outInitial.base instanceof LogWriter)
        {
            ((LogWriter)outInitial.base).setLogFile(logFile);
        }
        if (errInitial.base instanceof LogWriter)
        {
            ((LogWriter)errInitial.base).setLogFile(logFile);
        }
    }

    public static void setOutDefault(OutPort outport)
    {
        outLocation.set(outport);
    }

    public void clearBuffer()
    {
        bout.clearBuffer();
    }

    public void close()
    {
        if (!(base instanceof OutPort) || ((OutPort)base).bout != bout) goto _L2; else goto _L1
_L1:
        base.close();
_L4:
        WriterManager.instance.unregister(unregisterRef);
        return;
_L2:
        try
        {
            out.close();
        }
        catch (IOException ioexception)
        {
            setError();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected boolean closeOnExit()
    {
        return true;
    }

    public void closeThis()
    {
        try
        {
            if (!(base instanceof OutPort) || ((OutPort)base).bout != bout)
            {
                bout.closeThis();
            }
        }
        catch (IOException ioexception)
        {
            setError();
        }
        WriterManager.instance.unregister(unregisterRef);
    }

    public void echo(char ac[], int i, int j)
        throws IOException
    {
        if (base instanceof LogWriter)
        {
            ((LogWriter)base).echo(ac, i, j);
        }
    }

    public void endAttribute()
    {
        if (objectFormat != null)
        {
            objectFormat.endAttribute(this);
            return;
        } else
        {
            print(' ');
            return;
        }
    }

    public void endElement()
    {
        if (objectFormat != null)
        {
            objectFormat.endElement(this);
            return;
        } else
        {
            print(')');
            return;
        }
    }

    public void endLogicalBlock(String s)
    {
        bout.endLogicalBlock(s);
    }

    public void freshLine()
    {
        if (bout.getColumnNumber() != 0)
        {
            println();
        }
    }

    public int getColumnNumber()
    {
        return bout.getColumnNumber();
    }

    public void print(double d)
    {
        if (numberFormat == null)
        {
            super.print(d);
            return;
        } else
        {
            print(numberFormat.format(d));
            return;
        }
    }

    public void print(float f)
    {
        if (numberFormat == null)
        {
            super.print(f);
            return;
        } else
        {
            print(numberFormat.format(f));
            return;
        }
    }

    public void print(int i)
    {
        if (numberFormat == null)
        {
            super.print(i);
            return;
        } else
        {
            print(numberFormat.format(i));
            return;
        }
    }

    public void print(long l)
    {
        if (numberFormat == null)
        {
            super.print(l);
            return;
        } else
        {
            print(numberFormat.format(l));
            return;
        }
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<output-port");
        if (path != null)
        {
            consumer.write(32);
            consumer.write(path.toString());
        }
        consumer.write(62);
    }

    public void print(Object obj)
    {
        if (objectFormat != null)
        {
            objectFormat.writeObject(obj, this);
            return;
        }
        if (obj instanceof Consumable)
        {
            ((Consumable)obj).consume(this);
            return;
        }
        Object obj1 = obj;
        if (obj == null)
        {
            obj1 = "null";
        }
        super.print(obj1);
    }

    public void print(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "(null)";
        }
        write(s1);
    }

    public void print(boolean flag)
    {
        if (objectFormat == null)
        {
            super.print(flag);
            return;
        } else
        {
            objectFormat.writeBoolean(flag, this);
            return;
        }
    }

    public void setColumnNumber(int i)
    {
        bout.setColumnNumber(i);
    }

    public void setIndentation(int i, boolean flag)
    {
        bout.addIndentation(i, flag);
    }

    public void startAttribute(Object obj)
    {
        if (objectFormat != null)
        {
            objectFormat.startAttribute(obj, this);
            return;
        } else
        {
            print(' ');
            print(obj);
            print(": ");
            return;
        }
    }

    public void startElement(Object obj)
    {
        if (objectFormat != null)
        {
            objectFormat.startElement(obj, this);
            return;
        } else
        {
            print('(');
            print(obj);
            return;
        }
    }

    public void startLogicalBlock(String s, String s1, int i)
    {
        bout.startLogicalBlock(s, false, s1);
        s1 = bout;
        if (s != null)
        {
            i -= s.length();
        }
        s1.addIndentation(i, false);
    }

    public void startLogicalBlock(String s, boolean flag, String s1)
    {
        bout.startLogicalBlock(s, flag, s1);
    }

    public void writeBreak(int i)
    {
        bout.writeBreak(i);
    }

    public void writeBreakFill()
    {
        writeBreak(70);
    }

    public void writeBreakLinear()
    {
        writeBreak(78);
    }

    public void writeSpaceFill()
    {
        write(32);
        writeBreak(70);
    }

    public void writeSpaceLinear()
    {
        write(32);
        writeBreak(78);
    }

    public void writeWordEnd()
    {
        bout.writeWordEnd();
    }

    public void writeWordStart()
    {
        bout.writeWordStart();
    }

    static 
    {
        outInitial = new OutPort(new LogWriter(new BufferedWriter(new OutputStreamWriter(System.out))), true, true, Path.valueOf("/dev/stdout"));
        errInitial = new OutPort(new LogWriter(new OutputStreamWriter(System.err)), true, true, Path.valueOf("/dev/stderr"));
        outLocation = new ThreadLocation("out-default");
        outLocation.setGlobal(outInitial);
        errLocation = new ThreadLocation("err-default");
        errLocation.setGlobal(errInitial);
    }
}
