// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.widget.ScrollView;

// Referenced classes of package org.acra:
//            CrashReportDialog

class val.scroll
    implements Runnable
{

    final CrashReportDialog this$0;
    final ScrollView val$scroll;

    public void run()
    {
        val$scroll.scrollTo(0, 0);
    }

    ()
    {
        this$0 = final_crashreportdialog;
        val$scroll = ScrollView.this;
        super();
    }
}
