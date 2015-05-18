// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;

import java.util.AbstractSet;
import java.util.Iterator;

// Referenced classes of package gnu.mapping:
//            LocationEnumeration, SimpleEnvironment

class EnvironmentMappings extends AbstractSet
{

    SimpleEnvironment env;

    public EnvironmentMappings(SimpleEnvironment simpleenvironment)
    {
        env = simpleenvironment;
    }

    public Iterator iterator()
    {
        return new LocationEnumeration(env);
    }

    public int size()
    {
        return env.size();
    }
}
