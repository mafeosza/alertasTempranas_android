// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;

// Referenced classes of package com.google.appinventor.components.runtime:
//            PhoneCall

private class number extends BroadcastReceiver
{

    private String number;
    private int status;
    final PhoneCall this$0;

    public void onReceive(Context context, Intent intent)
    {
        context = intent.getAction();
        if (!"android.intent.action.PHONE_STATE".equals(context)) goto _L2; else goto _L1
_L1:
        context = intent.getStringExtra("state");
        if (!TelephonyManager.EXTRA_STATE_RINGING.equals(context)) goto _L4; else goto _L3
_L3:
        status = 1;
        number = intent.getStringExtra("incoming_number");
        PhoneCallStarted(1, number);
_L6:
        return;
_L4:
        if (!TelephonyManager.EXTRA_STATE_OFFHOOK.equals(context))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (status == 1)
        {
            status = 3;
            IncomingCallAnswered(number);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!TelephonyManager.EXTRA_STATE_IDLE.equals(context)) goto _L6; else goto _L5
_L5:
        if (status != 1) goto _L8; else goto _L7
_L7:
        PhoneCallEnded(1, number);
_L9:
        status = 0;
        number = "";
        return;
_L8:
        if (status == 3)
        {
            PhoneCallEnded(2, number);
        } else
        if (status == 2)
        {
            PhoneCallEnded(3, number);
        }
        if (true) goto _L9; else goto _L2
_L2:
        if ("android.intent.action.NEW_OUTGOING_CALL".equals(context))
        {
            status = 2;
            number = intent.getStringExtra("android.intent.extra.PHONE_NUMBER");
            PhoneCallStarted(2, number);
            return;
        }
        if (true) goto _L6; else goto _L10
_L10:
    }

    public ()
    {
        this$0 = PhoneCall.this;
        super();
        status = 0;
        number = "";
    }
}
