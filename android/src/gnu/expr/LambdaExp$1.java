// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.bytecode.Filter;
import gnu.bytecode.Method;

// Referenced classes of package gnu.expr:
//            LambdaExp

class t>
    implements Filter
{

    final LambdaExp this$0;
    final String val$mangled;

    public boolean select(Object obj)
    {
        for (obj = (Method)obj; !((Method) (obj)).getName().equals(val$mangled) || ((Method) (obj)).getParameterTypes().length != min_args;)
        {
            return false;
        }

        return true;
    }

    ()
    {
        this$0 = final_lambdaexp;
        val$mangled = String.this;
        super();
    }
}
