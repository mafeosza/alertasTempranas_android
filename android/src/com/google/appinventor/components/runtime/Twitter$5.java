// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.io.File;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Twitter, Form

class val.status
    implements Runnable
{

    final com.google.appinventor.components.runtime.Twitter this$0;
    final String val$imagePath;
    final String val$status;

    public void run()
    {
        String s = val$imagePath;
        Object obj = s;
        if (s.startsWith("file://"))
        {
            obj = val$imagePath.replace("file://", "");
        }
        obj = new File(((String) (obj)));
        if (((File) (obj)).exists())
        {
            StatusUpdate statusupdate = new StatusUpdate(val$status);
            statusupdate.setMedia(((File) (obj)));
            Twitter.access$200(com.google.appinventor.components.runtime.Twitter.this).updateStatus(statusupdate);
            return;
        }
        try
        {
            form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "TweetWithImage", 315, new Object[0]);
            return;
        }
        catch (TwitterException twitterexception)
        {
            form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "TweetWithImage", 306, new Object[] {
                twitterexception.getMessage()
            });
        }
        return;
    }

    _cls9()
    {
        this$0 = final_twitter;
        val$imagePath = s;
        val$status = String.this;
        super();
    }
}
