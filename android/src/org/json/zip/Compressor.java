// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.Kim;

// Referenced classes of package org.json.zip:
//            JSONzip, BitWriter, Huff, Keep, 
//            MapKeep, TrieKeep

public class Compressor extends JSONzip
{

    final BitWriter bitwriter;

    public Compressor(BitWriter bitwriter1)
    {
        bitwriter = bitwriter1;
    }

    private static int bcd(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return c - 48;
        }
        switch (c)
        {
        case 44: // ','
        default:
            return 13;

        case 46: // '.'
            return 10;

        case 45: // '-'
            return 11;

        case 43: // '+'
            return 12;
        }
    }

    private void one()
        throws JSONException
    {
        write(1, 1);
    }

    private void write(int i, int j)
        throws JSONException
    {
        try
        {
            bitwriter.write(i, j);
            return;
        }
        catch (Throwable throwable)
        {
            throw new JSONException(throwable);
        }
    }

    private void write(int i, Huff huff)
        throws JSONException
    {
        huff.write(i, bitwriter);
    }

    private void write(Kim kim, int i, int j, Huff huff)
        throws JSONException
    {
        for (; i < j; i++)
        {
            write(kim.get(i), huff);
        }

    }

    private void write(Kim kim, Huff huff)
        throws JSONException
    {
        write(kim, 0, kim.length, huff);
    }

    private void writeAndTick(int i, Keep keep)
        throws JSONException
    {
        int j = keep.bitsize();
        keep.tick(i);
        write(i, j);
    }

    private void writeArray(JSONArray jsonarray)
        throws JSONException
    {
        boolean flag = false;
        int j = jsonarray.length();
        if (j == 0)
        {
            write(1, 3);
            return;
        }
        Object obj1 = jsonarray.get(0);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = JSONObject.NULL;
        }
        int i;
        if (obj instanceof String)
        {
            flag = true;
            write(6, 3);
            writeString((String)obj);
        } else
        {
            write(7, 3);
            writeValue(obj);
        }
        i = 1;
        while (i < j) 
        {
            Object obj2 = jsonarray.get(i);
            obj = obj2;
            if (obj2 == null)
            {
                obj = JSONObject.NULL;
            }
            if ((obj instanceof String) != flag)
            {
                zero();
            }
            one();
            if (obj instanceof String)
            {
                writeString((String)obj);
            } else
            {
                writeValue(obj);
            }
            i++;
        }
        zero();
        zero();
    }

    private void writeJSON(Object obj)
        throws JSONException
    {
        if (JSONObject.NULL.equals(obj))
        {
            write(4, 3);
            return;
        }
        if (Boolean.FALSE.equals(obj))
        {
            write(3, 3);
            return;
        }
        if (Boolean.TRUE.equals(obj))
        {
            write(2, 3);
            return;
        }
        if (!(obj instanceof Map)) goto _L2; else goto _L1
_L1:
        Object obj1 = new JSONObject((Map)obj);
_L4:
        if (obj1 instanceof JSONObject)
        {
            writeObject((JSONObject)obj1);
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (obj instanceof Collection)
        {
            obj1 = new JSONArray((Collection)obj);
        } else
        {
            obj1 = obj;
            if (obj.getClass().isArray())
            {
                obj1 = new JSONArray(obj);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (obj1 instanceof JSONArray)
        {
            writeArray((JSONArray)obj1);
            return;
        } else
        {
            throw new JSONException("Unrecognized object");
        }
    }

    private void writeName(String s)
        throws JSONException
    {
        s = new Kim(s);
        int i = namekeep.find(s);
        if (i != -1)
        {
            one();
            writeAndTick(i, namekeep);
            return;
        } else
        {
            zero();
            write(s, namehuff);
            write(256, namehuff);
            namekeep.register(s);
            return;
        }
    }

    private void writeObject(JSONObject jsonobject)
        throws JSONException
    {
        boolean flag = true;
        Iterator iterator = jsonobject.keys();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = iterator.next();
            if (obj instanceof String)
            {
                if (flag)
                {
                    flag = false;
                    write(5, 3);
                } else
                {
                    one();
                }
                writeName((String)obj);
                obj = jsonobject.get((String)obj);
                if (obj instanceof String)
                {
                    zero();
                    writeString((String)obj);
                } else
                {
                    one();
                    writeValue(obj);
                }
            }
        } while (true);
        if (flag)
        {
            write(0, 3);
            return;
        } else
        {
            zero();
            return;
        }
    }

    private void writeString(String s)
        throws JSONException
    {
        if (s.length() == 0)
        {
            zero();
            zero();
            write(256, substringhuff);
            zero();
            return;
        }
        s = new Kim(s);
        int i = stringkeep.find(s);
        if (i != -1)
        {
            one();
            writeAndTick(i, stringkeep);
            return;
        } else
        {
            writeSubstring(s);
            stringkeep.register(s);
            return;
        }
    }

    private void writeSubstring(Kim kim)
        throws JSONException
    {
        substringkeep.reserve();
        zero();
        int i = 0;
        int j1 = kim.length;
        int j = -1;
        int i1 = 0;
        do
        {
            int l = -1;
            int k = i;
label0:
            do
            {
label1:
                {
                    if (k <= j1 - 3)
                    {
                        l = substringkeep.match(kim, k, j1);
                        if (l == -1)
                        {
                            break label1;
                        }
                    }
                    if (l == -1)
                    {
                        zero();
                        if (i < j1)
                        {
                            write(kim, i, j1, substringhuff);
                            if (j != -1)
                            {
                                substringkeep.registerOne(kim, j, i1);
                            }
                        }
                        write(256, substringhuff);
                        zero();
                        substringkeep.registerMany(kim);
                        return;
                    }
                    break label0;
                }
                k++;
            } while (true);
            byte byte0 = j;
            if (i != k)
            {
                zero();
                write(kim, i, k, substringhuff);
                write(256, substringhuff);
                byte0 = j;
                if (j != -1)
                {
                    substringkeep.registerOne(kim, j, i1);
                    byte0 = -1;
                }
            }
            one();
            writeAndTick(l, substringkeep);
            i = k + substringkeep.length(l);
            if (byte0 != -1)
            {
                substringkeep.registerOne(kim, byte0, i1);
            }
            j = k;
            i1 = i + 1;
        } while (true);
    }

    private void writeValue(Object obj)
        throws JSONException
    {
        if (obj instanceof Number)
        {
            String s = JSONObject.numberToString((Number)obj);
            int i = values.find(s);
            if (i != -1)
            {
                write(2, 2);
                writeAndTick(i, values);
                return;
            }
            if ((obj instanceof Integer) || (obj instanceof Long))
            {
                long l = ((Number)obj).longValue();
                if (l >= 0L && l < 16384L)
                {
                    write(0, 2);
                    if (l < 16L)
                    {
                        zero();
                        write((int)l, 4);
                        return;
                    }
                    one();
                    if (l < 128L)
                    {
                        zero();
                        write((int)l, 7);
                        return;
                    } else
                    {
                        one();
                        write((int)l, 14);
                        return;
                    }
                }
            }
            write(1, 2);
            for (int j = 0; j < s.length(); j++)
            {
                write(bcd(s.charAt(j)), 4);
            }

            write(endOfNumber, 4);
            values.register(s);
            return;
        } else
        {
            write(3, 2);
            writeJSON(obj);
            return;
        }
    }

    private void zero()
        throws JSONException
    {
        write(0, 1);
    }

    public void flush()
        throws JSONException
    {
        pad(8);
    }

    public void pad(int i)
        throws JSONException
    {
        try
        {
            bitwriter.pad(i);
            return;
        }
        catch (Throwable throwable)
        {
            throw new JSONException(throwable);
        }
    }

    public void zip(JSONArray jsonarray)
        throws JSONException
    {
        begin();
        writeJSON(jsonarray);
    }

    public void zip(JSONObject jsonobject)
        throws JSONException
    {
        begin();
        writeJSON(jsonobject);
    }
}
