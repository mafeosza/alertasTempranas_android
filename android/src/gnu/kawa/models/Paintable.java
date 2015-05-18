// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public interface Paintable
{

    public abstract Rectangle2D getBounds2D();

    public abstract void paint(Graphics2D graphics2d);

    public abstract Paintable transform(AffineTransform affinetransform);
}
