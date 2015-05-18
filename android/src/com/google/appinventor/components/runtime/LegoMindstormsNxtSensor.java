// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtBase, BluetoothClient, Form, ComponentContainer, 
//            BluetoothConnectionBase

public abstract class LegoMindstormsNxtSensor extends LegoMindstormsNxtBase
{
    static class SensorValue
    {

        final boolean valid;
        final Object value;

        SensorValue(boolean flag, Object obj)
        {
            valid = flag;
            value = obj;
        }
    }


    static final int SENSOR_MODE_ANGLESTEPMODE = 224;
    static final int SENSOR_MODE_BOOLEANMODE = 32;
    static final int SENSOR_MODE_CELSIUSMODE = 160;
    static final int SENSOR_MODE_FAHRENHEITMODE = 192;
    static final int SENSOR_MODE_MASK_MODE = 224;
    static final int SENSOR_MODE_MASK_SLOPE = 31;
    static final int SENSOR_MODE_PCTFULLSCALEMODE = 128;
    static final int SENSOR_MODE_PERIODCOUNTERMODE = 96;
    static final int SENSOR_MODE_RAWMODE = 0;
    static final int SENSOR_MODE_TRANSITIONCNTMODE = 64;
    static final int SENSOR_TYPE_ANGLE = 4;
    static final int SENSOR_TYPE_CUSTOM = 9;
    static final int SENSOR_TYPE_LIGHT_ACTIVE = 5;
    static final int SENSOR_TYPE_LIGHT_INACTIVE = 6;
    static final int SENSOR_TYPE_LOWSPEED = 10;
    static final int SENSOR_TYPE_LOWSPEED_9V = 11;
    static final int SENSOR_TYPE_NO_SENSOR = 0;
    static final int SENSOR_TYPE_REFLECTION = 3;
    static final int SENSOR_TYPE_SOUND_DB = 7;
    static final int SENSOR_TYPE_SOUND_DBA = 8;
    static final int SENSOR_TYPE_SWITCH = 1;
    static final int SENSOR_TYPE_TEMPERATURE = 2;
    protected int port;
    private String sensorPortLetter;

    protected LegoMindstormsNxtSensor(ComponentContainer componentcontainer, String s)
    {
        super(componentcontainer, s);
    }

    public String SensorPort()
    {
        return sensorPortLetter;
    }

    public abstract void SensorPort(String s);

    public void afterConnect(BluetoothConnectionBase bluetoothconnectionbase)
    {
        initializeSensor("Connect");
    }

    protected abstract void initializeSensor(String s);

    protected final void setSensorPort(String s)
    {
        int i;
        try
        {
            i = convertSensorPortLetterToNumber(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "SensorPort", 408, new Object[] {
                s
            });
            return;
        }
        sensorPortLetter = s;
        port = i;
        if (bluetooth != null && bluetooth.IsConnected())
        {
            initializeSensor("SensorPort");
        }
    }
}
