// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.MotionEvent;
import com.google.appinventor.components.runtime.util.BoundingBox;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Canvas, Sprite

class this._cls0 extends android.view.ureListener
{

    final Canvas this$0;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        float f2 = Math.max(0, (int)motionevent.getX());
        float f3 = Math.max(0, (int)motionevent.getY());
        f /= 1000F;
        f1 /= 1000F;
        float f4 = (float)Math.sqrt(f * f + f1 * f1);
        float f5 = (float)(-Math.toDegrees(Math.atan2(f1, f)));
        int i = Width();
        int j = Height();
        motionevent = new BoundingBox(Math.max(0, (int)f2 - 12), Math.max(0, (int)f3 - 12), Math.min(i - 1, (int)f2 + 12), Math.min(j - 1, (int)f3 + 12));
        boolean flag = false;
        motionevent1 = Canvas.access$000(Canvas.this).iterator();
        do
        {
            if (!motionevent1.hasNext())
            {
                break;
            }
            Sprite sprite = (Sprite)motionevent1.next();
            if (sprite.Enabled() && sprite.Visible() && sprite.intersectsWith(motionevent))
            {
                sprite.Flung(f2, f3, f4, f5, f, f1);
                flag = true;
            }
        } while (true);
        Flung(f2, f3, f4, f5, f, f1, flag);
        return true;
    }

    ()
    {
        this$0 = Canvas.this;
        super();
    }
}
