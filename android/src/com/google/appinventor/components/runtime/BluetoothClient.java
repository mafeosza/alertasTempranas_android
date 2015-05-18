// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.google.appinventor.components.runtime:
//            BluetoothConnectionBase, Form, ComponentContainer, Component

public final class BluetoothClient extends BluetoothConnectionBase
{

    private static final String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private Set acceptableDeviceClasses;
    private final List attachedComponents = new ArrayList();

    public BluetoothClient(ComponentContainer componentcontainer)
    {
        super(componentcontainer, "BluetoothClient");
    }

    private void connect(Object obj, UUID uuid)
        throws IOException
    {
        if (!secure && SdkLevel.getLevel() >= 10)
        {
            uuid = ((UUID) (BluetoothReflection.createInsecureRfcommSocketToServiceRecord(obj, uuid)));
        } else
        {
            uuid = ((UUID) (BluetoothReflection.createRfcommSocketToServiceRecord(obj, uuid)));
        }
        BluetoothReflection.connectToBluetoothSocket(uuid);
        setConnection(uuid);
        Log.i(logTag, (new StringBuilder()).append("Connected to Bluetooth device ").append(BluetoothReflection.getBluetoothDeviceAddress(obj)).append(" ").append(BluetoothReflection.getBluetoothDeviceName(obj)).append(".").toString());
    }

    private boolean connect(String s, String s1, String s2)
    {
        Object obj1 = BluetoothReflection.getBluetoothAdapter();
        if (obj1 == null)
        {
            form.dispatchErrorOccurredEvent(this, s, 501, new Object[0]);
            return false;
        }
        if (!BluetoothReflection.isBluetoothEnabled(obj1))
        {
            form.dispatchErrorOccurredEvent(this, s, 502, new Object[0]);
            return false;
        }
        int i = s1.indexOf(" ");
        Object obj = s1;
        if (i != -1)
        {
            obj = s1.substring(0, i);
        }
        if (!BluetoothReflection.checkBluetoothAddress(obj1, ((String) (obj))))
        {
            form.dispatchErrorOccurredEvent(this, s, 503, new Object[0]);
            return false;
        }
        s1 = ((String) (BluetoothReflection.getRemoteDevice(obj1, ((String) (obj)))));
        if (!BluetoothReflection.isBonded(s1))
        {
            form.dispatchErrorOccurredEvent(this, s, 504, new Object[0]);
            return false;
        }
        if (!isDeviceClassAcceptable(s1))
        {
            form.dispatchErrorOccurredEvent(this, s, 505, new Object[0]);
            return false;
        }
        try
        {
            obj = UUID.fromString(s2);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            form.dispatchErrorOccurredEvent(this, s, 506, new Object[] {
                s2
            });
            return false;
        }
        Disconnect();
        try
        {
            connect(s1, ((UUID) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            Disconnect();
            form.dispatchErrorOccurredEvent(this, s, 507, new Object[0]);
            return false;
        }
        return true;
    }

    private boolean isDeviceClassAcceptable(Object obj)
    {
        if (acceptableDeviceClasses == null)
        {
            return true;
        }
        obj = BluetoothReflection.getBluetoothClass(obj);
        if (obj == null)
        {
            return false;
        } else
        {
            int i = BluetoothReflection.getDeviceClass(obj);
            return acceptableDeviceClasses.contains(Integer.valueOf(i));
        }
    }

    public List AddressesAndNames()
    {
        ArrayList arraylist = new ArrayList();
        Object obj = BluetoothReflection.getBluetoothAdapter();
        if (obj != null && BluetoothReflection.isBluetoothEnabled(obj))
        {
            obj = BluetoothReflection.getBondedDevices(obj).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                Object obj1 = ((Iterator) (obj)).next();
                if (isDeviceClassAcceptable(obj1))
                {
                    String s = BluetoothReflection.getBluetoothDeviceName(obj1);
                    obj1 = BluetoothReflection.getBluetoothDeviceAddress(obj1);
                    arraylist.add((new StringBuilder()).append(((String) (obj1))).append(" ").append(s).toString());
                }
            } while (true);
        }
        return arraylist;
    }

    public boolean Connect(String s)
    {
        return connect("Connect", s, "00001101-0000-1000-8000-00805F9B34FB");
    }

    public boolean ConnectWithUUID(String s, String s1)
    {
        return connect("ConnectWithUUID", s, s1);
    }

    public boolean IsDevicePaired(String s)
    {
        Object obj = BluetoothReflection.getBluetoothAdapter();
        if (obj == null)
        {
            form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 501, new Object[0]);
            return false;
        }
        if (!BluetoothReflection.isBluetoothEnabled(obj))
        {
            form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 502, new Object[0]);
            return false;
        }
        int i = s.indexOf(" ");
        String s1 = s;
        if (i != -1)
        {
            s1 = s.substring(0, i);
        }
        if (!BluetoothReflection.checkBluetoothAddress(obj, s1))
        {
            form.dispatchErrorOccurredEvent(this, "IsDevicePaired", 503, new Object[0]);
            return false;
        } else
        {
            return BluetoothReflection.isBonded(BluetoothReflection.getRemoteDevice(obj, s1));
        }
    }

    boolean attachComponent(Component component, Set set)
    {
        boolean flag1 = false;
        if (!attachedComponents.isEmpty()) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (set == null)
        {
            set = null;
        } else
        {
            set = new HashSet(set);
        }
        acceptableDeviceClasses = set;
_L7:
        attachedComponents.add(component);
        flag = true;
_L4:
        return flag;
_L2:
        if (acceptableDeviceClasses == null)
        {
            if (set != null)
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (set == null) goto _L4; else goto _L3
_L3:
        flag = flag1;
        if (!acceptableDeviceClasses.containsAll(set)) goto _L4; else goto _L5
_L5:
        if (!set.containsAll(acceptableDeviceClasses))
        {
            return false;
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    void detachComponent(Component component)
    {
        attachedComponents.remove(component);
        if (attachedComponents.isEmpty())
        {
            acceptableDeviceClasses = null;
        }
    }
}
