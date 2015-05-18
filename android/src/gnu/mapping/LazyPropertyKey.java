// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

// Referenced classes of package gnu.mapping:
//            PropertyKey, PropertySet

public class LazyPropertyKey extends PropertyKey
{

    public LazyPropertyKey(String s)
    {
        super(s);
    }

    public Object get(PropertySet propertyset, Object obj)
    {
        obj = propertyset.getProperty(this, obj);
        if (!(obj instanceof String))
        {
            break MISSING_BLOCK_LABEL_248;
        }
        Object obj1 = (String)obj;
        int i;
        int j;
        if (((String) (obj1)).charAt(0) == '*')
        {
            i = 1;
        } else
        {
            i = 0;
        }
        j = ((String) (obj1)).indexOf(':');
        if (j <= i || j >= ((String) (obj1)).length() - 1)
        {
            throw new RuntimeException((new StringBuilder()).append("lazy property ").append(this).append(" must have the form \"ClassName:fieldName\" or \"ClassName:staticMethodName\"").toString());
        }
        Object obj2 = ((String) (obj1)).substring(i, j);
        obj = ((String) (obj1)).substring(j + 1);
        try
        {
            obj2 = Class.forName(((String) (obj2)), true, propertyset.getClass().getClassLoader());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj1 = (new StringBuilder()).append("lazy property ").append(this).append(" has specifier \"").append(((String) (obj1))).append("\" but there is no such ");
            if (i == 0)
            {
                propertyset = "field";
            } else
            {
                propertyset = "method";
            }
            throw new RuntimeException(((StringBuilder) (obj1)).append(propertyset).toString(), ((Throwable) (obj)));
        }
        if (i != 0) goto _L2; else goto _L1
_L1:
        obj = ((Class) (obj2)).getField(((String) (obj))).get(null);
_L4:
        propertyset.setProperty(this, obj);
        return obj;
_L2:
        obj = ((Class) (obj2)).getDeclaredMethod(((String) (obj)), new Class[] {
            java/lang/Object
        }).invoke(null, new Object[] {
            propertyset
        });
        if (true) goto _L4; else goto _L3
_L3:
        return obj;
    }

    public void set(PropertySet propertyset, String s)
    {
        propertyset.setProperty(this, s);
    }
}
