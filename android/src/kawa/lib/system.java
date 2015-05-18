// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.AddOp;
import gnu.kawa.functions.IsEqual;
import gnu.lists.FVector;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.IntNum;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.InputStream;
import java.util.StringTokenizer;
import kawa.lang.CompileFile;
import kawa.lang.NamedException;
import kawa.standard.Scheme;

// Referenced classes of package kawa.lib:
//            lists, vectors, strings, misc

public class system extends ModuleBody
{

    public static final system $instance;
    static final IntNum Lit0 = IntNum.make(0);
    static final IntNum Lit1 = IntNum.make(1);
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit2;
    static final SimpleSymbol Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final ModuleMethod _fldcatch;
    public static Procedure command$Mnparse;
    public static final ModuleMethod compile$Mnfile;
    public static final ModuleMethod convert$Mnlist$Mnto$Mnstring$Mnarray;
    public static final ModuleMethod convert$Mnvector$Mnto$Mnstring$Mnarray;
    public static final ModuleMethod make$Mnprocess;
    public static final ModuleMethod open$Mninput$Mnpipe;
    public static final ModuleMethod process$Mncommand$Mnline$Mnassignments;
    public static final ModuleMethod system;
    public static final ModuleMethod tokenize$Mnstring$Mnto$Mnstring$Mnarray;
    public static final ModuleMethod tokenize$Mnstring$Mnusing$Mnshell;

    public system()
    {
        ModuleInfo.register(this);
    }

    public static Object _mthcatch(Object obj, Procedure procedure, Procedure procedure1)
    {
        try
        {
            procedure = ((Procedure) (procedure.apply0()));
        }
        // Misplaced declaration of an exception variable
        catch (Procedure procedure)
        {
            return procedure.applyHandler(obj, procedure1);
        }
        return procedure;
    }

    public static void compileFile(CharSequence charsequence, String s)
    {
        SourceMessages sourcemessages = new SourceMessages();
        charsequence = CompileFile.read(charsequence.toString(), sourcemessages);
        charsequence.explicit = true;
        if (sourcemessages.seenErrors())
        {
            throw (Throwable)new SyntaxException(sourcemessages);
        }
        charsequence.compileToArchive(charsequence.getModule(), s);
        if (sourcemessages.seenErrors())
        {
            throw (Throwable)new SyntaxException(sourcemessages);
        } else
        {
            return;
        }
    }

    public static Object convertListToStringArray(Object obj)
    {
        LList llist;
        String as[];
        int i;
        try
        {
            llist = (LList)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "length", 1, obj);
        }
        as = new String[lists.length(llist)];
        i = 0;
        do
        {
            if (lists.isNull(obj))
            {
                return as;
            }
            Pair pair;
            try
            {
                pair = (Pair)obj;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "pp", -2, obj);
            }
            obj = pair.getCar();
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = obj.toString();
            }
            as[i] = ((String) (obj));
            obj = pair.getCdr();
            i++;
        } while (true);
    }

    public static Object convertVectorToStringArray(Object obj)
    {
        Object obj1;
        String as[];
        int i;
        try
        {
            obj1 = (FVector)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "vector-length", 1, obj);
        }
        i = vectors.vectorLength(((FVector) (obj1)));
        as = new String[i];
        obj1 = Lit0;
        while (Scheme.numEqu.apply2(obj1, Integer.valueOf(i)) == Boolean.FALSE) 
        {
            int j = ((Number)obj1).intValue();
            Object obj2;
            int k;
            try
            {
                obj2 = (FVector)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                throw new WrongType(((ClassCastException) (obj1)), "vector-ref", 1, obj);
            }
            try
            {
                k = ((Number)obj1).intValue();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new WrongType(((ClassCastException) (obj)), "vector-ref", 2, obj1);
            }
            obj2 = vectors.vectorRef(((FVector) (obj2)), k);
            if (obj2 == null)
            {
                obj2 = null;
            } else
            {
                obj2 = obj2.toString();
            }
            as[j] = ((String) (obj2));
            obj1 = AddOp.$Pl.apply2(obj1, Lit1);
        }
        return as;
    }

    public static Process makeProcess(Object obj, Object obj1)
    {
        Runtime runtime;
        String as[];
        if (vectors.isVector(obj))
        {
            obj = convertVectorToStringArray(obj);
        } else
        if (lists.isList(obj))
        {
            obj = convertListToStringArray(obj);
        } else
        if (strings.isString(obj))
        {
            obj = command$Mnparse.apply1(obj);
        } else
        if (!(obj instanceof String[]))
        {
            obj = misc.error$V("invalid arguments to make-process", new Object[0]);
        }
        runtime = Runtime.getRuntime();
        try
        {
            as = (String[])obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            throw new WrongType(((ClassCastException) (obj1)), "java.lang.Runtime.exec(java.lang.String[],java.lang.String[])", 2, obj);
        }
        try
        {
            obj = (String[])obj1;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throw new WrongType(((ClassCastException) (obj)), "java.lang.Runtime.exec(java.lang.String[],java.lang.String[])", 3, obj1);
        }
        return runtime.exec(as, ((String []) (obj)));
    }

    public static InputStream openInputPipe(Object obj)
    {
        return makeProcess(obj, null).getInputStream();
    }

    public static void processCommandLineAssignments()
    {
        ApplicationMainSupport.processSetProperties();
    }

    public static int system(Object obj)
    {
        return makeProcess(obj, null).waitFor();
    }

    public static Object tokenizeStringToStringArray(String s)
    {
        Object obj = new StringTokenizer(s);
        for (s = LList.Empty; ((StringTokenizer) (obj)).hasMoreTokens(); s = lists.cons(((StringTokenizer) (obj)).nextToken(), s)) { }
        String as[];
        int i;
        try
        {
            obj = (LList)s;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "length", 1, s);
        }
        i = lists.length(((LList) (obj)));
        as = new String[i];
        i--;
        do
        {
            if (lists.isNull(s))
            {
                return as;
            }
            Pair pair;
            try
            {
                pair = (Pair)s;
            }
            catch (ClassCastException classcastexception1)
            {
                throw new WrongType(classcastexception1, "pp", -2, s);
            }
            s = ((String) (pair.getCar()));
            if (s == null)
            {
                s = null;
            } else
            {
                s = s.toString();
            }
            as[i] = s;
            s = ((String) (pair.getCdr()));
            i--;
        } while (true);
    }

    public static String[] tokenizeStringUsingShell(Object obj)
    {
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        return (new String[] {
            "/bin/sh", "-c", obj
        });
    }

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 10)
        {
            processCommandLineAssignments();
            return Values.empty;
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

        case 2: // '\002'
            return openInputPipe(obj);

        case 3: // '\003'
            return Integer.valueOf(system(obj));

        case 4: // '\004'
            return convertVectorToStringArray(obj);

        case 5: // '\005'
            return convertListToStringArray(obj);

        case 6: // '\006'
            if (obj == null)
            {
                modulemethod = null;
            } else
            {
                modulemethod = obj.toString();
            }
            return tokenizeStringToStringArray(modulemethod);

        case 7: // '\007'
            return tokenizeStringUsingShell(obj);
        }
    }

    public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply2(modulemethod, obj, obj1);

        case 1: // '\001'
            return makeProcess(obj, obj1);

        case 8: // '\b'
            break;
        }
        CharSequence charsequence;
        try
        {
            charsequence = (CharSequence)obj;
        }
        // Misplaced declaration of an exception variable
        catch (ModuleMethod modulemethod)
        {
            throw new WrongType(modulemethod, "compile-file", 1, obj);
        }
        if (obj1 == null)
        {
            modulemethod = null;
        } else
        {
            modulemethod = obj1.toString();
        }
        compileFile(charsequence, modulemethod);
        return Values.empty;
    }

    public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
    {
        if (modulemethod.selector == 9)
        {
            try
            {
                modulemethod = (Procedure)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "catch", 2, obj1);
            }
            try
            {
                obj1 = (Procedure)obj2;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "catch", 3, obj2);
            }
            return _mthcatch(obj, modulemethod, ((Procedure) (obj1)));
        } else
        {
            return super.apply3(modulemethod, obj, obj1, obj2);
        }
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 10)
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
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

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

        case 4: // '\004'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 3: // '\003'
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
        switch (modulemethod.selector)
        {
        default:
            return super.match2(modulemethod, obj, obj1, callcontext);

        case 8: // '\b'
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

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.value2 = obj1;
            callcontext.proc = modulemethod;
            callcontext.pc = 2;
            return 0;
        }
    }

    public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
    {
        if (modulemethod.selector == 9)
        {
            callcontext.value1 = obj;
            if (!(obj1 instanceof Procedure))
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

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
        if (IsEqual.apply(System.getProperty("file.separator"), "/"))
        {
            callcontext = tokenize$Mnstring$Mnusing$Mnshell;
        } else
        {
            callcontext = tokenize$Mnstring$Mnto$Mnstring$Mnarray;
        }
        command$Mnparse = callcontext;
    }

    static 
    {
        Lit11 = (SimpleSymbol)(new SimpleSymbol("process-command-line-assignments")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("catch")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("compile-file")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("tokenize-string-using-shell")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("tokenize-string-to-string-array")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("convert-list-to-string-array")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("convert-vector-to-string-array")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("system")).readResolve();
        Lit3 = (SimpleSymbol)(new SimpleSymbol("open-input-pipe")).readResolve();
        Lit2 = (SimpleSymbol)(new SimpleSymbol("make-process")).readResolve();
        $instance = new system();
        system system1 = $instance;
        make$Mnprocess = new ModuleMethod(system1, 1, Lit2, 8194);
        open$Mninput$Mnpipe = new ModuleMethod(system1, 2, Lit3, 4097);
        system = new ModuleMethod(system1, 3, Lit4, 4097);
        convert$Mnvector$Mnto$Mnstring$Mnarray = new ModuleMethod(system1, 4, Lit5, 4097);
        convert$Mnlist$Mnto$Mnstring$Mnarray = new ModuleMethod(system1, 5, Lit6, 4097);
        tokenize$Mnstring$Mnto$Mnstring$Mnarray = new ModuleMethod(system1, 6, Lit7, 4097);
        tokenize$Mnstring$Mnusing$Mnshell = new ModuleMethod(system1, 7, Lit8, 4097);
        compile$Mnfile = new ModuleMethod(system1, 8, Lit9, 8194);
        _fldcatch = new ModuleMethod(system1, 9, Lit10, 12291);
        process$Mncommand$Mnline$Mnassignments = new ModuleMethod(system1, 10, Lit11, 0);
        $instance.run();
    }
}
