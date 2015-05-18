// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.Iterator;

// Referenced classes of package org.json:
//            JSONException, JSONObject, HTTPTokener

public class HTTP
{

    public static final String CRLF = "\r\n";

    public HTTP()
    {
    }

    public static JSONObject toJSONObject(String s)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        s = new HTTPTokener(s);
        String s1 = s.nextToken();
        if (s1.toUpperCase().startsWith("HTTP"))
        {
            jsonobject.put("HTTP-Version", s1);
            jsonobject.put("Status-Code", s.nextToken());
            jsonobject.put("Reason-Phrase", s.nextTo('\0'));
            s.next();
        } else
        {
            jsonobject.put("Method", s1);
            jsonobject.put("Request-URI", s.nextToken());
            jsonobject.put("HTTP-Version", s.nextToken());
        }
        for (; s.more(); s.next())
        {
            s1 = s.nextTo(':');
            s.next(':');
            jsonobject.put(s1, s.nextTo('\0'));
        }

        return jsonobject;
    }

    public static String toString(JSONObject jsonobject)
        throws JSONException
    {
        Iterator iterator = jsonobject.keys();
        StringBuffer stringbuffer = new StringBuffer();
        if (jsonobject.has("Status-Code") && jsonobject.has("Reason-Phrase"))
        {
            stringbuffer.append(jsonobject.getString("HTTP-Version"));
            stringbuffer.append(' ');
            stringbuffer.append(jsonobject.getString("Status-Code"));
            stringbuffer.append(' ');
            stringbuffer.append(jsonobject.getString("Reason-Phrase"));
        } else
        if (jsonobject.has("Method") && jsonobject.has("Request-URI"))
        {
            stringbuffer.append(jsonobject.getString("Method"));
            stringbuffer.append(' ');
            stringbuffer.append('"');
            stringbuffer.append(jsonobject.getString("Request-URI"));
            stringbuffer.append('"');
            stringbuffer.append(' ');
            stringbuffer.append(jsonobject.getString("HTTP-Version"));
        } else
        {
            throw new JSONException("Not enough material for an HTTP header.");
        }
        stringbuffer.append("\r\n");
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = iterator.next().toString();
            if (!"HTTP-Version".equals(s) && !"Status-Code".equals(s) && !"Reason-Phrase".equals(s) && !"Method".equals(s) && !"Request-URI".equals(s) && !jsonobject.isNull(s))
            {
                stringbuffer.append(s);
                stringbuffer.append(": ");
                stringbuffer.append(jsonobject.getString(s));
                stringbuffer.append("\r\n");
            }
        } while (true);
        stringbuffer.append("\r\n");
        return stringbuffer.toString();
    }
}
