// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.SimplePropertyCopier;
import com.google.appinventor.components.runtime.Component;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PropertyUtil
{

    public PropertyUtil()
    {
    }

    public static Component copyComponentProperties(Component component, Component component1)
        throws Throwable
    {
        Class class1;
        Method amethod[];
        int i;
        int j;
        if (!component.getClass().equals(component1.getClass()))
        {
            throw new IllegalArgumentException("Source and target classes must be identical");
        }
        class1 = component.getClass();
        amethod = class1.getMethods();
        j = amethod.length;
        i = 0;
_L2:
        Method method;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_212;
        }
        method = amethod[i];
        if (!method.isAnnotationPresent(com/google/appinventor/components/annotations/SimpleProperty) || method.getParameterTypes().length != 1)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        Object obj;
        Object obj1;
        obj = method.getName();
        obj1 = getPropertyCopierMethod((new StringBuilder()).append("Copy").append(((String) (obj))).toString(), class1);
        if (obj1 != null)
        {
            try
            {
                ((Method) (obj1)).invoke(component1, new Object[] {
                    component
                });
            }
            catch (NoSuchMethodException nosuchmethodexception) { }
            // Misplaced declaration of an exception variable
            catch (Component component)
            {
                throw component.getCause();
            }
            break MISSING_BLOCK_LABEL_214;
        }
        obj = class1.getMethod(((String) (obj)), new Class[0]);
        obj1 = method.getParameterTypes()[0];
        if (((Method) (obj)).isAnnotationPresent(com/google/appinventor/components/annotations/SimpleProperty) && ((Class) (obj1)).isAssignableFrom(((Method) (obj)).getReturnType()))
        {
            method.invoke(component1, new Object[] {
                ((Method) (obj)).invoke(component, new Object[0])
            });
        }
        break MISSING_BLOCK_LABEL_214;
        return component1;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Method getPropertyCopierMethod(String s, Class class1)
    {
_L2:
        Method method;
        boolean flag;
        method = class1.getMethod(s, new Class[] {
            class1
        });
        flag = method.isAnnotationPresent(com/google/appinventor/components/annotations/SimplePropertyCopier);
label0:
        {
            if (flag)
            {
                return method;
            }
            break label0;
        }
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        Class class2 = class1.getSuperclass();
        class1 = class2;
        if (class2 == null)
        {
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }
}
