// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.google.appinventor.components.runtime:
//            WebViewer

private class <init> extends WebViewClient
{

    final WebViewer this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return !WebViewer.access$000(WebViewer.this);
    }

    private I()
    {
        this$0 = WebViewer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
