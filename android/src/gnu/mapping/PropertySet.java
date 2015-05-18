// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Named, Namespace, Symbol

public abstract class PropertySet
    implements Named
{

    public static final Symbol nameKey;
    private Object properties[];

    public PropertySet()
    {
    }

    public static Object[] setProperty(Object aobj[], Object obj, Object obj1)
    {
        Object aobj2[] = aobj;
        if (aobj2 != null) goto _L2; else goto _L1
_L1:
        Object aobj1[];
        int j;
        aobj1 = new Object[10];
        aobj = aobj1;
        j = 0;
_L4:
        aobj1[j] = obj;
        aobj1[j + 1] = obj1;
        return aobj;
_L2:
        int i = -1;
        j = aobj2.length;
        do
        {
            int k = j - 2;
            if (k < 0)
            {
                break;
            }
            aobj1 = ((Object []) (aobj2[k]));
            if (aobj1 == obj)
            {
                obj = aobj2[k + 1];
                aobj2[k + 1] = obj1;
                return aobj;
            }
            j = k;
            if (aobj1 == null)
            {
                i = k;
                j = k;
            }
        } while (true);
        j = i;
        aobj1 = aobj2;
        if (i < 0)
        {
            j = aobj2.length;
            aobj = new Object[j * 2];
            System.arraycopy(((Object) (aobj2)), 0, ((Object) (aobj)), 0, j);
            aobj1 = aobj;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public String getName()
    {
        Object obj = getProperty(nameKey, null);
        if (obj == null)
        {
            return null;
        }
        if (obj instanceof Symbol)
        {
            return ((Symbol)obj).getName();
        } else
        {
            return obj.toString();
        }
    }

    public Object getProperty(Object obj, Object obj1)
    {
        Object obj2;
label0:
        {
            obj2 = obj1;
            if (properties == null)
            {
                break label0;
            }
            int i = properties.length;
            int j;
            do
            {
                j = i - 2;
                obj2 = obj1;
                if (j < 0)
                {
                    break label0;
                }
                i = j;
            } while (properties[j] != obj);
            obj2 = properties[j + 1];
        }
        return obj2;
    }

    public Object getSymbol()
    {
        return getProperty(nameKey, null);
    }

    public Object removeProperty(Object obj)
    {
        Object aobj[] = properties;
        if (aobj == null)
        {
            return null;
        }
        int i = aobj.length;
        do
        {
            int j = i - 2;
            if (j >= 0)
            {
                i = j;
                if (aobj[j] == obj)
                {
                    obj = aobj[j + 1];
                    aobj[j] = null;
                    aobj[j + 1] = null;
                    return obj;
                }
            } else
            {
                return null;
            }
        } while (true);
    }

    public final void setName(String s)
    {
        setProperty(nameKey, s);
    }

    public void setProperty(Object obj, Object obj1)
    {
        this;
        JVM INSTR monitorenter ;
        properties = setProperty(properties, obj, obj1);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    public final void setSymbol(Object obj)
    {
        setProperty(nameKey, obj);
    }

    static 
    {
        nameKey = Namespace.EmptyNamespace.getSymbol("name");
    }
}
