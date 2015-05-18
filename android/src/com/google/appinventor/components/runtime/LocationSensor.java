// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnStopListener, OnResumeListener, 
//            Deleteable, ComponentContainer, Form, EventDispatcher

public class LocationSensor extends AndroidNonvisibleComponent
    implements Component, OnStopListener, OnResumeListener, Deleteable
{
    private class MyLocationListener
        implements LocationListener
    {

        final LocationSensor this$0;

        public void onLocationChanged(Location location)
        {
            lastLocation = location;
            longitude = location.getLongitude();
            latitude = location.getLatitude();
            if (location.hasAltitude())
            {
                hasAltitude = true;
                altitude = location.getAltitude();
            }
            hasLocationData = true;
            LocationChanged(latitude, longitude, altitude);
        }

        public void onProviderDisabled(String s)
        {
            StatusChanged(s, "Disabled");
            stopListening();
            if (enabled)
            {
                RefreshProvider();
            }
        }

        public void onProviderEnabled(String s)
        {
            StatusChanged(s, "Enabled");
            RefreshProvider();
        }

        public void onStatusChanged(String s, int i, Bundle bundle)
        {
            i;
            JVM INSTR tableswitch 0 2: default 28
        //                       0 40
        //                       1 29
        //                       2 79;
               goto _L1 _L2 _L3 _L4
_L1:
            return;
_L3:
            StatusChanged(s, "TEMPORARILY_UNAVAILABLE");
            return;
_L2:
            StatusChanged(s, "OUT_OF_SERVICE");
            if (s.equals(providerName))
            {
                stopListening();
                RefreshProvider();
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            StatusChanged(s, "AVAILABLE");
            if (!s.equals(providerName) && !allProviders.contains(s))
            {
                RefreshProvider();
                return;
            }
            if (true) goto _L1; else goto _L5
_L5:
        }

        private MyLocationListener()
        {
            this$0 = LocationSensor.this;
            super();
        }

    }


    public static final int UNKNOWN_VALUE = 0;
    private List allProviders;
    private double altitude;
    private int distanceInterval;
    private boolean enabled;
    private Geocoder geocoder;
    private final Handler handler = new Handler();
    private boolean hasAltitude;
    private boolean hasLocationData;
    private Location lastLocation;
    private double latitude;
    private boolean listening;
    private final Criteria locationCriteria = new Criteria();
    private final LocationManager locationManager;
    private LocationProvider locationProvider;
    private double longitude;
    private MyLocationListener myLocationListener;
    private boolean providerLocked;
    private String providerName;
    private int timeInterval;

    public LocationSensor(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        providerLocked = false;
        listening = false;
        longitude = 0.0D;
        latitude = 0.0D;
        altitude = 0.0D;
        hasLocationData = false;
        hasAltitude = false;
        enabled = true;
        form.registerForOnResume(this);
        form.registerForOnStop(this);
        timeInterval = 60000;
        distanceInterval = 5;
        componentcontainer = componentcontainer.$context();
        geocoder = new Geocoder(componentcontainer);
        locationManager = (LocationManager)componentcontainer.getSystemService("location");
        myLocationListener = new MyLocationListener();
        allProviders = new ArrayList();
        Enabled(enabled);
    }

    private boolean empty(String s)
    {
        return s == null || s.length() == 0;
    }

    private boolean startProvider(String s)
    {
        providerName = s;
        LocationProvider locationprovider = locationManager.getProvider(s);
        if (locationprovider == null)
        {
            Log.d("LocationSensor", (new StringBuilder()).append("getProvider(").append(s).append(") returned null").toString());
            return false;
        } else
        {
            stopListening();
            locationProvider = locationprovider;
            locationManager.requestLocationUpdates(s, timeInterval, distanceInterval, myLocationListener);
            listening = true;
            return true;
        }
    }

    private void stopListening()
    {
        if (listening)
        {
            locationManager.removeUpdates(myLocationListener);
            locationProvider = null;
            listening = false;
        }
    }

    public double Accuracy()
    {
        if (lastLocation != null && lastLocation.hasAccuracy())
        {
            return (double)lastLocation.getAccuracy();
        }
        if (locationProvider != null)
        {
            return (double)locationProvider.getAccuracy();
        } else
        {
            return 0.0D;
        }
    }

    public double Altitude()
    {
        return altitude;
    }

    public List AvailableProviders()
    {
        return allProviders;
    }

    public String CurrentAddress()
    {
        if ((!hasLocationData || latitude > 90D || latitude < -90D || longitude > 180D) && longitude < -180D)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        Object obj = geocoder.getFromLocation(latitude, longitude, 1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        if (((List) (obj)).size() != 1)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        obj = (Address)((List) (obj)).get(0);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_198;
        }
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
_L2:
        if (i > ((Address) (obj)).getMaxAddressLineIndex())
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(((Address) (obj)).getAddressLine(i));
        stringbuilder.append("\n");
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        obj = stringbuilder.toString();
        return ((String) (obj));
        Exception exception;
        exception;
        if ((exception instanceof IllegalArgumentException) || (exception instanceof IOException) || (exception instanceof IndexOutOfBoundsException))
        {
            Log.e("LocationSensor", (new StringBuilder()).append("Exception thrown by getting current address ").append(exception.getMessage()).toString());
        } else
        {
            Log.e("LocationSensor", (new StringBuilder()).append("Unexpected exception thrown by getting current address ").append(exception.getMessage()).toString());
        }
        return "No address available";
    }

    public int DistanceInterval()
    {
        return distanceInterval;
    }

    public void DistanceInterval(int i)
    {
        if (i >= 0 && i <= 1000)
        {
            distanceInterval = i;
            if (enabled)
            {
                RefreshProvider();
                return;
            }
        }
    }

    public void Enabled(boolean flag)
    {
        enabled = flag;
        if (!flag)
        {
            stopListening();
            return;
        } else
        {
            RefreshProvider();
            return;
        }
    }

    public boolean Enabled()
    {
        return enabled;
    }

    public boolean HasAccuracy()
    {
        return Accuracy() != 0.0D && enabled;
    }

    public boolean HasAltitude()
    {
        return hasAltitude && enabled;
    }

    public boolean HasLongitudeLatitude()
    {
        return hasLocationData && enabled;
    }

    public double Latitude()
    {
        return latitude;
    }

    public double LatitudeFromAddress(String s)
    {
        Object obj;
        try
        {
            obj = geocoder.getFromLocationName(s, 1);
            Log.i("LocationSensor", (new StringBuilder()).append("latitude addressObjs size is ").append(((List) (obj)).size()).append(" for ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            form.dispatchErrorOccurredEvent(this, "LatitudeFromAddress", 101, new Object[] {
                s
            });
            return 0.0D;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (((List) (obj)).size() != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        throw new IOException("");
        double d = ((Address)((List) (obj)).get(0)).getLatitude();
        return d;
    }

    public void LocationChanged(double d, double d1, double d2)
    {
        if (enabled)
        {
            EventDispatcher.dispatchEvent(this, "LocationChanged", new Object[] {
                Double.valueOf(d), Double.valueOf(d1), Double.valueOf(d2)
            });
        }
    }

    public double Longitude()
    {
        return longitude;
    }

    public double LongitudeFromAddress(String s)
    {
        Object obj;
        try
        {
            obj = geocoder.getFromLocationName(s, 1);
            Log.i("LocationSensor", (new StringBuilder()).append("longitude addressObjs size is ").append(((List) (obj)).size()).append(" for ").append(s).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            form.dispatchErrorOccurredEvent(this, "LongitudeFromAddress", 102, new Object[] {
                s
            });
            return 0.0D;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        if (((List) (obj)).size() != 0)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        throw new IOException("");
        double d = ((Address)((List) (obj)).get(0)).getLongitude();
        return d;
    }

    public void ProviderLocked(boolean flag)
    {
        providerLocked = flag;
    }

    public boolean ProviderLocked()
    {
        return providerLocked;
    }

    public String ProviderName()
    {
        if (providerName == null)
        {
            return "NO PROVIDER";
        } else
        {
            return providerName;
        }
    }

    public void ProviderName(String s)
    {
        providerName = s;
        if (!empty(s) && startProvider(s))
        {
            return;
        } else
        {
            RefreshProvider();
            return;
        }
    }

    public void RefreshProvider()
    {
        stopListening();
        if (!providerLocked || empty(providerName)) goto _L2; else goto _L1
_L1:
        listening = startProvider(providerName);
_L4:
        return;
_L2:
        allProviders = locationManager.getProviders(true);
        Object obj = locationManager.getBestProvider(locationCriteria, true);
        if (obj != null && !((String) (obj)).equals(allProviders.get(0)))
        {
            allProviders.add(0, obj);
        }
        obj = allProviders.iterator();
        String s;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = (String)((Iterator) (obj)).next();
            listening = startProvider(s);
        } while (!listening);
        if (!providerLocked)
        {
            providerName = s;
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void StatusChanged(String s, String s1)
    {
        if (enabled)
        {
            EventDispatcher.dispatchEvent(this, "StatusChanged", new Object[] {
                s, s1
            });
        }
    }

    public int TimeInterval()
    {
        return timeInterval;
    }

    public void TimeInterval(int i)
    {
        if (i >= 0 && i <= 0xf4240)
        {
            timeInterval = i;
            if (enabled)
            {
                RefreshProvider();
                return;
            }
        }
    }

    public void onDelete()
    {
        stopListening();
    }

    public void onResume()
    {
        if (enabled)
        {
            RefreshProvider();
        }
    }

    public void onStop()
    {
        stopListening();
    }


/*
    static Location access$002(LocationSensor locationsensor, Location location)
    {
        locationsensor.lastLocation = location;
        return location;
    }

*/



/*
    static double access$102(LocationSensor locationsensor, double d)
    {
        locationsensor.longitude = d;
        return d;
    }

*/



/*
    static double access$202(LocationSensor locationsensor, double d)
    {
        locationsensor.latitude = d;
        return d;
    }

*/


/*
    static boolean access$302(LocationSensor locationsensor, boolean flag)
    {
        locationsensor.hasAltitude = flag;
        return flag;
    }

*/



/*
    static double access$402(LocationSensor locationsensor, double d)
    {
        locationsensor.altitude = d;
        return d;
    }

*/


/*
    static boolean access$502(LocationSensor locationsensor, boolean flag)
    {
        locationsensor.hasLocationData = flag;
        return flag;
    }

*/




}
