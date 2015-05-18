// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.Type;
import gnu.bytecode.ZipLoader;
import gnu.expr.ApplyExp;
import gnu.expr.ClassExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ErrorExp;
import gnu.expr.Expression;
import gnu.expr.InlineCalls;
import gnu.expr.Keyword;
import gnu.expr.LambdaExp;
import gnu.expr.LangExp;
import gnu.expr.Language;
import gnu.expr.LetExp;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.NameLookup;
import gnu.expr.QuoteExp;
import gnu.expr.ReferenceExp;
import gnu.expr.ScopeExp;
import gnu.expr.Special;
import gnu.expr.ThisExp;
import gnu.kawa.functions.AppendValues;
import gnu.kawa.functions.CompileNamedPart;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.reflect.ClassMethods;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.xml.MakeAttribute;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Namespace;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.SourceLocator;
import gnu.text.SourceMessages;
import gnu.xml.NamespaceBinding;
import java.util.Stack;
import java.util.Vector;
import kawa.standard.begin;
import kawa.standard.object;
import kawa.standard.require;

// Referenced classes of package kawa.lang:
//            SyntaxForm, SyntaxForms, Syntax, TemplateScope, 
//            PatternScope, Quote, AutoloadProcedure, Macro

public class Translator extends Compilation
{

    private static Expression errorExp = new ErrorExp("unknown syntax error");
    public static final Declaration getNamedPartDecl;
    public LambdaExp curMethodLambda;
    public Macro currentMacroDefinition;
    Syntax currentSyntax;
    private Environment env;
    public int firstForm;
    public Stack formStack;
    Declaration macroContext;
    public Declaration matchArray;
    Vector notedAccess;
    public PatternScope patternScope;
    public Object pendingForm;
    PairWithPosition positionPair;
    Stack renamedAliasStack;
    public Declaration templateScopeDecl;
    public NamespaceBinding xmlElementNamespaces;

    public Translator(Language language, SourceMessages sourcemessages, NameLookup namelookup)
    {
        super(language, sourcemessages, namelookup);
        formStack = new Stack();
        xmlElementNamespaces = NamespaceBinding.predefinedXML;
        env = Environment.getCurrent();
    }

    static ReferenceExp getOriginalRef(Declaration declaration)
    {
        if (declaration != null && declaration.isAlias() && !declaration.isIndirectBinding())
        {
            declaration = declaration.getValue();
            if (declaration instanceof ReferenceExp)
            {
                return (ReferenceExp)declaration;
            }
        }
        return null;
    }

    public static int listLength(Object obj)
    {
        int i = 0;
        Object obj1 = obj;
        Object obj2 = obj;
        obj = obj1;
        obj1 = obj2;
        Object obj3;
        do
        {
            do
            {
                obj2 = obj;
                if (!(obj1 instanceof SyntaxForm))
                {
                    break;
                }
                obj1 = ((SyntaxForm)obj1).getDatum();
            } while (true);
            for (; obj2 instanceof SyntaxForm; obj2 = ((SyntaxForm)obj2).getDatum()) { }
            if (obj1 == LList.Empty)
            {
                return i;
            }
            if (!(obj1 instanceof Pair))
            {
                return -1 - i;
            }
            i++;
            for (obj = ((Pair)obj1).getCdr(); obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
            if (obj == LList.Empty)
            {
                return i;
            }
            if (!(obj instanceof Pair))
            {
                return -1 - i;
            }
            obj2 = ((Pair)obj2).getCdr();
            obj3 = ((Pair)obj).getCdr();
            i++;
            obj1 = obj3;
            obj = obj2;
        } while (obj3 != obj2);
        return 0x80000000;
    }

    private Expression makeBody(int i, ScopeExp scopeexp)
    {
        int k = formStack.size() - i;
        if (k == 0)
        {
            return QuoteExp.voidExp;
        }
        if (k == 1)
        {
            return (Expression)formStack.pop();
        }
        Expression aexpression[] = new Expression[k];
        for (int j = 0; j < k; j++)
        {
            aexpression[j] = (Expression)formStack.elementAt(i + j);
        }

        formStack.setSize(i);
        if (scopeexp instanceof ModuleExp)
        {
            return new ApplyExp(AppendValues.appendValues, aexpression);
        } else
        {
            return ((LispLanguage)getLanguage()).makeBody(aexpression);
        }
    }

    public static Pair makePair(Pair pair, Object obj, Object obj1)
    {
        if (pair instanceof PairWithPosition)
        {
            return new PairWithPosition((PairWithPosition)pair, obj, obj1);
        } else
        {
            return new Pair(obj, obj1);
        }
    }

    private void rewriteBody(LList llist)
    {
_L2:
        Pair pair;
        if (llist == LList.Empty)
        {
            break; /* Loop/switch isn't completed */
        }
        pair = (Pair)llist;
        llist = ((LList) (pushPositionOf(pair)));
        rewriteInBody(pair.getCar());
        popPositionOf(llist);
        llist = (LList)pair.getCdr();
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        popPositionOf(llist);
        throw exception;
_L1:
    }

    public static Object safeCar(Object obj)
    {
        for (; obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
        if (!(obj instanceof Pair))
        {
            return null;
        } else
        {
            return stripSyntax(((Pair)obj).getCar());
        }
    }

    public static Object safeCdr(Object obj)
    {
        for (; obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
        if (!(obj instanceof Pair))
        {
            return null;
        } else
        {
            return stripSyntax(((Pair)obj).getCdr());
        }
    }

    public static void setLine(Declaration declaration, Object obj)
    {
        if (obj instanceof SourceLocator)
        {
            declaration.setLocation((SourceLocator)obj);
        }
    }

    public static void setLine(Expression expression, Object obj)
    {
        if (obj instanceof SourceLocator)
        {
            expression.setLocation((SourceLocator)obj);
        }
    }

    public static Object stripSyntax(Object obj)
    {
        for (; obj instanceof SyntaxForm; obj = ((SyntaxForm)obj).getDatum()) { }
        return obj;
    }

    static void vectorReverse(Vector vector, int i, int j)
    {
        int k = j / 2;
        int l = (i + j) - 1;
        for (j = 0; j < k; j++)
        {
            Object obj = vector.elementAt(i + j);
            vector.setElementAt(vector.elementAt(l - j), i + j);
            vector.setElementAt(obj, l - j);
        }

    }

    public static Object wrapSyntax(Object obj, SyntaxForm syntaxform)
    {
        if (syntaxform == null || (obj instanceof Expression))
        {
            return obj;
        } else
        {
            return SyntaxForms.fromDatumIfNeeded(obj, syntaxform);
        }
    }

    Expression apply_rewrite(Syntax syntax, Pair pair)
    {
        Object obj;
        obj = errorExp;
        obj = currentSyntax;
        currentSyntax = syntax;
        syntax = syntax.rewriteForm(pair, this);
        currentSyntax = ((Syntax) (obj));
        return syntax;
        syntax;
        currentSyntax = ((Syntax) (obj));
        throw syntax;
    }

    Syntax check_if_Syntax(Declaration declaration)
    {
        Object obj;
        Object obj1;
        Declaration declaration1 = Declaration.followAliases(declaration);
        obj1 = null;
        obj = declaration1.getValue();
        if (obj == null || !declaration1.getFlag(32768L))
        {
            break MISSING_BLOCK_LABEL_176;
        }
        if (!(declaration.getValue() instanceof ReferenceExp)) goto _L2; else goto _L1
_L1:
        Declaration declaration2 = ((ReferenceExp)declaration.getValue()).contextDecl();
        if (declaration2 == null) goto _L4; else goto _L3
_L3:
        macroContext = declaration2;
_L6:
        obj = ((Expression) (obj)).eval(env);
_L7:
        if (obj instanceof Syntax)
        {
            return (Syntax)obj;
        } else
        {
            return null;
        }
_L4:
        if (!(current_scope instanceof TemplateScope)) goto _L6; else goto _L5
_L5:
        macroContext = ((TemplateScope)current_scope).macroContext;
          goto _L6
        obj;
        ((Throwable) (obj)).printStackTrace();
        error('e', (new StringBuilder()).append("unable to evaluate macro for ").append(declaration.getSymbol()).toString());
        obj = obj1;
          goto _L7
_L2:
        if (!(current_scope instanceof TemplateScope)) goto _L6; else goto _L8
_L8:
        macroContext = ((TemplateScope)current_scope).macroContext;
          goto _L6
        obj = obj1;
        if (declaration.getFlag(32768L))
        {
            obj = obj1;
            if (!declaration.needsContext())
            {
                obj = StaticFieldLocation.make(declaration).get(null);
            }
        }
          goto _L7
    }

    public Declaration define(Object obj, SyntaxForm syntaxform, ScopeExp scopeexp)
    {
        Object obj1;
        boolean flag;
        if (syntaxform != null && syntaxform.getScope() != currentScope())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj1 = new String(obj.toString());
        } else
        {
            obj1 = obj;
        }
        scopeexp = scopeexp.getDefine(obj1, 'w', this);
        if (flag)
        {
            obj = makeRenamedAlias(obj, scopeexp, syntaxform.getScope());
            syntaxform.getScope().addDeclaration(((Declaration) (obj)));
        }
        push(scopeexp);
        return scopeexp;
    }

    public Type exp2Type(Pair pair)
    {
        Object obj = pushPositionOf(pair);
        Expression expression;
        boolean flag;
        expression = InlineCalls.inlineCalls(rewrite_car(pair, false), this);
        flag = expression instanceof ErrorExp;
        if (flag)
        {
            popPositionOf(obj);
            return null;
        }
        Type type = getLanguage().getTypeFor(expression);
        pair = type;
        if (type != null) goto _L2; else goto _L1
_L1:
        Object obj1 = expression.eval(env);
        if (!(obj1 instanceof Class)) goto _L4; else goto _L3
_L3:
        pair = Type.make((Class)obj1);
_L2:
        if (pair != null) goto _L6; else goto _L5
_L5:
        if (!(expression instanceof ReferenceExp)) goto _L8; else goto _L7
_L7:
        error('e', (new StringBuilder()).append("unknown type name '").append(((ReferenceExp)expression).getName()).append('\'').toString());
_L9:
        pair = Type.pointer_type;
        popPositionOf(obj);
        return pair;
_L4:
        pair = type;
        try
        {
            if (obj1 instanceof Type)
            {
                pair = (Type)obj1;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Pair pair)
        {
            pair = type;
        }
        finally
        {
            popPositionOf(obj);
            throw pair;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        error('e', "invalid type spec (must be \"type\" or 'type or <type>)");
          goto _L9
_L6:
        popPositionOf(obj);
        return pair;
        if (true) goto _L2; else goto _L10
_L10:
    }

    public void finishModule(ModuleExp moduleexp)
    {
        Declaration declaration;
        boolean flag;
        flag = moduleexp.isStatic();
        declaration = moduleexp.firstDecl();
_L7:
        if (declaration == null) goto _L2; else goto _L1
_L1:
        if (declaration.getFlag(512L))
        {
            String s;
            if (declaration.getFlag(1024L))
            {
                s = "' exported but never defined";
            } else
            if (declaration.getFlag(2048L))
            {
                s = "' declared static but never defined";
            } else
            {
                s = "' declared but never defined";
            }
            error('e', declaration, "'", s);
        }
        if (moduleexp.getFlag(16384) || generateMain && !immediate)
        {
            if (declaration.getFlag(1024L))
            {
                if (declaration.isPrivate())
                {
                    if (declaration.getFlag(0x1000000L))
                    {
                        error('e', declaration, "'", "' is declared both private and exported");
                    }
                    declaration.setPrivate(false);
                }
            } else
            {
                declaration.setPrivate(true);
            }
        }
        if (!flag) goto _L4; else goto _L3
_L3:
        declaration.setFlag(2048L);
_L5:
        declaration = declaration.nextDecl();
        continue; /* Loop/switch isn't completed */
_L4:
        if (moduleexp.getFlag(0x10000) && !declaration.getFlag(2048L) || Compilation.moduleStatic < 0 || moduleexp.getFlag(0x20000))
        {
            declaration.setFlag(4096L);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public Syntax getCurrentSyntax()
    {
        return currentSyntax;
    }

    public final Environment getGlobalEnvironment()
    {
        return env;
    }

    public Declaration lookup(Object obj, int i)
    {
        Declaration declaration = lexical.lookup(obj, i);
        if (declaration != null && getLanguage().hasNamespace(declaration, i))
        {
            return declaration;
        } else
        {
            return currentModule().lookup(obj, getLanguage(), i);
        }
    }

    public Declaration lookupGlobal(Object obj)
    {
        return lookupGlobal(obj, -1);
    }

    public Declaration lookupGlobal(Object obj, int i)
    {
        ModuleExp moduleexp = currentModule();
        Declaration declaration1 = moduleexp.lookup(obj, getLanguage(), i);
        Declaration declaration = declaration1;
        if (declaration1 == null)
        {
            declaration = moduleexp.getNoDefine(obj);
            declaration.setIndirectBinding(true);
        }
        return declaration;
    }

    public Declaration makeRenamedAlias(Declaration declaration, ScopeExp scopeexp)
    {
        if (scopeexp == null)
        {
            return declaration;
        } else
        {
            return makeRenamedAlias(declaration.getSymbol(), declaration, scopeexp);
        }
    }

    public Declaration makeRenamedAlias(Object obj, Declaration declaration, ScopeExp scopeexp)
    {
        obj = new Declaration(obj);
        ((Declaration) (obj)).setAlias(true);
        ((Declaration) (obj)).setPrivate(true);
        obj.context = scopeexp;
        declaration = new ReferenceExp(declaration);
        declaration.setDontDereference(true);
        ((Declaration) (obj)).noteValue(declaration);
        return ((Declaration) (obj));
    }

    public Object matchQuoted(Pair pair)
    {
        if (matches(pair.getCar(), "quote") && (pair.getCdr() instanceof Pair))
        {
            pair = (Pair)pair.getCdr();
            if (pair.getCdr() == LList.Empty)
            {
                return pair.getCar();
            }
        }
        return null;
    }

    public final boolean matches(Object obj, String s)
    {
        return matches(obj, null, s);
    }

    public boolean matches(Object obj, SyntaxForm syntaxform, Symbol symbol)
    {
        if (syntaxform == null);
        syntaxform = ((SyntaxForm) (obj));
        if (obj instanceof SyntaxForm)
        {
            syntaxform = ((SyntaxForm) (((SyntaxForm)obj).getDatum()));
        }
        obj = syntaxform;
        if (syntaxform instanceof SimpleSymbol)
        {
            obj = syntaxform;
            if (!selfEvaluatingSymbol(syntaxform))
            {
                ReferenceExp referenceexp = getOriginalRef(lexical.lookup(syntaxform, -1));
                obj = syntaxform;
                if (referenceexp != null)
                {
                    obj = referenceexp.getSymbol();
                }
            }
        }
        return obj == symbol;
    }

    public boolean matches(Object obj, SyntaxForm syntaxform, String s)
    {
        if (syntaxform == null);
        syntaxform = ((SyntaxForm) (obj));
        if (obj instanceof SyntaxForm)
        {
            syntaxform = ((SyntaxForm) (((SyntaxForm)obj).getDatum()));
        }
        obj = syntaxform;
        if (syntaxform instanceof SimpleSymbol)
        {
            obj = syntaxform;
            if (!selfEvaluatingSymbol(syntaxform))
            {
                ReferenceExp referenceexp = getOriginalRef(lexical.lookup(syntaxform, -1));
                obj = syntaxform;
                if (referenceexp != null)
                {
                    obj = referenceexp.getSymbol();
                }
            }
        }
        return (obj instanceof SimpleSymbol) && ((Symbol)obj).getLocalPart() == s;
    }

    public Symbol namespaceResolve(Expression expression, Expression expression1)
    {
        return namespaceResolve(namespaceResolvePrefix(expression), expression1);
    }

    public Symbol namespaceResolve(Namespace namespace, Expression expression)
    {
        if (namespace != null && (expression instanceof QuoteExp))
        {
            return namespace.getSymbol(((QuoteExp)expression).getValue().toString().intern());
        } else
        {
            return null;
        }
    }

    public Object namespaceResolve(Object obj)
    {
        if (!(obj instanceof SimpleSymbol) && (obj instanceof Pair))
        {
            Pair pair = (Pair)obj;
            if (safeCar(pair) == LispLanguage.lookup_sym && (pair.getCdr() instanceof Pair))
            {
                Object obj2 = (Pair)pair.getCdr();
                if (((Pair) (obj2)).getCdr() instanceof Pair)
                {
                    Object obj1 = rewrite(((Pair) (obj2)).getCar());
                    obj2 = rewrite(((Pair)((Pair) (obj2)).getCdr()).getCar());
                    Symbol symbol = namespaceResolve(((Expression) (obj1)), ((Expression) (obj2)));
                    if (symbol != null)
                    {
                        return symbol;
                    }
                    obj1 = CompileNamedPart.combineName(((Expression) (obj1)), ((Expression) (obj2)));
                    if (obj1 != null)
                    {
                        return Namespace.EmptyNamespace.getSymbol(((String) (obj1)));
                    }
                }
            }
        }
        return obj;
    }

    public Namespace namespaceResolvePrefix(Expression expression)
    {
        if (expression instanceof ReferenceExp)
        {
            expression = (ReferenceExp)expression;
            Object obj = expression.getBinding();
            if (obj == null || ((Declaration) (obj)).getFlag(0x10000L))
            {
                expression = ((Expression) (expression.getSymbol()));
                String s;
                if (expression instanceof Symbol)
                {
                    expression = (Symbol)expression;
                } else
                {
                    expression = env.getSymbol(expression.toString());
                }
                expression = ((Expression) (env.get(expression, null)));
            } else
            if (((Declaration) (obj)).isNamespaceDecl())
            {
                expression = ((Expression) (((Declaration) (obj)).getConstantValue()));
            } else
            {
                expression = null;
            }
            if (expression instanceof Namespace)
            {
                obj = (Namespace)expression;
                s = ((Namespace) (obj)).getName();
                expression = ((Expression) (obj));
                if (s != null)
                {
                    expression = ((Expression) (obj));
                    if (s.startsWith("class:"))
                    {
                        expression = null;
                    }
                }
                return expression;
            }
        }
        return null;
    }

    public void noteAccess(Object obj, ScopeExp scopeexp)
    {
        if (notedAccess == null)
        {
            notedAccess = new Vector();
        }
        notedAccess.addElement(obj);
        notedAccess.addElement(scopeexp);
    }

    public Expression parse(Object obj)
    {
        return rewrite(obj);
    }

    public Object popForms(int i)
    {
        int k = formStack.size();
        if (k == i)
        {
            return Values.empty;
        }
        Object obj;
        if (k == i + 1)
        {
            obj = formStack.elementAt(i);
        } else
        {
            obj = new Values();
            int j = i;
            while (j < k) 
            {
                ((Values) (obj)).writeObject(formStack.elementAt(j));
                j++;
            }
        }
        formStack.setSize(i);
        return obj;
    }

    public void popPositionOf(Object obj)
    {
        if (obj != null)
        {
            setLine(obj);
            positionPair = (PairWithPosition)obj;
            if (positionPair.getCar() == Special.eof)
            {
                positionPair = (PairWithPosition)positionPair.getCdr();
                return;
            }
        }
    }

    public void popRenamedAlias(int i)
    {
        do
        {
            int j = i - 1;
            if (j < 0)
            {
                break;
            }
            ScopeExp scopeexp = (ScopeExp)renamedAliasStack.pop();
            Object obj = (Declaration)renamedAliasStack.pop();
            getOriginalRef(((Declaration) (obj))).getBinding().setSymbol(((Declaration) (obj)).getSymbol());
            scopeexp.remove(((Declaration) (obj)));
            obj = renamedAliasStack.pop();
            i = j;
            if (obj != null)
            {
                scopeexp.addDeclaration((Declaration)obj);
                i = j;
            }
        } while (true);
    }

    public void processAccesses()
    {
        if (notedAccess != null)
        {
            int j = notedAccess.size();
            ScopeExp scopeexp = current_scope;
            for (int i = 0; i < j; i += 2)
            {
                Object obj = notedAccess.elementAt(i);
                ScopeExp scopeexp1 = (ScopeExp)notedAccess.elementAt(i + 1);
                if (current_scope != scopeexp1)
                {
                    setCurrentScope(scopeexp1);
                }
                obj = lexical.lookup(obj, -1);
                if (obj != null && !((Declaration) (obj)).getFlag(0x10000L))
                {
                    ((Declaration) (obj)).getContext().currentLambda().capture(((Declaration) (obj)));
                    ((Declaration) (obj)).setCanRead(true);
                    ((Declaration) (obj)).setSimple(false);
                    ((Declaration) (obj)).setFlag(0x80000L);
                }
            }

            if (current_scope != scopeexp)
            {
                setCurrentScope(scopeexp);
                return;
            }
        }
    }

    public Object pushPositionOf(Object obj)
    {
        Object obj1 = obj;
        if (obj instanceof SyntaxForm)
        {
            obj1 = ((SyntaxForm)obj).getDatum();
        }
        if (!(obj1 instanceof PairWithPosition))
        {
            return null;
        }
        PairWithPosition pairwithposition = (PairWithPosition)obj1;
        if (positionPair == null || positionPair.getFileName() != getFileName() || positionPair.getLineNumber() != getLineNumber() || positionPair.getColumnNumber() != getColumnNumber())
        {
            obj = new PairWithPosition(this, Special.eof, positionPair);
        } else
        {
            obj = positionPair;
        }
        setLine(obj1);
        positionPair = pairwithposition;
        return obj;
    }

    public void pushRenamedAlias(Declaration declaration)
    {
        Declaration declaration1 = getOriginalRef(declaration).getBinding();
        ScopeExp scopeexp = declaration.context;
        declaration1.setSymbol(null);
        declaration1 = scopeexp.lookup(declaration1.getSymbol());
        if (declaration1 != null)
        {
            scopeexp.remove(declaration1);
        }
        scopeexp.addDeclaration(declaration);
        if (renamedAliasStack == null)
        {
            renamedAliasStack = new Stack();
        }
        renamedAliasStack.push(declaration1);
        renamedAliasStack.push(declaration);
        renamedAliasStack.push(scopeexp);
    }

    public void resolveModule(ModuleExp moduleexp)
    {
        Compilation compilation;
        int i;
        int j;
        if (pendingImports == null)
        {
            i = 0;
        } else
        {
            i = pendingImports.size();
        }
        j = 0;
        do
        {
            if (j >= i)
            {
                break;
            }
            Object obj = pendingImports;
            int k = j + 1;
            obj = (ModuleInfo)((Stack) (obj)).elementAt(j);
            Object obj1 = pendingImports;
            j = k + 1;
            obj1 = (ScopeExp)((Stack) (obj1)).elementAt(k);
            Object obj2 = pendingImports;
            int l = j + 1;
            obj2 = (Expression)((Stack) (obj2)).elementAt(j);
            Object obj3 = pendingImports;
            k = l + 1;
            obj3 = (Integer)((Stack) (obj3)).elementAt(l);
            j = k;
            if (moduleexp == obj1)
            {
                ReferenceExp referenceexp = new ReferenceExp((Object)null);
                referenceexp.setLine(this);
                setLine(((Expression) (obj2)));
                j = formStack.size();
                require.importDefinitions(null, ((ModuleInfo) (obj)), null, formStack, ((ScopeExp) (obj1)), this);
                int i1 = ((Integer) (obj3)).intValue();
                if (((Integer) (obj3)).intValue() != j)
                {
                    int j1 = formStack.size();
                    vectorReverse(formStack, i1, j - i1);
                    vectorReverse(formStack, j, j1 - j);
                    vectorReverse(formStack, i1, j1 - i1);
                }
                setLine(referenceexp);
                j = k;
            }
        } while (true);
        pendingImports = null;
        processAccesses();
        setModule(moduleexp);
        compilation = Compilation.setSaveCurrent(this);
        rewriteInBody(popForms(firstForm));
        moduleexp.body = makeBody(firstForm, moduleexp);
        if (!immediate)
        {
            lexical.pop(moduleexp);
        }
        Compilation.restoreCurrent(compilation);
        return;
        moduleexp;
        Compilation.restoreCurrent(compilation);
        throw moduleexp;
    }

    public Expression rewrite(Object obj)
    {
        return rewrite(obj, false);
    }

    public Expression rewrite(Object obj, boolean flag)
    {
        Object obj1;
        if (!(obj instanceof SyntaxForm))
        {
            break MISSING_BLOCK_LABEL_61;
        }
        obj1 = (SyntaxForm)obj;
        obj = current_scope;
        setCurrentScope(((SyntaxForm) (obj1)).getScope());
        obj1 = rewrite(((SyntaxForm) (obj1)).getDatum(), flag);
        setCurrentScope(((ScopeExp) (obj)));
        return ((Expression) (obj1));
        Exception exception;
        exception;
        setCurrentScope(((ScopeExp) (obj)));
        throw exception;
        if (obj instanceof PairWithPosition)
        {
            return rewrite_with_position(obj, flag, (PairWithPosition)obj);
        }
        if (obj instanceof Pair)
        {
            return rewrite_pair((Pair)obj, flag);
        }
        if (!(obj instanceof Symbol) || selfEvaluatingSymbol(obj)) goto _L2; else goto _L1
_L1:
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj7;
        Object obj8;
        Object obj9;
        boolean flag2;
        obj2 = lexical.lookup(obj, flag);
        obj8 = null;
        obj7 = null;
        exception = current_scope;
        Object obj5;
        int i;
        if (obj2 == null)
        {
            i = -1;
        } else
        {
            i = ScopeExp.nesting(((Declaration) (obj2)).context);
        }
        if ((obj instanceof Symbol) && ((Symbol)obj).hasEmptyNamespace())
        {
            obj3 = obj.toString();
        } else
        {
            obj3 = null;
            exception = null;
        }
_L19:
        if (exception == null) goto _L4; else goto _L3
_L3:
        if (!(exception instanceof LambdaExp) || !(((ScopeExp) (exception)).outer instanceof ClassExp) || !((LambdaExp)exception).isClassMethod()) goto _L6; else goto _L5
_L5:
        if (i < ScopeExp.nesting(((ScopeExp) (exception)).outer)) goto _L7; else goto _L4
_L4:
        char c;
        ClassExp classexp;
        gnu.bytecode.Member member;
        boolean flag1;
        if (obj2 != null)
        {
            obj4 = ((Declaration) (obj2)).getSymbol();
            obj5 = null;
            obj9 = getOriginalRef(((Declaration) (obj2)));
            obj = obj4;
            exception = obj5;
            if (obj9 != null)
            {
                obj3 = ((ReferenceExp) (obj9)).getBinding();
                obj2 = obj3;
                obj = obj4;
                exception = obj5;
                if (obj3 == null)
                {
                    exception = ((Exception) (((ReferenceExp) (obj9)).getSymbol()));
                    obj = exception;
                    obj2 = obj3;
                }
            }
            obj4 = exception;
            obj3 = obj;
        } else
        {
            obj3 = obj;
            obj4 = obj;
        }
        obj9 = (Symbol)obj4;
        flag2 = getLanguage().hasSeparateFunctionNamespace();
        if (obj2 == null) goto _L9; else goto _L8
_L7:
        obj4 = (LambdaExp)exception;
        classexp = (ClassExp)((ScopeExp) (exception)).outer;
        obj9 = classexp.getClassType();
        member = SlotGet.lookupMember(((gnu.bytecode.ObjectType) (obj9)), ((String) (obj3)), ((ClassType) (obj9)));
        if (obj4 == classexp.clinitMethod || obj4 != classexp.initMethod && ((LambdaExp) (obj4)).nameDecl.isStatic())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (member != null) goto _L11; else goto _L10
_L10:
        if (flag1)
        {
            c = 'S';
        } else
        {
            c = 'V';
        }
        if (ClassMethods.getMethods(((gnu.bytecode.ObjectType) (obj9)), ((String) (obj3)), c, ((ClassType) (obj9)), language).length != 0) goto _L11; else goto _L6
_L6:
        exception = ((ScopeExp) (exception)).outer;
        continue; /* Loop/switch isn't completed */
_L11:
        if (flag1)
        {
            obj = new ReferenceExp(((ClassExp)((LambdaExp) (obj4)).outer).nameDecl);
        } else
        {
            obj = new ThisExp(((LambdaExp) (obj4)).firstDecl());
        }
        return CompileNamedPart.makeExp(((Expression) (obj)), QuoteExp.getInstance(obj3));
_L8:
        if ((current_scope instanceof TemplateScope) && ((Declaration) (obj2)).needsContext())
        {
            exception = ((TemplateScope)current_scope).macroContext;
            obj = obj2;
            break MISSING_BLOCK_LABEL_345;
        }
        exception = obj7;
        obj = obj2;
        if (!((Declaration) (obj2)).getFlag(0x100000L))
        {
            continue; /* Loop/switch isn't completed */
        }
        exception = obj7;
        obj = obj2;
        if (((Declaration) (obj2)).isStatic())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = currentScope();
_L12:
label0:
        {
            if (obj == null)
            {
                throw new Error((new StringBuilder()).append("internal error: missing ").append(obj2).toString());
            }
            if (((ScopeExp) (obj)).outer != ((Declaration) (obj2)).context)
            {
                break label0;
            }
            exception = ((ScopeExp) (obj)).firstDecl();
            obj = obj2;
        }
        continue; /* Loop/switch isn't completed */
        obj = ((ScopeExp) (obj)).outer;
        if (true) goto _L12; else goto _L9
_L9:
        exception = env;
        Throwable throwable;
        Object obj6;
        boolean flag3;
        if (flag && flag2)
        {
            obj = EnvironmentKey.FUNCTION;
        } else
        {
            obj = null;
        }
        obj = exception.lookup(((Symbol) (obj9)), obj);
        obj6 = obj;
        if (obj != null)
        {
            obj6 = ((Location) (obj)).getBase();
        }
        if (!(obj6 instanceof FieldLocation)) goto _L14; else goto _L13
_L13:
        obj6 = (FieldLocation)obj6;
        obj2 = ((FieldLocation) (obj6)).getDeclaration();
        if (!inlineOk(null) && obj2 != getNamedPartDecl && (!"objectSyntax".equals(((FieldLocation) (obj6)).getMemberName()) || !"kawa.standard.object".equals(((FieldLocation) (obj6)).getDeclaringClass().getName())))
        {
            break MISSING_BLOCK_LABEL_1160;
        }
        if (!immediate)
        {
            break MISSING_BLOCK_LABEL_847;
        }
        exception = obj7;
        obj = obj2;
        if (((Declaration) (obj2)).isStatic())
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new Declaration("(module-instance)");
        ((Declaration) (obj)).setValue(new QuoteExp(((FieldLocation) (obj6)).getInstance()));
        exception = ((Exception) (obj));
        obj = obj2;
        continue; /* Loop/switch isn't completed */
        if (!((Declaration) (obj2)).isStatic())
        {
            break MISSING_BLOCK_LABEL_904;
        }
        obj = ((FieldLocation) (obj6)).getRClass();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_895;
        }
        obj = ((Class) (obj)).getClassLoader();
        if (obj instanceof ZipLoader)
        {
            break MISSING_BLOCK_LABEL_895;
        }
        flag3 = obj instanceof ArrayClassLoader;
        exception = obj7;
        obj = obj2;
        if (!flag3)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = null;
        exception = obj7;
        continue; /* Loop/switch isn't completed */
        obj = null;
        exception = obj7;
        continue; /* Loop/switch isn't completed */
        obj;
        exception = obj8;
_L15:
        error('e', (new StringBuilder()).append("exception loading '").append(obj4).append("' - ").append(((Throwable) (obj)).getMessage()).toString());
        obj = null;
        continue; /* Loop/switch isn't completed */
_L14:
        if (obj6 != null)
        {
            exception = obj7;
            obj = obj2;
            if (((Location) (obj6)).isBound())
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        obj4 = ((LispLanguage)getLanguage()).checkDefaultBinding(((Symbol) (obj9)), this);
        exception = obj7;
        obj = obj2;
        if (obj4 != null)
        {
            return ((Expression) (obj4));
        }
_L17:
        if (obj != null)
        {
            if (!flag && (((Declaration) (obj)).getConstantValue() instanceof object))
            {
                return QuoteExp.getInstance(java/lang/Object);
            }
            if (((Declaration) (obj)).getContext() instanceof PatternScope)
            {
                return syntaxError((new StringBuilder()).append("reference to pattern variable ").append(((Declaration) (obj)).getName()).append(" outside syntax template").toString());
            }
        }
        obj = new ReferenceExp(obj3, ((Declaration) (obj)));
        ((ReferenceExp) (obj)).setContextDecl(exception);
        ((ReferenceExp) (obj)).setLine(this);
        if (flag && flag2)
        {
            ((ReferenceExp) (obj)).setFlag(8);
        }
        return ((Expression) (obj));
_L2:
        if (obj instanceof LangExp)
        {
            return rewrite(((LangExp)obj).getLangValue(), flag);
        }
        if (obj instanceof Expression)
        {
            return (Expression)obj;
        }
        if (obj == Special.abstractSpecial)
        {
            return QuoteExp.abstractExp;
        } else
        {
            return QuoteExp.getInstance(Quote.quote(obj, this), this);
        }
        throwable;
        exception = ((Exception) (obj));
        obj = throwable;
          goto _L15
        obj = null;
        exception = obj7;
        if (true) goto _L17; else goto _L16
_L16:
        if (true) goto _L19; else goto _L18
_L18:
    }

    public void rewriteInBody(Object obj)
    {
        if (!(obj instanceof SyntaxForm)) goto _L2; else goto _L1
_L1:
        SyntaxForm syntaxform;
        syntaxform = (SyntaxForm)obj;
        obj = current_scope;
        setCurrentScope(syntaxform.getScope());
        rewriteInBody(syntaxform.getDatum());
        setCurrentScope(((ScopeExp) (obj)));
_L4:
        return;
        Exception exception;
        exception;
        setCurrentScope(((ScopeExp) (obj)));
        throw exception;
_L2:
        if (obj instanceof Values)
        {
            obj = ((Object) (((Values)obj).getValues()));
            int i = 0;
            while (i < obj.length) 
            {
                rewriteInBody(obj[i]);
                i++;
            }
        } else
        {
            formStack.add(rewrite(obj, false));
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public Expression rewrite_body(Object obj)
    {
        Object obj1;
        LetExp letexp;
        int k;
        obj1 = pushPositionOf(obj);
        letexp = new LetExp(null);
        k = formStack.size();
        letexp.outer = current_scope;
        current_scope = letexp;
        int j;
        obj = scanBody(obj, letexp, true);
        if (((LList) (obj)).isEmpty())
        {
            formStack.add(syntaxError("body with no expressions"));
        }
        j = letexp.countNonDynamicDecls();
        if (j == 0)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        Expression aexpression[] = new Expression[j];
        int i = j;
_L2:
        i--;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        aexpression[i] = QuoteExp.undefined_exp;
        if (true) goto _L2; else goto _L1
        obj;
        pop(letexp);
        popPositionOf(obj1);
        throw obj;
_L1:
        letexp.inits = aexpression;
        rewriteBody(((LList) (obj)));
        obj = makeBody(k, null);
        setLineOf(((Expression) (obj)));
        if (j == 0)
        {
            pop(letexp);
            popPositionOf(obj1);
            return ((Expression) (obj));
        }
        letexp.body = ((Expression) (obj));
        setLineOf(letexp);
        pop(letexp);
        popPositionOf(obj1);
        return letexp;
    }

    public final Expression rewrite_car(Pair pair, SyntaxForm syntaxform)
    {
        ScopeExp scopeexp;
        if (syntaxform == null || syntaxform.getScope() == current_scope || (pair.getCar() instanceof SyntaxForm))
        {
            return rewrite_car(pair, false);
        }
        scopeexp = current_scope;
        setCurrentScope(syntaxform.getScope());
        pair = rewrite_car(pair, false);
        setCurrentScope(scopeexp);
        return pair;
        pair;
        setCurrentScope(scopeexp);
        throw pair;
    }

    public final Expression rewrite_car(Pair pair, boolean flag)
    {
        Object obj = pair.getCar();
        if (pair instanceof PairWithPosition)
        {
            return rewrite_with_position(obj, flag, (PairWithPosition)pair);
        } else
        {
            return rewrite(obj, flag);
        }
    }

    public Expression rewrite_pair(Pair pair, boolean flag)
    {
        Stack stack;
        Expression expression1;
        ScopeExp scopeexp;
        int i;
        int j;
        boolean flag1;
        expression1 = rewrite_car(pair, true);
        if (expression1 instanceof QuoteExp)
        {
            Object obj = expression1.valueIfConstant();
            if (obj instanceof Syntax)
            {
                return apply_rewrite((Syntax)obj, pair);
            }
        }
        Object obj1;
        if (expression1 instanceof ReferenceExp)
        {
            ReferenceExp referenceexp = (ReferenceExp)expression1;
            Object obj3 = referenceexp.getBinding();
            if (obj3 == null)
            {
                obj1 = referenceexp.getSymbol();
                Environment environment;
                if ((obj1 instanceof Symbol) && !selfEvaluatingSymbol(obj1))
                {
                    obj1 = (Symbol)obj1;
                    ((Symbol) (obj1)).getName();
                } else
                {
                    obj1 = obj1.toString();
                    obj1 = env.getSymbol(((String) (obj1)));
                }
                environment = env;
                if (getLanguage().hasSeparateFunctionNamespace())
                {
                    obj3 = EnvironmentKey.FUNCTION;
                } else
                {
                    obj3 = null;
                }
                obj1 = environment.get(((Symbol) (obj1)), obj3, null);
                if (obj1 instanceof Syntax)
                {
                    return apply_rewrite((Syntax)obj1, pair);
                }
                if (obj1 instanceof AutoloadProcedure)
                {
                    try
                    {
                        ((AutoloadProcedure)obj1).getLoaded();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj1) { }
                }
            } else
            {
                obj1 = macroContext;
                obj3 = check_if_Syntax(((Declaration) (obj3)));
                if (obj3 != null)
                {
                    pair = apply_rewrite(((Syntax) (obj3)), pair);
                    macroContext = ((Declaration) (obj1));
                    return pair;
                }
            }
            referenceexp.setProcedureName(true);
            if (getLanguage().hasSeparateFunctionNamespace())
            {
                expression1.setFlag(8);
            }
        }
        obj1 = pair.getCdr();
        j = listLength(obj1);
        if (j == -1)
        {
            return syntaxError((new StringBuilder()).append("circular list is not allowed after ").append(pair.getCar()).toString());
        }
        if (j < 0)
        {
            return syntaxError((new StringBuilder()).append("dotted list [").append(obj1).append("] is not allowed after ").append(pair.getCar()).toString());
        }
        flag1 = false;
        stack = new Stack();
        scopeexp = current_scope;
        i = 0;
        pair = ((Pair) (obj1));
_L2:
        Object obj2;
        Pair pair1;
        boolean flag2;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_544;
        }
        obj2 = pair;
        if (pair instanceof SyntaxForm)
        {
            pair = (SyntaxForm)pair;
            obj2 = pair.getDatum();
            setCurrentScope(pair.getScope());
        }
        pair1 = (Pair)obj2;
        obj2 = rewrite_car(pair1, false);
        i++;
        pair = ((Pair) (obj2));
        flag2 = flag1;
        if (flag1)
        {
            if ((i & 1) != 0)
            {
                break; /* Loop/switch isn't completed */
            }
            pair = (Expression)stack.pop();
            pair = new ApplyExp(MakeAttribute.makeAttribute, new Expression[] {
                pair, obj2
            });
            flag2 = flag1;
        }
_L3:
        stack.addElement(pair);
        pair = ((Pair) (pair1.getCdr()));
        flag1 = flag2;
        if (true) goto _L2; else goto _L1
_L1:
label0:
        {
            if (!(obj2 instanceof QuoteExp))
            {
                break label0;
            }
            pair = ((Pair) (((QuoteExp)obj2).getValue()));
            if (!(pair instanceof Keyword) || i >= j)
            {
                break label0;
            }
            pair = new QuoteExp(((Keyword)pair).asSymbol());
            flag2 = flag1;
        }
          goto _L3
        flag2 = false;
        pair = ((Pair) (obj2));
          goto _L3
        pair = new Expression[stack.size()];
        stack.copyInto(pair);
        if (scopeexp != current_scope)
        {
            setCurrentScope(scopeexp);
        }
        if ((expression1 instanceof ReferenceExp) && ((ReferenceExp)expression1).getBinding() == getNamedPartDecl)
        {
            Expression expression = pair[0];
            pair = pair[1];
            Symbol symbol = namespaceResolve(expression, pair);
            if (symbol != null)
            {
                return rewrite(symbol, flag);
            } else
            {
                return CompileNamedPart.makeExp(expression, pair);
            }
        } else
        {
            return ((LispLanguage)getLanguage()).makeApply(expression1, pair);
        }
    }

    public Expression rewrite_with_position(Object obj, boolean flag, PairWithPosition pairwithposition)
    {
        Object obj1;
        obj1 = pushPositionOf(pairwithposition);
        if (obj != pairwithposition)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        obj = rewrite_pair(pairwithposition, flag);
_L1:
        setLineOf(((Expression) (obj)));
        popPositionOf(obj1);
        return ((Expression) (obj));
        obj = rewrite(obj, flag);
          goto _L1
        obj;
        popPositionOf(obj1);
        throw obj;
    }

    public LList scanBody(Object obj, ScopeExp scopeexp, boolean flag)
    {
        Object obj1;
        Object obj2;
        Object obj3;
        int i;
        if (flag)
        {
            obj1 = LList.Empty;
        } else
        {
            obj1 = null;
        }
        obj3 = null;
        obj2 = obj;
        obj = obj1;
        obj1 = obj3;
_L2:
        obj3 = obj;
        if (obj2 == LList.Empty)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (!(obj2 instanceof SyntaxForm))
        {
            break MISSING_BLOCK_LABEL_174;
        }
        obj3 = (SyntaxForm)obj2;
        obj2 = current_scope;
        setCurrentScope(((SyntaxForm) (obj3)).getScope());
        i = formStack.size();
        scopeexp = scanBody(((SyntaxForm) (obj3)).getDatum(), scopeexp, flag);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        obj3 = (LList)SyntaxForms.fromDatumIfNeeded(scopeexp, ((SyntaxForm) (obj3)));
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        setCurrentScope(((ScopeExp) (obj2)));
        return ((LList) (obj3));
        ((Pair) (obj1)).setCdrBackdoor(obj3);
        setCurrentScope(((ScopeExp) (obj2)));
        return ((LList) (obj));
        formStack.add(wrapSyntax(popForms(i), ((SyntaxForm) (obj3))));
        setCurrentScope(((ScopeExp) (obj2)));
        return null;
        obj;
        setCurrentScope(((ScopeExp) (obj2)));
        throw obj;
        if (obj2 instanceof Pair)
        {
            Object obj5 = (Pair)obj2;
            int k = formStack.size();
            scanForm(((Pair) (obj5)).getCar(), scopeexp);
            if (getState() == 2)
            {
                obj = obj5;
                if (((Pair) (obj5)).getCar() != pendingForm)
                {
                    obj = makePair(((Pair) (obj5)), pendingForm, ((Pair) (obj5)).getCdr());
                }
                pendingForm = new Pair(begin.begin, obj);
                return LList.Empty;
            }
            int l = formStack.size();
            Object obj4 = obj1;
            obj2 = obj;
            if (flag)
            {
                int j = k;
                while (j < l) 
                {
                    obj2 = makePair(((Pair) (obj5)), formStack.elementAt(j), LList.Empty);
                    if (obj1 == null)
                    {
                        obj = obj2;
                    } else
                    {
                        ((Pair) (obj1)).setCdrBackdoor(obj2);
                    }
                    obj1 = obj2;
                    j++;
                }
                formStack.setSize(k);
                obj2 = obj;
                obj4 = obj1;
            }
            obj5 = ((Pair) (obj5)).getCdr();
            obj1 = obj4;
            obj = obj2;
            obj2 = obj5;
        } else
        {
            formStack.add(syntaxError("body is not a proper list"));
            return ((LList) (obj));
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void scanForm(Object obj, ScopeExp scopeexp)
    {
        if (!(obj instanceof SyntaxForm)) goto _L2; else goto _L1
_L1:
        Object obj1;
        obj1 = (SyntaxForm)obj;
        obj = currentScope();
        setCurrentScope(((SyntaxForm) (obj1)).getScope());
        int i = formStack.size();
        scanForm(((SyntaxForm) (obj1)).getDatum(), scopeexp);
        formStack.add(wrapSyntax(popForms(i), ((SyntaxForm) (obj1))));
        setCurrentScope(((ScopeExp) (obj)));
_L25:
        return;
        scopeexp;
        setCurrentScope(((ScopeExp) (obj)));
        throw scopeexp;
_L2:
        Object obj3 = obj;
        if (!(obj instanceof Values)) goto _L4; else goto _L3
_L3:
        if (obj != Values.empty) goto _L6; else goto _L5
_L5:
        obj3 = QuoteExp.voidExp;
_L4:
        Expression expression;
        Declaration declaration;
        Pair pair;
        ScopeExp scopeexp1;
        Object obj4;
        if (!(obj3 instanceof Pair))
        {
            break MISSING_BLOCK_LABEL_644;
        }
        pair = (Pair)obj3;
        declaration = macroContext;
        expression = null;
        scopeexp1 = current_scope;
        obj4 = pushPositionOf(obj3);
        if ((obj3 instanceof SourceLocator) && scopeexp.getLineNumber() < 0)
        {
            scopeexp.setLocation((SourceLocator)obj3);
        }
        obj = pair.getCar();
        obj1 = obj;
        if (obj instanceof SyntaxForm)
        {
            obj = (SyntaxForm)pair.getCar();
            setCurrentScope(((SyntaxForm) (obj)).getScope());
            obj1 = ((SyntaxForm) (obj)).getDatum();
        }
        Object obj2;
        obj = obj1;
        obj2 = expression;
        if (!(obj1 instanceof Pair)) goto _L8; else goto _L7
_L7:
        Object obj5 = (Pair)obj1;
        obj = obj1;
        obj2 = expression;
        if (((Pair) (obj5)).getCar() != LispLanguage.lookup_sym) goto _L8; else goto _L9
_L9:
        obj = obj1;
        obj2 = expression;
        if (!(((Pair) (obj5)).getCdr() instanceof Pair)) goto _L8; else goto _L10
_L10:
        obj5 = (Pair)((Pair) (obj5)).getCdr();
        obj = obj1;
        obj2 = expression;
        if (!(((Pair) (obj5)).getCdr() instanceof Pair)) goto _L8; else goto _L11
_L11:
        obj = rewrite(((Pair) (obj5)).getCar());
        obj1 = rewrite(((Pair)((Pair) (obj5)).getCdr()).getCar());
        obj2 = ((Expression) (obj)).valueIfConstant();
        obj5 = ((Expression) (obj1)).valueIfConstant();
        if (!(obj2 instanceof Class)) goto _L13; else goto _L12
_L12:
        boolean flag = obj5 instanceof Symbol;
        if (!flag) goto _L13; else goto _L14
_L14:
        obj1 = GetNamedPart.getNamedPart(obj2, (Symbol)obj5);
        obj = obj1;
        obj2 = expression;
        if (!(obj1 instanceof Syntax)) goto _L8; else goto _L15
_L15:
        obj2 = (Syntax)obj1;
        obj = obj1;
_L8:
        if (!(obj instanceof Symbol) || selfEvaluatingSymbol(obj)) goto _L17; else goto _L16
_L16:
        expression = rewrite(obj, true);
        obj1 = obj2;
        if (!(expression instanceof ReferenceExp)) goto _L19; else goto _L18
_L18:
        obj1 = ((ReferenceExp)expression).getBinding();
        if (obj1 == null) goto _L21; else goto _L20
_L20:
        obj1 = check_if_Syntax(((Declaration) (obj1)));
_L19:
        int j;
        int k;
        if (scopeexp1 != current_scope)
        {
            setCurrentScope(scopeexp1);
        }
        popPositionOf(obj4);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_644;
        }
        obj = getFileName();
        j = getLineNumber();
        k = getColumnNumber();
        setLine(pair);
        ((Syntax) (obj1)).scanForm(pair, scopeexp, this);
        macroContext = declaration;
        setLine(((String) (obj)), j, k);
        return;
_L6:
        obj = ((Object) (((Values)obj).getValues()));
        j = 0;
        while (j < obj.length) 
        {
            scanForm(obj[j], scopeexp);
            j++;
        }
        continue; /* Loop/switch isn't completed */
        obj;
        obj = null;
        obj2 = expression;
          goto _L8
_L13:
        obj = namespaceResolve(((Expression) (obj)), ((Expression) (obj1)));
        obj2 = expression;
          goto _L8
_L21:
        obj = resolve(obj, true);
        obj1 = obj2;
        if (!(obj instanceof Syntax)) goto _L19; else goto _L22
_L22:
        obj1 = (Syntax)obj;
          goto _L19
_L17:
        obj1 = obj2;
        if (obj != begin.begin) goto _L19; else goto _L23
_L23:
        obj1 = (Syntax)obj;
          goto _L19
        obj;
        if (scopeexp1 != current_scope)
        {
            setCurrentScope(scopeexp1);
        }
        popPositionOf(obj4);
        throw obj;
        scopeexp;
        macroContext = declaration;
        setLine(((String) (obj)), j, k);
        throw scopeexp;
        formStack.add(obj3);
        return;
        if (true) goto _L25; else goto _L24
_L24:
    }

    public final boolean selfEvaluatingSymbol(Object obj)
    {
        return ((LispLanguage)getLanguage()).selfEvaluatingSymbol(obj);
    }

    public void setLineOf(Expression expression)
    {
        if (expression instanceof QuoteExp)
        {
            return;
        } else
        {
            expression.setLocation(this);
            return;
        }
    }

    static 
    {
        getNamedPartDecl = Declaration.getDeclarationFromStatic("gnu.kawa.functions.GetNamedPart", "getNamedPart");
        LispLanguage.getNamedPartLocation.setDeclaration(getNamedPartDecl);
    }
}
