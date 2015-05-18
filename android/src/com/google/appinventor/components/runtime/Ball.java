// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.google.appinventor.components.runtime.util.PaintUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Sprite, ComponentContainer

public final class Ball extends Sprite
{

    static final int DEFAULT_RADIUS = 5;
    private Paint paint;
    private int paintColor;
    private int radius;

    public Ball(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        paint = new Paint();
        PaintColor(0xff000000);
        Radius(5);
    }

    public int Height()
    {
        return radius * 2;
    }

    public void Height(int i)
    {
    }

    public int PaintColor()
    {
        return paintColor;
    }

    public void PaintColor(int i)
    {
        paintColor = i;
        if (i != 0)
        {
            PaintUtil.changePaint(paint, i);
        } else
        {
            PaintUtil.changePaint(paint, 0xff000000);
        }
        registerChange();
    }

    public int Radius()
    {
        return radius;
    }

    public void Radius(int i)
    {
        radius = i;
        registerChange();
    }

    public int Width()
    {
        return radius * 2;
    }

    public void Width(int i)
    {
    }

    public boolean containsPoint(double d, double d1)
    {
        double d2 = xLeft + (double)radius;
        double d3 = yTop + (double)radius;
        return (d - d2) * (d - d2) + (d1 - d3) * (d1 - d3) <= (double)(radius * radius);
    }

    protected void onDraw(Canvas canvas)
    {
        if (visible)
        {
            canvas.drawCircle((float)xLeft + (float)radius, (float)yTop + (float)radius, radius, paint);
        }
    }
}
