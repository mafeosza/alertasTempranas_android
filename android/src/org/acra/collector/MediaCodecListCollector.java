// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MediaCodecListCollector
{
    private static final class CodecType extends Enum
    {

        private static final CodecType $VALUES[];
        public static final CodecType AAC;
        public static final CodecType AVC;
        public static final CodecType H263;
        public static final CodecType MPEG4;

        public static CodecType valueOf(String s)
        {
            return (CodecType)Enum.valueOf(org/acra/collector/MediaCodecListCollector$CodecType, s);
        }

        public static CodecType[] values()
        {
            return (CodecType[])$VALUES.clone();
        }

        static 
        {
            AVC = new CodecType("AVC", 0);
            H263 = new CodecType("H263", 1);
            MPEG4 = new CodecType("MPEG4", 2);
            AAC = new CodecType("AAC", 3);
            $VALUES = (new CodecType[] {
                AVC, H263, MPEG4, AAC
            });
        }

        private CodecType(String s, int i)
        {
            super(s, i);
        }
    }


    private static final String AAC_TYPES[];
    private static final String AVC_TYPES[];
    private static final String COLOR_FORMAT_PREFIX = "COLOR_";
    private static final String H263_TYPES[];
    private static final String MPEG4_TYPES[];
    private static Class codecCapabilitiesClass;
    private static Field colorFormatsField;
    private static Method getCapabilitiesForTypeMethod;
    private static Method getCodecInfoAtMethod;
    private static Method getNameMethod;
    private static Method getSupportedTypesMethod;
    private static Method isEncoderMethod;
    private static Field levelField;
    private static SparseArray mAACProfileValues;
    private static SparseArray mAVCLevelValues;
    private static SparseArray mAVCProfileValues;
    private static SparseArray mColorFormatValues;
    private static SparseArray mH263LevelValues;
    private static SparseArray mH263ProfileValues;
    private static SparseArray mMPEG4LevelValues;
    private static SparseArray mMPEG4ProfileValues;
    private static Class mediaCodecInfoClass;
    private static Class mediaCodecListClass;
    private static Field profileField;
    private static Field profileLevelsField;

    public MediaCodecListCollector()
    {
    }

    public static String collecMediaCodecList()
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (mediaCodecListClass == null || mediaCodecInfoClass == null) goto _L2; else goto _L1
_L1:
        int k = ((Integer)(Integer)mediaCodecListClass.getMethod("getCodecCount", new Class[0]).invoke(null, new Object[0])).intValue();
        int i = 0;
_L5:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        Object obj;
        String as[];
        int l;
        stringbuilder.append("\n");
        obj = getCodecInfoAtMethod.invoke(null, new Object[] {
            Integer.valueOf(i)
        });
        stringbuilder.append(i).append(": ").append(getNameMethod.invoke(obj, new Object[0])).append("\n");
        stringbuilder.append("isEncoder: ").append(isEncoderMethod.invoke(obj, new Object[0])).append("\n");
        as = (String[])(String[])getSupportedTypesMethod.invoke(obj, new Object[0]);
        stringbuilder.append("Supported types: ").append(Arrays.toString(as)).append("\n");
        l = as.length;
        int j = 0;
_L4:
        if (j >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuilder.append(collectCapabilitiesForType(obj, as[j]));
        j++;
        if (true) goto _L4; else goto _L3
_L3:
        stringbuilder.append("\n");
        i++;
        continue; /* Loop/switch isn't completed */
        Object obj1;
        obj1;
        break; /* Loop/switch isn't completed */
        if (true) goto _L5; else goto _L2
_L2:
        return stringbuilder.toString();
        obj1;
          goto _L2
        obj1;
          goto _L2
    }

    private static String collectCapabilitiesForType(Object obj, String s)
        throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {
        StringBuilder stringbuilder;
        Object aobj[];
        int j;
        stringbuilder = new StringBuilder();
        Object obj1 = getCapabilitiesForTypeMethod.invoke(obj, new Object[] {
            s
        });
        int ai[] = (int[])(int[])colorFormatsField.get(obj1);
        if (ai.length > 0)
        {
            stringbuilder.append(s).append(" color formats:");
            for (int i = 0; i < ai.length; i++)
            {
                stringbuilder.append((String)mColorFormatValues.get(ai[i]));
                if (i < ai.length - 1)
                {
                    stringbuilder.append(',');
                }
            }

            stringbuilder.append("\n");
        }
        aobj = (Object[])(Object[])profileLevelsField.get(obj1);
        if (aobj.length <= 0)
        {
            break MISSING_BLOCK_LABEL_418;
        }
        stringbuilder.append(s).append(" profile levels:");
        j = 0;
_L7:
        int k;
        int l;
        if (j >= aobj.length)
        {
            break MISSING_BLOCK_LABEL_411;
        }
        s = identifyCodecType(obj);
        k = profileField.getInt(aobj[j]);
        l = levelField.getInt(aobj[j]);
        if (s == null)
        {
            stringbuilder.append(k).append('-').append(l);
        }
        static class _cls1
        {

            static final int $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[];

            static 
            {
                $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType = new int[CodecType.values().length];
                try
                {
                    $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[CodecType.AVC.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[CodecType.H263.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[CodecType.MPEG4.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$org$acra$collector$MediaCodecListCollector$CodecType[CodecType.AAC.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.org.acra.collector.MediaCodecListCollector.CodecType[s.ordinal()];
        JVM INSTR tableswitch 1 4: default 248
    //                   1 273
    //                   2 316
    //                   3 354
    //                   4 392;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_392;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L8:
        if (j < aobj.length - 1)
        {
            stringbuilder.append(',');
        }
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        stringbuilder.append(k).append((String)mAVCProfileValues.get(k)).append('-').append((String)mAVCLevelValues.get(l));
          goto _L8
_L3:
        stringbuilder.append((String)mH263ProfileValues.get(k)).append('-').append((String)mH263LevelValues.get(l));
          goto _L8
_L4:
        stringbuilder.append((String)mMPEG4ProfileValues.get(k)).append('-').append((String)mMPEG4LevelValues.get(l));
          goto _L8
        stringbuilder.append((String)mAACProfileValues.get(k));
          goto _L8
        stringbuilder.append("\n");
        return stringbuilder.append("\n").toString();
    }

    private static CodecType identifyCodecType(Object obj)
        throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {
        obj = (String)getNameMethod.invoke(obj, new Object[0]);
        String as[] = AVC_TYPES;
        int i1 = as.length;
        for (int i = 0; i < i1; i++)
        {
            if (((String) (obj)).contains(as[i]))
            {
                return CodecType.AVC;
            }
        }

        as = H263_TYPES;
        i1 = as.length;
        for (int j = 0; j < i1; j++)
        {
            if (((String) (obj)).contains(as[j]))
            {
                return CodecType.H263;
            }
        }

        as = MPEG4_TYPES;
        i1 = as.length;
        for (int k = 0; k < i1; k++)
        {
            if (((String) (obj)).contains(as[k]))
            {
                return CodecType.MPEG4;
            }
        }

        as = AAC_TYPES;
        i1 = as.length;
        for (int l = 0; l < i1; l++)
        {
            if (((String) (obj)).contains(as[l]))
            {
                return CodecType.AAC;
            }
        }

        return null;
    }

    static 
    {
        MPEG4_TYPES = (new String[] {
            "mp4", "mpeg4", "MP4", "MPEG4"
        });
        AVC_TYPES = (new String[] {
            "avc", "h264", "AVC", "H264"
        });
        H263_TYPES = (new String[] {
            "h263", "H263"
        });
        AAC_TYPES = (new String[] {
            "aac", "AAC"
        });
        mediaCodecListClass = null;
        getCodecInfoAtMethod = null;
        mediaCodecInfoClass = null;
        getNameMethod = null;
        isEncoderMethod = null;
        getSupportedTypesMethod = null;
        getCapabilitiesForTypeMethod = null;
        codecCapabilitiesClass = null;
        colorFormatsField = null;
        profileLevelsField = null;
        profileField = null;
        levelField = null;
        mColorFormatValues = new SparseArray();
        mAVCLevelValues = new SparseArray();
        mAVCProfileValues = new SparseArray();
        mH263LevelValues = new SparseArray();
        mH263ProfileValues = new SparseArray();
        mMPEG4LevelValues = new SparseArray();
        mMPEG4ProfileValues = new SparseArray();
        mAACProfileValues = new SparseArray();
        Field afield[];
        int j;
        mediaCodecListClass = Class.forName("android.media.MediaCodecList");
        getCodecInfoAtMethod = mediaCodecListClass.getMethod("getCodecInfoAt", new Class[] {
            Integer.TYPE
        });
        mediaCodecInfoClass = Class.forName("android.media.MediaCodecInfo");
        getNameMethod = mediaCodecInfoClass.getMethod("getName", new Class[0]);
        isEncoderMethod = mediaCodecInfoClass.getMethod("isEncoder", new Class[0]);
        getSupportedTypesMethod = mediaCodecInfoClass.getMethod("getSupportedTypes", new Class[0]);
        getCapabilitiesForTypeMethod = mediaCodecInfoClass.getMethod("getCapabilitiesForType", new Class[] {
            java/lang/String
        });
        codecCapabilitiesClass = Class.forName("android.media.MediaCodecInfo$CodecCapabilities");
        colorFormatsField = codecCapabilitiesClass.getField("colorFormats");
        profileLevelsField = codecCapabilitiesClass.getField("profileLevels");
        afield = codecCapabilitiesClass.getFields();
        j = afield.length;
        int i = 0;
_L23:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Field field = afield[i];
        if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers()) && field.getName().startsWith("COLOR_"))
        {
            mColorFormatValues.put(field.getInt(null), field.getName());
        }
          goto _L3
_L2:
        Class class1;
        Field afield1[];
        class1 = Class.forName("android.media.MediaCodecInfo$CodecProfileLevel");
        afield1 = class1.getFields();
        j = afield1.length;
        i = 0;
_L21:
        if (i >= j) goto _L5; else goto _L4
_L4:
        Field field1 = afield1[i];
        if (!Modifier.isStatic(field1.getModifiers()) || !Modifier.isFinal(field1.getModifiers())) goto _L7; else goto _L6
_L6:
        if (!field1.getName().startsWith("AVCLevel")) goto _L9; else goto _L8
_L8:
        mAVCLevelValues.put(field1.getInt(null), field1.getName());
          goto _L7
_L9:
        if (!field1.getName().startsWith("AVCProfile")) goto _L11; else goto _L10
_L10:
        mAVCProfileValues.put(field1.getInt(null), field1.getName());
          goto _L7
_L11:
        if (!field1.getName().startsWith("H263Level")) goto _L13; else goto _L12
_L12:
        mH263LevelValues.put(field1.getInt(null), field1.getName());
          goto _L7
_L13:
        if (!field1.getName().startsWith("H263Profile")) goto _L15; else goto _L14
_L14:
        mH263ProfileValues.put(field1.getInt(null), field1.getName());
          goto _L7
_L15:
        if (!field1.getName().startsWith("MPEG4Level")) goto _L17; else goto _L16
_L16:
        mMPEG4LevelValues.put(field1.getInt(null), field1.getName());
          goto _L7
_L17:
        if (!field1.getName().startsWith("MPEG4Profile")) goto _L19; else goto _L18
_L18:
        mMPEG4ProfileValues.put(field1.getInt(null), field1.getName());
          goto _L7
_L19:
        if (field1.getName().startsWith("AAC"))
        {
            mAACProfileValues.put(field1.getInt(null), field1.getName());
        }
          goto _L7
_L5:
        try
        {
            profileField = class1.getField("profile");
            levelField = class1.getField("level");
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        catch (NoSuchMethodException nosuchmethodexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
        catch (IllegalAccessException illegalaccessexception) { }
        catch (SecurityException securityexception) { }
        catch (NoSuchFieldException nosuchfieldexception) { }
        break; /* Loop/switch isn't completed */
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
_L7:
        i++;
        if (true) goto _L21; else goto _L20
_L20:
        if (true) goto _L23; else goto _L22
_L22:
    }
}
