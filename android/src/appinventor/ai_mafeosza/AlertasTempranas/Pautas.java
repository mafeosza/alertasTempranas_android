// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package appinventor.ai_mafeosza.AlertasTempranas;

import com.google.appinventor.components.runtime.Button;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.runtime.Form;
import com.google.appinventor.components.runtime.HandlesEventDispatching;
import com.google.appinventor.components.runtime.HorizontalArrangement;
import com.google.appinventor.components.runtime.Label;
import com.google.appinventor.components.runtime.ListView;
import com.google.appinventor.components.runtime.Notifier;
import com.google.appinventor.components.runtime.ReplApplication;
import com.google.appinventor.components.runtime.Web;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import com.google.appinventor.components.runtime.util.RetValManager;
import com.google.appinventor.components.runtime.util.RuntimeErrorAlert;
import com.google.youngandroid.runtime;
import gnu.expr.Language;
import gnu.expr.ModuleBody;
import gnu.expr.ModuleInfo;
import gnu.expr.ModuleMethod;
import gnu.kawa.functions.Format;
import gnu.kawa.functions.GetNamedPart;
import gnu.kawa.reflect.Invoke;
import gnu.kawa.reflect.SlotGet;
import gnu.kawa.reflect.SlotSet;
import gnu.lists.FString;
import gnu.lists.LList;
import gnu.lists.Pair;
import gnu.lists.PairWithPosition;
import gnu.lists.VoidConsumer;
import gnu.mapping.CallContext;
import gnu.mapping.Environment;
import gnu.mapping.Procedure;
import gnu.mapping.PropertySet;
import gnu.mapping.SimpleSymbol;
import gnu.mapping.Symbol;
import gnu.mapping.Values;
import gnu.mapping.WrongType;
import gnu.math.DFloNum;
import gnu.math.IntNum;
import kawa.lang.Promise;
import kawa.lib.lists;
import kawa.lib.misc;
import kawa.lib.strings;
import kawa.standard.Scheme;
import kawa.standard.require;

public class Pautas extends Form
    implements Runnable
{
    public class frame0 extends ModuleBody
    {

        Object $end;
        final ModuleMethod lambda$Fn20 = new ModuleMethod(this, 1, null, 4097);

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 1)
            {
                return lambda21(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda21(Object obj)
        {
            if (runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit3, runtime.$Stthe$Mnnull$Mnvalue$St) != Boolean.FALSE)
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Pautas.Lit3, Boolean.FALSE);
            } else
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Pautas.Lit4, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), "", Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit14, runtime.$Stthe$Mnnull$Mnvalue$St), obj, "", $end)), Pautas.Lit54, "join"));
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 1)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return super.match1(modulemethod, obj, callcontext);
            }
        }

        public frame0()
        {
        }
    }

    public class frame1 extends ModuleBody
    {

        Object $end;
        final ModuleMethod lambda$Fn23 = new ModuleMethod(this, 2, null, 4097);

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 2)
            {
                return lambda24(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda24(Object obj)
        {
            if (runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit3, runtime.$Stthe$Mnnull$Mnvalue$St) != Boolean.FALSE)
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Pautas.Lit3, Boolean.FALSE);
            } else
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Pautas.Lit4, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), "", Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Pautas.Lit14, runtime.$Stthe$Mnnull$Mnvalue$St), obj, "", $end)), Pautas.Lit56, "join"));
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            if (modulemethod.selector == 2)
            {
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            } else
            {
                return super.match1(modulemethod, obj, callcontext);
            }
        }

        public frame1()
        {
        }
    }


    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("Pautas")).readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("getMessage")).readResolve();
    static final SimpleSymbol Lit10;
    static final SimpleSymbol Lit100 = (SimpleSymbol)(new SimpleSymbol("BackgroundColor")).readResolve();
    static final IntNum Lit101 = IntNum.make(0xffffff);
    static final SimpleSymbol Lit102 = (SimpleSymbol)(new SimpleSymbol("Height")).readResolve();
    static final SimpleSymbol Lit103 = (SimpleSymbol)(new SimpleSymbol("TextColor")).readResolve();
    static final IntNum Lit104;
    static final FString Lit105 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit106 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit107 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement2")).readResolve();
    static final FString Lit108 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit109 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit11 = (SimpleSymbol)(new SimpleSymbol("Get")).readResolve();
    static final SimpleSymbol Lit110 = (SimpleSymbol)(new SimpleSymbol("reportarEnfermedad")).readResolve();
    static final FString Lit111 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit112;
    static final SimpleSymbol Lit113 = (SimpleSymbol)(new SimpleSymbol("reportarEnfermedad$Click")).readResolve();
    static final SimpleSymbol Lit114 = (SimpleSymbol)(new SimpleSymbol("Click")).readResolve();
    static final FString Lit115 = new FString("com.google.appinventor.components.runtime.Web");
    static final FString Lit116 = new FString("com.google.appinventor.components.runtime.Web");
    static final IntNum Lit117 = IntNum.make(200);
    static final PairWithPosition Lit118;
    static final SimpleSymbol Lit119 = (SimpleSymbol)(new SimpleSymbol("Notifier1")).readResolve();
    static final PairWithPosition Lit12;
    static final SimpleSymbol Lit120 = (SimpleSymbol)(new SimpleSymbol("ShowAlert")).readResolve();
    static final PairWithPosition Lit121;
    static final PairWithPosition Lit122;
    static final SimpleSymbol Lit123 = (SimpleSymbol)(new SimpleSymbol("Web1$GotText")).readResolve();
    static final SimpleSymbol Lit124 = (SimpleSymbol)(new SimpleSymbol("GotText")).readResolve();
    static final FString Lit125 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit126 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit127 = (SimpleSymbol)(new SimpleSymbol("android-log-form")).readResolve();
    static final SimpleSymbol Lit128 = (SimpleSymbol)(new SimpleSymbol("add-to-form-environment")).readResolve();
    static final SimpleSymbol Lit129 = (SimpleSymbol)(new SimpleSymbol("lookup-in-form-environment")).readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol)(new SimpleSymbol("g$tempData")).readResolve();
    static final SimpleSymbol Lit130 = (SimpleSymbol)(new SimpleSymbol("is-bound-in-form-environment")).readResolve();
    static final SimpleSymbol Lit131 = (SimpleSymbol)(new SimpleSymbol("add-to-global-var-environment")).readResolve();
    static final SimpleSymbol Lit132 = (SimpleSymbol)(new SimpleSymbol("add-to-events")).readResolve();
    static final SimpleSymbol Lit133 = (SimpleSymbol)(new SimpleSymbol("add-to-components")).readResolve();
    static final SimpleSymbol Lit134 = (SimpleSymbol)(new SimpleSymbol("add-to-global-vars")).readResolve();
    static final SimpleSymbol Lit135 = (SimpleSymbol)(new SimpleSymbol("add-to-form-do-after-creation")).readResolve();
    static final SimpleSymbol Lit136 = (SimpleSymbol)(new SimpleSymbol("send-error")).readResolve();
    static final SimpleSymbol Lit137 = (SimpleSymbol)(new SimpleSymbol("dispatchEvent")).readResolve();
    static final SimpleSymbol Lit138 = (SimpleSymbol)(new SimpleSymbol("lookup-handler")).readResolve();
    static final SimpleSymbol Lit139;
    static final SimpleSymbol Lit14 = (SimpleSymbol)(new SimpleSymbol("p$parse")).readResolve();
    static final PairWithPosition Lit15;
    static final PairWithPosition Lit16;
    static final IntNum Lit17 = IntNum.make(2);
    static final PairWithPosition Lit18;
    static final PairWithPosition Lit19;
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("*the-null-value*")).readResolve();
    static final IntNum Lit20 = IntNum.make(1);
    static final PairWithPosition Lit21;
    static final SimpleSymbol Lit22 = (SimpleSymbol)(new SimpleSymbol("JsonTextDecode")).readResolve();
    static final PairWithPosition Lit23;
    static final SimpleSymbol Lit24 = (SimpleSymbol)(new SimpleSymbol("HtmlTextDecode")).readResolve();
    static final PairWithPosition Lit25;
    static final PairWithPosition Lit26;
    static final PairWithPosition Lit27;
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("g$isFirstItem")).readResolve();
    static final PairWithPosition Lit30;
    static final PairWithPosition Lit31;
    static final PairWithPosition Lit32;
    static final SimpleSymbol Lit33 = (SimpleSymbol)(new SimpleSymbol("g$reporte")).readResolve();
    static final SimpleSymbol Lit34 = (SimpleSymbol)(new SimpleSymbol("g$pautasFA")).readResolve();
    static final PairWithPosition Lit35;
    static final PairWithPosition Lit36;
    static final SimpleSymbol Lit37 = (SimpleSymbol)(new SimpleSymbol("g$pautasDengueGrave")).readResolve();
    static final PairWithPosition Lit38;
    static final PairWithPosition Lit39;
    static final SimpleSymbol Lit4 = (SimpleSymbol)(new SimpleSymbol("g$allPautas")).readResolve();
    static final SimpleSymbol Lit40 = (SimpleSymbol)(new SimpleSymbol("g$pautasDengueMortal")).readResolve();
    static final PairWithPosition Lit41;
    static final PairWithPosition Lit42;
    static final SimpleSymbol Lit43 = (SimpleSymbol)(new SimpleSymbol("g$pautasHepatitisA")).readResolve();
    static final PairWithPosition Lit44;
    static final PairWithPosition Lit45;
    static final SimpleSymbol Lit46 = (SimpleSymbol)(new SimpleSymbol("g$pautasHepatitisE")).readResolve();
    static final PairWithPosition Lit47;
    static final PairWithPosition Lit48;
    static final SimpleSymbol Lit49 = (SimpleSymbol)(new SimpleSymbol("g$pautasChikungunya")).readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol)(new SimpleSymbol("g$url")).readResolve();
    static final PairWithPosition Lit50;
    static final PairWithPosition Lit51;
    static final SimpleSymbol Lit52 = (SimpleSymbol)(new SimpleSymbol("p$getAllPautas")).readResolve();
    static final PairWithPosition Lit53;
    static final PairWithPosition Lit54;
    static final PairWithPosition Lit55;
    static final PairWithPosition Lit56;
    static final SimpleSymbol Lit57 = (SimpleSymbol)(new SimpleSymbol("g$pautasEnterovirus")).readResolve();
    static final PairWithPosition Lit58;
    static final PairWithPosition Lit59;
    static final SimpleSymbol Lit6 = (SimpleSymbol)(new SimpleSymbol("p$getPautas")).readResolve();
    static final SimpleSymbol Lit60 = (SimpleSymbol)(new SimpleSymbol("g$pautasLeptospirosis")).readResolve();
    static final PairWithPosition Lit61;
    static final PairWithPosition Lit62;
    static final SimpleSymbol Lit63 = (SimpleSymbol)(new SimpleSymbol("g$pautasMalaria")).readResolve();
    static final PairWithPosition Lit64;
    static final PairWithPosition Lit65;
    static final SimpleSymbol Lit66 = (SimpleSymbol)(new SimpleSymbol("AppName")).readResolve();
    static final PairWithPosition Lit67;
    static final SimpleSymbol Lit68 = (SimpleSymbol)(new SimpleSymbol("ListView1")).readResolve();
    static final SimpleSymbol Lit69 = (SimpleSymbol)(new SimpleSymbol("Elements")).readResolve();
    static final SimpleSymbol Lit7 = (SimpleSymbol)(new SimpleSymbol("Web1")).readResolve();
    static final SimpleSymbol Lit70;
    static final PairWithPosition Lit71;
    static final PairWithPosition Lit72;
    static final PairWithPosition Lit73;
    static final PairWithPosition Lit74;
    static final PairWithPosition Lit75;
    static final PairWithPosition Lit76;
    static final PairWithPosition Lit77;
    static final PairWithPosition Lit78;
    static final PairWithPosition Lit79;
    static final SimpleSymbol Lit8 = (SimpleSymbol)(new SimpleSymbol("Url")).readResolve();
    static final PairWithPosition Lit80;
    static final SimpleSymbol Lit81 = (SimpleSymbol)(new SimpleSymbol("Pautas$Initialize")).readResolve();
    static final SimpleSymbol Lit82 = (SimpleSymbol)(new SimpleSymbol("Initialize")).readResolve();
    static final FString Lit83 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit84 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement1")).readResolve();
    static final SimpleSymbol Lit85 = (SimpleSymbol)(new SimpleSymbol("AlignHorizontal")).readResolve();
    static final IntNum Lit86 = IntNum.make(3);
    static final SimpleSymbol Lit87;
    static final SimpleSymbol Lit88 = (SimpleSymbol)(new SimpleSymbol("Width")).readResolve();
    static final IntNum Lit89 = IntNum.make(-2);
    static final PairWithPosition Lit9;
    static final FString Lit90 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit91 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit92 = (SimpleSymbol)(new SimpleSymbol("Label1")).readResolve();
    static final SimpleSymbol Lit93 = (SimpleSymbol)(new SimpleSymbol("FontBold")).readResolve();
    static final SimpleSymbol Lit94 = (SimpleSymbol)(new SimpleSymbol("boolean")).readResolve();
    static final SimpleSymbol Lit95 = (SimpleSymbol)(new SimpleSymbol("FontSize")).readResolve();
    static final DFloNum Lit96 = DFloNum.make(20);
    static final SimpleSymbol Lit97 = (SimpleSymbol)(new SimpleSymbol("Text")).readResolve();
    static final FString Lit98 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit99 = new FString("com.google.appinventor.components.runtime.ListView");
    public static Pautas Pautas;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn10;
    static final ModuleMethod lambda$Fn11;
    static final ModuleMethod lambda$Fn12;
    static final ModuleMethod lambda$Fn13;
    static final ModuleMethod lambda$Fn14;
    static final ModuleMethod lambda$Fn15;
    static final ModuleMethod lambda$Fn16;
    static final ModuleMethod lambda$Fn17;
    static final ModuleMethod lambda$Fn18;
    static final ModuleMethod lambda$Fn19;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn21;
    static final ModuleMethod lambda$Fn22;
    static final ModuleMethod lambda$Fn24;
    static final ModuleMethod lambda$Fn25;
    static final ModuleMethod lambda$Fn26;
    static final ModuleMethod lambda$Fn27;
    static final ModuleMethod lambda$Fn28;
    static final ModuleMethod lambda$Fn29;
    static final ModuleMethod lambda$Fn3;
    static final ModuleMethod lambda$Fn30;
    static final ModuleMethod lambda$Fn31;
    static final ModuleMethod lambda$Fn32;
    static final ModuleMethod lambda$Fn33;
    static final ModuleMethod lambda$Fn34;
    static final ModuleMethod lambda$Fn35;
    static final ModuleMethod lambda$Fn36;
    static final ModuleMethod lambda$Fn37;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn8;
    static final ModuleMethod lambda$Fn9;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public HorizontalArrangement HorizontalArrangement1;
    public HorizontalArrangement HorizontalArrangement2;
    public Label Label1;
    public ListView ListView1;
    public Notifier Notifier1;
    public final ModuleMethod Pautas$Initialize;
    public Web Web1;
    public final ModuleMethod Web1$GotText;
    public final ModuleMethod add$Mnto$Mncomponents;
    public final ModuleMethod add$Mnto$Mnevents;
    public final ModuleMethod add$Mnto$Mnform$Mndo$Mnafter$Mncreation;
    public final ModuleMethod add$Mnto$Mnform$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvar$Mnenvironment;
    public final ModuleMethod add$Mnto$Mnglobal$Mnvars;
    public final ModuleMethod android$Mnlog$Mnform;
    public LList components$Mnto$Mncreate;
    public final ModuleMethod dispatchEvent;
    public LList events$Mnto$Mnregister;
    public LList form$Mndo$Mnafter$Mncreation;
    public Environment form$Mnenvironment;
    public Symbol form$Mnname$Mnsymbol;
    public Environment global$Mnvar$Mnenvironment;
    public LList global$Mnvars$Mnto$Mncreate;
    public final ModuleMethod is$Mnbound$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod lookup$Mnhandler;
    public final ModuleMethod lookup$Mnin$Mnform$Mnenvironment;
    public final ModuleMethod process$Mnexception;
    public Button reportarEnfermedad;
    public final ModuleMethod reportarEnfermedad$Click;
    public final ModuleMethod send$Mnerror;

    public Pautas()
    {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.main = this;
        android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit127, 4097);
        add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit128, 8194);
        lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit129, 8193);
        is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit130, 4097);
        add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit131, 8194);
        add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit132, 8194);
        add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit133, 16388);
        add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit134, 8194);
        add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit135, 4097);
        send$Mnerror = new ModuleMethod(frame2, 13, Lit136, 4097);
        process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", 4097);
        dispatchEvent = new ModuleMethod(frame2, 15, Lit137, 16388);
        lookup$Mnhandler = new ModuleMethod(frame2, 16, Lit138, 8194);
        ModuleMethod modulemethod = new ModuleMethod(frame2, 17, null, 0);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:541");
        lambda$Fn1 = modulemethod;
        $define = new ModuleMethod(frame2, 18, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 19, null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 20, null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 21, null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 22, null, 4097);
        lambda$Fn7 = new ModuleMethod(frame2, 23, null, 4097);
        lambda$Fn6 = new ModuleMethod(frame2, 24, null, 0);
        lambda$Fn8 = new ModuleMethod(frame2, 25, null, 0);
        lambda$Fn9 = new ModuleMethod(frame2, 26, null, 12291);
        lambda$Fn11 = new ModuleMethod(frame2, 27, null, 12291);
        lambda$Fn10 = new ModuleMethod(frame2, 28, null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 29, null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 30, null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 31, null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 32, null, 0);
        lambda$Fn16 = new ModuleMethod(frame2, 33, null, 0);
        lambda$Fn17 = new ModuleMethod(frame2, 34, null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 35, null, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 36, null, 12291);
        lambda$Fn22 = new ModuleMethod(frame2, 37, null, 12291);
        lambda$Fn21 = new ModuleMethod(frame2, 38, null, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 39, null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 40, null, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 41, null, 0);
        lambda$Fn27 = new ModuleMethod(frame2, 42, null, 0);
        Pautas$Initialize = new ModuleMethod(frame2, 43, Lit81, 0);
        lambda$Fn28 = new ModuleMethod(frame2, 44, null, 0);
        lambda$Fn29 = new ModuleMethod(frame2, 45, null, 0);
        lambda$Fn30 = new ModuleMethod(frame2, 46, null, 0);
        lambda$Fn31 = new ModuleMethod(frame2, 47, null, 0);
        lambda$Fn32 = new ModuleMethod(frame2, 48, null, 0);
        lambda$Fn33 = new ModuleMethod(frame2, 49, null, 0);
        lambda$Fn34 = new ModuleMethod(frame2, 50, null, 0);
        lambda$Fn35 = new ModuleMethod(frame2, 51, null, 0);
        lambda$Fn36 = new ModuleMethod(frame2, 52, null, 0);
        lambda$Fn37 = new ModuleMethod(frame2, 53, null, 0);
        reportarEnfermedad$Click = new ModuleMethod(frame2, 54, Lit113, 0);
        Web1$GotText = new ModuleMethod(frame2, 55, Lit123, 16388);
    }

    static Object lambda10(Object obj, Object obj1, Object obj2)
    {
        runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.string$Mnsplit$Mnat$Mnfirst, LList.list2(obj, obj1), Lit15, "split at first"));
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit16, "length of list"), Lit17), Lit18, "=") != Boolean.FALSE)
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St), Lit17), Lit19, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St), Lit20), Lit21, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callComponentMethod(Lit7, Lit22, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit23));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callComponentMethod(Lit7, Lit24, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit25));
        } else
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, "No hay resultados");
        }
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Procedure lambda11()
    {
        return lambda$Fn11;
    }

    static Object lambda12(Object obj, Object obj1, Object obj2)
    {
        runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.string$Mnsplit$Mnat$Mnfirst, LList.list2(obj, obj1), Lit26, "split at first"));
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit27, "length of list"), Lit17), Lit28, "=") != Boolean.FALSE)
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St), Lit17), Lit29, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St), Lit20), Lit30, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callComponentMethod(Lit7, Lit22, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit31));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callComponentMethod(Lit7, Lit24, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit32));
        } else
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit13, "No hay resultados");
        }
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda13()
    {
        return runtime.callYailPrimitive(runtime.get$Mnstart$Mnvalue, LList.Empty, LList.Empty, "get start value");
    }

    static Object lambda14()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). Hemoderivados para el sangrado severo.", "2). Di\341lisis para la insuficiencia renal.", "3). L\355quidos por v\355a intravenosa [l\355quidos intravenosos]."), Lit36, "make a list");
    }

    static Object lambda15()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). Es fundamentalmente la hidrataci\363n con el mantenimiento de los signos vitales y el gasto urinario.", "2). Se debe evitar el uso de aspirina y cualquier tipo de AINE.", "3). Se indica el uso de acetaminof\351n como analg\351sico y antipir\351tico."), Lit39, "make a list");
    }

    static Object lambda16()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). Una transfusi\363n de plasma fresco o plaquetas puede corregir problemas de sangrado.", "2). La rehidrataci\363n con l\355quidos intravenosos con frecuencia es necesaria para tratar la deshidrataci\363n.", "3). Tratamiento complementario en un ambiente/unidad de cuidados intensivos."), Lit42, "make a list");
    }

    static Object lambda17()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). La hepatitis aguda, a menos que sea grave, no necesita ning\372n tratamiento.", "2). La funci\363n hep\341tica y otras funciones corporales se vigilan mediante ex\341menes de sangre.", "3). Se debe reposar bastante en cama, tomar mucho l\355quido y comer alimentos saludables."), Lit45, "make a list");
    }

    static Object lambda18()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("No existe un tratamiento espec\355fico.", "Generalmente la hepatitis E se resuelve espont\341neamente tras varias semanas o meses."), Lit48, "make a list");
    }

    static Object lambda19()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("No existe un tratamiento espec\355fico.", "1). El cuadro cl\355nico se pueden tratar con medicamentos que alivien las molestias del paciente.", "2). Se debe evitar la aspirina, porque puede alterar la coagulaci\363n de la sangre."), Lit51, "make a list");
    }

    public static SimpleSymbol lambda1symbolAppend$V(Object aobj[])
    {
        Object obj = LList.makeList(aobj, 0);
        gnu.kawa.functions.Apply apply = Scheme.apply;
        ModuleMethod modulemethod = strings.string$Mnappend;
        aobj = LList.Empty;
        do
        {
            if (obj == LList.Empty)
            {
                aobj = ((Object []) (apply.apply2(modulemethod, LList.reverseInPlace(((Object) (aobj))))));
                Object obj1;
                Symbol symbol;
                try
                {
                    obj = (CharSequence)aobj;
                }
                catch (ClassCastException classcastexception)
                {
                    throw new WrongType(classcastexception, "string->symbol", 1, ((Object) (aobj)));
                }
                return misc.string$To$Symbol(((CharSequence) (obj)));
            }
            try
            {
                obj1 = (Pair)obj;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "arg0", -2, obj);
            }
            obj = ((Pair) (obj1)).getCdr();
            obj1 = ((Pair) (obj1)).getCar();
            try
            {
                symbol = (Symbol)obj1;
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                throw new WrongType(((ClassCastException) (aobj)), "symbol->string", 1, obj1);
            }
            aobj = Pair.make(misc.symbol$To$String(symbol), ((Object) (aobj)));
        } while (true);
    }

    static Object lambda2()
    {
        return null;
    }

    static Object lambda20(Object obj, Object obj1, Object obj2)
    {
        frame0 frame0_1 = new frame0();
        frame0_1.end = obj2;
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Boolean.TRUE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit4, "");
        runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(obj, obj1), Lit53, "split"));
        runtime.yailForEach(frame0_1.Fn20, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St));
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Procedure lambda22()
    {
        return lambda$Fn22;
    }

    static Object lambda23(Object obj, Object obj1, Object obj2)
    {
        frame1 frame1_1 = new frame1();
        frame1_1.end = obj2;
        runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Boolean.TRUE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit4, "");
        runtime.addGlobalVarToCurrentFormEnvironment(Lit13, runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(obj, obj1), Lit55, "split"));
        runtime.yailForEach(frame1_1.Fn23, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit13, runtime.$Stthe$Mnnull$Mnvalue$St));
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda25()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("1). Las enfermedades causadas por enterovirus no se tratan con antibi\363ticos.", "2). Algunas de estas enfermedades son susceptibles a ciertos anti virales."), Lit59, "make a list");
    }

    static Object lambda26()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("1). Algunos medicamentos para tratarla son: Ampicilina, Azitromicina, Ceftriaxona, Doxiciclina y Penicilina.", "2). Los casos complicados pueden necesitar tratamiento complementario en una unidad de cuidados intensivos."), Lit62, "make a list");
    }

    static Object lambda27()
    {
        return runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("No existe un tratamiento espec\355fico.", "1). Insistir en que es una medida de urgencia y que, en cuanto, se pueda se debe acudir a un especialista."), Lit65, "make a list");
    }

    static Object lambda28()
    {
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit66, "AlertasTempranas", Lit10);
    }

    static Object lambda29()
    {
        runtime.setAndCoerceProperty$Ex(Lit84, Lit85, Lit86, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit84, Lit88, Lit89, Lit87);
    }

    static Boolean lambda3()
    {
        return Boolean.FALSE;
    }

    static Object lambda30()
    {
        runtime.setAndCoerceProperty$Ex(Lit84, Lit85, Lit86, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit84, Lit88, Lit89, Lit87);
    }

    static Object lambda31()
    {
        runtime.setAndCoerceProperty$Ex(Lit92, Lit93, Boolean.TRUE, Lit94);
        runtime.setAndCoerceProperty$Ex(Lit92, Lit95, Lit96, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit92, Lit97, "Pautas y Precauciones", Lit10);
    }

    static Object lambda32()
    {
        runtime.setAndCoerceProperty$Ex(Lit92, Lit93, Boolean.TRUE, Lit94);
        runtime.setAndCoerceProperty$Ex(Lit92, Lit95, Lit96, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit92, Lit97, "Pautas y Precauciones", Lit10);
    }

    static Object lambda33()
    {
        runtime.setAndCoerceProperty$Ex(Lit68, Lit100, Lit101, Lit87);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit102, Lit89, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit68, Lit103, Lit104, Lit87);
    }

    static Object lambda34()
    {
        runtime.setAndCoerceProperty$Ex(Lit68, Lit100, Lit101, Lit87);
        runtime.setAndCoerceProperty$Ex(Lit68, Lit102, Lit89, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit68, Lit103, Lit104, Lit87);
    }

    static Object lambda35()
    {
        runtime.setAndCoerceProperty$Ex(Lit107, Lit85, Lit86, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit107, Lit88, Lit89, Lit87);
    }

    static Object lambda36()
    {
        runtime.setAndCoerceProperty$Ex(Lit107, Lit85, Lit86, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit107, Lit88, Lit89, Lit87);
    }

    static Object lambda37()
    {
        runtime.setAndCoerceProperty$Ex(Lit110, Lit88, Lit89, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit110, Lit97, "Reportar Enfermedad", Lit10);
    }

    static Object lambda38()
    {
        runtime.setAndCoerceProperty$Ex(Lit110, Lit88, Lit89, Lit87);
        return runtime.setAndCoerceProperty$Ex(Lit110, Lit97, "Reportar Enfermedad", Lit10);
    }

    static String lambda4()
    {
        return "";
    }

    static String lambda5()
    {
        return "http://192.168.195.76/alerts/api/guidelines";
    }

    static Object lambda6(Object obj)
    {
        runtime.setAndCoerceProperty$Ex(Lit7, Lit8, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St), "/search/", obj), Lit9, "join"), Lit10);
        return runtime.callComponentMethod(Lit7, Lit11, LList.Empty, LList.Empty);
    }

    static Procedure lambda7()
    {
        return lambda$Fn7;
    }

    static Object lambda8(Object obj)
    {
        runtime.setAndCoerceProperty$Ex(Lit7, Lit8, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St), "/search/", obj), Lit12, "join"), Lit10);
        return runtime.callComponentMethod(Lit7, Lit11, LList.Empty, LList.Empty);
    }

    static String lambda9()
    {
        return "";
    }

    public void $define()
    {
        Object obj;
        Object obj1;
        Language.setDefaults(Scheme.getInstance());
        try
        {
            run();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            androidLogForm(((Exception) (obj)).getMessage());
            processException(obj);
        }
        Pautas = this;
        addToFormEnvironment(Lit0, this);
        obj = events$Mnto$Mnregister;
_L12:
        if (obj != LList.Empty) goto _L2; else goto _L1
_L1:
        addToGlobalVars(Lit2, lambda$Fn1);
        obj = lists.reverse(global$Mnvars$Mnto$Mncreate);
_L13:
        if (obj != LList.Empty) goto _L4; else goto _L3
_L3:
        obj = lists.reverse(form$Mndo$Mnafter$Mncreation);
_L14:
        if (obj != LList.Empty) goto _L6; else goto _L5
_L5:
        obj = lists.reverse(components$Mnto$Mncreate);
        obj1 = obj;
_L15:
        if (obj1 != LList.Empty) goto _L8; else goto _L7
_L7:
        obj1 = obj;
_L16:
        if (obj1 != LList.Empty) goto _L10; else goto _L9
_L9:
        obj1 = LList.Empty;
        if (obj == obj1)
        {
            return;
        }
          goto _L11
_L2:
        ClassCastException classcastexception;
        Object obj2;
        Object obj3;
        Object obj4;
        Symbol symbol;
        try
        {
            obj2 = (Pair)obj;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "arg0", -2, obj);
        }
        obj1 = ((Pair) (obj2)).getCar();
        obj = lists.car.apply1(obj1);
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        obj1 = lists.cdr.apply1(obj1);
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj1.toString();
        }
        EventDispatcher.registerEventForDelegation(this, ((String) (obj)), ((String) (obj1)));
        obj = ((Pair) (obj2)).getCdr();
          goto _L12
_L4:
        try
        {
            obj1 = (Pair)obj;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            try
            {
                throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                processException(obj);
            }
            return;
        }
        obj2 = ((Pair) (obj1)).getCar();
        obj = lists.car.apply1(obj2);
        obj2 = lists.cadr.apply1(obj2);
        obj3 = (Symbol)obj;
        addToGlobalVarEnvironment(((Symbol) (obj3)), Scheme.applyToArgs.apply1(obj2));
        obj = ((Pair) (obj1)).getCdr();
          goto _L13
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "add-to-global-var-environment", 0, obj);
_L6:
        obj1 = (Pair)obj;
        misc.force(((Pair) (obj1)).getCar());
        obj = ((Pair) (obj1)).getCdr();
          goto _L14
        obj1;
        throw new WrongType(((ClassCastException) (obj1)), "arg0", -2, obj);
_L8:
        obj2 = (Pair)obj1;
        obj4 = ((Pair) (obj2)).getCar();
        obj1 = lists.caddr.apply1(obj4);
        lists.cadddr.apply1(obj4);
        obj3 = lists.cadr.apply1(obj4);
        obj4 = lists.car.apply1(obj4);
        symbol = (Symbol)obj4;
        obj4 = lookupInFormEnvironment(symbol);
        obj3 = Invoke.make.apply2(obj3, obj4);
        SlotSet.set$Mnfield$Ex.apply3(this, obj1, obj3);
        obj4 = (Symbol)obj1;
        addToFormEnvironment(((Symbol) (obj4)), obj3);
        obj1 = ((Pair) (obj2)).getCdr();
          goto _L15
        obj;
        throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj1);
        obj;
        throw new WrongType(((ClassCastException) (obj)), "lookup-in-form-environment", 0, obj4);
        obj;
        throw new WrongType(((ClassCastException) (obj)), "add-to-form-environment", 0, obj1);
_L10:
        obj2 = (Pair)obj1;
        obj1 = ((Pair) (obj2)).getCar();
        lists.caddr.apply1(obj1);
        obj1 = lists.cadddr.apply1(obj1);
        if (obj1 != Boolean.FALSE)
        {
            Scheme.applyToArgs.apply1(obj1);
        }
        obj1 = ((Pair) (obj2)).getCdr();
          goto _L16
        obj;
        throw new WrongType(((ClassCastException) (obj)), "arg0", -2, obj1);
_L11:
        obj1 = (Pair)obj;
        obj = ((Pair) (obj1)).getCar();
        obj2 = lists.caddr.apply1(obj);
        lists.cadddr.apply1(obj);
        callInitialize(SlotGet.field.apply2(this, obj2));
        obj = ((Pair) (obj1)).getCdr();
          goto _L9
        classcastexception;
        throw new WrongType(classcastexception, "arg0", -2, obj);
          goto _L12
    }

    public Object Pautas$Initialize()
    {
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Fiebre Amarilla"), Lit67, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit34, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Dengue Grave"), Lit71, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit37, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Dengue Mortal"), Lit72, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit40, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Hepatitis a"), Lit73, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit43, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Hepatitis e"), Lit74, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit46, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Chikungunya"), Lit75, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit49, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Enterovirus"), Lit76, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit57, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Leptospirosis"), Lit77, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit60, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        if (runtime.callYailPrimitive(runtime.string$Mncontains, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), "Malaria"), Lit78, "contains") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit68, Lit69, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit63, runtime.$Stthe$Mnnull$Mnvalue$St), Lit70);
        }
        return Scheme.applyToArgs.apply2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit6, runtime.$Stthe$Mnnull$Mnvalue$St), runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit33, runtime.$Stthe$Mnnull$Mnvalue$St), ","), Lit79, "split"), Lit20), Lit80, "select list item"));
    }

    public Object Web1$GotText(Object obj, Object obj1, Object obj2, Object obj3)
    {
        runtime.sanitizeComponentData(obj);
        obj = runtime.sanitizeComponentData(obj1);
        runtime.sanitizeComponentData(obj2);
        obj1 = runtime.sanitizeComponentData(obj3);
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(obj, Lit117), Lit118, "=") != Boolean.FALSE)
        {
            return runtime.setAndCoerceProperty$Ex(Lit68, Lit69, Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit52, runtime.$Stthe$Mnnull$Mnvalue$St), obj1, "", ""), Lit70);
        } else
        {
            return runtime.callComponentMethod(Lit119, Lit120, LList.list1(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("Error getting data: Response recieve from server -", obj), Lit121, "join")), Lit122);
        }
    }

    public void addToComponents(Object obj, Object obj1, Object obj2, Object obj3)
    {
        components$Mnto$Mncreate = lists.cons(LList.list4(obj, obj1, obj2, obj3), components$Mnto$Mncreate);
    }

    public void addToEvents(Object obj, Object obj1)
    {
        events$Mnto$Mnregister = lists.cons(lists.cons(obj, obj1), events$Mnto$Mnregister);
    }

    public void addToFormDoAfterCreation(Object obj)
    {
        form$Mndo$Mnafter$Mncreation = lists.cons(obj, form$Mndo$Mnafter$Mncreation);
    }

    public void addToFormEnvironment(Symbol symbol, Object obj)
    {
        androidLogForm(Format.formatToString(0, new Object[] {
            "Adding ~A to env ~A with value ~A", symbol, form$Mnenvironment, obj
        }));
        form$Mnenvironment.put(symbol, obj);
    }

    public void addToGlobalVarEnvironment(Symbol symbol, Object obj)
    {
        androidLogForm(Format.formatToString(0, new Object[] {
            "Adding ~A to env ~A with value ~A", symbol, global$Mnvar$Mnenvironment, obj
        }));
        global$Mnvar$Mnenvironment.put(symbol, obj);
    }

    public void addToGlobalVars(Object obj, Object obj1)
    {
        global$Mnvars$Mnto$Mncreate = lists.cons(LList.list2(obj, obj1), global$Mnvars$Mnto$Mncreate);
    }

    public void androidLogForm(Object obj)
    {
    }

    public boolean dispatchEvent(Component component, String s, String s1, Object aobj[])
    {
        boolean flag = false;
        SimpleSymbol simplesymbol = misc.string$To$Symbol(s);
        if (isBoundInFormEnvironment(simplesymbol))
        {
            if (lookupInFormEnvironment(simplesymbol) == component)
            {
                component = ((Component) (lookupHandler(s, s1)));
                try
                {
                    Scheme.apply.apply2(component, LList.makeList(aobj, 0));
                }
                // Misplaced declaration of an exception variable
                catch (Component component)
                {
                    androidLogForm(component.getMessage());
                    component.printStackTrace();
                    processException(component);
                    return false;
                }
                flag = true;
            }
            return flag;
        } else
        {
            EventDispatcher.unregisterEventForDelegation(this, s, s1);
            return false;
        }
    }

    public boolean isBoundInFormEnvironment(Symbol symbol)
    {
        return form$Mnenvironment.isBound(symbol);
    }

    public Object lookupHandler(Object obj, Object obj1)
    {
        Object obj2 = null;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        if (obj1 == null)
        {
            obj1 = obj2;
        } else
        {
            obj1 = obj1.toString();
        }
        return lookupInFormEnvironment(misc.string$To$Symbol(EventDispatcher.makeFullEventName(((String) (obj)), ((String) (obj1)))));
    }

    public Object lookupInFormEnvironment(Symbol symbol)
    {
        return lookupInFormEnvironment(symbol, Boolean.FALSE);
    }

    public Object lookupInFormEnvironment(Symbol symbol, Object obj)
    {
        int i;
        if (form$Mnenvironment == null)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        i = i + 1 & 1;
        if (i == 0 ? i != 0 : form$Mnenvironment.isBound(symbol))
        {
            obj = form$Mnenvironment.get(symbol);
        }
        return obj;
    }

    public void processException(Object obj)
    {
        Object obj1;
        try
        {
            obj1 = (Throwable)obj;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "com.google.appinventor.components.runtime.ReplApplication.reportError(java.lang.Throwable)", 1, obj);
        }
        ReplApplication.reportError(((Throwable) (obj1)));
        obj1 = Scheme.applyToArgs.apply1(GetNamedPart.getNamedPart.apply2(obj, Lit1));
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = obj1.toString();
        }
        if (obj instanceof YailRuntimeError)
        {
            obj = ((YailRuntimeError)obj).getErrorType();
        } else
        {
            obj = "Runtime Error";
        }
        RuntimeErrorAlert.alert(this, ((String) (obj1)), ((String) (obj)), "End Application");
    }

    public Object reportarEnfermedad$Click()
    {
        runtime.setThisForm();
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("NotificarEvento"), Lit112, "open another screen");
    }

    public void run()
    {
        CallContext callcontext;
        gnu.lists.Consumer consumer;
        callcontext = CallContext.getInstance();
        consumer = callcontext.consumer;
        callcontext.consumer = VoidConsumer.instance;
        run(callcontext);
        Throwable throwable = null;
_L2:
        ModuleBody.runCleanup(callcontext, throwable, consumer);
        return;
        throwable;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final void run(CallContext callcontext)
    {
        gnu.lists.Consumer consumer = callcontext.consumer;
        callcontext = ((CallContext) (require.find("com.google.youngandroid.runtime")));
        Runnable runnable;
        try
        {
            runnable = (Runnable)callcontext;
        }
        catch (ClassCastException classcastexception)
        {
            throw new WrongType(classcastexception, "java.lang.Runnable.run()", 1, callcontext);
        }
        runnable.run();
        $Stdebug$Mnform$St = Boolean.FALSE;
        form$Mnenvironment = Environment.make(misc.symbol$To$String(Lit0));
        callcontext = strings.stringAppend(new Object[] {
            misc.symbol$To$String(Lit0), "-global-vars"
        });
        if (callcontext == null)
        {
            callcontext = null;
        } else
        {
            callcontext = callcontext.toString();
        }
        global$Mnvar$Mnenvironment = Environment.make(callcontext);
        Pautas = null;
        form$Mnname$Mnsymbol = Lit0;
        events$Mnto$Mnregister = LList.Empty;
        components$Mnto$Mncreate = LList.Empty;
        global$Mnvars$Mnto$Mncreate = LList.Empty;
        form$Mndo$Mnafter$Mncreation = LList.Empty;
        callcontext = ((CallContext) (require.find("com.google.youngandroid.runtime")));
        try
        {
            runnable = (Runnable)callcontext;
        }
        catch (ClassCastException classcastexception1)
        {
            throw new WrongType(classcastexception1, "java.lang.Runnable.run()", 1, callcontext);
        }
        runnable.run();
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Boolean.FALSE), consumer);
        } else
        {
            addToGlobalVars(Lit3, lambda$Fn2);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit4, ""), consumer);
        } else
        {
            addToGlobalVars(Lit4, lambda$Fn3);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, "http://192.168.195.76/alerts/api/guidelines"), consumer);
        } else
        {
            addToGlobalVars(Lit5, lambda$Fn4);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit6, lambda$Fn5), consumer);
        } else
        {
            addToGlobalVars(Lit6, lambda$Fn6);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit13, ""), consumer);
        } else
        {
            addToGlobalVars(Lit13, lambda$Fn8);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit14, lambda$Fn9), consumer);
        } else
        {
            addToGlobalVars(Lit14, lambda$Fn10);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit33, runtime.callYailPrimitive(runtime.get$Mnstart$Mnvalue, LList.Empty, LList.Empty, "get start value")), consumer);
        } else
        {
            addToGlobalVars(Lit33, lambda$Fn12);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit34, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). Hemoderivados para el sangrado severo.", "2). Di\341lisis para la insuficiencia renal.", "3). L\355quidos por v\355a intravenosa [l\355quidos intravenosos]."), Lit35, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit34, lambda$Fn13);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit37, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). Es fundamentalmente la hidrataci\363n con el mantenimiento de los signos vitales y el gasto urinario.", "2). Se debe evitar el uso de aspirina y cualquier tipo de AINE.", "3). Se indica el uso de acetaminof\351n como analg\351sico y antipir\351tico."), Lit38, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit37, lambda$Fn14);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit40, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). Una transfusi\363n de plasma fresco o plaquetas puede corregir problemas de sangrado.", "2). La rehidrataci\363n con l\355quidos intravenosos con frecuencia es necesaria para tratar la deshidrataci\363n.", "3). Tratamiento complementario en un ambiente/unidad de cuidados intensivos."), Lit41, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit40, lambda$Fn15);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit43, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("1). La hepatitis aguda, a menos que sea grave, no necesita ning\372n tratamiento.", "2). La funci\363n hep\341tica y otras funciones corporales se vigilan mediante ex\341menes de sangre.", "3). Se debe reposar bastante en cama, tomar mucho l\355quido y comer alimentos saludables."), Lit44, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit43, lambda$Fn16);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit46, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("No existe un tratamiento espec\355fico.", "Generalmente la hepatitis E se resuelve espont\341neamente tras varias semanas o meses."), Lit47, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit46, lambda$Fn17);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit49, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list3("No existe un tratamiento espec\355fico.", "1). El cuadro cl\355nico se pueden tratar con medicamentos que alivien las molestias del paciente.", "2). Se debe evitar la aspirina, porque puede alterar la coagulaci\363n de la sangre."), Lit50, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit49, lambda$Fn18);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit52, lambda$Fn19), consumer);
        } else
        {
            addToGlobalVars(Lit52, lambda$Fn21);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit57, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("1). Las enfermedades causadas por enterovirus no se tratan con antibi\363ticos.", "2). Algunas de estas enfermedades son susceptibles a ciertos anti virales."), Lit58, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit57, lambda$Fn24);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit60, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("1). Algunos medicamentos para tratarla son: Ampicilina, Azitromicina, Ceftriaxona, Doxiciclina y Penicilina.", "2). Los casos complicados pueden necesitar tratamiento complementario en una unidad de cuidados intensivos."), Lit61, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit60, lambda$Fn25);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit63, runtime.callYailPrimitive(runtime.make$Mnyail$Mnlist, LList.list2("No existe un tratamiento espec\355fico.", "1). Insistir en que es una medida de urgencia y que, en cuanto, se pueda se debe acudir a un especialista."), Lit64, "make a list")), consumer);
        } else
        {
            addToGlobalVars(Lit63, lambda$Fn26);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit66, "AlertasTempranas", Lit10), consumer);
        } else
        {
            addToFormDoAfterCreation(new Promise(lambda$Fn27));
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit81, Pautas$Initialize);
        } else
        {
            addToFormEnvironment(Lit81, Pautas$Initialize);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Pautas", "Initialize");
        } else
        {
            addToEvents(Lit0, Lit82);
        }
        HorizontalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit83, Lit84, lambda$Fn28), consumer);
        } else
        {
            addToComponents(Lit0, Lit90, Lit84, lambda$Fn29);
        }
        Label1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit84, Lit91, Lit92, lambda$Fn30), consumer);
        } else
        {
            addToComponents(Lit84, Lit98, Lit92, lambda$Fn31);
        }
        ListView1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit99, Lit68, lambda$Fn32), consumer);
        } else
        {
            addToComponents(Lit0, Lit105, Lit68, lambda$Fn33);
        }
        HorizontalArrangement2 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit106, Lit107, lambda$Fn34), consumer);
        } else
        {
            addToComponents(Lit0, Lit108, Lit107, lambda$Fn35);
        }
        reportarEnfermedad = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit107, Lit109, Lit110, lambda$Fn36), consumer);
        } else
        {
            addToComponents(Lit107, Lit111, Lit110, lambda$Fn37);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit113, reportarEnfermedad$Click);
        } else
        {
            addToFormEnvironment(Lit113, reportarEnfermedad$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "reportarEnfermedad", "Click");
        } else
        {
            addToEvents(Lit110, Lit114);
        }
        Web1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit115, Lit7, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit116, Lit7, Boolean.FALSE);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit123, Web1$GotText);
        } else
        {
            addToFormEnvironment(Lit123, Web1$GotText);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Web1", "GotText");
        } else
        {
            addToEvents(Lit7, Lit124);
        }
        Notifier1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit125, Lit119, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit126, Lit119, Boolean.FALSE);
        }
        runtime.initRuntime();
    }

    public void sendError(Object obj)
    {
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = obj.toString();
        }
        RetValManager.sendError(((String) (obj)));
    }

    static 
    {
        Lit139 = (SimpleSymbol)(new SimpleSymbol("any")).readResolve();
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("text")).readResolve();
        Lit10 = simplesymbol;
        Lit122 = PairWithPosition.make(simplesymbol, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x591e1);
        Lit121 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x591d0), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x591ca);
        Lit118 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x59067), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x59062);
        Lit112 = PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x52056);
        int ai[] = new int[2];
        ai[0] = 0xff000000;
        Lit104 = IntNum.make(ai);
        Lit87 = (SimpleSymbol)(new SimpleSymbol("number")).readResolve();
        ai = (SimpleSymbol)(new SimpleSymbol("list")).readResolve();
        Lit70 = ai;
        Lit80 = PairWithPosition.make(ai, PairWithPosition.make(Lit87, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f84f), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f849);
        Lit79 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f836), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f830);
        Lit78 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f721), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f71b);
        Lit77 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f64c), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f646);
        Lit76 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f573), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f56d);
        Lit75 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f49c), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f496);
        Lit74 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f3c6), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f3c0);
        Lit73 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f2f0), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f2ea);
        Lit72 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f218), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f212);
        Lit71 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f13f), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f139);
        Lit67 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f070), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1f06a);
        Lit65 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x180ef), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x180ea);
        Lit64 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x180ef), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x180ea);
        Lit62 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x17139), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x17134);
        Lit61 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x17139), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x17134);
        Lit59 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x160fb), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x160f6);
        Lit58 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x160fb), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x160f6);
        Lit56 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1521c), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x15217), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x15211);
        Lit55 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x150f4), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x150ee);
        Lit54 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1521c), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x15217), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x15211);
        Lit53 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x150f4), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x150ee);
        Lit51 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1414a), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x14146), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x14141);
        Lit50 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1414a), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x14146), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x14141);
        Lit48 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x130e1), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x130dc);
        Lit47 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x130e1), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x130dc);
        Lit45 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x12180), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1217c), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x12177);
        Lit44 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x12180), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1217c), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x12177);
        Lit42 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x11187), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x11183), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1117e);
        Lit41 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x11187), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x11183), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1117e);
        Lit39 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x10164), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x10160), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1015b);
        Lit38 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x10164), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x10160), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 0x1015b);
        Lit36 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 61694), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 61690), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 61685);
        Lit35 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 61694), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 61690), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 61685);
        Lit32 = PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 54175);
        Lit31 = PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 54058);
        Lit30 = PairWithPosition.make(Lit70, PairWithPosition.make(Lit87, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53921), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53915);
        Lit29 = PairWithPosition.make(Lit70, PairWithPosition.make(Lit87, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53781), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53775);
        Lit28 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53650), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53645);
        Lit27 = PairWithPosition.make(Lit70, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53616);
        Lit26 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53453), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53447);
        Lit25 = PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 54175);
        Lit23 = PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 54058);
        Lit21 = PairWithPosition.make(Lit70, PairWithPosition.make(Lit87, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53921), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53915);
        Lit19 = PairWithPosition.make(Lit70, PairWithPosition.make(Lit87, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53781), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53775);
        Lit18 = PairWithPosition.make(Lit139, PairWithPosition.make(Lit139, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53650), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53645);
        Lit16 = PairWithPosition.make(Lit70, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53616);
        Lit15 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53453), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 53447);
        Lit12 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 45250), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 45245), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 45239);
        Lit9 = PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, PairWithPosition.make(Lit10, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 45250), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 45245), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Pautas.yail", 45239);
    }

    private class frame extends ModuleBody
    {

        Pautas $main;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            case 22: // '\026'
            case 23: // '\027'
            case 26: // '\032'
            case 27: // '\033'
            case 36: // '$'
            case 37: // '%'
            default:
                return super.apply0(modulemethod);

            case 17: // '\021'
                return Pautas.lambda2();

            case 18: // '\022'
                $main.$define();
                return Values.empty;

            case 19: // '\023'
                return Pautas.lambda3();

            case 20: // '\024'
                return Pautas.lambda4();

            case 21: // '\025'
                return Pautas.lambda5();

            case 24: // '\030'
                return Pautas.lambda7();

            case 25: // '\031'
                return Pautas.lambda9();

            case 28: // '\034'
                return Pautas.lambda11();

            case 29: // '\035'
                return Pautas.lambda13();

            case 30: // '\036'
                return Pautas.lambda14();

            case 31: // '\037'
                return Pautas.lambda15();

            case 32: // ' '
                return Pautas.lambda16();

            case 33: // '!'
                return Pautas.lambda17();

            case 34: // '"'
                return Pautas.lambda18();

            case 35: // '#'
                return Pautas.lambda19();

            case 38: // '&'
                return Pautas.lambda22();

            case 39: // '\''
                return Pautas.lambda25();

            case 40: // '('
                return Pautas.lambda26();

            case 41: // ')'
                return Pautas.lambda27();

            case 42: // '*'
                return Pautas.lambda28();

            case 43: // '+'
                return $main.Pautas$Initialize();

            case 44: // ','
                return Pautas.lambda29();

            case 45: // '-'
                return Pautas.lambda30();

            case 46: // '.'
                return Pautas.lambda31();

            case 47: // '/'
                return Pautas.lambda32();

            case 48: // '0'
                return Pautas.lambda33();

            case 49: // '1'
                return Pautas.lambda34();

            case 50: // '2'
                return Pautas.lambda35();

            case 51: // '3'
                return Pautas.lambda36();

            case 52: // '4'
                return Pautas.lambda37();

            case 53: // '5'
                return Pautas.lambda38();

            case 54: // '6'
                return $main.reportarEnfermedad$Click();
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply1(modulemethod, obj);

            case 3: // '\003'
                $main.androidLogForm(obj);
                return Values.empty;

            case 5: // '\005'
                modulemethod = $main;
                Symbol symbol;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
                }
                return modulemethod.lookupInFormEnvironment(symbol);

            case 7: // '\007'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "is-bound-in-form-environment", 1, obj);
                }
                if (modulemethod.isBoundInFormEnvironment(symbol))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }

            case 12: // '\f'
                $main.addToFormDoAfterCreation(obj);
                return Values.empty;

            case 13: // '\r'
                $main.sendError(obj);
                return Values.empty;

            case 14: // '\016'
                $main.processException(obj);
                return Values.empty;

            case 22: // '\026'
                return Pautas.lambda6(obj);

            case 23: // '\027'
                return Pautas.lambda8(obj);
            }
        }

        public Object apply2(ModuleMethod modulemethod, Object obj, Object obj1)
        {
            switch (modulemethod.selector)
            {
            case 6: // '\006'
            case 7: // '\007'
            case 10: // '\n'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            default:
                return super.apply2(modulemethod, obj, obj1);

            case 4: // '\004'
                modulemethod = $main;
                Symbol symbol;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "add-to-form-environment", 1, obj);
                }
                modulemethod.addToFormEnvironment(symbol, obj1);
                return Values.empty;

            case 5: // '\005'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "lookup-in-form-environment", 1, obj);
                }
                return modulemethod.lookupInFormEnvironment(symbol, obj1);

            case 8: // '\b'
                modulemethod = $main;
                try
                {
                    symbol = (Symbol)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "add-to-global-var-environment", 1, obj);
                }
                modulemethod.addToGlobalVarEnvironment(symbol, obj1);
                return Values.empty;

            case 9: // '\t'
                $main.addToEvents(obj, obj1);
                return Values.empty;

            case 11: // '\013'
                $main.addToGlobalVars(obj, obj1);
                return Values.empty;

            case 16: // '\020'
                return $main.lookupHandler(obj, obj1);
            }
        }

        public Object apply3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply3(modulemethod, obj, obj1, obj2);

            case 26: // '\032'
                return Pautas.lambda10(obj, obj1, obj2);

            case 27: // '\033'
                return Pautas.lambda12(obj, obj1, obj2);

            case 36: // '$'
                return Pautas.lambda20(obj, obj1, obj2);

            case 37: // '%'
                return Pautas.lambda23(obj, obj1, obj2);
            }
        }

        public Object apply4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.apply4(modulemethod, obj, obj1, obj2, obj3);

            case 10: // '\n'
                $main.addToComponents(obj, obj1, obj2, obj3);
                return Values.empty;

            case 15: // '\017'
                modulemethod = $main;
                Component component;
                try
                {
                    component = (Component)obj;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 1, obj);
                }
                try
                {
                    obj = (String)obj1;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 2, obj1);
                }
                try
                {
                    obj1 = (String)obj2;
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 3, obj2);
                }
                try
                {
                    obj2 = ((Object) ((Object[])obj3));
                }
                // Misplaced declaration of an exception variable
                catch (ModuleMethod modulemethod)
                {
                    throw new WrongType(modulemethod, "dispatchEvent", 4, obj3);
                }
                if (modulemethod.dispatchEvent(component, ((String) (obj)), ((String) (obj1)), ((Object []) (obj2))))
                {
                    return Boolean.TRUE;
                } else
                {
                    return Boolean.FALSE;
                }

            case 55: // '7'
                return $main.Web1$GotText(obj, obj1, obj2, obj3);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 22: // '\026'
            case 23: // '\027'
            case 26: // '\032'
            case 27: // '\033'
            case 36: // '$'
            case 37: // '%'
            default:
                return super.match0(modulemethod, callcontext);

            case 54: // '6'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 53: // '5'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 52: // '4'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 51: // '3'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 50: // '2'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 49: // '1'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 48: // '0'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 47: // '/'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 46: // '.'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 45: // '-'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 44: // ','
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 43: // '+'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 42: // '*'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 41: // ')'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 40: // '('
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 39: // '\''
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 38: // '&'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 35: // '#'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 34: // '"'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 33: // '!'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 32: // ' '
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 31: // '\037'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 30: // '\036'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 29: // '\035'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 28: // '\034'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 25: // '\031'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 24: // '\030'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 21: // '\025'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 20: // '\024'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 19: // '\023'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 18: // '\022'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 17: // '\021'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;
            }
        }

        public int match1(ModuleMethod modulemethod, Object obj, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match1(modulemethod, obj, callcontext);

            case 23: // '\027'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 22: // '\026'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 14: // '\016'
                if (!(obj instanceof Pautas))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 1;
                    return 0;
                }

            case 13: // '\r'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 12: // '\f'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;

            case 7: // '\007'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 1;
                    return 0;
                }

            case 5: // '\005'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 1;
                    return 0;
                }

            case 3: // '\003'
                callcontext.value1 = obj;
                callcontext.proc = modulemethod;
                callcontext.pc = 1;
                return 0;
            }
        }

        public int match2(ModuleMethod modulemethod, Object obj, Object obj1, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 6: // '\006'
            case 7: // '\007'
            case 10: // '\n'
            case 12: // '\f'
            case 13: // '\r'
            case 14: // '\016'
            case 15: // '\017'
            default:
                return super.match2(modulemethod, obj, obj1, callcontext);

            case 16: // '\020'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 11: // '\013'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 9: // '\t'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;

            case 8: // '\b'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.value2 = obj1;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 2;
                    return 0;
                }

            case 5: // '\005'
                if (!(obj instanceof Symbol))
                {
                    return 0xfff40001;
                } else
                {
                    callcontext.value1 = obj;
                    callcontext.value2 = obj1;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 2;
                    return 0;
                }

            case 4: // '\004'
                break;
            }
            if (!(obj instanceof Symbol))
            {
                return 0xfff40001;
            } else
            {
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.proc = modulemethod;
                callcontext.pc = 2;
                return 0;
            }
        }

        public int match3(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match3(modulemethod, obj, obj1, obj2, callcontext);

            case 37: // '%'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;

            case 36: // '$'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;

            case 27: // '\033'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;

            case 26: // '\032'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;
            }
        }

        public int match4(ModuleMethod modulemethod, Object obj, Object obj1, Object obj2, Object obj3, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            default:
                return super.match4(modulemethod, obj, obj1, obj2, obj3, callcontext);

            case 55: // '7'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;

            case 15: // '\017'
                if (!(obj instanceof Pautas))
                {
                    return 0xfff40001;
                }
                callcontext.value1 = obj;
                if (!(obj1 instanceof Component))
                {
                    return 0xfff40002;
                }
                callcontext.value2 = obj1;
                if (!(obj2 instanceof String))
                {
                    return 0xfff40003;
                }
                callcontext.value3 = obj2;
                if (!(obj3 instanceof String))
                {
                    return 0xfff40004;
                } else
                {
                    callcontext.value4 = obj3;
                    callcontext.proc = modulemethod;
                    callcontext.pc = 4;
                    return 0;
                }

            case 10: // '\n'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;
            }
        }

        public frame()
        {
        }
    }

}
