// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient, EventDispatcher

class val.emailAddress
    implements Runnable
{

    final GameClient this$0;
    final String val$emailAddress;

    public void run()
    {
        EventDispatcher.dispatchEvent(GameClient.this, "UserEmailAddressSet", new Object[] {
            val$emailAddress
        });
    }

    r()
    {
        this$0 = final_gameclient;
        val$emailAddress = String.this;
        super();
    }
}
