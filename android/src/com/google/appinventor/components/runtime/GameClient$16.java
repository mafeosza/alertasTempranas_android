// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.count
    implements Runnable
{

    final GameClient this$0;
    final int val$count;
    final String val$type;

    public void run()
    {
        GameClient.access$200(GameClient.this, val$type, val$count);
    }

    ()
    {
        this$0 = final_gameclient;
        val$type = s;
        val$count = I.this;
        super();
    }
}
