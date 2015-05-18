// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.SetNamedPart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.kawa.util.AbstractHashTable;
import gnu.kawa.util.GeneralHashTable;
import gnu.kawa.util.HashNode;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Location;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.standard.thisRef;

public class hashtable extends ModuleBody
{
    public class HashTable extends GeneralHashTable
    {

        public Procedure equivalenceFunction;
        public Procedure hashFunction;
        public boolean mutable;

        private void $finit$()
        {
            mutable = true;
        }

        public Object clone()
        {
            return new HashTable(this, true);
        }

        public Pair entriesVectorPair()
        {
            FVector fvector = new FVector();
            FVector fvector1 = new FVector();
            Object obj = super.table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "table", -2, obj);
            }
            for (i = ahashnode.length - 1; i >= 0; i--)
            {
                for (obj = ahashnode[i]; obj != null; obj = getEntryNext(((HashNode) (obj))))
                {
                    fvector.add(((HashNode) (obj)).getKey());
                    fvector1.add(((HashNode) (obj)).getValue());
                }

            }

            return lists.cons(fvector, fvector1);
        }

        public Object fold(Procedure procedure, Object obj)
        {
            java.util.Map.Entry aentry[] = super.table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])aentry;
            }
            // Misplaced declaration of an exception variable
            catch (Procedure procedure)
            {
                throw new WrongType(procedure, "table", -2, aentry);
            }
            for (i = ahashnode.length - 1; i >= 0;)
            {
                HashNode hashnode = ahashnode[i];
                aentry = ((java.util.Map.Entry []) (obj));
                for (obj = hashnode; obj != null; obj = getEntryNext(((HashNode) (obj))))
                {
                    aentry = ((java.util.Map.Entry []) (procedure.apply3(((HashNode) (obj)).getKey(), ((HashNode) (obj)).getValue(), aentry)));
                }

                i--;
                obj = aentry;
            }

            return obj;
        }

        public int hash(Object obj)
        {
            return ((Number)hashFunction.apply1(obj)).intValue();
        }

        public FVector keysVector()
        {
            Object obj1 = new FVector();
            Object obj = super.table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "table", -2, obj);
            }
            for (i = ahashnode.length - 1; i >= 0; i--)
            {
                for (obj = ahashnode[i]; obj != null; obj = getEntryNext(((HashNode) (obj))))
                {
                    ((FVector) (obj1)).add(((HashNode) (obj)).getKey());
                }

            }

            return ((FVector) (obj1));
        }

        public boolean matches(Object obj, Object obj1)
        {
            return equivalenceFunction.apply2(obj, obj1) != Boolean.FALSE;
        }

        public void putAll(HashTable hashtable1)
        {
            Object obj = ((AbstractHashTable) (hashtable1)).table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            // Misplaced declaration of an exception variable
            catch (HashTable hashtable1)
            {
                throw new WrongType(hashtable1, "table", -2, obj);
            }
            for (i = ahashnode.length - 1; i >= 0; i--)
            {
                for (obj = ahashnode[i]; obj != null; obj = hashtable1.getEntryNext(((HashNode) (obj))))
                {
                    put(((HashNode) (obj)).getKey(), ((HashNode) (obj)).getValue());
                }

            }

        }

        public Object toAlist()
        {
            Object obj1 = LList.Empty;
            Object obj = super.table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "table", -2, obj);
            }
            for (i = ahashnode.length - 1; i >= 0; i--)
            {
                for (obj = ahashnode[i]; obj != null; obj = getEntryNext(((HashNode) (obj))))
                {
                    obj1 = lists.cons(lists.cons(((HashNode) (obj)).getKey(), ((HashNode) (obj)).getValue()), obj1);
                }

            }

            return obj1;
        }

        public HashNode[] toNodeArray()
        {
            Object obj1 = new HashNode[size()];
            int i = 0;
            Object obj = super.table;
            HashNode ahashnode[];
            int j;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "table", -2, obj);
            }
            for (j = ahashnode.length - 1; j >= 0; j--)
            {
                for (obj = ahashnode[j]; obj != null;)
                {
                    obj1[i] = ((HashNode) (obj));
                    obj = getEntryNext(((HashNode) (obj)));
                    i++;
                }

            }

            return ((HashNode []) (obj1));
        }

        public LList toNodeList()
        {
            Object obj1 = LList.Empty;
            Object obj = super.table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            catch (ClassCastException classcastexception)
            {
                throw new WrongType(classcastexception, "table", -2, obj);
            }
            for (i = ahashnode.length - 1; i >= 0; i--)
            {
                for (obj = ahashnode[i]; obj != null; obj = getEntryNext(((HashNode) (obj))))
                {
                    obj1 = lists.cons(obj, obj1);
                }

            }

            return (LList)obj1;
        }

        public void walk(Procedure procedure)
        {
            Object obj = super.table;
            HashNode ahashnode[];
            int i;
            try
            {
                ahashnode = (HashNode[])obj;
            }
            // Misplaced declaration of an exception variable
            catch (Procedure procedure)
            {
                throw new WrongType(procedure, "table", -2, obj);
            }
            for (i = ahashnode.length - 1; i >= 0; i--)
            {
                for (obj = ahashnode[i]; obj != null; obj = getEntryNext(((HashNode) (obj))))
                {
                    procedure.apply2(((HashNode) (obj)).getKey(), ((HashNode) (obj)).getValue());
                }

            }

        }

        public HashTable(Procedure procedure, Procedure procedure1)
        {
            $finit$();
            equivalenceFunction = procedure;
            hashFunction = procedure1;
        }

        public HashTable(Procedure procedure, Procedure procedure1, int i)
        {
            super(i);
            $finit$();
            equivalenceFunction = procedure;
            hashFunction = procedure1;
        }

        public HashTable(HashTable hashtable1, boolean flag)
        {
            $finit$();
            Invoke.invokeSpecial.applyN(new Object[] {
                hashtable.hashtable, this, hashtable1.equivalenceFunction.apply0(), hashtable1.hashFunction.apply0(), Integer.valueOf(hashtable1.size() + 100)
            });
            putAll(hashtable1);
            SetNamedPart setnamedpart = SetNamedPart.setNamedPart;
            thisRef thisref = thisRef.thisSyntax;
            SimpleSymbol simplesymbol = hashtable.Lit0;
            if (flag)
            {
                hashtable1 = Boolean.TRUE;
            } else
            {
                hashtable1 = Boolean.FALSE;
            }
            setnamedpart.apply3(thisref, simplesymbol, hashtable1);
        }
    }


    public static final Location $Prvt$do = StaticFieldLocation.make("kawa.lib.std_syntax", "do");
    public static final Class $Prvt$hashnode = gnu/kawa/util/HashNode;
    public static final Location $Prvt$let$St = StaticFieldLocation.make("kawa.lib.std_syntax", "let$St");
    public static final hashtable $instance;
    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("mutable")).readResolve();
    static final SimpleSymbol Lit1;
    public static final Class hashtable = kawa/lib/kawa/hashtable$HashTable;
    public static final ModuleMethod hashtable$Mncheck$Mnmutable;

    public hashtable()
    {
        ModuleInfo.register(this);
    }

    public static void hashtableCheckMutable(HashTable hashtable1)
    {
        if (!hashtable1.mutable)
        {
            misc.error$V("cannot modify non-mutable hashtable", new Object[0]);
        }
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            try
            {
                modulemethod = (HashTable)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "hashtable-check-mutable", 1, obj);
            }
            hashtableCheckMutable(modulemethod);
            return Values.empty;
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            if (!(obj instanceof HashTable))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit1 = (SimpleSymbol)(new SimpleSymbol("hashtable-check-mutable")).readResolve();
        $instance = new hashtable();
        hashtable$Mncheck$Mnmutable = new ModuleMethod($instance, 1, Lit1, 4097);
        $instance.run();
    }
}
