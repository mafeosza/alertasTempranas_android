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
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 16, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 17, null, 8194);
    LList maybe$Mnstart$Plend;
    Object proc;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 16)
        {
            return lambda19();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 17)
        {
            return lambda20(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda19()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfor$Mneach, s, maybe$Mnstart$Plend);
    }

    Object lambda20(Object obj, Object obj1)
    {
        while (Scheme.numLss.apply2(obj, obj1) != Boolean.FALSE) 
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj3 = proc;
            Object obj2 = s;
            CharSequence charsequence;
            int i;
            try
            {
                charsequence = (CharSequence)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj2);
            }
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
            }
            applytoargs.apply2(obj3, Char.make(strings.stringRef(charsequence, i)));
            obj = AddOp.$Pl.apply2(obj, srfi13.Lit1);
        }
        return Values.empty;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 16)
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
        if (modulemethod.selector == 17)
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
