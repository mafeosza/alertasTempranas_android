// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtSensor, Deleteable, EventDispatcher, BluetoothClient, 
//            Form, ComponentContainer

public class NxtColorSensor extends LegoMindstormsNxtSensor
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
            return (State)Enum.valueOf(com/google/appinventor/components/runtime/NxtColorSensor$State, s);
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
    static final int SENSOR_TYPE_COLOR_BLUE = 16;
    static final int SENSOR_TYPE_COLOR_FULL = 13;
    static final int SENSOR_TYPE_COLOR_GREEN = 15;
    static final int SENSOR_TYPE_COLOR_NONE = 17;
    static final int SENSOR_TYPE_COLOR_RED = 14;
    private static final Map mapColorToSensorType;
    private static final Map mapSensorValueToColor;
    private boolean aboveRangeEventEnabled;
    private boolean belowRangeEventEnabled;
    private int bottomOfRange;
    private boolean colorChangedEventEnabled;
    private boolean detectColor;
    private int generateColor;
    private Handler handler;
    private int previousColor;
    private State previousState;
    private final Runnable sensorReader = new Runnable() {

        final NxtColorSensor this$0;

        public void run()
        {
            if (bluetooth == null || !bluetooth.IsConnected()) goto _L2; else goto _L1
_L1:
            if (!detectColor) goto _L4; else goto _L3
_L3:
            LegoMindstormsNxtSensor.SensorValue sensorvalue = getColorValue("");
            if (sensorvalue.valid)
            {
                int i = ((Integer)sensorvalue.value).intValue();
                if (i != previousColor)
                {
                    ColorChanged(i);
                }
                previousColor = i;
            }
_L2:
            if (isHandlerNeeded())
            {
                handler.post(sensorReader);
            }
            return;
_L4:
            Object obj;
            obj = getLightValue("");
            if (!((LegoMindstormsNxtSensor.SensorValue) (obj)).valid)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((Integer)((LegoMindstormsNxtSensor.SensorValue) (obj)).value).intValue() >= bottomOfRange)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = State.BELOW_RANGE;
_L6:
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
            if (true) goto _L2; else goto _L5
_L5:
            if (((Integer)((LegoMindstormsNxtSensor.SensorValue) (obj)).value).intValue() > topOfRange)
            {
                obj = State.ABOVE_RANGE;
            } else
            {
                obj = State.WITHIN_RANGE;
            }
              goto _L6
            if (true) goto _L2; else goto _L7
_L7:
        }

            
            {
                this$0 = NxtColorSensor.this;
                super();
            }
    };
    private int topOfRange;
    private boolean withinRangeEventEnabled;

    public NxtColorSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "NxtColorSensor");
        handler = new Handler();
        previousState = State.UNKNOWN;
        previousColor = 0xffffff;
        SensorPort("3");
        DetectColor(true);
        ColorChangedEventEnabled(false);
        BottomOfRange(256);
        TopOfRange(767);
        BelowRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
        GenerateColor(0xffffff);
    }

    private LegoMindstormsNxtSensor.SensorValue getColorValue(String s)
    {
        s = getInputValues(s, port);
        if (s != null && getBooleanValueFromBytes(s, 4))
        {
            int i = getSWORDValueFromBytes(s, 12);
            if (mapSensorValueToColor.containsKey(Integer.valueOf(i)))
            {
                return new LegoMindstormsNxtSensor.SensorValue(true, Integer.valueOf(((Integer)mapSensorValueToColor.get(Integer.valueOf(i))).intValue()));
            }
        }
        return new LegoMindstormsNxtSensor.SensorValue(false, null);
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
        if (detectColor)
        {
            return colorChangedEventEnabled;
        }
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

    public void ColorChanged(int i)
    {
        EventDispatcher.dispatchEvent(this, "ColorChanged", new Object[] {
            Integer.valueOf(i)
        });
    }

    public void ColorChangedEventEnabled(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        colorChangedEventEnabled = flag;
        flag = isHandlerNeeded();
        if (flag1 && !flag)
        {
            handler.removeCallbacks(sensorReader);
        }
        if (!flag1 && flag)
        {
            previousColor = 0xffffff;
            handler.post(sensorReader);
        }
    }

    public boolean ColorChangedEventEnabled()
    {
        return colorChangedEventEnabled;
    }

    public void DetectColor(boolean flag)
    {
        boolean flag1 = isHandlerNeeded();
        detectColor = flag;
        if (bluetooth != null && bluetooth.IsConnected())
        {
            initializeSensor("DetectColor");
        }
        flag = isHandlerNeeded();
        if (flag1 && !flag)
        {
            handler.removeCallbacks(sensorReader);
        }
        previousColor = 0xffffff;
        previousState = State.UNKNOWN;
        if (!flag1 && flag)
        {
            handler.post(sensorReader);
        }
    }

    public boolean DetectColor()
    {
        return detectColor;
    }

    public int GenerateColor()
    {
        return generateColor;
    }

    public void GenerateColor(int i)
    {
        if (mapColorToSensorType.containsKey(Integer.valueOf(i)))
        {
            generateColor = i;
            if (bluetooth != null && bluetooth.IsConnected())
            {
                initializeSensor("GenerateColor");
            }
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(this, "GenerateColor", 419, new Object[0]);
            return;
        }
    }

    public int GetColor()
    {
        if (checkBluetooth("GetColor"))
        {
            if (!detectColor)
            {
                form.dispatchErrorOccurredEvent(this, "GetColor", 417, new Object[0]);
                return 0xffffff;
            }
            LegoMindstormsNxtSensor.SensorValue sensorvalue = getColorValue("GetColor");
            if (sensorvalue.valid)
            {
                return ((Integer)sensorvalue.value).intValue();
            }
        }
        return 0xffffff;
    }

    public int GetLightLevel()
    {
        if (checkBluetooth("GetLightLevel"))
        {
            if (detectColor)
            {
                form.dispatchErrorOccurredEvent(this, "GetLightLevel", 418, new Object[0]);
                return -1;
            }
            LegoMindstormsNxtSensor.SensorValue sensorvalue = getLightValue("GetLightLevel");
            if (sensorvalue.valid)
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
        int i;
        if (detectColor)
        {
            i = 13;
        } else
        {
            i = ((Integer)mapColorToSensorType.get(Integer.valueOf(generateColor))).intValue();
        }
        setInputMode(s, port, i, 0);
        resetInputScaledValue(s, port);
    }

    public void onDelete()
    {
        handler.removeCallbacks(sensorReader);
        super.onDelete();
    }

    static 
    {
        mapColorToSensorType = new HashMap();
        mapColorToSensorType.put(Integer.valueOf(0xffff0000), Integer.valueOf(14));
        mapColorToSensorType.put(Integer.valueOf(0xff00ff00), Integer.valueOf(15));
        mapColorToSensorType.put(Integer.valueOf(0xff0000ff), Integer.valueOf(16));
        mapColorToSensorType.put(Integer.valueOf(0xffffff), Integer.valueOf(17));
        mapSensorValueToColor = new HashMap();
        mapSensorValueToColor.put(Integer.valueOf(1), Integer.valueOf(0xff000000));
        mapSensorValueToColor.put(Integer.valueOf(2), Integer.valueOf(0xff0000ff));
        mapSensorValueToColor.put(Integer.valueOf(3), Integer.valueOf(0xff00ff00));
        mapSensorValueToColor.put(Integer.valueOf(4), Integer.valueOf(-256));
        mapSensorValueToColor.put(Integer.valueOf(5), Integer.valueOf(0xffff0000));
        mapSensorValueToColor.put(Integer.valueOf(6), Integer.valueOf(-1));
    }








/*
    static int access$202(NxtColorSensor nxtcolorsensor, int i)
    {
        nxtcolorsensor.previousColor = i;
        return i;
    }

*/






/*
    static State access$602(NxtColorSensor nxtcolorsensor, State state)
    {
        nxtcolorsensor.previousState = state;
        return state;
    }

*/



}
