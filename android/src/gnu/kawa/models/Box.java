// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import gnu.math.IntNum;
import java.awt.Dimension;
import java.io.Serializable;

// Referenced classes of package gnu.kawa.models:
//            Model, Viewable, Display, Spacer

public abstract class Box extends Model
    implements Viewable, Serializable
{

    Viewable cellSpacing;
    Viewable components[];
    int numComponents;

    public Box()
    {
    }

    public void add(Viewable viewable)
    {
        Viewable aviewable[];
        int i;
        aviewable = components;
        i = numComponents;
        if (i != 0) goto _L2; else goto _L1
_L1:
        components = new Viewable[4];
_L4:
        components[i] = viewable;
        numComponents = i + 1;
        return;
_L2:
        if (aviewable.length <= i)
        {
            components = new Viewable[i * 2];
            System.arraycopy(aviewable, 0, components, 0, i);
            aviewable = components;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public abstract int getAxis();

    public Viewable getCellSpacing()
    {
        return cellSpacing;
    }

    public final Viewable getComponent(int i)
    {
        return components[i];
    }

    public final int getComponentCount()
    {
        return numComponents;
    }

    public void makeView(Display display, Object obj)
    {
        display.addBox(this, obj);
    }

    public void setCellSpacing(Object obj)
    {
        if ((obj instanceof IntNum) || (obj instanceof Integer))
        {
            int i = ((Number)obj).intValue();
            if (getAxis() == 0)
            {
                obj = new Dimension(i, 0);
            } else
            {
                obj = new Dimension(0, i);
            }
            cellSpacing = Spacer.rigidArea(((java.awt.geom.Dimension2D) (obj)));
            return;
        } else
        {
            cellSpacing = (Viewable)obj;
            return;
        }
    }
}
