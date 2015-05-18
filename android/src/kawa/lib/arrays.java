// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Arrays;
import gnu.lists.Array;
import gnu.lists.FVector;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;

public class arrays extends ModuleBody
{

    public static final Class $Lsarray$Gr = gnu/lists/Array;
    public static final arrays $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    public static final ModuleMethod array;
    public static final ModuleMethod array$Mnend;
    public static final ModuleMethod array$Mnrank;
    public static final ModuleMethod array$Mnstart;
    public static final ModuleMethod array$Qu;
    public static final ModuleMethod make$Mnarray;
    public static final ModuleMethod shape;
    public static final ModuleMethod share$Mnarray;

    public arrays()
    {
        ModuleInfo.register(this);
    }

    public static transient Array array(Array array1, Object aobj[])
    {
        return Arrays.makeSimple(array1, new FVector(aobj));
    }

    public static int arrayEnd(Array array1, int i)
    {
        return array1.getLowBound(i) + array1.getSize(i);
    }

    public static int arrayRank(Array array1)
    {
        return array1.rank();
    }

    public static int arrayStart(Array array1, int i)
    {
        return array1.getLowBound(i);
    }

    public static boolean isArray(Object obj)
    {
        return obj instanceof Array;
    }

    public static Array makeArray(Array array1)
    {
        return makeArray(array1, null);
    }

    public static Array makeArray(Array array1, Object obj)
    {
        return Arrays.make(array1, obj);
    }

    public static transient Array shape(Object aobj[])
    {
        return Arrays.shape(aobj);
    }

    public static Array shareArray(Array array1, Array array2, Procedure procedure)
    {
        return Arrays.shareArray(array1, array2, procedure);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        case 2: // '\002'
        case 4: // '\004'
        case 5: // '\005'
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isArray(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 3: // '\003'
            try
            {
                modulemethod = (Array)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-array", 1, obj);
            }
            return makeArray(modulemethod);

        case 6: // '\006'
            break;
        }
        try
        {
            modulemethod = (Array)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "array-rank", 1, obj);
        }
        return Integer.valueOf(arrayRank(modulemethod));
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 3: // '\003'
            int i;
            try
            {
                modulemethod = (Array)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "make-array", 1, obj);
            }
            return makeArray(modulemethod, obj1);

        case 7: // '\007'
            try
            {
                modulemethod = (Array)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "array-start", 1, obj);
            }
            try
            {
                i = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "array-start", 2, obj1);
            }
            return Integer.valueOf(arrayStart(modulemethod, i));

        case 8: // '\b'
            break;
        }
        try
        {
            modulemethod = (Array)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "array-end", 1, obj);
        }
        try
        {
            i = ((Number)obj1).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "array-end", 2, obj1);
        }
        return Integer.valueOf(arrayEnd(modulemethod, i));
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 9)
        {
            try
            {
                modulemethod = (Array)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "share-array", 1, obj);
            }
            try
            {
                obj = (Array)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "share-array", 2, obj1);
            }
            try
            {
                obj1 = (Procedure)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "share-array", 3, obj2);
            }
            return shareArray(modulemethod, ((Array) (obj)), ((Procedure) (obj1)));
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public Object applyN(ModuleMethod modulemethod, Object aobj[])
    {
        switch (modulemethod.selector)
        {
        case 3: // '\003'
        case 4: // '\004'
        default:
            return super.applyN(modulemethod, aobj);

        case 2: // '\002'
            return shape(aobj);

        case 5: // '\005'
            modulemethod = ((ModuleMethod) (aobj[0]));
            break;
        }
        Array array1;
        int i;
        try
        {
            array1 = (Array)modulemethod;
        }
        // Misplaced declaration of an exception variable
        catch (Object aobj[])
        {
            throw new WrongType(((ClassCastException) (aobj)), "array", 1, modulemethod);
        }
        i = aobj.length - 1;
        modulemethod = ((ModuleMethod) (new Object[i]));
        do
        {
            i--;
            if (i < 0)
            {
                return array(array1, modulemethod);
            }
            modulemethod[i] = aobj[i + 1];
        } while (true);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        int i = 0xfff40001;
        modulemethod.selector;
        JVM INSTR tableswitch 1 6: default 48
    //                   1 108
    //                   2 48
    //                   3 84
    //                   4 48
    //                   5 48
    //                   6 60;
           goto _L1 _L2 _L1 _L3 _L1 _L1 _L4
_L1:
        i = super.match1(modulemethod, obj, callcontext);
_L6:
        return i;
_L4:
        if (!(obj instanceof Array)) goto _L6; else goto _L5
_L5:
        callcontext.value1 = obj;
        callcontext.proc = modulemethod;
        callcontext.pc = 1;
        return 0;
_L3:
        if (!(obj instanceof Array)) goto _L6; else goto _L7
_L7:
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
        JVM INSTR tableswitch 3 8: default 48
    //                   3 128
    //                   4 48
    //                   5 48
    //                   6 48
    //                   7 95
    //                   8 62;
           goto _L1 _L2 _L1 _L1 _L1 _L3 _L4
_L1:
        i = super.match2(modulemethod, obj, obj1, callcontext);
_L6:
        return i;
_L4:
        if (obj instanceof Array)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (obj instanceof Array)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (obj instanceof Array)
        {
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 9)
        {
            if (!(obj instanceof Array))
            {
                return 0xfff40001;
            }
            callcontext.value1 = obj;
            if (!(obj1 instanceof Array))
            {
                return 0xfff40002;
            }
            callcontext.value2 = obj1;
            if (!(obj2 instanceof Procedure))
            {
                return 0xfff40003;
            } else
            {
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
        case 3: // '\003'
        case 4: // '\004'
        default:
            return super.matchN(modulemethod, aobj, callcontext);

        case 5: // '\005'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;

        case 2: // '\002'
            callcontext.values = aobj;
            callcontext.proc = modulemethod;
            callcontext.pc = 5;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit7 = (SimpleSymbol)(new SimpleSymbol("share-array")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("array-end")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("array-start")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("array-rank")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("array")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("make-array")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("shape")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("array?")).readResolve();
        $instance = new arrays();
        arrays arrays1 = $instance;
        array$Qu = new ModuleMethod(arrays1, 1, Lit0, 4097);
        shape = new ModuleMethod(arrays1, 2, Lit1, -4096);
        make$Mnarray = new ModuleMethod(arrays1, 3, Lit2, 8193);
        array = new ModuleMethod(arrays1, 5, Lit3, -4095);
        array$Mnrank = new ModuleMethod(arrays1, 6, Lit4, 4097);
        array$Mnstart = new ModuleMethod(arrays1, 7, Lit5, 8194);
        array$Mnend = new ModuleMethod(arrays1, 8, Lit6, 8194);
        share$Mnarray = new ModuleMethod(arrays1, 9, Lit7, 12291);
        $instance.run();
    }
}
