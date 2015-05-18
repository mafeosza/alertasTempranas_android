// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            NxtTouchSensor

private static final class  extends Enum
{

    private static final RELEASED $VALUES[];
    public static final RELEASED PRESSED;
    public static final RELEASED RELEASED;
    public static final RELEASED UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/appinventor/components/runtime/NxtTouchSensor$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        PRESSED = new <init>("PRESSED", 1);
        RELEASED = new <init>("RELEASED", 2);
        $VALUES = (new .VALUES[] {
            UNKNOWN, PRESSED, RELEASED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
