// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Twitter, Form

class messages
    implements Runnable
{

    List messages;
    final com.google.appinventor.components.runtime.Twitter this$0;

    public void run()
    {
        messages = Twitter.access$200(com.google.appinventor.components.runtime.Twitter.this).getDirectMessages();
        Twitter.access$100(com.google.appinventor.components.runtime.Twitter.this).post(new Runnable() {

            final Twitter._cls8 this$1;

            public void run()
            {
                Twitter.access$1300(this$0).clear();
                DirectMessage directmessage;
                for (Iterator iterator = messages.iterator(); iterator.hasNext(); Twitter.access$1300(this$0).add((new StringBuilder()).append(directmessage.getSenderScreenName()).append(" ").append(directmessage.getText()).toString()))
                {
                    directmessage = (DirectMessage)iterator.next();
                }

                DirectMessagesReceived(Twitter.access$1300(this$0));
            }

            
            {
                this$1 = Twitter._cls8.this;
                super();
            }
        });
        return;
        Object obj;
        obj;
        form.dispatchErrorOccurredEvent(com.google.appinventor.components.runtime.Twitter.this, "RequestDirectMessages", 309, new Object[] {
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
