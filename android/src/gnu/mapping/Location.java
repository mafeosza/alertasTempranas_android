// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.io.PrintWriter;

// Referenced classes of package gnu.mapping:
//            PlainLocation, Namespace, ThreadLocation, UnboundLocationException, 
//            Symbol, IndirectableLocation

public abstract class Location
{

    public static final String UNBOUND = new String("(unbound)");

    public Location()
    {
    }

    public static IndirectableLocation make(Symbol symbol)
    {
        symbol = new PlainLocation(symbol, null);
        symbol.base = null;
        symbol.value = UNBOUND;
        return symbol;
    }

    public static IndirectableLocation make(String s)
    {
        s = new PlainLocation(Namespace.EmptyNamespace.getSymbol(s.intern()), null);
        s.base = null;
        s.value = UNBOUND;
        return s;
    }

    public static Location make(Object obj, String s)
    {
        s = new ThreadLocation(s);
        s.setGlobal(obj);
        return s;
    }

    public boolean entered()
    {
        return false;
    }

    public final Object get()
    {
        String s = UNBOUND;
        Object obj = get(s);
        if (obj == s)
        {
            throw new UnboundLocationException(this);
        } else
        {
            return obj;
        }
    }

    public abstract Object get(Object obj);

    public Location getBase()
    {
        return this;
    }

    public Object getKeyProperty()
    {
        return null;
    }

    public Symbol getKeySymbol()
    {
        return null;
    }

    public final Object getValue()
    {
        return get(null);
    }

    public boolean isBound()
    {
        String s = UNBOUND;
        return get(s) != s;
    }

    public boolean isConstant()
    {
        return false;
    }

    public void print(PrintWriter printwriter)
    {
        printwriter.print("#<location ");
        Object obj = getKeySymbol();
        if (obj != null)
        {
            printwriter.print(obj);
        }
        obj = UNBOUND;
        Object obj1 = get(obj);
        if (obj1 != obj)
        {
            printwriter.print(" -> ");
            printwriter.print(obj1);
        } else
        {
            printwriter.print("(unbound)");
        }
        printwriter.print('>');
    }

    public abstract void set(Object obj);

    public void setRestore(Object obj)
    {
        set(obj);
    }

    public final Object setValue(Object obj)
    {
        Object obj1 = get(null);
        set(obj);
        return obj1;
    }

    public Object setWithSave(Object obj)
    {
        Object obj1 = get(UNBOUND);
        set(obj);
        return obj1;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getClass().getName());
        Object obj = getKeySymbol();
        stringbuffer.append('[');
        if (obj != null)
        {
            stringbuffer.append(obj);
            obj = getKeyProperty();
            if (obj != null && obj != this)
            {
                stringbuffer.append('/');
                stringbuffer.append(obj);
            }
        }
        stringbuffer.append("]");
        return stringbuffer.toString();
    }

    public void undefine()
    {
        set(UNBOUND);
    }

}
