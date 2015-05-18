// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Intent;
import android.view.Window;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Picker, ActivityResultListener, Deleteable, OnResumeListener, 
//            ListPickerActivity, ComponentContainer, Form

public class ListPicker extends Picker
    implements ActivityResultListener, Deleteable, OnResumeListener
{

    private static final boolean DEFAULT_ENABLED = false;
    public static final int DEFAULT_ITEM_BACKGROUND_COLOR = 0xff000000;
    public static final int DEFAULT_ITEM_TEXT_COLOR = -1;
    static final String LIST_ACTIVITY_ANIM_TYPE = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".anim").toString();
    static final String LIST_ACTIVITY_ARG_NAME = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".list").toString();
    static final String LIST_ACTIVITY_BACKGROUND_COLOR = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".backgroundcolor").toString();
    private static final String LIST_ACTIVITY_CLASS = com/google/appinventor/components/runtime/ListPickerActivity.getName();
    static final String LIST_ACTIVITY_ITEM_TEXT_COLOR = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".itemtextcolor").toString();
    static final String LIST_ACTIVITY_ORIENTATION_TYPE = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".orientation").toString();
    static final String LIST_ACTIVITY_RESULT_INDEX = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".index").toString();
    static final String LIST_ACTIVITY_RESULT_NAME = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".selection").toString();
    static final String LIST_ACTIVITY_SHOW_SEARCH_BAR = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".search").toString();
    static final String LIST_ACTIVITY_TITLE = (new StringBuilder()).append(LIST_ACTIVITY_CLASS).append(".title").toString();
    private int itemBackgroundColor;
    private int itemTextColor;
    private YailList items;
    private boolean resumedFromListFlag;
    private String selection;
    private int selectionIndex;
    private boolean showFilter;
    private String title;

    public ListPicker(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        showFilter = false;
        title = "";
        resumedFromListFlag = false;
        items = new YailList();
        selection = "";
        selectionIndex = 0;
        itemTextColor = -1;
        itemBackgroundColor = 0xff000000;
        componentcontainer.$form().registerForOnResume(this);
    }

    public YailList Elements()
    {
        return items;
    }

    public void Elements(YailList yaillist)
    {
        items = ElementsUtil.elements(yaillist, "ListPicker");
    }

    public void ElementsFromString(String s)
    {
        items = ElementsUtil.elementsFromString(s);
    }

    public int ItemBackgroundColor()
    {
        return itemBackgroundColor;
    }

    public void ItemBackgroundColor(int i)
    {
        itemBackgroundColor = i;
    }

    public int ItemTextColor()
    {
        return itemTextColor;
    }

    public void ItemTextColor(int i)
    {
        itemTextColor = i;
    }

    public String Selection()
    {
        return selection;
    }

    public void Selection(String s)
    {
        selection = s;
        selectionIndex = ElementsUtil.setSelectedIndexFromValue(s, items);
    }

    public int SelectionIndex()
    {
        return selectionIndex;
    }

    public void SelectionIndex(int i)
    {
        selectionIndex = ElementsUtil.selectionIndex(i, items);
        selection = ElementsUtil.setSelectionFromIndex(i, items);
    }

    public void ShowFilterBar(boolean flag)
    {
        showFilter = flag;
    }

    public boolean ShowFilterBar()
    {
        return showFilter;
    }

    public String Title()
    {
        return title;
    }

    public void Title(String s)
    {
        title = s;
    }

    public Intent getIntent()
    {
        Intent intent = new Intent();
        intent.setClassName(container.$context(), LIST_ACTIVITY_CLASS);
        intent.putExtra(LIST_ACTIVITY_ARG_NAME, items.toStringArray());
        intent.putExtra(LIST_ACTIVITY_SHOW_SEARCH_BAR, String.valueOf(showFilter));
        if (!title.equals(""))
        {
            intent.putExtra(LIST_ACTIVITY_TITLE, title);
        }
        String s = container.$form().getOpenAnimType();
        intent.putExtra(LIST_ACTIVITY_ANIM_TYPE, s);
        intent.putExtra(LIST_ACTIVITY_ORIENTATION_TYPE, container.$form().ScreenOrientation());
        intent.putExtra(LIST_ACTIVITY_ITEM_TEXT_COLOR, itemTextColor);
        intent.putExtra(LIST_ACTIVITY_BACKGROUND_COLOR, itemBackgroundColor);
        return intent;
    }

    public void onDelete()
    {
        container.$form().unregisterForActivityResult(this);
    }

    public void onResume()
    {
        if (resumedFromListFlag)
        {
            container.$form().getWindow().setSoftInputMode(3);
            resumedFromListFlag = false;
        }
    }

    public void resultReturned(int i, int j, Intent intent)
    {
        if (i == requestCode && j == -1)
        {
            if (intent.hasExtra(LIST_ACTIVITY_RESULT_NAME))
            {
                selection = intent.getStringExtra(LIST_ACTIVITY_RESULT_NAME);
            } else
            {
                selection = "";
            }
            selectionIndex = intent.getIntExtra(LIST_ACTIVITY_RESULT_INDEX, 0);
            AfterPicking();
            resumedFromListFlag = true;
        }
    }

}
