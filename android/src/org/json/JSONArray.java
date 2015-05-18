// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package org.json:
//            JSONException, JSONObject, JSONTokener

public class JSONArray
{

    private final ArrayList myArrayList;

    public JSONArray()
    {
        myArrayList = new ArrayList();
    }

    public JSONArray(Object obj)
        throws JSONException
    {
        this();
        if (obj.getClass().isArray())
        {
            int j = Array.getLength(obj);
            for (int i = 0; i < j; i++)
            {
                put(JSONObject.wrap(Array.get(obj, i)));
            }

        } else
        {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
    }

    public JSONArray(String s)
        throws JSONException
    {
        this(new JSONTokener(s));
    }

    public JSONArray(Collection collection)
    {
        myArrayList = new ArrayList();
        if (collection != null)
        {
            for (collection = collection.iterator(); collection.hasNext(); myArrayList.add(JSONObject.wrap(collection.next()))) { }
        }
    }

    public JSONArray(JSONTokener jsontokener)
        throws JSONException
    {
        this();
        if (jsontokener.nextClean() != '[')
        {
            throw jsontokener.syntaxError("A JSONArray text must start with '['");
        }
        if (jsontokener.nextClean() == ']') goto _L2; else goto _L1
_L1:
        jsontokener.back();
_L7:
        if (jsontokener.nextClean() == ',')
        {
            jsontokener.back();
            myArrayList.add(JSONObject.NULL);
        } else
        {
            jsontokener.back();
            myArrayList.add(jsontokener.nextValue());
        }
        jsontokener.nextClean();
        JVM INSTR lookupswitch 2: default 88
    //                   44: 114
    //                   93: 123;
           goto _L3 _L4 _L2
_L3:
        throw jsontokener.syntaxError("Expected a ',' or ']'");
_L4:
        if (jsontokener.nextClean() != ']') goto _L5; else goto _L2
_L2:
        return;
_L5:
        jsontokener.back();
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Object get(int i)
        throws JSONException
    {
        Object obj = opt(i);
        if (obj == null)
        {
            throw new JSONException("JSONArray[" + i + "] not found.");
        } else
        {
            return obj;
        }
    }

    public boolean getBoolean(int i)
        throws JSONException
    {
        Object obj = get(i);
        if (obj.equals(Boolean.FALSE) || (obj instanceof String) && ((String)obj).equalsIgnoreCase("false"))
        {
            return false;
        }
        if (obj.equals(Boolean.TRUE) || (obj instanceof String) && ((String)obj).equalsIgnoreCase("true"))
        {
            return true;
        } else
        {
            throw new JSONException("JSONArray[" + i + "] is not a boolean.");
        }
    }

    public double getDouble(int i)
        throws JSONException
    {
        Object obj = get(i);
        double d;
        try
        {
            if (obj instanceof Number)
            {
                return ((Number)obj).doubleValue();
            }
            d = Double.parseDouble((String)obj);
        }
        catch (Exception exception)
        {
            throw new JSONException("JSONArray[" + i + "] is not a number.");
        }
        return d;
    }

    public int getInt(int i)
        throws JSONException
    {
        Object obj = get(i);
        int j;
        try
        {
            if (obj instanceof Number)
            {
                return ((Number)obj).intValue();
            }
            j = Integer.parseInt((String)obj);
        }
        catch (Exception exception)
        {
            throw new JSONException("JSONArray[" + i + "] is not a number.");
        }
        return j;
    }

    public JSONArray getJSONArray(int i)
        throws JSONException
    {
        Object obj = get(i);
        if (obj instanceof JSONArray)
        {
            return (JSONArray)obj;
        } else
        {
            throw new JSONException("JSONArray[" + i + "] is not a JSONArray.");
        }
    }

    public JSONObject getJSONObject(int i)
        throws JSONException
    {
        Object obj = get(i);
        if (obj instanceof JSONObject)
        {
            return (JSONObject)obj;
        } else
        {
            throw new JSONException("JSONArray[" + i + "] is not a JSONObject.");
        }
    }

    public long getLong(int i)
        throws JSONException
    {
        Object obj = get(i);
        long l;
        try
        {
            if (obj instanceof Number)
            {
                return ((Number)obj).longValue();
            }
            l = Long.parseLong((String)obj);
        }
        catch (Exception exception)
        {
            throw new JSONException("JSONArray[" + i + "] is not a number.");
        }
        return l;
    }

    public String getString(int i)
        throws JSONException
    {
        Object obj = get(i);
        if (obj instanceof String)
        {
            return (String)obj;
        } else
        {
            throw new JSONException("JSONArray[" + i + "] not a string.");
        }
    }

    public boolean isNull(int i)
    {
        return JSONObject.NULL.equals(opt(i));
    }

    public String join(String s)
        throws JSONException
    {
        int j = length();
        StringBuffer stringbuffer = new StringBuffer();
        for (int i = 0; i < j; i++)
        {
            if (i > 0)
            {
                stringbuffer.append(s);
            }
            stringbuffer.append(JSONObject.valueToString(myArrayList.get(i)));
        }

        return stringbuffer.toString();
    }

    public int length()
    {
        return myArrayList.size();
    }

    public Object opt(int i)
    {
        if (i < 0 || i >= length())
        {
            return null;
        } else
        {
            return myArrayList.get(i);
        }
    }

    public boolean optBoolean(int i)
    {
        return optBoolean(i, false);
    }

    public boolean optBoolean(int i, boolean flag)
    {
        boolean flag1;
        try
        {
            flag1 = getBoolean(i);
        }
        catch (Exception exception)
        {
            return flag;
        }
        return flag1;
    }

    public double optDouble(int i)
    {
        return optDouble(i, (0.0D / 0.0D));
    }

    public double optDouble(int i, double d)
    {
        double d1;
        try
        {
            d1 = getDouble(i);
        }
        catch (Exception exception)
        {
            return d;
        }
        return d1;
    }

    public int optInt(int i)
    {
        return optInt(i, 0);
    }

    public int optInt(int i, int j)
    {
        try
        {
            i = getInt(i);
        }
        catch (Exception exception)
        {
            return j;
        }
        return i;
    }

    public JSONArray optJSONArray(int i)
    {
        Object obj = opt(i);
        if (obj instanceof JSONArray)
        {
            return (JSONArray)obj;
        } else
        {
            return null;
        }
    }

    public JSONObject optJSONObject(int i)
    {
        Object obj = opt(i);
        if (obj instanceof JSONObject)
        {
            return (JSONObject)obj;
        } else
        {
            return null;
        }
    }

    public long optLong(int i)
    {
        return optLong(i, 0L);
    }

    public long optLong(int i, long l)
    {
        long l1;
        try
        {
            l1 = getLong(i);
        }
        catch (Exception exception)
        {
            return l;
        }
        return l1;
    }

    public String optString(int i)
    {
        return optString(i, "");
    }

    public String optString(int i, String s)
    {
        Object obj = opt(i);
        if (JSONObject.NULL.equals(obj))
        {
            return s;
        } else
        {
            return obj.toString();
        }
    }

    public JSONArray put(double d)
        throws JSONException
    {
        Double double1 = new Double(d);
        JSONObject.testValidity(double1);
        put(double1);
        return this;
    }

    public JSONArray put(int i)
    {
        put(new Integer(i));
        return this;
    }

    public JSONArray put(int i, double d)
        throws JSONException
    {
        put(i, new Double(d));
        return this;
    }

    public JSONArray put(int i, int j)
        throws JSONException
    {
        put(i, new Integer(j));
        return this;
    }

    public JSONArray put(int i, long l)
        throws JSONException
    {
        put(i, new Long(l));
        return this;
    }

    public JSONArray put(int i, Object obj)
        throws JSONException
    {
        JSONObject.testValidity(obj);
        if (i < 0)
        {
            throw new JSONException("JSONArray[" + i + "] not found.");
        }
        if (i < length())
        {
            myArrayList.set(i, obj);
            return this;
        }
        for (; i != length(); put(JSONObject.NULL)) { }
        put(obj);
        return this;
    }

    public JSONArray put(int i, Collection collection)
        throws JSONException
    {
        put(i, new JSONArray(collection));
        return this;
    }

    public JSONArray put(int i, Map map)
        throws JSONException
    {
        put(i, new JSONObject(map));
        return this;
    }

    public JSONArray put(int i, boolean flag)
        throws JSONException
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        put(i, boolean1);
        return this;
    }

    public JSONArray put(long l)
    {
        put(new Long(l));
        return this;
    }

    public JSONArray put(Object obj)
    {
        myArrayList.add(obj);
        return this;
    }

    public JSONArray put(Collection collection)
    {
        put(new JSONArray(collection));
        return this;
    }

    public JSONArray put(Map map)
    {
        put(new JSONObject(map));
        return this;
    }

    public JSONArray put(boolean flag)
    {
        Boolean boolean1;
        if (flag)
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        put(boolean1);
        return this;
    }

    public Object remove(int i)
    {
        Object obj = opt(i);
        myArrayList.remove(i);
        return obj;
    }

    public JSONObject toJSONObject(JSONArray jsonarray)
        throws JSONException
    {
        if (jsonarray != null && jsonarray.length() != 0 && length() != 0) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = null;
_L4:
        return jsonobject;
_L2:
        JSONObject jsonobject1 = new JSONObject();
        int i = 0;
        do
        {
            jsonobject = jsonobject1;
            if (i >= jsonarray.length())
            {
                continue;
            }
            jsonobject1.put(jsonarray.getString(i), opt(i));
            i++;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String toString()
    {
        String s;
        try
        {
            s = toString(0);
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public String toString(int i)
        throws JSONException
    {
        Object obj = new StringWriter();
        synchronized (((StringWriter) (obj)).getBuffer())
        {
            obj = write(((Writer) (obj)), i, 0).toString();
        }
        return ((String) (obj));
        exception;
        stringbuffer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Writer write(Writer writer)
        throws JSONException
    {
        return write(writer, 0, 0);
    }

    Writer write(Writer writer, int i, int j)
        throws JSONException
    {
        int k;
        int l;
        int i1;
        boolean flag = false;
        try
        {
            l = length();
            writer.write(91);
        }
        // Misplaced declaration of an exception variable
        catch (Writer writer)
        {
            throw new JSONException(writer);
        }
        if (l != 1) goto _L2; else goto _L1
_L1:
        JSONObject.writeValue(writer, myArrayList.get(0), i, j);
_L4:
        writer.write(93);
        return writer;
_L3:
        if (k >= l)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        writer.write(44);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        writer.write(10);
        JSONObject.indent(writer, i1);
        JSONObject.writeValue(writer, myArrayList.get(k), i, i1);
        flag = true;
        k++;
          goto _L3
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        writer.write(10);
        JSONObject.indent(writer, j);
          goto _L4
_L2:
        if (l == 0) goto _L4; else goto _L5
_L5:
        i1 = j + i;
        k = 0;
          goto _L3
    }
}
