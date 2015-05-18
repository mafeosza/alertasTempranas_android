// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.models;


// Referenced classes of package gnu.kawa.models:
//            Viewable, WeakListener, ModelListener

public abstract class Model
    implements Viewable
{

    transient WeakListener listeners;

    public Model()
    {
    }

    public void addListener(ModelListener modellistener)
    {
        listeners = new WeakListener(modellistener, listeners);
    }

    public void addListener(WeakListener weaklistener)
    {
        weaklistener.next = listeners;
        listeners = weaklistener;
    }

    public void notifyListeners(String s)
    {
        WeakListener weaklistener1 = null;
        WeakListener weaklistener = listeners;
        while (weaklistener != null) 
        {
            Object obj = weaklistener.get();
            WeakListener weaklistener3 = weaklistener.next;
            if (obj == null)
            {
                weaklistener = weaklistener1;
                if (weaklistener1 != null)
                {
                    weaklistener1.next = weaklistener3;
                    weaklistener = weaklistener1;
                }
            } else
            {
                WeakListener weaklistener2 = weaklistener;
                weaklistener.update(obj, this, s);
                weaklistener = weaklistener2;
            }
            weaklistener1 = weaklistener;
            weaklistener = weaklistener3;
        }
    }
}
