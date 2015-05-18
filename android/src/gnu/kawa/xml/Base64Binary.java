// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;


// Referenced classes of package gnu.kawa.xml:
//            BinaryObject

public class Base64Binary extends BinaryObject
{

    public static final String ENCODING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";

    public Base64Binary(String s)
    {
        byte abyte0[];
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        i2 = s.length();
        k = 0;
        for (int i = 0; i < i2;)
        {
            char c = s.charAt(i);
            int l = k;
            if (!Character.isWhitespace(c))
            {
                l = k;
                if (c != '=')
                {
                    l = k + 1;
                }
            }
            i++;
            k = l;
        }

        abyte0 = new byte[(k * 3) / 4];
        l1 = 0;
        i1 = 0;
        k1 = 0;
        j1 = 0;
        k = 0;
_L3:
        if (j1 >= i2) goto _L2; else goto _L1
_L1:
        char c1;
        int j;
        c1 = s.charAt(j1);
        if (c1 >= 'A' && c1 <= 'Z')
        {
            j = c1 - 65;
        } else
        if (c1 >= 'a' && c1 <= 'z')
        {
            j = (c1 - 97) + 26;
        } else
        if (c1 >= '0' && c1 <= '9')
        {
            j = (c1 - 48) + 52;
        } else
        if (c1 == '+')
        {
            j = 62;
        } else
        {
label0:
            {
                if (c1 != '/')
                {
                    break label0;
                }
                j = 63;
            }
        }
_L4:
        if (j < 0 || k1 > 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("illegal character in base64Binary string at position ").append(j1).toString());
        }
        break MISSING_BLOCK_LABEL_287;
        if (Character.isWhitespace(c1))
        {
            j = k;
        } else
        {
label1:
            {
                if (c1 != '=')
                {
                    break label1;
                }
                k1++;
                j = k;
            }
        }
_L5:
        j1++;
        k = j;
          goto _L3
        j = -1;
          goto _L4
        l1 = (l1 << 6) + j;
        i1++;
        if (i1 == 4)
        {
            j = k + 1;
            abyte0[k] = (byte)(l1 >> 16);
            k = j + 1;
            abyte0[j] = (byte)(l1 >> 8);
            j = k + 1;
            abyte0[k] = (byte)l1;
            i1 = 0;
        } else
        {
            j = k;
        }
          goto _L5
_L2:
        if (i1 + k1 <= 0 ? k != abyte0.length : i1 + k1 != 4 || ((1 << k1) - 1 & l1) != 0 || (k + 3) - k1 != abyte0.length)
        {
            throw new IllegalArgumentException();
        }
        k1;
        JVM INSTR tableswitch 1 2: default 440
    //                   1 446
    //                   2 474;
           goto _L6 _L7 _L8
_L6:
        data = abyte0;
        return;
_L7:
        j = k + 1;
        abyte0[k] = (byte)(l1 << 10);
        abyte0[j] = (byte)(l1 >> 2);
        continue; /* Loop/switch isn't completed */
_L8:
        abyte0[k] = (byte)(l1 >> 4);
        if (true) goto _L6; else goto _L9
_L9:
          goto _L4
    }

    public Base64Binary(byte abyte0[])
    {
        data = abyte0;
    }

    public static Base64Binary valueOf(String s)
    {
        return new Base64Binary(s);
    }

    public String toString()
    {
        return toString(new StringBuffer()).toString();
    }

    public StringBuffer toString(StringBuffer stringbuffer)
    {
        byte abyte0[] = data;
        int i1 = abyte0.length;
        int i = 0;
        int j = 0;
        do
        {
            if (j >= i1)
            {
                break;
            }
            int k = i << 8 | abyte0[j] & 0xff;
            int l = j + 1;
            j = l;
            i = k;
            if (l % 3 == 0)
            {
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(k >> 18 & 0x3f));
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(k >> 12 & 0x3f));
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(k >> 6 & 0x3f));
                stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(k & 0x3f));
                j = l;
                i = k;
            }
        } while (true);
        switch (i1 % 3)
        {
        default:
            return stringbuffer;

        case 1: // '\001'
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(i >> 2 & 0x3f));
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(i << 4 & 0x3f));
            stringbuffer.append("==");
            return stringbuffer;

        case 2: // '\002'
            stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(i >> 10 & 0x3f));
            break;
        }
        stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(i >> 4 & 0x3f));
        stringbuffer.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".charAt(i << 2 & 0x3f));
        stringbuffer.append('=');
        return stringbuffer;
    }
}
