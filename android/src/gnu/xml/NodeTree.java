// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.kawa.xml.ElementType;
import gnu.kawa.xml.KNode;
import gnu.kawa.xml.UntypedAtomic;
import gnu.lists.AbstractSequence;
import gnu.lists.SeqPosition;
import gnu.lists.TreeList;
import gnu.mapping.CharArrayOutPort;
import gnu.mapping.Symbol;
import gnu.text.Path;
import gnu.text.URIPath;

// Referenced classes of package gnu.xml:
//            XName, XMLPrinter

public class NodeTree extends TreeList
{

    static int counter;
    int id;
    int idCount;
    String idNames[];
    int idOffsets[];

    public NodeTree()
    {
    }

    public static NodeTree make()
    {
        return new NodeTree();
    }

    public int ancestorAttribute(int i, String s, String s1)
    {
_L6:
        if (i != -1) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        int k;
        k = getAttributeI(i, s, s1);
        j = k;
        if (k != 0) goto _L4; else goto _L3
_L3:
        i = parentPos(i);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public Path baseUriOfPos(int i, boolean flag)
    {
        Object obj1;
        int j;
        obj1 = null;
        int k = posToDataIndex(i);
        j = i;
        i = k;
_L6:
        Object obj2;
        char c;
        if (i == data.length)
        {
            return null;
        }
        c = data[i];
        obj2 = null;
        if (c != '\uF112') goto _L2; else goto _L1
_L1:
        Object obj;
        j = getIntN(i + 1);
        obj = obj2;
        if (j >= 0)
        {
            obj = URIPath.makeURI(objects[j]);
        }
_L4:
        obj2 = obj1;
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (obj1 != null && flag)
        {
            obj = ((Path) (obj)).resolve(((Path) (obj1)));
        }
        if (!((Path) (obj)).isAbsolute())
        {
            obj2 = obj;
            if (flag)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        return ((Path) (obj));
_L2:
        if (c < '\uA000' || c > '\uAFFF')
        {
            obj = obj2;
            if (c != '\uF108')
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        j = getAttributeI(j, "http://www.w3.org/XML/1998/namespace", "base");
        obj = obj2;
        if (j != 0)
        {
            obj = URIPath.valueOf(KNode.getNodeValue(this, j));
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = parentOrEntityI(i);
        if (i == -1)
        {
            return ((Path) (obj2));
        }
        j = i << 1;
        obj1 = obj2;
        if (true) goto _L6; else goto _L5
_L5:
    }

    void enterID(String s, int i)
    {
        Object obj1;
        int j;
        int k;
        int l;
        obj1 = idNames;
        int ai1[] = idOffsets;
        Object obj;
        int ai[];
        if (obj1 == null)
        {
            j = 64;
            idNames = new String[64];
            idOffsets = new int[64];
            ai = ai1;
            obj = obj1;
        } else
        {
            l = idCount;
            k = idNames.length;
            j = k;
            obj = obj1;
            ai = ai1;
            if (l * 4 >= k * 3)
            {
                idNames = new String[k * 2];
                idOffsets = new int[k * 2];
                idCount = 0;
                j = k;
                do
                {
                    l = j - 1;
                    if (l < 0)
                    {
                        break;
                    }
                    obj = obj1[l];
                    j = l;
                    if (obj != null)
                    {
                        enterID(((String) (obj)), ai1[l]);
                        j = l;
                    }
                } while (true);
                obj = idNames;
                ai = idOffsets;
                j = k * 2;
            }
        }
        k = s.hashCode();
        l = j - 1;
        j = k & l;
_L6:
        obj1 = obj[j];
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        obj[j] = s;
        ai[j] = i;
        idCount = idCount + 1;
_L4:
        return;
_L2:
        if (((String) (obj1)).equals(s)) goto _L4; else goto _L3
_L3:
        j = j + (~k << 1 | 1) & l;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int getAttribute(int i, String s, String s1)
    {
        Object obj = null;
        if (s == null)
        {
            s = null;
        } else
        {
            s = s.intern();
        }
        if (s1 == null)
        {
            s1 = obj;
        } else
        {
            s1 = s1.intern();
        }
        return getAttributeI(i, s, s1);
    }

    public int getAttributeI(int i, String s, String s1)
    {
        i = firstAttributePos(i);
_L7:
        if (i != 0 && getNextKind(i) == 35) goto _L2; else goto _L1
_L1:
        int j = 0;
_L4:
        return j;
_L2:
        if (s1 != null && posLocalName(i) != s1)
        {
            break; /* Loop/switch isn't completed */
        }
        j = i;
        if (s == null) goto _L4; else goto _L3
_L3:
        j = i;
        if (posNamespaceURI(i) == s) goto _L4; else goto _L5
_L5:
        i = nextPos(i);
        if (true) goto _L7; else goto _L6
_L6:
    }

    public int getId()
    {
        if (id == 0)
        {
            int i = counter + 1;
            counter = i;
            id = i;
        }
        return id;
    }

    public SeqPosition getIteratorAtPos(int i)
    {
        return KNode.make(this, i);
    }

    public int lookupID(String s)
    {
        String as[] = idNames;
        int ai[] = idOffsets;
        int i = idNames.length;
        int j = s.hashCode();
        int k = i - 1;
        i = j & k;
        do
        {
            String s1 = as[i];
            if (s1 == null)
            {
                return -1;
            }
            if (s1.equals(s))
            {
                return ai[i];
            }
            i = i + (~j << 1 | 1) & k;
        } while (true);
    }

    public void makeIDtableIfNeeded()
    {
        if (idNames == null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        idNames = new String[64];
        idOffsets = new int[64];
        int k = endPos();
        int i = 0;
        do
        {
            int j = nextMatching(i, ElementType.anyElement, k, true);
            if (j == 0)
            {
                continue;
            }
            int l = getAttributeI(j, "http://www.w3.org/XML/1998/namespace", "id");
            i = j;
            if (l != 0)
            {
                enterID(KNode.getNodeValue(this, l), j);
                i = j;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int nextPos(int i)
    {
        boolean flag = false;
        if ((i & 1) == 0);
        int j = posToDataIndex(i);
        i = nextNodeIndex(j, 0x7fffffff);
        if (i != j)
        {
            i <<= 1;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (j != data.length)
            {
                return (j << 1) + 3;
            }
        }
        return i;
    }

    public int posFirstChild(int i)
    {
        i = gotoChildrenStart(posToDataIndex(i));
        char c;
        if (i >= 0)
        {
            if ((c = data[i]) != '\uF10B' && c != '\uF10C' && c != '\uF111')
            {
                return i << 1;
            }
        }
        return -1;
    }

    public boolean posHasAttributes(int i)
    {
        for (i = gotoAttributesStart(posToDataIndex(i)); i < 0 || i < 0 || data[i] != '\uF109';)
        {
            return false;
        }

        return true;
    }

    public boolean posIsDefaultNamespace(int i, String s)
    {
        throw new Error("posIsDefaultNamespace not implemented");
    }

    public String posLocalName(int i)
    {
        Object obj = getNextTypeObject(i);
        if (obj instanceof XName)
        {
            return ((XName)obj).getLocalPart();
        }
        if (obj instanceof Symbol)
        {
            return ((Symbol)obj).getLocalName();
        } else
        {
            return getNextTypeName(i);
        }
    }

    public String posLookupNamespaceURI(int i, String s)
    {
        if (getNextKind(i) != 33)
        {
            throw new IllegalArgumentException("argument must be an element");
        }
        Object obj = getNextTypeObject(i);
        if (obj instanceof XName)
        {
            return ((XName)obj).lookupNamespaceURI(s);
        } else
        {
            return null;
        }
    }

    public String posLookupPrefix(int i, String s)
    {
        throw new Error("posLookupPrefix not implemented");
    }

    public String posNamespaceURI(int i)
    {
        Object obj = getNextTypeObject(i);
        if (obj instanceof XName)
        {
            return ((XName)obj).getNamespaceURI();
        }
        if (obj instanceof Symbol)
        {
            return ((Symbol)obj).getNamespaceURI();
        } else
        {
            return null;
        }
    }

    public String posPrefix(int i)
    {
        String s = getNextTypeName(i);
        if (s != null)
        {
            if ((i = s.indexOf(':')) >= 0)
            {
                return s.substring(0, i);
            }
        }
        return null;
    }

    public String posTarget(int i)
    {
        i = posToDataIndex(i);
        if (data[i] != '\uF114')
        {
            throw new ClassCastException("expected process-instruction");
        } else
        {
            return (String)objects[getIntN(i + 1)];
        }
    }

    public int stableCompare(AbstractSequence abstractsequence)
    {
        if (this == abstractsequence)
        {
            return 0;
        }
        int j = super.stableCompare(abstractsequence);
        int i = j;
        if (j == 0)
        {
            i = j;
            if (abstractsequence instanceof NodeTree)
            {
                i = getId();
                int k = ((NodeTree)abstractsequence).getId();
                if (i < k)
                {
                    i = -1;
                } else
                if (i > k)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
            }
        }
        return i;
    }

    public String toString()
    {
        CharArrayOutPort chararrayoutport = new CharArrayOutPort();
        consume(new XMLPrinter(chararrayoutport));
        chararrayoutport.close();
        return chararrayoutport.toString();
    }

    public Object typedValue(int i)
    {
        Object obj = new StringBuffer();
        stringValue(posToDataIndex(i), ((StringBuffer) (obj)));
        obj = ((StringBuffer) (obj)).toString();
        i = getNextKind(i);
        if (i == 37 || i == 36)
        {
            return obj;
        } else
        {
            return new UntypedAtomic(((String) (obj)));
        }
    }
}
