// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtSensor, Deleteable, EventDispatcher, ComponentContainer, 
//            BluetoothClient

public class NxtUltrasonicSensor extends LegoMindstormsNxtSensor
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
            return (State)Enum.valueOf(com/google/appinventor/components/runtime/NxtUltrasonicSensor$State, s);
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


    private static final int DEFAULT_BOTTOM_OF_RANGE = 30;
    private static final String DEFAULT_SENSOR_PORT = "4";
    private static final int DEFAULT_TOP_OF_RANGE = 90;
    private boolean aboveRangeEventEnabled;
    private boolean belowRangeEventEnabled;
    private int bottomOfRange;
    private Handler handler;
    private State previousState;
    private final Runnable sensorReader = new Runnable() {

        final NxtUltrasonicSensor this$0;

        public void run()
        {
            if (bluetooth != null && bluetooth.IsConnected())
            {
                Object obj = getDistanceValue("");
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
                this$0 = NxtUltrasonicSensor.this;
                super();
            }
    };
    private int topOfRange;
    private boolean withinRangeEventEnabled;

    public NxtUltrasonicSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "NxtUltrasonicSensor");
        handler = new Handler();
        previousState = State.UNKNOWN;
        SensorPort("4");
        BottomOfRange(30);
        TopOfRange(90);
        BelowRangeEventEnabled(false);
        WithinRangeEventEnabled(false);
        AboveRangeEventEnabled(false);
    }

    private void configureUltrasonicSensor(String s)
    {
        lsWrite(s, port, new byte[] {
            2, 65, 2
        }, 0);
    }

    private LegoMindstormsNxtSensor.SensorValue getDistanceValue(String s)
    {
        lsWrite(s, port, new byte[] {
            2, 66
        }, 1);
        int i = 0;
        do
        {
            if (i >= 3)
            {
                break;
            }
            if (lsGetStatus(s, port) > 0)
            {
                s = lsRead(s, port);
                if (s != null)
                {
                    i = getUBYTEValueFromBytes(s, 4);
                    if (i >= 0 && i <= 254)
                    {
                        return new LegoMindstormsNxtSensor.SensorValue(true, Integer.valueOf(i));
                    }
                }
                break;
            }
            i++;
        } while (true);
        return new LegoMindstormsNxtSensor.SensorValue(false, null);
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

    public int GetDistance()
    {
        LegoMindstormsNxtSensor.SensorValue sensorvalue;
        if (checkBluetooth("GetDistance"))
        {
            if ((sensorvalue = getDistanceValue("GetDistance")).valid)
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
        setInputMode(s, port, 11, 0);
        configureUltrasonicSensor(s);
    }

    public void onDelete()
    {
        handler.removeCallbacks(sensorReader);
        super.onDelete();
    }






/*
    static State access$302(NxtUltrasonicSensor nxtultrasonicsensor, State state)
    {
        nxtultrasonicsensor.previousState = state;
        return state;
    }

*/






}
