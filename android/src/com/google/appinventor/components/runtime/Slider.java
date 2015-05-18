// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.View;
import android.widget.SeekBar;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public class Slider extends AndroidViewComponent
    implements android.widget.SeekBar.OnSeekBarChangeListener
{

    private static final boolean DEBUG = false;
    private static final String LOG_TAG = "Slider";
    private static final int initialLeftColor = -14336;
    private static final String initialLeftColorString = "&HFFFFC800";
    private static final int initialRightColor = 0xff888888;
    private static final String initialRightColorString = "&HFF888888";
    private ClipDrawable beforeThumb;
    private LayerDrawable fullBar;
    private int leftColor;
    private float maxValue;
    private float minValue;
    private int rightColor;
    private final SeekBar seekbar;
    private boolean thumbEnabled;
    private float thumbPosition;

    public Slider(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        seekbar = new SeekBar(componentcontainer.$context());
        fullBar = (LayerDrawable)seekbar.getProgressDrawable();
        beforeThumb = (ClipDrawable)fullBar.findDrawableByLayerId(0x102000d);
        leftColor = -14336;
        rightColor = 0xff888888;
        setSliderColors();
        componentcontainer.$add(this);
        minValue = 10F;
        maxValue = 50F;
        thumbPosition = 30F;
        thumbEnabled = true;
        seekbar.setOnSeekBarChangeListener(this);
        seekbar.setMax(100);
        setSeekbarPosition();
    }

    private void setSeekbarPosition()
    {
        float f = (thumbPosition - minValue) / (maxValue - minValue);
        seekbar.setProgress((int)(f * 100F));
    }

    private void setSliderColors()
    {
        fullBar.setColorFilter(rightColor, android.graphics.PorterDuff.Mode.SRC);
        beforeThumb.setColorFilter(leftColor, android.graphics.PorterDuff.Mode.SRC);
    }

    public int ColorLeft()
    {
        return leftColor;
    }

    public void ColorLeft(int i)
    {
        leftColor = i;
        setSliderColors();
    }

    public int ColorRight()
    {
        return rightColor;
    }

    public void ColorRight(int i)
    {
        rightColor = i;
        setSliderColors();
    }

    public int Height()
    {
        return getView().getHeight();
    }

    public void Height(int i)
    {
        container.setChildHeight(this, i);
    }

    public float MaxValue()
    {
        return maxValue;
    }

    public void MaxValue(float f)
    {
        maxValue = f;
        minValue = Math.min(f, minValue);
        ThumbPosition((minValue + maxValue) / 2.0F);
    }

    public float MinValue()
    {
        return minValue;
    }

    public void MinValue(float f)
    {
        minValue = f;
        maxValue = Math.max(f, maxValue);
        ThumbPosition((minValue + maxValue) / 2.0F);
    }

    public void PositionChanged(float f)
    {
        EventDispatcher.dispatchEvent(this, "PositionChanged", new Object[] {
            Float.valueOf(f)
        });
    }

    public void ThumbEnabled(boolean flag)
    {
        thumbEnabled = flag;
        char c;
        if (thumbEnabled)
        {
            c = '\377';
        } else
        {
            c = '\0';
        }
        seekbar.getThumb().mutate().setAlpha(c);
        seekbar.setEnabled(thumbEnabled);
    }

    public boolean ThumbEnabled()
    {
        return thumbEnabled;
    }

    public float ThumbPosition()
    {
        return thumbPosition;
    }

    public void ThumbPosition(float f)
    {
        thumbPosition = Math.max(Math.min(f, maxValue), minValue);
        setSeekbarPosition();
        PositionChanged(thumbPosition);
    }

    public View getView()
    {
        return seekbar;
    }

    public void onProgressChanged(SeekBar seekbar1, int i, boolean flag)
    {
        thumbPosition = ((maxValue - minValue) * (float)i) / 100F + minValue;
        PositionChanged(thumbPosition);
    }

    public void onStartTrackingTouch(SeekBar seekbar1)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar1)
    {
    }
}
