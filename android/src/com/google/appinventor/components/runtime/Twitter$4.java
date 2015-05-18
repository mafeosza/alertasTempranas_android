// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import twitter4j.Twitter;
import twitter4j.TwitterException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Twitter, Form

class val.status
    implements Runnable
{

    final com.google.appinventor.components.runtime.Twitter this$0;
    final String val$status;

    public void run()
    {
        try
        {
            Twitter.access$200(com.google.appinventor.components.runtime.Twitter.this).updateStatus(val$status);
            return;
        }
        catch (TwitterException twitterexception)
        {
            form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "Tweet", 306, new Object[] {
                twitterexception.getMessage()
            });
        }
    }

    _cls9()
    {
        this$0 = final_twitter;
        val$status = String.this;
        super();
    }
}
