// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.os.Handler;
import com.google.appinventor.components.runtime.AlarmHandler;

public final class TimerInternal
    implements Runnable
{

    private AlarmHandler component;
    private boolean enabled;
    private Handler handler;
    private int interval;

    public TimerInternal(AlarmHandler alarmhandler, boolean flag, int i)
    {
        this(alarmhandler, flag, i, new Handler());
    }

    public TimerInternal(AlarmHandler alarmhandler, boolean flag, int i, Handler handler1)
    {
        handler = handler1;
        component = alarmhandler;
        enabled = flag;
        interval = i;
        if (flag)
        {
            handler1.postDelayed(this, i);
        }
    }

    public void Enabled(boolean flag)
    {
        if (enabled)
        {
            handler.removeCallbacks(this);
        }
        enabled = flag;
        if (flag)
        {
            handler.postDelayed(this, interval);
        }
    }

    public boolean Enabled()
    {
        return enabled;
    }

    public int Interval()
    {
        return interval;
    }

    public void Interval(int i)
    {
        interval = i;
        if (enabled)
        {
            handler.removeCallbacks(this);
            handler.postDelayed(this, i);
        }
    }

    public void run()
    {
        if (enabled)
        {
            component.alarm();
            if (enabled)
            {
                handler.postDelayed(this, interval);
            }
        }
    }
}
