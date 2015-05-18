// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.content.DialogInterface;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            RuntimeErrorAlert

static final class val.context
    implements android.content.ickListener
{

    final Object val$context;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        ((Activity)val$context).finish();
    }

    (Object obj)
    {
        val$context = obj;
        super();
    }
}
