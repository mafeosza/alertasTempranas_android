// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import gnu.lists.FString;
import gnu.mapping.ThreadLocation;
import gnu.mapping.WrappedException;
import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.lang.reflect.Method;

// Referenced classes of package gnu.kawa.models:
//            Label, Model, Box, Button, 
//            DrawImage, Spacer, Text, Window

public abstract class Display
{

    public static ThreadLocation myDisplay = new ThreadLocation("my-display");

    public Display()
    {
    }

    public static Dimension asDimension(Dimension2D dimension2d)
    {
        if ((dimension2d instanceof Dimension) || dimension2d == null)
        {
            return (Dimension)dimension2d;
        } else
        {
            return new Dimension((int)(dimension2d.getWidth() + 0.5D), (int)(dimension2d.getHeight() + 0.5D));
        }
    }

    public static Display getInstance()
    {
        Object obj;
        String s;
        String s1;
        Object obj2;
        obj2 = myDisplay.get(null);
        if (obj2 instanceof Display)
        {
            return (Display)obj2;
        }
        int i;
        if (obj2 == null)
        {
            obj = "swing";
        } else
        {
            obj = obj2.toString();
        }
_L6:
        i = ((String) (obj)).indexOf(',');
        s = null;
        s1 = ((String) (obj));
        if (i >= 0)
        {
            s = ((String) (obj)).substring(i + 1);
            s1 = ((String) (obj)).substring(0, i);
        }
        if (!s1.equals("swing")) goto _L2; else goto _L1
_L1:
        obj = "gnu.kawa.swingviews.SwingDisplay";
_L4:
        obj = (Display)Class.forName(((String) (obj))).getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        return ((Display) (obj));
_L2:
        if (s1.equals("swt"))
        {
            obj = "gnu.kawa.swtviews.SwtDisplay";
        } else
        {
            obj = s1;
            if (s1.equals("echo2"))
            {
                obj = "gnu.kawa.echo2.Echo2Display";
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        Object obj1;
        obj1;
        if (s == null)
        {
            throw new RuntimeException((new StringBuilder()).append("no display toolkit: ").append(obj2).toString());
        }
        obj1 = s;
        continue; /* Loop/switch isn't completed */
        obj1;
        throw WrappedException.wrapIfNeeded(((Throwable) (obj1)));
        if (true) goto _L6; else goto _L5
_L5:
    }

    public abstract void addBox(Box box, Object obj);

    public abstract void addButton(Button button, Object obj);

    public abstract void addImage(DrawImage drawimage, Object obj);

    public abstract void addLabel(Label label, Object obj);

    public void addSpacer(Spacer spacer, Object obj)
    {
        throw new Error("makeView called on Spacer");
    }

    public void addText(Text text, Object obj)
    {
        throw new Error("makeView called on Text");
    }

    public abstract void addView(Object obj, Object obj1);

    public Model coerceToModel(Object obj)
    {
        if ((obj instanceof FString) || (obj instanceof String))
        {
            return new Label(obj.toString());
        } else
        {
            return (Model)obj;
        }
    }

    public abstract Window makeWindow();

}
