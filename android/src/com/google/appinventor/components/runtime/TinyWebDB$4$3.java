// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.JsonUtil;
import org.json.JSONArray;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TinyWebDB

class this._cls1
    implements Runnable
{

    final l.tag this$1;

    public void run()
    {
        WebServiceError((new StringBuilder()).append("The Web server returned a garbled value for the tag ").append(tag).append(".").toString());
    }

    l.tag()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/TinyWebDB$4

/* anonymous class */
    class TinyWebDB._cls4
        implements AsyncCallbackPair
    {

        final TinyWebDB this$0;
        final String val$tag;

        public void onFailure(final String message)
        {
            TinyWebDB.access$100(TinyWebDB.this).post(new TinyWebDB._cls4._cls4());
        }

        public volatile void onSuccess(Object obj)
        {
            onSuccess((JSONArray)obj);
        }

        public void onSuccess(final JSONArray valueFromWebDB)
        {
            if (valueFromWebDB == null)
            {
                TinyWebDB.access$100(TinyWebDB.this).post(new TinyWebDB._cls4._cls1());
                return;
            }
            final String tagFromWebDB;
            tagFromWebDB = valueFromWebDB.getString(1);
            valueFromWebDB = valueFromWebDB.getString(2);
            if (valueFromWebDB.length() != 0)
            {
                break MISSING_BLOCK_LABEL_89;
            }
            valueFromWebDB = "";
_L1:
            try
            {
                TinyWebDB.access$100(TinyWebDB.this).post(new TinyWebDB._cls4._cls2());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (final JSONArray valueFromWebDB)
            {
                TinyWebDB.access$100(TinyWebDB.this).post(new TinyWebDB._cls4._cls3());
            }
            return;
            valueFromWebDB = ((JSONArray) (JsonUtil.getObjectFromJson(valueFromWebDB)));
              goto _L1
        }

            
            {
                this$0 = final_tinywebdb;
                tag = String.this;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/TinyWebDB$4$1

/* anonymous class */
        class TinyWebDB._cls4._cls1
            implements Runnable
        {

            final TinyWebDB._cls4 this$1;

            public void run()
            {
                WebServiceError((new StringBuilder()).append("The Web server did not respond to the get value request for the tag ").append(tag).append(".").toString());
            }

                    
                    {
                        this$1 = TinyWebDB._cls4.this;
                        super();
                    }
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/TinyWebDB$4$2

/* anonymous class */
        class TinyWebDB._cls4._cls2
            implements Runnable
        {

            final TinyWebDB._cls4 this$1;
            final String val$tagFromWebDB;
            final Object val$valueFromWebDB;

            public void run()
            {
                GotValue(tagFromWebDB, valueFromWebDB);
            }

                    
                    {
                        this$1 = TinyWebDB._cls4.this;
                        tagFromWebDB = s;
                        valueFromWebDB = obj;
                        super();
                    }
        }


        // Unreferenced inner class com/google/appinventor/components/runtime/TinyWebDB$4$4

/* anonymous class */
        class TinyWebDB._cls4._cls4
            implements Runnable
        {

            final TinyWebDB._cls4 this$1;
            final String val$message;

            public void run()
            {
                WebServiceError(message);
            }

                    
                    {
                        this$1 = TinyWebDB._cls4.this;
                        message = s;
                        super();
                    }
        }

    }

}
