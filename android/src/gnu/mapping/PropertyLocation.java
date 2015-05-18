// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import gnu.lists.LList;
import gnu.lists.Pair;

// Referenced classes of package gnu.mapping:
//            Location, Environment, Symbol, Namespace

public class PropertyLocation extends Location
{

    Pair pair;

    public PropertyLocation()
    {
    }

    public static Object getProperty(Object obj, Object obj1, Object obj2)
    {
        return getProperty(obj, obj1, obj2, Environment.getCurrent());
    }

    public static Object getProperty(Object obj, Object obj1, Object obj2, Environment environment)
    {
label0:
        {
            Object obj3 = obj;
            if (!(obj instanceof Symbol))
            {
                if (!(obj instanceof String))
                {
                    break label0;
                }
                obj3 = Namespace.getDefaultSymbol((String)obj);
            }
            return environment.get((Symbol)obj3, obj1, obj2);
        }
        return plistGet(environment.get(Symbol.PLIST, obj, LList.Empty), obj1, obj2);
    }

    public static Object getPropertyList(Object obj)
    {
        return Environment.getCurrent().get(Symbol.PLIST, obj, LList.Empty);
    }

    public static Object getPropertyList(Object obj, Environment environment)
    {
        return environment.get(Symbol.PLIST, obj, LList.Empty);
    }

    public static Object plistGet(Object obj, Object obj1, Object obj2)
    {
        Object obj3;
        do
        {
            obj3 = obj2;
            if (!(obj instanceof Pair))
            {
                break;
            }
            obj3 = (Pair)obj;
            if (((Pair) (obj3)).getCar() != obj1)
            {
                continue;
            }
            obj3 = ((Pair)((Pair) (obj3)).getCdr()).getCar();
            break;
        } while (true);
        return obj3;
    }

    public static Object plistPut(Object obj, Object obj1, Object obj2)
    {
        Pair pair1;
        for (Object obj3 = obj; obj3 instanceof Pair; obj3 = pair1.getCdr())
        {
            obj3 = (Pair)obj3;
            pair1 = (Pair)((Pair) (obj3)).getCdr();
            if (((Pair) (obj3)).getCar() == obj1)
            {
                pair1.setCar(obj2);
                return obj;
            }
        }

        return new Pair(obj1, new Pair(obj2, obj));
    }

    public static Object plistRemove(Object obj, Object obj1)
    {
        Object obj2 = null;
        Object obj3 = obj;
        do
        {
            Object obj4;
label0:
            {
label1:
                {
                    obj4 = obj;
                    if (obj3 instanceof Pair)
                    {
                        Pair pair1 = (Pair)obj3;
                        obj4 = (Pair)pair1.getCdr();
                        obj3 = ((Pair) (obj4)).getCdr();
                        if (pair1.getCar() != obj1)
                        {
                            break label0;
                        }
                        if (obj2 != null)
                        {
                            break label1;
                        }
                        obj4 = obj3;
                    }
                    return obj4;
                }
                ((Pair) (obj2)).setCdr(obj3);
                return obj;
            }
            obj2 = obj4;
        } while (true);
    }

    public static void putProperty(Object obj, Object obj1, Object obj2)
    {
        putProperty(obj, obj1, obj2, Environment.getCurrent());
    }

    public static void putProperty(Object obj, Object obj1, Object obj2, Environment environment)
    {
        Object obj3;
label0:
        {
label1:
            {
                obj3 = obj;
                if (!(obj instanceof Symbol))
                {
                    if (!(obj instanceof String))
                    {
                        break label1;
                    }
                    obj3 = Namespace.getDefaultSymbol((String)obj);
                }
                obj = environment.lookup((Symbol)obj3, obj1);
                if (obj != null)
                {
                    obj = ((Location) (obj)).getBase();
                    if (obj instanceof PropertyLocation)
                    {
                        ((PropertyLocation)obj).set(obj2);
                        return;
                    }
                }
                break label0;
            }
            obj = environment.getLocation(Symbol.PLIST, obj);
            ((Location) (obj)).set(plistPut(((Location) (obj)).get(LList.Empty), obj1, obj2));
            return;
        }
        obj = environment.getLocation(Symbol.PLIST, obj3);
        obj2 = new Pair(obj2, ((Location) (obj)).get(LList.Empty));
        ((Location) (obj)).set(new Pair(obj1, obj2));
        obj = new PropertyLocation();
        obj.pair = ((Pair) (obj2));
        environment.addLocation((Symbol)obj3, obj1, ((Location) (obj)));
    }

    public static boolean removeProperty(Object obj, Object obj1)
    {
        return removeProperty(obj, obj1, Environment.getCurrent());
    }

    public static boolean removeProperty(Object obj, Object obj1, Environment environment)
    {
        Location location = environment.lookup(Symbol.PLIST, obj);
        if (location != null) goto _L2; else goto _L1
_L1:
        Object obj2;
        return false;
_L2:
        if (!((obj2 = location.get(LList.Empty)) instanceof Pair)) goto _L1; else goto _L3
_L3:
        Object obj3;
        obj2 = (Pair)obj2;
        obj3 = null;
_L5:
        if (((Pair) (obj2)).getCar() == obj1)
        {
            obj2 = ((Pair)((Pair) (obj2)).getCdr()).getCdr();
            Object obj4;
            if (obj3 == null)
            {
                location.set(obj2);
            } else
            {
                ((Pair) (obj3)).setCdr(obj2);
            }
            if (obj instanceof Symbol)
            {
                environment.remove((Symbol)obj, obj1);
            }
            return true;
        }
        obj4 = ((Pair) (obj2)).getCdr();
        if (!(obj4 instanceof Pair)) goto _L1; else goto _L4
_L4:
        obj3 = obj2;
        obj2 = (Pair)obj4;
          goto _L5
    }

    public static void setPropertyList(Object obj, Object obj1)
    {
        setPropertyList(obj, obj1, Environment.getCurrent());
    }

    public static void setPropertyList(Object obj, Object obj1, Environment environment)
    {
        environment;
        JVM INSTR monitorenter ;
        Location location = environment.lookup(Symbol.PLIST, obj);
        if (!(obj instanceof Symbol)) goto _L2; else goto _L1
_L1:
        Symbol symbol;
        symbol = (Symbol)obj;
        obj = location.get(LList.Empty);
_L6:
        if (obj instanceof Pair) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L7:
        if (obj instanceof Pair) goto _L5; else goto _L2
_L2:
        location.set(obj1);
        environment;
        JVM INSTR monitorexit ;
        return;
_L4:
        obj = (Pair)obj;
        Object obj2 = ((Pair) (obj)).getCar();
        if (plistGet(obj1, obj2, null) != null)
        {
            environment.remove(symbol, obj2);
        }
        obj = ((Pair)((Pair) (obj)).getCdr()).getCdr();
          goto _L6
_L5:
        Pair pair1;
        Object obj3;
        pair1 = (Pair)obj;
        obj3 = pair1.getCar();
        obj = environment.lookup(symbol, obj3);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_168;
        }
        obj = ((Location) (obj)).getBase();
        if (!(obj instanceof PropertyLocation))
        {
            break MISSING_BLOCK_LABEL_168;
        }
        obj = (PropertyLocation)obj;
_L8:
        pair1 = (Pair)pair1.getCdr();
        obj.pair = pair1;
        obj = pair1.getCdr();
          goto _L7
        obj = new PropertyLocation();
        environment.addLocation(symbol, obj3, ((Location) (obj)));
          goto _L8
        obj;
        environment;
        JVM INSTR monitorexit ;
        throw obj;
          goto _L6
    }

    public final Object get(Object obj)
    {
        return pair.getCar();
    }

    public boolean isBound()
    {
        return true;
    }

    public final void set(Object obj)
    {
        pair.setCar(obj);
    }
}
