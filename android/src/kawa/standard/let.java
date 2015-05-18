// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.LetExp;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Symbol;
import java.util.Stack;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

public class let extends Syntax
{

    public static final let let;

    public let()
    {
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        if (!(obj instanceof Pair))
        {
            return translator.syntaxError("missing let arguments");
        }
        Object obj1 = (Pair)obj;
        Object obj2 = ((Pair) (obj1)).getCar();
        Object obj8 = ((Pair) (obj1)).getCdr();
        int i1 = Translator.listLength(obj2);
        if (i1 < 0)
        {
            return translator.syntaxError("bindings not a proper list");
        }
        Expression aexpression[] = new Expression[i1];
        LetExp letexp = new LetExp(aexpression);
        obj1 = null;
        int i = 0;
        SyntaxForm syntaxform = null;
        for (int j = 0; j < i1;)
        {
            Object obj5;
            Object obj6;
            Object obj7;
            Pair pair1;
            Object obj9;
            Declaration declaration;
            int l;
label0:
            {
                Pair pair;
label1:
                {
                    for (; obj2 instanceof SyntaxForm; obj2 = syntaxform.getDatum())
                    {
                        syntaxform = (SyntaxForm)obj2;
                    }

                    pair1 = (Pair)obj2;
                    obj5 = pair1.getCar();
                    obj2 = syntaxform;
                    Object obj3 = obj5;
                    if (obj5 instanceof SyntaxForm)
                    {
                        obj2 = (SyntaxForm)obj5;
                        obj3 = ((SyntaxForm) (obj2)).getDatum();
                    }
                    if (!(obj3 instanceof Pair))
                    {
                        return translator.syntaxError((new StringBuilder()).append("let binding is not a pair:").append(obj3).toString());
                    }
                    obj6 = (Pair)obj3;
                    obj5 = ((Pair) (obj6)).getCar();
                    if (obj5 instanceof SyntaxForm)
                    {
                        obj3 = (SyntaxForm)obj5;
                        obj5 = ((SyntaxForm) (obj3)).getDatum();
                        obj3 = ((SyntaxForm) (obj3)).getScope();
                    } else
                    if (obj2 == null)
                    {
                        obj3 = null;
                    } else
                    {
                        obj3 = ((SyntaxForm) (obj2)).getScope();
                    }
                    obj9 = translator.namespaceResolve(obj5);
                    if (!(obj9 instanceof Symbol))
                    {
                        return translator.syntaxError((new StringBuilder()).append("variable ").append(obj9).append(" in let binding is not a symbol: ").append(obj).toString());
                    }
                    declaration = letexp.addDeclaration(obj9);
                    declaration.setFlag(0x40000L);
                    obj5 = obj1;
                    l = i;
                    if (obj3 != null)
                    {
                        obj5 = translator.makeRenamedAlias(declaration, ((gnu.expr.ScopeExp) (obj3)));
                        obj3 = obj1;
                        if (obj1 == null)
                        {
                            obj3 = new Stack();
                        }
                        ((Stack) (obj3)).push(obj5);
                        l = i + 1;
                        obj5 = obj3;
                    }
                    obj3 = ((Pair) (obj6)).getCdr();
                    obj1 = obj2;
                    for (obj2 = obj3; obj2 instanceof SyntaxForm; obj2 = ((SyntaxForm) (obj1)).getDatum())
                    {
                        obj1 = (SyntaxForm)obj2;
                    }

                    if (!(obj2 instanceof Pair))
                    {
                        return translator.syntaxError((new StringBuilder()).append("let has no value for '").append(obj9).append("'").toString());
                    }
                    pair = (Pair)obj2;
                    for (obj3 = pair.getCdr(); obj3 instanceof SyntaxForm; obj3 = ((SyntaxForm) (obj1)).getDatum())
                    {
                        obj1 = (SyntaxForm)obj3;
                    }

                    obj2 = pair;
                    obj7 = obj3;
                    obj6 = obj1;
                    if (!translator.matches(pair.getCar(), "::"))
                    {
                        break label0;
                    }
                    if (obj3 instanceof Pair)
                    {
                        pair = (Pair)obj3;
                        if (pair.getCdr() != LList.Empty)
                        {
                            break label1;
                        }
                    }
                    return translator.syntaxError("missing type after '::' in let");
                }
                obj2 = pair.getCdr();
                Object obj4 = obj1;
                obj1 = obj2;
                do
                {
                    obj2 = pair;
                    obj7 = obj1;
                    obj6 = obj4;
                    if (!(obj1 instanceof SyntaxForm))
                    {
                        break;
                    }
                    obj4 = (SyntaxForm)obj1;
                    obj1 = ((SyntaxForm) (obj4)).getDatum();
                } while (true);
            }
            if (obj7 != LList.Empty)
            {
                if (obj7 instanceof Pair)
                {
                    declaration.setType(translator.exp2Type(((Pair) (obj2))));
                    declaration.setFlag(8192L);
                    obj2 = (Pair)obj7;
                } else
                {
                    return translator.syntaxError((new StringBuilder()).append("let binding for '").append(obj9).append("' is improper list").toString());
                }
            }
            aexpression[j] = translator.rewrite_car(((Pair) (obj2)), ((SyntaxForm) (obj6)));
            if (((Pair) (obj2)).getCdr() != LList.Empty)
            {
                return translator.syntaxError((new StringBuilder()).append("junk after declaration of ").append(obj9).toString());
            }
            declaration.noteValue(aexpression[j]);
            obj2 = pair1.getCdr();
            j++;
            obj1 = obj5;
            i = l;
        }

        int k = i;
        do
        {
            k--;
            if (k >= 0)
            {
                translator.pushRenamedAlias((Declaration)((Stack) (obj1)).pop());
            } else
            {
                translator.push(letexp);
                letexp.body = translator.rewrite_body(obj8);
                translator.pop(letexp);
                translator.popRenamedAlias(i);
                return letexp;
            }
        } while (true);
    }

    static 
    {
        let = new let();
        let.setName("let");
    }
}
