// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.acra.ACRA;

// Referenced classes of package org.acra.collector:
//            Compatibility

final class DeviceFeaturesCollector
{

    DeviceFeaturesCollector()
    {
    }

    public static String getFeatures(Context context)
    {
        StringBuilder stringbuilder;
        if (Compatibility.getAPILevel() < 5)
        {
            return "Data available only with API Level >= 5";
        }
        stringbuilder = new StringBuilder();
        Object aobj[];
        int j;
        PackageManager packagemanager = context.getPackageManager();
        aobj = (Object[])(Object[])android/content/pm/PackageManager.getMethod("getSystemAvailableFeatures", (Class[])null).invoke(packagemanager, new Object[0]);
        j = aobj.length;
        int i = 0;
_L3:
        Object obj;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_202;
        }
        obj = aobj[i];
        String s = (String)obj.getClass().getField("name").get(obj);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        stringbuilder.append(s);
_L1:
        stringbuilder.append("\n");
        i++;
        continue; /* Loop/switch isn't completed */
        obj = (String)obj.getClass().getMethod("getGlEsVersion", (Class[])null).invoke(obj, new Object[0]);
        stringbuilder.append("glEsVersion = ");
        stringbuilder.append(((String) (obj)));
          goto _L1
        Throwable throwable;
        throwable;
        Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve DeviceFeatures for ").append(context.getPackageName()).toString(), throwable);
        stringbuilder.append("Could not retrieve data: ");
        stringbuilder.append(throwable.getMessage());
        return stringbuilder.toString();
        if (true) goto _L3; else goto _L2
_L2:
    }
}
