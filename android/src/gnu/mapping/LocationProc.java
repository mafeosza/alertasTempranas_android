// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure0or1, HasSetter, Location, Values, 
//            Setter0, ConstrainedLocation, Procedure, Symbol

public class LocationProc extends Procedure0or1
    implements HasSetter
{

    Location loc;

    public LocationProc(Location location)
    {
        loc = location;
    }

    public LocationProc(Location location, Procedure procedure)
    {
        loc = location;
        if (procedure != null)
        {
            pushConverter(procedure);
        }
    }

    public static LocationProc makeNamed(Symbol symbol, Location location)
    {
        location = new LocationProc(location);
        location.setSymbol(symbol);
        return location;
    }

    public Object apply0()
        throws Throwable
    {
        return loc.get();
    }

    public Object apply1(Object obj)
        throws Throwable
    {
        set0(obj);
        return Values.empty;
    }

    public final Location getLocation()
    {
        return loc;
    }

    public Procedure getSetter()
    {
        return new Setter0(this);
    }

    public void pushConverter(Procedure procedure)
    {
        loc = ConstrainedLocation.make(loc, procedure);
    }

    public void set0(Object obj)
        throws Throwable
    {
        loc.set(obj);
    }

    public String toString()
    {
        if (getSymbol() != null)
        {
            return super.toString();
        } else
        {
            return (new StringBuilder()).append("#<location-proc ").append(loc).append(">").toString();
        }
    }
}
