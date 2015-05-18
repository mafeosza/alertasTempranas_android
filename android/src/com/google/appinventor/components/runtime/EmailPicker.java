// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.widget.AutoCompleteTextView;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TextBoxBase, ComponentContainer, EmailAddressAdapter, EventDispatcher

public class EmailPicker extends TextBoxBase
{

    private final EmailAddressAdapter addressAdapter;

    public EmailPicker(ComponentContainer componentcontainer)
    {
        super(componentcontainer, new AutoCompleteTextView(componentcontainer.$context()));
        addressAdapter = new EmailAddressAdapter(componentcontainer.$context());
        ((AutoCompleteTextView)super.view).setAdapter(addressAdapter);
    }

    public void GotFocus()
    {
        EventDispatcher.dispatchEvent(this, "GotFocus", new Object[0]);
    }
}
