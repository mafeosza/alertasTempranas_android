// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.Iterator;

// Referenced classes of package org.json:
//            JSONException, XMLTokener, XML, JSONArray, 
//            JSONObject

public class JSONML
{

    public JSONML()
    {
    }

    private static Object parse(XMLTokener xmltokener, boolean flag, JSONArray jsonarray)
        throws JSONException
    {
_L7:
        Object obj;
        Object obj2;
        if (!xmltokener.more())
        {
            throw xmltokener.syntaxError("Bad XML");
        }
        obj2 = xmltokener.nextContent();
        if (obj2 != XML.LT)
        {
            break MISSING_BLOCK_LABEL_703;
        }
        obj = xmltokener.nextToken();
        if (!(obj instanceof Character))
        {
            break MISSING_BLOCK_LABEL_293;
        }
        if (obj == XML.SLASH)
        {
            jsonarray = ((JSONArray) (xmltokener.nextToken()));
            if (!(jsonarray instanceof String))
            {
                throw new JSONException("Expected a closing name instead of '" + jsonarray + "'.");
            }
            if (xmltokener.nextToken() != XML.GT)
            {
                throw xmltokener.syntaxError("Misshaped close tag");
            }
            break MISSING_BLOCK_LABEL_585;
        }
        if (obj != XML.BANG) goto _L2; else goto _L1
_L1:
        int j;
        char c = xmltokener.next();
        if (c == '-')
        {
            if (xmltokener.next() == '-')
            {
                xmltokener.skipPast("-->");
            } else
            {
                xmltokener.back();
            }
            continue; /* Loop/switch isn't completed */
        }
        if (c == '[')
        {
            if (xmltokener.nextToken().equals("CDATA") && xmltokener.next() == '[')
            {
                if (jsonarray != null)
                {
                    jsonarray.put(xmltokener.nextCDATA());
                }
            } else
            {
                throw xmltokener.syntaxError("Expected 'CDATA['");
            }
            continue; /* Loop/switch isn't completed */
        }
        j = 1;
_L4:
        int i;
        obj = xmltokener.nextMeta();
        if (obj == null)
        {
            throw xmltokener.syntaxError("Missing '>' after '<!'.");
        }
        if (obj != XML.LT)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j + 1;
_L5:
        j = i;
        if (i <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L4; else goto _L3
_L3:
        i = j;
        if (obj == XML.GT)
        {
            i = j - 1;
        }
          goto _L5
        if (true) goto _L4; else goto _L2
_L2:
        if (obj == XML.QUEST)
        {
            xmltokener.skipPast("?>");
        } else
        {
            throw xmltokener.syntaxError("Misshaped tag");
        }
        continue; /* Loop/switch isn't completed */
        String s;
        JSONObject jsonobject;
        if (!(obj instanceof String))
        {
            throw xmltokener.syntaxError("Bad tagName '" + obj + "'.");
        }
        s = (String)obj;
        obj2 = new JSONArray();
        jsonobject = new JSONObject();
        if (flag)
        {
            ((JSONArray) (obj2)).put(s);
            if (jsonarray != null)
            {
                jsonarray.put(obj2);
            }
        } else
        {
            jsonobject.put("tagName", s);
            if (jsonarray != null)
            {
                jsonarray.put(jsonobject);
            }
        }
        obj = null;
        do
        {
            if (obj == null)
            {
                obj = xmltokener.nextToken();
            }
            if (obj == null)
            {
                throw xmltokener.syntaxError("Misshaped tag");
            }
            if (!(obj instanceof String))
            {
                if (flag && jsonobject.length() > 0)
                {
                    ((JSONArray) (obj2)).put(jsonobject);
                }
                if (obj != XML.SLASH)
                {
                    break MISSING_BLOCK_LABEL_590;
                }
                if (xmltokener.nextToken() != XML.GT)
                {
                    throw xmltokener.syntaxError("Misshaped tag");
                }
                break;
            }
            String s1 = (String)obj;
            if (!flag && ("tagName".equals(s1) || "childNode".equals(s1)))
            {
                throw xmltokener.syntaxError("Reserved attribute.");
            }
            obj = xmltokener.nextToken();
            if (obj == XML.EQ)
            {
                obj = xmltokener.nextToken();
                if (!(obj instanceof String))
                {
                    throw xmltokener.syntaxError("Missing value");
                }
                jsonobject.accumulate(s1, XML.stringToValue((String)obj));
                obj = null;
            } else
            {
                jsonobject.accumulate(s1, "");
            }
        } while (true);
        if (jsonarray != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_587;
        }
        jsonarray = ((JSONArray) (obj2));
        return jsonarray;
        return jsonobject;
        if (obj != XML.GT)
        {
            throw xmltokener.syntaxError("Misshaped tag");
        }
        obj = (String)parse(xmltokener, flag, ((JSONArray) (obj2)));
        if (obj != null)
        {
            if (!((String) (obj)).equals(s))
            {
                throw xmltokener.syntaxError("Mismatched '" + s + "' and '" + obj + "'");
            }
            if (!flag && ((JSONArray) (obj2)).length() > 0)
            {
                jsonobject.put("childNodes", obj2);
            }
            if (jsonarray == null)
            {
                if (flag)
                {
                    return obj2;
                } else
                {
                    return jsonobject;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        if (jsonarray != null)
        {
            Object obj1 = obj2;
            if (obj2 instanceof String)
            {
                obj1 = XML.stringToValue((String)obj2);
            }
            jsonarray.put(obj1);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static JSONArray toJSONArray(String s)
        throws JSONException
    {
        return toJSONArray(new XMLTokener(s));
    }

    public static JSONArray toJSONArray(XMLTokener xmltokener)
        throws JSONException
    {
        return (JSONArray)parse(xmltokener, true, null);
    }

    public static JSONObject toJSONObject(String s)
        throws JSONException
    {
        return toJSONObject(new XMLTokener(s));
    }

    public static JSONObject toJSONObject(XMLTokener xmltokener)
        throws JSONException
    {
        return (JSONObject)parse(xmltokener, false, null);
    }

    public static String toString(JSONArray jsonarray)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = jsonarray.getString(0);
        XML.noSpace(s);
        s = XML.escape(s);
        stringbuffer.append('<');
        stringbuffer.append(s);
        Object obj = jsonarray.opt(1);
        int i;
        if (obj instanceof JSONObject)
        {
            byte byte0 = 2;
            obj = (JSONObject)obj;
            Iterator iterator = ((JSONObject) (obj)).keys();
            do
            {
                i = byte0;
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = iterator.next().toString();
                XML.noSpace(s1);
                String s2 = ((JSONObject) (obj)).optString(s1);
                if (s2 != null)
                {
                    stringbuffer.append(' ');
                    stringbuffer.append(XML.escape(s1));
                    stringbuffer.append('=');
                    stringbuffer.append('"');
                    stringbuffer.append(XML.escape(s2));
                    stringbuffer.append('"');
                }
            } while (true);
        } else
        {
            i = 1;
        }
        int k = jsonarray.length();
        if (i >= k)
        {
            stringbuffer.append('/');
            stringbuffer.append('>');
        } else
        {
            stringbuffer.append('>');
            do
            {
                Object obj1 = jsonarray.get(i);
                int j = i + 1;
                if (obj1 != null)
                {
                    if (obj1 instanceof String)
                    {
                        stringbuffer.append(XML.escape(obj1.toString()));
                    } else
                    if (obj1 instanceof JSONObject)
                    {
                        stringbuffer.append(toString((JSONObject)obj1));
                    } else
                    if (obj1 instanceof JSONArray)
                    {
                        stringbuffer.append(toString((JSONArray)obj1));
                    }
                }
                i = j;
            } while (j < k);
            stringbuffer.append('<');
            stringbuffer.append('/');
            stringbuffer.append(s);
            stringbuffer.append('>');
        }
        return stringbuffer.toString();
    }

    public static String toString(JSONObject jsonobject)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s = jsonobject.optString("tagName");
        if (s == null)
        {
            return XML.escape(jsonobject.toString());
        }
        XML.noSpace(s);
        s = XML.escape(s);
        stringbuffer.append('<');
        stringbuffer.append(s);
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s1 = iterator.next().toString();
            if (!"tagName".equals(s1) && !"childNodes".equals(s1))
            {
                XML.noSpace(s1);
                String s2 = jsonobject.optString(s1);
                if (s2 != null)
                {
                    stringbuffer.append(' ');
                    stringbuffer.append(XML.escape(s1));
                    stringbuffer.append('=');
                    stringbuffer.append('"');
                    stringbuffer.append(XML.escape(s2));
                    stringbuffer.append('"');
                }
            }
        } while (true);
        jsonobject = jsonobject.optJSONArray("childNodes");
        if (jsonobject == null)
        {
            stringbuffer.append('/');
            stringbuffer.append('>');
        } else
        {
            stringbuffer.append('>');
            int j = jsonobject.length();
            int i = 0;
            while (i < j) 
            {
                Object obj = jsonobject.get(i);
                if (obj != null)
                {
                    if (obj instanceof String)
                    {
                        stringbuffer.append(XML.escape(obj.toString()));
                    } else
                    if (obj instanceof JSONObject)
                    {
                        stringbuffer.append(toString((JSONObject)obj));
                    } else
                    if (obj instanceof JSONArray)
                    {
                        stringbuffer.append(toString((JSONArray)obj));
                    } else
                    {
                        stringbuffer.append(obj.toString());
                    }
                }
                i++;
            }
            stringbuffer.append('<');
            stringbuffer.append('/');
            stringbuffer.append(s);
            stringbuffer.append('>');
        }
        return stringbuffer.toString();
    }
}
