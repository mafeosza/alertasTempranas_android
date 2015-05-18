// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.LocationEnumeration;
import gnu.mapping.NamedLocation;
import gnu.mapping.Symbol;
import gnu.mapping.ThreadLocation;

// Referenced classes of package gnu.expr:
//            Language

public class BuiltinEnvironment extends Environment
{

    static final BuiltinEnvironment instance;

    private BuiltinEnvironment()
    {
    }

    public static BuiltinEnvironment getInstance()
    {
        return instance;
    }

    public NamedLocation addLocation(Symbol symbol, Object obj, Location location)
    {
        throw new RuntimeException();
    }

    public void define(Symbol symbol, Object obj, Object obj1)
    {
        throw new RuntimeException();
    }

    public LocationEnumeration enumerateAllLocations()
    {
        return getLangEnvironment().enumerateAllLocations();
    }

    public LocationEnumeration enumerateLocations()
    {
        return getLangEnvironment().enumerateLocations();
    }

    public Environment getLangEnvironment()
    {
        Language language = Language.getDefaultLanguage();
        if (language == null)
        {
            return null;
        } else
        {
            return language.getLangEnvironment();
        }
    }

    public NamedLocation getLocation(Symbol symbol, Object obj, int i, boolean flag)
    {
        throw new RuntimeException();
    }

    protected boolean hasMoreElements(LocationEnumeration locationenumeration)
    {
        throw new RuntimeException();
    }

    public NamedLocation lookup(Symbol symbol, Object obj, int i)
    {
        Language language;
        if (obj != ThreadLocation.ANONYMOUS)
        {
            if ((language = Language.getDefaultLanguage()) != null)
            {
                return language.lookupBuiltin(symbol, obj, i);
            }
        }
        return null;
    }

    static 
    {
        instance = new BuiltinEnvironment();
        instance.setName("language-builtins");
    }
}
