// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            LocationSensor

private class <init>
    implements LocationListener
{

    final LocationSensor this$0;

    public void onLocationChanged(Location location)
    {
        LocationSensor.access$002(LocationSensor.this, location);
        LocationSensor.access$102(LocationSensor.this, location.getLongitude());
        LocationSensor.access$202(LocationSensor.this, location.getLatitude());
        if (location.hasAltitude())
        {
            LocationSensor.access$302(LocationSensor.this, true);
            LocationSensor.access$402(LocationSensor.this, location.getAltitude());
        }
        LocationSensor.access$502(LocationSensor.this, true);
        LocationChanged(LocationSensor.access$200(LocationSensor.this), LocationSensor.access$100(LocationSensor.this), LocationSensor.access$400(LocationSensor.this));
    }

    public void onProviderDisabled(String s)
    {
        StatusChanged(s, "Disabled");
        LocationSensor.access$600(LocationSensor.this);
        if (LocationSensor.access$700(LocationSensor.this))
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
    //                   0 40
    //                   1 29
    //                   2 79;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L3:
        StatusChanged(s, "TEMPORARILY_UNAVAILABLE");
        return;
_L2:
        StatusChanged(s, "OUT_OF_SERVICE");
        if (s.equals(LocationSensor.access$800(LocationSensor.this)))
        {
            LocationSensor.access$600(LocationSensor.this);
            RefreshProvider();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        StatusChanged(s, "AVAILABLE");
        if (!s.equals(LocationSensor.access$800(LocationSensor.this)) && !LocationSensor.access$900(LocationSensor.this).contains(s))
        {
            RefreshProvider();
            return;
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private Q()
    {
        this$0 = LocationSensor.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
