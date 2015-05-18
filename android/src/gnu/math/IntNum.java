// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;

// Referenced classes of package gnu.math:
//            RatNum, MPN, Numeric, RealNum

public class IntNum extends RatNum
    implements Externalizable
{

    static final int maxFixNum = 1024;
    static final int minFixNum = -100;
    static final int numFixNum = 1125;
    static final IntNum smallFixNums[];
    public int ival;
    public int words[];

    public IntNum()
    {
    }

    public IntNum(int i)
    {
        ival = i;
    }

    public static IntNum abs(IntNum intnum)
    {
        IntNum intnum1 = intnum;
        if (intnum.isNegative())
        {
            intnum1 = neg(intnum);
        }
        return intnum1;
    }

    public static final IntNum add(int i, int j)
    {
        return make((long)i + (long)j);
    }

    public static IntNum add(IntNum intnum, int i)
    {
        if (intnum.words == null)
        {
            return add(intnum.ival, i);
        } else
        {
            IntNum intnum1 = new IntNum(0);
            intnum1.setAdd(intnum, i);
            return intnum1.canonicalize();
        }
    }

    public static IntNum add(IntNum intnum, IntNum intnum1)
    {
        return add(intnum, intnum1, 1);
    }

    public static IntNum add(IntNum intnum, IntNum intnum1, int i)
    {
        if (intnum.words == null && intnum1.words == null)
        {
            return make((long)i * (long)intnum1.ival + (long)intnum.ival);
        }
        IntNum intnum2 = intnum1;
        if (i != 1)
        {
            if (i == -1)
            {
                intnum2 = neg(intnum1);
            } else
            {
                intnum2 = times(intnum1, make(i));
            }
        }
        if (intnum.words == null)
        {
            return add(intnum2, intnum.ival);
        }
        if (intnum2.words == null)
        {
            return add(intnum, intnum2.ival);
        }
        IntNum intnum3 = intnum;
        intnum1 = intnum2;
        if (intnum2.ival > intnum.ival)
        {
            intnum1 = intnum;
            intnum3 = intnum2;
        }
        intnum = alloc(intnum3.ival + 1);
        i = intnum1.ival;
        long l1 = MPN.add_n(intnum.words, intnum3.words, intnum1.words, i);
        long l;
        if (intnum1.words[i - 1] < 0)
        {
            l = 0xffffffffL;
        } else
        {
            l = 0L;
        }
        for (; i < intnum3.ival; i++)
        {
            l1 += ((long)intnum3.words[i] & 0xffffffffL) + l;
            intnum.words[i] = (int)l1;
            l1 >>>= 32;
        }

        long l2 = l;
        if (intnum3.words[i - 1] < 0)
        {
            l2 = l - 1L;
        }
        intnum.words[i] = (int)(l1 + l2);
        intnum.ival = i + 1;
        return intnum.canonicalize();
    }

    public static IntNum alloc(int i)
    {
        if (i <= 1)
        {
            return new IntNum();
        } else
        {
            IntNum intnum = new IntNum();
            intnum.words = new int[i];
            return intnum;
        }
    }

    public static IntNum asIntNumOrNull(Object obj)
    {
        if (obj instanceof IntNum)
        {
            return (IntNum)obj;
        }
        if (obj instanceof BigInteger)
        {
            return valueOf(obj.toString(), 10);
        }
        if ((obj instanceof Number) && ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof Byte)))
        {
            return make(((Number)obj).longValue());
        } else
        {
            return null;
        }
    }

    public static int compare(IntNum intnum, long l)
    {
        if (intnum.words != null) goto _L2; else goto _L1
_L1:
        long l1 = intnum.ival;
_L8:
        if (l1 >= l) goto _L4; else goto _L3
_L3:
        return -1;
_L2:
        boolean flag1;
        flag1 = intnum.isNegative();
        boolean flag;
        if (l < 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag1 != flag)
        {
            if (!flag1)
            {
                return 1;
            }
        } else
        {
            int i;
            if (intnum.words == null)
            {
                i = 1;
            } else
            {
                i = intnum.ival;
            }
            if (i == 1)
            {
                l1 = intnum.words[0];
            } else
            {
                if (i != 2)
                {
                    continue; /* Loop/switch isn't completed */
                }
                l1 = intnum.longValue();
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L3; else goto _L5
_L5:
        if (flag1) goto _L3; else goto _L6
_L6:
        return 1;
_L4:
        if (l1 > l)
        {
            return 1;
        }
        return 0;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static int compare(IntNum intnum, IntNum intnum1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = true;
        if (intnum.words != null || intnum1.words != null) goto _L2; else goto _L1
_L1:
        if (intnum.ival >= intnum1.ival) goto _L4; else goto _L3
_L3:
        return -1;
_L4:
        return intnum.ival <= intnum1.ival ? 0 : 1;
_L2:
        boolean flag2 = intnum.isNegative();
        if (flag2 != intnum1.isNegative())
        {
            if (!flag2)
            {
                return 1;
            }
        } else
        {
            int i;
            int j;
            if (intnum.words == null)
            {
                i = 1;
            } else
            {
                i = intnum.ival;
            }
            if (intnum1.words == null)
            {
                j = 1;
            } else
            {
                j = intnum1.ival;
            }
            if (i != j)
            {
                if (i > j)
                {
                    flag1 = true;
                }
                if (flag1 != flag2)
                {
                    i = ((flag) ? 1 : 0);
                } else
                {
                    i = -1;
                }
                return i;
            } else
            {
                return MPN.cmp(intnum.words, intnum1.words, i);
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static void divide(long l, long l1, IntNum intnum, IntNum intnum1, int i)
    {
        int j;
        j = i;
        if (i == 5)
        {
            if (l1 < 0L)
            {
                j = 2;
            } else
            {
                j = 1;
            }
        }
        if (l >= 0L) goto _L2; else goto _L1
_L1:
        i = 1;
        if (l != 0x8000000000000000L) goto _L4; else goto _L3
_L3:
        divide(make(l), make(l1), intnum, intnum1, j);
_L12:
        return;
_L4:
        l = -l;
_L13:
        if (l1 >= 0L) goto _L6; else goto _L5
_L5:
        boolean flag = true;
        if (l1 != 0x8000000000000000L) goto _L8; else goto _L7
_L7:
        if (j != 3) goto _L10; else goto _L9
_L9:
        if (intnum != null)
        {
            intnum.set(0);
        }
        if (intnum1 == null) goto _L12; else goto _L11
_L11:
        intnum1.set(l);
        return;
_L2:
        i = 0;
          goto _L13
_L10:
        divide(make(l), make(l1), intnum, intnum1, j);
        return;
_L8:
        l1 = -l1;
_L20:
        boolean flag1;
        int k;
        long l2;
        long l3;
        l2 = l / l1;
        l3 = l % l1;
        k = i ^ flag;
        flag1 = false;
        flag = flag1;
        if (l3 == 0L) goto _L15; else goto _L14
_L14:
        flag = flag1;
        j;
        JVM INSTR tableswitch 1 4: default 204
    //                   1 298
    //                   2 298
    //                   3 208
    //                   4 330;
           goto _L16 _L17 _L17 _L18 _L19
_L19:
        break MISSING_BLOCK_LABEL_330;
_L18:
        break; /* Loop/switch isn't completed */
_L16:
        flag = flag1;
_L15:
        if (intnum != null)
        {
            l = l2;
            if (flag)
            {
                l = l2 + 1L;
            }
            l2 = l;
            if (k != 0)
            {
                l2 = -l;
            }
            intnum.set(l2);
        }
        if (intnum1 != null)
        {
            l = l3;
            j = i;
            if (flag)
            {
                l = l1 - l3;
                if (i == 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
            }
            l1 = l;
            if (j != 0)
            {
                l1 = -l;
            }
            intnum1.set(l1);
            return;
        }
          goto _L12
_L6:
        flag = false;
          goto _L20
_L17:
        if (j == 1)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        flag = flag1;
        if (k == j)
        {
            flag = true;
        }
          goto _L15
        if (l3 > l1 - (1L & l2) >> 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L15
    }

    public static void divide(IntNum intnum, IntNum intnum1, IntNum intnum2, IntNum intnum3, int i)
    {
        if (intnum.words != null && intnum.ival > 2 || intnum1.words != null && intnum1.ival > 2) goto _L2; else goto _L1
_L1:
        long l2;
        long l3;
        l2 = intnum.longValue();
        l3 = intnum1.longValue();
        if (l2 == 0x8000000000000000L || l3 == 0x8000000000000000L) goto _L2; else goto _L3
_L3:
        divide(l2, l3, intnum2, intnum3, i);
_L16:
        return;
_L2:
        int ai1[];
        int ai2[];
        int j;
        int k;
        int l;
        int l1;
        boolean flag;
        boolean flag1;
        flag = intnum.isNegative();
        flag1 = intnum1.isNegative();
        l1 = flag ^ flag1;
        if (intnum1.words == null)
        {
            l = 1;
        } else
        {
            l = intnum1.ival;
        }
        ai2 = new int[l];
        intnum1.getAbsolute(ai2);
        for (; l > 1 && ai2[l - 1] == 0; l--) { }
        if (intnum.words == null)
        {
            j = 1;
        } else
        {
            j = intnum.ival;
        }
        ai1 = new int[j + 2];
        intnum.getAbsolute(ai1);
        for (; j > 1 && ai1[j - 1] == 0; j--) { }
        k = MPN.cmp(ai1, j, ai2, l);
        if (k >= 0) goto _L5; else goto _L4
_L4:
        int ai[];
        ai = ai2;
        intnum = ai1;
        k = 1;
_L7:
        for (ai[0] = 0; j > 1 && intnum[j - 1] == 0; j--) { }
        break; /* Loop/switch isn't completed */
_L5:
        if (k == 0)
        {
            ai1[0] = 1;
            k = 1;
            ai2[0] = 0;
            j = 1;
            ai = ai1;
            intnum = ai2;
            continue; /* Loop/switch isn't completed */
        }
        if (l != 1)
        {
            break; /* Loop/switch isn't completed */
        }
        k = j;
        l = 1;
        ai2[0] = MPN.divmod_1(ai1, ai1, j, ai2[0]);
        j = l;
        ai = ai1;
        intnum = ai2;
        if (true) goto _L7; else goto _L6
_L6:
        int j1 = MPN.count_leading_zeros(ai2[l - 1]);
        k = j;
        if (j1 != 0)
        {
            MPN.lshift(ai2, 0, ai2, l, j1);
            ai1[j] = MPN.lshift(ai1, 0, ai1, j, j1);
            k = j + 1;
        }
        IntNum intnum4;
        int i1;
        int k1;
        if (k == l)
        {
            j = k + 1;
            ai1[k] = 0;
        } else
        {
            j = k;
        }
        MPN.divide(ai1, j, ai2, l);
        i1 = l;
        MPN.rshift0(ai2, ai1, 0, i1, j1);
        k1 = (j + 1) - l;
        k = k1;
        j = i1;
        ai = ai1;
        intnum = ai2;
        if (intnum2 != null)
        {
            j1 = 0;
            do
            {
                k = k1;
                j = i1;
                ai = ai1;
                intnum = ai2;
                if (j1 >= k1)
                {
                    break;
                }
                ai1[j1] = ai1[j1 + l];
                j1++;
            } while (true);
        }
        if (true) goto _L7; else goto _L8
_L8:
        i1 = j;
        if (intnum[j - 1] < 0)
        {
            intnum[j] = 0;
            i1 = j + 1;
        }
        j1 = 0;
        if (i1 > 1) goto _L10; else goto _L9
_L9:
        j = j1;
        if (intnum[0] == 0) goto _L11; else goto _L10
_L10:
        l = i;
        if (i == 5)
        {
            if (flag1)
            {
                l = 2;
            } else
            {
                l = 1;
            }
        }
        j = j1;
        l;
        JVM INSTR tableswitch 1 4: default 612
    //                   1 731
    //                   2 731
    //                   3 616
    //                   4 763;
           goto _L12 _L13 _L13 _L14 _L15
_L14:
        break; /* Loop/switch isn't completed */
_L12:
        j = j1;
_L11:
        if (intnum2 != null)
        {
            i = k;
            if (ai[k - 1] < 0)
            {
                ai[k] = 0;
                i = k + 1;
            }
            intnum2.set(ai, i);
            if (l1 != 0)
            {
                if (j != 0)
                {
                    intnum2.setInvert();
                } else
                {
                    intnum2.setNegative();
                }
            } else
            if (j != 0)
            {
                intnum2.setAdd(1);
            }
        }
        if (intnum3 != null)
        {
            intnum3.set(intnum, i1);
            if (j != 0)
            {
                if (intnum1.words == null)
                {
                    intnum2 = intnum3;
                    if (flag1)
                    {
                        i = intnum[0] + intnum1.ival;
                    } else
                    {
                        i = intnum[0] - intnum1.ival;
                    }
                    intnum2.set(i);
                } else
                {
                    if (flag1)
                    {
                        i = 1;
                    } else
                    {
                        i = -1;
                    }
                    intnum2 = add(intnum3, intnum1, i);
                }
                if (flag)
                {
                    intnum3.setNegative(intnum2);
                    return;
                } else
                {
                    intnum3.set(intnum2);
                    return;
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L16; else goto _L13
_L13:
        if (l == 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = j1;
        if (l1 == i)
        {
            j = 1;
        }
          goto _L11
_L15:
        if (intnum3 == null)
        {
            intnum4 = new IntNum();
        } else
        {
            intnum4 = intnum3;
        }
        intnum4.set(intnum, i1);
        intnum4 = shift(intnum4, 1);
        if (flag1)
        {
            intnum4.setNegative();
        }
        j = compare(intnum4, intnum1);
        i = j;
        if (flag1)
        {
            i = -j;
        }
        if (i == 1 || i == 0 && (ai[0] & 1) != 0)
        {
            j = 1;
        } else
        {
            j = 0;
        }
          goto _L11
        if (!flag) goto _L16; else goto _L17
_L17:
        intnum3.setNegative();
        return;
    }

    public static boolean equals(IntNum intnum, IntNum intnum1)
    {
        if (intnum.words != null || intnum1.words != null) goto _L2; else goto _L1
_L1:
        if (intnum.ival != intnum1.ival) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (intnum.words == null || intnum1.words == null || intnum.ival != intnum1.ival)
        {
            return false;
        }
        int i = intnum.ival;
        do
        {
            int j = i - 1;
            if (j < 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            i = j;
            if (intnum.words[j] != intnum1.words[j])
            {
                return false;
            }
        } while (true);
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static final int gcd(int i, int j)
    {
        int l = i;
        int k = j;
        if (j > i)
        {
            k = i;
            l = j;
        }
        do
        {
            if (k == 0)
            {
                return l;
            }
            if (k == 1)
            {
                return k;
            }
            i = l % k;
            l = k;
            k = i;
        } while (true);
    }

    public static IntNum gcd(IntNum intnum, IntNum intnum1)
    {
        int j = intnum.ival;
        int k = intnum1.ival;
        int i = j;
        if (intnum.words == null)
        {
            if (j == 0)
            {
                return abs(intnum1);
            }
            if (intnum1.words == null && j != 0x80000000 && k != 0x80000000)
            {
                i = j;
                if (j < 0)
                {
                    i = -j;
                }
                j = k;
                if (k < 0)
                {
                    j = -k;
                }
                return make(gcd(i, j));
            }
            i = 1;
        }
        j = k;
        if (intnum1.words == null)
        {
            if (k == 0)
            {
                return abs(intnum);
            }
            j = 1;
        }
        int ai[];
        int ai1[];
        if (i <= j)
        {
            i = j;
        }
        ai = new int[i];
        ai1 = new int[i];
        intnum.getAbsolute(ai);
        intnum1.getAbsolute(ai1);
        j = MPN.gcd(ai, ai1, i);
        intnum = new IntNum(0);
        i = j;
        if (ai[j - 1] < 0)
        {
            ai[j] = 0;
            i = j + 1;
        }
        intnum.ival = i;
        intnum.words = ai;
        return intnum.canonicalize();
    }

    public static int intValue(Object obj)
    {
        obj = (IntNum)obj;
        if (((IntNum) (obj)).words != null)
        {
            throw new ClassCastException("integer too large");
        } else
        {
            return ((IntNum) (obj)).ival;
        }
    }

    public static IntNum lcm(IntNum intnum, IntNum intnum1)
    {
        if (intnum.isZero() || intnum1.isZero())
        {
            return zero();
        } else
        {
            intnum = abs(intnum);
            intnum1 = abs(intnum1);
            IntNum intnum2 = new IntNum();
            divide(times(intnum, intnum1), gcd(intnum, intnum1), intnum2, null, 3);
            return intnum2.canonicalize();
        }
    }

    public static IntNum make(int i)
    {
        if (i >= -100 && i <= 1024)
        {
            return smallFixNums[i + 100];
        } else
        {
            return new IntNum(i);
        }
    }

    public static IntNum make(long l)
    {
        if (l >= -100L && l <= 1024L)
        {
            return smallFixNums[(int)l + 100];
        }
        int i = (int)l;
        if ((long)i == l)
        {
            return new IntNum(i);
        } else
        {
            IntNum intnum = alloc(2);
            intnum.ival = 2;
            intnum.words[0] = i;
            intnum.words[1] = (int)(l >> 32);
            return intnum;
        }
    }

    public static IntNum make(int ai[])
    {
        return make(ai, ai.length);
    }

    public static IntNum make(int ai[], int i)
    {
        if (ai == null)
        {
            return make(i);
        }
        i = wordsNeeded(ai, i);
        if (i <= 1)
        {
            if (i == 0)
            {
                return zero();
            } else
            {
                return make(ai[0]);
            }
        } else
        {
            IntNum intnum = new IntNum();
            intnum.words = ai;
            intnum.ival = i;
            return intnum;
        }
    }

    public static IntNum makeU(long l)
    {
        if (l >= 0L)
        {
            return make(l);
        } else
        {
            IntNum intnum = alloc(3);
            intnum.ival = 3;
            intnum.words[0] = (int)l;
            intnum.words[1] = (int)(l >> 32);
            intnum.words[2] = 0;
            return intnum;
        }
    }

    public static IntNum minusOne()
    {
        return smallFixNums[99];
    }

    public static IntNum modulo(IntNum intnum, IntNum intnum1)
    {
        return remainder(intnum, intnum1, 1);
    }

    public static IntNum neg(IntNum intnum)
    {
        if (intnum.words == null && intnum.ival != 0x80000000)
        {
            return make(-intnum.ival);
        } else
        {
            IntNum intnum1 = new IntNum(0);
            intnum1.setNegative(intnum);
            return intnum1.canonicalize();
        }
    }

    public static boolean negate(int ai[], int ai1[], int i)
    {
        long l = 1L;
        boolean flag;
        int j;
        if (ai1[i - 1] < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        for (j = 0; j < i; j++)
        {
            l += (long)(~ai1[j]) & 0xffffffffL;
            ai[j] = (int)l;
            l >>= 32;
        }

        return flag && ai[i - 1] < 0;
    }

    public static final IntNum one()
    {
        return smallFixNums[101];
    }

    public static IntNum power(IntNum intnum, int i)
    {
        if (i > 0) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        IntNum intnum1 = one();
_L6:
        return intnum1;
_L4:
        throw new Error("negative exponent");
_L2:
        intnum1 = intnum;
        if (intnum.isZero()) goto _L6; else goto _L5
_L5:
        int ai[];
        int ai1[];
        int ai2[];
        int ai3[];
        boolean flag;
        int i1;
        int j1;
        int k1;
        int j;
        if (intnum.words == null)
        {
            j = 1;
        } else
        {
            j = intnum.ival;
        }
        i1 = (intnum.intLength() * i >> 5) + j * 2;
        if (intnum.isNegative() && (i & 1) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ai = new int[i1];
        ai1 = new int[i1];
        ai2 = new int[i1];
        intnum.getAbsolute(ai);
        k1 = 1;
        ai1[0] = 1;
        i1 = i;
        intnum = ai2;
        j1 = j;
_L8:
        i = k1;
        ai3 = ai1;
        ai2 = intnum;
        if ((i1 & 1) != 0)
        {
            MPN.mul(intnum, ai, j1, ai1, k1);
            j = k1 + j1;
            do
            {
                i = j;
                ai3 = intnum;
                ai2 = ai1;
                if (intnum[j - 1] != 0)
                {
                    break;
                }
                j--;
            } while (true);
        }
        int l1 = i1 >> 1;
        if (l1 == 0)
        {
            int k = i;
            if (ai3[i - 1] < 0)
            {
                k = i + 1;
            }
            if (flag)
            {
                negate(ai3, ai3, k);
            }
            return make(ai3, k);
        }
        MPN.mul(ai2, ai, j1, ai, j1);
        int ai4[] = ai;
        int l = j1 * 2;
        do
        {
            j1 = l;
            ai = ai2;
            k1 = i;
            ai1 = ai3;
            intnum = ai4;
            i1 = l1;
            if (ai2[l - 1] != 0)
            {
                continue;
            }
            l--;
        } while (true);
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static IntNum quotient(IntNum intnum, IntNum intnum1)
    {
        return quotient(intnum, intnum1, 3);
    }

    public static IntNum quotient(IntNum intnum, IntNum intnum1, int i)
    {
        IntNum intnum2 = new IntNum();
        divide(intnum, intnum1, intnum2, null, i);
        return intnum2.canonicalize();
    }

    public static IntNum remainder(IntNum intnum, IntNum intnum1)
    {
        return remainder(intnum, intnum1, 3);
    }

    public static IntNum remainder(IntNum intnum, IntNum intnum1, int i)
    {
        if (intnum1.isZero())
        {
            return intnum;
        } else
        {
            IntNum intnum2 = new IntNum();
            divide(intnum, intnum1, null, intnum2, i);
            return intnum2.canonicalize();
        }
    }

    public static int shift(int i, int j)
    {
        if (j < 32)
        {
            if (j >= 0)
            {
                return i << j;
            }
            j = -j;
            if (j >= 32)
            {
                if (i < 0)
                {
                    return -1;
                }
            } else
            {
                return i >> j;
            }
        }
        return 0;
    }

    public static long shift(long l, int i)
    {
        if (i < 32)
        {
            if (i >= 0)
            {
                return l << i;
            }
            i = -i;
            if (i >= 32)
            {
                if (l < 0L)
                {
                    return -1L;
                }
            } else
            {
                return l >> i;
            }
        }
        return 0L;
    }

    public static IntNum shift(IntNum intnum, int i)
    {
        boolean flag = false;
        if (intnum.words != null) goto _L2; else goto _L1
_L1:
        if (i > 0) goto _L4; else goto _L3
_L3:
        if (i <= -32) goto _L6; else goto _L5
_L5:
        i = intnum.ival >> -i;
_L10:
        IntNum intnum1 = make(i);
_L8:
        return intnum1;
_L6:
        i = ((flag) ? 1 : 0);
        if (intnum.ival < 0)
        {
            i = -1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i < 32)
        {
            return make((long)intnum.ival << i);
        }
_L2:
        intnum1 = intnum;
        if (i == 0) goto _L8; else goto _L7
_L7:
        IntNum intnum2 = new IntNum(0);
        intnum2.setShift(intnum, i);
        return intnum2.canonicalize();
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static IntNum sub(IntNum intnum, IntNum intnum1)
    {
        return add(intnum, intnum1, -1);
    }

    public static final IntNum ten()
    {
        return smallFixNums[110];
    }

    public static final IntNum times(int i, int j)
    {
        return make((long)i * (long)j);
    }

    public static final IntNum times(IntNum intnum, int i)
    {
        IntNum intnum1;
        if (i == 0)
        {
            intnum1 = zero();
        } else
        {
            intnum1 = intnum;
            if (i != 1)
            {
                int ai[] = intnum.words;
                int k = intnum.ival;
                if (ai == null)
                {
                    return make((long)k * (long)i);
                }
                IntNum intnum2 = alloc(k + 1);
                boolean flag;
                int j;
                boolean flag1;
                if (ai[k - 1] < 0)
                {
                    flag = true;
                    negate(intnum2.words, ai, k);
                    intnum = intnum2.words;
                } else
                {
                    flag = false;
                    intnum = ai;
                }
                flag1 = flag;
                j = i;
                if (i < 0)
                {
                    if (!flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    j = -i;
                    flag1 = flag;
                }
                intnum2.words[k] = MPN.mul_1(intnum2.words, intnum, k, j);
                intnum2.ival = k + 1;
                if (flag1)
                {
                    intnum2.setNegative();
                }
                return intnum2.canonicalize();
            }
        }
        return intnum1;
    }

    public static final IntNum times(IntNum intnum, IntNum intnum1)
    {
        if (intnum1.words == null)
        {
            return times(intnum, intnum1.ival);
        }
        if (intnum.words == null)
        {
            return times(intnum1, intnum.ival);
        }
        int i = intnum.ival;
        int j = intnum1.ival;
        boolean flag;
        if (intnum.isNegative())
        {
            flag = true;
            int ai[] = new int[i];
            negate(ai, intnum.words, i);
            intnum = ai;
        } else
        {
            flag = false;
            intnum = intnum.words;
        }
        if (intnum1.isNegative())
        {
            int ai1[];
            int ai2[];
            int k;
            int l;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ai1 = new int[j];
            negate(ai1, intnum1.words, j);
            intnum1 = ai1;
        } else
        {
            intnum1 = intnum1.words;
        }
        l = i;
        ai2 = intnum;
        k = j;
        ai1 = intnum1;
        if (i < j)
        {
            ai1 = intnum;
            k = i;
            ai2 = intnum1;
            l = j;
        }
        intnum = alloc(l + k);
        MPN.mul(intnum.words, ai2, l, ai1, k);
        intnum.ival = l + k;
        if (flag)
        {
            intnum.setNegative();
        }
        return intnum.canonicalize();
    }

    public static IntNum valueOf(String s)
        throws NumberFormatException
    {
        return valueOf(s, 10);
    }

    public static IntNum valueOf(String s, int i)
        throws NumberFormatException
    {
        int i1 = s.length();
        if (i1 + i <= 28)
        {
            String s1 = s;
            if (i1 > 1)
            {
                s1 = s;
                if (s.charAt(0) == '+')
                {
                    s1 = s;
                    if (Character.digit(s.charAt(1), i) >= 0)
                    {
                        s1 = s.substring(1);
                    }
                }
            }
            return make(Long.parseLong(s1, i));
        }
        byte abyte0[] = new byte[i1];
        boolean flag = false;
        int k = 0;
        int j = 0;
        while (k < i1) 
        {
            char c = s.charAt(k);
            if (c == '-' && k == 0)
            {
                flag = true;
            } else
            if ((c != '+' || k != 0) && c != '_' && (j != 0 || c != ' ' && c != '\t'))
            {
                int j1 = Character.digit(c, i);
                if (j1 < 0)
                {
                    throw new NumberFormatException((new StringBuilder()).append("For input string: \"").append(s).append('"').toString());
                }
                int l = j + 1;
                abyte0[j] = (byte)j1;
                j = l;
            }
            k++;
        }
        return valueOf(abyte0, j, flag, i);
    }

    public static IntNum valueOf(byte abyte0[], int i, boolean flag, int j)
    {
        int ai[] = new int[i / MPN.chars_per_word(j) + 1];
        j = MPN.set_str(ai, abyte0, i, j);
        if (j == 0)
        {
            return zero();
        }
        i = j;
        if (ai[j - 1] < 0)
        {
            ai[j] = 0;
            i = j + 1;
        }
        if (flag)
        {
            negate(ai, ai, i);
        }
        return make(ai, i);
    }

    public static IntNum valueOf(char ac[], int i, int j, int k, boolean flag)
    {
        byte abyte0[];
        int l;
        int i1;
        abyte0 = new byte[j];
        i1 = 0;
        l = 0;
_L5:
        if (i1 >= j) goto _L2; else goto _L1
_L1:
        char c = ac[i + i1];
        if (c != '-') goto _L4; else goto _L3
_L3:
        flag = true;
_L6:
        i1++;
          goto _L5
_L4:
        if (c != '_' && (l != 0 || c != ' ' && c != '\t')) goto _L7; else goto _L6
_L7:
        int k1;
        k1 = Character.digit(c, k);
        if (k1 >= 0)
        {
            break MISSING_BLOCK_LABEL_97;
        }
_L2:
        return valueOf(abyte0, l, flag, k);
        int j1 = l + 1;
        abyte0[l] = (byte)k1;
        l = j1;
          goto _L6
    }

    public static int wordsNeeded(int ai[], int i)
    {
        int j;
        j = i;
        i = j;
        if (j <= 0) goto _L2; else goto _L1
_L1:
        int k;
        int l;
        i = j - 1;
        l = ai[i];
        j = i;
        k = l;
        if (l != -1) goto _L4; else goto _L3
_L3:
        j = i;
        do
        {
            i = j;
            if (j <= 0)
            {
                break;
            }
            k = ai[j - 1];
            i = j;
            if (k >= 0)
            {
                break;
            }
            i = j - 1;
            j = i;
        } while (k == -1);
_L2:
        return i + 1;
_L4:
        i = j;
        if (k != 0) goto _L2; else goto _L5
_L5:
        i = j;
        if (j <= 0) goto _L2; else goto _L6
_L6:
        k = ai[j - 1];
        i = j;
        if (k < 0) goto _L2; else goto _L7
_L7:
        j--;
          goto _L4
    }

    public static final IntNum zero()
    {
        return smallFixNums[100];
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof IntNum)
        {
            return add(this, (IntNum)obj, i);
        }
        if (!(obj instanceof Numeric))
        {
            throw new IllegalArgumentException();
        } else
        {
            return ((Numeric)obj).addReversed(this, i);
        }
    }

    public BigDecimal asBigDecimal()
    {
        if (words == null)
        {
            return new BigDecimal(ival);
        }
        if (ival <= 2)
        {
            return BigDecimal.valueOf(longValue());
        } else
        {
            return new BigDecimal(toString());
        }
    }

    public BigInteger asBigInteger()
    {
        if (words == null || ival <= 2)
        {
            return BigInteger.valueOf(longValue());
        } else
        {
            return new BigInteger(toString());
        }
    }

    public IntNum canonicalize()
    {
        if (words != null)
        {
            int i = wordsNeeded(words, ival);
            ival = i;
            if (i <= 1)
            {
                if (ival == 1)
                {
                    ival = words[0];
                }
                words = null;
            }
        }
        IntNum intnum = this;
        if (words == null)
        {
            intnum = this;
            if (ival >= -100)
            {
                intnum = this;
                if (ival <= 1024)
                {
                    intnum = smallFixNums[ival + 100];
                }
            }
        }
        return intnum;
    }

    boolean checkBits(int i)
    {
        boolean flag = true;
        if (i > 0)
        {
            if (words == null)
            {
                if (i > 31 || (ival & (1 << i) - 1) != 0)
                {
                    return true;
                }
            } else
            {
                int j;
                for (j = 0; j < i >> 5; j++)
                {
                    if (words[j] != 0)
                    {
                        return true;
                    }
                }

                if ((i & 0x1f) == 0 || (words[j] & (1 << (i & 0x1f)) - 1) == 0)
                {
                    flag = false;
                }
                return flag;
            }
        }
        return false;
    }

    public int compare(Object obj)
    {
        if (obj instanceof IntNum)
        {
            return compare(this, (IntNum)obj);
        } else
        {
            return ((RealNum)obj).compareReversed(this);
        }
    }

    public final IntNum denominator()
    {
        return one();
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof RatNum)
        {
            obj = (RatNum)obj;
            return RatNum.make(times(this, ((RatNum) (obj)).denominator()), ((RatNum) (obj)).numerator());
        }
        if (!(obj instanceof Numeric))
        {
            throw new IllegalArgumentException();
        } else
        {
            return ((Numeric)obj).divReversed(this);
        }
    }

    public double doubleValue()
    {
        if (words == null)
        {
            return (double)ival;
        }
        if (ival <= 2)
        {
            return (double)longValue();
        }
        if (isNegative())
        {
            return neg(this).roundToDouble(0, true, false);
        } else
        {
            return roundToDouble(0, false, false);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof IntNum))
        {
            return false;
        } else
        {
            return equals(this, (IntNum)obj);
        }
    }

    public void format(int i, StringBuffer stringbuffer)
    {
        if (i == 10)
        {
            if (words == null)
            {
                stringbuffer.append(ival);
                return;
            }
            if (ival <= 2)
            {
                stringbuffer.append(longValue());
                return;
            }
        }
        stringbuffer.append(toString(i));
    }

    public void format(int i, StringBuilder stringbuilder)
    {
        if (words != null) goto _L2; else goto _L1
_L1:
        if (i != 10) goto _L4; else goto _L3
_L3:
        stringbuilder.append(ival);
_L6:
        return;
_L4:
        stringbuilder.append(Integer.toString(ival, i));
        return;
_L2:
        int ai[];
        int j;
        boolean flag;
        if (ival <= 2)
        {
            long l3 = longValue();
            if (i == 10)
            {
                stringbuilder.append(l3);
                return;
            } else
            {
                stringbuilder.append(Long.toString(l3, i));
                return;
            }
        }
        flag = isNegative();
        int k;
        int i1;
        int k1;
        int j2;
        if (flag || i != 16)
        {
            ai = new int[ival];
            getAbsolute(ai);
        } else
        {
            ai = words;
        }
        j = ival;
        if (i != 16)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        if (flag)
        {
            stringbuilder.append('-');
        }
        i1 = stringbuilder.length();
        i = j;
        j = i - 1;
        if (j < 0) goto _L6; else goto _L5
_L5:
        k1 = ai[j];
        i = 8;
        do
        {
            k = i - 1;
            i = j;
            if (k < 0)
            {
                break MISSING_BLOCK_LABEL_141;
            }
            j2 = k1 >> k * 4 & 0xf;
            if (j2 <= 0)
            {
                i = k;
                if (stringbuilder.length() <= i1)
                {
                    continue;
                }
            }
            stringbuilder.append(Character.forDigit(j2, 16));
            i = k;
        } while (true);
        int l;
        int j1;
        int l2;
        l = MPN.chars_per_word(i);
        j1 = i;
        int l1 = l;
        do
        {
            l1--;
            if (l1 <= 0)
            {
                break;
            }
            j1 *= i;
        } while (true);
        l2 = stringbuilder.length();
_L8:
        int i2;
        int k2;
        int i3 = MPN.divmod_1(ai, ai, j, j1);
        for (i2 = j; i2 > 0 && ai[i2 - 1] == 0; i2--) { }
        k2 = l;
        j = i3;
_L9:
        int j3;
        j3 = k2 - 1;
        if (j3 >= 0 && (i2 != 0 || j != 0))
        {
            break MISSING_BLOCK_LABEL_414;
        }
        j = i2;
        if (i2 != 0) goto _L8; else goto _L7
_L7:
        if (flag)
        {
            stringbuilder.append('-');
        }
        i = stringbuilder.length() - 1;
        j = l2;
        while (j < i) 
        {
            char c = stringbuilder.charAt(j);
            stringbuilder.setCharAt(j, stringbuilder.charAt(i));
            stringbuilder.setCharAt(i, c);
            j++;
            i--;
        }
          goto _L6
        if (j < 0)
        {
            k2 = (int)(((long)j & -1L) % (long)i);
            j /= i;
        } else
        {
            k2 = j % i;
            j /= i;
        }
        stringbuilder.append(Character.forDigit(k2, i));
        k2 = j3;
          goto _L9
    }

    public void getAbsolute(int ai[])
    {
        if (words != null) goto _L2; else goto _L1
_L1:
        int i;
        i = 1;
        ai[0] = ival;
_L4:
        if (ai[i - 1] < 0)
        {
            negate(ai, ai, i);
        }
        int j = ai.length;
        do
        {
            j--;
            int k;
            if (j > i)
            {
                ai[j] = 0;
            } else
            {
                return;
            }
        } while (true);
_L2:
        j = ival;
        i = j;
_L5:
        k = i - 1;
        i = j;
        if (k < 0) goto _L4; else goto _L3
_L3:
        ai[k] = words[k];
        i = k;
          goto _L5
    }

    public int hashCode()
    {
        if (words == null)
        {
            return ival;
        } else
        {
            return words[0] + words[ival - 1];
        }
    }

    public boolean inIntRange()
    {
        return inRange(0xffffffff80000000L, 0x7fffffffL);
    }

    public boolean inLongRange()
    {
        return inRange(0x8000000000000000L, 0x7fffffffffffffffL);
    }

    public boolean inRange(long l, long l1)
    {
        return compare(this, l) >= 0 && compare(this, l1) <= 0;
    }

    public int intLength()
    {
        if (words == null)
        {
            return MPN.intLength(ival);
        } else
        {
            return MPN.intLength(words, ival);
        }
    }

    public int intValue()
    {
        if (words == null)
        {
            return ival;
        } else
        {
            return words[0];
        }
    }

    public final boolean isMinusOne()
    {
        return words == null && ival == -1;
    }

    public final boolean isNegative()
    {
        int i;
        if (words == null)
        {
            i = ival;
        } else
        {
            i = words[ival - 1];
        }
        return i < 0;
    }

    public final boolean isOdd()
    {
        boolean flag = false;
        int i;
        if (words == null)
        {
            i = ival;
        } else
        {
            i = words[0];
        }
        if ((i & 1) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public final boolean isOne()
    {
        return words == null && ival == 1;
    }

    public final boolean isZero()
    {
        return words == null && ival == 0;
    }

    public long longValue()
    {
        if (words == null)
        {
            return (long)ival;
        }
        if (ival == 1)
        {
            return (long)words[0];
        } else
        {
            return ((long)words[1] << 32) + ((long)words[0] & 0xffffffffL);
        }
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof IntNum)
        {
            return times(this, (IntNum)obj);
        }
        if (!(obj instanceof Numeric))
        {
            throw new IllegalArgumentException();
        } else
        {
            return ((Numeric)obj).mulReversed(this);
        }
    }

    public Numeric neg()
    {
        return neg(this);
    }

    public final IntNum numerator()
    {
        return this;
    }

    public Numeric power(IntNum intnum)
    {
        if (!isOne()) goto _L2; else goto _L1
_L1:
        return this;
_L2:
        if (!isMinusOne())
        {
            break; /* Loop/switch isn't completed */
        }
        if (!intnum.isOdd())
        {
            return one();
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (intnum.words == null && intnum.ival >= 0)
        {
            return power(this, intnum.ival);
        }
        if (isZero())
        {
            if (intnum.isNegative())
            {
                return RatNum.infinity(-1);
            }
        } else
        {
            return super.power(intnum);
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        int j = objectinput.readInt();
        int i = j;
        if (j <= 0xc0000000)
        {
            i = j & 0x7fffffff;
            if (i == 1)
            {
                i = objectinput.readInt();
            } else
            {
                int ai[] = new int[i];
                int k = i;
                do
                {
                    k--;
                    if (k < 0)
                    {
                        break;
                    }
                    ai[k] = objectinput.readInt();
                } while (true);
                words = ai;
            }
        }
        ival = i;
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        return canonicalize();
    }

    public void realloc(int i)
    {
        if (i == 0)
        {
            if (words != null)
            {
                if (ival > 0)
                {
                    ival = words[0];
                }
                words = null;
            }
        } else
        if (words == null || words.length < i || words.length > i + 2)
        {
            int ai[] = new int[i];
            if (words == null)
            {
                ai[0] = ival;
                ival = 1;
            } else
            {
                if (i < ival)
                {
                    ival = i;
                }
                System.arraycopy(words, 0, ai, 0, ival);
            }
            words = ai;
            return;
        }
    }

    public double roundToDouble(int i, boolean flag, boolean flag1)
    {
        long l1;
        long l3;
label0:
        {
            int l = intLength();
            int k = i + (l - 1);
            if (k < -1075)
            {
                return !flag ? 0.0D : 0.0D;
            }
            if (k > 1023)
            {
                return !flag ? (1.0D / 0.0D) : (-1.0D / 0.0D);
            }
            int j;
            int i1;
            if (k >= -1022)
            {
                j = 53;
            } else
            {
                j = k + 53 + 1022;
            }
            i1 = l - (j + 1);
            if (i1 > 0)
            {
                if (words == null)
                {
                    l1 = ival >> i1;
                } else
                {
                    l1 = MPN.rshift_long(words, ival, i1);
                }
            } else
            {
                l1 = longValue() << -i1;
            }
            if (k == 1023 && l1 >> 1 == 0x1fffffffffffffL)
            {
                if (flag1 || checkBits(l - j))
                {
                    return !flag ? (1.0D / 0.0D) : (-1.0D / 0.0D);
                }
                return !flag ? 1.7976931348623157E+308D : -1.7976931348623157E+308D;
            }
            long l2 = l1;
            i = k;
            if ((1L & l1) != 1L)
            {
                break label0;
            }
            if ((2L & l1) != 2L && !flag1)
            {
                l2 = l1;
                i = k;
                if (!checkBits(i1))
                {
                    break label0;
                }
            }
            l1 += 2L;
            if ((0x40000000000000L & l1) != 0L)
            {
                i = k + 1;
                l2 = l1 >> 1;
            } else
            {
                l2 = l1;
                i = k;
                if (j == 52)
                {
                    l2 = l1;
                    i = k;
                    if ((0x20000000000000L & l1) != 0L)
                    {
                        i = k + 1;
                        l2 = l1;
                    }
                }
            }
        }
        if (flag)
        {
            l1 = 0x8000000000000000L;
        } else
        {
            l1 = 0L;
        }
        i += 1023;
        if (i <= 0)
        {
            l3 = 0L;
        } else
        {
            l3 = (long)i << 52;
        }
        return Double.longBitsToDouble(l1 | l3 | l2 >> 1 & 0xffefffffffffffffL);
    }

    public final void set(int i)
    {
        words = null;
        ival = i;
    }

    public final void set(long l)
    {
        int i = (int)l;
        if ((long)i == l)
        {
            ival = i;
            words = null;
            return;
        } else
        {
            realloc(2);
            words[0] = i;
            words[1] = (int)(l >> 32);
            ival = 2;
            return;
        }
    }

    public final void set(IntNum intnum)
    {
        if (intnum.words == null)
        {
            set(intnum.ival);
        } else
        if (this != intnum)
        {
            realloc(intnum.ival);
            System.arraycopy(intnum.words, 0, words, 0, intnum.ival);
            ival = intnum.ival;
            return;
        }
    }

    public final void set(int ai[], int i)
    {
        ival = i;
        words = ai;
    }

    public final void setAdd(int i)
    {
        setAdd(this, i);
    }

    public void setAdd(IntNum intnum, int i)
    {
        if (intnum.words == null)
        {
            set((long)intnum.ival + (long)i);
            return;
        }
        int j = intnum.ival;
        realloc(j + 1);
        long l = i;
        for (i = 0; i < j; i++)
        {
            l += (long)intnum.words[i] & 0xffffffffL;
            words[i] = (int)l;
            l >>= 32;
        }

        long l1 = l;
        if (intnum.words[j - 1] < 0)
        {
            l1 = l - 1L;
        }
        words[j] = (int)l1;
        ival = wordsNeeded(words, j + 1);
    }

    void setInvert()
    {
        if (words != null) goto _L2; else goto _L1
_L1:
        ival = ~ival;
_L4:
        return;
_L2:
        int i = ival;
        do
        {
            i--;
            if (i < 0)
            {
                continue;
            }
            words[i] = ~words[i];
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void setNegative()
    {
        setNegative(this);
    }

    public void setNegative(IntNum intnum)
    {
        int j = intnum.ival;
        if (intnum.words == null)
        {
            if (j == 0x80000000)
            {
                set(-(long)j);
                return;
            } else
            {
                set(-j);
                return;
            }
        }
        realloc(j + 1);
        int i = j;
        if (negate(words, intnum.words, j))
        {
            words[j] = 0;
            i = j + 1;
        }
        ival = i;
    }

    void setShift(IntNum intnum, int i)
    {
        if (i > 0)
        {
            setShiftLeft(intnum, i);
            return;
        } else
        {
            setShiftRight(intnum, -i);
            return;
        }
    }

    void setShiftLeft(IntNum intnum, int i)
    {
        if (intnum.words != null) goto _L2; else goto _L1
_L1:
        if (i >= 32) goto _L4; else goto _L3
_L3:
        set((long)intnum.ival << i);
_L6:
        return;
_L4:
        int j;
        int ai[] = new int[1];
        ai[0] = intnum.ival;
        j = 1;
        intnum = ai;
        break MISSING_BLOCK_LABEL_41;
_L2:
        int ai1[] = intnum.words;
        j = intnum.ival;
        intnum = ai1;
        int k = i >> 5;
        int i1 = i & 0x1f;
        int l = j + k;
        if (i1 == 0)
        {
            realloc(l);
            do
            {
                j--;
                i = l;
                if (j < 0)
                {
                    break;
                }
                words[j + k] = intnum[j];
            } while (true);
        } else
        {
            i = l + 1;
            realloc(i);
            j = MPN.lshift(words, k, intnum, j, i1);
            l = 32 - i1;
            words[i - 1] = (j << l) >> l;
        }
        ival = i;
        i = k;
        do
        {
            i--;
            if (i < 0)
            {
                continue;
            }
            words[i] = 0;
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
    }

    void setShiftRight(IntNum intnum, int i)
    {
        byte byte0 = -1;
        if (intnum.words != null) goto _L2; else goto _L1
_L1:
        if (i >= 32) goto _L4; else goto _L3
_L3:
        i = intnum.ival >> i;
_L8:
        set(i);
_L6:
        return;
_L4:
        i = byte0;
        if (intnum.ival >= 0)
        {
            i = 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        int l;
        boolean flag;
        if (i == 0)
        {
            set(intnum);
            return;
        }
        flag = intnum.isNegative();
        int k = i >> 5;
        i &= 0x1f;
        l = intnum.ival - k;
        if (l <= 0)
        {
            if (!flag)
            {
                byte0 = 0;
            }
            set(byte0);
            return;
        }
        if (words == null || words.length < l)
        {
            realloc(l);
        }
        MPN.rshift0(words, intnum.words, k, l, i);
        ival = l;
        if (!flag) goto _L6; else goto _L5
_L5:
        intnum = words;
        int j = l - 1;
        intnum[j] = intnum[j] | -2 << 31 - i;
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int sign()
    {
        int ai[];
        int i;
        i = ival;
        ai = words;
        if (ai != null) goto _L2; else goto _L1
_L1:
        if (i <= 0) goto _L4; else goto _L3
_L3:
        return 1;
_L4:
        return i >= 0 ? 0 : -1;
_L2:
        i--;
        int j = ai[i];
        if (j <= 0)
        {
            if (j < 0)
            {
                return -1;
            }
            do
            {
                if (i == 0)
                {
                    return 0;
                }
                j = i - 1;
                i = j;
            } while (ai[j] == 0);
            return 1;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public IntNum toExactInt(int i)
    {
        return this;
    }

    public RealNum toInt(int i)
    {
        return this;
    }

    public String toString(int i)
    {
        if (words == null)
        {
            return Integer.toString(ival, i);
        }
        if (ival <= 2)
        {
            return Long.toString(longValue(), i);
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(ival * (MPN.chars_per_word(i) + 1));
            format(i, stringbuilder);
            return stringbuilder.toString();
        }
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        int i;
        boolean flag;
        flag = false;
        if (words == null)
        {
            i = 1;
        } else
        {
            i = wordsNeeded(words, ival);
        }
        if (i > 1) goto _L2; else goto _L1
_L1:
        if (words == null)
        {
            i = ival;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (words.length != 0)
            {
                i = words[0];
            }
        }
        if (i < 0xc0000000) goto _L4; else goto _L3
_L3:
        objectoutput.writeInt(i);
_L6:
        return;
_L4:
        objectoutput.writeInt(0x80000001);
        objectoutput.writeInt(i);
        return;
_L2:
        objectoutput.writeInt(0x80000000 | i);
        do
        {
            i--;
            if (i < 0)
            {
                continue;
            }
            objectoutput.writeInt(words[i]);
        } while (true);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        smallFixNums = new IntNum[1125];
        int i = 1125;
        do
        {
            i--;
            if (i >= 0)
            {
                smallFixNums[i] = new IntNum(i - 100);
            }
        } while (true);
    }
}
