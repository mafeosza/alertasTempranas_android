// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.math;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

// Referenced classes of package gnu.math:
//            Quantity, Unit, Duration, Numeric, 
//            Complex

public class DateTime extends Quantity
    implements Cloneable
{

    public static final int DATE_MASK = 14;
    static final int DAY_COMPONENT = 3;
    public static final int DAY_MASK = 8;
    public static TimeZone GMT = TimeZone.getTimeZone("GMT");
    static final int HOURS_COMPONENT = 4;
    public static final int HOURS_MASK = 16;
    static final int MINUTES_COMPONENT = 5;
    public static final int MINUTES_MASK = 32;
    static final int MONTH_COMPONENT = 2;
    public static final int MONTH_MASK = 4;
    static final int SECONDS_COMPONENT = 6;
    public static final int SECONDS_MASK = 64;
    static final int TIMEZONE_COMPONENT = 7;
    public static final int TIMEZONE_MASK = 128;
    public static final int TIME_MASK = 112;
    static final int YEAR_COMPONENT = 1;
    public static final int YEAR_MASK = 2;
    private static final Date minDate = new Date(0x8000000000000000L);
    GregorianCalendar calendar;
    int mask;
    int nanoSeconds;
    Unit unit;

    public DateTime(int i)
    {
        unit = Unit.date;
        calendar = new GregorianCalendar();
        calendar.setGregorianChange(minDate);
        calendar.clear();
        mask = i;
    }

    public DateTime(int i, GregorianCalendar gregoriancalendar)
    {
        unit = Unit.date;
        calendar = gregoriancalendar;
        mask = i;
    }

    public static DateTime add(DateTime datetime, Duration duration, int i)
    {
        if (duration.unit == Unit.duration || duration.unit == Unit.month && (datetime.mask & 0xe) != 14)
        {
            throw new IllegalArgumentException("invalid date/time +/- duration combinatuion");
        }
        DateTime datetime1 = new DateTime(datetime.mask, (GregorianCalendar)datetime.calendar.clone());
        if (duration.months != 0)
        {
            int j = datetime1.getYear() * 12 + datetime1.calendar.get(2) + duration.months * i;
            int j1 = datetime1.calendar.get(5);
            int k;
            int l;
            int i1;
            long l1;
            long l2;
            long l3;
            if (j >= 12)
            {
                l = j / 12;
                k = j % 12;
                datetime1.calendar.set(0, 1);
                j = daysInMonth(k, l);
            } else
            {
                j = 11 - j;
                datetime1.calendar.set(0, 0);
                l = j / 12 + 1;
                k = 11 - j % 12;
                j = daysInMonth(k, 1);
            }
            i1 = j1;
            if (j1 > j)
            {
                i1 = j;
            }
            datetime1.calendar.set(l, k, i1);
        }
        l2 = (long)datetime.nanoSeconds + (long)i * (duration.seconds * 0x3b9aca00L + (long)duration.nanos);
        if (l2 != 0L)
        {
            l1 = l2;
            if ((datetime.mask & 0x70) == 0)
            {
                l3 = l2 % 0x4e94914f0000L;
                l1 = l3;
                if (l3 < 0L)
                {
                    l1 = l3 + 0x4e94914f0000L;
                }
                l1 = l2 - l1;
            }
            l2 = datetime1.calendar.getTimeInMillis();
            l3 = l1 / 0x3b9aca00L;
            datetime1.calendar.setTimeInMillis(l2 + l3 * 1000L);
            datetime1.nanoSeconds = (int)(l1 % 0x3b9aca00L);
        }
        return datetime1;
    }

    public static DateTime addMinutes(DateTime datetime, int i)
    {
        return addSeconds(datetime, i * 60);
    }

    public static DateTime addSeconds(DateTime datetime, int i)
    {
        DateTime datetime1 = new DateTime(datetime.mask, (GregorianCalendar)datetime.calendar.clone());
        long l = (long)i * 0x3b9aca00L;
        if (l != 0L)
        {
            l += datetime.nanoSeconds;
            long l1 = datetime.calendar.getTimeInMillis();
            long l2 = l / 0xf4240L;
            datetime1.calendar.setTimeInMillis(l1 + l2);
            datetime1.nanoSeconds = (int)(l % 0xf4240L);
        }
        return datetime1;
    }

    private static void append(int i, StringBuffer stringbuffer, int j)
    {
        int k = stringbuffer.length();
        stringbuffer.append(i);
        i = (k + j) - stringbuffer.length();
        do
        {
            i--;
            if (i >= 0)
            {
                stringbuffer.insert(k, '0');
            } else
            {
                return;
            }
        } while (true);
    }

    public static int compare(DateTime datetime, DateTime datetime1)
    {
        long l3 = datetime.calendar.getTimeInMillis();
        long l5 = datetime1.calendar.getTimeInMillis();
        long l4 = l3;
        long l2 = l5;
        if (((datetime.mask | datetime1.mask) & 0xe) == 0)
        {
            long l = l3;
            if (l3 < 0L)
            {
                l = l3 + 0x5265c00L;
            }
            l4 = l;
            l2 = l5;
            if (l5 < 0L)
            {
                l2 = l5 + 0x5265c00L;
                l4 = l;
            }
        }
        int j = datetime.nanoSeconds;
        int i = datetime1.nanoSeconds;
        long l1 = l4 + (long)(j / 0xf4240);
        l2 += i / 0xf4240;
        j %= 0xf4240;
        i %= 0xf4240;
        if (l1 < l2)
        {
            return -1;
        }
        if (l1 > l2)
        {
            return 1;
        }
        if (j < i)
        {
            return -1;
        }
        return j <= i ? 0 : 1;
    }

    public static int daysInMonth(int i, int j)
    {
        switch (i)
        {
        case 2: // '\002'
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
        default:
            return 31;

        case 3: // '\003'
        case 5: // '\005'
        case 8: // '\b'
        case 10: // '\n'
            return 30;

        case 1: // '\001'
            break;
        }
        return !isLeapYear(j) ? 28 : 29;
    }

    public static boolean isLeapYear(int i)
    {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    public static TimeZone minutesToTimeZone(int i)
    {
        if (i == 0)
        {
            return GMT;
        } else
        {
            StringBuffer stringbuffer = new StringBuffer("GMT");
            toStringZone(i, stringbuffer);
            return TimeZone.getTimeZone(stringbuffer.toString());
        }
    }

    public static DateTime parse(String s, int i)
    {
        boolean flag = true;
        DateTime datetime = new DateTime(i);
        s = s.trim();
        int k = s.length();
        int j = 0;
        boolean flag1;
        if ((i & 0xe) != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if ((i & 0x70) == 0)
        {
            flag = false;
        }
        if (flag1)
        {
            i = datetime.parseDate(s, 0, i);
            j = i;
            if (flag)
            {
                if (i < 0 || i >= k || s.charAt(i) != 'T')
                {
                    j = -1;
                } else
                {
                    j = i + 1;
                }
            }
        }
        i = j;
        if (flag)
        {
            i = datetime.parseTime(s, j);
        }
        if (datetime.parseZone(s, i) != k)
        {
            throw new NumberFormatException((new StringBuilder()).append("Unrecognized date/time '").append(s).append('\'').toString());
        } else
        {
            return datetime;
        }
    }

    private static int parseDigits(String s, int i)
    {
        int j = i;
        i = -1;
        int l = s.length();
        do
        {
label0:
            {
                int k;
                if (j < l)
                {
                    k = Character.digit(s.charAt(j), 10);
                    if (k >= 0)
                    {
                        break label0;
                    }
                }
                if (i < 0)
                {
                    return j;
                } else
                {
                    return j | i << 16;
                }
            }
            if (i > 20000)
            {
                return 0;
            }
            if (i < 0)
            {
                i = k;
            } else
            {
                i = i * 10 + k;
            }
            j++;
        } while (true);
    }

    public static Duration sub(DateTime datetime, DateTime datetime1)
    {
        long l = datetime.calendar.getTimeInMillis();
        long l1 = datetime1.calendar.getTimeInMillis();
        int i = datetime.nanoSeconds;
        int j = datetime1.nanoSeconds;
        long l2 = i / 0xf4240;
        long l3 = j / 0xf4240;
        i = j % 0xf4240;
        l = (l + l2) - (l1 + l3);
        l1 = l / 1000L;
        i = (int)(((l % 1000L) * 0xf4240L + (long)i) - (long)i);
        return Duration.make(0, l1 + (long)(i / 0x3b9aca00), i % 0x3b9aca00, Unit.second);
    }

    public static void toStringZone(int i, StringBuffer stringbuffer)
    {
        if (i == 0)
        {
            stringbuffer.append('Z');
            return;
        }
        if (i < 0)
        {
            stringbuffer.append('-');
            i = -i;
        } else
        {
            stringbuffer.append('+');
        }
        append(i / 60, stringbuffer, 2);
        stringbuffer.append(':');
        append(i % 60, stringbuffer, 2);
    }

    public Numeric add(Object obj, int i)
    {
        if (obj instanceof Duration)
        {
            return add(this, (Duration)obj, i);
        }
        if ((obj instanceof DateTime) && i == -1)
        {
            return sub(this, (DateTime)obj);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public Numeric addReversed(Numeric numeric, int i)
    {
        if ((numeric instanceof Duration) && i == 1)
        {
            return add(this, (Duration)numeric, i);
        } else
        {
            throw new IllegalArgumentException();
        }
    }

    public DateTime adjustTimezone(int i)
    {
        DateTime datetime = new DateTime(mask, (GregorianCalendar)calendar.clone());
        Object obj;
        if (i == 0)
        {
            obj = GMT;
        } else
        {
            obj = new StringBuffer("GMT");
            toStringZone(i, ((StringBuffer) (obj)));
            obj = TimeZone.getTimeZone(((StringBuffer) (obj)).toString());
        }
        datetime.calendar.setTimeZone(((TimeZone) (obj)));
        if ((datetime.mask & 0x80) != 0)
        {
            long l = calendar.getTimeInMillis();
            datetime.calendar.setTimeInMillis(l);
            if ((mask & 0x70) == 0)
            {
                datetime.calendar.set(11, 0);
                datetime.calendar.set(12, 0);
                datetime.calendar.set(13, 0);
                datetime.nanoSeconds = 0;
            }
            return datetime;
        } else
        {
            datetime.mask = datetime.mask | 0x80;
            return datetime;
        }
    }

    public DateTime cast(int i)
    {
        int j = mask & 0xffffff7f;
        if (i == j)
        {
            return this;
        }
        DateTime datetime = new DateTime(i, (GregorianCalendar)calendar.clone());
        if ((~j & i) != 0 && (j != 14 || i != 126))
        {
            throw new ClassCastException("cannot cast DateTime - missing conponents");
        }
        if (isZoneUnspecified())
        {
            datetime.mask = datetime.mask & 0xffffff7f;
        } else
        {
            datetime.mask = datetime.mask | 0x80;
        }
        i = j & ~i;
        if ((i & 0x70) != 0)
        {
            datetime.calendar.clear(11);
            datetime.calendar.clear(12);
            datetime.calendar.clear(13);
        } else
        {
            datetime.nanoSeconds = nanoSeconds;
        }
        if ((i & 2) != 0)
        {
            datetime.calendar.clear(1);
            datetime.calendar.clear(0);
        }
        if ((i & 4) != 0)
        {
            datetime.calendar.clear(2);
        }
        if ((i & 8) != 0)
        {
            datetime.calendar.clear(5);
        }
        return datetime;
    }

    public int compare(Object obj)
    {
        if (obj instanceof DateTime)
        {
            return compare(this, (DateTime)obj);
        } else
        {
            return ((Numeric)obj).compareReversed(this);
        }
    }

    public int components()
    {
        return mask & 0xffffff7f;
    }

    public int getDay()
    {
        return calendar.get(5);
    }

    public int getHours()
    {
        return calendar.get(11);
    }

    public int getMinutes()
    {
        return calendar.get(12);
    }

    public int getMonth()
    {
        return calendar.get(2) + 1;
    }

    public int getNanoSecondsOnly()
    {
        return nanoSeconds;
    }

    public int getSecondsOnly()
    {
        return calendar.get(13);
    }

    public int getWholeSeconds()
    {
        return calendar.get(13);
    }

    public int getYear()
    {
        int j = calendar.get(1);
        int i = j;
        if (calendar.get(0) == 0)
        {
            i = 1 - j;
        }
        return i;
    }

    public int getZoneMinutes()
    {
        return calendar.getTimeZone().getRawOffset() / 60000;
    }

    public boolean isExact()
    {
        return (mask & 0x70) == 0;
    }

    public boolean isZero()
    {
        throw new Error("DateTime.isZero not meaningful!");
    }

    public boolean isZoneUnspecified()
    {
        return (mask & 0x80) == 0;
    }

    public Complex number()
    {
        throw new Error("number needs to be implemented!");
    }

    int parseDate(String s, int i, int j)
    {
        if (i >= 0) goto _L2; else goto _L1
_L1:
        int k = i;
_L4:
        return k;
_L2:
        int l;
        int j2;
        j2 = s.length();
        int i1 = 0;
        l = i1;
        k = i;
        if (i < j2)
        {
            l = i1;
            k = i;
            if (s.charAt(i) == '-')
            {
                k = i + 1;
                l = 1;
            }
        }
        i1 = k;
        if ((j & 2) == 0)
        {
            if (l == 0)
            {
                return -1;
            }
            i = -1;
            l = i1;
        } else
        {
            i1 = parseDigits(s, i1);
            i = i1 >> 16;
            i1 &= 0xffff;
            if (i1 != k + 4 && (i1 <= k + 4 || s.charAt(k) == '0'))
            {
                return -1;
            }
            if (l != 0 || i == 0)
            {
                calendar.set(0, 0);
                calendar.set(1, i + 1);
                l = i1;
            } else
            {
                calendar.set(1, i);
                l = i1;
            }
        }
        k = l;
        if ((j & 0xc) == 0) goto _L4; else goto _L3
_L3:
        int j1;
        if (l >= j2 || s.charAt(l) != '-')
        {
            return -1;
        }
        j1 = l + 1;
        if ((j & 4) == 0) goto _L6; else goto _L5
_L5:
        int l1;
        k = parseDigits(s, j1);
        l1 = k >> 16;
        l = k & 0xffff;
        if (l1 <= 0 || l1 > 12 || l != j1 + 2)
        {
            return -1;
        }
        calendar.set(2, l1 - 1);
        k = l;
        if ((j & 8) == 0) goto _L4; else goto _L7
_L7:
        k = l1;
_L9:
        if (l >= j2 || s.charAt(l) != '-')
        {
            return -1;
        }
        break; /* Loop/switch isn't completed */
_L6:
        k = -1;
        l = j1;
        if (true) goto _L9; else goto _L8
_L8:
        int i2 = l + 1;
        int k1 = parseDigits(s, i2);
        l = k1 >> 16;
        k1 &= 0xffff;
        if (l > 0 && k1 == i2 + 2)
        {
            if ((j & 4) == 0)
            {
                i = 31;
            } else
            {
                if ((j & 2) == 0)
                {
                    i = 2000;
                }
                i = daysInMonth(k - 1, i);
            }
            if (l <= i)
            {
                calendar.set(5, l);
                return k1;
            }
        }
        return -1;
    }

    int parseTime(String s, int i)
    {
        int j;
        int k;
        int i1;
        int j1;
        int k1;
        int l1;
        if (i < 0)
        {
            return i;
        }
        k1 = s.length();
        j = parseDigits(s, i);
        i1 = j >> 16;
        j &= 0xffff;
        if (i1 > 24 || j != i + 2 || j == k1 || s.charAt(j) != ':')
        {
            break MISSING_BLOCK_LABEL_366;
        }
        i = j + 1;
        j = parseDigits(s, i);
        j1 = j >> 16;
        j &= 0xffff;
        if (j1 >= 60 || j != i + 2 || j == k1 || s.charAt(j) != ':')
        {
            break MISSING_BLOCK_LABEL_366;
        }
        j++;
        i = parseDigits(s, j);
        l1 = i >> 16;
        i &= 0xffff;
        if (l1 >= 60 || i != j + 2)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        j = i;
        if (i + 1 >= k1)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        j = i;
        if (s.charAt(i) != '.')
        {
            break MISSING_BLOCK_LABEL_305;
        }
        j = i;
        if (Character.digit(s.charAt(i + 1), 10) < 0)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        j = i + 1;
        k = 0;
        i = 0;
_L2:
        int l;
        int i2;
label0:
        {
            if (j < k1)
            {
                i2 = Character.digit(s.charAt(j), 10);
                if (i2 >= 0)
                {
                    break label0;
                }
            }
            for (; i < 9; i++)
            {
                k *= 10;
            }

            break; /* Loop/switch isn't completed */
        }
        if (i >= 9)
        {
            break; /* Loop/switch isn't completed */
        }
        l = k * 10 + i2;
_L3:
        i++;
        j++;
        k = l;
        if (true) goto _L2; else goto _L1
_L1:
        l = k;
        if (i == 9)
        {
            l = k;
            if (i2 >= 5)
            {
                l = k + 1;
            }
        }
          goto _L3
        if (true) goto _L2; else goto _L4
_L4:
        nanoSeconds = k;
        if (i1 == 24 && (j1 != 0 || l1 != 0 || nanoSeconds != 0))
        {
            return -1;
        } else
        {
            calendar.set(11, i1);
            calendar.set(12, j1);
            calendar.set(13, l1);
            return j;
        }
        return -1;
    }

    int parseZone(String s, int i)
    {
        if (i >= 0)
        {
            int j = parseZoneMinutes(s, i);
            if (j == 0)
            {
                return -1;
            }
            if (j != i)
            {
                int k = j & 0xffff;
                if (j >> 16 == 0)
                {
                    s = GMT;
                } else
                {
                    s = TimeZone.getTimeZone((new StringBuilder()).append("GMT").append(s.substring(i, k)).toString());
                }
                calendar.setTimeZone(s);
                mask = mask | 0x80;
                return k;
            }
        }
        return i;
    }

    int parseZoneMinutes(String s, int i)
    {
        int l;
        boolean flag;
        flag = false;
        l = s.length();
        if (i != l && i >= 0) goto _L2; else goto _L1
_L1:
        int j = i;
_L4:
        return j;
_L2:
        int i1;
        int j1;
        char c;
        int k1;
        c = s.charAt(i);
        if (c == 'Z')
        {
            return i + 1;
        }
        if (c != '+' && c != '-')
        {
            return i;
        }
        i++;
        j1 = parseDigits(s, i);
        k1 = j1 >> 16;
        j = ((flag) ? 1 : 0);
        if (k1 > 14)
        {
            continue; /* Loop/switch isn't completed */
        }
        i1 = k1 * 60;
        j1 &= 0xffff;
        j = ((flag) ? 1 : 0);
        if (j1 != i + 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = ((flag) ? 1 : 0);
        if (j1 >= l)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = i1;
        l = j1;
        if (s.charAt(j1) != ':')
        {
            break; /* Loop/switch isn't completed */
        }
        j1++;
        i = parseDigits(s, j1);
        l = i & 0xffff;
        i >>= 16;
        if (i <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        j = ((flag) ? 1 : 0);
        if (i >= 60)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = ((flag) ? 1 : 0);
        if (k1 == 14) goto _L4; else goto _L3
_L3:
        i = i1 + i;
        j = ((flag) ? 1 : 0);
        if (l != j1 + 2) goto _L4; else goto _L5
_L5:
        j = ((flag) ? 1 : 0);
        if (i <= 840)
        {
            int k = i;
            if (c == '-')
            {
                k = -i;
            }
            return k << 16 | l;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void setTimeZone(TimeZone timezone)
    {
        calendar.setTimeZone(timezone);
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        toString(stringbuffer);
        return stringbuffer.toString();
    }

    public void toString(StringBuffer stringbuffer)
    {
        boolean flag1 = true;
        int i = components();
        boolean flag;
        if ((i & 0xe) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((i & 0x70) == 0)
        {
            flag1 = false;
        }
        if (flag)
        {
            toStringDate(stringbuffer);
            if (flag1)
            {
                stringbuffer.append('T');
            }
        }
        if (flag1)
        {
            toStringTime(stringbuffer);
        }
        toStringZone(stringbuffer);
    }

    public void toStringDate(StringBuffer stringbuffer)
    {
        int k = components();
        if ((k & 2) != 0)
        {
            int j = calendar.get(1);
            int i = j;
            if (calendar.get(0) == 0)
            {
                j--;
                i = j;
                if (j != 0)
                {
                    stringbuffer.append('-');
                    i = j;
                }
            }
            append(i, stringbuffer, 4);
        } else
        {
            stringbuffer.append('-');
        }
        if ((k & 0xc) != 0)
        {
            stringbuffer.append('-');
            if ((k & 4) != 0)
            {
                append(getMonth(), stringbuffer, 2);
            }
            if ((k & 8) != 0)
            {
                stringbuffer.append('-');
                append(getDay(), stringbuffer, 2);
            }
        }
    }

    public void toStringTime(StringBuffer stringbuffer)
    {
        append(getHours(), stringbuffer, 2);
        stringbuffer.append(':');
        append(getMinutes(), stringbuffer, 2);
        stringbuffer.append(':');
        append(getWholeSeconds(), stringbuffer, 2);
        Duration.appendNanoSeconds(nanoSeconds, stringbuffer);
    }

    public void toStringZone(StringBuffer stringbuffer)
    {
        if (isZoneUnspecified())
        {
            return;
        } else
        {
            toStringZone(getZoneMinutes(), stringbuffer);
            return;
        }
    }

    public Unit unit()
    {
        return unit;
    }

    public DateTime withZoneUnspecified()
    {
        if (isZoneUnspecified())
        {
            return this;
        } else
        {
            DateTime datetime = new DateTime(mask, (GregorianCalendar)calendar.clone());
            datetime.calendar.setTimeZone(TimeZone.getDefault());
            datetime.mask = datetime.mask & 0xffffff7f;
            return datetime;
        }
    }

}
