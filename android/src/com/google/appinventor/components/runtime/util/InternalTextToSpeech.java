// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import java.util.HashMap;
import java.util.Locale;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            ITextToSpeech

public class InternalTextToSpeech
    implements ITextToSpeech
{

    private static final String LOG_TAG = "InternalTTS";
    private final Activity activity;
    private final ITextToSpeech.TextToSpeechCallback callback;
    private volatile boolean isTtsInitialized;
    private Handler mHandler;
    private int nextUtteranceId;
    private TextToSpeech tts;
    private int ttsMaxRetries;
    private int ttsRetryDelay;

    public InternalTextToSpeech(Activity activity1, ITextToSpeech.TextToSpeechCallback texttospeechcallback)
    {
        mHandler = new Handler();
        nextUtteranceId = 1;
        ttsRetryDelay = 500;
        ttsMaxRetries = 20;
        activity = activity1;
        callback = texttospeechcallback;
        initializeTts();
    }

    private void initializeTts()
    {
        if (tts == null)
        {
            Log.d("InternalTTS", "INTERNAL TTS is reinitializing");
            tts = new TextToSpeech(activity, new android.speech.tts.TextToSpeech.OnInitListener() {

                final InternalTextToSpeech this$0;

                public void onInit(int i)
                {
                    if (i == 0)
                    {
                        isTtsInitialized = true;
                    }
                }

            
            {
                this$0 = InternalTextToSpeech.this;
                super();
            }
            });
        }
    }

    private void speak(final String message, final Locale loc, final int retries)
    {
        Log.d("InternalTTS", (new StringBuilder()).append("InternalTTS speak called, message = ").append(message).toString());
        if (retries > ttsMaxRetries)
        {
            Log.d("InternalTTS", "max number of speak retries exceeded: speak will fail");
            callback.onFailure();
        }
        if (isTtsInitialized)
        {
            Log.d("InternalTTS", (new StringBuilder()).append("TTS initialized after ").append(retries).append(" retries.").toString());
            tts.setLanguage(loc);
            tts.setOnUtteranceCompletedListener(new android.speech.tts.TextToSpeech.OnUtteranceCompletedListener() {

                final InternalTextToSpeech this$0;

                public void onUtteranceCompleted(String s)
                {
                    activity.runOnUiThread(new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            callback.onSuccess();
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                }

            
            {
                this$0 = InternalTextToSpeech.this;
                super();
            }
            });
            loc = new HashMap();
            retries = nextUtteranceId;
            nextUtteranceId = retries + 1;
            loc.put("utteranceId", Integer.toString(retries));
            TextToSpeech texttospeech = tts;
            TextToSpeech texttospeech1 = tts;
            if (texttospeech.speak(message, 0, loc) == -1)
            {
                Log.d("InternalTTS", "speak called and tts.speak result was an error");
                callback.onFailure();
            }
            return;
        } else
        {
            Log.d("InternalTTS", "speak called when TTS not initialized");
            mHandler.postDelayed(new Runnable() {

                final InternalTextToSpeech this$0;
                final Locale val$loc;
                final String val$message;
                final int val$retries;

                public void run()
                {
                    Log.d("InternalTTS", (new StringBuilder()).append("delaying call to speak.  Retries is: ").append(retries).append(" Message is: ").append(message).toString());
                    speak(message, loc, retries + 1);
                }

            
            {
                this$0 = InternalTextToSpeech.this;
                retries = i;
                message = s;
                loc = locale;
                super();
            }
            }, ttsRetryDelay);
            return;
        }
    }

    public boolean isInitialized()
    {
        return isTtsInitialized;
    }

    public int isLanguageAvailable(Locale locale)
    {
        return tts.isLanguageAvailable(locale);
    }

    public void onDestroy()
    {
        Log.d("InternalTTS", "Internal TTS got onDestroy");
        if (tts != null)
        {
            tts.shutdown();
            isTtsInitialized = false;
            tts = null;
        }
    }

    public void onResume()
    {
        Log.d("InternalTTS", "Internal TTS got onResume");
        initializeTts();
    }

    public void onStop()
    {
        Log.d("InternalTTS", "Internal TTS got onStop");
    }

    public void setPitch(float f)
    {
        tts.setPitch(f);
    }

    public void setSpeechRate(float f)
    {
        tts.setSpeechRate(f);
    }

    public void speak(String s, Locale locale)
    {
        Log.d("InternalTTS", "Internal TTS got speak");
        speak(s, locale, 0);
    }


/*
    static boolean access$002(InternalTextToSpeech internaltexttospeech, boolean flag)
    {
        internaltexttospeech.isTtsInitialized = flag;
        return flag;
    }

*/



}
