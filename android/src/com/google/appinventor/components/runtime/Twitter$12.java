// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Twitter, Form

class messages
    implements Runnable
{

    List messages;
    final com.google.appinventor.components.runtime.Twitter this$0;

    public void run()
    {
        messages = Twitter.access$200(com.google.appinventor.components.runtime.Twitter.this).getHomeTimeline();
        Twitter.access$100(com.google.appinventor.components.runtime.Twitter.this).post(new Runnable() {

            final Twitter._cls12 this$1;

            public void run()
            {
                Twitter.access$1400(this$0).clear();
                ArrayList arraylist;
                for (Iterator iterator = messages.iterator(); iterator.hasNext(); Twitter.access$1400(this$0).add(arraylist))
                {
                    Status status = (Status)iterator.next();
                    arraylist = new ArrayList();
                    arraylist.add(status.getUser().getScreenName());
                    arraylist.add(status.getText());
                }

                FriendTimelineReceived(Twitter.access$1400(this$0));
            }

            
            {
                this$1 = Twitter._cls12.this;
                super();
            }
        });
        return;
        Object obj;
        obj;
        form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "RequestFriendTimeline", 313, new Object[] {
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
        this$0 = com.google.appinventor.components.runtime.Twitter.this;
        super();
        messages = Collections.emptyList();
    }
}
