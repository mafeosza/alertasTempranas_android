// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.lists.AbstractSequence;
import gnu.xml.NodeTree;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.TypeInfo;

// Referenced classes of package gnu.kawa.xml:
//            KNode

public class KAttr extends KNode
    implements Attr
{

    public KAttr(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public static Object getObjectValue(NodeTree nodetree, int i)
    {
        return nodetree.getPosNext(i + 10);
    }

    public String getName()
    {
        return sequence.getNextTypeName(ipos);
    }

    public short getNodeType()
    {
        return 2;
    }

    public Object getObjectValue()
    {
        return getObjectValue((NodeTree)sequence, ipos);
    }

    public Element getOwnerElement()
    {
        return (Element)super.getParentNode();
    }

    public Node getParentNode()
    {
        return null;
    }

    public TypeInfo getSchemaTypeInfo()
    {
        return null;
    }

    public boolean getSpecified()
    {
        return true;
    }

    public String getValue()
    {
        return getNodeValue();
    }

    public boolean isId()
    {
        return false;
    }

    public void setValue(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "setValue not supported");
    }
}
