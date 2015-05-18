// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.appinventor.components.runtime.WebViewer;
import java.io.File;

public class EclairUtil
{

    private EclairUtil()
    {
    }

    public static void clearWebViewGeoLoc()
    {
        GeolocationPermissions.getInstance().clearAll();
    }

    public static String getInstallerPackageName(String s, Activity activity)
    {
        return activity.getPackageManager().getInstallerPackageName(s);
    }

    public static void overridePendingTransitions(Activity activity, int i, int j)
    {
        activity.overridePendingTransition(i, j);
    }

    public static void setupWebViewGeoLoc(WebViewer webviewer, WebView webview, Activity activity)
    {
        webview.getSettings().setGeolocationDatabasePath(activity.getFilesDir().getAbsolutePath());
        webview.getSettings().setDatabaseEnabled(true);
        webview.setWebChromeClient(new WebChromeClient(webviewer, activity) {

            final Activity val$activity;
            final WebViewer val$caller;

            public void onGeolocationPermissionsShowPrompt(String s, final android.webkit.GeolocationPermissions.Callback theCallback)
            {
                if (!caller.PromptforPermission())
                {
                    theCallback.invoke(s, true, true);
                    return;
                }
                AlertDialog alertdialog = (new android.app.AlertDialog.Builder(activity)).create();
                alertdialog.setTitle("Permission Request");
                String s1 = s;
                if (s.equals("file://"))
                {
                    s1 = "This Application";
                }
                alertdialog.setMessage((new StringBuilder()).append(s1).append(" would like to access your location.").toString());
                alertdialog.setButton(-1, "Allow", s. new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$0;
                    final android.webkit.GeolocationPermissions.Callback val$theCallback;
                    final String val$theOrigin;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        theCallback.invoke(theOrigin, true, true);
                    }

            
            {
                this$0 = final__pcls1;
                theCallback = callback;
                theOrigin = String.this;
                super();
            }
                });
                alertdialog.setButton(-2, "Refuse", s. new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$0;
                    final android.webkit.GeolocationPermissions.Callback val$theCallback;
                    final String val$theOrigin;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        theCallback.invoke(theOrigin, false, true);
                    }

            
            {
                this$0 = final__pcls1;
                theCallback = callback;
                theOrigin = String.this;
                super();
            }
                });
                alertdialog.show();
            }

            
            {
                caller = webviewer;
                activity = activity1;
                super();
            }
        });
    }
}
