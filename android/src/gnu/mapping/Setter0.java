// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Setter, Procedure, Values, WrongArguments

public class Setter0 extends Setter
{

    public Setter0(Procedure procedure)
    {
        super(procedure);
    }

    public Object apply1(Object obj)
        throws Throwable
    {
        getter.set0(obj);
        return Values.empty;
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        int i = aobj.length;
        if (i != 1)
        {
            throw new WrongArguments(this, i);
        } else
        {
            getter.set0(aobj[0]);
            return Values.empty;
        }
    }

    public int numArgs()
    {
        return 4097;
    }
}
