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

public class lambda.Fn171 extends ModuleBody
{
    public class srfi13.frame74 extends ModuleBody
    {

        CharSequence ans;
        Object cset;
        final ModuleMethod lambda$Fn169;
        final ModuleMethod lambda$Fn170;
        final ModuleMethod lambda$Fn171;
        srfi13.frame73 staticLink;
        CharSequence temp;

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply2(modulemethod, obj, obj1);

            case 142: 
                return lambda169(obj, obj1);

            case 143: 
                return lambda170(obj, obj1);

            case 144: 
                return lambda171(obj, obj1);
            }
        }

        Object lambda169(Object obj, Object obj1)
        {
            if (Scheme.applyToArgs.apply2(staticLink.criterion, obj) != Boolean.FALSE)
            {
                return obj1;
            }
            CharSequence charsequence = temp;
            char c;
            CharSeq charseq;
            int i;
            try
            {
                charseq = (CharSeq)charsequence;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "string-set!", 1, charsequence);
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
            return AddOp.$Pl.apply2(obj1, srfi13.Lit1);
        }

        Object lambda170(Object obj, Object obj1)
        {
            gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
            Object obj2 = srfi13.loc$char$Mnset$Mncontains$Qu;
            try
            {
                obj2 = ((Location) (obj2)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1099, 45);
                throw obj;
            }
            if (applytoargs.apply3(obj2, cset, obj) != Boolean.FALSE)
            {
                return obj1;
            } else
            {
                return AddOp.$Pl.apply2(obj1, srfi13.Lit1);
            }
        }

        Object lambda171(Object obj, Object obj1)
        {
            Object obj2 = Scheme.applyToArgs;
            Object obj3 = srfi13.loc$char$Mnset$Mncontains$Qu;
            char c;
            int i;
            try
            {
                obj3 = ((Location) (obj3)).get();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1104, 35);
                throw obj;
            }
            if (((Procedure) (obj2)).apply3(obj3, cset, obj) != Boolean.FALSE)
            {
                return obj1;
            }
            obj2 = ans;
            try
            {
                obj3 = (CharSeq)obj2;
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
            strings.stringSet$Ex(((CharSeq) (obj3)), i, c);
            return AddOp.$Pl.apply2(obj1, srfi13.Lit1);
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match2(modulemethod, obj, obj1, callcontext);

            case 144: 
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 143: 
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 142: 
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }

        public srfi13.frame74()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 142, null, 8194);
            modulemethod.setProperty("source-location", "srfi13.scm:1089");
            lambda$Fn169 = modulemethod;
            modulemethod = new ModuleMethod(this, 143, null, 8194);
            modulemethod.setProperty("source-location", "srfi13.scm:1099");
            lambda$Fn170 = modulemethod;
            modulemethod = new ModuleMethod(this, 144, null, 8194);
            modulemethod.setProperty("source-location", "srfi13.scm:1104");
            lambda$Fn171 = modulemethod;
        }
    }


    Object criterion;
    final ModuleMethod lambda$Fn167 = new ModuleMethod(this, 145, null, 0);
    final ModuleMethod lambda$Fn168 = new ModuleMethod(this, 146, null, 8194);
    LList maybe$Mnstart$Plend;
    Object s;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 145)
        {
            return lambda167();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        if (modulemethod.selector == 146)
        {
            return lambda168(obj, obj1);
        } else
        {
            return super.apply2(modulemethod, obj, obj1);
        }
    }

    Object lambda167()
    {
        return srfi13.stringParseFinalStart$PlEnd(srfi13.string$Mndelete, s, maybe$Mnstart$Plend);
    }

    CharSequence lambda168(Object obj, Object obj1)
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
            obj = srfi13.stringFold$V(plend.Fn169, srfi13.Lit0, s, new Object[] {
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
            ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1096, 22);
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
                ((UnboundLocationException) (obj)).setLine("srfi13.scm", 1097, 26);
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
        obj2 = srfi13.stringFold$V(plend.Fn170, srfi13.Lit0, s, new Object[] {
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
        srfi13.stringFold$V(plend.Fn171, srfi13.Lit0, s, new Object[] {
            obj, obj1
        });
        return plend.ans;
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 145)
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
        if (modulemethod.selector == 146)
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

    public lambda.Fn171()
    {
    }
}
