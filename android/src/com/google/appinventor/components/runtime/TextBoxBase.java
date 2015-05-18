// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.EditText;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public abstract class TextBoxBase extends AndroidViewComponent
    implements android.view.View.OnFocusChangeListener
{

    private int backgroundColor;
    private boolean bold;
    private Drawable defaultTextBoxDrawable;
    private int fontTypeface;
    private String hint;
    private boolean italic;
    private int textAlignment;
    private int textColor;
    protected final EditText view;

    public TextBoxBase(ComponentContainer componentcontainer, EditText edittext)
    {
        super(componentcontainer);
        view = edittext;
        view.setOnFocusChangeListener(this);
        defaultTextBoxDrawable = view.getBackground();
        componentcontainer.$add(this);
        componentcontainer.setChildWidth(this, 160);
        TextAlignment(0);
        Enabled(true);
        fontTypeface = 0;
        TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
        FontSize(14F);
        Hint("");
        Text("");
        TextColor(0xff000000);
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
            ViewUtil.setBackgroundDrawable(view, defaultTextBoxDrawable);
            return;
        }
    }

    public void Enabled(boolean flag)
    {
        TextViewUtil.setEnabled(view, flag);
    }

    public boolean Enabled()
    {
        return TextViewUtil.isEnabled(view);
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

    public String Hint()
    {
        return hint;
    }

    public void Hint(String s)
    {
        hint = s;
        view.setHint(s);
        view.invalidate();
    }

    public void LostFocus()
    {
        EventDispatcher.dispatchEvent(this, "LostFocus", new Object[0]);
    }

    public void RequestFocus()
    {
        view.requestFocus();
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
