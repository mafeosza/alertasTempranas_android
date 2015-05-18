// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.awt.Color;

// Referenced classes of package gnu.kawa.models:
//            Model, Display

public class Button extends Model
{

    Object action;
    Color background;
    boolean disabled;
    Color foreground;
    String text;
    Object width;

    public Button()
    {
    }

    public Object getAction()
    {
        return action;
    }

    public Color getBackground()
    {
        return background;
    }

    public Color getForeground()
    {
        return foreground;
    }

    public String getText()
    {
        return text;
    }

    public boolean isDisabled()
    {
        return disabled;
    }

    public void makeView(Display display, Object obj)
    {
        display.addButton(this, obj);
    }

    public void setAction(Object obj)
    {
        action = obj;
    }

    public void setBackground(Color color)
    {
        background = color;
        notifyListeners("background");
    }

    public void setDisabled(boolean flag)
    {
        disabled = flag;
    }

    public void setForeground(Color color)
    {
        foreground = color;
        notifyListeners("foreground");
    }

    public void setText(String s)
    {
        text = s;
        notifyListeners("text");
    }
}
