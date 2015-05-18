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

class val.theOrigin
    implements android.content..OnClickListener
{

    final val.theOrigin this$0;
    final android.webkit.issions.Callback val$theCallback;
    final String val$theOrigin;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        val$theCallback.invoke(val$theOrigin, false, true);
    }

    l.activity()
    {
        this$0 = final_activity;
        val$theCallback = callback;
        val$theOrigin = String.this;
        super();
    }

    // Unreferenced inner class com/google/appinventor/components/runtime/util/EclairUtil$1

/* anonymous class */
    static final class EclairUtil._cls1 extends WebChromeClient
    {

        final Activity val$activity;
        final WebViewer val$caller;

        public void onGeolocationPermissionsShowPrompt(final String theOrigin, final android.webkit.GeolocationPermissions.Callback theCallback)
        {
            if (!caller.PromptforPermission())
            {
                theCallback.invoke(theOrigin, true, true);
                return;
            }
            AlertDialog alertdialog = (new android.app.AlertDialog.Builder(activity)).create();
            alertdialog.setTitle("Permission Request");
            String s = theOrigin;
            if (theOrigin.equals("file://"))
            {
                s = "This Application";
            }
            alertdialog.setMessage((new StringBuilder()).append(s).append(" would like to access your location.").toString());
            alertdialog.setButton(-1, "Allow", new EclairUtil._cls1._cls1());
            alertdialog.setButton(-2, "Refuse", theOrigin. new EclairUtil._cls1._cls2());
            alertdialog.show();
        }

            
            {
                caller = webviewer;
                activity = activity1;
                super();
            }

        // Unreferenced inner class com/google/appinventor/components/runtime/util/EclairUtil$1$1

/* anonymous class */
        class EclairUtil._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

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
        }

    }

}
