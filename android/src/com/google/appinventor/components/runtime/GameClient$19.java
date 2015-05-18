// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class this._cls0
    implements AsyncCallbackPair
{

    final GameClient this$0;

    public void onFailure(String s)
    {
        WebServiceError("Invite", s);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
        jsonobject = jsonobject.getString("inv");
        if (!jsonobject.equals("")) goto _L2; else goto _L1
_L1:
        Info((new StringBuilder()).append(jsonobject).append(" was already invited.").toString());
_L4:
        FunctionCompleted("Invite");
        return;
_L2:
        try
        {
            Info((new StringBuilder()).append("Successfully invited ").append(jsonobject).append(".").toString());
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            Log.w("GameClient", jsonobject);
            Info("Failed to parse invite player response.");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    backPair()
    {
        this$0 = GameClient.this;
        super();
    }
}
