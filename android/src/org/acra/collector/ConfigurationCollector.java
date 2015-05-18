// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.acra.collector;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.acra.ACRA;

public final class ConfigurationCollector
{

    private static final String FIELD_MCC = "mcc";
    private static final String FIELD_MNC = "mnc";
    private static final String FIELD_SCREENLAYOUT = "screenLayout";
    private static final String FIELD_UIMODE = "uiMode";
    private static final String PREFIX_HARDKEYBOARDHIDDEN = "HARDKEYBOARDHIDDEN_";
    private static final String PREFIX_KEYBOARD = "KEYBOARD_";
    private static final String PREFIX_KEYBOARDHIDDEN = "KEYBOARDHIDDEN_";
    private static final String PREFIX_NAVIGATION = "NAVIGATION_";
    private static final String PREFIX_NAVIGATIONHIDDEN = "NAVIGATIONHIDDEN_";
    private static final String PREFIX_ORIENTATION = "ORIENTATION_";
    private static final String PREFIX_SCREENLAYOUT = "SCREENLAYOUT_";
    private static final String PREFIX_TOUCHSCREEN = "TOUCHSCREEN_";
    private static final String PREFIX_UI_MODE = "UI_MODE_";
    private static final String SUFFIX_MASK = "_MASK";
    private static SparseArray mHardKeyboardHiddenValues;
    private static SparseArray mKeyboardHiddenValues;
    private static SparseArray mKeyboardValues;
    private static SparseArray mNavigationHiddenValues;
    private static SparseArray mNavigationValues;
    private static SparseArray mOrientationValues;
    private static SparseArray mScreenLayoutValues;
    private static SparseArray mTouchScreenValues;
    private static SparseArray mUiModeValues;
    private static final HashMap mValueArrays;

    public ConfigurationCollector()
    {
    }

    private static String activeFlags(SparseArray sparsearray, int i)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int j = 0; j < sparsearray.size(); j++)
        {
            int k = sparsearray.keyAt(j);
            if (!((String)sparsearray.get(k)).endsWith("_MASK"))
            {
                continue;
            }
            k = i & k;
            if (k <= 0)
            {
                continue;
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append('+');
            }
            stringbuilder.append((String)sparsearray.get(k));
        }

        return stringbuilder.toString();
    }

    public static String collectConfiguration(Context context)
    {
        String s;
        try
        {
            s = toString(context.getResources().getConfiguration());
        }
        catch (RuntimeException runtimeexception)
        {
            Log.w(ACRA.LOG_TAG, (new StringBuilder()).append("Couldn't retrieve CrashConfiguration for : ").append(context.getPackageName()).toString(), runtimeexception);
            return "Couldn't retrieve crash config";
        }
        return s;
    }

    private static String getFieldValueName(Configuration configuration, Field field)
        throws IllegalAccessException
    {
        Object obj = field.getName();
        if (((String) (obj)).equals("mcc") || ((String) (obj)).equals("mnc"))
        {
            obj = Integer.toString(field.getInt(configuration));
        } else
        {
            if (((String) (obj)).equals("uiMode"))
            {
                return activeFlags((SparseArray)mValueArrays.get("UI_MODE_"), field.getInt(configuration));
            }
            if (((String) (obj)).equals("screenLayout"))
            {
                return activeFlags((SparseArray)mValueArrays.get("SCREENLAYOUT_"), field.getInt(configuration));
            }
            obj = (SparseArray)mValueArrays.get((new StringBuilder()).append(((String) (obj)).toUpperCase()).append('_').toString());
            if (obj == null)
            {
                return Integer.toString(field.getInt(configuration));
            }
            String s = (String)((SparseArray) (obj)).get(field.getInt(configuration));
            obj = s;
            if (s == null)
            {
                return Integer.toString(field.getInt(configuration));
            }
        }
        return ((String) (obj));
    }

    public static String toString(Configuration configuration)
    {
        StringBuilder stringbuilder;
        Field afield[];
        int i;
        int j;
        stringbuilder = new StringBuilder();
        afield = configuration.getClass().getFields();
        j = afield.length;
        i = 0;
_L6:
        Field field;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_144;
        }
        field = afield[i];
        if (Modifier.isStatic(field.getModifiers()))
        {
            break MISSING_BLOCK_LABEL_149;
        }
        stringbuilder.append(field.getName()).append('=');
        if (!field.getType().equals(Integer.TYPE)) goto _L2; else goto _L1
_L1:
        stringbuilder.append(getFieldValueName(configuration, field));
_L4:
        stringbuilder.append('\n');
        break MISSING_BLOCK_LABEL_149;
_L2:
        if (field.get(configuration) == null) goto _L4; else goto _L3
_L3:
        stringbuilder.append(field.get(configuration).toString());
          goto _L4
        Object obj;
        obj;
        Log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", ((Throwable) (obj)));
        break MISSING_BLOCK_LABEL_149;
        obj;
        Log.e(ACRA.LOG_TAG, "Error while inspecting device configuration: ", ((Throwable) (obj)));
        break MISSING_BLOCK_LABEL_149;
        return stringbuilder.toString();
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static 
    {
        Field afield[];
        int i;
        int j;
        mHardKeyboardHiddenValues = new SparseArray();
        mKeyboardValues = new SparseArray();
        mKeyboardHiddenValues = new SparseArray();
        mNavigationValues = new SparseArray();
        mNavigationHiddenValues = new SparseArray();
        mOrientationValues = new SparseArray();
        mScreenLayoutValues = new SparseArray();
        mTouchScreenValues = new SparseArray();
        mUiModeValues = new SparseArray();
        mValueArrays = new HashMap();
        mValueArrays.put("HARDKEYBOARDHIDDEN_", mHardKeyboardHiddenValues);
        mValueArrays.put("KEYBOARD_", mKeyboardValues);
        mValueArrays.put("KEYBOARDHIDDEN_", mKeyboardHiddenValues);
        mValueArrays.put("NAVIGATION_", mNavigationValues);
        mValueArrays.put("NAVIGATIONHIDDEN_", mNavigationHiddenValues);
        mValueArrays.put("ORIENTATION_", mOrientationValues);
        mValueArrays.put("SCREENLAYOUT_", mScreenLayoutValues);
        mValueArrays.put("TOUCHSCREEN_", mTouchScreenValues);
        mValueArrays.put("UI_MODE_", mUiModeValues);
        afield = android/content/res/Configuration.getFields();
        j = afield.length;
        i = 0;
_L2:
        Object obj;
        String s;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        obj = afield[i];
        if (!Modifier.isStatic(((Field) (obj)).getModifiers()) || !Modifier.isFinal(((Field) (obj)).getModifiers()))
        {
            break MISSING_BLOCK_LABEL_500;
        }
        s = ((Field) (obj)).getName();
        if (s.startsWith("HARDKEYBOARDHIDDEN_"))
        {
            mHardKeyboardHiddenValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("KEYBOARD_"))
        {
            mKeyboardValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("KEYBOARDHIDDEN_"))
        {
            mKeyboardHiddenValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("NAVIGATION_"))
        {
            mNavigationValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("NAVIGATIONHIDDEN_"))
        {
            mNavigationHiddenValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("ORIENTATION_"))
        {
            mOrientationValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("SCREENLAYOUT_"))
        {
            mScreenLayoutValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        if (s.startsWith("TOUCHSCREEN_"))
        {
            mTouchScreenValues.put(((Field) (obj)).getInt(null), s);
            break MISSING_BLOCK_LABEL_500;
        }
        try
        {
            if (s.startsWith("UI_MODE_"))
            {
                mUiModeValues.put(((Field) (obj)).getInt(null), s);
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w(ACRA.LOG_TAG, "Error while inspecting device configuration: ", ((Throwable) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.w(ACRA.LOG_TAG, "Error while inspecting device configuration: ", ((Throwable) (obj)));
        }
        break MISSING_BLOCK_LABEL_500;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
