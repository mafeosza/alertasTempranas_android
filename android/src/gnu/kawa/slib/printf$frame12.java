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
import kawa.lib.ports;
import kawa.lib.strings;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn18 extends ModuleBody
{

    Object cnt;
    final ModuleMethod lambda$Fn18;
    Object port;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 20)
        {
            return lambda32(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    Boolean lambda32(Object obj)
    {
        if (strings.isString(obj))
        {
            AddOp addop = AddOp.$Pl;
            CharSequence charsequence;
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "string-length", 1, obj);
            }
            cnt = addop.apply2(Integer.valueOf(strings.stringLength(charsequence)), cnt);
            ports.display(obj, port);
            return Boolean.TRUE;
        } else
        {
            cnt = AddOp.$Pl.apply2(printf.Lit7, cnt);
            ports.display(obj, port);
            return Boolean.TRUE;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 20)
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
        ModuleMethod modulemethod = new ModuleMethod(this, 20, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:546");
        lambda$Fn18 = modulemethod;
    }
}
