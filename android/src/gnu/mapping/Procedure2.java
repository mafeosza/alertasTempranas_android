// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure, WrongArguments

public abstract class Procedure2 extends Procedure
{

    public Procedure2()
    {
    }

    public Procedure2(String s)
    {
        super(s);
    }

    public Object apply0()
        throws Throwable
    {
        throw new WrongArguments(getName(), 2, "(?)");
    }

    public Object apply1(Object obj)
        throws Throwable
    {
        throw new WrongArguments(this, 1);
    }

    public abstract Object apply2(Object obj, Object obj1)
        throws Throwable;

    public Object apply3(Object obj, Object obj1, Object obj2)
    {
        throw new WrongArguments(this, 3);
    }

    public Object apply4(Object obj, Object obj1, Object obj2, Object obj3)
        throws Throwable
    {
        throw new WrongArguments(this, 4);
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        if (aobj.length != 2)
        {
            throw new WrongArguments(this, aobj.length);
        } else
        {
            return apply2(aobj[0], aobj[1]);
        }
    }

    public int numArgs()
    {
        return 8194;
    }
}
