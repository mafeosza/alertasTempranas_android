// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.util.Iterator;

// Referenced classes of package org.json:
//            JSONException, XMLTokener, JSONObject, JSONArray

public class XML
{

    public static final Character AMP = new Character('&');
    public static final Character APOS = new Character('\'');
    public static final Character BANG = new Character('!');
    public static final Character EQ = new Character('=');
    public static final Character GT = new Character('>');
    public static final Character LT = new Character('<');
    public static final Character QUEST = new Character('?');
    public static final Character QUOT = new Character('"');
    public static final Character SLASH = new Character('/');

    public XML()
    {
    }

    public static String escape(String s)
    {
        StringBuffer stringbuffer;
        int i;
        int j;
        stringbuffer = new StringBuffer();
        i = 0;
        j = s.length();
_L8:
        char c;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        c = s.charAt(i);
        c;
        JVM INSTR lookupswitch 5: default 80
    //                   34: 123
    //                   38: 93
    //                   39: 133
    //                   60: 103
    //                   62: 113;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_133;
_L3:
        break; /* Loop/switch isn't completed */
_L1:
        stringbuffer.append(c);
_L9:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
        stringbuffer.append("&amp;");
          goto _L9
_L5:
        stringbuffer.append("&lt;");
          goto _L9
_L6:
        stringbuffer.append("&gt;");
          goto _L9
_L2:
        stringbuffer.append("&quot;");
          goto _L9
        stringbuffer.append("&apos;");
          goto _L9
        return stringbuffer.toString();
    }

    public static void noSpace(String s)
        throws JSONException
    {
        int j = s.length();
        if (j == 0)
        {
            throw new JSONException("Empty string.");
        }
        for (int i = 0; i < j; i++)
        {
            if (Character.isWhitespace(s.charAt(i)))
            {
                throw new JSONException("'" + s + "' contains a space character.");
            }
        }

    }

    private static boolean parse(XMLTokener xmltokener, JSONObject jsonobject, String s)
        throws JSONException
    {
        Object obj = xmltokener.nextToken();
        if (obj != BANG) goto _L2; else goto _L1
_L1:
        int i = xmltokener.next();
        if (i != '-') goto _L4; else goto _L3
_L3:
        if (xmltokener.next() != '-') goto _L6; else goto _L5
_L5:
        xmltokener.skipPast("-->");
_L8:
        return false;
_L6:
        xmltokener.back();
        break MISSING_BLOCK_LABEL_47;
_L4:
        if (i == '[')
        {
            if ("CDATA".equals(xmltokener.nextToken()) && xmltokener.next() == '[')
            {
                xmltokener = xmltokener.nextCDATA();
                if (xmltokener.length() > 0)
                {
                    jsonobject.accumulate("content", xmltokener);
                    return false;
                }
            } else
            {
                throw xmltokener.syntaxError("Expected 'CDATA['");
            }
            continue; /* Loop/switch isn't completed */
        }
        int j = 1;
        do
        {
            jsonobject = ((JSONObject) (xmltokener.nextMeta()));
            if (jsonobject == null)
            {
                throw xmltokener.syntaxError("Missing '>' after '<!'.");
            }
            if (jsonobject == LT)
            {
                i = j + 1;
            } else
            {
                i = j;
                if (jsonobject == GT)
                {
                    i = j - 1;
                }
            }
            j = i;
            if (i <= 0)
            {
                return false;
            }
        } while (true);
_L2:
        if (obj == QUEST)
        {
            xmltokener.skipPast("?>");
            return false;
        }
        if (obj == SLASH)
        {
            jsonobject = ((JSONObject) (xmltokener.nextToken()));
            if (s == null)
            {
                throw xmltokener.syntaxError("Mismatched close tag " + jsonobject);
            }
            if (!jsonobject.equals(s))
            {
                throw xmltokener.syntaxError("Mismatched " + s + " and " + jsonobject);
            }
            if (xmltokener.nextToken() != GT)
            {
                throw xmltokener.syntaxError("Misshaped close tag");
            } else
            {
                return true;
            }
        }
        if (obj instanceof Character)
        {
            throw xmltokener.syntaxError("Misshaped tag");
        }
        obj = (String)obj;
        s = null;
        JSONObject jsonobject1 = new JSONObject();
        do
        {
            if (s == null)
            {
                s = ((String) (xmltokener.nextToken()));
            }
            if (!(s instanceof String))
            {
                break;
            }
            String s1 = (String)s;
            s = ((String) (xmltokener.nextToken()));
            if (s == EQ)
            {
                s = ((String) (xmltokener.nextToken()));
                if (!(s instanceof String))
                {
                    throw xmltokener.syntaxError("Missing value");
                }
                jsonobject1.accumulate(s1, stringToValue((String)s));
                s = null;
            } else
            {
                jsonobject1.accumulate(s1, "");
            }
        } while (true);
        if (s == SLASH)
        {
            if (xmltokener.nextToken() != GT)
            {
                throw xmltokener.syntaxError("Misshaped tag");
            }
            if (jsonobject1.length() > 0)
            {
                jsonobject.accumulate(((String) (obj)), jsonobject1);
                return false;
            } else
            {
                jsonobject.accumulate(((String) (obj)), "");
                return false;
            }
        }
        if (s == GT)
        {
label0:
            do
            {
                do
                {
                    s = ((String) (xmltokener.nextContent()));
                    if (s == null)
                    {
                        if (obj != null)
                        {
                            throw xmltokener.syntaxError("Unclosed tag " + obj);
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                    if (!(s instanceof String))
                    {
                        continue label0;
                    }
                    s = (String)s;
                    if (s.length() > 0)
                    {
                        jsonobject1.accumulate("content", stringToValue(s));
                    }
                } while (true);
            } while (s != LT || !parse(xmltokener, jsonobject1, ((String) (obj))));
            if (jsonobject1.length() == 0)
            {
                jsonobject.accumulate(((String) (obj)), "");
                return false;
            }
            if (jsonobject1.length() == 1 && jsonobject1.opt("content") != null)
            {
                jsonobject.accumulate(((String) (obj)), jsonobject1.opt("content"));
                return false;
            } else
            {
                jsonobject.accumulate(((String) (obj)), jsonobject1);
                return false;
            }
        }
        throw xmltokener.syntaxError("Misshaped tag");
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static Object stringToValue(String s)
    {
        if (!"true".equalsIgnoreCase(s)) goto _L2; else goto _L1
_L1:
        Object obj = Boolean.TRUE;
_L4:
        return obj;
_L2:
        if ("false".equalsIgnoreCase(s))
        {
            return Boolean.FALSE;
        }
        if ("null".equalsIgnoreCase(s))
        {
            return JSONObject.NULL;
        }
        char c = s.charAt(0);
        if (c != '-' && (c < '0' || c > '9'))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag;
        obj = new Long(s);
        flag = ((Long) (obj)).toString().equals(s);
        if (flag) goto _L4; else goto _L3
_L3:
        return s;
        Exception exception;
        exception;
        exception = new Double(s);
        flag = exception.toString().equals(s);
        if (flag)
        {
            return exception;
        }
        continue; /* Loop/switch isn't completed */
        exception;
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static JSONObject toJSONObject(String s)
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        for (s = new XMLTokener(s); s.more() && s.skipPast("<"); parse(s, jsonobject, null)) { }
        return jsonobject;
    }

    public static String toString(Object obj)
        throws JSONException
    {
        return toString(obj, null);
    }

    public static String toString(Object obj, String s)
        throws JSONException
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (obj instanceof JSONObject)
        {
            if (s != null)
            {
                stringbuffer.append('<');
                stringbuffer.append(s);
                stringbuffer.append('>');
            }
            JSONObject jsonobject = (JSONObject)obj;
            for (Iterator iterator = jsonobject.keys(); iterator.hasNext();)
            {
                String s1 = iterator.next().toString();
                Object obj1 = jsonobject.opt(s1);
                obj = obj1;
                if (obj1 == null)
                {
                    obj = "";
                }
                if (obj instanceof String)
                {
                    obj1 = (String)obj;
                }
                if ("content".equals(s1))
                {
                    if (obj instanceof JSONArray)
                    {
                        obj = (JSONArray)obj;
                        int l = ((JSONArray) (obj)).length();
                        int i = 0;
                        while (i < l) 
                        {
                            if (i > 0)
                            {
                                stringbuffer.append('\n');
                            }
                            stringbuffer.append(escape(((JSONArray) (obj)).get(i).toString()));
                            i++;
                        }
                    } else
                    {
                        stringbuffer.append(escape(obj.toString()));
                    }
                } else
                if (obj instanceof JSONArray)
                {
                    obj = (JSONArray)obj;
                    int i1 = ((JSONArray) (obj)).length();
                    int j = 0;
                    while (j < i1) 
                    {
                        Object obj2 = ((JSONArray) (obj)).get(j);
                        if (obj2 instanceof JSONArray)
                        {
                            stringbuffer.append('<');
                            stringbuffer.append(s1);
                            stringbuffer.append('>');
                            stringbuffer.append(toString(obj2));
                            stringbuffer.append("</");
                            stringbuffer.append(s1);
                            stringbuffer.append('>');
                        } else
                        {
                            stringbuffer.append(toString(obj2, s1));
                        }
                        j++;
                    }
                } else
                if ("".equals(obj))
                {
                    stringbuffer.append('<');
                    stringbuffer.append(s1);
                    stringbuffer.append("/>");
                } else
                {
                    stringbuffer.append(toString(obj, s1));
                }
            }

            if (s != null)
            {
                stringbuffer.append("</");
                stringbuffer.append(s);
                stringbuffer.append('>');
            }
            return stringbuffer.toString();
        }
        Object obj3 = obj;
        if (obj.getClass().isArray())
        {
            obj3 = new JSONArray(obj);
        }
        if (obj3 instanceof JSONArray)
        {
            obj3 = (JSONArray)obj3;
            int j1 = ((JSONArray) (obj3)).length();
            int k = 0;
            while (k < j1) 
            {
                Object obj4 = ((JSONArray) (obj3)).opt(k);
                if (s == null)
                {
                    obj = "array";
                } else
                {
                    obj = s;
                }
                stringbuffer.append(toString(obj4, ((String) (obj))));
                k++;
            }
            return stringbuffer.toString();
        }
        if (obj3 == null)
        {
            obj = "null";
        } else
        {
            obj = escape(obj3.toString());
        }
        if (s == null)
        {
            return "\"" + obj + "\"";
        }
        if (((String) (obj)).length() == 0)
        {
            return "<" + s + "/>";
        } else
        {
            return "<" + s + ">" + obj + "</" + s + ">";
        }
    }

}
