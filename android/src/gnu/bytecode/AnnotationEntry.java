// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.bytecode;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

// Referenced classes of package gnu.bytecode:
//            ClassType

public class AnnotationEntry
    implements Annotation
{

    ClassType annotationType;
    LinkedHashMap elementsValue;

    public AnnotationEntry()
    {
        elementsValue = new LinkedHashMap(10);
    }

    public void addMember(String s, Object obj)
    {
        elementsValue.put(s, obj);
    }

    public Class annotationType()
    {
        return annotationType.getReflectClass();
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof AnnotationEntry) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if (!getAnnotationType().getName().equals(((AnnotationEntry) (obj = (AnnotationEntry)obj)).getAnnotationType().getName())) goto _L4; else goto _L3
_L3:
        Iterator iterator = elementsValue.entrySet().iterator();
_L8:
        if (!iterator.hasNext()) goto _L6; else goto _L5
_L5:
        Object obj2;
        Object obj4;
        obj4 = (java.util.Map.Entry)iterator.next();
        obj2 = (String)((java.util.Map.Entry) (obj4)).getKey();
        obj4 = ((java.util.Map.Entry) (obj4)).getValue();
        obj2 = ((AnnotationEntry) (obj)).elementsValue.get(obj2);
        if (obj4 == obj2) goto _L8; else goto _L7
_L7:
        if (obj4 == null || obj2 == null) goto _L4; else goto _L9
_L9:
        if (!obj4.equals(obj2))
        {
            return false;
        }
          goto _L8
_L6:
        obj = ((AnnotationEntry) (obj)).elementsValue.entrySet().iterator();
label0:
        do
        {
label1:
            {
                Object obj1;
                Object obj3;
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break label1;
                    }
                    obj3 = (java.util.Map.Entry)((Iterator) (obj)).next();
                    obj1 = (String)((java.util.Map.Entry) (obj3)).getKey();
                    obj3 = ((java.util.Map.Entry) (obj3)).getValue();
                    obj1 = elementsValue.get(obj1);
                } while (obj1 == obj3);
                if (obj1 == null || obj3 == null)
                {
                    continue;
                }
                if (!obj1.equals(obj3))
                {
                    return false;
                }
            }
        } while (true);
_L4:
        if (true) goto _L1; else goto _L10
_L10:
        return true;
    }

    public ClassType getAnnotationType()
    {
        return annotationType;
    }

    public int hashCode()
    {
        int i = 0;
        for (Iterator iterator = elementsValue.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            i += ((String)entry.getKey()).hashCode() * 127 ^ entry.getValue().hashCode();
        }

        return i;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append('@');
        stringbuilder.append(getAnnotationType().getName());
        stringbuilder.append('(');
        int i = 0;
        for (Iterator iterator = elementsValue.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            stringbuilder.append((String)entry.getKey());
            stringbuilder.append('=');
            stringbuilder.append(entry.getValue());
            i++;
        }

        stringbuilder.append(')');
        return stringbuilder.toString();
    }
}
