// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            NamedLocation, Location, Environment, Symbol

public class SharedLocation extends NamedLocation
{

    int timestamp;

    public SharedLocation(Symbol symbol, Object obj, int i)
    {
        super(symbol, obj);
        timestamp = i;
    }

    public final Object get(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (base == null) goto _L2; else goto _L1
_L1:
        obj = base.get(obj);
_L4:
        this;
        JVM INSTR monitorexit ;
        return obj;
_L2:
        if (value != Location.UNBOUND)
        {
            obj = value;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj;
        throw obj;
    }

    public boolean isBound()
    {
        this;
        JVM INSTR monitorenter ;
        if (base == null) goto _L2; else goto _L1
_L1:
        boolean flag = base.isBound();
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        Object obj;
        String s;
        obj = value;
        s = Location.UNBOUND;
        if (obj != s)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void set(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        if (base != null) goto _L2; else goto _L1
_L1:
        value = obj;
_L3:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (value != DIRECT_ON_SET)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        base = null;
        value = obj;
          goto _L3
        obj;
        throw obj;
label0:
        {
            if (!base.isConstant())
            {
                break label0;
            }
            getEnvironment().put(getKeySymbol(), getKeyProperty(), obj);
        }
          goto _L3
        base.set(obj);
          goto _L3
    }
}
