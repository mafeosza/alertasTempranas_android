// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            BluetoothConnectionBase

interface BluetoothConnectionListener
{

    public abstract void afterConnect(BluetoothConnectionBase bluetoothconnectionbase);

    public abstract void beforeDisconnect(BluetoothConnectionBase bluetoothconnectionbase);
}
