// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;

public final class RuntimeErrorAlert
{

    public RuntimeErrorAlert()
    {
    }

    public static void alert(Object obj, String s, String s1, String s2)
    {
        Log.i("RuntimeErrorAlert", "in alert");
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder((Context)obj)).create();
        alertdialog.setTitle(s1);
        alertdialog.setMessage(s);
        alertdialog.setButton(s2, new android.content.DialogInterface.OnClickListener(obj) {

            final Object val$context;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                ((Activity)context).finish();
            }

            
            {
                context = obj;
                super();
            }
        });
        if (s == null)
        {
            Log.e(com/google/appinventor/components/runtime/util/RuntimeErrorAlert.getName(), "No error message available");
        } else
        {
            Log.e(com/google/appinventor/components/runtime/util/RuntimeErrorAlert.getName(), s);
        }
        alertdialog.show();
    }
}
