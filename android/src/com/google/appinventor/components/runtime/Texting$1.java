// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Texting

class this._cls0 extends BroadcastReceiver
{

    final Texting this$0;

    public void onReceive(Context context, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        Texting.access$100(Texting.this, context, null, getResultCode(), Texting.access$000(Texting.this));
        Texting.access$200().unregisterReceiver(this);
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        Log.e("BroadcastReceiver", (new StringBuilder()).append("Error in onReceive for msgId ").append(intent.getAction()).toString());
        Log.e("BroadcastReceiver", context.getMessage());
        context.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }

    _cls9()
    {
        this$0 = Texting.this;
        super();
    }
}
