// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lang;

import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleContext;
import gnu.kawa.reflect.ClassMemberLocation;
import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.HasSetter;
import gnu.mapping.Procedure;
import gnu.mapping.Symbol;
import gnu.mapping.UnboundLocationException;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.PrintWriter;
import java.lang.reflect.Field;

public class AutoloadProcedure extends Procedure
    implements Externalizable
{

    static final Class classModuleBody = gnu/expr/ModuleBody;
    String className;
    Language language;
    Procedure loaded;

    public AutoloadProcedure()
    {
    }

    public AutoloadProcedure(String s, String s1)
    {
        super(s);
        className = s1;
    }

    public AutoloadProcedure(String s, String s1, Language language1)
    {
        super(s);
        className = s1;
        language = language1;
    }

    private void throw_error(String s)
    {
        loaded = null;
        String s1 = getName();
        StringBuilder stringbuilder = (new StringBuilder()).append(s).append(className).append(" while autoloading ");
        if (s1 == null)
        {
            s = "";
        } else
        {
            s = s1.toString();
        }
        throw new RuntimeException(stringbuilder.append(s).toString());
    }

    public Object apply0()
        throws Throwable
    {
        return getLoaded().apply0();
    }

    public Object apply1(Object obj)
        throws Throwable
    {
        return getLoaded().apply1(obj);
    }

    public Object apply2(Object obj, Object obj1)
        throws Throwable
    {
        return getLoaded().apply2(obj, obj1);
    }

    public Object apply3(Object obj, Object obj1, Object obj2)
        throws Throwable
    {
        return getLoaded().apply3(obj, obj1, obj2);
    }

    public Object apply4(Object obj, Object obj1, Object obj2, Object obj3)
        throws Throwable
    {
        return getLoaded().apply4(obj, obj1, obj2, obj3);
    }

    public Object applyN(Object aobj[])
        throws Throwable
    {
        if (loaded == null)
        {
            load();
        }
        if (loaded instanceof AutoloadProcedure)
        {
            throw new InternalError((new StringBuilder()).append("circularity in autoload of ").append(getName()).toString());
        } else
        {
            return loaded.applyN(aobj);
        }
    }

    public Procedure getLoaded()
    {
        if (loaded == null)
        {
            load();
        }
        return loaded;
    }

    public Object getProperty(Object obj, Object obj1)
    {
        Object obj2 = super.getProperty(obj, null);
        if (obj2 != null)
        {
            return obj2;
        } else
        {
            return getLoaded().getProperty(obj, obj1);
        }
    }

    public Procedure getSetter()
    {
        if (loaded == null)
        {
            load();
        }
        if (loaded instanceof HasSetter)
        {
            return loaded.getSetter();
        } else
        {
            return super.getSetter();
        }
    }

    void load()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Environment environment;
        Class class1;
        obj2 = null;
        obj3 = getSymbol();
        obj1 = language;
        obj = obj1;
        if (obj1 == null)
        {
            obj = Language.getDefaultLanguage();
        }
        environment = ((Language) (obj)).getLangEnvironment();
        if (obj3 instanceof Symbol)
        {
            obj1 = (Symbol)obj3;
        } else
        {
            obj1 = environment.getSymbol(obj3.toString());
        }
        class1 = Class.forName(className);
        if (!classModuleBody.isAssignableFrom(class1)) goto _L2; else goto _L1
_L1:
        obj2 = ModuleContext.getContext().searchInstance(class1);
        if (obj2 != null)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        try
        {
            obj2 = class1.getDeclaredField("$instance").get(null);
        }
        catch (UnboundLocationException unboundlocationexception)
        {
            try
            {
                obj2 = class1.newInstance();
            }
            catch (ClassNotFoundException classnotfoundexception)
            {
                throw_error("failed to find class ");
                return;
            }
            catch (InstantiationException instantiationexception)
            {
                throw_error("failed to instantiate class ");
                return;
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                throw_error("illegal access in class ");
                return;
            }
        }
        ClassMemberLocation.defineAll(obj2, ((Language) (obj)), environment);
        if (obj2 instanceof ModuleBody)
        {
            ((ModuleBody)obj2).run();
        }
        obj = environment.getFunction(((Symbol) (obj1)), null);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        if (obj instanceof Procedure)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        throw_error((new StringBuilder()).append("invalid ModuleBody class - does not define ").append(obj3).toString());
        loaded = (Procedure)obj;
_L4:
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_184;
        }
        if (loaded.getSymbol() == null)
        {
            loaded.setSymbol(obj3);
        }
        return;
_L2:
        loaded = (Procedure)class1.newInstance();
        if (loaded == this)
        {
            throw_error("circularity detected");
        }
        if (obj3 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((Language) (obj)).hasSeparateFunctionNamespace())
        {
            obj2 = EnvironmentKey.FUNCTION;
        }
        environment.put(((Symbol) (obj1)), obj2, loaded);
        continue; /* Loop/switch isn't completed */
        unboundlocationexception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int numArgs()
    {
        return getLoaded().numArgs();
    }

    public void print(PrintWriter printwriter)
    {
        printwriter.print("#<procedure ");
        String s = getName();
        if (s != null)
        {
            printwriter.print(s);
        }
        printwriter.print('>');
    }

    public void readExternal(ObjectInput objectinput)
        throws IOException, ClassNotFoundException
    {
        setName((String)objectinput.readObject());
        className = (String)objectinput.readObject();
    }

    public void writeExternal(ObjectOutput objectoutput)
        throws IOException
    {
        objectoutput.writeObject(getName());
        objectoutput.writeObject(className);
    }

}
