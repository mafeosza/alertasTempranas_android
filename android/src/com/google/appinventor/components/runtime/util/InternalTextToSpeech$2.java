// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            InternalTextToSpeech

class this._cls0
    implements android.speech.tts.eCompletedListener
{

    final InternalTextToSpeech this$0;

    public void onUtteranceCompleted(String s)
    {
        InternalTextToSpeech.access$200(InternalTextToSpeech.this).runOnUiThread(new Runnable() {

            final InternalTextToSpeech._cls2 this$1;

            public void run()
            {
                InternalTextToSpeech.access$100(this$0).onSuccess();
            }

            
            {
                this$1 = InternalTextToSpeech._cls2.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = InternalTextToSpeech.this;
        super();
    }
}
