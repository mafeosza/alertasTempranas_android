// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.bytecode.Type;
import gnu.expr.BeginExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.ObjectExp;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.SetExp;
import gnu.expr.ThisExp;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import java.util.Vector;
import kawa.lang.Lambda;
import kawa.lang.Syntax;
import kawa.lang.SyntaxForm;
import kawa.lang.Translator;

// Referenced classes of package kawa.standard:
//            SchemeCompilation

public class object extends Syntax
{

    public static final Keyword accessKeyword = Keyword.make("access");
    public static final Keyword allocationKeyword = Keyword.make("allocation");
    public static final Keyword classNameKeyword = Keyword.make("class-name");
    static final Symbol coloncolon;
    static final Keyword initKeyword = Keyword.make("init");
    static final Keyword init_formKeyword = Keyword.make("init-form");
    static final Keyword init_keywordKeyword = Keyword.make("init-keyword");
    static final Keyword init_valueKeyword = Keyword.make("init-value");
    static final Keyword initformKeyword = Keyword.make("initform");
    public static final Keyword interfaceKeyword = Keyword.make("interface");
    public static final object objectSyntax;
    public static final Keyword throwsKeyword = Keyword.make("throws");
    static final Keyword typeKeyword = Keyword.make("type");
    Lambda lambda;

    public object(Lambda lambda1)
    {
        lambda = lambda1;
    }

    static long addAccessFlags(Object obj, long l, long l1, String s, Translator translator)
    {
        long l2 = matchAccess(obj, translator);
        if (l2 != 0L) goto _L2; else goto _L1
_L1:
        translator.error('e', (new StringBuilder()).append("unknown access specifier ").append(obj).toString());
_L4:
        return l | l2;
_L2:
        if (((-1L ^ l1) & l2) != 0L)
        {
            translator.error('e', (new StringBuilder()).append("invalid ").append(s).append(" access specifier ").append(obj).toString());
        } else
        if ((l & l2) != 0L)
        {
            translator.error('w', (new StringBuilder()).append("duplicate ").append(s).append(" access specifiers ").append(obj).toString());
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static long matchAccess(Object obj, Translator translator)
    {
        for (; obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
        Object obj1 = obj;
        if (obj instanceof Pair)
        {
            obj1 = (Pair)obj;
            obj = translator.matchQuoted((Pair)obj);
            obj1 = obj;
            if (obj instanceof Pair)
            {
                return matchAccess2((Pair)obj, translator);
            }
        }
        return matchAccess1(obj1, translator);
    }

    private static long matchAccess1(Object obj, Translator translator)
    {
        if (!(obj instanceof Keyword)) goto _L2; else goto _L1
_L1:
        translator = ((Keyword)obj).getName();
_L4:
        if ("private".equals(translator))
        {
            return 0x1000000L;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (obj instanceof FString)
        {
            translator = ((FString)obj).toString();
        } else
        {
            translator = ((Translator) (obj));
            if (obj instanceof SimpleSymbol)
            {
                translator = obj.toString();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if ("protected".equals(translator))
        {
            return 0x2000000L;
        }
        if ("public".equals(translator))
        {
            return 0x4000000L;
        }
        if ("package".equals(translator))
        {
            return 0x8000000L;
        }
        if ("volatile".equals(translator))
        {
            return 0x80000000L;
        }
        if ("transient".equals(translator))
        {
            return 0x100000000L;
        }
        if ("enum".equals(translator))
        {
            return 0x200000000L;
        }
        return !"final".equals(translator) ? 0L : 0x400000000L;
    }

    private static long matchAccess2(Pair pair, Translator translator)
    {
        long l = matchAccess1(pair.getCar(), translator);
        pair = ((Pair) (pair.getCdr()));
        if (pair == LList.Empty || l == 0L)
        {
            return l;
        }
        if (pair instanceof Pair)
        {
            long l1 = matchAccess2((Pair)pair, translator);
            if (l1 != 0L)
            {
                return l | l1;
            }
        }
        return 0L;
    }

    static boolean matches(Object obj, String s, Translator translator)
    {
        boolean flag1 = false;
        if (!(obj instanceof Keyword)) goto _L2; else goto _L1
_L1:
        obj = ((Keyword)obj).getName();
_L7:
        boolean flag;
label0:
        {
            if (s != null)
            {
                flag = flag1;
                if (!s.equals(obj))
                {
                    break label0;
                }
            }
            flag = true;
        }
_L4:
        return flag;
_L2:
        if (obj instanceof FString)
        {
            obj = ((FString)obj).toString();
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!(obj instanceof Pair)) goto _L4; else goto _L3
_L3:
        obj = translator.matchQuoted((Pair)obj);
        flag = flag1;
        if (!(obj instanceof SimpleSymbol)) goto _L4; else goto _L5
_L5:
        obj = obj.toString();
        if (true) goto _L7; else goto _L6
_L6:
    }

    private static void rewriteInit(Object obj, ClassExp classexp, Pair pair, Translator translator, SyntaxForm syntaxform)
    {
        LambdaExp lambdaexp;
        LambdaExp lambdaexp1;
        boolean flag;
        if (obj instanceof Declaration)
        {
            flag = ((Declaration)obj).getFlag(2048L);
        } else
        if (obj == Boolean.TRUE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            lambdaexp = classexp.clinitMethod;
        } else
        {
            lambdaexp = classexp.initMethod;
        }
        lambdaexp1 = lambdaexp;
        if (lambdaexp == null)
        {
            lambdaexp1 = new LambdaExp(new BeginExp());
            lambdaexp1.setClassMethod(true);
            lambdaexp1.setReturnType(Type.voidType);
            if (flag)
            {
                lambdaexp1.setName("$clinit$");
                classexp.clinitMethod = lambdaexp1;
            } else
            {
                lambdaexp1.setName("$finit$");
                classexp.initMethod = lambdaexp1;
                lambdaexp1.add(null, new Declaration(ThisExp.THIS_NAME));
            }
            lambdaexp1.nextSibling = classexp.firstChild;
            classexp.firstChild = lambdaexp1;
        }
        translator.push(lambdaexp1);
        classexp = translator.curMethodLambda;
        translator.curMethodLambda = lambdaexp1;
        pair = translator.rewrite_car(pair, syntaxform);
        if (obj instanceof Declaration)
        {
            syntaxform = (Declaration)obj;
            obj = new SetExp(syntaxform, pair);
            ((SetExp) (obj)).setLocation(syntaxform);
            syntaxform.noteValue(null);
        } else
        {
            obj = Compilation.makeCoercion(pair, new QuoteExp(Type.voidType));
        }
        ((BeginExp)lambdaexp1.body).add(((Expression) (obj)));
        translator.curMethodLambda = classexp;
        translator.pop(lambdaexp1);
    }

    public void rewriteClassDef(Object aobj[], Translator translator)
    {
        Object obj;
        Expression aexpression[];
        Object obj5;
        Object obj8;
        ClassExp classexp;
        Vector vector;
        classexp = (ClassExp)aobj[0];
        obj = aobj[1];
        vector = (Vector)aobj[2];
        obj8 = (LambdaExp)aobj[3];
        Object obj1 = aobj[4];
        obj5 = aobj[5];
        classexp.firstChild = ((LambdaExp) (obj8));
        int l = Translator.listLength(obj1);
        int i = l;
        if (l < 0)
        {
            translator.error('e', "object superclass specification not a list");
            i = 0;
        }
        aexpression = new Expression[i];
        l = 0;
        aobj = ((Object []) (obj1));
        for (; l < i; l++)
        {
            for (; aobj instanceof SyntaxForm; aobj = ((Object []) (((SyntaxForm)aobj).getDatum()))) { }
            aobj = (Pair)aobj;
            aexpression[l] = translator.rewrite_car(((Pair) (aobj)), false);
            if (aexpression[l] instanceof ReferenceExp)
            {
                Object obj2 = Declaration.followAliases(((ReferenceExp)aexpression[l]).getBinding());
                if (obj2 != null)
                {
                    obj2 = ((Declaration) (obj2)).getValue();
                    if (obj2 instanceof ClassExp)
                    {
                        ((ClassExp)obj2).setFlag(0x20000);
                    }
                }
            }
            aobj = ((Object []) (((Pair) (aobj)).getCdr()));
        }

        if (obj5 == null) goto _L2; else goto _L1
_L1:
        aobj = ((Object []) (translator.rewrite_car((Pair)obj5, false).valueIfConstant()));
        if (!(aobj instanceof CharSequence)) goto _L4; else goto _L3
_L3:
        aobj = ((Object) (aobj)).toString();
        if (((String) (aobj)).length() <= 0) goto _L4; else goto _L5
_L5:
        classexp.classNameSpecifier = ((String) (aobj));
_L2:
        classexp.supers = aexpression;
        classexp.setTypes(translator);
        int i1 = vector.size();
        for (int j = 0; j < i1; j += 2)
        {
            aobj = ((Object []) (vector.elementAt(j + 1)));
            if (aobj != null)
            {
                rewriteInit(vector.elementAt(j), classexp, (Pair)aobj, translator, null);
            }
        }

        break; /* Loop/switch isn't completed */
_L4:
        aobj = ((Object []) (translator.pushPositionOf(obj5)));
        translator.error('e', "class-name specifier must be a non-empty string literal");
        translator.popPositionOf(((Object) (aobj)));
        if (true) goto _L2; else goto _L6
_L6:
        int k;
        translator.push(classexp);
        k = 0;
        obj5 = null;
        aobj = ((Object []) (obj));
_L9:
        if (aobj == LList.Empty) goto _L8; else goto _L7
_L7:
        Object obj3;
        Object obj12;
        for (; aobj instanceof SyntaxForm; aobj = ((Object []) (((SyntaxForm) (obj5)).getDatum())))
        {
            obj5 = (SyntaxForm)aobj;
        }

        obj3 = (Pair)aobj;
        obj12 = translator.pushPositionOf(obj3);
        obj = ((Pair) (obj3)).getCar();
        aobj = ((Object []) (obj5));
        for (; obj instanceof SyntaxForm; obj = ((SyntaxForm) (aobj)).getDatum())
        {
            aobj = (SyntaxForm)obj;
        }

        Object obj10;
        obj10 = ((Pair) (obj3)).getCdr();
        if (!(obj instanceof Keyword) || !(obj10 instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_470;
        }
        aobj = ((Object []) (((Pair)obj10).getCdr()));
        translator.popPositionOf(obj12);
          goto _L9
        Object obj4;
        obj4 = (Pair)obj;
        obj3 = ((Pair) (obj4)).getCar();
        obj = ((Object) (aobj));
        for (; obj3 instanceof SyntaxForm; obj3 = ((SyntaxForm) (obj)).getDatum())
        {
            obj = (SyntaxForm)obj3;
        }

        if (!(obj3 instanceof String) && !(obj3 instanceof Symbol) && !(obj3 instanceof Keyword)) goto _L11; else goto _L10
_L10:
        Object obj9;
        int j1;
        obj9 = null;
        j1 = 0;
        if (!(obj3 instanceof Keyword)) goto _L13; else goto _L12
_L12:
        obj = obj4;
          goto _L14
_L22:
        if (obj == LList.Empty) goto _L16; else goto _L15
_L15:
        for (; obj instanceof SyntaxForm; obj = ((SyntaxForm) (aobj)).getDatum())
        {
            aobj = (SyntaxForm)obj;
        }

          goto _L17
_L13:
        obj = ((Pair) (obj4)).getCdr();
          goto _L14
_L17:
        Object obj6;
        obj = (Pair)obj;
        for (obj6 = ((Pair) (obj)).getCar(); obj6 instanceof SyntaxForm; obj6 = ((SyntaxForm)obj6).getDatum()) { }
        Object obj7;
        Object obj13;
        obj13 = translator.pushPositionOf(obj);
        obj7 = ((Pair) (obj)).getCdr();
        if (obj6 != coloncolon && !(obj6 instanceof Keyword) || !(obj7 instanceof Pair)) goto _L19; else goto _L18
_L18:
        int k1 = j1 + 1;
        Object obj11;
        Pair pair;
        pair = (Pair)obj7;
        obj7 = pair.getCar();
        obj11 = pair.getCdr();
        if (obj6 != coloncolon && obj6 != typeKeyword) goto _L21; else goto _L20
_L25:
        translator.popPositionOf(obj13);
        obj9 = obj7;
          goto _L22
        aobj;
_L36:
        translator.popPositionOf(obj12);
        throw aobj;
_L21:
        if (obj6 == initKeyword || obj6 == initformKeyword || obj6 == init_formKeyword) goto _L24; else goto _L23
_L23:
        obj = obj11;
        j1 = k1;
        obj7 = obj9;
        if (obj6 != init_valueKeyword) goto _L25; else goto _L24
_L19:
label0:
        {
            if (obj7 != LList.Empty || obj3 != null)
            {
                break label0;
            }
            obj3 = obj;
            obj4 = ((Object) (aobj));
            obj = obj7;
            obj7 = obj9;
        }
          goto _L25
        if (!(obj7 instanceof Pair) || j1 != 0 || obj3 != null || obj9 != null) goto _L16; else goto _L26
_L26:
        obj = (Pair)obj7;
        if (((Pair) (obj)).getCdr() != LList.Empty) goto _L16; else goto _L27
_L27:
        obj3 = obj;
        obj4 = ((Object) (aobj));
        obj = ((Pair) (obj)).getCdr();
        obj7 = obj6;
          goto _L25
_L16:
        aobj = ((Object []) (obj8));
        j1 = k;
        if (obj3 == null) goto _L29; else goto _L28
_L28:
        k1 = k + 1;
        obj = vector.elementAt(k);
        if (!(obj instanceof Declaration)) goto _L31; else goto _L30
_L30:
        ((Declaration)obj).getFlag(2048L);
_L33:
        k = k1 + 1;
        aobj = ((Object []) (obj8));
        j1 = k;
        if (vector.elementAt(k1) != null) goto _L29; else goto _L32
_L32:
        rewriteInit(obj, classexp, ((Pair) (obj3)), translator, ((SyntaxForm) (obj4)));
        j1 = k;
        aobj = ((Object []) (obj8));
_L29:
        translator.popPositionOf(obj12);
        obj8 = ((Object) (aobj));
        k = j1;
        aobj = ((Object []) (obj10));
          goto _L9
_L31:
        aobj = Boolean.TRUE;
        if (obj != aobj);
          goto _L33
_L11:
        if (!(obj3 instanceof Pair)) goto _L35; else goto _L34
_L34:
        obj6 = translator.currentScope();
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_1010;
        }
        translator.setCurrentScope(((SyntaxForm) (aobj)).getScope());
        if ("*init*".equals(((LambdaExp) (obj8)).getName()))
        {
            ((LambdaExp) (obj8)).setReturnType(Type.voidType);
        }
        Translator.setLine(((Expression) (obj8)), obj4);
        obj7 = translator.curMethodLambda;
        translator.curMethodLambda = ((LambdaExp) (obj8));
        obj9 = lambda;
        obj3 = ((Pair)obj3).getCdr();
        obj4 = ((Pair) (obj4)).getCdr();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_1257;
        }
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_1097;
        }
        if (((SyntaxForm) (obj)).getScope() == ((SyntaxForm) (aobj)).getScope())
        {
            break MISSING_BLOCK_LABEL_1257;
        }
        obj = ((SyntaxForm) (obj)).getScope();
_L37:
        ((Lambda) (obj9)).rewrite(((LambdaExp) (obj8)), obj3, obj4, translator, ((kawa.lang.TemplateScope) (obj)));
        translator.curMethodLambda = ((LambdaExp) (obj7));
        if (aobj == null)
        {
            break MISSING_BLOCK_LABEL_1133;
        }
        translator.setCurrentScope(((gnu.expr.ScopeExp) (obj6)));
        aobj = ((LambdaExp) (obj8)).nextSibling;
        j1 = k;
          goto _L29
_L35:
        translator.syntaxError("invalid field/method definition");
        aobj = ((Object []) (obj8));
        j1 = k;
          goto _L29
_L8:
        if (classexp.initMethod != null)
        {
            classexp.initMethod.outer = classexp;
        }
        if (classexp.clinitMethod != null)
        {
            classexp.clinitMethod.outer = classexp;
        }
        translator.pop(classexp);
        classexp.declareParts(translator);
        return;
        aobj;
          goto _L36
_L14:
        obj3 = null;
        obj4 = null;
          goto _L22
_L20:
        obj = obj11;
        j1 = k1;
          goto _L25
_L24:
        obj3 = pair;
        obj4 = ((Object) (aobj));
        obj = obj11;
        j1 = k1;
        obj7 = obj9;
          goto _L25
        obj = null;
          goto _L37
    }

    public Expression rewriteForm(Pair pair, Translator translator)
    {
        if (!(pair.getCdr() instanceof Pair))
        {
            pair = translator.syntaxError("missing superclass specification in object");
        } else
        {
            Pair pair1 = (Pair)pair.getCdr();
            ObjectExp objectexp = new ObjectExp();
            pair = pair1;
            if (pair1.getCar() instanceof FString)
            {
                if (!(pair1.getCdr() instanceof Pair))
                {
                    return translator.syntaxError("missing superclass specification after object class name");
                }
                pair = (Pair)pair1.getCdr();
            }
            Object aobj[] = scanClassDef(pair, objectexp, translator);
            pair = objectexp;
            if (aobj != null)
            {
                rewriteClassDef(aobj, translator);
                return objectexp;
            }
        }
        return pair;
    }

    public Object[] scanClassDef(Pair pair, ClassExp classexp, Translator translator)
    {
        Pair pair3;
        Pair pair5;
        Pair pair6;
        Object obj6;
        Object obj8;
        Vector vector;
        long l1;
        translator.mustCompileHere();
        obj8 = pair.getCar();
        obj6 = pair.getCdr();
        pair5 = null;
        pair3 = null;
        pair6 = null;
        l1 = 0L;
        vector = new Vector(20);
        pair = ((Pair) (obj6));
_L11:
        if (pair == LList.Empty) goto _L2; else goto _L1
_L1:
        Pair pair4;
        Object obj3;
        Object obj9;
        for (; pair instanceof SyntaxForm; pair = ((Pair) (((SyntaxForm)pair).getDatum()))) { }
        if (!(pair instanceof Pair))
        {
            translator.error('e', "object member not a list");
            return null;
        }
        pair4 = (Pair)pair;
        Object obj;
        for (obj = pair4.getCar(); obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
        pair = ((Pair) (pair4.getCdr()));
        obj9 = translator.pushPositionOf(pair4);
        pair4 = pair;
        if (obj instanceof Keyword)
        {
            for (; pair instanceof SyntaxForm; pair = ((Pair) (((SyntaxForm)pair).getDatum()))) { }
            pair4 = pair;
            if (pair instanceof Pair)
            {
                if (obj == interfaceKeyword)
                {
                    if (((Pair)pair).getCar() == Boolean.FALSE)
                    {
                        classexp.setFlag(0x10000);
                    } else
                    {
                        classexp.setFlag(32768);
                    }
                    pair = ((Pair) (((Pair)pair).getCdr()));
                    translator.popPositionOf(obj9);
                    continue; /* Loop/switch isn't completed */
                }
                if (obj == classNameKeyword)
                {
                    if (pair5 != null)
                    {
                        translator.error('e', "duplicate class-name specifiers");
                    }
                    pair5 = pair;
                    pair = ((Pair) (((Pair)pair).getCdr()));
                    translator.popPositionOf(obj9);
                    continue; /* Loop/switch isn't completed */
                }
                pair4 = pair;
                if (obj == accessKeyword)
                {
                    obj = translator.pushPositionOf(pair);
                    l1 = addAccessFlags(((Pair)pair).getCar(), l1, 0x603000000L, "class", translator);
                    if (classexp.nameDecl == null)
                    {
                        translator.error('e', "access specifier for anonymous class");
                    }
                    translator.popPositionOf(obj);
                    pair = ((Pair) (((Pair)pair).getCdr()));
                    translator.popPositionOf(obj9);
                    continue; /* Loop/switch isn't completed */
                }
            }
        }
        if (!(obj instanceof Pair))
        {
            translator.error('e', "object member not a list");
            return null;
        }
        pair = (Pair)obj;
        for (obj3 = pair.getCar(); obj3 instanceof SyntaxForm; obj3 = ((SyntaxForm)obj3).getDatum()) { }
        if (!(obj3 instanceof String) && !(obj3 instanceof Symbol) && !(obj3 instanceof Keyword)) goto _L4; else goto _L3
_L3:
        Pair pair1;
        Declaration declaration;
        Object obj4;
        Pair pair7;
        boolean flag2;
        int j;
        int k;
        long l2;
        obj4 = null;
        j = 0;
        l2 = 0L;
        if (obj3 instanceof Keyword)
        {
            declaration = null;
        } else
        {
            declaration = classexp.addDeclaration(obj3);
            declaration.setSimple(false);
            declaration.setFlag(0x100000L);
            Translator.setLine(declaration, pair);
            pair = ((Pair) (pair.getCdr()));
        }
        k = 0;
        flag2 = false;
        pair7 = null;
_L6:
        Object obj2;
        boolean flag;
        int i;
        long l3;
        pair1 = pair;
        if (pair == LList.Empty)
        {
            break MISSING_BLOCK_LABEL_1363;
        }
        for (; pair instanceof SyntaxForm; pair = ((Pair) (((SyntaxForm)pair).getDatum()))) { }
        pair = (Pair)pair;
        Object obj5;
        for (obj5 = pair.getCar(); obj5 instanceof SyntaxForm; obj5 = ((SyntaxForm)obj5).getDatum()) { }
        Object obj10 = translator.pushPositionOf(pair);
        obj2 = pair.getCdr();
        if (obj5 != coloncolon && !(obj5 instanceof Keyword) || !(obj2 instanceof Pair))
        {
            break; /* Loop/switch isn't completed */
        }
        int l = k + 1;
        Pair pair9 = (Pair)obj2;
        Object obj11 = pair9.getCar();
        Object obj7 = pair9.getCdr();
        if (obj5 == coloncolon || obj5 == typeKeyword)
        {
            obj2 = pair9;
            flag = flag2;
            k = l;
            pair1 = pair7;
            pair = ((Pair) (obj7));
            i = j;
            l3 = l2;
        } else
        if (obj5 == allocationKeyword)
        {
            if (j != 0)
            {
                translator.error('e', "duplicate allocation: specification");
            }
            if (matches(obj11, "class", translator) || matches(obj11, "static", translator))
            {
                i = 2048;
                l3 = l2;
                pair = ((Pair) (obj7));
                pair1 = pair7;
                k = l;
                flag = flag2;
                obj2 = obj4;
            } else
            if (matches(obj11, "instance", translator))
            {
                i = 4096;
                l3 = l2;
                pair = ((Pair) (obj7));
                pair1 = pair7;
                k = l;
                flag = flag2;
                obj2 = obj4;
            } else
            {
                translator.error('e', (new StringBuilder()).append("unknown allocation kind '").append(obj11).append("'").toString());
                l3 = l2;
                i = j;
                pair = ((Pair) (obj7));
                pair1 = pair7;
                k = l;
                flag = flag2;
                obj2 = obj4;
            }
        } else
        if (obj5 == initKeyword || obj5 == initformKeyword || obj5 == init_formKeyword || obj5 == init_valueKeyword)
        {
            if (flag2)
            {
                translator.error('e', "duplicate initialization");
            }
            flag2 = true;
            l3 = l2;
            i = j;
            pair = ((Pair) (obj7));
            pair1 = pair7;
            k = l;
            flag = flag2;
            obj2 = obj4;
            if (obj5 != initKeyword)
            {
                pair1 = pair9;
                l3 = l2;
                i = j;
                pair = ((Pair) (obj7));
                k = l;
                flag = flag2;
                obj2 = obj4;
            }
        } else
        if (obj5 == init_keywordKeyword)
        {
            if (!(obj11 instanceof Keyword))
            {
                translator.error('e', "invalid 'init-keyword' - not a keyword");
                l3 = l2;
                i = j;
                pair = ((Pair) (obj7));
                pair1 = pair7;
                k = l;
                flag = flag2;
                obj2 = obj4;
            } else
            {
                l3 = l2;
                i = j;
                pair = ((Pair) (obj7));
                pair1 = pair7;
                k = l;
                flag = flag2;
                obj2 = obj4;
                if (((Keyword)obj11).getName() != obj3.toString())
                {
                    translator.error('w', "init-keyword option ignored");
                    l3 = l2;
                    i = j;
                    pair = ((Pair) (obj7));
                    pair1 = pair7;
                    k = l;
                    flag = flag2;
                    obj2 = obj4;
                }
            }
        } else
        if (obj5 == accessKeyword)
        {
            pair = ((Pair) (translator.pushPositionOf(pair9)));
            l3 = addAccessFlags(obj11, l2, 0x78f000000L, "field", translator);
            translator.popPositionOf(pair);
            i = j;
            pair = ((Pair) (obj7));
            pair1 = pair7;
            k = l;
            flag = flag2;
            obj2 = obj4;
        } else
        {
            translator.error('w', (new StringBuilder()).append("unknown slot keyword '").append(obj5).append("'").toString());
            l3 = l2;
            i = j;
            pair = ((Pair) (obj7));
            pair1 = pair7;
            k = l;
            flag = flag2;
            obj2 = obj4;
        }
_L7:
        translator.popPositionOf(obj10);
        l2 = l3;
        j = i;
        pair7 = pair1;
        flag2 = flag;
        obj4 = obj2;
        if (true) goto _L6; else goto _L5
_L5:
        if (obj2 == LList.Empty && !flag2)
        {
            pair1 = pair;
            flag = true;
            l3 = l2;
            i = j;
            pair = ((Pair) (obj2));
            obj2 = obj4;
        } else
        {
label0:
            {
                if (!(obj2 instanceof Pair) || k != 0 || flag2 || obj4 != null)
                {
                    break label0;
                }
                Pair pair8 = (Pair)obj2;
                if (pair8.getCdr() != LList.Empty)
                {
                    break label0;
                }
                obj2 = pair;
                pair1 = pair8;
                pair = ((Pair) (pair8.getCdr()));
                flag = true;
                l3 = l2;
                i = j;
            }
        }
          goto _L7
        if (true) goto _L6; else goto _L8
_L8:
        pair1 = null;
        if (pair1 != LList.Empty)
        {
            classexp = (new StringBuilder()).append("invalid argument list for slot '").append(obj3).append('\'').append(" args:");
            if (pair1 == null)
            {
                pair = "null";
            } else
            {
                pair = pair1.getClass().getName();
            }
            translator.error('e', classexp.append(pair).toString());
            return null;
        }
        if (flag2)
        {
            boolean flag1;
            if (j == 2048)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (declaration != null)
            {
                pair = declaration;
            } else
            if (flag1)
            {
                pair = Boolean.TRUE;
            } else
            {
                pair = Boolean.FALSE;
            }
            vector.addElement(pair);
            vector.addElement(pair7);
        }
        if (declaration == null)
        {
            if (!flag2)
            {
                translator.error('e', "missing field name");
                return null;
            }
        } else
        {
            if (obj4 != null)
            {
                declaration.setType(translator.exp2Type(((Pair) (obj4))));
            }
            if (j != 0)
            {
                declaration.setFlag(j);
            }
            if (l2 != 0L)
            {
                declaration.setFlag(l2);
            }
            declaration.setCanRead(true);
            declaration.setCanWrite(true);
        }
_L9:
        translator.popPositionOf(obj9);
        pair = pair4;
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj3 instanceof Pair)
        {
            Pair pair2 = (Pair)obj3;
            Object obj1 = pair2.getCar();
            if (!(obj1 instanceof String) && !(obj1 instanceof Symbol))
            {
                translator.error('e', "missing method name");
                return null;
            }
            pair = new LambdaExp();
            Translator.setLine(classexp.addMethod(pair, obj1), pair2);
            if (pair6 == null)
            {
                pair3 = pair;
            } else
            {
                pair6.nextSibling = pair;
            }
            pair6 = pair;
        } else
        {
            translator.error('e', "invalid field/method definition");
        }
        if (true) goto _L9; else goto _L2
_L2:
        if (l1 != 0L)
        {
            classexp.nameDecl.setFlag(l1);
        }
        return (new Object[] {
            classexp, obj6, vector, pair3, obj8, pair5
        });
        if (true) goto _L11; else goto _L10
_L10:
    }

    static 
    {
        objectSyntax = new object(SchemeCompilation.lambda);
        objectSyntax.setName("object");
        coloncolon = Namespace.EmptyNamespace.getSymbol("::");
    }
}
