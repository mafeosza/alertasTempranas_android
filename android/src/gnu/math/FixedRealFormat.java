// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

// Referenced classes of package gnu.math:
//            DFloNum, ExponentialFormat, IntNum, RealNum, 
//            Complex, RatNum

public class FixedRealFormat extends Format
{

    private int d;
    private int i;
    public boolean internalPad;
    public char overflowChar;
    public char padChar;
    public int scale;
    public boolean showPlus;
    public int width;

    public FixedRealFormat()
    {
    }

    private void format(StringBuffer stringbuffer, FieldPosition fieldposition, int j, int k, int l, int i1, int j1)
    {
        int l1;
label0:
        {
            int k1 = getMinimumIntegerDigits();
            if (k >= 0 && k > k1)
            {
                l1 = 0;
            } else
            {
                l1 = k1 - k;
            }
            k1 = l1;
            if (k + l1 > 0)
            {
                break label0;
            }
            if (width > 0)
            {
                k1 = l1;
                if (width <= l + 1 + i1)
                {
                    break label0;
                }
            }
            k1 = l1 + 1;
        }
label1:
        {
            l1 = width - (i1 + j + k1 + 1);
            do
            {
                k1--;
                if (k1 < 0)
                {
                    break;
                }
                stringbuffer.insert(j1 + i1, '0');
            } while (true);
            if (l1 >= 0)
            {
                j = j1;
                k = l1;
                if (internalPad)
                {
                    j = j1;
                    k = l1;
                    if (i1 > 0)
                    {
                        j = j1 + 1;
                        k = l1;
                    }
                }
                do
                {
                    k--;
                    if (k < 0)
                    {
                        break;
                    }
                    stringbuffer.insert(j, padChar);
                } while (true);
            } else
            if (overflowChar != 0)
            {
                stringbuffer.setLength(j1);
                i = width;
                do
                {
                    j = i - 1;
                    i = j;
                    if (j < 0)
                    {
                        break;
                    }
                    stringbuffer.append(overflowChar);
                } while (true);
                break label1;
            }
            stringbuffer.insert(stringbuffer.length() - l, '.');
        }
    }

    public StringBuffer format(double d1, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        int l;
        int k1;
        boolean flag;
        int i2;
        int i3;
        int j3;
label0:
        {
            if (Double.isNaN(d1) || Double.isInfinite(d1))
            {
                return stringbuffer.append(d1);
            }
            if (getMaximumFractionDigits() >= 0)
            {
                format(((RealNum) (DFloNum.toExact(d1))), stringbuffer, fieldposition);
                return stringbuffer;
            }
            String s;
            String s1;
            int j;
            int j1;
            int l1;
            if (d1 < 0.0D)
            {
                flag = true;
                d1 = -d1;
            } else
            {
                flag = false;
            }
            i3 = stringbuffer.length();
            l1 = 1;
            if (flag)
            {
                stringbuffer.append('-');
            } else
            if (showPlus)
            {
                stringbuffer.append('+');
            } else
            {
                l1 = 0;
            }
            s1 = Double.toString(d1);
            l = scale;
            k1 = s1.indexOf('E');
            j = l;
            s = s1;
            if (k1 >= 0)
            {
                int i1 = k1 + 1;
                j = i1;
                if (s1.charAt(i1) == '+')
                {
                    j = i1 + 1;
                }
                j = l + Integer.parseInt(s1.substring(j));
                s = s1.substring(0, k1);
            }
            l = s.indexOf('.');
            k1 = s.length();
            j1 = j;
            s1 = s;
            if (l >= 0)
            {
                j1 = j - (k1 - l - 1);
                s1 = (new StringBuilder()).append(s.substring(0, l)).append(s.substring(l + 1)).toString();
            }
            k1 = s1.length();
            for (l = 0; l < k1 - 1 && s1.charAt(l) == '0'; l++) { }
            j = k1;
            s = s1;
            if (l > 0)
            {
                s = s1.substring(l);
                j = k1 - l;
            }
            l = j + j1;
            if (width > 0)
            {
                while (l < 0) 
                {
                    stringbuffer.append('0');
                    l++;
                    j++;
                }
                k1 = width - l1 - 1 - l;
            } else
            {
                if (j > 16)
                {
                    k1 = 16;
                } else
                {
                    k1 = j;
                }
                k1 -= l;
            }
            i2 = k1;
            if (k1 < 0)
            {
                i2 = 0;
            }
            stringbuffer.append(s);
            while (j1 > 0) 
            {
                stringbuffer.append('0');
                j1--;
                j++;
            }
            j3 = i3 + l1;
            j = j3 + l + i2;
            j1 = stringbuffer.length();
            boolean flag1;
            int j2;
            if (j >= j1)
            {
                j = j1;
                j1 = 48;
            } else
            {
                j1 = stringbuffer.charAt(j);
            }
            if (j1 >= 53)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                j1 = 57;
                j2 = j;
            } else
            {
                j1 = 48;
                j2 = j;
            }
            for (; j2 > j3 + l && stringbuffer.charAt(j2 - 1) == j1; j2--) { }
            int k2 = j2 - j3;
            int l2 = k2 - l;
            j1 = k2;
            k1 = l;
            j = l2;
            if (flag1)
            {
                j1 = k2;
                k1 = l;
                j = l2;
                if (ExponentialFormat.addOne(stringbuffer, j3, j2))
                {
                    k1 = l + 1;
                    j = 0;
                    j1 = k1;
                }
            }
            flag1 = j1;
            l = j;
            if (j != 0)
            {
                break label0;
            }
            if (width > 0)
            {
                flag1 = j1;
                l = j;
                if (l1 + k1 + 1 >= width)
                {
                    break label0;
                }
            }
            l = 1;
            flag1 = j1 + 1;
            stringbuffer.insert(j3 + k1, '0');
        }
        stringbuffer.setLength(j3 + flag1);
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        format(stringbuffer, fieldposition, flag1, k1, l, k, i3);
        return stringbuffer;
    }

    public StringBuffer format(long l, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        format(((RealNum) (IntNum.make(l))), stringbuffer, fieldposition);
        return stringbuffer;
    }

    public StringBuffer format(Object obj, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        RealNum realnum1 = RealNum.asRealNumOrNull(obj);
        RealNum realnum = realnum1;
        if (realnum1 == null)
        {
            if (obj instanceof Complex)
            {
                obj = obj.toString();
                int j = width - ((String) (obj)).length();
                do
                {
                    j--;
                    if (j >= 0)
                    {
                        stringbuffer.append(' ');
                    } else
                    {
                        stringbuffer.append(((String) (obj)));
                        return stringbuffer;
                    }
                } while (true);
            }
            realnum = (RealNum)obj;
        }
        return format(realnum.doubleValue(), stringbuffer, fieldposition);
    }

    public void format(RealNum realnum, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        if (realnum instanceof RatNum)
        {
            int k = getMaximumFractionDigits();
            if (k >= 0)
            {
                RatNum ratnum = (RatNum)realnum;
                boolean flag = ratnum.isNegative();
                realnum = ratnum;
                if (flag)
                {
                    realnum = ratnum.rneg();
                }
                int l = stringbuffer.length();
                int j = 1;
                int i1;
                if (flag)
                {
                    stringbuffer.append('-');
                } else
                if (showPlus)
                {
                    stringbuffer.append('+');
                } else
                {
                    j = 0;
                }
                realnum = RealNum.toScaledInt(realnum, scale + k).toString();
                stringbuffer.append(realnum);
                i1 = realnum.length();
                format(stringbuffer, fieldposition, i1, i1 - k, k, j, l);
                return;
            }
        }
        format(realnum.doubleValue(), stringbuffer, fieldposition);
    }

    public int getMaximumFractionDigits()
    {
        return d;
    }

    public int getMinimumIntegerDigits()
    {
        return i;
    }

    public Number parse(String s, ParsePosition parseposition)
    {
        throw new Error("RealFixedFormat.parse - not implemented");
    }

    public Object parseObject(String s, ParsePosition parseposition)
    {
        throw new Error("RealFixedFormat.parseObject - not implemented");
    }

    public void setMaximumFractionDigits(int j)
    {
        d = j;
    }

    public void setMinimumIntegerDigits(int j)
    {
        i = j;
    }
}
