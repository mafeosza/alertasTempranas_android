// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.GameInstance;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.instanceId
    implements Runnable
{

    final GameClient this$0;
    final String val$instanceId;

    public void run()
    {
        if (val$instanceId.equals(""))
        {
            Log.d("GameClient", "Instance id set to empty string.");
            if (!InstanceId().equals(""))
            {
                GameClient.access$302(GameClient.this, new GameInstance(""));
                InstanceIdChanged("");
                FunctionCompleted("SetInstance");
            }
            return;
        } else
        {
            GameClient.access$900(GameClient.this, val$instanceId);
            return;
        }
    }

    nce()
    {
        this$0 = final_gameclient;
        val$instanceId = String.this;
        super();
    }
}
