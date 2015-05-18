// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.arguments
    implements Runnable
{

    final GameClient this$0;
    final YailList val$arguments;
    final String val$command;

    public void run()
    {
        GameClient.access$800(GameClient.this, val$command, val$arguments);
    }

    ()
    {
        this$0 = final_gameclient;
        val$command = s;
        val$arguments = YailList.this;
        super();
    }
}
