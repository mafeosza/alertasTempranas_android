// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LegoMindstormsNxtBase, Form, ComponentContainer, BluetoothConnectionBase

public class NxtDrive extends LegoMindstormsNxtBase
{

    private static final int MODE_BRAKE = 2;
    private static final int MODE_MOTORON = 1;
    private static final int MODE_REGULATED = 4;
    private static final int MOTOR_RUN_STATE_IDLE = 0;
    private static final int MOTOR_RUN_STATE_RAMPDOWN = 64;
    private static final int MOTOR_RUN_STATE_RAMPUP = 16;
    private static final int MOTOR_RUN_STATE_RUNNING = 32;
    private static final int REGULATION_MODE_IDLE = 0;
    private static final int REGULATION_MODE_MOTOR_SPEED = 1;
    private static final int REGULATION_MODE_MOTOR_SYNC = 2;
    private List driveMotorPorts;
    private String driveMotors;
    private boolean stopBeforeDisconnect;
    private double wheelDiameter;

    public NxtDrive(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "NxtDrive");
        DriveMotors("CB");
        WheelDiameter(4.32F);
        StopBeforeDisconnect(true);
    }

    private void move(String s, int i, long l)
    {
        if (checkBluetooth(s))
        {
            Iterator iterator = driveMotorPorts.iterator();
            while (iterator.hasNext()) 
            {
                setOutputState(s, ((Integer)iterator.next()).intValue(), i, 1, 1, 0, 32, l);
            }
        }
    }

    private void turnIndefinitely(String s, int i, int j, int k)
    {
        if (!checkBluetooth(s))
        {
            return;
        } else
        {
            setOutputState(s, ((Integer)driveMotorPorts.get(j)).intValue(), i, 1, 1, 0, 32, 0L);
            setOutputState(s, ((Integer)driveMotorPorts.get(k)).intValue(), -i, 1, 1, 0, 32, 0L);
            return;
        }
    }

    public String DriveMotors()
    {
        return driveMotors;
    }

    public void DriveMotors(String s)
    {
        driveMotors = s;
        driveMotorPorts = new ArrayList();
        int i = 0;
        while (i < s.length()) 
        {
            char c = s.charAt(i);
            try
            {
                driveMotorPorts.add(Integer.valueOf(convertMotorPortLetterToNumber(c)));
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                form.dispatchErrorOccurredEvent(this, "DriveMotors", 407, new Object[] {
                    Character.valueOf(c)
                });
            }
            i++;
        }
    }

    public void MoveBackward(int i, double d)
    {
        long l = (long)((360D * d) / (wheelDiameter * 3.1415926535897931D));
        move("MoveBackward", -i, l);
    }

    public void MoveBackwardIndefinitely(int i)
    {
        move("MoveBackwardIndefinitely", -i, 0L);
    }

    public void MoveForward(int i, double d)
    {
        move("MoveForward", i, (long)((360D * d) / (wheelDiameter * 3.1415926535897931D)));
    }

    public void MoveForwardIndefinitely(int i)
    {
        move("MoveForwardIndefinitely", i, 0L);
    }

    public void Stop()
    {
        if (checkBluetooth("Stop"))
        {
            Iterator iterator = driveMotorPorts.iterator();
            while (iterator.hasNext()) 
            {
                setOutputState("Stop", ((Integer)iterator.next()).intValue(), 0, 2, 0, 0, 0, 0L);
            }
        }
    }

    public void StopBeforeDisconnect(boolean flag)
    {
        stopBeforeDisconnect = flag;
    }

    public boolean StopBeforeDisconnect()
    {
        return stopBeforeDisconnect;
    }

    public void TurnClockwiseIndefinitely(int i)
    {
        int j = driveMotorPorts.size();
        if (j >= 2)
        {
            turnIndefinitely("TurnClockwiseIndefinitely", i, 0, j - 1);
        }
    }

    public void TurnCounterClockwiseIndefinitely(int i)
    {
        int j = driveMotorPorts.size();
        if (j >= 2)
        {
            turnIndefinitely("TurnCounterClockwiseIndefinitely", i, j - 1, 0);
        }
    }

    public float WheelDiameter()
    {
        return (float)wheelDiameter;
    }

    public void WheelDiameter(float f)
    {
        wheelDiameter = f;
    }

    public void beforeDisconnect(BluetoothConnectionBase bluetoothconnectionbase)
    {
        if (stopBeforeDisconnect)
        {
            for (bluetoothconnectionbase = driveMotorPorts.iterator(); bluetoothconnectionbase.hasNext(); setOutputState("Disconnect", ((Integer)bluetoothconnectionbase.next()).intValue(), 0, 2, 0, 0, 0, 0L)) { }
        }
    }
}
