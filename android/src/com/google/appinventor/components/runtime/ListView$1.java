// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.Filter;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ListView

class this._cls0
    implements TextWatcher
{

    final ListView this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        ListView.access$000(ListView.this).getFilter().filter(charsequence);
    }

    ()
    {
        this$0 = ListView.this;
        super();
    }
}
