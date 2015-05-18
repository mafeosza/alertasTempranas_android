// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            InternalTextToSpeech

class this._cls1
    implements Runnable
{

    final hCallback.onSuccess this$1;

    public void run()
    {
        InternalTextToSpeech.access$100(_fld0).onSuccess();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/util/InternalTextToSpeech$2

/* anonymous class */
    class InternalTextToSpeech._cls2
        implements android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
    {

        final InternalTextToSpeech this$0;

        public void onUtteranceCompleted(String s)
        {
            InternalTextToSpeech.access$200(InternalTextToSpeech.this).runOnUiThread(new InternalTextToSpeech._cls2._cls1());
        }

            
            {
                this$0 = InternalTextToSpeech.this;
                super();
            }
    }

}
