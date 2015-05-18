// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib.kawa;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import java.util.regex.Matcher;
import kawa.standard.Scheme;

// Referenced classes of package kawa.lib.kawa:
//            regex

public class t> extends ModuleBody
{

    Object loop;
    Matcher matcher;
    Object repl;
    StringBuffer sbuf;

    public Object apply0(ModuleMethod modulemethod)
    {
        if (modulemethod.selector == 1)
        {
            return lambda1loop();
        } else
        {
            return super.apply0(modulemethod);
        }
    }

    public String lambda1loop()
    {
        if (matcher.find())
        {
            Matcher matcher1 = matcher;
            StringBuffer stringbuffer = sbuf;
            Object obj = Scheme.applyToArgs.apply2(repl, matcher.group());
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = obj.toString();
            }
            matcher1.appendReplacement(stringbuffer, Matcher.quoteReplacement(((String) (obj))));
        }
        matcher.appendTail(sbuf);
        return sbuf.toString();
    }

    public int match0(ModuleMethod modulemethod, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            callcontext.proc = modulemethod;
            callcontext.pc = 0;
            return 0;
        } else
        {
            return super.match0(modulemethod, callcontext);
        }
    }

    public ()
    {
        loop = new ModuleMethod(this, 1, regex.Lit0, 0);
    }
}
