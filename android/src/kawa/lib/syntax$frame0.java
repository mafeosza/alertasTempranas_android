// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.lists.LList;
import gnu.lists.Pair;
import kawa.lang.Pattern;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxTemplate;
import kawa.lang.TemplateScope;
import kawa.standard.syntax_case;

// Referenced classes of package kawa.lib:
//            syntax, prim_syntax

public class  extends ModuleBody
{

    TemplateScope $unnamed$0;
    Object $unnamed$1[];

    public Object lambda6loop(Object obj)
    {
        Object aobj[] = SyntaxPattern.allocVars(5, $unnamed$1);
        if (syntax.Lit85.match(obj, aobj, 0))
        {
            return Pair.make(syntax.Lit86.execute(aobj, $unnamed$0), lambda6loop(syntax.Lit87.execute(aobj, $unnamed$0)));
        }
        if (syntax.Lit88.match(obj, aobj, 0))
        {
            return LList.Empty;
        }
        if (syntax.Lit89.match(obj, aobj, 0))
        {
            Object obj1 = syntax.Lit90.execute(aobj, $unnamed$0);
            if ("invalid case-lambda clause" instanceof Object[])
            {
                obj = ((Object) ((Object[])"invalid case-lambda clause"));
            } else
            {
                obj = ((Object) (new Object[] {
                    "invalid case-lambda clause"
                }));
            }
            return LList.list1(prim_syntax.syntaxError(obj1, ((Object []) (obj))));
        } else
        {
            return syntax_case.error("syntax-case", obj);
        }
    }

    public ()
    {
    }
}
