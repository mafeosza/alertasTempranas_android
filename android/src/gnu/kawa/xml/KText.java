// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

// Referenced classes of package gnu.kawa.xml:
//            KCharacterData

public class KText extends KCharacterData
    implements Text
{

    public KText(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public static KText make(String s)
    {
        NodeTree nodetree = new NodeTree();
        nodetree.append(s);
        return new KText(nodetree, 0);
    }

    public String getNodeName()
    {
        return "#text";
    }

    public short getNodeType()
    {
        return 3;
    }

    public String getWholeText()
    {
        throw new UnsupportedOperationException("getWholeText not implemented yet");
    }

    public boolean hasAttributes()
    {
        return false;
    }

    public boolean isElementContentWhitespace()
    {
        return false;
    }

    public Text replaceWholeText(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "splitText not supported");
    }

    public Text splitText(int i)
        throws DOMException
    {
        throw new DOMException((short)7, "splitText not supported");
    }
}
