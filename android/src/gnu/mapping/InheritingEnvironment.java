// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            SimpleEnvironment, Environment, LocationEnumeration, NamedLocation, 
//            IndirectableLocation, SharedLocation, Symbol, Namespace

public class InheritingEnvironment extends SimpleEnvironment
{

    int baseTimestamp;
    Environment inherited[];
    Namespace namespaceMap[];
    int numInherited;
    Object propertyMap[];

    public InheritingEnvironment(String s, Environment environment)
    {
        super(s);
        addParent(environment);
        if (environment instanceof SimpleEnvironment)
        {
            s = (SimpleEnvironment)environment;
            int i = ((SimpleEnvironment) (s)).currentTimestamp + 1;
            s.currentTimestamp = i;
            baseTimestamp = i;
            currentTimestamp = i;
        }
    }

    public void addParent(Environment environment)
    {
        if (numInherited != 0) goto _L2; else goto _L1
_L1:
        inherited = new Environment[4];
_L4:
        inherited[numInherited] = environment;
        numInherited = numInherited + 1;
        return;
_L2:
        if (numInherited <= inherited.length)
        {
            Environment aenvironment[] = new Environment[numInherited * 2];
            System.arraycopy(inherited, 0, aenvironment, 0, numInherited);
            inherited = aenvironment;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public LocationEnumeration enumerateAllLocations()
    {
        LocationEnumeration locationenumeration = new LocationEnumeration(table, 1 << log2Size);
        locationenumeration.env = this;
        if (inherited != null && inherited.length > 0)
        {
            locationenumeration.inherited = inherited[0].enumerateAllLocations();
            locationenumeration.index = 0;
        }
        return locationenumeration;
    }

    public NamedLocation getLocation(Symbol symbol, Object obj, int i, boolean flag)
    {
        NamedLocation namedlocation1 = null;
        this;
        JVM INSTR monitorenter ;
        NamedLocation namedlocation = lookupDirect(symbol, obj, i);
        if (namedlocation == null) goto _L2; else goto _L1
_L1:
        if (flag) goto _L4; else goto _L3
_L3:
        boolean flag1 = namedlocation.isBound();
        if (!flag1) goto _L2; else goto _L4
_L4:
        symbol = namedlocation;
_L12:
        this;
        JVM INSTR monitorexit ;
        return symbol;
_L2:
        if ((flags & 0x20) == 0 || !flag) goto _L6; else goto _L5
_L5:
        namedlocation = inherited[0].getLocation(symbol, obj, i, true);
_L9:
        if (namedlocation == null)
        {
            break MISSING_BLOCK_LABEL_221;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_245;
        }
        namedlocation1 = addUnboundLocation(symbol, obj, i);
        if ((flags & 1) == 0 && namedlocation.isBound())
        {
            redefineError(symbol, obj, namedlocation1);
        }
        namedlocation1.base = namedlocation;
        if (namedlocation.value != IndirectableLocation.INDIRECT_FLUIDS) goto _L8; else goto _L7
_L7:
        namedlocation1.value = namedlocation.value;
_L10:
        symbol = namedlocation1;
        if (!(namedlocation1 instanceof SharedLocation))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((SharedLocation)namedlocation1).timestamp = baseTimestamp;
        symbol = namedlocation1;
        continue; /* Loop/switch isn't completed */
        symbol;
        throw symbol;
_L6:
        namedlocation = lookupInherited(symbol, obj, i);
          goto _L9
_L8:
label0:
        {
            if ((flags & 0x10) == 0)
            {
                break label0;
            }
            namedlocation1.value = IndirectableLocation.DIRECT_ON_SET;
        }
          goto _L10
        namedlocation1.value = null;
          goto _L10
        namedlocation = namedlocation1;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_239;
        }
        namedlocation = addUnboundLocation(symbol, obj, i);
        symbol = namedlocation;
        continue; /* Loop/switch isn't completed */
        symbol = namedlocation;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public final int getNumParents()
    {
        return numInherited;
    }

    public final Environment getParent(int i)
    {
        return inherited[i];
    }

    protected boolean hasMoreElements(LocationEnumeration locationenumeration)
    {
        if (locationenumeration.inherited == null) goto _L2; else goto _L1
_L1:
        NamedLocation namedlocation = locationenumeration.nextLoc;
_L6:
        locationenumeration.inherited.nextLoc = namedlocation;
        if (locationenumeration.inherited.hasMoreElements()) goto _L4; else goto _L3
_L3:
        locationenumeration.prevLoc = null;
        locationenumeration.nextLoc = locationenumeration.inherited.nextLoc;
        int i = locationenumeration.index + 1;
        locationenumeration.index = i;
        if (i != numInherited)
        {
            break; /* Loop/switch isn't completed */
        }
        locationenumeration.inherited = null;
        locationenumeration.bindings = table;
        locationenumeration.index = 1 << log2Size;
_L2:
        return super.hasMoreElements(locationenumeration);
_L4:
        namedlocation = locationenumeration.inherited.nextLoc;
        if (lookup(namedlocation.name, namedlocation.property) == namedlocation)
        {
            locationenumeration.nextLoc = namedlocation;
            return true;
        }
        namedlocation = namedlocation.next;
        if (true) goto _L6; else goto _L5
_L5:
        locationenumeration.inherited = inherited[locationenumeration.index].enumerateAllLocations();
        if (true) goto _L1; else goto _L7
_L7:
    }

    public NamedLocation lookup(Symbol symbol, Object obj, int i)
    {
        NamedLocation namedlocation = super.lookup(symbol, obj, i);
        if (namedlocation != null && namedlocation.isBound())
        {
            return namedlocation;
        } else
        {
            return lookupInherited(symbol, obj, i);
        }
    }

    public NamedLocation lookupInherited(Symbol symbol, Object obj, int i)
    {
        int j = 0;
_L8:
        Object obj1;
        Symbol symbol1;
        Object obj2;
        if (j >= numInherited)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        obj2 = symbol;
        obj1 = obj;
        symbol1 = ((Symbol) (obj2));
        if (namespaceMap == null) goto _L2; else goto _L1
_L1:
        symbol1 = ((Symbol) (obj2));
        if (namespaceMap.length <= j * 2) goto _L2; else goto _L3
_L3:
        Object obj3;
        Object obj4;
        obj3 = namespaceMap[j * 2];
        obj4 = namespaceMap[j * 2 + 1];
        if (obj3 != null) goto _L5; else goto _L4
_L4:
        symbol1 = ((Symbol) (obj2));
        if (obj4 == null) goto _L2; else goto _L5
_L5:
        if (symbol.getNamespace() == obj4) goto _L7; else goto _L6
_L6:
        j++;
          goto _L8
_L7:
        symbol1 = Symbol.make(obj3, symbol.getName());
_L2:
        obj2 = obj1;
        if (propertyMap == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        obj2 = obj1;
        if (propertyMap.length <= j * 2)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        obj3 = propertyMap[j * 2];
        obj4 = propertyMap[j * 2 + 1];
        if (obj3 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = obj1;
        if (obj4 == null)
        {
            break MISSING_BLOCK_LABEL_187;
        }
        if (obj != obj4) goto _L6; else goto _L9
_L9:
        obj2 = obj3;
        obj1 = inherited[j].lookup(symbol1, obj2, i);
        if (obj1 == null || !((NamedLocation) (obj1)).isBound() || (obj1 instanceof SharedLocation) && ((SharedLocation)obj1).timestamp >= baseTimestamp) goto _L6; else goto _L10
_L10:
        return ((NamedLocation) (obj1));
        return null;
    }

    protected void toStringBase(StringBuffer stringbuffer)
    {
        stringbuffer.append(" baseTs:");
        stringbuffer.append(baseTimestamp);
        for (int i = 0; i < numInherited; i++)
        {
            stringbuffer.append(" base:");
            stringbuffer.append(inherited[i].toStringVerbose());
        }

    }
}
