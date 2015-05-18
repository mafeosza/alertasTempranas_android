// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.io.Serializable;

// Referenced classes of package gnu.kawa.models:
//            Model, Viewable, Display

public class Spacer extends Model
    implements Viewable, Serializable
{

    Dimension2D maxSize;
    Dimension2D minSize;
    Dimension2D preferredSize;

    public Spacer()
    {
    }

    public static Spacer rigidArea(int i, int j)
    {
        return rigidArea(((Dimension2D) (new Dimension(i, j))));
    }

    public static Spacer rigidArea(Dimension2D dimension2d)
    {
        Spacer spacer = new Spacer();
        spacer.minSize = dimension2d;
        spacer.maxSize = dimension2d;
        spacer.preferredSize = dimension2d;
        return spacer;
    }

    public Dimension getMaximumSize()
    {
        return Display.asDimension(maxSize);
    }

    public Dimension2D getMaximumSize2D()
    {
        return maxSize;
    }

    public Dimension getMinimumSize()
    {
        return Display.asDimension(minSize);
    }

    public Dimension2D getMinimumSize2D()
    {
        return minSize;
    }

    public Dimension getPreferredSize()
    {
        return Display.asDimension(preferredSize);
    }

    public Dimension2D getPreferredSize2D()
    {
        return preferredSize;
    }

    public boolean isRigid()
    {
        while (minSize == maxSize || minSize != null && maxSize != null && minSize.getWidth() == maxSize.getWidth() && minSize.getHeight() == maxSize.getHeight()) 
        {
            return true;
        }
        return false;
    }

    public void makeView(Display display, Object obj)
    {
        display.addSpacer(this, obj);
    }
}
