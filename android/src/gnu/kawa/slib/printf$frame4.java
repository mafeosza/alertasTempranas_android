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
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.lists;
import kawa.lib.numbers;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn8 extends ModuleBody
{
    public class printf.frame5 extends ModuleBody
    {

        Object fdigs;
        final ModuleMethod lambda$Fn10;
        printf.frame4 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 6)
            {
                return lambda14(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda14(Object obj, Object obj1)
        {
            gnu.lists.FString fstring = strings.stringAppend(new Object[] {
                "0", staticLink.idigs, fdigs
            });
            int i = strings.stringLength(fstring);
            Object obj2 = printf.Lit7;
            AddOp addop = AddOp.$Pl;
            Object obj3 = staticLink.idigs;
            CharSequence charsequence;
            try
            {
                charsequence = (CharSequence)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-length", 1, obj3);
            }
            obj1 = addop.apply2(obj1, Integer.valueOf(strings.stringLength(charsequence)));
            do
            {
                if (Scheme.numGEq.apply2(obj2, Integer.valueOf(i)) != Boolean.FALSE)
                {
                    return Scheme.applyToArgs.applyN(new Object[] {
                        staticLink.staticLink.staticLink.cont, obj, staticLink.staticLink.sgn, "0", printf.Lit7
                    });
                }
                obj3 = printf.Lit9;
                int j;
                try
                {
                    j = ((Number)obj2).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-ref", 2, obj2);
                }
                if (characters.isChar$Eq(((Char) (obj3)), Char.make(strings.stringRef(fstring, j))))
                {
                    obj2 = AddOp.$Pl.apply2(obj2, printf.Lit7);
                    obj1 = AddOp.$Mn.apply2(obj1, printf.Lit7);
                } else
                {
                    obj3 = Scheme.applyToArgs;
                    Object obj4 = staticLink.staticLink.staticLink.cont;
                    Object obj5 = staticLink.staticLink.sgn;
                    obj2 = AddOp.$Mn.apply2(obj2, printf.Lit7);
                    int k;
                    try
                    {
                        k = ((Number)obj2).intValue();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "substring", 2, obj2);
                    }
                    return ((Procedure) (obj3)).applyN(new Object[] {
                        obj4, obj, obj5, strings.substring(fstring, k, i), obj1
                    });
                }
            } while (true);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 6)
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

        public printf.frame5()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 6, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:92");
            lambda$Fn10 = modulemethod;
        }
    }

    public class printf.frame6 extends ModuleBody
    {

        Object cont;
        final ModuleMethod lambda$Fn11;
        printf.frame staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 5)
            {
                return lambda15(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda15(Object obj, Object obj1)
        {
            printf.frame7 frame7_1 = new printf.frame7();
            frame7_1.staticLink = this;
            frame7_1.sgn = obj1;
            return staticLink.lambda3digits(obj, frame7_1.lambda$Fn12);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 5)
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

        public printf.frame6()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 5, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:67");
            lambda$Fn11 = modulemethod;
        }
    }

    public class printf.frame7 extends ModuleBody
    {

        final ModuleMethod lambda$Fn12;
        Object sgn;
        printf.frame6 staticLink;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            if (modulemethod.selector == 4)
            {
                return lambda16(obj, obj1);
            } else
            {
                return super.apply2(modulemethod, obj, obj1);
            }
        }

        Object lambda16(Object obj, Object obj1)
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj2 = staticLink.cont;
            Char char1 = printf.Lit5;
            Object obj3 = sgn;
            Char char2;
            try
            {
                char2 = (Char)obj3;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "char=?", 2, obj3);
            }
            if (characters.isChar$Eq(char1, char2))
            {
                obj3 = AddOp.$Mn;
                CharSequence charsequence;
                try
                {
                    charsequence = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string->number", 1, obj1);
                }
                obj1 = ((Procedure) (obj3)).apply1(numbers.string$To$Number(charsequence));
            } else
            {
                try
                {
                    obj3 = (CharSequence)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string->number", 1, obj1);
                }
                obj1 = numbers.string$To$Number(((CharSequence) (obj3)));
            }
            return applytoargs.apply3(obj2, obj, obj1);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            if (modulemethod.selector == 4)
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

        public printf.frame7()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 4, null, 8194);
            modulemethod.setProperty("source-location", "printf.scm:69");
            lambda$Fn12 = modulemethod;
        }
    }


    Object idigs;
    final ModuleMethod lambda$Fn8;
    final ModuleMethod lambda$Fn9;
     staticLink;

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 8)
        {
            return lambda12(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 7)
        {
            return lambda13(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda12(Object obj)
    {
        return staticLink.staticLink.staticLink.ambda3digits(obj, lambda$Fn9);
    }

    Object lambda13(Object obj, Object obj1)
    {
        Object obj2 = new <init>();
        obj2.staticLink = this;
        obj2.fdigs = obj1;
        obj2 = ((fdigs) (obj2)).Fn10;
        Object obj3 = staticLink.staticLink.staticLink;
        obj1 = new <init>();
        obj1.staticLink = ((staticLink) (obj3));
        obj1.cont = obj2;
        if (Scheme.numGEq.apply2(obj, Integer.valueOf(staticLink.staticLink.staticLink.)) != Boolean.FALSE)
        {
            return Scheme.applyToArgs.apply3((() (obj1)).cont, obj, printf.Lit1);
        }
        obj2 = staticLink.staticLink.staticLink.tr;
        int i;
        try
        {
            obj3 = (CharSequence)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "string-ref", 1, obj2);
        }
        try
        {
            i = ((Number)obj).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "string-ref", 2, obj);
        }
        if (lists.memv(Char.make(strings.stringRef(((CharSequence) (obj3)), i)), printf.Lit10) != Boolean.FALSE)
        {
            return staticLink.staticLink.staticLink.ambda2sign(AddOp.$Pl.apply2(obj, printf.Lit7), (() (obj1)).Fn11);
        } else
        {
            return Scheme.applyToArgs.apply3((() (obj1)).cont, obj, printf.Lit1);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 8)
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

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        if (modulemethod.selector == 7)
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

    public lambda.Fn11()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 7, null, 8194);
        modulemethod.setProperty("source-location", "printf.scm:90");
        lambda$Fn9 = modulemethod;
        modulemethod = new ModuleMethod(this, 8, null, 4097);
        modulemethod.setProperty("source-location", "printf.scm:87");
        lambda$Fn8 = modulemethod;
    }
}
