// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.BluetoothReflection;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package com.google.appinventor.components.runtime:
//            BluetoothServer, Form

class this._cls1
    implements Runnable
{

    final l.functionName this$1;

    public void run()
    {
        form.dispatchErrorOccurredEvent(_fld0, functionName, 509, new Object[0]);
    }

    l.functionName()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/BluetoothServer$1

/* anonymous class */
    class BluetoothServer._cls1
        implements Runnable
    {

        final BluetoothServer this$0;
        final String val$functionName;

        public void run()
        {
            final Object bluetoothSocket;
            Object obj1;
            bluetoothSocket = null;
            obj1 = BluetoothServer.access$000(BluetoothServer.this).get();
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            bluetoothSocket = BluetoothReflection.accept(obj1);
            StopAccepting();
            if (bluetoothSocket != null)
            {
                BluetoothServer.access$100(BluetoothServer.this).post(new BluetoothServer._cls1._cls2());
            }
            return;
            Object obj;
            obj;
            BluetoothServer.access$100(BluetoothServer.this).post(new BluetoothServer._cls1._cls1());
            StopAccepting();
            return;
            obj;
            StopAccepting();
            throw obj;
        }

            
            {
                this$0 = final_bluetoothserver;
                functionName = String.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/BluetoothServer$1$2

/* anonymous class */
        class BluetoothServer._cls1._cls2
            implements Runnable
        {

            final BluetoothServer._cls1 this$1;
            final Object val$bluetoothSocket;

            public void run()
            {
                try
                {
                    setConnection(bluetoothSocket);
                }
                catch (IOException ioexception)
                {
                    Disconnect();
                    form.dispatchErrorOccurredEvent(this$0, functionName, 509, new Object[0]);
                    return;
                }
                ConnectionAccepted();
            }

                    
                    {
                        this$1 = BluetoothServer._cls1.this;
                        bluetoothSocket = obj;
                        super();
                    }
        }

    }

}
