// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            PropertySet

public class PropertyKey
{

    String name;

    public PropertyKey(String s)
    {
        name = s;
    }

    public final Object get(PropertySet propertyset)
    {
        return get(propertyset, null);
    }

    public Object get(PropertySet propertyset, Object obj)
    {
        return propertyset.getProperty(this, obj);
    }

    public void set(PropertySet propertyset, Object obj)
    {
        propertyset.setProperty(this, obj);
    }
}
