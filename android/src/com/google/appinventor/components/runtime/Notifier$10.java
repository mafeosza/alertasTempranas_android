// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Notifier

class val.notice
    implements Runnable
{

    final Notifier this$0;
    final String val$notice;

    public void run()
    {
        Notifier.access$000(Notifier.this, val$notice);
    }

    ()
    {
        this$0 = final_notifier;
        val$notice = String.this;
        super();
    }
}
