// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            GameClient

class val.contents
    implements Runnable
{

    final GameClient this$0;
    final YailList val$contents;
    final YailList val$recipients;
    final String val$type;

    public void run()
    {
        GameClient.access$700(GameClient.this, val$type, val$recipients, val$contents);
    }

    ()
    {
        this$0 = final_gameclient;
        val$type = s;
        val$recipients = yaillist;
        val$contents = YailList.this;
        super();
    }
}
