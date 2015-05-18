// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;

import java.io.IOException;

// Referenced classes of package gnu.lists:
//            XConsumer, Consumer

public class FilterConsumer
    implements XConsumer
{

    protected Object attributeType;
    protected Consumer base;
    protected boolean inAttribute;
    protected boolean skipping;

    public FilterConsumer(Consumer consumer)
    {
        base = consumer;
    }

    public Consumer append(char c)
    {
        write(c);
        return this;
    }

    public Consumer append(CharSequence charsequence)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        write(((CharSequence) (obj)), 0, ((CharSequence) (obj)).length());
        return this;
    }

    public Consumer append(CharSequence charsequence, int i, int j)
    {
        Object obj = charsequence;
        if (charsequence == null)
        {
            obj = "null";
        }
        write(((CharSequence) (obj)), i, j - i);
        return this;
    }

    public volatile Appendable append(char c)
        throws IOException
    {
        return append(c);
    }

    public volatile Appendable append(CharSequence charsequence)
        throws IOException
    {
        return append(charsequence);
    }

    public volatile Appendable append(CharSequence charsequence, int i, int j)
        throws IOException
    {
        return append(charsequence, i, j);
    }

    protected void beforeContent()
    {
    }

    protected void beforeNode()
    {
    }

    public void beginEntity(Object obj)
    {
        if (!skipping)
        {
            beforeNode();
            if (base instanceof XConsumer)
            {
                ((XConsumer)base).beginEntity(obj);
            }
        }
    }

    public void endAttribute()
    {
        if (!skipping)
        {
            base.endAttribute();
        }
        inAttribute = false;
    }

    public void endDocument()
    {
        if (!skipping)
        {
            base.endDocument();
        }
    }

    public void endElement()
    {
        if (!skipping)
        {
            base.endElement();
        }
    }

    public void endEntity()
    {
        if (!skipping && (base instanceof XConsumer))
        {
            ((XConsumer)base).endEntity();
        }
    }

    public boolean ignoring()
    {
        return base.ignoring();
    }

    public void startAttribute(Object obj)
    {
        attributeType = obj;
        inAttribute = true;
        if (!skipping)
        {
            beforeNode();
            base.startAttribute(obj);
        }
    }

    public void startDocument()
    {
        if (!skipping)
        {
            base.startDocument();
        }
    }

    public void startElement(Object obj)
    {
        if (!skipping)
        {
            beforeNode();
            base.startElement(obj);
        }
    }

    public void write(int i)
    {
        beforeContent();
        if (!skipping)
        {
            base.write(i);
        }
    }

    public void write(CharSequence charsequence, int i, int j)
    {
        beforeContent();
        if (!skipping)
        {
            base.write(charsequence, i, j);
        }
    }

    public void write(String s)
    {
        write(((CharSequence) (s)), 0, s.length());
    }

    public void write(char ac[], int i, int j)
    {
        beforeContent();
        if (!skipping)
        {
            base.write(ac, i, j);
        }
    }

    public void writeBoolean(boolean flag)
    {
        beforeContent();
        if (!skipping)
        {
            base.writeBoolean(flag);
        }
    }

    public void writeCDATA(char ac[], int i, int j)
    {
label0:
        {
            beforeContent();
            if (!skipping)
            {
                if (!(base instanceof XConsumer))
                {
                    break label0;
                }
                ((XConsumer)base).writeCDATA(ac, i, j);
            }
            return;
        }
        base.write(ac, i, j);
    }

    public void writeComment(char ac[], int i, int j)
    {
        if (!skipping)
        {
            beforeNode();
            if (base instanceof XConsumer)
            {
                ((XConsumer)base).writeComment(ac, i, j);
            }
        }
    }

    public void writeDouble(double d)
    {
        beforeContent();
        if (!skipping)
        {
            base.writeDouble(d);
        }
    }

    public void writeFloat(float f)
    {
        beforeContent();
        if (!skipping)
        {
            base.writeFloat(f);
        }
    }

    public void writeInt(int i)
    {
        beforeContent();
        if (!skipping)
        {
            base.writeInt(i);
        }
    }

    public void writeLong(long l)
    {
        beforeContent();
        if (!skipping)
        {
            base.writeLong(l);
        }
    }

    public void writeObject(Object obj)
    {
        beforeContent();
        if (!skipping)
        {
            base.writeObject(obj);
        }
    }

    public void writeProcessingInstruction(String s, char ac[], int i, int j)
    {
        if (!skipping)
        {
            beforeNode();
            if (base instanceof XConsumer)
            {
                ((XConsumer)base).writeProcessingInstruction(s, ac, i, j);
            }
        }
    }
}
