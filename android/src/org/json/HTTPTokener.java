// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;


// Referenced classes of package org.json:
//            JSONTokener, JSONException

public class HTTPTokener extends JSONTokener
{

    public HTTPTokener(String s)
    {
        super(s);
    }

    public String nextToken()
        throws JSONException
    {
        char c;
        StringBuffer stringbuffer;
label0:
        {
            stringbuffer = new StringBuffer();
            char c1;
            do
            {
                c1 = next();
            } while (Character.isWhitespace(c1));
            if (c1 != '"')
            {
                c = c1;
                if (c1 != '\'')
                {
                    break label0;
                }
            }
            do
            {
                c = next();
                if (c < ' ')
                {
                    throw syntaxError("Unterminated string.");
                }
                if (c == c1)
                {
                    return stringbuffer.toString();
                }
                stringbuffer.append(c);
            } while (true);
        }
        for (; c != 0 && !Character.isWhitespace(c); c = next())
        {
            stringbuffer.append(c);
        }

        return stringbuffer.toString();
    }
}
