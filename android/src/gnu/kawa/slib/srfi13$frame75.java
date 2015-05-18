// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.CharSeq;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.characters;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn176 extends ModuleBody
{
    public class srfi13.frame76 extends ModuleBody
    {

        CharSequence ans;
        Object cset;
        final ModuleMethod lambda$Fn174;
        final ModuleMethod lambda$Fn175;
        final ModuleMethod lambda$Fn176;
        srfi13.frame75 staticLink;
        CharSequence temp;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply2(modulemethod, obj, obj1);

            case 147: 
                return lambda174(obj, obj1);

            case 148: 
                return lambda175(obj, obj1);

            case 149: 
                return lambda176(obj, obj1);
            }
        }

        Object lambda174(Object obj, Object obj1)
        {
            Object obj2 = obj1;
            if (Scheme.applyToArgs.apply2(staticLink.criterion, obj) != Boolean.FALSE)
            {
                obj2 = temp;
                char c;
                CharSeq charseq;
                int i;
                try
                {
                    charseq = (CharSeq)obj2;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj2);
                }
                try
                {
                    i = ((Number)obj1).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj1);
                }
                try
                {
                    c = ((Char)obj).charValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-set!", 3, obj);
                }
                strings.stringSet$Ex(charseq, i, c);
                obj2 = AddOp.$Pl.apply2(obj1, srfi13.Lit1);
            }
            return obj2;
        }

        Object lambda175(Object obj, Object obj1)
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj2 = srfi13.loc$char$Mnset$Mncontains$Qu;
            Object obj3;
            try
            {
                obj3 = ((Location) (obj2)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1128, 45);
                throw obj;
            }
            obj2 = obj1;
            if (applytoargs.apply3(obj3, cset, obj) != Boolean.FALSE)
            {
                obj2 = AddOp.$Pl.apply2(obj1, srfi13.Lit1);
            }
            return obj2;
        }

        Object lambda176(Object obj, Object obj1)
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj2 = srfi13.loc$char$Mnset$Mncontains$Qu;
            Object obj3;
            try
            {
                obj3 = ((Location) (obj2)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1133, 35);
                throw obj;
            }
            obj2 = obj1;
            if (applytoargs.apply3(obj3, cset, obj) != Boolean.FALSE)
            {
                obj2 = ans;
                char c;
                CharSeq charseq;
                int i;
                try
                {
                    charseq = (CharSeq)obj2;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, obj2);
                }
                try
                {
                    i = ((Number)obj1).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "string-set!", 2, obj1);
                }
                try
                {
                    c = ((Char)obj).charValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "string-set!", 3, obj);
                }
                strings.stringSet$Ex(charseq, i, c);
                obj2 = AddOp.$Pl.apply2(obj1, srfi13.Lit1);
            }
            return obj2;
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match2(modulemethod, obj, obj1, callcontext);

            case 149: 
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 148: 
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 147: 
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }

        public srfi13.frame76()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 147, null, 8194);
            modulemethod.setProperty("source-location", "srfi13.scm:1116");
            lambda$Fn174 = modulemethod;
            modulemethod = new ModuleMethod(this, 148, null, 8194);
            modulemethod.setProperty("source-location", "srfi13.scm:1128");
            lambda$Fn175 = modulemethod;
            modulemethod = new ModuleMethod(this, 149, null, 8194);
            modulemethod.setProperty("source-location", "srfi13.scm:1133");
            lambda$Fn176 = modulemethod;
        }
    }


    Object criterion;
    final ModuleMethod lambda$Fn172 = new ModuleMethod(this, 150, null, 0);
    final ModuleMethod lambda$Fn173 = new ModuleMethod(this, 151, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 150)
        {
            return lambda172();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 151)
        {
            return lambda173(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda172()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mnfilter, s, maybe$Mnstart$Plend);
    }

    CharSequence lambda173(Object obj, Object obj1)
    {
        maybe.Mnstart.Plend plend = new <init>();
        plend.staticLink = this;
        Object obj2;
        if (misc.isProcedure(criterion))
        {
            obj2 = AddOp.$Mn.apply2(obj1, obj);
            Object obj3;
            int i;
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj2);
            }
            plend.temp = strings.makeString(i);
            obj = srfi13.stringFold$V(plend.Fn174, srfi13.Lit0, s, new Object[] {
                obj, obj1
            });
            if (Scheme.numEqu.apply2(obj, obj2) != Boolean.FALSE)
            {
                return plend.temp;
            }
            obj1 = plend.temp;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "substring", 3, obj);
            }
            return strings.substring(((CharSequence) (obj1)), 0, i);
        }
        obj2 = Scheme.applyToArgs;
        obj3 = srfi13.loc$char$Mnset$Qu;
        try
        {
            obj3 = ((Location) (obj3)).get();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1124, 22);
            throw obj;
        }
        if (((Procedure) (obj2)).apply2(obj3, criterion) != Boolean.FALSE)
        {
            obj2 = criterion;
        } else
        if (characters.isChar(criterion))
        {
            obj2 = Scheme.applyToArgs;
            obj3 = srfi13.loc$char$Mnset;
            try
            {
                obj3 = ((Location) (obj3)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1125, 26);
                throw obj;
            }
            obj2 = ((Procedure) (obj2)).apply2(obj3, criterion);
        } else
        {
            obj2 = misc.error$V("string-delete criterion not predicate, char or char-set", new Object[] {
                criterion
            });
        }
        plend.cset = obj2;
        obj2 = srfi13.stringFold$V(plend.Fn175, srfi13.Lit0, s, new Object[] {
            obj, obj1
        });
        try
        {
            i = ((Number)obj2).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-string", 1, obj2);
        }
        plend.ans = strings.makeString(i);
        srfi13.stringFold$V(plend.Fn176, srfi13.Lit0, s, new Object[] {
            obj, obj1
        });
        return plend.ans;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 150)
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
        if (modulemethod.selector == 151)
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

    public lambda.Fn176()
    {
    }
}
