// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.ThisExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.Consumer;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.text.SourceMessages;
import kawa.standard.object;

// Referenced classes of package kawa.lang:
//            Syntax, Translator, SyntaxForm, SyntaxForms, 
//            TemplateScope

public class Lambda extends Syntax
{

    public static final Keyword nameKeyword = Keyword.make("name");
    public Expression defaultDefault;
    public Object keyKeyword;
    public Object optionalKeyword;
    public Object restKeyword;

    public Lambda()
    {
        defaultDefault = QuoteExp.falseExp;
    }

    private static void addParam(Declaration declaration, ScopeExp scopeexp, LambdaExp lambdaexp, Translator translator)
    {
        Declaration declaration1 = declaration;
        if (scopeexp != null)
        {
            declaration1 = translator.makeRenamedAlias(declaration, scopeexp);
        }
        lambdaexp.addDeclaration(declaration1);
        if (scopeexp != null)
        {
            declaration1.context = scopeexp;
        }
    }

    public void print(Consumer consumer)
    {
        consumer.write("#<builtin lambda>");
    }

    public Expression rewrite(Object obj, Translator translator)
    {
        if (!(obj instanceof Pair))
        {
            obj = translator.syntaxError("missing formals in lambda");
        } else
        {
            int i = translator.getMessages().getErrorCount();
            LambdaExp lambdaexp = new LambdaExp();
            obj = (Pair)obj;
            Translator.setLine(lambdaexp, obj);
            rewrite(lambdaexp, ((Pair) (obj)).getCar(), ((Pair) (obj)).getCdr(), translator, null);
            obj = lambdaexp;
            if (translator.getMessages().getErrorCount() > i)
            {
                return new ErrorExp("bad lambda expression");
            }
        }
        return ((Expression) (obj));
    }

    public void rewrite(LambdaExp lambdaexp, Object obj, Object obj1, Translator translator, TemplateScope templatescope)
    {
        rewriteFormals(lambdaexp, obj, translator, templatescope);
        if (obj1 instanceof PairWithPosition)
        {
            lambdaexp.setFile(((PairWithPosition)obj1).getFileName());
        }
        rewriteBody(lambdaexp, rewriteAttrs(lambdaexp, obj1, translator), translator);
    }

    public Object rewriteAttrs(LambdaExp lambdaexp, Object obj, Translator translator)
    {
        SyntaxForm syntaxform;
        Object obj2;
        Object obj3;
        boolean flag;
        boolean flag1;
        obj3 = null;
        obj2 = null;
        flag1 = false;
        flag = false;
        syntaxform = null;
_L8:
        for (; obj instanceof SyntaxForm; obj = syntaxform.getDatum())
        {
            syntaxform = (SyntaxForm)obj;
        }

        if (obj instanceof Pair) goto _L2; else goto _L1
_L1:
        int i = flag1 | flag;
        if (i != 0)
        {
            lambdaexp.nameDecl.setFlag(i);
        }
        lambdaexp = ((LambdaExp) (obj));
        if (syntaxform != null)
        {
            lambdaexp = ((LambdaExp) (SyntaxForms.fromDatumIfNeeded(obj, syntaxform)));
        }
        return lambdaexp;
_L2:
        Object obj1;
        Object obj5;
        obj5 = (Pair)obj;
        obj1 = Translator.stripSyntax(((Pair) (obj5)).getCar());
        if (!translator.matches(obj1, "::")) goto _L4; else goto _L3
_L3:
        Object obj4 = null;
_L5:
        obj1 = syntaxform;
        for (obj5 = ((Pair) (obj5)).getCdr(); obj5 instanceof SyntaxForm; obj5 = ((SyntaxForm) (obj1)).getDatum())
        {
            obj1 = (SyntaxForm)obj5;
        }

        continue; /* Loop/switch isn't completed */
_L4:
        obj4 = obj1;
        if (obj1 instanceof Keyword) goto _L5; else goto _L1
        if (!(obj5 instanceof Pair)) goto _L1; else goto _L6
_L6:
        int j;
        int k;
        obj5 = (Pair)obj5;
        if (obj4 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (lambdaexp.isClassMethod() && "*init*".equals(lambdaexp.getName()))
        {
            translator.error('e', "explicit return type for '*init*' method");
            obj1 = obj2;
            j = ((flag) ? 1 : 0);
            obj = obj3;
            k = ((flag1) ? 1 : 0);
        } else
        {
            lambdaexp.body = new LangExp(((Object) (new Object[] {
                obj5, obj1
            })));
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        }
_L9:
        obj4 = ((Pair) (obj5)).getCdr();
        flag1 = k;
        obj3 = obj;
        flag = j;
        obj2 = obj1;
        obj = obj4;
        if (true) goto _L8; else goto _L7
_L7:
label0:
        {
            if (obj4 != object.accessKeyword)
            {
                break MISSING_BLOCK_LABEL_545;
            }
            obj = translator.rewrite_car(((Pair) (obj5)), ((SyntaxForm) (obj1)));
            if (obj instanceof QuoteExp)
            {
                obj = ((QuoteExp)obj).getValue();
                if ((obj instanceof SimpleSymbol) || (obj instanceof CharSequence))
                {
                    break label0;
                }
            }
            translator.error('e', "access: value not a constant symbol or string");
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        }
          goto _L9
        if (lambdaexp.nameDecl == null)
        {
            translator.error('e', "access: not allowed for anonymous function");
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        } else
        {
            obj = obj.toString();
            if ("private".equals(obj))
            {
                j = 0x1000000;
            } else
            if ("protected".equals(obj))
            {
                j = 0x2000000;
            } else
            if ("public".equals(obj))
            {
                j = 0x4000000;
            } else
            if ("package".equals(obj))
            {
                j = 0x8000000;
            } else
            {
                translator.error('e', "unknown access specifier");
                j = ((flag1) ? 1 : 0);
            }
            if (obj3 != null && obj != null)
            {
                translator.error('e', (new StringBuilder()).append("duplicate access specifiers - ").append(((String) (obj3))).append(" and ").append(((String) (obj))).toString());
            }
            k = j;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        }
          goto _L9
label1:
        {
            if (obj4 != object.allocationKeyword)
            {
                break MISSING_BLOCK_LABEL_770;
            }
            obj = translator.rewrite_car(((Pair) (obj5)), ((SyntaxForm) (obj1)));
            if (obj instanceof QuoteExp)
            {
                obj = ((QuoteExp)obj).getValue();
                if ((obj instanceof SimpleSymbol) || (obj instanceof CharSequence))
                {
                    break label1;
                }
            }
            translator.error('e', "allocation: value not a constant symbol or string");
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        }
          goto _L9
        if (lambdaexp.nameDecl == null)
        {
            translator.error('e', "allocation: not allowed for anonymous function");
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        } else
        {
            obj1 = obj.toString();
            if ("class".equals(obj1) || "static".equals(obj1))
            {
                j = 2048;
            } else
            if ("instance".equals(obj1))
            {
                j = 4096;
            } else
            {
                translator.error('e', "unknown allocation specifier");
                j = ((flag) ? 1 : 0);
            }
            if (obj2 != null && obj1 != null)
            {
                translator.error('e', (new StringBuilder()).append("duplicate allocation specifiers - ").append(((String) (obj2))).append(" and ").append(((String) (obj1))).toString());
            }
            k = ((flag1) ? 1 : 0);
            obj = obj3;
        }
          goto _L9
        if (obj4 == object.throwsKeyword)
        {
            obj = ((Pair) (obj5)).getCar();
            k = Translator.listLength(obj);
            if (k < 0)
            {
                translator.error('e', "throws: not followed by a list");
                k = ((flag1) ? 1 : 0);
                obj = obj3;
                j = ((flag) ? 1 : 0);
                obj1 = obj2;
            } else
            {
                obj4 = new Expression[k];
                for (j = 0; j < k; j++)
                {
                    for (; obj instanceof SyntaxForm; obj = ((SyntaxForm) (obj1)).getDatum())
                    {
                        obj1 = (SyntaxForm)obj;
                    }

                    obj = (Pair)obj;
                    obj4[j] = translator.rewrite_car(((Pair) (obj)), ((SyntaxForm) (obj1)));
                    Translator.setLine(obj4[j], obj);
                    obj = ((Pair) (obj)).getCdr();
                }

                lambdaexp.setExceptions(((Expression []) (obj4)));
                k = ((flag1) ? 1 : 0);
                obj = obj3;
                j = ((flag) ? 1 : 0);
                obj1 = obj2;
            }
        } else
        if (obj4 == nameKeyword)
        {
            obj4 = translator.rewrite_car(((Pair) (obj5)), ((SyntaxForm) (obj1)));
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
            if (obj4 instanceof QuoteExp)
            {
                lambdaexp.setName(((QuoteExp)obj4).getValue().toString());
                k = ((flag1) ? 1 : 0);
                obj = obj3;
                j = ((flag) ? 1 : 0);
                obj1 = obj2;
            }
        } else
        {
            translator.error('w', (new StringBuilder()).append("unknown procedure property ").append(obj4).toString());
            k = ((flag1) ? 1 : 0);
            obj = obj3;
            j = ((flag) ? 1 : 0);
            obj1 = obj2;
        }
          goto _L9
    }

    public void rewriteBody(LambdaExp lambdaexp, Object obj, Translator translator)
    {
        Object obj2;
        int k;
        k = 0;
        if (translator.curMethodLambda == null && lambdaexp.nameDecl != null && translator.getModule().getFlag(0x20000))
        {
            translator.curMethodLambda = lambdaexp;
        }
        translator.currentScope();
        translator.pushScope(lambdaexp);
        Declaration declaration1 = null;
        int i;
        int l;
        int i1;
        if (lambdaexp.keywords == null)
        {
            i = 0;
        } else
        {
            i = lambdaexp.keywords.length;
        }
        if (lambdaexp.defaultArgs == null)
        {
            i = 0;
        } else
        {
            i = lambdaexp.defaultArgs.length - i;
        }
        i1 = 0;
        l = 0;
        for (Object obj1 = lambdaexp.firstDecl(); obj1 != null;)
        {
            Declaration declaration;
            int j1;
            int k1;
label0:
            {
                declaration = ((Declaration) (obj1));
                j1 = k;
                if (((Declaration) (obj1)).isAlias())
                {
                    declaration = Translator.getOriginalRef(((Declaration) (obj1))).getBinding();
                    lambdaexp.replaceFollowing(declaration1, declaration);
                    declaration.context = lambdaexp;
                    translator.pushRenamedAlias(((Declaration) (obj1)));
                    j1 = k + 1;
                }
                obj1 = declaration.getTypeExp();
                if (obj1 instanceof LangExp)
                {
                    declaration.setType(translator.exp2Type((Pair)((LangExp)obj1).getLangValue()));
                }
                declaration1 = declaration;
                k1 = l;
                if (i1 < lambdaexp.min_args)
                {
                    break label0;
                }
                if (i1 >= lambdaexp.min_args + i && lambdaexp.max_args < 0)
                {
                    k1 = l;
                    if (i1 == lambdaexp.min_args + i)
                    {
                        break label0;
                    }
                }
                lambdaexp.defaultArgs[l] = translator.rewrite(lambdaexp.defaultArgs[l]);
                k1 = l + 1;
            }
            i1++;
            translator.lexical.push(declaration);
            obj1 = declaration.nextDecl();
            k = j1;
            l = k1;
        }

        if (lambdaexp.isClassMethod() && !lambdaexp.nameDecl.getFlag(2048L))
        {
            lambdaexp.add(null, new Declaration(ThisExp.THIS_NAME));
        }
        LambdaExp lambdaexp1 = translator.curLambda;
        translator.curLambda = lambdaexp;
        obj2 = lambdaexp.returnType;
        if (lambdaexp.body instanceof LangExp)
        {
            obj2 = ((Object) ((Object[])(Object[])((LangExp)lambdaexp.body).getLangValue()));
            obj2 = translator.rewrite_car((Pair)obj2[0], (SyntaxForm)obj2[1]);
            obj2 = translator.getLanguage().getTypeFor(((Expression) (obj2)));
        }
        lambdaexp.body = translator.rewrite_body(obj);
        translator.curLambda = lambdaexp1;
        if (!(lambdaexp.body instanceof BeginExp)) goto _L2; else goto _L1
_L1:
        int j;
        obj = ((BeginExp)lambdaexp.body).getExpressions();
        j = obj.length;
        if (j <= 1) goto _L2; else goto _L3
_L3:
        if (obj[0] instanceof ReferenceExp) goto _L5; else goto _L4
_L4:
        Object obj3 = obj[0].valueIfConstant();
        if (!(obj3 instanceof Type) && !(obj3 instanceof Class)) goto _L2; else goto _L5
_L5:
        obj2 = obj[0];
        j--;
        if (j == 1)
        {
            lambdaexp.body = obj[1];
        } else
        {
            Expression aexpression[] = new Expression[j];
            System.arraycopy(obj, 1, aexpression, 0, j);
            lambdaexp.body = BeginExp.canonicalize(aexpression);
        }
        lambdaexp.setCoercedReturnValue(((Expression) (obj2)), translator.getLanguage());
_L7:
        translator.pop(lambdaexp);
        lambdaexp.countDecls();
        translator.popRenamedAlias(k);
        lambdaexp.countDecls();
        if (translator.curMethodLambda == lambdaexp)
        {
            translator.curMethodLambda = null;
        }
        return;
_L2:
        lambdaexp.setCoercedReturnType(((Type) (obj2)));
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        translator = rewrite(pair.getCdr(), translator);
        Translator.setLine(translator, pair);
        return translator;
    }

    public void rewriteFormals(LambdaExp lambdaexp, Object obj, Translator translator, TemplateScope templatescope)
    {
        Object obj1;
        int j;
        int k;
        int i1;
        if (lambdaexp.getSymbol() == null)
        {
            String s = lambdaexp.getFileName();
            int i = lambdaexp.getLineNumber();
            if (s != null && i > 0)
            {
                lambdaexp.setSourceLocation(s, i);
            }
        }
        obj1 = obj;
        k = -1;
        i1 = -1;
        j = -1;
_L7:
        Object obj2;
        obj2 = obj1;
        if (obj1 instanceof SyntaxForm)
        {
            obj2 = ((SyntaxForm)obj1).getDatum();
        }
        if (obj2 instanceof Pair) goto _L2; else goto _L1
_L1:
        if (!(obj2 instanceof Symbol)) goto _L4; else goto _L3
_L3:
        if (k < 0 && j < 0 && i1 < 0) goto _L6; else goto _L5
_L5:
        translator.syntaxError((new StringBuilder()).append("dotted rest-arg after ").append(optionalKeyword).append(", ").append(restKeyword).append(", or ").append(keyKeyword).toString());
_L10:
        return;
_L2:
        obj2 = (Pair)obj2;
        Object obj3 = ((Pair) (obj2)).getCar();
        obj1 = obj3;
        if (obj3 instanceof SyntaxForm)
        {
            obj1 = ((SyntaxForm)obj3).getDatum();
        }
        if (obj1 == optionalKeyword)
        {
            if (k >= 0)
            {
                translator.syntaxError((new StringBuilder()).append("multiple ").append(optionalKeyword).append(" in parameter list").toString());
                return;
            }
            if (i1 >= 0 || j >= 0)
            {
                translator.syntaxError((new StringBuilder()).append(optionalKeyword.toString()).append(" after ").append(restKeyword).append(" or ").append(keyKeyword).toString());
                return;
            }
            k = 0;
            obj1 = obj2;
        } else
        if (obj1 == restKeyword)
        {
            if (i1 >= 0)
            {
                translator.syntaxError((new StringBuilder()).append("multiple ").append(restKeyword).append(" in parameter list").toString());
                return;
            }
            if (j >= 0)
            {
                translator.syntaxError((new StringBuilder()).append(restKeyword.toString()).append(" after ").append(keyKeyword).toString());
                return;
            }
            i1 = 0;
            obj1 = obj2;
        } else
        if (obj1 == keyKeyword)
        {
            if (j >= 0)
            {
                translator.syntaxError((new StringBuilder()).append("multiple ").append(keyKeyword).append(" in parameter list").toString());
                return;
            }
            j = 0;
            obj1 = obj2;
        } else
        if (translator.matches(((Pair) (obj2)).getCar(), "::") && (((Pair) (obj2)).getCdr() instanceof Pair))
        {
            obj1 = (Pair)((Pair) (obj2)).getCdr();
        } else
        if (j >= 0)
        {
            j++;
            obj1 = obj2;
        } else
        if (i1 >= 0)
        {
            i1++;
            obj1 = obj2;
        } else
        if (k >= 0)
        {
            k++;
            obj1 = obj2;
        } else
        {
            lambdaexp.min_args = lambdaexp.min_args + 1;
            obj1 = obj2;
        }
        ((Pair) (obj1)).getCdr();
        obj1 = ((Pair) (obj1)).getCdr();
          goto _L7
_L6:
        i1 = 1;
_L9:
        if (i1 > 1)
        {
            translator.syntaxError((new StringBuilder()).append("multiple ").append(restKeyword).append(" parameters").toString());
            return;
        }
        break; /* Loop/switch isn't completed */
_L4:
        if (obj2 != LList.Empty)
        {
            translator.syntaxError("misformed formals in lambda");
            return;
        }
        if (true) goto _L9; else goto _L8
_L8:
        TemplateScope templatescope1;
        int j1 = k;
        if (k < 0)
        {
            j1 = 0;
        }
        k = i1;
        if (i1 < 0)
        {
            k = 0;
        }
        i1 = j;
        if (j < 0)
        {
            i1 = 0;
        }
        if (k > 0)
        {
            lambdaexp.max_args = -1;
        } else
        {
            lambdaexp.max_args = lambdaexp.min_args + j1 + i1 * 2;
        }
        if (j1 + i1 > 0)
        {
            lambdaexp.defaultArgs = new Expression[j1 + i1];
        }
        if (i1 > 0)
        {
            lambdaexp.keywords = new Keyword[i1];
        }
        obj1 = obj;
        i1 = 0;
        j = 0;
        templatescope1 = null;
        obj = templatescope;
        templatescope = ((TemplateScope) (obj1));
_L11:
label0:
        {
            obj2 = templatescope;
            if (templatescope instanceof SyntaxForm)
            {
                obj = (SyntaxForm)templatescope;
                obj2 = ((SyntaxForm) (obj)).getDatum();
                obj = ((SyntaxForm) (obj)).getScope();
            }
            obj1 = obj;
            if (obj2 instanceof Pair)
            {
                break label0;
            }
            templatescope = ((TemplateScope) (obj2));
            if (obj2 instanceof SyntaxForm)
            {
                obj = (SyntaxForm)obj2;
                templatescope = ((TemplateScope) (((SyntaxForm) (obj)).getDatum()));
                obj = ((SyntaxForm) (obj)).getScope();
            }
            if (templatescope instanceof Symbol)
            {
                templatescope = new Declaration(templatescope);
                templatescope.setType(LangObjType.listType);
                templatescope.setFlag(0x40000L);
                templatescope.noteValue(null);
                addParam(templatescope, ((ScopeExp) (obj)), lambdaexp, translator);
                return;
            }
        }
          goto _L10
        Pair pair = (Pair)obj2;
        Object obj4 = pair.getCar();
        templatescope = ((TemplateScope) (obj4));
        if (obj4 instanceof SyntaxForm)
        {
            obj1 = (SyntaxForm)obj4;
            templatescope = ((TemplateScope) (((SyntaxForm) (obj1)).getDatum()));
            obj1 = ((SyntaxForm) (obj1)).getScope();
        }
        Object obj6;
        int l;
        if (templatescope == optionalKeyword || templatescope == restKeyword || templatescope == keyKeyword)
        {
            obj6 = pair;
            l = i1;
            templatescope1 = templatescope;
        } else
        {
            Object obj7;
            Object obj11;
            Object obj15;
label1:
            {
                obj15 = translator.pushPositionOf(pair);
                Object obj12 = null;
                Expression expression = defaultDefault;
                Object obj8 = null;
                Object obj9 = null;
                if (translator.matches(templatescope, "::"))
                {
                    translator.syntaxError("'::' must follow parameter name");
                    return;
                }
                Object obj5 = translator.namespaceResolve(templatescope);
                Object obj14;
                if (obj5 instanceof Symbol)
                {
                    obj14 = expression;
                    obj7 = obj5;
                    obj6 = pair;
                    obj11 = obj1;
                    templatescope = obj9;
                    if (pair.getCdr() instanceof Pair)
                    {
                        obj8 = (Pair)pair.getCdr();
                        obj14 = expression;
                        obj7 = obj5;
                        obj6 = pair;
                        obj11 = obj1;
                        templatescope = obj9;
                        if (translator.matches(((Pair) (obj8)).getCar(), "::"))
                        {
                            if (!(pair.getCdr() instanceof Pair))
                            {
                                translator.syntaxError((new StringBuilder()).append("'::' not followed by a type specifier (for parameter '").append(obj5).append("')").toString());
                                return;
                            }
                            obj6 = (Pair)((Pair) (obj8)).getCdr();
                            templatescope = ((TemplateScope) (obj6));
                            obj11 = obj1;
                            obj7 = obj5;
                            obj14 = expression;
                        }
                    }
                } else
                {
                    obj14 = expression;
                    obj7 = obj12;
                    obj6 = pair;
                    obj11 = obj1;
                    templatescope = obj9;
                    if (obj5 instanceof Pair)
                    {
                        Pair pair1 = (Pair)obj5;
                        obj6 = pair1.getCar();
                        templatescope = ((TemplateScope) (obj6));
                        obj5 = obj1;
                        if (obj6 instanceof SyntaxForm)
                        {
                            obj1 = (SyntaxForm)obj6;
                            templatescope = ((TemplateScope) (((SyntaxForm) (obj1)).getDatum()));
                            obj5 = ((SyntaxForm) (obj1)).getScope();
                        }
                        obj1 = translator.namespaceResolve(templatescope);
                        obj14 = expression;
                        obj7 = obj12;
                        obj6 = pair;
                        obj11 = obj5;
                        templatescope = obj9;
                        if (obj1 instanceof Symbol)
                        {
                            obj14 = expression;
                            obj7 = obj12;
                            obj6 = pair;
                            obj11 = obj5;
                            templatescope = obj9;
                            if (pair1.getCdr() instanceof Pair)
                            {
                                Object obj13 = obj1;
                                obj1 = (Pair)pair1.getCdr();
                                templatescope = ((TemplateScope) (obj1));
                                Object obj10;
                                if (translator.matches(((Pair) (obj1)).getCar(), "::"))
                                {
                                    if (!(((Pair) (obj1)).getCdr() instanceof Pair))
                                    {
                                        translator.syntaxError((new StringBuilder()).append("'::' not followed by a type specifier (for parameter '").append(obj13).append("')").toString());
                                        return;
                                    }
                                    templatescope = (Pair)((Pair) (obj1)).getCdr();
                                    obj8 = templatescope;
                                    if (templatescope.getCdr() instanceof Pair)
                                    {
                                        templatescope = (Pair)templatescope.getCdr();
                                    } else
                                    if (templatescope.getCdr() == LList.Empty)
                                    {
                                        templatescope = null;
                                    } else
                                    {
                                        translator.syntaxError((new StringBuilder()).append("improper list in specifier for parameter '").append(obj13).append("')").toString());
                                        return;
                                    }
                                }
                                obj10 = expression;
                                obj1 = templatescope;
                                if (templatescope != null)
                                {
                                    obj10 = expression;
                                    obj1 = templatescope;
                                    if (templatescope1 != null)
                                    {
                                        obj10 = templatescope.getCar();
                                        if (templatescope.getCdr() instanceof Pair)
                                        {
                                            obj1 = (Pair)templatescope.getCdr();
                                        } else
                                        if (templatescope.getCdr() == LList.Empty)
                                        {
                                            obj1 = null;
                                        } else
                                        {
                                            translator.syntaxError((new StringBuilder()).append("improper list in specifier for parameter '").append(obj13).append("')").toString());
                                            return;
                                        }
                                    }
                                }
                                obj14 = obj10;
                                obj7 = obj13;
                                obj6 = pair;
                                obj11 = obj5;
                                templatescope = ((TemplateScope) (obj8));
                                if (obj1 != null)
                                {
                                    if (obj8 != null)
                                    {
                                        translator.syntaxError((new StringBuilder()).append("duplicate type specifier for parameter '").append(obj13).append('\'').toString());
                                        return;
                                    }
                                    templatescope = ((TemplateScope) (obj1));
                                    obj14 = obj10;
                                    obj7 = obj13;
                                    obj6 = pair;
                                    obj11 = obj5;
                                    if (((Pair) (obj1)).getCdr() != LList.Empty)
                                    {
                                        translator.syntaxError((new StringBuilder()).append("junk at end of specifier for parameter '").append(obj13).append('\'').append(" after type ").append(((Pair) (obj1)).getCar()).toString());
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                if (obj7 == null)
                {
                    translator.syntaxError((new StringBuilder()).append("parameter is neither name nor (name :: type) nor (name default): ").append(obj6).toString());
                    return;
                }
                if (templatescope1 != optionalKeyword)
                {
                    l = i1;
                    if (templatescope1 != keyKeyword)
                    {
                        break label1;
                    }
                }
                lambdaexp.defaultArgs[i1] = new LangExp(obj14);
                l = i1 + 1;
            }
            i1 = j;
            if (templatescope1 == keyKeyword)
            {
                Keyword akeyword[] = lambdaexp.keywords;
                if (obj7 instanceof Symbol)
                {
                    obj1 = ((Symbol)obj7).getName();
                } else
                {
                    obj1 = obj7.toString();
                }
                akeyword[j] = Keyword.make(((String) (obj1)));
                i1 = j + 1;
            }
            obj1 = new Declaration(obj7);
            Translator.setLine(((Declaration) (obj1)), obj2);
            if (templatescope != null)
            {
                ((Declaration) (obj1)).setTypeExp(new LangExp(templatescope));
                ((Declaration) (obj1)).setFlag(8192L);
            } else
            if (templatescope1 == restKeyword)
            {
                ((Declaration) (obj1)).setType(LangObjType.listType);
            }
            ((Declaration) (obj1)).setFlag(0x40000L);
            ((Declaration) (obj1)).noteValue(null);
            addParam(((Declaration) (obj1)), ((ScopeExp) (obj11)), lambdaexp, translator);
            translator.popPositionOf(obj15);
            j = i1;
        }
        templatescope = ((TemplateScope) (((Pair) (obj6)).getCdr()));
        i1 = l;
          goto _L11
    }

    public void setKeywords(Object obj, Object obj1, Object obj2)
    {
        optionalKeyword = obj;
        restKeyword = obj1;
        keyKeyword = obj2;
    }

    public Object skipAttrs(LambdaExp lambdaexp, Object obj, Translator translator)
    {
_L2:
        Object obj1;
label0:
        {
            if (obj instanceof Pair)
            {
                lambdaexp = (Pair)obj;
                if (lambdaexp.getCdr() instanceof Pair)
                {
                    break label0;
                }
            }
            return obj;
        }
        obj1 = lambdaexp.getCar();
          goto _L1
_L4:
        obj = ((Pair)lambdaexp.getCdr()).getCdr();
        if (true) goto _L2; else goto _L1
_L1:
        if (translator.matches(obj1, "::") || (obj1 instanceof Keyword)) goto _L4; else goto _L3
_L3:
        return obj;
    }

}
