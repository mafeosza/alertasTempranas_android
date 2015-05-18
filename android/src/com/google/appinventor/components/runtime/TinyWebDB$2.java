// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TinyWebDB

class this._cls0
    implements AsyncCallbackPair
{

    final TinyWebDB this$0;

    public void onFailure(final String message)
    {
        TinyWebDB.access$100(TinyWebDB.this).post(new Runnable() {

            final TinyWebDB._cls2 this$1;
            final String val$message;

            public void run()
            {
                WebServiceError(message);
            }

            
            {
                this$1 = TinyWebDB._cls2.this;
                message = s;
                super();
            }
        });
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(String s)
    {
        TinyWebDB.access$100(TinyWebDB.this).post(new Runnable() {

            final TinyWebDB._cls2 this$1;

            public void run()
            {
                ValueStored();
            }

            
            {
                this$1 = TinyWebDB._cls2.this;
                super();
            }
        });
    }

    _cls2.val.message()
    {
        this$0 = TinyWebDB.this;
        super();
    }
}
