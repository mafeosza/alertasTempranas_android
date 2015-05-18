// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.json.zip;


// Referenced classes of package org.json.zip:
//            None, PostMortem, JSONzip

abstract class Keep
    implements None, PostMortem
{

    protected int capacity;
    protected int length;
    protected int power;
    protected long uses[];

    public Keep(int i)
    {
        capacity = JSONzip.twos[i];
        length = 0;
        power = 0;
        uses = new long[capacity];
    }

    public static long age(long l)
    {
        if (l >= 32L)
        {
            return 16L;
        } else
        {
            return l / 2L;
        }
    }

    public int bitsize()
    {
        for (; JSONzip.twos[power] < length; power = power + 1) { }
        return power;
    }

    public void tick(int i)
    {
        long al[] = uses;
        al[i] = al[i] + 1L;
    }

    public abstract Object value(int i);
}
