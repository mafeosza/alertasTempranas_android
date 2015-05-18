// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.os.Process;
import android.text.format.Time;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.annotation.ReportsCrashes;
import org.acra.collector.ConfigurationCollector;
import org.acra.collector.CrashReportData;
import org.acra.collector.CrashReportDataFactory;
import org.acra.sender.EmailIntentSender;
import org.acra.sender.GoogleFormSender;
import org.acra.sender.HttpPostSender;
import org.acra.sender.ReportSender;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ToastSender;

// Referenced classes of package org.acra:
//            CrashReportFileNameParser, CrashReportFinder, ACRA, ACRAConfiguration, 
//            ReportingInteractionMode, ReportField, ACRAConstants, CrashReportDialog, 
//            CrashReportPersister, SendWorker

public class ErrorReporter
    implements Thread.UncaughtExceptionHandler
{

    private static boolean toastWaitEnded = true;
    private Thread brokenThread;
    private final CrashReportDataFactory crashReportDataFactory;
    private boolean enabled;
    private final CrashReportFileNameParser fileNameParser = new CrashReportFileNameParser();
    private final Context mContext;
    private final Thread.UncaughtExceptionHandler mDfltExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    private final List mReportSenders = new ArrayList();
    private final SharedPreferences prefs;
    private Throwable unhandledThrowable;

    ErrorReporter(Context context, SharedPreferences sharedpreferences, boolean flag)
    {
        enabled = false;
        mContext = context;
        prefs = sharedpreferences;
        enabled = flag;
        context = ConfigurationCollector.collectConfiguration(mContext);
        Time time = new Time();
        time.setToNow();
        crashReportDataFactory = new CrashReportDataFactory(mContext, sharedpreferences, time, context);
        Thread.setDefaultUncaughtExceptionHandler(this);
        checkReportsOnApplicationStart();
    }

    private boolean containsOnlySilentOrApprovedReports(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (!fileNameParser.isApproved(s))
            {
                return false;
            }
        }

        return true;
    }

    private void deletePendingReports(boolean flag, boolean flag1, int i)
    {
        String as[] = (new CrashReportFinder(mContext)).getCrashReportFiles();
        Arrays.sort(as);
        if (as != null)
        {
            for (int j = 0; j < as.length - i; j++)
            {
                Object obj = as[j];
                boolean flag2 = fileNameParser.isApproved(((String) (obj)));
                if ((!flag2 || !flag) && (flag2 || !flag1))
                {
                    continue;
                }
                obj = new File(mContext.getFilesDir(), ((String) (obj)));
                if (!((File) (obj)).delete())
                {
                    Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("Could not delete report : ").append(obj).toString());
                }
            }

        }
    }

    private void endApplication()
    {
        if (ACRA.getConfig().mode() == ReportingInteractionMode.SILENT || ACRA.getConfig().mode() == ReportingInteractionMode.TOAST && ACRA.getConfig().forceCloseDialogAfterToast())
        {
            mDfltExceptionHandler.uncaughtException(brokenThread, unhandledThrowable);
            return;
        } else
        {
            Log.e(ACRA.LOG_TAG, (new StringBuilder()).append(mContext.getPackageName()).append(" fatal error : ").append(unhandledThrowable.getMessage()).toString(), unhandledThrowable);
            Process.killProcess(Process.myPid());
            System.exit(10);
            return;
        }
    }

    public static ErrorReporter getInstance()
    {
        return ACRA.getErrorReporter();
    }

    private String getLatestNonSilentReport(String as[])
    {
        if (as != null && as.length > 0)
        {
            for (int i = as.length - 1; i >= 0; i--)
            {
                if (!fileNameParser.isSilent(as[i]))
                {
                    return as[i];
                }
            }

            return as[as.length - 1];
        } else
        {
            return null;
        }
    }

    private String getReportFileName(CrashReportData crashreportdata)
    {
        Object obj = new Time();
        ((Time) (obj)).setToNow();
        long l = ((Time) (obj)).toMillis(false);
        crashreportdata = crashreportdata.getProperty(ReportField.IS_SILENT);
        obj = (new StringBuilder()).append("").append(l);
        if (crashreportdata != null)
        {
            crashreportdata = ACRAConstants.SILENT_SUFFIX;
        } else
        {
            crashreportdata = "";
        }
        return ((StringBuilder) (obj)).append(crashreportdata).append(".stacktrace").toString();
    }

    private void handleException(final Throwable worker, ReportingInteractionMode reportinginteractionmode, final boolean showDirectDialog, final boolean endApplication)
    {
        boolean flag2 = true;
        if (!enabled)
        {
            return;
        }
        boolean flag3 = false;
        ReportingInteractionMode reportinginteractionmode1;
        final String reportFileName;
        boolean flag;
        boolean flag1;
        if (reportinginteractionmode == null)
        {
            reportinginteractionmode1 = ACRA.getConfig().mode();
            flag1 = flag3;
        } else
        {
            flag1 = flag3;
            reportinginteractionmode1 = reportinginteractionmode;
            if (reportinginteractionmode == ReportingInteractionMode.SILENT)
            {
                flag1 = flag3;
                reportinginteractionmode1 = reportinginteractionmode;
                if (ACRA.getConfig().mode() != ReportingInteractionMode.SILENT)
                {
                    flag1 = true;
                    reportinginteractionmode1 = reportinginteractionmode;
                }
            }
        }
        reportinginteractionmode = worker;
        if (worker == null)
        {
            reportinginteractionmode = new Exception("Report requested by developer");
        }
        if (reportinginteractionmode1 == ReportingInteractionMode.TOAST || ACRA.getConfig().resToastText() != 0 && (reportinginteractionmode1 == ReportingInteractionMode.NOTIFICATION || reportinginteractionmode1 == ReportingInteractionMode.DIALOG))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            (new Thread() {

                final ErrorReporter this$0;

                public void run()
                {
                    Looper.prepare();
                    ToastSender.sendToast(mContext, ACRA.getConfig().resToastText(), 1);
                    Looper.loop();
                }

            
            {
                this$0 = ErrorReporter.this;
                super();
            }
            }).start();
        }
        worker = crashReportDataFactory.createCrashData(reportinginteractionmode, showDirectDialog, brokenThread);
        reportFileName = getReportFileName(worker);
        saveCrashReportFile(reportFileName, worker);
        reportinginteractionmode = null;
        if (reportinginteractionmode1 == ReportingInteractionMode.SILENT || reportinginteractionmode1 == ReportingInteractionMode.TOAST || prefs.getBoolean("acra.alwaysaccept", false))
        {
            Log.d(ACRA.LOG_TAG, "About to start ReportSenderWorker from #handleException");
            worker = startSendingReports(flag1, true);
        } else
        {
            worker = reportinginteractionmode;
            if (reportinginteractionmode1 == ReportingInteractionMode.NOTIFICATION)
            {
                Log.d(ACRA.LOG_TAG, "About to send status bar notification from #handleException");
                notifySendReport(reportFileName);
                worker = reportinginteractionmode;
            }
        }
        if (flag)
        {
            toastWaitEnded = false;
            (new Thread() {

                final ErrorReporter this$0;

                public void run()
                {
                    Time time1 = new Time();
                    Time time = new Time();
                    time1.setToNow();
                    long l1 = time1.toMillis(false);
                    long l = 0L;
                    while (l < 3000L) 
                    {
                        try
                        {
                            Thread.sleep(3000L);
                        }
                        catch (InterruptedException interruptedexception)
                        {
                            Log.d(ACRA.LOG_TAG, "Interrupted while waiting for Toast to end.", interruptedexception);
                        }
                        time.setToNow();
                        l = time.toMillis(false) - l1;
                    }
                    ErrorReporter.toastWaitEnded = true;
                }

            
            {
                this$0 = ErrorReporter.this;
                super();
            }
            }).start();
        }
        if (reportinginteractionmode1 == ReportingInteractionMode.DIALOG && !prefs.getBoolean("acra.alwaysaccept", false))
        {
            showDirectDialog = flag2;
        } else
        {
            showDirectDialog = false;
        }
        (new Thread() {

            final ErrorReporter this$0;
            final boolean val$endApplication;
            final String val$reportFileName;
            final boolean val$showDirectDialog;
            final SendWorker val$worker;

            public void run()
            {
                Log.d(ACRA.LOG_TAG, "Waiting for Toast + worker...");
                while (!ErrorReporter.toastWaitEnded || worker != null && worker.isAlive()) 
                {
                    try
                    {
                        Thread.sleep(100L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        Log.e(ACRA.LOG_TAG, "Error : ", interruptedexception);
                    }
                }
                if (showDirectDialog)
                {
                    Log.d(ACRA.LOG_TAG, "About to create DIALOG from #handleException");
                    notifyDialog(reportFileName);
                }
                Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Wait for Toast + worker ended. Kill Application ? ").append(endApplication).toString());
                if (endApplication)
                {
                    ErrorReporter.this.endApplication();
                }
            }

            
            {
                this$0 = ErrorReporter.this;
                worker = sendworker;
                showDirectDialog = flag;
                reportFileName = s;
                endApplication = flag1;
                super();
            }
        }).start();
    }

    private void notifySendReport(String s)
    {
        NotificationManager notificationmanager = (NotificationManager)mContext.getSystemService("notification");
        Object obj = ACRA.getConfig();
        Notification notification = new Notification(((ReportsCrashes) (obj)).resNotifIcon(), mContext.getText(((ReportsCrashes) (obj)).resNotifTickerText()), System.currentTimeMillis());
        CharSequence charsequence = mContext.getText(((ReportsCrashes) (obj)).resNotifTitle());
        obj = mContext.getText(((ReportsCrashes) (obj)).resNotifText());
        Intent intent = new Intent(mContext, org/acra/CrashReportDialog);
        Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Creating Notification for ").append(s).toString());
        intent.putExtra("REPORT_FILE_NAME", s);
        s = PendingIntent.getActivity(mContext, 0, intent, 0x8000000);
        notification.setLatestEventInfo(mContext, charsequence, ((CharSequence) (obj)), s);
        notificationmanager.cancelAll();
        notificationmanager.notify(666, notification);
    }

    private void saveCrashReportFile(String s, CrashReportData crashreportdata)
    {
        try
        {
            Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Writing crash report file ").append(s).append(".").toString());
            (new CrashReportPersister(mContext)).store(crashreportdata, s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e(ACRA.LOG_TAG, "An error occurred while writing the report file...", s);
        }
    }

    public void addCustomData(String s, String s1)
    {
        crashReportDataFactory.putCustomData(s, s1);
    }

    public void addReportSender(ReportSender reportsender)
    {
        mReportSenders.add(reportsender);
    }

    public void checkReportsOnApplicationStart()
    {
        long l = prefs.getInt("acra.lastVersionNr", 0);
        Object obj = (new PackageManagerWrapper(mContext)).getPackageInfo();
        String as1[];
        boolean flag;
        if (obj != null && (long)((PackageInfo) (obj)).versionCode > l)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if (ACRA.getConfig().deleteOldUnsentReportsOnApplicationStart())
            {
                deletePendingReports();
            }
            android.content.SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("acra.lastVersionNr", ((PackageInfo) (obj)).versionCode);
            editor.commit();
        }
        if ((ACRA.getConfig().mode() == ReportingInteractionMode.NOTIFICATION || ACRA.getConfig().mode() == ReportingInteractionMode.DIALOG) && ACRA.getConfig().deleteUnapprovedReportsOnApplicationStart())
        {
            deletePendingNonApprovedReports(true);
        }
        obj = new CrashReportFinder(mContext);
        as1 = ((CrashReportFinder) (obj)).getCrashReportFiles();
        if (as1 != null && as1.length > 0)
        {
            ReportingInteractionMode reportinginteractionmode = ACRA.getConfig().mode();
            String as[] = ((CrashReportFinder) (obj)).getCrashReportFiles();
            boolean flag1 = containsOnlySilentOrApprovedReports(as);
            if (reportinginteractionmode == ReportingInteractionMode.SILENT || reportinginteractionmode == ReportingInteractionMode.TOAST || flag1 && (reportinginteractionmode == ReportingInteractionMode.NOTIFICATION || reportinginteractionmode == ReportingInteractionMode.DIALOG))
            {
                if (reportinginteractionmode == ReportingInteractionMode.TOAST && !flag1)
                {
                    ToastSender.sendToast(mContext, ACRA.getConfig().resToastText(), 1);
                }
                Log.v(ACRA.LOG_TAG, "About to start ReportSenderWorker from #checkReportOnApplicationStart");
                startSendingReports(false, false);
            } else
            {
                if (ACRA.getConfig().mode() == ReportingInteractionMode.NOTIFICATION)
                {
                    notifySendReport(getLatestNonSilentReport(as));
                    return;
                }
                if (ACRA.getConfig().mode() == ReportingInteractionMode.DIALOG)
                {
                    notifyDialog(getLatestNonSilentReport(as));
                    return;
                }
            }
        }
    }

    void deletePendingNonApprovedReports(boolean flag)
    {
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        deletePendingReports(false, true, i);
    }

    void deletePendingReports()
    {
        deletePendingReports(true, true, 0);
    }

    public String getCustomData(String s)
    {
        return crashReportDataFactory.getCustomData(s);
    }

    public void handleException(Throwable throwable)
    {
        handleException(throwable, ACRA.getConfig().mode(), false, false);
    }

    public void handleException(Throwable throwable, boolean flag)
    {
        handleException(throwable, ACRA.getConfig().mode(), false, flag);
    }

    public void handleSilentException(Throwable throwable)
    {
        if (enabled)
        {
            handleException(throwable, ReportingInteractionMode.SILENT, true, false);
            Log.d(ACRA.LOG_TAG, "ACRA sent Silent report.");
            return;
        } else
        {
            Log.d(ACRA.LOG_TAG, "ACRA is disabled. Silent report not sent.");
            return;
        }
    }

    void notifyDialog(String s)
    {
        Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Creating Dialog for ").append(s).toString());
        Intent intent = new Intent(mContext, org/acra/CrashReportDialog);
        intent.putExtra("REPORT_FILE_NAME", s);
        intent.setFlags(0x10000000);
        mContext.startActivity(intent);
    }

    public String putCustomData(String s, String s1)
    {
        return crashReportDataFactory.putCustomData(s, s1);
    }

    public void removeAllReportSenders()
    {
        mReportSenders.clear();
    }

    public String removeCustomData(String s)
    {
        return crashReportDataFactory.removeCustomData(s);
    }

    public void removeReportSender(ReportSender reportsender)
    {
        mReportSenders.remove(reportsender);
    }

    public void removeReportSenders(Class class1)
    {
        if (org/acra/sender/ReportSender.isAssignableFrom(class1))
        {
            Iterator iterator = mReportSenders.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ReportSender reportsender = (ReportSender)iterator.next();
                if (class1.isInstance(reportsender))
                {
                    mReportSenders.remove(reportsender);
                }
            } while (true);
        }
    }

    public void setDefaultReportSenders()
    {
        ACRAConfiguration acraconfiguration = ACRA.getConfig();
        Application application = ACRA.getApplication();
        removeAllReportSenders();
        if (!"".equals(acraconfiguration.mailTo()))
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append(application.getPackageName()).append(" reports will be sent by email (if accepted by user).").toString());
            setReportSender(new EmailIntentSender(application));
        } else
        {
            if (!(new PackageManagerWrapper(application)).hasPermission("android.permission.INTERNET"))
            {
                Log.e(ACRA.LOG_TAG, (new StringBuilder()).append(application.getPackageName()).append(" should be granted permission ").append("android.permission.INTERNET").append(" if you want your crash reports to be sent. If you don't want to add this permission to your application you can also enable sending reports by email. If this is your will then provide your email address in @ReportsCrashes(mailTo=\"your.account@domain.com\"").toString());
                return;
            }
            if (acraconfiguration.formUri() != null && !"".equals(acraconfiguration.formUri()))
            {
                setReportSender(new HttpPostSender(null));
                return;
            }
            if (acraconfiguration.formKey() != null && !"".equals(acraconfiguration.formKey().trim()))
            {
                addReportSender(new GoogleFormSender());
                return;
            }
        }
    }

    public void setEnabled(boolean flag)
    {
        String s1 = ACRA.LOG_TAG;
        StringBuilder stringbuilder = (new StringBuilder()).append("ACRA is ");
        String s;
        if (flag)
        {
            s = "enabled";
        } else
        {
            s = "disabled";
        }
        Log.i(s1, stringbuilder.append(s).append(" for ").append(mContext.getPackageName()).toString());
        enabled = flag;
    }

    public void setReportSender(ReportSender reportsender)
    {
        removeAllReportSenders();
        addReportSender(reportsender);
    }

    SendWorker startSendingReports(boolean flag, boolean flag1)
    {
        SendWorker sendworker = new SendWorker(mContext, mReportSenders, flag, flag1);
        sendworker.start();
        return sendworker;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        if (enabled)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (mDfltExceptionHandler != null)
        {
            Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("ACRA is disabled for ").append(mContext.getPackageName()).append(" - forwarding uncaught Exception on to default ExceptionHandler").toString());
            mDfltExceptionHandler.uncaughtException(thread, throwable);
            return;
        }
        try
        {
            Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("ACRA is disabled for ").append(mContext.getPackageName()).append(" - no default ExceptionHandler").toString());
            return;
        }
        catch (Throwable throwable1) { }
        if (mDfltExceptionHandler != null)
        {
            mDfltExceptionHandler.uncaughtException(thread, throwable);
            return;
        }
        break MISSING_BLOCK_LABEL_203;
        brokenThread = thread;
        unhandledThrowable = throwable;
        Log.e(ACRA.LOG_TAG, (new StringBuilder()).append("ACRA caught a ").append(throwable.getClass().getSimpleName()).append(" exception for ").append(mContext.getPackageName()).append(". Building report.").toString());
        handleException(throwable, ACRA.getConfig().mode(), false, true);
    }





/*
    static boolean access$102(boolean flag)
    {
        toastWaitEnded = flag;
        return flag;
    }

*/

}
