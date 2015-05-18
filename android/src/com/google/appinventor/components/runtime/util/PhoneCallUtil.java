// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PhoneCallUtil
{

    private PhoneCallUtil()
    {
    }

    public static void makePhoneCall(Context context, String s)
    {
        if (s != null && s.length() > 0)
        {
            context.startActivity(new Intent("android.intent.action.CALL", Uri.parse((new StringBuilder()).append("tel:").append(s).toString())));
        }
    }
}
