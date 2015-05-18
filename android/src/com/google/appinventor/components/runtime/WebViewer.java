// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.appinventor.components.runtime.util.EclairUtil;
import com.google.appinventor.components.runtime.util.FroyoUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer

public final class WebViewer extends AndroidViewComponent
{
    public class WebViewInterface
    {

        Context mContext;
        final WebViewer this$0;
        String webViewString;

        public String getWebViewString()
        {
            return webViewString;
        }

        public void setWebViewString(String s)
        {
            webViewString = s;
        }

        WebViewInterface(Context context)
        {
            this$0 = WebViewer.this;
            super();
            mContext = context;
            webViewString = " ";
        }
    }

    private class WebViewerClient extends WebViewClient
    {

        final WebViewer this$0;

        public boolean shouldOverrideUrlLoading(WebView webview1, String s)
        {
            return !followLinks;
        }

        private WebViewerClient()
        {
            this$0 = WebViewer.this;
            super();
        }

    }


    private boolean followLinks;
    private String homeUrl;
    private boolean ignoreSslErrors;
    private boolean prompt;
    private final WebView webview;
    WebViewInterface wvInterface;

    public WebViewer(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        followLinks = true;
        prompt = true;
        ignoreSslErrors = false;
        webview = new WebView(componentcontainer.$context());
        resetWebViewClient();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setFocusable(true);
        wvInterface = new WebViewInterface(webview.getContext());
        webview.addJavascriptInterface(wvInterface, "AppInventor");
        webview.getSettings().setBuiltInZoomControls(true);
        if (SdkLevel.getLevel() >= 5)
        {
            EclairUtil.setupWebViewGeoLoc(this, webview, componentcontainer.$context());
        }
        componentcontainer.$add(this);
        webview.setOnTouchListener(new android.view.View.OnTouchListener() {

            final WebViewer this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                motionevent.getAction();
                JVM INSTR tableswitch 0 1: default 28
            //                           0 30
            //                           1 30;
                   goto _L1 _L2 _L2
_L1:
                return false;
_L2:
                if (!view.hasFocus())
                {
                    view.requestFocus();
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = WebViewer.this;
                super();
            }
        });
        HomeUrl("");
        Width(-2);
        Height(-2);
    }

    private void resetWebViewClient()
    {
        if (SdkLevel.getLevel() >= 8)
        {
            webview.setWebViewClient(FroyoUtil.getWebViewClient(ignoreSslErrors, followLinks, container.$form(), this));
            return;
        } else
        {
            webview.setWebViewClient(new WebViewerClient());
            return;
        }
    }

    public boolean CanGoBack()
    {
        return webview.canGoBack();
    }

    public boolean CanGoForward()
    {
        return webview.canGoForward();
    }

    public void ClearCaches()
    {
        webview.clearCache(true);
    }

    public void ClearLocations()
    {
        if (SdkLevel.getLevel() >= 5)
        {
            EclairUtil.clearWebViewGeoLoc();
        }
    }

    public String CurrentPageTitle()
    {
        if (webview.getTitle() == null)
        {
            return "";
        } else
        {
            return webview.getTitle();
        }
    }

    public String CurrentUrl()
    {
        if (webview.getUrl() == null)
        {
            return "";
        } else
        {
            return webview.getUrl();
        }
    }

    public void FollowLinks(boolean flag)
    {
        followLinks = flag;
        resetWebViewClient();
    }

    public boolean FollowLinks()
    {
        return followLinks;
    }

    public void GoBack()
    {
        if (webview.canGoBack())
        {
            webview.goBack();
        }
    }

    public void GoForward()
    {
        if (webview.canGoForward())
        {
            webview.goForward();
        }
    }

    public void GoHome()
    {
        webview.loadUrl(homeUrl);
    }

    public void GoToUrl(String s)
    {
        webview.loadUrl(s);
    }

    public void Height(int i)
    {
        int j = i;
        if (i == -1)
        {
            j = -2;
        }
        super.Height(j);
    }

    public String HomeUrl()
    {
        return homeUrl;
    }

    public void HomeUrl(String s)
    {
        homeUrl = s;
        webview.clearHistory();
        webview.loadUrl(homeUrl);
    }

    public void IgnoreSslErrors(boolean flag)
    {
        ignoreSslErrors = flag;
        resetWebViewClient();
    }

    public boolean IgnoreSslErrors()
    {
        return ignoreSslErrors;
    }

    public void PromptforPermission(boolean flag)
    {
        prompt = flag;
    }

    public boolean PromptforPermission()
    {
        return prompt;
    }

    public void UsesLocation(boolean flag)
    {
    }

    public String WebViewString()
    {
        return wvInterface.getWebViewString();
    }

    public void WebViewString(String s)
    {
        wvInterface.setWebViewString(s);
    }

    public void Width(int i)
    {
        int j = i;
        if (i == -1)
        {
            j = -2;
        }
        super.Width(j);
    }

    public View getView()
    {
        return webview;
    }

}
