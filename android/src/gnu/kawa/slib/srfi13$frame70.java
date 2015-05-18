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

    final ModuleMethod lambda$Fn159 = new ModuleMethod(this, 136, null, 0);
    final ModuleMethod lambda$Fn160 = new ModuleMethod(this, 137, null, 8194);
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 136)
        {
            return lambda159();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 137)
        {
            return lambda160(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda159()
    {
        ModuleMethod modulemethod = srfi13.string$Mntrim$Mnboth;
        Object obj = s;
        Object obj1 = srfi13.loc$rest;
        try
        {
            obj1 = ((Location) (obj1)).get();
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            unboundlocationexception.setLine("srfi13.scm", 1037, 58);
            throw unboundlocationexception;
        }
        return srfi13.stringParseFinalStart$PlEnd(modulemethod, obj, obj1);
    }

    Object lambda160(Object obj, Object obj1)
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
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1038, 29);
            throw obj;
        }
        obj = srfi13.stringSkip$V(obj2, obj3, new Object[] {
            obj, obj1
        });
        if (obj != Boolean.FALSE)
        {
            Object obj4 = s;
            CharSequence charsequence;
            gnu.math.IntNum intnum;
            Object obj5;
            Object obj6;
            int i;
            int j;
            try
            {
                charsequence = (CharSequence)obj4;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "%substring/shared", 0, obj4);
            }
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "%substring/shared", 1, obj);
            }
            obj4 = AddOp.$Pl;
            intnum = srfi13.Lit1;
            obj5 = s;
            obj6 = srfi13.loc$criterion;
            try
            {
                obj6 = ((Location) (obj6)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1040, 58);
                throw obj;
            }
            obj = ((Procedure) (obj4)).apply2(intnum, srfi13.stringSkipRight$V(obj5, obj6, new Object[] {
                obj, obj1
            }));
            try
            {
                j = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "%substring/shared", 2, obj);
            }
            return srfi13.$PcSubstring$SlShared(charsequence, i, j);
        } else
        {
            return "";
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 136)
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
        if (modulemethod.selector == 137)
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
