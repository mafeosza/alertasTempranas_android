// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.mapping;


// Referenced classes of package gnu.mapping:
//            ProcedureN, Procedure, Values

public class Setter extends ProcedureN
{

    protected Procedure getter;

    public Setter(Procedure procedure)
    {
        getter = procedure;
        procedure = procedure.getName();
        if (procedure != null)
        {
            setName((new StringBuilder()).append("(setter ").append(procedure).append(")").toString());
        }
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        getter.setN(aobj);
        return Values.empty;
    }

    public int numArgs()
    {
        int i = getter.numArgs();
        if (i < 0)
        {
            return i + 1;
        } else
        {
            return i + 4097;
        }
    }
}
