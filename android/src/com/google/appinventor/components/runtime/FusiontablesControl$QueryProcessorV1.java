// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.GoogleKeyInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.fusiontables.Fusiontables;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.OAuth2Helper;

// Referenced classes of package com.google.appinventor.components.runtime:
//            FusiontablesControl, ComponentContainer

private class dialog extends AsyncTask
{

    private static final String STAG = "FUSION_SERVICE_ACCOUNT";
    private static final String TAG = "QueryProcessorV1";
    private final Activity activity;
    private final ProgressDialog dialog;
    final FusiontablesControl this$0;

    private String serviceAuthRequest(String s)
    {
        Object obj;
        Object obj1;
        FusiontablesControl.access$502(FusiontablesControl.this, "");
        FusiontablesControl.access$902(FusiontablesControl.this, FusiontablesControl.access$1000(FusiontablesControl.this));
        obj = AndroidHttp.newCompatibleTransport();
        obj1 = new GsonFactory();
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("keyPath ").append(FusiontablesControl.access$1100(FusiontablesControl.this)).toString());
        if (FusiontablesControl.access$1200(FusiontablesControl.this) == null)
        {
            FusiontablesControl.access$1202(FusiontablesControl.this, MediaUtil.copyMediaToTempFile(FusiontablesControl.access$1300(FusiontablesControl.this).$form(), FusiontablesControl.access$1100(FusiontablesControl.this)));
        }
        obj1 = (new com.google.api.services.fusiontables.orV1.this._cls0(((com.google.api.client.http.HttpTransport) (obj)), ((com.google.api.client.json.JsonFactory) (obj1)), (new com.google.api.client.googleapis.auth.oauth2.s._cls0()).(((com.google.api.client.http.HttpTransport) (obj))).ry(((com.google.api.client.json.JsonFactory) (obj1))).countId(FusiontablesControl.access$1500(FusiontablesControl.this)).countScopes(new String[] {
            FusiontablesControl.access$1400(FusiontablesControl.this)
        }).countPrivateKeyFromP12File(FusiontablesControl.access$1200(FusiontablesControl.this))._mth0())).stInitializer(new GoogleKeyInitializer(ApiKey())).stInitializer().query().stInitializer(s);
        ((com.google.api.services.fusiontables.stInitializer) (obj1)).stInitializer("alt", "csv");
        obj = null;
        obj1 = ((com.google.api.services.fusiontables.stInitializer) (obj1)).d();
        obj = obj1;
_L1:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.httpResponseToString(((com.google.api.client.http.HttpResponse) (obj))));
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Query = ").append(s).append("\nResultStr = ").append(FusiontablesControl.access$500(FusiontablesControl.this)).toString());
_L3:
        Log.i("FUSION_SERVICE_ACCOUNT", "executed sql query");
_L2:
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("returning queryResultStr = ").append(FusiontablesControl.access$500(FusiontablesControl.this)).toString());
        return FusiontablesControl.access$500(FusiontablesControl.this);
        Object obj2;
        obj2;
        Log.i("FUSION_SERVICE_ACCOUNT", "Got a JsonResponse exception on sql.executeUnparsed");
        FusiontablesControl.access$902(FusiontablesControl.this, parseJsonResponseException(((GoogleJsonResponseException) (obj2)).getMessage()));
        signalJsonResponseError(s, FusiontablesControl.access$900(FusiontablesControl.this));
          goto _L1
        s;
        Log.i("FUSION_SERVICE_ACCOUNT", "in Catch Throwable e");
        s.printStackTrace();
        FusiontablesControl.access$502(FusiontablesControl.this, s.getMessage());
          goto _L2
        obj2;
        Log.i("FUSION_SERVICE_ACCOUNT", "Got an unanticipated exception on sql.executeUnparsed");
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Exception class is ").append(obj2.getClass()).toString());
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Exception message is ").append(((Exception) (obj2)).getMessage()).toString());
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Exception is ").append(obj2).toString());
        Log.i("FUSION_SERVICE_ACCOUNT", "Point e");
        Log.i("FUSION_SERVICE_ACCOUNT", "end of printing exception");
        FusiontablesControl.access$902(FusiontablesControl.this, ((Exception) (obj2)).getMessage());
        signalJsonResponseError(s, FusiontablesControl.access$900(FusiontablesControl.this));
          goto _L1
        FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.access$900(FusiontablesControl.this));
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Error with null response:  ").append(FusiontablesControl.access$900(FusiontablesControl.this)).toString());
          goto _L3
    }

    private String userAuthRequest(String s)
    {
        FusiontablesControl.access$502(FusiontablesControl.this, "");
        Object obj = (new OAuth2Helper()).getRefreshedAuthToken(activity, FusiontablesControl.access$600(FusiontablesControl.this));
        if (obj != null)
        {
            if (s.toLowerCase().contains("create table"))
            {
                FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.access$800(FusiontablesControl.this, FusiontablesControl.access$700(FusiontablesControl.this, s), ((String) (obj))));
                return FusiontablesControl.access$500(FusiontablesControl.this);
            }
            obj = sendQuery(s, ((String) (obj)));
            if (obj != null)
            {
                FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.httpResponseToString(((com.google.api.client.http.HttpResponse) (obj))));
                Log.i("QueryProcessorV1", (new StringBuilder()).append("Query = ").append(s).append("\nResultStr = ").append(FusiontablesControl.access$500(FusiontablesControl.this)).toString());
            } else
            {
                FusiontablesControl.access$502(FusiontablesControl.this, FusiontablesControl.access$900(FusiontablesControl.this));
                Log.i("QueryProcessorV1", (new StringBuilder()).append("Error:  ").append(FusiontablesControl.access$900(FusiontablesControl.this)).toString());
            }
            return FusiontablesControl.access$500(FusiontablesControl.this);
        } else
        {
            return OAuth2Helper.getErrorMessage();
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        as = as[0];
        Log.i("QueryProcessorV1", (new StringBuilder()).append("Starting doInBackground ").append(as).toString());
        if (FusiontablesControl.access$400(FusiontablesControl.this))
        {
            return serviceAuthRequest(as);
        } else
        {
            return userAuthRequest(as);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        Log.i("FUSION", (new StringBuilder()).append("Query result ").append(s).toString());
        String s1 = s;
        if (s == null)
        {
            s1 = FusiontablesControl.access$900(FusiontablesControl.this);
        }
        dialog.dismiss();
        GotResult(s1);
    }

    protected void onPreExecute()
    {
        dialog.setMessage("Fusiontables...");
        dialog.show();
    }

    String parseJsonResponseException(String s)
    {
        Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("parseJsonResponseException: ").append(s).toString());
        return s;
    }

    (Activity activity1)
    {
        this$0 = FusiontablesControl.this;
        super();
        Log.i("QueryProcessorV1", "Creating AsyncFusiontablesQuery");
        activity = activity1;
        dialog = new ProgressDialog(activity1);
    }
}
