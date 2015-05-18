// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.DialogInterface;
import android.widget.EditText;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Notifier

class val.input
    implements android.content.face.OnClickListener
{

    final Notifier this$0;
    final EditText val$input;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        HideKeyboard(val$input);
        AfterTextInput(val$input.getText().toString());
    }

    ()
    {
        this$0 = final_notifier;
        val$input = EditText.this;
        super();
    }
}
