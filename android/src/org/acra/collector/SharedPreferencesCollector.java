// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;

final class SharedPreferencesCollector
{

    SharedPreferencesCollector()
    {
    }

    public static String collect(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        TreeMap treemap = new TreeMap();
        treemap.put("default", PreferenceManager.getDefaultSharedPreferences(context));
        String as[] = ACRA.getConfig().additionalSharedPreferences();
        if (as != null)
        {
            int j = as.length;
            for (int i = 0; i < j; i++)
            {
                String s = as[i];
                treemap.put(s, context.getSharedPreferences(s, 0));
            }

        }
        context = treemap.keySet().iterator();
        while (context.hasNext()) 
        {
            Object obj = (String)context.next();
            stringbuilder.append(((String) (obj))).append("\n");
            obj = (SharedPreferences)treemap.get(obj);
            if (obj != null)
            {
                obj = ((SharedPreferences) (obj)).getAll();
                if (obj != null && ((Map) (obj)).size() > 0)
                {
                    Iterator iterator = ((Map) (obj)).keySet().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        String s1 = (String)iterator.next();
                        if (!filteredKey(s1))
                        {
                            if (((Map) (obj)).get(s1) != null)
                            {
                                stringbuilder.append(s1).append("=").append(((Map) (obj)).get(s1).toString()).append("\n");
                            } else
                            {
                                stringbuilder.append(s1).append("=").append("null\n");
                            }
                        }
                    } while (true);
                } else
                {
                    stringbuilder.append("empty\n");
                }
            } else
            {
                stringbuilder.append("null\n");
            }
            stringbuilder.append("\n");
        }
        return stringbuilder.toString();
    }

    private static boolean filteredKey(String s)
    {
        String as[] = ACRA.getConfig().excludeMatchingSharedPreferencesKeys();
        if (as.length < 0)
        {
            return s.matches(as[0]);
        } else
        {
            return false;
        }
    }
}
