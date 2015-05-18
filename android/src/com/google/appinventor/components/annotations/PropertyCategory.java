// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.annotations;


public final class PropertyCategory extends Enum
{

    private static final PropertyCategory $VALUES[];
    public static final PropertyCategory APPEARANCE;
    public static final PropertyCategory BEHAVIOR;
    public static final PropertyCategory DEPRECATED;
    public static final PropertyCategory UNSET;
    private String name;

    private PropertyCategory(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static PropertyCategory valueOf(String s)
    {
        return (PropertyCategory)Enum.valueOf(com/google/appinventor/components/annotations/PropertyCategory, s);
    }

    public static PropertyCategory[] values()
    {
        return (PropertyCategory[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        BEHAVIOR = new PropertyCategory("BEHAVIOR", 0, "Behavior");
        APPEARANCE = new PropertyCategory("APPEARANCE", 1, "Appearance");
        DEPRECATED = new PropertyCategory("DEPRECATED", 2, "Deprecated");
        UNSET = new PropertyCategory("UNSET", 3, "Unspecified");
        $VALUES = (new PropertyCategory[] {
            BEHAVIOR, APPEARANCE, DEPRECATED, UNSET
        });
    }
}
