// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;

import org.acra.collector.CrashReportData;

// Referenced classes of package org.acra.sender:
//            ReportSenderException

public interface ReportSender
{

    public abstract void send(CrashReportData crashreportdata)
        throws ReportSenderException;
}
