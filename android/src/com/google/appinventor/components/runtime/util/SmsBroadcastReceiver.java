// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import com.google.appinventor.components.runtime.ReplForm;
import com.google.appinventor.components.runtime.Texting;

public class SmsBroadcastReceiver extends BroadcastReceiver
{

    public static final int NOTIFICATION_ID = 8647;
    public static final String TAG = "SmsBroadcastReceiver";

    public SmsBroadcastReceiver()
    {
    }

    private String getMessage(Intent intent)
    {
        String s = "";
        if (intent.getAction().equals("com.google.android.apps.googlevoice.SMS_RECEIVED"))
        {
            intent = intent.getExtras().getString("com.google.android.apps.googlevoice.TEXT");
        } else
        {
            Object aobj[] = (Object[])(Object[])intent.getExtras().get("pdus");
            int j = aobj.length;
            int i = 0;
            intent = s;
            while (i < j) 
            {
                intent = SmsMessage.createFromPdu((byte[])(byte[])aobj[i]).getMessageBody();
                i++;
            }
        }
        return intent;
    }

    private String getPhoneNumber(Intent intent)
    {
        String s = "";
        if (intent.getAction().equals("com.google.android.apps.googlevoice.SMS_RECEIVED"))
        {
            intent = PhoneNumberUtils.formatNumber(intent.getExtras().getString("com.google.android.apps.googlevoice.PHONE_NUMBER"));
        } else
        {
            Object aobj[] = (Object[])(Object[])intent.getExtras().get("pdus");
            int j = aobj.length;
            int i = 0;
            intent = s;
            while (i < j) 
            {
                intent = PhoneNumberUtils.formatNumber(SmsMessage.createFromPdu((byte[])(byte[])aobj[i]).getOriginatingAddress());
                i++;
            }
        }
        return intent;
    }

    private boolean isRepl(Context context)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            context = context.getPackageName();
            flag1 = Class.forName((new StringBuilder()).append(context).append(".Screen1").toString()).getSuperclass().equals(com/google/appinventor/components/runtime/ReplForm);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return false;
        }
        if (flag1)
        {
            flag = true;
        }
        return flag;
    }

    private void sendNotification(Context context, String s, String s1)
    {
        String s2;
        Log.i("SmsBroadcastReceiver", (new StringBuilder()).append("sendingNotification ").append(s).append(":").append(s1).toString());
        s2 = context.getPackageName();
        Log.i("SmsBroadcastReceiver", (new StringBuilder()).append("Package name : ").append(s2).toString());
        Object obj;
        s2 = (new StringBuilder()).append(s2).append(".Screen1").toString();
        obj = new Intent(context, Class.forName(s2));
        try
        {
            ((Intent) (obj)).setAction("android.intent.action.MAIN");
            ((Intent) (obj)).addCategory("android.intent.category.LAUNCHER");
            ((Intent) (obj)).addFlags(0x30000000);
            NotificationManager notificationmanager = (NotificationManager)context.getSystemService("notification");
            Notification notification = new Notification(0x1080090, (new StringBuilder()).append(s).append(" : ").append(s1).toString(), System.currentTimeMillis());
            notification.flags = notification.flags | 0x10;
            notification.defaults = notification.defaults | 1;
            obj = PendingIntent.getActivity(context, 0, ((Intent) (obj)), 0x8000000);
            notification.setLatestEventInfo(context, (new StringBuilder()).append("Sms from ").append(s).toString(), s1, ((PendingIntent) (obj)));
            notification.number = Texting.getCachedMsgCount();
            notificationmanager.notify(null, 8647, notification);
            Log.i("SmsBroadcastReceiver", (new StringBuilder()).append("Notification sent, classname: ").append(s2).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context) { }
        break MISSING_BLOCK_LABEL_286;
        context;
        context.printStackTrace();
        return;
    }

    public void onReceive(Context context, Intent intent)
    {
        Log.i("SmsBroadcastReceiver", "onReceive");
        String s = getPhoneNumber(intent);
        intent = getMessage(intent);
        Log.i("SmsBroadcastReceiver", (new StringBuilder()).append("Received ").append(s).append(" : ").append(intent).toString());
        int i = Texting.isReceivingEnabled(context);
        if (i == 1)
        {
            Log.i("SmsBroadcastReceiver", (new StringBuilder()).append(context.getApplicationInfo().packageName).append(" Receiving is not enabled, ignoring message.").toString());
            return;
        }
        if ((i == 2 || isRepl(context)) && !Texting.isRunning())
        {
            Log.i("SmsBroadcastReceiver", (new StringBuilder()).append(context.getApplicationInfo().packageName).append(" Texting isn't running, and either receivingEnabled is FOREGROUND or we are the repl.").toString());
            return;
        }
        Texting.handledReceivedMessage(context, s, intent);
        if (Texting.isRunning())
        {
            Log.i("SmsBroadcastReceiver", (new StringBuilder()).append(context.getApplicationInfo().packageName).append(" App in Foreground, delivering message.").toString());
            return;
        } else
        {
            Log.i("SmsBroadcastReceiver", (new StringBuilder()).append(context.getApplicationInfo().packageName).append(" Texting isn't running, but receivingEnabled == 2, sending notification.").toString());
            sendNotification(context, s, intent);
            return;
        }
    }
}
