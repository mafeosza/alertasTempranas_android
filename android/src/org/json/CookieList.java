// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.Iterator;

// Referenced classes of package org.json:
//            JSONException, JSONObject, JSONTokener, Cookie

public class CookieList
{

    public CookieList()
    {
    }

    public static JSONObject toJSONObject(String s)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        for (s = new JSONTokener(s); s.more(); s.next())
        {
            String s1 = Cookie.unescape(s.nextTo('='));
            s.next('=');
            jsonobject.put(s1, Cookie.unescape(s.nextTo(';')));
        }

        return jsonobject;
    }

    public static String toString(JSONObject jsonobject)
        throws JSONException
    {
        boolean flag = false;
        Iterator iterator = jsonobject.keys();
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = iterator.next().toString();
            if (!jsonobject.isNull(s))
            {
                if (flag)
                {
                    stringbuffer.append(';');
                }
                stringbuffer.append(Cookie.escape(s));
                stringbuffer.append("=");
                stringbuffer.append(Cookie.escape(jsonobject.getString(s)));
                flag = true;
            }
        } while (true);
        return stringbuffer.toString();
    }
}
