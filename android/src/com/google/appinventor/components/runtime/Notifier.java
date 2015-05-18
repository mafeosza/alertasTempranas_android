// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Handler;
import android.text.Html;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.appinventor.components.runtime.util.SdkLevel;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, ComponentContainer, EventDispatcher

public final class Notifier extends AndroidNonvisibleComponent
    implements Component
{

    private static final String LOG_TAG = "Notifier";
    private final Activity activity;
    private int backgroundColor;
    private final Handler handler = new Handler();
    private int notifierLength;
    private ProgressDialog progressDialog;
    private int textColor;

    public Notifier(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        notifierLength = 1;
        backgroundColor = 0xff444444;
        textColor = -1;
        activity = componentcontainer.$context();
        progressDialog = null;
    }

    public static void oneButtonAlert(Activity activity1, String s, String s1, String s2)
    {
        Log.i("Notifier", (new StringBuilder()).append("One button alert ").append(s).toString());
        activity1 = (new android.app.AlertDialog.Builder(activity1)).create();
        activity1.setTitle(s1);
        activity1.setCancelable(false);
        activity1.setMessage(stringToHTML(s));
        activity1.setButton(-3, s2, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
            }

        });
        activity1.show();
    }

    private static SpannableString stringToHTML(String s)
    {
        return new SpannableString(Html.fromHtml(s));
    }

    private void textInputDialog(final String input, String s, boolean flag)
    {
        AlertDialog alertdialog = (new android.app.AlertDialog.Builder(activity)).create();
        alertdialog.setTitle(s);
        alertdialog.setMessage(stringToHTML(input));
        input = new EditText(activity);
        alertdialog.setView(input);
        alertdialog.setCancelable(false);
        alertdialog.setButton(-1, "OK", new android.content.DialogInterface.OnClickListener() {

            final Notifier this$0;
            final EditText val$input;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                HideKeyboard(input);
                AfterTextInput(input.getText().toString());
            }

            
            {
                this$0 = Notifier.this;
                input = edittext;
                super();
            }
        });
        if (flag)
        {
            alertdialog.setButton(-2, "Cancel", new android.content.DialogInterface.OnClickListener() {

                final Notifier this$0;
                final EditText val$input;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    HideKeyboard(input);
                    AfterTextInput("Cancel");
                }

            
            {
                this$0 = Notifier.this;
                input = edittext;
                super();
            }
            });
        }
        alertdialog.show();
    }

    private void toastNow(String s)
    {
        Toast toast;
        TextView textview;
        int i;
        if (SdkLevel.getLevel() >= 14)
        {
            i = 22;
        } else
        {
            i = 15;
        }
        toast = Toast.makeText(activity, s, notifierLength);
        toast.setGravity(17, toast.getXOffset() / 2, toast.getYOffset() / 2);
        textview = new TextView(activity);
        textview.setBackgroundColor(backgroundColor);
        textview.setTextColor(textColor);
        textview.setTextSize(i);
        textview.setTypeface(Typeface.create(Typeface.SANS_SERIF, 0));
        textview.setPadding(10, 10, 10, 10);
        textview.setText((new StringBuilder()).append(s).append(" ").toString());
        toast.setView(textview);
        toast.show();
    }

    public static void twoButtonDialog(Activity activity1, String s, String s1, String s2, String s3, boolean flag, Runnable runnable, Runnable runnable1, 
            Runnable runnable2)
    {
        Log.i("Notifier", (new StringBuilder()).append("ShowChooseDialog: ").append(s).toString());
        activity1 = (new android.app.AlertDialog.Builder(activity1)).create();
        activity1.setTitle(s1);
        activity1.setCancelable(false);
        activity1.setMessage(stringToHTML(s));
        activity1.setButton(-1, s2, new android.content.DialogInterface.OnClickListener(runnable) {

            final Runnable val$positiveAction;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                positiveAction.run();
            }

            
            {
                positiveAction = runnable;
                super();
            }
        });
        activity1.setButton(-3, s3, new android.content.DialogInterface.OnClickListener(runnable1) {

            final Runnable val$negativeAction;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                negativeAction.run();
            }

            
            {
                negativeAction = runnable;
                super();
            }
        });
        if (flag)
        {
            activity1.setButton(-2, "Cancel", new android.content.DialogInterface.OnClickListener(runnable2) {

                final Runnable val$cancelAction;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    cancelAction.run();
                }

            
            {
                cancelAction = runnable;
                super();
            }
            });
        }
        activity1.show();
    }

    public void AfterChoosing(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterChoosing", new Object[] {
            s
        });
    }

    public void AfterTextInput(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterTextInput", new Object[] {
            s
        });
    }

    public void BackgroundColor(int i)
    {
        backgroundColor = i;
    }

    public void DismissProgressDialog()
    {
        if (progressDialog != null)
        {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }

    public void HideKeyboard(View view)
    {
        if (view != null)
        {
            ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public void LogError(String s)
    {
        Log.e("Notifier", s);
    }

    public void LogInfo(String s)
    {
        Log.i("Notifier", s);
    }

    public void LogWarning(String s)
    {
        Log.w("Notifier", s);
    }

    public int NotifierLength()
    {
        return notifierLength;
    }

    public void NotifierLength(int i)
    {
        notifierLength = i;
    }

    public void ShowAlert(final String notice)
    {
        handler.post(new Runnable() {

            final Notifier this$0;
            final String val$notice;

            public void run()
            {
                toastNow(notice);
            }

            
            {
                this$0 = Notifier.this;
                notice = s;
                super();
            }
        });
    }

    public void ShowChooseDialog(String s, String s1, final String button1Text, final String button2Text, boolean flag)
    {
        twoButtonDialog(activity, s, s1, button1Text, button2Text, flag, new Runnable() {

            final Notifier this$0;
            final String val$button1Text;

            public void run()
            {
                AfterChoosing(button1Text);
            }

            
            {
                this$0 = Notifier.this;
                button1Text = s;
                super();
            }
        }, new Runnable() {

            final Notifier this$0;
            final String val$button2Text;

            public void run()
            {
                AfterChoosing(button2Text);
            }

            
            {
                this$0 = Notifier.this;
                button2Text = s;
                super();
            }
        }, new Runnable() {

            final Notifier this$0;

            public void run()
            {
                AfterChoosing("Cancel");
            }

            
            {
                this$0 = Notifier.this;
                super();
            }
        });
    }

    public void ShowMessageDialog(String s, String s1, String s2)
    {
        oneButtonAlert(activity, s, s1, s2);
    }

    public void ShowProgressDialog(String s, String s1)
    {
        progressDialog(s, s1);
    }

    public void ShowTextDialog(String s, String s1, boolean flag)
    {
        textInputDialog(s, s1, flag);
    }

    public int TextColor()
    {
        return textColor;
    }

    public void TextColor(int i)
    {
        textColor = i;
    }

    public void progressDialog(String s, String s1)
    {
        if (progressDialog != null)
        {
            DismissProgressDialog();
        }
        progressDialog = ProgressDialog.show(activity, s1, s);
        progressDialog.setCancelable(false);
    }

}
