// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

// Referenced classes of package gnu.kawa.models:
//            Paintable

public class WithComposite
    implements Paintable
{

    Composite composite[];
    Paintable paintable[];

    public WithComposite()
    {
    }

    public static WithComposite make(Paintable paintable1, Composite composite1)
    {
        WithComposite withcomposite = new WithComposite();
        withcomposite.paintable = (new Paintable[] {
            paintable1
        });
        withcomposite.composite = (new Composite[] {
            composite1
        });
        return withcomposite;
    }

    public static WithComposite make(Paintable apaintable[], Composite acomposite[])
    {
        WithComposite withcomposite = new WithComposite();
        withcomposite.paintable = apaintable;
        withcomposite.composite = acomposite;
        return withcomposite;
    }

    public static WithComposite make(Object aobj[])
    {
        int j = 0;
        int i = aobj.length;
        do
        {
            int k = i - 1;
            if (k < 0)
            {
                break;
            }
            i = k;
            if (aobj[k] instanceof Paintable)
            {
                j++;
                i = k;
            }
        } while (true);
        Paintable apaintable[] = new Paintable[j];
        Composite acomposite[] = new Composite[j];
        Composite composite1 = null;
        j = 0;
        i = 0;
        while (i < aobj.length) 
        {
            Object obj = aobj[i];
            if (obj instanceof Paintable)
            {
                apaintable[j] = (Paintable)aobj[i];
                acomposite[j] = composite1;
                j++;
            } else
            {
                composite1 = (Composite)obj;
            }
            i++;
        }
        return make(apaintable, acomposite);
    }

    public Rectangle2D getBounds2D()
    {
        int j = paintable.length;
        if (j != 0) goto _L2; else goto _L1
_L1:
        Rectangle2D rectangle2d1 = null;
_L4:
        return rectangle2d1;
_L2:
        Rectangle2D rectangle2d = paintable[0].getBounds2D();
        int i = 1;
        do
        {
            rectangle2d1 = rectangle2d;
            if (i >= j)
            {
                continue;
            }
            rectangle2d = rectangle2d.createUnion(paintable[i].getBounds2D());
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void paint(Graphics2D graphics2d)
    {
        Composite composite1;
        Composite composite2;
        Composite composite4;
        composite4 = graphics2d.getComposite();
        composite2 = composite4;
        composite1 = composite2;
        int j = paintable.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        composite1 = composite2;
        Composite composite5 = composite[i];
        Composite composite3;
        composite3 = composite2;
        if (composite5 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        composite3 = composite2;
        if (composite5 == composite2)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        composite1 = composite2;
        graphics2d.setComposite(composite5);
        composite3 = composite5;
        composite1 = composite3;
        paintable[i].paint(graphics2d);
        i++;
        composite2 = composite3;
        if (true) goto _L2; else goto _L1
_L1:
        if (composite2 != composite4)
        {
            graphics2d.setComposite(composite4);
        }
        return;
        Exception exception;
        exception;
        if (composite1 != composite4)
        {
            graphics2d.setComposite(composite4);
        }
        throw exception;
    }

    public Paintable transform(AffineTransform affinetransform)
    {
        int j = paintable.length;
        Paintable apaintable[] = new Paintable[j];
        for (int i = 0; i < j; i++)
        {
            apaintable[i] = paintable[i].transform(affinetransform);
        }

        return make(apaintable, composite);
    }
}
