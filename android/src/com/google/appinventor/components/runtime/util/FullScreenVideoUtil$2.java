// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime.util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.VideoView;
import com.google.appinventor.components.runtime.VideoPlayer;

// Referenced classes of package com.google.appinventor.components.runtime.util:
//            FullScreenVideoUtil

class this._cls0 extends Dialog
{

    final FullScreenVideoUtil this$0;

    public void onStart()
    {
        super.onStart();
        startDialog();
    }

    protected void onStop()
    {
        Bundle bundle = new Bundle();
        bundle.putInt("PositionKey", FullScreenVideoUtil.access$000(FullScreenVideoUtil.this).getCurrentPosition());
        bundle.putBoolean("PlayingKey", FullScreenVideoUtil.access$000(FullScreenVideoUtil.this).isPlaying());
        bundle.putString("SourceKey", FullScreenVideoUtil.access$100(FullScreenVideoUtil.this).getString("SourceKey"));
        FullScreenVideoUtil.access$200(FullScreenVideoUtil.this).fullScreenKilled(bundle);
        super.onStop();
    }

    (Context context, int i)
    {
        this$0 = FullScreenVideoUtil.this;
        super(context, i);
    }
}
