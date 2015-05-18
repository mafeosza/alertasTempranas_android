// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.content.SharedPreferences;

// Referenced classes of package org.acra:
//            ACRA, ErrorReporter

static final class 
    implements android.content.references.OnSharedPreferenceChangeListener
{

    public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
    {
        if ("acra.disable".equals(s) || "acra.enable".equals(s))
        {
            boolean flag;
            if (!ACRA.access$000(sharedpreferences))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ACRA.getErrorReporter().setEnabled(flag);
        }
    }

    ()
    {
    }
}
