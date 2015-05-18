// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.CodeAttr;
import gnu.bytecode.Type;

// Referenced classes of package gnu.expr:
//            Target, Compilation

public class IgnoreTarget extends Target
{

    public IgnoreTarget()
    {
    }

    public void compileFromStack(Compilation compilation, Type type)
    {
        if (!type.isVoid())
        {
            compilation.getCode().emitPop(1);
        }
    }

    public Type getType()
    {
        return Type.voidType;
    }
}
