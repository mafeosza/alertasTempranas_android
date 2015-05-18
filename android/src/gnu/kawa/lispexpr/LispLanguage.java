// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.lispexpr;

import gnu.bytecode.Field;
import gnu.expr.ApplyExp;
import gnu.expr.BeginExp;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.Language;
import gnu.expr.ModuleExp;
import gnu.expr.NameLookup;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.Sequence;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.InPort;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.text.Lexer;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.IOException;
import kawa.lang.Syntax;
import kawa.lang.Translator;

// Referenced classes of package gnu.kawa.lispexpr:
//            LispReader, ReadTable

public abstract class LispLanguage extends Language
{

    public static final Symbol bracket_apply_sym;
    public static final Symbol bracket_list_sym;
    public static StaticFieldLocation getNamedPartLocation;
    public static final Symbol lookup_sym;
    public static final String quasiquote_sym = "quasiquote";
    public static final String quote_sym = "quote";
    public static final String unquote_sym = "unquote";
    public static final String unquotesplicing_sym = "unquote-splicing";
    public ReadTable defaultReadTable;

    public LispLanguage()
    {
        defaultReadTable = createReadTable();
    }

    public static Symbol langSymbolToSymbol(Object obj)
    {
        return ((LispLanguage)Language.getDefaultLanguage()).fromLangSymbol(obj);
    }

    public Expression checkDefaultBinding(Symbol symbol, Translator translator)
    {
        return null;
    }

    public abstract ReadTable createReadTable();

    public Declaration declFromField(ModuleExp moduleexp, Object obj, Field field)
    {
        moduleexp = super.declFromField(moduleexp, obj, field);
        boolean flag;
        if ((field.getModifiers() & 0x10) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && (obj instanceof Syntax))
        {
            moduleexp.setSyntax();
        }
        return moduleexp;
    }

    protected void defSntxStFld(String s, String s1)
    {
        defSntxStFld(s, s1, Compilation.mangleNameIfNeeded(s));
    }

    protected void defSntxStFld(String s, String s1, String s2)
    {
        Object obj;
        if (hasSeparateFunctionNamespace())
        {
            obj = EnvironmentKey.FUNCTION;
        } else
        {
            obj = null;
        }
        StaticFieldLocation.define(environ, environ.getSymbol(s), obj, s1, s2).setSyntax();
    }

    protected Symbol fromLangSymbol(Object obj)
    {
        if (obj instanceof String)
        {
            return getSymbol((String)obj);
        } else
        {
            return (Symbol)obj;
        }
    }

    public Compilation getCompilation(Lexer lexer, SourceMessages sourcemessages, NameLookup namelookup)
    {
        return new Translator(this, sourcemessages, namelookup);
    }

    public Lexer getLexer(InPort inport, SourceMessages sourcemessages)
    {
        return new LispReader(inport, sourcemessages);
    }

    public Expression makeApply(Expression expression, Expression aexpression[])
    {
        return new ApplyExp(expression, aexpression);
    }

    public Expression makeBody(Expression aexpression[])
    {
        return new BeginExp(aexpression);
    }

    public boolean parse(Compilation compilation, int i)
        throws IOException, SyntaxException
    {
        Object obj;
        Lexer lexer;
        ModuleExp moduleexp;
        LispReader lispreader;
        obj = (Translator)compilation;
        lexer = ((Translator) (obj)).lexer;
        moduleexp = ((Translator) (obj)).mainLambda;
        new Values();
        lispreader = (LispReader)lexer;
        compilation = Compilation.setSaveCurrent(((Compilation) (obj)));
        if (((Translator) (obj)).pendingForm != null)
        {
            ((Translator) (obj)).scanForm(((Translator) (obj)).pendingForm, moduleexp);
            obj.pendingForm = null;
        }
_L6:
        Object obj1;
        Object obj2;
        obj1 = lispreader.readCommand();
        obj2 = Sequence.eofValue;
        if (obj1 != obj2) goto _L2; else goto _L1
_L1:
        if ((i & 4) != 0)
        {
            Compilation.restoreCurrent(compilation);
            return false;
        }
          goto _L3
_L2:
        ((Translator) (obj)).scanForm(obj1, moduleexp);
        if ((i & 4) == 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!((Translator) (obj)).getMessages().seenErrors()) goto _L3; else goto _L4
_L4:
        int j = lispreader.peek();
        if (j >= 0 && j != 13 && j != 10)
        {
            break MISSING_BLOCK_LABEL_186;
        }
_L3:
        if (lexer.peek() == 41)
        {
            lexer.fatal("An unexpected close paren was read.");
        }
        ((Translator) (obj)).finishModule(moduleexp);
        if ((i & 8) != 0)
        {
            break MISSING_BLOCK_LABEL_175;
        }
        obj.firstForm = 0;
        ((Translator) (obj)).setState(4);
        Compilation.restoreCurrent(compilation);
        return true;
        lispreader.skip();
          goto _L4
        obj;
        Compilation.restoreCurrent(compilation);
        throw obj;
        if ((i & 8) == 0) goto _L6; else goto _L5
_L5:
        j = ((Translator) (obj)).getState();
        if (j >= 2)
        {
            Compilation.restoreCurrent(compilation);
            return true;
        }
          goto _L6
    }

    public void resolve(Compilation compilation)
    {
        compilation = (Translator)compilation;
        compilation.resolveModule(compilation.getModule());
    }

    public boolean selfEvaluatingSymbol(Object obj)
    {
        return obj instanceof Keyword;
    }

    static 
    {
        lookup_sym = Namespace.EmptyNamespace.getSymbol("$lookup$");
        bracket_list_sym = Namespace.EmptyNamespace.getSymbol("$bracket-list$");
        bracket_apply_sym = Namespace.EmptyNamespace.getSymbol("$bracket-apply$");
        getNamedPartLocation = new StaticFieldLocation("gnu.kawa.functions.GetNamedPart", "getNamedPart");
        getNamedPartLocation.setProcedure();
    }
}
