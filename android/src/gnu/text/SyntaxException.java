// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.text;

import java.io.PrintWriter;

// Referenced classes of package gnu.text:
//            SourceMessages, SourceError

public class SyntaxException extends Exception
{

    String header;
    public int maxToPrint;
    SourceMessages messages;

    public SyntaxException(SourceMessages sourcemessages)
    {
        maxToPrint = 10;
        messages = sourcemessages;
    }

    public SyntaxException(String s, SourceMessages sourcemessages)
    {
        maxToPrint = 10;
        header = s;
        messages = sourcemessages;
    }

    public void clear()
    {
        messages.clear();
    }

    public final String getHeader()
    {
        return header;
    }

    public String getMessage()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (header != null)
        {
            stringbuffer.append(header);
        }
        int i = maxToPrint;
        SourceError sourceerror = messages.firstError;
        do
        {
            if (sourceerror == null)
            {
                break;
            }
            i--;
            if (i < 0)
            {
                break;
            }
            stringbuffer.append('\n');
            stringbuffer.append(sourceerror);
            sourceerror = sourceerror.next;
        } while (true);
        return stringbuffer.toString();
    }

    public SourceMessages getMessages()
    {
        return messages;
    }

    public void printAll(PrintWriter printwriter, int i)
    {
        if (header != null)
        {
            printwriter.println(header);
        }
        messages.printAll(printwriter, i);
    }

    public final void setHeader(String s)
    {
        header = s;
    }
}
