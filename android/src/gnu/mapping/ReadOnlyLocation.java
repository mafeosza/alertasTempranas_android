// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            ConstrainedLocation, Location

public class ReadOnlyLocation extends ConstrainedLocation
{

    public ReadOnlyLocation()
    {
    }

    public static ReadOnlyLocation make(Location location)
    {
        ReadOnlyLocation readonlylocation = new ReadOnlyLocation();
        readonlylocation.base = location;
        return readonlylocation;
    }

    protected Object coerce(Object obj)
    {
        obj = new StringBuffer("attempt to modify read-only location");
        Symbol symbol = getKeySymbol();
        if (symbol != null)
        {
            ((StringBuffer) (obj)).append(": ");
            ((StringBuffer) (obj)).append(symbol);
        }
        throw new IllegalStateException(((StringBuffer) (obj)).toString());
    }

    public boolean isConstant()
    {
        return true;
    }
}
