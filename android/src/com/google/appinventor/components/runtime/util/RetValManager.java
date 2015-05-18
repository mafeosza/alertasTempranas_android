// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.util.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RetValManager
{

    private static final String LOG_TAG = "RetValManager";
    private static final long TENSECONDS = 10000L;
    private static ArrayList currentArray = new ArrayList(10);
    private static final Object semaphore = new Object();

    private RetValManager()
    {
    }

    public static void appendReturnValue(String s, String s1, String s2)
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("status", s1);
        jsonobject.put("type", "return");
        jsonobject.put("value", s2);
        jsonobject.put("blockid", s);
        boolean flag;
        flag = currentArray.isEmpty();
        currentArray.add(jsonobject);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        semaphore.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("RetValManager", "Error building retval", s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static String fetch(boolean flag)
    {
        long l = System.currentTimeMillis();
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
_L2:
        if (!currentArray.isEmpty() || !flag)
        {
            break MISSING_BLOCK_LABEL_37;
        }
        if (System.currentTimeMillis() - l <= 9900L)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        Object obj1;
        JSONObject jsonobject;
        obj1 = new JSONArray(currentArray);
        jsonobject = new JSONObject();
        jsonobject.put("status", "OK");
        jsonobject.put("values", obj1);
        currentArray.clear();
        obj1 = jsonobject.toString();
        obj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
        Object obj2;
        try
        {
            semaphore.wait(10000L);
        }
        catch (InterruptedException interruptedexception) { }
        finally { }
        if (true) goto _L2; else goto _L1
_L1:
        obj2;
        Log.e("RetValManager", "Error fetching retvals", ((Throwable) (obj2)));
        obj;
        JVM INSTR monitorexit ;
        return "{\"status\" : \"BAD\", \"message\" : \"Failure in RetValManager\"}";
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
    }

    public static void popScreen(String s)
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("status", "OK");
        jsonobject.put("type", "popScreen");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        jsonobject.put("value", s.toString());
        boolean flag;
        flag = currentArray.isEmpty();
        currentArray.add(jsonobject);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        semaphore.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("RetValManager", "Error building retval", s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void pushScreen(String s, Object obj)
    {
        Object obj1 = semaphore;
        obj1;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("status", "OK");
        jsonobject.put("type", "pushScreen");
        jsonobject.put("screen", s);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        jsonobject.put("value", obj.toString());
        boolean flag;
        flag = currentArray.isEmpty();
        currentArray.add(jsonobject);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        semaphore.notifyAll();
        obj1;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("RetValManager", "Error building retval", s);
        obj1;
        JVM INSTR monitorexit ;
        return;
        s;
        obj1;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void sendError(String s)
    {
        Object obj = semaphore;
        obj;
        JVM INSTR monitorenter ;
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("status", "OK");
        jsonobject.put("type", "error");
        jsonobject.put("value", s);
        boolean flag;
        flag = currentArray.isEmpty();
        currentArray.add(jsonobject);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        semaphore.notifyAll();
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        Log.e("RetValManager", "Error building retval", s);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

}
