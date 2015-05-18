// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.sax;

import gnu.text.LineBufferedReader;
import gnu.text.SourceMessages;
import gnu.xml.XMLFilter;
import gnu.xml.XMLParser;
import java.io.IOException;
import org.xml.sax.ContentHandler;
import org.xml.sax.DTDHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;

// Referenced classes of package gnu.kawa.sax:
//            ContentConsumer

public class KawaXMLReader extends ContentConsumer
    implements XMLReader
{

    ErrorHandler errorHandler;

    public KawaXMLReader()
    {
    }

    public DTDHandler getDTDHandler()
    {
        return null;
    }

    public EntityResolver getEntityResolver()
    {
        return null;
    }

    public ErrorHandler getErrorHandler()
    {
        return errorHandler;
    }

    public boolean getFeature(String s)
    {
        return false;
    }

    public Object getProperty(String s)
    {
        return null;
    }

    public void parse(String s)
    {
    }

    public void parse(InputSource inputsource)
        throws IOException, SAXException
    {
        Object obj1 = inputsource.getCharacterStream();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = XMLParser.XMLStreamReader(inputsource.getByteStream());
        }
        obj1 = new SourceMessages();
        inputsource = new XMLFilter(this);
        obj = new LineBufferedReader(((java.io.Reader) (obj)));
        inputsource.setSourceLocator(((LineBufferedReader) (obj)));
        getContentHandler().setDocumentLocator(inputsource);
        XMLParser.parse(((LineBufferedReader) (obj)), ((SourceMessages) (obj1)), inputsource);
        obj = ((SourceMessages) (obj1)).toString(20);
        if (obj != null)
        {
            throw new SAXParseException(((String) (obj)), inputsource);
        } else
        {
            return;
        }
    }

    public void setDTDHandler(DTDHandler dtdhandler)
    {
    }

    public void setEntityResolver(EntityResolver entityresolver)
    {
    }

    public void setErrorHandler(ErrorHandler errorhandler)
    {
        errorHandler = errorhandler;
    }

    public void setFeature(String s, boolean flag)
    {
    }

    public void setProperty(String s, Object obj)
    {
    }
}
