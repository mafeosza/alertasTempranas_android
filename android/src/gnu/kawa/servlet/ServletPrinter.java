// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.servlet;

import gnu.kawa.xml.HttpPrinter;
import java.io.IOException;

// Referenced classes of package gnu.kawa.servlet:
//            HttpOutputStream, HttpRequestContext

public class ServletPrinter extends HttpPrinter
{

    HttpRequestContext hctx;

    public ServletPrinter(HttpRequestContext httprequestcontext, int i)
        throws IOException
    {
        super(new HttpOutputStream(httprequestcontext, i));
        hctx = httprequestcontext;
    }

    public void addHeader(String s, String s1)
    {
        if (s.equalsIgnoreCase("Content-type"))
        {
            super.sawContentType = s1;
            hctx.setContentType(s1);
        } else
        if (s.equalsIgnoreCase("Status"))
        {
            int k = s1.length();
            int j = 0;
            int i = 0;
            while (i < k) 
            {
                if (i >= k)
                {
                    hctx.statusCode = j;
                    return;
                }
                char c = s1.charAt(i);
                int i1 = Character.digit(c, 10);
                if (i1 >= 0)
                {
                    j = j * 10 + i1;
                    i++;
                } else
                {
                    int l = i;
                    if (c == ' ')
                    {
                        l = i + 1;
                    }
                    hctx.statusCode = j;
                    hctx.statusReasonPhrase = s1.substring(l);
                    return;
                }
            }
        } else
        {
            hctx.setResponseHeader(s, s1);
            return;
        }
    }

    public void printHeaders()
    {
    }

    public boolean reset(boolean flag)
    {
        return ((HttpOutputStream)ostream).reset() & super.reset(flag);
    }
}
