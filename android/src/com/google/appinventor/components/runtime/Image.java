// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.appinventor.components.runtime.util.AnimationUtil;
import com.google.appinventor.components.runtime.util.MediaUtil;
import com.google.appinventor.components.runtime.util.ViewUtil;
import java.io.IOException;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, ComponentContainer

public final class Image extends AndroidViewComponent
{

    private String picturePath;
    private final ImageView view;

    public Image(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        picturePath = "";
        view = new ImageView(componentcontainer.$context()) {

            final Image this$0;

            public boolean verifyDrawable(Drawable drawable)
            {
                super.verifyDrawable(drawable);
                return true;
            }

            
            {
                this$0 = Image.this;
                super(context);
            }
        };
        componentcontainer.$add(this);
        view.setFocusable(true);
    }

    public void Animation(String s)
    {
        AnimationUtil.ApplyAnimation(view, s);
    }

    public String Picture()
    {
        return picturePath;
    }

    public void Picture(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        picturePath = s1;
        try
        {
            s = MediaUtil.getBitmapDrawable(container.$form(), picturePath);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("Image", (new StringBuilder()).append("Unable to load ").append(picturePath).toString());
            s = null;
        }
        ViewUtil.setImage(view, s);
    }

    public View getView()
    {
        return view;
    }
}
