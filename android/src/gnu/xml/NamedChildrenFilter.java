// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.lists.Consumable;
import gnu.lists.Consumer;
import gnu.lists.FilterConsumer;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.Symbol;

public class NamedChildrenFilter extends FilterConsumer
{

    int level;
    String localName;
    int matchLevel;
    String namespaceURI;

    public NamedChildrenFilter(String s, String s1, Consumer consumer)
    {
        super(consumer);
        namespaceURI = s;
        localName = s1;
        skipping = true;
    }

    public static NamedChildrenFilter make(String s, String s1, Consumer consumer)
    {
        return new NamedChildrenFilter(s, s1, consumer);
    }

    public void endDocument()
    {
        level = level - 1;
        super.endDocument();
    }

    public void endElement()
    {
        level = level - 1;
        super.endElement();
        if (!skipping && matchLevel == level)
        {
            skipping = true;
        }
    }

    public void startDocument()
    {
        level = level + 1;
        super.startDocument();
    }

    public void startElement(Object obj)
    {
        if (skipping && level == 1)
        {
            Object obj1;
            String s;
            if (obj instanceof Symbol)
            {
                obj1 = (Symbol)obj;
                s = ((Symbol) (obj1)).getNamespaceURI();
                obj1 = ((Symbol) (obj1)).getLocalName();
            } else
            {
                s = "";
                obj1 = obj.toString().intern();
            }
            if ((localName == obj1 || localName == null) && (namespaceURI == s || namespaceURI == null))
            {
                skipping = false;
                matchLevel = level;
            }
        }
        super.startElement(obj);
        level = level + 1;
    }

    public void writeObject(Object obj)
    {
        if (obj instanceof SeqPosition)
        {
            SeqPosition seqposition = (SeqPosition)obj;
            if (seqposition.sequence instanceof TreeList)
            {
                ((TreeList)seqposition.sequence).consumeNext(seqposition.ipos, this);
                return;
            }
        }
        if (obj instanceof Consumable)
        {
            ((Consumable)obj).consume(this);
            return;
        } else
        {
            super.writeObject(obj);
            return;
        }
    }
}
