// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ZipLoader;
import gnu.expr.Compilation;
import gnu.expr.CompiledModule;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleManager;
import gnu.lists.AbstractFormat;
import gnu.lists.Consumer;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.TtyInPort;
import gnu.mapping.Values;
import gnu.mapping.WrappedException;
import gnu.mapping.WrongArguments;
import gnu.text.FilePath;
import gnu.text.Lexer;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Writer;
import java.lang.reflect.Method;
import java.net.URL;

public class Shell
{

    private static Class boolClasses[];
    public static ThreadLocal currentLoadPath = new ThreadLocal();
    public static Object defaultFormatInfo[];
    public static Method defaultFormatMethod;
    public static String defaultFormatName;
    static Object formats[][];
    private static Class httpPrinterClasses[] = {
        gnu/mapping/OutPort
    };
    private static Class noClasses[];
    private static Object portArg;
    private static Class xmlPrinterClasses[] = {
        gnu/mapping/OutPort, java/lang/Object
    };

    public Shell()
    {
    }

    public static final CompiledModule checkCompiledZip(InputStream inputstream, Path path, Environment environment, Language language)
        throws IOException
    {
        Environment environment1 = null;
        inputstream.mark(5);
        boolean flag;
        if (inputstream.read() == 80 && inputstream.read() == 75 && inputstream.read() == 3 && inputstream.read() == 4)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        try
        {
            inputstream.reset();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            return null;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        inputstream = environment1;
_L4:
        return inputstream;
_L2:
        inputstream.close();
        environment1 = Environment.getCurrent();
        inputstream = path.toString();
        if (environment == environment1)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        Environment.setCurrent(environment);
        if (!(path instanceof FilePath))
        {
            throw new RuntimeException((new StringBuilder()).append("load: ").append(inputstream).append(" - not a file path").toString());
        }
        break MISSING_BLOCK_LABEL_186;
        path;
        throw new WrappedException((new StringBuilder()).append("load: ").append(inputstream).append(" - ").append(path.toString()).toString(), path);
        inputstream;
        if (environment != environment1)
        {
            Environment.setCurrent(environment1);
        }
        throw inputstream;
        path = ((FilePath)path).toFile();
        if (!path.exists())
        {
            throw new RuntimeException((new StringBuilder()).append("load: ").append(inputstream).append(" - not found").toString());
        }
        if (!path.canRead())
        {
            throw new RuntimeException((new StringBuilder()).append("load: ").append(inputstream).append(" - not readable").toString());
        }
        path = CompiledModule.make((new ZipLoader(inputstream)).loadAllClasses(), language);
        inputstream = path;
        if (environment != environment1)
        {
            Environment.setCurrent(environment1);
            return path;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static CompiledModule compileSource(InPort inport, Environment environment, URL url, Language language, SourceMessages sourcemessages)
        throws SyntaxException, IOException
    {
        inport = language.parse(inport, sourcemessages, 1, ModuleManager.getInstance().findWithSourcePath(inport.getName()));
        CallContext.getInstance().values = Values.noArgs;
        environment = ((Environment) (ModuleExp.evalModule1(environment, inport, url, null)));
        if (environment == null || sourcemessages.seenErrors())
        {
            return null;
        } else
        {
            return new CompiledModule(inport.getModule(), environment, language);
        }
    }

    public static Consumer getOutputConsumer(OutPort outport)
    {
        Object aobj1[];
        Object aobj[] = defaultFormatInfo;
        if (outport == null)
        {
            return VoidConsumer.getInstance();
        }
        if (aobj == null)
        {
            return Language.getDefaultLanguage().getOutputConsumer(outport);
        }
        int i;
        int j;
        try
        {
            aobj1 = new Object[aobj.length - 4];
            System.arraycopy(((Object) (aobj)), 4, ((Object) (aobj1)), 0, aobj1.length);
            i = aobj1.length;
        }
        // Misplaced declaration of an exception variable
        catch (OutPort outport)
        {
            throw new RuntimeException((new StringBuilder()).append("cannot get output-format '").append(defaultFormatName).append("' - caught ").append(outport).toString());
        }
        j = i - 1;
        if (j < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i = j;
        if (aobj1[j] == portArg)
        {
            aobj1[j] = outport;
            i = j;
        }
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_44;
_L1:
        Object obj;
        obj = defaultFormatMethod.invoke(null, aobj1);
        if (!(obj instanceof AbstractFormat))
        {
            break MISSING_BLOCK_LABEL_145;
        }
        outport.objectFormat = (AbstractFormat)obj;
        return outport;
        outport = (Consumer)obj;
        return outport;
    }

    public static void printError(Throwable throwable, SourceMessages sourcemessages, OutPort outport)
    {
        if (throwable instanceof WrongArguments)
        {
            throwable = (WrongArguments)throwable;
            sourcemessages.printAll(outport, 20);
            if (((WrongArguments) (throwable)).usage != null)
            {
                outport.println((new StringBuilder()).append("usage: ").append(((WrongArguments) (throwable)).usage).toString());
            }
            throwable.printStackTrace(outport);
            return;
        }
        if (throwable instanceof ClassCastException)
        {
            sourcemessages.printAll(outport, 20);
            outport.println((new StringBuilder()).append("Invalid parameter, was: ").append(throwable.getMessage()).toString());
            throwable.printStackTrace(outport);
            return;
        }
        if (throwable instanceof SyntaxException)
        {
            SyntaxException syntaxexception = (SyntaxException)throwable;
            if (syntaxexception.getMessages() == sourcemessages)
            {
                syntaxexception.printAll(outport, 20);
                syntaxexception.clear();
                return;
            }
        }
        sourcemessages.printAll(outport, 20);
        throwable.printStackTrace(outport);
    }

    public static Throwable run(Language language, Environment environment, InPort inport, Consumer consumer, OutPort outport, URL url, SourceMessages sourcemessages)
    {
        int i;
        Language language1 = Language.setSaveCurrent(language);
        Lexer lexer = language.getLexer(inport, sourcemessages);
        Consumer consumer1;
        CallContext callcontext;
        Object obj;
        boolean flag;
        boolean flag1;
        if (outport != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        lexer.setInteractive(flag);
        callcontext = CallContext.getInstance();
        consumer1 = null;
        if (consumer != null)
        {
            consumer1 = callcontext.consumer;
            callcontext.consumer = consumer;
        }
        ModuleExp moduleexp;
        StringBuilder stringbuilder;
        try
        {
            Thread thread = Thread.currentThread();
            ClassLoader classloader = thread.getContextClassLoader();
            if (!(classloader instanceof ArrayClassLoader))
            {
                thread.setContextClassLoader(new ArrayClassLoader(classloader));
            }
        }
        catch (SecurityException securityexception) { }
_L9:
        obj = language.parse(lexer, 7, null);
        if (!flag) goto _L2; else goto _L1
_L1:
        flag1 = sourcemessages.checkErrors(outport, 20);
_L5:
        if (obj != null) goto _L4; else goto _L3
_L3:
        if (consumer != null)
        {
            callcontext.consumer = consumer1;
        }
        Language.restoreCurrent(language1);
        return null;
_L2:
        if (sourcemessages.seenErrors())
        {
            throw new SyntaxException(sourcemessages);
        }
        flag1 = false;
          goto _L5
_L4:
        if (flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        moduleexp = ((Compilation) (obj)).getModule();
        stringbuilder = (new StringBuilder()).append("atInteractiveLevel$");
        i = ModuleExp.interactiveCounter + 1;
        ModuleExp.interactiveCounter = i;
        moduleexp.setName(stringbuilder.append(i).toString());
_L7:
        i = inport.read();
        if (i >= 0 && i != 13 && i != 10)
        {
            continue; /* Loop/switch isn't completed */
        }
_L8:
        try
        {
            if (!ModuleExp.evalModule(environment, callcontext, ((Compilation) (obj)), url, outport))
            {
                break; /* Loop/switch isn't completed */
            }
            if (consumer instanceof Writer)
            {
                ((Writer)consumer).flush();
            }
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            if (!flag)
            {
                if (consumer != null)
                {
                    callcontext.consumer = consumer1;
                }
                Language.restoreCurrent(language1);
                return ((Throwable) (obj));
            }
        }
        finally
        {
            if (consumer != null)
            {
                callcontext.consumer = consumer1;
            }
            Language.restoreCurrent(language1);
            throw language;
        }
        break MISSING_BLOCK_LABEL_346;
        if (i == 32 || i == 9) goto _L7; else goto _L6
_L6:
        inport.unread();
          goto _L8
        printError(((Throwable) (obj)), sourcemessages, outport);
        break; /* Loop/switch isn't completed */
        if (i >= 0) goto _L9; else goto _L3
    }

    public static Throwable run(Language language, Environment environment, InPort inport, OutPort outport, OutPort outport1, SourceMessages sourcemessages)
    {
        AbstractFormat abstractformat;
        Consumer consumer;
        abstractformat = null;
        if (outport != null)
        {
            abstractformat = outport.objectFormat;
        }
        consumer = getOutputConsumer(outport);
        language = run(language, environment, inport, consumer, outport1, null, sourcemessages);
        if (outport != null)
        {
            outport.objectFormat = abstractformat;
        }
        return language;
        language;
        if (outport != null)
        {
            outport.objectFormat = abstractformat;
        }
        throw language;
    }

    public static boolean run(Language language, Environment environment)
    {
        InPort inport = InPort.inDefault();
        SourceMessages sourcemessages = new SourceMessages();
        Object obj;
        if (inport instanceof TtyInPort)
        {
            obj = language.getPrompter();
            if (obj != null)
            {
                ((TtyInPort)inport).setPrompter(((gnu.mapping.Procedure) (obj)));
            }
            obj = OutPort.errDefault();
        } else
        {
            obj = null;
        }
        language = run(language, environment, inport, OutPort.outDefault(), ((OutPort) (obj)), sourcemessages);
        if (language == null)
        {
            return true;
        } else
        {
            printError(language, sourcemessages, OutPort.errDefault());
            return false;
        }
    }

    public static boolean run(Language language, Environment environment, InPort inport, Consumer consumer, OutPort outport, URL url)
    {
        SourceMessages sourcemessages = new SourceMessages();
        language = run(language, environment, inport, consumer, outport, url, sourcemessages);
        if (language != null)
        {
            printError(language, sourcemessages, outport);
        }
        return language == null;
    }

    public static final boolean runFile(InputStream inputstream, Path path, Environment environment, boolean flag, int i)
        throws Throwable
    {
        Object obj;
        Path path1;
        Language language;
        obj = inputstream;
        if (!(inputstream instanceof BufferedInputStream))
        {
            obj = new BufferedInputStream(inputstream);
        }
        language = Language.getDefaultLanguage();
        path1 = (Path)currentLoadPath.get();
        currentLoadPath.set(path);
        inputstream = checkCompiledZip(((InputStream) (obj)), path, environment, language);
        Object obj1;
        obj1 = inputstream;
        if (inputstream != null)
        {
            break MISSING_BLOCK_LABEL_222;
        }
        obj = InPort.openFile(((InputStream) (obj)), path);
_L2:
        i--;
        if (i < 0)
        {
            break; /* Loop/switch isn't completed */
        }
        ((InPort) (obj)).skipRestOfLine();
        if (true) goto _L2; else goto _L1
        inputstream;
        currentLoadPath.set(path1);
        throw inputstream;
_L1:
        URL url;
        obj1 = new SourceMessages();
        url = path.toURL();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        if (!ModuleBody.getMainPrintValues())
        {
            break MISSING_BLOCK_LABEL_159;
        }
        path = getOutputConsumer(OutPort.outDefault());
_L3:
        path = run(language, environment, ((InPort) (obj)), path, null, url, ((SourceMessages) (obj1)));
        if (path == null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        throw path;
        inputstream;
        ((InPort) (obj)).close();
        throw inputstream;
        path = new VoidConsumer();
          goto _L3
        path = compileSource(((InPort) (obj)), environment, url, language, ((SourceMessages) (obj1)));
        ((SourceMessages) (obj1)).printAll(OutPort.errDefault(), 20);
        inputstream = path;
        if (path != null)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        ((InPort) (obj)).close();
        currentLoadPath.set(path1);
        return false;
        ((InPort) (obj)).close();
        obj1 = inputstream;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        ((CompiledModule) (obj1)).evalModule(environment, OutPort.outDefault());
        currentLoadPath.set(path1);
        return true;
    }

    public static boolean runFileOrClass(String s, boolean flag, int i)
    {
        Language language = Language.getDefaultLanguage();
        if (!s.equals("-")) goto _L2; else goto _L1
_L1:
        InputStream inputstream;
        Path path;
        path = Path.valueOf("/dev/stdin");
        inputstream = System.in;
_L4:
        flag = runFile(inputstream, path, Environment.getCurrent(), flag, i);
        return flag;
_L2:
        Throwable throwable;
        try
        {
            path = Path.valueOf(s);
            inputstream = path.openInputStream();
        }
        catch (Throwable throwable1)
        {
            try
            {
                s = Class.forName(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                System.err.println((new StringBuilder()).append("Cannot read file ").append(throwable1.getMessage()).toString());
                return false;
            }
            try
            {
                CompiledModule.make(s, language).evalModule(Environment.getCurrent(), OutPort.outDefault());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return false;
            }
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
        throwable;
        throwable.printStackTrace(System.err);
        return false;
    }

    public static void setDefaultFormat(String s)
    {
        int i;
        s = s.intern();
        defaultFormatName = s;
        i = 0;
_L2:
        Object aobj[];
        Object obj;
        aobj = formats[i];
        obj = aobj[0];
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        System.err.println((new StringBuilder()).append("kawa: unknown output format '").append(s).append("'").toString());
        System.exit(-1);
_L4:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (obj != s) goto _L4; else goto _L3
_L3:
        defaultFormatInfo = aobj;
        try
        {
            defaultFormatMethod = Class.forName((String)aobj[1]).getMethod((String)aobj[2], (Class[])(Class[])aobj[3]);
        }
        catch (Throwable throwable)
        {
            System.err.println((new StringBuilder()).append("kawa:  caught ").append(throwable).append(" while looking for format '").append(s).append("'").toString());
            System.exit(-1);
        }
        if (!defaultFormatInfo[1].equals("gnu.lists.VoidConsumer"))
        {
            ModuleBody.setMainPrintValues(true);
        }
        return;
    }

    static 
    {
        noClasses = new Class[0];
        boolClasses = (new Class[] {
            Boolean.TYPE
        });
        portArg = "(port)";
        Class aclass[] = boolClasses;
        Boolean boolean1 = Boolean.FALSE;
        Object aobj[] = {
            "readable-scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", boolClasses, Boolean.TRUE
        };
        Object aobj1[] = {
            "elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", boolClasses, Boolean.FALSE
        };
        Object aobj2[] = {
            "readable-elisp", "gnu.kawa.functions.DisplayFormat", "getEmacsLispFormat", boolClasses, Boolean.TRUE
        };
        Object aobj3[] = {
            "clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.FALSE
        };
        Object aobj4[] = {
            "readable-clisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.TRUE
        };
        Class aclass1[] = boolClasses;
        Boolean boolean2 = Boolean.FALSE;
        Object aobj5[] = {
            "readable-commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", boolClasses, Boolean.TRUE
        };
        Object aobj6[] = {
            "xml", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, portArg, null
        };
        Object aobj7[] = {
            "html", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, portArg, "html"
        };
        Object aobj8[] = {
            "xhtml", "gnu.xml.XMLPrinter", "make", xmlPrinterClasses, portArg, "xhtml"
        };
        Object aobj9[] = {
            "cgi", "gnu.kawa.xml.HttpPrinter", "make", httpPrinterClasses, portArg
        };
        Class aclass2[] = noClasses;
        Object aobj10[] = {
            null
        };
        formats = (new Object[][] {
            new Object[] {
                "scheme", "gnu.kawa.functions.DisplayFormat", "getSchemeFormat", aclass, boolean1
            }, aobj, aobj1, aobj2, aobj3, aobj4, new Object[] {
                "commonlisp", "gnu.kawa.functions.DisplayFormat", "getCommonLispFormat", aclass1, boolean2
            }, aobj5, aobj6, aobj7, aobj8, aobj9, new Object[] {
                "ignore", "gnu.lists.VoidConsumer", "getInstance", aclass2
            }, aobj10
        });
    }
}
