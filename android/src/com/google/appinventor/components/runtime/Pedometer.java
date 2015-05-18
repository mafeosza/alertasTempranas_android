// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.Array;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, Deleteable, ComponentContainer, 
//            EventDispatcher

public class Pedometer extends AndroidNonvisibleComponent
    implements Component, LocationListener, SensorEventListener, Deleteable
{

    private static final int DIMENSIONS = 3;
    private static final int INTERVAL_VARIATION = 250;
    private static final int MIN_SATELLITES = 4;
    private static final int NUM_INTERVALS = 2;
    private static final float PEAK_VALLEY_RANGE = 4F;
    private static final String PREFS_NAME = "PedometerPrefs";
    private static final float STRIDE_LENGTH = 0.73F;
    private static final String TAG = "Pedometer";
    private static final int WIN_SIZE = 20;
    private boolean calibrateSteps;
    private final Context context;
    private Location currentLocation;
    private float distWhenGPSLost;
    private long elapsedTimestamp;
    private boolean firstGpsReading;
    private boolean foundNonStep;
    private boolean foundValley[];
    private boolean gpsAvailable;
    private float gpsDistance;
    private long gpsStepTime;
    private int intervalPos;
    private int lastNumSteps;
    private float lastValley[];
    private float lastValues[][];
    private final LocationManager locationManager;
    private Location locationWhenGPSLost;
    private int numStepsRaw;
    private int numStepsWithFilter;
    private int peak[];
    private boolean pedometerPaused;
    private float prevDiff[];
    private Location prevLocation;
    private long prevStopClockTime;
    private final SensorManager sensorManager;
    private boolean startPeaking;
    private long startTime;
    private boolean statusMoving;
    private long stepInterval[];
    private long stepTimestamp;
    private int stopDetectionTimeout;
    private float strideLength;
    private float totalDistance;
    private boolean useGps;
    private int valley[];
    private int winPos;

    public Pedometer(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        stopDetectionTimeout = 2000;
        winPos = 0;
        intervalPos = 0;
        numStepsWithFilter = 0;
        numStepsRaw = 0;
        lastNumSteps = 0;
        peak = new int[3];
        valley = new int[3];
        lastValley = new float[3];
        lastValues = (float[][])Array.newInstance(Float.TYPE, new int[] {
            20, 3
        });
        prevDiff = new float[3];
        strideLength = 0.73F;
        totalDistance = 0.0F;
        distWhenGPSLost = 0.0F;
        gpsDistance = 0.0F;
        stepInterval = new long[2];
        stepTimestamp = 0L;
        elapsedTimestamp = 0L;
        startTime = 0L;
        prevStopClockTime = 0L;
        gpsStepTime = 0L;
        foundValley = new boolean[3];
        startPeaking = false;
        foundNonStep = true;
        gpsAvailable = false;
        calibrateSteps = true;
        pedometerPaused = true;
        useGps = true;
        statusMoving = false;
        firstGpsReading = true;
        context = componentcontainer.$context();
        winPos = 0;
        startPeaking = false;
        numStepsWithFilter = 0;
        numStepsRaw = 0;
        firstGpsReading = true;
        gpsDistance = 0.0F;
        for (int i = 0; i < 3; i++)
        {
            foundValley[i] = true;
            lastValley[i] = 0.0F;
        }

        sensorManager = (SensorManager)context.getSystemService("sensor");
        locationManager = (LocationManager)context.getSystemService("location");
        locationManager.requestLocationUpdates("gps", 0L, 0.0F, this);
        componentcontainer = context.getSharedPreferences("PedometerPrefs", 0);
        strideLength = componentcontainer.getFloat("Pedometer.stridelength", 0.73F);
        totalDistance = componentcontainer.getFloat("Pedometer.distance", 0.0F);
        numStepsRaw = componentcontainer.getInt("Pedometer.prevStepCount", 0);
        prevStopClockTime = componentcontainer.getLong("Pedometer.clockTime", 0L);
        numStepsWithFilter = numStepsRaw;
        startTime = System.currentTimeMillis();
        Log.d("Pedometer", "Pedometer Created");
    }

    private boolean areStepsEquallySpaced()
    {
        float f = 0.0F;
        int k = 0;
        long al[] = stepInterval;
        int i1 = al.length;
        for (int i = 0; i < i1;)
        {
            long l1 = al[i];
            float f1 = f;
            int l = k;
            if (l1 > 0L)
            {
                l = k + 1;
                f1 = f + (float)l1;
            }
            i++;
            f = f1;
            k = l;
        }

        f /= k;
        al = stepInterval;
        k = al.length;
        for (int j = 0; j < k; j++)
        {
            if (Math.abs((float)al[j] - f) > 250F)
            {
                return false;
            }
        }

        return true;
    }

    private void getPeak()
    {
        int k = (winPos + 10) % 20;
        int i = 0;
label0:
        do
        {
            if (i < 3)
            {
                peak[i] = k;
                int j = 0;
                do
                {
label1:
                    {
                        if (j < 20)
                        {
                            if (j == k || lastValues[j][i] < lastValues[k][i])
                            {
                                break label1;
                            }
                            peak[i] = -1;
                        }
                        i++;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            return;
        } while (true);
    }

    private void getValley()
    {
        int k = (winPos + 10) % 20;
        int i = 0;
label0:
        do
        {
            if (i < 3)
            {
                valley[i] = k;
                int j = 0;
                do
                {
label1:
                    {
                        if (j < 20)
                        {
                            if (j == k || lastValues[j][i] > lastValues[k][i])
                            {
                                break label1;
                            }
                            valley[i] = -1;
                        }
                        i++;
                        continue label0;
                    }
                    j++;
                } while (true);
            }
            return;
        } while (true);
    }

    private void setGpsAvailable(boolean flag)
    {
        if (!gpsAvailable && flag)
        {
            gpsAvailable = true;
            GPSAvailable();
        } else
        if (gpsAvailable && !flag)
        {
            gpsAvailable = false;
            GPSLost();
            return;
        }
    }

    public void CalibrateStrideLength(boolean flag)
    {
        if (!gpsAvailable && flag)
        {
            CalibrationFailed();
            return;
        }
        if (flag)
        {
            useGps = true;
        }
        calibrateSteps = flag;
    }

    public boolean CalibrateStrideLength()
    {
        return calibrateSteps;
    }

    public void CalibrationFailed()
    {
        EventDispatcher.dispatchEvent(this, "CalibrationFailed", new Object[0]);
    }

    public float Distance()
    {
        return totalDistance;
    }

    public long ElapsedTime()
    {
        if (pedometerPaused)
        {
            return prevStopClockTime;
        } else
        {
            return prevStopClockTime + (System.currentTimeMillis() - startTime);
        }
    }

    public void GPSAvailable()
    {
        EventDispatcher.dispatchEvent(this, "GPSAvailable", new Object[0]);
    }

    public void GPSLost()
    {
        EventDispatcher.dispatchEvent(this, "GPSLost", new Object[0]);
    }

    public boolean Moving()
    {
        return statusMoving;
    }

    public void Pause()
    {
        if (!pedometerPaused)
        {
            pedometerPaused = true;
            statusMoving = false;
            sensorManager.unregisterListener(this);
            Log.d("Pedometer", "Unregistered listener on pause");
            prevStopClockTime = prevStopClockTime + (System.currentTimeMillis() - startTime);
        }
    }

    public void Reset()
    {
        numStepsWithFilter = 0;
        numStepsRaw = 0;
        totalDistance = 0.0F;
        calibrateSteps = false;
        prevStopClockTime = 0L;
        startTime = System.currentTimeMillis();
    }

    public void Resume()
    {
        Start();
    }

    public void Save()
    {
        android.content.SharedPreferences.Editor editor = context.getSharedPreferences("PedometerPrefs", 0).edit();
        editor.putFloat("Pedometer.stridelength", strideLength);
        editor.putFloat("Pedometer.distance", totalDistance);
        editor.putInt("Pedometer.prevStepCount", numStepsRaw);
        if (pedometerPaused)
        {
            editor.putLong("Pedometer.clockTime", prevStopClockTime);
        } else
        {
            editor.putLong("Pedometer.clockTime", prevStopClockTime + (System.currentTimeMillis() - startTime));
        }
        editor.putLong("Pedometer.closeTime", System.currentTimeMillis());
        editor.commit();
        Log.d("Pedometer", "Pedometer state saved.");
    }

    public void SimpleStep(int i, float f)
    {
        EventDispatcher.dispatchEvent(this, "SimpleStep", new Object[] {
            Integer.valueOf(i), Float.valueOf(f)
        });
    }

    public void Start()
    {
        if (pedometerPaused)
        {
            pedometerPaused = false;
            sensorManager.registerListener(this, (Sensor)sensorManager.getSensorList(1).get(0), 0);
            startTime = System.currentTimeMillis();
        }
    }

    public void StartedMoving()
    {
        EventDispatcher.dispatchEvent(this, "StartedMoving", new Object[0]);
    }

    public void Stop()
    {
        Pause();
        locationManager.removeUpdates(this);
        useGps = false;
        calibrateSteps = false;
        setGpsAvailable(false);
    }

    public int StopDetectionTimeout()
    {
        return stopDetectionTimeout;
    }

    public void StopDetectionTimeout(int i)
    {
        stopDetectionTimeout = i;
    }

    public void StoppedMoving()
    {
        EventDispatcher.dispatchEvent(this, "StoppedMoving", new Object[0]);
    }

    public float StrideLength()
    {
        return strideLength;
    }

    public void StrideLength(float f)
    {
        CalibrateStrideLength(false);
        strideLength = f;
    }

    public void UseGPS(boolean flag)
    {
        if (flag || !useGps) goto _L2; else goto _L1
_L1:
        locationManager.removeUpdates(this);
_L4:
        useGps = flag;
        return;
_L2:
        if (flag && !useGps)
        {
            locationManager.requestLocationUpdates("gps", 0L, 0.0F, this);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public boolean UseGPS()
    {
        return useGps;
    }

    public void WalkStep(int i, float f)
    {
        EventDispatcher.dispatchEvent(this, "WalkStep", new Object[] {
            Integer.valueOf(i), Float.valueOf(f)
        });
    }

    public void onAccuracyChanged(Sensor sensor, int i)
    {
        Log.d("Pedometer", "Accelerometer accuracy changed.");
    }

    public void onDelete()
    {
        sensorManager.unregisterListener(this);
        locationManager.removeUpdates(this);
    }

    public void onLocationChanged(Location location)
    {
        if (!statusMoving || pedometerPaused || !useGps)
        {
            return;
        }
        float f = 0.0F;
        currentLocation = location;
        if (currentLocation.getAccuracy() > 10F)
        {
            setGpsAvailable(false);
            return;
        }
        setGpsAvailable(true);
        if (prevLocation != null)
        {
            float f1 = currentLocation.distanceTo(prevLocation);
            f = f1;
            if ((double)f1 > 0.10000000000000001D)
            {
                f = f1;
                if (f1 < 10F)
                {
                    totalDistance = totalDistance + f1;
                    prevLocation = currentLocation;
                    f = f1;
                }
            }
        } else
        {
            if (locationWhenGPSLost != null)
            {
                float f2 = currentLocation.distanceTo(locationWhenGPSLost);
                totalDistance = distWhenGPSLost + ((totalDistance - distWhenGPSLost) + f2) / 2.0F;
            }
            gpsStepTime = System.currentTimeMillis();
            prevLocation = currentLocation;
        }
        if (calibrateSteps)
        {
            if (!firstGpsReading)
            {
                gpsDistance = gpsDistance + f;
                int i = numStepsRaw;
                int j = lastNumSteps;
                strideLength = gpsDistance / (float)(i - j);
                return;
            } else
            {
                firstGpsReading = false;
                lastNumSteps = numStepsRaw;
                return;
            }
        } else
        {
            firstGpsReading = true;
            gpsDistance = 0.0F;
            return;
        }
    }

    public void onProviderDisabled(String s)
    {
        distWhenGPSLost = totalDistance;
        locationWhenGPSLost = currentLocation;
        firstGpsReading = true;
        prevLocation = null;
        setGpsAvailable(false);
    }

    public void onProviderEnabled(String s)
    {
        setGpsAvailable(true);
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        if (sensorevent.sensor.getType() != 1)
        {
            return;
        }
        sensorevent = sensorevent.values;
        if (startPeaking)
        {
            getPeak();
            getValley();
        }
        int i;
        int j;
        if (prevDiff[0] > prevDiff[1])
        {
            i = 0;
        } else
        {
            i = 1;
        }
        j = i;
        if (prevDiff[2] > prevDiff[i])
        {
            j = 2;
        }
        i = 0;
        while (i < 3) 
        {
            if (startPeaking && peak[i] >= 0)
            {
                if (foundValley[i] && lastValues[peak[i]][i] - lastValley[i] > 4F)
                {
                    if (j == i)
                    {
                        long l = System.currentTimeMillis();
                        stepInterval[intervalPos] = l - stepTimestamp;
                        intervalPos = (intervalPos + 1) % 2;
                        stepTimestamp = l;
                        if (areStepsEquallySpaced())
                        {
                            if (foundNonStep)
                            {
                                numStepsWithFilter = numStepsWithFilter + 2;
                                if (!gpsAvailable)
                                {
                                    totalDistance = totalDistance + strideLength * 2.0F;
                                }
                                foundNonStep = false;
                            }
                            numStepsWithFilter = numStepsWithFilter + 1;
                            WalkStep(numStepsWithFilter, totalDistance);
                            if (!gpsAvailable)
                            {
                                totalDistance = totalDistance + strideLength;
                            }
                        } else
                        {
                            foundNonStep = true;
                        }
                        numStepsRaw = numStepsRaw + 1;
                        SimpleStep(numStepsRaw, totalDistance);
                        if (!statusMoving)
                        {
                            statusMoving = true;
                            StartedMoving();
                        }
                    }
                    foundValley[i] = false;
                    prevDiff[i] = lastValues[peak[i]][i] - lastValley[i];
                } else
                {
                    prevDiff[i] = 0.0F;
                }
            }
            if (startPeaking && valley[i] >= 0)
            {
                foundValley[i] = true;
                lastValley[i] = lastValues[valley[i]][i];
            }
            lastValues[winPos][i] = sensorevent[i];
            i++;
        }
        elapsedTimestamp = System.currentTimeMillis();
        if (elapsedTimestamp - stepTimestamp > (long)stopDetectionTimeout)
        {
            if (statusMoving)
            {
                statusMoving = false;
                StoppedMoving();
            }
            stepTimestamp = elapsedTimestamp;
        }
        if (winPos - 1 < 0)
        {
            i = 19;
        } else
        {
            i = winPos - 1;
        }
        for (j = 0; j < 3; j++)
        {
            if (lastValues[i][j] == lastValues[winPos][j])
            {
                sensorevent = lastValues[winPos];
                sensorevent[j] = (float)((double)sensorevent[j] + 0.001D);
            }
        }

        if (winPos == 19 && !startPeaking)
        {
            startPeaking = true;
        }
        winPos = (winPos + 1) % 20;
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
