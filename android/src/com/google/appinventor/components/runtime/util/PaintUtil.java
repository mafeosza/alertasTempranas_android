// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;

public class PaintUtil
{

    private PaintUtil()
    {
    }

    public static void changePaint(Paint paint, int i)
    {
        paint.setColor(0xffffff & i);
        paint.setAlpha(i >> 24 & 0xff);
        paint.setXfermode(null);
    }

    public static void changePaintTransparent(Paint paint)
    {
        paint.setAlpha(0);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
    }
}
