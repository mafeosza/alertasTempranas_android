// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Field;

// Referenced classes of package gnu.expr:
//            Compilation

public abstract class Initializer
{

    public Field field;
    Initializer next;

    public Initializer()
    {
    }

    public static Initializer reverse(Initializer initializer)
    {
        Initializer initializer1 = null;
        Initializer initializer2;
        for (; initializer != null; initializer = initializer2)
        {
            initializer2 = initializer.next;
            initializer.next = initializer1;
            initializer1 = initializer;
        }

        return initializer1;
    }

    public abstract void emit(Compilation compilation);

    public void reportError(String s, Compilation compilation)
    {
        compilation.error('e', (new StringBuilder()).append(s).append("field ").append(field).toString());
    }
}
