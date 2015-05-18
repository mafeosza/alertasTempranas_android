// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package gnu.kawa.slib;

import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.lists.LList;
import gnu.lists.PairWithPosition;
import gnu.mapping.CallContext;
import gnu.mapping.SimpleSymbol;
import kawa.lang.Macro;
import kawa.lang.SyntaxPattern;
import kawa.lang.SyntaxRule;
import kawa.lang.SyntaxRules;

public class DefineRecordType extends ModuleBody
{

    public static final Macro $Prvt$$Pcdefine$Mnrecord$Mnfield;
    public static final DefineRecordType $instance;
    static final SimpleSymbol Lit0;
    static final SyntaxRules Lit1;
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit11;
    static final SimpleSymbol Lit12;
    static final SimpleSymbol Lit2;
    static final SyntaxRules Lit3;
    static final SimpleSymbol Lit4;
    static final SimpleSymbol Lit5;
    static final SimpleSymbol Lit6;
    static final SimpleSymbol Lit7;
    static final SimpleSymbol Lit8;
    static final SimpleSymbol Lit9;
    public static final Macro define$Mnrecord$Mntype;

    public DefineRecordType()
    {
        ModuleInfo.register(this);
    }

    public final void run(CallContext callcontext)
    {
        callcontext = callcontext.consumer;
    }

    static 
    {
        Lit12 = (SimpleSymbol)(new SimpleSymbol("tmp")).readResolve();
        Lit11 = (SimpleSymbol)(new SimpleSymbol("slot-set!")).readResolve();
        Lit10 = (SimpleSymbol)(new SimpleSymbol("begin")).readResolve();
        Lit9 = (SimpleSymbol)(new SimpleSymbol("value")).readResolve();
        Lit8 = (SimpleSymbol)(new SimpleSymbol("quote")).readResolve();
        Lit7 = (SimpleSymbol)(new SimpleSymbol("slot-ref")).readResolve();
        Lit6 = (SimpleSymbol)(new SimpleSymbol("::")).readResolve();
        Lit5 = (SimpleSymbol)(new SimpleSymbol("obj")).readResolve();
        Lit4 = (SimpleSymbol)(new SimpleSymbol("define")).readResolve();
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("%define-record-field")).readResolve();
        Lit2 = simplesymbol;
        SyntaxRule syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\b", new Object[0], 3), "\001\001\001", "\021\030\004Y\t\023\b\021\030\f\021\030\024\b\003\b\021\030\034\021\030\f\b\021\030$\b\013", new Object[] {
            Lit4, Lit5, Lit6, Lit7, Lit8
        }, 0);
        SyntaxRule syntaxrule1 = new SyntaxRule(new SyntaxPattern("\f\030\f\007\f\017\f\027\f\037\b", new Object[0], 4), "\001\001\001\001", "\021\030\004\341\021\030\fY\t\023\b\021\030\024\021\030\034\b\003\b\021\030$\021\030\024\b\021\030,\b\013\b\021\030\fi\t\033A\021\030\024\021\030\034\b\003\0304\021\030\034\021\030<\b\021\030D\021\030\024)\021\030,\b\013\030L", new Object[] {
            Lit10, Lit4, Lit5, Lit6, Lit7, Lit8, PairWithPosition.make(Lit9, LList.Empty, "DefineRecordType.scm", 0x33028), (SimpleSymbol)(new SimpleSymbol("<void>")).readResolve(), Lit11, PairWithPosition.make(Lit9, LList.Empty, "DefineRecordType.scm", 0x3401d)
        }, 0);
        Lit3 = new SyntaxRules(new Object[] {
            simplesymbol
        }, new SyntaxRule[] {
            syntaxrule, syntaxrule1
        }, 4);
        simplesymbol = (SimpleSymbol)(new SimpleSymbol("define-record-type")).readResolve();
        Lit0 = simplesymbol;
        syntaxrule = new SyntaxRule(new SyntaxPattern("\f\030\f\007<\f\017\r\027\020\b\b\f\037-\f'\f/3 \030\b", new Object[0], 7), "\001\001\003\001\003\003\002", "\021\030\004Y\021\030\f\t\003\t\020\b%\b#\271\021\030\024!\t\033\030\034\021\030$\021\030,\b\021\0304\021\030<\b\003\u01C1\021\030\024)\t\013\b\025\023\021\030$\t\003\b\021\030Dy\b\021\030L\021\030$\t\003\b\021\030T\b\003\231\021\030\004\b\025\021\030\\\021\030L)\021\030d\b\023\b\023\030l\b%\021\030t\t\003\t#\t+2", new Object[] {
            Lit10, (SimpleSymbol)(new SimpleSymbol("define-simple-class")).readResolve(), Lit4, PairWithPosition.make(Lit5, LList.Empty, "DefineRecordType.scm", 0x1e01b), Lit6, (SimpleSymbol)(new SimpleSymbol("<boolean>")).readResolve(), (SimpleSymbol)(new SimpleSymbol("instance?")).readResolve(), Lit5, (SimpleSymbol)(new SimpleSymbol("let")).readResolve(), Lit12, 
            (SimpleSymbol)(new SimpleSymbol("make")).readResolve(), Lit11, Lit8, PairWithPosition.make(Lit12, LList.Empty, "DefineRecordType.scm", 0x23005), Lit2
        }, 1);
        Lit1 = new SyntaxRules(new Object[] {
            simplesymbol
        }, new SyntaxRule[] {
            syntaxrule
        }, 7);
        $instance = new DefineRecordType();
        define$Mnrecord$Mntype = Macro.make(Lit0, Lit1, $instance);
        $Prvt$$Pcdefine$Mnrecord$Mnfield = Macro.make(Lit2, Lit3, $instance);
        $instance.run();
    }
}
