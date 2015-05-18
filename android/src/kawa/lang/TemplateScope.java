// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.LetExp;
import gnu.expr.ScopeExp;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

// Referenced classes of package kawa.lang:
//            Translator, Macro, Syntax

public class TemplateScope extends LetExp
    implements Externalizable
{

    Declaration macroContext;
    private Syntax syntax;

    public TemplateScope()
    {
        super(null);
    }

    public TemplateScope(ScopeExp scopeexp)
    {
        super(null);
        outer = scopeexp;
    }

    public static TemplateScope make()
    {
        return make((Translator)Compilation.getCurrent());
    }

    public static TemplateScope make(Translator translator)
    {
        TemplateScope templatescope = new TemplateScope();
        Syntax syntax1 = translator.getCurrentSyntax();
        if (syntax1 instanceof Macro)
        {
            templatescope.outer = ((Macro)syntax1).getCapturedScope();
            templatescope.macroContext = translator.macroContext;
        }
        templatescope.syntax = syntax1;
        return templatescope;
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        outer = (ScopeExp)objectinput.readObject();
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append("(for ").append(syntax).append(")").toString();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(outer);
    }
}
