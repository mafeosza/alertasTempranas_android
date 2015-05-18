// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;


// Referenced classes of package gnu.math:
//            IntNum, MPN

public class BitOps
{

    static final byte bit4_count[] = {
        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 
        2, 3, 2, 3, 3, 4
    };

    private BitOps()
    {
    }

    public static IntNum and(IntNum intnum, int i)
    {
        if (intnum.words == null)
        {
            return IntNum.make(intnum.ival & i);
        }
        if (i >= 0)
        {
            return IntNum.make(intnum.words[0] & i);
        }
        int j = intnum.ival;
        int ai[] = new int[j];
        ai[0] = intnum.words[0] & i;
        i = j;
        do
        {
            i--;
            if (i > 0)
            {
                ai[i] = intnum.words[i];
            } else
            {
                return IntNum.make(ai, intnum.ival);
            }
        } while (true);
    }

    public static IntNum and(IntNum intnum, IntNum intnum1)
    {
        if (intnum1.words == null)
        {
            return and(intnum, intnum1.ival);
        }
        if (intnum.words == null)
        {
            return and(intnum1, intnum.ival);
        }
        IntNum intnum3 = intnum;
        IntNum intnum2 = intnum1;
        if (intnum.ival < intnum1.ival)
        {
            intnum2 = intnum;
            intnum3 = intnum1;
        }
        int i;
        int j;
        int k;
        if (intnum2.isNegative())
        {
            j = intnum3.ival;
        } else
        {
            j = intnum2.ival;
        }
        intnum = new int[j];
        i = 0;
        do
        {
            k = i;
            if (i >= intnum2.ival)
            {
                break;
            }
            intnum[i] = intnum3.words[i] & intnum2.words[i];
            i++;
        } while (true);
        for (; k < j; k++)
        {
            intnum[k] = intnum3.words[k];
        }

        return IntNum.make(intnum, j);
    }

    public static int bitCount(int i)
    {
        int j = 0;
        for (; i != 0; i >>>= 4)
        {
            j += bit4_count[i & 0xf];
        }

        return j;
    }

    public static int bitCount(IntNum intnum)
    {
        int ai[] = intnum.words;
        int i;
        int j;
        int k;
        if (ai == null)
        {
            j = 1;
            i = bitCount(intnum.ival);
        } else
        {
            j = intnum.ival;
            i = bitCount(ai, j);
        }
        k = i;
        if (intnum.isNegative())
        {
            k = j * 32 - i;
        }
        return k;
    }

    public static int bitCount(int ai[], int i)
    {
        boolean flag = false;
        int j = i;
        i = ((flag) ? 1 : 0);
        do
        {
            j--;
            if (j >= 0)
            {
                i += bitCount(ai[j]);
            } else
            {
                return i;
            }
        } while (true);
    }

    public static IntNum bitOp(int i, IntNum intnum, IntNum intnum1)
    {
        IntNum intnum2 = intnum;
        switch (i)
        {
        default:
            intnum2 = new IntNum();
            setBitOp(intnum2, i, intnum, intnum1);
            intnum2 = intnum2.canonicalize();
            // fall through

        case 3: // '\003'
            return intnum2;

        case 0: // '\0'
            return IntNum.zero();

        case 1: // '\001'
            return and(intnum, intnum1);

        case 5: // '\005'
            return intnum1;

        case 15: // '\017'
            return IntNum.minusOne();
        }
    }

    public static boolean bitValue(IntNum intnum, int i)
    {
        int j = intnum.ival;
        if (intnum.words != null) goto _L2; else goto _L1
_L1:
        if (i < 32) goto _L4; else goto _L3
_L3:
        if (j >= 0) goto _L6; else goto _L5
_L5:
        return true;
_L6:
        return false;
_L4:
        if ((j >> i & 1) != 0) goto _L5; else goto _L7
_L7:
        return false;
_L2:
        int k;
        k = i >> 5;
        if (k < j)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (intnum.words[j - 1] < 0) goto _L5; else goto _L8
_L8:
        return false;
        if ((intnum.words[k] >> i & 1) != 0) goto _L5; else goto _L9
_L9:
        return false;
    }

    static int[] dataBufferFor(IntNum intnum, int i)
    {
        int j = intnum.ival;
        int k = i + 1 >> 5;
        if (intnum.words == null)
        {
            i = k;
            if (k == 0)
            {
                i = 1;
            }
            int ai[] = new int[i];
            ai[0] = j;
            intnum = ai;
            if (j < 0)
            {
                j = 1;
                do
                {
                    intnum = ai;
                    if (j >= i)
                    {
                        break;
                    }
                    ai[j] = -1;
                    j++;
                } while (true);
            }
        } else
        {
            int l = i + 1 >> 5;
            int ai1[];
            if (l > j)
            {
                i = l;
            } else
            {
                i = j;
            }
            ai1 = new int[i];
            i = j;
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                ai1[i] = intnum.words[i];
            } while (true);
            intnum = ai1;
            if (ai1[j - 1] < 0)
            {
                do
                {
                    intnum = ai1;
                    if (j >= l)
                    {
                        break;
                    }
                    ai1[j] = -1;
                    j++;
                } while (true);
            }
        }
        return intnum;
    }

    public static IntNum extract(IntNum intnum, int i, int j)
    {
        if (j >= 32) goto _L2; else goto _L1
_L1:
        IntNum intnum1;
        int k;
        if (intnum.words == null)
        {
            k = intnum.ival;
        } else
        {
            k = intnum.words[0];
        }
        intnum1 = IntNum.make((~(-1 << j) & k) >> i);
_L4:
        return intnum1;
_L2:
        int l;
        int i1;
        int j1;
        boolean flag;
        if (intnum.words == null)
        {
            if (intnum.ival >= 0)
            {
                if (i >= 31)
                {
                    i = 0;
                } else
                {
                    i = intnum.ival >> i;
                }
                return IntNum.make(i);
            }
            l = 1;
        } else
        {
            l = intnum.ival;
        }
        flag = intnum.isNegative();
        if (j <= l * 32)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        j1 = l * 32;
        i1 = l;
        j = j1;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        intnum1 = intnum;
        if (i == 0) goto _L4; else goto _L3
_L3:
        j = j1;
        i1 = l;
_L5:
        l = j - i;
        if (l < 64)
        {
            long l1;
            if (intnum.words == null)
            {
                j = intnum.ival;
                if (i >= 32)
                {
                    i = 31;
                }
                l1 = j >> i;
            } else
            {
                l1 = MPN.rshift_long(intnum.words, i1, i);
            }
            return IntNum.make(~(-1L << l) & l1);
        }
        break MISSING_BLOCK_LABEL_227;
        i1 = j + 31 >> 5;
          goto _L5
        int k1 = i >> 5;
        int ai[] = new int[((j >> 5) + 1) - k1];
        if (intnum.words == null)
        {
            if (i >= 32)
            {
                i = -1;
            } else
            {
                i = intnum.ival >> i;
            }
            ai[0] = i;
        } else
        {
            MPN.rshift0(ai, intnum.words, k1, i1 - k1, i & 0x1f);
        }
        i = l >> 5;
        ai[i] = ai[i] & ~(-1 << l);
        return IntNum.make(ai, i + 1);
    }

    public static IntNum ior(IntNum intnum, IntNum intnum1)
    {
        return bitOp(7, intnum, intnum1);
    }

    public static int lowestBitSet(int i)
    {
        int j;
        if (i == 0)
        {
            j = -1;
        } else
        {
            j = 0;
            int k = i;
            int l;
            do
            {
                i = j;
                l = k;
                if ((k & 0xff) != 0)
                {
                    break;
                }
                k >>>= 8;
                j += 8;
            } while (true);
            while ((l & 3) == 0) 
            {
                l >>>= 2;
                i += 2;
            }
            j = i;
            if ((l & 1) == 0)
            {
                return i + 1;
            }
        }
        return j;
    }

    public static int lowestBitSet(IntNum intnum)
    {
        int ai[] = intnum.words;
        if (ai == null)
        {
            return lowestBitSet(intnum.ival);
        }
        for (int i = intnum.ival; i < 0;)
        {
            int j = lowestBitSet(ai[0]);
            if (j >= 0)
            {
                return j + 0;
            }
        }

        return -1;
    }

    public static IntNum not(IntNum intnum)
    {
        return bitOp(12, intnum, IntNum.zero());
    }

    public static IntNum reverseBits(IntNum intnum, int i, int j)
    {
        int k = intnum.ival;
        if (intnum.words == null && j < 63)
        {
            long l2 = k;
            for (j--; i < j; j--)
            {
                l2 = (l2 >> i & 1L) << j | l2 & ~(1L << i | 1L << j) | (l2 >> j & 1L) << i;
                i++;
            }

            return IntNum.make(l2);
        }
        intnum = dataBufferFor(intnum, j - 1);
        k = i;
        i = j - 1;
        j = k;
        while (j < i) 
        {
            int i1 = j >> 5;
            int j1 = i >> 5;
            int l = intnum[i1];
            int k1 = l >> j & 1;
            if (i1 == j1)
            {
                l = k1 << i | (int)((long)l & ~(1L << j | 1L << i)) | (l >> i & 1) << j;
            } else
            {
                int l1 = intnum[j1];
                l = l & ~(1 << (j & 0x1f)) | (l1 >> (i & 0x1f) & 1) << (j & 0x1f);
                intnum[j1] = l1 & ~(1 << (i & 0x1f)) | k1 << (i & 0x1f);
            }
            intnum[i1] = l;
            j++;
            i--;
        }
        return IntNum.make(intnum, intnum.length);
    }

    public static void setBitOp(IntNum intnum, int i, IntNum intnum1, IntNum intnum2)
    {
        if (intnum2.words != null) goto _L2; else goto _L1
_L1:
        IntNum intnum3;
        IntNum intnum4;
        int i1;
        intnum4 = intnum2;
        intnum3 = intnum1;
        i1 = i;
_L25:
        int j;
        int k;
        int j1;
        boolean flag;
        if (intnum4.words == null)
        {
            i = intnum4.ival;
            k = 1;
        } else
        {
            i = intnum4.words[0];
            k = intnum4.ival;
        }
        if (intnum3.words == null)
        {
            j = intnum3.ival;
            j1 = 1;
        } else
        {
            j = intnum3.words[0];
            j1 = intnum3.ival;
        }
        if (j1 > 1)
        {
            intnum.realloc(j1);
        }
        intnum1 = intnum.words;
        flag = false;
        i1;
        JVM INSTR tableswitch 0 14: default 148
    //                   0 281
    //                   1 1403
    //                   2 1394
    //                   3 449
    //                   4 1385
    //                   5 1379
    //                   6 1373
    //                   7 1364
    //                   8 1355
    //                   9 1349
    //                   10 1343
    //                   11 1334
    //                   12 1035
    //                   13 1325
    //                   14 1316;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L3:
        j = -1;
        i = 0;
        k = ((flag) ? 1 : 0);
_L26:
        if (i + 1 == j1)
        {
            k = 0;
        }
        k;
        JVM INSTR tableswitch 0 2: default 196
    //                   0 1207
    //                   1 1238
    //                   2 1276;
           goto _L19 _L20 _L21 _L22
_L19:
        intnum.ival = i;
        return;
_L2:
        if (intnum1.words == null) goto _L24; else goto _L23
_L23:
        i1 = i;
        intnum3 = intnum1;
        intnum4 = intnum2;
        if (intnum1.ival >= intnum2.ival) goto _L25; else goto _L24
_L24:
        i1 = swappedOp(i);
        intnum3 = intnum2;
        intnum4 = intnum1;
          goto _L25
_L4:
        j = 0;
        i = 0;
        k = ((flag) ? 1 : 0);
          goto _L26
_L28:
        int k1;
        int l1;
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L66:
        l1 = j & k1;
        if (i1 + 1 < k) goto _L28; else goto _L27
_L27:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 < 0)
        {
            k = 1;
            i = i1;
            j = l1;
        }
          goto _L26
_L30:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L65:
        l1 = j & ~k1;
        if (i1 + 1 < k) goto _L30; else goto _L29
_L29:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 >= 0)
        {
            k = 1;
            i = i1;
            j = l1;
        }
          goto _L26
_L7:
        k = 1;
        i = 0;
          goto _L26
_L32:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L64:
        l1 = ~j & k1;
        if (i1 + 1 < k) goto _L32; else goto _L31
_L31:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 < 0)
        {
            k = 2;
            i = i1;
            j = l1;
        }
          goto _L26
_L34:
        i = j + 1;
        intnum1[j] = i1;
        j = intnum3.words[i];
        i1 = intnum4.words[i];
        j = i;
        i = i1;
_L63:
        i1 = i;
        if (j + 1 < k) goto _L34; else goto _L33
_L33:
        k = ((flag) ? 1 : 0);
        i = j;
        j = i1;
          goto _L26
_L36:
        i = i1 + 1;
        intnum1[i1] = j;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
        i = k1;
_L62:
        j ^= i;
        if (i1 + 1 < k) goto _L36; else goto _L35
_L35:
        if (i < 0)
        {
            k = 2;
        } else
        {
            k = 1;
        }
        i = i1;
          goto _L26
_L38:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L61:
        l1 = j | k1;
        if (i1 + 1 < k) goto _L38; else goto _L37
_L37:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 >= 0)
        {
            k = 1;
            i = i1;
            j = l1;
        }
          goto _L26
_L40:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L60:
        l1 = ~(j | k1);
        if (i1 + 1 < k) goto _L40; else goto _L39
_L39:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 >= 0)
        {
            k = 2;
            i = i1;
            j = l1;
        }
          goto _L26
_L42:
        i = i1 + 1;
        intnum1[i1] = j;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
        i = k1;
_L59:
        j = ~(j ^ i);
        if (i1 + 1 < k) goto _L42; else goto _L41
_L41:
        if (i >= 0)
        {
            k = 2;
        } else
        {
            k = 1;
        }
        i = i1;
          goto _L26
_L44:
        i = j + 1;
        intnum1[j] = i1;
        j = intnum3.words[i];
        i1 = intnum4.words[i];
        j = i;
        i = i1;
_L58:
        i1 = ~i;
        if (j + 1 < k) goto _L44; else goto _L43
_L43:
        k = ((flag) ? 1 : 0);
        i = j;
        j = i1;
          goto _L26
_L46:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L57:
        l1 = j | ~k1;
        if (i1 + 1 < k) goto _L46; else goto _L45
_L45:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 < 0)
        {
            k = 1;
            i = i1;
            j = l1;
        }
          goto _L26
_L16:
        j = ~j;
        k = 2;
        i = 0;
          goto _L26
_L48:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L56:
        l1 = ~j | k1;
        if (i1 + 1 < k) goto _L48; else goto _L47
_L47:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 >= 0)
        {
            k = 2;
            i = i1;
            j = l1;
        }
          goto _L26
_L50:
        i = i1 + 1;
        intnum1[i1] = l1;
        j = intnum3.words[i];
        k1 = intnum4.words[i];
        i1 = i;
_L55:
        l1 = ~(j & k1);
        if (i1 + 1 < k) goto _L50; else goto _L49
_L49:
        k = ((flag) ? 1 : 0);
        i = i1;
        j = l1;
        if (k1 < 0)
        {
            k = 2;
            i = i1;
            j = l1;
        }
          goto _L26
_L20:
        if (i == 0 && intnum1 == null)
        {
            intnum.ival = j;
            return;
        }
        int l = i + 1;
        intnum1[i] = j;
        i = l;
          goto _L19
_L21:
        intnum1[i] = j;
_L52:
        j = i + 1;
        i = j;
        if (j >= j1) goto _L19; else goto _L51
_L51:
        intnum1[j] = intnum3.words[j];
        i = j;
          goto _L52
_L22:
        intnum1[i] = j;
_L54:
        j = i + 1;
        i = j;
        if (j >= j1) goto _L19; else goto _L53
_L53:
        intnum1[j] = ~intnum3.words[j];
        i = j;
          goto _L54
          goto _L19
_L18:
        i1 = 0;
        k1 = i;
          goto _L55
_L17:
        i1 = 0;
        k1 = i;
          goto _L56
_L15:
        i1 = 0;
        k1 = i;
          goto _L57
_L14:
        j = 0;
          goto _L58
_L13:
        i1 = 0;
          goto _L59
_L12:
        i1 = 0;
        k1 = i;
          goto _L60
_L11:
        i1 = 0;
        k1 = i;
          goto _L61
_L10:
        i1 = 0;
          goto _L62
_L9:
        j = 0;
          goto _L63
_L8:
        i1 = 0;
        k1 = i;
          goto _L64
_L6:
        i1 = 0;
        k1 = i;
          goto _L65
_L5:
        i1 = 0;
        k1 = i;
          goto _L66
    }

    public static IntNum setBitValue(IntNum intnum, int i, int j)
    {
        byte byte0;
        int k;
        int l;
        byte0 = 31;
        k = j & 1;
        l = intnum.ival;
        if (intnum.words != null) goto _L2; else goto _L1
_L1:
        j = byte0;
        if (i < 31)
        {
            j = i;
        }
        if ((l >> j & 1) != k) goto _L4; else goto _L3
_L3:
        return intnum;
_L4:
        if (i < 63)
        {
            return IntNum.make((long)l ^ (long)(1 << i));
        }
        break; /* Loop/switch isn't completed */
_L2:
        j = i >> 5;
        if (j >= l)
        {
            if (intnum.words[l - 1] < 0)
            {
                j = 1;
            } else
            {
                j = 0;
            }
        } else
        {
            j = intnum.words[j] >> i & 1;
        }
        if (j == k) goto _L3; else goto _L5
_L5:
        intnum = dataBufferFor(intnum, i);
        j = i >> 5;
        intnum[j] = 1 << (i & 0x1f) ^ intnum[j];
        return IntNum.make(intnum, intnum.length);
    }

    public static int swappedOp(int i)
    {
        return "\000\001\004\005\002\003\006\007\b\t\f\r\n\013\016\017".charAt(i);
    }

    public static boolean test(IntNum intnum, int i)
    {
        boolean flag = false;
        if (intnum.words == null)
        {
            return (intnum.ival & i) != 0;
        }
        if (i < 0 || (intnum.words[0] & i) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean test(IntNum intnum, IntNum intnum1)
    {
        if (intnum1.words == null)
        {
            return test(intnum, intnum1.ival);
        }
        if (intnum.words == null)
        {
            return test(intnum1, intnum.ival);
        }
        IntNum intnum3 = intnum;
        IntNum intnum2 = intnum1;
        if (intnum.ival < intnum1.ival)
        {
            intnum2 = intnum;
            intnum3 = intnum1;
        }
        for (int i = 0; i < intnum2.ival; i++)
        {
            if ((intnum3.words[i] & intnum2.words[i]) != 0)
            {
                return true;
            }
        }

        return intnum2.isNegative();
    }

    public static IntNum xor(IntNum intnum, IntNum intnum1)
    {
        return bitOp(6, intnum, intnum1);
    }

}
