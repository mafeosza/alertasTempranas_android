// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.bytecode.Type;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.PropertySet;
import gnu.mapping.WrongType;

// Referenced classes of package kawa.lib:
//            reflection

public class lambda.Fn1 extends ModuleBody
{

    final ModuleMethod lambda$Fn1;
    Object rtype;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            if (lambda1(obj))
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

    boolean lambda1(Object obj)
    {
        Object obj1 = rtype;
        Type type;
        try
        {
            type = (Type)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "gnu.bytecode.Type.isInstance(java.lang.Object)", 1, obj1);
        }
        return type.isInstance(obj);
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

    public on()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
        modulemethod.setProperty("source-location", "reflection.scm:30");
        lambda$Fn1 = modulemethod;
    }
}
