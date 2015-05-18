// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient, EventDispatcher

class 
    implements Runnable
{

    final GameClient this$0;
    final YailList val$arguments;
    final String val$command;

    public void run()
    {
        Log.d("GameClient", (new StringBuilder()).append("Server command failed: ").append(val$command).toString());
        EventDispatcher.dispatchEvent(GameClient.this, "ServerCommandFailure", new Object[] {
            val$command, val$arguments
        });
    }

    ()
    {
        this$0 = final_gameclient;
        val$command = s;
        val$arguments = YailList.this;
        super();
    }
}
