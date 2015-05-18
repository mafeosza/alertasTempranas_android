// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Texting

class this._cls0 extends AsyncTask
{

    final Texting this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((String[])aobj);
    }

    protected transient String doInBackground(String as[])
    {
        String s;
        String s1;
        String s2;
        s1 = as[0];
        s2 = as[1];
        s = "";
        Log.i("Texting Component", (new StringBuilder()).append("Async sending phoneNumber = ").append(s1).append(" message = ").append(s2).toString());
        as = s;
        s1 = (new StringBuilder()).append(URLEncoder.encode("phoneNumber", "UTF-8")).append("=").append(URLEncoder.encode(s1, "UTF-8")).append("&").append(URLEncoder.encode("text", "UTF-8")).append("=").append(URLEncoder.encode(s2, "UTF-8")).toString();
        as = s;
        if (Texting.access$500(Texting.this) != null)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        as = s;
        Texting.access$502(Texting.this, new init>(Texting.this, Texting.access$300(Texting.this)));
        as = s;
        if (!Texting.access$500(Texting.this).sInitialized())
        {
            break MISSING_BLOCK_LABEL_215;
        }
        as = s;
        s = ccess._mth600(Texting.access$500(Texting.this), s1);
        as = s;
        Log.i("Texting Component", (new StringBuilder()).append("Sent SMS, response = ").append(s).toString());
        as = s;
        break MISSING_BLOCK_LABEL_223;
        return "IO Error: unable to create GvHelper";
        Exception exception;
        exception;
        exception.printStackTrace();
        return as;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        int i;
        super.onPostExecute(s);
        boolean flag1 = false;
        i = 0;
        boolean flag = flag1;
        JSONObject jsonobject;
        int j;
        try
        {
            jsonobject = new JSONObject(s);
        }
        catch (JSONException jsonexception)
        {
            jsonexception.printStackTrace();
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        flag1 = jsonobject.getBoolean("ok");
        flag = flag1;
        j = jsonobject.getJSONObject("data").getInt("code");
        i = j;
        flag = flag1;
_L6:
        if (!flag) goto _L2; else goto _L1
_L1:
        Toast.makeText(Texting.access$200(), "Message sent", 0).show();
_L4:
        return;
_L2:
        if (i == 58)
        {
            Toast.makeText(Texting.access$200(), "Errcode 58: SMS limit reached", 0).show();
            return;
        }
        if (!s.contains("IO Error")) goto _L4; else goto _L3
_L3:
        Toast.makeText(Texting.access$200(), s, 0).show();
        return;
        if (true) goto _L6; else goto _L5
_L5:
    }

    ()
    {
        this$0 = Texting.this;
        super();
    }
}
