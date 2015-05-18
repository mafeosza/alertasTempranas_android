// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.makePublic
    implements Runnable
{

    final GameClient this$0;
    final String val$instanceId;
    final boolean val$makePublic;

    public void run()
    {
        GameClient.access$600(GameClient.this, val$instanceId, Boolean.valueOf(val$makePublic));
    }

    ()
    {
        this$0 = final_gameclient;
        val$instanceId = s;
        val$makePublic = Z.this;
        super();
    }
}
