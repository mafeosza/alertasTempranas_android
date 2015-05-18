// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;


public final class BoundingBox
{

    private double bottom;
    private double left;
    private double right;
    private double top;

    public BoundingBox(double d, double d1, double d2, double d3)
    {
        left = d;
        top = d1;
        right = d2;
        bottom = d3;
    }

    public double getBottom()
    {
        return bottom;
    }

    public double getLeft()
    {
        return left;
    }

    public double getRight()
    {
        return right;
    }

    public double getTop()
    {
        return top;
    }

    public boolean intersectDestructively(BoundingBox boundingbox)
    {
        double d = Math.max(left, boundingbox.left);
        double d1 = Math.min(right, boundingbox.right);
        double d2 = Math.max(top, boundingbox.top);
        double d3 = Math.min(bottom, boundingbox.bottom);
        if (d > d1 || d2 > d3)
        {
            return false;
        } else
        {
            left = d;
            right = d1;
            top = d2;
            bottom = d3;
            return true;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("<BoundingBox (left = ").append(left).append(", top = ").append(top).append(", right = ").append(right).append(", bottom = ").append(bottom).append(">").toString();
    }
}
