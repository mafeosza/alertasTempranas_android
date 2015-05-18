// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.os.Handler;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            AsynchUtil

class this._cls0
    implements Runnable
{

    final l.callback this$0;

    public void run()
    {
        callback.run();
    }

    l.androidUIHandler()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/util/AsynchUtil$1

/* anonymous class */
    static final class AsynchUtil._cls1
        implements Runnable
    {

        final Handler val$androidUIHandler;
        final Runnable val$call;
        final Runnable val$callback;

        public void run()
        {
            call.run();
            if (callback != null)
            {
                androidUIHandler.post(new AsynchUtil._cls1._cls1());
            }
        }

            
            {
                call = runnable;
                callback = runnable1;
                androidUIHandler = handler;
                super();
            }
    }

}
