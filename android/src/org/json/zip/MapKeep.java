// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;

import java.util.HashMap;
import org.json.Kim;

// Referenced classes of package org.json.zip:
//            Keep, JSONzip, PostMortem

class MapKeep extends Keep
{

    private Object list[];
    private HashMap map;

    public MapKeep(int i)
    {
        super(i);
        list = new Object[capacity];
        map = new HashMap(capacity);
    }

    private void compact()
    {
        int i = 0;
        int j = 0;
        while (i < capacity) 
        {
            Object obj = list[i];
            long l = age(uses[i]);
            if (l > 0L)
            {
                uses[j] = l;
                list[j] = obj;
                map.put(obj, new Integer(j));
                j++;
            } else
            {
                map.remove(obj);
            }
            i++;
        }
        if (j < capacity)
        {
            length = j;
        } else
        {
            map.clear();
            length = 0;
        }
        power = 0;
    }

    public int find(Object obj)
    {
        obj = map.get(obj);
        if (obj instanceof Integer)
        {
            return ((Integer)obj).intValue();
        } else
        {
            return -1;
        }
    }

    public boolean postMortem(PostMortem postmortem)
    {
        MapKeep mapkeep = (MapKeep)postmortem;
        if (length != mapkeep.length)
        {
            JSONzip.log(length + " <> " + mapkeep.length);
            return false;
        }
        Object obj;
        Object obj1;
        boolean flag;
        for (int i = 0; i < length; i++)
        {
            if (list[i] instanceof Kim)
            {
                flag = ((Kim)list[i]).equals(mapkeep.list[i]);
            } else
            {
                obj = list[i];
                obj1 = mapkeep.list[i];
                postmortem = ((PostMortem) (obj));
                if (obj instanceof Number)
                {
                    postmortem = obj.toString();
                }
                obj = obj1;
                if (obj1 instanceof Number)
                {
                    obj = obj1.toString();
                }
                flag = postmortem.equals(obj);
            }
            if (!flag)
            {
                JSONzip.log("\n[" + i + "]\n " + list[i] + "\n " + mapkeep.list[i] + "\n " + uses[i] + "\n " + mapkeep.uses[i]);
                return false;
            }
        }

        return true;
    }

    public void register(Object obj)
    {
        if (length >= capacity)
        {
            compact();
        }
        list[length] = obj;
        map.put(obj, new Integer(length));
        uses[length] = 1L;
        length = length + 1;
    }

    public Object value(int i)
    {
        return list[i];
    }
}
