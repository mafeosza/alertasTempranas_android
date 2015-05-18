// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import android.util.Log;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Voting

class this._cls1
    implements Runnable
{

    final erviceError this$1;

    public void run()
    {
        WebServiceError("The Web server did not respond to your request for a ballot");
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/Voting$2

/* anonymous class */
    class Voting._cls2
        implements AsyncCallbackPair
    {

        final Voting this$0;

        public void onFailure(final String message)
        {
            Log.w("Voting", (new StringBuilder()).append("postRequestBallot Failure ").append(message).toString());
            Voting.access$100(Voting.this).post(new Voting._cls2._cls5());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((JSONObject)obj);
        }

        public void onSuccess(JSONObject jsonobject)
        {
            if (jsonobject == null)
            {
                Voting.access$100(Voting.this).post(new Voting._cls2._cls1());
                return;
            }
            try
            {
                Log.i("Voting", (new StringBuilder()).append("postRequestBallot: ballot retrieved ").append(jsonobject).toString());
                Voting.access$202(Voting.this, Boolean.valueOf(jsonobject.getBoolean("isPolling")));
                if (Voting.access$200(Voting.this).booleanValue())
                {
                    Voting.access$302(Voting.this, Boolean.valueOf(jsonobject.getBoolean("idRequested")));
                    Voting.access$402(Voting.this, jsonobject.getString("question"));
                    Voting.access$502(Voting.this, jsonobject.getString("options"));
                    Voting.access$602(Voting.this, Voting.access$700(Voting.this, new JSONArray(Voting.access$500(Voting.this))));
                    Voting.access$100(Voting.this).post(new Voting._cls2._cls2());
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                Voting.access$100(Voting.this).post(new Voting._cls2._cls4());
                return;
            }
            Voting.access$100(Voting.this).post(new Voting._cls2._cls3());
            return;
        }

            
            {
                this$0 = Voting.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/Voting$2$2

/* anonymous class */
        class Voting._cls2._cls2
            implements Runnable
        {

            final Voting._cls2 this$1;

            public void run()
            {
                GotBallot();
            }

                    
                    {
                        this$1 = Voting._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/Voting$2$3

/* anonymous class */
        class Voting._cls2._cls3
            implements Runnable
        {

            final Voting._cls2 this$1;

            public void run()
            {
                NoOpenPoll();
            }

                    
                    {
                        this$1 = Voting._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/Voting$2$4

/* anonymous class */
        class Voting._cls2._cls4
            implements Runnable
        {

            final Voting._cls2 this$1;

            public void run()
            {
                WebServiceError("The Web server returned a garbled object");
            }

                    
                    {
                        this$1 = Voting._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/Voting$2$5

/* anonymous class */
        class Voting._cls2._cls5
            implements Runnable
        {

            final Voting._cls2 this$1;
            final String val$message;

            public void run()
            {
                WebServiceError(message);
            }

                    
                    {
                        this$1 = Voting._cls2.this;
                        message = s;
                        super();
                    }
        }

    }

}
