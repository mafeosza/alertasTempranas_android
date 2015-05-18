// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import gnu.mapping.WrappedException;
import gnu.text.Path;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import javax.imageio.ImageIO;

// Referenced classes of package gnu.kawa.models:
//            Model, Paintable, Display, WithTransform

public class DrawImage extends Model
    implements Paintable, Serializable
{

    String description;
    BufferedImage image;
    Path src;

    public DrawImage()
    {
    }

    public DrawImage(BufferedImage bufferedimage)
    {
        image = bufferedimage;
    }

    public Rectangle2D getBounds2D()
    {
        loadImage();
        int i = image.getWidth();
        int j = image.getHeight();
        return new java.awt.geom.Rectangle2D.Float(0.0F, 0.0F, i, j);
    }

    public Image getImage()
    {
        loadImage();
        return image;
    }

    public Path getSrc()
    {
        return src;
    }

    void loadImage()
    {
        if (image != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        image = ImageIO.read(src.openInputStream());
        return;
        Throwable throwable;
        throwable;
        throw WrappedException.wrapIfNeeded(throwable);
    }

    public void makeView(Display display, Object obj)
    {
        display.addImage(this, obj);
    }

    public void paint(Graphics2D graphics2d)
    {
        loadImage();
        graphics2d.drawImage(image, null, null);
    }

    public void setSrc(Path path)
    {
        src = path;
    }

    public Paintable transform(AffineTransform affinetransform)
    {
        return new WithTransform(this, affinetransform);
    }
}
