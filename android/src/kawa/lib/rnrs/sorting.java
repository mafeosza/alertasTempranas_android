// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.srfi95;
import kawa.standard.append;

public class sorting extends ModuleBody
{

    public static final sorting $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    public static final ModuleMethod list$Mnsort;
    public static final ModuleMethod vector$Mnsort;
    public static final ModuleMethod vector$Mnsort$Ex;

    public sorting()
    {
        ModuleInfo.register(this);
    }

    public static Object listSort(Object obj, Object obj1)
    {
        return srfi95.$PcSortList(append.append$V(new Object[] {
            obj1, LList.Empty
        }), obj, Boolean.FALSE);
    }

    public static void vectorSort(Object obj, Object obj1)
    {
        Sequence sequence;
        try
        {
            sequence = (Sequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%sort-vector", 1, obj1);
        }
        srfi95.$PcSortVector(sequence, obj, Boolean.FALSE);
    }

    public static void vectorSort$Ex(Object obj, Object obj1)
    {
        Sequence sequence;
        try
        {
            sequence = (Sequence)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%vector-sort!", 1, obj1);
        }
        srfi95.$PcVectorSort$Ex(sequence, obj, Boolean.FALSE);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 1: // '\001'
            return listSort(obj, obj1);

        case 2: // '\002'
            vectorSort(obj, obj1);
            return Values.empty;

        case 3: // '\003'
            vectorSort$Ex(obj, obj1);
            break;
        }
        return Values.empty;
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit2 = (SimpleSymbol)(new SimpleSymbol("vector-sort!")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("vector-sort")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("list-sort")).readResolve();
        $instance = new sorting();
        sorting sorting1 = $instance;
        list$Mnsort = new ModuleMethod(sorting1, 1, Lit0, 8194);
        vector$Mnsort = new ModuleMethod(sorting1, 2, Lit1, 8194);
        vector$Mnsort$Ex = new ModuleMethod(sorting1, 3, Lit2, 8194);
        $instance.run();
    }
}
