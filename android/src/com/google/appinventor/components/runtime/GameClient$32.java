// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.GameInstance;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.params
    implements AsyncCallbackPair
{

    final GameClient this$0;
    final boolean val$allowInstanceIdChange;
    final AsyncCallbackPair val$callback;
    final String val$commandName;
    final List val$params;

    public void onFailure(String s)
    {
        Log.d("GameClient", (new StringBuilder()).append("Posting to server failed for ").append(val$commandName).append(" with arguments ").append(val$params).append("\n Failure message: ").append(s).toString());
        val$callback.onFailure(s);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
        Log.d("GameClient", (new StringBuilder()).append("Received response for ").append(val$commandName).append(": ").append(jsonobject.toString()).toString());
        String s;
        try
        {
            if (jsonobject.getBoolean("e"))
            {
                val$callback.onFailure(jsonobject.getString("response"));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.w("GameClient", jsonobject);
            val$callback.onFailure((new StringBuilder()).append("Failed to parse JSON response to command ").append(val$commandName).toString());
            return;
        }
        s = jsonobject.getString("gid");
        if (!s.equals(GameId()))
        {
            Info((new StringBuilder()).append("Incorrect game id in response: + ").append(s).append(".").toString());
            return;
        }
        String s1;
        s1 = jsonobject.getString("iid");
        if (s1.equals(""))
        {
            val$callback.onSuccess(jsonobject.getJSONObject("response"));
            return;
        }
        if (!s1.equals(InstanceId()))
        {
            break MISSING_BLOCK_LABEL_228;
        }
        GameClient.access$1100(GameClient.this, jsonobject);
_L2:
        val$callback.onSuccess(jsonobject.getJSONObject("response"));
        return;
label0:
        {
            if (!val$allowInstanceIdChange && !InstanceId().equals(""))
            {
                break label0;
            }
            GameClient.access$302(GameClient.this, new GameInstance(s1));
            GameClient.access$1100(GameClient.this, jsonobject);
            InstanceIdChanged(s1);
        }
        if (true) goto _L2; else goto _L1
_L1:
        Info((new StringBuilder()).append("Ignored server response to ").append(val$commandName).append(" for incorrect instance ").append(s1).append(".").toString());
        return;
    }

    backPair()
    {
        this$0 = final_gameclient;
        val$commandName = s;
        val$callback = asynccallbackpair;
        val$allowInstanceIdChange = flag;
        val$params = List.this;
        super();
    }
}
