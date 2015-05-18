// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.kawa.util.AbstractWeakHashTable;
import gnu.mapping.WrappedException;
import java.lang.reflect.Field;

// Referenced classes of package gnu.expr:
//            ModuleManager, ModuleInfo

public class ModuleContext
{
    static class ClassToInstanceMap extends AbstractWeakHashTable
    {

        protected Class getKeyFromValue(Object obj)
        {
            return obj.getClass();
        }

        protected volatile Object getKeyFromValue(Object obj)
        {
            return getKeyFromValue(obj);
        }

        protected boolean matches(Class class1, Class class2)
        {
            return class1 == class2;
        }

        ClassToInstanceMap()
        {
        }
    }


    public static int IN_HTTP_SERVER = 1;
    public static int IN_SERVLET = 2;
    static ModuleContext global;
    int flags;
    ModuleManager manager;
    private ClassToInstanceMap table;

    public ModuleContext(ModuleManager modulemanager)
    {
        table = new ClassToInstanceMap();
        manager = modulemanager;
    }

    public static ModuleContext getContext()
    {
        return global;
    }

    public void addFlags(int i)
    {
        flags = flags | i;
    }

    public void clear()
    {
        this;
        JVM INSTR monitorenter ;
        table.clear();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public ModuleInfo findFromInstance(Object obj)
    {
        Object obj1 = obj.getClass();
        this;
        JVM INSTR monitorenter ;
        ModuleManager modulemanager = manager;
        obj1 = ModuleManager.findWithClass(((Class) (obj1)));
        setInstance(obj);
        this;
        JVM INSTR monitorexit ;
        return ((ModuleInfo) (obj1));
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public Object findInstance(ModuleInfo moduleinfo)
    {
        this;
        JVM INSTR monitorenter ;
        Class class1 = moduleinfo.getModuleClass();
        moduleinfo = ((ModuleInfo) (findInstance(class1)));
        this;
        JVM INSTR monitorexit ;
        return moduleinfo;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        moduleinfo = moduleinfo.getClassName();
        throw new WrappedException((new StringBuilder()).append("cannot find module ").append(moduleinfo).toString(), classnotfoundexception);
        moduleinfo;
        this;
        JVM INSTR monitorexit ;
        throw moduleinfo;
    }

    public Object findInstance(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = table.get(class1);
        Object obj2 = obj;
        if (obj != null) goto _L2; else goto _L1
_L1:
        obj = class1.getDeclaredField("$instance").get(null);
        class1 = ((Class) (obj));
_L3:
        setInstance(class1);
        obj2 = class1;
_L2:
        this;
        JVM INSTR monitorexit ;
        return obj2;
        Object obj1;
        obj1;
        obj1 = class1.newInstance();
        class1 = ((Class) (obj1));
          goto _L3
        obj1;
        throw new WrappedException((new StringBuilder()).append("exception while initializing module ").append(class1.getName()).toString(), ((Throwable) (obj1)));
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
    }

    public int getFlags()
    {
        return flags;
    }

    public ModuleManager getManager()
    {
        return manager;
    }

    public Object searchInstance(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        class1 = ((Class) (table.get(class1)));
        this;
        JVM INSTR monitorexit ;
        return class1;
        class1;
        throw class1;
    }

    public void setFlags(int i)
    {
        flags = i;
    }

    public void setInstance(Object obj)
    {
        this;
        JVM INSTR monitorenter ;
        table.put(obj.getClass(), obj);
        this;
        JVM INSTR monitorexit ;
        return;
        obj;
        throw obj;
    }

    static 
    {
        global = new ModuleContext(ModuleManager.instance);
    }
}
