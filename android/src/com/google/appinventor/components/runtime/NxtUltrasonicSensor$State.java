// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            NxtUltrasonicSensor

private static final class I extends Enum
{

    private static final ABOVE_RANGE $VALUES[];
    public static final ABOVE_RANGE ABOVE_RANGE;
    public static final ABOVE_RANGE BELOW_RANGE;
    public static final ABOVE_RANGE UNKNOWN;
    public static final ABOVE_RANGE WITHIN_RANGE;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/google/appinventor/components/runtime/NxtUltrasonicSensor$State, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        BELOW_RANGE = new <init>("BELOW_RANGE", 1);
        WITHIN_RANGE = new <init>("WITHIN_RANGE", 2);
        ABOVE_RANGE = new <init>("ABOVE_RANGE", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, BELOW_RANGE, WITHIN_RANGE, ABOVE_RANGE
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
