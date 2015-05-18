// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.LinearLayout;
import com.google.appinventor.components.runtime.util.ElementsUtil;
import com.google.appinventor.components.runtime.util.YailList;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer, EventDispatcher

public final class ListView extends AndroidViewComponent
    implements android.widget.AdapterView.OnItemClickListener
{

    private static final int DEFAULT_BACKGROUND_COLOR = 0xff000000;
    private static final boolean DEFAULT_ENABLED = false;
    private static final int DEFAULT_TEXT_COLOR = -1;
    private static final int DEFAULT_TEXT_SIZE = 22;
    private static final String LOG_TAG = "ListView";
    private ArrayAdapter adapter;
    private int backgroundColor;
    protected final ComponentContainer container;
    private YailList items;
    private final LinearLayout listViewLayout;
    private String selection;
    private int selectionIndex;
    private boolean showFilter;
    private int textColor;
    private int textSize;
    private EditText txtSearchBox;
    private final android.widget.ListView view;

    public ListView(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        showFilter = false;
        container = componentcontainer;
        items = YailList.makeEmptyList();
        view = new android.widget.ListView(componentcontainer.$context());
        view.setOnItemClickListener(this);
        listViewLayout = new LinearLayout(componentcontainer.$context());
        listViewLayout.setOrientation(1);
        txtSearchBox = new EditText(componentcontainer.$context());
        txtSearchBox.setSingleLine(true);
        txtSearchBox.setWidth(-2);
        txtSearchBox.setPadding(10, 10, 10, 10);
        txtSearchBox.setHint("Search list...");
        txtSearchBox.addTextChangedListener(new TextWatcher() {

            final ListView this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                adapter.getFilter().filter(charsequence);
            }

            
            {
                this$0 = ListView.this;
                super();
            }
        });
        if (showFilter)
        {
            txtSearchBox.setVisibility(0);
        } else
        {
            txtSearchBox.setVisibility(8);
        }
        Width(-2);
        BackgroundColor(0xff000000);
        textColor = -1;
        TextColor(textColor);
        textSize = 22;
        TextSize(textSize);
        ElementsFromString("");
        listViewLayout.addView(txtSearchBox);
        listViewLayout.addView(view);
        listViewLayout.requestLayout();
        componentcontainer.$add(this);
    }

    public void AfterPicking()
    {
        EventDispatcher.dispatchEvent(this, "AfterPicking", new Object[0]);
    }

    public int BackgroundColor()
    {
        return backgroundColor;
    }

    public void BackgroundColor(int i)
    {
        backgroundColor = i;
        setBackgroundColor(backgroundColor);
    }

    public YailList Elements()
    {
        return items;
    }

    public void Elements(YailList yaillist)
    {
        items = ElementsUtil.elements(yaillist, "Listview");
        setAdapterData();
    }

    public void ElementsFromString(String s)
    {
        items = ElementsUtil.elementsFromString(s);
        setAdapterData();
    }

    public void Height(int i)
    {
        int j = i;
        if (i == -1)
        {
            j = -2;
        }
        super.Height(j);
    }

    public String Selection()
    {
        return selection;
    }

    public void Selection(String s)
    {
        selection = s;
        selectionIndex = ElementsUtil.setSelectedIndexFromValue(s, items);
    }

    public int SelectionIndex()
    {
        return selectionIndex;
    }

    public void SelectionIndex(int i)
    {
        selectionIndex = ElementsUtil.selectionIndex(i, items);
        selection = ElementsUtil.setSelectionFromIndex(i, items);
    }

    public void ShowFilterBar(boolean flag)
    {
        showFilter = flag;
        if (flag)
        {
            txtSearchBox.setVisibility(0);
            return;
        } else
        {
            txtSearchBox.setVisibility(8);
            return;
        }
    }

    public boolean ShowFilterBar()
    {
        return showFilter;
    }

    public int TextColor()
    {
        return textColor;
    }

    public void TextColor(int i)
    {
        textColor = i;
        setAdapterData();
    }

    public int TextSize()
    {
        return textSize;
    }

    public void TextSize(int i)
    {
        if (i > 1000)
        {
            textSize = 999;
        } else
        {
            textSize = i;
        }
        setAdapterData();
    }

    public void Width(int i)
    {
        int j = i;
        if (i == -1)
        {
            j = -2;
        }
        super.Width(j);
    }

    public View getView()
    {
        return listViewLayout;
    }

    public Spannable[] itemsToColoredText()
    {
        int j = items.size();
        Spannable aspannable[] = new Spannable[j];
        for (int i = 1; i <= j; i++)
        {
            SpannableString spannablestring = new SpannableString(YailList.YailListElementToString(items.get(i)));
            spannablestring.setSpan(new ForegroundColorSpan(textColor), 0, spannablestring.length(), 0);
            spannablestring.setSpan(new AbsoluteSizeSpan(textSize), 0, spannablestring.length(), 0);
            aspannable[i - 1] = spannablestring;
        }

        return aspannable;
    }

    public void onItemClick(AdapterView adapterview, View view1, int i, long l)
    {
        selection = adapterview.getAdapter().getItem(i).toString();
        selectionIndex = i + 1;
        AfterPicking();
    }

    public void setAdapterData()
    {
        adapter = new ArrayAdapter(container.$context(), 0x1090003, itemsToColoredText());
        view.setAdapter(adapter);
    }

    public void setBackgroundColor(int i)
    {
        backgroundColor = i;
        view.setBackgroundColor(backgroundColor);
        listViewLayout.setBackgroundColor(backgroundColor);
        view.setCacheColorHint(backgroundColor);
    }

}
