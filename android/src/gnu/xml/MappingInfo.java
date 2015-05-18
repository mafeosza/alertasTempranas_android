// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.xml;

import gnu.mapping.Symbol;

// Referenced classes of package gnu.xml:
//            NamespaceBinding, XName

final class MappingInfo
{

    int index;
    String local;
    NamespaceBinding namespaces;
    MappingInfo nextInBucket;
    String prefix;
    Symbol qname;
    int tagHash;
    XName type;
    String uri;

    MappingInfo()
    {
        index = -1;
    }

    static boolean equals(String s, StringBuffer stringbuffer)
    {
        int j = stringbuffer.length();
        if (s.length() == j) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (stringbuffer.charAt(i) != s.charAt(i))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    static boolean equals(String s, char ac[], int i, int j)
    {
        if (s.length() == j) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int k = 0;
label0:
        do
        {
label1:
            {
                if (k >= j)
                {
                    break label1;
                }
                if (ac[i + k] != s.charAt(k))
                {
                    break label0;
                }
                k++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    static int hash(String s, String s1)
    {
        int j = s1.hashCode();
        int i = j;
        if (s != null)
        {
            i = j ^ s.hashCode();
        }
        return i;
    }

    static int hash(char ac[], int i, int j)
    {
        int l = 0;
        int i1 = 0;
        int j1 = -1;
        int k = 0;
        while (k < j) 
        {
            char c = ac[i + k];
            if (c == ':' && j1 < 0)
            {
                j1 = k;
                c = '\0';
                i1 = l;
                l = c;
            } else
            {
                l = l * 31 + c;
            }
            k++;
        }
        return i1 ^ l;
    }

    boolean match(char ac[], int i, int j)
    {
        if (prefix != null)
        {
            int k = local.length();
            int l = prefix.length();
            return j == l + 1 + k && ac[l] == ':' && equals(prefix, ac, i, l) && equals(local, ac, i + l + 1, k);
        } else
        {
            return equals(local, ac, i, j);
        }
    }
}
