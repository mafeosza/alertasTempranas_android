// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;


// Referenced classes of package org.acra.collector:
//            MediaCodecListCollector

static class decType
{

    static final int $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[];

    static 
    {
        $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType = new int[decType.values().length];
        try
        {
            $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[decType.AVC.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[decType.H263.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[decType.MPEG4.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[decType.AAC.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
