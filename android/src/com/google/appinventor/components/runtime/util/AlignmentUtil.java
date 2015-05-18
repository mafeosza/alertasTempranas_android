// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.LinearLayout;

public class AlignmentUtil
{

    LinearLayout viewLayout;

    public AlignmentUtil(LinearLayout linearlayout)
    {
        viewLayout = linearlayout;
    }

    public void setHorizontalAlignment(int i)
        throws IllegalArgumentException
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Bad value to setHorizontalAlignment: ").append(i).toString());

        case 1: // '\001'
            viewLayout.setHorizontalGravity(3);
            return;

        case 2: // '\002'
            viewLayout.setHorizontalGravity(5);
            return;

        case 3: // '\003'
            viewLayout.setHorizontalGravity(1);
            break;
        }
    }

    public void setVerticalAlignment(int i)
        throws IllegalArgumentException
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("Bad value to setVerticalAlignment: ").append(i).toString());

        case 1: // '\001'
            viewLayout.setVerticalGravity(48);
            return;

        case 2: // '\002'
            viewLayout.setVerticalGravity(16);
            return;

        case 3: // '\003'
            viewLayout.setVerticalGravity(80);
            break;
        }
    }
}
