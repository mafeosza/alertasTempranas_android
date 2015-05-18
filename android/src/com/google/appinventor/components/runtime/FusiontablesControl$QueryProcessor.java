// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import com.google.appinventor.components.runtime.util.IClientLoginHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;

// Referenced classes of package com.google.appinventor.components.runtime:
//            FusiontablesControl

private class <init> extends AsyncTask
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
            Object obj = FusiontablesControl.access$200(FusiontablesControl.this, as[0]);
            Log.d("FUSION", (new StringBuilder()).append("Fetching: ").append(as[0]).toString());
            as = FusiontablesControl.access$300(FusiontablesControl.this).execute(((org.apache.http.client.methods.HttpUriRequest) (obj)));
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
        progress = ProgressDialog.show(FusiontablesControl.access$000(FusiontablesControl.this), "Fusiontables", "processing query...", true);
    }

    private ()
    {
        this$0 = FusiontablesControl.this;
        super();
        progress = null;
    }

    progress(progress progress1)
    {
        this();
    }
}
