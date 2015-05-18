// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public final class Spinner extends AndroidViewComponent
    implements android.widget.AdapterView.OnItemSelectedListener
{

    private ArrayAdapter adapter;
    private boolean isInitialized;
    private YailList items;
    private String selection;
    private int selectionIndex;
    private final android.widget.Spinner view;

    public Spinner(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        items = new YailList();
        isInitialized = false;
        view = new android.widget.Spinner(componentcontainer.$context());
        adapter = new ArrayAdapter(componentcontainer.$context(), 0x1090008);
        adapter.setDropDownViewResource(0x1090009);
        view.setAdapter(adapter);
        view.setOnItemSelectedListener(this);
        componentcontainer.$add(this);
    }

    private void setAdapterData(String as[])
    {
        adapter.clear();
        for (int i = 0; i < as.length; i++)
        {
            adapter.add(as[i]);
        }

    }

    public void AfterSelecting(String s)
    {
        EventDispatcher.dispatchEvent(this, "AfterSelecting", new Object[] {
            s
        });
    }

    public void DisplayDropdown()
    {
        view.performClick();
    }

    public YailList Elements()
    {
        return items;
    }

    public void Elements(YailList yaillist)
    {
        items = ElementsUtil.elements(yaillist, "Spinner");
        isInitialized = false;
        setAdapterData(yaillist.toStringArray());
    }

    public void ElementsFromString(String s)
    {
        items = ElementsUtil.elementsFromString(s);
        setAdapterData(s.split(" *, *"));
    }

    public String Prompt()
    {
        return view.getPrompt().toString();
    }

    public void Prompt(String s)
    {
        view.setPrompt(s);
    }

    public String Selection()
    {
        return selection;
    }

    public void Selection(String s)
    {
        selection = s;
        view.setSelection(adapter.getPosition(s));
        selectionIndex = ElementsUtil.setSelectedIndexFromValue(s, items);
    }

    public int SelectionIndex()
    {
        return selectionIndex;
    }

    public void SelectionIndex(int i)
    {
        selectionIndex = ElementsUtil.selectionIndex(i, items);
        view.setSelection(selectionIndex - 1);
        selection = ElementsUtil.setSelectionFromIndex(i, items);
    }

    public View getView()
    {
        return view;
    }

    public void onItemSelected(AdapterView adapterview, View view1, int i, long l)
    {
        if (!isInitialized)
        {
            isInitialized = true;
            return;
        } else
        {
            SelectionIndex(i + 1);
            AfterSelecting(selection);
            return;
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
        view.setSelection(0);
    }
}
