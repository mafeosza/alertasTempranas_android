// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.mapping.Symbol;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.xml:
//            NamespaceBinding

public class XName extends Symbol
    implements Externalizable
{

    NamespaceBinding namespaceNodes;

    public XName()
    {
    }

    public XName(Symbol symbol, NamespaceBinding namespacebinding)
    {
        super(symbol.getNamespace(), symbol.getName());
        namespaceNodes = namespacebinding;
    }

    public static int checkName(String s)
    {
        int l = s.length();
        if (l != 0) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        byte byte0 = 2;
        int i = 0;
        do
        {
            j = byte0;
            if (i >= l)
            {
                continue;
            }
            boolean flag;
            int k;
            char c;
            if (i == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            j = i + 1;
            c = s.charAt(i);
            k = c;
            i = j;
            if (c >= '\uD800')
            {
                k = c;
                i = j;
                if (c < '\uDC00')
                {
                    k = c;
                    i = j;
                    if (j < l)
                    {
                        k = (c - 55296) * 1024 + (s.charAt(j) - 56320) + 0x10000;
                        i = j + 1;
                    }
                }
            }
            if (k == 58)
            {
                j = byte0;
                if (byte0 == 2)
                {
                    j = 1;
                }
            } else
            {
                if (!isNamePart(k))
                {
                    return -1;
                }
                j = byte0;
                if (flag)
                {
                    j = byte0;
                    if (!isNameStart(k))
                    {
                        j = 0;
                    }
                }
            }
            byte0 = j;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isNCName(String s)
    {
        return checkName(s) > 1;
    }

    public static boolean isName(String s)
    {
        return checkName(s) > 0;
    }

    public static boolean isNamePart(int i)
    {
        return Character.isUnicodeIdentifierPart(i) || i == 45 || i == 46;
    }

    public static boolean isNameStart(int i)
    {
        return Character.isUnicodeIdentifierStart(i) || i == 95;
    }

    public static boolean isNmToken(String s)
    {
        return checkName(s) >= 0;
    }

    public final NamespaceBinding getNamespaceNodes()
    {
        return namespaceNodes;
    }

    String lookupNamespaceURI(String s)
    {
        for (NamespaceBinding namespacebinding = namespaceNodes; namespacebinding != null; namespacebinding = namespacebinding.next)
        {
            if (s == namespacebinding.prefix)
            {
                return namespacebinding.uri;
            }
        }

        return null;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        super.readExternal(objectinput);
        namespaceNodes = (NamespaceBinding)objectinput.readObject();
    }

    public final void setNamespaceNodes(NamespaceBinding namespacebinding)
    {
        namespaceNodes = namespacebinding;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        super.writeExternal(objectoutput);
        objectoutput.writeObject(namespaceNodes);
    }
}
