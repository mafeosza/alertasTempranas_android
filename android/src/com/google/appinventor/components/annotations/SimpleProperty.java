// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.annotations;

import java.lang.annotation.Annotation;

// Referenced classes of package com.google.appinventor.components.annotations:
//            PropertyCategory

public interface SimpleProperty
    extends Annotation
{

    public abstract PropertyCategory category();

    public abstract String description();

    public abstract boolean userVisible();
}
