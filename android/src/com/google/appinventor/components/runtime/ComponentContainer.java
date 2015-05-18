// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.runtime;

import android.app.Activity;

// Referenced classes of package com.google.appinventor.components.runtime:
//            AndroidViewComponent, Form

public interface ComponentContainer
{

    public abstract void $add(AndroidViewComponent androidviewcomponent);

    public abstract Activity $context();

    public abstract Form $form();

    public abstract void setChildHeight(AndroidViewComponent androidviewcomponent, int i);

    public abstract void setChildWidth(AndroidViewComponent androidviewcomponent, int i);
}
