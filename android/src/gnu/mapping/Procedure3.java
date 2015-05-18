// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure, WrongArguments

public abstract class Procedure3 extends Procedure
{

    public Procedure3()
    {
    }

    public Procedure3(String s)
    {
        super(s);
    }

    public Object apply0()
    {
        throw new WrongArguments(this, 0);
    }

    public Object apply1(Object obj)
    {
        throw new WrongArguments(this, 1);
    }

    public Object apply2(Object obj, Object obj1)
    {
        throw new WrongArguments(this, 2);
    }

    public abstract Object apply3(Object obj, Object obj1, Object obj2)
        throws Throwable;

    public Object apply4(Object obj, Object obj1, Object obj2, Object obj3)
    {
        throw new WrongArguments(this, 4);
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        if (aobj.length != 3)
        {
            throw new WrongArguments(this, aobj.length);
        } else
        {
            return apply3(aobj[0], aobj[1], aobj[2]);
        }
    }

    public int numArgs()
    {
        return 12291;
    }
}
