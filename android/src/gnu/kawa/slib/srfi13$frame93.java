// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    final ModuleMethod lambda$Fn208 = new ModuleMethod(this, 183, null, 0);
    final ModuleMethod lambda$Fn209 = new ModuleMethod(this, 184, null, 8194);
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 183)
        {
            return lambda208();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 184)
        {
            return lambda209(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda208()
    {
        ModuleMethod modulemethod = srfi13.string$Mntokenize;
        Object obj = s;
        Object obj1 = srfi13.loc$rest;
        try
        {
            obj1 = ((Location) (obj1)).get();
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            unboundlocationexception.setLine("srfi13.scm", 1696, 57);
            throw unboundlocationexception;
        }
        return srfi13.stringParseFinalStart$PlEnd(modulemethod, obj, obj1);
    }

    Object lambda209(Object obj, Object obj1)
    {
        Object obj2;
        LList llist = LList.Empty;
        obj2 = obj1;
        obj1 = llist;
_L2:
        Object obj3;
        obj3 = Scheme.numLss.apply2(obj, obj2);
        boolean flag;
        try
        {
            flag = ((Boolean)obj3).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "x", -2, obj3);
        }
        if (flag)
        {
            obj3 = s;
            Object obj4 = srfi13.loc$token$Mnchars;
            Object obj6;
            int i;
            int j;
            try
            {
                obj4 = ((Location) (obj4)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1698, 48);
                throw obj;
            }
            obj2 = srfi13.stringIndexRight$V(obj3, obj4, new Object[] {
                obj, obj2
            });
        } else
        if (flag)
        {
            obj2 = Boolean.TRUE;
        } else
        {
            obj2 = Boolean.FALSE;
        }
        obj3 = obj1;
        if (obj2 == Boolean.FALSE)
        {
            break MISSING_BLOCK_LABEL_266;
        }
        obj3 = AddOp.$Pl.apply2(srfi13.Lit1, obj2);
        obj4 = s;
        obj6 = srfi13.loc$token$Mnchars;
        try
        {
            obj6 = ((Location) (obj6)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1701, 34);
            throw obj;
        }
        obj2 = srfi13.stringSkipRight$V(obj4, obj6, new Object[] {
            obj, obj2
        });
        if (obj2 != Boolean.FALSE)
        {
            Object obj5 = s;
            try
            {
                obj6 = (CharSequence)obj5;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj5);
            }
            obj5 = AddOp.$Pl.apply2(srfi13.Lit1, obj2);
            try
            {
                i = ((Number)obj5).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj5);
            }
            try
            {
                j = ((Number)obj3).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj3);
            }
            obj1 = lists.cons(strings.substring(((CharSequence) (obj6)), i, j), obj1);
            continue; /* Loop/switch isn't completed */
        }
        obj2 = s;
        try
        {
            obj5 = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "substring", 1, obj2);
        }
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "substring", 2, obj);
        }
        j = ((Number)obj3).intValue();
        obj3 = lists.cons(strings.substring(((CharSequence) (obj5)), i, j), obj1);
        return obj3;
        obj;
        throw new WrongType(((ClassCastException) (obj)), "substring", 3, obj3);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 183)
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
        if (modulemethod.selector == 184)
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
