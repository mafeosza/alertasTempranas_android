// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.webkit.WebChromeClient;
import com.google.appinventor.components.runtime.WebViewer;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            EclairUtil

static final class val.activity extends WebChromeClient
{

    final Activity val$activity;
    final WebViewer val$caller;

    public void onGeolocationPermissionsShowPrompt(final String theOrigin, final android.webkit.rmissions.Callback theCallback)
    {
        if (!val$caller.PromptforPermission())
        {
            theCallback.invoke(theOrigin, true, true);
            return;
        }
        AlertDialog alertdialog = (new android.app.uilder(val$activity)).create();
        alertdialog.setTitle("Permission Request");
        String s = theOrigin;
        if (theOrigin.equals("file://"))
        {
            s = "This Application";
        }
        alertdialog.setMessage((new StringBuilder()).append(s).append(" would like to access your location.").toString());
        alertdialog.setButton(-1, "Allow", new android.content.DialogInterface.OnClickListener() {

            final EclairUtil._cls1 this$0;
            final android.webkit.GeolocationPermissions.Callback val$theCallback;
            final String val$theOrigin;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                theCallback.invoke(theOrigin, true, true);
            }

            
            {
                this$0 = EclairUtil._cls1.this;
                theCallback = callback;
                theOrigin = s;
                super();
            }
        });
        alertdialog.setButton(-2, "Refuse", new android.content.DialogInterface.OnClickListener() {

            final EclairUtil._cls1 this$0;
            final android.webkit.GeolocationPermissions.Callback val$theCallback;
            final String val$theOrigin;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                theCallback.invoke(theOrigin, false, true);
            }

            
            {
                this$0 = EclairUtil._cls1.this;
                theCallback = callback;
                theOrigin = s;
                super();
            }
        });
        alertdialog.show();
    }

    _cls2.val.theOrigin(WebViewer webviewer, Activity activity1)
    {
        val$caller = webviewer;
        val$activity = activity1;
        super();
    }
}
