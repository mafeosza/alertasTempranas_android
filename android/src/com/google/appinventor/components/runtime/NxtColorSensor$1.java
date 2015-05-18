// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime:
//            NxtColorSensor, BluetoothClient

class this._cls0
    implements Runnable
{

    final NxtColorSensor this$0;

    public void run()
    {
        if (bluetooth == null || !bluetooth.IsConnected()) goto _L2; else goto _L1
_L1:
        if (!NxtColorSensor.access$000(NxtColorSensor.this)) goto _L4; else goto _L3
_L3:
        Sensor.SensorValue sensorvalue = NxtColorSensor.access$100(NxtColorSensor.this, "");
        if (sensorvalue.valid)
        {
            int i = ((Integer)sensorvalue.value).intValue();
            if (i != NxtColorSensor.access$200(NxtColorSensor.this))
            {
                ColorChanged(i);
            }
            NxtColorSensor.access$202(NxtColorSensor.this, i);
        }
_L2:
        if (NxtColorSensor.access$1000(NxtColorSensor.this))
        {
            NxtColorSensor.access$1200(NxtColorSensor.this).post(NxtColorSensor.access$1100(NxtColorSensor.this));
        }
        return;
_L4:
        Object obj;
        obj = NxtColorSensor.access$300(NxtColorSensor.this, "");
        if (!((Sensor.SensorValue) (obj)).valid)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Integer)((Sensor.SensorValue) (obj)).value).intValue() >= NxtColorSensor.access$400(NxtColorSensor.this))
        {
            break; /* Loop/switch isn't completed */
        }
        obj = ate.BELOW_RANGE;
_L6:
        if (obj != NxtColorSensor.access$600(NxtColorSensor.this))
        {
            if (obj == ate.BELOW_RANGE && NxtColorSensor.access$700(NxtColorSensor.this))
            {
                BelowRange();
            }
            if (obj == ate.WITHIN_RANGE && NxtColorSensor.access$800(NxtColorSensor.this))
            {
                WithinRange();
            }
            if (obj == ate.ABOVE_RANGE && NxtColorSensor.access$900(NxtColorSensor.this))
            {
                AboveRange();
            }
        }
        NxtColorSensor.access$602(NxtColorSensor.this, ((ate) (obj)));
        if (true) goto _L2; else goto _L5
_L5:
        if (((Integer)((Sensor.SensorValue) (obj)).value).intValue() > NxtColorSensor.access$500(NxtColorSensor.this))
        {
            obj = ate.ABOVE_RANGE;
        } else
        {
            obj = ate.WITHIN_RANGE;
        }
          goto _L6
        if (true) goto _L2; else goto _L7
_L7:
    }

    ate()
    {
        this$0 = NxtColorSensor.this;
        super();
    }
}
