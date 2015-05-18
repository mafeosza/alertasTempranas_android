// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.NameLookup;
import gnu.lists.ImmutablePair;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;

// Referenced classes of package kawa.lang:
//            Translator, SyntaxForm, TemplateScope

public class SyntaxForms
{
    static class PairSyntaxForm extends ImmutablePair
        implements SyntaxForm
    {

        private Pair datum;
        private TemplateScope scope;

        public Object getCar()
        {
            if (car == null)
            {
                car = SyntaxForms.makeForm(datum.getCar(), scope);
            }
            return car;
        }

        public Object getCdr()
        {
            if (cdr == null)
            {
                cdr = SyntaxForms.makeForm(datum.getCdr(), scope);
            }
            return cdr;
        }

        public Object getDatum()
        {
            return datum;
        }

        public TemplateScope getScope()
        {
            return scope;
        }

        public String toString()
        {
            return SyntaxForms.toString(this, null);
        }

        public PairSyntaxForm(Pair pair, TemplateScope templatescope)
        {
            datum = pair;
            scope = templatescope;
        }
    }

    static class SimpleSyntaxForm
        implements SyntaxForm
    {

        static int counter;
        private Object datum;
        int id;
        private TemplateScope scope;

        public Object getDatum()
        {
            return datum;
        }

        public TemplateScope getScope()
        {
            return scope;
        }

        public String toString()
        {
            return SyntaxForms.toString(this, Integer.toString(id));
        }

        SimpleSyntaxForm(Object obj, TemplateScope templatescope)
        {
            int i = counter + 1;
            counter = i;
            id = i;
            datum = obj;
            scope = templatescope;
        }
    }


    public static final boolean DEBUGGING = true;

    public SyntaxForms()
    {
    }

    public static boolean freeIdentifierEquals(SyntaxForm syntaxform, SyntaxForm syntaxform1)
    {
        Translator translator = (Translator)Compilation.getCurrent();
        return translator.lexical.lookup(syntaxform.getDatum(), -1) == translator.lexical.lookup(syntaxform1.getDatum(), -1);
    }

    public static Object fromDatum(Object obj, SyntaxForm syntaxform)
    {
        return makeForm(obj, syntaxform.getScope());
    }

    public static Object fromDatumIfNeeded(Object obj, SyntaxForm syntaxform)
    {
        if (obj == syntaxform.getDatum())
        {
            return syntaxform;
        }
        if (obj instanceof SyntaxForm)
        {
            return (SyntaxForm)obj;
        } else
        {
            return fromDatum(obj, syntaxform);
        }
    }

    public static boolean isIdentifier(SyntaxForm syntaxform)
    {
        return syntaxform.getDatum() instanceof Symbol;
    }

    public static Object makeForm(Object obj, TemplateScope templatescope)
    {
        Object obj1;
        if (obj instanceof Pair)
        {
            obj1 = new PairSyntaxForm((Pair)obj, templatescope);
        } else
        {
            obj1 = obj;
            if (obj != LList.Empty)
            {
                return new SimpleSyntaxForm(obj, templatescope);
            }
        }
        return obj1;
    }

    public static Object makeWithTemplate(Object obj, Object obj1)
    {
        Object obj2;
        if (obj1 instanceof SyntaxForm)
        {
            obj2 = (SyntaxForm)obj1;
        } else
        {
            obj2 = obj1;
            if (obj instanceof SyntaxForm)
            {
                obj = (SyntaxForm)obj;
                if (obj1 == ((SyntaxForm) (obj)).getDatum())
                {
                    return obj;
                } else
                {
                    return fromDatum(obj1, ((SyntaxForm) (obj)));
                }
            }
        }
        return obj2;
    }

    public static Expression rewrite(Object obj)
    {
        return ((Translator)Compilation.getCurrent()).rewrite(obj);
    }

    public static Expression rewriteBody(Object obj)
    {
        return ((Translator)Compilation.getCurrent()).rewrite_body(obj);
    }

    public static String toString(SyntaxForm syntaxform, String s)
    {
        StringBuilder stringbuilder = new StringBuilder("#<syntax");
        if (s != null)
        {
            stringbuilder.append('#');
            stringbuilder.append(s);
        }
        stringbuilder.append(' ');
        stringbuilder.append(syntaxform.getDatum());
        syntaxform = syntaxform.getScope();
        if (syntaxform == null)
        {
            stringbuilder.append(" in null");
        } else
        {
            stringbuilder.append(" in #");
            stringbuilder.append(((TemplateScope) (syntaxform)).id);
        }
        stringbuilder.append(">");
        return stringbuilder.toString();
    }
}
