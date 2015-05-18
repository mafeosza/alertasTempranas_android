// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.sender;

import android.net.Uri;
import android.util.Log;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.ReportField;
import org.acra.collector.CrashReportData;
import org.acra.util.HttpRequest;

// Referenced classes of package org.acra.sender:
//            ReportSender, ReportSenderException

public class HttpPostSender
    implements ReportSender
{

    private final Uri mFormUri;
    private final Map mMapping;

    public HttpPostSender(String s, Map map)
    {
        mFormUri = Uri.parse(s);
        mMapping = map;
    }

    public HttpPostSender(Map map)
    {
        mFormUri = null;
        mMapping = map;
    }

    private static boolean isNull(String s)
    {
        return s == null || "ACRA-NULL-STRING".equals(s);
    }

    private Map remap(Map map)
    {
        ReportField areportfield1[] = ACRA.getConfig().customReportContent();
        ReportField areportfield[] = areportfield1;
        if (areportfield1.length == 0)
        {
            areportfield = ACRA.DEFAULT_REPORT_FIELDS;
        }
        HashMap hashmap = new HashMap(map.size());
        int j = areportfield.length;
        int i = 0;
        while (i < j) 
        {
            ReportField reportfield = areportfield[i];
            if (mMapping == null || mMapping.get(reportfield) == null)
            {
                hashmap.put(reportfield.toString(), map.get(reportfield));
            } else
            {
                hashmap.put(mMapping.get(reportfield), map.get(reportfield));
            }
            i++;
        }
        return hashmap;
    }

    public void send(CrashReportData crashreportdata)
        throws ReportSenderException
    {
        String s1 = null;
        Map map = remap(crashreportdata);
        if (mFormUri != null) goto _L2; else goto _L1
_L1:
        crashreportdata = new URL(ACRA.getConfig().formUri());
_L5:
        Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Connect to ").append(crashreportdata.toString()).toString());
        if (!isNull(ACRA.getConfig().formUriBasicAuthLogin())) goto _L4; else goto _L3
_L3:
        String s = null;
_L6:
        if (!isNull(ACRA.getConfig().formUriBasicAuthPassword()))
        {
            break MISSING_BLOCK_LABEL_188;
        }
_L7:
        HttpRequest httprequest = new HttpRequest();
        httprequest.setConnectionTimeOut(ACRA.getConfig().connectionTimeout());
        httprequest.setSocketTimeOut(ACRA.getConfig().socketTimeout());
        httprequest.setMaxNrRetries(ACRA.getConfig().maxNumberOfRequestRetries());
        httprequest.setLogin(s);
        httprequest.setPassword(s1);
        httprequest.sendPost(crashreportdata, map);
        return;
_L2:
        try
        {
            crashreportdata = new URL(mFormUri.toString());
        }
        // Misplaced declaration of an exception variable
        catch (CrashReportData crashreportdata)
        {
            throw new ReportSenderException("Error while sending report to Http Post Form.", crashreportdata);
        }
          goto _L5
_L4:
        s = ACRA.getConfig().formUriBasicAuthLogin();
          goto _L6
        s1 = ACRA.getConfig().formUriBasicAuthPassword();
          goto _L7
    }
}
