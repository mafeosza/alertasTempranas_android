// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import twitter4j.Twitter;
import twitter4j.TwitterException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Twitter, Form

class val.user
    implements Runnable
{

    final com.google.appinventor.components.runtime.Twitter this$0;
    final String val$user;

    public void run()
    {
        try
        {
            Twitter.access$200(com.google.appinventor.components.runtime.Twitter.this).destroyFriendship(val$user);
            return;
        }
        catch (TwitterException twitterexception)
        {
            form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "StopFollowing", 312, new Object[] {
                twitterexception.getMessage()
            });
        }
    }

    ()
    {
        this$0 = final_twitter;
        val$user = String.this;
        super();
    }
}
