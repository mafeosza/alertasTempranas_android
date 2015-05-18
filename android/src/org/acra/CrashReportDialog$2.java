// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.view.View;

// Referenced classes of package org.acra:
//            CrashReportDialog, ACRA, ErrorReporter

class this._cls0
    implements android.view.
{

    final CrashReportDialog this$0;

    public void onClick(View view)
    {
        ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
        finish();
    }

    ener()
    {
        this$0 = CrashReportDialog.this;
        super();
    }
}
