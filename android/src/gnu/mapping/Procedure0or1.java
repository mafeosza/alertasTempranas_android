// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure, WrongArguments

public abstract class Procedure0or1 extends Procedure
{

    public Procedure0or1()
    {
    }

    public Procedure0or1(String s)
    {
        super(s);
    }

    public abstract Object apply0()
        throws Throwable;

    public abstract Object apply1(Object obj)
        throws Throwable;

    public Object apply2(Object obj, Object obj1)
    {
        throw new WrongArguments(this, 2);
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
    {
        throw new WrongArguments(this, 3);
    }

    public Object apply4(Object obj, Object obj1, Object obj2, Object obj3)
    {
        throw new WrongArguments(this, 4);
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        if (aobj.length == 0)
        {
            return apply0();
        }
        if (aobj.length == 1)
        {
            return apply1(aobj[0]);
        } else
        {
            throw new WrongArguments(this, aobj.length);
        }
    }

    public int numArgs()
    {
        return 4096;
    }
}
