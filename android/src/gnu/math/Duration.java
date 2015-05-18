// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package gnu.math:
//            Quantity, Unit, DateTime, RealNum, 
//            DFloNum, Numeric, Complex

public class Duration extends Quantity
    implements Externalizable
{

    int months;
    int nanos;
    long seconds;
    public Unit unit;

    public Duration()
    {
    }

    public static Duration add(Duration duration, Duration duration1, int i)
    {
        long l = duration.months;
        long l1 = i;
        long l2 = duration1.months;
        long l3 = duration.seconds * 0x3b9aca00L + (long)duration.nanos + (long)i * (duration1.seconds * 0x3b9aca00L + (long)duration1.nanos);
        Duration duration2 = new Duration();
        duration2.months = (int)(l + l1 * l2);
        duration2.seconds = (int)(l3 / 0x3b9aca00L);
        duration2.nanos = (int)(l3 % 0x3b9aca00L);
        if (duration.unit != duration1.unit || duration.unit == Unit.duration)
        {
            throw new ArithmeticException("cannot add these duration types");
        } else
        {
            duration2.unit = duration.unit;
            return duration2;
        }
    }

    static void appendNanoSeconds(int i, StringBuffer stringbuffer)
    {
        if (i == 0)
        {
            return;
        }
        stringbuffer.append('.');
        int j = stringbuffer.length();
        stringbuffer.append(i);
        i = (j + 9) - stringbuffer.length();
        do
        {
            i--;
            if (i < 0)
            {
                break;
            }
            stringbuffer.insert(j, '0');
        } while (true);
        i = j + 9;
        do
        {
            j = i - 1;
            i = j;
        } while (stringbuffer.charAt(j) == '0');
        stringbuffer.setLength(j + 1);
    }

    public static int compare(Duration duration, Duration duration1)
    {
        long l = (long)duration.months - (long)duration1.months;
        long l1 = (duration.seconds * 0x3b9aca00L + (long)duration.nanos) - (duration1.seconds * 0x3b9aca00L + (long)duration1.nanos);
        if (l >= 0L || l1 > 0L)
        {
            if (l > 0L && l1 >= 0L)
            {
                return 1;
            }
            if (l == 0L)
            {
                if (l1 >= 0L)
                {
                    return l1 <= 0L ? 0 : 1;
                }
            } else
            {
                return -2;
            }
        }
        return -1;
    }

    public static double div(Duration duration, Duration duration1)
    {
        int i = duration.months;
        int j = duration1.months;
        double d = (double)duration.seconds + (double)duration.nanos * 1.0000000000000001E-09D;
        double d1 = (double)duration1.seconds + (double)duration.nanos * 1.0000000000000001E-09D;
        if (j == 0 && d1 == 0.0D)
        {
            throw new ArithmeticException("divide duration by zero");
        }
        if (j == 0)
        {
            if (i == 0)
            {
                return d / d1;
            }
        } else
        if (d1 == 0.0D && d == 0.0D)
        {
            return (double)i / (double)j;
        }
        throw new ArithmeticException("divide of incompatible durations");
    }

    public static boolean equals(Duration duration, Duration duration1)
    {
        return duration.months == duration1.months && duration.seconds == duration1.seconds && duration.nanos == duration1.nanos;
    }

    public static Duration make(int i, long l, int j, Unit unit1)
    {
        Duration duration = new Duration();
        duration.months = i;
        duration.seconds = l;
        duration.nanos = j;
        duration.unit = unit1;
        return duration;
    }

    public static Duration makeMinutes(int i)
    {
        Duration duration = new Duration();
        duration.unit = Unit.second;
        duration.seconds = i * 60;
        return duration;
    }

    public static Duration makeMonths(int i)
    {
        Duration duration = new Duration();
        duration.unit = Unit.month;
        duration.months = i;
        return duration;
    }

    public static Duration parse(String s, Unit unit1)
    {
        Duration duration = valueOf(s, unit1);
        if (duration == null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("not a valid ").append(unit1.getName()).append(" duration: '").append(s).append("'").toString());
        } else
        {
            return duration;
        }
    }

    public static Duration parseDayTimeDuration(String s)
    {
        return parse(s, Unit.second);
    }

    public static Duration parseDuration(String s)
    {
        return parse(s, Unit.duration);
    }

    public static Duration parseYearMonthDuration(String s)
    {
        return parse(s, Unit.month);
    }

    private static long scanPart(String s, int i)
    {
        int k;
        int l;
        long l2;
        long l3;
        l3 = -1L;
        k = i;
        l2 = -1L;
        l = s.length();
_L10:
        if (k >= l) goto _L2; else goto _L1
_L1:
        int j;
        int i1;
        j = s.charAt(k);
        k++;
        i1 = Character.digit(j, 10);
        if (i1 >= 0) goto _L4; else goto _L3
_L3:
        if (l2 >= 0L) goto _L6; else goto _L5
_L5:
        long l1 = i << 16;
_L8:
        return l1;
_L6:
        return l2 << 32 | (long)(k << 16) | (long)j;
_L4:
        if (l2 < 0L)
        {
            l1 = i1;
        } else
        {
            l1 = 10L * l2 + (long)i1;
        }
        l2 = l1;
        if (l1 > 0x7fffffffL)
        {
            return -1L;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        l1 = l3;
        if (l2 >= 0L) goto _L8; else goto _L7
_L7:
        return (long)(i << 16);
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static Duration times(Duration duration, double d)
    {
        if (duration.unit == Unit.duration)
        {
            throw new IllegalArgumentException("cannot multiply general duration");
        }
        double d1 = (double)duration.months * d;
        if (Double.isInfinite(d1) || Double.isNaN(d1))
        {
            throw new ArithmeticException("overflow/NaN when multiplying a duration");
        } else
        {
            d = (double)(duration.seconds * 0x3b9aca00L + (long)duration.nanos) * d;
            Duration duration1 = new Duration();
            duration1.months = (int)Math.floor(0.5D + d1);
            duration1.seconds = (int)(d / 1000000000D);
            duration1.nanos = (int)(d % 1000000000D);
            duration1.unit = duration.unit;
            return duration1;
        }
    }

    public static Duration valueOf(String s, Unit unit1)
    {
        int i;
        int j;
        int k;
        int l;
        int i1;
        boolean flag;
        int j1;
        boolean flag1;
        int k1;
        long l1;
        s = s.trim();
        i = 0;
        k1 = s.length();
        if (k1 < 0 && s.charAt(0) == '-')
        {
            flag = true;
            i = 0 + 1;
        } else
        {
            flag = false;
        }
        if (i + 1 >= k1 || s.charAt(i) != 'P')
        {
            return null;
        }
        k = 0;
        j1 = 0;
        flag1 = false;
        long l6 = 0L;
        long l2 = scanPart(s, i + 1);
        l = (int)l2 >> 16;
        j = (char)(int)l2;
        if (unit1 == Unit.second && (j == 'Y' || j == 'M'))
        {
            return null;
        }
        i = j;
        l1 = l2;
        if (j == 'Y')
        {
            k = (int)(l2 >> 32) * 12;
            l = (int)l2 >> 16;
            l1 = scanPart(s, l);
            i = (char)(int)l1;
        }
        i1 = i;
        j = k;
        l2 = l1;
        if (i == 'M')
        {
            j = (int)((long)k + (l1 >> 32));
            l = (int)l1 >> 16;
            l2 = scanPart(s, l);
            i1 = (char)(int)l2;
        }
        if (unit1 == Unit.month && l != k1)
        {
            return null;
        }
        long l4 = l2;
        l1 = l6;
        if (i1 == 'D')
        {
            if (unit1 == Unit.month)
            {
                return null;
            }
            l1 = 0x15180L * (long)(int)(l2 >> 32);
            l = (int)l2 >> 16;
            l4 = scanPart(s, l);
        }
        if (l4 != (long)(l << 16))
        {
            return null;
        }
        if (l == k1)
        {
            i1 = l;
            k = ((flag1) ? 1 : 0);
            break MISSING_BLOCK_LABEL_314;
        }
label0:
        {
            if (s.charAt(l) == 'T')
            {
                k = l + 1;
                if (k != k1)
                {
                    break label0;
                }
            }
            return null;
        }
label1:
        {
            if (unit1 == Unit.month)
            {
                return null;
            }
            long l7 = scanPart(s, k);
            l = (char)(int)l7;
            i = l;
            l3 = l7;
            long l5 = l1;
            if (l == 'H')
            {
                l5 = l1 + (long)((int)(l7 >> 32) * 3600);
                k = (int)l7 >> 16;
                l3 = scanPart(s, k);
                i = (char)(int)l3;
            }
            l = i;
            l7 = l3;
            l1 = l5;
            if (i == 'M')
            {
                l1 = l5 + (long)((int)(l3 >> 32) * 60);
                k = (int)l3 >> 16;
                l7 = scanPart(s, k);
                l = (char)(int)l7;
            }
            if (l != 'S')
            {
                i = k;
                l3 = l1;
                if (l != '.')
                {
                    break label1;
                }
            }
            l3 = l1 + (long)(int)(l7 >> 32);
            i = (int)l7 >> 16;
        }
        k = ((flag1) ? 1 : 0);
        i1 = i;
        l1 = l3;
        if (l != '.') goto _L2; else goto _L1
_L1:
        k = ((flag1) ? 1 : 0);
        i1 = i;
        l1 = l3;
        if (i + 1 >= k1) goto _L2; else goto _L3
_L3:
        k = ((flag1) ? 1 : 0);
        i1 = i;
        l1 = l3;
        if (Character.digit(s.charAt(i), 10) < 0) goto _L2; else goto _L4
_L4:
        k = 0;
        i1 = i;
        i = k;
        k = j1;
        j1 = l;
        do
        {
            if (i1 >= k1)
            {
                break MISSING_BLOCK_LABEL_805;
            }
            j1 = i1 + 1;
            char c = s.charAt(i1);
            i1 = Character.digit(c, 10);
            if (i1 < 0)
            {
                l = i;
                i = j1;
                j1 = c;
                break MISSING_BLOCK_LABEL_641;
            }
            if (i < 9)
            {
                l = k * 10 + i1;
            } else
            {
                l = k;
                if (i == 9)
                {
                    l = k;
                    if (i1 >= 5)
                    {
                        l = k + 1;
                    }
                }
            }
            i++;
            i1 = j1;
            j1 = c;
            k = l;
        } while (true);
_L5:
        for (; l < 9; l++)
        {
            k *= 10;
        }

        i1 = i;
        l1 = l3;
        if (j1 != 83)
        {
            return null;
        }
_L2:
        long l3;
        if (i1 != k1)
        {
            return null;
        }
        s = new Duration();
        l = j;
        i = k;
        l3 = l1;
        if (flag)
        {
            l = -j;
            l3 = -l1;
            i = -k;
        }
        s.months = l;
        s.seconds = l3;
        s.nanos = i;
        s.unit = unit1;
        return s;
        l = i;
        i = i1;
          goto _L5
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof Duration)
        {
            return add(this, (Duration)obj, i);
        }
        if ((obj instanceof DateTime) && i == 1)
        {
            return DateTime.add((DateTime)obj, this, 1);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public int compare(Object obj)
    {
        if (obj instanceof Duration)
        {
            return compare(this, (Duration)obj);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Numeric div(Object obj)
    {
        if (obj instanceof RealNum)
        {
            double d = ((RealNum)obj).doubleValue();
            if (d == 0.0D || Double.isNaN(d))
            {
                throw new ArithmeticException("divide of duration by 0 or NaN");
            } else
            {
                return times(this, 1.0D / d);
            }
        }
        if (obj instanceof Duration)
        {
            return new DFloNum(div(this, (Duration)obj));
        } else
        {
            return ((Numeric)obj).divReversed(this);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj == null || !(obj instanceof Duration))
        {
            return false;
        } else
        {
            return equals(this, (Duration)obj);
        }
    }

    public int getDays()
    {
        return (int)(seconds / 0x15180L);
    }

    public int getHours()
    {
        return (int)((seconds / 3600L) % 24L);
    }

    public int getMinutes()
    {
        return (int)((seconds / 60L) % 60L);
    }

    public int getMonths()
    {
        return months % 12;
    }

    public long getNanoSeconds()
    {
        return seconds * 0x3b9aca00L + (long)nanos;
    }

    public int getNanoSecondsOnly()
    {
        return nanos;
    }

    public int getSecondsOnly()
    {
        return (int)(seconds % 60L);
    }

    public long getTotalMinutes()
    {
        return seconds / 60L;
    }

    public int getTotalMonths()
    {
        return months;
    }

    public long getTotalSeconds()
    {
        return seconds;
    }

    public int getYears()
    {
        return months / 12;
    }

    public int hashCode()
    {
        return months ^ (int)seconds ^ nanos;
    }

    public boolean isExact()
    {
        return false;
    }

    public boolean isZero()
    {
        return months == 0 && seconds == 0L && nanos == 0;
    }

    public Numeric mul(Object obj)
    {
        if (obj instanceof RealNum)
        {
            return times(this, ((RealNum)obj).doubleValue());
        } else
        {
            return ((Numeric)obj).mulReversed(this);
        }
    }

    public Numeric mulReversed(Numeric numeric)
    {
        if (!(numeric instanceof RealNum))
        {
            throw new IllegalArgumentException();
        } else
        {
            return times(this, ((RealNum)numeric).doubleValue());
        }
    }

    public Complex number()
    {
        throw new Error("number needs to be implemented!");
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        months = objectinput.readInt();
        seconds = objectinput.readLong();
        nanos = objectinput.readInt();
        unit = (Unit)objectinput.readObject();
    }

    public String toString()
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        int i1 = months;
        long l1 = seconds;
        int l = nanos;
        int i;
        int j;
        int k;
        long l2;
        long l3;
        if (i1 < 0 || l1 < 0L || l < 0)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        i = i1;
        j = l;
        l2 = l1;
        if (k != 0)
        {
            i = -i1;
            l2 = -l1;
            j = -l;
            stringbuffer.append('-');
        }
        stringbuffer.append('P');
        l = i / 12;
        k = i;
        if (l != 0)
        {
            stringbuffer.append(l);
            stringbuffer.append('Y');
            k = i - l * 12;
        }
        if (k != 0)
        {
            stringbuffer.append(k);
            stringbuffer.append('M');
        }
        l3 = l2 / 0x15180L;
        l1 = l2;
        if (l3 != 0L)
        {
            stringbuffer.append(l3);
            stringbuffer.append('D');
            l1 = l2 - 0x15180L * l3;
        }
        if (l1 == 0L && j == 0) goto _L2; else goto _L1
_L1:
        stringbuffer.append('T');
        l3 = l1 / 3600L;
        l2 = l1;
        if (l3 != 0L)
        {
            stringbuffer.append(l3);
            stringbuffer.append('H');
            l2 = l1 - 3600L * l3;
        }
        l3 = l2 / 60L;
        l1 = l2;
        if (l3 != 0L)
        {
            stringbuffer.append(l3);
            stringbuffer.append('M');
            l1 = l2 - 60L * l3;
        }
        if (l1 != 0L || j != 0)
        {
            stringbuffer.append(l1);
            appendNanoSeconds(j, stringbuffer);
            stringbuffer.append('S');
        }
_L4:
        return stringbuffer.toString();
_L2:
        if (stringbuffer.length() == 1)
        {
            String s;
            if (unit == Unit.month)
            {
                s = "0M";
            } else
            {
                s = "T0S";
            }
            stringbuffer.append(s);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Unit unit()
    {
        return unit;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeInt(months);
        objectoutput.writeLong(seconds);
        objectoutput.writeInt(nanos);
        objectoutput.writeObject(unit);
    }
}
