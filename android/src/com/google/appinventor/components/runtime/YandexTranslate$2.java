// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            YandexTranslate

class val.translation
    implements Runnable
{

    final YandexTranslate this$0;
    final String val$responseCode;
    final String val$translation;

    public void run()
    {
        GotTranslation(val$responseCode, val$translation);
    }

    A()
    {
        this$0 = final_yandextranslate;
        val$responseCode = s;
        val$translation = String.this;
        super();
    }
}
