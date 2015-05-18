// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            genwrite

public class lambda.Fn1 extends ModuleBody
{

    final ModuleMethod lambda$Fn1;
    Object left;
    Object result;
     staticLink;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            if (lambda22(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    boolean lambda22(Object obj)
    {
        result = lists.cons(obj, result);
        AddOp addop = AddOp.$Mn;
        Object obj1 = left;
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "string-length", 1, obj);
        }
        left = addop.apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
        return ((Boolean)Scheme.numGrt.apply2(left, genwrite.Lit1)).booleanValue();
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "genwrite.scm:72");
        lambda$Fn1 = modulemethod;
    }
}
