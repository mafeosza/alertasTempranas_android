// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.Kim;

// Referenced classes of package org.json.zip:
//            JSONzip, BitReader, Keep, Huff, 
//            MapKeep, TrieKeep

public class Decompressor extends JSONzip
{

    BitReader bitreader;

    public Decompressor(BitReader bitreader1)
    {
        bitreader = bitreader1;
    }

    private boolean bit()
        throws JSONException
    {
        boolean flag;
        try
        {
            flag = bitreader.bit();
        }
        catch (Throwable throwable)
        {
            throw new JSONException(throwable);
        }
        return flag;
    }

    private Object getAndTick(Keep keep, BitReader bitreader1)
        throws JSONException
    {
        int i;
        try
        {
            i = bitreader1.read(keep.bitsize());
            bitreader1 = ((BitReader) (keep.value(i)));
            if (i >= keep.length)
            {
                throw new JSONException("Deep error.");
            }
        }
        // Misplaced declaration of an exception variable
        catch (Keep keep)
        {
            throw new JSONException(keep);
        }
        keep.tick(i);
        return bitreader1;
    }

    private int read(int i)
        throws JSONException
    {
        try
        {
            i = bitreader.read(i);
        }
        catch (Throwable throwable)
        {
            throw new JSONException(throwable);
        }
        return i;
    }

    private JSONArray readArray(boolean flag)
        throws JSONException
    {
        JSONArray jsonarray = new JSONArray();
        Object obj;
        if (flag)
        {
            obj = readString();
        } else
        {
            obj = readValue();
        }
        jsonarray.put(obj);
        do
        {
            while (!bit()) 
            {
                if (!bit())
                {
                    return jsonarray;
                }
                if (flag)
                {
                    obj = readValue();
                } else
                {
                    obj = readString();
                }
                jsonarray.put(obj);
            }
            if (flag)
            {
                obj = readString();
            } else
            {
                obj = readValue();
            }
            jsonarray.put(obj);
        } while (true);
    }

    private Object readJSON()
        throws JSONException
    {
        switch (read(3))
        {
        case 4: // '\004'
        default:
            return JSONObject.NULL;

        case 5: // '\005'
            return readObject();

        case 6: // '\006'
            return readArray(true);

        case 7: // '\007'
            return readArray(false);

        case 0: // '\0'
            return new JSONObject();

        case 1: // '\001'
            return new JSONArray();

        case 2: // '\002'
            return Boolean.TRUE;

        case 3: // '\003'
            return Boolean.FALSE;
        }
    }

    private String readName()
        throws JSONException
    {
        byte abyte0[] = new byte[0x10000];
        int i = 0;
        if (!bit())
        {
            do
            {
                int j = namehuff.read(bitreader);
                if (j == 256)
                {
                    if (i == 0)
                    {
                        return "";
                    } else
                    {
                        Kim kim = new Kim(abyte0, i);
                        namekeep.register(kim);
                        return kim.toString();
                    }
                }
                abyte0[i] = (byte)j;
                i++;
            } while (true);
        } else
        {
            return getAndTick(namekeep, bitreader).toString();
        }
    }

    private JSONObject readObject()
        throws JSONException
    {
        JSONObject jsonobject = new JSONObject();
        do
        {
            String s = readName();
            Object obj;
            if (!bit())
            {
                obj = readString();
            } else
            {
                obj = readValue();
            }
            jsonobject.put(s, obj);
        } while (bit());
        return jsonobject;
    }

    private String readString()
        throws JSONException
    {
        int i = 0;
        int j = -1;
        int k = 0;
        if (bit())
        {
            return getAndTick(stringkeep, bitreader).toString();
        }
        byte abyte0[] = new byte[0x10000];
        boolean flag = bit();
        substringkeep.reserve();
        do
        {
            while (flag) 
            {
                int l = ((Kim)getAndTick(substringkeep, bitreader)).copy(abyte0, i);
                if (j != -1)
                {
                    substringkeep.registerOne(new Kim(abyte0, j, k + 1));
                }
                k = l;
                flag = bit();
                j = i;
                i = l;
            }
            do
            {
                int i1 = substringhuff.read(bitreader);
                if (i1 == 256)
                {
                    if (!bit())
                    {
                        if (i == 0)
                        {
                            return "";
                        } else
                        {
                            Kim kim = new Kim(abyte0, i);
                            stringkeep.register(kim);
                            substringkeep.registerMany(kim);
                            return kim.toString();
                        }
                    }
                    break;
                }
                abyte0[i] = (byte)i1;
                i1 = i + 1;
                i = i1;
                if (j != -1)
                {
                    substringkeep.registerOne(new Kim(abyte0, j, k + 1));
                    j = -1;
                    i = i1;
                }
            } while (true);
            flag = true;
        } while (true);
    }

    private Object readValue()
        throws JSONException
    {
        byte byte0 = 4;
        switch (read(2))
        {
        default:
            throw new JSONException("Impossible.");

        case 0: // '\0'
            if (bit())
            {
                if (!bit())
                {
                    byte0 = 7;
                } else
                {
                    byte0 = 14;
                }
            }
            return new Integer(read(byte0));

        case 1: // '\001'
            byte abyte0[] = new byte[256];
            int i = 0;
            do
            {
                int j = read(4);
                if (j == endOfNumber)
                {
                    try
                    {
                        abyte0 = ((byte []) (JSONObject.stringToValue(new String(abyte0, 0, i, "US-ASCII"))));
                    }
                    catch (UnsupportedEncodingException unsupportedencodingexception)
                    {
                        throw new JSONException(unsupportedencodingexception);
                    }
                    values.register(abyte0);
                    return abyte0;
                }
                abyte0[i] = bcd[j];
                i++;
            } while (true);

        case 2: // '\002'
            return getAndTick(values, bitreader);

        case 3: // '\003'
            return readJSON();
        }
    }

    public boolean pad(int i)
        throws JSONException
    {
        boolean flag;
        try
        {
            flag = bitreader.pad(i);
        }
        catch (Throwable throwable)
        {
            throw new JSONException(throwable);
        }
        return flag;
    }

    public Object unzip()
        throws JSONException
    {
        begin();
        return readJSON();
    }
}
