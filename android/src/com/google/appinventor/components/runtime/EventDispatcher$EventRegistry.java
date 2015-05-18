// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import java.util.HashMap;

// Referenced classes of package com.google.appinventor.components.runtime:
//            EventDispatcher, HandlesEventDispatching

private static final class dispatchDelegate
{

    private final HandlesEventDispatching dispatchDelegate;
    private final HashMap eventClosuresMap = new HashMap();


    (HandlesEventDispatching handleseventdispatching)
    {
        dispatchDelegate = handleseventdispatching;
    }
}
