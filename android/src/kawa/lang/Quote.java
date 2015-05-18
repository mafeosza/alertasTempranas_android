// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.Method;
import gnu.expr.ApplyExp;
import gnu.expr.Compilation;
import gnu.expr.Expression;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Environment;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import java.util.IdentityHashMap;
import java.util.Vector;

// Referenced classes of package kawa.lang:
//            Syntax, SyntaxForm, SyntaxForms, Translator

public class Quote extends Syntax
{

    private static final Object CYCLE = new String("(cycle)");
    protected static final int QUOTE_DEPTH = -1;
    private static final Object WORKING = new String("(working)");
    static final Method appendMethod;
    static final Method consXMethod;
    static final Method makePairMethod;
    static final Method makeVectorMethod = ClassType.make("gnu.lists.FVector").getDeclaredMethod("make", 1);
    public static final Quote plainQuote = new Quote("quote", false);
    public static final Quote quasiQuote = new Quote("quasiquote", true);
    static final ClassType quoteType;
    static final Method vectorAppendMethod = ClassType.make("kawa.standard.vector_append").getDeclaredMethod("apply$V", 1);
    protected boolean isQuasi;

    public Quote(String s, boolean flag)
    {
        super(s);
        isQuasi = flag;
    }

    public static Object append$V(Object aobj[])
    {
        int i = aobj.length;
        if (i != 0) goto _L2; else goto _L1
_L1:
        Object obj1 = LList.Empty;
_L4:
        return obj1;
_L2:
        Object obj;
        obj = aobj[i - 1];
        i--;
_L5:
        i--;
        obj1 = obj;
        if (i < 0) goto _L4; else goto _L3
_L3:
        Object obj2;
        SyntaxForm syntaxform;
        Pair pair;
        obj2 = aobj[i];
        pair = null;
        syntaxform = null;
        obj1 = null;
_L6:
label0:
        {
            for (; obj2 instanceof SyntaxForm; obj2 = syntaxform.getDatum())
            {
                syntaxform = (SyntaxForm)obj2;
            }

            if (obj2 != LList.Empty)
            {
                break label0;
            }
            Object obj3;
            Pair pair1;
            if (pair != null)
            {
                pair.setCdr(obj);
            } else
            {
                obj1 = obj;
            }
            obj = obj1;
        }
          goto _L5
        pair1 = (Pair)obj2;
        obj3 = pair1.getCar();
        obj2 = obj3;
        if (syntaxform != null)
        {
            obj2 = obj3;
            if (!(obj3 instanceof SyntaxForm))
            {
                obj2 = SyntaxForms.makeForm(obj3, syntaxform.getScope());
            }
        }
        obj2 = new Pair(obj2, null);
        if (pair == null)
        {
            obj1 = obj2;
        } else
        {
            pair.setCdr(obj2);
        }
        obj3 = pair1.getCdr();
        pair = ((Pair) (obj2));
        obj2 = obj3;
          goto _L6
    }

    public static Object consX$V(Object aobj[])
    {
        return LList.consX(aobj);
    }

    private static ApplyExp makeInvokeMakeVector(Expression aexpression[])
    {
        return new ApplyExp(makeVectorMethod, aexpression);
    }

    public static Symbol makeSymbol(Namespace namespace, Object obj)
    {
        if (obj instanceof CharSequence)
        {
            obj = ((CharSequence)obj).toString();
        } else
        {
            obj = (String)obj;
        }
        return namespace.getSymbol(((String) (obj)).intern());
    }

    public static Object quote(Object obj)
    {
        return plainQuote.expand(obj, -1, (Translator)Compilation.getCurrent());
    }

    public static Object quote(Object obj, Translator translator)
    {
        return plainQuote.expand(obj, -1, translator);
    }

    protected Expression coerceExpression(Object obj, Translator translator)
    {
        if (obj instanceof Expression)
        {
            return (Expression)obj;
        } else
        {
            return leaf(obj, translator);
        }
    }

    Object expand(Object obj, int i, SyntaxForm syntaxform, Object obj1, Translator translator)
    {
        Object obj2;
        IdentityHashMap identityhashmap;
        identityhashmap = (IdentityHashMap)obj1;
        obj2 = identityhashmap.get(obj);
        if (obj2 != WORKING) goto _L2; else goto _L1
_L1:
        identityhashmap.put(obj, CYCLE);
_L4:
        return obj2;
_L2:
        if (obj2 == CYCLE || obj2 != null) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof Pair)) goto _L6; else goto _L5
_L5:
        syntaxform = ((SyntaxForm) (expand_pair((Pair)obj, i, syntaxform, obj1, translator)));
_L19:
        if (obj != syntaxform && identityhashmap.get(obj) == CYCLE)
        {
            translator.error('e', "cycle in non-literal data");
        }
        identityhashmap.put(obj, syntaxform);
        return syntaxform;
_L6:
        if (obj instanceof SyntaxForm)
        {
            syntaxform = (SyntaxForm)obj;
            syntaxform = ((SyntaxForm) (expand(syntaxform.getDatum(), i, syntaxform, obj1, translator)));
            continue; /* Loop/switch isn't completed */
        }
        if (!(obj instanceof FVector)) goto _L8; else goto _L7
_L7:
        Object aobj[];
        byte abyte0[];
        int j;
        int k;
        int j1;
        obj2 = (FVector)obj;
        j1 = ((FVector) (obj2)).size();
        aobj = new Object[j1];
        abyte0 = new byte[j1];
        j = 0;
        k = 0;
_L17:
        if (k >= j1) goto _L10; else goto _L9
_L9:
        Object obj3;
        int l;
        int i1;
        obj3 = ((FVector) (obj2)).get(k);
        i1 = i;
        l = i1;
        if (!(obj3 instanceof Pair)) goto _L12; else goto _L11
_L11:
        l = i1;
        if (i <= -1) goto _L12; else goto _L13
_L13:
        Pair pair;
        pair = (Pair)obj3;
        l = i1;
        if (!translator.matches(pair.getCar(), syntaxform, "unquote-splicing")) goto _L12; else goto _L14
_L14:
        i1--;
        l = i1;
        if (i1 != 0) goto _L12; else goto _L15
_L15:
label0:
        {
            if (pair.getCdr() instanceof Pair)
            {
                obj3 = (Pair)pair.getCdr();
                if (((Pair) (obj3)).getCdr() == LList.Empty)
                {
                    break label0;
                }
            }
            return translator.syntaxError((new StringBuilder()).append("invalid used of ").append(pair.getCar()).append(" in quasiquote template").toString());
        }
        aobj[k] = translator.rewrite_car(((Pair) (obj3)), syntaxform);
        abyte0[k] = 3;
_L16:
        l = j;
        if (abyte0[k] > j)
        {
            l = abyte0[k];
        }
        k++;
        j = l;
        continue; /* Loop/switch isn't completed */
_L12:
        aobj[k] = expand(obj3, l, syntaxform, obj1, translator);
        if (aobj[k] == obj3)
        {
            abyte0[k] = 0;
        } else
        if (aobj[k] instanceof Expression)
        {
            abyte0[k] = 2;
        } else
        {
            abyte0[k] = 1;
        }
        if (true) goto _L16; else goto _L10
_L10:
        if (j == 0)
        {
            syntaxform = ((SyntaxForm) (obj2));
        } else
        if (j == 1)
        {
            syntaxform = new FVector(aobj);
        } else
        {
            syntaxform = new Expression[j1];
            i = 0;
            while (i < j1) 
            {
                if (abyte0[i] == 3)
                {
                    syntaxform[i] = (Expression)aobj[i];
                } else
                if (j < 3)
                {
                    syntaxform[i] = coerceExpression(aobj[i], translator);
                } else
                if (abyte0[i] < 2)
                {
                    syntaxform[i] = leaf(new FVector(new Object[] {
                        aobj[i]
                    }), translator);
                } else
                {
                    syntaxform[i] = makeInvokeMakeVector(new Expression[] {
                        (Expression)aobj[i]
                    });
                }
                i++;
            }
            if (j < 3)
            {
                syntaxform = makeInvokeMakeVector(syntaxform);
            } else
            {
                syntaxform = new ApplyExp(vectorAppendMethod, syntaxform);
            }
        }
        continue; /* Loop/switch isn't completed */
        if (true) goto _L17; else goto _L8
_L8:
        syntaxform = ((SyntaxForm) (obj));
        if (true) goto _L19; else goto _L18
_L18:
    }

    protected Object expand(Object obj, int i, Translator translator)
    {
        return expand(obj, i, null, new IdentityHashMap(), translator);
    }

    protected boolean expandColonForms()
    {
        return true;
    }

    Object expand_pair(Pair pair, int i, SyntaxForm syntaxform, Object obj, Translator translator)
    {
        Object obj1 = pair;
_L13:
        if (!expandColonForms() || obj1 != pair || !translator.matches(((Pair) (obj1)).getCar(), syntaxform, LispLanguage.lookup_sym) || !(((Pair) (obj1)).getCdr() instanceof Pair)) goto _L2; else goto _L1
_L1:
        Object obj2 = (Pair)((Pair) (obj1)).getCdr();
        if (!(obj2 instanceof Pair)) goto _L2; else goto _L3
_L3:
        Object obj4 = (Pair)((Pair) (obj2)).getCdr();
        if (!(obj4 instanceof Pair) || ((Pair) (obj4)).getCdr() != LList.Empty) goto _L2; else goto _L4
_L4:
        obj = translator.rewrite_car(((Pair) (obj2)), false);
        obj4 = translator.rewrite_car(((Pair) (obj4)), false);
        Namespace namespace = translator.namespaceResolvePrefix(((Expression) (obj)));
        syntaxform = translator.namespaceResolve(namespace, ((Expression) (obj4)));
        if (syntaxform != null)
        {
            obj = obj1;
        } else
        if (namespace != null && i == 1)
        {
            syntaxform = new ApplyExp(quoteType.getDeclaredMethod("makeSymbol", 2), new Expression[] {
                QuoteExp.getInstance(namespace), obj4
            });
            obj = obj1;
        } else
        if ((obj instanceof ReferenceExp) && (obj4 instanceof QuoteExp))
        {
            syntaxform = translator.getGlobalEnvironment().getSymbol((new StringBuilder()).append(((ReferenceExp)obj).getName()).append(':').append(((QuoteExp)obj4).getValue().toString()).toString());
            obj = obj1;
        } else
        {
            obj = CompileNamedPart.combineName(((Expression) (obj)), ((Expression) (obj4)));
            if (obj != null)
            {
                syntaxform = translator.getGlobalEnvironment().getSymbol(((String) (obj)));
                obj = obj1;
            } else
            {
                obj = translator.pushPositionOf(obj1);
                translator.error('e', (new StringBuilder()).append("'").append(((Pair) (obj2)).getCar()).append("' is not a valid prefix").toString());
                translator.popPositionOf(obj);
                obj = obj1;
            }
        }
_L11:
        if (pair == obj)
        {
            return syntaxform;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i >= 0) goto _L6; else goto _L5
_L5:
        if (i != 1 || !(((Pair) (obj1)).getCar() instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_880;
        }
        obj4 = ((Pair) (obj1)).getCar();
        obj2 = syntaxform;
        for (; obj4 instanceof SyntaxForm; obj4 = ((SyntaxForm) (obj2)).getDatum())
        {
            obj2 = (SyntaxForm)obj4;
        }

        break MISSING_BLOCK_LABEL_604;
_L6:
        if (!translator.matches(((Pair) (obj1)).getCar(), syntaxform, "quasiquote"))
        {
            break; /* Loop/switch isn't completed */
        }
        i++;
        if (true) goto _L5; else goto _L7
_L7:
        int j;
label0:
        {
            if (!translator.matches(((Pair) (obj1)).getCar(), syntaxform, "unquote"))
            {
                continue; /* Loop/switch isn't completed */
            }
            j = i - 1;
            if (((Pair) (obj1)).getCdr() instanceof Pair)
            {
                obj2 = (Pair)((Pair) (obj1)).getCdr();
                if (((Pair) (obj2)).getCdr() == LList.Empty)
                {
                    break label0;
                }
            }
            return translator.syntaxError((new StringBuilder()).append("invalid used of ").append(((Pair) (obj1)).getCar()).append(" in quasiquote template").toString());
        }
        i = j;
        if (j != 0) goto _L5; else goto _L8
_L8:
        syntaxform = translator.rewrite_car(((Pair) (obj2)), syntaxform);
        obj = obj1;
        continue; /* Loop/switch isn't completed */
        if (!translator.matches(((Pair) (obj1)).getCar(), syntaxform, "unquote-splicing")) goto _L5; else goto _L9
_L9:
        return translator.syntaxError((new StringBuilder()).append("invalid used of ").append(((Pair) (obj1)).getCar()).append(" in quasiquote template").toString());
        byte byte1 = -1;
        byte byte0 = byte1;
        Object obj5;
        if (obj4 instanceof Pair)
        {
            obj5 = ((Pair)obj4).getCar();
            if (translator.matches(obj5, ((SyntaxForm) (obj2)), "unquote"))
            {
                byte0 = 0;
            } else
            {
                byte0 = byte1;
                if (translator.matches(obj5, ((SyntaxForm) (obj2)), "unquote-splicing"))
                {
                    byte0 = 1;
                }
            }
        }
        if (byte0 >= 0)
        {
            obj5 = ((Pair)obj4).getCdr();
            Vector vector = new Vector();
            obj4 = obj2;
            obj2 = obj5;
            do
            {
                obj5 = obj2;
                if (obj2 instanceof SyntaxForm)
                {
                    obj4 = (SyntaxForm)obj2;
                    obj5 = ((SyntaxForm) (obj4)).getDatum();
                }
                if (obj5 == LList.Empty)
                {
                    i = vector.size() + 1;
                    obj = expand(((Pair) (obj1)).getCdr(), 1, syntaxform, obj, translator);
                    syntaxform = ((SyntaxForm) (obj));
                    if (i > 1)
                    {
                        obj2 = new Expression[i];
                        vector.copyInto(((Object []) (obj2)));
                        obj2[i - 1] = coerceExpression(obj, translator);
                        if (byte0 == 0)
                        {
                            syntaxform = consXMethod;
                        } else
                        {
                            syntaxform = appendMethod;
                        }
                        syntaxform = new ApplyExp(syntaxform, ((Expression []) (obj2)));
                    }
                    obj = obj1;
                    continue; /* Loop/switch isn't completed */
                }
                if (obj5 instanceof Pair)
                {
                    vector.addElement(translator.rewrite_car((Pair)obj5, ((SyntaxForm) (obj4))));
                    obj2 = ((Pair)obj5).getCdr();
                } else
                {
                    return translator.syntaxError("improper list argument to unquote");
                }
            } while (true);
        }
        Object obj3 = expand(((Pair) (obj1)).getCar(), i, syntaxform, obj, translator);
        if (obj3 == ((Pair) (obj1)).getCar())
        {
            obj1 = ((Pair) (obj1)).getCdr();
            if (obj1 instanceof Pair)
            {
                obj1 = (Pair)obj1;
            } else
            {
                syntaxform = ((SyntaxForm) (expand(obj1, i, syntaxform, obj, translator)));
                obj = obj1;
                continue; /* Loop/switch isn't completed */
            }
            continue; /* Loop/switch isn't completed */
        }
        syntaxform = ((SyntaxForm) (expand(((Pair) (obj1)).getCdr(), i, syntaxform, obj, translator)));
        if ((obj3 instanceof Expression) || (syntaxform instanceof Expression))
        {
            obj = coerceExpression(obj3, translator);
            syntaxform = coerceExpression(syntaxform, translator);
            syntaxform = new ApplyExp(makePairMethod, new Expression[] {
                obj, syntaxform
            });
            obj = obj1;
        } else
        {
            syntaxform = Translator.makePair(((Pair) (obj1)), obj3, syntaxform);
            obj = obj1;
        }
        if (true) goto _L11; else goto _L10
_L10:
        Pair pair1 = pair;
        Pair apair1[] = new Pair[20];
        i = 0;
        int k;
        do
        {
            Pair apair[] = apair1;
            if (i >= apair1.length)
            {
                apair = new Pair[i * 2];
                System.arraycopy(apair1, 0, apair, 0, i);
            }
            k = i + 1;
            apair[i] = pair1;
            if (pair1.getCdr() == obj)
            {
                if (syntaxform instanceof Expression)
                {
                    obj = LList.Empty;
                } else
                {
                    obj = syntaxform;
                }
                do
                {
                    k--;
                    if (k < 0)
                    {
                        break;
                    }
                    pair1 = apair[k];
                    obj = Translator.makePair(pair1, pair1.getCar(), obj);
                } while (true);
                break;
            }
            pair1 = (Pair)pair1.getCdr();
            i = k;
            apair1 = apair;
        } while (true);
        if (syntaxform instanceof Expression)
        {
            Expression aexpression[] = new Expression[2];
            aexpression[1] = (Expression)syntaxform;
            if (k == 1)
            {
                aexpression[0] = leaf(pair.getCar(), translator);
                return new ApplyExp(makePairMethod, aexpression);
            } else
            {
                aexpression[0] = leaf(obj, translator);
                return new ApplyExp(appendMethod, aexpression);
            }
        }
        return obj;
        if (true) goto _L13; else goto _L12
_L12:
    }

    protected Expression leaf(Object obj, Translator translator)
    {
        return new QuoteExp(obj);
    }

    public Expression rewrite(Object obj, Translator translator)
    {
label0:
        {
            if (obj instanceof Pair)
            {
                obj = (Pair)obj;
                if (((Pair) (obj)).getCdr() == LList.Empty)
                {
                    break label0;
                }
            }
            return translator.syntaxError("wrong number of arguments to quote");
        }
        obj = ((Pair) (obj)).getCar();
        int i;
        if (isQuasi)
        {
            i = 1;
        } else
        {
            i = -1;
        }
        return coerceExpression(expand(obj, i, translator), translator);
    }

    static 
    {
        quoteType = ClassType.make("kawa.lang.Quote");
        consXMethod = quoteType.getDeclaredMethod("consX$V", 1);
        appendMethod = quoteType.getDeclaredMethod("append$V", 1);
        makePairMethod = Compilation.typePair.getDeclaredMethod("make", 2);
    }
}
