// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package kawa.lib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.expr.PrimProcedure;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.Procedure;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.WrongType;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class trace extends ModuleBody
{

    public static final Macro $Pcdo$Mntrace;
    public static final trace $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SyntaxRules Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    public static final ModuleMethod disassemble;
    public static final Macro trace;
    public static final Macro untrace;

    public trace()
    {
        ModuleInfo.register(this);
    }

    public static Object disassemble(Procedure procedure)
    {
        CallContext callcontext;
        int i;
        callcontext = CallContext.getInstance();
        i = callcontext.startFromContext();
        PrimProcedure.disassemble$X(procedure, callcontext);
        return callcontext.getFromContext(i);
        procedure;
        callcontext.cleanupFromContext(i);
        throw procedure;
    }

    public Object apply1(ModuleMethod modulemethod, Object obj)
    {
        if (modulemethod.selector == 1)
        {
            try
            {
                modulemethod = (Procedure)obj;
            }
            // Misplaced declaration of an exception variable
            catch (ModuleMethod modulemethod)
            {
                throw new WrongType(modulemethod, "disassemble", 1, obj);
            }
            return disassemble(modulemethod);
        } else
        {
            return super.apply1(modulemethod, obj);
        }
    }

    public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
    {
        if (modulemethod.selector == 1)
        {
            if (!(obj instanceof Procedure))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }
        } else
        {
            return super.match1(modulemethod, obj, callcontext);
        }
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit7 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("disassemble")).readResolve();
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("untrace")).readResolve();
        Lit4 = simplesymbol;
        Object obj = new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1);
        SimpleSymbol simplesymbol1 = Lit7;
        SimpleSymbol simplesymbol2 = (SimpleSymbol)(new SimpleSymbol("%do-trace")).readResolve();
        Lit0 = simplesymbol2;
        obj = new SyntaxRule(((SyntaxPattern) (obj)), "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", new Object[] {
            simplesymbol1, simplesymbol2, PairWithPosition.make(Boolean.FALSE, LList.Empty, "trace.scm", 0x1301b)
        }, 1);
        Lit5 = new SyntaxRules(new Object[] {
            simplesymbol
        }, new SyntaxRule[] {
            obj
        }, 1);
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("trace")).readResolve();
        Lit2 = simplesymbol;
        obj = new SyntaxRule(new SyntaxPattern("\f\030\r\007\000\b\b", new Object[0], 1), "\003", "\021\030\004\b\005\021\030\f\t\003\030\024", new Object[] {
            Lit7, Lit0, PairWithPosition.make(Boolean.TRUE, LList.Empty, "trace.scm", 57371)
        }, 1);
        Lit3 = new SyntaxRules(new Object[] {
            simplesymbol
        }, new SyntaxRule[] {
            obj
        }, 1);
        simplesymbol = Lit0;
        obj = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\b", new Object[0], 2), "\001\001", "\021\030\004\t\003\b\021\030\f\021\030\024\021\030\034\t\003\b\013", new Object[] {
            (SimpleSymbol)(new SimpleSymbol("set!")).readResolve(), (SimpleSymbol)(new SimpleSymbol("invoke-static")).readResolve(), (SimpleSymbol)(new SimpleSymbol("<kawa.standard.TracedProcedure>")).readResolve(), PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("quote")).readResolve(), PairWithPosition.make((SimpleSymbol)(new SimpleSymbol("doTrace")).readResolve(), LList.Empty, "trace.scm", 32806), "trace.scm", 32806)
        }, 0);
        Lit1 = new SyntaxRules(new Object[] {
            simplesymbol
        }, new SyntaxRule[] {
            obj
        }, 2);
        $instance = new trace();
        $Pcdo$Mntrace = Macro.make(Lit0, Lit1, $instance);
        trace = Macro.make(Lit2, Lit3, $instance);
        untrace = Macro.make(Lit4, Lit5, $instance);
        disassemble = new ModuleMethod($instance, 1, Lit6, 4097);
        $instance.run();
    }
}
