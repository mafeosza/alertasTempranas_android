// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import kawa.lib.strings;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    Object end1;
    final ModuleMethod lambda$Fn206 = new ModuleMethod(this, 181, null, 0);
    final ModuleMethod lambda$Fn207 = new ModuleMethod(this, 182, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s1;
    Object s2;
    Object start1;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 181)
        {
            return lambda206();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 182)
        {
            return lambda207(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda206()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreplace, s2, maybe$Mnstart$Plend);
    }

    CharSequence lambda207(Object obj, Object obj1)
    {
        Object obj2 = s1;
        Object obj3;
        Object obj4;
        CharSequence charsequence;
        int i;
        int j;
        int k;
        int l;
        try
        {
            obj3 = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj2);
        }
        i = strings.stringLength(((CharSequence) (obj3)));
        obj3 = AddOp.$Mn.apply2(obj1, obj);
        obj2 = AddOp.$Pl.apply2(AddOp.$Mn.apply2(Integer.valueOf(i), AddOp.$Mn.apply2(end1, start1)), obj3);
        try
        {
            j = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj2);
        }
        obj2 = strings.makeString(j);
        obj4 = s1;
        try
        {
            charsequence = (CharSequence)obj4;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 2, obj4);
        }
        obj4 = start1;
        try
        {
            j = ((Number)obj4).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 4, obj4);
        }
        srfi13.$PcStringCopy$Ex(((CharSequence) (obj2)), 0, charsequence, 0, j);
        obj4 = start1;
        try
        {
            j = ((Number)obj4).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 1, obj4);
        }
        obj4 = s2;
        try
        {
            charsequence = (CharSequence)obj4;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 2, obj4);
        }
        try
        {
            k = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%string-copy!", 3, obj);
        }
        try
        {
            l = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "%string-copy!", 4, obj1);
        }
        srfi13.$PcStringCopy$Ex(((CharSequence) (obj2)), j, charsequence, k, l);
        obj = AddOp.$Pl.apply2(start1, obj3);
        try
        {
            j = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%string-copy!", 1, obj);
        }
        obj = s1;
        try
        {
            obj1 = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%string-copy!", 2, obj);
        }
        obj = end1;
        try
        {
            k = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "%string-copy!", 3, obj);
        }
        srfi13.$PcStringCopy$Ex(((CharSequence) (obj2)), j, ((CharSequence) (obj1)), k, i);
        return ((CharSequence) (obj2));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 181)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 182)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return super.match2(modulemethod, obj, obj1, callcontext);
        }
    }

    public ()
    {
    }
}
