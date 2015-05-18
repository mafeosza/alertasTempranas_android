// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.reflect.SlotSet;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.standard.Scheme;

public class lists extends ModuleBody
{

    public static final Location $Prvt$define$Mnprocedure = StaticFieldLocation.make("kawa.lib.std_syntax", "define$Mnprocedure");
    public static final lists $instance;
    static final Keyword Lit0 = Keyword.make("setter");
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("car")).readResolve();
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
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("cdr")).readResolve();
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod assoc;
    public static final ModuleMethod assq;
    public static final ModuleMethod assv;
    public static final GenericProc caaaar;
    static final ModuleMethod caaaar$Fn28;
    public static final GenericProc caaadr;
    static final ModuleMethod caaadr$Fn30;
    public static final GenericProc caaar;
    static final ModuleMethod caaar$Fn12;
    public static final GenericProc caadar;
    static final ModuleMethod caadar$Fn32;
    public static final GenericProc caaddr;
    static final ModuleMethod caaddr$Fn34;
    public static final GenericProc caadr;
    static final ModuleMethod caadr$Fn14;
    public static final GenericProc caar;
    static final ModuleMethod caar$Fn4;
    public static final GenericProc cadaar;
    static final ModuleMethod cadaar$Fn36;
    public static final GenericProc cadadr;
    static final ModuleMethod cadadr$Fn38;
    public static final GenericProc cadar;
    static final ModuleMethod cadar$Fn16;
    public static final GenericProc caddar;
    static final ModuleMethod caddar$Fn40;
    public static final GenericProc cadddr;
    static final ModuleMethod cadddr$Fn42;
    public static final GenericProc caddr;
    static final ModuleMethod caddr$Fn18;
    public static final GenericProc cadr;
    static final ModuleMethod cadr$Fn6;
    public static final GenericProc car;
    static final ModuleMethod car$Fn1;
    public static final GenericProc cdaaar;
    static final ModuleMethod cdaaar$Fn44;
    public static final GenericProc cdaadr;
    static final ModuleMethod cdaadr$Fn46;
    public static final GenericProc cdaar;
    static final ModuleMethod cdaar$Fn20;
    public static final GenericProc cdadar;
    static final ModuleMethod cdadar$Fn48;
    public static final GenericProc cdaddr;
    static final ModuleMethod cdaddr$Fn50;
    public static final GenericProc cdadr;
    static final ModuleMethod cdadr$Fn22;
    public static final GenericProc cdar;
    static final ModuleMethod cdar$Fn8;
    public static final GenericProc cddaar;
    static final ModuleMethod cddaar$Fn52;
    public static final GenericProc cddadr;
    static final ModuleMethod cddadr$Fn54;
    public static final GenericProc cddar;
    static final ModuleMethod cddar$Fn24;
    public static final GenericProc cdddar;
    static final ModuleMethod cdddar$Fn56;
    public static final GenericProc cddddr;
    static final ModuleMethod cddddr$Fn58;
    public static final GenericProc cdddr;
    static final ModuleMethod cdddr$Fn26;
    public static final GenericProc cddr;
    static final ModuleMethod cddr$Fn10;
    public static final GenericProc cdr;
    static final ModuleMethod cdr$Fn2;
    public static final ModuleMethod cons;
    static final ModuleMethod lambda$Fn11;
    static final ModuleMethod lambda$Fn13;
    static final ModuleMethod lambda$Fn15;
    static final ModuleMethod lambda$Fn17;
    static final ModuleMethod lambda$Fn19;
    static final ModuleMethod lambda$Fn21;
    static final ModuleMethod lambda$Fn23;
    static final ModuleMethod lambda$Fn25;
    static final ModuleMethod lambda$Fn27;
    static final ModuleMethod lambda$Fn29;
    static final ModuleMethod lambda$Fn3;
    static final ModuleMethod lambda$Fn31;
    static final ModuleMethod lambda$Fn33;
    static final ModuleMethod lambda$Fn35;
    static final ModuleMethod lambda$Fn37;
    static final ModuleMethod lambda$Fn39;
    static final ModuleMethod lambda$Fn41;
    static final ModuleMethod lambda$Fn43;
    static final ModuleMethod lambda$Fn45;
    static final ModuleMethod lambda$Fn47;
    static final ModuleMethod lambda$Fn49;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn51;
    static final ModuleMethod lambda$Fn53;
    static final ModuleMethod lambda$Fn55;
    static final ModuleMethod lambda$Fn57;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn9;
    public static final ModuleMethod length;
    public static final ModuleMethod list$Mnref;
    public static final ModuleMethod list$Mntail;
    public static final ModuleMethod list$Qu;
    public static final ModuleMethod member;
    public static final ModuleMethod memq;
    public static final ModuleMethod memv;
    public static final ModuleMethod null$Qu;
    public static final ModuleMethod pair$Qu;
    public static final ModuleMethod reverse;
    public static final ModuleMethod reverse$Ex;
    public static final ModuleMethod set$Mncar$Ex;
    public static final ModuleMethod set$Mncdr$Ex;

    public lists()
    {
        ModuleInfo.register(this);
    }

    public static Object assoc(Object obj, Object obj1)
    {
        return assoc(obj, obj1, ((Procedure) (Scheme.isEqual)));
    }

    public static Object assoc(Object obj, Object obj1, Procedure procedure)
    {
_L6:
        if (obj1 != LList.Empty) goto _L2; else goto _L1
_L1:
        Object obj2 = Boolean.FALSE;
_L4:
        return obj2;
_L2:
        obj2 = car.apply1(obj1);
        Pair pair;
        try
        {
            pair = (Pair)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "pair", -2, obj2);
        }
        obj2 = pair;
        if (procedure.apply2(pair.getCar(), obj) != Boolean.FALSE) goto _L4; else goto _L3
_L3:
        obj1 = cdr.apply1(obj1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object assq(Object obj, Object obj1)
    {
_L6:
        if (obj1 != LList.Empty) goto _L2; else goto _L1
_L1:
        Object obj2 = Boolean.FALSE;
_L4:
        return obj2;
_L2:
        obj2 = car.apply1(obj1);
        Pair pair;
        try
        {
            pair = (Pair)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "pair", -2, obj2);
        }
        obj2 = pair;
        if (pair.getCar() == obj) goto _L4; else goto _L3
_L3:
        obj1 = cdr.apply1(obj1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Object assv(Object obj, Object obj1)
    {
_L6:
        if (obj1 != LList.Empty) goto _L2; else goto _L1
_L1:
        Object obj2 = Boolean.FALSE;
_L4:
        return obj2;
_L2:
        obj2 = car.apply1(obj1);
        Pair pair;
        try
        {
            pair = (Pair)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "pair", -2, obj2);
        }
        obj2 = pair;
        if (Scheme.isEqv.apply2(pair.getCar(), obj) != Boolean.FALSE) goto _L4; else goto _L3
_L3:
        obj1 = cdr.apply1(obj1);
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Object caaaar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCar()).getCar();
    }

    static Object caaadr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCar()).getCar();
    }

    static Object caaar(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCar();
    }

    static Object caadar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCar()).getCar();
    }

    static Object caaddr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCar()).getCar();
    }

    static Object caadr(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCar();
    }

    static Object caar(Object obj)
    {
        return ((Pair)((Pair)obj).getCar()).getCar();
    }

    static Object cadaar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCdr()).getCar();
    }

    static Object cadadr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCdr()).getCar();
    }

    static Object cadar(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCar();
    }

    static Object caddar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCdr()).getCar();
    }

    static Object cadddr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCdr()).getCar();
    }

    static Object caddr(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCar();
    }

    static Object cadr(Object obj)
    {
        return ((Pair)((Pair)obj).getCdr()).getCar();
    }

    static Object car(Pair pair)
    {
        return pair.getCar();
    }

    static Object cdaaar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCar()).getCdr();
    }

    static Object cdaadr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCar()).getCdr();
    }

    static Object cdaar(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCdr();
    }

    static Object cdadar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCar()).getCdr();
    }

    static Object cdaddr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCar()).getCdr();
    }

    static Object cdadr(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCdr();
    }

    static Object cdar(Object obj)
    {
        return ((Pair)((Pair)obj).getCar()).getCdr();
    }

    static Object cddaar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCdr()).getCdr();
    }

    static Object cddadr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCdr()).getCdr();
    }

    static Object cddar(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCdr();
    }

    static Object cdddar(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCdr()).getCdr();
    }

    static Object cddddr(Object obj)
    {
        return ((Pair)((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCdr()).getCdr();
    }

    static Object cdddr(Object obj)
    {
        return ((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCdr();
    }

    static Object cddr(Object obj)
    {
        return ((Pair)((Pair)obj).getCdr()).getCdr();
    }

    static Object cdr(Pair pair)
    {
        return pair.getCdr();
    }

    public static Pair cons(Object obj, Object obj1)
    {
        return new Pair(obj, obj1);
    }

    public static boolean isList(Object obj)
    {
        boolean flag = false;
        if (LList.listLength(obj, false) >= 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isNull(Object obj)
    {
        return obj == LList.Empty;
    }

    public static boolean isPair(Object obj)
    {
        return obj instanceof Pair;
    }

    static void lambda1(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)obj).getCar(), Lit1, obj1);
    }

    static void lambda10(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCdr()).getCar(), Lit2, obj1);
    }

    static void lambda11(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCar()).getCdr(), Lit2, obj1);
    }

    static void lambda12(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCdr()).getCdr(), Lit2, obj1);
    }

    static void lambda13(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCar(), Lit1, obj1);
    }

    static void lambda14(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCar(), Lit1, obj1);
    }

    static void lambda15(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCar(), Lit1, obj1);
    }

    static void lambda16(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCar(), Lit1, obj1);
    }

    static void lambda17(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCdr(), Lit1, obj1);
    }

    static void lambda18(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCdr(), Lit1, obj1);
    }

    static void lambda19(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCdr(), Lit1, obj1);
    }

    static void lambda2(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)obj).getCdr(), Lit1, obj1);
    }

    static void lambda20(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCdr(), Lit1, obj1);
    }

    static void lambda21(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCar(), Lit2, obj1);
    }

    static void lambda22(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCar(), Lit2, obj1);
    }

    static void lambda23(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCar(), Lit2, obj1);
    }

    static void lambda24(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCar(), Lit2, obj1);
    }

    static void lambda25(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCar()).getCdr(), Lit2, obj1);
    }

    static void lambda26(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCar()).getCdr(), Lit2, obj1);
    }

    static void lambda27(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCar()).getCdr()).getCdr(), Lit2, obj1);
    }

    static void lambda28(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)((Pair)obj).getCdr()).getCdr()).getCdr(), Lit2, obj1);
    }

    static void lambda3(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)obj).getCar(), Lit2, obj1);
    }

    static void lambda4(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)obj).getCdr(), Lit2, obj1);
    }

    static void lambda5(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCar()).getCar(), Lit1, obj1);
    }

    static void lambda6(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCdr()).getCar(), Lit1, obj1);
    }

    static void lambda7(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCar()).getCdr(), Lit1, obj1);
    }

    static void lambda8(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCdr()).getCdr(), Lit1, obj1);
    }

    static void lambda9(Object obj, Object obj1)
    {
        SlotSet.set$Mnfield$Ex.apply3(((Pair)((Pair)obj).getCar()).getCar(), Lit2, obj1);
    }

    public static int length(LList llist)
    {
        return LList.length(llist);
    }

    public static Object listRef(Object obj, int i)
    {
        return car.apply1(listTail(obj, i));
    }

    public static Object listTail(Object obj, int i)
    {
        return LList.listTail(obj, i);
    }

    public static Object member(Object obj, Object obj1)
    {
        return member(obj, obj1, ((Procedure) (Scheme.isEqual)));
    }

    public static Object member(Object obj, Object obj1, Procedure procedure)
    {
_L3:
        boolean flag = obj1 instanceof Pair;
        if (!flag) goto _L2; else goto _L1
_L1:
        Pair pair;
        try
        {
            pair = (Pair)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "p", -2, obj1);
        }
        if (procedure.apply2(obj, pair.getCar()) != Boolean.FALSE)
        {
            return obj1;
        }
        obj1 = pair.getCdr();
        if (true) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object memq(Object obj, Object obj1)
    {
_L3:
        boolean flag = obj1 instanceof Pair;
        if (!flag) goto _L2; else goto _L1
_L1:
        Pair pair;
        try
        {
            pair = (Pair)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "p", -2, obj1);
        }
        if (obj == pair.getCar())
        {
            return obj1;
        }
        obj1 = pair.getCdr();
        if (true) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static Object memv(Object obj, Object obj1)
    {
_L3:
        boolean flag = obj1 instanceof Pair;
        if (!flag) goto _L2; else goto _L1
_L1:
        Pair pair;
        try
        {
            pair = (Pair)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "p", -2, obj1);
        }
        if (Scheme.isEqv.apply2(obj, pair.getCar()) != Boolean.FALSE)
        {
            return obj1;
        }
        obj1 = pair.getCdr();
        if (true) goto _L3; else goto _L2
_L2:
        if (flag)
        {
            return Boolean.TRUE;
        } else
        {
            return Boolean.FALSE;
        }
    }

    public static LList reverse(LList llist)
    {
        Object obj = LList.Empty;
        do
        {
            if (isNull(llist))
            {
                return (LList)obj;
            }
            Pair pair;
            try
            {
                pair = (Pair)llist;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "pair", -2, llist);
            }
            llist = ((LList) (cdr.apply1(pair)));
            obj = cons(car.apply1(pair), obj);
        } while (true);
    }

    public static LList reverse$Ex(LList llist)
    {
        return LList.reverseInPlace(llist);
    }

    public static void setCar$Ex(Pair pair, Object obj)
    {
        pair.setCar(obj);
    }

    public static void setCdr$Ex(Pair pair, Object obj)
    {
        pair.setCdr(obj);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        case 10: // '\n'
        case 12: // '\f'
        case 14: // '\016'
        case 16: // '\020'
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        case 24: // '\030'
        case 26: // '\032'
        case 28: // '\034'
        case 30: // '\036'
        case 32: // ' '
        case 34: // '"'
        case 36: // '$'
        case 38: // '&'
        case 40: // '('
        case 42: // '*'
        case 44: // ','
        case 46: // '.'
        case 48: // '0'
        case 50: // '2'
        case 52: // '4'
        case 54: // '6'
        case 56: // '8'
        case 58: // ':'
        case 60: // '<'
        case 62: // '>'
        case 66: // 'B'
        case 67: // 'C'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isPair(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 3: // '\003'
            if (isNull(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 6: // '\006'
            try
            {
                modulemethod = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "car", 1, obj);
            }
            return car(modulemethod);

        case 7: // '\007'
            try
            {
                modulemethod = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "cdr", 1, obj);
            }
            return cdr(modulemethod);

        case 9: // '\t'
            return caar(obj);

        case 11: // '\013'
            return cadr(obj);

        case 13: // '\r'
            return cdar(obj);

        case 15: // '\017'
            return cddr(obj);

        case 17: // '\021'
            return caaar(obj);

        case 19: // '\023'
            return caadr(obj);

        case 21: // '\025'
            return cadar(obj);

        case 23: // '\027'
            return caddr(obj);

        case 25: // '\031'
            return cdaar(obj);

        case 27: // '\033'
            return cdadr(obj);

        case 29: // '\035'
            return cddar(obj);

        case 31: // '\037'
            return cdddr(obj);

        case 33: // '!'
            return caaaar(obj);

        case 35: // '#'
            return caaadr(obj);

        case 37: // '%'
            return caadar(obj);

        case 39: // '\''
            return caaddr(obj);

        case 41: // ')'
            return cadaar(obj);

        case 43: // '+'
            return cadadr(obj);

        case 45: // '-'
            return caddar(obj);

        case 47: // '/'
            return cadddr(obj);

        case 49: // '1'
            return cdaaar(obj);

        case 51: // '3'
            return cdaadr(obj);

        case 53: // '5'
            return cdadar(obj);

        case 55: // '7'
            return cdaddr(obj);

        case 57: // '9'
            return cddaar(obj);

        case 59: // ';'
            return cddadr(obj);

        case 61: // '='
            return cdddar(obj);

        case 63: // '?'
            return cddddr(obj);

        case 64: // '@'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "length", 1, obj);
            }
            return Integer.valueOf(length(modulemethod));

        case 65: // 'A'
            try
            {
                modulemethod = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "reverse", 1, obj);
            }
            return reverse(modulemethod);

        case 68: // 'D'
            if (isList(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 69: // 'E'
            break;
        }
        try
        {
            modulemethod = (LList)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "reverse!", 1, obj);
        }
        return reverse$Ex(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
        case 11: // '\013'
        case 13: // '\r'
        case 15: // '\017'
        case 17: // '\021'
        case 19: // '\023'
        case 21: // '\025'
        case 23: // '\027'
        case 25: // '\031'
        case 27: // '\033'
        case 29: // '\035'
        case 31: // '\037'
        case 33: // '!'
        case 35: // '#'
        case 37: // '%'
        case 39: // '\''
        case 41: // ')'
        case 43: // '+'
        case 45: // '-'
        case 47: // '/'
        case 49: // '1'
        case 51: // '3'
        case 53: // '5'
        case 55: // '7'
        case 57: // '9'
        case 59: // ';'
        case 61: // '='
        case 63: // '?'
        case 64: // '@'
        case 65: // 'A'
        case 68: // 'D'
        case 69: // 'E'
        case 73: // 'I'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 2: // '\002'
            return cons(obj, obj1);

        case 4: // '\004'
            int i;
            try
            {
                modulemethod = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "set-car!", 1, obj);
            }
            setCar$Ex(modulemethod, obj1);
            return Values.empty;

        case 5: // '\005'
            try
            {
                modulemethod = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "set-cdr!", 1, obj);
            }
            setCdr$Ex(modulemethod, obj1);
            return Values.empty;

        case 8: // '\b'
            lambda1(obj, obj1);
            return Values.empty;

        case 10: // '\n'
            lambda2(obj, obj1);
            return Values.empty;

        case 12: // '\f'
            lambda3(obj, obj1);
            return Values.empty;

        case 14: // '\016'
            lambda4(obj, obj1);
            return Values.empty;

        case 16: // '\020'
            lambda5(obj, obj1);
            return Values.empty;

        case 18: // '\022'
            lambda6(obj, obj1);
            return Values.empty;

        case 20: // '\024'
            lambda7(obj, obj1);
            return Values.empty;

        case 22: // '\026'
            lambda8(obj, obj1);
            return Values.empty;

        case 24: // '\030'
            lambda9(obj, obj1);
            return Values.empty;

        case 26: // '\032'
            lambda10(obj, obj1);
            return Values.empty;

        case 28: // '\034'
            lambda11(obj, obj1);
            return Values.empty;

        case 30: // '\036'
            lambda12(obj, obj1);
            return Values.empty;

        case 32: // ' '
            lambda13(obj, obj1);
            return Values.empty;

        case 34: // '"'
            lambda14(obj, obj1);
            return Values.empty;

        case 36: // '$'
            lambda15(obj, obj1);
            return Values.empty;

        case 38: // '&'
            lambda16(obj, obj1);
            return Values.empty;

        case 40: // '('
            lambda17(obj, obj1);
            return Values.empty;

        case 42: // '*'
            lambda18(obj, obj1);
            return Values.empty;

        case 44: // ','
            lambda19(obj, obj1);
            return Values.empty;

        case 46: // '.'
            lambda20(obj, obj1);
            return Values.empty;

        case 48: // '0'
            lambda21(obj, obj1);
            return Values.empty;

        case 50: // '2'
            lambda22(obj, obj1);
            return Values.empty;

        case 52: // '4'
            lambda23(obj, obj1);
            return Values.empty;

        case 54: // '6'
            lambda24(obj, obj1);
            return Values.empty;

        case 56: // '8'
            lambda25(obj, obj1);
            return Values.empty;

        case 58: // ':'
            lambda26(obj, obj1);
            return Values.empty;

        case 60: // '<'
            lambda27(obj, obj1);
            return Values.empty;

        case 62: // '>'
            lambda28(obj, obj1);
            return Values.empty;

        case 66: // 'B'
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list-tail", 2, obj1);
            }
            return listTail(obj, i);

        case 67: // 'C'
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "list-ref", 2, obj1);
            }
            return listRef(obj, i);

        case 70: // 'F'
            return memq(obj, obj1);

        case 71: // 'G'
            return memv(obj, obj1);

        case 72: // 'H'
            return member(obj, obj1);

        case 74: // 'J'
            return assq(obj, obj1);

        case 75: // 'K'
            return assv(obj, obj1);

        case 76: // 'L'
            return assoc(obj, obj1);
        }
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 72: // 'H'
            try
            {
                modulemethod = (Procedure)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "member", 3, obj2);
            }
            return member(obj, obj1, modulemethod);

        case 76: // 'L'
            break;
        }
        try
        {
            modulemethod = (Procedure)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "assoc", 3, obj2);
        }
        return assoc(obj, obj1, modulemethod);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        case 10: // '\n'
        case 12: // '\f'
        case 14: // '\016'
        case 16: // '\020'
        case 18: // '\022'
        case 20: // '\024'
        case 22: // '\026'
        case 24: // '\030'
        case 26: // '\032'
        case 28: // '\034'
        case 30: // '\036'
        case 32: // ' '
        case 34: // '"'
        case 36: // '$'
        case 38: // '&'
        case 40: // '('
        case 42: // '*'
        case 44: // ','
        case 46: // '.'
        case 48: // '0'
        case 50: // '2'
        case 52: // '4'
        case 54: // '6'
        case 56: // '8'
        case 58: // ':'
        case 60: // '<'
        case 62: // '>'
        case 66: // 'B'
        case 67: // 'C'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 69: // 'E'
            if (obj instanceof LList)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 68: // 'D'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 65: // 'A'
            if (obj instanceof LList)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 64: // '@'
            if (obj instanceof LList)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 63: // '?'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 61: // '='
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 59: // ';'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 57: // '9'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 55: // '7'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 53: // '5'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 51: // '3'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 49: // '1'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 47: // '/'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 45: // '-'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 43: // '+'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 41: // ')'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 39: // '\''
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 37: // '%'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 35: // '#'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 33: // '!'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 31: // '\037'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 29: // '\035'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 27: // '\033'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 25: // '\031'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 23: // '\027'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 21: // '\025'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 19: // '\023'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 17: // '\021'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 15: // '\017'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 13: // '\r'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 11: // '\013'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 9: // '\t'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 7: // '\007'
            if (!(obj instanceof Pair))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 6: // '\006'
            if (!(obj instanceof Pair))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 3: // '\003'
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
        case 3: // '\003'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
        case 11: // '\013'
        case 13: // '\r'
        case 15: // '\017'
        case 17: // '\021'
        case 19: // '\023'
        case 21: // '\025'
        case 23: // '\027'
        case 25: // '\031'
        case 27: // '\033'
        case 29: // '\035'
        case 31: // '\037'
        case 33: // '!'
        case 35: // '#'
        case 37: // '%'
        case 39: // '\''
        case 41: // ')'
        case 43: // '+'
        case 45: // '-'
        case 47: // '/'
        case 49: // '1'
        case 51: // '3'
        case 53: // '5'
        case 55: // '7'
        case 57: // '9'
        case 59: // ';'
        case 61: // '='
        case 63: // '?'
        case 64: // '@'
        case 65: // 'A'
        case 68: // 'D'
        case 69: // 'E'
        case 73: // 'I'
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 76: // 'L'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 75: // 'K'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 74: // 'J'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 72: // 'H'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 71: // 'G'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 70: // 'F'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 67: // 'C'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 66: // 'B'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 62: // '>'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 60: // '<'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 58: // ':'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 56: // '8'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 54: // '6'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 52: // '4'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 50: // '2'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 48: // '0'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 46: // '.'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 44: // ','
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 42: // '*'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 40: // '('
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 38: // '&'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 36: // '$'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 34: // '"'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 32: // ' '
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 30: // '\036'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 28: // '\034'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 26: // '\032'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 24: // '\030'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 22: // '\026'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 20: // '\024'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 18: // '\022'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 16: // '\020'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 14: // '\016'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 12: // '\f'
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

        case 8: // '\b'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;

        case 5: // '\005'
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

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        int i = 0xfff40003;
        modulemethod.selector;
        JVM INSTR lookupswitch 2: default 36
    //                   72: 93
    //                   76: 52;
           goto _L1 _L2 _L3
_L1:
        i = super.match3(modulemethod, obj, obj1, obj2, callcontext);
_L5:
        return i;
_L3:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        if (obj2 instanceof Procedure)
        {
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        if (obj2 instanceof Procedure)
        {
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        car = new GenericProc("car");
        car.setProperties(new Object[] {
            Lit0, set$Mncar$Ex, car$Fn1
        });
        cdr = new GenericProc("cdr");
        cdr.setProperties(new Object[] {
            Lit0, set$Mncdr$Ex, cdr$Fn2
        });
        caar = new GenericProc("caar");
        caar.setProperties(new Object[] {
            Lit0, lambda$Fn3, caar$Fn4
        });
        cadr = new GenericProc("cadr");
        cadr.setProperties(new Object[] {
            Lit0, lambda$Fn5, cadr$Fn6
        });
        cdar = new GenericProc("cdar");
        cdar.setProperties(new Object[] {
            Lit0, lambda$Fn7, cdar$Fn8
        });
        cddr = new GenericProc("cddr");
        cddr.setProperties(new Object[] {
            Lit0, lambda$Fn9, cddr$Fn10
        });
        caaar = new GenericProc("caaar");
        caaar.setProperties(new Object[] {
            Lit0, lambda$Fn11, caaar$Fn12
        });
        caadr = new GenericProc("caadr");
        caadr.setProperties(new Object[] {
            Lit0, lambda$Fn13, caadr$Fn14
        });
        cadar = new GenericProc("cadar");
        cadar.setProperties(new Object[] {
            Lit0, lambda$Fn15, cadar$Fn16
        });
        caddr = new GenericProc("caddr");
        caddr.setProperties(new Object[] {
            Lit0, lambda$Fn17, caddr$Fn18
        });
        cdaar = new GenericProc("cdaar");
        cdaar.setProperties(new Object[] {
            Lit0, lambda$Fn19, cdaar$Fn20
        });
        cdadr = new GenericProc("cdadr");
        cdadr.setProperties(new Object[] {
            Lit0, lambda$Fn21, cdadr$Fn22
        });
        cddar = new GenericProc("cddar");
        cddar.setProperties(new Object[] {
            Lit0, lambda$Fn23, cddar$Fn24
        });
        cdddr = new GenericProc("cdddr");
        cdddr.setProperties(new Object[] {
            Lit0, lambda$Fn25, cdddr$Fn26
        });
        caaaar = new GenericProc("caaaar");
        caaaar.setProperties(new Object[] {
            Lit0, lambda$Fn27, caaaar$Fn28
        });
        caaadr = new GenericProc("caaadr");
        caaadr.setProperties(new Object[] {
            Lit0, lambda$Fn29, caaadr$Fn30
        });
        caadar = new GenericProc("caadar");
        caadar.setProperties(new Object[] {
            Lit0, lambda$Fn31, caadar$Fn32
        });
        caaddr = new GenericProc("caaddr");
        caaddr.setProperties(new Object[] {
            Lit0, lambda$Fn33, caaddr$Fn34
        });
        cadaar = new GenericProc("cadaar");
        cadaar.setProperties(new Object[] {
            Lit0, lambda$Fn35, cadaar$Fn36
        });
        cadadr = new GenericProc("cadadr");
        cadadr.setProperties(new Object[] {
            Lit0, lambda$Fn37, cadadr$Fn38
        });
        caddar = new GenericProc("caddar");
        caddar.setProperties(new Object[] {
            Lit0, lambda$Fn39, caddar$Fn40
        });
        cadddr = new GenericProc("cadddr");
        cadddr.setProperties(new Object[] {
            Lit0, lambda$Fn41, cadddr$Fn42
        });
        cdaaar = new GenericProc("cdaaar");
        cdaaar.setProperties(new Object[] {
            Lit0, lambda$Fn43, cdaaar$Fn44
        });
        cdaadr = new GenericProc("cdaadr");
        cdaadr.setProperties(new Object[] {
            Lit0, lambda$Fn45, cdaadr$Fn46
        });
        cdadar = new GenericProc("cdadar");
        cdadar.setProperties(new Object[] {
            Lit0, lambda$Fn47, cdadar$Fn48
        });
        cdaddr = new GenericProc("cdaddr");
        cdaddr.setProperties(new Object[] {
            Lit0, lambda$Fn49, cdaddr$Fn50
        });
        cddaar = new GenericProc("cddaar");
        cddaar.setProperties(new Object[] {
            Lit0, lambda$Fn51, cddaar$Fn52
        });
        cddadr = new GenericProc("cddadr");
        cddadr.setProperties(new Object[] {
            Lit0, lambda$Fn53, cddadr$Fn54
        });
        cdddar = new GenericProc("cdddar");
        cdddar.setProperties(new Object[] {
            Lit0, lambda$Fn55, cdddar$Fn56
        });
        cddddr = new GenericProc("cddddr");
        cddddr.setProperties(new Object[] {
            Lit0, lambda$Fn57, cddddr$Fn58
        });
    }

    static 
    {
        Lit19 = (SimpleSymbol)(new SimpleSymbol("assoc")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("assv")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("assq")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("member")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("memv")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("memq")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("reverse!")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("list?")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("list-ref")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("list-tail")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("reverse")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("length")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("set-cdr!")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("set-car!")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("null?")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("cons")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("pair?")).readResolve();
        $instance = new lists();
        lists lists1 = $instance;
        pair$Qu = new ModuleMethod(lists1, 1, Lit3, 4097);
        cons = new ModuleMethod(lists1, 2, Lit4, 8194);
        null$Qu = new ModuleMethod(lists1, 3, Lit5, 4097);
        set$Mncar$Ex = new ModuleMethod(lists1, 4, Lit6, 8194);
        set$Mncdr$Ex = new ModuleMethod(lists1, 5, Lit7, 8194);
        ModuleMethod modulemethod = new ModuleMethod(lists1, 6, "car", 4097);
        modulemethod.setProperty("source-location", "lists.scm:31");
        car$Fn1 = modulemethod;
        modulemethod = new ModuleMethod(lists1, 7, "cdr", 4097);
        modulemethod.setProperty("source-location", "lists.scm:36");
        cdr$Fn2 = modulemethod;
        lambda$Fn3 = new ModuleMethod(lists1, 8, null, 8194);
        caar$Fn4 = new ModuleMethod(lists1, 9, "caar", 4097);
        lambda$Fn5 = new ModuleMethod(lists1, 10, null, 8194);
        cadr$Fn6 = new ModuleMethod(lists1, 11, "cadr", 4097);
        lambda$Fn7 = new ModuleMethod(lists1, 12, null, 8194);
        cdar$Fn8 = new ModuleMethod(lists1, 13, "cdar", 4097);
        lambda$Fn9 = new ModuleMethod(lists1, 14, null, 8194);
        cddr$Fn10 = new ModuleMethod(lists1, 15, "cddr", 4097);
        lambda$Fn11 = new ModuleMethod(lists1, 16, null, 8194);
        caaar$Fn12 = new ModuleMethod(lists1, 17, "caaar", 4097);
        lambda$Fn13 = new ModuleMethod(lists1, 18, null, 8194);
        caadr$Fn14 = new ModuleMethod(lists1, 19, "caadr", 4097);
        lambda$Fn15 = new ModuleMethod(lists1, 20, null, 8194);
        cadar$Fn16 = new ModuleMethod(lists1, 21, "cadar", 4097);
        lambda$Fn17 = new ModuleMethod(lists1, 22, null, 8194);
        caddr$Fn18 = new ModuleMethod(lists1, 23, "caddr", 4097);
        lambda$Fn19 = new ModuleMethod(lists1, 24, null, 8194);
        cdaar$Fn20 = new ModuleMethod(lists1, 25, "cdaar", 4097);
        lambda$Fn21 = new ModuleMethod(lists1, 26, null, 8194);
        cdadr$Fn22 = new ModuleMethod(lists1, 27, "cdadr", 4097);
        lambda$Fn23 = new ModuleMethod(lists1, 28, null, 8194);
        cddar$Fn24 = new ModuleMethod(lists1, 29, "cddar", 4097);
        lambda$Fn25 = new ModuleMethod(lists1, 30, null, 8194);
        cdddr$Fn26 = new ModuleMethod(lists1, 31, "cdddr", 4097);
        lambda$Fn27 = new ModuleMethod(lists1, 32, null, 8194);
        caaaar$Fn28 = new ModuleMethod(lists1, 33, "caaaar", 4097);
        lambda$Fn29 = new ModuleMethod(lists1, 34, null, 8194);
        caaadr$Fn30 = new ModuleMethod(lists1, 35, "caaadr", 4097);
        lambda$Fn31 = new ModuleMethod(lists1, 36, null, 8194);
        caadar$Fn32 = new ModuleMethod(lists1, 37, "caadar", 4097);
        lambda$Fn33 = new ModuleMethod(lists1, 38, null, 8194);
        caaddr$Fn34 = new ModuleMethod(lists1, 39, "caaddr", 4097);
        lambda$Fn35 = new ModuleMethod(lists1, 40, null, 8194);
        cadaar$Fn36 = new ModuleMethod(lists1, 41, "cadaar", 4097);
        lambda$Fn37 = new ModuleMethod(lists1, 42, null, 8194);
        cadadr$Fn38 = new ModuleMethod(lists1, 43, "cadadr", 4097);
        lambda$Fn39 = new ModuleMethod(lists1, 44, null, 8194);
        caddar$Fn40 = new ModuleMethod(lists1, 45, "caddar", 4097);
        lambda$Fn41 = new ModuleMethod(lists1, 46, null, 8194);
        cadddr$Fn42 = new ModuleMethod(lists1, 47, "cadddr", 4097);
        lambda$Fn43 = new ModuleMethod(lists1, 48, null, 8194);
        cdaaar$Fn44 = new ModuleMethod(lists1, 49, "cdaaar", 4097);
        lambda$Fn45 = new ModuleMethod(lists1, 50, null, 8194);
        cdaadr$Fn46 = new ModuleMethod(lists1, 51, "cdaadr", 4097);
        lambda$Fn47 = new ModuleMethod(lists1, 52, null, 8194);
        cdadar$Fn48 = new ModuleMethod(lists1, 53, "cdadar", 4097);
        lambda$Fn49 = new ModuleMethod(lists1, 54, null, 8194);
        cdaddr$Fn50 = new ModuleMethod(lists1, 55, "cdaddr", 4097);
        lambda$Fn51 = new ModuleMethod(lists1, 56, null, 8194);
        cddaar$Fn52 = new ModuleMethod(lists1, 57, "cddaar", 4097);
        lambda$Fn53 = new ModuleMethod(lists1, 58, null, 8194);
        cddadr$Fn54 = new ModuleMethod(lists1, 59, "cddadr", 4097);
        lambda$Fn55 = new ModuleMethod(lists1, 60, null, 8194);
        cdddar$Fn56 = new ModuleMethod(lists1, 61, "cdddar", 4097);
        lambda$Fn57 = new ModuleMethod(lists1, 62, null, 8194);
        cddddr$Fn58 = new ModuleMethod(lists1, 63, "cddddr", 4097);
        length = new ModuleMethod(lists1, 64, Lit8, 4097);
        reverse = new ModuleMethod(lists1, 65, Lit9, 4097);
        list$Mntail = new ModuleMethod(lists1, 66, Lit10, 8194);
        list$Mnref = new ModuleMethod(lists1, 67, Lit11, 8194);
        list$Qu = new ModuleMethod(lists1, 68, Lit12, 4097);
        reverse$Ex = new ModuleMethod(lists1, 69, Lit13, 4097);
        memq = new ModuleMethod(lists1, 70, Lit14, 8194);
        memv = new ModuleMethod(lists1, 71, Lit15, 8194);
        member = new ModuleMethod(lists1, 72, Lit16, 12290);
        assq = new ModuleMethod(lists1, 74, Lit17, 8194);
        assv = new ModuleMethod(lists1, 75, Lit18, 8194);
        assoc = new ModuleMethod(lists1, 76, Lit19, 12290);
        $instance.run();
    }
}
