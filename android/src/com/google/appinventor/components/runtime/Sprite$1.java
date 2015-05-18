// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Sprite, EventDispatcher

class val.args
    implements Runnable
{

    final Sprite this$0;
    final Object val$args[];
    final String val$eventName;
    final Sprite val$sprite;

    public void run()
    {
        EventDispatcher.dispatchEvent(val$sprite, val$eventName, val$args);
    }

    atcher()
    {
        this$0 = final_sprite1;
        val$sprite = sprite2;
        val$eventName = s;
        val$args = _5B_Ljava.lang.Object_3B_.this;
        super();
    }
}
