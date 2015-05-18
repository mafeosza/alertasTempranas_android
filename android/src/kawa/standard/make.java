// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.ClassType;
import gnu.expr.Keyword;
import gnu.mapping.ProcedureN;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.mapping.WrongType;
import kawa.lang.Record;

public class make extends ProcedureN
{

    public make()
    {
    }

    public Object applyN(Object aobj[])
    {
        int j = aobj.length;
        if (j == 0)
        {
            throw new WrongArguments(this, j);
        }
        Object obj1 = aobj[0];
        Object obj;
        if (obj1 instanceof Class)
        {
            obj = (Class)obj1;
        } else
        if (obj1 instanceof ClassType)
        {
            obj = ((ClassType)obj1).getReflectClass();
        } else
        {
            obj = null;
        }
        if (obj == null)
        {
            throw new WrongType(this, 1, obj1, "class");
        }
        int i;
        try
        {
            obj = ((Class) (obj)).newInstance();
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new WrappedException(((Throwable) (aobj)));
        }
        for (i = 1; i < j;)
        {
            int k = i + 1;
            Keyword keyword = (Keyword)aobj[i];
            i = k + 1;
            Record.set1(aobj[k], keyword.getName(), obj);
        }

        return obj;
    }

    public int numArgs()
    {
        return -4095;
    }
}
