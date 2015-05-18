// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;


class MPN
{

    MPN()
    {
    }

    public static int add_1(int ai[], int ai1[], int i, int j)
    {
        long l = (long)j & 0xffffffffL;
        for (j = 0; j < i; j++)
        {
            l += (long)ai1[j] & 0xffffffffL;
            ai[j] = (int)l;
            l >>= 32;
        }

        return (int)l;
    }

    public static int add_n(int ai[], int ai1[], int ai2[], int i)
    {
        long l = 0L;
        for (int j = 0; j < i; j++)
        {
            l += ((long)ai1[j] & 0xffffffffL) + ((long)ai2[j] & 0xffffffffL);
            ai[j] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static int chars_per_word(int i)
    {
        byte byte0;
        byte0 = 16;
        if (i >= 10)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        if (i >= 8)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        if (i > 2) goto _L2; else goto _L1
_L1:
        byte0 = 32;
_L4:
        return byte0;
_L2:
        if (i == 3)
        {
            return 20;
        }
        if (i == 4) goto _L4; else goto _L3
_L3:
        return 18 - i;
        return 10;
        if (i < 12)
        {
            return 9;
        }
        if (i <= 16)
        {
            return 8;
        }
        if (i <= 23)
        {
            return 7;
        }
        if (i <= 40)
        {
            return 6;
        }
        return i > 256 ? 1 : 4;
    }

    public static int cmp(int ai[], int i, int ai1[], int j)
    {
        if (i > j)
        {
            return 1;
        }
        if (i < j)
        {
            return -1;
        } else
        {
            return cmp(ai, ai1, i);
        }
    }

    public static int cmp(int ai[], int ai1[], int i)
    {
        do
        {
            i--;
            if (i >= 0)
            {
                int j = ai[i];
                int k = ai1[i];
                if (j != k)
                {
                    return (j ^ 0x80000000) <= (0x80000000 ^ k) ? -1 : 1;
                }
            } else
            {
                return 0;
            }
        } while (true);
    }

    public static int count_leading_zeros(int i)
    {
        if (i != 0) goto _L2; else goto _L1
_L1:
        int l = 32;
_L4:
        return l;
_L2:
        l = 0;
        int j = 16;
        int k = i;
        i = l;
        do
        {
            l = i;
            if (j <= 0)
            {
                continue;
            }
            l = k >>> j;
            if (l == 0)
            {
                i += j;
            } else
            {
                k = l;
            }
            j >>= 1;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void divide(int ai[], int i, int ai1[], int j)
    {
        int k = i;
        do
        {
            int l;
            if (ai[k] == ai1[j - 1])
            {
                i = -1;
            } else
            {
                i = (int)udiv_qrnnd(((long)ai[k] << 32) + ((long)ai[k - 1] & 0xffffffffL), ai1[j - 1]);
            }
            l = i;
            if (i != 0)
            {
                l = submul_1(ai, k - j, ai1, j, i);
                long l1 = ((long)ai[k] & 0xffffffffL) - ((long)l & 0xffffffffL);
                do
                {
                    l = i;
                    if (l1 == 0L)
                    {
                        break;
                    }
                    l = i - 1;
                    l1 = 0L;
                    for (i = 0; i < j; i++)
                    {
                        l1 += ((long)ai[(k - j) + i] & 0xffffffffL) + ((long)ai1[i] & 0xffffffffL);
                        ai[(k - j) + i] = (int)l1;
                        l1 >>>= 32;
                    }

                    ai[k] = (int)((long)ai[k] + l1);
                    l1--;
                    i = l;
                } while (true);
            }
            ai[k] = l;
            i = k - 1;
            k = i;
        } while (i >= j);
    }

    public static int divmod_1(int ai[], int ai1[], int i, int j)
    {
        i--;
        long l = ai1[i];
        if ((l & 0xffffffffL) >= ((long)j & 0xffffffffL))
        {
            l = 0L;
        } else
        {
            ai[i] = 0;
            l <<= 32;
            i--;
        }
        for (; i >= 0; i--)
        {
            l = udiv_qrnnd(0xffffffff00000000L & l | (long)ai1[i] & 0xffffffffL, j);
            ai[i] = (int)l;
        }

        return (int)(l >> 32);
    }

    static int findLowestBit(int i)
    {
        int k = 0;
        int j = i;
        for (i = k; (j & 0xf) == 0; i += 4)
        {
            j >>= 4;
        }

        k = i;
        int l = j;
        if ((j & 3) == 0)
        {
            l = j >> 2;
            k = i + 2;
        }
        i = k;
        if ((l & 1) == 0)
        {
            i = k + 1;
        }
        return i;
    }

    static int findLowestBit(int ai[])
    {
        int i = 0;
        do
        {
            if (ai[i] != 0)
            {
                return i * 32 + findLowestBit(ai[i]);
            }
            i++;
        } while (true);
    }

    public static int gcd(int ai[], int ai1[], int i)
    {
        int j = 0;
_L13:
        int k = ai[j] | ai1[j];
        if (k == 0) goto _L2; else goto _L1
_L1:
        int ai2[];
        int l;
        int j1;
        j1 = findLowestBit(k);
        i -= j;
        rshift0(ai, ai, j, i, j1);
        rshift0(ai1, ai1, j, i, j1);
        if ((ai[0] & 1) != 0)
        {
            int ai3[] = ai;
            ai2 = ai1;
            ai1 = ai3;
        } else
        {
            ai2 = ai;
        }
_L8:
        for (l = 0; ai2[l] == 0; l++) { }
        if (l > 0)
        {
            k = 0;
            int i1;
            do
            {
                i1 = k;
                if (k >= i - l)
                {
                    break;
                }
                ai2[k] = ai2[k + l];
                k++;
            } while (true);
            for (; i1 < i; i1++)
            {
                ai2[i1] = 0;
            }

        }
        k = findLowestBit(ai2[0]);
        if (k > 0)
        {
            rshift(ai2, ai2, 0, i, k);
        }
        k = cmp(ai1, ai2, i);
          goto _L3
_L2:
        j++;
        continue; /* Loop/switch isn't completed */
_L3:
        if (k != 0) goto _L5; else goto _L4
_L4:
        k = i;
        if (j + j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_395;
        }
        if (j1 <= 0) goto _L7; else goto _L6
_L6:
        l = lshift(ai, j, ai, i, j1);
        k = i;
        if (l != 0)
        {
            ai[i + j] = l;
            k = i + 1;
        }
_L10:
        i = j;
        do
        {
            i--;
            if (i < 0)
            {
                break;
            }
            ai[i] = 0;
        } while (true);
        break MISSING_BLOCK_LABEL_388;
_L5:
        int ai4[];
        int ai5[];
        if (k > 0)
        {
            sub_n(ai1, ai1, ai2, i);
            k = i;
            ai4 = ai1;
            ai5 = ai2;
        } else
        {
            sub_n(ai2, ai2, ai1, i);
            ai5 = ai1;
            ai4 = ai2;
            k = i;
        }
        ai1 = ai5;
        ai2 = ai4;
        i = k;
        if (ai5[k - 1] == 0)
        {
            ai1 = ai5;
            ai2 = ai4;
            i = k;
            if (ai4[k - 1] == 0)
            {
                k--;
                break MISSING_BLOCK_LABEL_286;
            }
        }
          goto _L8
_L7:
        k = i;
_L11:
        l = k - 1;
        k = i;
        if (l < 0) goto _L10; else goto _L9
_L9:
        ai[l + j] = ai[l];
        k = l;
          goto _L11
          goto _L10
        k += j;
        return k;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public static int intLength(int i)
    {
        int j = i;
        if (i < 0)
        {
            j = ~i;
        }
        return 32 - count_leading_zeros(j);
    }

    public static int intLength(int ai[], int i)
    {
        i--;
        return intLength(ai[i]) + i * 32;
    }

    public static int lshift(int ai[], int i, int ai1[], int j, int k)
    {
        int j1 = 32 - k;
        j--;
        int l = ai1[j];
        int k1 = i + 1;
        i = l;
        do
        {
            j--;
            if (j >= 0)
            {
                int i1 = ai1[j];
                ai[k1 + j] = i << k | i1 >>> j1;
                i = i1;
            } else
            {
                ai[k1 + j] = i << k;
                return l >>> j1;
            }
        } while (true);
    }

    public static void mul(int ai[], int ai1[], int i, int ai2[], int j)
    {
        ai[i] = mul_1(ai, ai1, i, ai2[0]);
        for (int k = 1; k < j; k++)
        {
            long l2 = ai2[k];
            long l1 = 0L;
            for (int l = 0; l < i; l++)
            {
                l1 += ((long)ai1[l] & 0xffffffffL) * (l2 & 0xffffffffL) + ((long)ai[k + l] & 0xffffffffL);
                ai[k + l] = (int)l1;
                l1 >>>= 32;
            }

            ai[k + i] = (int)l1;
        }

    }

    public static int mul_1(int ai[], int ai1[], int i, int j)
    {
        long l1 = j;
        long l = 0L;
        for (j = 0; j < i; j++)
        {
            l += ((long)ai1[j] & 0xffffffffL) * (l1 & 0xffffffffL);
            ai[j] = (int)l;
            l >>>= 32;
        }

        return (int)l;
    }

    public static int rshift(int ai[], int ai1[], int i, int j, int k)
    {
        int l1 = 32 - k;
        int j1 = ai1[i];
        int i1 = 1;
        int l = j1;
        for (; i1 < j; i1++)
        {
            int k1 = ai1[i + i1];
            ai[i1 - 1] = l >>> k | k1 << l1;
            l = k1;
        }

        ai[i1 - 1] = l >>> k;
        return j1 << l1;
    }

    public static void rshift0(int ai[], int ai1[], int i, int j, int k)
    {
        if (k > 0)
        {
            rshift(ai, ai1, i, j, k);
        } else
        {
            k = 0;
            while (k < j) 
            {
                ai[k] = ai1[k + i];
                k++;
            }
        }
    }

    public static long rshift_long(int ai[], int i, int j)
    {
        int l = j >> 5;
        int k1 = j & 0x1f;
        int k;
        int i1;
        int j1;
        int l1;
        if (ai[i - 1] < 0)
        {
            j = -1;
        } else
        {
            j = 0;
        }
        if (l >= i)
        {
            k = j;
        } else
        {
            k = ai[l];
        }
        l1 = l + 1;
        if (l1 >= i)
        {
            l = j;
        } else
        {
            l = ai[l1];
        }
        j1 = k;
        i1 = l;
        if (k1 != 0)
        {
            i1 = l1 + 1;
            if (i1 >= i)
            {
                i = j;
            } else
            {
                i = ai[i1];
            }
            j1 = k >>> k1 | l << 32 - k1;
            i1 = l >>> k1 | i << 32 - k1;
        }
        return (long)i1 << 32 | (long)j1 & 0xffffffffL;
    }

    public static int set_str(int ai[], byte abyte0[], int i, int j)
    {
        if ((j - 1 & j) != 0) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        int i1;
        boolean flag = false;
        l = 0;
        do
        {
            j >>= 1;
            if (j == 0)
            {
                break;
            }
            l++;
        } while (true);
        k = 0;
        i1 = i;
        i = 0;
        j = ((flag) ? 1 : 0);
_L5:
        i1--;
        if (i1 < 0) goto _L4; else goto _L3
_L3:
        int k1 = abyte0[i1];
        int j1 = k | k1 << j;
        j += l;
        int l1;
        if (j >= 32)
        {
            k = i + 1;
            ai[i] = j1;
            j -= 32;
            i = k1 >> l - j;
        } else
        {
            k = i;
            i = j1;
        }
        j1 = k;
        k = i;
        i = j1;
        if (true) goto _L5; else goto _L4
_L4:
        i1 = i;
        if (k != 0)
        {
            ai[i] = k;
            return i + 1;
        }
          goto _L6
_L2:
        l1 = chars_per_word(j);
        l = 0;
        k = 0;
        do
        {
            i1 = k;
            if (l >= i)
            {
                break;
            }
            j1 = i - l;
            i1 = j1;
            if (j1 > l1)
            {
                i1 = l1;
            }
            j1 = abyte0[l];
            k1 = j;
            l++;
            do
            {
                i1--;
                if (i1 <= 0)
                {
                    break;
                }
                j1 = j1 * j + abyte0[l];
                k1 *= j;
                l++;
            } while (true);
            if (k == 0)
            {
                i1 = j1;
            } else
            {
                i1 = mul_1(ai, ai, k, k1) + add_1(ai, ai, k, j1);
            }
            if (i1 != 0)
            {
                j1 = k + 1;
                ai[k] = i1;
                k = j1;
            }
        } while (true);
_L6:
        return i1;
    }

    public static int sub_n(int ai[], int ai1[], int ai2[], int i)
    {
        int k = 0;
        int j = 0;
        while (j < i) 
        {
            int i1 = ai2[j];
            int l = ai1[j];
            i1 += k;
            if ((i1 ^ 0x80000000) < (k ^ 0x80000000))
            {
                k = 1;
            } else
            {
                k = 0;
            }
            i1 = l - i1;
            if ((i1 ^ 0x80000000) > (l ^ 0x80000000))
            {
                l = 1;
            } else
            {
                l = 0;
            }
            k += l;
            ai[j] = i1;
            j++;
        }
        return k;
    }

    public static int submul_1(int ai[], int i, int ai1[], int j, int k)
    {
        long l1 = k;
        int i1 = 0;
        int l = 0;
        do
        {
            long l2 = ((long)ai1[l] & 0xffffffffL) * (l1 & 0xffffffffL);
            k = (int)l2;
            int k1 = (int)(l2 >> 32);
            int j1 = k + i1;
            if ((0x80000000 ^ j1) < (0x80000000 ^ i1))
            {
                k = 1;
            } else
            {
                k = 0;
            }
            i1 = k + k1;
            k1 = ai[i + l];
            j1 = k1 - j1;
            k = i1;
            if ((0x80000000 ^ j1) > (0x80000000 ^ k1))
            {
                k = i1 + 1;
            }
            ai[i + l] = j1;
            j1 = l + 1;
            i1 = k;
            l = j1;
        } while (j1 < j);
        return k;
    }

    public static long udiv_qrnnd(long l, int i)
    {
        long l2;
        long l3;
        l2 = l >>> 32;
        l3 = l & 0xffffffffL;
        if (i < 0) goto _L2; else goto _L1
_L1:
        long l1;
        if (l2 < ((long)i - l2 - (l3 >>> 31) & 0xffffffffL))
        {
            l1 = l / (long)i;
            l %= i;
        } else
        {
            l -= (long)i << 31;
            l1 = l / (long)i;
            l %= i;
            l1 -= 0x80000000L;
        }
_L4:
        return l << 32 | 0xffffffffL & l1;
_L2:
        l1 = i >>> 1;
        l >>>= 1;
        if (l2 < l1 || l2 >> 1 < l1)
        {
            if (l2 < l1)
            {
                l2 = l / l1;
                l %= l1;
            } else
            {
                l = ~(l - (l1 << 32));
                l2 = (-1L ^ l / l1) & 0xffffffffL;
                l = l1 - 1L - l % l1;
            }
            l3 = 2L * l + (1L & l3);
            l1 = l2;
            l = l3;
            if ((i & 1) != 0)
            {
                if (l3 >= l2)
                {
                    l = l3 - l2;
                    l1 = l2;
                } else
                if (l2 - l3 <= ((long)i & 0xffffffffL))
                {
                    l = (l3 - l2) + (long)i;
                    l1 = l2 - 1L;
                } else
                {
                    l = (l3 - l2) + (long)i + (long)i;
                    l1 = l2 - 2L;
                }
            }
        } else
        if (l3 >= ((long)(-i) & 0xffffffffL))
        {
            l1 = -1L;
            l = l3 + (long)i;
        } else
        {
            l1 = -2L;
            l = (long)i + l3 + (long)i;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
