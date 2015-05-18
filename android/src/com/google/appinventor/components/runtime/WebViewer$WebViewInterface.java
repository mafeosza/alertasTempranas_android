// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;

// Referenced classes of package com.google.appinventor.components.runtime:
//            WebViewer

public class webViewString
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

    (Context context)
    {
        this$0 = WebViewer.this;
        super();
        mContext = context;
        webViewString = " ";
    }
}
