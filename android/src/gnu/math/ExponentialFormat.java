// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

// Referenced classes of package gnu.math:
//            RealNum, IntNum

public class ExponentialFormat extends Format
{

    static final double LOG10 = Math.log(10D);
    public int expDigits;
    public char exponentChar;
    public boolean exponentShowSign;
    public int fracDigits;
    public boolean general;
    public int intDigits;
    public char overflowChar;
    public char padChar;
    public boolean showPlus;
    public int width;

    public ExponentialFormat()
    {
        fracDigits = -1;
        exponentChar = 'E';
    }

    static boolean addOne(StringBuffer stringbuffer, int i, int j)
    {
        do
        {
            if (j == i)
            {
                stringbuffer.insert(j, '1');
                return true;
            }
            j--;
            char c = stringbuffer.charAt(j);
            if (c != '9')
            {
                stringbuffer.setCharAt(j, (char)(c + 1));
                return false;
            }
            stringbuffer.setCharAt(j, '0');
        } while (true);
    }

    StringBuffer format(double d, String s, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        int i;
        int j1;
        int k1;
        int i2;
        int j2;
        int k2;
        int i3;
        int k3;
        boolean flag3;
        boolean flag4;
        int l3;
        int i4;
        int j4;
        boolean flag5;
        int l4;
        boolean flag6;
        int i5;
        l3 = intDigits;
        int k4 = fracDigits;
        double d1;
        boolean flag;
        if (d < 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d1 = d;
        if (flag)
        {
            d1 = -d;
        }
        i5 = stringbuffer.length();
        i = 1;
        if (flag)
        {
            i4 = i;
            if (k4 >= 0)
            {
                stringbuffer.append('-');
                i4 = i;
            }
        } else
        if (showPlus)
        {
            stringbuffer.append('+');
            i4 = i;
        } else
        {
            i4 = 0;
        }
        k1 = stringbuffer.length();
        if (Double.isNaN(d1) || Double.isInfinite(d1))
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        if (k4 < 0 || flag4)
        {
            fieldposition = s;
            if (s == null)
            {
                fieldposition = Double.toString(d1);
            }
            i = fieldposition.indexOf('E');
            if (i >= 0)
            {
                stringbuffer.append(fieldposition);
                int l2 = i + k1;
                int i1;
                boolean flag1;
                boolean flag2;
                if (fieldposition.charAt(l2 + 1) == '-')
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag2 = false;
                if (flag1)
                {
                    i = 2;
                } else
                {
                    i = 1;
                }
                i1 = l2 + i;
                i = ((flag2) ? 1 : 0);
                for (; i1 < stringbuffer.length(); i1++)
                {
                    i = i * 10 + (stringbuffer.charAt(i1) - 48);
                }

                i1 = i;
                if (flag1)
                {
                    i1 = -i;
                }
                stringbuffer.setLength(l2);
                i = i1;
            } else
            {
                i = RealNum.toStringScientific(fieldposition, stringbuffer);
            }
            j2 = k1;
            if (flag)
            {
                j2 = k1 + 1;
            }
            stringbuffer.deleteCharAt(j2 + 1);
            j1 = stringbuffer.length() - j2;
            k1 = j1;
            if (j1 > 1)
            {
                k1 = j1;
                if (stringbuffer.charAt((j2 + j1) - 1) == '0')
                {
                    k1 = j1 - 1;
                    stringbuffer.setLength(j2 + k1);
                }
            }
            i3 = k1 - i - 1;
        } else
        {
            if (l3 > 0)
            {
                i = 1;
            } else
            {
                i = l3;
            }
            j1 = k4 + i;
            i = (int)(Math.log(d1) / LOG10 + 1000D);
            if (i == 0x80000000)
            {
                i = 0;
            } else
            {
                i -= 1000;
            }
            i3 = j1 - i - 1;
            RealNum.toScaledInt(d1, i3).format(10, stringbuffer);
            i = j1 - 1 - i3;
            j2 = k1;
            k1 = j1;
        }
        l4 = i - (l3 - 1);
        if (l4 < 0)
        {
            j4 = -l4;
        } else
        {
            j4 = l4;
        }
        if (j4 >= 1000)
        {
            i = 4;
        } else
        if (j4 >= 100)
        {
            i = 3;
        } else
        if (j4 >= 10)
        {
            i = 2;
        } else
        {
            i = 1;
        }
_L10:
        k2 = i;
        if (expDigits > i)
        {
            k2 = expDigits;
        }
        flag6 = true;
        if (!general)
        {
            j1 = 0;
        } else
        if (expDigits > 0)
        {
            j1 = expDigits + 2;
        } else
        {
            j1 = 4;
        }
        if (k4 < 0)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (general) goto _L2; else goto _L1
_L1:
        i2 = k1;
        k3 = l3;
        flag3 = flag6;
        if (!flag5) goto _L3; else goto _L2
_L2:
        k3 = k1 - i3;
        i = k4;
        if (flag5)
        {
            if (k3 < 7)
            {
                i2 = k3;
            } else
            {
                i2 = 7;
            }
            i = i2;
            if (k1 > i2)
            {
                i = k1;
            }
        }
        if (!general || k3 < 0 || i - k3 < 0) goto _L5; else goto _L4
_L4:
        flag3 = false;
        i2 = i;
_L3:
        for (i2 = j2 + i2; stringbuffer.length() < i2; stringbuffer.append('0')) { }
        break; /* Loop/switch isn't completed */
_L5:
        i2 = k1;
        k3 = l3;
        flag3 = flag6;
        if (!flag5)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (width > 0)
        {
            break; /* Loop/switch isn't completed */
        }
        k1 = i;
_L7:
        i2 = k1;
        k3 = l3;
        flag3 = flag6;
        if (k1 <= 0)
        {
            i2 = 1;
            k3 = l3;
            flag3 = flag6;
        }
        if (true) goto _L3; else goto _L6
_L6:
        k1 = width - i4 - k2 - 3;
        i2 = k1;
        if (l3 < 0)
        {
            i2 = k1 - l3;
        }
        k1 = i2;
        if (i2 > i)
        {
            k1 = i;
        }
          goto _L7
        if (true) goto _L3; else goto _L8
_L8:
        int l1;
label0:
        {
            int j;
            if (i2 == stringbuffer.length())
            {
                j = 48;
            } else
            {
                j = stringbuffer.charAt(i2);
            }
            if (j >= 53)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            l1 = i3;
            if (j != 0)
            {
                l1 = i3;
                if (addOne(stringbuffer, j2, i2))
                {
                    l1 = i3 + 1;
                }
            }
            stringbuffer.length();
            stringbuffer.setLength(i2);
            l1 = j2;
            j = i2;
            if (k3 < 0)
            {
                j = k3;
                do
                {
                    i2 = j + 1;
                    j = l1;
                    if (i2 > 0)
                    {
                        break;
                    }
                    stringbuffer.insert(j2, '0');
                    j = i2;
                } while (true);
            } else
            {
                for (; j2 + k3 > j; j++)
                {
                    stringbuffer.append('0');
                }

                j = l1 + k3;
            }
            if (flag4)
            {
                flag3 = false;
            } else
            {
                stringbuffer.insert(j, '.');
            }
            if (flag3)
            {
                stringbuffer.append(exponentChar);
                if (exponentShowSign || l4 < 0)
                {
                    char c;
                    int j3;
                    if (l4 >= 0)
                    {
                        c = '+';
                    } else
                    {
                        c = '-';
                    }
                    stringbuffer.append(c);
                }
                j3 = stringbuffer.length();
                stringbuffer.append(j4);
                l1 = stringbuffer.length();
                l1 = expDigits - (l1 - j3);
                i2 = k2;
                if (l1 > 0)
                {
                    do
                    {
                        l1--;
                        i2 = k2;
                        if (l1 < 0)
                        {
                            break;
                        }
                        stringbuffer.insert(j3, '0');
                    } while (true);
                }
            } else
            {
                i2 = 0;
            }
            l1 = stringbuffer.length();
            k2 = width - (l1 - i5);
            l1 = k2;
            if (!flag5)
            {
                break label0;
            }
            if (j + 1 != stringbuffer.length())
            {
                l1 = k2;
                if (stringbuffer.charAt(j + 1) != exponentChar)
                {
                    break label0;
                }
            }
            if (width > 0)
            {
                l1 = k2;
                if (k2 <= 0)
                {
                    break label0;
                }
            }
            l1 = k2 - 1;
            stringbuffer.insert(j + 1, '0');
        }
label1:
        {
label2:
            {
                int k;
label3:
                {
                    if (l1 < 0 && width > 0 || flag3 && i2 > expDigits && expDigits > 0 && overflowChar != 0)
                    {
                        break label2;
                    }
                    k = l1;
                    if (k3 > 0)
                    {
                        break label3;
                    }
                    if (l1 <= 0)
                    {
                        k = l1;
                        if (width > 0)
                        {
                            break label3;
                        }
                    }
                    stringbuffer.insert(j2, '0');
                    k = l1 - 1;
                }
                l1 = k;
                if (!flag3)
                {
                    l1 = k;
                    if (width > 0)
                    {
                        do
                        {
                            j1--;
                            l1 = k;
                            if (j1 < 0)
                            {
                                break;
                            }
                            stringbuffer.append(' ');
                            k--;
                        } while (true);
                    }
                }
                do
                {
                    l1--;
                    if (l1 < 0)
                    {
                        break;
                    }
                    stringbuffer.insert(i5, padChar);
                } while (true);
                break label1;
            }
            if (overflowChar != 0)
            {
                stringbuffer.setLength(i5);
                int l = width;
                do
                {
                    l--;
                    if (l < 0)
                    {
                        break;
                    }
                    stringbuffer.append(overflowChar);
                } while (true);
            }
        }
        return stringbuffer;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public StringBuffer format(double d, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        String s;
        if (fracDigits < 0)
        {
            s = Double.toString(d);
        } else
        {
            s = null;
        }
        return format(d, s, stringbuffer, fieldposition);
    }

    public StringBuffer format(float f, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        double d = f;
        String s;
        if (fracDigits < 0)
        {
            s = Float.toString(f);
        } else
        {
            s = null;
        }
        return format(d, s, stringbuffer, fieldposition);
    }

    public StringBuffer format(long l, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        return format(l, stringbuffer, fieldposition);
    }

    public StringBuffer format(Object obj, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        return format(((RealNum)obj).doubleValue(), stringbuffer, fieldposition);
    }

    public Number parse(String s, ParsePosition parseposition)
    {
        throw new Error("ExponentialFormat.parse - not implemented");
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new Error("ExponentialFormat.parseObject - not implemented");
    }

}
