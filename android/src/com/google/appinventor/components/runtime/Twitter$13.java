// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Twitter, Form

class tweets
    implements Runnable
{

    final com.google.appinventor.components.runtime.Twitter this$0;
    List tweets;
    final String val$query;

    public void run()
    {
        tweets = Twitter.access$200(com.google.appinventor.components.runtime.Twitter.this).search(new Query(val$query)).getTweets();
        Twitter.access$100(com.google.appinventor.components.runtime.Twitter.this).post(new Runnable() {

            final Twitter._cls13 this$1;

            public void run()
            {
                Twitter.access$1500(this$0).clear();
                Status status;
                for (Iterator iterator = tweets.iterator(); iterator.hasNext(); Twitter.access$1500(this$0).add((new StringBuilder()).append(status.getUser().getName()).append(" ").append(status.getText()).toString()))
                {
                    status = (Status)iterator.next();
                }

                SearchSuccessful(Twitter.access$1500(this$0));
            }

            
            {
                this$1 = Twitter._cls13.this;
                super();
            }
        });
        return;
        Object obj;
        obj;
        form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "SearchTwitter", 314, new Object[] {
            ((TwitterException) (obj)).getMessage()
        });
        Twitter.access$100(com.google.appinventor.components.runtime.Twitter.this).post(new _cls1());
        return;
        obj;
        Twitter.access$100(com.google.appinventor.components.runtime.Twitter.this).post(new _cls1());
        throw obj;
    }

    _cls1.this._cls1()
    {
        this$0 = final_twitter;
        val$query = String.this;
        super();
        tweets = Collections.emptyList();
    }
}
