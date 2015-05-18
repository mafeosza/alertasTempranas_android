// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import java.util.EnumMap;
import org.acra.ReportField;

public final class CrashReportData extends EnumMap
{

    private static final long serialVersionUID = 0x3912d07a70363e98L;

    public CrashReportData()
    {
        super(org/acra/ReportField);
    }

    public String getProperty(ReportField reportfield)
    {
        return (String)super.get(reportfield);
    }
}
