// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.runtime.errors.YailRuntimeError;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            YailList

public class ElementsUtil
{

    public ElementsUtil()
    {
    }

    public static YailList elements(YailList yaillist, String s)
    {
        String as[] = yaillist.toStringArray();
        for (int i = 0; i < as.length; i++)
        {
            if (!(as[i] instanceof String))
            {
                throw new YailRuntimeError((new StringBuilder()).append("Items passed to ").append(s).append(" must be Strings").toString(), "Error");
            }
        }

        return yaillist;
    }

    public static YailList elementsFromString(String s)
    {
        YailList yaillist = new YailList();
        if (s.length() > 0)
        {
            yaillist = YailList.makeList((Object[])s.split(" *, *"));
        }
        return yaillist;
    }

    public static int selectionIndex(int i, YailList yaillist)
    {
        int j;
label0:
        {
            if (i > 0)
            {
                j = i;
                if (i <= yaillist.size())
                {
                    break label0;
                }
            }
            j = 0;
        }
        return j;
    }

    public static int setSelectedIndexFromValue(String s, YailList yaillist)
    {
        for (int i = 0; i < yaillist.size(); i++)
        {
            if (yaillist.getString(i).equals(s))
            {
                return i + 1;
            }
        }

        return 0;
    }

    public static String setSelectionFromIndex(int i, YailList yaillist)
    {
        if (i == 0)
        {
            return "";
        } else
        {
            return yaillist.getString(i - 1);
        }
    }
}
