// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.graphics.Bitmap;
import android.view.View;

public class DonutUtil
{

    private DonutUtil()
    {
    }

    public static void buildDrawingCache(View view, boolean flag)
    {
        view.buildDrawingCache(flag);
    }

    public static Bitmap getDrawingCache(View view, boolean flag)
    {
        return view.getDrawingCache(flag);
    }
}
