// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ReflectionCollector
{

    ReflectionCollector()
    {
    }

    public static String collectConstants(Class class1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        class1 = class1.getFields();
        int j = class1.length;
        int i = 0;
        while (i < j) 
        {
            Field field = class1[i];
            stringbuilder.append(field.getName()).append("=");
            try
            {
                stringbuilder.append(field.get(null).toString());
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                stringbuilder.append("N/A");
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                stringbuilder.append("N/A");
            }
            stringbuilder.append("\n");
            i++;
        }
        return stringbuilder.toString();
    }

    public static String collectStaticGettersResults(Class class1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        class1 = class1.getMethods();
        int j = class1.length;
        int i = 0;
        while (i < j) 
        {
            Method method = class1[i];
            if (method.getParameterTypes().length == 0 && (method.getName().startsWith("get") || method.getName().startsWith("is")) && !method.getName().equals("getClass"))
            {
                try
                {
                    stringbuilder.append(method.getName());
                    stringbuilder.append('=');
                    stringbuilder.append(method.invoke(null, (Object[])null));
                    stringbuilder.append("\n");
                }
                catch (IllegalArgumentException illegalargumentexception) { }
                catch (IllegalAccessException illegalaccessexception) { }
                catch (InvocationTargetException invocationtargetexception) { }
            }
            i++;
        }
        return stringbuilder.toString();
    }
}
