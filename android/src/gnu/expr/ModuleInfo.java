// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.ClassType;
import gnu.bytecode.Field;
import gnu.bytecode.Type;
import gnu.kawa.reflect.FieldLocation;
import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.Location;
import gnu.mapping.WrappedException;
import gnu.text.Path;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

// Referenced classes of package gnu.expr:
//            ModuleManager, ModuleContext, Declaration, ReferenceExp, 
//            ModuleExp, Compilation, Language, QuoteExp

public class ModuleInfo
{
    static class ClassToInfoMap extends AbstractWeakHashTable
    {

        protected Class getKeyFromValue(ModuleInfo moduleinfo)
        {
            return moduleinfo.moduleClass;
        }

        protected volatile Object getKeyFromValue(Object obj)
        {
            return getKeyFromValue((ModuleInfo)obj);
        }

        protected boolean matches(Class class1, Class class2)
        {
            return class1 == class2;
        }

        ClassToInfoMap()
        {
        }
    }


    static ClassToInfoMap mapClassToInfo = new ClassToInfoMap();
    private String className;
    Compilation comp;
    ModuleInfo dependencies[];
    ModuleExp exp;
    public long lastCheckedTime;
    public long lastModifiedTime;
    Class moduleClass;
    int numDependencies;
    Path sourceAbsPath;
    String sourceAbsPathname;
    public String sourcePath;
    String uri;

    public ModuleInfo()
    {
    }

    public static Path absPath(String s)
    {
        return Path.valueOf(s).getCanonical();
    }

    public static ModuleInfo find(ClassType classtype)
    {
        if (!classtype.isExisting())
        {
            break MISSING_BLOCK_LABEL_18;
        }
        ModuleInfo moduleinfo = ModuleManager.findWithClass(classtype.getReflectClass());
        return moduleinfo;
        Exception exception;
        exception;
        return ModuleManager.getInstance().findWithClassName(classtype.getName());
    }

    public static ModuleInfo findFromInstance(Object obj)
    {
        return ModuleContext.getContext().findFromInstance(obj);
    }

    static void makeDeclInModule2(ModuleExp moduleexp, Declaration declaration)
    {
        Object obj = declaration.getConstantValue();
        if (!(obj instanceof FieldLocation)) goto _L2; else goto _L1
_L1:
        FieldLocation fieldlocation;
        fieldlocation = (FieldLocation)obj;
        Declaration declaration1 = fieldlocation.getDeclaration();
        obj = new ReferenceExp(declaration1);
        declaration.setAlias(true);
        ((ReferenceExp) (obj)).setDontDereference(true);
        declaration.setValue(((Expression) (obj)));
        if (declaration1.isProcedureDecl())
        {
            declaration.setProcedureDecl(true);
        }
        if (declaration1.getFlag(32768L))
        {
            declaration.setSyntax();
        }
        if (declaration.getFlag(2048L)) goto _L2; else goto _L3
_L3:
        declaration = fieldlocation.getDeclaringClass().getName();
        moduleexp = moduleexp.firstDecl();
_L8:
        if (moduleexp == null) goto _L2; else goto _L4
_L4:
        if (!declaration.equals(moduleexp.getType().getName()) || !moduleexp.getFlag(0x40000000L)) goto _L6; else goto _L5
_L5:
        ((ReferenceExp) (obj)).setContextDecl(moduleexp);
_L2:
        return;
_L6:
        moduleexp = moduleexp.nextDecl();
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static void register(Object obj)
    {
        ModuleContext.getContext().setInstance(obj);
    }

    public void addDependency(ModuleInfo moduleinfo)
    {
        this;
        JVM INSTR monitorenter ;
        if (dependencies != null) goto _L2; else goto _L1
_L1:
        dependencies = new ModuleInfo[8];
_L4:
        ModuleInfo amoduleinfo[];
        int i;
        amoduleinfo = dependencies;
        i = numDependencies;
        numDependencies = i + 1;
        amoduleinfo[i] = moduleinfo;
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (numDependencies != dependencies.length) goto _L4; else goto _L3
_L3:
        ModuleInfo amoduleinfo1[] = new ModuleInfo[numDependencies * 2];
        System.arraycopy(dependencies, 0, amoduleinfo1, 0, numDependencies);
        dependencies = amoduleinfo1;
          goto _L4
        moduleinfo;
        throw moduleinfo;
    }

    public boolean checkCurrent(ModuleManager modulemanager, long l)
    {
        Object obj;
        long l1;
        long l2;
        long l3;
        if (sourceAbsPath == null)
        {
            return true;
        }
        if (lastCheckedTime + modulemanager.lastModifiedCacheTime >= l)
        {
            return moduleClass != null;
        }
        l3 = sourceAbsPath.getLastModified();
        l2 = lastModifiedTime;
        lastModifiedTime = l3;
        lastCheckedTime = l;
        if (className == null)
        {
            return false;
        }
        Object obj1;
        int i;
        if (moduleClass == null)
        {
            try
            {
                moduleClass = ClassType.getContextClass(className);
            }
            // Misplaced declaration of an exception variable
            catch (ModuleManager modulemanager)
            {
                return false;
            }
        }
        l1 = l2;
        if (l2 != 0L) goto _L2; else goto _L1
_L1:
        l1 = l2;
        if (moduleClass == null) goto _L2; else goto _L3
_L3:
        obj1 = className;
        i = ((String) (obj1)).lastIndexOf('.');
        obj = obj1;
        if (i >= 0)
        {
            obj = ((String) (obj1)).substring(i + 1);
        }
        obj = (new StringBuilder()).append(((String) (obj))).append(".class").toString();
        obj1 = moduleClass.getResource(((String) (obj)));
        l1 = l2;
        obj = obj1;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_204;
        }
        l1 = ((URL) (obj1)).openConnection().getLastModified();
        obj = obj1;
_L4:
        if (obj == null)
        {
            return true;
        }
        break; /* Loop/switch isn't completed */
        IOException ioexception;
        ioexception;
        ioexception = null;
        l1 = l2;
        if (true) goto _L4; else goto _L2
_L2:
        if (l3 > l1)
        {
            moduleClass = null;
            return false;
        }
        int j = numDependencies;
        do
        {
            int k = j - 1;
            if (k >= 0)
            {
                ModuleInfo moduleinfo = dependencies[k];
                j = k;
                if (moduleinfo.comp == null)
                {
                    j = k;
                    if (!moduleinfo.checkCurrent(modulemanager, l))
                    {
                        moduleClass = null;
                        return false;
                    }
                }
            } else
            {
                return true;
            }
        } while (true);
    }

    public void cleanupAfterCompilation()
    {
        if (comp != null)
        {
            comp.cleanupAfterCompilation();
        }
    }

    public void clearClass()
    {
        moduleClass = null;
        numDependencies = 0;
        dependencies = null;
    }

    public String getClassName()
    {
        this;
        JVM INSTR monitorenter ;
        if (className != null) goto _L2; else goto _L1
_L1:
        if (moduleClass == null) goto _L4; else goto _L3
_L3:
        className = moduleClass.getName();
_L2:
        String s = className;
        this;
        JVM INSTR monitorexit ;
        return s;
_L4:
        if (comp == null || comp.mainClass == null) goto _L2; else goto _L5
_L5:
        className = comp.mainClass.getName();
          goto _L2
        Exception exception;
        exception;
        throw exception;
    }

    public ClassType getClassType()
    {
        this;
        JVM INSTR monitorenter ;
        if (moduleClass == null) goto _L2; else goto _L1
_L1:
        ClassType classtype = (ClassType)Type.make(moduleClass);
_L4:
        this;
        JVM INSTR monitorexit ;
        return classtype;
_L2:
        if (comp != null && comp.mainClass != null)
        {
            classtype = comp.mainClass;
            continue; /* Loop/switch isn't completed */
        }
        classtype = ClassType.make(className);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Compilation getCompilation()
    {
        return comp;
    }

    public Object getInstance()
    {
        return ModuleContext.getContext().findInstance(this);
    }

    public Class getModuleClass()
        throws ClassNotFoundException
    {
        this;
        JVM INSTR monitorenter ;
        Class class1 = moduleClass;
        if (class1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return class1;
_L2:
        class1 = ClassType.getContextClass(className);
        moduleClass = class1;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public Class getModuleClassRaw()
    {
        return moduleClass;
    }

    public ModuleExp getModuleExp()
    {
        this;
        JVM INSTR monitorenter ;
        ModuleExp moduleexp1 = exp;
        ModuleExp moduleexp = moduleexp1;
        if (moduleexp1 != null) goto _L2; else goto _L1
_L1:
        if (comp == null) goto _L4; else goto _L3
_L3:
        moduleexp = comp.mainLambda;
_L2:
        this;
        JVM INSTR monitorexit ;
        return moduleexp;
_L4:
        ClassType classtype = ClassType.make(className);
        moduleexp = new ModuleExp();
        moduleexp.type = classtype;
        moduleexp.setName(classtype.getName());
        moduleexp.flags = moduleexp.flags | 0x80000;
        moduleexp.info = this;
        exp = moduleexp;
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public String getNamespaceUri()
    {
        return uri;
    }

    public Object getRunInstance()
    {
        Object obj = getInstance();
        if (obj instanceof Runnable)
        {
            ((Runnable)obj).run();
        }
        return obj;
    }

    public Path getSourceAbsPath()
    {
        return sourceAbsPath;
    }

    public String getSourceAbsPathname()
    {
        String s1 = sourceAbsPathname;
        String s = s1;
        if (s1 == null)
        {
            s = s1;
            if (sourceAbsPath != null)
            {
                s = sourceAbsPath.toString();
                sourceAbsPathname = s;
            }
        }
        return s;
    }

    public int getState()
    {
        if (comp == null)
        {
            return 14;
        } else
        {
            return comp.getState();
        }
    }

    public void loadByStages(int i)
    {
        if (getState() + 1 < i)
        {
            loadByStages(i - 2);
            int j = getState();
            if (j < i)
            {
                comp.setState(j + 1);
                int k = numDependencies;
                for (j = 0; j < k; j++)
                {
                    dependencies[j].loadByStages(i);
                }

                j = getState();
                if (j < i)
                {
                    comp.setState(j & -2);
                    comp.process(i);
                    return;
                }
            }
        }
    }

    public boolean loadEager(int i)
    {
        boolean flag = true;
        if (comp != null || className == null) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int k = getState();
        if (k >= i)
        {
            return true;
        }
        if ((k & 1) != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        comp.setState(k + 1);
        int l = numDependencies;
        int j = 0;
        do
        {
            if (j >= l)
            {
                break;
            }
            if (!dependencies[j].loadEager(i))
            {
                if (getState() == k + 1)
                {
                    comp.setState(k);
                    return false;
                }
                continue; /* Loop/switch isn't completed */
            }
            j++;
        } while (true);
        if (getState() == k + 1)
        {
            comp.setState(k);
        }
        comp.process(i);
        if (getState() != i)
        {
            flag = false;
        }
        return flag;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void setClassName(String s)
    {
        className = s;
    }

    public void setCompilation(Compilation compilation)
    {
        compilation.minfo = this;
        comp = compilation;
        compilation = compilation.mainLambda;
        exp = compilation;
        if (compilation != null)
        {
            compilation = compilation.getFileName();
            sourcePath = compilation;
            sourceAbsPath = absPath(compilation);
        }
    }

    public void setModuleClass(Class class1)
    {
        moduleClass = class1;
        className = class1.getName();
        mapClassToInfo.put(class1, this);
    }

    public void setNamespaceUri(String s)
    {
        uri = s;
    }

    public void setSourceAbsPath(Path path)
    {
        sourceAbsPath = path;
        sourceAbsPathname = null;
    }

    public ModuleExp setupModuleExp()
    {
        this;
        JVM INSTR monitorenter ;
        ModuleExp moduleexp;
        int i;
        moduleexp = getModuleExp();
        i = moduleexp.flags;
        if ((i & 0x80000) != 0) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return moduleexp;
_L2:
        moduleexp.setFlag(false, 0x80000);
        if (moduleClass == null) goto _L4; else goto _L3
_L3:
        Object obj;
        Class class1;
        class1 = moduleClass;
        obj = (ClassType)Type.make(class1);
_L8:
        Object obj2 = null;
        Field field;
        Language language;
        language = Language.getDefaultLanguage();
        field = ((ClassType) (obj)).getFields();
_L7:
        if (field == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        i = field.getFlags();
        if ((i & 1) != 0) goto _L6; else goto _L5
_L5:
        obj = obj2;
_L9:
        field = field.getNext();
        obj2 = obj;
          goto _L7
_L4:
        obj = ClassType.make(className);
        class1 = ((ClassType) (obj)).getReflectClass();
          goto _L8
_L6:
        obj = obj2;
        if ((i & 8) != 0)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = obj2;
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        obj = getInstance();
        Declaration declaration;
        obj2 = class1.getField(field.getName()).get(obj);
        declaration = language.declFromField(moduleexp, obj2, field);
        if ((i & 0x10) == 0)
        {
            break MISSING_BLOCK_LABEL_220;
        }
        if ((obj2 instanceof Location) && !(obj2 instanceof FieldLocation))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        declaration.noteValue(new QuoteExp(obj2));
          goto _L9
        Object obj1;
        obj1;
        throw new WrappedException(((Throwable) (obj1)));
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
        declaration.noteValue(null);
          goto _L9
        obj1 = moduleexp.firstDecl();
_L11:
        if (obj1 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        makeDeclInModule2(moduleexp, ((Declaration) (obj1)));
        obj1 = ((Declaration) (obj1)).nextDecl();
        if (true) goto _L11; else goto _L10
_L10:
        if (true) goto _L1; else goto _L12
_L12:
    }

    public String toString()
    {
        StringBuffer stringbuffer;
        stringbuffer = new StringBuffer();
        stringbuffer.append("ModuleInfo[");
        if (moduleClass == null) goto _L2; else goto _L1
_L1:
        stringbuffer.append("class: ");
        stringbuffer.append(moduleClass);
_L4:
        stringbuffer.append(']');
        return stringbuffer.toString();
_L2:
        if (className != null)
        {
            stringbuffer.append("class-name: ");
            stringbuffer.append(className);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

}
