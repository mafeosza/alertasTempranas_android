// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            TableLayout, AndroidViewComponent

class ponent
    implements Runnable
{

    final TableLayout this$0;
    final AndroidViewComponent val$child;

    public void run()
    {
        TableLayout.access$000(TableLayout.this, val$child);
    }

    ponent()
    {
        this$0 = final_tablelayout;
        val$child = AndroidViewComponent.this;
        super();
    }
}
