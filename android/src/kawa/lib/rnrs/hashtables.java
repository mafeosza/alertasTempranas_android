// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.rnrs;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.HashNode;
import gnu.lists.FVector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.kawa.hashtable;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.Scheme;

public class hashtables extends ModuleBody
{

    public static final hashtables $instance;
    static final SimpleSymbol Lit0;
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
    static final SimpleSymbol Lit20;
    static final SimpleSymbol Lit21;
    static final SimpleSymbol Lit22;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod equal$Mnhash;
    static final ModuleMethod hash$Mnby$Mnidentity;
    static final ModuleMethod hash$Mnfor$Mneqv;
    public static final ModuleMethod hashtable$Mnclear$Ex;
    public static final ModuleMethod hashtable$Mncontains$Qu;
    public static final ModuleMethod hashtable$Mncopy;
    public static final ModuleMethod hashtable$Mndelete$Ex;
    public static final ModuleMethod hashtable$Mnentries;
    public static final ModuleMethod hashtable$Mnequivalence$Mnfunction;
    public static final ModuleMethod hashtable$Mnhash$Mnfunction;
    public static final ModuleMethod hashtable$Mnkeys;
    public static final ModuleMethod hashtable$Mnmutable$Qu;
    public static final ModuleMethod hashtable$Mnref;
    public static final ModuleMethod hashtable$Mnset$Ex;
    public static final ModuleMethod hashtable$Mnsize;
    public static final ModuleMethod hashtable$Mnupdate$Ex;
    public static final ModuleMethod hashtable$Qu;
    public static final ModuleMethod make$Mneq$Mnhashtable;
    public static final ModuleMethod make$Mneqv$Mnhashtable;
    public static final ModuleMethod make$Mnhashtable;
    public static final ModuleMethod string$Mnci$Mnhash;
    public static final ModuleMethod string$Mnhash;
    public static final ModuleMethod symbol$Mnhash;

    public hashtables()
    {
        ModuleInfo.register(this);
    }

    public static int equalHash(Object obj)
    {
        return obj.hashCode();
    }

    static int hashByIdentity(Object obj)
    {
        return System.identityHashCode(obj);
    }

    static int hashForEqv(Object obj)
    {
        return obj.hashCode();
    }

    public static void hashtableClear$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        hashtableClear$Ex(hashtable1, 64);
    }

    public static void hashtableClear$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, int i)
    {
        hashtable.hashtableCheckMutable(hashtable1);
        hashtable1.clear();
    }

    public static kawa.lib.kawa.hashtable.HashTable hashtableCopy(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashtableCopy(hashtable1, false);
    }

    public static kawa.lib.kawa.hashtable.HashTable hashtableCopy(kawa.lib.kawa.hashtable.HashTable hashtable1, boolean flag)
    {
        return new kawa.lib.kawa.hashtable.HashTable(hashtable1, flag);
    }

    public static void hashtableDelete$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj)
    {
        hashtable.hashtableCheckMutable(hashtable1);
        hashtable1.remove(obj);
    }

    public static Object hashtableEntries(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        hashtable1 = hashtable1.entriesVectorPair();
        return misc.values(new Object[] {
            lists.car.apply1(hashtable1), lists.cdr.apply1(hashtable1)
        });
    }

    public static Procedure hashtableEquivalenceFunction(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return (Procedure)hashtable1.equivalenceFunction.apply1(hashtable1);
    }

    public static Object hashtableHashFunction(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        Object obj;
        Object obj1;
        obj = hashtable1.hashFunction.apply1(hashtable1);
        obj1 = Scheme.isEqv.apply2(obj, hash$Mnby$Mnidentity);
        if (obj1 == Boolean.FALSE) goto _L2; else goto _L1
_L1:
        hashtable1 = ((kawa.lib.kawa.hashtable.HashTable) (obj));
        if (obj1 == Boolean.FALSE) goto _L4; else goto _L3
_L3:
        hashtable1 = Boolean.FALSE;
_L4:
        return hashtable1;
_L2:
        hashtable1 = ((kawa.lib.kawa.hashtable.HashTable) (obj));
        if (Scheme.isEqv.apply2(obj, hash$Mnfor$Mneqv) == Boolean.FALSE) goto _L4; else goto _L3
    }

    public static FVector hashtableKeys(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashtable1.keysVector();
    }

    public static Object hashtableRef(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1)
    {
        hashtable1 = hashtable1.getNode(obj);
        if (hashtable1 == null)
        {
            return obj1;
        } else
        {
            return hashtable1.getValue();
        }
    }

    public static void hashtableSet$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Object obj1)
    {
        hashtable.hashtableCheckMutable(hashtable1);
        hashtable1.put(obj, obj1);
    }

    public static int hashtableSize(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        return hashtable1.size();
    }

    public static Object hashtableUpdate$Ex(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj, Procedure procedure, Object obj1)
    {
        hashtable.hashtableCheckMutable(hashtable1);
        HashNode hashnode = hashtable1.getNode(obj);
        if (hashnode == null)
        {
            hashtableSet$Ex(hashtable1, obj, procedure.apply1(obj1));
            return Values.empty;
        } else
        {
            return hashnode.setValue(procedure.apply1(hashnode.getValue()));
        }
    }

    public static boolean isHashtable(Object obj)
    {
        return obj instanceof kawa.lib.kawa.hashtable.HashTable;
    }

    public static boolean isHashtableContains(kawa.lib.kawa.hashtable.HashTable hashtable1, Object obj)
    {
        int i;
        if (hashtable1.getNode(obj) == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return i + 1 & 1;
    }

    public static Object isHashtableMutable(kawa.lib.kawa.hashtable.HashTable hashtable1)
    {
        gnu.kawa.functions.ApplyToArgs applytoargs = Scheme.applyToArgs;
        if (hashtable1.mutable)
        {
            hashtable1 = Boolean.TRUE;
        } else
        {
            hashtable1 = Boolean.FALSE;
        }
        return applytoargs.apply1(hashtable1);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeEqHashtable()
    {
        return makeEqHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeEqHashtable(int i)
    {
        return new kawa.lib.kawa.hashtable.HashTable(Scheme.isEq, hash$Mnby$Mnidentity, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeEqvHashtable()
    {
        return makeEqvHashtable(AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeEqvHashtable(int i)
    {
        return new kawa.lib.kawa.hashtable.HashTable(Scheme.isEqv, hash$Mnfor$Mneqv, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeHashtable(Procedure procedure, Procedure procedure1)
    {
        return makeHashtable(procedure, procedure1, AbstractHashTable.DEFAULT_INITIAL_SIZE);
    }

    public static kawa.lib.kawa.hashtable.HashTable makeHashtable(Procedure procedure, Procedure procedure1, int i)
    {
        return new kawa.lib.kawa.hashtable.HashTable(procedure, procedure1, i);
    }

    public static int stringCiHash(CharSequence charsequence)
    {
        return charsequence.toString().toLowerCase().hashCode();
    }

    public static int stringHash(CharSequence charsequence)
    {
        return charsequence.hashCode();
    }

    public static int symbolHash(Symbol symbol)
    {
        return symbol.hashCode();
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        default:
            return super.apply0(modulemethod);

        case 3: // '\003'
            return makeEqHashtable();

        case 5: // '\005'
            return makeEqvHashtable();
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 17: // '\021'
        case 19: // '\023'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            return Integer.valueOf(hashByIdentity(obj));

        case 2: // '\002'
            return Integer.valueOf(hashForEqv(obj));

        case 3: // '\003'
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-eq-hashtable", 1, obj);
            }
            return makeEqHashtable(i);

        case 5: // '\005'
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-eqv-hashtable", 1, obj);
            }
            return makeEqvHashtable(i);

        case 9: // '\t'
            if (isHashtable(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 10: // '\n'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-size", 1, obj);
            }
            return Integer.valueOf(hashtableSize(modulemethod));

        case 16: // '\020'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-copy", 1, obj);
            }
            return hashtableCopy(modulemethod);

        case 18: // '\022'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-clear!", 1, obj);
            }
            hashtableClear$Ex(modulemethod);
            return Values.empty;

        case 20: // '\024'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-keys", 1, obj);
            }
            return hashtableKeys(modulemethod);

        case 21: // '\025'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-entries", 1, obj);
            }
            return hashtableEntries(modulemethod);

        case 22: // '\026'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-equivalence-function", 1, obj);
            }
            return hashtableEquivalenceFunction(modulemethod);

        case 23: // '\027'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-hash-function", 1, obj);
            }
            return hashtableHashFunction(modulemethod);

        case 24: // '\030'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-mutable?", 1, obj);
            }
            return isHashtableMutable(modulemethod);

        case 25: // '\031'
            return Integer.valueOf(equalHash(obj));

        case 26: // '\032'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-hash", 1, obj);
            }
            return Integer.valueOf(stringHash(modulemethod));

        case 27: // '\033'
            try
            {
                modulemethod = (CharSequence)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "string-ci-hash", 1, obj);
            }
            return Integer.valueOf(stringCiHash(modulemethod));

        case 28: // '\034'
            break;
        }
        try
        {
            modulemethod = (Symbol)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "symbol-hash", 1, obj);
        }
        return Integer.valueOf(symbolHash(modulemethod));
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        boolean flag = true;
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 7: // '\007'
            int i;
            try
            {
                modulemethod = (Procedure)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hashtable", 1, obj);
            }
            try
            {
                obj = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hashtable", 2, obj1);
            }
            return makeHashtable(modulemethod, ((Procedure) (obj)));

        case 13: // '\r'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-delete!", 1, obj);
            }
            hashtableDelete$Ex(modulemethod, obj1);
            return Values.empty;

        case 14: // '\016'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-contains?", 1, obj);
            }
            if (isHashtableContains(modulemethod, obj1))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 16: // '\020'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-copy", 1, obj);
            }
            try
            {
                obj = Boolean.FALSE;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-copy", 2, obj1);
            }
            if (obj1 == obj)
            {
                flag = false;
            }
            return hashtableCopy(modulemethod, flag);

        case 18: // '\022'
            break;
        }
        try
        {
            modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "hashtable-clear!", 1, obj);
        }
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "hashtable-clear!", 2, obj1);
        }
        hashtableClear$Ex(modulemethod, i);
        return Values.empty;
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        switch (modulemethod.selector)
        {
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        default:
            return super.apply3(modulemethod, obj, obj1, obj2);

        case 7: // '\007'
            int i;
            try
            {
                modulemethod = (Procedure)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hashtable", 1, obj);
            }
            try
            {
                obj = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hashtable", 2, obj1);
            }
            try
            {
                i = ((Number)obj2).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-hashtable", 3, obj2);
            }
            return makeHashtable(modulemethod, ((Procedure) (obj)), i);

        case 11: // '\013'
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-ref", 1, obj);
            }
            return hashtableRef(modulemethod, obj1, obj2);

        case 12: // '\f'
            break;
        }
        try
        {
            modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "hashtable-set!", 1, obj);
        }
        hashtableSet$Ex(modulemethod, obj1, obj2);
        return Values.empty;
    }

    public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
    {
        if (modulemethod.selector == 15)
        {
            try
            {
                modulemethod = (kawa.lib.kawa.hashtable.HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-update!", 1, obj);
            }
            try
            {
                obj = (Procedure)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-update!", 3, obj2);
            }
            return hashtableUpdate$Ex(modulemethod, obj1, ((Procedure) (obj)), obj3);
        } else
        {
            return super.apply4(modulemethod, obj, obj1, obj2, obj3);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        default:
            return super.match0(modulemethod, callcontext);

        case 5: // '\005'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;

        case 3: // '\003'
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 1 28: default 136
    //                   1 497
    //                   2 480
    //                   3 463
    //                   4 136
    //                   5 446
    //                   6 136
    //                   7 136
    //                   8 136
    //                   9 429
    //                   10 405
    //                   11 136
    //                   12 136
    //                   13 136
    //                   14 136
    //                   15 136
    //                   16 381
    //                   17 136
    //                   18 357
    //                   19 136
    //                   20 333
    //                   21 309
    //                   22 285
    //                   23 261
    //                   24 237
    //                   25 220
    //                   26 196
    //                   27 172
    //                   28 148;
           goto _L1 _L2 _L3 _L4 _L1 _L5 _L1 _L1 _L1 _L6 _L7 _L1 _L1 _L1 _L1 _L1 _L8 _L1 _L9 _L1 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18
_L1:
        i = super.match1(modulemethod, obj, callcontext);
_L20:
        return i;
_L18:
        if (!(obj instanceof Symbol)) goto _L20; else goto _L19
_L19:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L17:
        if (!(obj instanceof CharSequence)) goto _L20; else goto _L21
_L21:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L16:
        if (!(obj instanceof CharSequence)) goto _L20; else goto _L22
_L22:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L15:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L14:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L23
_L23:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L13:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L24
_L24:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L12:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L25
_L25:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L11:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L26
_L26:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L10:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L27
_L27:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L9:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L28
_L28:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L8:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L29
_L29:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L7:
        if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable)) goto _L20; else goto _L30
_L30:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L6:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
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
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
    }

    public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR lookupswitch 5: default 60
    //                   7: 206
    //                   13: 173
    //                   14: 140
    //                   16: 107
    //                   18: 74;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L8:
        return i;
_L6:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
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
        if (true) goto _L8; else goto _L7
_L7:
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 7 12: default 48
    //                   7 144
    //                   8 48
    //                   9 48
    //                   10 48
    //                   11 104
    //                   12 64;
           goto _L1 _L2 _L1 _L1 _L1 _L3 _L4
_L1:
        i = super.match3(modulemethod, obj, obj1, obj2, callcontext);
_L6:
        return i;
_L4:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (obj instanceof kawa.lib.kawa.hashtable.HashTable)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.value3 = obj2;
            callcontext.proc = modulemethod;
            callcontext.pc = 3;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (obj instanceof Procedure)
        {
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
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
    {
        if (modulemethod.selector == 15)
        {
            if (!(obj instanceof kawa.lib.kawa.hashtable.HashTable))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            if (!(obj2 instanceof Procedure))
            {
                return 0xfff40003;
            } else
            {
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            }
        } else
        {
            return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit22 = (SimpleSymbol)(new SimpleSymbol("symbol-hash")).readResolve();
        Lit21 = (SimpleSymbol)(new SimpleSymbol("string-ci-hash")).readResolve();
        Lit20 = (SimpleSymbol)(new SimpleSymbol("string-hash")).readResolve();
        Lit19 = (SimpleSymbol)(new SimpleSymbol("equal-hash")).readResolve();
        Lit18 = (SimpleSymbol)(new SimpleSymbol("hashtable-mutable?")).readResolve();
        Lit17 = (SimpleSymbol)(new SimpleSymbol("hashtable-hash-function")).readResolve();
        Lit16 = (SimpleSymbol)(new SimpleSymbol("hashtable-equivalence-function")).readResolve();
        Lit15 = (SimpleSymbol)(new SimpleSymbol("hashtable-entries")).readResolve();
        Lit14 = (SimpleSymbol)(new SimpleSymbol("hashtable-keys")).readResolve();
        Lit13 = (SimpleSymbol)(new SimpleSymbol("hashtable-clear!")).readResolve();
        Lit12 = (SimpleSymbol)(new SimpleSymbol("hashtable-copy")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("hashtable-update!")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("hashtable-contains?")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("hashtable-delete!")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("hashtable-set!")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("hashtable-ref")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("hashtable-size")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("hashtable?")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("make-hashtable")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("make-eqv-hashtable")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("make-eq-hashtable")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("hash-for-eqv")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("hash-by-identity")).readResolve();
        $instance = new hashtables();
        hashtables hashtables1 = $instance;
        hash$Mnby$Mnidentity = new ModuleMethod(hashtables1, 1, Lit0, 4097);
        hash$Mnfor$Mneqv = new ModuleMethod(hashtables1, 2, Lit1, 4097);
        make$Mneq$Mnhashtable = new ModuleMethod(hashtables1, 3, Lit2, 4096);
        make$Mneqv$Mnhashtable = new ModuleMethod(hashtables1, 5, Lit3, 4096);
        make$Mnhashtable = new ModuleMethod(hashtables1, 7, Lit4, 12290);
        hashtable$Qu = new ModuleMethod(hashtables1, 9, Lit5, 4097);
        hashtable$Mnsize = new ModuleMethod(hashtables1, 10, Lit6, 4097);
        hashtable$Mnref = new ModuleMethod(hashtables1, 11, Lit7, 12291);
        hashtable$Mnset$Ex = new ModuleMethod(hashtables1, 12, Lit8, 12291);
        hashtable$Mndelete$Ex = new ModuleMethod(hashtables1, 13, Lit9, 8194);
        hashtable$Mncontains$Qu = new ModuleMethod(hashtables1, 14, Lit10, 8194);
        hashtable$Mnupdate$Ex = new ModuleMethod(hashtables1, 15, Lit11, 16388);
        hashtable$Mncopy = new ModuleMethod(hashtables1, 16, Lit12, 8193);
        hashtable$Mnclear$Ex = new ModuleMethod(hashtables1, 18, Lit13, 8193);
        hashtable$Mnkeys = new ModuleMethod(hashtables1, 20, Lit14, 4097);
        hashtable$Mnentries = new ModuleMethod(hashtables1, 21, Lit15, 4097);
        hashtable$Mnequivalence$Mnfunction = new ModuleMethod(hashtables1, 22, Lit16, 4097);
        hashtable$Mnhash$Mnfunction = new ModuleMethod(hashtables1, 23, Lit17, 4097);
        hashtable$Mnmutable$Qu = new ModuleMethod(hashtables1, 24, Lit18, 4097);
        equal$Mnhash = new ModuleMethod(hashtables1, 25, Lit19, 4097);
        string$Mnhash = new ModuleMethod(hashtables1, 26, Lit20, 4097);
        string$Mnci$Mnhash = new ModuleMethod(hashtables1, 27, Lit21, 4097);
        symbol$Mnhash = new ModuleMethod(hashtables1, 28, Lit22, 4097);
        $instance.run();
    }
}
