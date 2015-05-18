// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.Hashtable;
import java.util.Set;

// Referenced classes of package gnu.mapping:
//            Environment, NamedLocation, PlainLocation, UnboundLocationException, 
//            Location, ThreadLocation, InheritingEnvironment, IndirectableLocation, 
//            Symbol, EnvironmentMappings, LocationEnumeration, SharedLocation

public class SimpleEnvironment extends Environment
{

    int currentTimestamp;
    int log2Size;
    private int mask;
    int num_bindings;
    NamedLocation sharedTail;
    NamedLocation table[];

    public SimpleEnvironment()
    {
        this(64);
    }

    public SimpleEnvironment(int i)
    {
        for (log2Size = 4; i > 1 << log2Size; log2Size = log2Size + 1) { }
        i = 1 << log2Size;
        table = new NamedLocation[i];
        mask = i - 1;
        sharedTail = new PlainLocation(null, null, this);
    }

    public SimpleEnvironment(String s)
    {
        this();
        setName(s);
    }

    public static Location getCurrentLocation(String s)
    {
        return getCurrent().getLocation(s, true);
    }

    public static Object lookup_global(Symbol symbol)
        throws UnboundLocationException
    {
        Location location = getCurrent().lookup(symbol);
        if (location == null)
        {
            throw new UnboundLocationException(symbol);
        } else
        {
            return location.get();
        }
    }

    NamedLocation addLocation(Symbol symbol, Object obj, int i, Location location)
    {
        Object obj1 = location;
        if (location instanceof ThreadLocation)
        {
            obj1 = location;
            if (((ThreadLocation)location).property == obj)
            {
                obj1 = ((ThreadLocation)location).getLocation();
            }
        }
        location = lookupDirect(symbol, obj, i);
        if (obj1 == location)
        {
            return location;
        }
        boolean flag;
        if (location != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            location = addUnboundLocation(symbol, obj, i);
        }
        if ((flags & 3) != 3)
        {
            boolean flag1 = flag;
            if (flag)
            {
                flag1 = location.isBound();
            }
            if (flag1 ? (flags & 2) == 0 : (flags & 1) == 0 && ((Location) (obj1)).isBound())
            {
                redefineError(symbol, obj, location);
            }
        }
        if ((flags & 0x20) != 0)
        {
            location.base = ((SimpleEnvironment)((InheritingEnvironment)this).getParent(0)).addLocation(symbol, obj, i, ((Location) (obj1)));
        } else
        {
            location.base = ((Location) (obj1));
        }
        location.value = IndirectableLocation.INDIRECT_FLUIDS;
        return location;
    }

    public NamedLocation addLocation(Symbol symbol, Object obj, Location location)
    {
        return addLocation(symbol, obj, symbol.hashCode() ^ System.identityHashCode(obj), location);
    }

    protected NamedLocation addUnboundLocation(Symbol symbol, Object obj, int i)
    {
        symbol = newEntry(symbol, obj, i & mask);
        symbol.base = null;
        symbol.value = Location.UNBOUND;
        return symbol;
    }

    public NamedLocation define(Symbol symbol, Object obj, int i, Object obj1)
    {
        i &= mask;
        NamedLocation namedlocation = table[i];
        do
        {
            if (namedlocation == null)
            {
                symbol = newEntry(symbol, obj, i);
                symbol.set(obj1);
                return symbol;
            }
            if (namedlocation.matches(symbol, obj))
            {
                if (namedlocation.isBound() ? !getCanDefine() : !getCanRedefine())
                {
                    redefineError(symbol, obj, namedlocation);
                }
                namedlocation.base = null;
                namedlocation.value = obj1;
                return namedlocation;
            }
            namedlocation = namedlocation.next;
        } while (true);
    }

    public void define(Symbol symbol, Object obj, Object obj1)
    {
        define(symbol, obj, symbol.hashCode() ^ System.identityHashCode(obj), obj1);
    }

    public Set entrySet()
    {
        return new EnvironmentMappings(this);
    }

    public LocationEnumeration enumerateAllLocations()
    {
        return enumerateLocations();
    }

    public LocationEnumeration enumerateLocations()
    {
        LocationEnumeration locationenumeration = new LocationEnumeration(table, 1 << log2Size);
        locationenumeration.env = this;
        return locationenumeration;
    }

    public NamedLocation getLocation(Symbol symbol, Object obj, int i, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        NamedLocation namedlocation = lookup(symbol, obj, i);
        if (namedlocation == null) goto _L2; else goto _L1
_L1:
        symbol = namedlocation;
_L4:
        this;
        JVM INSTR monitorexit ;
        return symbol;
_L2:
        if (!flag)
        {
            symbol = null;
            continue; /* Loop/switch isn't completed */
        }
        symbol = addUnboundLocation(symbol, obj, i);
        if (true) goto _L4; else goto _L3
_L3:
        symbol;
        throw symbol;
    }

    protected boolean hasMoreElements(LocationEnumeration locationenumeration)
    {
        do
        {
            if (locationenumeration.nextLoc == null)
            {
                locationenumeration.prevLoc = null;
                int i = locationenumeration.index - 1;
                locationenumeration.index = i;
                if (i < 0)
                {
                    return false;
                }
                locationenumeration.nextLoc = locationenumeration.bindings[locationenumeration.index];
                if (locationenumeration.nextLoc == null)
                {
                    continue;
                }
            }
            if (locationenumeration.nextLoc.name == null)
            {
                locationenumeration.nextLoc = locationenumeration.nextLoc.next;
            } else
            {
                return true;
            }
        } while (true);
    }

    public NamedLocation lookup(Symbol symbol, Object obj, int i)
    {
        return lookupDirect(symbol, obj, i);
    }

    public NamedLocation lookupDirect(Symbol symbol, Object obj, int i)
    {
        int j = mask;
        for (NamedLocation namedlocation = table[i & j]; namedlocation != null; namedlocation = namedlocation.next)
        {
            if (namedlocation.matches(symbol, obj))
            {
                return namedlocation;
            }
        }

        return null;
    }

    NamedLocation newEntry(Symbol symbol, Object obj, int i)
    {
        NamedLocation namedlocation = newLocation(symbol, obj);
        obj = table[i];
        symbol = ((Symbol) (obj));
        if (obj == null)
        {
            symbol = sharedTail;
        }
        namedlocation.next = symbol;
        table[i] = namedlocation;
        num_bindings = num_bindings + 1;
        if (num_bindings >= table.length)
        {
            rehash();
        }
        return namedlocation;
    }

    NamedLocation newLocation(Symbol symbol, Object obj)
    {
        if ((flags & 8) != 0)
        {
            return new SharedLocation(symbol, obj, currentTimestamp);
        } else
        {
            return new PlainLocation(symbol, obj);
        }
    }

    public void put(Symbol symbol, Object obj, Object obj1)
    {
        boolean flag;
        if ((flags & 4) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = getLocation(symbol, obj, flag);
        if (obj == null)
        {
            throw new UnboundLocationException(symbol);
        }
        if (((Location) (obj)).isConstant())
        {
            throw new IllegalStateException((new StringBuilder()).append("attempt to modify read-only location: ").append(symbol).append(" in ").append(this).append(" loc:").append(obj).toString());
        } else
        {
            ((Location) (obj)).set(obj1);
            return;
        }
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setSymbol(objectinput.readObject());
    }

    public Object readResolve()
        throws ObjectStreamException
    {
        String s = getName();
        Environment environment = (Environment)envTable.get(s);
        if (environment != null)
        {
            return environment;
        } else
        {
            envTable.put(s, this);
            return this;
        }
    }

    protected void redefineError(Symbol symbol, Object obj, Location location)
    {
        throw new IllegalStateException((new StringBuilder()).append("prohibited define/redefine of ").append(symbol).append(" in ").append(this).toString());
    }

    void rehash()
    {
        NamedLocation anamedlocation[];
        NamedLocation anamedlocation1[];
        int i;
        int i1;
        anamedlocation = table;
        i = anamedlocation.length;
        int k = i * 2;
        anamedlocation1 = new NamedLocation[k];
        i1 = k - 1;
_L2:
        NamedLocation namedlocation;
        int l;
        l = i - 1;
        if (l < 0)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        namedlocation = anamedlocation[l];
_L4:
        i = l;
        if (namedlocation == null) goto _L2; else goto _L1
_L1:
        i = l;
        if (namedlocation == sharedTail) goto _L2; else goto _L3
_L3:
        NamedLocation namedlocation1 = namedlocation.next;
        Object obj = namedlocation.name;
        Object obj1 = namedlocation.property;
        int j = (((Symbol) (obj)).hashCode() ^ System.identityHashCode(obj1)) & i1;
        obj1 = anamedlocation1[j];
        obj = obj1;
        if (obj1 == null)
        {
            obj = sharedTail;
        }
        namedlocation.next = ((NamedLocation) (obj));
        anamedlocation1[j] = namedlocation;
        namedlocation = namedlocation1;
          goto _L4
        table = anamedlocation1;
        log2Size = log2Size + 1;
        mask = i1;
        return;
    }

    public int size()
    {
        return num_bindings;
    }

    protected void toStringBase(StringBuffer stringbuffer)
    {
    }

    public String toStringVerbose()
    {
        StringBuffer stringbuffer = new StringBuffer();
        toStringBase(stringbuffer);
        return (new StringBuilder()).append("#<environment ").append(getName()).append(" num:").append(num_bindings).append(" ts:").append(currentTimestamp).append(stringbuffer).append('>').toString();
    }

    public Location unlink(Symbol symbol, Object obj, int i)
    {
        i &= mask;
        NamedLocation namedlocation1 = null;
        NamedLocation namedlocation2;
        for (NamedLocation namedlocation = table[i]; namedlocation != null; namedlocation = namedlocation2)
        {
            namedlocation2 = namedlocation.next;
            if (namedlocation.matches(symbol, obj))
            {
                if (!getCanRedefine())
                {
                    redefineError(symbol, obj, namedlocation);
                }
                if (namedlocation1 == null)
                {
                    table[i] = namedlocation2;
                } else
                {
                    namedlocation1.next = namedlocation;
                }
                num_bindings = num_bindings - 1;
                return namedlocation;
            }
            namedlocation1 = namedlocation;
        }

        return null;
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getSymbol());
    }
}
