// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.appinventor.components.runtime.util.AnimationUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ListPicker

public class ListPickerActivity extends Activity
    implements android.widget.AdapterView.OnItemClickListener
{
    private static class MyAdapter extends ArrayAdapter
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

        public MyAdapter(Context context, String as[])
        {
            super(context, 0x1090000, as);
            mContext = context;
        }
    }


    static int backgroundColor;
    static int itemColor;
    MyAdapter adapter;
    private String closeAnim;
    private ListView listView;
    EditText txtSearchBox;

    public ListPickerActivity()
    {
        closeAnim = "";
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new LinearLayout(this);
        bundle.setOrientation(1);
        Object obj = getIntent();
        if (((Intent) (obj)).hasExtra(ListPicker.LIST_ACTIVITY_ANIM_TYPE))
        {
            closeAnim = ((Intent) (obj)).getStringExtra(ListPicker.LIST_ACTIVITY_ANIM_TYPE);
        }
        if (((Intent) (obj)).hasExtra(ListPicker.LIST_ACTIVITY_ORIENTATION_TYPE))
        {
            String as[] = ((Intent) (obj)).getStringExtra(ListPicker.LIST_ACTIVITY_ORIENTATION_TYPE).toLowerCase();
            if (as.equals("portrait"))
            {
                setRequestedOrientation(1);
            } else
            if (as.equals("landscape"))
            {
                setRequestedOrientation(0);
            }
        }
        if (((Intent) (obj)).hasExtra(ListPicker.LIST_ACTIVITY_TITLE))
        {
            setTitle(((Intent) (obj)).getStringExtra(ListPicker.LIST_ACTIVITY_TITLE));
        }
        if (((Intent) (obj)).hasExtra(ListPicker.LIST_ACTIVITY_ARG_NAME))
        {
            as = getIntent().getStringArrayExtra(ListPicker.LIST_ACTIVITY_ARG_NAME);
            listView = new ListView(this);
            listView.setOnItemClickListener(this);
            itemColor = ((Intent) (obj)).getIntExtra(ListPicker.LIST_ACTIVITY_ITEM_TEXT_COLOR, -1);
            backgroundColor = ((Intent) (obj)).getIntExtra(ListPicker.LIST_ACTIVITY_BACKGROUND_COLOR, 0xff000000);
            bundle.setBackgroundColor(backgroundColor);
            adapter = new MyAdapter(this, as);
            listView.setAdapter(adapter);
            obj = ((Intent) (obj)).getStringExtra(ListPicker.LIST_ACTIVITY_SHOW_SEARCH_BAR);
            txtSearchBox = new EditText(this);
            txtSearchBox.setSingleLine(true);
            txtSearchBox.setWidth(-2);
            txtSearchBox.setPadding(10, 10, 10, 10);
            txtSearchBox.setHint("Search list...");
            if (obj == null || !((String) (obj)).equalsIgnoreCase("true"))
            {
                txtSearchBox.setVisibility(8);
            }
            txtSearchBox.addTextChangedListener(new TextWatcher() {

                final ListPickerActivity this$0;

                public void afterTextChanged(Editable editable)
                {
                }

                public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

                public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                    adapter.getFilter().filter(charsequence);
                }

            
            {
                this$0 = ListPickerActivity.this;
                super();
            }
            });
        } else
        {
            setResult(0);
            finish();
            AnimationUtil.ApplyCloseScreenAnimation(this, closeAnim);
        }
        bundle.addView(txtSearchBox);
        bundle.addView(listView);
        setContentView(bundle);
        bundle.requestLayout();
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
        getWindow().setSoftInputMode(3);
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (String)adapterview.getAdapter().getItem(i);
        view = new Intent();
        view.putExtra(ListPicker.LIST_ACTIVITY_RESULT_NAME, adapterview);
        view.putExtra(ListPicker.LIST_ACTIVITY_RESULT_INDEX, i + 1);
        closeAnim = adapterview;
        setResult(-1, view);
        finish();
        AnimationUtil.ApplyCloseScreenAnimation(this, closeAnim);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            boolean flag = super.onKeyDown(i, keyevent);
            AnimationUtil.ApplyCloseScreenAnimation(this, closeAnim);
            return flag;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }
}
