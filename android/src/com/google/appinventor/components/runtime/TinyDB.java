// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.JsonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidNonvisibleComponent, Component, Deleteable, ComponentContainer

public class TinyDB extends AndroidNonvisibleComponent
    implements Component, Deleteable
{

    private Context context;
    private SharedPreferences sharedPreferences;

    public TinyDB(ComponentContainer componentcontainer)
    {
        super(componentcontainer.$form());
        context = componentcontainer.$context();
        sharedPreferences = context.getSharedPreferences("TinyDB1", 0);
    }

    public void ClearAll()
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void ClearTag(String s)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(s);
        editor.commit();
    }

    public Object GetTags()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(sharedPreferences.getAll().keySet());
        Collections.sort(arraylist);
        return arraylist;
    }

    public Object GetValue(String s, Object obj)
    {
        s = sharedPreferences.getString(s, "");
        if (s.length() == 0)
        {
            return obj;
        }
        try
        {
            s = ((String) (JsonUtil.getObjectFromJson(s)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Creation Error.");
        }
        return s;
    }

    public void StoreValue(String s, Object obj)
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        try
        {
            editor.putString(s, JsonUtil.getJsonRepresentation(obj));
            editor.commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
        }
    }

    public void onDelete()
    {
        android.content.SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
