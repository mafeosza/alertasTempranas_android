// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

// Referenced classes of package org.json:
//            JSONException, JSONObject

public class Property
{

    public Property()
    {
    }

    public static JSONObject toJSONObject(Properties properties)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        if (properties != null && !properties.isEmpty())
        {
            String s;
            for (Enumeration enumeration = properties.propertyNames(); enumeration.hasMoreElements(); jsonobject.put(s, properties.getProperty(s)))
            {
                s = (String)enumeration.nextElement();
            }

        }
        return jsonobject;
    }

    public static Properties toProperties(JSONObject jsonobject)
        throws JSONException
    {
        Properties properties = new Properties();
        if (jsonobject != null)
        {
            String s;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext(); properties.put(s, jsonobject.getString(s)))
            {
                s = iterator.next().toString();
            }

        }
        return properties;
    }
}
