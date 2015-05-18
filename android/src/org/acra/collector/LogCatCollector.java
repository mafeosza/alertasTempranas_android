// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.os.Process;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;
import org.acra.util.BoundedLinkedList;

// Referenced classes of package org.acra.collector:
//            Compatibility

class LogCatCollector
{

    private static final int DEFAULT_TAIL_COUNT = 100;

    LogCatCollector()
    {
    }

    public static String collectLogCat(String s)
    {
        String s1;
        Object obj1;
        int i = Process.myPid();
        Object obj = null;
        s1 = ((String) (obj));
        if (ACRA.getConfig().logcatFilterByPid())
        {
            s1 = ((String) (obj));
            if (i > 0)
            {
                s1 = (new StringBuilder()).append(Integer.toString(i)).append("):").toString();
            }
        }
        obj = new ArrayList();
        ((List) (obj)).add("logcat");
        if (s != null)
        {
            ((List) (obj)).add("-b");
            ((List) (obj)).add(s);
        }
        obj1 = new ArrayList(Arrays.asList(ACRA.getConfig().logcatArguments()));
        int k = ((List) (obj1)).indexOf("-t");
        if (k > -1 && k < ((List) (obj1)).size())
        {
            int j = Integer.parseInt((String)((List) (obj1)).get(k + 1));
            i = j;
            if (Compatibility.getAPILevel() < 8)
            {
                ((List) (obj1)).remove(k + 1);
                ((List) (obj1)).remove(k);
                ((List) (obj1)).add("-d");
                i = j;
            }
        } else
        {
            i = -1;
        }
        if (i <= 0)
        {
            i = 100;
        }
        s = new BoundedLinkedList(i);
        ((List) (obj)).addAll(((java.util.Collection) (obj1)));
        obj = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec((String[])((List) (obj)).toArray(new String[((List) (obj)).size()])).getInputStream()), 8192);
        Log.d(ACRA.LOG_TAG, "Retrieving logcat output...");
_L5:
        obj1 = ((BufferedReader) (obj)).readLine();
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        return s.toString();
_L2:
        if (s1 == null) goto _L4; else goto _L3
_L3:
        if (!((String) (obj1)).contains(s1)) goto _L5; else goto _L4
_L4:
        s.add((new StringBuilder()).append(((String) (obj1))).append("\n").toString());
          goto _L5
        IOException ioexception;
        ioexception;
        Log.e(ACRA.LOG_TAG, "LogCatCollector.collectLogCat could not retrieve data.", ioexception);
          goto _L1
    }
}
