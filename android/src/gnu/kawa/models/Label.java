// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.io.Serializable;

// Referenced classes of package gnu.kawa.models:
//            Model, Viewable, Display

public class Label extends Model
    implements Viewable, Serializable
{

    String text;

    public Label()
    {
    }

    public Label(String s)
    {
        text = s;
    }

    public String getText()
    {
        return text;
    }

    public void makeView(Display display, Object obj)
    {
        display.addLabel(this, obj);
    }

    public void setText(String s)
    {
        text = s;
        notifyListeners("text");
    }
}
