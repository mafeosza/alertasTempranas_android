// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.CharSeq;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.WrongType;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn200 = new ModuleMethod(this, 175, null, 0);
    final ModuleMethod lambda$Fn201 = new ModuleMethod(this, 176, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 175)
        {
            return lambda200();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 176)
        {
            return lambda201(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda200()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnreverse, s, maybe$Mnstart$Plend);
    }

    CharSequence lambda201(Object obj, Object obj1)
    {
        obj1 = AddOp.$Mn.apply2(obj1, obj);
        Object obj2;
        CharSequence charsequence;
        int i;
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj1);
        }
        charsequence = strings.makeString(i);
        obj2 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
        obj1 = obj;
        obj = obj2;
        while (Scheme.numLss.apply2(obj, srfi13.Lit0) == Boolean.FALSE) 
        {
            Object obj3;
            CharSeq charseq;
            CharSequence charsequence1;
            int j;
            int k;
            try
            {
                charseq = (CharSeq)charsequence;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, charsequence);
            }
            try
            {
                j = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-set!", 2, obj);
            }
            obj3 = s;
            try
            {
                charsequence1 = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj3);
            }
            try
            {
                k = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
            }
            strings.stringSet$Ex(charseq, j, strings.stringRef(charsequence1, k));
            obj1 = AddOp.$Pl.apply2(obj1, srfi13.Lit1);
            obj = AddOp.$Mn.apply2(obj, srfi13.Lit1);
        }
        return charsequence;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 175)
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
        if (modulemethod.selector == 176)
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
