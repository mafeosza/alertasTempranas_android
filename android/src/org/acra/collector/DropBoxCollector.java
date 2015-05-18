// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.text.format.Time;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.acra.ACRA;
import org.acra.ACRAConfiguration;

// Referenced classes of package org.acra.collector:
//            Compatibility

final class DropBoxCollector
{

    private static final String NO_RESULT = "N/A";
    private static final String SYSTEM_TAGS[] = {
        "system_app_anr", "system_app_wtf", "system_app_crash", "system_server_anr", "system_server_wtf", "system_server_crash", "BATTERY_DISCHARGE_INFO", "SYSTEM_RECOVERY_LOG", "SYSTEM_BOOT", "SYSTEM_LAST_KMSG", 
        "APANIC_CONSOLE", "APANIC_THREADS", "SYSTEM_RESTART", "SYSTEM_TOMBSTONE", "data_app_strictmode"
    };

    DropBoxCollector()
    {
    }

    public static String read(Context context, String as[])
    {
        Object obj = Compatibility.getDropBoxServiceName();
        if (obj == null)
        {
            return "N/A";
        }
        Method method;
        obj = context.getSystemService(((String) (obj)));
        method = obj.getClass().getMethod("getNextEntry", new Class[] {
            java/lang/String, Long.TYPE
        });
        if (method == null)
        {
            return "";
        }
        Time time;
        long l;
        time = new Time();
        time.setToNow();
        time.minute = time.minute - ACRA.getConfig().dropboxCollectionMinutes();
        time.normalize(false);
        l = time.toMillis(false);
        context = new ArrayList();
        if (ACRA.getConfig().includeDropBoxSystemTags())
        {
            context.addAll(Arrays.asList(SYSTEM_TAGS));
        }
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_145;
        }
        if (as.length > 0)
        {
            context.addAll(Arrays.asList(as));
        }
        if (context.isEmpty())
        {
            return "No tag configured for collection.";
        }
        Iterator iterator;
        as = new StringBuilder();
        iterator = context.iterator();
_L5:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s;
        s = (String)iterator.next();
        as.append("Tag: ").append(s).append('\n');
        context = ((Context) (method.invoke(obj, new Object[] {
            s, Long.valueOf(l)
        })));
        if (context != null) goto _L4; else goto _L3
_L3:
        as.append("Nothing.").append('\n');
          goto _L5
        context;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
_L9:
        return "N/A";
_L4:
        Method method1;
        Method method2;
        Method method3;
        method1 = context.getClass().getMethod("getText", new Class[] {
            Integer.TYPE
        });
        method2 = context.getClass().getMethod("getTimeMillis", (Class[])null);
        method3 = context.getClass().getMethod("close", (Class[])null);
_L7:
        if (context == null) goto _L5; else goto _L6
_L6:
        String s1;
        long l1;
        l1 = ((Long)method2.invoke(context, (Object[])null)).longValue();
        time.set(l1);
        as.append("@").append(time.format2445()).append('\n');
        s1 = (String)method1.invoke(context, new Object[] {
            Integer.valueOf(500)
        });
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        as.append("Text: ").append(s1).append('\n');
_L8:
        method3.invoke(context, (Object[])null);
        context = ((Context) (method.invoke(obj, new Object[] {
            s, Long.valueOf(l1)
        })));
          goto _L7
          goto _L5
        as.append("Not Text!").append('\n');
          goto _L8
        context;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
          goto _L9
_L2:
        context = as.toString();
        return context;
        context;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
          goto _L9
        context;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
          goto _L9
        context;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
          goto _L9
        context;
        Log.i(ACRA.LOG_TAG, "DropBoxManager not available.");
          goto _L9
    }

}
