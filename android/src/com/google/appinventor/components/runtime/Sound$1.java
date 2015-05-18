// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Sound, Form

class this._cls0
    implements Runnable
{

    final Sound this$0;

    public void run()
    {
        if (Sound.access$000(Sound.this))
        {
            Sound.access$200(Sound.this);
            return;
        }
        if (Sound.access$300(Sound.this) > 0)
        {
            int _tmp = Sound.access$310(Sound.this);
            Sound.access$400(Sound.this);
            return;
        } else
        {
            form.dispatchErrorOccurredEvent(Sound.access$500(Sound.this), "Play", 710, new Object[] {
                Sound.access$600(Sound.this)
            });
            return;
        }
    }

    ()
    {
        this$0 = Sound.this;
        super();
    }
}
