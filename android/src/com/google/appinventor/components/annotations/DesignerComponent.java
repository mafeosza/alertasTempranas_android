// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.appinventor.components.annotations;

import com.google.appinventor.components.common.ComponentCategory;
import java.lang.annotation.Annotation;

public interface DesignerComponent
    extends Annotation
{

    public abstract ComponentCategory category();

    public abstract String description();

    public abstract String designerHelpDescription();

    public abstract String iconName();

    public abstract boolean nonVisible();

    public abstract boolean showOnPalette();

    public abstract int version();
}
