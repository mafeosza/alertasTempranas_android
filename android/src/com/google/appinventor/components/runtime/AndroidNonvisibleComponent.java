// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Component, Form, HandlesEventDispatching

public abstract class AndroidNonvisibleComponent
    implements Component
{

    protected final Form form;

    protected AndroidNonvisibleComponent(Form form1)
    {
        form = form1;
    }

    public HandlesEventDispatching getDispatchDelegate()
    {
        return form;
    }
}
