// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.widget.Toast;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ReplForm

class this._cls0
    implements Runnable
{

    final ReplForm this$0;

    public void run()
    {
        Toast.makeText(ReplForm.this, "Closing forms is not currently supported during development.", 1).show();
    }

    ()
    {
        this$0 = ReplForm.this;
        super();
    }
}
