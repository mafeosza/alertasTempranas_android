// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            EnvironmentKey, Symbol

public class KeyPair
    implements EnvironmentKey
{

    Symbol name;
    Object property;

    public KeyPair(Symbol symbol, Object obj)
    {
        name = symbol;
        property = obj;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof KeyPair)
        {
            if (property == ((KeyPair) (obj = (KeyPair)obj)).property && (name != null ? name.equals(((KeyPair) (obj)).name) : ((KeyPair) (obj)).name == null))
            {
                return true;
            }
        }
        return false;
    }

    public Object getKeyProperty()
    {
        return property;
    }

    public Symbol getKeySymbol()
    {
        return name;
    }

    public int hashCode()
    {
        return name.hashCode() ^ System.identityHashCode(property);
    }

    public final boolean matches(EnvironmentKey environmentkey)
    {
        return Symbol.equals(environmentkey.getKeySymbol(), name) && environmentkey.getKeyProperty() == property;
    }

    public final boolean matches(Symbol symbol, Object obj)
    {
        return Symbol.equals(symbol, name) && obj == property;
    }

    public String toString()
    {
        return (new StringBuilder()).append("KeyPair[sym:").append(name).append(" prop:").append(property).append("]").toString();
    }
}
