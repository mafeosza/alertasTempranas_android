// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.View;
import android.widget.CompoundButton;
import com.google.appinventor.components.runtime.util.TextViewUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public final class CheckBox extends AndroidViewComponent
    implements android.widget.CompoundButton.OnCheckedChangeListener, android.view.View.OnFocusChangeListener
{

    private int backgroundColor;
    private boolean bold;
    private int fontTypeface;
    private boolean italic;
    private int textColor;
    private final android.widget.CheckBox view;

    public CheckBox(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        view = new android.widget.CheckBox(componentcontainer.$context());
        view.setOnFocusChangeListener(this);
        view.setOnCheckedChangeListener(this);
        componentcontainer.$add(this);
        BackgroundColor(0xffffff);
        Enabled(true);
        fontTypeface = 0;
        TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
        FontSize(14F);
        Text("");
        TextColor(0xff000000);
        Checked(false);
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

    public void Changed()
    {
        EventDispatcher.dispatchEvent(this, "Changed", new Object[0]);
    }

    public void Checked(boolean flag)
    {
        view.setChecked(flag);
        view.invalidate();
    }

    public boolean Checked()
    {
        return view.isChecked();
    }

    public void Enabled(boolean flag)
    {
        TextViewUtil.setEnabled(view, flag);
    }

    public boolean Enabled()
    {
        return view.isEnabled();
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

    public void GotFocus()
    {
        EventDispatcher.dispatchEvent(this, "GotFocus", new Object[0]);
    }

    public void LostFocus()
    {
        EventDispatcher.dispatchEvent(this, "LostFocus", new Object[0]);
    }

    public String Text()
    {
        return TextViewUtil.getText(view);
    }

    public void Text(String s)
    {
        TextViewUtil.setText(view, s);
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

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        Changed();
    }

    public void onFocusChange(View view1, boolean flag)
    {
        if (flag)
        {
            GotFocus();
            return;
        } else
        {
            LostFocus();
            return;
        }
    }
}
