// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import java.io.IOException;
import java.net.SocketTimeoutException;
import org.acra.ACRA;
import org.acra.log.ACRALog;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package org.acra.util:
//            HttpRequest

private static class <init>
    implements HttpRequestRetryHandler
{

    private final HttpParams httpParams;
    private final int maxNrRetries;

    public boolean retryRequest(IOException ioexception, int i, HttpContext httpcontext)
    {
        if (ioexception instanceof SocketTimeoutException)
        {
            if (i <= maxNrRetries)
            {
                if (httpParams != null)
                {
                    i = HttpConnectionParams.getSoTimeout(httpParams) * 2;
                    HttpConnectionParams.setSoTimeout(httpParams, i);
                    ACRA.log.d(ACRA.LOG_TAG, (new StringBuilder()).append("SocketTimeOut - increasing time out to ").append(i).append(" millis and trying again").toString());
                } else
                {
                    ACRA.log.d(ACRA.LOG_TAG, "SocketTimeOut - no HttpParams, cannot increase time out. Trying again with current settings");
                }
                return true;
            }
            ACRA.log.d(ACRA.LOG_TAG, (new StringBuilder()).append("SocketTimeOut but exceeded max number of retries : ").append(maxNrRetries).toString());
        }
        return false;
    }

    private _cls9(HttpParams httpparams, int i)
    {
        httpParams = httpparams;
        maxNrRetries = i;
    }

    maxNrRetries(HttpParams httpparams, int i, maxNrRetries maxnrretries)
    {
        this(httpparams, i);
    }
}
