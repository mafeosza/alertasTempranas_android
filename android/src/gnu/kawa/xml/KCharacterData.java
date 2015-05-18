// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.xml.NodeTree;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;

// Referenced classes of package gnu.kawa.xml:
//            KNode

public abstract class KCharacterData extends KNode
    implements CharacterData
{

    public KCharacterData(NodeTree nodetree, int i)
    {
        super(nodetree, i);
    }

    public void appendData(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "appendData not supported");
    }

    public void deleteData(int i, int j)
        throws DOMException
    {
        replaceData(i, j, "");
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

    public void insertData(int i, String s)
        throws DOMException
    {
        replaceData(i, 0, s);
    }

    public void replaceData(int i, int j, String s)
        throws DOMException
    {
        throw new DOMException((short)7, "replaceData not supported");
    }

    public void setData(String s)
        throws DOMException
    {
        throw new DOMException((short)7, "setData not supported");
    }

    public String substringData(int i, int j)
        throws DOMException
    {
        String s = getData();
        if (i < 0 || j < 0 || i + j >= s.length())
        {
            throw new DOMException((short)1, "invalid index to substringData");
        } else
        {
            return s.substring(i, j);
        }
    }
}
