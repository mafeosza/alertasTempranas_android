// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.Expression;
import gnu.expr.Keyword;
import gnu.expr.QuoteExp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.lispexpr.LispLanguage;
import gnu.kawa.lispexpr.ReadTable;
import gnu.kawa.reflect.FieldLocation;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Location;
import gnu.mapping.Named;
import gnu.mapping.NamedLocation;
import gnu.mapping.Namespace;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import java.lang.reflect.Field;
import kawa.lang.Syntax;

// Referenced classes of package gnu.commonlisp.lang:
//            Lisp2ReadTable

public abstract class Lisp2 extends LispLanguage
{

    public static final LList FALSE;
    public static final Symbol TRUE = Namespace.getDefault().getSymbol("t");
    public static final Expression nilExpr;

    public Lisp2()
    {
    }

    public static Object asSymbol(String s)
    {
        if (s == "nil")
        {
            return FALSE;
        } else
        {
            return Environment.getCurrent().getSymbol(s);
        }
    }

    private void defun(Procedure procedure)
    {
        defun(procedure.getName(), procedure);
    }

    public static Object getString(Symbol symbol)
    {
        return getString(symbol.getName());
    }

    public static Object getString(String s)
    {
        return new FString(s);
    }

    public Object booleanObject(boolean flag)
    {
        if (flag)
        {
            return TRUE;
        } else
        {
            return FALSE;
        }
    }

    public ReadTable createReadTable()
    {
        Lisp2ReadTable lisp2readtable = new Lisp2ReadTable();
        lisp2readtable.initialize();
        lisp2readtable.setInitialColonIsKeyword(true);
        return lisp2readtable;
    }

    protected void defun(Symbol symbol, Object obj)
    {
        environ.define(symbol, EnvironmentKey.FUNCTION, obj);
        if (obj instanceof Procedure)
        {
            obj = (Procedure)obj;
            if (((Procedure) (obj)).getSymbol() == null)
            {
                ((Procedure) (obj)).setSymbol(symbol);
            }
        }
    }

    protected void defun(String s, Object obj)
    {
        environ.define(getSymbol(s), EnvironmentKey.FUNCTION, obj);
        if (obj instanceof Named)
        {
            obj = (Named)obj;
            if (((Named) (obj)).getName() == null)
            {
                ((Named) (obj)).setName(s);
            }
        }
    }

    public void emitPushBoolean(boolean flag, CodeAttr codeattr)
    {
        if (flag)
        {
            codeattr.emitGetStatic(ClassType.make("gnu.commonlisp.lang.Lisp2").getDeclaredField("TRUE"));
            return;
        } else
        {
            codeattr.emitGetStatic(Compilation.scmListType.getDeclaredField("Empty"));
            return;
        }
    }

    protected Symbol fromLangSymbol(Object obj)
    {
        if (obj == LList.Empty)
        {
            return environ.getSymbol("nil");
        } else
        {
            return super.fromLangSymbol(obj);
        }
    }

    public Object getEnvPropertyFor(Field field, Object obj)
    {
        if (Compilation.typeProcedure.getReflectClass().isAssignableFrom(field.getType()) || (obj instanceof Syntax))
        {
            return EnvironmentKey.FUNCTION;
        } else
        {
            return null;
        }
    }

    public int getNamespaceOf(Declaration declaration)
    {
        if (declaration.isAlias())
        {
            return 3;
        }
        return !declaration.isProcedureDecl() ? 1 : 2;
    }

    public boolean hasSeparateFunctionNamespace()
    {
        return true;
    }

    protected void importLocation(Location location)
    {
        Symbol symbol = ((NamedLocation)location).getKeySymbol();
        if (!environ.isBound(symbol, EnvironmentKey.FUNCTION))
        {
            location = location.getBase();
            if ((location instanceof FieldLocation) && ((FieldLocation)location).isProcedureOrSyntax())
            {
                environ.addLocation(symbol, EnvironmentKey.FUNCTION, location);
                return;
            }
            location = ((Location) (location.get(null)));
            if (location != null)
            {
                if ((location instanceof Procedure) || (location instanceof Syntax))
                {
                    defun(symbol, location);
                    return;
                }
                if (location instanceof LangObjType)
                {
                    defun(symbol, ((LangObjType)location).getConstructor());
                    return;
                } else
                {
                    define(symbol.getName(), location);
                    return;
                }
            }
        }
    }

    public boolean isTrue(Object obj)
    {
        return obj != FALSE;
    }

    public Object noValue()
    {
        return FALSE;
    }

    public boolean selfEvaluatingSymbol(Object obj)
    {
        return (obj instanceof Keyword) || obj == TRUE || obj == FALSE;
    }

    static 
    {
        FALSE = LList.Empty;
        nilExpr = new QuoteExp(FALSE);
    }
}
