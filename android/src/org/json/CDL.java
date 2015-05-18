// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;


// Referenced classes of package org.json:
//            JSONException, JSONTokener, JSONArray, JSONObject

public class CDL
{

    public CDL()
    {
    }

    private static String getValue(JSONTokener jsontokener)
        throws JSONException
    {
        char c;
        do
        {
            c = jsontokener.next();
        } while (c == ' ' || c == '\t');
        switch (c)
        {
        default:
            jsontokener.back();
            return jsontokener.nextTo(',');

        case 0: // '\0'
            return null;

        case 34: // '"'
        case 39: // '\''
            StringBuffer stringbuffer = new StringBuffer();
            do
            {
                char c1 = jsontokener.next();
                if (c1 == c)
                {
                    return stringbuffer.toString();
                }
                if (c1 == 0 || c1 == '\n' || c1 == '\r')
                {
                    throw jsontokener.syntaxError("Missing close quote '" + c + "'.");
                }
                stringbuffer.append(c1);
            } while (true);

        case 44: // ','
            jsontokener.back();
            return "";
        }
    }

    public static JSONArray rowToJSONArray(JSONTokener jsontokener)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
_L4:
        char c;
        Object obj;
        obj = getValue(jsontokener);
        c = jsontokener.next();
        if (obj != null && (jsonarray.length() != 0 || ((String) (obj)).length() != 0 || c == ',')) goto _L2; else goto _L1
_L1:
        obj = null;
_L5:
        return ((JSONArray) (obj));
_L2:
        jsonarray.put(obj);
_L6:
        if (c == ',') goto _L4; else goto _L3
_L3:
label0:
        {
            if (c == ' ')
            {
                break label0;
            }
            obj = jsonarray;
            if (c != '\n')
            {
                obj = jsonarray;
                if (c != '\r')
                {
                    obj = jsonarray;
                    if (c != 0)
                    {
                        throw jsontokener.syntaxError("Bad character '" + c + "' (" + (int)c + ").");
                    }
                }
            }
        }
          goto _L5
        c = jsontokener.next();
          goto _L6
    }

    public static JSONObject rowToJSONObject(JSONArray jsonarray, JSONTokener jsontokener)
        throws JSONException
    {
        jsontokener = rowToJSONArray(jsontokener);
        if (jsontokener != null)
        {
            return jsontokener.toJSONObject(jsonarray);
        } else
        {
            return null;
        }
    }

    public static String rowToString(JSONArray jsonarray)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        while (i < jsonarray.length()) 
        {
            if (i > 0)
            {
                stringbuffer.append(',');
            }
            Object obj = jsonarray.opt(i);
            if (obj != null)
            {
                obj = obj.toString();
                if (((String) (obj)).length() > 0 && (((String) (obj)).indexOf(',') >= 0 || ((String) (obj)).indexOf('\n') >= 0 || ((String) (obj)).indexOf('\r') >= 0 || ((String) (obj)).indexOf('\0') >= 0 || ((String) (obj)).charAt(0) == '"'))
                {
                    stringbuffer.append('"');
                    int k = ((String) (obj)).length();
                    for (int j = 0; j < k; j++)
                    {
                        char c = ((String) (obj)).charAt(j);
                        if (c >= ' ' && c != '"')
                        {
                            stringbuffer.append(c);
                        }
                    }

                    stringbuffer.append('"');
                } else
                {
                    stringbuffer.append(((String) (obj)));
                }
            }
            i++;
        }
        stringbuffer.append('\n');
        return stringbuffer.toString();
    }

    public static JSONArray toJSONArray(String s)
        throws JSONException
    {
        return toJSONArray(new JSONTokener(s));
    }

    public static JSONArray toJSONArray(JSONArray jsonarray, String s)
        throws JSONException
    {
        return toJSONArray(jsonarray, new JSONTokener(s));
    }

    public static JSONArray toJSONArray(JSONArray jsonarray, JSONTokener jsontokener)
        throws JSONException
    {
        if (jsonarray != null && jsonarray.length() != 0) goto _L2; else goto _L1
_L1:
        jsonarray = null;
_L4:
        return jsonarray;
_L2:
        JSONArray jsonarray1 = new JSONArray();
        do
        {
            JSONObject jsonobject;
label0:
            {
                jsonobject = rowToJSONObject(jsonarray, jsontokener);
                if (jsonobject != null)
                {
                    break label0;
                }
                jsonarray = jsonarray1;
                if (jsonarray1.length() == 0)
                {
                    return null;
                }
            }
            if (true)
            {
                continue;
            }
            jsonarray1.put(jsonobject);
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static JSONArray toJSONArray(JSONTokener jsontokener)
        throws JSONException
    {
        return toJSONArray(rowToJSONArray(jsontokener), jsontokener);
    }

    public static String toString(JSONArray jsonarray)
        throws JSONException
    {
        Object obj = jsonarray.optJSONObject(0);
        if (obj != null)
        {
            obj = ((JSONObject) (obj)).names();
            if (obj != null)
            {
                return rowToString(((JSONArray) (obj))) + toString(((JSONArray) (obj)), jsonarray);
            }
        }
        return null;
    }

    public static String toString(JSONArray jsonarray, JSONArray jsonarray1)
        throws JSONException
    {
        if (jsonarray == null || jsonarray.length() == 0)
        {
            return null;
        }
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < jsonarray1.length(); i++)
        {
            JSONObject jsonobject = jsonarray1.optJSONObject(i);
            if (jsonobject != null)
            {
                stringbuffer.append(rowToString(jsonobject.toJSONArray(jsonarray)));
            }
        }

        return stringbuffer.toString();
    }
}
