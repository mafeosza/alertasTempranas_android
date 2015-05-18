// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Image

class this._cls0 extends ImageView
{

    final Image this$0;

    public boolean verifyDrawable(Drawable drawable)
    {
        super.verifyDrawable(drawable);
        return true;
    }

    (Context context)
    {
        this$0 = Image.this;
        super(context);
    }
}
