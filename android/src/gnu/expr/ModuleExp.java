// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ArrayClassLoader;
import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.kawa.reflect.StaticFieldLocation;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Location;
import gnu.mapping.OutPort;
import gnu.mapping.Symbol;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import gnu.text.SourceMessages;
import gnu.text.SyntaxException;
import java.io.Externalizable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.URL;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

// Referenced classes of package gnu.expr:
//            LambdaExp, Compilation, ModuleInfo, Expression, 
//            ModuleContext, ModuleBody, Declaration, Language, 
//            QuoteExp, ReferenceExp, ClassExp, ExpVisitor

public class ModuleExp extends LambdaExp
    implements Externalizable
{

    public static final int EXPORT_SPECIFIED = 16384;
    public static final int IMMEDIATE = 0x100000;
    public static final int LAZY_DECLARATIONS = 0x80000;
    public static final int NONSTATIC_SPECIFIED = 0x10000;
    public static final int STATIC_RUN_SPECIFIED = 0x40000;
    public static final int STATIC_SPECIFIED = 32768;
    public static final int SUPERTYPE_SPECIFIED = 0x20000;
    public static boolean alwaysCompile;
    public static boolean compilerAvailable;
    public static String dumpZipPrefix;
    public static int interactiveCounter;
    static int lastZipCounter;
    public static boolean neverCompile = false;
    ModuleInfo info;
    ClassType interfaces[];
    ClassType superType;

    public ModuleExp()
    {
    }

    public static final boolean evalModule(Environment environment, CallContext callcontext, Compilation compilation, URL url, OutPort outport)
        throws Throwable
    {
        ModuleExp moduleexp = compilation.getModule();
        Language language = compilation.getLanguage();
        compilation = ((Compilation) (evalModule1(environment, compilation, url, outport)));
        if (compilation == null)
        {
            return false;
        } else
        {
            evalModule2(environment, callcontext, language, moduleexp, compilation);
            return true;
        }
    }

    public static final Object evalModule1(Environment environment, Compilation compilation, URL url, OutPort outport)
        throws SyntaxException
    {
        URL url1;
        Thread thread;
        Object obj;
        Object obj1;
        Compilation compilation1;
        Environment environment1;
        ModuleExp moduleexp;
        SourceMessages sourcemessages;
        moduleexp = compilation.getModule();
        moduleexp.info = compilation.minfo;
        environment1 = Environment.setSaveCurrent(environment);
        compilation1 = Compilation.setSaveCurrent(compilation);
        sourcemessages = compilation.getMessages();
        obj1 = null;
        obj = null;
        thread = null;
        if (alwaysCompile && neverCompile)
        {
            throw new RuntimeException("alwaysCompile and neverCompile are both true!");
        }
        if (neverCompile)
        {
            compilation.mustCompile = false;
        }
        url1 = obj1;
        environment = thread;
        compilation.process(6);
        url1 = obj1;
        environment = thread;
        compilation.minfo.loadByStages(8);
        if (outport == null) goto _L2; else goto _L1
_L1:
        url1 = obj1;
        environment = thread;
        boolean flag = sourcemessages.checkErrors(outport, 20);
        if (!flag) goto _L4; else goto _L3
_L3:
        Environment.restoreCurrent(environment1);
        Compilation.restoreCurrent(compilation1);
        if (false)
        {
            throw new NullPointerException();
        }
        environment = null;
_L5:
        return environment;
_L2:
        url1 = obj1;
        environment = thread;
        if (sourcemessages.seenErrors()) goto _L3; else goto _L4
_L4:
        url1 = obj1;
        environment = thread;
        if (compilation.mustCompile)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        url1 = obj1;
        environment = thread;
        if (!Compilation.debugPrintFinalExpr || outport == null)
        {
            break MISSING_BLOCK_LABEL_278;
        }
        url1 = obj1;
        environment = thread;
        outport.println((new StringBuilder()).append("[Evaluating final module \"").append(moduleexp.getName()).append("\":").toString());
        url1 = obj1;
        environment = thread;
        moduleexp.print(outport);
        url1 = obj1;
        environment = thread;
        outport.println(']');
        url1 = obj1;
        environment = thread;
        outport.flush();
        url1 = obj1;
        environment = thread;
        compilation = Boolean.TRUE;
        Environment.restoreCurrent(environment1);
        Compilation.restoreCurrent(compilation1);
        environment = compilation;
        if (false)
        {
            throw new NullPointerException();
        }
          goto _L5
        url1 = obj1;
        environment = thread;
        Class class1 = evalToClass(compilation, url);
        if (class1 == null)
        {
            Environment.restoreCurrent(environment1);
            Compilation.restoreCurrent(compilation1);
            if (false)
            {
                throw new NullPointerException();
            } else
            {
                return null;
            }
        }
        compilation = obj;
        url1 = obj1;
        environment = thread;
        thread = Thread.currentThread();
        compilation = obj;
        url1 = obj1;
        environment = thread;
        url = thread.getContextClassLoader();
        compilation = url;
        url1 = url;
        environment = thread;
        thread.setContextClassLoader(class1.getClassLoader());
        compilation = thread;
_L10:
        url1 = url;
        environment = compilation;
        moduleexp.body = null;
        url1 = url;
        environment = compilation;
        moduleexp.thisVariable = null;
        if (outport == null) goto _L7; else goto _L6
_L6:
        url1 = url;
        environment = compilation;
        if (!sourcemessages.checkErrors(outport, 20)) goto _L9; else goto _L8
_L8:
        outport = Boolean.valueOf(false);
        Environment.restoreCurrent(environment1);
        Compilation.restoreCurrent(compilation1);
        environment = outport;
        if (compilation != null)
        {
            compilation.setContextClassLoader(url);
            return outport;
        }
          goto _L5
        environment;
        environment = null;
        url = compilation;
        compilation = environment;
          goto _L10
_L7:
        url1 = url;
        environment = compilation;
        flag = sourcemessages.seenErrors();
        if (flag) goto _L8; else goto _L9
_L9:
        Environment.restoreCurrent(environment1);
        Compilation.restoreCurrent(compilation1);
        environment = class1;
        if (compilation == null) goto _L5; else goto _L11
_L11:
        compilation.setContextClassLoader(url);
        return class1;
        compilation;
        Environment.restoreCurrent(environment1);
        Compilation.restoreCurrent(compilation1);
        if (environment != null)
        {
            environment.setContextClassLoader(url1);
        }
        throw compilation;
    }

    public static final void evalModule2(Environment environment, CallContext callcontext, Language language, ModuleExp moduleexp, Object obj)
        throws Throwable
    {
        Environment environment1 = Environment.setSaveCurrent(environment);
        if (obj != Boolean.TRUE) goto _L2; else goto _L1
_L1:
        moduleexp.body.apply(callcontext);
_L3:
        callcontext.runUntilDone();
        Environment.restoreCurrent(environment1);
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            return;
        }
_L2:
        Object obj1 = obj;
        if (obj instanceof Class)
        {
            obj1 = ModuleContext.getContext().findInstance((Class)obj);
        }
        if (obj1 instanceof Runnable)
        {
            if (!(obj1 instanceof ModuleBody))
            {
                break MISSING_BLOCK_LABEL_146;
            }
            obj = (ModuleBody)obj1;
            if (!((ModuleBody) (obj)).runDone)
            {
                obj.runDone = true;
                ((ModuleBody) (obj)).run(callcontext);
            }
        }
_L4:
        if (moduleexp != null)
        {
            break MISSING_BLOCK_LABEL_159;
        }
        ClassMemberLocation.defineAll(obj1, language, environment);
          goto _L3
        environment;
        Environment.restoreCurrent(environment1);
        if (false)
        {
            throw new NullPointerException();
        } else
        {
            throw environment;
        }
        ((Runnable)obj1).run();
          goto _L4
        moduleexp = moduleexp.firstDecl();
_L8:
        if (moduleexp == null) goto _L3; else goto _L5
_L5:
        obj = moduleexp.getSymbol();
        if (!moduleexp.isPrivate() && obj != null) goto _L7; else goto _L6
_L6:
        moduleexp = moduleexp.nextDecl();
          goto _L8
_L7:
        obj1 = ((Declaration) (moduleexp)).field;
        if (!(obj instanceof Symbol)) goto _L10; else goto _L9
_L9:
        obj = (Symbol)obj;
_L13:
        Object obj3;
        Expression expression;
        obj3 = language.getEnvPropertyFor(moduleexp);
        expression = moduleexp.getValue();
        if ((((Declaration) (moduleexp)).field.getModifiers() & 0x10) == 0)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        if (!(expression instanceof QuoteExp) || expression == QuoteExp.undefined_exp) goto _L12; else goto _L11
_L11:
        obj1 = ((QuoteExp)expression).getValue();
_L14:
        if (!moduleexp.isIndirectBinding())
        {
            break MISSING_BLOCK_LABEL_377;
        }
        environment.addLocation(((Symbol) (obj)), obj3, (Location)obj1);
          goto _L6
_L10:
        obj = Symbol.make("", obj.toString().intern());
          goto _L13
_L12:
        Object obj2;
        obj2 = ((Declaration) (moduleexp)).field.getReflectField().get(null);
        if (moduleexp.isIndirectBinding())
        {
            break MISSING_BLOCK_LABEL_346;
        }
        moduleexp.setValue(QuoteExp.getInstance(obj2));
        obj1 = obj2;
          goto _L14
        if (!moduleexp.isAlias()) goto _L16; else goto _L15
_L15:
        obj1 = obj2;
        if (expression instanceof ReferenceExp) goto _L14; else goto _L16
_L16:
        moduleexp.setValue(null);
        obj1 = obj2;
          goto _L14
        environment.define(((Symbol) (obj)), obj3, obj1);
          goto _L6
        obj1 = new StaticFieldLocation(((Field) (obj1)).getDeclaringClass(), ((Field) (obj1)).getName());
        ((StaticFieldLocation) (obj1)).setDeclaration(moduleexp);
        environment.addLocation(((Symbol) (obj)), obj3, ((Location) (obj1)));
        moduleexp.setValue(null);
          goto _L6
    }

    public static Class evalToClass(Compilation compilation, URL url)
        throws SyntaxException
    {
        SourceMessages sourcemessages;
        compilation.getModule();
        sourcemessages = compilation.getMessages();
        compilation.minfo.loadByStages(12);
        Object obj;
        Object obj1;
        Object obj2;
        int i;
        if (sourcemessages.seenErrors())
        {
            return null;
        }
        byte abyte0[];
        Object obj3;
        int j;
        try
        {
            obj2 = compilation.loader;
        }
        // Misplaced declaration of an exception variable
        catch (Compilation compilation)
        {
            throw new WrappedException("I/O error in lambda eval", compilation);
        }
        // Misplaced declaration of an exception variable
        catch (Compilation compilation)
        {
            throw new WrappedException("class not found in lambda eval", compilation);
        }
        // Misplaced declaration of an exception variable
        catch (URL url)
        {
            compilation.getMessages().error('f', (new StringBuilder()).append("internal compile error - caught ").append(url).toString(), url);
            throw new SyntaxException(sourcemessages);
        }
        obj = url;
        if (url != null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        obj = Path.currentPath().toURL();
        ((ArrayClassLoader) (obj2)).setResourceContext(((URL) (obj)));
        url = null;
        if (dumpZipPrefix != null)
        {
            url = new StringBuffer(dumpZipPrefix);
            lastZipCounter++;
            if (interactiveCounter > lastZipCounter)
            {
                lastZipCounter = interactiveCounter;
            }
            url.append(lastZipCounter);
            url.append(".zip");
            url = new ZipOutputStream(new FileOutputStream(url.toString()));
        }
          goto _L1
_L11:
        if (i >= compilation.numClasses) goto _L3; else goto _L2
_L2:
        obj = compilation.classes[i];
        obj1 = ((ClassType) (obj)).getName();
        abyte0 = ((ClassType) (obj)).writeToArray();
        ((ArrayClassLoader) (obj2)).addClass(((String) (obj1)), abyte0);
        if (url == null) goto _L5; else goto _L4
_L4:
        obj1 = new ZipEntry((new StringBuilder()).append(((String) (obj1)).replace('.', '/')).append(".class").toString());
        ((ZipEntry) (obj1)).setSize(abyte0.length);
        obj3 = new CRC32();
        ((CRC32) (obj3)).update(abyte0);
        ((ZipEntry) (obj1)).setCrc(((CRC32) (obj3)).getValue());
        ((ZipEntry) (obj1)).setMethod(0);
        url.putNextEntry(((ZipEntry) (obj1)));
        url.write(abyte0);
          goto _L5
_L3:
        if (url == null) goto _L7; else goto _L6
_L6:
        url.close();
          goto _L7
_L12:
        for (; abyte0.getParent() instanceof ArrayClassLoader; abyte0 = (ArrayClassLoader)abyte0.getParent()) { }
          goto _L8
_L13:
        if (i >= compilation.numClasses)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        obj1 = compilation.classes[i];
        obj3 = ((ArrayClassLoader) (obj2)).loadClass(((ClassType) (obj1)).getName());
        ((ClassType) (obj1)).setReflectClass(((Class) (obj3)));
        ((ClassType) (obj1)).setExisting(true);
        if (i == 0)
        {
            obj1 = obj3;
            break MISSING_BLOCK_LABEL_538;
        }
        obj1 = url;
        if (abyte0 == obj2)
        {
            break MISSING_BLOCK_LABEL_538;
        }
        abyte0.addClass(((Class) (obj3)));
        obj1 = url;
        break MISSING_BLOCK_LABEL_538;
        obj2 = compilation.minfo;
        ((ModuleInfo) (obj2)).setModuleClass(url);
        compilation.cleanupAfterCompilation();
        j = ((ModuleInfo) (obj2)).numDependencies;
        i = 0;
_L10:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = ((ModuleInfo) (obj2)).dependencies[i];
        obj1 = ((ModuleInfo) (obj3)).getModuleClassRaw();
        abyte0 = ((byte []) (obj1));
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_436;
        }
        abyte0 = evalToClass(((ModuleInfo) (obj3)).comp, null);
        compilation.loader.addClass(abyte0);
        i++;
        if (true) goto _L10; else goto _L9
_L9:
        return url;
_L1:
        i = 0;
          goto _L11
_L5:
        i++;
          goto _L11
_L7:
        url = null;
        abyte0 = ((byte []) (obj2));
          goto _L12
_L8:
        i = 0;
          goto _L13
        i++;
        url = ((URL) (obj1));
          goto _L13
    }

    public static void mustAlwaysCompile()
    {
        alwaysCompile = true;
        neverCompile = false;
    }

    public static void mustNeverCompile()
    {
        alwaysCompile = false;
        neverCompile = true;
        compilerAvailable = false;
    }

    public void allocChildClasses(Compilation compilation)
    {
        declareClosureEnv();
        if (!compilation.usingCPStyle())
        {
            return;
        } else
        {
            allocFrame(compilation);
            return;
        }
    }

    void allocFields(Compilation compilation)
    {
        Declaration declaration = firstDecl();
        do
        {
            if (declaration == null)
            {
                break;
            }
            if ((!declaration.isSimple() || declaration.isPublic()) && declaration.field == null && declaration.getFlag(0x10000L) && declaration.getFlag(6L))
            {
                declaration.makeField(compilation, null);
            }
            declaration = declaration.nextDecl();
        } while (true);
        declaration = firstDecl();
        while (declaration != null) 
        {
            if (declaration.field == null)
            {
                Expression expression1 = declaration.getValue();
                if ((!declaration.isSimple() || declaration.isPublic() || declaration.isNamespaceDecl() || declaration.getFlag(16384L) && declaration.getFlag(6L)) && !declaration.getFlag(0x10000L))
                {
                    if ((expression1 instanceof LambdaExp) && !(expression1 instanceof ModuleExp) && !(expression1 instanceof ClassExp))
                    {
                        ((LambdaExp)expression1).allocFieldFor(compilation);
                    } else
                    {
                        Expression expression = expression1;
                        if (!declaration.shouldEarlyInit())
                        {
                            if (declaration.isAlias())
                            {
                                expression = expression1;
                            } else
                            {
                                expression = null;
                            }
                        }
                        declaration.makeField(compilation, expression);
                    }
                }
            }
            declaration = declaration.nextDecl();
        }
    }

    public ClassType classFor(Compilation compilation)
    {
        if (type == null || type == Compilation.typeProcedure) goto _L2; else goto _L1
_L1:
        Object obj1 = type;
_L10:
        return ((ClassType) (obj1));
_L2:
        Object obj;
        Object obj2;
        obj1 = getFileName();
        obj = getName();
        obj2 = null;
        if (obj != null)
        {
            obj1 = obj2;
        } else
        if (obj1 == null)
        {
            String s = getName();
            obj = s;
            obj1 = obj2;
            if (s == null)
            {
                obj = "$unnamed_input_file$";
                obj1 = obj2;
            }
        } else
        if (filename.equals("-") || filename.equals("/dev/stdin"))
        {
            String s1 = getName();
            obj = s1;
            obj1 = obj2;
            if (s1 == null)
            {
                obj = "$stdin$";
                obj1 = obj2;
            }
        } else
        {
            obj2 = Path.valueOf(obj1);
            String s2 = ((Path) (obj2)).getLast();
            int i = s2.lastIndexOf('.');
            obj = s2;
            obj1 = obj2;
            if (i > 0)
            {
                obj = s2.substring(0, i);
                obj1 = obj2;
            }
        }
        if (getName() == null)
        {
            setName(((String) (obj)));
        }
        obj2 = Compilation.mangleNameIfNeeded(((String) (obj)));
        if (compilation.classPrefix.length() != 0 || obj1 == null || ((Path) (obj1)).isAbsolute()) goto _L4; else goto _L3
_L3:
        obj = ((Path) (obj1)).getParent();
        if (obj == null) goto _L4; else goto _L5
_L5:
        obj = obj.toString();
        if (((String) (obj)).length() <= 0 || ((String) (obj)).indexOf("..") >= 0) goto _L4; else goto _L6
_L6:
        obj1 = ((String) (obj)).replaceAll(System.getProperty("file.separator"), "/");
        obj = obj1;
        if (((String) (obj1)).startsWith("./"))
        {
            obj = ((String) (obj1)).substring(2);
        }
        if (((String) (obj)).equals("."))
        {
            obj = obj2;
        } else
        {
            obj = (new StringBuilder()).append(Compilation.mangleURI(((String) (obj)))).append(".").append(((String) (obj2))).toString();
        }
_L8:
        obj2 = new ClassType(((String) (obj)));
        setType(((ClassType) (obj2)));
        obj1 = obj2;
        if (compilation.mainLambda != this)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (compilation.mainClass == null)
        {
            compilation.mainClass = ((ClassType) (obj2));
            return ((ClassType) (obj2));
        }
        break; /* Loop/switch isn't completed */
_L4:
        obj = (new StringBuilder()).append(compilation.classPrefix).append(((String) (obj2))).toString();
        if (true) goto _L8; else goto _L7
_L7:
        obj1 = obj2;
        if (!((String) (obj)).equals(compilation.mainClass.getName()))
        {
            compilation.error('e', (new StringBuilder()).append("inconsistent main class name: ").append(((String) (obj))).append(" - old name: ").append(compilation.mainClass.getName()).toString());
            return ((ClassType) (obj2));
        }
        if (true) goto _L10; else goto _L9
_L9:
    }

    public Declaration firstDecl()
    {
        this;
        JVM INSTR monitorenter ;
        if (getFlag(0x80000))
        {
            info.setupModuleExp();
        }
        this;
        JVM INSTR monitorexit ;
        return decls;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final ClassType[] getInterfaces()
    {
        return interfaces;
    }

    public String getNamespaceUri()
    {
        return info.uri;
    }

    public final ClassType getSuperType()
    {
        return superType;
    }

    public final boolean isStatic()
    {
        return getFlag(32768) || (Compilation.moduleStatic >= 0 || getFlag(0x100000)) && !getFlag(0x20000) && !getFlag(0x10000);
    }

    public void print(OutPort outport)
    {
        outport.startLogicalBlock("(Module/", ")", 2);
        Object obj = getSymbol();
        if (obj != null)
        {
            outport.print(obj);
            outport.print('/');
        }
        outport.print(id);
        outport.print('/');
        outport.writeSpaceFill();
        outport.startLogicalBlock("(", false, ")");
        obj = firstDecl();
        if (obj != null)
        {
            outport.print("Declarations:");
            for (; obj != null; obj = ((Declaration) (obj)).nextDecl())
            {
                outport.writeSpaceFill();
                ((Declaration) (obj)).printInfo(outport);
            }

        }
        outport.endLogicalBlock(")");
        outport.writeSpaceLinear();
        if (body == null)
        {
            outport.print("<null body>");
        } else
        {
            body.print(outport);
        }
        outport.endLogicalBlock(")");
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        objectinput = ((ObjectInput) (objectinput.readObject()));
        if (objectinput instanceof ClassType)
        {
            type = (ClassType)objectinput;
            setName(type.getName());
        } else
        {
            setName((String)objectinput);
        }
        flags = flags | 0x80000;
    }

    public final void setInterfaces(ClassType aclasstype[])
    {
        interfaces = aclasstype;
    }

    public final void setSuperType(ClassType classtype)
    {
        superType = classtype;
    }

    public boolean staticInitRun()
    {
        return isStatic() && (getFlag(0x40000) || Compilation.moduleStatic == 2);
    }

    protected Object visit(ExpVisitor expvisitor, Object obj)
    {
        return expvisitor.visitModuleExp(this, obj);
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        String s = null;
        if (type != null && type != Compilation.typeProcedure && !type.isExisting())
        {
            objectoutput.writeObject(type);
            return;
        }
        if (true)
        {
            s = getName();
        }
        String s1 = s;
        if (s == null)
        {
            s1 = getFileName();
        }
        objectoutput.writeObject(s1);
    }

    static 
    {
        compilerAvailable = true;
        alwaysCompile = compilerAvailable;
    }
}
