// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.FString;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.Values;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.text.MessageFormat;

// Referenced classes of package gnu.kawa.functions:
//            ParseFormat

public class Format extends ProcedureN
{

    public static final Format format;

    public Format()
    {
    }

    static Object[] drop2(Object aobj[])
    {
        int i = aobj.length - 2;
        Object aobj1[] = new Object[i];
        System.arraycopy(((Object) (aobj)), 2, ((Object) (aobj1)), 0, i);
        return aobj1;
    }

    public static transient Object format(Object aobj[])
    {
        Object obj = aobj[0];
        if (obj == Boolean.TRUE)
        {
            format(((Writer) (OutPort.outDefault())), aobj, 1);
            return Values.empty;
        }
        if (obj == Boolean.FALSE)
        {
            return formatToString(1, aobj);
        }
        if ((obj instanceof MessageFormat) || (obj instanceof CharSequence) || (obj instanceof ReportFormat))
        {
            return formatToString(0, aobj);
        }
        if (obj instanceof Writer)
        {
            format((Writer)obj, aobj, 1);
            return Values.empty;
        }
        if (obj instanceof OutputStream)
        {
            formatToOutputStream((OutputStream)obj, aobj[1], drop2(aobj));
            return Values.empty;
        } else
        {
            throw new RuntimeException("bad first argument to format");
        }
    }

    public static void format(Writer writer, Object aobj[], int i)
    {
        int j = i + 1;
        Object obj = aobj[i];
        Object aobj1[] = new Object[aobj.length - j];
        System.arraycopy(((Object) (aobj)), j, ((Object) (aobj1)), 0, aobj1.length);
        formatToWriter(writer, obj, aobj1);
    }

    public static FString formatToFString(char c, Object obj, Object aobj[])
    {
        ReportFormat reportformat = ParseFormat.asFormat(obj, c);
        obj = new CharArrayOutPort();
        try
        {
            reportformat.format(aobj, 0, ((Writer) (obj)), null);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new RuntimeException((new StringBuilder()).append("Error in format: ").append(obj).toString());
        }
        aobj = ((CharArrayOutPort) (obj)).toCharArray();
        ((CharArrayOutPort) (obj)).close();
        return new FString(((char []) (aobj)));
    }

    public static transient void formatToOutputStream(OutputStream outputstream, Object obj, Object aobj[])
    {
        outputstream = new OutPort(outputstream);
        format(new Object[] {
            outputstream, obj, aobj
        });
        outputstream.closeThis();
    }

    public static transient String formatToString(int i, Object aobj[])
    {
        CharArrayOutPort chararrayoutport = new CharArrayOutPort();
        format(chararrayoutport, aobj, i);
        aobj = chararrayoutport.toString();
        chararrayoutport.close();
        return ((String) (aobj));
    }

    public static transient void formatToWriter(Writer writer, Object obj, Object aobj[])
    {
        Object obj1 = writer;
        if (writer == null)
        {
            obj1 = OutPort.outDefault();
        }
        try
        {
            if (obj instanceof MessageFormat)
            {
                ((Writer) (obj1)).write(((MessageFormat)obj).format(((Object) (aobj))));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new RuntimeException((new StringBuilder()).append("Error in format: ").append(writer).toString());
        }
        writer = ((Writer) (obj));
        if (!(obj instanceof ReportFormat))
        {
            writer = ((Writer) (ParseFormat.parseFormat.apply1(obj)));
        }
        ((ReportFormat)writer).format(aobj, 0, ((Writer) (obj1)), null);
        return;
    }

    public Object applyN(Object aobj[])
    {
        return format(aobj);
    }

    static 
    {
        format = new Format();
        format.setName("format");
        format.setProperty(Procedure.validateApplyKey, "gnu.kawa.functions.CompileMisc:validateApplyFormat");
    }
}
