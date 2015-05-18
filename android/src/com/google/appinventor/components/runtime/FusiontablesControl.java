// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import com.google.api.client.extensions.android2.AndroidHttp;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.services.GoogleKeyInitializer;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.fusiontables.Fusiontables;
import com.google.appinventor.components.runtime.util.ClientLoginHelper;
import com.google.appinventor.components.runtime.util.IClientLoginHelper;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.OAuth2Helper;
import com.google.appinventor.components.runtime.util.SdkLevel;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, Form, 
//            EventDispatcher

public class FusiontablesControl extends AndroidNonvisibleComponent
    implements Component
{
    private class QueryProcessor extends AsyncTask
    {

        private ProgressDialog progress;
        final FusiontablesControl this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient String doInBackground(String as[])
        {
            try
            {
                Object obj = genFusiontablesQuery(as[0]);
                Log.d("FUSION", (new StringBuilder()).append("Fetching: ").append(as[0]).toString());
                as = requestHelper.execute(((HttpUriRequest) (obj)));
                obj = new ByteArrayOutputStream();
                as.getEntity().writeTo(((java.io.OutputStream) (obj)));
                Log.d("FUSION", (new StringBuilder()).append("Response: ").append(as.getStatusLine().toString()).toString());
                as = ((ByteArrayOutputStream) (obj)).toString();
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                as.printStackTrace();
                return as.getMessage();
            }
            return as;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            progress.dismiss();
            GotResult(s);
        }

        protected void onPreExecute()
        {
            progress = ProgressDialog.show(activity, "Fusiontables", "processing query...", true);
        }

        private QueryProcessor()
        {
            this$0 = FusiontablesControl.this;
            super();
            progress = null;
        }

    }

    private class QueryProcessorV1 extends AsyncTask
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
            queryResultStr = "";
            errorMessage = standardErrorMessage;
            obj = AndroidHttp.newCompatibleTransport();
            obj1 = new GsonFactory();
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("keyPath ").append(keyPath).toString());
            if (cachedServiceCredentials == null)
            {
                cachedServiceCredentials = MediaUtil.copyMediaToTempFile(container.$form(), keyPath);
            }
            obj1 = (new com.google.api.services.fusiontables.Fusiontables.Builder(((com.google.api.client.http.HttpTransport) (obj)), ((com.google.api.client.json.JsonFactory) (obj1)), (new com.google.api.client.googleapis.auth.oauth2.GoogleCredential.Builder()).setTransport(((com.google.api.client.http.HttpTransport) (obj))).setJsonFactory(((com.google.api.client.json.JsonFactory) (obj1))).setServiceAccountId(serviceAccountEmail).setServiceAccountScopes(new String[] {
                scope
            }).setServiceAccountPrivateKeyFromP12File(cachedServiceCredentials).build())).setJsonHttpRequestInitializer(new GoogleKeyInitializer(ApiKey())).build().query().sql(s);
            ((com.google.api.services.fusiontables.Fusiontables.Query.Sql) (obj1)).put("alt", "csv");
            obj = null;
            obj1 = ((com.google.api.services.fusiontables.Fusiontables.Query.Sql) (obj1)).executeUnparsed();
            obj = obj1;
_L1:
            if (obj == null)
            {
                break MISSING_BLOCK_LABEL_528;
            }
            queryResultStr = FusiontablesControl.httpResponseToString(((com.google.api.client.http.HttpResponse) (obj)));
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Query = ").append(s).append("\nResultStr = ").append(queryResultStr).toString());
_L3:
            Log.i("FUSION_SERVICE_ACCOUNT", "executed sql query");
_L2:
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("returning queryResultStr = ").append(queryResultStr).toString());
            return queryResultStr;
            Object obj2;
            obj2;
            Log.i("FUSION_SERVICE_ACCOUNT", "Got a JsonResponse exception on sql.executeUnparsed");
            errorMessage = parseJsonResponseException(((GoogleJsonResponseException) (obj2)).getMessage());
            signalJsonResponseError(s, errorMessage);
              goto _L1
            s;
            Log.i("FUSION_SERVICE_ACCOUNT", "in Catch Throwable e");
            s.printStackTrace();
            queryResultStr = s.getMessage();
              goto _L2
            obj2;
            Log.i("FUSION_SERVICE_ACCOUNT", "Got an unanticipated exception on sql.executeUnparsed");
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Exception class is ").append(obj2.getClass()).toString());
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Exception message is ").append(((Exception) (obj2)).getMessage()).toString());
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Exception is ").append(obj2).toString());
            Log.i("FUSION_SERVICE_ACCOUNT", "Point e");
            Log.i("FUSION_SERVICE_ACCOUNT", "end of printing exception");
            errorMessage = ((Exception) (obj2)).getMessage();
            signalJsonResponseError(s, errorMessage);
              goto _L1
            queryResultStr = errorMessage;
            Log.i("FUSION_SERVICE_ACCOUNT", (new StringBuilder()).append("Error with null response:  ").append(errorMessage).toString());
              goto _L3
        }

        private String userAuthRequest(String s)
        {
            queryResultStr = "";
            Object obj = (new OAuth2Helper()).getRefreshedAuthToken(activity, authTokenType);
            if (obj != null)
            {
                if (s.toLowerCase().contains("create table"))
                {
                    queryResultStr = doPostRequest(parseSqlCreateQueryToJson(s), ((String) (obj)));
                    return queryResultStr;
                }
                obj = sendQuery(s, ((String) (obj)));
                if (obj != null)
                {
                    queryResultStr = FusiontablesControl.httpResponseToString(((com.google.api.client.http.HttpResponse) (obj)));
                    Log.i("QueryProcessorV1", (new StringBuilder()).append("Query = ").append(s).append("\nResultStr = ").append(queryResultStr).toString());
                } else
                {
                    queryResultStr = errorMessage;
                    Log.i("QueryProcessorV1", (new StringBuilder()).append("Error:  ").append(errorMessage).toString());
                }
                return queryResultStr;
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
            if (isServiceAuth)
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
                s1 = errorMessage;
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

        QueryProcessorV1(Activity activity1)
        {
            this$0 = FusiontablesControl.this;
            super();
            Log.i("QueryProcessorV1", "Creating AsyncFusiontablesQuery");
            activity = activity1;
            dialog = new ProgressDialog(activity1);
        }
    }


    public static final String APP_NAME = "App Inventor";
    public static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";
    public static final String AUTH_TOKEN_TYPE_FUSIONTABLES = "oauth2:https://www.googleapis.com/auth/fusiontables";
    private static final String DEFAULT_QUERY = "show tables";
    private static final String DIALOG_TEXT = "Choose an account to access FusionTables";
    public static final String FUSIONTABLES_POST = "https://www.googleapis.com/fusiontables/v1/tables";
    public static final String FUSIONTABLES_URL = "https://www.googleapis.com/fusiontables/v1/query";
    private static final String FUSIONTABLE_SERVICE = "fusiontables";
    private static final String FUSION_QUERY_URL = "http://www.google.com/fusiontables/api/query";
    private static final String LOG_TAG = "FUSION";
    private static final int SERVER_TIMEOUT_MS = 30000;
    private final Activity activity;
    private String apiKey;
    private String authTokenType;
    private File cachedServiceCredentials;
    private final ComponentContainer container;
    private String errorMessage;
    private boolean isServiceAuth;
    private String keyPath;
    private String query;
    private String queryResultStr;
    private final IClientLoginHelper requestHelper = createClientLoginHelper("Choose an account to access FusionTables", "fusiontables");
    private String scope;
    private String serviceAccountEmail;
    private String standardErrorMessage;

    public FusiontablesControl(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        cachedServiceCredentials = null;
        authTokenType = "oauth2:https://www.googleapis.com/auth/fusiontables";
        standardErrorMessage = "Error on Fusion Tables query";
        keyPath = "";
        isServiceAuth = false;
        serviceAccountEmail = "";
        scope = "https://www.googleapis.com/auth/fusiontables";
        container = componentcontainer;
        activity = componentcontainer.$context();
        query = "show tables";
        if (SdkLevel.getLevel() < 5)
        {
            showNoticeAndDie("Sorry. The Fusiontables component is not compatible with this phone.", "This application must exit.", "Rats!");
        }
    }

    private IClientLoginHelper createClientLoginHelper(String s, String s1)
    {
        if (SdkLevel.getLevel() >= 5)
        {
            DefaultHttpClient defaulthttpclient = new DefaultHttpClient();
            HttpConnectionParams.setSoTimeout(defaulthttpclient.getParams(), 30000);
            HttpConnectionParams.setConnectionTimeout(defaulthttpclient.getParams(), 30000);
            return new ClientLoginHelper(activity, s1, s, defaulthttpclient);
        } else
        {
            return null;
        }
    }

    private String doPostRequest(String s, String s1)
    {
        Object obj;
        Object obj1 = s.trim().substring("create table".length());
        Log.i("FUSION", (new StringBuilder()).append("Http Post content = ").append(((String) (obj1))).toString());
        obj = new HttpPost((new StringBuilder()).append("https://www.googleapis.com/fusiontables/v1/tables?key=").append(ApiKey()).toString());
        int i;
        try
        {
            obj1 = new StringEntity(((String) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return (new StringBuilder()).append("Error: ").append(s.getMessage()).toString();
        }
        ((StringEntity) (obj1)).setContentType("application/json");
        ((HttpPost) (obj)).addHeader("Authorization", (new StringBuilder()).append("Bearer ").append(s1).toString());
        ((HttpPost) (obj)).setEntity(((HttpEntity) (obj1)));
        s1 = new DefaultHttpClient();
        try
        {
            s1 = s1.execute(((HttpUriRequest) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return (new StringBuilder()).append("Error: ").append(s.getMessage()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return (new StringBuilder()).append("Error: ").append(s.getMessage()).toString();
        }
        i = s1.getStatusLine().getStatusCode();
        if (s1 == null || i != 200)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        obj = httpApacheResponseToString(s1);
        obj1 = new JSONObject(((String) (obj)));
        if (!((JSONObject) (obj1)).has("tableId")) goto _L2; else goto _L1
_L1:
        queryResultStr = (new StringBuilder()).append("tableId,").append(((JSONObject) (obj1)).get("tableId")).toString();
_L3:
        Log.i("FUSION", (new StringBuilder()).append("Response code = ").append(s1.getStatusLine()).toString());
        Log.i("FUSION", (new StringBuilder()).append("Query = ").append(s).append("\nResultStr = ").append(queryResultStr).toString());
_L4:
        return queryResultStr;
_L2:
        try
        {
            queryResultStr = ((String) (obj));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return (new StringBuilder()).append("Error: ").append(s.getMessage()).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return (new StringBuilder()).append("Error: ").append(s.getMessage()).toString();
        }
          goto _L3
        Log.i("FUSION", (new StringBuilder()).append("Error: ").append(s1.getStatusLine().toString()).toString());
        queryResultStr = s1.getStatusLine().toString();
          goto _L4
    }

    private HttpUriRequest genFusiontablesQuery(String s)
        throws IOException
    {
        HttpPost httppost = new HttpPost("http://www.google.com/fusiontables/api/query");
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(new BasicNameValuePair("sql", s));
        s = new UrlEncodedFormEntity(arraylist, "UTF-8");
        s.setContentType("application/x-www-form-urlencoded");
        httppost.setEntity(s);
        return httppost;
    }

    public static String httpApacheResponseToString(HttpResponse httpresponse)
    {
label0:
        {
            String s = "";
            if (httpresponse != null)
            {
                if (httpresponse.getStatusLine().getStatusCode() == 200)
                {
                    break label0;
                }
                s = (new StringBuilder()).append(httpresponse.getStatusLine().getStatusCode()).append(" ").append(httpresponse.getStatusLine().getReasonPhrase()).toString();
            }
            return s;
        }
        try
        {
            httpresponse = parseResponse(httpresponse.getEntity().getContent());
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            httpresponse.printStackTrace();
            return "";
        }
        return httpresponse;
    }

    public static String httpResponseToString(com.google.api.client.http.HttpResponse httpresponse)
    {
label0:
        {
            String s = "";
            if (httpresponse != null)
            {
                if (httpresponse.getStatusCode() == 200)
                {
                    break label0;
                }
                s = (new StringBuilder()).append(httpresponse.getStatusCode()).append(" ").append(httpresponse.getStatusMessage()).toString();
            }
            return s;
        }
        try
        {
            httpresponse = parseResponse(httpresponse.getContent());
        }
        // Misplaced declaration of an exception variable
        catch (com.google.api.client.http.HttpResponse httpresponse)
        {
            httpresponse.printStackTrace();
            return "";
        }
        return httpresponse;
    }

    public static String parseResponse(InputStream inputstream)
    {
        Object obj;
        String s;
        BufferedReader bufferedreader;
        s = "";
        obj = s;
        String s1;
        try
        {
            bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            inputstream.printStackTrace();
            return ((String) (obj));
        }
        obj = s;
        inputstream = new StringBuilder();
_L2:
        obj = s;
        s1 = bufferedreader.readLine();
        if (s1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = s;
        inputstream.append((new StringBuilder()).append(s1).append("\n").toString());
        if (true) goto _L2; else goto _L1
_L1:
        obj = s;
        inputstream = inputstream.toString();
        obj = inputstream;
        Log.i("FUSION", (new StringBuilder()).append("resultStr = ").append(inputstream).toString());
        obj = inputstream;
        bufferedreader.close();
        return inputstream;
    }

    private String parseSqlCreateQueryToJson(String s)
    {
        Log.i("FUSION", (new StringBuilder()).append("parsetoJSonSqlCreate :").append(s).toString());
        StringBuilder stringbuilder = new StringBuilder();
        String s1 = s.trim();
        s = s1.substring("create table".length(), s1.indexOf('(')).trim();
        String as[] = s1.substring(s1.indexOf('(') + 1, s1.indexOf(')')).split(",");
        stringbuilder.append("{'columns':[");
        for (int i = 0; i < as.length; i++)
        {
            String as1[] = as[i].split(":");
            stringbuilder.append((new StringBuilder()).append("{'name': '").append(as1[0].trim()).append("', 'type': '").append(as1[1].trim()).append("'}").toString());
            if (i < as.length - 1)
            {
                stringbuilder.append(",");
            }
        }

        stringbuilder.append("],");
        stringbuilder.append("'isExportable':'true',");
        stringbuilder.append((new StringBuilder()).append("'name': '").append(s).append("'").toString());
        stringbuilder.append("}");
        stringbuilder.insert(0, "CREATE TABLE ");
        Log.i("FUSION", (new StringBuilder()).append("result = ").append(stringbuilder.toString()).toString());
        return stringbuilder.toString();
    }

    private void showNoticeAndDie(String s, String s1, String s2)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(activity)).create();
        alertdialog.setTitle(s1);
        alertdialog.setCancelable(false);
        alertdialog.setMessage(s);
        alertdialog.setButton(s2, new android.content.DialogInterface.OnClickListener() {

            final FusiontablesControl this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                activity.finish();
            }

            
            {
                this$0 = FusiontablesControl.this;
                super();
            }
        });
        alertdialog.show();
    }

    public String ApiKey()
    {
        return apiKey;
    }

    public void ApiKey(String s)
    {
        apiKey = s;
    }

    public void DoQuery()
    {
        if (requestHelper != null)
        {
            (new QueryProcessor()).execute(new String[] {
                query
            });
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(this, "DoQuery", 3, new Object[0]);
            return;
        }
    }

    public void ForgetLogin()
    {
        OAuth2Helper.resetAccountCredential(activity);
    }

    public void GetRows(String s, String s1)
    {
        query = (new StringBuilder()).append("SELECT ").append(s1).append(" FROM ").append(s).toString();
        (new QueryProcessorV1(activity)).execute(new String[] {
            query
        });
    }

    public void GetRowsWithConditions(String s, String s1, String s2)
    {
        query = (new StringBuilder()).append("SELECT ").append(s1).append(" FROM ").append(s).append(" WHERE ").append(s2).toString();
        (new QueryProcessorV1(activity)).execute(new String[] {
            query
        });
    }

    public void GotResult(String s)
    {
        EventDispatcher.dispatchEvent(this, "GotResult", new Object[] {
            s
        });
    }

    public void InsertRow(String s, String s1, String s2)
    {
        query = (new StringBuilder()).append("INSERT INTO ").append(s).append(" (").append(s1).append(")").append(" VALUES ").append("(").append(s2).append(")").toString();
        (new QueryProcessorV1(activity)).execute(new String[] {
            query
        });
    }

    public String KeyFile()
    {
        return keyPath;
    }

    public void KeyFile(String s)
    {
        if (s.equals(keyPath))
        {
            return;
        }
        if (cachedServiceCredentials != null)
        {
            cachedServiceCredentials.delete();
            cachedServiceCredentials = null;
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        keyPath = s1;
    }

    public String Query()
    {
        return query;
    }

    public void Query(String s)
    {
        query = s;
    }

    public void SendQuery()
    {
        (new QueryProcessorV1(activity)).execute(new String[] {
            query
        });
    }

    public String ServiceAccountEmail()
    {
        return serviceAccountEmail;
    }

    public void ServiceAccountEmail(String s)
    {
        serviceAccountEmail = s;
    }

    public void UseServiceAuthentication(boolean flag)
    {
        isServiceAuth = flag;
    }

    public boolean UseServiceAuthentication()
    {
        return isServiceAuth;
    }

    public void handleOAuthError(String s)
    {
        Log.i("FUSION", (new StringBuilder()).append("handleOAuthError: ").append(s).toString());
        errorMessage = s;
    }

    public com.google.api.client.http.HttpResponse sendQuery(String s, String s1)
    {
        errorMessage = standardErrorMessage;
        Log.i("FUSION", (new StringBuilder()).append("executing ").append(s).toString());
        Fusiontables fusiontables = (new com.google.api.services.fusiontables.Fusiontables.Builder(AndroidHttp.newCompatibleTransport(), new GsonFactory(), new GoogleCredential())).setApplicationName("App Inventor Fusiontables/v1.0").setJsonHttpRequestInitializer(new GoogleKeyInitializer(ApiKey())).build();
        try
        {
            s = fusiontables.query().sql(s);
            s.put("alt", "csv");
            s.setOauthToken(s1);
            s = s.executeUnparsed();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            errorMessage = s.getMessage();
            Log.e("FUSION", "JsonResponseException");
            Log.e("FUSION", (new StringBuilder()).append("e.getMessage() is ").append(s.getMessage()).toString());
            Log.e("FUSION", (new StringBuilder()).append("response is ").append(null).toString());
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            errorMessage = s.getMessage();
            Log.e("FUSION", "IOException");
            Log.e("FUSION", (new StringBuilder()).append("e.getMessage() is ").append(s.getMessage()).toString());
            Log.e("FUSION", (new StringBuilder()).append("response is ").append(null).toString());
            return null;
        }
        return s;
    }

    void signalJsonResponseError(String s, String s1)
    {
        form.dispatchErrorOccurredEventDialog(this, "SendQuery", 2601, new Object[] {
            s, s1
        });
    }






/*
    static File access$1202(FusiontablesControl fusiontablescontrol, File file)
    {
        fusiontablescontrol.cachedServiceCredentials = file;
        return file;
    }

*/









/*
    static String access$502(FusiontablesControl fusiontablescontrol, String s)
    {
        fusiontablescontrol.queryResultStr = s;
        return s;
    }

*/






/*
    static String access$902(FusiontablesControl fusiontablescontrol, String s)
    {
        fusiontablescontrol.errorMessage = s;
        return s;
    }

*/
}
