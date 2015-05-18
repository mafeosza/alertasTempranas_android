// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.PositionConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreePosition;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.xml.NodeTree;
import gnu.xml.XMLPrinter;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

// Referenced classes of package gnu.kawa.xml:
//            KText, KElement, KAttr, KDocument, 
//            KCDATASection, KComment, KProcessingInstruction, SortedNodes, 
//            Nodes

public abstract class KNode extends SeqPosition
    implements Node, Consumable
{

    public KNode(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public static Object atomicValue(Object obj)
    {
        Object obj1 = obj;
        if (obj instanceof KNode)
        {
            obj = (KNode)obj;
            obj1 = ((NodeTree)((KNode) (obj)).sequence).typedValue(((KNode) (obj)).ipos);
        }
        return obj1;
    }

    public static KNode coerce(Object obj)
    {
        if (obj instanceof KNode)
        {
            return (KNode)obj;
        }
        if (obj instanceof NodeTree)
        {
            obj = (NodeTree)obj;
            return make(((NodeTree) (obj)), ((NodeTree) (obj)).startPos());
        }
        if ((obj instanceof SeqPosition) && !(obj instanceof TreePosition))
        {
            obj = (SeqPosition)obj;
            if (((SeqPosition) (obj)).sequence instanceof NodeTree)
            {
                return make((NodeTree)((SeqPosition) (obj)).sequence, ((SeqPosition) (obj)).ipos);
            }
        }
        return null;
    }

    public static String getNodeValue(NodeTree nodetree, int i)
    {
        StringBuffer stringbuffer = new StringBuffer();
        getNodeValue(nodetree, i, stringbuffer);
        return stringbuffer.toString();
    }

    public static void getNodeValue(NodeTree nodetree, int i, StringBuffer stringbuffer)
    {
        nodetree.stringValue(nodetree.posToDataIndex(i), stringbuffer);
    }

    public static KNode make(NodeTree nodetree)
    {
        return make(nodetree, 0);
    }

    public static KNode make(NodeTree nodetree, int i)
    {
        int j;
        int k = nodetree.posToDataIndex(i);
        j = i;
        for (i = k; i < nodetree.data.length && nodetree.data[i] == '\uF112';)
        {
            j = i + 5;
            i = j;
            if (j == nodetree.gapStart)
            {
                i = nodetree.gapEnd;
            }
            j = i << 1;
        }

        nodetree.getNextKindI(nodetree.posToDataIndex(j));
        JVM INSTR lookupswitch 7: default 132
    //                   0: 202
    //                   31: 172
    //                   33: 142
    //                   34: 162
    //                   35: 152
    //                   36: 182
    //                   37: 192;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        return new KText(nodetree, j);
_L4:
        return new KElement(nodetree, j);
_L6:
        return new KAttr(nodetree, j);
_L5:
        return new KDocument(nodetree, j);
_L3:
        return new KCDATASection(nodetree, j);
_L7:
        return new KComment(nodetree, j);
_L8:
        return new KProcessingInstruction(nodetree, j);
_L2:
        if (!nodetree.isEmpty())
        {
            return null;
        }
        if (true) goto _L1; else goto _L9
_L9:
    }

    public Node appendChild(Node node)
        throws DOMException
    {
        throw new DOMException((short)7, "appendChild not supported");
    }

    public Path baseURI()
    {
        return ((NodeTree)sequence).baseUriOfPos(ipos, true);
    }

    public Node cloneNode(boolean flag)
    {
        if (!flag)
        {
            throw new UnsupportedOperationException("shallow cloneNode not implemented");
        } else
        {
            NodeTree nodetree = new NodeTree();
            ((NodeTree)sequence).consumeNext(ipos, nodetree);
            return make(nodetree);
        }
    }

    public short compareDocumentPosition(Node node)
        throws DOMException
    {
        if (!(node instanceof KNode))
        {
            throw new DOMException((short)9, (new StringBuilder()).append("other Node is a ").append(node.getClass().getName()).toString());
        }
        node = (KNode)node;
        AbstractSequence abstractsequence = ((KNode) (node)).sequence;
        int i;
        if (sequence == abstractsequence)
        {
            i = abstractsequence.compare(ipos, ((KNode) (node)).ipos);
        } else
        {
            i = sequence.stableCompare(abstractsequence);
        }
        return (short)i;
    }

    public void consume(Consumer consumer)
    {
        if (consumer instanceof PositionConsumer)
        {
            ((PositionConsumer)consumer).consume(this);
            return;
        } else
        {
            ((NodeTree)sequence).consumeNext(ipos, consumer);
            return;
        }
    }

    public KNode copy()
    {
        return make((NodeTree)sequence, sequence.copyPos(getPos()));
    }

    public volatile SeqPosition copy()
    {
        return copy();
    }

    public NamedNodeMap getAttributes()
    {
        throw new UnsupportedOperationException("getAttributes not implemented yet");
    }

    public String getBaseURI()
    {
        Path path = ((NodeTree)sequence).baseUriOfPos(ipos, true);
        if (path == null)
        {
            return null;
        } else
        {
            return path.toString();
        }
    }

    public NodeList getChildNodes()
    {
        SortedNodes sortednodes = new SortedNodes();
        for (int i = sequence.firstChildPos(ipos); i != 0; i = sequence.nextPos(i))
        {
            sortednodes.writePosition(sequence, i);
        }

        return sortednodes;
    }

    public NodeList getElementsByTagName(String s)
    {
        throw new UnsupportedOperationException("getElementsByTagName not implemented yet");
    }

    public Object getFeature(String s, String s1)
    {
        return null;
    }

    public Node getFirstChild()
    {
        int i = ((NodeTree)sequence).posFirstChild(ipos);
        return make((NodeTree)sequence, i);
    }

    public Node getLastChild()
    {
        int j = 0;
        for (int i = sequence.firstChildPos(ipos); i != 0; i = sequence.nextPos(i))
        {
            j = i;
        }

        if (j == 0)
        {
            return null;
        } else
        {
            return make((NodeTree)sequence, j);
        }
    }

    public String getLocalName()
    {
        return ((NodeTree)sequence).posLocalName(ipos);
    }

    public String getNamespaceURI()
    {
        return ((NodeTree)sequence).posNamespaceURI(ipos);
    }

    public Node getNextSibling()
    {
        int i = ((NodeTree)sequence).nextPos(ipos);
        if (i == 0)
        {
            return null;
        } else
        {
            return make((NodeTree)sequence, i);
        }
    }

    public String getNodeName()
    {
        return sequence.getNextTypeName(ipos);
    }

    public Object getNodeNameObject()
    {
        return ((NodeTree)sequence).getNextTypeObject(ipos);
    }

    public Symbol getNodeSymbol()
    {
        Object obj = ((NodeTree)sequence).getNextTypeObject(ipos);
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof Symbol)
        {
            return (Symbol)obj;
        } else
        {
            return Namespace.EmptyNamespace.getSymbol(obj.toString().intern());
        }
    }

    public abstract short getNodeType();

    public String getNodeValue()
    {
        StringBuffer stringbuffer = new StringBuffer();
        getNodeValue(stringbuffer);
        return stringbuffer.toString();
    }

    public void getNodeValue(StringBuffer stringbuffer)
    {
        getNodeValue((NodeTree)sequence, ipos, stringbuffer);
    }

    public Document getOwnerDocument()
    {
        if (sequence.getNextKind(ipos) == 34)
        {
            return new KDocument((NodeTree)sequence, 0);
        } else
        {
            return null;
        }
    }

    public Node getParentNode()
    {
        int i = sequence.parentPos(ipos);
        if (i == -1)
        {
            return null;
        } else
        {
            return make((NodeTree)sequence, i);
        }
    }

    public String getPrefix()
    {
        return ((NodeTree)sequence).posPrefix(ipos);
    }

    public Node getPreviousSibling()
    {
        int i;
        int i1;
        int j = sequence.parentPos(ipos);
        i = j;
        if (j == -1)
        {
            i = 0;
        }
        i1 = ((NodeTree)sequence).posToDataIndex(ipos);
        i = sequence.firstChildPos(i);
_L3:
        int k;
        int l;
        k = i;
        l = sequence.nextPos(k);
        if (l != 0) goto _L2; else goto _L1
_L1:
        if (k == 0)
        {
            return null;
        } else
        {
            return make((NodeTree)sequence, k);
        }
_L2:
        i = l;
        if (((NodeTree)sequence).posToDataIndex(l) != i1) goto _L3; else goto _L1
    }

    public String getTextContent()
    {
        StringBuffer stringbuffer = new StringBuffer();
        getTextContent(stringbuffer);
        return stringbuffer.toString();
    }

    protected void getTextContent(StringBuffer stringbuffer)
    {
        getNodeValue(stringbuffer);
    }

    public Object getUserData(String s)
    {
        return null;
    }

    public boolean hasAttributes()
    {
        return false;
    }

    public boolean hasChildNodes()
    {
        return ((NodeTree)sequence).posFirstChild(ipos) >= 0;
    }

    public Node insertBefore(Node node, Node node1)
        throws DOMException
    {
        throw new DOMException((short)7, "insertBefore not supported");
    }

    public boolean isDefaultNamespace(String s)
    {
        return ((NodeTree)sequence).posIsDefaultNamespace(ipos, s);
    }

    public boolean isEqualNode(Node node)
    {
        throw new UnsupportedOperationException("getAttributesisEqualNode not implemented yet");
    }

    public boolean isSameNode(Node node)
    {
        if (node instanceof KNode)
        {
            if (sequence == ((KNode) (node = (KNode)node)).sequence)
            {
                return sequence.equals(ipos, ((KNode) (node)).ipos);
            }
        }
        return false;
    }

    public boolean isSupported(String s, String s1)
    {
        return false;
    }

    public String lookupNamespaceURI(String s)
    {
        return ((NodeTree)sequence).posLookupNamespaceURI(ipos, s);
    }

    public String lookupPrefix(String s)
    {
        return ((NodeTree)sequence).posLookupPrefix(ipos, s);
    }

    public void normalize()
    {
    }

    public Node removeChild(Node node)
        throws DOMException
    {
        throw new DOMException((short)7, "removeChild not supported");
    }

    public Node replaceChild(Node node, Node node1)
        throws DOMException
    {
        throw new DOMException((short)7, "replaceChild not supported");
    }

    public void setNodeValue(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "setNodeValue not supported");
    }

    public void setPrefix(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "setPrefix not supported");
    }

    public void setTextContent(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "setTextContent not supported");
    }

    public Object setUserData(String s, Object obj, UserDataHandler userdatahandler)
    {
        throw new UnsupportedOperationException("setUserData not implemented yet");
    }

    public String toString()
    {
        CharArrayOutPort chararrayoutport = new CharArrayOutPort();
        XMLPrinter xmlprinter = new XMLPrinter(chararrayoutport);
        ((NodeTree)sequence).consumeNext(ipos, xmlprinter);
        xmlprinter.close();
        chararrayoutport.close();
        return chararrayoutport.toString();
    }
}
