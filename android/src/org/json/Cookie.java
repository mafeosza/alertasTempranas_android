// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;


// Referenced classes of package org.json:
//            JSONException, JSONObject, JSONTokener

public class Cookie
{

    public Cookie()
    {
    }

    public static String escape(String s)
    {
        s = s.trim();
        StringBuffer stringbuffer = new StringBuffer();
        int j = s.length();
        int i = 0;
        while (i < j) 
        {
            char c = s.charAt(i);
            if (c < ' ' || c == '+' || c == '%' || c == '=' || c == ';')
            {
                stringbuffer.append('%');
                stringbuffer.append(Character.forDigit((char)(c >>> 4 & 0xf), 16));
                stringbuffer.append(Character.forDigit((char)(c & 0xf), 16));
            } else
            {
                stringbuffer.append(c);
            }
            i++;
        }
        return stringbuffer.toString();
    }

    public static JSONObject toJSONObject(String s)
        throws JSONException
    {
        JSONObject jsonobject;
        JSONTokener jsontokener;
        jsonobject = new JSONObject();
        jsontokener = new JSONTokener(s);
        jsonobject.put("name", jsontokener.nextTo('='));
        jsontokener.next('=');
        jsonobject.put("value", jsontokener.nextTo(';'));
        jsontokener.next();
_L2:
        String s1;
        if (!jsontokener.more())
        {
            break MISSING_BLOCK_LABEL_129;
        }
        s1 = unescape(jsontokener.nextTo("=;"));
        if (jsontokener.next() == '=')
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (!s1.equals("secure"))
        {
            break; /* Loop/switch isn't completed */
        }
        s = Boolean.TRUE;
_L3:
        jsonobject.put(s1, s);
        if (true) goto _L2; else goto _L1
_L1:
        throw jsontokener.syntaxError("Missing '=' in cookie parameter.");
        s = unescape(jsontokener.nextTo(';'));
        jsontokener.next();
          goto _L3
        return jsonobject;
    }

    public static String toString(JSONObject jsonobject)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(escape(jsonobject.getString("name")));
        stringbuffer.append("=");
        stringbuffer.append(escape(jsonobject.getString("value")));
        if (jsonobject.has("expires"))
        {
            stringbuffer.append(";expires=");
            stringbuffer.append(jsonobject.getString("expires"));
        }
        if (jsonobject.has("domain"))
        {
            stringbuffer.append(";domain=");
            stringbuffer.append(escape(jsonobject.getString("domain")));
        }
        if (jsonobject.has("path"))
        {
            stringbuffer.append(";path=");
            stringbuffer.append(escape(jsonobject.getString("path")));
        }
        if (jsonobject.optBoolean("secure"))
        {
            stringbuffer.append(";secure");
        }
        return stringbuffer.toString();
    }

    public static String unescape(String s)
    {
        int k = s.length();
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        while (i < k) 
        {
            char c1 = s.charAt(i);
            char c;
            int j;
            if (c1 == '+')
            {
                c = ' ';
                j = i;
            } else
            {
                c = c1;
                j = i;
                if (c1 == '%')
                {
                    c = c1;
                    j = i;
                    if (i + 2 < k)
                    {
                        int l = JSONTokener.dehexchar(s.charAt(i + 1));
                        int i1 = JSONTokener.dehexchar(s.charAt(i + 2));
                        c = c1;
                        j = i;
                        if (l >= 0)
                        {
                            c = c1;
                            j = i;
                            if (i1 >= 0)
                            {
                                c = (char)(l * 16 + i1);
                                j = i + 2;
                            }
                        }
                    }
                }
            }
            stringbuffer.append(c);
            i = j + 1;
        }
        return stringbuffer.toString();
    }
}
