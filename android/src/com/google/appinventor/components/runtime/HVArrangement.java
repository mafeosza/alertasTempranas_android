// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.view.View;
import com.google.appinventor.components.runtime.util.AlignmentUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, Component, ComponentContainer, LinearLayout, 
//            Form

public class HVArrangement extends AndroidViewComponent
    implements Component, ComponentContainer
{

    private final AlignmentUtil alignmentSetter;
    private final Activity context;
    private int horizontalAlignment;
    private final int orientation;
    private int verticalAlignment;
    private final LinearLayout viewLayout;

    public HVArrangement(ComponentContainer componentcontainer, int i)
    {
        super(componentcontainer);
        context = componentcontainer.$context();
        orientation = i;
        viewLayout = new LinearLayout(context, i, Integer.valueOf(100), Integer.valueOf(100));
        alignmentSetter = new AlignmentUtil(viewLayout);
        horizontalAlignment = 1;
        verticalAlignment = 1;
        alignmentSetter.setHorizontalAlignment(horizontalAlignment);
        alignmentSetter.setVerticalAlignment(verticalAlignment);
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

    public int AlignHorizontal()
    {
        return horizontalAlignment;
    }

    public void AlignHorizontal(int i)
    {
        try
        {
            alignmentSetter.setHorizontalAlignment(i);
            horizontalAlignment = i;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            container.$form().dispatchErrorOccurredEvent(this, "HorizontalAlignment", 1401, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public int AlignVertical()
    {
        return verticalAlignment;
    }

    public void AlignVertical(int i)
    {
        try
        {
            alignmentSetter.setVerticalAlignment(i);
            verticalAlignment = i;
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            container.$form().dispatchErrorOccurredEvent(this, "VerticalAlignment", 1402, new Object[] {
                Integer.valueOf(i)
            });
        }
    }

    public View getView()
    {
        return viewLayout.getLayoutManager();
    }

    public void setChildHeight(AndroidViewComponent androidviewcomponent, int i)
    {
        if (orientation == 0)
        {
            ViewUtil.setChildHeightForHorizontalLayout(androidviewcomponent.getView(), i);
            return;
        } else
        {
            ViewUtil.setChildHeightForVerticalLayout(androidviewcomponent.getView(), i);
            return;
        }
    }

    public void setChildWidth(AndroidViewComponent androidviewcomponent, int i)
    {
        if (orientation == 0)
        {
            ViewUtil.setChildWidthForHorizontalLayout(androidviewcomponent.getView(), i);
            return;
        } else
        {
            ViewUtil.setChildWidthForVerticalLayout(androidviewcomponent.getView(), i);
            return;
        }
    }
}
