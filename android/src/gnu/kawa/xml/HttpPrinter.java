// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.UnescapedData;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.xml.XMLPrinter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

public class HttpPrinter extends FilterConsumer
{

    Object currentHeader;
    private int elementNesting;
    Vector headers;
    protected OutputStream ostream;
    protected String sawContentType;
    StringBuilder sbuf;
    private int seenStartDocument;
    boolean seenXmlHeader;
    OutPort writer;

    public HttpPrinter(OutPort outport)
    {
        super(null);
        headers = new Vector();
        sbuf = new StringBuilder(100);
        writer = outport;
    }

    public HttpPrinter(OutputStream outputstream)
    {
        super(null);
        headers = new Vector();
        sbuf = new StringBuilder(100);
        ostream = outputstream;
    }

    public static HttpPrinter make(OutPort outport)
    {
        return new HttpPrinter(outport);
    }

    private void writeRaw(String s)
        throws IOException
    {
        if (writer != null)
        {
            writer.write(s);
        } else
        {
            int j = s.length();
            int i = 0;
            while (i < j) 
            {
                ostream.write((byte)s.charAt(i));
                i++;
            }
        }
    }

    public void addHeader(String s, String s1)
    {
        if (s.equalsIgnoreCase("Content-type"))
        {
            sawContentType = s1;
        }
        headers.addElement(s);
        headers.addElement(s1);
    }

    protected void beforeNode()
    {
        if (sawContentType == null)
        {
            addHeader("Content-type", "text/xml");
        }
        beginData();
    }

    public void beginData()
    {
        if (base == null)
        {
            if (sawContentType == null)
            {
                addHeader("Content-type", "text/plain");
            }
            if (writer == null)
            {
                writer = new OutPort(ostream);
            }
            String s = null;
            if ("text/html".equalsIgnoreCase(sawContentType))
            {
                s = "html";
            } else
            if ("application/xhtml+xml".equalsIgnoreCase(sawContentType))
            {
                s = "xhtml";
            } else
            if ("text/plain".equalsIgnoreCase(sawContentType))
            {
                s = "plain";
            }
            base = XMLPrinter.make(writer, s);
            if (seenStartDocument == 0)
            {
                base.startDocument();
                seenStartDocument = 1;
            }
            try
            {
                printHeaders();
            }
            catch (Throwable throwable)
            {
                throw new RuntimeException(throwable.toString());
            }
        }
        append(sbuf);
        sbuf.setLength(0);
    }

    public void endAttribute()
    {
        if (currentHeader != null)
        {
            addHeader(currentHeader.toString(), sbuf.toString());
            sbuf.setLength(0);
            currentHeader = null;
            return;
        } else
        {
            base.endAttribute();
            return;
        }
    }

    public void endDocument()
    {
        if (base != null)
        {
            base.endDocument();
        }
        String s;
        if (sawContentType == null)
        {
            addHeader("Content-type", "text/plain");
        }
        if (sbuf.length() > 0)
        {
            s = sbuf.toString();
            sbuf.setLength(0);
            if (writer == null)
            {
                break MISSING_BLOCK_LABEL_101;
            }
            writer.write(s);
        }
_L2:
        if (writer != null)
        {
            writer.close();
        }
        if (ostream != null)
        {
            ostream.flush();
            return;
        }
        break MISSING_BLOCK_LABEL_116;
        ostream.write(s.getBytes());
        if (true) goto _L2; else goto _L1
_L1:
        Throwable throwable;
        throwable;
    }

    public void endElement()
    {
        super.endElement();
        elementNesting = elementNesting - 1;
        if (elementNesting == 0 && seenStartDocument == 1)
        {
            endDocument();
        }
    }

    public void printHeader(String s, String s1)
        throws IOException
    {
        writeRaw(s);
        writeRaw(": ");
        writeRaw(s1);
        writeRaw("\n");
    }

    public void printHeaders()
        throws IOException
    {
        int j = headers.size();
        for (int i = 0; i < j; i += 2)
        {
            printHeader(headers.elementAt(i).toString(), headers.elementAt(i + 1).toString());
        }

        writeRaw("\n");
    }

    public boolean reset(boolean flag)
    {
        if (flag)
        {
            headers.clear();
            sawContentType = null;
            currentHeader = null;
            elementNesting = 0;
        }
        sbuf.setLength(0);
        base = null;
        flag = true;
        if (ostream != null)
        {
            if (writer == null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            writer = null;
        }
        return flag;
    }

    public void startAttribute(Object obj)
    {
        if (base == null)
        {
            currentHeader = obj;
            return;
        } else
        {
            base.startAttribute(obj);
            return;
        }
    }

    public void startDocument()
    {
        if (base != null)
        {
            base.startDocument();
        }
        seenStartDocument = 2;
    }

    public void startElement(Object obj)
    {
        if (sawContentType == null)
        {
            String s;
            if (!seenXmlHeader)
            {
                s = "text/html";
            } else
            if ((obj instanceof Symbol) && "html".equals(((Symbol)obj).getLocalPart()))
            {
                s = "text/xhtml";
            } else
            {
                s = "text/xml";
            }
            addHeader("Content-type", s);
        }
        beginData();
        base.startElement(obj);
        elementNesting = elementNesting + 1;
    }

    public void write(CharSequence charsequence, int i, int j)
    {
        if (base == null)
        {
            sbuf.append(charsequence, i, i + j);
            return;
        } else
        {
            base.write(charsequence, i, j);
            return;
        }
    }

    public void write(char ac[], int i, int j)
    {
        if (base == null)
        {
            sbuf.append(ac, i, j);
            return;
        } else
        {
            base.write(ac, i, j);
            return;
        }
    }

    public void writeObject(Object obj)
    {
        if ((obj instanceof Consumable) && !(obj instanceof UnescapedData))
        {
            ((Consumable)obj).consume(this);
            return;
        } else
        {
            beginData();
            super.writeObject(obj);
            return;
        }
    }
}
