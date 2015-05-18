// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.IOException;
import org.acra.collector.CrashReportData;
import org.acra.util.ToastSender;

// Referenced classes of package org.acra:
//            ACRA, ACRAConfiguration, ErrorReporter, CrashReportPersister, 
//            ReportField

public final class CrashReportDialog extends Activity
{

    private static final String STATE_COMMENT = "comment";
    private static final String STATE_EMAIL = "email";
    String mReportFileName;
    private SharedPreferences prefs;
    private EditText userComment;
    private EditText userEmail;

    public CrashReportDialog()
    {
    }

    protected void cancelNotification()
    {
        ((NotificationManager)getSystemService("notification")).cancel(666);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mReportFileName = getIntent().getStringExtra("REPORT_FILE_NAME");
        Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Opening CrashReportDialog for ").append(mReportFileName).toString());
        if (mReportFileName == null)
        {
            finish();
        }
        requestWindowFeature(3);
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        linearlayout.setPadding(10, 10, 10, 10);
        linearlayout.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -2));
        linearlayout.setFocusable(true);
        linearlayout.setFocusableInTouchMode(true);
        final ScrollView scroll = new ScrollView(this);
        linearlayout.addView(scroll, new android.widget.LinearLayout.LayoutParams(-1, -1, 1.0F));
        LinearLayout linearlayout1 = new LinearLayout(this);
        linearlayout1.setOrientation(1);
        scroll.addView(linearlayout1);
        TextView textview = new TextView(this);
        textview.setText(getText(ACRA.getConfig().resDialogText()));
        linearlayout1.addView(textview);
        int i = ACRA.getConfig().resDialogCommentPrompt();
        if (i != 0)
        {
            TextView textview1 = new TextView(this);
            textview1.setText(getText(i));
            textview1.setPadding(textview1.getPaddingLeft(), 10, textview1.getPaddingRight(), textview1.getPaddingBottom());
            linearlayout1.addView(textview1, new android.widget.LinearLayout.LayoutParams(-1, -2));
            userComment = new EditText(this);
            userComment.setLines(2);
            if (bundle != null)
            {
                String s = bundle.getString("comment");
                if (s != null)
                {
                    userComment.setText(s);
                }
            }
            linearlayout1.addView(userComment);
        }
        i = ACRA.getConfig().resDialogEmailPrompt();
        if (i != 0)
        {
            Object obj = new TextView(this);
            ((TextView) (obj)).setText(getText(i));
            ((TextView) (obj)).setPadding(((TextView) (obj)).getPaddingLeft(), 10, ((TextView) (obj)).getPaddingRight(), ((TextView) (obj)).getPaddingBottom());
            linearlayout1.addView(((View) (obj)));
            userEmail = new EditText(this);
            userEmail.setSingleLine();
            userEmail.setInputType(33);
            prefs = getSharedPreferences(ACRA.getConfig().sharedPreferencesName(), ACRA.getConfig().sharedPreferencesMode());
            obj = null;
            if (bundle != null)
            {
                obj = bundle.getString("email");
            }
            if (obj != null)
            {
                userEmail.setText(((CharSequence) (obj)));
            } else
            {
                userEmail.setText(prefs.getString("acra.user.email", ""));
            }
            linearlayout1.addView(userEmail);
        }
        bundle = new LinearLayout(this);
        bundle.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -2));
        bundle.setPadding(bundle.getPaddingLeft(), 10, bundle.getPaddingRight(), bundle.getPaddingBottom());
        obj = new Button(this);
        ((Button) (obj)).setText(0x1040013);
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final CrashReportDialog this$0;

            public void onClick(View view)
            {
                String s1;
                CrashReportPersister crashreportpersister;
                int j;
                if (userComment != null)
                {
                    view = userComment.getText().toString();
                } else
                {
                    view = "";
                }
                if (prefs != null && userEmail != null)
                {
                    s1 = userEmail.getText().toString();
                    android.content.SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("acra.user.email", s1);
                    editor.commit();
                } else
                {
                    s1 = "";
                }
                crashreportpersister = new CrashReportPersister(getApplicationContext());
                try
                {
                    Log.d(ACRA.LOG_TAG, (new StringBuilder()).append("Add user comment to ").append(mReportFileName).toString());
                    CrashReportData crashreportdata = crashreportpersister.load(mReportFileName);
                    crashreportdata.put(ReportField.USER_COMMENT, view);
                    crashreportdata.put(ReportField.USER_EMAIL, s1);
                    crashreportpersister.store(crashreportdata, mReportFileName);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    Log.w(ACRA.LOG_TAG, "User comment not added: ", view);
                }
                Log.v(ACRA.LOG_TAG, "About to start SenderWorker from CrashReportDialog");
                ACRA.getErrorReporter().startSendingReports(false, true);
                j = ACRA.getConfig().resDialogOkToast();
                if (j != 0)
                {
                    ToastSender.sendToast(getApplicationContext(), j, 1);
                }
                finish();
            }

            
            {
                this$0 = CrashReportDialog.this;
                super();
            }
        });
        bundle.addView(((View) (obj)), new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0F));
        obj = new Button(this);
        ((Button) (obj)).setText(0x1040009);
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final CrashReportDialog this$0;

            public void onClick(View view)
            {
                ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
                finish();
            }

            
            {
                this$0 = CrashReportDialog.this;
                super();
            }
        });
        bundle.addView(((View) (obj)), new android.widget.LinearLayout.LayoutParams(-1, -2, 1.0F));
        linearlayout.addView(bundle, new android.widget.LinearLayout.LayoutParams(-1, -2));
        setContentView(linearlayout);
        i = ACRA.getConfig().resDialogTitle();
        if (i != 0)
        {
            setTitle(i);
        }
        getWindow().setFeatureDrawableResource(3, ACRA.getConfig().resDialogIcon());
        cancelNotification();
        scroll.post(new Runnable() {

            final CrashReportDialog this$0;
            final ScrollView val$scroll;

            public void run()
            {
                scroll.scrollTo(0, 0);
            }

            
            {
                this$0 = CrashReportDialog.this;
                scroll = scrollview;
                super();
            }
        });
    }

    public boolean onKeyUp(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            ACRA.getErrorReporter().deletePendingNonApprovedReports(false);
        }
        return super.onKeyUp(i, keyevent);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (userComment != null && userComment.getText() != null)
        {
            bundle.putString("comment", userComment.getText().toString());
        }
        if (userEmail != null && userEmail.getText() != null)
        {
            bundle.putString("email", userEmail.getText().toString());
        }
    }



}
