// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import gnu.lists.LList;
import gnu.lists.Pair;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            YailConstants, YailNumberToString, JsonUtil

public class YailList extends Pair
{

    private static final String LOG_TAG = "YailList";

    public YailList()
    {
        super(YailConstants.YAIL_HEADER, LList.Empty);
    }

    private YailList(Object obj)
    {
        super(YailConstants.YAIL_HEADER, obj);
    }

    public static String YailListElementToString(Object obj)
    {
        if (java/lang/Number.isInstance(obj))
        {
            return YailNumberToString.format(((Number)obj).doubleValue());
        } else
        {
            return String.valueOf(obj);
        }
    }

    public static YailList makeEmptyList()
    {
        return new YailList();
    }

    public static YailList makeList(Collection collection)
    {
        return new YailList(Pair.makeList(collection.toArray(), 0));
    }

    public static YailList makeList(List list)
    {
        return new YailList(Pair.makeList(list));
    }

    public static YailList makeList(Object aobj[])
    {
        return new YailList(Pair.makeList(aobj, 0));
    }

    public Object getObject(int i)
    {
        return get(i + 1);
    }

    public String getString(int i)
    {
        return get(i + 1).toString();
    }

    public int size()
    {
        return super.size() - 1;
    }

    public Object[] toArray()
    {
        if (cdr instanceof Pair)
        {
            return ((Pair)cdr).toArray();
        }
        if (cdr instanceof LList)
        {
            return ((LList)cdr).toArray();
        } else
        {
            throw new YailRuntimeError("YailList cannot be represented as an array", "YailList Error.");
        }
    }

    public String toJSONString()
    {
        String s;
        StringBuilder stringbuilder;
        Object obj;
        int i;
        int j;
        try
        {
            stringbuilder = new StringBuilder();
        }
        catch (JSONException jsonexception)
        {
            throw new YailRuntimeError("List failed to convert to JSON.", "JSON Creation Error.");
        }
        s = "";
        stringbuilder.append('[');
        j = size();
        i = 1;
_L2:
        if (i > j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = get(i);
        stringbuilder.append(s).append(JsonUtil.getJsonRepresentation(obj));
        s = ",";
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder.append(']');
        s = stringbuilder.toString();
        return s;
    }

    public String toString()
    {
        if (cdr instanceof Pair)
        {
            return ((Pair)cdr).toString();
        }
        if (cdr instanceof LList)
        {
            return ((LList)cdr).toString();
        } else
        {
            throw new RuntimeException("YailList cannot be represented as a String");
        }
    }

    public String[] toStringArray()
    {
        int j = size();
        String as[] = new String[j];
        for (int i = 1; i <= j; i++)
        {
            as[i - 1] = YailListElementToString(get(i));
        }

        return as;
    }
}
