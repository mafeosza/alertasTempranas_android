// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;

import java.lang.ref.WeakReference;

// Referenced classes of package gnu.kawa.models:
//            ModelListener, Model

public class WeakListener extends WeakReference
{

    WeakListener next;

    public WeakListener(Object obj)
    {
        super(obj);
    }

    public WeakListener(Object obj, WeakListener weaklistener)
    {
        super(obj);
        next = weaklistener;
    }

    public void update(Object obj, Model model, Object obj1)
    {
        ((ModelListener)obj).modelUpdated(model, obj1);
    }
}
