// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.io.IOException;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            YandexTranslate, Form

class val.textToTranslate
    implements Runnable
{

    final YandexTranslate this$0;
    final String val$languageToTranslateTo;
    final String val$textToTranslate;

    public void run()
    {
        try
        {
            YandexTranslate.access$000(YandexTranslate.this, val$languageToTranslateTo, val$textToTranslate);
            return;
        }
        catch (IOException ioexception)
        {
            form.dispatchErrorOccurredEvent(YandexTranslate.this, "RequestTranslation", 2202, new Object[0]);
            return;
        }
        catch (JSONException jsonexception)
        {
            form.dispatchErrorOccurredEvent(YandexTranslate.this, "RequestTranslation", 2203, new Object[0]);
        }
    }

    A()
    {
        this$0 = final_yandextranslate;
        val$languageToTranslateTo = s;
        val$textToTranslate = String.this;
        super();
    }
}
