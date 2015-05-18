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

public class GoogleFormSender
    implements ReportSender
{

    private final Uri mFormUri;

    public GoogleFormSender()
    {
        mFormUri = null;
    }

    public GoogleFormSender(String s)
    {
        mFormUri = Uri.parse(String.format(ACRA.getConfig().googleFormUrlFormat(), new Object[] {
            s
        }));
    }

    private Map remap(Map map)
    {
        ReportField areportfield[];
        HashMap hashmap;
        int i;
        int j;
        int k;
        ReportField areportfield1[] = ACRA.getConfig().customReportContent();
        areportfield = areportfield1;
        if (areportfield1.length == 0)
        {
            areportfield = ACRA.DEFAULT_REPORT_FIELDS;
        }
        j = 0;
        hashmap = new HashMap();
        k = areportfield.length;
        i = 0;
_L2:
        ReportField reportfield;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        reportfield = areportfield[i];
        static class _cls1
        {

            static final int $SwitchMap$org$acra$ReportField[];

            static 
            {
                $SwitchMap$org$acra$ReportField = new int[ReportField.values().length];
                try
                {
                    $SwitchMap$org$acra$ReportField[ReportField.APP_VERSION_NAME.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$acra$ReportField[ReportField.ANDROID_VERSION.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.org.acra.ReportField[reportfield.ordinal()])
        {
        default:
            hashmap.put((new StringBuilder()).append("entry.").append(j).append(".single").toString(), map.get(reportfield));
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_199;
        }
_L3:
        j++;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap.put((new StringBuilder()).append("entry.").append(j).append(".single").toString(), (new StringBuilder()).append("'").append((String)map.get(reportfield)).toString());
          goto _L3
        hashmap.put((new StringBuilder()).append("entry.").append(j).append(".single").toString(), (new StringBuilder()).append("'").append((String)map.get(reportfield)).toString());
          goto _L3
        return hashmap;
    }

    public void send(CrashReportData crashreportdata)
        throws ReportSenderException
    {
        Object obj;
        Map map;
        if (mFormUri == null)
        {
            obj = Uri.parse(String.format(ACRA.getConfig().googleFormUrlFormat(), new Object[] {
                ACRA.getConfig().formKey()
            }));
        } else
        {
            obj = mFormUri;
        }
        map = remap(crashreportdata);
        map.put("pageNumber", "0");
        map.put("backupCache", "");
        map.put("submit", "Envoyer");
        try
        {
            obj = new URL(((Uri) (obj)).toString());
            Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Sending report ").append((String)crashreportdata.get(ReportField.REPORT_ID)).toString());
            Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Connect to ").append(obj).toString());
            crashreportdata = new HttpRequest();
            crashreportdata.setConnectionTimeOut(ACRA.getConfig().connectionTimeout());
            crashreportdata.setSocketTimeOut(ACRA.getConfig().socketTimeout());
            crashreportdata.setMaxNrRetries(ACRA.getConfig().maxNumberOfRequestRetries());
            crashreportdata.sendPost(((URL) (obj)), map);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (CrashReportData crashreportdata)
        {
            throw new ReportSenderException("Error while sending report to Google Form.", crashreportdata);
        }
    }
}
