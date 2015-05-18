// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.expr;

import gnu.mapping.InPort;
import gnu.mapping.Procedure1;

class SimplePrompter extends Procedure1
{

    public String prefix;
    public String suffix;

    SimplePrompter()
    {
        prefix = "[";
        suffix = "] ";
    }

    public Object apply1(Object obj)
    {
        if (obj instanceof InPort)
        {
            int i = ((InPort)obj).getLineNumber() + 1;
            if (i >= 0)
            {
                return (new StringBuilder()).append(prefix).append(i).append(suffix).toString();
            }
        }
        return suffix;
    }
}
