// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            AsyncCallbackPair, WebServiceUtil

class 
    implements AsyncCallbackPair
{

    final WebServiceUtil this$0;
    final AsyncCallbackPair val$callback;

    public void onFailure(String s)
    {
        val$callback.onFailure(s);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(String s)
    {
        try
        {
            val$callback.onSuccess(new JSONObject(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            val$callback.onFailure(s.getMessage());
        }
    }

    ()
    {
        this$0 = final_webserviceutil;
        val$callback = AsyncCallbackPair.this;
        super();
    }
}
