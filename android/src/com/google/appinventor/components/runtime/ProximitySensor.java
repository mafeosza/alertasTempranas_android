// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, OnStopListener, OnResumeListener, SensorComponent, 
//            OnPauseListener, Deleteable, ComponentContainer, Form, 
//            EventDispatcher

public class ProximitySensor extends AndroidNonvisibleComponent
    implements OnStopListener, OnResumeListener, SensorComponent, OnPauseListener, SensorEventListener, Deleteable
{

    private float distance;
    private boolean enabled;
    private boolean keepRunningWhenOnPause;
    private Sensor proximitySensor;
    private final SensorManager sensorManager;

    public ProximitySensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        distance = 0.0F;
        form.registerForOnResume(this);
        form.registerForOnStop(this);
        form.registerForOnPause(this);
        enabled = true;
        sensorManager = (SensorManager)componentcontainer.$context().getSystemService("sensor");
        proximitySensor = sensorManager.getDefaultSensor(8);
        startListening();
    }

    private void startListening()
    {
        sensorManager.registerListener(this, proximitySensor, 3);
    }

    private void stopListening()
    {
        sensorManager.unregisterListener(this);
    }

    public boolean Available()
    {
        return sensorManager.getSensorList(8).size() > 0;
    }

    public float Distance()
    {
        return distance;
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

    public void KeepRunningWhenOnPause(boolean flag)
    {
        keepRunningWhenOnPause = flag;
    }

    public boolean KeepRunningWhenOnPause()
    {
        return keepRunningWhenOnPause;
    }

    public float MaximumRange()
    {
        return proximitySensor.getMaximumRange();
    }

    public void ProximityChanged(float f)
    {
        distance = f;
        EventDispatcher.dispatchEvent(this, "ProximityChanged", new Object[] {
            Float.valueOf(distance)
        });
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

    public void onPause()
    {
        if (enabled && !keepRunningWhenOnPause)
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
            distance = ((float[])sensorevent.values.clone())[0];
            ProximityChanged(distance);
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
