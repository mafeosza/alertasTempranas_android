// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            NamedLocation, Location, Environment, Symbol

public class PlainLocation extends NamedLocation
{

    public PlainLocation(Symbol symbol, Object obj)
    {
        super(symbol, obj);
    }

    public PlainLocation(Symbol symbol, Object obj, Object obj1)
    {
        super(symbol, obj);
        value = obj1;
    }

    public final Object get(Object obj)
    {
        if (base != null)
        {
            obj = base.get(obj);
        } else
        if (value != Location.UNBOUND)
        {
            return value;
        }
        return obj;
    }

    public boolean isBound()
    {
        if (base != null)
        {
            return base.isBound();
        }
        return value != Location.UNBOUND;
    }

    public final void set(Object obj)
    {
        if (base == null)
        {
            value = obj;
            return;
        }
        if (value == DIRECT_ON_SET)
        {
            base = null;
            value = obj;
            return;
        }
        if (base.isConstant())
        {
            getEnvironment().put(getKeySymbol(), getKeyProperty(), obj);
            return;
        } else
        {
            base.set(obj);
            return;
        }
    }
}
