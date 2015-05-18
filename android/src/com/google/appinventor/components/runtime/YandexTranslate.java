// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, ComponentContainer, Form, EventDispatcher

public final class YandexTranslate extends AndroidNonvisibleComponent
{

    public static final String YANDEX_TRANSLATE_SERVICE_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=";
    private final Activity activity;
    private final byte key1[] = {
        -127, -88, 79, 80, 65, 112, -80, 87, -62, 126, 
        -125, -25, -31, 55, 107, -42, -63, -62, 33, -122, 
        1, 89, -33, 23, -19, 18, -81, 37, -67, 114, 
        92, -60, -76, -50, -59, -49, -114, -64, -96, -75, 
        117, -116, 53, -8, 44, 111, 120, 48, 41, 30, 
        85, -116, -31, 17, 87, -89, -49, -51, 47, 92, 
        121, -58, -80, -25, 86, 123, -36, -9, 101, -112, 
        -22, -28, -29, -14, -125, 46, -103, -36, 125, 114, 
        35, -31, 1, 123
    };
    private final byte key2[] = {
        -11, -38, 33, 35, 45, 94, -127, 121, -13, 80, 
        -79, -41, -48, 3, 91, -29, -15, -9, 117, -74, 
        49, 105, -26, 34, -35, 72, -127, 64, -116, 69, 
        111, -12, -48, -81, -11, -83, -69, -12, -108, -42, 
        65, -72, 86, -42, 27, 12, 26, 2, 28, 122, 
        51, -24, -45, 36, 54, -106, -87, -3, 27, 62, 
        65, -16, -126, -42, 99, 77, -70, -49, 83, -12, 
        -114, -35, -44, -109, -77, 28, -84, -66, 72, 22, 
        18, -126, 50, 78
    };
    private final String yandexKey = gk();

    public YandexTranslate(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        form.setYandexTranslateTagline();
        activity = componentcontainer.$context();
    }

    private static String getResponseContent(HttpURLConnection httpurlconnection)
        throws IOException
    {
        Object obj;
        String s = httpurlconnection.getContentEncoding();
        obj = s;
        if (s == null)
        {
            obj = "UTF-8";
        }
        obj = new InputStreamReader(httpurlconnection.getInputStream(), ((String) (obj)));
        int i = httpurlconnection.getContentLength();
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        httpurlconnection = new StringBuilder(i);
_L2:
        char ac[] = new char[1024];
_L1:
        i = ((InputStreamReader) (obj)).read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        httpurlconnection.append(ac, 0, i);
          goto _L1
        httpurlconnection;
        ((InputStreamReader) (obj)).close();
        throw httpurlconnection;
        httpurlconnection = new StringBuilder();
          goto _L2
        httpurlconnection = httpurlconnection.toString();
        ((InputStreamReader) (obj)).close();
        return httpurlconnection;
    }

    private String gk()
    {
        byte abyte0[] = new byte[key1.length];
        for (int i = 0; i < key1.length; i++)
        {
            abyte0[i] = (byte)(key1[i] ^ key2[i]);
        }

        return new String(abyte0);
    }

    private void performRequest(String s, final String responseCode)
        throws IOException, JSONException
    {
        s = (HttpURLConnection)(new URL((new StringBuilder()).append("https://translate.yandex.net/api/v1.5/tr.json/translate?key=").append(yandexKey).append("&lang=").append(s).append("&text=").append(URLEncoder.encode(responseCode, "UTF-8")).toString())).openConnection();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_121;
        }
        final String translation = new JSONObject(getResponseContent(s));
        responseCode = translation.getString("code");
        translation = (String)translation.getJSONArray("text").get(0);
        activity.runOnUiThread(new Runnable() {

            final YandexTranslate this$0;
            final String val$responseCode;
            final String val$translation;

            public void run()
            {
                GotTranslation(responseCode, translation);
            }

            
            {
                this$0 = YandexTranslate.this;
                responseCode = s;
                translation = s1;
                super();
            }
        });
        s.disconnect();
        return;
        responseCode;
        s.disconnect();
        throw responseCode;
    }

    public void GotTranslation(String s, String s1)
    {
        EventDispatcher.dispatchEvent(this, "GotTranslation", new Object[] {
            s, s1
        });
    }

    public void RequestTranslation(final String languageToTranslateTo, final String textToTranslate)
    {
        if (yandexKey.equals(""))
        {
            form.dispatchErrorOccurredEvent(this, "RequestTranslation", 2201, new Object[0]);
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final YandexTranslate this$0;
                final String val$languageToTranslateTo;
                final String val$textToTranslate;

                public void run()
                {
                    try
                    {
                        performRequest(languageToTranslateTo, textToTranslate);
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        form.dispatchErrorOccurredEvent(YandexTranslate.this, "RequestTranslation", 2202, new Object[0]);
                        return;
                    }
                    catch (JSONException jsonexception)
                    {
                        form.dispatchErrorOccurredEvent(YandexTranslate.this, "RequestTranslation", 2203, new Object[0]);
                    }
                }

            
            {
                this$0 = YandexTranslate.this;
                languageToTranslateTo = s;
                textToTranslate = s1;
                super();
            }
            });
            return;
        }
    }

}
