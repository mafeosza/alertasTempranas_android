// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.Comment;

// Referenced classes of package gnu.kawa.xml:
//            KCharacterData

public class KComment extends KCharacterData
    implements Comment
{

    public KComment(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public static KComment valueOf(String s)
    {
        NodeTree nodetree = new NodeTree();
        nodetree.writeComment(s, 0, s.length());
        return new KComment(nodetree, 0);
    }

    public String getNodeName()
    {
        return "#comment";
    }

    public short getNodeType()
    {
        return 8;
    }
}
