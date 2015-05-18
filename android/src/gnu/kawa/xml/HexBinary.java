// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;


// Referenced classes of package gnu.kawa.xml:
//            BinaryObject

public class HexBinary extends BinaryObject
{

    public HexBinary(byte abyte0[])
    {
        data = abyte0;
    }

    static char forHexDigit(int i)
    {
        if (i < 10)
        {
            return (char)(i + 48);
        } else
        {
            return (char)((i - 10) + 65);
        }
    }

    static byte[] parseHexBinary(String s)
    {
        byte abyte0[];
        int k;
        int l;
        s = s.trim();
        int i = s.length();
        if ((i & 1) != 0)
        {
            throw new IllegalArgumentException("hexBinary string length not a multiple of 2");
        }
        l = i >> 1;
        abyte0 = new byte[l];
        k = 0;
_L7:
        if (k >= l) goto _L2; else goto _L1
_L1:
        int j;
        int i1;
        int j1;
        i1 = Character.digit(s.charAt(k * 2), 16);
        j1 = Character.digit(s.charAt(k * 2 + 1), 16);
        j = -1;
        if (i1 >= 0) goto _L4; else goto _L3
_L3:
        j = k * 2;
_L6:
        if (j >= 0)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("invalid hexBinary character at position ").append(j).toString());
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (j1 < 0)
        {
            j = k * 2 + 1;
        }
        if (true) goto _L6; else goto _L5
_L5:
        abyte0[k] = (byte)(i1 * 16 + j1);
        k++;
          goto _L7
_L2:
        return abyte0;
    }

    static HexBinary valueOf(String s)
    {
        return new HexBinary(parseHexBinary(s));
    }

    public String toString()
    {
        return toString(new StringBuffer()).toString();
    }

    public StringBuffer toString(StringBuffer stringbuffer)
    {
        byte abyte0[] = data;
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            stringbuffer.append(forHexDigit(byte0 >> 4 & 0xf));
            stringbuffer.append(forHexDigit(byte0 & 0xf));
        }

        return stringbuffer;
    }
}
