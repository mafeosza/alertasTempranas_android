// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.GameInstance;
import com.google.appinventor.components.runtime.util.JsonUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.requestedType
    implements AsyncCallbackPair
{

    final GameClient this$0;
    final String val$requestedType;

    public void onFailure(String s)
    {
        WebServiceError("GetMessages", s);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
        int j;
        j = jsonobject.getInt("count");
        jsonobject = jsonobject.getJSONArray("messages");
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj = jsonobject.getJSONObject(i);
        String s = ((JSONObject) (obj)).getString("type");
        String s1 = ((JSONObject) (obj)).getString("msender");
        String s2 = ((JSONObject) (obj)).getString("mtime");
        obj = JsonUtil.getListFromJsonArray(((JSONObject) (obj)).getJSONArray("contents"));
        if (val$requestedType.equals(""))
        {
            GameClient.access$300(GameClient.this).putMessageTime(val$requestedType, s2);
        }
        GameClient.access$300(GameClient.this).putMessageTime(s, s2);
        GotMessage(s, s1, ((java.util.List) (obj)));
        i++;
        if (true) goto _L2; else goto _L1
        jsonobject;
        Log.w("GameClient", jsonobject);
        Info("Failed to parse messages response.");
_L1:
        FunctionCompleted("GetMessages");
        return;
    }

    nce()
    {
        this$0 = final_gameclient;
        val$requestedType = String.this;
        super();
    }
}
