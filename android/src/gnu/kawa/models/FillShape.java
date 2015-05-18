// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

// Referenced classes of package gnu.kawa.models:
//            Paintable

public class FillShape
    implements Paintable
{

    Shape shape;

    public FillShape(Shape shape1)
    {
        shape = shape1;
    }

    public Rectangle2D getBounds2D()
    {
        return shape.getBounds2D();
    }

    public void paint(Graphics2D graphics2d)
    {
        graphics2d.fill(shape);
    }

    public Paintable transform(AffineTransform affinetransform)
    {
        return new FillShape(affinetransform.createTransformedShape(shape));
    }
}
