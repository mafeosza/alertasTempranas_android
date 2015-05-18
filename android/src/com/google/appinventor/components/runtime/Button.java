// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            ButtonBase, EventDispatcher, ComponentContainer

public final class Button extends ButtonBase
{

    public Button(ComponentContainer componentcontainer)
    {
        super(componentcontainer);
    }

    public void Click()
    {
        EventDispatcher.dispatchEvent(this, "Click", new Object[0]);
    }

    public boolean LongClick()
    {
        return EventDispatcher.dispatchEvent(this, "LongClick", new Object[0]);
    }

    public void click()
    {
        Click();
    }

    public boolean longClick()
    {
        return LongClick();
    }
}
