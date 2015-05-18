// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.runtime.util.AsyncCallbackPair;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class this._cls0
    implements AsyncCallbackPair
{

    final GameClient this$0;

    public void onFailure(String s)
    {
        WebServiceError("GetInstanceLists", "Failed to get up to date instance lists.");
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((JSONObject)obj);
    }

    public void onSuccess(JSONObject jsonobject)
    {
        GameClient.access$100(GameClient.this, jsonobject);
        FunctionCompleted("GetInstanceLists");
    }

    backPair()
    {
        this$0 = GameClient.this;
        super();
    }
}
