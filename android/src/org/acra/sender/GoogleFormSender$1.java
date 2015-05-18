// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;

import org.acra.ReportField;

// Referenced classes of package org.acra.sender:
//            GoogleFormSender

static class 
{

    static final int $SwitchMap$org$acra$ReportField[];

    static 
    {
        $SwitchMap$org$acra$ReportField = new int[ReportField.values().length];
        try
        {
            $SwitchMap$org$acra$ReportField[ReportField.APP_VERSION_NAME.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$acra$ReportField[ReportField.ANDROID_VERSION.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
