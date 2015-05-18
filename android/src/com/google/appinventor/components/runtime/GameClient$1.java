// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient, EventDispatcher

class val.functionName
    implements Runnable
{

    final GameClient this$0;
    final String val$functionName;

    public void run()
    {
        Log.d("GameClient", (new StringBuilder()).append("Request completed: ").append(val$functionName).toString());
        EventDispatcher.dispatchEvent(GameClient.this, "FunctionCompleted", new Object[] {
            val$functionName
        });
    }

    er()
    {
        this$0 = final_gameclient;
        val$functionName = String.this;
        super();
    }
}
