// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.util.Locale;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            InternalTextToSpeech

class val.loc
    implements Runnable
{

    final InternalTextToSpeech this$0;
    final Locale val$loc;
    final String val$message;
    final int val$retries;

    public void run()
    {
        Log.d("InternalTTS", (new StringBuilder()).append("delaying call to speak.  Retries is: ").append(val$retries).append(" Message is: ").append(val$message).toString());
        InternalTextToSpeech.access$300(InternalTextToSpeech.this, val$message, val$loc, val$retries + 1);
    }

    ()
    {
        this$0 = final_internaltexttospeech;
        val$retries = i;
        val$message = s;
        val$loc = Locale.this;
        super();
    }
}
