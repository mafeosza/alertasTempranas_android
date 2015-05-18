// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;

// Referenced classes of package gnu.kawa.xml:
//            KNode

public class KProcessingInstruction extends KNode
    implements ProcessingInstruction
{

    public KProcessingInstruction(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public static KProcessingInstruction valueOf(String s, String s1)
    {
        NodeTree nodetree = new NodeTree();
        nodetree.writeProcessingInstruction(s, s1, 0, s1.length());
        return new KProcessingInstruction(nodetree, 0);
    }

    public String getData()
    {
        return getNodeValue();
    }

    public String getNodeName()
    {
        return getTarget();
    }

    public short getNodeType()
    {
        return 7;
    }

    public String getTarget()
    {
        return ((NodeTree)sequence).posTarget(ipos);
    }

    public void setData(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "setData not supported");
    }
}
