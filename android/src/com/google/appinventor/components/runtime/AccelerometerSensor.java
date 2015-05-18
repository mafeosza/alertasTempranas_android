// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, OnStopListener, OnResumeListener, SensorComponent, 
//            Deleteable, ComponentContainer, Form, EventDispatcher

public class AccelerometerSensor extends AndroidNonvisibleComponent
    implements OnStopListener, OnResumeListener, SensorComponent, SensorEventListener, Deleteable
{

    private static final int SENSOR_CACHE_SIZE = 10;
    private static final double moderateShakeThreshold = 13D;
    private static final double strongShakeThreshold = 20D;
    private static final double weakShakeThreshold = 5D;
    private final Queue X_CACHE = new LinkedList();
    private final Queue Y_CACHE = new LinkedList();
    private final Queue Z_CACHE = new LinkedList();
    private Sensor accelerometerSensor;
    private int accuracy;
    private boolean enabled;
    private int minimumInterval;
    private int sensitivity;
    private final SensorManager sensorManager;
    private long timeLastShook;
    private float xAccel;
    private float yAccel;
    private float zAccel;

    public AccelerometerSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        form.registerForOnResume(this);
        form.registerForOnStop(this);
        enabled = true;
        sensorManager = (SensorManager)componentcontainer.$context().getSystemService("sensor");
        accelerometerSensor = sensorManager.getDefaultSensor(1);
        startListening();
        MinimumInterval(400);
        Sensitivity(2);
    }

    private void addToSensorCache(Queue queue, float f)
    {
        if (queue.size() >= 10)
        {
            queue.remove();
        }
        queue.add(Float.valueOf(f));
    }

    private boolean isShaking(Queue queue, float f)
    {
        float f1;
        boolean flag;
        flag = true;
        f1 = 0.0F;
        for (Iterator iterator = queue.iterator(); iterator.hasNext();)
        {
            f1 += ((Float)iterator.next()).floatValue();
        }

        f1 /= queue.size();
        if (Sensitivity() != 1) goto _L2; else goto _L1
_L1:
        if ((double)Math.abs(f1 - f) > 20D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
_L4:
        return flag;
_L2:
        if (Sensitivity() != 2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if ((double)Math.abs(f1 - f) > 13D && (double)Math.abs(f1 - f) < 20D) goto _L4; else goto _L3
_L3:
        return false;
        if ((double)Math.abs(f1 - f) > 5D && (double)Math.abs(f1 - f) < 13D) goto _L4; else goto _L5
_L5:
        return false;
    }

    private void startListening()
    {
        sensorManager.registerListener(this, accelerometerSensor, 1);
    }

    private void stopListening()
    {
        sensorManager.unregisterListener(this);
    }

    public void AccelerationChanged(float f, float f1, float f2)
    {
        xAccel = f;
        yAccel = f1;
        zAccel = f2;
        addToSensorCache(X_CACHE, f);
        addToSensorCache(Y_CACHE, f1);
        addToSensorCache(Z_CACHE, f2);
        long l = System.currentTimeMillis();
        if ((isShaking(X_CACHE, f) || isShaking(Y_CACHE, f1) || isShaking(Z_CACHE, f2)) && (timeLastShook == 0L || l >= timeLastShook + (long)minimumInterval))
        {
            timeLastShook = l;
            Shaking();
        }
        EventDispatcher.dispatchEvent(this, "AccelerationChanged", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2)
        });
    }

    public boolean Available()
    {
        return sensorManager.getSensorList(1).size() > 0;
    }

    public void Enabled(boolean flag)
    {
        if (enabled == flag)
        {
            return;
        }
        enabled = flag;
        if (flag)
        {
            startListening();
            return;
        } else
        {
            stopListening();
            return;
        }
    }

    public boolean Enabled()
    {
        return enabled;
    }

    public int MinimumInterval()
    {
        return minimumInterval;
    }

    public void MinimumInterval(int i)
    {
        minimumInterval = i;
    }

    public int Sensitivity()
    {
        return sensitivity;
    }

    public void Sensitivity(int i)
    {
        if (i == 1 || i == 2 || i == 3)
        {
            sensitivity = i;
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(this, "Sensitivity", 1901, new Object[] {
                Integer.valueOf(i)
            });
            return;
        }
    }

    public void Shaking()
    {
        EventDispatcher.dispatchEvent(this, "Shaking", new Object[0]);
    }

    public float XAccel()
    {
        return xAccel;
    }

    public float YAccel()
    {
        return yAccel;
    }

    public float ZAccel()
    {
        return zAccel;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onDelete()
    {
        if (enabled)
        {
            stopListening();
        }
    }

    public void onResume()
    {
        if (enabled)
        {
            startListening();
        }
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        if (enabled)
        {
            float af[] = sensorevent.values;
            xAccel = af[0];
            yAccel = af[1];
            zAccel = af[2];
            accuracy = sensorevent.accuracy;
            AccelerationChanged(xAccel, yAccel, zAccel);
        }
    }

    public void onStop()
    {
        if (enabled)
        {
            stopListening();
        }
    }
}
