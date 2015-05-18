// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Application;
import android.util.Log;
import com.google.appinventor.common.version.GitBuildId;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ErrorReporter;

public class ReplApplication extends Application
{

    private static ReplApplication thisInstance;
    private boolean active;

    public ReplApplication()
    {
        active = false;
    }

    public static void reportError(Throwable throwable)
    {
        if (thisInstance != null && thisInstance.active)
        {
            ACRA.getErrorReporter().handleException(throwable);
        }
    }

    public void onCreate()
    {
        super.onCreate();
        thisInstance = this;
        String s = GitBuildId.getAcraUri();
        if (s.equals(""))
        {
            Log.i("ReplApplication", "ACRA Not Active");
            return;
        } else
        {
            Log.i("ReplApplication", (new StringBuilder()).append("ACRA Active, URI = ").append(s).toString());
            ACRAConfiguration acraconfiguration = ACRA.getNewDefaultConfig(this);
            acraconfiguration.setFormUri(s);
            acraconfiguration.setDisableSSLCertValidation(true);
            ACRA.setConfig(acraconfiguration);
            ACRA.init(this);
            active = true;
            return;
        }
    }
}
