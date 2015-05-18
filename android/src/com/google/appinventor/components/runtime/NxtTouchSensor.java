// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtSensor, Deleteable, EventDispatcher, ComponentContainer, 
//            BluetoothClient

public class NxtTouchSensor extends LegoMindstormsNxtSensor
    implements Deleteable
{
    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State PRESSED;
        public static final State RELEASED;
        public static final State UNKNOWN;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/google/appinventor/components/runtime/NxtTouchSensor$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new State("UNKNOWN", 0);
            PRESSED = new State("PRESSED", 1);
            RELEASED = new State("RELEASED", 2);
            $VALUES = (new State[] {
                UNKNOWN, PRESSED, RELEASED
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String DEFAULT_SENSOR_PORT = "1";
    private Handler handler;
    private boolean pressedEventEnabled;
    private State previousState;
    private boolean releasedEventEnabled;
    private final Runnable sensorReader = new Runnable() {

        final NxtTouchSensor this$0;

        public void run()
        {
            if (bluetooth != null && bluetooth.IsConnected())
            {
                Object obj = getPressedValue("");
                if (((LegoMindstormsNxtSensor.SensorValue) (obj)).valid)
                {
                    if (((Boolean)((LegoMindstormsNxtSensor.SensorValue) (obj)).value).booleanValue())
                    {
                        obj = State.PRESSED;
                    } else
                    {
                        obj = State.RELEASED;
                    }
                    if (obj != previousState)
                    {
                        if (obj == State.PRESSED && pressedEventEnabled)
                        {
                            Pressed();
                        }
                        if (obj == State.RELEASED && releasedEventEnabled)
                        {
                            Released();
                        }
                    }
                    previousState = ((State) (obj));
                }
            }
            if (isHandlerNeeded())
            {
                handler.post(sensorReader);
            }
        }

            
            {
                this$0 = NxtTouchSensor.this;
                super();
            }
    };

    public NxtTouchSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "NxtTouchSensor");
        handler = new Handler();
        previousState = State.UNKNOWN;
        SensorPort("1");
        PressedEventEnabled(false);
        ReleasedEventEnabled(false);
    }

    private LegoMindstormsNxtSensor.SensorValue getPressedValue(String s)
    {
        boolean flag = false;
        s = getInputValues(s, port);
        if (s != null && getBooleanValueFromBytes(s, 4))
        {
            if (getSWORDValueFromBytes(s, 12) != 0)
            {
                flag = true;
            }
            return new LegoMindstormsNxtSensor.SensorValue(true, Boolean.valueOf(flag));
        } else
        {
            return new LegoMindstormsNxtSensor.SensorValue(false, null);
        }
    }

    private boolean isHandlerNeeded()
    {
        return pressedEventEnabled || releasedEventEnabled;
    }

    public boolean IsPressed()
    {
        LegoMindstormsNxtSensor.SensorValue sensorvalue;
        if (checkBluetooth("IsPressed"))
        {
            if ((sensorvalue = getPressedValue("IsPressed")).valid)
            {
                return ((Boolean)sensorvalue.value).booleanValue();
            }
        }
        return false;
    }

    public void Pressed()
    {
        EventDispatcher.dispatchEvent(this, "Pressed", new Object[0]);
    }

    public void PressedEventEnabled(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        pressedEventEnabled = flag;
        flag = isHandlerNeeded();
        if (flag1 && !flag)
        {
            handler.removeCallbacks(sensorReader);
        }
        if (!flag1 && flag)
        {
            previousState = State.UNKNOWN;
            handler.post(sensorReader);
        }
    }

    public boolean PressedEventEnabled()
    {
        return pressedEventEnabled;
    }

    public void Released()
    {
        EventDispatcher.dispatchEvent(this, "Released", new Object[0]);
    }

    public void ReleasedEventEnabled(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        releasedEventEnabled = flag;
        flag = isHandlerNeeded();
        if (flag1 && !flag)
        {
            handler.removeCallbacks(sensorReader);
        }
        if (!flag1 && flag)
        {
            previousState = State.UNKNOWN;
            handler.post(sensorReader);
        }
    }

    public boolean ReleasedEventEnabled()
    {
        return releasedEventEnabled;
    }

    public void SensorPort(String s)
    {
        setSensorPort(s);
    }

    protected void initializeSensor(String s)
    {
        setInputMode(s, port, 1, 32);
    }

    public void onDelete()
    {
        handler.removeCallbacks(sensorReader);
        super.onDelete();
    }




/*
    static State access$102(NxtTouchSensor nxttouchsensor, State state)
    {
        nxttouchsensor.previousState = state;
        return state;
    }

*/





}
