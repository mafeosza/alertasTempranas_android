// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Voting

class val.message
    implements Runnable
{

    final val.message this$1;
    final String val$message;

    public void run()
    {
        WebServiceError(val$message);
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$message = String.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/Voting$4

/* anonymous class */
    class Voting._cls4
        implements AsyncCallbackPair
    {

        final Voting this$0;

        public void onFailure(String s)
        {
            Log.w("Voting", (new StringBuilder()).append("postSendBallot Failure ").append(s).toString());
            Voting.access$100(Voting.this).post(s. new Voting._cls4._cls2());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((String)obj);
        }

        public void onSuccess(String s)
        {
            Voting.access$100(Voting.this).post(new Voting._cls4._cls1());
        }

            
            {
                this$0 = Voting.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/Voting$4$1

/* anonymous class */
        class Voting._cls4._cls1
            implements Runnable
        {

            final Voting._cls4 this$1;

            public void run()
            {
                GotBallotConfirmation();
            }

                    
                    {
                        this$1 = Voting._cls4.this;
                        super();
                    }
        }

    }

}
