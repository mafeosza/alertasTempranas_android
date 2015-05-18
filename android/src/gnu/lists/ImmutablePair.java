// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.lists;


// Referenced classes of package gnu.lists:
//            Pair

public class ImmutablePair extends Pair
{

    public ImmutablePair()
    {
    }

    public ImmutablePair(Object obj, Object obj1)
    {
        car = obj;
        cdr = obj1;
    }

    public void setCar(Object obj)
    {
        throw new UnsupportedOperationException("cannot modify read-only pair");
    }

    public void setCdr(Object obj)
    {
        throw new UnsupportedOperationException("cannot modify read-only pair");
    }
}
