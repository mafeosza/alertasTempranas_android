// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;


// Referenced classes of package org.acra:
//            ACRAConstants

final class CrashReportFileNameParser
{

    CrashReportFileNameParser()
    {
    }

    public boolean isApproved(String s)
    {
        return isSilent(s) || s.contains("-approved");
    }

    public boolean isSilent(String s)
    {
        return s.contains(ACRAConstants.SILENT_SUFFIX);
    }
}
