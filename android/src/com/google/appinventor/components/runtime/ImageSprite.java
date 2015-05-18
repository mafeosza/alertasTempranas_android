// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import com.google.appinventor.components.runtime.util.MediaUtil;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Sprite, ComponentContainer, Form

public class ImageSprite extends Sprite
{

    private double cachedRotationHeading;
    private BitmapDrawable drawable;
    private final Form form;
    private int heightHint;
    private Matrix mat;
    private String picturePath;
    private Bitmap rotatedBitmap;
    private BitmapDrawable rotatedDrawable;
    private boolean rotates;
    private boolean rotationCached;
    private Bitmap scaledBitmap;
    private Bitmap unrotatedBitmap;
    private int widthHint;

    public ImageSprite(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        widthHint = -1;
        heightHint = -1;
        picturePath = "";
        form = componentcontainer.$form();
        mat = new Matrix();
        rotates = true;
        rotationCached = false;
    }

    public int Height()
    {
        if (heightHint == -1 || heightHint == -2)
        {
            if (drawable == null)
            {
                return 0;
            } else
            {
                return drawable.getBitmap().getHeight();
            }
        } else
        {
            return heightHint;
        }
    }

    public void Height(int i)
    {
        heightHint = i;
        registerChange();
    }

    public String Picture()
    {
        return picturePath;
    }

    public void Picture(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        picturePath = s1;
        try
        {
            drawable = MediaUtil.getBitmapDrawable(form, picturePath);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("ImageSprite", (new StringBuilder()).append("Unable to load ").append(picturePath).toString());
            drawable = null;
        }
        if (drawable != null)
        {
            unrotatedBitmap = drawable.getBitmap();
        } else
        {
            unrotatedBitmap = null;
        }
        registerChange();
    }

    public void Rotates(boolean flag)
    {
        rotates = flag;
        registerChange();
    }

    public boolean Rotates()
    {
        return rotates;
    }

    public int Width()
    {
        if (widthHint == -1 || widthHint == -2)
        {
            if (drawable == null)
            {
                return 0;
            } else
            {
                return drawable.getBitmap().getWidth();
            }
        } else
        {
            return widthHint;
        }
    }

    public void Width(int i)
    {
        widthHint = i;
        registerChange();
    }

    public void onDraw(Canvas canvas)
    {
        int i;
        int j;
        int k;
        int l;
label0:
        {
            if (unrotatedBitmap != null && visible)
            {
                i = (int)Math.round(xLeft);
                j = (int)Math.round(yTop);
                k = Width();
                l = Height();
                if (rotates)
                {
                    break label0;
                }
                drawable.setBounds(i, j, i + k, j + l);
                drawable.draw(canvas);
            }
            return;
        }
        if (!rotationCached || cachedRotationHeading != Heading())
        {
            mat.setRotate((float)(-Heading()), k / 2, l / 2);
            if (k != unrotatedBitmap.getWidth() || l != unrotatedBitmap.getHeight())
            {
                scaledBitmap = Bitmap.createScaledBitmap(unrotatedBitmap, k, l, true);
            } else
            {
                scaledBitmap = unrotatedBitmap;
            }
            rotatedBitmap = Bitmap.createBitmap(scaledBitmap, 0, 0, scaledBitmap.getWidth(), scaledBitmap.getHeight(), mat, true);
            rotatedDrawable = new BitmapDrawable(rotatedBitmap);
            cachedRotationHeading = Heading();
        }
        rotatedDrawable.setBounds((k / 2 + i) - rotatedBitmap.getWidth() / 2, (l / 2 + j) - rotatedBitmap.getHeight() / 2, k / 2 + i + rotatedBitmap.getWidth() / 2, l / 2 + j + rotatedBitmap.getHeight() / 2);
        rotatedDrawable.draw(canvas);
    }
}
