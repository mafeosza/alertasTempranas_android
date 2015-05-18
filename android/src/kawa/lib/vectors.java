// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.GenericProc;
import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.Special;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;

// Referenced classes of package kawa.lib:
//            lists

public class vectors extends ModuleBody
{

    public static final vectors $instance;
    static final Keyword Lit0 = Keyword.make("setter");
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    public static final ModuleMethod list$Mn$Grvector;
    public static final ModuleMethod make$Mnvector;
    public static final ModuleMethod vector$Mn$Grlist;
    public static final ModuleMethod vector$Mnfill$Ex;
    public static final ModuleMethod vector$Mnlength;
    public static final GenericProc vector$Mnref;
    static final ModuleMethod vector$Mnref$Fn1;
    public static final ModuleMethod vector$Mnset$Ex;
    public static final ModuleMethod vector$Qu;

    public vectors()
    {
        ModuleInfo.register(this);
    }

    public static boolean isVector(Object obj)
    {
        return obj instanceof FVector;
    }

    public static FVector list$To$Vector(LList llist)
    {
        return new FVector(llist);
    }

    public static FVector makeVector(int i)
    {
        return makeVector(i, Special.undefined);
    }

    public static FVector makeVector(int i, Object obj)
    {
        return new FVector(i, obj);
    }

    public static LList vector$To$List(FVector fvector)
    {
        Object obj = LList.Empty;
        int i = vectorLength(fvector);
        do
        {
            i--;
            if (i < 0)
            {
                return ((LList) (obj));
            }
            obj = lists.cons(vector$Mnref.apply2(fvector, Integer.valueOf(i)), obj);
        } while (true);
    }

    public static void vectorFill$Ex(FVector fvector, Object obj)
    {
        fvector.setAll(obj);
    }

    public static int vectorLength(FVector fvector)
    {
        return fvector.size();
    }

    public static Object vectorRef(FVector fvector, int i)
    {
        return fvector.get(i);
    }

    public static void vectorSet$Ex(FVector fvector, int i, Object obj)
    {
        fvector.set(i, obj);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isVector(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 2: // '\002'
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-vector", 1, obj);
            }
            return makeVector(i);

        case 4: // '\004'
            try
            {
                modulemethod = (FVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "vector-length", 1, obj);
            }
            return Integer.valueOf(vectorLength(modulemethod));

        case 7: // '\007'
            try
            {
                modulemethod = (FVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "vector->list", 1, obj);
            }
            return vector$To$List(modulemethod);

        case 8: // '\b'
            break;
        }
        try
        {
            modulemethod = (LList)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "list->vector", 1, obj);
        }
        return list$To$Vector(modulemethod);
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 2: // '\002'
            int i;
            try
            {
                i = ((Number)obj).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-vector", 1, obj);
            }
            return makeVector(i, obj1);

        case 6: // '\006'
            try
            {
                modulemethod = (FVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "vector-ref", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "vector-ref", 2, obj1);
            }
            return vectorRef(modulemethod, i);

        case 9: // '\t'
            break;
        }
        try
        {
            modulemethod = (FVector)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "vector-fill!", 1, obj);
        }
        vectorFill$Ex(modulemethod, obj1);
        return Values.empty;
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 5)
        {
            int i;
            try
            {
                modulemethod = (FVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "vector-set!", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "vector-set!", 2, obj1);
            }
            vectorSet$Ex(modulemethod, i, obj2);
            return Values.empty;
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 8: // '\b'
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

        case 7: // '\007'
            if (obj instanceof FVector)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }

        case 4: // '\004'
            if (obj instanceof FVector)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return 0xfff40001;
            }

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
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 9: // '\t'
            if (obj instanceof FVector)
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

        case 6: // '\006'
            if (obj instanceof FVector)
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
        if (modulemethod.selector == 5)
        {
            if (obj instanceof FVector)
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
        } else
        {
            return super.match3(modulemethod, obj, obj1, obj2, callcontext);
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        vector$Mnref = new GenericProc("vector-ref");
        callcontext = vector$Mnref;
        Keyword keyword = Lit0;
        ModuleMethod modulemethod = vector$Mnset$Ex;
        ModuleMethod modulemethod1 = vector$Mnref$Fn1;
        callcontext.setProperties(new Object[] {
            keyword, modulemethod, vector$Mnref$Fn1
        });
    }

    static 
    {
        Lit8 = (SimpleSymbol)(new SimpleSymbol("vector-fill!")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("list->vector")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("vector->list")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("vector-ref")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("vector-set!")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("vector-length")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("make-vector")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("vector?")).readResolve();
        $instance = new vectors();
        vectors vectors1 = $instance;
        vector$Qu = new ModuleMethod(vectors1, 1, Lit1, 4097);
        make$Mnvector = new ModuleMethod(vectors1, 2, Lit2, 8193);
        vector$Mnlength = new ModuleMethod(vectors1, 4, Lit3, 4097);
        vector$Mnset$Ex = new ModuleMethod(vectors1, 5, Lit4, 12291);
        vector$Mnref$Fn1 = new ModuleMethod(vectors1, 6, Lit5, 8194);
        vector$Mn$Grlist = new ModuleMethod(vectors1, 7, Lit6, 4097);
        list$Mn$Grvector = new ModuleMethod(vectors1, 8, Lit7, 4097);
        vector$Mnfill$Ex = new ModuleMethod(vectors1, 9, Lit8, 8194);
        $instance.run();
    }
}
