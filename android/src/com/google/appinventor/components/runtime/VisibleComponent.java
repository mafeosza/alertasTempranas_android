// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;


// Referenced classes of package com.google.appinventor.components.runtime:
//            Component

public abstract class VisibleComponent
    implements Component
{

    protected VisibleComponent()
    {
    }

    public abstract int Height();

    public abstract void Height(int i);

    public abstract int Width();

    public abstract void Width(int i);
}
