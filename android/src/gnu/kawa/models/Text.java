// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import gnu.lists.CharBuffer;
import java.io.Serializable;

// Referenced classes of package gnu.kawa.models:
//            Model, Viewable, Display

public class Text extends Model
    implements Viewable, Serializable
{

    public final CharBuffer buffer;

    public Text()
    {
        this("");
    }

    public Text(String s)
    {
        buffer = new CharBuffer(100);
        buffer.gapEnd = 99;
        buffer.getArray()[buffer.gapEnd] = '\n';
        setText(s);
    }

    public CharBuffer getBuffer()
    {
        return buffer;
    }

    public String getText()
    {
        int i = buffer.size() - 1;
        int j = buffer.getSegment(0, i);
        return new String(buffer.getArray(), j, i);
    }

    public void makeView(Display display, Object obj)
    {
        display.addText(this, obj);
    }

    public void setText(String s)
    {
        int i = buffer.size() - 1;
        if (i > 0)
        {
            buffer.delete(0, i);
        }
        buffer.insert(0, s, false);
        notifyListeners("text");
    }
}
