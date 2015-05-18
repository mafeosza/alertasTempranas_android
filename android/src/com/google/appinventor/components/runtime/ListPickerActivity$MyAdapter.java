// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ListPickerActivity

private static class mContext extends ArrayAdapter
{

    private final Context mContext;

    public long getItemId(int i)
    {
        return (long)((String)getItem(i)).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        TextView textview = (TextView)view;
        view = textview;
        if (textview == null)
        {
            view = (TextView)LayoutInflater.from(mContext).inflate(0x1090003, viewgroup, false);
        }
        view.setText((CharSequence)getItem(i));
        view.setTextColor(ListPickerActivity.itemColor);
        return view;
    }

    public (Context context, String as[])
    {
        super(context, 0x1090000, as);
        mContext = context;
    }
}
