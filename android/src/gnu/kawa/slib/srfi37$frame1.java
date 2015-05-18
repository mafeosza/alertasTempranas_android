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
//            srfi37

public class  extends ModuleBody
{

    Object args;
    Object index;
    final ModuleMethod lambda$Fn3 = new ModuleMethod(this, 3, null, 0);
    final ModuleMethod lambda$Fn4 = new ModuleMethod(this, 4, null, -4096);
    final ModuleMethod lambda$Fn5 = new ModuleMethod(this, 5, null, 0);
    final ModuleMethod lambda$Fn6 = new ModuleMethod(this, 6, null, -4096);
    final ModuleMethod lambda$Fn7 = new ModuleMethod(this, 7, null, 0);
    final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 8, null, -4096);
    char name;
    Object option;
    Object seeds;
    Object shorts;
     staticLink;

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 6: // '\006'
        default:
            return super.apply0(modulemethod);

        case 3: // '\003'
            return lambda8();

        case 5: // '\005'
            return lambda10();

        case 7: // '\007'
            return lambda12();
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        case 7: // '\007'
        default:
            return super.applyN(modulemethod, aobj);

        case 4: // '\004'
            return lambda9$V(aobj);

        case 6: // '\006'
            return lambda11$V(aobj);

        case 8: // '\b'
            return lambda13$V(aobj);
        }
    }

    Object lambda10()
    {
        gnu.kawa.functions.Apply apply = Scheme.apply;
        Object obj = option;
         ;
        try
        {
             = (option)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "option-processor", 0, obj);
        }
        return apply.applyN(new Object[] {
            srfi37.optionProcessor(), option, Char.make(name), lists.car.apply1(args), seeds
        });
    }

    Object lambda11$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda5scanArgs(lists.cdr.apply1(args), ((Object) (aobj)));
    }

    Object lambda12()
    {
        gnu.kawa.functions.Apply apply = Scheme.apply;
        Object obj = option;
         ;
        try
        {
             = (option)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "option-processor", 0, obj);
        }
        return apply.applyN(new Object[] {
            srfi37.optionProcessor(), option, Char.make(name), Boolean.FALSE, seeds
        });
    }

    Object lambda13$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda3scanShortOptions(AddOp.$Pl.apply2(index, srfi37.Lit0), shorts, args, ((Object) (aobj)));
    }

    Object lambda8()
    {
        gnu.kawa.functions.Apply apply = Scheme.apply;
        Object obj = option;
        Object obj1;
        Char char1;
        CharSequence charsequence;
        Object obj2;
        CharSequence charsequence1;
        int i;
        try
        {
            obj1 = (option)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "option-processor", 0, obj);
        }
        obj = srfi37.optionProcessor(((rocessor) (obj1)));
        obj1 = option;
        char1 = Char.make(name);
        obj2 = shorts;
        try
        {
            charsequence = (CharSequence)obj2;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "substring", 1, obj2);
        }
        obj2 = AddOp.$Pl.apply2(index, srfi37.Lit0);
        try
        {
            i = ((Number)obj2).intValue();
        }
        catch (ClassCastException classcastexception2)
        {
            throw new WrongType(classcastexception2, "substring", 2, obj2);
        }
        obj2 = shorts;
        try
        {
            charsequence1 = (CharSequence)obj2;
        }
        catch (ClassCastException classcastexception3)
        {
            throw new WrongType(classcastexception3, "string-length", 1, obj2);
        }
        return apply.applyN(new Object[] {
            obj, obj1, char1, strings.substring(charsequence, i, strings.stringLength(charsequence1)), seeds
        });
    }

    Object lambda9$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda5scanArgs(args, ((Object) (aobj)));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 6: // '\006'
        default:
            return super.match0(modulemethod, callcontext);

        case 7: // '\007'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 5: // '\005'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 3: // '\003'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        case 7: // '\007'
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 8: // '\b'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 6: // '\006'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 4: // '\004'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public ()
    {
    }
}
