// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.Arrays;

// Referenced classes of package org.json:
//            JSONException

public class Kim
{

    private byte bytes[];
    private int hashcode;
    public int length;
    private String string;

    public Kim(String s)
        throws JSONException
    {
        bytes = null;
        hashcode = 0;
        length = 0;
        string = null;
        int k1 = s.length();
        hashcode = 0;
        length = 0;
        if (k1 > 0)
        {
            int i = 0;
            while (i < k1) 
            {
                char c = s.charAt(i);
                if (c <= '\177')
                {
                    length = length + 1;
                } else
                if (c <= '\u3FFF')
                {
                    length = length + 2;
                } else
                {
                    int j = i;
                    if (c >= '\uD800')
                    {
                        j = i;
                        if (c <= '\uDFFF')
                        {
                            j = i + 1;
                            i = s.charAt(j);
                            if (c > '\uDBFF' || i < '\uDC00' || i > '\uDFFF')
                            {
                                throw new JSONException("Bad UTF16");
                            }
                        }
                    }
                    length = length + 3;
                    i = j;
                }
                i++;
            }
            bytes = new byte[length];
            int k = 0;
            int i1 = 1;
            i = 0;
            while (i < k1) 
            {
                char c1 = s.charAt(i);
                int l;
                if (c1 <= '\177')
                {
                    bytes[k] = (byte)c1;
                    l = i1 + c1;
                    hashcode = hashcode + l;
                    k++;
                } else
                if (c1 <= '\u3FFF')
                {
                    l = c1 >>> 7 | 0x80;
                    bytes[k] = (byte)l;
                    l = i1 + l;
                    hashcode = hashcode + l;
                    k++;
                    i1 = c1 & 0x7f;
                    bytes[k] = (byte)i1;
                    l += i1;
                    hashcode = hashcode + l;
                    k++;
                } else
                {
                    int j1 = c1;
                    l = i;
                    if (c1 >= '\uD800')
                    {
                        j1 = c1;
                        l = i;
                        if (c1 <= '\uDBFF')
                        {
                            l = i + 1;
                            j1 = ((c1 & 0x3ff) << 10 | s.charAt(l) & 0x3ff) + 0x10000;
                        }
                    }
                    i = j1 >>> 14 | 0x80;
                    bytes[k] = (byte)i;
                    i = i1 + i;
                    hashcode = hashcode + i;
                    k++;
                    i1 = j1 >>> 7 & 0xff | 0x80;
                    bytes[k] = (byte)i1;
                    i += i1;
                    hashcode = hashcode + i;
                    k++;
                    i1 = j1 & 0x7f;
                    bytes[k] = (byte)i1;
                    i1 = i + i1;
                    hashcode = hashcode + i1;
                    k++;
                    i = l;
                    l = i1;
                }
                i++;
                i1 = l;
            }
            hashcode = hashcode + (i1 << 16);
        }
    }

    public Kim(Kim kim, int i, int j)
    {
        this(kim.bytes, i, j);
    }

    public Kim(byte abyte0[], int i)
    {
        this(abyte0, 0, i);
    }

    public Kim(byte abyte0[], int i, int j)
    {
        bytes = null;
        hashcode = 0;
        length = 0;
        string = null;
        int k = 1;
        hashcode = 0;
        length = j - i;
        if (length > 0)
        {
            bytes = new byte[length];
            for (j = 0; j < length; j++)
            {
                int l = abyte0[j + i] & 0xff;
                k += l;
                hashcode = hashcode + k;
                bytes[j] = (byte)l;
            }

            hashcode = hashcode + (k << 16);
        }
    }

    public static int characterSize(int i)
        throws JSONException
    {
        if (i < 0 || i > 0x10ffff)
        {
            throw new JSONException("Bad character " + i);
        }
        if (i <= 127)
        {
            return 1;
        }
        return i > 16383 ? 3 : 2;
    }

    public int characterAt(int i)
        throws JSONException
    {
        int j = get(i);
        if ((j & 0x80) != 0) goto _L2; else goto _L1
_L1:
        return j;
_L2:
        int k = get(i + 1);
        if ((k & 0x80) == 0)
        {
            k = (j & 0x7f) << 7 | k;
            j = k;
            if (k > 127)
            {
                continue; /* Loop/switch isn't completed */
            }
        } else
        {
            int l = get(i + 2);
            k = (j & 0x7f) << 14 | (k & 0x7f) << 7 | l;
            if ((l & 0x80) == 0 && k > 16383 && k <= 0x10ffff)
            {
                j = k;
                if (k < 55296)
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (k > 57343)
                {
                    return k;
                }
            }
        }
        throw new JSONException("Bad character at " + i);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public int copy(byte abyte0[], int i)
    {
        System.arraycopy(bytes, 0, abyte0, i, length);
        return length + i;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Kim)
        {
            obj = (Kim)obj;
            if (this == obj)
            {
                return true;
            }
            if (hashcode == ((Kim) (obj)).hashcode)
            {
                return Arrays.equals(bytes, ((Kim) (obj)).bytes);
            }
        }
        return false;
    }

    public int get(int i)
        throws JSONException
    {
        if (i < 0 || i > length)
        {
            throw new JSONException("Bad character at " + i);
        } else
        {
            return bytes[i] & 0xff;
        }
    }

    public int hashCode()
    {
        return hashcode;
    }

    public String toString()
        throws JSONException
    {
        if (string == null)
        {
            int i = 0;
            char ac[] = new char[length];
            int j = 0;
            while (j < length) 
            {
                int k = characterAt(j);
                if (k < 0x10000)
                {
                    ac[i] = (char)k;
                    i++;
                } else
                {
                    ac[i] = (char)(0xd800 | k - 0x10000 >>> 10);
                    i++;
                    ac[i] = (char)(0xdc00 | k & 0x3ff);
                    i++;
                }
                j += characterSize(k);
            }
            string = new String(ac, 0, i);
        }
        return string;
    }
}
