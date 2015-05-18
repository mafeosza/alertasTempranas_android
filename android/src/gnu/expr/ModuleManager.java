// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import gnu.text.URLPath;
import java.io.File;
import java.net.URL;

// Referenced classes of package gnu.expr:
//            ModuleInfo, ModuleSet, Compilation, ModuleExp

public class ModuleManager
{

    public static final long LAST_MODIFIED_CACHE_TIME = 1000L;
    static ModuleManager instance = new ModuleManager();
    private String compilationDirectory;
    public long lastModifiedCacheTime;
    ModuleInfo modules[];
    int numModules;
    ModuleSet packageInfoChain;

    public ModuleManager()
    {
        compilationDirectory = "";
        lastModifiedCacheTime = 1000L;
    }

    private void add(ModuleInfo moduleinfo)
    {
        this;
        JVM INSTR monitorenter ;
        if (modules != null) goto _L2; else goto _L1
_L1:
        modules = new ModuleInfo[10];
_L4:
        ModuleInfo amoduleinfo[];
        int i;
        amoduleinfo = modules;
        i = numModules;
        numModules = i + 1;
        amoduleinfo[i] = moduleinfo;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (numModules != modules.length) goto _L4; else goto _L3
_L3:
        ModuleInfo amoduleinfo1[] = new ModuleInfo[numModules * 2];
        System.arraycopy(modules, 0, amoduleinfo1, 0, numModules);
        modules = amoduleinfo1;
          goto _L4
        moduleinfo;
        throw moduleinfo;
    }

    public static ModuleInfo findWithClass(Class class1)
    {
        gnu/expr/ModuleManager;
        JVM INSTR monitorenter ;
        ModuleInfo moduleinfo1 = (ModuleInfo)ModuleInfo.mapClassToInfo.get(class1);
        ModuleInfo moduleinfo;
        moduleinfo = moduleinfo1;
        if (moduleinfo1 != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        moduleinfo = new ModuleInfo();
        moduleinfo.setModuleClass(class1);
        gnu/expr/ModuleManager;
        JVM INSTR monitorexit ;
        return moduleinfo;
        class1;
        throw class1;
    }

    public static ModuleManager getInstance()
    {
        return instance;
    }

    private ModuleInfo searchWithAbsSourcePath(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = numModules;
_L4:
        i--;
        if (i < 0) goto _L2; else goto _L1
_L1:
        ModuleInfo moduleinfo;
        boolean flag;
        moduleinfo = modules[i];
        flag = s.equals(moduleinfo.getSourceAbsPathname());
        if (!flag) goto _L4; else goto _L3
_L3:
        s = moduleinfo;
_L6:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        ModuleSet moduleset = packageInfoChain;
_L2:
        if (moduleset == null)
        {
            break; /* Loop/switch isn't completed */
        }
        ModuleSet moduleset1;
        moduleset1 = moduleset.next;
        moduleset.next = null;
        moduleset = moduleset1;
        if (true) goto _L2; else goto _L1
_L1:
        packageInfoChain = null;
        modules = null;
        numModules = 0;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public ModuleInfo find(Compilation compilation)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        ModuleExp moduleexp = compilation.getModule();
        ClassType classtype = moduleexp.classFor(compilation);
        obj = moduleexp.getFileName();
        obj = findWithSourcePath(ModuleInfo.absPath(((String) (obj))), ((String) (obj)));
        ((ModuleInfo) (obj)).setClassName(classtype.getName());
        obj.exp = moduleexp;
        compilation.minfo = ((ModuleInfo) (obj));
        obj.comp = compilation;
        this;
        JVM INSTR monitorexit ;
        return ((ModuleInfo) (obj));
        compilation;
        throw compilation;
    }

    public ModuleInfo findWithClassName(String s)
    {
        ModuleInfo moduleinfo = searchWithClassName(s);
        if (moduleinfo != null)
        {
            return moduleinfo;
        }
        try
        {
            s = findWithClass(ClassType.getContextClass(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw WrappedException.wrapIfNeeded(s);
        }
        return s;
    }

    public ModuleInfo findWithSourcePath(Path path, String s)
    {
        this;
        JVM INSTR monitorenter ;
        ModuleInfo moduleinfo1;
        String s1;
        s1 = path.toString();
        moduleinfo1 = searchWithAbsSourcePath(s1);
        ModuleInfo moduleinfo;
        moduleinfo = moduleinfo1;
        if (moduleinfo1 != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        moduleinfo = new ModuleInfo();
        moduleinfo.sourcePath = s;
        moduleinfo.sourceAbsPath = path;
        moduleinfo.sourceAbsPathname = s1;
        add(moduleinfo);
        this;
        JVM INSTR monitorexit ;
        return moduleinfo;
        path;
        throw path;
    }

    public ModuleInfo findWithSourcePath(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = findWithSourcePath(ModuleInfo.absPath(s), s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public ModuleInfo findWithURL(URL url)
    {
        this;
        JVM INSTR monitorenter ;
        url = findWithSourcePath(URLPath.valueOf(url), url.toExternalForm());
        this;
        JVM INSTR monitorexit ;
        return url;
        url;
        throw url;
    }

    public String getCompilationDirectory()
    {
        return compilationDirectory;
    }

    public ModuleInfo getModule(int i)
    {
        this;
        JVM INSTR monitorenter ;
        int j = numModules;
        if (i < j) goto _L2; else goto _L1
_L1:
        ModuleInfo moduleinfo = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return moduleinfo;
_L2:
        moduleinfo = modules[i];
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void loadPackageInfo(String s)
        throws ClassNotFoundException, InstantiationException, IllegalAccessException
    {
        this;
        JVM INSTR monitorenter ;
        String s1;
        s1 = (new StringBuilder()).append(s).append(".").append("$ModulesMap$").toString();
        s = packageInfoChain;
_L1:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (!s.getClass().getName().equals(s1));
        s = ((ModuleSet) (s)).next;
          goto _L1
        s = (ModuleSet)Class.forName(s1).newInstance();
        s.next = packageInfoChain;
        packageInfoChain = s;
        s.register(this);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void register(String s, String s1, String s2)
    {
        this;
        JVM INSTR monitorenter ;
        ModuleInfo moduleinfo = searchWithClassName(s);
        if (moduleinfo == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Path path;
        String s3;
        path = Path.valueOf(s1);
        s3 = path.getCanonical().toString();
        if (searchWithAbsSourcePath(s3) != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        moduleinfo = new ModuleInfo();
        if (!path.isAbsolute()) goto _L4; else goto _L3
_L3:
        moduleinfo.sourceAbsPath = path;
        moduleinfo.sourceAbsPathname = s3;
_L6:
        moduleinfo.setClassName(s);
        moduleinfo.sourcePath = s1;
        moduleinfo.uri = s2;
        add(moduleinfo);
        continue; /* Loop/switch isn't completed */
        s;
        throw s;
_L4:
        Object obj = packageInfoChain.getClass();
        String s4 = (new StringBuilder()).append(((Class) (obj)).getName().replace('.', '/')).append(".class").toString();
        obj = URLPath.valueOf(((Class) (obj)).getClassLoader().getResource(s4)).resolve(s1);
        moduleinfo.sourceAbsPath = ((Path) (obj));
        moduleinfo.sourceAbsPathname = obj.toString();
        if (true) goto _L6; else goto _L5
_L5:
        s;
        if (true) goto _L1; else goto _L7
_L7:
    }

    public ModuleInfo searchWithClassName(String s)
    {
        this;
        JVM INSTR monitorenter ;
        int i = numModules;
_L4:
        i--;
        if (i < 0) goto _L2; else goto _L1
_L1:
        ModuleInfo moduleinfo;
        boolean flag;
        moduleinfo = modules[i];
        flag = s.equals(moduleinfo.getClassName());
        if (!flag) goto _L4; else goto _L3
_L3:
        s = moduleinfo;
_L6:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = null;
        if (true) goto _L6; else goto _L5
_L5:
        s;
        throw s;
    }

    public void setCompilationDirectory(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        int i = s1.length();
        s = s1;
        if (i > 0)
        {
            char c = File.separatorChar;
            s = s1;
            if (s1.charAt(i - 1) != c)
            {
                s = (new StringBuilder()).append(s1).append(c).toString();
            }
        }
        compilationDirectory = s;
    }

}
