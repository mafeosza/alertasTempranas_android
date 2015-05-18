// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.io.IOException;
import org.acra.collector.CrashReportData;
import org.acra.util.ToastSender;

// Referenced classes of package org.acra:
//            CrashReportDialog, CrashReportPersister, ACRA, ReportField, 
//            ErrorReporter, ACRAConfiguration

class this._cls0
    implements android.view.
{

    final CrashReportDialog this$0;

    public void onClick(View view)
    {
        String s;
        CrashReportPersister crashreportpersister;
        int i;
        if (CrashReportDialog.access$000(CrashReportDialog.this) != null)
        {
            view = CrashReportDialog.access$000(CrashReportDialog.this).getText().toString();
        } else
        {
            view = "";
        }
        if (CrashReportDialog.access$100(CrashReportDialog.this) != null && CrashReportDialog.access$200(CrashReportDialog.this) != null)
        {
            s = CrashReportDialog.access$200(CrashReportDialog.this).getText().toString();
            android.content.itor itor = CrashReportDialog.access$100(CrashReportDialog.this).edit();
            itor.putString("acra.user.email", s);
            itor.commit();
        } else
        {
            s = "";
        }
        crashreportpersister = new CrashReportPersister(getApplicationContext());
        try
        {
            Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Add user comment to ").append(mReportFileName).toString());
            CrashReportData crashreportdata = crashreportpersister.load(mReportFileName);
            crashreportdata.put(ReportField.USER_COMMENT, view);
            crashreportdata.put(ReportField.USER_EMAIL, s);
            crashreportpersister.store(crashreportdata, mReportFileName);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Log.w(ACRA.LOG_TAG, "User comment not added: ", view);
        }
        Log.v(ACRA.LOG_TAG, "About to start SenderWorker from CrashReportDialog");
        ACRA.getErrorReporter().startSendingReports(false, true);
        i = ACRA.getConfig().resDialogOkToast();
        if (i != 0)
        {
            ToastSender.sendToast(getApplicationContext(), i, 1);
        }
        finish();
    }

    tData()
    {
        this$0 = CrashReportDialog.this;
        super();
    }
}
