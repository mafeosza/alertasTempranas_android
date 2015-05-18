// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;


// Referenced classes of package org.acra.collector:
//            MediaCodecListCollector

private static final class  extends Enum
{

    private static final AAC $VALUES[];
    public static final AAC AAC;
    public static final AAC AVC;
    public static final AAC H263;
    public static final AAC MPEG4;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(org/acra/collector/MediaCodecListCollector$CodecType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AVC = new <init>("AVC", 0);
        H263 = new <init>("H263", 1);
        MPEG4 = new <init>("MPEG4", 2);
        AAC = new <init>("AAC", 3);
        $VALUES = (new .VALUES[] {
            AVC, H263, MPEG4, AAC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
