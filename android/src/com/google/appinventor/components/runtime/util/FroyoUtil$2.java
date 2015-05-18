// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            FroyoUtil

static final class val.component extends WebViewClient
{

    final Component val$component;
    final boolean val$followLinks;
    final Form val$form;
    final boolean val$ignoreErrors;

    public void onReceivedSslError(WebView webview, SslErrorHandler sslerrorhandler, SslError sslerror)
    {
        if (val$ignoreErrors)
        {
            sslerrorhandler.proceed();
            return;
        } else
        {
            sslerrorhandler.cancel();
            val$form.dispatchErrorOccurredEvent(val$component, "WebView", 2501, new Object[0]);
            return;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return !val$followLinks;
    }

    (boolean flag, boolean flag1, Form form1, Component component1)
    {
        val$followLinks = flag;
        val$ignoreErrors = flag1;
        val$form = form1;
        val$component = component1;
        super();
    }
}
