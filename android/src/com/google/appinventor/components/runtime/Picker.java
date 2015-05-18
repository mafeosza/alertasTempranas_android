// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;
import android.content.Intent;
import com.google.appinventor.components.runtime.util.AnimationUtil;

// Referenced classes of package com.google.appinventor.components.runtime:
//            ButtonBase, ActivityResultListener, EventDispatcher, ComponentContainer, 
//            Form

public abstract class Picker extends ButtonBase
    implements ActivityResultListener
{

    protected final ComponentContainer container;
    protected int requestCode;

    public Picker(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
        container = componentcontainer;
    }

    public void AfterPicking()
    {
        EventDispatcher.dispatchEvent(this, "AfterPicking", new Object[0]);
    }

    public void BeforePicking()
    {
        EventDispatcher.dispatchEvent(this, "BeforePicking", new Object[0]);
    }

    public void Open()
    {
        click();
    }

    public void click()
    {
        BeforePicking();
        if (requestCode == 0)
        {
            requestCode = container.$form().registerForActivityResult(this);
        }
        container.$context().startActivityForResult(getIntent(), requestCode);
        String s = container.$form().getOpenAnimType();
        AnimationUtil.ApplyOpenScreenAnimation(container.$context(), s);
    }

    protected abstract Intent getIntent();
}
