// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

// Referenced classes of package gnu.kawa.xml:
//            KNode, KElement

public class KDocument extends KNode
    implements Document
{

    public KDocument(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public Node adoptNode(Node node)
        throws DOMException
    {
        throw new DOMException((short)9, "adoptNode not implemented");
    }

    public Attr createAttribute(String s)
    {
        throw new UnsupportedOperationException("createAttribute not implemented");
    }

    public Attr createAttributeNS(String s, String s1)
    {
        throw new UnsupportedOperationException("createAttributeNS not implemented");
    }

    public CDATASection createCDATASection(String s)
    {
        throw new UnsupportedOperationException("createCDATASection not implemented");
    }

    public Comment createComment(String s)
    {
        throw new UnsupportedOperationException("createComment not implemented");
    }

    public DocumentFragment createDocumentFragment()
    {
        throw new UnsupportedOperationException("createDocumentFragment not implemented");
    }

    public Element createElement(String s)
    {
        throw new UnsupportedOperationException("createElement not implemented");
    }

    public Element createElementNS(String s, String s1)
    {
        throw new UnsupportedOperationException("createElementNS not implemented");
    }

    public EntityReference createEntityReference(String s)
    {
        throw new UnsupportedOperationException("createEntityReference implemented");
    }

    public ProcessingInstruction createProcessingInstruction(String s, String s1)
    {
        throw new UnsupportedOperationException("createProcessingInstruction not implemented");
    }

    public Text createTextNode(String s)
    {
        throw new UnsupportedOperationException("createTextNode not implemented");
    }

    public DocumentType getDoctype()
    {
        return null;
    }

    public KElement getDocumentElement()
    {
        int i = ((NodeTree)sequence).posFirstChild(ipos);
        do
        {
            if (i == -1)
            {
                return null;
            }
            if (sequence.getNextKind(i) != 36)
            {
                return (KElement)make((NodeTree)sequence, i);
            }
            i = sequence.nextPos(i);
        } while (true);
    }

    public volatile Element getDocumentElement()
    {
        return getDocumentElement();
    }

    public String getDocumentURI()
    {
        return null;
    }

    public DOMConfiguration getDomConfig()
    {
        throw new DOMException((short)9, "getDomConfig not implemented");
    }

    public Element getElementById(String s)
    {
        return null;
    }

    public NodeList getElementsByTagNameNS(String s, String s1)
    {
        throw new UnsupportedOperationException("getElementsByTagNameNS not implemented yet");
    }

    public DOMImplementation getImplementation()
    {
        throw new UnsupportedOperationException("getImplementation not implemented");
    }

    public String getInputEncoding()
    {
        return null;
    }

    public String getNodeName()
    {
        return "#document";
    }

    public short getNodeType()
    {
        return 9;
    }

    public String getNodeValue()
    {
        return null;
    }

    public Node getParentNode()
    {
        return null;
    }

    public boolean getStrictErrorChecking()
    {
        return false;
    }

    public String getTextContent()
    {
        return null;
    }

    protected void getTextContent(StringBuffer stringbuffer)
    {
    }

    public String getXmlEncoding()
    {
        return null;
    }

    public boolean getXmlStandalone()
    {
        return false;
    }

    public String getXmlVersion()
    {
        return "1.1";
    }

    public boolean hasAttributes()
    {
        return false;
    }

    public Node importNode(Node node, boolean flag)
    {
        throw new UnsupportedOperationException("importNode not implemented");
    }

    public void normalizeDocument()
    {
    }

    public Node renameNode(Node node, String s, String s1)
        throws DOMException
    {
        throw new DOMException((short)9, "renameNode not implemented");
    }

    public void setDocumentURI(String s)
    {
    }

    public void setStrictErrorChecking(boolean flag)
    {
    }

    public void setXmlStandalone(boolean flag)
    {
    }

    public void setXmlVersion(String s)
    {
    }
}
