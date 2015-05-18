// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.view.View;
import com.google.appinventor.components.runtime.util.ViewUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, Component, ComponentContainer, TableLayout, 
//            Form

public class TableArrangement extends AndroidViewComponent
    implements Component, ComponentContainer
{

    private final Activity context;
    private final TableLayout viewLayout;

    public TableArrangement(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        context = componentcontainer.$context();
        viewLayout = new TableLayout(context, 2, 2);
        componentcontainer.$add(this);
    }

    public void $add(AndroidViewComponent androidviewcomponent)
    {
        viewLayout.add(androidviewcomponent);
    }

    public Activity $context()
    {
        return context;
    }

    public Form $form()
    {
        return container.$form();
    }

    public int Columns()
    {
        return viewLayout.getNumColumns();
    }

    public void Columns(int i)
    {
        viewLayout.setNumColumns(i);
    }

    public int Rows()
    {
        return viewLayout.getNumRows();
    }

    public void Rows(int i)
    {
        viewLayout.setNumRows(i);
    }

    public View getView()
    {
        return viewLayout.getLayoutManager();
    }

    public void setChildHeight(AndroidViewComponent androidviewcomponent, int i)
    {
        ViewUtil.setChildHeightForTableLayout(androidviewcomponent.getView(), i);
    }

    public void setChildWidth(AndroidViewComponent androidviewcomponent, int i)
    {
        ViewUtil.setChildWidthForTableLayout(androidviewcomponent.getView(), i);
    }
}
