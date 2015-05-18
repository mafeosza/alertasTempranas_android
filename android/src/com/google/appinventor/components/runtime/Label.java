// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.appinventor.components.runtime.util.TextViewUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer

public final class Label extends AndroidViewComponent
{

    private static final int DEFAULT_LABEL_MARGIN = 2;
    private int backgroundColor;
    private boolean bold;
    private int defaultLabelMarginInDp;
    private int fontTypeface;
    private boolean hasMargins;
    private boolean italic;
    private final android.widget.LinearLayout.LayoutParams linearLayoutParams;
    private int textAlignment;
    private int textColor;
    private final TextView view;

    public Label(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        defaultLabelMarginInDp = 0;
        view = new TextView(componentcontainer.$context());
        componentcontainer.$add(this);
        componentcontainer = view.getLayoutParams();
        if (componentcontainer instanceof android.widget.LinearLayout.LayoutParams)
        {
            linearLayoutParams = (android.widget.LinearLayout.LayoutParams)componentcontainer;
            defaultLabelMarginInDp = dpToPx(view, 2);
        } else
        {
            defaultLabelMarginInDp = 0;
            linearLayoutParams = null;
            Log.e("Label", "Error: The label's view does not have linear layout parameters");
            (new RuntimeException()).printStackTrace();
        }
        TextAlignment(0);
        BackgroundColor(0xffffff);
        fontTypeface = 0;
        TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
        FontSize(14F);
        Text("");
        TextColor(0xff000000);
        HasMargins(true);
    }

    private static int dpToPx(View view1, int i)
    {
        float f = view1.getContext().getResources().getDisplayMetrics().density;
        return Math.round((float)i * f);
    }

    private void setLabelMargins(boolean flag)
    {
        int i;
        if (flag)
        {
            i = defaultLabelMarginInDp;
        } else
        {
            i = 0;
        }
        linearLayoutParams.setMargins(i, i, i, i);
        view.invalidate();
    }

    public int BackgroundColor()
    {
        return backgroundColor;
    }

    public void BackgroundColor(int i)
    {
        backgroundColor = i;
        if (i != 0)
        {
            TextViewUtil.setBackgroundColor(view, i);
            return;
        } else
        {
            TextViewUtil.setBackgroundColor(view, 0xffffff);
            return;
        }
    }

    public void FontBold(boolean flag)
    {
        bold = flag;
        TextViewUtil.setFontTypeface(view, fontTypeface, flag, italic);
    }

    public boolean FontBold()
    {
        return bold;
    }

    public void FontItalic(boolean flag)
    {
        italic = flag;
        TextViewUtil.setFontTypeface(view, fontTypeface, bold, flag);
    }

    public boolean FontItalic()
    {
        return italic;
    }

    public float FontSize()
    {
        return TextViewUtil.getFontSize(view);
    }

    public void FontSize(float f)
    {
        TextViewUtil.setFontSize(view, f);
    }

    public int FontTypeface()
    {
        return fontTypeface;
    }

    public void FontTypeface(int i)
    {
        fontTypeface = i;
        TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
    }

    public void HasMargins(boolean flag)
    {
        hasMargins = flag;
        setLabelMargins(flag);
    }

    public boolean HasMargins()
    {
        return hasMargins;
    }

    public String Text()
    {
        return TextViewUtil.getText(view);
    }

    public void Text(String s)
    {
        TextViewUtil.setText(view, s);
    }

    public int TextAlignment()
    {
        return textAlignment;
    }

    public void TextAlignment(int i)
    {
        textAlignment = i;
        TextViewUtil.setAlignment(view, i, false);
    }

    public int TextColor()
    {
        return textColor;
    }

    public void TextColor(int i)
    {
        textColor = i;
        if (i != 0)
        {
            TextViewUtil.setTextColor(view, i);
            return;
        } else
        {
            TextViewUtil.setTextColor(view, 0xff000000);
            return;
        }
    }

    public View getView()
    {
        return view;
    }
}
