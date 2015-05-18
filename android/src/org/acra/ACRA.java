// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import org.acra.annotation.ReportsCrashes;
import org.acra.log.ACRALog;
import org.acra.log.AndroidLogDelegate;

// Referenced classes of package org.acra:
//            ReportField, ACRAConfigurationException, ReportingInteractionMode, ACRAConfiguration, 
//            ErrorReporter

public class ACRA
{

    public static final ReportField DEFAULT_MAIL_REPORT_FIELDS[];
    public static final ReportField DEFAULT_REPORT_FIELDS[];
    public static final boolean DEV_LOGGING = false;
    public static final String LOG_TAG = org/acra/ACRA.getSimpleName();
    public static final String PREF_ALWAYS_ACCEPT = "acra.alwaysaccept";
    public static final String PREF_DISABLE_ACRA = "acra.disable";
    public static final String PREF_ENABLE_ACRA = "acra.enable";
    public static final String PREF_ENABLE_DEVICE_ID = "acra.deviceid.enable";
    public static final String PREF_ENABLE_SYSTEM_LOGS = "acra.syslog.enable";
    public static final String PREF_LAST_VERSION_NR = "acra.lastVersionNr";
    public static final String PREF_USER_EMAIL_ADDRESS = "acra.user.email";
    private static ACRAConfiguration configProxy;
    private static ErrorReporter errorReporterSingleton;
    public static ACRALog log = new AndroidLogDelegate();
    private static Application mApplication;
    private static android.content.SharedPreferences.OnSharedPreferenceChangeListener mPrefListener;
    private static ReportsCrashes mReportsCrashes;

    public ACRA()
    {
    }

    static void checkCrashResources()
        throws ACRAConfigurationException
    {
        ACRAConfiguration acraconfiguration = getConfig();
        static class _cls2
        {

            static final int $SwitchMap$org$acra$ReportingInteractionMode[];

            static 
            {
                $SwitchMap$org$acra$ReportingInteractionMode = new int[ReportingInteractionMode.values().length];
                try
                {
                    $SwitchMap$org$acra$ReportingInteractionMode[ReportingInteractionMode.TOAST.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$acra$ReportingInteractionMode[ReportingInteractionMode.NOTIFICATION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$acra$ReportingInteractionMode[ReportingInteractionMode.DIALOG.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.org.acra.ReportingInteractionMode[acraconfiguration.mode().ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 45
    //                   2 64
    //                   3 110;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if (acraconfiguration.resToastText() == 0)
        {
            throw new ACRAConfigurationException("TOAST mode: you have to define the resToastText parameter in your application @ReportsCrashes() annotation.");
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (acraconfiguration.resNotifTickerText() == 0 || acraconfiguration.resNotifTitle() == 0 || acraconfiguration.resNotifText() == 0 || acraconfiguration.resDialogText() == 0)
        {
            throw new ACRAConfigurationException("NOTIFICATION mode: you have to define at least the resNotifTickerText, resNotifTitle, resNotifText, resDialogText parameters in your application @ReportsCrashes() annotation.");
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (acraconfiguration.resDialogText() == 0)
        {
            throw new ACRAConfigurationException("DIALOG mode: you have to define at least the resDialogText parameters in your application @ReportsCrashes() annotation.");
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static SharedPreferences getACRASharedPreferences()
    {
        ACRAConfiguration acraconfiguration = getConfig();
        if (!"".equals(acraconfiguration.sharedPreferencesName()))
        {
            return mApplication.getSharedPreferences(acraconfiguration.sharedPreferencesName(), acraconfiguration.sharedPreferencesMode());
        } else
        {
            return PreferenceManager.getDefaultSharedPreferences(mApplication);
        }
    }

    static Application getApplication()
    {
        return mApplication;
    }

    public static ACRAConfiguration getConfig()
    {
        if (configProxy == null)
        {
            if (mApplication == null)
            {
                log.w(LOG_TAG, "Calling ACRA.getConfig() before ACRA.init() gives you an empty configuration instance. You might prefer calling ACRA.getNewDefaultConfig(Application) to get an instance with default values taken from a @ReportsCrashes annotation.");
            }
            configProxy = getNewDefaultConfig(mApplication);
        }
        return configProxy;
    }

    public static ErrorReporter getErrorReporter()
    {
        if (errorReporterSingleton == null)
        {
            throw new IllegalStateException("Cannot access ErrorReporter before ACRA#init");
        } else
        {
            return errorReporterSingleton;
        }
    }

    public static ACRAConfiguration getNewDefaultConfig(Application application)
    {
        if (application != null)
        {
            return new ACRAConfiguration((ReportsCrashes)application.getClass().getAnnotation(org/acra/annotation/ReportsCrashes));
        } else
        {
            return new ACRAConfiguration(null);
        }
    }

    public static void init(Application application)
    {
        if (mApplication != null)
        {
            throw new IllegalStateException("ACRA#init called more than once");
        }
        mApplication = application;
        mReportsCrashes = (ReportsCrashes)mApplication.getClass().getAnnotation(org/acra/annotation/ReportsCrashes);
        if (mReportsCrashes == null)
        {
            log.e(LOG_TAG, (new StringBuilder()).append("ACRA#init called but no ReportsCrashes annotation on Application ").append(mApplication.getPackageName()).toString());
            return;
        }
        application = getACRASharedPreferences();
        checkCrashResources();
        log.d(LOG_TAG, (new StringBuilder()).append("ACRA is enabled for ").append(mApplication.getPackageName()).append(", intializing...").toString());
        boolean flag;
        if (!shouldDisableACRA(application))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            ErrorReporter errorreporter = new ErrorReporter(mApplication.getApplicationContext(), application, flag);
            errorreporter.setDefaultReportSenders();
            errorReporterSingleton = errorreporter;
        }
        catch (ACRAConfigurationException acraconfigurationexception)
        {
            log.w(LOG_TAG, "Error : ", acraconfigurationexception);
        }
        mPrefListener = new android.content.SharedPreferences.OnSharedPreferenceChangeListener() {

            public void onSharedPreferenceChanged(SharedPreferences sharedpreferences, String s)
            {
                if ("acra.disable".equals(s) || "acra.enable".equals(s))
                {
                    boolean flag1;
                    if (!ACRA.shouldDisableACRA(sharedpreferences))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    ACRA.getErrorReporter().setEnabled(flag1);
                }
            }

        };
        application.registerOnSharedPreferenceChangeListener(mPrefListener);
        return;
    }

    static boolean isDebuggable()
    {
        boolean flag = false;
        PackageManager packagemanager = mApplication.getPackageManager();
        int i;
        try
        {
            i = packagemanager.getApplicationInfo(mApplication.getPackageName(), 0).flags;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return false;
        }
        if ((i & 2) > 0)
        {
            flag = true;
        }
        return flag;
    }

    public static void setConfig(ACRAConfiguration acraconfiguration)
    {
        configProxy = acraconfiguration;
    }

    public static void setLog(ACRALog acralog)
    {
        log = acralog;
    }

    private static boolean shouldDisableACRA(SharedPreferences sharedpreferences)
    {
        boolean flag = true;
        if (sharedpreferences.getBoolean("acra.enable", true))
        {
            flag = false;
        }
        flag = sharedpreferences.getBoolean("acra.disable", flag);
        return flag;
        sharedpreferences;
        return false;
    }

    static 
    {
        DEFAULT_MAIL_REPORT_FIELDS = (new ReportField[] {
            ReportField.USER_COMMENT, ReportField.ANDROID_VERSION, ReportField.APP_VERSION_NAME, ReportField.BRAND, ReportField.PHONE_MODEL, ReportField.CUSTOM_DATA, ReportField.STACK_TRACE
        });
        DEFAULT_REPORT_FIELDS = (new ReportField[] {
            ReportField.REPORT_ID, ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME, ReportField.PACKAGE_NAME, ReportField.FILE_PATH, ReportField.PHONE_MODEL, ReportField.BRAND, ReportField.PRODUCT, ReportField.ANDROID_VERSION, ReportField.BUILD, 
            ReportField.TOTAL_MEM_SIZE, ReportField.AVAILABLE_MEM_SIZE, ReportField.CUSTOM_DATA, ReportField.IS_SILENT, ReportField.STACK_TRACE, ReportField.INITIAL_CONFIGURATION, ReportField.CRASH_CONFIGURATION, ReportField.DISPLAY, ReportField.USER_COMMENT, ReportField.USER_EMAIL, 
            ReportField.USER_APP_START_DATE, ReportField.USER_CRASH_DATE, ReportField.DUMPSYS_MEMINFO, ReportField.LOGCAT, ReportField.INSTALLATION_ID, ReportField.DEVICE_FEATURES, ReportField.ENVIRONMENT, ReportField.SHARED_PREFERENCES, ReportField.SETTINGS_SYSTEM, ReportField.SETTINGS_SECURE
        });
    }

}
