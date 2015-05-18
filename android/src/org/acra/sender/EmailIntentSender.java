// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;

import android.content.Context;
import android.content.Intent;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;

// Referenced classes of package org.acra.sender:
//            ReportSender, ReportSenderException

public class EmailIntentSender
    implements ReportSender
{

    private final Context mContext;

    public EmailIntentSender(Context context)
    {
        mContext = context;
    }

    private String buildBody(CrashReportData crashreportdata)
    {
        ReportField areportfield1[] = ACRA.getConfig().customReportContent();
        ReportField areportfield[] = areportfield1;
        if (areportfield1.length == 0)
        {
            areportfield = ACRA.DEFAULT_MAIL_REPORT_FIELDS;
        }
        StringBuilder stringbuilder = new StringBuilder();
        int j = areportfield.length;
        for (int i = 0; i < j; i++)
        {
            ReportField reportfield = areportfield[i];
            stringbuilder.append(reportfield.toString()).append("=");
            stringbuilder.append((String)crashreportdata.get(reportfield));
            stringbuilder.append('\n');
        }

        return stringbuilder.toString();
    }

    public void send(CrashReportData crashreportdata)
        throws ReportSenderException
    {
        String s = (new StringBuilder()).append(mContext.getPackageName()).append(" Crash Report").toString();
        crashreportdata = buildBody(crashreportdata);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.addFlags(0x10000000);
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", s);
        intent.putExtra("android.intent.extra.TEXT", crashreportdata);
        intent.putExtra("android.intent.extra.EMAIL", new String[] {
            ACRA.getConfig().mailTo()
        });
        mContext.startActivity(intent);
    }
}
