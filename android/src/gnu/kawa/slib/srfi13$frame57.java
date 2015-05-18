// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.rnrs.unicode;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class ception extends ModuleBody
{

    Object bound;
    final ModuleMethod lambda$Fn136 = new ModuleMethod(this, 114, null, 0);
    final ModuleMethod lambda$Fn137 = new ModuleMethod(this, 115, null, 8194);
    Object s;

    static int lambda138(Object obj)
    {
        Char char1;
        try
        {
            char1 = (Char)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "char-downcase", 1, obj);
        }
        return characters.char$To$Integer(unicode.charDowncase(char1));
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 114)
        {
            return lambda136();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 115)
        {
            return lambda137(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda136()
    {
        ModuleMethod modulemethod = srfi13.string$Mnhash$Mnci;
        Object obj = s;
        Object obj1 = srfi13.loc$rest;
        try
        {
            obj1 = ((Location) (obj1)).get();
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            unboundlocationexception.setLine("srfi13.scm", 921, 58);
            throw unboundlocationexception;
        }
        return srfi13.stringParseFinalStart$PlEnd(modulemethod, obj, obj1);
    }

    Object lambda137(Object obj, Object obj1)
    {
        return srfi13.$PcStringHash(s, srfi13.lambda$Fn138, bound, obj, obj1);
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 114)
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
        if (modulemethod.selector == 115)
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
