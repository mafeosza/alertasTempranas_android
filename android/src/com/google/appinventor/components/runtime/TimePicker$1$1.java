// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import android.widget.TimePicker;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TimePicker

class this._cls1
    implements Runnable
{

    final rTimeSet this$1;

    public void run()
    {
        AfterTimeSet();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/TimePicker$1

/* anonymous class */
    class TimePicker._cls1
        implements android.app.TimePickerDialog.OnTimeSetListener
    {

        final com.google.appinventor.components.runtime.TimePicker this$0;

        public void onTimeSet(TimePicker timepicker, int i, int j)
        {
            if (timepicker.isShown())
            {
                TimePicker.access$002(com.google.appinventor.components.runtime.TimePicker.this, i);
                TimePicker.access$102(com.google.appinventor.components.runtime.TimePicker.this, j);
                TimePicker.access$200(com.google.appinventor.components.runtime.TimePicker.this).post(new TimePicker._cls1._cls1());
            }
        }

            
            {
                this$0 = com.google.appinventor.components.runtime.TimePicker.this;
                super();
            }
    }

}
