// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.text.method.PasswordTransformationMethod;
import android.widget.EditText;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TextBoxBase, ComponentContainer

public final class PasswordTextBox extends TextBoxBase
{

    public PasswordTextBox(ComponentContainer componentcontainer)
    {
        super(componentcontainer, new EditText(componentcontainer.$context()));
        view.setRawInputType(128);
        view.setSingleLine(true);
        view.setTransformationMethod(new PasswordTransformationMethod());
        view.setImeOptions(6);
    }
}
