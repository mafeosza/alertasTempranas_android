// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import gnu.mapping.CharArrayOutPort;
import gnu.mapping.OutPort;
import java.io.Writer;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

// Referenced classes of package gnu.lists:
//            Consumer, PrintConsumer

public abstract class AbstractFormat extends Format
{

    public AbstractFormat()
    {
    }

    public void endAttribute(Consumer consumer)
    {
        write(" ", consumer);
    }

    public void endElement(Consumer consumer)
    {
        write(")", consumer);
    }

    public StringBuffer format(Object obj, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        fieldposition = new CharArrayOutPort();
        writeObject(obj, fieldposition);
        stringbuffer.append(fieldposition.toCharArray());
        fieldposition.close();
        return stringbuffer;
    }

    public void format(Object obj, Consumer consumer)
    {
        OutPort outport;
        AbstractFormat abstractformat;
        if (!(consumer instanceof OutPort))
        {
            break MISSING_BLOCK_LABEL_46;
        }
        outport = (OutPort)consumer;
        abstractformat = outport.objectFormat;
        outport.objectFormat = this;
        consumer.writeObject(obj);
        outport.objectFormat = abstractformat;
        return;
        obj;
        outport.objectFormat = abstractformat;
        throw obj;
        consumer.writeObject(obj);
        return;
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new Error((new StringBuilder()).append(getClass().getName()).append(".parseObject - not implemented").toString());
    }

    public void startAttribute(Object obj, Consumer consumer)
    {
        write(obj.toString(), consumer);
        write(": ", consumer);
    }

    public void startElement(Object obj, Consumer consumer)
    {
        write("(", consumer);
        write(obj.toString(), consumer);
        write(" ", consumer);
    }

    public void write(int i, Consumer consumer)
    {
        consumer.write(i);
    }

    protected void write(String s, Consumer consumer)
    {
        consumer.write(s);
    }

    public void writeBoolean(boolean flag, Consumer consumer)
    {
        consumer.writeBoolean(flag);
    }

    public void writeInt(int i, Consumer consumer)
    {
        writeLong(i, consumer);
    }

    public void writeLong(long l, Consumer consumer)
    {
        consumer.writeLong(l);
    }

    public abstract void writeObject(Object obj, Consumer consumer);

    public final void writeObject(Object obj, PrintConsumer printconsumer)
    {
        writeObject(obj, ((Consumer) (printconsumer)));
    }

    public final void writeObject(Object obj, Writer writer)
    {
        if (writer instanceof Consumer)
        {
            writeObject(obj, (Consumer)writer);
            return;
        } else
        {
            OutPort outport = new OutPort(writer, false, true);
            writeObject(obj, (Consumer)writer);
            outport.close();
            return;
        }
    }
}
