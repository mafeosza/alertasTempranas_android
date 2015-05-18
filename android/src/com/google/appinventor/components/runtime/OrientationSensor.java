// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.google.appinventor.components.runtime.util.FroyoUtil;
import com.google.appinventor.components.runtime.util.OrientationSensorUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Deleteable, OnPauseListener, OnResumeListener, 
//            ComponentContainer, Form, EventDispatcher

public class OrientationSensor extends AndroidNonvisibleComponent
    implements SensorEventListener, Deleteable, OnPauseListener, OnResumeListener
{

    private static final int AZIMUTH = 0;
    private static final int DIMENSIONS = 3;
    private static final String LOG_TAG = "OrientationSensor";
    private static final int PITCH = 1;
    private static final int ROLL = 2;
    private final Sensor accelerometerSensor;
    private final float accels[] = new float[3];
    private boolean accelsFilled;
    private int accuracy;
    private float azimuth;
    private boolean enabled;
    private final float inclinationMatrix[] = new float[9];
    private boolean listening;
    private final Sensor magneticFieldSensor;
    private final float mags[] = new float[3];
    private boolean magsFilled;
    private float pitch;
    private float roll;
    private final float rotationMatrix[] = new float[9];
    private final SensorManager sensorManager;
    private final float values[] = new float[3];

    public OrientationSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        sensorManager = (SensorManager)componentcontainer.$context().getSystemService("sensor");
        accelerometerSensor = sensorManager.getDefaultSensor(1);
        magneticFieldSensor = sensorManager.getDefaultSensor(2);
        form.registerForOnResume(this);
        form.registerForOnPause(this);
        Enabled(true);
    }

    static float computeAngle(float f, float f1)
    {
        return (float)Math.toDegrees(Math.atan2(Math.toRadians(f), -Math.toRadians(f1)));
    }

    private int getScreenRotation()
    {
        Display display = ((WindowManager)form.getSystemService("window")).getDefaultDisplay();
        if (SdkLevel.getLevel() >= 8)
        {
            return FroyoUtil.getRotation(display);
        } else
        {
            return display.getOrientation();
        }
    }

    private void startListening()
    {
        if (!listening)
        {
            sensorManager.registerListener(this, accelerometerSensor, 3);
            sensorManager.registerListener(this, magneticFieldSensor, 3);
            listening = true;
        }
    }

    private void stopListening()
    {
        if (listening)
        {
            sensorManager.unregisterListener(this);
            listening = false;
            accelsFilled = false;
            magsFilled = false;
        }
    }

    public float Angle()
    {
        return computeAngle(pitch, roll);
    }

    public boolean Available()
    {
        return sensorManager.getSensorList(1).size() > 0 && sensorManager.getSensorList(2).size() > 0;
    }

    public float Azimuth()
    {
        return azimuth;
    }

    public void Enabled(boolean flag)
    {
label0:
        {
            if (enabled != flag)
            {
                enabled = flag;
                if (!flag)
                {
                    break label0;
                }
                startListening();
            }
            return;
        }
        stopListening();
    }

    public boolean Enabled()
    {
        return enabled;
    }

    public float Magnitude()
    {
        double d = Math.toRadians(Math.min(90F, Math.abs(pitch)));
        double d1 = Math.toRadians(Math.min(90F, Math.abs(roll)));
        return (float)(1.0D - Math.cos(d) * Math.cos(d1));
    }

    public void OrientationChanged(float f, float f1, float f2)
    {
        EventDispatcher.dispatchEvent(this, "OrientationChanged", new Object[] {
            Float.valueOf(f), Float.valueOf(f1), Float.valueOf(f2)
        });
    }

    public float Pitch()
    {
        return pitch;
    }

    public float Roll()
    {
        return roll;
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
    }

    public void onDelete()
    {
        stopListening();
    }

    public void onPause()
    {
        stopListening();
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
        if (!enabled) goto _L2; else goto _L1
_L1:
        int i = sensorevent.sensor.getType();
        i;
        JVM INSTR tableswitch 1 2: default 40
    //                   1 67
    //                   2 275;
           goto _L3 _L4 _L5
_L3:
        Log.e("OrientationSensor", (new StringBuilder()).append("Unexpected sensor type: ").append(i).toString());
_L2:
        return;
_L4:
        System.arraycopy(sensorevent.values, 0, accels, 0, 3);
        accelsFilled = true;
        accuracy = sensorevent.accuracy;
_L12:
        if (!accelsFilled || !magsFilled) goto _L2; else goto _L6
_L6:
        SensorManager.getRotationMatrix(rotationMatrix, inclinationMatrix, accels, mags);
        SensorManager.getOrientation(rotationMatrix, values);
        azimuth = OrientationSensorUtil.normalizeAzimuth((float)Math.toDegrees(values[0]));
        pitch = OrientationSensorUtil.normalizePitch((float)Math.toDegrees(values[1]));
        roll = OrientationSensorUtil.normalizeRoll((float)(-Math.toDegrees(values[2])));
        i = getScreenRotation();
        i;
        JVM INSTR tableswitch 0 3: default 232
    //                   0 258
    //                   1 297
    //                   2 320
    //                   3 332;
           goto _L7 _L8 _L9 _L10 _L11
_L11:
        break MISSING_BLOCK_LABEL_332;
_L8:
        break; /* Loop/switch isn't completed */
_L7:
        Log.e("OrientationSensor", (new StringBuilder()).append("Illegal value for getScreenRotation(): ").append(i).toString());
_L13:
        OrientationChanged(azimuth, pitch, roll);
        return;
_L5:
        System.arraycopy(sensorevent.values, 0, mags, 0, 3);
        magsFilled = true;
          goto _L12
_L9:
        float f = -pitch;
        pitch = -roll;
        roll = f;
          goto _L13
_L10:
        roll = -roll;
          goto _L13
        float f1 = pitch;
        pitch = roll;
        roll = f1;
          goto _L13
    }
}
