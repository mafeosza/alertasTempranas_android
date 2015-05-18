// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;


// Referenced classes of package gnu.kawa.models:
//            Display

public interface Window
{

    public abstract Display getDisplay();

    public abstract String getTitle();

    public abstract void open();

    public abstract void setContent(Object obj);

    public abstract void setMenuBar(Object obj);

    public abstract void setTitle(String s);
}
