// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.xml;

import gnu.bytecode.ClassType;
import gnu.bytecode.CodeAttr;
import gnu.bytecode.Method;
import gnu.expr.Compilation;
import gnu.lists.TreePosition;
import gnu.math.IntNum;

public final class Focus extends TreePosition
{

    public static final ClassType TYPE;
    static ThreadLocal current = new ThreadLocal();
    static final Method getCurrentFocusMethod;
    IntNum contextPosition;
    public long position;

    public Focus()
    {
    }

    public static void compileGetCurrent(Compilation compilation)
    {
        compilation.getCode().emitInvoke(getCurrentFocusMethod);
    }

    public static Focus getCurrent()
    {
        Object obj1 = current.get();
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new Focus();
            current.set(obj);
        }
        return (Focus)obj;
    }

    static 
    {
        TYPE = ClassType.make("gnu.kawa.xml.Focus");
        getCurrentFocusMethod = TYPE.getDeclaredMethod("getCurrent", 0);
    }
}
