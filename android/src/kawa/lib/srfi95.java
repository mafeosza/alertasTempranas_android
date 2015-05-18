// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.DivideOp;
import gnu.kawa.lispexpr.LangObjType;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.Sequence;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.standard.Scheme;
import kawa.standard.append;

// Referenced classes of package kawa.lib:
//            lists, vectors, numbers

public class srfi95 extends ModuleBody
{
    public class frame extends ModuleBody
    {

        Object key;
        Object less$Qu;

        public Object lambda1loop(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
        {
            if (Scheme.applyToArgs.apply3(less$Qu, obj4, obj1) != Boolean.FALSE)
            {
                if (lists.isNull(obj5))
                {
                    return lists.cons(obj3, lists.cons(obj, obj2));
                } else
                {
                    return lists.cons(obj3, lambda1loop(obj, obj1, obj2, lists.car.apply1(obj5), Scheme.applyToArgs.apply2(key, lists.car.apply1(obj5)), lists.cdr.apply1(obj5)));
                }
            }
            if (lists.isNull(obj2))
            {
                return lists.cons(obj, lists.cons(obj3, obj5));
            } else
            {
                return lists.cons(obj, lambda1loop(lists.car.apply1(obj2), Scheme.applyToArgs.apply2(key, lists.car.apply1(obj2)), lists.cdr.apply1(obj2), obj3, obj4, obj5));
            }
        }

        public frame()
        {
        }
    }

    public class frame0 extends ModuleBody
    {

        Object keyer;
        Object less$Qu;
        Object seq;

        public Object lambda2step(Object obj)
        {
            if (Scheme.numGrt.apply2(obj, srfi95.Lit1) != Boolean.FALSE)
            {
                Object obj1 = DivideOp.quotient.apply2(obj, srfi95.Lit1);
                return srfi95.sort$ClMerge$Ex(lambda2step(obj1), lambda2step(AddOp.$Mn.apply2(obj, obj1)), less$Qu, keyer);
            }
            if (Scheme.numEqu.apply2(obj, srfi95.Lit1) != Boolean.FALSE)
            {
                Object obj2 = lists.car.apply1(seq);
                Object obj3 = lists.cadr.apply1(seq);
                obj = seq;
                seq = lists.cddr.apply1(seq);
                if (Scheme.applyToArgs.apply3(less$Qu, Scheme.applyToArgs.apply2(keyer, obj3), Scheme.applyToArgs.apply2(keyer, obj2)) != Boolean.FALSE)
                {
                    Pair pair;
                    try
                    {
                        pair = (Pair)obj;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj2)
                    {
                        throw new WrongType(((ClassCastException) (obj2)), "set-car!", 1, obj);
                    }
                    lists.setCar$Ex(pair, obj3);
                    obj3 = lists.cdr.apply1(obj);
                    try
                    {
                        pair = (Pair)obj3;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, obj3);
                    }
                    lists.setCar$Ex(pair, obj2);
                }
                obj2 = lists.cdr.apply1(obj);
                try
                {
                    obj3 = (Pair)obj2;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj2);
                }
                lists.setCdr$Ex(((Pair) (obj3)), LList.Empty);
                return obj;
            }
            if (Scheme.numEqu.apply2(obj, srfi95.Lit2) != Boolean.FALSE)
            {
                obj = seq;
                seq = lists.cdr.apply1(seq);
                try
                {
                    obj2 = (Pair)obj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "set-cdr!", 1, obj);
                }
                lists.setCdr$Ex(((Pair) (obj2)), LList.Empty);
                return obj;
            } else
            {
                return LList.Empty;
            }
        }

        public frame0()
        {
        }
    }

    public class frame1 extends ModuleBody
    {

        Object key;
        Object less$Qu;

        public Object lambda3loop(Object obj, Object obj1, Object obj2, Object obj3, Object obj4)
        {
            if (Scheme.applyToArgs.apply3(less$Qu, obj4, obj2) != Boolean.FALSE)
            {
                try
                {
                    obj4 = (Pair)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
                }
                lists.setCdr$Ex(((Pair) (obj4)), obj3);
                if (lists.isNull(lists.cdr.apply1(obj3)))
                {
                    try
                    {
                        obj = (Pair)obj3;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj3);
                    }
                    lists.setCdr$Ex(((Pair) (obj)), obj1);
                    return Values.empty;
                } else
                {
                    return lambda3loop(obj3, obj1, obj2, lists.cdr.apply1(obj3), Scheme.applyToArgs.apply2(key, lists.cadr.apply1(obj3)));
                }
            }
            try
            {
                obj2 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
            }
            lists.setCdr$Ex(((Pair) (obj2)), obj1);
            if (lists.isNull(lists.cdr.apply1(obj1)))
            {
                try
                {
                    obj = (Pair)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj1);
                }
                lists.setCdr$Ex(((Pair) (obj)), obj3);
                return Values.empty;
            } else
            {
                return lambda3loop(obj1, lists.cdr.apply1(obj1), Scheme.applyToArgs.apply2(key, lists.cadr.apply1(obj1)), obj3, obj4);
            }
        }

        public frame1()
        {
        }
    }


    public static final ModuleMethod $Pcsort$Mnlist;
    public static final ModuleMethod $Pcsort$Mnvector;
    public static final ModuleMethod $Pcvector$Mnsort$Ex;
    public static final srfi95 $instance;
    static final IntNum Lit0 = IntNum.make(-1);
    static final IntNum Lit1 = IntNum.make(2);
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final IntNum Lit2 = IntNum.make(1);
    static final IntNum Lit3 = IntNum.make(0);
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    static final ModuleMethod identity;
    public static final ModuleMethod merge;
    public static final ModuleMethod merge$Ex;
    public static final ModuleMethod sort;
    public static final ModuleMethod sort$Ex;
    public static final ModuleMethod sorted$Qu;

    public static Object $PcSortList(Object obj, Object obj1, Object obj2)
    {
        frame0 frame0_1;
        frame0_1 = new frame0();
        frame0_1.seq = obj;
        frame0_1.Qu = obj1;
        frame0_1.keyer = Special.undefined;
        if (obj2 != Boolean.FALSE)
        {
            obj = lists.car;
        } else
        {
            obj = identity;
        }
        frame0_1.keyer = obj;
        if (obj2 == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        obj = frame0_1.seq;
_L4:
        if (lists.isNull(obj))
        {
            obj = frame0_1.seq;
            try
            {
                obj1 = (LList)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "length", 1, obj);
            }
            frame0_1.seq = frame0_1.lambda2step(Integer.valueOf(lists.length(((LList) (obj1)))));
            obj = frame0_1.seq;
            break MISSING_BLOCK_LABEL_90;
        } else
        {
            try
            {
                obj1 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(((Pair) (obj1)), lists.cons(Scheme.applyToArgs.apply2(obj2, lists.car.apply1(obj)), lists.car.apply1(obj)));
            obj = lists.cdr.apply1(obj);
            continue; /* Loop/switch isn't completed */
        }
        do
        {
            if (lists.isNull(obj))
            {
                return frame0_1.seq;
            }
            try
            {
                obj1 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-car!", 1, obj);
            }
            lists.setCar$Ex(((Pair) (obj1)), lists.cdar.apply1(obj));
            obj = lists.cdr.apply1(obj);
        } while (true);
_L2:
        obj = frame0_1.seq;
        obj1 = (LList)obj;
        return frame0_1.lambda2step(Integer.valueOf(lists.length(((LList) (obj1)))));
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "length", 1, obj);
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static void $PcSortVector(Sequence sequence, Object obj)
    {
        $PcSortVector(sequence, obj, Boolean.FALSE);
    }

    public static void $PcSortVector(Sequence sequence, Object obj, Object obj1)
    {
        gnu.lists.FVector fvector = vectors.makeVector(sequence.size());
        obj = $PcSortList(rank$Mn1Array$To$List(sequence), obj, obj1);
        sequence = Lit3;
        while (!lists.isNull(obj)) 
        {
            int i;
            try
            {
                i = ((Number)sequence).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "vector-set!", 2, sequence);
            }
            vectors.vectorSet$Ex(fvector, i, lists.car.apply1(obj));
            obj = lists.cdr.apply1(obj);
            sequence = ((Sequence) (AddOp.$Pl.apply2(sequence, Lit2)));
        }
    }

    public static Object $PcVectorSort$Ex(Sequence sequence, Object obj, Object obj1)
    {
        obj1 = $PcSortList(rank$Mn1Array$To$List(sequence), obj, obj1);
        for (obj = Lit3; !lists.isNull(obj1); obj = AddOp.$Pl.apply2(obj, Lit2))
        {
            sequence.set(((Number)obj).intValue(), lists.car.apply1(obj1));
            obj1 = lists.cdr.apply1(obj1);
        }

        return sequence;
    }

    public srfi95()
    {
        ModuleInfo.register(this);
    }

    static Object identity(Object obj)
    {
        return obj;
    }

    public static Object isSorted(Object obj, Object obj1)
    {
        return isSorted(obj, obj1, identity);
    }

    public static Object isSorted(Object obj, Object obj1, Object obj2)
    {
        if (lists.isNull(obj))
        {
            return Boolean.TRUE;
        }
        Object obj3;
        if (obj instanceof Sequence)
        {
            Object obj5;
            boolean flag;
            int j;
            try
            {
                obj5 = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "arr", -2, obj);
            }
            j = ((Sequence) (obj5)).size() - 1;
            if (j <= 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                if (flag)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
            obj = Integer.valueOf(j - 1);
            obj3 = Scheme.applyToArgs.apply2(obj2, ((Sequence) (obj5)).get(j));
            do
            {
                Object obj4;
                int i;
                boolean flag1;
                try
                {
                    obj4 = LangObjType.coerceRealNum(obj);
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "negative?", 1, obj);
                }
                flag1 = numbers.isNegative(((gnu.math.RealNum) (obj4)));
                if (flag1)
                {
                    if (flag1)
                    {
                        return Boolean.TRUE;
                    } else
                    {
                        return Boolean.FALSE;
                    }
                }
                obj4 = Scheme.applyToArgs;
                try
                {
                    i = ((Number)obj).intValue();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj1)
                {
                    throw new WrongType(((ClassCastException) (obj1)), "gnu.lists.Sequence.get(int)", 2, obj);
                }
                obj4 = ((Procedure) (obj4)).apply2(obj2, ((Sequence) (obj5)).get(i));
                obj3 = Scheme.applyToArgs.apply3(obj1, obj4, obj3);
                if (obj3 != Boolean.FALSE)
                {
                    obj = AddOp.$Pl.apply2(Lit0, obj);
                    obj3 = obj4;
                } else
                {
                    return obj3;
                }
            } while (true);
        }
        if (lists.isNull(lists.cdr.apply1(obj)))
        {
            return Boolean.TRUE;
        }
        obj3 = Scheme.applyToArgs.apply2(obj2, lists.car.apply1(obj));
        obj = lists.cdr.apply1(obj);
        do
        {
            flag1 = lists.isNull(obj);
            if (flag1)
            {
                if (flag1)
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }
            }
            obj4 = Scheme.applyToArgs.apply2(obj2, lists.car.apply1(obj));
            obj3 = Scheme.applyToArgs.apply3(obj1, obj4, obj3);
            try
            {
                obj5 = Boolean.FALSE;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "x", -2, obj3);
            }
            if (obj3 != obj5)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            i = i + 1 & 1;
            if (i != 0)
            {
                obj = lists.cdr.apply1(obj);
                obj3 = obj4;
            } else
            if (i != 0)
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }
        } while (true);
    }

    public static Object merge(Object obj, Object obj1, Object obj2)
    {
        return merge(obj, obj1, obj2, identity);
    }

    public static Object merge(Object obj, Object obj1, Object obj2, Object obj3)
    {
        frame frame2 = new frame();
        frame2.Qu = obj2;
        frame2.key = obj3;
        if (lists.isNull(obj))
        {
            return obj1;
        }
        if (lists.isNull(obj1))
        {
            return obj;
        } else
        {
            return frame2.lambda1loop(lists.car.apply1(obj), Scheme.applyToArgs.apply2(frame2.key, lists.car.apply1(obj)), lists.cdr.apply1(obj), lists.car.apply1(obj1), Scheme.applyToArgs.apply2(frame2.key, lists.car.apply1(obj1)), lists.cdr.apply1(obj1));
        }
    }

    public static Object merge$Ex(Object obj, Object obj1, Object obj2)
    {
        return merge$Ex(obj, obj1, obj2, identity);
    }

    public static Object merge$Ex(Object obj, Object obj1, Object obj2, Object obj3)
    {
        return sort$ClMerge$Ex(obj, obj1, obj2, obj3);
    }

    static Object rank$Mn1Array$To$List(Sequence sequence)
    {
        int i = sequence.size() - 1;
        Object obj = LList.Empty;
        do
        {
            if (i < 0)
            {
                return obj;
            }
            obj = lists.cons(sequence.get(i), obj);
            i--;
        } while (true);
    }

    public static Object sort(Sequence sequence, Object obj)
    {
        return sort(sequence, obj, Boolean.FALSE);
    }

    public static Object sort(Sequence sequence, Object obj, Object obj1)
    {
        if (lists.isList(sequence))
        {
            return $PcSortList(append.append$V(new Object[] {
                sequence, LList.Empty
            }), obj, obj1);
        } else
        {
            $PcSortVector(sequence, obj, obj1);
            return Values.empty;
        }
    }

    static Object sort$ClMerge$Ex(Object obj, Object obj1, Object obj2, Object obj3)
    {
        frame1 frame1_1 = new frame1();
        frame1_1.Qu = obj2;
        frame1_1.key = obj3;
        if (lists.isNull(obj))
        {
            return obj1;
        }
        if (lists.isNull(obj1))
        {
            return obj;
        }
        obj2 = Scheme.applyToArgs.apply2(frame1_1.key, lists.car.apply1(obj));
        obj3 = Scheme.applyToArgs.apply2(frame1_1.key, lists.car.apply1(obj1));
        if (Scheme.applyToArgs.apply3(frame1_1.Qu, obj3, obj2) != Boolean.FALSE)
        {
            if (lists.isNull(lists.cdr.apply1(obj1)))
            {
                try
                {
                    obj2 = (Pair)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, obj1);
                }
                lists.setCdr$Ex(((Pair) (obj2)), obj);
                return obj1;
            } else
            {
                frame1_1.lambda3loop(obj1, obj, obj2, lists.cdr.apply1(obj1), Scheme.applyToArgs.apply2(frame1_1.key, lists.cadr.apply1(obj1)));
                return obj1;
            }
        }
        if (lists.isNull(lists.cdr.apply1(obj)))
        {
            try
            {
                obj2 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "set-cdr!", 1, obj);
            }
            lists.setCdr$Ex(((Pair) (obj2)), obj1);
        } else
        {
            frame1_1.lambda3loop(obj, lists.cdr.apply1(obj), Scheme.applyToArgs.apply2(frame1_1.key, lists.cadr.apply1(obj)), obj1, obj3);
        }
        return obj;
    }

    public static Object sort$Ex(Sequence sequence, Object obj)
    {
        return sort$Ex(sequence, obj, Boolean.FALSE);
    }

    public static Object sort$Ex(Sequence sequence, Object obj, Object obj1)
    {
        if (lists.isList(sequence))
        {
            obj1 = $PcSortList(sequence, obj, obj1);
            if (obj1 != sequence)
            {
                for (obj = obj1; lists.cdr.apply1(obj) != sequence; obj = lists.cdr.apply1(obj)) { }
                Object obj2;
                Pair pair;
                try
                {
                    obj2 = (Pair)obj;
                }
                // Misplaced declaration of an exception variable
                catch (Sequence sequence)
                {
                    throw new WrongType(sequence, "set-cdr!", 1, obj);
                }
                lists.setCdr$Ex(((Pair) (obj2)), obj1);
                obj2 = lists.car.apply1(sequence);
                obj = lists.cdr.apply1(sequence);
                try
                {
                    pair = (Pair)sequence;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-car!", 1, sequence);
                }
                lists.setCar$Ex(pair, lists.car.apply1(obj1));
                try
                {
                    pair = (Pair)sequence;
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw new WrongType(((ClassCastException) (obj)), "set-cdr!", 1, sequence);
                }
                lists.setCdr$Ex(pair, lists.cdr.apply1(obj1));
                try
                {
                    pair = (Pair)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Sequence sequence)
                {
                    throw new WrongType(sequence, "set-car!", 1, obj1);
                }
                lists.setCar$Ex(pair, obj2);
                try
                {
                    obj2 = (Pair)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (Sequence sequence)
                {
                    throw new WrongType(sequence, "set-cdr!", 1, obj1);
                }
                lists.setCdr$Ex(((Pair) (obj2)), obj);
            }
            return sequence;
        } else
        {
            return $PcVectorSort$Ex(sequence, obj, obj1);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            return identity(obj);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 2: // '\002'
            return isSorted(obj, obj1);

        case 9: // '\t'
            try
            {
                modulemethod = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "sort!", 1, obj);
            }
            return sort$Ex(modulemethod, obj1);

        case 12: // '\f'
            try
            {
                modulemethod = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%sort-vector", 1, obj);
            }
            $PcSortVector(modulemethod, obj1);
            return Values.empty;

        case 14: // '\016'
            break;
        }
        try
        {
            modulemethod = (Sequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "sort", 1, obj);
        }
        return sort(modulemethod, obj1);
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 5: // '\005'
        case 7: // '\007'
        case 10: // '\n'
        case 13: // '\r'
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 2: // '\002'
            return isSorted(obj, obj1, obj2);

        case 4: // '\004'
            return merge(obj, obj1, obj2);

        case 6: // '\006'
            return merge$Ex(obj, obj1, obj2);

        case 8: // '\b'
            return $PcSortList(obj, obj1, obj2);

        case 9: // '\t'
            try
            {
                modulemethod = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "sort!", 1, obj);
            }
            return sort$Ex(modulemethod, obj1, obj2);

        case 11: // '\013'
            try
            {
                modulemethod = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%vector-sort!", 1, obj);
            }
            return $PcVectorSort$Ex(modulemethod, obj1, obj2);

        case 12: // '\f'
            try
            {
                modulemethod = (Sequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "%sort-vector", 1, obj);
            }
            $PcSortVector(modulemethod, obj1, obj2);
            return Values.empty;

        case 14: // '\016'
            break;
        }
        try
        {
            modulemethod = (Sequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "sort", 1, obj);
        }
        return sort(modulemethod, obj1, obj2);
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        default:
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);

        case 4: // '\004'
            return merge(obj, obj1, obj2, obj3);

        case 6: // '\006'
            return merge$Ex(obj, obj1, obj2, obj3);
        }
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

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR lookupswitch 4: default 52
    //                   2: 165
    //                   9: 132
    //                   12: 99
    //                   14: 66;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L7:
        return i;
_L5:
        if (!(obj instanceof Sequence)) goto _L7; else goto _L6
_L6:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L4:
        if (!(obj instanceof Sequence)) goto _L7; else goto _L8
_L8:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L3:
        if (!(obj instanceof Sequence)) goto _L7; else goto _L9
_L9:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L2:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 2 14: default 76
    //                   2 351
    //                   3 76
    //                   4 318
    //                   5 76
    //                   6 285
    //                   7 76
    //                   8 252
    //                   9 212
    //                   10 76
    //                   11 172
    //                   12 132
    //                   13 76
    //                   14 92;
           goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L5 _L6 _L1 _L7 _L8 _L1 _L9
_L1:
        i = super.match3(modulemethod, obj, obj1, obj2, callcontext);
_L11:
        return i;
_L9:
        if (!(obj instanceof Sequence)) goto _L11; else goto _L10
_L10:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L8:
        if (!(obj instanceof Sequence)) goto _L11; else goto _L12
_L12:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L7:
        if (!(obj instanceof Sequence)) goto _L11; else goto _L13
_L13:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L6:
        if (!(obj instanceof Sequence)) goto _L11; else goto _L14
_L14:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L5:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L4:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L3:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
_L2:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.value3 = obj2;
        callcontext.proc = modulemethod;
        callcontext.pc = 3;
        return 0;
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 5: // '\005'
        default:
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

        case 6: // '\006'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;

        case 4: // '\004'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit12 = (SimpleSymbol)(new SimpleSymbol("sort")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("%sort-vector")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("%vector-sort!")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("sort!")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("%sort-list")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("merge!")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("merge")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("sorted?")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("identity")).readResolve();
        $instance = new srfi95();
        srfi95 srfi95_1 = $instance;
        identity = new ModuleMethod(srfi95_1, 1, Lit4, 4097);
        sorted$Qu = new ModuleMethod(srfi95_1, 2, Lit5, 12290);
        merge = new ModuleMethod(srfi95_1, 4, Lit6, 16387);
        merge$Ex = new ModuleMethod(srfi95_1, 6, Lit7, 16387);
        $Pcsort$Mnlist = new ModuleMethod(srfi95_1, 8, Lit8, 12291);
        sort$Ex = new ModuleMethod(srfi95_1, 9, Lit9, 12290);
        $Pcvector$Mnsort$Ex = new ModuleMethod(srfi95_1, 11, Lit10, 12291);
        $Pcsort$Mnvector = new ModuleMethod(srfi95_1, 12, Lit11, 12290);
        sort = new ModuleMethod(srfi95_1, 14, Lit12, 12290);
        $instance.run();
    }
}
