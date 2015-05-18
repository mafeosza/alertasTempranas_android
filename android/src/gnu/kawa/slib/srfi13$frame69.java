// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    final ModuleMethod lambda$Fn157 = new ModuleMethod(this, 134, null, 0);
    final ModuleMethod lambda$Fn158 = new ModuleMethod(this, 135, null, 8194);
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 134)
        {
            return lambda157();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 135)
        {
            return lambda158(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda157()
    {
        ModuleMethod modulemethod = srfi13.string$Mntrim$Mnright;
        Object obj = s;
        Object obj1 = srfi13.loc$rest;
        try
        {
            obj1 = ((Location) (obj1)).get();
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            unboundlocationexception.setLine("srfi13.scm", 1030, 59);
            throw unboundlocationexception;
        }
        return srfi13.stringParseFinalStart$PlEnd(modulemethod, obj, obj1);
    }

    Object lambda158(Object obj, Object obj1)
    {
        Object obj2 = s;
        Object obj3 = srfi13.loc$criterion;
        try
        {
            obj3 = ((Location) (obj3)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1031, 35);
            throw obj;
        }
        obj2 = srfi13.stringSkipRight$V(obj2, obj3, new Object[] {
            obj, obj1
        });
        if (obj2 != Boolean.FALSE)
        {
            obj = s;
            int i;
            try
            {
                obj1 = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "%substring/shared", 0, obj);
            }
            obj = AddOp.$Pl.apply2(srfi13.Lit1, obj2);
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "%substring/shared", 2, obj);
            }
            return srfi13.$PcSubstring$SlShared(((CharSequence) (obj1)), 0, i);
        } else
        {
            return "";
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 134)
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
        if (modulemethod.selector == 135)
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

    public ception()
    {
    }
}
