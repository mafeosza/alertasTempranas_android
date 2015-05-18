// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.log.ACRALog;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

// Referenced classes of package org.acra.util:
//            FakeSocketFactory

public final class HttpRequest
{
    private static class SocketTimeOutRetryHandler
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

        private SocketTimeOutRetryHandler(HttpParams httpparams, int i)
        {
            httpParams = httpparams;
            maxNrRetries = i;
        }

    }


    private int connectionTimeOut;
    private String login;
    private int maxNrRetries;
    private String password;
    private int socketTimeOut;

    public HttpRequest()
    {
        connectionTimeOut = 3000;
        socketTimeOut = 3000;
        maxNrRetries = 3;
    }

    private UsernamePasswordCredentials getCredentials()
    {
        if (login != null || password != null)
        {
            return new UsernamePasswordCredentials(login, password);
        } else
        {
            return null;
        }
    }

    private HttpClient getHttpClient()
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        basichttpparams.setParameter("http.protocol.cookie-policy", "rfc2109");
        HttpConnectionParams.setConnectionTimeout(basichttpparams, connectionTimeOut);
        HttpConnectionParams.setSoTimeout(basichttpparams, socketTimeOut);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        Object obj = new SchemeRegistry();
        ((SchemeRegistry) (obj)).register(new Scheme("http", new PlainSocketFactory(), 80));
        if (ACRA.getConfig().disableSSLCertValidation())
        {
            ((SchemeRegistry) (obj)).register(new Scheme("https", new FakeSocketFactory(), 443));
        } else
        {
            ((SchemeRegistry) (obj)).register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        }
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, ((SchemeRegistry) (obj))), basichttpparams);
        ((DefaultHttpClient) (obj)).setHttpRequestRetryHandler(new SocketTimeOutRetryHandler(basichttpparams, maxNrRetries));
        return ((HttpClient) (obj));
    }

    private HttpPost getHttpPost(URL url, Map map)
        throws UnsupportedEncodingException
    {
        url = new HttpPost(url.toString());
        UsernamePasswordCredentials usernamepasswordcredentials = getCredentials();
        if (usernamepasswordcredentials != null)
        {
            url.addHeader(BasicScheme.authenticate(usernamepasswordcredentials, "UTF-8", false));
        }
        url.setHeader("User-Agent", "Android");
        url.setHeader("Accept", "text/html,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5");
        url.setHeader("Content-Type", "application/x-www-form-urlencoded");
        url.setEntity(new StringEntity(getParamsAsString(map), "UTF-8"));
        return url;
    }

    private String getParamsAsString(Map map)
        throws UnsupportedEncodingException
    {
        StringBuilder stringbuilder = new StringBuilder();
        Object obj;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); stringbuilder.append(URLEncoder.encode(obj.toString(), "UTF-8")))
        {
            Object obj1 = iterator.next();
            if (stringbuilder.length() != 0)
            {
                stringbuilder.append('&');
            }
            obj = map.get(obj1);
            if (obj == null)
            {
                obj = "";
            }
            stringbuilder.append(URLEncoder.encode(obj1.toString(), "UTF-8"));
            stringbuilder.append('=');
        }

        return stringbuilder.toString();
    }

    public void sendPost(URL url, Map map)
        throws IOException
    {
        HttpClient httpclient = getHttpClient();
        HttpPost httppost = getHttpPost(url, map);
        ACRA.log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Sending request to ").append(url).toString());
        for (url = map.keySet().iterator(); url.hasNext(); url.next()) { }
        url = httpclient.execute(httppost, new BasicHttpContext());
        if (url != null)
        {
            if (url.getStatusLine() != null)
            {
                map = Integer.toString(url.getStatusLine().getStatusCode());
                if (map.startsWith("4") || map.startsWith("5"))
                {
                    throw new IOException((new StringBuilder()).append("Host returned error code ").append(map).toString());
                }
            }
            EntityUtils.toString(url.getEntity());
        }
    }

    public void setConnectionTimeOut(int i)
    {
        connectionTimeOut = i;
    }

    public void setLogin(String s)
    {
        login = s;
    }

    public void setMaxNrRetries(int i)
    {
        maxNrRetries = i;
    }

    public void setPassword(String s)
    {
        password = s;
    }

    public void setSocketTimeOut(int i)
    {
        socketTimeOut = i;
    }
}
