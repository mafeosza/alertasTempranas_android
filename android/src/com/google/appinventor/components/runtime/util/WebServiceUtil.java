// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            AsyncCallbackPair

public class WebServiceUtil
{

    private static final WebServiceUtil INSTANCE = new WebServiceUtil();
    private static final String LOG_TAG = "WebServiceUtil";
    private static HttpClient httpClient = null;
    private static Object httpClientSynchronizer = new Object();

    private WebServiceUtil()
    {
    }

    public static WebServiceUtil getInstance()
    {
        synchronized (httpClientSynchronizer)
        {
            if (httpClient == null)
            {
                SchemeRegistry schemeregistry = new SchemeRegistry();
                schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
                BasicHttpParams basichttpparams = new BasicHttpParams();
                HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
                HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
                ConnManagerParams.setMaxTotalConnections(basichttpparams, 20);
                httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
            }
        }
        return INSTANCE;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void postCommand(String s, String s1, List list, AsyncCallbackPair asynccallbackpair)
    {
        Log.d("WebServiceUtil", (new StringBuilder()).append("Posting ").append(s1).append(" to ").append(s).append(" with arguments ").append(list).toString());
        if (s == null || s.equals(""))
        {
            asynccallbackpair.onFailure("No service url to post command to.");
        }
        s1 = new HttpPost((new StringBuilder()).append(s).append("/").append(s1).toString());
        s = list;
        if (list == null)
        {
            s = new ArrayList();
        }
        try
        {
            list = new BasicResponseHandler();
            s1.setEntity(new UrlEncodedFormEntity(s, "UTF-8"));
            s1.setHeader("Accept", "application/json");
            asynccallbackpair.onSuccess((String)httpClient.execute(s1, list));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("WebServiceUtil", s);
            asynccallbackpair.onFailure("Failed to encode params for web service call.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("WebServiceUtil", s);
            asynccallbackpair.onFailure("Communication with the web service encountered a protocol exception.");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.w("WebServiceUtil", s);
        }
        asynccallbackpair.onFailure("Communication with the web service timed out.");
    }

    public void postCommandReturningArray(String s, String s1, List list, final AsyncCallbackPair callback)
    {
        postCommand(s, s1, list, new AsyncCallbackPair() {

            final WebServiceUtil this$0;
            final AsyncCallbackPair val$callback;

            public void onFailure(String s2)
            {
                callback.onFailure(s2);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((String)obj);
            }

            public void onSuccess(String s2)
            {
                try
                {
                    callback.onSuccess(new JSONArray(s2));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    callback.onFailure(s2.getMessage());
                }
            }

            
            {
                this$0 = WebServiceUtil.this;
                callback = asynccallbackpair;
                super();
            }
        });
    }

    public void postCommandReturningObject(String s, String s1, List list, final AsyncCallbackPair callback)
    {
        postCommand(s, s1, list, new AsyncCallbackPair() {

            final WebServiceUtil this$0;
            final AsyncCallbackPair val$callback;

            public void onFailure(String s2)
            {
                callback.onFailure(s2);
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((String)obj);
            }

            public void onSuccess(String s2)
            {
                try
                {
                    callback.onSuccess(new JSONObject(s2));
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s2)
                {
                    callback.onFailure(s2.getMessage());
                }
            }

            
            {
                this$0 = WebServiceUtil.this;
                callback = asynccallbackpair;
                super();
            }
        });
    }

}
