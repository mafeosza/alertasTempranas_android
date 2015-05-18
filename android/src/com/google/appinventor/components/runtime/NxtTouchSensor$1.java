// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime:
//            NxtTouchSensor, BluetoothClient

class this._cls0
    implements Runnable
{

    final NxtTouchSensor this$0;

    public void run()
    {
        if (bluetooth != null && bluetooth.IsConnected())
        {
            Object obj = NxtTouchSensor.access$000(NxtTouchSensor.this, "");
            if (((Sensor.SensorValue) (obj)).valid)
            {
                if (((Boolean)((Sensor.SensorValue) (obj)).value).booleanValue())
                {
                    obj = ate.PRESSED;
                } else
                {
                    obj = ate.RELEASED;
                }
                if (obj != NxtTouchSensor.access$100(NxtTouchSensor.this))
                {
                    if (obj == ate.PRESSED && NxtTouchSensor.access$200(NxtTouchSensor.this))
                    {
                        Pressed();
                    }
                    if (obj == ate.RELEASED && NxtTouchSensor.access$300(NxtTouchSensor.this))
                    {
                        Released();
                    }
                }
                NxtTouchSensor.access$102(NxtTouchSensor.this, ((ate) (obj)));
            }
        }
        if (NxtTouchSensor.access$400(NxtTouchSensor.this))
        {
            NxtTouchSensor.access$600(NxtTouchSensor.this).post(NxtTouchSensor.access$500(NxtTouchSensor.this));
        }
    }

    ate()
    {
        this$0 = NxtTouchSensor.this;
        super();
    }
}
