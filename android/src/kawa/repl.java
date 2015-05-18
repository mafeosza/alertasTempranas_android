// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa;

import gnu.bytecode.ClassType;
import gnu.expr.ApplicationMainSupport;
import gnu.expr.Compilation;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleExp;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleManager;
import gnu.kawa.servlet.HttpRequestContext;
import gnu.lists.FString;
import gnu.mapping.CharArrayInPort;
import gnu.mapping.Environment;
import gnu.mapping.InPort;
import gnu.mapping.OutPort;
import gnu.mapping.Procedure0or1;
import gnu.mapping.Values;
import gnu.text.Options;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import gnu.text.WriterManager;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

// Referenced classes of package kawa:
//            Shell, Telnet, TelnetRepl, Version

public class repl extends Procedure0or1
{

    public static String compilationTopname = null;
    static int defaultParseOptions = 72;
    public static String homeDirectory;
    public static boolean noConsole;
    static Language previousLanguage;
    static boolean shutdownRegistered;
    Language language;

    public repl(Language language1)
    {
        language = language1;
    }

    static void bad_option(String s)
    {
        System.err.println((new StringBuilder()).append("kawa: bad option '").append(s).append("'").toString());
        printOptions(System.err);
        System.exit(-1);
    }

    static void checkInitFile()
    {
        if (homeDirectory == null)
        {
            Object obj = null;
            homeDirectory = System.getProperty("user.home");
            Object obj1;
            if (homeDirectory != null)
            {
                obj1 = new FString(homeDirectory);
                if ("/".equals(System.getProperty("file.separator")))
                {
                    obj = ".kawarc.scm";
                } else
                {
                    obj = "kawarc.scm";
                }
                obj = new File(homeDirectory, ((String) (obj)));
            } else
            {
                obj1 = Boolean.FALSE;
            }
            Environment.getCurrent().put("home-directory", obj1);
            if (obj != null && ((File) (obj)).exists() && !Shell.runFileOrClass(((File) (obj)).getPath(), true, 0))
            {
                System.exit(-1);
            }
        }
    }

    public static void compileFiles(String as[], int i, int j)
    {
        Compilation acompilation[];
        ModuleInfo amoduleinfo[];
        SourceMessages sourcemessages;
        ModuleManager modulemanager;
        int k;
        modulemanager = ModuleManager.getInstance();
        acompilation = new Compilation[j - i];
        amoduleinfo = new ModuleInfo[j - i];
        sourcemessages = new SourceMessages();
        k = i;
_L2:
        Object obj;
        Object obj1;
        String s;
        Object obj2;
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s = as[k];
        getLanguageFromFilenameExtension(s);
        obj2 = Language.getDefaultLanguage();
        obj1 = null;
        obj = obj1;
        Object obj3 = InPort.openFile(s);
        obj = obj1;
        obj1 = ((Language) (obj2)).parse(((InPort) (obj3)), sourcemessages, defaultParseOptions);
        obj = obj1;
        if (compilationTopname == null)
        {
            break MISSING_BLOCK_LABEL_153;
        }
        obj = obj1;
        obj2 = new ClassType(Compilation.mangleNameIfNeeded(compilationTopname));
        obj = obj1;
        obj3 = ((Compilation) (obj1)).getModule();
        obj = obj1;
        ((ModuleExp) (obj3)).setType(((ClassType) (obj2)));
        obj = obj1;
        ((ModuleExp) (obj3)).setName(compilationTopname);
        obj = obj1;
        obj1.mainClass = ((ClassType) (obj2));
        obj = obj1;
        amoduleinfo[k - i] = modulemanager.find(((Compilation) (obj1)));
        acompilation[k - i] = ((Compilation) (obj1));
_L5:
        if (sourcemessages.seenErrorsOrWarnings())
        {
            System.err.println((new StringBuilder()).append("(compiling ").append(s).append(')').toString());
            if (sourcemessages.checkErrors(System.err, 20))
            {
                System.exit(1);
            }
        }
        k++;
        if (true) goto _L2; else goto _L1
        FileNotFoundException filenotfoundexception;
        filenotfoundexception;
        obj = obj1;
        System.err.println(filenotfoundexception);
        obj = obj1;
        System.exit(-1);
_L1:
        k = i;
_L4:
        if (k >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = as[k];
        obj1 = acompilation[k - i];
        boolean flag;
        System.err.println((new StringBuilder()).append("(compiling ").append(((String) (obj))).append(" to ").append(((Compilation) (obj1)).mainClass.getName()).append(')').toString());
        amoduleinfo[k - i].loadByStages(14);
        flag = sourcemessages.seenErrors();
        sourcemessages.checkErrors(System.err, 50);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_372;
        }
        System.exit(-1);
        acompilation[k - i] = ((Compilation) (obj1));
        flag = sourcemessages.seenErrors();
        sourcemessages.checkErrors(System.err, 50);
        if (flag)
        {
            try
            {
                System.exit(-1);
            }
            catch (Throwable throwable)
            {
                internalError(throwable, ((Compilation) (obj1)), obj);
            }
        }
        k++;
        if (true) goto _L4; else goto _L3
        obj1;
        if (!(obj1 instanceof SyntaxException) || ((SyntaxException)obj1).getMessages() != sourcemessages)
        {
            internalError(((Throwable) (obj1)), ((Compilation) (obj)), s);
        }
          goto _L5
_L3:
    }

    public static void getLanguage()
    {
        if (previousLanguage == null)
        {
            previousLanguage = Language.getInstance(null);
            Language.setDefaults(previousLanguage);
        }
    }

    public static void getLanguageFromFilenameExtension(String s)
    {
        if (previousLanguage == null)
        {
            previousLanguage = Language.getInstanceFromFilenameExtension(s);
            if (previousLanguage != null)
            {
                Language.setDefaults(previousLanguage);
                return;
            }
        }
        getLanguage();
    }

    static void internalError(Throwable throwable, Compilation compilation, Object obj)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if (compilation != null)
        {
            String s = compilation.getFileName();
            int i = compilation.getLineNumber();
            if (s != null && i > 0)
            {
                stringbuffer.append(s);
                stringbuffer.append(':');
                stringbuffer.append(i);
                stringbuffer.append(": ");
            }
        }
        stringbuffer.append("internal error while compiling ");
        stringbuffer.append(obj);
        System.err.println(stringbuffer.toString());
        throwable.printStackTrace(System.err);
        System.exit(-1);
    }

    public static void main(String args[])
    {
        int i = processArgs(args, 0, args.length);
        if (i < 0)
        {
            if (!shutdownRegistered)
            {
                OutPort.runCleanups();
            }
            ModuleBody.exitDecrement();
            return;
        }
        if (i >= args.length) goto _L2; else goto _L1
_L1:
        String s = args[i];
        getLanguageFromFilenameExtension(s);
        setArgs(args, i + 1);
        checkInitFile();
        Shell.runFileOrClass(s, false, 0);
_L5:
        if (!shutdownRegistered)
        {
            OutPort.runCleanups();
        }
        ModuleBody.exitDecrement();
        return;
_L2:
        getLanguage();
        setArgs(args, i);
        checkInitFile();
        if (!shouldUseGuiConsole()) goto _L4; else goto _L3
_L3:
        startGuiConsole();
          goto _L5
        args;
        if (!shutdownRegistered)
        {
            OutPort.runCleanups();
        }
        ModuleBody.exitDecrement();
        throw args;
_L4:
        if (Shell.run(Language.getDefaultLanguage(), Environment.getCurrent())) goto _L5; else goto _L6
_L6:
        System.exit(-1);
          goto _L5
    }

    public static void printOption(PrintStream printstream, String s, String s1)
    {
        printstream.print(" ");
        printstream.print(s);
        int j = s.length();
        for (int i = 0; i < 30 - (j + 1); i++)
        {
            printstream.print(" ");
        }

        printstream.print(" ");
        printstream.println(s1);
    }

    public static void printOptions(PrintStream printstream)
    {
        printstream.println("Usage: [java kawa.repl | kawa] [options ...]");
        printstream.println();
        printstream.println(" Generic options:");
        printOption(printstream, "--help", "Show help about options");
        printOption(printstream, "--author", "Show author information");
        printOption(printstream, "--version", "Show version information");
        printstream.println();
        printstream.println(" Options");
        printOption(printstream, "-e <expr>", "Evaluate expression <expr>");
        printOption(printstream, "-c <expr>", "Same as -e, but make sure ~/.kawarc.scm is run first");
        printOption(printstream, "-f <filename>", "File to interpret");
        printOption(printstream, "-s| --", "Start reading commands interactively from console");
        printOption(printstream, "-w", "Launch the interpreter in a GUI window");
        printOption(printstream, "--server <port>", "Start a server accepting telnet connections on <port>");
        printOption(printstream, "--debug-dump-zip", "Compiled interactive expressions to a zip archive");
        printOption(printstream, "--debug-print-expr", "Print generated internal expressions");
        printOption(printstream, "--debug-print-final-expr", "Print expression after any optimizations");
        printOption(printstream, "--debug-error-prints-stack-trace", "Print stack trace with errors");
        printOption(printstream, "--debug-warning-prints-stack-trace", "Print stack trace with warnings");
        printOption(printstream, "--[no-]full-tailcalls", "(Don't) use full tail-calls");
        printOption(printstream, "-C <filename> ...", "Compile named files to Java class files");
        printOption(printstream, "--output-format <format>", "Use <format> when printing top-level output");
        printOption(printstream, "--<language>", "Select source language, one of:");
        String as[][] = Language.getLanguages();
        for (int i = 0; i < as.length; i++)
        {
            printstream.print("   ");
            String as1[] = as[i];
            int l = as1.length;
            for (int k = 0; k < l - 1; k++)
            {
                printstream.print((new StringBuilder()).append(as1[k]).append(" ").toString());
            }

            if (i == 0)
            {
                printstream.print("[default]");
            }
            printstream.println();
        }

        printstream.println(" Compilation options, must be specified before -C");
        printOption(printstream, "-d <dirname>", "Directory to place .class files in");
        printOption(printstream, "-P <prefix>", "Prefix to prepand to class names");
        printOption(printstream, "-T <topname>", "name to give to top-level class");
        printOption(printstream, "--main", "Generate an application, with a main method");
        printOption(printstream, "--applet", "Generate an applet");
        printOption(printstream, "--servlet", "Generate a servlet");
        printOption(printstream, "--module-static", "Top-level definitions are by default static");
        ArrayList arraylist = Compilation.options.keys();
        for (int j = 0; j < arraylist.size(); j++)
        {
            String s = (String)arraylist.get(j);
            printOption(printstream, (new StringBuilder()).append("--").append(s).toString(), Compilation.options.getDoc(s));
        }

        printstream.println();
        printstream.println("For more information go to:  http://www.gnu.org/software/kawa/");
    }

    public static int processArgs(String as[], int i, int j)
    {
        int l;
        boolean flag;
        flag = false;
        l = i;
_L2:
        String as1[];
        int k;
        if (l >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        as1 = as[l];
        if (as1.equals("-c") || as1.equals("-e"))
        {
            i = l + 1;
            if (i == j)
            {
                bad_option(as1);
            }
            getLanguage();
            setArgs(as, i + 1);
            if (as1.equals("-c"))
            {
                checkInitFile();
            }
            Object obj2 = Language.getDefaultLanguage();
            SourceMessages sourcemessages = new SourceMessages();
            obj2 = Shell.run(((Language) (obj2)), Environment.getCurrent(), new CharArrayInPort(as[i]), OutPort.outDefault(), null, sourcemessages);
            if (obj2 != null)
            {
                Shell.printError(((Throwable) (obj2)), sourcemessages, OutPort.errDefault());
                System.exit(-1);
            }
            k = 1;
        } else
        {
label0:
            {
                if (!as1.equals("-f"))
                {
                    break label0;
                }
                i = l + 1;
                if (i == j)
                {
                    bad_option(as1);
                }
                String s = as[i];
                getLanguageFromFilenameExtension(s);
                setArgs(as, i + 1);
                checkInitFile();
                if (!Shell.runFileOrClass(s, true, 0))
                {
                    System.exit(-1);
                }
                k = 1;
            }
        }
_L19:
        l = i + 1;
        flag = k;
        if (true) goto _L2; else goto _L1
        if (!as1.startsWith("--script")) goto _L4; else goto _L3
_L3:
        Object obj;
        obj = as1.substring(8);
        l++;
        flag = false;
        i = ((flag) ? 1 : 0);
        k = l;
        if (((String) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_264;
        }
        i = Integer.parseInt(((String) (obj)));
        k = l;
_L5:
        if (k == j)
        {
            bad_option(as1);
        }
        obj = as[k];
        getLanguageFromFilenameExtension(((String) (obj)));
        setArgs(as, k + 1);
        checkInitFile();
        if (!Shell.runFileOrClass(((String) (obj)), true, i))
        {
            System.exit(-1);
        }
        return -1;
        Throwable throwable;
        throwable;
        k = j;
        i = ((flag) ? 1 : 0);
        if (true) goto _L5; else goto _L4
_L4:
        if (!as1.equals("\\")) goto _L7; else goto _L6
_L6:
        Object obj3;
        l++;
        if (l == j)
        {
            bad_option(as1);
        }
        obj3 = as[l];
        throwable = new SourceMessages();
        BufferedInputStream bufferedinputstream;
        bufferedinputstream = new BufferedInputStream(new FileInputStream(((String) (obj3))));
        j = bufferedinputstream.read();
        if (j != 35) goto _L9; else goto _L8
_L8:
        Vector vector;
        as1 = new StringBuffer(100);
        vector = new Vector(10);
        k = 0;
_L10:
        i = k;
        if (j == 10)
        {
            break MISSING_BLOCK_LABEL_451;
        }
        i = k;
        if (j == 13)
        {
            break MISSING_BLOCK_LABEL_451;
        }
        i = k;
        if (j < 0)
        {
            break MISSING_BLOCK_LABEL_451;
        }
        j = bufferedinputstream.read();
          goto _L10
_L16:
        k = bufferedinputstream.read();
        if (k >= 0) goto _L12; else goto _L11
_L11:
        System.err.println((new StringBuilder()).append("unexpected end-of-file processing argument line for: '").append(((String) (obj3))).append('\'').toString());
        System.exit(-1);
          goto _L12
_L20:
        if (as1.length() > 0)
        {
            vector.addElement(as1.toString());
        }
        i = vector.size();
        if (i <= 0) goto _L9; else goto _L13
_L13:
        as1 = new String[i];
        vector.copyInto(as1);
        j = processArgs(as1, 0, i);
        if (j < 0 || j >= i) goto _L9; else goto _L14
_L14:
        System.err.println((new StringBuilder()).append("").append(i - j).append(" unused meta args").toString());
_L9:
        getLanguageFromFilenameExtension(((String) (obj3)));
        obj3 = InPort.openFile(bufferedinputstream, obj3);
        setArgs(as, l + 1);
        checkInitFile();
        as = OutPort.errDefault();
        obj3 = Shell.run(Language.getDefaultLanguage(), Environment.getCurrent(), ((InPort) (obj3)), OutPort.outDefault(), null, throwable);
        throwable.printAll(as, 20);
        if (obj3 != null)
        {
            try
            {
                if ((obj3 instanceof SyntaxException) && ((SyntaxException)obj3).getMessages() == throwable)
                {
                    System.exit(1);
                }
                throw obj3;
            }
            // Misplaced declaration of an exception variable
            catch (String as[])
            {
                Shell.printError(as, throwable, OutPort.errDefault());
            }
            System.exit(1);
        }
        return -1;
_L21:
        if (k != 32)
        {
            j = i;
            if (k != 9)
            {
                break MISSING_BLOCK_LABEL_738;
            }
        }
        if (as1.length() <= 0) goto _L16; else goto _L15
_L15:
        vector.addElement(as1.toString());
        as1.setLength(0);
          goto _L16
_L18:
        as1.append((char)k);
        i = j;
          goto _L16
_L23:
        j = i;
        if (k != i) goto _L18; else goto _L17
_L17:
        i = 0;
          goto _L16
_L7:
        if (as1.equals("-s") || as1.equals("--"))
        {
            getLanguage();
            setArgs(as, l + 1);
            checkInitFile();
            Shell.run(Language.getDefaultLanguage(), Environment.getCurrent());
            return -1;
        }
        if (as1.equals("-w"))
        {
            i = l + 1;
            getLanguage();
            setArgs(as, i);
            checkInitFile();
            startGuiConsole();
            k = 1;
        } else
        if (as1.equals("-d"))
        {
            i = l + 1;
            if (i == j)
            {
                bad_option(as1);
            }
            ModuleManager.getInstance().setCompilationDirectory(as[i]);
            k = ((flag) ? 1 : 0);
        } else
        if (as1.equals("--target") || as1.equals("target"))
        {
            i = l + 1;
            if (i == j)
            {
                bad_option(as1);
            }
            String s1 = as[i];
            if (s1.equals("7"))
            {
                Compilation.defaultClassFileVersion = 0x330000;
            }
            if (s1.equals("6") || s1.equals("1.6"))
            {
                Compilation.defaultClassFileVersion = 0x320000;
                k = ((flag) ? 1 : 0);
            } else
            if (s1.equals("5") || s1.equals("1.5"))
            {
                Compilation.defaultClassFileVersion = 0x310000;
                k = ((flag) ? 1 : 0);
            } else
            if (s1.equals("1.4"))
            {
                Compilation.defaultClassFileVersion = 0x300000;
                k = ((flag) ? 1 : 0);
            } else
            if (s1.equals("1.3"))
            {
                Compilation.defaultClassFileVersion = 0x2f0000;
                k = ((flag) ? 1 : 0);
            } else
            if (s1.equals("1.2"))
            {
                Compilation.defaultClassFileVersion = 0x2e0000;
                k = ((flag) ? 1 : 0);
            } else
            if (s1.equals("1.1"))
            {
                Compilation.defaultClassFileVersion = 0x2d0003;
                k = ((flag) ? 1 : 0);
            } else
            {
                bad_option(s1);
                k = ((flag) ? 1 : 0);
            }
        } else
        if (as1.equals("-P"))
        {
            i = l + 1;
            if (i == j)
            {
                bad_option(as1);
            }
            Compilation.classPrefixDefault = as[i];
            k = ((flag) ? 1 : 0);
        } else
        if (as1.equals("-T"))
        {
            i = l + 1;
            if (i == j)
            {
                bad_option(as1);
            }
            compilationTopname = as[i];
            k = ((flag) ? 1 : 0);
        } else
        {
            if (as1.equals("-C"))
            {
                i = l + 1;
                if (i == j)
                {
                    bad_option(as1);
                }
                compileFiles(as, i, j);
                return -1;
            }
            if (as1.equals("--output-format") || as1.equals("--format"))
            {
                i = l + 1;
                if (i == j)
                {
                    bad_option(as1);
                }
                Shell.setDefaultFormat(as[i]);
                k = ((flag) ? 1 : 0);
            } else
            if (as1.equals("--connect"))
            {
                l++;
                if (l == j)
                {
                    bad_option(as1);
                }
                if (as[l].equals("-"))
                {
                    i = 0;
                } else
                {
                    try
                    {
                        i = Integer.parseInt(as[l]);
                    }
                    catch (NumberFormatException numberformatexception)
                    {
                        bad_option("--connect port#");
                        i = -1;
                    }
                }
                try
                {
                    Object obj4 = new Telnet(new Socket(InetAddress.getByName(null), i), true);
                    TelnetInputStream telnetinputstream = ((Telnet) (obj4)).getInputStream();
                    obj4 = new PrintStream(((Telnet) (obj4)).getOutputStream(), true);
                    System.setIn(telnetinputstream);
                    System.setOut(((PrintStream) (obj4)));
                    System.setErr(((PrintStream) (obj4)));
                }
                // Misplaced declaration of an exception variable
                catch (String as[])
                {
                    as.printStackTrace(System.err);
                    throw new Error(as.toString());
                }
                k = ((flag) ? 1 : 0);
                i = l;
            } else
            {
                if (as1.equals("--server"))
                {
                    getLanguage();
                    i = l + 1;
                    if (i == j)
                    {
                        bad_option(as1);
                    }
                    if (as[i].equals("-"))
                    {
                        i = 0;
                    } else
                    {
                        try
                        {
                            i = Integer.parseInt(as[i]);
                        }
                        // Misplaced declaration of an exception variable
                        catch (String as[])
                        {
                            bad_option("--server port#");
                            i = -1;
                        }
                    }
                    try
                    {
                        as = new ServerSocket(i);
                        i = as.getLocalPort();
                        System.err.println((new StringBuilder()).append("Listening on port ").append(i).toString());
                        do
                        {
                            System.err.print("waiting ... ");
                            System.err.flush();
                            Socket socket = as.accept();
                            System.err.println((new StringBuilder()).append("got connection from ").append(socket.getInetAddress()).append(" port:").append(socket.getPort()).toString());
                            TelnetRepl.serve(Language.getDefaultLanguage(), socket);
                        } while (true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        throw new Error(as.toString());
                    }
                }
                if (as1.equals("--http-auto-handler"))
                {
                    i = l + 2;
                    if (i >= j)
                    {
                        bad_option(as1);
                    }
                    System.err.println("kawa: HttpServer classes not found");
                    System.exit(-1);
                    k = ((flag) ? 1 : 0);
                } else
                if (as1.equals("--http-start"))
                {
                    i = l + 1;
                    if (i >= j)
                    {
                        bad_option("missing httpd port argument");
                    }
                    System.err.println("kawa: HttpServer classes not found");
                    System.exit(-1);
                    k = ((flag) ? 1 : 0);
                } else
                if (as1.equals("--main"))
                {
                    Compilation.generateMainDefault = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--applet"))
                {
                    defaultParseOptions |= 0x10;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--servlet"))
                {
                    defaultParseOptions |= 0x20;
                    HttpRequestContext.importServletDefinitions = 2;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--debug-dump-zip"))
                {
                    ModuleExp.dumpZipPrefix = "kawa-zip-dump-";
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--debug-print-expr"))
                {
                    Compilation.debugPrintExpr = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--debug-print-final-expr"))
                {
                    Compilation.debugPrintFinalExpr = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--debug-error-prints-stack-trace"))
                {
                    SourceMessages.debugStackTraceOnError = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--debug-warning-prints-stack-trace"))
                {
                    SourceMessages.debugStackTraceOnWarning = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--module-nonstatic") || as1.equals("--no-module-static"))
                {
                    Compilation.moduleStatic = -1;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--module-static"))
                {
                    Compilation.moduleStatic = 1;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--module-static-run"))
                {
                    Compilation.moduleStatic = 2;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--no-inline") || as1.equals("--inline=none"))
                {
                    Compilation.inlineOk = false;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--no-console"))
                {
                    noConsole = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--inline"))
                {
                    Compilation.inlineOk = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--cps"))
                {
                    Compilation.defaultCallConvention = 4;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--full-tailcalls"))
                {
                    Compilation.defaultCallConvention = 3;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--no-full-tailcalls"))
                {
                    Compilation.defaultCallConvention = 1;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--pedantic"))
                {
                    Language.requirePedantic = true;
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--help"))
                {
                    printOptions(System.out);
                    System.exit(0);
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--author"))
                {
                    System.out.println("Per Bothner <per@bothner.com>");
                    System.exit(0);
                    k = ((flag) ? 1 : 0);
                    i = l;
                } else
                if (as1.equals("--version"))
                {
                    System.out.print("Kawa ");
                    System.out.print(Version.getVersion());
                    System.out.println();
                    System.out.println("Copyright (C) 2009 Per Bothner");
                    k = 1;
                    i = l;
                } else
                {
label1:
                    {
                        if (as1.length() <= 0 || as1.charAt(0) != '-')
                        {
                            break label1;
                        }
                        Object obj5 = as1;
                        Object obj1 = obj5;
                        if (((String) (obj5)).length() > 2)
                        {
                            obj1 = obj5;
                            if (((String) (obj5)).charAt(0) == '-')
                            {
                                if (((String) (obj5)).charAt(1) == '-')
                                {
                                    i = 2;
                                } else
                                {
                                    i = 1;
                                }
                                obj1 = ((String) (obj5)).substring(i);
                            }
                        }
                        obj5 = Language.getInstance(((String) (obj1)));
                        if (obj5 != null)
                        {
                            if (previousLanguage == null)
                            {
                                Language.setDefaults(((Language) (obj5)));
                            } else
                            {
                                Language.setCurrentLanguage(((Language) (obj5)));
                            }
                            previousLanguage = ((Language) (obj5));
                            k = ((flag) ? 1 : 0);
                            i = l;
                        } else
                        {
                            i = ((String) (obj1)).indexOf("=");
                            String s2;
                            String s3;
                            Object obj6;
                            boolean flag1;
                            if (i < 0)
                            {
                                s2 = null;
                            } else
                            {
                                s2 = ((String) (obj1)).substring(i + 1);
                                obj1 = ((String) (obj1)).substring(0, i);
                            }
                            if (((String) (obj1)).startsWith("no-") && ((String) (obj1)).length() > 3)
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            obj6 = obj1;
                            s3 = s2;
                            if (s2 == null)
                            {
                                obj6 = obj1;
                                s3 = s2;
                                if (flag1)
                                {
                                    s3 = "no";
                                    obj6 = ((String) (obj1)).substring(3);
                                }
                            }
                            s2 = Compilation.options.set(((String) (obj6)), s3);
                            k = ((flag) ? 1 : 0);
                            i = l;
                            if (s2 != null)
                            {
                                obj1 = s2;
                                if (flag1)
                                {
                                    obj1 = s2;
                                    if (s2 == "unknown option name")
                                    {
                                        obj1 = (new StringBuilder()).append("both '--no-' prefix and '=").append(s3).append("' specified").toString();
                                    }
                                }
                                if (obj1 == "unknown option name")
                                {
                                    bad_option(as1);
                                    k = ((flag) ? 1 : 0);
                                    i = l;
                                } else
                                {
                                    System.err.println((new StringBuilder()).append("kawa: bad option '").append(as1).append("': ").append(((String) (obj1))).toString());
                                    System.exit(-1);
                                    k = ((flag) ? 1 : 0);
                                    i = l;
                                }
                            }
                        }
                    }
                }
            }
        }
          goto _L19
        k = ((flag) ? 1 : 0);
        i = l;
        if (ApplicationMainSupport.processSetProperty(as1)) goto _L19; else goto _L1
_L1:
        if (flag)
        {
            return -1;
        } else
        {
            return l;
        }
_L12:
        if (i != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (k != 92 && k != 39 && k != 34)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = k;
          goto _L16
        if (k != 10 && k != 13) goto _L21; else goto _L20
        if (i != 92) goto _L23; else goto _L22
_L22:
        j = 0;
          goto _L18
    }

    public static void setArgs(String as[], int i)
    {
        ApplicationMainSupport.setArgs(as, i);
    }

    public static boolean shouldUseGuiConsole()
    {
        if (!noConsole) goto _L2; else goto _L1
_L1:
        Object obj;
        return true;
_L2:
        if ((obj = Class.forName("java.lang.System").getMethod("console", new Class[0]).invoke(((Object) (new Object[0])), new Object[0])) == null) goto _L1; else goto _L3
_L3:
        return false;
        Throwable throwable;
        throwable;
        if (true) goto _L3; else goto _L4
_L4:
    }

    private static void startGuiConsole()
    {
        try
        {
            Class.forName("kawa.GuiConsole").newInstance();
            return;
        }
        catch (Exception exception)
        {
            System.err.println((new StringBuilder()).append("failed to create Kawa window: ").append(exception).toString());
        }
        System.exit(-1);
    }

    public Object apply0()
    {
        Shell.run(language, Environment.getCurrent());
        return Values.empty;
    }

    public Object apply1(Object obj)
    {
        Shell.run(language, (Environment)obj);
        return Values.empty;
    }

    static 
    {
        shutdownRegistered = WriterManager.instance.registerShutdownHook();
    }
}
