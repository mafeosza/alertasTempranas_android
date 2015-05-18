// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;

public class CustomMediaController extends MediaController
    implements android.view.View.OnTouchListener
{

    private View mAnchorView;
    private int mShowTime;

    public CustomMediaController(Context context)
    {
        super(context);
        mShowTime = 3000;
    }

    public boolean addTo(ViewGroup viewgroup, android.view.ViewGroup.LayoutParams layoutparams)
    {
        android.view.ViewParent viewparent = getParent();
        if (viewparent != null && (viewparent instanceof ViewGroup))
        {
            ((ViewGroup)viewparent).removeView(this);
            viewgroup.addView(this, layoutparams);
            return true;
        } else
        {
            Log.e("CustomMediaController.addTo", "MediaController not available in fullscreen.");
            return false;
        }
    }

    public void hide()
    {
        super.hide();
        setVisibility(4);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (view == mAnchorView)
        {
            show(mShowTime);
        }
        return false;
    }

    public void setAnchorView(View view)
    {
        mAnchorView = view;
        mAnchorView.setOnTouchListener(this);
        super.setAnchorView(view);
    }

    public void show()
    {
        setVisibility(0);
        super.show();
    }

    public void show(int i)
    {
        setVisibility(0);
        super.show(i);
    }
}
