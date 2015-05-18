// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public final class ViewUtil
{

    private ViewUtil()
    {
    }

    public static void setBackgroundDrawable(View view, Drawable drawable)
    {
        view.setBackgroundDrawable(drawable);
        view.invalidate();
    }

    public static void setBackgroundImage(View view, Drawable drawable)
    {
        view.setBackgroundDrawable(drawable);
        view.requestLayout();
    }

    public static void setChildHeightForHorizontalLayout(View view, int i)
    {
        Object obj = view.getLayoutParams();
        if (!(obj instanceof android.widget.LinearLayout.LayoutParams)) goto _L2; else goto _L1
_L1:
        obj = (android.widget.LinearLayout.LayoutParams)obj;
        i;
        JVM INSTR tableswitch -2 -1: default 40
    //                   -2 59
    //                   -1 50;
           goto _L3 _L4 _L5
_L3:
        obj.height = i;
_L6:
        view.requestLayout();
        return;
_L5:
        obj.height = -2;
        continue; /* Loop/switch isn't completed */
_L4:
        obj.height = -1;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("ViewUtil", "The view does not have linear layout parameters");
        return;
    }

    public static void setChildHeightForTableLayout(View view, int i)
    {
        Object obj = view.getLayoutParams();
        if (!(obj instanceof android.widget.TableRow.LayoutParams)) goto _L2; else goto _L1
_L1:
        obj = (android.widget.TableRow.LayoutParams)obj;
        i;
        JVM INSTR tableswitch -2 -1: default 40
    //                   -2 59
    //                   -1 50;
           goto _L3 _L4 _L5
_L3:
        obj.height = i;
_L6:
        view.requestLayout();
        return;
_L5:
        obj.height = -2;
        continue; /* Loop/switch isn't completed */
_L4:
        obj.height = -1;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("ViewUtil", "The view does not have table layout parameters");
        return;
    }

    public static void setChildHeightForVerticalLayout(View view, int i)
    {
        Object obj = view.getLayoutParams();
        if (!(obj instanceof android.widget.LinearLayout.LayoutParams)) goto _L2; else goto _L1
_L1:
        obj = (android.widget.LinearLayout.LayoutParams)obj;
        i;
        JVM INSTR tableswitch -2 -1: default 40
    //                   -2 69
    //                   -1 55;
           goto _L3 _L4 _L5
_L3:
        obj.height = i;
        obj.weight = 0.0F;
_L6:
        view.requestLayout();
        return;
_L5:
        obj.height = -2;
        obj.weight = 0.0F;
        continue; /* Loop/switch isn't completed */
_L4:
        obj.height = 0;
        obj.weight = 1.0F;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("ViewUtil", "The view does not have linear layout parameters");
        return;
    }

    public static void setChildWidthForHorizontalLayout(View view, int i)
    {
        Object obj = view.getLayoutParams();
        if (!(obj instanceof android.widget.LinearLayout.LayoutParams)) goto _L2; else goto _L1
_L1:
        obj = (android.widget.LinearLayout.LayoutParams)obj;
        i;
        JVM INSTR tableswitch -2 -1: default 40
    //                   -2 69
    //                   -1 55;
           goto _L3 _L4 _L5
_L3:
        obj.width = i;
        obj.weight = 0.0F;
_L6:
        view.requestLayout();
        return;
_L5:
        obj.width = -2;
        obj.weight = 0.0F;
        continue; /* Loop/switch isn't completed */
_L4:
        obj.width = 0;
        obj.weight = 1.0F;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("ViewUtil", "The view does not have linear layout parameters");
        return;
    }

    public static void setChildWidthForTableLayout(View view, int i)
    {
        Object obj = view.getLayoutParams();
        if (!(obj instanceof android.widget.TableRow.LayoutParams)) goto _L2; else goto _L1
_L1:
        obj = (android.widget.TableRow.LayoutParams)obj;
        i;
        JVM INSTR tableswitch -2 -1: default 40
    //                   -2 59
    //                   -1 50;
           goto _L3 _L4 _L5
_L3:
        obj.width = i;
_L6:
        view.requestLayout();
        return;
_L5:
        obj.width = -2;
        continue; /* Loop/switch isn't completed */
_L4:
        obj.width = -1;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("ViewUtil", "The view does not have table layout parameters");
        return;
    }

    public static void setChildWidthForVerticalLayout(View view, int i)
    {
        Object obj = view.getLayoutParams();
        if (!(obj instanceof android.widget.LinearLayout.LayoutParams)) goto _L2; else goto _L1
_L1:
        obj = (android.widget.LinearLayout.LayoutParams)obj;
        i;
        JVM INSTR tableswitch -2 -1: default 40
    //                   -2 59
    //                   -1 50;
           goto _L3 _L4 _L5
_L3:
        obj.width = i;
_L6:
        view.requestLayout();
        return;
_L5:
        obj.width = -2;
        continue; /* Loop/switch isn't completed */
_L4:
        obj.width = -1;
        if (true) goto _L6; else goto _L2
_L2:
        Log.e("ViewUtil", "The view does not have linear layout parameters");
        return;
    }

    public static void setImage(ImageView imageview, Drawable drawable)
    {
        imageview.setImageDrawable(drawable);
        if (drawable != null)
        {
            imageview.setAdjustViewBounds(true);
        }
        imageview.requestLayout();
    }
}
