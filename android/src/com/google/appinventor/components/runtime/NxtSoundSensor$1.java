// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime:
//            NxtSoundSensor, BluetoothClient

class this._cls0
    implements Runnable
{

    final NxtSoundSensor this$0;

    public void run()
    {
        if (bluetooth != null && bluetooth.IsConnected())
        {
            Object obj = NxtSoundSensor.access$000(NxtSoundSensor.this, "");
            if (((Sensor.SensorValue) (obj)).valid)
            {
                if (((Integer)((Sensor.SensorValue) (obj)).value).intValue() < NxtSoundSensor.access$100(NxtSoundSensor.this))
                {
                    obj = ate.BELOW_RANGE;
                } else
                if (((Integer)((Sensor.SensorValue) (obj)).value).intValue() > NxtSoundSensor.access$200(NxtSoundSensor.this))
                {
                    obj = ate.ABOVE_RANGE;
                } else
                {
                    obj = ate.WITHIN_RANGE;
                }
                if (obj != NxtSoundSensor.access$300(NxtSoundSensor.this))
                {
                    if (obj == ate.BELOW_RANGE && NxtSoundSensor.access$400(NxtSoundSensor.this))
                    {
                        BelowRange();
                    }
                    if (obj == ate.WITHIN_RANGE && NxtSoundSensor.access$500(NxtSoundSensor.this))
                    {
                        WithinRange();
                    }
                    if (obj == ate.ABOVE_RANGE && NxtSoundSensor.access$600(NxtSoundSensor.this))
                    {
                        AboveRange();
                    }
                }
                NxtSoundSensor.access$302(NxtSoundSensor.this, ((ate) (obj)));
            }
        }
        if (NxtSoundSensor.access$700(NxtSoundSensor.this))
        {
            NxtSoundSensor.access$900(NxtSoundSensor.this).post(NxtSoundSensor.access$800(NxtSoundSensor.this));
        }
    }

    ate()
    {
        this$0 = NxtSoundSensor.this;
        super();
    }
}
