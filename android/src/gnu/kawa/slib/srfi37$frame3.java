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
import kawa.lib.lists;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.call_with_values;

// Referenced classes of package gnu.kawa.slib:
//            srfi37

public class  extends ModuleBody
{
    public class srfi37.frame4 extends ModuleBody
    {

        final ModuleMethod lambda$Fn13 = new ModuleMethod(this, 15, null, 0);
        final ModuleMethod lambda$Fn14 = new ModuleMethod(this, 16, null, 4097);
        srfi37.frame3 staticLink;
        Object x;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 15)
            {
                return lambda18();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 16)
            {
                return lambda19(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        CharSequence lambda18()
        {
            Object obj = staticLink.arg;
            CharSequence charsequence;
            CharSequence charsequence1;
            int i;
            try
            {
                charsequence = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "substring", 1, obj);
            }
            obj = AddOp.$Pl.apply2(staticLink.temp, srfi37.Lit0);
            try
            {
                i = ((Number)obj).intValue();
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "substring", 2, obj);
            }
            obj = staticLink.arg;
            try
            {
                charsequence1 = (CharSequence)obj;
            }
            catch (ClassCastException classcastexception2)
            {
                throw new WrongType(classcastexception2, "string-length", 1, obj);
            }
            return strings.substring(charsequence, i, strings.stringLength(charsequence1));
        }

        Object lambda19(Object obj)
        {
            srfi37.frame5 frame5_1 = new srfi37.frame5();
            frame5_1.staticLink = this;
            frame5_1.x = obj;
            return call_with_values.callWithValues(frame5_1.lambda$Fn15, frame5_1.lambda$Fn16);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 15)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 16)
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

        public srfi37.frame4()
        {
        }
    }

    public class srfi37.frame5 extends ModuleBody
    {

        final ModuleMethod lambda$Fn15 = new ModuleMethod(this, 13, null, 0);
        final ModuleMethod lambda$Fn16 = new ModuleMethod(this, 14, null, 4097);
        srfi37.frame4 staticLink;
        Object x;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 13)
            {
                return lambda20();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 14)
            {
                return lambda21(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda20()
        {
            Object obj = staticLink.staticLink.staticLink.lambda2findOption(staticLink.x);
            if (obj != Boolean.FALSE)
            {
                return obj;
            } else
            {
                return srfi37.option(LList.list1(staticLink.x), Boolean.TRUE, Boolean.FALSE, staticLink.staticLink.staticLink.unrecognized$Mnoption$Mnproc);
            }
        }

        Object lambda21(Object obj)
        {
            srfi37.frame6 frame6_1 = new srfi37.frame6();
            frame6_1.staticLink = this;
            frame6_1.x = obj;
            return call_with_values.callWithValues(frame6_1.lambda$Fn17, frame6_1.lambda$Fn18);
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 13)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 14)
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

        public srfi37.frame5()
        {
        }
    }

    public class srfi37.frame6 extends ModuleBody
    {

        final ModuleMethod lambda$Fn17 = new ModuleMethod(this, 11, null, 0);
        final ModuleMethod lambda$Fn18 = new ModuleMethod(this, 12, null, -4096);
        srfi37.frame5 staticLink;
        Object x;

        public Object apply0(ModuleMethod modulemethod)
        {
            if (modulemethod.selector == 11)
            {
                return lambda22();
            } else
            {
                return super.apply0(modulemethod);
            }
        }

        public Object applyN(ModuleMethod modulemethod, Object aobj[])
        {
            if (modulemethod.selector == 12)
            {
                return lambda23$V(aobj);
            } else
            {
                return super.applyN(modulemethod, aobj);
            }
        }

        Object lambda22()
        {
            gnu.kawa.functions.Apply apply = Scheme.apply;
            Object obj = x;
            option.Mntype mntype;
            try
            {
                mntype = (option.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "option-processor", 0, obj);
            }
            return apply.applyN(new Object[] {
                srfi37.optionProcessor(mntype), x, staticLink.staticLink.x, staticLink.x, staticLink.staticLink.staticLink.seeds
            });
        }

        Object lambda23$V(Object aobj[])
        {
            aobj = LList.makeList(aobj, 0);
            return staticLink.staticLink.staticLink.staticLink.lambda5scanArgs(staticLink.staticLink.staticLink.args, ((Object) (aobj)));
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            if (modulemethod.selector == 11)
            {
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            } else
            {
                return super.match0(modulemethod, callcontext);
            }
        }

        public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
        {
            if (modulemethod.selector == 12)
            {
                callcontext.values = aobj;
                callcontext.proc = modulemethod;
                callcontext.pc = 5;
                return 0;
            } else
            {
                return super.matchN(modulemethod, aobj, callcontext);
            }
        }

        public srfi37.frame6()
        {
        }
    }


    Object arg;
    Object args;
    final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 17, null, 0);
    final ModuleMethod lambda$Fn12 = new ModuleMethod(this, 18, null, 4097);
    final ModuleMethod lambda$Fn19 = new ModuleMethod(this, 19, null, 0);
    final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 20, null, -4096);
    final ModuleMethod lambda$Fn21 = new ModuleMethod(this, 21, null, 0);
    final ModuleMethod lambda$Fn22 = new ModuleMethod(this, 22, null, -4096);
    final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 23, null, 0);
    final ModuleMethod lambda$Fn24 = new ModuleMethod(this, 24, null, -4096);
    CharSequence name;
    Object option;
    Object seeds;
     staticLink;
    Object temp;

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        default:
            return super.apply0(modulemethod);

        case 17: // '\021'
            return lambda16();

        case 19: // '\023'
            return lambda24();

        case 21: // '\025'
            return lambda26();

        case 23: // '\027'
            return lambda28();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 18)
        {
            return lambda17(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        case 21: // '\025'
        case 23: // '\027'
        default:
            return super.applyN(modulemethod, aobj);

        case 20: // '\024'
            return lambda25$V(aobj);

        case 22: // '\026'
            return lambda27$V(aobj);

        case 24: // '\030'
            return lambda29$V(aobj);
        }
    }

    CharSequence lambda16()
    {
        Object obj = arg;
        CharSequence charsequence;
        int i;
        try
        {
            charsequence = (CharSequence)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "substring", 1, obj);
        }
        obj = temp;
        try
        {
            i = ((Number)obj).intValue();
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "substring", 3, obj);
        }
        return strings.substring(charsequence, 2, i);
    }

    Object lambda17(Object obj)
    {
          = new <init>();
        .staticLink = this;
        .x = obj;
        return call_with_values.callWithValues(.Fn13, .Fn14);
    }

    Object lambda24()
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
            srfi37.optionProcessor(), option, name, lists.car.apply1(args), seeds
        });
    }

    Object lambda25$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda5scanArgs(lists.cdr.apply1(args), ((Object) (aobj)));
    }

    Object lambda26()
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
            srfi37.optionProcessor(), option, name, Boolean.FALSE, seeds
        });
    }

    Object lambda27$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda5scanArgs(args, ((Object) (aobj)));
    }

    Object lambda28()
    {
        return Scheme.apply.apply3(staticLink.Mnproc, arg, seeds);
    }

    Object lambda29$V(Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        return staticLink.ambda5scanArgs(args, ((Object) (aobj)));
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        default:
            return super.match0(modulemethod, callcontext);

        case 23: // '\027'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 21: // '\025'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 19: // '\023'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 17: // '\021'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 18)
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

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 21: // '\025'
        case 23: // '\027'
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 24: // '\030'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 22: // '\026'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 20: // '\024'
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
