// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            NanoHTTPD

private class <init>
    implements ThreadFactory
{

    final NanoHTTPD this$0;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(new ThreadGroup("biggerstack"), runnable, "HTTPD Session", 0x40000L);
        runnable.setDaemon(true);
        return runnable;
    }

    private ()
    {
        this$0 = NanoHTTPD.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
