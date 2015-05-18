// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.bytecode.Type;
import gnu.expr.Language;
import gnu.kawa.functions.DisplayFormat;
import gnu.kawa.functions.IsEq;
import gnu.kawa.functions.IsEqual;
import gnu.kawa.functions.Not;
import gnu.kawa.functions.NumberCompare;
import gnu.kawa.lispexpr.LangPrimType;
import gnu.kawa.reflect.InstanceOf;
import gnu.lists.AbstractFormat;
import gnu.mapping.Environment;
import gnu.mapping.LocationEnumeration;
import gnu.math.IntNum;
import gnu.math.Numeric;
import gnu.text.Char;
import kawa.lang.Lambda;
import kawa.standard.Scheme;
import kawa.standard.begin;

// Referenced classes of package gnu.commonlisp.lang:
//            Lisp2, defun, defvar, function, 
//            setq, prog1, UnwindProtect

public class CommonLisp extends Lisp2
{

    static boolean charIsInt;
    public static final Environment clispEnvironment;
    static final AbstractFormat displayFormat;
    public static final CommonLisp instance;
    public static final NumberCompare numEqu;
    public static final NumberCompare numGEq;
    public static final NumberCompare numGrt;
    public static final NumberCompare numLEq;
    public static final NumberCompare numLss;
    static final AbstractFormat writeFormat;
    LangPrimType booleanType;

    public CommonLisp()
    {
        environ = clispEnvironment;
    }

    public static char asChar(Object obj)
    {
        if (obj instanceof Char)
        {
            return ((Char)obj).charValue();
        }
        int i;
        if (obj instanceof Numeric)
        {
            i = ((Numeric)obj).intValue();
        } else
        {
            i = -1;
        }
        if (i < 0 || i > 65535)
        {
            throw new ClassCastException("not a character value");
        } else
        {
            return (char)i;
        }
    }

    public static Numeric asNumber(Object obj)
    {
        if (obj instanceof Char)
        {
            return IntNum.make(((Char)obj).intValue());
        } else
        {
            return (Numeric)obj;
        }
    }

    public static Object getCharacter(int i)
    {
        if (charIsInt)
        {
            return IntNum.make(i);
        } else
        {
            return Char.make((char)i);
        }
    }

    public static CommonLisp getInstance()
    {
        return instance;
    }

    public static void registerEnvironment()
    {
        Language.setDefaults(instance);
    }

    public AbstractFormat getFormat(boolean flag)
    {
        if (flag)
        {
            return writeFormat;
        } else
        {
            return displayFormat;
        }
    }

    public String getName()
    {
        return "CommonLisp";
    }

    public Type getTypeFor(Class class1)
    {
        if (class1.isPrimitive())
        {
            class1 = class1.getName();
            if (class1.equals("boolean"))
            {
                if (booleanType == null)
                {
                    booleanType = new LangPrimType(Type.booleanType, this);
                }
                return booleanType;
            } else
            {
                return Scheme.getNamedType(class1);
            }
        } else
        {
            return Type.make(class1);
        }
    }

    public Type getTypeFor(String s)
    {
        String s1 = s;
        if (s == "t")
        {
            s1 = "java.lang.Object";
        }
        return Scheme.string2Type(s1);
    }

    void initLisp()
    {
        for (LocationEnumeration locationenumeration = Scheme.builtin().enumerateAllLocations(); locationenumeration.hasMoreElements(); importLocation(locationenumeration.nextLocation())) { }
        Object obj;
        try
        {
            loadClass("kawa.lib.prim_syntax");
            loadClass("kawa.lib.std_syntax");
            loadClass("kawa.lib.lists");
            loadClass("kawa.lib.strings");
            loadClass("gnu.commonlisp.lisp.PrimOps");
        }
        catch (ClassNotFoundException classnotfoundexception) { }
        obj = new Lambda();
        ((Lambda) (obj)).setKeywords(asSymbol("&optional"), asSymbol("&rest"), asSymbol("&key"));
        obj.defaultDefault = nilExpr;
        defun("lambda", obj);
        defun("defun", new defun(((Lambda) (obj))));
        defun("defvar", new defvar(false));
        defun("defconst", new defvar(true));
        defun("defsubst", new defun(((Lambda) (obj))));
        defun("function", new function(((kawa.lang.Syntax) (obj))));
        defun("setq", new setq());
        defun("prog1", new prog1("prog1", 1));
        defun("prog2", prog1.prog2);
        defun("progn", new begin());
        defun("unwind-protect", new UnwindProtect());
        obj = new Not(this);
        defun("not", obj);
        defun("null", obj);
        defun("eq", new IsEq(this, "eq"));
        defun("equal", new IsEqual(this, "equal"));
        defun("typep", new InstanceOf(this));
        defun("princ", displayFormat);
        defun("prin1", writeFormat);
        defProcStFld("=", "gnu.commonlisp.lang.CommonLisp", "numEqu");
        defProcStFld("<", "gnu.commonlisp.lang.CommonLisp", "numLss");
        defProcStFld(">", "gnu.commonlisp.lang.CommonLisp", "numGrt");
        defProcStFld("<=", "gnu.commonlisp.lang.CommonLisp", "numLEq");
        defProcStFld(">=", "gnu.commonlisp.lang.CommonLisp", "numGEq");
        defProcStFld("functionp", "gnu.commonlisp.lisp.PrimOps");
    }

    static 
    {
        Environment environment;
        charIsInt = false;
        clispEnvironment = Environment.make("clisp-environment");
        instance = new CommonLisp();
        instance.define("t", TRUE);
        instance.define("nil", FALSE);
        numEqu = NumberCompare.make(instance, "=", 8);
        numGrt = NumberCompare.make(instance, ">", 16);
        numGEq = NumberCompare.make(instance, ">=", 24);
        numLss = NumberCompare.make(instance, "<", 4);
        numLEq = NumberCompare.make(instance, "<=", 12);
        environment = Environment.setSaveCurrent(clispEnvironment);
        instance.initLisp();
        Environment.restoreCurrent(environment);
        writeFormat = new DisplayFormat(true, 'C');
        displayFormat = new DisplayFormat(false, 'C');
        return;
        Exception exception;
        exception;
        Environment.restoreCurrent(environment);
        throw exception;
    }
}
