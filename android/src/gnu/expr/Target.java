// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Type;

// Referenced classes of package gnu.expr:
//            IgnoreTarget, StackTarget, Compilation

public abstract class Target
{

    public static final Target Ignore = new IgnoreTarget();
    public static final Target pushObject;

    public Target()
    {
    }

    public static Target pushValue(Type type)
    {
        if (type.isVoid())
        {
            return Ignore;
        } else
        {
            return StackTarget.getInstance(type);
        }
    }

    public abstract void compileFromStack(Compilation compilation, Type type);

    public abstract Type getType();

    static 
    {
        pushObject = new StackTarget(Type.pointer_type);
    }
}
