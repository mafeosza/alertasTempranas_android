// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.Dates;
import com.google.appinventor.components.runtime.util.TimerInternal;
import java.util.Calendar;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, AlarmHandler, OnStopListener, 
//            OnResumeListener, OnDestroyListener, Deleteable, ComponentContainer, 
//            Form, ReplForm, EventDispatcher

public final class Clock extends AndroidNonvisibleComponent
    implements Component, AlarmHandler, OnStopListener, OnResumeListener, OnDestroyListener, Deleteable
{

    private static final boolean DEFAULT_ENABLED = true;
    private static final int DEFAULT_INTERVAL = 1000;
    private boolean onScreen;
    private boolean timerAlwaysFires;
    private TimerInternal timerInternal;

    public Clock()
    {
        super(null);
        timerAlwaysFires = true;
        onScreen = false;
    }

    public Clock(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        timerAlwaysFires = true;
        onScreen = false;
        timerInternal = new TimerInternal(this, true, 1000);
        form.registerForOnResume(this);
        form.registerForOnStop(this);
        form.registerForOnDestroy(this);
        if (form instanceof ReplForm)
        {
            onScreen = true;
        }
    }

    public static Calendar AddDays(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 5, i);
        return calendar;
    }

    public static Calendar AddHours(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 11, i);
        return calendar;
    }

    public static Calendar AddMinutes(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 12, i);
        return calendar;
    }

    public static Calendar AddMonths(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 2, i);
        return calendar;
    }

    public static Calendar AddSeconds(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 13, i);
        return calendar;
    }

    public static Calendar AddWeeks(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 3, i);
        return calendar;
    }

    public static Calendar AddYears(Calendar calendar, int i)
    {
        calendar = (Calendar)calendar.clone();
        Dates.DateAdd(calendar, 1, i);
        return calendar;
    }

    public static int DayOfMonth(Calendar calendar)
    {
        return Dates.Day(calendar);
    }

    public static long Duration(Calendar calendar, Calendar calendar1)
    {
        return calendar1.getTimeInMillis() - calendar.getTimeInMillis();
    }

    public static String FormatDate(Calendar calendar)
    {
        return Dates.FormatDate(calendar);
    }

    public static String FormatDateTime(Calendar calendar)
    {
        return Dates.FormatDateTime(calendar);
    }

    public static String FormatTime(Calendar calendar)
    {
        return Dates.FormatTime(calendar);
    }

    public static long GetMillis(Calendar calendar)
    {
        return calendar.getTimeInMillis();
    }

    public static int Hour(Calendar calendar)
    {
        return Dates.Hour(calendar);
    }

    public static Calendar MakeInstant(String s)
    {
        try
        {
            s = Dates.DateValue(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new YailRuntimeError("Argument to MakeInstant should have form MM/DD/YYYY, hh:mm:ss, or MM/DD/YYYY or hh:mm", "Sorry to be so picky.");
        }
        return s;
    }

    public static Calendar MakeInstantFromMillis(long l)
    {
        Calendar calendar = Dates.Now();
        calendar.setTimeInMillis(l);
        return calendar;
    }

    public static int Minute(Calendar calendar)
    {
        return Dates.Minute(calendar);
    }

    public static int Month(Calendar calendar)
    {
        return Dates.Month(calendar) + 1;
    }

    public static String MonthName(Calendar calendar)
    {
        return Dates.MonthName(calendar);
    }

    public static Calendar Now()
    {
        return Dates.Now();
    }

    public static int Second(Calendar calendar)
    {
        return Dates.Second(calendar);
    }

    public static long SystemTime()
    {
        return Dates.Timer();
    }

    public static int Weekday(Calendar calendar)
    {
        return Dates.Weekday(calendar);
    }

    public static String WeekdayName(Calendar calendar)
    {
        return Dates.WeekdayName(calendar);
    }

    public static int Year(Calendar calendar)
    {
        return Dates.Year(calendar);
    }

    public void Timer()
    {
        if (timerAlwaysFires || onScreen)
        {
            EventDispatcher.dispatchEvent(this, "Timer", new Object[0]);
        }
    }

    public void TimerAlwaysFires(boolean flag)
    {
        timerAlwaysFires = flag;
    }

    public boolean TimerAlwaysFires()
    {
        return timerAlwaysFires;
    }

    public void TimerEnabled(boolean flag)
    {
        timerInternal.Enabled(flag);
    }

    public boolean TimerEnabled()
    {
        return timerInternal.Enabled();
    }

    public int TimerInterval()
    {
        return timerInternal.Interval();
    }

    public void TimerInterval(int i)
    {
        timerInternal.Interval(i);
    }

    public void alarm()
    {
        Timer();
    }

    public void onDelete()
    {
        timerInternal.Enabled(false);
    }

    public void onDestroy()
    {
        timerInternal.Enabled(false);
    }

    public void onResume()
    {
        onScreen = true;
    }

    public void onStop()
    {
        onScreen = false;
    }
}
