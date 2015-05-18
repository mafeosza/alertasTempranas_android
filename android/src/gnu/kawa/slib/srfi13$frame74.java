// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.lists.CharSeq;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.UnboundLocationException;
import gnu.mapping.WrongType;
import gnu.text.Char;
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            srfi13

public class lambda.Fn171 extends ModuleBody
{

    CharSequence ans;
    Object cset;
    final ModuleMethod lambda$Fn169;
    final ModuleMethod lambda$Fn170;
    final ModuleMethod lambda$Fn171;
    _cls2 staticLink;
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

    public ception()
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
