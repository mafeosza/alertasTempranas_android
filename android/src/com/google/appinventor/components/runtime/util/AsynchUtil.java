// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.os.Handler;

public class AsynchUtil
{

    public AsynchUtil()
    {
    }

    public static void runAsynchronously(Handler handler, Runnable runnable, Runnable runnable1)
    {
        (new Thread(new Runnable(runnable, runnable1, handler) {

            final Handler val$androidUIHandler;
            final Runnable val$call;
            final Runnable val$callback;

            public void run()
            {
                call.run();
                if (callback != null)
                {
                    androidUIHandler.post(new Runnable() {

                        final _cls1 this$0;

                        public void run()
                        {
                            callback.run();
                        }

            
            {
                this$0 = _cls1.this;
                super();
            }
                    });
                }
            }

            
            {
                call = runnable;
                callback = runnable1;
                androidUIHandler = handler;
                super();
            }
        })).start();
    }

    public static void runAsynchronously(Runnable runnable)
    {
        (new Thread(runnable)).start();
    }
}
