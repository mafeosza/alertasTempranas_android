// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.google.appinventor.components.runtime.util.OAuth2Helper;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Texting

class this._cls0 extends AsyncTask
{

    final Texting this$0;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient String doInBackground(Void avoid[])
    {
        Log.i("Texting Component", "Authenticating");
        return (new OAuth2Helper()).getRefreshedAuthToken(Texting.access$200(), "grandcentral");
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((String)obj);
    }

    protected void onPostExecute(String s)
    {
        Log.i("Texting Component", (new StringBuilder()).append("authToken = ").append(s).toString());
        Texting.access$302(Texting.this, s);
        Toast.makeText(Texting.access$200(), "Finished authentication", 0).show();
        Texting.access$400(Texting.this);
    }

    I()
    {
        this$0 = Texting.this;
        super();
    }
}
