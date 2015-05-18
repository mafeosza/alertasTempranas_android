// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;
import kawa.standard.append;

// Referenced classes of package gnu.kawa.slib:
//            condition, srfi1

public class conditions extends ModuleBody
{
    public class condition.Mntype
    {

        public Object all$Mnfields;
        public Object fields;
        public Object name;
        public Object supertype;

        public String toString()
        {
            StringBuffer stringbuffer = new StringBuffer("#<condition-type ");
            stringbuffer.append(name);
            stringbuffer.append(">");
            return stringbuffer.toString();
        }

        public condition.Mntype(Object obj, Object obj1, Object obj2, Object obj3)
        {
            name = obj;
            supertype = obj1;
            fields = obj2;
            all$Mnfields = obj3;
        }
    }

    public class frame extends ModuleBody
    {

        final ModuleMethod lambda$Fn1;
        condition.Mntype type;

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 1)
            {
                if (lambda2(obj))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        boolean lambda2(Object obj)
        {
            obj = lists.car.apply1(obj);
            condition.Mntype mntype;
            try
            {
                mntype = (condition.Mntype)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "condition-subtype?", 0, obj);
            }
            return conditions.isConditionSubtype(mntype, type);
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return super.match1(modulemethod, obj, callcontext);
            }
        }

        public frame()
        {
            ModuleMethod modulemethod = new ModuleMethod(this, 1, null, 4097);
            modulemethod.setProperty("source-location", "conditions.scm:166");
            lambda$Fn1 = modulemethod;
        }
    }


    public static Object $Amcondition;
    public static Object $Amerror;
    public static Object $Ammessage;
    public static Object $Amserious;
    static final Class $Lscondition$Mntype$Gr = gnu/kawa/slib/condition$Mntype;
    public static final Class $Prvt$$Lscondition$Gr = gnu/kawa/slib/condition;
    public static final ModuleMethod $Prvt$type$Mnfield$Mnalist$Mn$Grcondition;
    public static final conditions $instance;
    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("&condition")).readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("&message")).readResolve();
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit13;
    static final SyntaxRules Lit14;
    static final SimpleSymbol Lit15;
    static final SimpleSymbol Lit16;
    static final SimpleSymbol Lit17;
    static final SimpleSymbol Lit18;
    static final SyntaxRules Lit19;
    static final PairWithPosition Lit2;
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("&serious")).readResolve();
    static final SimpleSymbol Lit4 = (SimpleSymbol)(new SimpleSymbol("&error")).readResolve();
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SyntaxRules Lit9;
    public static final Macro condition;
    public static final ModuleMethod condition$Mnhas$Mntype$Qu;
    public static final ModuleMethod condition$Mnref;
    static final Macro condition$Mntype$Mnfield$Mnalist;
    public static final ModuleMethod condition$Mntype$Qu;
    public static final ModuleMethod condition$Qu;
    public static final Macro define$Mncondition$Mntype;
    public static final ModuleMethod extract$Mncondition;
    public static final ModuleMethod make$Mncompound$Mncondition;
    public static final ModuleMethod make$Mncondition;
    public static final ModuleMethod make$Mncondition$Mntype;

    public conditions()
    {
        ModuleInfo.register(this);
    }

    static Object checkConditionTypeFieldAlist(Object obj)
    {
        Object obj1 = obj;
_L3:
        Object obj2;
        Object obj4;
        Object obj6;
        if (lists.isNull(obj1))
        {
            break MISSING_BLOCK_LABEL_236;
        }
        Object obj3 = lists.car.apply1(obj1);
        obj2 = lists.car.apply1(obj3);
        condition.Mntype mntype;
        try
        {
            mntype = (condition.Mntype)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "type", -2, obj2);
        }
        obj2 = lists.cdr.apply1(obj3);
        obj3 = LList.Empty;
        do
        {
            if (obj2 == LList.Empty)
            {
                obj2 = LList.reverseInPlace(obj3);
                obj3 = mntype.all$Mnfields;
                obj2 = srfi1.lsetDifference$V(Scheme.isEq, obj3, new Object[] {
                    obj2
                });
                break MISSING_BLOCK_LABEL_77;
            }
            Object obj5;
            condition.Mntype mntype1;
            boolean flag;
            try
            {
                obj4 = (Pair)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj2);
            }
            obj2 = ((Pair) (obj4)).getCdr();
            obj3 = Pair.make(lists.car.apply1(((Pair) (obj4)).getCar()), obj3);
        } while (true);
_L1:
        {
            if (obj2 == LList.Empty)
            {
                obj1 = lists.cdr.apply1(obj1);
                continue; /* Loop/switch isn't completed */
            }
            try
            {
                obj3 = (Pair)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj2);
            }
            obj5 = ((Pair) (obj3)).getCar();
            obj4 = conditionTypeFieldSupertype(mntype, obj5);
            obj2 = obj;
        }
        obj6 = lists.car.apply1(lists.car.apply1(obj2));
        try
        {
            mntype1 = (condition.Mntype)obj6;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "condition-subtype?", 0, obj6);
        }
        obj6 = (condition.Mntype)obj4;
label0:
        {
            flag = isConditionSubtype(mntype1, ((condition.Mntype) (obj6)));
            if (!flag)
            {
                break label0;
            }
            if (!flag)
            {
                misc.error$V("missing field in condition construction", new Object[] {
                    mntype, obj5
                });
            }
            obj2 = ((Pair) (obj3)).getCdr();
        }
          goto _L1
        obj2 = lists.cdr.apply1(obj2);
        break MISSING_BLOCK_LABEL_148;
        return Values.empty;
        obj;
        throw new WrongType(((ClassCastException) (obj)), "condition-subtype?", 1, obj4);
        if (true) goto _L3; else goto _L2
_L2:
    }

    static Object conditionMessage(Object obj)
    {
        condition condition1;
        condition.Mntype mntype;
        try
        {
            condition1 = (condition)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "extract-condition", 0, obj);
        }
        obj = $Ammessage;
        try
        {
            mntype = (condition.Mntype)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "extract-condition", 1, obj);
        }
        return conditionRef(extractCondition(condition1, mntype), Lit5);
    }

    public static Object conditionRef(condition condition1, Object obj)
    {
        return typeFieldAlistRef(condition1.type$Mnfield$Mnalist, obj);
    }

    static Object conditionTypeFieldSupertype(condition.Mntype mntype, Object obj)
    {
_L6:
        if (mntype != Boolean.FALSE) goto _L2; else goto _L1
_L1:
        Object obj1 = Boolean.FALSE;
_L4:
        return obj1;
_L2:
        obj1 = mntype;
        if (lists.memq(obj, mntype.fields) != Boolean.FALSE) goto _L4; else goto _L3
_L3:
        mntype = (condition.Mntype)mntype.supertype;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static Object conditionTypes(Object obj)
    {
        obj = ((condition)obj).type$Mnfield$Mnalist;
        Object obj1 = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                return LList.reverseInPlace(obj1);
            }
            Pair pair;
            try
            {
                pair = (Pair)obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "arg0", -2, obj);
            }
            obj = pair.getCdr();
            obj1 = Pair.make(lists.car.apply1(pair.getCar()), obj1);
        } while (true);
    }

    public static condition extractCondition(condition condition1, condition.Mntype mntype)
    {
        frame frame1 = new frame();
        frame1.type = mntype;
        Object obj = srfi1.find(frame1.Fn1, condition1.type$Mnfield$Mnalist);
        if (obj == Boolean.FALSE)
        {
            misc.error$V("extract-condition: invalid condition type", new Object[] {
                condition1, frame1.type
            });
        }
        condition.Mntype mntype1 = frame1.type;
        condition1 = ((condition) (frame1.type.all$Mnfields));
        mntype = LList.Empty;
        do
        {
            if (condition1 == LList.Empty)
            {
                return new condition(LList.list1(lists.cons(mntype1, LList.reverseInPlace(mntype))));
            }
            Pair pair;
            try
            {
                pair = (Pair)condition1;
            }
            // Misplaced declaration of an exception variable
            catch (condition.Mntype mntype)
            {
                throw new WrongType(mntype, "arg0", -2, condition1);
            }
            condition1 = ((condition) (pair.getCdr()));
            mntype = Pair.make(lists.assq(pair.getCar(), lists.cdr.apply1(obj)), mntype);
        } while (true);
    }

    public static boolean isCondition(Object obj)
    {
        return obj instanceof condition;
    }

    public static boolean isConditionHasType(Object obj, condition.Mntype mntype)
    {
        obj = conditionTypes(obj);
        do
        {
            Object obj1 = lists.car.apply1(obj);
            condition.Mntype mntype1;
            boolean flag;
            try
            {
                mntype1 = (condition.Mntype)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "condition-subtype?", 0, obj1);
            }
            flag = isConditionSubtype(mntype1, mntype);
            if (flag)
            {
                return flag;
            }
            obj = lists.cdr.apply1(obj);
        } while (true);
    }

    static boolean isConditionSubtype(condition.Mntype mntype, condition.Mntype mntype1)
    {
        do
        {
            if (mntype == Boolean.FALSE)
            {
                return false;
            }
            if (mntype == mntype1)
            {
                return true;
            }
            mntype = (condition.Mntype)mntype.supertype;
        } while (true);
    }

    public static boolean isConditionType(Object obj)
    {
        return obj instanceof condition.Mntype;
    }

    static boolean isError(Object obj)
    {
        boolean flag1 = isCondition(obj);
        boolean flag = flag1;
        if (flag1)
        {
            Object obj1 = $Amerror;
            condition.Mntype mntype;
            try
            {
                mntype = (condition.Mntype)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "condition-has-type?", 1, obj1);
            }
            flag = isConditionHasType(obj, mntype);
        }
        return flag;
    }

    static boolean isMessageCondition(Object obj)
    {
        boolean flag1 = isCondition(obj);
        boolean flag = flag1;
        if (flag1)
        {
            Object obj1 = $Ammessage;
            condition.Mntype mntype;
            try
            {
                mntype = (condition.Mntype)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "condition-has-type?", 1, obj1);
            }
            flag = isConditionHasType(obj, mntype);
        }
        return flag;
    }

    static boolean isSeriousCondition(Object obj)
    {
        boolean flag1 = isCondition(obj);
        boolean flag = flag1;
        if (flag1)
        {
            Object obj1 = $Amserious;
            condition.Mntype mntype;
            try
            {
                mntype = (condition.Mntype)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "condition-has-type?", 1, obj1);
            }
            flag = isConditionHasType(obj, mntype);
        }
        return flag;
    }

    public static Object lambda1label(Object obj)
    {
        if (lists.isNull(obj))
        {
            return LList.Empty;
        } else
        {
            return lists.cons(lists.cons(lists.car.apply1(obj), lists.cadr.apply1(obj)), lambda1label(lists.cddr.apply1(obj)));
        }
    }

    public static condition makeCompoundCondition$V(Object obj, Object aobj[])
    {
        aobj = LList.makeList(aobj, 0);
        gnu.kawa.functions.Apply apply = Scheme.apply;
        append append1 = append.append;
        obj = lists.cons(obj, ((Object) (aobj)));
        aobj = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                return new condition(apply.apply2(append1, LList.reverseInPlace(((Object) (aobj)))));
            }
            Pair pair;
            try
            {
                pair = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "arg0", -2, obj);
            }
            obj = pair.getCdr();
            aobj = Pair.make(Scheme.applyToArgs.apply2(condition$Mntype$Mnfield$Mnalist, pair.getCar()), ((Object) (aobj)));
        } while (true);
    }

    public static condition makeCondition$V(condition.Mntype mntype, Object aobj[])
    {
        Object obj1 = lambda1label(LList.makeList(aobj, 0));
        gnu.kawa.functions.IsEq iseq = Scheme.isEq;
        Object obj2 = mntype.all$Mnfields;
        Object obj = LList.Empty;
        aobj = ((Object []) (obj1));
        do
        {
            if (aobj == LList.Empty)
            {
                if (srfi1.lset$Eq$V(iseq, new Object[] {
    obj2, LList.reverseInPlace(obj)
}) == Boolean.FALSE)
                {
                    misc.error$V("condition fields don't match condition type", new Object[0]);
                }
                return new condition(LList.list1(lists.cons(mntype, obj1)));
            }
            Pair pair;
            try
            {
                pair = (Pair)aobj;
            }
            // Misplaced declaration of an exception variable
            catch (condition.Mntype mntype)
            {
                throw new WrongType(mntype, "arg0", -2, ((Object) (aobj)));
            }
            aobj = ((Object []) (pair.getCdr()));
            obj = Pair.make(lists.car.apply1(pair.getCar()), obj);
        } while (true);
    }

    public static condition.Mntype makeConditionType(Symbol symbol, condition.Mntype mntype, Object obj)
    {
        if (!lists.isNull(srfi1.lsetIntersection$V(Scheme.isEq, mntype.all$Mnfields, new Object[] {
    obj
})))
        {
            misc.error$V("duplicate field name", new Object[0]);
        }
        return new condition.Mntype(symbol, mntype, obj, append.append$V(new Object[] {
            mntype.all$Mnfields, obj
        }));
    }

    public static condition typeFieldAlist$To$Condition(Object obj)
    {
        Object obj1;
        Object obj2;
        obj1 = LList.Empty;
        obj2 = obj;
_L1:
        Object obj3;
        if (obj2 == LList.Empty)
        {
            return new condition(LList.reverseInPlace(obj1));
        }
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        try
        {
            obj3 = (Pair)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj2);
        }
        obj4 = ((Pair) (obj3)).getCdr();
        obj6 = ((Pair) (obj3)).getCar();
        obj7 = lists.car.apply1(obj6);
        obj3 = ((condition.Mntype)lists.car.apply1(obj6)).all$Mnfields;
        obj2 = LList.Empty;
label0:
        {
            if (obj3 != LList.Empty)
            {
                break label0;
            }
            obj1 = Pair.make(lists.cons(obj7, LList.reverseInPlace(obj2)), obj1);
            obj2 = obj4;
        }
          goto _L1
        try
        {
            obj8 = (Pair)obj3;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj3);
        }
        obj5 = ((Pair) (obj8)).getCdr();
        obj8 = ((Pair) (obj8)).getCar();
        obj3 = lists.assq(obj8, lists.cdr.apply1(obj6));
        if (obj3 == Boolean.FALSE)
        {
            obj3 = lists.cons(obj8, typeFieldAlistRef(obj, obj8));
        }
        obj2 = Pair.make(obj3, obj2);
        obj3 = obj5;
        break MISSING_BLOCK_LABEL_71;
    }

    static Object typeFieldAlistRef(Object obj, Object obj1)
    {
        do
        {
            if (lists.isNull(obj))
            {
                return misc.error$V("type-field-alist-ref: field not found", new Object[] {
                    obj, obj1
                });
            }
            Object obj2 = lists.assq(obj1, lists.cdr.apply1(lists.car.apply1(obj)));
            if (obj2 != Boolean.FALSE)
            {
                return lists.cdr.apply1(obj2);
            }
            obj = lists.cdr.apply1(obj);
        } while (true);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 2: // '\002'
            if (isConditionType(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 4: // '\004'
            if (isCondition(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 10: // '\n'
            return typeFieldAlist$To$Condition(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 8: // '\b'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 6: // '\006'
            try
            {
                modulemethod = (condition.Mntype)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "condition-has-type?", 2, obj1);
            }
            if (isConditionHasType(obj, modulemethod))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 7: // '\007'
            try
            {
                modulemethod = (condition)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "condition-ref", 1, obj);
            }
            return conditionRef(modulemethod, obj1);

        case 9: // '\t'
            break;
        }
        try
        {
            modulemethod = (condition)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "extract-condition", 1, obj);
        }
        try
        {
            obj = (condition.Mntype)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "extract-condition", 2, obj1);
        }
        return extractCondition(modulemethod, ((condition.Mntype) (obj)));
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 3)
        {
            try
            {
                modulemethod = (Symbol)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-condition-type", 1, obj);
            }
            try
            {
                obj = (condition.Mntype)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-condition-type", 2, obj1);
            }
            return makeConditionType(modulemethod, ((condition.Mntype) (obj)), obj2);
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        case 6: // '\006'
        case 7: // '\007'
        default:
            return super.applyN(modulemethod, aobj);

        case 5: // '\005'
            modulemethod = ((ModuleMethod) (aobj[0]));
            condition.Mntype mntype;
            Object aobj1[];
            int i;
            try
            {
                mntype = (condition.Mntype)modulemethod;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "make-condition", 1, modulemethod);
            }
            i = aobj.length - 1;
            modulemethod = ((ModuleMethod) (new Object[i]));
            do
            {
                i--;
                if (i < 0)
                {
                    return makeCondition$V(mntype, modulemethod);
                }
                modulemethod[i] = aobj[i + 1];
            } while (true);

        case 8: // '\b'
            modulemethod = ((ModuleMethod) (aobj[0]));
            i = aobj.length - 1;
            aobj1 = new Object[i];
            break;
        }
        do
        {
            i--;
            if (i < 0)
            {
                return makeCompoundCondition$V(modulemethod, aobj1);
            }
            aobj1[i] = aobj[i + 1];
        } while (true);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 10: // '\n'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 4: // '\004'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 6 9: default 40
    //                   6 131
    //                   7 98
    //                   8 40
    //                   9 54;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L6:
        return i;
_L4:
        if (!(obj instanceof condition)) goto _L6; else goto _L5
_L5:
        callcontext.value1 = obj;
        if (!(obj1 instanceof condition.Mntype))
        {
            return 0xfff40002;
        } else
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
_L3:
        if (!(obj instanceof condition)) goto _L6; else goto _L7
_L7:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L2:
        callcontext.value1 = obj;
        if (!(obj1 instanceof condition.Mntype))
        {
            return 0xfff40002;
        } else
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 3)
        {
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof condition.Mntype))
            {
                return 0xfff40002;
            } else
            {
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            }
        } else
        {
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);
        }
    }

    public int matchN(ModuleMethod modulemethod, Object aobj[], CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 6: // '\006'
        case 7: // '\007'
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 8: // '\b'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 5: // '\005'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        $Amcondition = new condition.Mntype(Lit0, Boolean.FALSE, LList.Empty, LList.Empty);
        SimpleSymbol simplesymbol = Lit1;
        callcontext = ((CallContext) ($Amcondition));
        condition.Mntype mntype;
        try
        {
            mntype = (condition.Mntype)callcontext;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "make-condition-type", 1, callcontext);
        }
        $Ammessage = makeConditionType(simplesymbol, mntype, Lit2);
        simplesymbol = Lit3;
        callcontext = ((CallContext) ($Amcondition));
        try
        {
            mntype = (condition.Mntype)callcontext;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "make-condition-type", 1, callcontext);
        }
        $Amserious = makeConditionType(simplesymbol, mntype, LList.Empty);
        simplesymbol = Lit4;
        callcontext = ((CallContext) ($Amserious));
        try
        {
            mntype = (condition.Mntype)callcontext;
        }
        catch (ClassCastException classcastexception2)
        {
            throw new WrongType(classcastexception2, "make-condition-type", 1, callcontext);
        }
        $Amerror = makeConditionType(simplesymbol, mntype, LList.Empty);
    }

    static 
    {
        Lit22 = (SimpleSymbol)(new SimpleSymbol("thing")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("type-field-alist->condition")).readResolve();
        Object obj = (SimpleSymbol)(new SimpleSymbol("condition")).readResolve();
        Lit18 = ((SimpleSymbol) (obj));
        Object obj1 = new SyntaxRule(new SyntaxPattern("\f\030]\f\007-\f\017\f\027\b\b\020\b\000\030\b", new Object[0], 3), "\003\005\005", "\021\030\004\b\021\030\f\b\005\021\030\024\t\003\b\021\030\f\b\r\021\030\024)\021\030\034\b\013\b\023", new Object[] {
            Lit20, (SimpleSymbol)(new SimpleSymbol("list")).readResolve(), (SimpleSymbol)(new SimpleSymbol("cons")).readResolve(), Lit21
        }, 2);
        Lit19 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 3);
        Lit17 = (SimpleSymbol)(new SimpleSymbol("extract-condition")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("make-compound-condition")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("condition-ref")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("condition-type-field-alist")).readResolve();
        Lit13 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\b", new Object[0], 1), "\001", "\021\030\004\b\021\030\f\021\030\024\b\003", new Object[] {
            PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("$lookup$")).readResolve(), Pair.make((SimpleSymbol)(new SimpleSymbol("*")).readResolve(), Pair.make(Pair.make((SimpleSymbol)(new SimpleSymbol("quasiquote")).readResolve(), Pair.make((SimpleSymbol)(new SimpleSymbol(".type-field-alist")).readResolve(), LList.Empty)), LList.Empty)), "conditions.scm", 0x8e007), (SimpleSymbol)(new SimpleSymbol("as")).readResolve(), (SimpleSymbol)(new SimpleSymbol("<condition>")).readResolve()
        }, 0);
        Lit14 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 1);
        Lit12 = (SimpleSymbol)(new SimpleSymbol("condition-has-type?")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("make-condition")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("condition?")).readResolve();
        obj = (SimpleSymbol)(new SimpleSymbol("define-condition-type")).readResolve();
        Lit8 = ((SimpleSymbol) (obj));
        obj1 = new SyntaxPattern("\f\030\f\007\f\017\f\027-\f\037\f'\b\030\020\b", new Object[0], 5);
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        SimpleSymbol simplesymbol1 = (SimpleSymbol)(new SimpleSymbol("define")).readResolve();
        SimpleSymbol simplesymbol2 = (SimpleSymbol)(new SimpleSymbol("make-condition-type")).readResolve();
        Lit7 = simplesymbol2;
        obj1 = new SyntaxRule(((SyntaxPattern) (obj1)), "\001\001\001\003\003", "\021\030\004\311\021\030\f\t\003\b\021\030\024)\021\030\034\b\003\t\013\b\021\030\034\b\b\035\033\301\021\030\f!\t\023\030$\b\021\030,\021\0304\b\021\030<\021\030D\b\003\b%\021\030\f!\t#\030L\b\021\030TA\021\030\\\021\030d\b\003\b\021\030\034\b\033", new Object[] {
            simplesymbol, simplesymbol1, simplesymbol2, Lit21, PairWithPosition.make(Lit22, LList.Empty, "conditions.scm", 0x5001c), (SimpleSymbol)(new SimpleSymbol("and")).readResolve(), PairWithPosition.make(Lit10, PairWithPosition.make(Lit22, LList.Empty, "conditions.scm", 0x5101b), "conditions.scm", 0x5100f), Lit12, Lit22, PairWithPosition.make(Lit18, LList.Empty, "conditions.scm", 0x5301c), 
            Lit15, Lit17, Lit18
        }, 1);
        Lit9 = new SyntaxRules(new Object[] {
            obj
        }, new SyntaxRule[] {
            obj1
        }, 5);
        Lit6 = (SimpleSymbol)(new SimpleSymbol("condition-type?")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("message")).readResolve();
        Lit2 = PairWithPosition.make(Lit5, LList.Empty, "conditions.scm", 0xe2003);
        $instance = new conditions();
        obj = $instance;
        condition$Mntype$Qu = new ModuleMethod(((ModuleBody) (obj)), 2, Lit6, 4097);
        make$Mncondition$Mntype = new ModuleMethod(((ModuleBody) (obj)), 3, Lit7, 12291);
        define$Mncondition$Mntype = Macro.make(Lit8, Lit9, $instance);
        condition$Qu = new ModuleMethod(((ModuleBody) (obj)), 4, Lit10, 4097);
        make$Mncondition = new ModuleMethod(((ModuleBody) (obj)), 5, Lit11, -4095);
        condition$Mnhas$Mntype$Qu = new ModuleMethod(((ModuleBody) (obj)), 6, Lit12, 8194);
        condition$Mntype$Mnfield$Mnalist = Macro.make(Lit13, Lit14, $instance);
        condition$Mnref = new ModuleMethod(((ModuleBody) (obj)), 7, Lit15, 8194);
        make$Mncompound$Mncondition = new ModuleMethod(((ModuleBody) (obj)), 8, Lit16, -4095);
        extract$Mncondition = new ModuleMethod(((ModuleBody) (obj)), 9, Lit17, 8194);
        condition = Macro.make(Lit18, Lit19, $instance);
        $Prvt$type$Mnfield$Mnalist$Mn$Grcondition = new ModuleMethod(((ModuleBody) (obj)), 10, Lit20, 4097);
        $instance.run();
    }
}
