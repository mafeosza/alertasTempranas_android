// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.text.SourceLocator;

// Referenced classes of package gnu.mapping:
//            Location

public class UnboundLocationException extends RuntimeException
{

    int column;
    String filename;
    int line;
    Location location;
    public Object symbol;

    public UnboundLocationException()
    {
    }

    public UnboundLocationException(Location location1)
    {
        location = location1;
    }

    public UnboundLocationException(Object obj)
    {
        symbol = obj;
    }

    public UnboundLocationException(Object obj, SourceLocator sourcelocator)
    {
        symbol = obj;
        if (sourcelocator != null)
        {
            filename = sourcelocator.getFileName();
            line = sourcelocator.getLineNumber();
            column = sourcelocator.getColumnNumber();
        }
    }

    public UnboundLocationException(Object obj, String s)
    {
        super(s);
        symbol = obj;
    }

    public UnboundLocationException(Object obj, String s, int i, int j)
    {
        symbol = obj;
        filename = s;
        line = i;
        column = j;
    }

    public String getMessage()
    {
        Object obj = super.getMessage();
        if (obj != null)
        {
            return ((String) (obj));
        }
        StringBuffer stringbuffer = new StringBuffer();
        if (filename != null || line > 0)
        {
            if (filename != null)
            {
                stringbuffer.append(filename);
            }
            if (line >= 0)
            {
                stringbuffer.append(':');
                stringbuffer.append(line);
                if (column > 0)
                {
                    stringbuffer.append(':');
                    stringbuffer.append(column);
                }
            }
            stringbuffer.append(": ");
        }
        if (location == null)
        {
            obj = null;
        } else
        {
            obj = location.getKeySymbol();
        }
        if (obj != null)
        {
            stringbuffer.append("unbound location ");
            stringbuffer.append(obj);
            obj = location.getKeyProperty();
            if (obj != null)
            {
                stringbuffer.append(" (property ");
                stringbuffer.append(obj);
                stringbuffer.append(')');
            }
        } else
        if (symbol != null)
        {
            stringbuffer.append("unbound location ");
            stringbuffer.append(symbol);
        } else
        {
            stringbuffer.append("unbound location");
        }
        return stringbuffer.toString();
    }

    public void setLine(String s, int i, int j)
    {
        filename = s;
        line = i;
        column = j;
    }

    public String toString()
    {
        return getMessage();
    }
}
