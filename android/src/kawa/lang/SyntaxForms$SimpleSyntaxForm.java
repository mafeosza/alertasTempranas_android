// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;


// Referenced classes of package kawa.lang:
//            SyntaxForm, SyntaxForms, TemplateScope

static class scope
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

    (Object obj, TemplateScope templatescope)
    {
        int i = counter + 1;
        counter = i;
        id = i;
        datum = obj;
        scope = templatescope;
    }
}
