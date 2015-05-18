// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.commonlisp.lang;

import gnu.mapping.Environment;
import gnu.mapping.EnvironmentKey;
import gnu.mapping.Namespace;
import gnu.mapping.Symbol;

// Referenced classes of package gnu.commonlisp.lang:
//            Lisp2

public class Symbols
{

    private Symbols()
    {
    }

    public static Object getFunctionBinding(Environment environment, Object obj)
    {
        return environment.getFunction(getSymbol(obj));
    }

    public static Object getFunctionBinding(Object obj)
    {
        return Environment.getCurrent().getFunction(getSymbol(obj));
    }

    public static Object getPrintName(Object obj)
    {
        if (obj == Lisp2.FALSE)
        {
            return "nil";
        } else
        {
            return Lisp2.getString(((Symbol)obj).getName());
        }
    }

    public static Symbol getSymbol(Environment environment, Object obj)
    {
        Object obj1 = obj;
        if (obj == Lisp2.FALSE)
        {
            obj1 = "nil";
        }
        if (obj1 instanceof Symbol)
        {
            return (Symbol)obj1;
        } else
        {
            return environment.defaultNamespace().getSymbol((String)obj1);
        }
    }

    public static Symbol getSymbol(Object obj)
    {
        Object obj1 = obj;
        if (obj == Lisp2.FALSE)
        {
            obj1 = "nil";
        }
        if (obj1 instanceof Symbol)
        {
            return (Symbol)obj1;
        } else
        {
            return Namespace.getDefaultSymbol((String)obj1);
        }
    }

    public static boolean isBound(Object obj)
    {
        if (obj != Lisp2.FALSE)
        {
            Environment environment = Environment.getCurrent();
            if (obj instanceof Symbol)
            {
                obj = (Symbol)obj;
            } else
            {
                obj = environment.defaultNamespace().lookup((String)obj);
            }
            if (obj == null || !environment.isBound(((Symbol) (obj))))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean isSymbol(Object obj)
    {
        return (obj instanceof String) || obj == Lisp2.FALSE || (obj instanceof Symbol);
    }

    public static void setFunctionBinding(Environment environment, Object obj, Object obj1)
    {
        environment.put(getSymbol(obj), EnvironmentKey.FUNCTION, obj1);
    }
}
