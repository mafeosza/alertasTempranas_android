// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            IndirectableLocation, EnvironmentKey, Symbol, Environment, 
//            Location, ThreadLocation, SharedLocation

public abstract class NamedLocation extends IndirectableLocation
    implements java.util.Map.Entry, EnvironmentKey
{

    final Symbol name;
    NamedLocation next;
    final Object property;

    public NamedLocation(NamedLocation namedlocation)
    {
        name = namedlocation.name;
        property = namedlocation.property;
    }

    public NamedLocation(Symbol symbol, Object obj)
    {
        name = symbol;
        property = obj;
    }

    public boolean entered()
    {
        return next != null;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof NamedLocation) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        Object obj1 = (NamedLocation)obj;
        if (name != null) goto _L4; else goto _L3
_L3:
        if (((NamedLocation) (obj1)).name != null)
        {
            continue; /* Loop/switch isn't completed */
        }
_L6:
        if (property == ((NamedLocation) (obj1)).property)
        {
            obj = getValue();
            obj1 = ((NamedLocation) (obj1)).getValue();
            if (obj == obj1)
            {
                return true;
            }
            continue; /* Loop/switch isn't completed */
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (name.equals(((NamedLocation) (obj1)).name)) goto _L6; else goto _L5
_L5:
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L7
_L7:
        return false;
        if (obj == null || obj1 == null) goto _L1; else goto _L8
_L8:
        return obj.equals(obj1);
    }

    public Environment getEnvironment()
    {
        for (NamedLocation namedlocation = this; namedlocation != null; namedlocation = namedlocation.next)
        {
            if (namedlocation.name != null)
            {
                continue;
            }
            Environment environment = (Environment)namedlocation.value;
            if (environment != null)
            {
                return environment;
            }
        }

        return super.getEnvironment();
    }

    public final Object getKey()
    {
        Object obj = this;
        if (property == null)
        {
            obj = name;
        }
        return obj;
    }

    public final Object getKeyProperty()
    {
        return property;
    }

    public final Symbol getKeySymbol()
    {
        return name;
    }

    public int hashCode()
    {
        int j = name.hashCode() ^ System.identityHashCode(property);
        Object obj = getValue();
        int i = j;
        if (obj != null)
        {
            i = j ^ obj.hashCode();
        }
        return i;
    }

    public final boolean matches(EnvironmentKey environmentkey)
    {
        return Symbol.equals(environmentkey.getKeySymbol(), name) && environmentkey.getKeyProperty() == property;
    }

    public final boolean matches(Symbol symbol, Object obj)
    {
        return Symbol.equals(symbol, name) && obj == property;
    }

    public void setRestore(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (value != INDIRECT_FLUIDS) goto _L2; else goto _L1
_L1:
        base.setRestore(obj);
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!(obj instanceof Location))
        {
            break MISSING_BLOCK_LABEL_51;
        }
        value = null;
        base = (Location)obj;
          goto _L3
        obj;
        throw obj;
        value = obj;
        base = null;
          goto _L3
    }

    public Object setWithSave(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (value != INDIRECT_FLUIDS) goto _L2; else goto _L1
_L1:
        obj = base.setWithSave(obj);
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        ThreadLocation threadlocation = ThreadLocation.makeAnonymous(name);
        threadlocation.global.base = base;
        threadlocation.global.value = value;
        setAlias(threadlocation);
        NamedLocation namedlocation = threadlocation.getLocation();
        namedlocation.value = obj;
        namedlocation.base = null;
        obj = threadlocation.global;
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }
}
