// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.os.Handler;
import android.widget.FrameLayout;
import com.google.appinventor.components.runtime.util.OnInitializeListener;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Form, EventDispatcher, ReplForm

class this._cls0
    implements Runnable
{

    final Form this$0;

    public void run()
    {
        if (Form.access$000(Form.this) != null && Form.access$000(Form.this).getWidth() != 0 && Form.access$000(Form.this).getHeight() != 0)
        {
            EventDispatcher.dispatchEvent(Form.this, "Initialize", new Object[0]);
            Form.access$202(Form.this, true);
            for (Iterator iterator = Form.access$300(Form.this).iterator(); iterator.hasNext(); ((OnInitializeListener)iterator.next()).onInitialize()) { }
            if (Form.activeForm instanceof ReplForm)
            {
                ((ReplForm)Form.activeForm).HandleReturnValues();
            }
            return;
        } else
        {
            Form.access$100(Form.this).post(this);
            return;
        }
    }

    m()
    {
        this$0 = Form.this;
        super();
    }
}
