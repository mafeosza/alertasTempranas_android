// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lisp;

import gnu.commonlisp.lang.CommonLisp;
import gnu.commonlisp.lang.Lisp2;
import gnu.commonlisp.lang.Symbols;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.Apply;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.lists.SimpleVector;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertyLocation;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class PrimOps extends ModuleBody
{

    public static final PrimOps $instance;
    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("t")).readResolve();
    static final IntNum Lit1 = IntNum.make(0);
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SimpleSymbol Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SimpleSymbol Lit19;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24;
    static final SimpleSymbol Lit25;
    static final SimpleSymbol Lit26;
    static final SimpleSymbol Lit27;
    static final SimpleSymbol Lit28;
    static final SimpleSymbol Lit29;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit30;
    static final SimpleSymbol Lit31;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod apply;
    public static final ModuleMethod aref;
    public static final ModuleMethod arrayp;
    public static final ModuleMethod aset;
    public static final ModuleMethod boundp;
    public static final ModuleMethod car;
    public static final ModuleMethod cdr;
    public static final ModuleMethod char$Mnto$Mnstring;
    public static final ModuleMethod fillarray;
    public static final ModuleMethod fset;
    public static final ModuleMethod functionp;
    public static final ModuleMethod get;
    public static final ModuleMethod length;
    public static final ModuleMethod make$Mnstring;
    public static final ModuleMethod plist$Mnget;
    public static final ModuleMethod plist$Mnmember;
    public static final ModuleMethod plist$Mnput;
    public static final ModuleMethod plist$Mnremprop;
    public static final ModuleMethod put;
    public static final ModuleMethod set;
    public static final ModuleMethod setcar;
    public static final ModuleMethod setcdr;
    public static final ModuleMethod setplist;
    public static final ModuleMethod stringp;
    public static final ModuleMethod substring;
    public static final ModuleMethod symbol$Mnfunction;
    public static final ModuleMethod symbol$Mnname;
    public static final ModuleMethod symbol$Mnplist;
    public static final ModuleMethod symbol$Mnvalue;
    public static final ModuleMethod symbolp;

    public PrimOps()
    {
        ModuleInfo.register(this);
    }

    public static transient Object apply(Object obj, Object aobj[])
    {
        if (misc.isSymbol(obj))
        {
            obj = (Procedure)symbolFunction(obj);
        } else
        {
            obj = (Procedure)obj;
        }
        return ((Procedure) (obj)).applyN(Apply.getArguments(aobj, 0, apply));
    }

    public static Object aref(SimpleVector simplevector, int i)
    {
        return simplevector.get(i);
    }

    public static boolean arrayp(Object obj)
    {
        return obj instanceof SimpleVector;
    }

    public static Object aset(SimpleVector simplevector, int i, Object obj)
    {
        simplevector.set(i, obj);
        return obj;
    }

    public static boolean boundp(Object obj)
    {
        return Symbols.isBound(obj);
    }

    public static Object car(Object obj)
    {
        if (obj == LList.Empty)
        {
            return obj;
        } else
        {
            return ((Pair)obj).getCar();
        }
    }

    public static Object cdr(Object obj)
    {
        if (obj == LList.Empty)
        {
            return obj;
        } else
        {
            return ((Pair)obj).getCdr();
        }
    }

    public static FString charToString(Object obj)
    {
        return new FString(1, CommonLisp.asChar(obj));
    }

    public static Object fillarray(SimpleVector simplevector, Object obj)
    {
        simplevector.fill(obj);
        return obj;
    }

    public static void fset(Object obj, Object obj1)
    {
        Symbols.setFunctionBinding(Environment.getCurrent(), obj, obj1);
    }

    public static boolean functionp(Object obj)
    {
        return obj instanceof Procedure;
    }

    public static Object get(Symbol symbol, Object obj)
    {
        return get(symbol, obj, LList.Empty);
    }

    public static Object get(Symbol symbol, Object obj, Object obj1)
    {
        return PropertyLocation.getProperty(symbol, obj, obj1);
    }

    public static int length(Sequence sequence)
    {
        return sequence.size();
    }

    public static FString makeString(int i, Object obj)
    {
        return new FString(i, CommonLisp.asChar(obj));
    }

    public static Object plistGet(Object obj, Object obj1)
    {
        return plistGet(obj, obj1, Boolean.FALSE);
    }

    public static Object plistGet(Object obj, Object obj1, Object obj2)
    {
        return PropertyLocation.plistGet(obj, obj1, obj2);
    }

    public static Object plistMember(Object obj, Object obj1)
    {
        if (PropertyLocation.plistGet(obj, obj1, Values.empty) == Values.empty)
        {
            return LList.Empty;
        } else
        {
            return Lit0;
        }
    }

    public static Object plistPut(Object obj, Object obj1, Object obj2)
    {
        return PropertyLocation.plistPut(obj, obj1, obj2);
    }

    public static Object plistRemprop(Object obj, Object obj1)
    {
        return PropertyLocation.plistRemove(obj, obj1);
    }

    public static void put(Object obj, Object obj1, Object obj2)
    {
        PropertyLocation.putProperty(obj, obj1, obj2);
    }

    public static void set(Object obj, Object obj1)
    {
        Environment.getCurrent().put(Symbols.getSymbol(obj), obj1);
    }

    public static void setcar(Pair pair, Object obj)
    {
        lists.setCar$Ex(pair, obj);
    }

    public static void setcdr(Pair pair, Object obj)
    {
        lists.setCdr$Ex(pair, obj);
    }

    public static Object setplist(Object obj, Object obj1)
    {
        PropertyLocation.setPropertyList(obj, obj1);
        return obj1;
    }

    public static boolean stringp(Object obj)
    {
        return obj instanceof CharSequence;
    }

    public static FString substring(CharSequence charsequence, Object obj)
    {
        return substring(charsequence, obj, LList.Empty);
    }

    public static FString substring(CharSequence charsequence, Object obj, Object obj1)
    {
        Object obj2 = obj1;
        if (obj1 == LList.Empty)
        {
            obj2 = Integer.valueOf(strings.stringLength(charsequence));
        }
        obj1 = obj2;
        if (Scheme.numLss.apply2(obj2, Lit1) != Boolean.FALSE)
        {
            obj1 = AddOp.$Mn.apply2(Integer.valueOf(strings.stringLength(charsequence)), obj2);
        }
        obj2 = obj;
        if (Scheme.numLss.apply2(obj, Lit1) != Boolean.FALSE)
        {
            obj2 = AddOp.$Mn.apply2(Integer.valueOf(strings.stringLength(charsequence)), obj);
        }
        return new FString(charsequence, ((Number)obj2).intValue(), ((Number)AddOp.$Mn.apply2(obj1, obj2)).intValue());
    }

    public static Object symbolFunction(Object obj)
    {
        return Symbols.getFunctionBinding(obj);
    }

    public static Object symbolName(Object obj)
    {
        return Symbols.getPrintName(obj);
    }

    public static Object symbolPlist(Object obj)
    {
        return PropertyLocation.getPropertyList(obj);
    }

    public static Object symbolValue(Object obj)
    {
        return Environment.getCurrent().get(Symbols.getSymbol(obj));
    }

    public static boolean symbolp(Object obj)
    {
        return Symbols.isSymbol(obj);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            return car(obj);

        case 2: // '\002'
            return cdr(obj);

        case 5: // '\005'
            if (boundp(obj))
            {
                return Lisp2.TRUE;
            } else
            {
                return LList.Empty;
            }

        case 6: // '\006'
            if (symbolp(obj))
            {
                return Lisp2.TRUE;
            } else
            {
                return LList.Empty;
            }

        case 7: // '\007'
            return symbolName(obj);

        case 8: // '\b'
            return symbolPlist(obj);

        case 18: // '\022'
            return symbolValue(obj);

        case 20: // '\024'
            return symbolFunction(obj);

        case 23: // '\027'
            try
            {
                modulemethod = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "length", 1, obj);
            }
            return Integer.valueOf(length(modulemethod));

        case 24: // '\030'
            if (arrayp(obj))
            {
                return Lisp2.TRUE;
            } else
            {
                return LList.Empty;
            }

        case 28: // '\034'
            if (stringp(obj))
            {
                return Lisp2.TRUE;
            } else
            {
                return LList.Empty;
            }

        case 32: // ' '
            return charToString(obj);

        case 33: // '!'
            break;
        }
        if (functionp(obj))
        {
            return Lisp2.TRUE;
        } else
        {
            return LList.Empty;
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 11: // '\013'
        case 12: // '\f'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 26: // '\032'
        case 28: // '\034'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 3: // '\003'
            int i;
            try
            {
                modulemethod = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "setcar", 1, obj);
            }
            setcar(modulemethod, obj1);
            return Values.empty;

        case 4: // '\004'
            try
            {
                modulemethod = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "setcdr", 1, obj);
            }
            setcdr(modulemethod, obj1);
            return Values.empty;

        case 9: // '\t'
            return setplist(obj, obj1);

        case 10: // '\n'
            return plistGet(obj, obj1);

        case 13: // '\r'
            return plistRemprop(obj, obj1);

        case 14: // '\016'
            return plistMember(obj, obj1);

        case 15: // '\017'
            try
            {
                modulemethod = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "get", 1, obj);
            }
            return get(modulemethod, obj1);

        case 19: // '\023'
            set(obj, obj1);
            return Values.empty;

        case 21: // '\025'
            fset(obj, obj1);
            return Values.empty;

        case 25: // '\031'
            try
            {
                modulemethod = (SimpleVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "aref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "aref", 2, obj1);
            }
            return aref(modulemethod, i);

        case 27: // '\033'
            try
            {
                modulemethod = (SimpleVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "fillarray", 1, obj);
            }
            return fillarray(modulemethod, obj1);

        case 29: // '\035'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-string", 1, obj);
            }
            return makeString(i, obj1);

        case 30: // '\036'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "substring", 1, obj);
        }
        return substring(modulemethod, obj1);
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 10: // '\n'
            return plistGet(obj, obj1, obj2);

        case 12: // '\f'
            return plistPut(obj, obj1, obj2);

        case 15: // '\017'
            int i;
            try
            {
                modulemethod = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "get", 1, obj);
            }
            return get(modulemethod, obj1, obj2);

        case 17: // '\021'
            put(obj, obj1, obj2);
            return Values.empty;

        case 26: // '\032'
            try
            {
                modulemethod = (SimpleVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "aset", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "aset", 2, obj1);
            }
            return aset(modulemethod, i, obj2);

        case 30: // '\036'
            break;
        }
        try
        {
            modulemethod = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "substring", 1, obj);
        }
        return substring(modulemethod, obj1, obj2);
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        if (modulemethod.selector == 22)
        {
            modulemethod = ((ModuleMethod) (aobj[0]));
            int i = aobj.length - 1;
            Object aobj1[] = new Object[i];
            do
            {
                i--;
                if (i < 0)
                {
                    return apply(modulemethod, aobj1);
                }
                aobj1[i] = aobj[i + 1];
            } while (true);
        } else
        {
            return super.applyN(modulemethod, aobj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 33: // '!'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 32: // ' '
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 28: // '\034'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 24: // '\030'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 23: // '\027'
            if (!(obj instanceof Sequence))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 20: // '\024'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 18: // '\022'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 8: // '\b'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 7: // '\007'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 5: // '\005'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 11: // '\013'
        case 12: // '\f'
        case 16: // '\020'
        case 17: // '\021'
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        case 23: // '\027'
        case 24: // '\030'
        case 26: // '\032'
        case 28: // '\034'
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 30: // '\036'
            if (obj instanceof CharSequence)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 29: // '\035'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 27: // '\033'
            if (!(obj instanceof SimpleVector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 25: // '\031'
            if (!(obj instanceof SimpleVector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 21: // '\025'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 19: // '\023'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 15: // '\017'
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 14: // '\016'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 13: // '\r'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 9: // '\t'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 4: // '\004'
            if (!(obj instanceof Pair))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }

        case 3: // '\003'
            break;
        }
        if (!(obj instanceof Pair))
        {
            return 0xfff40001;
        } else
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 30: // '\036'
            if (obj instanceof CharSequence)
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 26: // '\032'
            if (!(obj instanceof SimpleVector))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            }

        case 17: // '\021'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 15: // '\017'
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            }

        case 12: // '\f'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        if (modulemethod.selector == 22)
        {
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        } else
        {
            return super.matchN(modulemethod, aobj, callcontext);
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit31 = (SimpleSymbol)(new SimpleSymbol("functionp")).readResolve();
        Lit30 = (SimpleSymbol)(new SimpleSymbol("char-to-string")).readResolve();
        Lit29 = (SimpleSymbol)(new SimpleSymbol("substring")).readResolve();
        Lit28 = (SimpleSymbol)(new SimpleSymbol("make-string")).readResolve();
        Lit27 = (SimpleSymbol)(new SimpleSymbol("stringp")).readResolve();
        Lit26 = (SimpleSymbol)(new SimpleSymbol("fillarray")).readResolve();
        Lit25 = (SimpleSymbol)(new SimpleSymbol("aset")).readResolve();
        Lit24 = (SimpleSymbol)(new SimpleSymbol("aref")).readResolve();
        Lit23 = (SimpleSymbol)(new SimpleSymbol("arrayp")).readResolve();
        Lit22 = (SimpleSymbol)(new SimpleSymbol("length")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("apply")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("fset")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("symbol-function")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("set")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("symbol-value")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("put")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("get")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("plist-member")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("plist-remprop")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("plist-put")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("plist-get")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("setplist")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("symbol-plist")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("symbol-name")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("symbolp")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("boundp")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("setcdr")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("setcar")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("cdr")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("car")).readResolve();
        $instance = new PrimOps();
        PrimOps primops = $instance;
        car = new ModuleMethod(primops, 1, Lit2, 4097);
        cdr = new ModuleMethod(primops, 2, Lit3, 4097);
        setcar = new ModuleMethod(primops, 3, Lit4, 8194);
        setcdr = new ModuleMethod(primops, 4, Lit5, 8194);
        boundp = new ModuleMethod(primops, 5, Lit6, 4097);
        symbolp = new ModuleMethod(primops, 6, Lit7, 4097);
        symbol$Mnname = new ModuleMethod(primops, 7, Lit8, 4097);
        symbol$Mnplist = new ModuleMethod(primops, 8, Lit9, 4097);
        setplist = new ModuleMethod(primops, 9, Lit10, 8194);
        plist$Mnget = new ModuleMethod(primops, 10, Lit11, 12290);
        plist$Mnput = new ModuleMethod(primops, 12, Lit12, 12291);
        plist$Mnremprop = new ModuleMethod(primops, 13, Lit13, 8194);
        plist$Mnmember = new ModuleMethod(primops, 14, Lit14, 8194);
        get = new ModuleMethod(primops, 15, Lit15, 12290);
        put = new ModuleMethod(primops, 17, Lit16, 12291);
        symbol$Mnvalue = new ModuleMethod(primops, 18, Lit17, 4097);
        set = new ModuleMethod(primops, 19, Lit18, 8194);
        symbol$Mnfunction = new ModuleMethod(primops, 20, Lit19, 4097);
        fset = new ModuleMethod(primops, 21, Lit20, 8194);
        apply = new ModuleMethod(primops, 22, Lit21, -4095);
        length = new ModuleMethod(primops, 23, Lit22, 4097);
        arrayp = new ModuleMethod(primops, 24, Lit23, 4097);
        aref = new ModuleMethod(primops, 25, Lit24, 8194);
        aset = new ModuleMethod(primops, 26, Lit25, 12291);
        fillarray = new ModuleMethod(primops, 27, Lit26, 8194);
        stringp = new ModuleMethod(primops, 28, Lit27, 4097);
        make$Mnstring = new ModuleMethod(primops, 29, Lit28, 8194);
        substring = new ModuleMethod(primops, 30, Lit29, 12290);
        char$Mnto$Mnstring = new ModuleMethod(primops, 32, Lit30, 4097);
        functionp = new ModuleMethod(primops, 33, Lit31, 4097);
        $instance.run();
    }
}
