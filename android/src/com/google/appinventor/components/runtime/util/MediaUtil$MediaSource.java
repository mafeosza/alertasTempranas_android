// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;


// Referenced classes of package com.google.appinventor.components.runtime.util:
//            MediaUtil

private static final class  extends Enum
{

    private static final CONTACT_URI $VALUES[];
    public static final CONTACT_URI ASSET;
    public static final CONTACT_URI CONTACT_URI;
    public static final CONTACT_URI CONTENT_URI;
    public static final CONTACT_URI FILE_URL;
    public static final CONTACT_URI REPL_ASSET;
    public static final CONTACT_URI SDCARD;
    public static final CONTACT_URI URL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/google/appinventor/components/runtime/util/MediaUtil$MediaSource, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ASSET = new <init>("ASSET", 0);
        REPL_ASSET = new <init>("REPL_ASSET", 1);
        SDCARD = new <init>("SDCARD", 2);
        FILE_URL = new <init>("FILE_URL", 3);
        URL = new <init>("URL", 4);
        CONTENT_URI = new <init>("CONTENT_URI", 5);
        CONTACT_URI = new <init>("CONTACT_URI", 6);
        $VALUES = (new .VALUES[] {
            ASSET, REPL_ASSET, SDCARD, FILE_URL, URL, CONTENT_URI, CONTACT_URI
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
