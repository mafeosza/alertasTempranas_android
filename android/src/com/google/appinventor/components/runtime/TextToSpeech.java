// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.ExternalTextToSpeech;
import com.google.appinventor.components.runtime.util.ITextToSpeech;
import com.google.appinventor.components.runtime.util.InternalTextToSpeech;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, OnStopListener, OnResumeListener, 
//            OnDestroyListener, ComponentContainer, Form, EventDispatcher

public class TextToSpeech extends AndroidNonvisibleComponent
    implements Component, OnStopListener, OnResumeListener, OnDestroyListener
{

    private static final String LOG_TAG = "TextToSpeech";
    private static final Map iso3CountryToLocaleMap = Maps.newHashMap();
    private static final Map iso3LanguageToLocaleMap = Maps.newHashMap();
    private YailList allCountries;
    private YailList allLanguages;
    private String country;
    private ArrayList countryList;
    private boolean isTtsPrepared;
    private String iso2Country;
    private String iso2Language;
    private String language;
    private ArrayList languageList;
    private float pitch;
    private boolean result;
    private float speechRate;
    private final ITextToSpeech tts;

    public TextToSpeech(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        pitch = 1.0F;
        speechRate = 1.0F;
        result = false;
        Language("");
        Country("");
        Object obj;
        StringBuilder stringbuilder;
        boolean flag;
        if (SdkLevel.getLevel() < 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        stringbuilder = (new StringBuilder()).append("Using ");
        if (flag)
        {
            obj = "external";
        } else
        {
            obj = "internal";
        }
        Log.v("TextToSpeech", stringbuilder.append(((String) (obj))).append(" TTS library.").toString());
        obj = new com.google.appinventor.components.runtime.util.ITextToSpeech.TextToSpeechCallback() {

            final TextToSpeech this$0;

            public void onFailure()
            {
                result = false;
                AfterSpeaking(false);
            }

            public void onSuccess()
            {
                result = true;
                AfterSpeaking(true);
            }

            
            {
                this$0 = TextToSpeech.this;
                super();
            }
        };
        if (flag)
        {
            componentcontainer = new ExternalTextToSpeech(componentcontainer, ((com.google.appinventor.components.runtime.util.ITextToSpeech.TextToSpeechCallback) (obj)));
        } else
        {
            componentcontainer = new InternalTextToSpeech(componentcontainer.$context(), ((com.google.appinventor.components.runtime.util.ITextToSpeech.TextToSpeechCallback) (obj)));
        }
        tts = componentcontainer;
        form.registerForOnStop(this);
        form.registerForOnResume(this);
        form.registerForOnDestroy(this);
        form.setVolumeControlStream(3);
        isTtsPrepared = false;
        languageList = new ArrayList();
        countryList = new ArrayList();
        allLanguages = YailList.makeList(languageList);
        allCountries = YailList.makeList(countryList);
    }

    private void getLanguageAndCountryLists()
    {
        if (SdkLevel.getLevel() >= 4)
        {
            Locale alocale[] = Locale.getAvailableLocales();
            int j = alocale.length;
            for (int i = 0; i < j; i++)
            {
                Object obj = alocale[i];
                if (tts.isLanguageAvailable(((Locale) (obj))) == -2)
                {
                    continue;
                }
                String s = ((Locale) (obj)).getLanguage();
                obj = ((Locale) (obj)).getISO3Country();
                if (!s.equals("") && !languageList.contains(s))
                {
                    languageList.add(s);
                }
                if (!((String) (obj)).equals("") && !countryList.contains(obj))
                {
                    countryList.add(obj);
                }
            }

            Collections.sort(languageList);
            Collections.sort(countryList);
            allLanguages = YailList.makeList(languageList);
            allCountries = YailList.makeList(countryList);
        }
    }

    private static void initLocaleMaps()
    {
        Locale alocale[] = Locale.getAvailableLocales();
        int j = alocale.length;
        int i = 0;
        while (i < j) 
        {
            Locale locale = alocale[i];
            try
            {
                String s = locale.getISO3Country();
                if (s.length() > 0)
                {
                    iso3CountryToLocaleMap.put(s, locale);
                }
            }
            catch (MissingResourceException missingresourceexception1) { }
            try
            {
                String s1 = locale.getISO3Language();
                if (s1.length() > 0)
                {
                    iso3LanguageToLocaleMap.put(s1, locale);
                }
            }
            catch (MissingResourceException missingresourceexception) { }
            i++;
        }
    }

    private static Locale iso3CountryToLocale(String s)
    {
        Locale locale1 = (Locale)iso3CountryToLocaleMap.get(s);
        Locale locale = locale1;
        if (locale1 == null)
        {
            locale = (Locale)iso3CountryToLocaleMap.get(s.toUpperCase(Locale.ENGLISH));
        }
        s = locale;
        if (locale == null)
        {
            s = Locale.getDefault();
        }
        return s;
    }

    private static Locale iso3LanguageToLocale(String s)
    {
        Locale locale1 = (Locale)iso3LanguageToLocaleMap.get(s);
        Locale locale = locale1;
        if (locale1 == null)
        {
            locale = (Locale)iso3LanguageToLocaleMap.get(s.toLowerCase(Locale.ENGLISH));
        }
        s = locale;
        if (locale == null)
        {
            s = Locale.getDefault();
        }
        return s;
    }

    public void AfterSpeaking(boolean flag)
    {
        EventDispatcher.dispatchEvent(this, "AfterSpeaking", new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public YailList AvailableCountries()
    {
        prepareLanguageAndCountryProperties();
        return allCountries;
    }

    public YailList AvailableLanguages()
    {
        prepareLanguageAndCountryProperties();
        return allLanguages;
    }

    public void BeforeSpeaking()
    {
        EventDispatcher.dispatchEvent(this, "BeforeSpeaking", new Object[0]);
    }

    public String Country()
    {
        return country;
    }

    public void Country(String s)
    {
        s.length();
        JVM INSTR tableswitch 2 3: default 28
    //                   2 65
    //                   3 49;
           goto _L1 _L2 _L3
_L1:
        s = Locale.getDefault();
        country = s.getCountry();
_L5:
        iso2Country = s.getCountry();
        return;
_L3:
        s = iso3CountryToLocale(s);
        country = s.getISO3Country();
        continue; /* Loop/switch isn't completed */
_L2:
        s = new Locale(s);
        country = s.getCountry();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String Language()
    {
        return language;
    }

    public void Language(String s)
    {
        s.length();
        JVM INSTR tableswitch 2 3: default 28
    //                   2 65
    //                   3 49;
           goto _L1 _L2 _L3
_L1:
        s = Locale.getDefault();
        language = s.getLanguage();
_L5:
        iso2Language = s.getLanguage();
        return;
_L3:
        s = iso3LanguageToLocale(s);
        language = s.getISO3Language();
        continue; /* Loop/switch isn't completed */
_L2:
        s = new Locale(s);
        language = s.getLanguage();
        if (true) goto _L5; else goto _L4
_L4:
    }

    public float Pitch()
    {
        return pitch;
    }

    public void Pitch(float f)
    {
        if (f < 0.0F || f > 2.0F)
        {
            Log.i("TextToSpeech", (new StringBuilder()).append("Pitch value should be between 0 and 2, but user specified: ").append(f).toString());
            return;
        }
        pitch = f;
        ITextToSpeech itexttospeech = tts;
        float f1 = f;
        if (f == 0.0F)
        {
            f1 = 0.1F;
        }
        itexttospeech.setPitch(f1);
    }

    public boolean Result()
    {
        return result;
    }

    public void Speak(String s)
    {
        BeforeSpeaking();
        Locale locale = new Locale(iso2Language, iso2Country);
        tts.speak(s, locale);
    }

    public float SpeechRate()
    {
        return speechRate;
    }

    public void SpeechRate(float f)
    {
        if (f < 0.0F || f > 2.0F)
        {
            Log.i("TextToSpeech", (new StringBuilder()).append("speechRate value should be between 0 and 2, but user specified: ").append(f).toString());
            return;
        }
        speechRate = f;
        ITextToSpeech itexttospeech = tts;
        float f1 = f;
        if (f == 0.0F)
        {
            f1 = 0.1F;
        }
        itexttospeech.setSpeechRate(f1);
    }

    public void onDestroy()
    {
        tts.onDestroy();
    }

    public void onResume()
    {
        tts.onResume();
    }

    public void onStop()
    {
        tts.onStop();
    }

    public void prepareLanguageAndCountryProperties()
    {
label0:
        {
            if (!isTtsPrepared)
            {
                if (tts.isInitialized())
                {
                    break label0;
                }
                form.dispatchErrorOccurredEvent(this, "TextToSpeech", 2701, new Object[0]);
                Speak("");
            }
            return;
        }
        getLanguageAndCountryLists();
        isTtsPrepared = true;
    }

    static 
    {
        initLocaleMaps();
    }


/*
    static boolean access$002(TextToSpeech texttospeech, boolean flag)
    {
        texttospeech.result = flag;
        return flag;
    }

*/
}
