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
import gnu.text.Char;
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class  extends ModuleBody
{

    final ModuleMethod lambda$Fn204 = new ModuleMethod(this, 179, null, 0);
    final ModuleMethod lambda$Fn205 = new ModuleMethod(this, 180, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 179)
        {
            return lambda204();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 180)
        {
            return lambda205(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda204()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mn$Grlist, s, maybe$Mnstart$Plend);
    }

    Object lambda205(Object obj, Object obj1)
    {
        obj1 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
        Object obj2 = LList.Empty;
        while (Scheme.numLss.apply2(obj1, obj) == Boolean.FALSE) 
        {
            Object obj3 = AddOp.$Mn.apply2(obj1, srfi13.Lit1);
            Object obj4 = s;
            CharSequence charsequence;
            int i;
            try
            {
                charsequence = (CharSequence)obj4;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj4);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj1);
            }
            obj2 = lists.cons(Char.make(strings.stringRef(charsequence, i)), obj2);
            obj1 = obj3;
        }
        return obj2;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 179)
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
        if (modulemethod.selector == 180)
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
