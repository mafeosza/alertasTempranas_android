// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Filter;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ListPickerActivity

class this._cls0
    implements TextWatcher
{

    final ListPickerActivity this$0;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        adapter.getFilter().filter(charsequence);
    }

    Adapter()
    {
        this$0 = ListPickerActivity.this;
        super();
    }
}
