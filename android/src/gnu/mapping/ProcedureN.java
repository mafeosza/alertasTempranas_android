// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            Procedure

public abstract class ProcedureN extends Procedure
{

    public static final Object noArgs[] = new Object[0];

    public ProcedureN()
    {
    }

    public ProcedureN(String s)
    {
        super(s);
    }

    public Object apply0()
        throws Throwable
    {
        return applyN(noArgs);
    }

    public Object apply1(Object obj)
        throws Throwable
    {
        return applyN(new Object[] {
            obj
        });
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        return applyN(new Object[] {
            obj, obj1
        });
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
        throws Throwable
    {
        return applyN(new Object[] {
            obj, obj1, obj2
        });
    }

    public Object apply4(Object obj, Object obj1, Object obj2, Object obj3)
        throws Throwable
    {
        return applyN(new Object[] {
            obj, obj1, obj2, obj3
        });
    }

    public abstract Object applyN(Object aobj[])
        throws Throwable;

}
