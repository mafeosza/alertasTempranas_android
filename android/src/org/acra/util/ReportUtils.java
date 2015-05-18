// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.util;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import org.acra.ACRA;

public final class ReportUtils
{

    public ReportUtils()
    {
    }

    public static String getApplicationFilePath(Context context)
    {
        File file = context.getFilesDir();
        if (file != null)
        {
            return file.getAbsolutePath();
        } else
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve ApplicationFilePath for : ").append(context.getPackageName()).toString());
            return "Couldn't retrieve ApplicationFilePath";
        }
    }

    public static long getAvailableInternalMemorySize()
    {
        StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
        long l = statfs.getBlockSize();
        return (long)statfs.getAvailableBlocks() * l;
    }

    public static String getDeviceId(Context context)
    {
        String s;
        try
        {
            s = ((TelephonyManager)context.getSystemService("phone")).getDeviceId();
        }
        catch (RuntimeException runtimeexception)
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve DeviceId for : ").append(context.getPackageName()).toString(), runtimeexception);
            return null;
        }
        return s;
    }

    public static String getDisplayDetails(Context context)
    {
        Object obj;
        try
        {
            obj = ((WindowManager)context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displaymetrics = new DisplayMetrics();
            ((Display) (obj)).getMetrics(displaymetrics);
            StringBuilder stringbuilder = new StringBuilder();
            stringbuilder.append("width=").append(((Display) (obj)).getWidth()).append('\n');
            stringbuilder.append("height=").append(((Display) (obj)).getHeight()).append('\n');
            stringbuilder.append("pixelFormat=").append(((Display) (obj)).getPixelFormat()).append('\n');
            stringbuilder.append("refreshRate=").append(((Display) (obj)).getRefreshRate()).append("fps").append('\n');
            stringbuilder.append("metrics.density=x").append(displaymetrics.density).append('\n');
            stringbuilder.append("metrics.scaledDensity=x").append(displaymetrics.scaledDensity).append('\n');
            stringbuilder.append("metrics.widthPixels=").append(displaymetrics.widthPixels).append('\n');
            stringbuilder.append("metrics.heightPixels=").append(displaymetrics.heightPixels).append('\n');
            stringbuilder.append("metrics.xdpi=").append(displaymetrics.xdpi).append('\n');
            stringbuilder.append("metrics.ydpi=").append(displaymetrics.ydpi);
            obj = stringbuilder.toString();
        }
        catch (RuntimeException runtimeexception)
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve DisplayDetails for : ").append(context.getPackageName()).toString(), runtimeexception);
            return "Couldn't retrieve Display Details";
        }
        return ((String) (obj));
    }

    public static long getTotalInternalMemorySize()
    {
        StatFs statfs = new StatFs(Environment.getDataDirectory().getPath());
        long l = statfs.getBlockSize();
        return (long)statfs.getBlockCount() * l;
    }

    public static String sparseArrayToString(SparseArray sparsearray)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (sparsearray == null)
        {
            return "null";
        }
        stringbuilder.append('{');
        int i = 0;
        while (i < sparsearray.size()) 
        {
            stringbuilder.append(sparsearray.keyAt(i));
            stringbuilder.append(" => ");
            if (sparsearray.valueAt(i) == null)
            {
                stringbuilder.append("null");
            } else
            {
                stringbuilder.append(sparsearray.valueAt(i).toString());
            }
            if (i < sparsearray.size() - 1)
            {
                stringbuilder.append(", ");
            }
            i++;
        }
        stringbuilder.append('}');
        return stringbuilder.toString();
    }
}
