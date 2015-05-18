// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.util.Log;
import com.google.appinventor.components.runtime.collect.Maps;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryLeakUtil
{

    private static final String LOG_TAG = "MemoryLeakUtil";
    private static final Map TRACKED_OBJECTS = Maps.newTreeMap();
    private static final AtomicInteger prefixGenerator = new AtomicInteger(0);

    private MemoryLeakUtil()
    {
    }

    public static void checkAllTrackedObjects(boolean flag, boolean flag1)
    {
        Log.i("MemoryLeakUtil", "Checking Tracked Objects ----------------------------------------");
        System.gc();
        int i = 0;
        int j = 0;
        Iterator iterator = TRACKED_OBJECTS.entrySet().iterator();
        do
        {
            if (iterator.hasNext())
            {
                Object obj = (java.util.Map.Entry)iterator.next();
                Object obj1 = (String)((java.util.Map.Entry) (obj)).getKey();
                obj = ((WeakReference)((java.util.Map.Entry) (obj)).getValue()).get();
                int k;
                int l;
                if (obj != null)
                {
                    l = i + 1;
                    k = j;
                } else
                {
                    j++;
                    k = j;
                    l = i;
                    if (flag1)
                    {
                        iterator.remove();
                        k = j;
                        l = i;
                    }
                }
                j = k;
                i = l;
                if (flag)
                {
                    obj1 = ((String) (obj1)).substring(((String) (obj1)).indexOf("_") + 1);
                    obj1 = (new StringBuilder()).append("Object with tag ").append(((String) (obj1))).append(" has ");
                    if (obj != null)
                    {
                        obj = "not ";
                    } else
                    {
                        obj = "";
                    }
                    Log.i("MemoryLeakUtil", ((StringBuilder) (obj1)).append(((String) (obj))).append("been garbage collected.").toString());
                    j = k;
                    i = l;
                }
                continue;
            }
            Log.i("MemoryLeakUtil", (new StringBuilder()).append("summary: collected ").append(j).toString());
            Log.i("MemoryLeakUtil", (new StringBuilder()).append("summary: remaining ").append(i).toString());
            Log.i("MemoryLeakUtil", "-----------------------------------------------------------------");
            return;
        } while (true);
    }

    public static boolean isTrackedObjectCollected(String s, boolean flag)
    {
        System.gc();
        Object obj = (WeakReference)TRACKED_OBJECTS.get(s);
        if (obj != null)
        {
            Object obj1 = ((WeakReference) (obj)).get();
            obj = s.substring(s.indexOf("_") + 1);
            StringBuilder stringbuilder = (new StringBuilder()).append("Object with tag ").append(((String) (obj))).append(" has ");
            if (obj1 != null)
            {
                obj = "not ";
            } else
            {
                obj = "";
            }
            Log.i("MemoryLeakUtil", stringbuilder.append(((String) (obj))).append("been garbage collected.").toString());
            if (flag && obj1 == null)
            {
                TRACKED_OBJECTS.remove(s);
            }
            return obj1 == null;
        } else
        {
            throw new IllegalArgumentException("key not found");
        }
    }

    public static String trackObject(String s, Object obj)
    {
        if (s == null)
        {
            s = (new StringBuilder()).append(prefixGenerator.incrementAndGet()).append("_").toString();
        } else
        {
            s = (new StringBuilder()).append(prefixGenerator.incrementAndGet()).append("_").append(s).toString();
        }
        TRACKED_OBJECTS.put(s, new WeakReference(obj));
        return s;
    }

}
