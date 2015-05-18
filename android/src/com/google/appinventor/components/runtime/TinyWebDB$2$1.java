// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TinyWebDB

class this._cls1
    implements Runnable
{

    final eStored this$1;

    public void run()
    {
        ValueStored();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/TinyWebDB$2

/* anonymous class */
    class TinyWebDB._cls2
        implements AsyncCallbackPair
    {

        final TinyWebDB this$0;

        public void onFailure(final String message)
        {
            TinyWebDB.access$100(TinyWebDB.this).post(new TinyWebDB._cls2._cls2());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((String)obj);
        }

        public void onSuccess(String s)
        {
            TinyWebDB.access$100(TinyWebDB.this).post(new TinyWebDB._cls2._cls1());
        }

            
            {
                this$0 = TinyWebDB.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/TinyWebDB$2$2

/* anonymous class */
        class TinyWebDB._cls2._cls2
            implements Runnable
        {

            final TinyWebDB._cls2 this$1;
            final String val$message;

            public void run()
            {
                WebServiceError(message);
            }

                    
                    {
                        this$1 = TinyWebDB._cls2.this;
                        message = s;
                        super();
                    }
        }

    }

}
