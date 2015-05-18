// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public final class WebViewActivity extends Activity
{

    public WebViewActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new WebView(this);
        bundle.getSettings().setJavaScriptEnabled(true);
        bundle.setWebViewClient(new WebViewClient() {

            final WebViewActivity this$0;

            public boolean shouldOverrideUrlLoading(WebView webview, String s2)
            {
                Log.i("WebView", (new StringBuilder()).append("Handling url ").append(s2).toString());
                Uri uri = Uri.parse(s2);
                if (uri.getScheme().equals("appinventor"))
                {
                    webview = new Intent();
                    webview.setData(uri);
                    setResult(-1, webview);
                    finish();
                } else
                {
                    webview.loadUrl(s2);
                }
                return true;
            }

            
            {
                this$0 = WebViewActivity.this;
                super();
            }
        });
        setContentView(bundle);
        Object obj = getIntent();
        if (obj != null && ((Intent) (obj)).getData() != null)
        {
            obj = ((Intent) (obj)).getData();
            String s = ((Uri) (obj)).getScheme();
            String s1 = ((Uri) (obj)).getHost();
            Log.i("WebView", (new StringBuilder()).append("Got intent with URI: ").append(obj).append(", scheme=").append(s).append(", host=").append(s1).toString());
            bundle.loadUrl(((Uri) (obj)).toString());
        }
    }
}
