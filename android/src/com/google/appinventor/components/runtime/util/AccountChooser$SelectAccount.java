// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.accounts.Account;
import android.app.Activity;
import android.content.DialogInterface;
import android.text.Html;
import android.util.Log;
import java.util.concurrent.SynchronousQueue;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            AccountChooser

class accountNames extends Thread
    implements android.content.er, android.content.ner
{

    private String accountNames[];
    private SynchronousQueue queue;
    final AccountChooser this$0;

    public void onCancel(DialogInterface dialoginterface)
    {
        Log.i("AccountChooser", "Chose: canceled");
        onClick(dialoginterface, -1);
    }

    public void onClick(DialogInterface dialoginterface, int i)
    {
        if (i < 0)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        try
        {
            String s = accountNames[i];
            Log.i("AccountChooser", (new StringBuilder()).append("Chose: ").append(s).toString());
            queue.put(s);
        }
        catch (InterruptedException interruptedexception) { }
        dialoginterface.dismiss();
        return;
        queue.put("");
        break MISSING_BLOCK_LABEL_44;
    }

    public void run()
    {
        AccountChooser.access$200(AccountChooser.this).runOnUiThread(new Runnable() {

            final AccountChooser.SelectAccount this$1;

            public void run()
            {
                (new android.app.AlertDialog.Builder(AccountChooser.access$200(this$0))).setTitle(Html.fromHtml(AccountChooser.access$100(this$0))).setOnCancelListener(AccountChooser.SelectAccount.this).setSingleChoiceItems(accountNames, -1, AccountChooser.SelectAccount.this).show();
                Log.i("AccountChooser", "Dialog showing!");
            }

            
            {
                this$1 = AccountChooser.SelectAccount.this;
                super();
            }
        });
    }


    _cls1.this._cls1(Account aaccount[], SynchronousQueue synchronousqueue)
    {
        this$0 = AccountChooser.this;
        super();
        queue = synchronousqueue;
        accountNames = new String[aaccount.length];
        for (int i = 0; i < aaccount.length; i++)
        {
            accountNames[i] = aaccount[i].name;
        }

    }
}
