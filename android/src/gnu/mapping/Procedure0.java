// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure, WrongArguments

public abstract class Procedure0 extends Procedure
{

    public Procedure0()
    {
    }

    public Procedure0(String s)
    {
        super(s);
    }

    public abstract Object apply0()
        throws Throwable;

    public Object apply1(Object obj)
    {
        throw new WrongArguments(this, 1);
    }

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
        if (aobj.length != 0)
        {
            throw new WrongArguments(this, aobj.length);
        } else
        {
            return apply0();
        }
    }

    public int numArgs()
    {
        return 0;
    }
}
