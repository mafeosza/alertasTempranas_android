// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.google.appinventor.components.runtime:
//            TextBoxBase, ComponentContainer

public final class TextBox extends TextBoxBase
{

    private boolean acceptsNumbersOnly;
    private boolean multiLine;

    public TextBox(ComponentContainer componentcontainer)
    {
        super(componentcontainer, new EditText(componentcontainer.$context()));
        NumbersOnly(false);
        MultiLine(false);
        view.setImeOptions(6);
    }

    public void HideKeyboard()
    {
        ((InputMethodManager)container.$context().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void MultiLine(boolean flag)
    {
        multiLine = flag;
        EditText edittext = view;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        edittext.setSingleLine(flag);
    }

    public boolean MultiLine()
    {
        return multiLine;
    }

    public void NumbersOnly(boolean flag)
    {
        if (flag)
        {
            view.setInputType(12290);
        } else
        {
            view.setInputType(0x20001);
        }
        acceptsNumbersOnly = flag;
    }

    public boolean NumbersOnly()
    {
        return acceptsNumbersOnly;
    }
}
