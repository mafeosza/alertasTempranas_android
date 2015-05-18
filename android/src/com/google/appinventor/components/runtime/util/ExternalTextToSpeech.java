// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.Intent;
import com.google.appinventor.components.runtime.ActivityResultListener;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.Form;
import java.util.Locale;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            ITextToSpeech

public class ExternalTextToSpeech
    implements ITextToSpeech, ActivityResultListener
{

    private static final String TTS_INTENT = "com.google.tts.makeBagel";
    private final ITextToSpeech.TextToSpeechCallback callback;
    private final ComponentContainer container;
    private int requestCode;

    public ExternalTextToSpeech(ComponentContainer componentcontainer, ITextToSpeech.TextToSpeechCallback texttospeechcallback)
    {
        container = componentcontainer;
        callback = texttospeechcallback;
    }

    public boolean isInitialized()
    {
        return true;
    }

    public int isLanguageAvailable(Locale locale)
    {
        return -1;
    }

    public void onDestroy()
    {
    }

    public void onResume()
    {
    }

    public void onStop()
    {
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        if (i == requestCode && j == -1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            callback.onSuccess();
            return;
        } else
        {
            callback.onFailure();
            return;
        }
    }

    public void setPitch(float f)
    {
    }

    public void setSpeechRate(float f)
    {
    }

    public void speak(String s, Locale locale)
    {
        Intent intent = new Intent("com.google.tts.makeBagel");
        intent.setFlags(0x20000);
        intent.setFlags(0x800000);
        intent.setFlags(0x40000000);
        intent.putExtra("message", s);
        intent.putExtra("language", locale.getISO3Language());
        intent.putExtra("country", locale.getISO3Country());
        if (requestCode == 0)
        {
            requestCode = container.$form().registerForActivityResult(this);
        }
        container.$context().startActivityForResult(intent, requestCode);
    }
}
