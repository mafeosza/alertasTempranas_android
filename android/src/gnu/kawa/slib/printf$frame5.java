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
import kawa.lib.strings;
import kawa.standard.Scheme;

// Referenced classes of package gnu.kawa.slib:
//            printf

public class lambda.Fn10 extends ModuleBody
{

    Object fdigs;
    final ModuleMethod lambda$Fn10;
     staticLink;

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

    public ()
    {
        ModuleMethod modulemethod = new ModuleMethod(this, 6, null, 8194);
        modulemethod.setProperty("source-location", "printf.scm:92");
        lambda$Fn10 = modulemethod;
    }
}
