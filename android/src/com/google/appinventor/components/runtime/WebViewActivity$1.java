// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

// Referenced classes of package com.google.appinventor.components.runtime:
//            WebViewActivity

class this._cls0 extends WebViewClient
{

    final WebViewActivity this$0;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        Log.i("WebView", (new StringBuilder()).append("Handling url ").append(s).toString());
        Uri uri = Uri.parse(s);
        if (uri.getScheme().equals("appinventor"))
        {
            webview = new Intent();
            webview.setData(uri);
            setResult(-1, webview);
            finish();
        } else
        {
            webview.loadUrl(s);
        }
        return true;
    }

    A()
    {
        this$0 = WebViewActivity.this;
        super();
    }
}
