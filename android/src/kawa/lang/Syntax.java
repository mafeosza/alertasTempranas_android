// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.ScopeExp;
import gnu.lists.Consumer;
import gnu.lists.Pair;
import gnu.mapping.Named;
import gnu.mapping.Symbol;
import gnu.text.Printable;
import java.util.Stack;
import java.util.Vector;

// Referenced classes of package kawa.lang:
//            Translator

public abstract class Syntax
    implements Printable, Named
{

    Object name;

    public Syntax()
    {
    }

    public Syntax(Object obj)
    {
        setName(obj);
    }

    public final String getName()
    {
        if (name == null)
        {
            return null;
        }
        if (name instanceof Symbol)
        {
            return ((Symbol)name).getName();
        } else
        {
            return name.toString();
        }
    }

    public Object getSymbol()
    {
        return name;
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<syntax ");
        String s1 = getName();
        String s = s1;
        if (s1 == null)
        {
            s = "<unnamed>";
        }
        consumer.write(s);
        consumer.write(62);
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        throw new InternalError("rewrite method not defined");
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        return rewrite(pair.getCdr(), translator);
    }

    public Expression rewriteForm(Object obj, Translator translator)
    {
        if (obj instanceof Pair)
        {
            return rewriteForm((Pair)obj, translator);
        } else
        {
            return translator.syntaxError((new StringBuilder()).append("non-list form for ").append(this).toString());
        }
    }

    public boolean scanForDefinitions(Pair pair, Vector vector, ScopeExp scopeexp, Translator translator)
    {
        vector.addElement(pair);
        return true;
    }

    public void scanForm(Pair pair, ScopeExp scopeexp, Translator translator)
    {
        if (!scanForDefinitions(pair, translator.formStack, scopeexp, translator))
        {
            translator.formStack.add(new ErrorExp((new StringBuilder()).append("syntax error expanding ").append(this).toString()));
        }
    }

    public void setName(Object obj)
    {
        name = obj;
    }

    public void setName(String s)
    {
        name = s;
    }
}
