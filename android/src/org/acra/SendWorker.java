// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.collector.CrashReportData;
import org.acra.sender.ReportSender;
import org.acra.sender.ReportSenderException;

// Referenced classes of package org.acra:
//            CrashReportFileNameParser, ACRA, CrashReportFinder, CrashReportPersister, 
//            ACRAConfiguration

final class SendWorker extends Thread
{

    private final boolean approvePendingReports;
    private final Context context;
    private final CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
    private final List reportSenders;
    private final boolean sendOnlySilentReports;

    public SendWorker(Context context1, List list, boolean flag, boolean flag1)
    {
        context = context1;
        reportSenders = list;
        sendOnlySilentReports = flag;
        approvePendingReports = flag1;
    }

    private void approvePendingReports()
    {
        Log.d(ACRA.LOG_TAG, "Mark all pending reports as approved.");
        String as[] = (new CrashReportFinder(context)).getCrashReportFiles();
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = as[i];
            if (fileNameParser.isApproved(((String) (obj))))
            {
                continue;
            }
            File file = new File(context.getFilesDir(), ((String) (obj)));
            obj = ((String) (obj)).replace(".stacktrace", "-approved.stacktrace");
            obj = new File(context.getFilesDir(), ((String) (obj)));
            if (!file.renameTo(((File) (obj))))
            {
                Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Could not rename approved report from ").append(file).append(" to ").append(obj).toString());
            }
        }

    }

    private void checkAndSendReports(Context context1, boolean flag)
    {
        String as[];
        int i;
        int j;
        int k;
        Log.d(ACRA.LOG_TAG, "#checkAndSendReports - start");
        as = (new CrashReportFinder(context1)).getCrashReportFiles();
        Arrays.sort(as);
        j = 0;
        k = as.length;
        i = 0;
_L5:
        if (i >= k) goto _L2; else goto _L1
_L1:
        String s = as[i];
        if (!flag || fileNameParser.isSilent(s)) goto _L4; else goto _L3
_L3:
        i++;
          goto _L5
_L4:
        if (j < 5) goto _L6; else goto _L2
_L2:
        Log.d(ACRA.LOG_TAG, "#checkAndSendReports - finish");
        return;
_L6:
        Log.i(ACRA.LOG_TAG, (new StringBuilder()).append("Sending file ").append(s).toString());
        sendCrashReport((new CrashReportPersister(context1)).load(s));
        deleteFile(context1, s);
        j++;
          goto _L3
        Object obj;
        obj;
        Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Failed to send crash reports for ").append(s).toString(), ((Throwable) (obj)));
        deleteFile(context1, s);
          goto _L2
        obj;
        Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Failed to load crash report for ").append(s).toString(), ((Throwable) (obj)));
        deleteFile(context1, s);
          goto _L2
        context1;
        Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Failed to send crash report for ").append(s).toString(), context1);
          goto _L2
    }

    private void deleteFile(Context context1, String s)
    {
        if (!context1.deleteFile(s))
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Could not delete error report : ").append(s).toString());
        }
    }

    private void sendCrashReport(CrashReportData crashreportdata)
        throws ReportSenderException
    {
        if (ACRA.isDebuggable() && !ACRA.getConfig().sendReportsInDevMode()) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        boolean flag;
        flag = false;
        iterator = reportSenders.iterator();
_L3:
        ReportSender reportsender;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        reportsender = (ReportSender)iterator.next();
        reportsender.send(crashreportdata);
        flag = true;
        continue; /* Loop/switch isn't completed */
        ReportSenderException reportsenderexception;
        reportsenderexception;
        if (!flag)
        {
            throw reportsenderexception;
        }
        Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("ReportSender of class ").append(reportsender.getClass().getName()).append(" failed but other senders completed their task. ACRA will not send this report again.").toString());
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void run()
    {
        if (approvePendingReports)
        {
            approvePendingReports();
        }
        checkAndSendReports(context, sendOnlySilentReports);
    }
}
