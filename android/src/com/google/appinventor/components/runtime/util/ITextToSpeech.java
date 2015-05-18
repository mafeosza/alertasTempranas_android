// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import java.util.Locale;

public interface ITextToSpeech
{
    public static interface TextToSpeechCallback
    {

        public abstract void onFailure();

        public abstract void onSuccess();
    }


    public abstract boolean isInitialized();

    public abstract int isLanguageAvailable(Locale locale);

    public abstract void onDestroy();

    public abstract void onResume();

    public abstract void onStop();

    public abstract void setPitch(float f);

    public abstract void setSpeechRate(float f);

    public abstract void speak(String s, Locale locale);
}
