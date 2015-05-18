// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

// Referenced classes of package gnu.kawa.models:
//            Paintable

public class WithPaint
    implements Paintable
{

    Paint paint;
    Paintable paintable;

    public WithPaint(Paintable paintable1, Paint paint1)
    {
        paintable = paintable1;
        paint = paint1;
    }

    public Rectangle2D getBounds2D()
    {
        return paintable.getBounds2D();
    }

    public void paint(Graphics2D graphics2d)
    {
        Paint paint1 = graphics2d.getPaint();
        graphics2d.setPaint(paint);
        paintable.paint(graphics2d);
        graphics2d.setPaint(paint1);
        return;
        Exception exception;
        exception;
        graphics2d.setPaint(paint1);
        throw exception;
    }

    public Paintable transform(AffineTransform affinetransform)
    {
        return new WithPaint(paintable.transform(affinetransform), paint);
    }
}
