// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import gnu.lists.FString;
import gnu.math.IntFraction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            YailList

public class JsonUtil
{

    private JsonUtil()
    {
    }

    public static Object convertJsonItem(Object obj)
        throws JSONException
    {
        Object obj1;
        if (obj == null)
        {
            obj1 = "null";
        } else
        {
            if (obj instanceof JSONObject)
            {
                return getListFromJsonObject((JSONObject)obj);
            }
            if (obj instanceof JSONArray)
            {
                return getListFromJsonArray((JSONArray)obj);
            }
            if (obj.equals(Boolean.FALSE) || (obj instanceof String) && ((String)obj).equalsIgnoreCase("false"))
            {
                return Boolean.valueOf(false);
            }
            if (obj.equals(Boolean.TRUE) || (obj instanceof String) && ((String)obj).equalsIgnoreCase("true"))
            {
                return Boolean.valueOf(true);
            }
            obj1 = obj;
            if (!(obj instanceof Number))
            {
                return obj.toString();
            }
        }
        return obj1;
    }

    public static String getJsonRepresentation(Object obj)
        throws JSONException
    {
        if (obj == null || obj.equals(null))
        {
            return "null";
        }
        if (obj instanceof FString)
        {
            return JSONObject.quote(obj.toString());
        }
        if (obj instanceof YailList)
        {
            return ((YailList)obj).toJSONString();
        }
        if (obj instanceof IntFraction)
        {
            return JSONObject.numberToString(Double.valueOf(((IntFraction)obj).doubleValue()));
        }
        if (obj instanceof Number)
        {
            return JSONObject.numberToString((Number)obj);
        }
        if (obj instanceof Boolean)
        {
            return obj.toString();
        }
        if (obj.getClass().isArray())
        {
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("[");
            String s = "";
            Object aobj[] = (Object[])(Object[])obj;
            int j = aobj.length;
            int i = 0;
            obj = s;
            for (; i < j; i++)
            {
                Object obj1 = aobj[i];
                stringbuilder.append(((String) (obj))).append(getJsonRepresentation(obj1));
                obj = ",";
            }

            stringbuilder.append("]");
            return stringbuilder.toString();
        } else
        {
            return JSONObject.quote(obj.toString());
        }
    }

    public static List getListFromJsonArray(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(convertJsonItem(jsonarray.get(i)));
        }

        return arraylist;
    }

    public static List getListFromJsonObject(JSONObject jsonobject)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        Iterator iterator = jsonobject.keys();
        ArrayList arraylist1 = new ArrayList();
        for (; iterator.hasNext(); arraylist1.add(iterator.next())) { }
        Collections.sort(arraylist1);
        ArrayList arraylist2;
        for (Iterator iterator1 = arraylist1.iterator(); iterator1.hasNext(); arraylist.add(arraylist2))
        {
            String s = (String)iterator1.next();
            arraylist2 = new ArrayList();
            arraylist2.add(s);
            arraylist2.add(convertJsonItem(jsonobject.get(s)));
        }

        return arraylist;
    }

    public static Object getObjectFromJson(String s)
        throws JSONException
    {
        if (s == null || s.equals(""))
        {
            s = "";
        } else
        {
            Object obj = (new JSONTokener(s)).nextValue();
            if (obj == null || obj.equals(null))
            {
                return null;
            }
            s = ((String) (obj));
            if (!(obj instanceof String))
            {
                s = ((String) (obj));
                if (!(obj instanceof Number))
                {
                    s = ((String) (obj));
                    if (!(obj instanceof Boolean))
                    {
                        if (obj instanceof JSONArray)
                        {
                            return getListFromJsonArray((JSONArray)obj);
                        }
                        if (obj instanceof JSONObject)
                        {
                            return getListFromJsonObject((JSONObject)obj);
                        } else
                        {
                            throw new JSONException("Invalid JSON string.");
                        }
                    }
                }
            }
        }
        return s;
    }

    public static List getStringListFromJsonArray(JSONArray jsonarray)
        throws JSONException
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            arraylist.add(jsonarray.getString(i));
        }

        return arraylist;
    }
}
