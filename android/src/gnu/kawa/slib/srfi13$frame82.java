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
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    Object _fldchar;
    final ModuleMethod lambda$Fn187 = new ModuleMethod(this, 162, null, 0);
    final ModuleMethod lambda$Fn188 = new ModuleMethod(this, 163, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 162)
        {
            return lambda187();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 163)
        {
            return lambda188(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda187()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfill$Ex, s, maybe$Mnstart$Plend);
    }

    Object lambda188(Object obj, Object obj1)
    {
        obj1 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
        while (Scheme.numLss.apply2(obj1, obj) == Boolean.FALSE) 
        {
            Object obj2 = s;
            char c;
            CharSeq charseq;
            int i;
            try
            {
                charseq = (CharSeq)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj2);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj1);
            }
            obj2 = _fldchar;
            try
            {
                c = ((Char)obj2).charValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 3, obj2);
            }
            strings.stringSet$Ex(charseq, i, c);
            obj1 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
        }
        return Values.empty;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 162)
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
        if (modulemethod.selector == 163)
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
