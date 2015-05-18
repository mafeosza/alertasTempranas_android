// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Web

private static class cookies
{

    final boolean allowCookies;
    final Map cookies;
    final Map requestHeaders;
    final String responseFileName;
    final boolean saveResponse;
    final URL url;
    final String urlString;

    rsException(Web web)
        throws MalformedURLException, rsException
    {
        urlString = Web.access$000(web);
        url = new URL(urlString);
        allowCookies = Web.access$100(web);
        saveResponse = Web.access$200(web);
        responseFileName = Web.access$300(web);
        requestHeaders = Web.access$500(Web.access$400(web));
        Object obj = null;
        Map map = obj;
        if (allowCookies)
        {
            map = obj;
            if (Web.access$600(web) != null)
            {
                try
                {
                    map = Web.access$600(web).get(url.toURI(), requestHeaders);
                }
                // Misplaced declaration of an exception variable
                catch (Web web)
                {
                    map = obj;
                }
                // Misplaced declaration of an exception variable
                catch (Web web)
                {
                    map = obj;
                }
            }
        }
        cookies = map;
    }
}
