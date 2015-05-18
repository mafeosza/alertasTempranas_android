// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Syntax;
import kawa.lang.Translator;

public class syntax_error extends Syntax
{

    public static final syntax_error syntax_error;

    public syntax_error()
    {
    }

    public static Expression error(Object obj, Object aobj[])
    {
        Object obj1;
        obj1 = new StringBuffer();
        int j = aobj.length;
        if (aobj == null || j == 0)
        {
            ((StringBuffer) (obj1)).append("invalid syntax");
        } else
        {
            int i = 0;
            while (i < j) 
            {
                ((StringBuffer) (obj1)).append(aobj[i]);
                i++;
            }
        }
        aobj = (Translator)Compilation.getCurrent();
        if (aobj == null)
        {
            throw new RuntimeException(((StringBuffer) (obj1)).toString());
        }
        obj = ((Translator) (aobj)).pushPositionOf(obj);
        obj1 = ((Translator) (aobj)).syntaxError(((StringBuffer) (obj1)).toString());
        ((Translator) (aobj)).popPositionOf(obj);
        return ((Expression) (obj1));
        Exception exception;
        exception;
        ((Translator) (aobj)).popPositionOf(obj);
        throw exception;
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i;
        for (i = 0; obj instanceof Pair; i++)
        {
            obj = (Pair)obj;
            if (i > 0)
            {
                stringbuffer.append(' ');
            }
            stringbuffer.append(((Pair) (obj)).getCar());
            obj = ((Pair) (obj)).getCdr();
        }

        if (obj != LList.Empty)
        {
            if (i > 0)
            {
                stringbuffer.append(' ');
            }
            stringbuffer.append(obj);
        }
        return translator.syntaxError(stringbuffer.toString());
    }

    static 
    {
        syntax_error = new syntax_error();
        syntax_error.setName("%syntax-error");
    }
}
