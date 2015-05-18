// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtSensor, Deleteable, EventDispatcher, BluetoothClient, 
//            ComponentContainer

public class NxtLightSensor extends LegoMindstormsNxtSensor
    implements Deleteable
{
    private static final class State extends Enum
    {

        private static final State $VALUES[];
        public static final State ABOVE_RANGE;
        public static final State BELOW_RANGE;
        public static final State UNKNOWN;
        public static final State WITHIN_RANGE;

        public static State valueOf(String s)
        {
            return (State)Enum.valueOf(com/google/appinventor/components/runtime/NxtLightSensor$State, s);
        }

        public static State[] values()
        {
            return (State[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new State("UNKNOWN", 0);
            BELOW_RANGE = new State("BELOW_RANGE", 1);
            WITHIN_RANGE = new State("WITHIN_RANGE", 2);
            ABOVE_RANGE = new State("ABOVE_RANGE", 3);
            $VALUES = (new State[] {
                UNKNOWN, BELOW_RANGE, WITHIN_RANGE, ABOVE_RANGE
            });
        }

        private State(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int DEFAULT_BOTTOM_OF_RANGE = 256;
    private static final String DEFAULT_SENSOR_PORT = "3";
    private static final int DEFAULT_TOP_OF_RANGE = 767;
    private boolean aboveRangeEventEnabled;
    private boolean belowRangeEventEnabled;
    private int bottomOfRange;
    private boolean generateLight;
    private Handler handler;
    private State previousState;
    private final Runnable sensorReader = new Runnable() {

        final NxtLightSensor this$0;

        public void run()
        {
            if (bluetooth != null && bluetooth.IsConnected())
            {
                Object obj = getLightValue("");
                if (((LegoMindstormsNxtSensor.SensorValue) (obj)).valid)
                {
                    if (((Integer)((LegoMindstormsNxtSensor.SensorValue) (obj)).value).intValue() < bottomOfRange)
                    {
                        obj = State.BELOW_RANGE;
                    } else
                    if (((Integer)((LegoMindstormsNxtSensor.SensorValue) (obj)).value).intValue() > topOfRange)
                    {
                        obj = State.ABOVE_RANGE;
                    } else
                    {
                        obj = State.WITHIN_RANGE;
                    }
                    if (obj != previousState)
                    {
                        if (obj == State.BELOW_RANGE && belowRangeEventEnabled)
                        {
                            BelowRange();
                        }
                        if (obj == State.WITHIN_RANGE && withinRangeEventEnabled)
                        {
                            WithinRange();
                        }
                        if (obj == State.ABOVE_RANGE && aboveRangeEventEnabled)
                        {
                            AboveRange();
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
                this$0 = NxtLightSensor.this;
                super();
            }
    };
    private int topOfRange;
    private boolean withinRangeEventEnabled;

    public NxtLightSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "NxtLightSensor");
        handler = new Handler();
        previousState = State.UNKNOWN;
        SensorPort("3");
        BottomOfRange(256);
        TopOfRange(767);
        BelowRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
        GenerateLight(false);
    }

    private LegoMindstormsNxtSensor.SensorValue getLightValue(String s)
    {
        s = getInputValues(s, port);
        if (s != null && getBooleanValueFromBytes(s, 4))
        {
            return new LegoMindstormsNxtSensor.SensorValue(true, Integer.valueOf(getUWORDValueFromBytes(s, 10)));
        } else
        {
            return new LegoMindstormsNxtSensor.SensorValue(false, null);
        }
    }

    private boolean isHandlerNeeded()
    {
        return belowRangeEventEnabled || withinRangeEventEnabled || aboveRangeEventEnabled;
    }

    public void AboveRange()
    {
        EventDispatcher.dispatchEvent(this, "AboveRange", new Object[0]);
    }

    public void AboveRangeEventEnabled(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        aboveRangeEventEnabled = flag;
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

    public boolean AboveRangeEventEnabled()
    {
        return aboveRangeEventEnabled;
    }

    public void BelowRange()
    {
        EventDispatcher.dispatchEvent(this, "BelowRange", new Object[0]);
    }

    public void BelowRangeEventEnabled(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        belowRangeEventEnabled = flag;
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

    public boolean BelowRangeEventEnabled()
    {
        return belowRangeEventEnabled;
    }

    public int BottomOfRange()
    {
        return bottomOfRange;
    }

    public void BottomOfRange(int i)
    {
        bottomOfRange = i;
        previousState = State.UNKNOWN;
    }

    public void GenerateLight(boolean flag)
    {
        generateLight = flag;
        if (bluetooth != null && bluetooth.IsConnected())
        {
            initializeSensor("GenerateLight");
        }
    }

    public boolean GenerateLight()
    {
        return generateLight;
    }

    public int GetLightLevel()
    {
        LegoMindstormsNxtSensor.SensorValue sensorvalue;
        if (checkBluetooth("GetLightLevel"))
        {
            if ((sensorvalue = getLightValue("GetLightLevel")).valid)
            {
                return ((Integer)sensorvalue.value).intValue();
            }
        }
        return -1;
    }

    public void SensorPort(String s)
    {
        setSensorPort(s);
    }

    public int TopOfRange()
    {
        return topOfRange;
    }

    public void TopOfRange(int i)
    {
        topOfRange = i;
        previousState = State.UNKNOWN;
    }

    public void WithinRange()
    {
        EventDispatcher.dispatchEvent(this, "WithinRange", new Object[0]);
    }

    public void WithinRangeEventEnabled(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        withinRangeEventEnabled = flag;
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

    public boolean WithinRangeEventEnabled()
    {
        return withinRangeEventEnabled;
    }

    protected void initializeSensor(String s)
    {
        int i = port;
        byte byte0;
        if (generateLight)
        {
            byte0 = 5;
        } else
        {
            byte0 = 6;
        }
        setInputMode(s, i, byte0, 128);
    }

    public void onDelete()
    {
        handler.removeCallbacks(sensorReader);
        super.onDelete();
    }






/*
    static State access$302(NxtLightSensor nxtlightsensor, State state)
    {
        nxtlightsensor.previousState = state;
        return state;
    }

*/






}
