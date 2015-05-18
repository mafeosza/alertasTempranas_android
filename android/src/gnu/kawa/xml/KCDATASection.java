// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.CDATASection;

// Referenced classes of package gnu.kawa.xml:
//            KText

public class KCDATASection extends KText
    implements CDATASection
{

    public KCDATASection(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public String getData()
    {
        return getNodeValue();
    }

    public int getLength()
    {
        StringBuffer stringbuffer = new StringBuffer();
        NodeTree nodetree = (NodeTree)sequence;
        nodetree.stringValue(nodetree.posToDataIndex(ipos), stringbuffer);
        return stringbuffer.length();
    }

    public String getNodeName()
    {
        return "#cdata-section";
    }

    public short getNodeType()
    {
        return 4;
    }
}
