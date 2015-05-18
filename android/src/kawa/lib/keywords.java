// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.Keyword;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;

public class keywords extends ModuleBody
{

    public static final keywords $instance;
    static final SimpleSymbol Lit0;
    static final SimpleSymbol Lit1;
    static final SimpleSymbol Lit2;
    public static final ModuleMethod keyword$Mn$Grstring;
    public static final ModuleMethod keyword$Qu;
    public static final ModuleMethod string$Mn$Grkeyword;

    public keywords()
    {
        ModuleInfo.register(this);
    }

    public static boolean isKeyword(Object obj)
    {
        return Keyword.isKeyword(obj);
    }

    public static CharSequence keyword$To$String(Keyword keyword)
    {
        return keyword.getName();
    }

    public static Keyword string$To$Keyword(String s)
    {
        return Keyword.make(s);
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.apply1(modulemethod, obj);

        case 1: // '\001'
            if (isKeyword(obj))
            {
                return Boolean.TRUE;
            } else
            {
                return Boolean.FALSE;
            }

        case 2: // '\002'
            try
            {
                modulemethod = (Keyword)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "keyword->string", 1, obj);
            }
            return keyword$To$String(modulemethod);

        case 3: // '\003'
            break;
        }
        if (obj == null)
        {
            modulemethod = null;
        } else
        {
            modulemethod = obj.toString();
        }
        return string$To$Keyword(modulemethod);
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        switch (modulemethod.selector)
        {
        default:
            return super.match1(modulemethod, obj, callcontext);

        case 3: // '\003'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;

        case 2: // '\002'
            if (!(obj instanceof Keyword))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }

        case 1: // '\001'
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit2 = (SimpleSymbol)(new SimpleSymbol("string->keyword")).readResolve();
        Lit1 = (SimpleSymbol)(new SimpleSymbol("keyword->string")).readResolve();
        Lit0 = (SimpleSymbol)(new SimpleSymbol("keyword?")).readResolve();
        $instance = new keywords();
        keywords keywords1 = $instance;
        keyword$Qu = new ModuleMethod(keywords1, 1, Lit0, 4097);
        keyword$Mn$Grstring = new ModuleMethod(keywords1, 2, Lit1, 4097);
        string$Mn$Grkeyword = new ModuleMethod(keywords1, 3, Lit2, 4097);
        $instance.run();
    }
}
