// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ActivityResultListener, ComponentContainer, 
//            EventDispatcher, Form

public class SpeechRecognizer extends AndroidNonvisibleComponent
    implements Component, ActivityResultListener
{

    private final ComponentContainer container;
    private int requestCode;
    private String result;

    public SpeechRecognizer(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        container = componentcontainer;
        result = "";
    }

    public void AfterGettingText(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterGettingText", new Object[] {
            s
        });
    }

    public void BeforeGettingText()
    {
        EventDispatcher.dispatchEvent(this, "BeforeGettingText", new Object[0]);
    }

    public void GetText()
    {
        BeforeGettingText();
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        if (requestCode == 0)
        {
            requestCode = form.registerForActivityResult(this);
        }
        container.$context().startActivityForResult(intent, requestCode);
    }

    public String Result()
    {
        return result;
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        if (i == requestCode && j == -1)
        {
            if (intent.hasExtra("android.speech.extra.RESULTS"))
            {
                result = (String)intent.getExtras().getStringArrayList("android.speech.extra.RESULTS").get(0);
            } else
            {
                result = "";
            }
            AfterGettingText(result);
        }
    }
}
