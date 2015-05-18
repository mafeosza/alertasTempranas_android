// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.lists.ImmutablePair;
import gnu.lists.Pair;

// Referenced classes of package kawa.lang:
//            SyntaxForm, SyntaxForms, TemplateScope

static class scope extends ImmutablePair
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

    public (Pair pair, TemplateScope templatescope)
    {
        datum = pair;
        scope = templatescope;
    }
}
