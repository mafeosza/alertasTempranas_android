// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Setter, Procedure, Values, WrongArguments

public class Setter1 extends Setter
{

    public Setter1(Procedure procedure)
    {
        super(procedure);
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        getter.set1(obj, obj1);
        return Values.empty;
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        int i = aobj.length;
        if (i != 2)
        {
            throw new WrongArguments(this, i);
        } else
        {
            getter.set1(aobj[0], aobj[1]);
            return Values.empty;
        }
    }

    public int numArgs()
    {
        return 8194;
    }
}
