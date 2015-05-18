// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.math.DateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

// Referenced classes of package gnu.kawa.xml:
//            XDataType

public class XTimeType extends XDataType
{

    public static final XTimeType dateTimeType = new XTimeType("dateTime", 20);
    public static final XTimeType dateType = new XTimeType("date", 21);
    private static TimeZone fixedTimeZone;
    public static final XTimeType gDayType = new XTimeType("gDay", 26);
    public static final XTimeType gMonthDayType = new XTimeType("gMonthDay", 25);
    public static final XTimeType gMonthType = new XTimeType("gMonth", 27);
    public static final XTimeType gYearMonthType = new XTimeType("gYearMonth", 23);
    public static final XTimeType gYearType = new XTimeType("gYear", 24);
    public static final XTimeType timeType = new XTimeType("time", 22);
    static ClassType typeDateTime = ClassType.make("gnu.math.DateTime");

    XTimeType(String s, int i)
    {
        super(s, typeDateTime, i);
    }

    static int components(int i)
    {
        byte byte0 = 126;
        switch (i)
        {
        default:
            byte0 = 0;
            // fall through

        case 20: // '\024'
        case 28: // '\034'
            return byte0;

        case 21: // '\025'
            return 14;

        case 22: // '\026'
            return 112;

        case 23: // '\027'
            return 6;

        case 24: // '\030'
            return 2;

        case 25: // '\031'
            return 12;

        case 26: // '\032'
            return 8;

        case 27: // '\033'
            return 4;

        case 29: // '\035'
            return 6;

        case 30: // '\036'
            return 120;
        }
    }

    private static TimeZone fixedTimeZone()
    {
        gnu/kawa/xml/XTimeType;
        JVM INSTR monitorenter ;
        TimeZone timezone;
        if (fixedTimeZone == null)
        {
            fixedTimeZone = DateTime.minutesToTimeZone(TimeZone.getDefault().getRawOffset() / 60000);
        }
        timezone = fixedTimeZone;
        gnu/kawa/xml/XTimeType;
        JVM INSTR monitorexit ;
        return timezone;
        Exception exception;
        exception;
        throw exception;
    }

    public static DateTime parseDateTime(String s, int i)
    {
        s = DateTime.parse(s, i);
        if (s.isZoneUnspecified())
        {
            s.setTimeZone(fixedTimeZone());
        }
        return s;
    }

    public boolean isInstance(Object obj)
    {
        while (!(obj instanceof DateTime) || components(typeCode) != ((DateTime)obj).components()) 
        {
            return false;
        }
        return true;
    }

    public DateTime now()
    {
        return new DateTime(components(typeCode) | 0x80, (GregorianCalendar)Calendar.getInstance(fixedTimeZone()));
    }

    public Object valueOf(String s)
    {
        return parseDateTime(s, components(typeCode));
    }

}
