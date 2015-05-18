// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.view.ViewGroup;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent

public interface Layout
{

    public abstract void add(AndroidViewComponent androidviewcomponent);

    public abstract ViewGroup getLayoutManager();
}
