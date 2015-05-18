// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.TextViewUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public abstract class ButtonBase extends AndroidViewComponent
    implements android.view.View.OnClickListener, android.view.View.OnFocusChangeListener, android.view.View.OnLongClickListener, android.view.View.OnTouchListener
{

    private static final String LOG_TAG = "ButtonBase";
    private static final float ROUNDED_CORNERS_ARRAY[] = {
        10F, 10F, 10F, 10F, 10F, 10F, 10F, 10F
    };
    private static final float ROUNDED_CORNERS_RADIUS = 10F;
    private static final int SHAPED_DEFAULT_BACKGROUND_COLOR = 0xffcccccc;
    private int backgroundColor;
    private Drawable backgroundImageDrawable;
    private boolean bold;
    private Drawable defaultButtonDrawable;
    private ColorStateList defaultColorStateList;
    private int fontTypeface;
    private String imagePath;
    private boolean italic;
    private int shape;
    private boolean showFeedback;
    private int textAlignment;
    private int textColor;
    private final Button view;

    public ButtonBase(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        showFeedback = true;
        imagePath = "";
        view = new Button(componentcontainer.$context());
        defaultButtonDrawable = view.getBackground();
        defaultColorStateList = view.getTextColors();
        componentcontainer.$add(this);
        view.setOnClickListener(this);
        view.setOnFocusChangeListener(this);
        view.setOnLongClickListener(this);
        view.setOnTouchListener(this);
        TextAlignment(1);
        BackgroundColor(0);
        Image("");
        Enabled(true);
        fontTypeface = 0;
        TextViewUtil.setFontTypeface(view, fontTypeface, bold, italic);
        FontSize(14F);
        Text("");
        TextColor(0);
        Shape(0);
    }

    private void setShape()
    {
        ShapeDrawable shapedrawable;
        shapedrawable = new ShapeDrawable();
        Paint paint = shapedrawable.getPaint();
        int i;
        if (backgroundColor == 0)
        {
            i = 0xffcccccc;
        } else
        {
            i = backgroundColor;
        }
        paint.setColor(i);
        shape;
        JVM INSTR tableswitch 1 3: default 60
    //                   1 76
    //                   2 108
    //                   3 122;
           goto _L1 _L2 _L3 _L4
_L1:
        throw new IllegalArgumentException();
_L2:
        shapedrawable.setShape(new RoundRectShape(ROUNDED_CORNERS_ARRAY, null, null));
_L6:
        view.setBackgroundDrawable(shapedrawable);
        view.invalidate();
        return;
_L3:
        shapedrawable.setShape(new RectShape());
        continue; /* Loop/switch isn't completed */
_L4:
        shapedrawable.setShape(new OvalShape());
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void updateAppearance()
    {
        if (backgroundImageDrawable == null)
        {
            if (shape == 0)
            {
                if (backgroundColor == 0)
                {
                    ViewUtil.setBackgroundDrawable(view, defaultButtonDrawable);
                    return;
                } else
                {
                    ViewUtil.setBackgroundDrawable(view, null);
                    TextViewUtil.setBackgroundColor(view, backgroundColor);
                    return;
                }
            } else
            {
                setShape();
                return;
            }
        } else
        {
            ViewUtil.setBackgroundImage(view, backgroundImageDrawable);
            return;
        }
    }

    public int BackgroundColor()
    {
        return backgroundColor;
    }

    public void BackgroundColor(int i)
    {
        backgroundColor = i;
        updateAppearance();
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

    public String Image()
    {
        return imagePath;
    }

    public void Image(String s)
    {
        if (s.equals(imagePath) && backgroundImageDrawable != null)
        {
            return;
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        imagePath = s1;
        backgroundImageDrawable = null;
        if (imagePath.length() > 0)
        {
            try
            {
                backgroundImageDrawable = MediaUtil.getBitmapDrawable(container.$form(), imagePath);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.e("ButtonBase", (new StringBuilder()).append("Unable to load ").append(imagePath).toString());
            }
        }
        updateAppearance();
    }

    public void LostFocus()
    {
        EventDispatcher.dispatchEvent(this, "LostFocus", new Object[0]);
    }

    public int Shape()
    {
        return shape;
    }

    public void Shape(int i)
    {
        shape = i;
        updateAppearance();
    }

    public void ShowFeedback(boolean flag)
    {
        showFeedback = flag;
    }

    public boolean ShowFeedback()
    {
        return showFeedback;
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
        TextViewUtil.setAlignment(view, i, true);
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
            TextViewUtil.setTextColors(view, defaultColorStateList);
            return;
        }
    }

    public void TouchDown()
    {
        EventDispatcher.dispatchEvent(this, "TouchDown", new Object[0]);
    }

    public void TouchUp()
    {
        EventDispatcher.dispatchEvent(this, "TouchUp", new Object[0]);
    }

    public abstract void click();

    public View getView()
    {
        return view;
    }

    public boolean longClick()
    {
        return false;
    }

    public void onClick(View view1)
    {
        click();
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

    public boolean onLongClick(View view1)
    {
        return longClick();
    }

    public boolean onTouch(View view1, MotionEvent motionevent)
    {
        if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        if (ShowFeedback())
        {
            view1.getBackground().setAlpha(70);
            view1.invalidate();
        }
        TouchDown();
_L4:
        return false;
_L2:
        if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
        {
            if (ShowFeedback())
            {
                view1.getBackground().setAlpha(255);
                view1.invalidate();
            }
            TouchUp();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
