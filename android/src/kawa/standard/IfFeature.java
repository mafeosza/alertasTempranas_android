// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.standard;

import gnu.expr.Compilation;
import gnu.expr.Declaration;
import gnu.expr.ModuleContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.SyntaxForm;

public class IfFeature
{

    public IfFeature()
    {
    }

    public static boolean hasFeature(String s)
    {
_L2:
        return true;
        if (s == "kawa" || s == "srfi-0" || s == "srfi-4" || s == "srfi-6" || s == "srfi-8" || s == "srfi-9" || s == "srfi-11" || s == "srfi-16" || s == "srfi-17" || s == "srfi-23" || s == "srfi-25" || s == "srfi-26" || s == "srfi-28" || s == "srfi-30" || s == "srfi-39") goto _L2; else goto _L1
_L1:
        if (s != "in-http-server" && s != "in-servlet")
        {
            break; /* Loop/switch isn't completed */
        }
        int i = ModuleContext.getContext().getFlags();
        if (s == "in-http-server")
        {
            if ((ModuleContext.IN_HTTP_SERVER & i) == 0)
            {
                return false;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (s != "in-servlet")
        {
            break; /* Loop/switch isn't completed */
        }
        if ((ModuleContext.IN_SERVLET & i) == 0)
        {
            return false;
        }
        if (true) goto _L2; else goto _L3
_L3:
        s = (new StringBuilder()).append("%provide%").append(s).toString().intern();
        s = Compilation.getCurrent().lookup(s, -1);
        if (s == null || s.getFlag(0x10000L))
        {
            return false;
        }
        if (true) goto _L2; else goto _L4
_L4:
    }

    public static boolean testFeature(Object obj)
    {
        Object obj1 = obj;
        if (obj instanceof SyntaxForm)
        {
            obj1 = ((SyntaxForm)obj).getDatum();
        }
        if ((obj1 instanceof String) || (obj1 instanceof SimpleSymbol))
        {
            return hasFeature(obj1.toString());
        } else
        {
            return false;
        }
    }
}
