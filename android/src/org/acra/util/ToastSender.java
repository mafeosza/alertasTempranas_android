// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import org.acra.ACRA;

public final class ToastSender
{

    public ToastSender()
    {
    }

    public static void sendToast(Context context, int i, int j)
    {
        try
        {
            Toast.makeText(context, i, j).show();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(ACRA.LOG_TAG, "Could not send crash Toast", context);
        }
    }
}
