// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Layout, AndroidViewComponent

public class TableLayout
    implements Layout
{

    private final Handler handler = new Handler();
    private final android.widget.TableLayout layoutManager;
    private int numColumns;
    private int numRows;

    TableLayout(Context context, int i, int j)
    {
        layoutManager = new android.widget.TableLayout(context);
        numColumns = i;
        numRows = j;
        for (int k = 0; k < j; k++)
        {
            TableRow tablerow = new TableRow(context);
            for (int l = 0; l < i; l++)
            {
                tablerow.addView(newEmptyCellView(), l, newEmptyCellLayoutParams());
            }

            layoutManager.addView(tablerow, k, new android.widget.LayoutParams());
        }

    }

    private void addChild(AndroidViewComponent androidviewcomponent)
    {
        int i = androidviewcomponent.Row();
        int j = androidviewcomponent.Column();
        if (i == -1 || j == -1)
        {
            addChildLater(androidviewcomponent);
            return;
        }
        if (i >= 0 && i < numRows)
        {
            if (j >= 0 && j < numColumns)
            {
                TableRow tablerow = (TableRow)layoutManager.getChildAt(i);
                tablerow.removeViewAt(j);
                androidviewcomponent = androidviewcomponent.getView();
                tablerow.addView(androidviewcomponent, j, androidviewcomponent.getLayoutParams());
                return;
            } else
            {
                Log.e("TableLayout", (new StringBuilder()).append("Child has illegal Column property: ").append(androidviewcomponent).toString());
                return;
            }
        } else
        {
            Log.e("TableLayout", (new StringBuilder()).append("Child has illegal Row property: ").append(androidviewcomponent).toString());
            return;
        }
    }

    private void addChildLater(final AndroidViewComponent child)
    {
        handler.post(new Runnable() {

            final TableLayout this$0;
            final AndroidViewComponent val$child;

            public void run()
            {
                addChild(child);
            }

            
            {
                this$0 = TableLayout.this;
                child = androidviewcomponent;
                super();
            }
        });
    }

    private static android.widget.TableRow.LayoutParams newCellLayoutParams()
    {
        return new android.widget.TableRow.LayoutParams();
    }

    private static android.widget.TableRow.LayoutParams newEmptyCellLayoutParams()
    {
        return new android.widget.TableRow.LayoutParams(0, 0);
    }

    private View newEmptyCellView()
    {
        return new TextView(layoutManager.getContext());
    }

    public void add(AndroidViewComponent androidviewcomponent)
    {
        androidviewcomponent.getView().setLayoutParams(newCellLayoutParams());
        addChildLater(androidviewcomponent);
    }

    public ViewGroup getLayoutManager()
    {
        return layoutManager;
    }

    int getNumColumns()
    {
        return numColumns;
    }

    int getNumRows()
    {
        return numRows;
    }

    void setNumColumns(int i)
    {
        if (i > numColumns)
        {
            layoutManager.getContext();
            for (int j = 0; j < numRows; j++)
            {
                TableRow tablerow = (TableRow)layoutManager.getChildAt(j);
                for (int l = numColumns; l < i; l++)
                {
                    tablerow.addView(newEmptyCellView(), l, newEmptyCellLayoutParams());
                }

            }

            numColumns = i;
        } else
        if (i < numColumns)
        {
            for (int k = 0; k < numRows; k++)
            {
                ((TableRow)layoutManager.getChildAt(k)).removeViews(i, numColumns - i);
            }

            numColumns = i;
            return;
        }
    }

    void setNumRows(int i)
    {
        if (i > numRows)
        {
            Context context = layoutManager.getContext();
            for (int j = numRows; j < i; j++)
            {
                TableRow tablerow = new TableRow(context);
                for (int k = 0; k < numColumns; k++)
                {
                    tablerow.addView(newEmptyCellView(), k, newEmptyCellLayoutParams());
                }

                layoutManager.addView(tablerow, j, new android.widget.LayoutParams());
            }

            numRows = i;
        } else
        if (i < numRows)
        {
            layoutManager.removeViews(i, numRows - i);
            numRows = i;
            return;
        }
    }

}
