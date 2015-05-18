// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.View;

// Referenced classes of package com.google.appinventor.components.runtime:
//            VisibleComponent, ComponentContainer, HandlesEventDispatching

public abstract class AndroidViewComponent extends VisibleComponent
{

    private int column;
    protected final ComponentContainer container;
    private int lastSetHeight;
    private int lastSetWidth;
    private int row;

    protected AndroidViewComponent(ComponentContainer componentcontainer)
    {
        lastSetWidth = -3;
        lastSetHeight = -3;
        column = -1;
        row = -1;
        container = componentcontainer;
    }

    public int Column()
    {
        return column;
    }

    public void Column(int i)
    {
        column = i;
    }

    public void CopyHeight(AndroidViewComponent androidviewcomponent)
    {
        Height(androidviewcomponent.lastSetHeight);
    }

    public void CopyWidth(AndroidViewComponent androidviewcomponent)
    {
        Width(androidviewcomponent.lastSetWidth);
    }

    public int Height()
    {
        return getView().getHeight();
    }

    public void Height(int i)
    {
        container.setChildHeight(this, i);
        lastSetHeight = i;
    }

    public int Row()
    {
        return row;
    }

    public void Row(int i)
    {
        row = i;
    }

    public void Visible(Boolean boolean1)
    {
        View view = getView();
        int i;
        if (boolean1.booleanValue())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean Visible()
    {
        return getView().getVisibility() == 0;
    }

    public int Width()
    {
        return getView().getWidth();
    }

    public void Width(int i)
    {
        container.setChildWidth(this, i);
        lastSetWidth = i;
    }

    public HandlesEventDispatching getDispatchDelegate()
    {
        return container.$form();
    }

    public abstract View getView();
}
