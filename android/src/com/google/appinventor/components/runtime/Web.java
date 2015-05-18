// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.google.appinventor.components.common.HtmlEntities;
import com.google.appinventor.components.runtime.collect.Lists;
import com.google.appinventor.components.runtime.collect.Maps;
import com.google.appinventor.components.runtime.util.AsynchUtil;
import com.google.appinventor.components.runtime.util.FileUtil;
import com.google.appinventor.components.runtime.util.GingerbreadUtil;
import com.google.appinventor.components.runtime.util.JsonUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.SdkLevel;
import com.google.appinventor.components.runtime.util.YailList;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, Form, 
//            EventDispatcher

public class Web extends AndroidNonvisibleComponent
    implements Component
{
    static class BuildRequestDataException extends Exception
    {

        final int errorNumber;
        final int index;

        BuildRequestDataException(int i, int j)
        {
            errorNumber = i;
            index = j;
        }
    }

    private static class CapturedProperties
    {

        final boolean allowCookies;
        final Map cookies;
        final Map requestHeaders;
        final String responseFileName;
        final boolean saveResponse;
        final URL url;
        final String urlString;

        CapturedProperties(Web web)
            throws MalformedURLException, InvalidRequestHeadersException
        {
            urlString = web.urlString;
            url = new URL(urlString);
            allowCookies = web.allowCookies;
            saveResponse = web.saveResponse;
            responseFileName = web.responseFileName;
            requestHeaders = Web.processRequestHeaders(web.requestHeaders);
            Object obj = null;
            Map map = obj;
            if (allowCookies)
            {
                map = obj;
                if (web.cookieHandler != null)
                {
                    try
                    {
                        map = web.cookieHandler.get(url.toURI(), requestHeaders);
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

    private static class InvalidRequestHeadersException extends Exception
    {

        final int errorNumber;
        final int index;

        InvalidRequestHeadersException(int i, int j)
        {
            errorNumber = i;
            index = j;
        }
    }


    private static final String LOG_TAG = "Web";
    private static final Map mimeTypeToExtension;
    private final Activity activity;
    private boolean allowCookies;
    private final CookieHandler cookieHandler;
    private YailList requestHeaders;
    private String responseFileName;
    private boolean saveResponse;
    private String urlString;

    protected Web()
    {
        super(null);
        urlString = "";
        requestHeaders = new YailList();
        responseFileName = "";
        activity = null;
        cookieHandler = null;
    }

    public Web(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        urlString = "";
        requestHeaders = new YailList();
        responseFileName = "";
        activity = componentcontainer.$context();
        if (SdkLevel.getLevel() >= 9)
        {
            componentcontainer = GingerbreadUtil.newCookieManager();
        } else
        {
            componentcontainer = null;
        }
        cookieHandler = componentcontainer;
    }

    private CapturedProperties capturePropertyValues(String s)
    {
        CapturedProperties capturedproperties = new CapturedProperties(this);
        return capturedproperties;
        Object obj;
        obj;
        form.dispatchErrorOccurredEvent(this, s, 1109, new Object[] {
            urlString
        });
_L2:
        return null;
        obj;
        form.dispatchErrorOccurredEvent(this, s, ((InvalidRequestHeadersException) (obj)).errorNumber, new Object[] {
            Integer.valueOf(((InvalidRequestHeadersException) (obj)).index)
        });
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static File createFile(String s, String s1)
        throws IOException, com.google.appinventor.components.runtime.util.FileUtil.FileException
    {
        if (!TextUtils.isEmpty(s))
        {
            return FileUtil.getExternalFile(s);
        }
        int i = s1.indexOf(';');
        s = s1;
        if (i != -1)
        {
            s = s1.substring(0, i);
        }
        s1 = (String)mimeTypeToExtension.get(s);
        s = s1;
        if (s1 == null)
        {
            s = "tmp";
        }
        return FileUtil.getDownloadFile(s);
    }

    static Object decodeJsonText(String s)
        throws IllegalArgumentException
    {
        try
        {
            s = ((String) (JsonUtil.getObjectFromJson(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new IllegalArgumentException("jsonText is not a legal JSON value");
        }
        return s;
    }

    private static InputStream getConnectionStream(HttpURLConnection httpurlconnection)
    {
        InputStream inputstream;
        try
        {
            inputstream = httpurlconnection.getInputStream();
        }
        catch (IOException ioexception)
        {
            return httpurlconnection.getErrorStream();
        }
        return inputstream;
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
        obj = new InputStreamReader(getConnectionStream(httpurlconnection), ((String) (obj)));
        int i = httpurlconnection.getContentLength();
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        httpurlconnection = new StringBuilder(i);
_L2:
        char ac[] = new char[1024];
_L1:
        i = ((InputStreamReader) (obj)).read(ac);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_93;
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

    private static String getResponseType(HttpURLConnection httpurlconnection)
    {
        httpurlconnection = httpurlconnection.getContentType();
        if (httpurlconnection != null)
        {
            return httpurlconnection;
        } else
        {
            return "";
        }
    }

    private static HttpURLConnection openConnection(CapturedProperties capturedproperties, String s)
        throws IOException, ClassCastException, ProtocolException
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)capturedproperties.url.openConnection();
        if (s.equals("PUT") || s.equals("DELETE"))
        {
            httpurlconnection.setRequestMethod(s);
        }
        for (s = capturedproperties.requestHeaders.entrySet().iterator(); s.hasNext();)
        {
            Object obj1 = (java.util.Map.Entry)s.next();
            String s1 = (String)((java.util.Map.Entry) (obj1)).getKey();
            obj1 = ((List)((java.util.Map.Entry) (obj1)).getValue()).iterator();
            while (((Iterator) (obj1)).hasNext()) 
            {
                httpurlconnection.addRequestProperty(s1, (String)((Iterator) (obj1)).next());
            }
        }

        if (capturedproperties.cookies != null)
        {
            for (capturedproperties = capturedproperties.cookies.entrySet().iterator(); capturedproperties.hasNext();)
            {
                Object obj = (java.util.Map.Entry)capturedproperties.next();
                s = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = ((List)((java.util.Map.Entry) (obj)).getValue()).iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    httpurlconnection.addRequestProperty(s, (String)((Iterator) (obj)).next());
                }
            }

        }
        return httpurlconnection;
    }

    private void performRequest(final CapturedProperties webProps, final byte responseType[], final String path, String s)
        throws IOException
    {
        s = openConnection(webProps, s);
        if (s == null) goto _L2; else goto _L1
_L1:
        if (responseType == null) goto _L4; else goto _L3
_L3:
        writeRequestData(s, responseType);
_L6:
        final int responseCode;
        responseCode = s.getResponseCode();
        responseType = getResponseType(s);
        processResponseCookies(s);
        if (!saveResponse)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        path = saveResponseContent(s, webProps.responseFileName, responseType);
        activity.runOnUiThread(new Runnable() {

            final Web this$0;
            final String val$path;
            final int val$responseCode;
            final String val$responseType;
            final CapturedProperties val$webProps;

            public void run()
            {
                GotFile(webProps.urlString, responseCode, responseType, path);
            }

            
            {
                this$0 = Web.this;
                webProps = capturedproperties;
                responseCode = i;
                responseType = s;
                path = s1;
                super();
            }
        });
_L7:
        s.disconnect();
_L2:
        return;
_L4:
        if (path == null) goto _L6; else goto _L5
_L5:
        writeRequestFile(s, path);
          goto _L6
        webProps;
        s.disconnect();
        throw webProps;
        path = getResponseContent(s);
        activity.runOnUiThread(new Runnable() {

            final Web this$0;
            final int val$responseCode;
            final String val$responseContent;
            final String val$responseType;
            final CapturedProperties val$webProps;

            public void run()
            {
                GotText(webProps.urlString, responseCode, responseType, responseContent);
            }

            
            {
                this$0 = Web.this;
                webProps = capturedproperties;
                responseCode = i;
                responseType = s;
                responseContent = s1;
                super();
            }
        });
          goto _L7
    }

    private static Map processRequestHeaders(YailList yaillist)
        throws InvalidRequestHeadersException
    {
        java.util.HashMap hashmap = Maps.newHashMap();
        for (int i = 0; i < yaillist.size();)
        {
            Object obj = yaillist.getObject(i);
            if (obj instanceof YailList)
            {
                Object obj1 = (YailList)obj;
                if (((YailList) (obj1)).size() == 2)
                {
                    String s = ((YailList) (obj1)).getObject(0).toString();
                    Object obj2 = ((YailList) (obj1)).getObject(1);
                    obj1 = Lists.newArrayList();
                    if (obj2 instanceof YailList)
                    {
                        obj2 = (YailList)obj2;
                        for (int j = 0; j < ((YailList) (obj2)).size(); j++)
                        {
                            ((List) (obj1)).add(((YailList) (obj2)).getObject(j).toString());
                        }

                    } else
                    {
                        ((List) (obj1)).add(obj2.toString());
                    }
                    hashmap.put(s, obj1);
                    i++;
                } else
                {
                    throw new InvalidRequestHeadersException(1111, i + 1);
                }
            } else
            {
                throw new InvalidRequestHeadersException(1110, i + 1);
            }
        }

        return hashmap;
    }

    private void processResponseCookies(HttpURLConnection httpurlconnection)
    {
        if (!allowCookies || cookieHandler == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        Map map = httpurlconnection.getHeaderFields();
        cookieHandler.put(httpurlconnection.getURL().toURI(), map);
        return;
        httpurlconnection;
        return;
        httpurlconnection;
    }

    private void requestTextImpl(final String text, final String encoding, final String functionName, final String httpVerb)
    {
        final CapturedProperties webProps = capturePropertyValues(functionName);
        if (webProps == null)
        {
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Web this$0;
                final String val$encoding;
                final String val$functionName;
                final String val$httpVerb;
                final String val$text;
                final CapturedProperties val$webProps;

                public void run()
                {
                    if (encoding != null && encoding.length() != 0) goto _L2; else goto _L1
_L1:
                    byte abyte0[] = text.getBytes("UTF-8");
_L4:
                    UnsupportedEncodingException unsupportedencodingexception;
                    try
                    {
                        performRequest(webProps, abyte0, null, httpVerb);
                        return;
                    }
                    catch (com.google.appinventor.components.runtime.util.FileUtil.FileException fileexception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, functionName, fileexception.getErrorMessageNumber(), new Object[0]);
                        return;
                    }
                    catch (Exception exception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, functionName, 1103, new Object[] {
                            text, webProps.urlString
                        });
                    }
                    break MISSING_BLOCK_LABEL_165;
_L2:
                    try
                    {
                        abyte0 = text.getBytes(encoding);
                    }
                    // Misplaced declaration of an exception variable
                    catch (UnsupportedEncodingException unsupportedencodingexception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, functionName, 1102, new Object[] {
                            encoding
                        });
                        return;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                this$0 = Web.this;
                encoding = s;
                text = s1;
                functionName = s2;
                webProps = capturedproperties;
                httpVerb = s3;
                super();
            }
            });
            return;
        }
    }

    private static String saveResponseContent(HttpURLConnection httpurlconnection, String s, String s1)
        throws IOException
    {
        s = createFile(s, s1);
        httpurlconnection = new BufferedInputStream(getConnectionStream(httpurlconnection), 4096);
        s1 = new BufferedOutputStream(new FileOutputStream(s), 4096);
_L1:
        int i = httpurlconnection.read();
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        s1.flush();
        s1.close();
        httpurlconnection.close();
        return s.getAbsolutePath();
        s1.write(i);
          goto _L1
        s;
        s1.close();
        throw s;
        s;
        httpurlconnection.close();
        throw s;
    }

    private static void writeRequestData(HttpURLConnection httpurlconnection, byte abyte0[])
        throws IOException
    {
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setFixedLengthStreamingMode(abyte0.length);
        httpurlconnection = new BufferedOutputStream(httpurlconnection.getOutputStream());
        httpurlconnection.write(abyte0, 0, abyte0.length);
        httpurlconnection.flush();
        httpurlconnection.close();
        return;
        abyte0;
        httpurlconnection.close();
        throw abyte0;
    }

    private void writeRequestFile(HttpURLConnection httpurlconnection, String s)
        throws IOException
    {
        s = new BufferedInputStream(MediaUtil.openMedia(form, s));
        httpurlconnection.setDoOutput(true);
        httpurlconnection.setChunkedStreamingMode(0);
        httpurlconnection = new BufferedOutputStream(httpurlconnection.getOutputStream());
_L1:
        int i = s.read();
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        httpurlconnection.flush();
        httpurlconnection.close();
        s.close();
        return;
        httpurlconnection.write(i);
          goto _L1
        Exception exception;
        exception;
        httpurlconnection.close();
        throw exception;
        httpurlconnection;
        s.close();
        throw httpurlconnection;
    }

    public void AllowCookies(boolean flag)
    {
        allowCookies = flag;
        if (flag && cookieHandler == null)
        {
            form.dispatchErrorOccurredEvent(this, "AllowCookies", 4, new Object[0]);
        }
    }

    public boolean AllowCookies()
    {
        return allowCookies;
    }

    public String BuildRequestData(YailList yaillist)
    {
        try
        {
            yaillist = buildRequestData(yaillist);
        }
        // Misplaced declaration of an exception variable
        catch (YailList yaillist)
        {
            form.dispatchErrorOccurredEvent(this, "BuildRequestData", ((BuildRequestDataException) (yaillist)).errorNumber, new Object[] {
                Integer.valueOf(((BuildRequestDataException) (yaillist)).index)
            });
            return "";
        }
        return yaillist;
    }

    public void ClearCookies()
    {
        if (cookieHandler != null)
        {
            GingerbreadUtil.clearCookies(cookieHandler);
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(this, "ClearCookies", 4, new Object[0]);
            return;
        }
    }

    public void Delete()
    {
        final CapturedProperties webProps = capturePropertyValues("Delete");
        if (webProps == null)
        {
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Web this$0;
                final CapturedProperties val$webProps;

                public void run()
                {
                    try
                    {
                        performRequest(webProps, null, null, "DELETE");
                        return;
                    }
                    catch (com.google.appinventor.components.runtime.util.FileUtil.FileException fileexception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "Delete", fileexception.getErrorMessageNumber(), new Object[0]);
                        return;
                    }
                    catch (Exception exception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "Delete", 1114, new Object[] {
                            webProps.urlString
                        });
                    }
                }

            
            {
                this$0 = Web.this;
                webProps = capturedproperties;
                super();
            }
            });
            return;
        }
    }

    public void Get()
    {
        final CapturedProperties webProps = capturePropertyValues("Get");
        if (webProps == null)
        {
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Web this$0;
                final CapturedProperties val$webProps;

                public void run()
                {
                    try
                    {
                        performRequest(webProps, null, null, "GET");
                        return;
                    }
                    catch (com.google.appinventor.components.runtime.util.FileUtil.FileException fileexception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "Get", fileexception.getErrorMessageNumber(), new Object[0]);
                        return;
                    }
                    catch (Exception exception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "Get", 1101, new Object[] {
                            webProps.urlString
                        });
                    }
                }

            
            {
                this$0 = Web.this;
                webProps = capturedproperties;
                super();
            }
            });
            return;
        }
    }

    public void GotFile(String s, int i, String s1, String s2)
    {
        EventDispatcher.dispatchEvent(this, "GotFile", new Object[] {
            s, Integer.valueOf(i), s1, s2
        });
    }

    public void GotText(String s, int i, String s1, String s2)
    {
        EventDispatcher.dispatchEvent(this, "GotText", new Object[] {
            s, Integer.valueOf(i), s1, s2
        });
    }

    public String HtmlTextDecode(String s)
    {
        String s1;
        try
        {
            s1 = HtmlEntities.decodeHtmlText(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "HtmlTextDecode", 1106, new Object[] {
                s
            });
            return "";
        }
        return s1;
    }

    public Object JsonTextDecode(String s)
    {
        Object obj;
        try
        {
            obj = decodeJsonText(s);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            form.dispatchErrorOccurredEvent(this, "JsonTextDecode", 1105, new Object[] {
                s
            });
            return "";
        }
        return obj;
    }

    public void PostFile(final String path)
    {
        final CapturedProperties webProps = capturePropertyValues("PostFile");
        if (webProps == null)
        {
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Web this$0;
                final String val$path;
                final CapturedProperties val$webProps;

                public void run()
                {
                    try
                    {
                        performRequest(webProps, null, path, "POST");
                        return;
                    }
                    catch (com.google.appinventor.components.runtime.util.FileUtil.FileException fileexception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "PostFile", fileexception.getErrorMessageNumber(), new Object[0]);
                        return;
                    }
                    catch (Exception exception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "PostFile", 1104, new Object[] {
                            path, webProps.urlString
                        });
                    }
                }

            
            {
                this$0 = Web.this;
                webProps = capturedproperties;
                path = s;
                super();
            }
            });
            return;
        }
    }

    public void PostText(String s)
    {
        requestTextImpl(s, "UTF-8", "PostText", "POST");
    }

    public void PostTextWithEncoding(String s, String s1)
    {
        requestTextImpl(s, s1, "PostTextWithEncoding", "POST");
    }

    public void PutFile(final String path)
    {
        final CapturedProperties webProps = capturePropertyValues("PutFile");
        if (webProps == null)
        {
            return;
        } else
        {
            AsynchUtil.runAsynchronously(new Runnable() {

                final Web this$0;
                final String val$path;
                final CapturedProperties val$webProps;

                public void run()
                {
                    try
                    {
                        performRequest(webProps, null, path, "PUT");
                        return;
                    }
                    catch (com.google.appinventor.components.runtime.util.FileUtil.FileException fileexception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "PutFile", fileexception.getErrorMessageNumber(), new Object[0]);
                        return;
                    }
                    catch (Exception exception)
                    {
                        form.dispatchErrorOccurredEvent(Web.this, "PutFile", 1104, new Object[] {
                            path, webProps.urlString
                        });
                    }
                }

            
            {
                this$0 = Web.this;
                webProps = capturedproperties;
                path = s;
                super();
            }
            });
            return;
        }
    }

    public void PutText(String s)
    {
        requestTextImpl(s, "UTF-8", "PutText", "PUT");
    }

    public void PutTextWithEncoding(String s, String s1)
    {
        requestTextImpl(s, s1, "PutTextWithEncoding", "PUT");
    }

    public YailList RequestHeaders()
    {
        return requestHeaders;
    }

    public void RequestHeaders(YailList yaillist)
    {
        try
        {
            processRequestHeaders(yaillist);
            requestHeaders = yaillist;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (YailList yaillist)
        {
            form.dispatchErrorOccurredEvent(this, "RequestHeaders", ((InvalidRequestHeadersException) (yaillist)).errorNumber, new Object[] {
                Integer.valueOf(((InvalidRequestHeadersException) (yaillist)).index)
            });
        }
    }

    public String ResponseFileName()
    {
        return responseFileName;
    }

    public void ResponseFileName(String s)
    {
        responseFileName = s;
    }

    public void SaveResponse(boolean flag)
    {
        saveResponse = flag;
    }

    public boolean SaveResponse()
    {
        return saveResponse;
    }

    public String UriEncode(String s)
    {
        try
        {
            s = URLEncoder.encode(s, "UTF-8");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Web", "UTF-8 is unsupported?", s);
            return "";
        }
        return s;
    }

    public String Url()
    {
        return urlString;
    }

    public void Url(String s)
    {
        urlString = s;
    }

    public Object XMLTextDecode(String s)
    {
        try
        {
            s = ((String) (JsonTextDecode(XML.toJSONObject(s).toString())));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Exception in XMLTextDecode", s.getMessage());
            form.dispatchErrorOccurredEvent(this, "XMLTextDecode", 1105, new Object[] {
                s.getMessage()
            });
            return YailList.makeEmptyList();
        }
        return s;
    }

    String buildRequestData(YailList yaillist)
        throws BuildRequestDataException
    {
        StringBuilder stringbuilder = new StringBuilder();
        String s = "";
        for (int i = 0; i < yaillist.size();)
        {
            Object obj = yaillist.getObject(i);
            if (obj instanceof YailList)
            {
                Object obj1 = (YailList)obj;
                if (((YailList) (obj1)).size() == 2)
                {
                    String s1 = ((YailList) (obj1)).getObject(0).toString();
                    obj1 = ((YailList) (obj1)).getObject(1).toString();
                    stringbuilder.append(s).append(UriEncode(s1)).append('=').append(UriEncode(((String) (obj1))));
                    s = "&";
                    i++;
                } else
                {
                    throw new BuildRequestDataException(1113, i + 1);
                }
            } else
            {
                throw new BuildRequestDataException(1112, i + 1);
            }
        }

        return stringbuilder.toString();
    }

    static 
    {
        mimeTypeToExtension = Maps.newHashMap();
        mimeTypeToExtension.put("application/pdf", "pdf");
        mimeTypeToExtension.put("application/zip", "zip");
        mimeTypeToExtension.put("audio/mpeg", "mpeg");
        mimeTypeToExtension.put("audio/mp3", "mp3");
        mimeTypeToExtension.put("audio/mp4", "mp4");
        mimeTypeToExtension.put("image/gif", "gif");
        mimeTypeToExtension.put("image/jpeg", "jpg");
        mimeTypeToExtension.put("image/png", "png");
        mimeTypeToExtension.put("image/tiff", "tiff");
        mimeTypeToExtension.put("text/plain", "txt");
        mimeTypeToExtension.put("text/html", "html");
        mimeTypeToExtension.put("text/xml", "xml");
    }








}
