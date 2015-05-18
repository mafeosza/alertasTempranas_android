// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.mapping.InPort;

// Referenced classes of package kawa.lib:
//            misc_syntax, ports, std_syntax

public class  extends ModuleBody
{

    Object k;
    InPort p;

    public Object lambda4f()
    {
        Object obj = ports.read(p);
        if (ports.isEofObject(obj))
        {
            ports.closeInputPort(p);
            return LList.Empty;
        } else
        {
            return new Pair(std_syntax.datum$To$SyntaxObject(k, obj), lambda4f());
        }
    }

    public ()
    {
    }
}
