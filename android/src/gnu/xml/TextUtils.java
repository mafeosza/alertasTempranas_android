// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.kawa.xml.KNode;
import gnu.lists.Consumer;
import gnu.lists.TreeList;
import gnu.mapping.Values;
import gnu.math.DFloNum;
import java.math.BigDecimal;

// Referenced classes of package gnu.xml:
//            NodeTree, XMLPrinter

public class TextUtils
{

    public TextUtils()
    {
    }

    public static String asString(Object obj)
    {
        if (obj == Values.empty || obj == null)
        {
            return "";
        }
        if (obj instanceof Values)
        {
            throw new ClassCastException();
        } else
        {
            StringBuffer stringbuffer = new StringBuffer(100);
            stringValue(obj, stringbuffer);
            return stringbuffer.toString();
        }
    }

    public static String replaceWhitespace(String s, boolean flag)
    {
        StringBuilder stringbuilder = null;
        int k1 = s.length();
        int i;
        int j;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = 0;
label0:
        do
        {
            char c;
            StringBuilder stringbuilder1;
            int k;
label1:
            {
                if (j >= k1)
                {
                    break label0;
                }
                k = j + 1;
                char c1 = s.charAt(j);
                int l;
                int j1;
                if (c1 == ' ')
                {
                    j = 1;
                } else
                if (c1 == '\t' || c1 == '\r' || c1 == '\n')
                {
                    j = 2;
                } else
                {
                    j = 0;
                }
                c = c1;
                stringbuilder1 = stringbuilder;
                if (stringbuilder != null)
                {
                    break label1;
                }
                if (j != 2 && (j != 1 || i <= 0 || !flag))
                {
                    c = c1;
                    stringbuilder1 = stringbuilder;
                    if (j != 1)
                    {
                        break label1;
                    }
                    c = c1;
                    stringbuilder1 = stringbuilder;
                    if (k != k1)
                    {
                        break label1;
                    }
                    c = c1;
                    stringbuilder1 = stringbuilder;
                    if (!flag)
                    {
                        break label1;
                    }
                }
                stringbuilder1 = new StringBuilder();
                if (i > 0)
                {
                    l = k - 2;
                } else
                {
                    l = k - 1;
                }
                for (j1 = 0; j1 < l; j1++)
                {
                    stringbuilder1.append(s.charAt(j1));
                }

                c = ' ';
            }
            int i1 = i;
            if (flag)
            {
                if (i > 0 && j == 0)
                {
                    if (stringbuilder1 != null && stringbuilder1.length() > 0)
                    {
                        stringbuilder1.append(' ');
                    }
                    i = 0;
                } else
                if (j == 2 || j == 1 && i > 0)
                {
                    i = 2;
                } else
                if (j > 0)
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                i1 = i;
                if (i > 0)
                {
                    j = k;
                    stringbuilder = stringbuilder1;
                    continue;
                }
            }
            if (stringbuilder1 != null)
            {
                stringbuilder1.append(c);
            }
            j = k;
            i = i1;
            stringbuilder = stringbuilder1;
        } while (true);
        if (stringbuilder != null)
        {
            s = stringbuilder.toString();
        }
        return s;
    }

    public static String stringValue(Object obj)
    {
        StringBuffer stringbuffer;
        int i;
        stringbuffer = new StringBuffer(100);
        if (!(obj instanceof Values))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        obj = (TreeList)obj;
        i = 0;
_L3:
        int j = ((TreeList) (obj)).getNextKind(i);
        if (j != 0) goto _L2; else goto _L1
_L1:
        return stringbuffer.toString();
_L2:
        if (j == 32)
        {
            stringValue(((TreeList) (obj)).getPosNext(i), stringbuffer);
        } else
        {
            ((TreeList) (obj)).stringValue(((TreeList) (obj)).posToDataIndex(i), stringbuffer);
        }
        i = ((TreeList) (obj)).nextPos(i);
          goto _L3
        stringValue(obj, stringbuffer);
          goto _L1
    }

    public static void stringValue(Object obj, StringBuffer stringbuffer)
    {
        if (!(obj instanceof KNode)) goto _L2; else goto _L1
_L1:
        obj = (KNode)obj;
        NodeTree nodetree = (NodeTree)((KNode) (obj)).sequence;
        nodetree.stringValue(nodetree.posToDataIndex(((KNode) (obj)).ipos), stringbuffer);
_L4:
        return;
_L2:
        Object obj1;
        if (!(obj instanceof BigDecimal))
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = XMLPrinter.formatDecimal((BigDecimal)obj);
_L5:
        if (obj1 != null && obj1 != Values.empty)
        {
            stringbuffer.append(obj1);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if ((obj instanceof Double) || (obj instanceof DFloNum))
        {
            obj1 = XMLPrinter.formatDouble(((Number)obj).doubleValue());
        } else
        {
            obj1 = obj;
            if (obj instanceof Float)
            {
                obj1 = XMLPrinter.formatFloat(((Number)obj).floatValue());
            }
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public static void textValue(Object obj, Consumer consumer)
    {
        if (obj == null || (obj instanceof Values) && ((Values)obj).isEmpty())
        {
            return;
        }
        if (obj instanceof String)
        {
            obj = (String)obj;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer();
            if (obj instanceof Values)
            {
                obj = ((Object) (((Values)obj).getValues()));
                for (int i = 0; i < obj.length; i++)
                {
                    if (i > 0)
                    {
                        stringbuffer.append(' ');
                    }
                    stringValue(obj[i], stringbuffer);
                }

            } else
            {
                stringValue(obj, stringbuffer);
            }
            obj = stringbuffer.toString();
        }
        consumer.write(((String) (obj)));
    }
}
