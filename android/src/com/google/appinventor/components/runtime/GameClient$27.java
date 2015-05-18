// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.YailList;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.arguments
    implements AsyncCallbackPair
{

    final GameClient this$0;
    final YailList val$arguments;
    final String val$command;

    public void onFailure(String s)
    {
        ServerCommandFailure(val$command, val$arguments);
        WebServiceError("ServerCommand", s);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
        try
        {
            ServerCommandSuccess(val$command, JsonUtil.getListFromJsonArray(jsonobject.getJSONArray("contents")));
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.w("GameClient", jsonobject);
            Info("Server command response failed to parse.");
        }
        FunctionCompleted("ServerCommand");
    }

    backPair()
    {
        this$0 = final_gameclient;
        val$command = s;
        val$arguments = YailList.this;
        super();
    }
}
