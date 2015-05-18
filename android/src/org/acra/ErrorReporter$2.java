// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.text.format.Time;
import android.util.Log;

// Referenced classes of package org.acra:
//            ErrorReporter, ACRA

class this._cls0 extends Thread
{

    final ErrorReporter this$0;

    public void run()
    {
        Time time1 = new Time();
        Time time = new Time();
        time1.setToNow();
        long l1 = time1.toMillis(false);
        long l = 0L;
        while (l < 3000L) 
        {
            try
            {
                Thread.sleep(3000L);
            }
            catch (InterruptedException interruptedexception)
            {
                Log.d(ACRA.LOG_TAG, "Interrupted while waiting for Toast to end.", interruptedexception);
            }
            time.setToNow();
            l = time.toMillis(false) - l1;
        }
        boolean _tmp = ErrorReporter.access$102(true);
    }

    ption()
    {
        this$0 = ErrorReporter.this;
        super();
    }
}
