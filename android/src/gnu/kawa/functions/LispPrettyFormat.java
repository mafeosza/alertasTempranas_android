// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.mapping.OutPort;
import gnu.text.ReportFormat;
import java.io.IOException;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;

// Referenced classes of package gnu.kawa.functions:
//            LispFormat, ObjectFormat

class LispPrettyFormat extends ReportFormat
{

    Format body;
    boolean perLine;
    String prefix;
    boolean seenAt;
    Format segments[];
    String suffix;

    LispPrettyFormat()
    {
    }

    public int format(Object aobj[], int i, Writer writer, FieldPosition fieldposition)
        throws IOException
    {
        String s;
        OutPort outport;
        Object obj;
        String s1;
        s1 = prefix;
        s = suffix;
        if (writer instanceof OutPort)
        {
            outport = (OutPort)writer;
        } else
        {
            outport = null;
        }
        obj = s;
        if (!seenAt) goto _L2; else goto _L1
_L1:
        if (outport == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        obj = s;
        outport.startLogicalBlock(s1, perLine, suffix);
        obj = s;
        i = ReportFormat.format(body, aobj, i, writer, fieldposition);
        aobj = s;
_L4:
        if (outport != null)
        {
            outport.endLogicalBlock(((String) (aobj)));
        }
        return i;
_L2:
        Object obj1;
        obj1 = aobj[i];
        obj = s;
        Object aobj1[] = LispFormat.asArray(obj1);
        aobj = s;
        if (aobj1 == null)
        {
            aobj = "";
            s1 = "";
        }
        if (outport == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = ((Object) (aobj));
        outport.startLogicalBlock(s1, perLine, suffix);
        if (aobj1 != null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        obj = ((Object) (aobj));
        ObjectFormat.format(obj1, writer, -1, true);
        break MISSING_BLOCK_LABEL_208;
        obj = ((Object) (aobj));
        ReportFormat.format(body, aobj1, 0, writer, fieldposition);
        break MISSING_BLOCK_LABEL_208;
        aobj;
        if (outport != null)
        {
            outport.endLogicalBlock(((String) (obj)));
        }
        throw aobj;
        i++;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append("LispPrettyFormat[");
        stringbuffer.append("prefix: \"");
        stringbuffer.append(prefix);
        stringbuffer.append("\", suffix: \"");
        stringbuffer.append(suffix);
        stringbuffer.append("\", body: ");
        stringbuffer.append(body);
        stringbuffer.append("]");
        return stringbuffer.toString();
    }
}
