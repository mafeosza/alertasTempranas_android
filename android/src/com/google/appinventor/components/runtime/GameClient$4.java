// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient, EventDispatcher

class val.instanceId
    implements Runnable
{

    final GameClient this$0;
    final String val$instanceId;

    public void run()
    {
        EventDispatcher.dispatchEvent(GameClient.this, "Invited", new Object[] {
            val$instanceId
        });
    }

    er()
    {
        this$0 = final_gameclient;
        val$instanceId = String.this;
        super();
    }
}
