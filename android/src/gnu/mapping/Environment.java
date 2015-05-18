// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.util.Hashtable;

// Referenced classes of package gnu.mapping:
//            PropertySet, SimpleEnvironment, InheritingEnvironment, EnvironmentKey, 
//            NamedLocation, LocationEnumeration, Location, SharedLocation, 
//            Symbol, Namespace, UnboundLocationException

public abstract class Environment extends PropertySet
{
    static class InheritedLocal extends InheritableThreadLocal
    {

        protected Environment childValue(Environment environment)
        {
            Environment environment1 = environment;
            if (environment == null)
            {
                environment1 = Environment.getCurrent();
            }
            environment = environment1.cloneForThread();
            environment.flags = ((SimpleEnvironment) (environment)).flags | 8;
            environment.flags = ((SimpleEnvironment) (environment)).flags & 0xffffffef;
            return environment;
        }

        protected volatile Object childValue(Object obj)
        {
            return childValue((Environment)obj);
        }

        InheritedLocal()
        {
        }
    }


    static final int CAN_DEFINE = 1;
    static final int CAN_IMPLICITLY_DEFINE = 4;
    static final int CAN_REDEFINE = 2;
    static final int DIRECT_INHERITED_ON_SET = 16;
    public static final int INDIRECT_DEFINES = 32;
    static final int THREAD_SAFE = 8;
    protected static final InheritedLocal curEnvironment = new InheritedLocal();
    static final Hashtable envTable = new Hashtable(50);
    static Environment global;
    int flags;

    public Environment()
    {
        flags = 23;
    }

    public static Environment current()
    {
        return getCurrent();
    }

    public static Environment getCurrent()
    {
        Environment environment = (Environment)curEnvironment.get();
        Object obj = environment;
        if (environment == null)
        {
            obj = make(Thread.currentThread().getName(), global);
            obj.flags = ((Environment) (obj)).flags | 8;
            curEnvironment.set(obj);
        }
        return ((Environment) (obj));
    }

    public static Environment getGlobal()
    {
        return global;
    }

    public static Environment getInstance(String s)
    {
        String s1;
        s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        s = envTable;
        s;
        JVM INSTR monitorenter ;
        Object obj = (Environment)envTable.get(s1);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        s;
        JVM INSTR monitorexit ;
        return ((Environment) (obj));
        obj = new SimpleEnvironment();
        ((Environment) (obj)).setName(s1);
        envTable.put(s1, obj);
        s;
        JVM INSTR monitorexit ;
        return ((Environment) (obj));
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static InheritingEnvironment make(String s, Environment environment)
    {
        return new InheritingEnvironment(s, environment);
    }

    public static SimpleEnvironment make()
    {
        return new SimpleEnvironment();
    }

    public static SimpleEnvironment make(String s)
    {
        return new SimpleEnvironment(s);
    }

    public static void restoreCurrent(Environment environment)
    {
        curEnvironment.set(environment);
    }

    public static void setCurrent(Environment environment)
    {
        curEnvironment.set(environment);
    }

    public static void setGlobal(Environment environment)
    {
        global = environment;
    }

    public static Environment setSaveCurrent(Environment environment)
    {
        Environment environment1 = (Environment)curEnvironment.get();
        curEnvironment.set(environment);
        return environment1;
    }

    public static Environment user()
    {
        return getCurrent();
    }

    public abstract NamedLocation addLocation(Symbol symbol, Object obj, Location location);

    public final void addLocation(EnvironmentKey environmentkey, Location location)
    {
        addLocation(environmentkey.getKeySymbol(), environmentkey.getKeyProperty(), location);
    }

    public final void addLocation(NamedLocation namedlocation)
    {
        addLocation(namedlocation.getKeySymbol(), namedlocation.getKeyProperty(), ((Location) (namedlocation)));
    }

    SimpleEnvironment cloneForThread()
    {
        InheritingEnvironment inheritingenvironment1 = new InheritingEnvironment(null, this);
        if (this instanceof InheritingEnvironment)
        {
            InheritingEnvironment inheritingenvironment = (InheritingEnvironment)this;
            int j = inheritingenvironment.numInherited;
            inheritingenvironment1.numInherited = j;
            inheritingenvironment1.inherited = new Environment[j];
            for (int i = 0; i < j; i++)
            {
                inheritingenvironment1.inherited[i] = inheritingenvironment.inherited[i];
            }

        }
        LocationEnumeration locationenumeration = enumerateLocations();
        do
        {
            if (!locationenumeration.hasMoreElements())
            {
                break;
            }
            Object obj = locationenumeration.nextLocation();
            Symbol symbol = ((Location) (obj)).getKeySymbol();
            Object obj1 = ((Location) (obj)).getKeyProperty();
            if (symbol != null && (obj instanceof NamedLocation))
            {
                NamedLocation namedlocation = (NamedLocation)obj;
                obj = namedlocation;
                if (namedlocation.base == null)
                {
                    obj = new SharedLocation(symbol, obj1, 0);
                    obj.value = namedlocation.value;
                    namedlocation.base = ((Location) (obj));
                    namedlocation.value = null;
                }
                inheritingenvironment1.addUnboundLocation(symbol, obj1, symbol.hashCode() ^ System.identityHashCode(obj1)).base = ((Location) (obj));
            }
        } while (true);
        return inheritingenvironment1;
    }

    public final boolean containsKey(Object obj)
    {
        Object obj1 = null;
        Object obj2 = obj;
        if (obj instanceof EnvironmentKey)
        {
            obj = (EnvironmentKey)obj;
            obj2 = ((EnvironmentKey) (obj)).getKeySymbol();
            obj1 = ((EnvironmentKey) (obj)).getKeyProperty();
        }
        if (obj2 instanceof Symbol)
        {
            obj = (Symbol)obj2;
        } else
        {
            obj = getSymbol((String)obj2);
        }
        return isBound(((Symbol) (obj)), obj1);
    }

    public Namespace defaultNamespace()
    {
        return Namespace.getDefault();
    }

    public abstract void define(Symbol symbol, Object obj, Object obj1);

    public abstract LocationEnumeration enumerateAllLocations();

    public abstract LocationEnumeration enumerateLocations();

    public final Object get(EnvironmentKey environmentkey, Object obj)
    {
        return get(environmentkey.getKeySymbol(), environmentkey.getKeyProperty(), obj);
    }

    public Object get(Symbol symbol)
    {
        String s = Location.UNBOUND;
        Object obj = get(symbol, null, s);
        if (obj == s)
        {
            throw new UnboundLocationException(symbol);
        } else
        {
            return obj;
        }
    }

    public Object get(Symbol symbol, Object obj, Object obj1)
    {
        symbol = lookup(symbol, obj);
        if (symbol == null)
        {
            return obj1;
        } else
        {
            return symbol.get(obj1);
        }
    }

    public final Object get(Object obj)
    {
        Object obj1 = null;
        Object obj2 = obj;
        if (obj instanceof EnvironmentKey)
        {
            obj = (EnvironmentKey)obj;
            obj2 = ((EnvironmentKey) (obj)).getKeySymbol();
            obj1 = ((EnvironmentKey) (obj)).getKeyProperty();
        }
        if (obj2 instanceof Symbol)
        {
            obj = (Symbol)obj2;
        } else
        {
            obj = getSymbol((String)obj2);
        }
        return get(((Symbol) (obj)), obj1, null);
    }

    public final Object get(String s, Object obj)
    {
        return get(getSymbol(s), null, obj);
    }

    public boolean getCanDefine()
    {
        return (flags & 1) != 0;
    }

    public boolean getCanRedefine()
    {
        return (flags & 2) != 0;
    }

    public final Object getChecked(String s)
    {
        Object obj = get(s, Location.UNBOUND);
        if (obj == Location.UNBOUND)
        {
            throw new UnboundLocationException((new StringBuilder()).append(s).append(" in ").append(this).toString());
        } else
        {
            return obj;
        }
    }

    public int getFlags()
    {
        return flags;
    }

    public final Object getFunction(Symbol symbol)
    {
        String s = Location.UNBOUND;
        Object obj = get(symbol, EnvironmentKey.FUNCTION, s);
        if (obj == s)
        {
            throw new UnboundLocationException(symbol);
        } else
        {
            return obj;
        }
    }

    public final Object getFunction(Symbol symbol, Object obj)
    {
        return get(symbol, EnvironmentKey.FUNCTION, obj);
    }

    public final Location getLocation(Symbol symbol)
    {
        return getLocation(symbol, null, true);
    }

    public final Location getLocation(Symbol symbol, Object obj)
    {
        return getLocation(symbol, obj, true);
    }

    public final Location getLocation(Object obj, boolean flag)
    {
        Object obj1 = null;
        Object obj2 = obj;
        if (obj instanceof EnvironmentKey)
        {
            obj = (EnvironmentKey)obj;
            obj2 = ((EnvironmentKey) (obj)).getKeySymbol();
            obj1 = ((EnvironmentKey) (obj)).getKeyProperty();
        }
        if (obj2 instanceof Symbol)
        {
            obj = (Symbol)obj2;
        } else
        {
            obj = getSymbol((String)obj2);
        }
        return getLocation(((Symbol) (obj)), obj1, flag);
    }

    public abstract NamedLocation getLocation(Symbol symbol, Object obj, int i, boolean flag);

    public final NamedLocation getLocation(Symbol symbol, Object obj, boolean flag)
    {
        return getLocation(symbol, obj, symbol.hashCode() ^ System.identityHashCode(obj), flag);
    }

    public Symbol getSymbol(String s)
    {
        return defaultNamespace().getSymbol(s);
    }

    protected abstract boolean hasMoreElements(LocationEnumeration locationenumeration);

    public final boolean isBound(Symbol symbol)
    {
        return isBound(symbol, null);
    }

    public boolean isBound(Symbol symbol, Object obj)
    {
        symbol = lookup(symbol, obj);
        if (symbol == null)
        {
            return false;
        } else
        {
            return symbol.isBound();
        }
    }

    public final boolean isLocked()
    {
        return (flags & 3) == 0;
    }

    public final Location lookup(Symbol symbol)
    {
        return getLocation(symbol, null, false);
    }

    public final Location lookup(Symbol symbol, Object obj)
    {
        return getLocation(symbol, obj, false);
    }

    public abstract NamedLocation lookup(Symbol symbol, Object obj, int i);

    public final Object put(Object obj, Object obj1)
    {
        obj = getLocation(obj, true);
        Object obj2 = ((Location) (obj)).get(null);
        ((Location) (obj)).set(obj1);
        return obj2;
    }

    public final Object put(String s, Object obj)
    {
        return put(s, obj);
    }

    public final void put(Symbol symbol, Object obj)
    {
        put(symbol, null, obj);
    }

    public void put(Symbol symbol, Object obj, Object obj1)
    {
        Location location = getLocation(symbol, obj);
        if (location.isConstant())
        {
            define(symbol, obj, obj1);
            return;
        } else
        {
            location.set(obj1);
            return;
        }
    }

    public final void putFunction(Symbol symbol, Object obj)
    {
        put(symbol, EnvironmentKey.FUNCTION, obj);
    }

    public final Object remove(EnvironmentKey environmentkey)
    {
        Symbol symbol = environmentkey.getKeySymbol();
        environmentkey = ((EnvironmentKey) (environmentkey.getKeyProperty()));
        return remove(symbol, environmentkey, symbol.hashCode() ^ System.identityHashCode(environmentkey));
    }

    public final Object remove(Symbol symbol, Object obj)
    {
        return remove(symbol, obj, symbol.hashCode() ^ System.identityHashCode(obj));
    }

    public Object remove(Symbol symbol, Object obj, int i)
    {
        symbol = unlink(symbol, obj, i);
        if (symbol == null)
        {
            return null;
        } else
        {
            obj = symbol.get(null);
            symbol.undefine();
            return obj;
        }
    }

    public final Object remove(Object obj)
    {
        if (obj instanceof EnvironmentKey)
        {
            obj = (EnvironmentKey)obj;
            return remove(((EnvironmentKey) (obj)).getKeySymbol(), ((EnvironmentKey) (obj)).getKeyProperty());
        }
        if (obj instanceof Symbol)
        {
            obj = (Symbol)obj;
        } else
        {
            obj = getSymbol((String)obj);
        }
        return remove(((Symbol) (obj)), null, ((Symbol) (obj)).hashCode() ^ System.identityHashCode(null));
    }

    public final void remove(Symbol symbol)
    {
        remove(symbol, null, symbol.hashCode());
    }

    public final void removeFunction(Symbol symbol)
    {
        remove(symbol, EnvironmentKey.FUNCTION);
    }

    public void setCanDefine(boolean flag)
    {
        if (flag)
        {
            flags = flags | 1;
            return;
        } else
        {
            flags = flags & -2;
            return;
        }
    }

    public void setCanRedefine(boolean flag)
    {
        if (flag)
        {
            flags = flags | 2;
            return;
        } else
        {
            flags = flags & -3;
            return;
        }
    }

    public void setFlag(boolean flag, int i)
    {
        if (flag)
        {
            flags = flags | i;
            return;
        } else
        {
            flags = flags & ~i;
            return;
        }
    }

    public final void setIndirectDefines()
    {
        flags = flags | 0x20;
        ((InheritingEnvironment)this).baseTimestamp = 0x7fffffff;
    }

    public void setLocked()
    {
        flags = flags & -8;
    }

    public String toString()
    {
        return (new StringBuilder()).append("#<environment ").append(getName()).append('>').toString();
    }

    public String toStringVerbose()
    {
        return toString();
    }

    public Location unlink(Symbol symbol, Object obj, int i)
    {
        throw new RuntimeException("unsupported operation: unlink (aka undefine)");
    }

}
