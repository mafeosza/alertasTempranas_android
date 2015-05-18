// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.media.SoundPool;

// Referenced classes of package com.google.appinventor.components.runtime:
//            Sound

private class <init>
{

    final Sound this$0;

    public void setOnloadCompleteListener(SoundPool soundpool)
    {
        soundpool.setOnLoadCompleteListener(new android.media.SoundPool.OnLoadCompleteListener() {

            final Sound.OnLoadHelper this$1;

            public void onLoadComplete(SoundPool soundpool1, int i, int j)
            {
                Sound.access$002(this$0, true);
            }

            
            {
                this$1 = Sound.OnLoadHelper.this;
                super();
            }
        });
    }

    private _cls1.this._cls1()
    {
        this$0 = Sound.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
