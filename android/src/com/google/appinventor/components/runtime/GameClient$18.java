// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.playerEmail
    implements Runnable
{

    final GameClient this$0;
    final String val$playerEmail;

    public void run()
    {
        GameClient.access$400(GameClient.this, val$playerEmail);
    }

    ()
    {
        this$0 = final_gameclient;
        val$playerEmail = String.this;
        super();
    }
}
