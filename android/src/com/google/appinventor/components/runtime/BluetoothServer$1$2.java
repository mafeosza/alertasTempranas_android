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

class val.bluetoothSocket
    implements Runnable
{

    final ectionAccepted this$1;
    final Object val$bluetoothSocket;

    public void run()
    {
        try
        {
            setConnection(val$bluetoothSocket);
        }
        catch (IOException ioexception)
        {
            Disconnect();
            form.dispatchErrorOccurredEvent(_fld0, functionName, 509, new Object[0]);
            return;
        }
        ConnectionAccepted();
    }

    l.functionName()
    {
        this$1 = final_functionname;
        val$bluetoothSocket = Object.this;
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
            Object obj;
            Object obj2;
            obj = null;
            obj2 = BluetoothServer.access$000(BluetoothServer.this).get();
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_29;
            }
            obj = BluetoothReflection.accept(obj2);
            StopAccepting();
            if (obj != null)
            {
                BluetoothServer.access$100(BluetoothServer.this).post(((BluetoothServer._cls1._cls2) (obj)). new BluetoothServer._cls1._cls2());
            }
            return;
            Object obj1;
            obj1;
            BluetoothServer.access$100(BluetoothServer.this).post(new BluetoothServer._cls1._cls1());
            StopAccepting();
            return;
            obj1;
            StopAccepting();
            throw obj1;
        }

            
            {
                this$0 = final_bluetoothserver;
                functionName = String.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/BluetoothServer$1$1

/* anonymous class */
        class BluetoothServer._cls1._cls1
            implements Runnable
        {

            final BluetoothServer._cls1 this$1;

            public void run()
            {
                form.dispatchErrorOccurredEvent(this$0, functionName, 509, new Object[0]);
            }

                    
                    {
                        this$1 = BluetoothServer._cls1.this;
                        super();
                    }
        }

    }

}
