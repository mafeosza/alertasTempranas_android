// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.functions;

import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;

// Referenced classes of package gnu.kawa.functions:
//            ApplyToArgs

public class Apply extends ProcedureN
{

    ApplyToArgs applyToArgs;

    public Apply(String s, ApplyToArgs applytoargs)
    {
        super(s);
        applyToArgs = applytoargs;
    }

    public static Object[] getArguments(Object aobj[], int i, Procedure procedure)
    {
        Object obj;
        int j;
        int l;
        int i1;
        i1 = aobj.length;
        if (i1 < i + 1)
        {
            throw new WrongArguments("apply", 2, (new StringBuilder()).append("(apply proc [args] args) [count:").append(i1).append(" skip:").append(i).append("]").toString());
        }
        obj = aobj[i1 - 1];
        if (obj instanceof Object[])
        {
            Object aobj1[] = (Object[])(Object[])obj;
            if (i1 == 2)
            {
                return aobj1;
            }
            j = aobj1.length;
        } else
        if (obj instanceof Sequence)
        {
            j = ((Sequence)obj).size();
        } else
        {
            j = -1;
        }
        if (j < 0)
        {
            throw new WrongType(procedure, i1, obj, "sequence or array");
        }
        procedure = ((Procedure) (new Object[j + (i1 - i - 1)]));
        for (l = 0; l < i1 - i - 1; l++)
        {
            procedure[l] = aobj[l + i];
        }

        i = l;
        aobj = ((Object []) (obj));
        i1 = j;
        if (!(obj instanceof Object[])) goto _L2; else goto _L1
_L1:
        System.arraycopy(((Object) ((Object[])(Object[])obj)), 0, procedure, l, j);
_L4:
        return procedure;
_L2:
        while (aobj instanceof Pair) 
        {
            aobj = (Pair)aobj;
            procedure[i] = ((Pair) (aobj)).getCar();
            aobj = ((Object []) (((Pair) (aobj)).getCdr()));
            i1--;
            i++;
        }
        if (i1 > 0)
        {
            aobj = (Sequence)aobj;
            int k = 0;
            while (k < i1) 
            {
                procedure[i] = ((Sequence) (aobj)).get(k);
                k++;
                i++;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void apply(CallContext callcontext)
        throws Throwable
    {
        Object aobj[] = callcontext.getArgs();
        applyToArgs.checkN(getArguments(aobj, 0, this), callcontext);
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        return applyToArgs.applyN(getArguments(aobj, 0, this));
    }
}
