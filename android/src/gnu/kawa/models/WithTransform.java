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

public class WithTransform
    implements Paintable
{

    Paintable paintable;
    AffineTransform transform;

    public WithTransform(Paintable paintable1, AffineTransform affinetransform)
    {
        paintable = paintable1;
        transform = affinetransform;
    }

    public Rectangle2D getBounds2D()
    {
        return transform.createTransformedShape(paintable.getBounds2D()).getBounds2D();
    }

    public void paint(Graphics2D graphics2d)
    {
        AffineTransform affinetransform = graphics2d.getTransform();
        graphics2d.transform(transform);
        paintable.paint(graphics2d);
        graphics2d.setTransform(affinetransform);
        return;
        Exception exception;
        exception;
        graphics2d.setTransform(affinetransform);
        throw exception;
    }

    public Paintable transform(AffineTransform affinetransform)
    {
        AffineTransform affinetransform1 = new AffineTransform(transform);
        affinetransform1.concatenate(affinetransform);
        return new WithTransform(paintable, affinetransform1);
    }
}
