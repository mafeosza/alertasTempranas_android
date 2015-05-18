// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.lispexpr.LangObjType;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.HashNode;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import kawa.lib.kawa.hashtable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.numbers;
import kawa.lib.rnrs.hashtables;
import kawa.lib.rnrs.unicode;
import kawa.lib.strings;
import kawa.standard.Scheme;

public class srfi69 extends ModuleBody
{

    public static final srfi69 $instance;
    static final IntNum Lit0 = IntNum.make(64);
    static final SimpleSymbol Lit1;
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
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod alist$Mn$Grhash$Mntable;
    public static final ModuleMethod hash;
    public static final ModuleMethod hash$Mnby$Mnidentity;
    public static final ModuleMethod hash$Mntable$Mn$Gralist;
    public static final ModuleMethod hash$Mntable$Mncopy;
    public static final Location hash$Mntable$Mndelete$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mndelete$Ex");
    public static final ModuleMethod hash$Mntable$Mnequivalence$Mnfunction;
    public static final Location hash$Mntable$Mnexists$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mncontains$Qu");
    public static final ModuleMethod hash$Mntable$Mnfold;
    public static final ModuleMethod hash$Mntable$Mnhash$Mnfunction;
    public static final ModuleMethod hash$Mntable$Mnkeys;
    public static final ModuleMethod hash$Mntable$Mnmerge$Ex;
    public static final ModuleMethod hash$Mntable$Mnref;
    public static final ModuleMethod hash$Mntable$Mnref$Sldefault;
    public static final Location hash$Mntable$Mnset$Ex = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnset$Ex");
    public static final Location hash$Mntable$Mnsize = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Mnsize");
    public static final ModuleMethod hash$Mntable$Mnupdate$Ex;
    public static final ModuleMethod hash$Mntable$Mnupdate$Ex$Sldefault;
    public static final ModuleMethod hash$Mntable$Mnvalues;
    public static final ModuleMethod hash$Mntable$Mnwalk;
    public static final Location hash$Mntable$Qu = StaticFieldLocation.make("kawa.lib.rnrs.hashtables", "hashtable$Qu");
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn3;
    public static final ModuleMethod make$Mnhash$Mntable;
    public static final ModuleMethod string$Mnci$Mnhash;
    public static final ModuleMethod string$Mnhash;

    public srfi69()
    {
        ModuleInfo.register(this);
    }

    public static kawa.lib.kawa.hashtable.HashTable alist$To$HashTable(Object obj)
    {
        return alist$To$HashTable(obj, Scheme.isEqual);
    }

    public static kawa.lib.kawa.hashtable.HashTable alist$To$HashTable(Object obj, Object obj1)
    {
        return alist$To$HashTable(obj, obj1, appropriateHashFunctionFor(obj1));
    }

    public static kawa.lib.kawa.hashtable.HashTable alist$To$HashTable(Object obj, Object obj1, Object obj2)
    {
        IntNum intnum = Lit0;
        LList llist;
        try
        {
            llist = (LList)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "length", 1, obj);
        }
        return alist$To$HashTable(obj, obj1, obj2, numbers.max(new Object[] {
            intnum, Integer.valueOf(lists.length(llist) * 2)
        }));
    }

    public static kawa.lib.kawa.hashtable.HashTable alist$To$HashTable(Object obj, Object obj1, Object obj2, Object obj3)
    {
        Procedure procedure;
        int i;
        try
        {
            procedure = (Procedure)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-hash-table", 0, obj1);
        }
        try
        {
            obj1 = (Procedure)obj2;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-hash-table", 1, obj2);
        }
        try
        {
            i = ((Number)obj3).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "make-hash-table", 2, obj3);
        }
        obj1 = makeHashTable(procedure, ((Procedure) (obj1)), i);
        do
        {
            if (obj == LList.Empty)
            {
                return ((kawa.lib.kawa.hashtable.HashTable) (obj1));
            }
            try
            {
                obj2 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
            }
            obj = ((Pair) (obj2)).getCar();
            hashTableUpdate$Ex$SlDefault(((kawa.lib.kawa.hashtable.HashTable) (obj1)), lists.car.apply1(obj), lambda$Fn1, lists.cdr.apply1(obj));
            obj = ((Pair) (obj2)).getCdr();
        } while (true);
    }

    static Procedure appropriateHashFunctionFor(Object obj)
    {
        Object obj1;
        boolean flag;
        if (obj == Scheme.isEq)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj1 = hash$Mnby$Mnidentity;
        } else
        if (flag)
        {
            obj1 = Boolean.TRUE;
        } else
        {
            obj1 = Boolean.FALSE;
        }
        if (obj1 != Boolean.FALSE)
        {
            return (Procedure)obj1;
        }
        if (obj == strings.string$Eq$Qu)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj1 = string$Mnhash;
        } else
        if (flag)
        {
            obj1 = Boolean.TRUE;
        } else
        {
            obj1 = Boolean.FALSE;
        }
        if (obj1 != Boolean.FALSE)
        {
            return (Procedure)obj1;
        }
        if (obj == unicode.string$Mnci$Eq$Qu)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            obj = string$Mnci$Mnhash;
        } else
        if (flag)
        {
            obj = Boolean.TRUE;
        } else
        {
            obj = Boolean.FALSE;
        }
        if (obj != Boolean.FALSE)
        {
            return (Procedure)obj;
        } else
        {
            return hash;
        }
    }

    public static Object hash(Object obj)
    {
        return hash(obj, null);
    }

    public static Object hash(Object obj, IntNum intnum)
    {
        int i;
        if (obj == null)
        {
            i = 0;
        } else
        {
            i = obj.hashCode();
        }
        if (intnum == null)
        {
            return Integer.valueOf(i);
        } else
        {
            return IntNum.modulo(IntNum.make(i), intnum);
        }
    }

    public static Object hashByIdentity(Object obj)
    {
        return hashByIdentity(obj, null);
    }

    public static Object hashByIdentity(Object obj, IntNum intnum)
    {
        int i = System.identityHashCode(obj);
        if (intnum == null)
        {
            return Integer.valueOf(i);
        } else
        {
            return IntNum.modulo(IntNum.make(i), intnum);
        }
    }

    public static Object hashTable$To$Alist(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashtable1.toAlist();
    }

    public static kawa.lib.kawa.hashtable.HashTable hashTableCopy(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return new kawa.lib.kawa.hashtable.HashTable(hashtable1, true);
    }

    public static Procedure hashTableEquivalenceFunction(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashtable1.equivalenceFunction;
    }

    public static Object hashTableFold(kawa.lib.kawa.hashtable.HashTable hashtable1, Procedure procedure, Object obj)
    {
        return hashtable1.fold(procedure, obj);
    }

    public static Procedure hashTableHashFunction(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashtable1.hashFunction;
    }

    public static Object hashTableKeys(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashTableFold(hashtable1, lambda$Fn2, LList.Empty);
    }

    public static void hashTableMerge$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, kawa.lib.kawa.hashtable.HashTable hashtable2)
    {
        hashtable1.putAll(hashtable2);
    }

    public static Object hashTableRef(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj)
    {
        return hashTableRef(hashtable1, obj, Boolean.FALSE);
    }

    public static Object hashTableRef(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1)
    {
        hashtable1 = hashtable1.getNode(obj);
        if (hashtable1 == null)
        {
            if (obj1 != Boolean.FALSE)
            {
                return Scheme.applyToArgs.apply1(obj1);
            } else
            {
                return misc.error$V("hash-table-ref: no value associated with", new Object[] {
                    obj
                });
            }
        } else
        {
            return hashtable1.getValue();
        }
    }

    public static Object hashTableRef$SlDefault(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1)
    {
        return hashtable1.get(obj, obj1);
    }

    public static void hashTableUpdate$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1)
    {
        hashTableUpdate$Ex(hashtable1, obj, obj1, Boolean.FALSE);
    }

    public static void hashTableUpdate$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1, Object obj2)
    {
        hashtable.hashtableCheckMutable(hashtable1);
        HashNode hashnode = hashtable1.getNode(obj);
        if (hashnode == null)
        {
            if (obj2 != Boolean.FALSE)
            {
                hashtables.hashtableSet$Ex(hashtable1, obj, Scheme.applyToArgs.apply2(obj1, Scheme.applyToArgs.apply1(obj2)));
                return;
            } else
            {
                misc.error$V("hash-table-update!: no value exists for key", new Object[] {
                    obj
                });
                return;
            }
        } else
        {
            hashnode.setValue(Scheme.applyToArgs.apply2(obj1, hashnode.getValue()));
            return;
        }
    }

    public static void hashTableUpdate$Ex$SlDefault(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1, Object obj2)
    {
        hashtable.hashtableCheckMutable(hashtable1);
        HashNode hashnode = hashtable1.getNode(obj);
        if (hashnode == null)
        {
            hashtables.hashtableSet$Ex(hashtable1, obj, Scheme.applyToArgs.apply2(obj1, obj2));
            return;
        } else
        {
            hashnode.setValue(Scheme.applyToArgs.apply2(obj1, hashnode.getValue()));
            return;
        }
    }

    public static Object hashTableValues(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashTableFold(hashtable1, lambda$Fn3, LList.Empty);
    }

    public static void hashTableWalk(kawa.lib.kawa.hashtable.HashTable hashtable1, Procedure procedure)
    {
        hashtable1.walk(procedure);
    }

    static Object lambda1(Object obj)
    {
        return obj;
    }

    static Pair lambda2(Object obj, Object obj1, Object obj2)
    {
        return lists.cons(obj, obj2);
    }

    static Pair lambda3(Object obj, Object obj1, Object obj2)
    {
        return lists.cons(obj1, obj2);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeHashTable()
    {
        return makeHashTable(((Procedure) (Scheme.isEqual)));
    }

    public static kawa.lib.kawa.hashtable.HashTable makeHashTable(Procedure procedure)
    {
        return makeHashTable(procedure, appropriateHashFunctionFor(procedure), 64);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeHashTable(Procedure procedure, Procedure procedure1)
    {
        return makeHashTable(procedure, procedure1, 64);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeHashTable(Procedure procedure, Procedure procedure1, int i)
    {
        return new kawa.lib.kawa.hashtable.HashTable(procedure, procedure1, i);
    }

    public static Object stringCiHash(Object obj)
    {
        return stringCiHash(obj, null);
    }

    public static Object stringCiHash(Object obj, IntNum intnum)
    {
        int i = obj.toString().toLowerCase().hashCode();
        if (intnum == null)
        {
            return Integer.valueOf(i);
        } else
        {
            return IntNum.modulo(IntNum.make(i), intnum);
        }
    }

    public static Object stringHash(CharSequence charsequence)
    {
        return stringHash(charsequence, null);
    }

    public static Object stringHash(CharSequence charsequence, IntNum intnum)
    {
        int i = charsequence.hashCode();
        if (intnum == null)
        {
            return Integer.valueOf(i);
        } else
        {
            return IntNum.modulo(IntNum.make(i), intnum);
        }
    }

    static Object symbolHash(Symbol symbol)
    {
        return symbolHash(symbol, null);
    }

    static Object symbolHash(Symbol symbol, IntNum intnum)
    {
        int i = symbol.hashCode();
        if (intnum == null)
        {
            return Integer.valueOf(i);
        } else
        {
            return IntNum.modulo(IntNum.make(i), intnum);
        }
    }

    static Object vectorHash(Object obj)
    {
        return vectorHash(obj, null);
    }

    static Object vectorHash(Object obj, IntNum intnum)
    {
        int i = obj.hashCode();
        if (intnum == null)
        {
            return Integer.valueOf(i);
        } else
        {
            return IntNum.modulo(IntNum.make(i), intnum);
        }
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 11)
        {
            return makeHashTable();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-hash", 1, obj);
            }
            return stringHash(modulemethod);

        case 3: // '\003'
            return stringCiHash(obj);

        case 5: // '\005'
            return hash(obj);

        case 7: // '\007'
            return hashByIdentity(obj);

        case 9: // '\t'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-equivalence-function", 1, obj);
            }
            return hashTableEquivalenceFunction(modulemethod);

        case 10: // '\n'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-hash-function", 1, obj);
            }
            return hashTableHashFunction(modulemethod);

        case 11: // '\013'
            try
            {
                modulemethod = (Procedure)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hash-table", 1, obj);
            }
            return makeHashTable(modulemethod);

        case 23: // '\027'
            return lambda1(obj);

        case 24: // '\030'
            return alist$To$HashTable(obj);

        case 28: // '\034'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table->alist", 1, obj);
            }
            return hashTable$To$Alist(modulemethod);

        case 29: // '\035'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-copy", 1, obj);
            }
            return hashTableCopy(modulemethod);

        case 32: // ' '
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-keys", 1, obj);
            }
            return hashTableKeys(modulemethod);

        case 34: // '"'
            break;
        }
        try
        {
            modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "hash-table-values", 1, obj);
        }
        return hashTableValues(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 1: // '\001'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-hash", 1, obj);
            }
            try
            {
                obj = LangObjType.coerceIntNum(obj1);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-hash", 2, obj1);
            }
            return stringHash(modulemethod, ((IntNum) (obj)));

        case 3: // '\003'
            try
            {
                modulemethod = LangObjType.coerceIntNum(obj1);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci-hash", 2, obj1);
            }
            return stringCiHash(obj, modulemethod);

        case 5: // '\005'
            try
            {
                modulemethod = LangObjType.coerceIntNum(obj1);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash", 2, obj1);
            }
            return hash(obj, modulemethod);

        case 7: // '\007'
            try
            {
                modulemethod = LangObjType.coerceIntNum(obj1);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-by-identity", 2, obj1);
            }
            return hashByIdentity(obj, modulemethod);

        case 11: // '\013'
            try
            {
                modulemethod = (Procedure)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hash-table", 1, obj);
            }
            try
            {
                obj = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hash-table", 2, obj1);
            }
            return makeHashTable(modulemethod, ((Procedure) (obj)));

        case 15: // '\017'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-ref", 1, obj);
            }
            return hashTableRef(modulemethod, obj1);

        case 21: // '\025'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-walk", 1, obj);
            }
            try
            {
                obj = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-walk", 2, obj1);
            }
            hashTableWalk(modulemethod, ((Procedure) (obj)));
            return Values.empty;

        case 24: // '\030'
            return alist$To$HashTable(obj, obj1);

        case 30: // '\036'
            break;
        }
        try
        {
            modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "hash-table-merge!", 1, obj);
        }
        try
        {
            obj = (kawa.lib.kawa.hashtable.HashTable)obj1;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "hash-table-merge!", 2, obj1);
        }
        hashTableMerge$Ex(modulemethod, ((kawa.lib.kawa.hashtable.HashTable) (obj)));
        return Values.empty;
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 11: // '\013'
            int i;
            try
            {
                modulemethod = (Procedure)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hash-table", 1, obj);
            }
            try
            {
                obj = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hash-table", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hash-table", 3, obj2);
            }
            return makeHashTable(modulemethod, ((Procedure) (obj)), i);

        case 15: // '\017'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-ref", 1, obj);
            }
            return hashTableRef(modulemethod, obj1, obj2);

        case 17: // '\021'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-ref/default", 1, obj);
            }
            return hashTableRef$SlDefault(modulemethod, obj1, obj2);

        case 18: // '\022'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-update!", 1, obj);
            }
            hashTableUpdate$Ex(modulemethod, obj1, obj2);
            return Values.empty;

        case 22: // '\026'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-fold", 1, obj);
            }
            try
            {
                obj = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-fold", 2, obj1);
            }
            return hashTableFold(modulemethod, ((Procedure) (obj)), obj2);

        case 24: // '\030'
            return alist$To$HashTable(obj, obj1, obj2);

        case 31: // '\037'
            return lambda2(obj, obj1, obj2);

        case 33: // '!'
            return lambda3(obj, obj1, obj2);
        }
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);

        case 18: // '\022'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-update!", 1, obj);
            }
            hashTableUpdate$Ex(modulemethod, obj1, obj2, obj3);
            return Values.empty;

        case 20: // '\024'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hash-table-update!/default", 1, obj);
            }
            hashTableUpdate$Ex$SlDefault(modulemethod, obj1, obj2, obj3);
            return Values.empty;

        case 24: // '\030'
            return alist$To$HashTable(obj, obj1, obj2, obj3);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 11)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR lookupswitch 13: default 124
    //                   1: 389
    //                   3: 372
    //                   5: 355
    //                   7: 338
    //                   9: 314
    //                   10: 290
    //                   11: 266
    //                   23: 249
    //                   24: 232
    //                   28: 208
    //                   29: 184
    //                   32: 160
    //                   34: 136;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        i = super.match1(modulemethod, obj, callcontext);
_L16:
        return i;
_L14:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L13:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L9:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L8:
        if (obj instanceof Procedure)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L4:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L3:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L2:
        if (obj instanceof CharSequence)
        {
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
        if (true) goto _L16; else goto _L15
_L15:
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR lookupswitch 9: default 92
    //                   1: 408
    //                   3: 371
    //                   5: 334
    //                   7: 297
    //                   11: 253
    //                   15: 220
    //                   21: 176
    //                   24: 150
    //                   30: 106;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L12:
        return i;
_L10:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof kawa.lib.kawa.hashtable.HashTable))
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
        continue; /* Loop/switch isn't completed */
_L9:
        callcontext.value1 = obj;
        callcontext.value2 = obj1;
        callcontext.proc = modulemethod;
        callcontext.pc = 2;
        return 0;
_L8:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Procedure))
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
        continue; /* Loop/switch isn't completed */
_L7:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (obj instanceof Procedure)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Procedure))
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
        continue; /* Loop/switch isn't completed */
_L5:
        callcontext.value1 = obj;
        if (IntNum.asIntNumOrNull(obj1) != null)
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return 0xfff40002;
        }
_L4:
        callcontext.value1 = obj;
        if (IntNum.asIntNumOrNull(obj1) != null)
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return 0xfff40002;
        }
_L3:
        callcontext.value1 = obj;
        if (IntNum.asIntNumOrNull(obj1) != null)
        {
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        } else
        {
            return 0xfff40002;
        }
_L2:
        if (obj instanceof CharSequence)
        {
            callcontext.value1 = obj;
            if (IntNum.asIntNumOrNull(obj1) != null)
            {
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            } else
            {
                return 0xfff40002;
            }
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);

        case 33: // '!'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 31: // '\037'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 24: // '\030'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;

        case 22: // '\026'
            if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Procedure))
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

        case 18: // '\022'
            if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
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
            if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
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

        case 15: // '\017'
            if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
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

        case 11: // '\013'
            break;
        }
        if (!(obj instanceof Procedure))
        {
            return 0xfff40001;
        }
        callcontext.value1 = obj;
        if (!(obj1 instanceof Procedure))
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
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

        case 24: // '\030'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.value4 = obj3;
            callcontext.proc = modulemethod;
            callcontext.pc = 4;
            return 0;

        case 20: // '\024'
            if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            }

        case 18: // '\022'
            break;
        }
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
        {
            return 0xfff40001;
        } else
        {
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
        Lit19 = (SimpleSymbol)(new SimpleSymbol("hash-table-values")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("hash-table-keys")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("hash-table-merge!")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("hash-table-copy")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("hash-table->alist")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("alist->hash-table")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("hash-table-fold")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("hash-table-walk")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("hash-table-update!/default")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("hash-table-update!")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("hash-table-ref/default")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("hash-table-ref")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("make-hash-table")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("hash-table-hash-function")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("hash-table-equivalence-function")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("hash-by-identity")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("hash")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("string-ci-hash")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("string-hash")).readResolve();
        $instance = new srfi69();
        srfi69 srfi69_1 = $instance;
        string$Mnhash = new ModuleMethod(srfi69_1, 1, Lit1, 8193);
        string$Mnci$Mnhash = new ModuleMethod(srfi69_1, 3, Lit2, 8193);
        hash = new ModuleMethod(srfi69_1, 5, Lit3, 8193);
        hash$Mnby$Mnidentity = new ModuleMethod(srfi69_1, 7, Lit4, 8193);
        hash$Mntable$Mnequivalence$Mnfunction = new ModuleMethod(srfi69_1, 9, Lit5, 4097);
        hash$Mntable$Mnhash$Mnfunction = new ModuleMethod(srfi69_1, 10, Lit6, 4097);
        make$Mnhash$Mntable = new ModuleMethod(srfi69_1, 11, Lit7, 12288);
        hash$Mntable$Mnref = new ModuleMethod(srfi69_1, 15, Lit8, 12290);
        hash$Mntable$Mnref$Sldefault = new ModuleMethod(srfi69_1, 17, Lit9, 12291);
        hash$Mntable$Mnupdate$Ex = new ModuleMethod(srfi69_1, 18, Lit10, 16387);
        hash$Mntable$Mnupdate$Ex$Sldefault = new ModuleMethod(srfi69_1, 20, Lit11, 16388);
        hash$Mntable$Mnwalk = new ModuleMethod(srfi69_1, 21, Lit12, 8194);
        hash$Mntable$Mnfold = new ModuleMethod(srfi69_1, 22, Lit13, 12291);
        ModuleMethod modulemethod = new ModuleMethod(srfi69_1, 23, null, 4097);
        modulemethod.setProperty("source-location", "srfi69.scm:166");
        lambda$Fn1 = modulemethod;
        alist$Mn$Grhash$Mntable = new ModuleMethod(srfi69_1, 24, Lit14, 16385);
        hash$Mntable$Mn$Gralist = new ModuleMethod(srfi69_1, 28, Lit15, 4097);
        hash$Mntable$Mncopy = new ModuleMethod(srfi69_1, 29, Lit16, 4097);
        hash$Mntable$Mnmerge$Ex = new ModuleMethod(srfi69_1, 30, Lit17, 8194);
        modulemethod = new ModuleMethod(srfi69_1, 31, null, 12291);
        modulemethod.setProperty("source-location", "srfi69.scm:183");
        lambda$Fn2 = modulemethod;
        hash$Mntable$Mnkeys = new ModuleMethod(srfi69_1, 32, Lit18, 4097);
        modulemethod = new ModuleMethod(srfi69_1, 33, null, 12291);
        modulemethod.setProperty("source-location", "srfi69.scm:186");
        lambda$Fn3 = modulemethod;
        hash$Mntable$Mnvalues = new ModuleMethod(srfi69_1, 34, Lit19, 4097);
        $instance.run();
    }
}
