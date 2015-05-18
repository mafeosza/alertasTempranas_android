// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.TimePickerDialog;
import android.os.Handler;
import java.util.Calendar;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ButtonBase, ComponentContainer, EventDispatcher, Form

public class TimePicker extends ButtonBase
{

    private Handler androidUIHandler;
    private boolean customTime;
    private Form form;
    private int hour;
    private int minute;
    private TimePickerDialog time;
    private android.app.TimePickerDialog.OnTimeSetListener timePickerListener;

    public TimePicker(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        hour = 0;
        minute = 0;
        customTime = false;
        timePickerListener = new android.app.TimePickerDialog.OnTimeSetListener() {

            final TimePicker this$0;

            public void onTimeSet(android.widget.TimePicker timepicker, int i, int j)
            {
                if (timepicker.isShown())
                {
                    hour = i;
                    minute = j;
                    androidUIHandler.post(new Runnable() {

                        final _cls1 this$1;

                        public void run()
                        {
                            AfterTimeSet();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                }
            }

            
            {
                this$0 = TimePicker.this;
                super();
            }
        };
        form = componentcontainer.$form();
        componentcontainer = Calendar.getInstance();
        hour = componentcontainer.get(11);
        minute = componentcontainer.get(12);
        time = new TimePickerDialog(container.$context(), timePickerListener, hour, minute, false);
        androidUIHandler = new Handler();
    }

    public void AfterTimeSet()
    {
        EventDispatcher.dispatchEvent(this, "AfterTimeSet", new Object[0]);
    }

    public int Hour()
    {
        return hour;
    }

    public void LaunchPicker()
    {
        click();
    }

    public int Minute()
    {
        return minute;
    }

    public void SetTimeToDisplay(int i, int j)
    {
        if (i < 0 || i > 23)
        {
            form.dispatchErrorOccurredEvent(this, "SetTimeToDisplay", 2301, new Object[0]);
            return;
        }
        if (j < 0 || j > 59)
        {
            form.dispatchErrorOccurredEvent(this, "SetTimeToDisplay", 2302, new Object[0]);
            return;
        } else
        {
            time.updateTime(i, j);
            customTime = true;
            return;
        }
    }

    public void click()
    {
        if (!customTime)
        {
            Calendar calendar = Calendar.getInstance();
            int i = calendar.get(11);
            int j = calendar.get(12);
            time.updateTime(i, j);
        } else
        {
            customTime = false;
        }
        time.show();
    }


/*
    static int access$002(TimePicker timepicker, int i)
    {
        timepicker.hour = i;
        return i;
    }

*/


/*
    static int access$102(TimePicker timepicker, int i)
    {
        timepicker.minute = i;
        return i;
    }

*/

}
