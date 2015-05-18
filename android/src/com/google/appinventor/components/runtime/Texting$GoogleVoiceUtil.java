// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Texting

class isInitialized
{

    private final int MAX_REDIRECTS = 5;
    String authToken;
    String general;
    private boolean isInitialized;
    int redirectCounter;
    String rnrSEE;
    final Texting this$0;

    private String sendGvSms(String s)
    {
        Log.i("Texting Component", "sendGvSms()");
        String s1 = "";
        OutputStreamWriter outputstreamwriter;
        Object obj;
        try
        {
            s = (new StringBuilder()).append(s).append("&").append(URLEncoder.encode("_rnr_se", "UTF-8")).append("=").append(URLEncoder.encode(rnrSEE, "UTF-8")).toString();
            Log.i("Texting Component", (new StringBuilder()).append("smsData = ").append(s).toString());
            obj = (new URL("https://www.google.com/voice/b/0/sms/send/")).openConnection();
            ((URLConnection) (obj)).setRequestProperty("Authorization", (new StringBuilder()).append("GoogleLogin auth=").append(authToken).toString());
            ((URLConnection) (obj)).setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13");
            ((URLConnection) (obj)).setDoOutput(true);
            ((URLConnection) (obj)).setConnectTimeout(30000);
            Log.i("Texting Component", (new StringBuilder()).append("sms request = ").append(obj).toString());
            outputstreamwriter = new OutputStreamWriter(((URLConnection) (obj)).getOutputStream());
            outputstreamwriter.write(s);
            outputstreamwriter.flush();
            obj = new BufferedReader(new InputStreamReader(((URLConnection) (obj)).getInputStream()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.i("Texting Component", (new StringBuilder()).append("IO Error on Send ").append(s.getMessage()).toString());
            s.printStackTrace();
            return "IO Error Message not sent";
        }
        s = s1;
        s1 = ((BufferedReader) (obj)).readLine();
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        s = (new StringBuilder()).append(s).append(s1).append("\n\r").toString();
        break MISSING_BLOCK_LABEL_220;
        Log.i("Texting Component", (new StringBuilder()).append("sendGvSms:  Sent SMS, response = ").append(s).toString());
        outputstreamwriter.close();
        ((BufferedReader) (obj)).close();
        if (s.equals(""))
        {
            throw new IOException("No Response Data Received.");
        }
        return s;
    }

    private void setRNRSEE()
        throws IOException
    {
        Log.i("Texting Component", "setRNRSEE()");
        if (general != null)
        {
            if (general.contains("'_rnr_se': '"))
            {
                rnrSEE = general.split("'_rnr_se': '", 2)[1].split("',", 2)[0];
                Log.i("Texting Component", "Successfully Received rnr_se.");
                return;
            } else
            {
                Log.i("Texting Component", (new StringBuilder()).append("Answer did not contain rnr_se! ").append(general).toString());
                throw new IOException((new StringBuilder()).append("Answer did not contain rnr_se! ").append(general).toString());
            }
        } else
        {
            Log.i("Texting Component", "setRNRSEE(): Answer was null!");
            throw new IOException("setRNRSEE(): Answer was null!");
        }
    }

    String get(String s)
        throws IOException
    {
        Object obj;
        HttpURLConnection httpurlconnection;
        int j;
        httpurlconnection = (HttpURLConnection)(new URL(s)).openConnection();
        j = 0;
        int i = j;
        try
        {
            httpurlconnection.setRequestProperty("Authorization", (new StringBuilder()).append("GoogleLogin auth=").append(authToken).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(i).append(") : IO Error.").toString());
        }
        i = j;
        httpurlconnection.setRequestProperty("User-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US) AppleWebKit/525.13 (KHTML, like Gecko) Chrome/0.A.B.C Safari/525.13");
        i = j;
        httpurlconnection.setInstanceFollowRedirects(false);
        i = j;
        httpurlconnection.connect();
        i = j;
        j = httpurlconnection.getResponseCode();
        i = j;
        Log.i("Texting Component", (new StringBuilder()).append(s).append(" - ").append(httpurlconnection.getResponseMessage()).toString());
        if (j == 200)
        {
            obj = httpurlconnection.getInputStream();
        } else
        {
            if (j == 301 || j == 302 || j == 303 || j == 307)
            {
                redirectCounter = redirectCounter + 1;
                if (redirectCounter > 5)
                {
                    redirectCounter = 0;
                    throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") : Too many redirects. exiting.").toString());
                }
                obj = httpurlconnection.getHeaderField("Location");
                if (obj != null && !((String) (obj)).equals(""))
                {
                    System.out.println((new StringBuilder()).append(s).append(" - ").append(j).append(" - new URL: ").append(((String) (obj))).toString());
                    return get(((String) (obj)));
                } else
                {
                    throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") : Received moved answer but no Location. exiting.").toString());
                }
            }
            obj = httpurlconnection.getErrorStream();
        }
        redirectCounter = 0;
        if (obj == null)
        {
            throw new IOException((new StringBuilder()).append(s).append(" : ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") : InputStream was null : exiting.").toString());
        }
        StringBuffer stringbuffer;
        obj = new BufferedReader(new InputStreamReader(((java.io.InputStream) (obj))));
        stringbuffer = new StringBuffer();
_L1:
        String s1 = ((BufferedReader) (obj)).readLine();
label0:
        {
            if (s1 == null)
            {
                break label0;
            }
            try
            {
                stringbuffer.append((new StringBuilder()).append(s1).append("\n\r").toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new IOException((new StringBuilder()).append(s).append(" - ").append(httpurlconnection.getResponseMessage()).append("(").append(j).append(") - ").append(((Exception) (obj)).getLocalizedMessage()).toString());
            }
        }
          goto _L1
        ((BufferedReader) (obj)).close();
        obj = stringbuffer.toString();
        return ((String) (obj));
    }

    public String getGeneral()
        throws IOException
    {
        Log.i("Texting Component", "getGeneral()");
        return get("https://www.google.com/voice/b/0");
    }

    public boolean isInitialized()
    {
        return isInitialized;
    }


    public (String s)
    {
        this$0 = Texting.this;
        super();
        Log.i("Texting Component", "Creating GV Util");
        authToken = s;
        try
        {
            general = getGeneral();
            Log.i("Texting Component", (new StringBuilder()).append("general = ").append(general).toString());
            setRNRSEE();
            isInitialized = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Texting texting)
        {
            printStackTrace();
        }
    }
}
