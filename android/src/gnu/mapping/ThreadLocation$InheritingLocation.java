// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            ThreadLocation, SharedLocation, NamedLocation

public class this._cls0 extends InheritableThreadLocal
{

    final ThreadLocation this$0;

    protected SharedLocation childValue(NamedLocation namedlocation)
    {
        if (property != ThreadLocation.ANONYMOUS)
        {
            throw new Error();
        }
        Object obj = namedlocation;
        if (namedlocation == null)
        {
            obj = (SharedLocation)getLocation();
        }
        namedlocation = ((NamedLocation) (obj));
        if (((NamedLocation) (obj)).base == null)
        {
            namedlocation = new SharedLocation(name, property, 0);
            namedlocation.value = ((NamedLocation) (obj)).value;
            obj.base = namedlocation;
            obj.value = null;
        }
        obj = new SharedLocation(name, property, 0);
        obj.value = null;
        obj.base = namedlocation;
        return ((SharedLocation) (obj));
    }

    protected volatile Object childValue(Object obj)
    {
        return childValue((NamedLocation)obj);
    }

    public ()
    {
        this$0 = ThreadLocation.this;
        super();
    }
}
