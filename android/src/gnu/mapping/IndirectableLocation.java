// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Location, PlainLocation, NamedLocation, Environment, 
//            Symbol

public abstract class IndirectableLocation extends Location
{

    protected static final Object DIRECT_ON_SET = new String("(direct-on-set)");
    protected static final Object INDIRECT_FLUIDS = new String("(indirect-fluids)");
    protected Location base;
    protected Object value;

    public IndirectableLocation()
    {
    }

    public Location getBase()
    {
        if (base == null)
        {
            return this;
        } else
        {
            return base.getBase();
        }
    }

    public Location getBaseForce()
    {
        if (base == null)
        {
            return new PlainLocation(getKeySymbol(), getKeyProperty(), value);
        } else
        {
            return base;
        }
    }

    public Environment getEnvironment()
    {
        if (base instanceof NamedLocation)
        {
            return ((NamedLocation)base).getEnvironment();
        } else
        {
            return null;
        }
    }

    public Object getKeyProperty()
    {
        if (base != null)
        {
            return base.getKeyProperty();
        } else
        {
            return null;
        }
    }

    public Symbol getKeySymbol()
    {
        if (base != null)
        {
            return base.getKeySymbol();
        } else
        {
            return null;
        }
    }

    public boolean isConstant()
    {
        return base != null && base.isConstant();
    }

    public void setAlias(Location location)
    {
        base = location;
        value = INDIRECT_FLUIDS;
    }

    public void setBase(Location location)
    {
        base = location;
        value = null;
    }

    public void undefine()
    {
        base = null;
        value = UNBOUND;
    }

}
