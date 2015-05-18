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

public class Noticias extends Form
    implements Runnable
{
    public class frame0 extends ModuleBody
    {

        Object $end;
        final ModuleMethod lambda$Fn8 = new ModuleMethod(this, 1, null, 4097);

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 1)
            {
                return lambda9(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda9(Object obj)
        {
            if (runtime.lookupGlobalVarInCurrentFormEnvironment(Noticias.Lit6, runtime.$Stthe$Mnnull$Mnvalue$St) != Boolean.FALSE)
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Noticias.Lit6, Boolean.FALSE);
            } else
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Noticias.Lit7, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Noticias.Lit7, runtime.$Stthe$Mnnull$Mnvalue$St), "/n", Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Noticias.Lit10, runtime.$Stthe$Mnnull$Mnvalue$St), obj, "{", $end)), Noticias.Lit11, "join"));
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
        final ModuleMethod lambda$Fn11 = new ModuleMethod(this, 2, null, 4097);

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            if (modulemethod.selector == 2)
            {
                return lambda12(obj);
            } else
            {
                return super.apply1(modulemethod, obj);
            }
        }

        Object lambda12(Object obj)
        {
            if (runtime.lookupGlobalVarInCurrentFormEnvironment(Noticias.Lit6, runtime.$Stthe$Mnnull$Mnvalue$St) != Boolean.FALSE)
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Noticias.Lit6, Boolean.FALSE);
            } else
            {
                return runtime.addGlobalVarToCurrentFormEnvironment(Noticias.Lit7, runtime.callYailPrimitive(strings.string$Mnappend, LList.list3(runtime.lookupGlobalVarInCurrentFormEnvironment(Noticias.Lit7, runtime.$Stthe$Mnnull$Mnvalue$St), "/n", Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Noticias.Lit10, runtime.$Stthe$Mnnull$Mnvalue$St), obj, "{", $end)), Noticias.Lit17, "join"));
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


    static final SimpleSymbol Lit0 = (SimpleSymbol)(new SimpleSymbol("Noticias")).readResolve();
    static final SimpleSymbol Lit1 = (SimpleSymbol)(new SimpleSymbol("getMessage")).readResolve();
    static final SimpleSymbol Lit10 = (SimpleSymbol)(new SimpleSymbol("p$parse")).readResolve();
    static final SimpleSymbol Lit100 = (SimpleSymbol)(new SimpleSymbol("add-to-events")).readResolve();
    static final SimpleSymbol Lit101 = (SimpleSymbol)(new SimpleSymbol("add-to-components")).readResolve();
    static final SimpleSymbol Lit102 = (SimpleSymbol)(new SimpleSymbol("add-to-global-vars")).readResolve();
    static final SimpleSymbol Lit103 = (SimpleSymbol)(new SimpleSymbol("add-to-form-do-after-creation")).readResolve();
    static final SimpleSymbol Lit104 = (SimpleSymbol)(new SimpleSymbol("send-error")).readResolve();
    static final SimpleSymbol Lit105 = (SimpleSymbol)(new SimpleSymbol("dispatchEvent")).readResolve();
    static final SimpleSymbol Lit106 = (SimpleSymbol)(new SimpleSymbol("lookup-handler")).readResolve();
    static final SimpleSymbol Lit107;
    static final PairWithPosition Lit11;
    static final SimpleSymbol Lit12 = (SimpleSymbol)(new SimpleSymbol("Notifier1")).readResolve();
    static final SimpleSymbol Lit13 = (SimpleSymbol)(new SimpleSymbol("ShowAlert")).readResolve();
    static final PairWithPosition Lit14;
    static final PairWithPosition Lit15;
    static final PairWithPosition Lit16;
    static final PairWithPosition Lit17;
    static final PairWithPosition Lit18;
    static final PairWithPosition Lit19;
    static final SimpleSymbol Lit2 = (SimpleSymbol)(new SimpleSymbol("*the-null-value*")).readResolve();
    static final SimpleSymbol Lit20 = (SimpleSymbol)(new SimpleSymbol("p$getReports")).readResolve();
    static final SimpleSymbol Lit21 = (SimpleSymbol)(new SimpleSymbol("Web1")).readResolve();
    static final SimpleSymbol Lit22 = (SimpleSymbol)(new SimpleSymbol("Url")).readResolve();
    static final SimpleSymbol Lit23;
    static final SimpleSymbol Lit24 = (SimpleSymbol)(new SimpleSymbol("Get")).readResolve();
    static final PairWithPosition Lit25;
    static final PairWithPosition Lit26;
    static final IntNum Lit27 = IntNum.make(2);
    static final PairWithPosition Lit28;
    static final PairWithPosition Lit29;
    static final SimpleSymbol Lit3 = (SimpleSymbol)(new SimpleSymbol("g$reporte")).readResolve();
    static final PairWithPosition Lit30;
    static final IntNum Lit31 = IntNum.make(1);
    static final PairWithPosition Lit32;
    static final SimpleSymbol Lit33 = (SimpleSymbol)(new SimpleSymbol("JsonTextDecode")).readResolve();
    static final PairWithPosition Lit34;
    static final SimpleSymbol Lit35 = (SimpleSymbol)(new SimpleSymbol("HtmlTextDecode")).readResolve();
    static final PairWithPosition Lit36;
    static final PairWithPosition Lit37;
    static final PairWithPosition Lit38;
    static final PairWithPosition Lit39;
    static final SimpleSymbol Lit4 = (SimpleSymbol)(new SimpleSymbol("g$url")).readResolve();
    static final PairWithPosition Lit40;
    static final PairWithPosition Lit41;
    static final PairWithPosition Lit42;
    static final PairWithPosition Lit43;
    static final PairWithPosition Lit44;
    static final SimpleSymbol Lit45 = (SimpleSymbol)(new SimpleSymbol("AppName")).readResolve();
    static final SimpleSymbol Lit46 = (SimpleSymbol)(new SimpleSymbol("Title")).readResolve();
    static final PairWithPosition Lit47;
    static final PairWithPosition Lit48;
    static final SimpleSymbol Lit49 = (SimpleSymbol)(new SimpleSymbol("ListView1")).readResolve();
    static final SimpleSymbol Lit5 = (SimpleSymbol)(new SimpleSymbol("g$tempData")).readResolve();
    static final SimpleSymbol Lit50 = (SimpleSymbol)(new SimpleSymbol("Elements")).readResolve();
    static final SimpleSymbol Lit51;
    static final PairWithPosition Lit52;
    static final SimpleSymbol Lit53 = (SimpleSymbol)(new SimpleSymbol("Noticias$Initialize")).readResolve();
    static final SimpleSymbol Lit54 = (SimpleSymbol)(new SimpleSymbol("Initialize")).readResolve();
    static final FString Lit55 = new FString("com.google.appinventor.components.runtime.Label");
    static final SimpleSymbol Lit56 = (SimpleSymbol)(new SimpleSymbol("Label1")).readResolve();
    static final SimpleSymbol Lit57 = (SimpleSymbol)(new SimpleSymbol("FontBold")).readResolve();
    static final SimpleSymbol Lit58;
    static final SimpleSymbol Lit59 = (SimpleSymbol)(new SimpleSymbol("FontSize")).readResolve();
    static final SimpleSymbol Lit6 = (SimpleSymbol)(new SimpleSymbol("g$isFirstItem")).readResolve();
    static final DFloNum Lit60 = DFloNum.make(20);
    static final SimpleSymbol Lit61;
    static final SimpleSymbol Lit62 = (SimpleSymbol)(new SimpleSymbol("Width")).readResolve();
    static final IntNum Lit63 = IntNum.make(-2);
    static final SimpleSymbol Lit64 = (SimpleSymbol)(new SimpleSymbol("Text")).readResolve();
    static final SimpleSymbol Lit65 = (SimpleSymbol)(new SimpleSymbol("TextAlignment")).readResolve();
    static final FString Lit66 = new FString("com.google.appinventor.components.runtime.Label");
    static final FString Lit67 = new FString("com.google.appinventor.components.runtime.ListView");
    static final SimpleSymbol Lit68 = (SimpleSymbol)(new SimpleSymbol("BackgroundColor")).readResolve();
    static final IntNum Lit69 = IntNum.make(0xffffff);
    static final SimpleSymbol Lit7 = (SimpleSymbol)(new SimpleSymbol("g$allReports")).readResolve();
    static final SimpleSymbol Lit70 = (SimpleSymbol)(new SimpleSymbol("Height")).readResolve();
    static final SimpleSymbol Lit71 = (SimpleSymbol)(new SimpleSymbol("TextColor")).readResolve();
    static final IntNum Lit72;
    static final FString Lit73 = new FString("com.google.appinventor.components.runtime.ListView");
    static final FString Lit74 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final SimpleSymbol Lit75 = (SimpleSymbol)(new SimpleSymbol("HorizontalArrangement1")).readResolve();
    static final SimpleSymbol Lit76 = (SimpleSymbol)(new SimpleSymbol("AlignHorizontal")).readResolve();
    static final IntNum Lit77 = IntNum.make(3);
    static final FString Lit78 = new FString("com.google.appinventor.components.runtime.HorizontalArrangement");
    static final FString Lit79 = new FString("com.google.appinventor.components.runtime.Button");
    static final SimpleSymbol Lit8 = (SimpleSymbol)(new SimpleSymbol("p$getAllReports")).readResolve();
    static final SimpleSymbol Lit80 = (SimpleSymbol)(new SimpleSymbol("reportarEnfermedad")).readResolve();
    static final FString Lit81 = new FString("com.google.appinventor.components.runtime.Button");
    static final PairWithPosition Lit82;
    static final SimpleSymbol Lit83 = (SimpleSymbol)(new SimpleSymbol("reportarEnfermedad$Click")).readResolve();
    static final SimpleSymbol Lit84 = (SimpleSymbol)(new SimpleSymbol("Click")).readResolve();
    static final FString Lit85 = new FString("com.google.appinventor.components.runtime.Web");
    static final FString Lit86 = new FString("com.google.appinventor.components.runtime.Web");
    static final IntNum Lit87 = IntNum.make(200);
    static final PairWithPosition Lit88;
    static final PairWithPosition Lit89;
    static final PairWithPosition Lit9;
    static final PairWithPosition Lit90;
    static final SimpleSymbol Lit91 = (SimpleSymbol)(new SimpleSymbol("Web1$GotText")).readResolve();
    static final SimpleSymbol Lit92 = (SimpleSymbol)(new SimpleSymbol("GotText")).readResolve();
    static final FString Lit93 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final FString Lit94 = new FString("com.google.appinventor.components.runtime.Notifier");
    static final SimpleSymbol Lit95 = (SimpleSymbol)(new SimpleSymbol("android-log-form")).readResolve();
    static final SimpleSymbol Lit96 = (SimpleSymbol)(new SimpleSymbol("add-to-form-environment")).readResolve();
    static final SimpleSymbol Lit97 = (SimpleSymbol)(new SimpleSymbol("lookup-in-form-environment")).readResolve();
    static final SimpleSymbol Lit98 = (SimpleSymbol)(new SimpleSymbol("is-bound-in-form-environment")).readResolve();
    static final SimpleSymbol Lit99 = (SimpleSymbol)(new SimpleSymbol("add-to-global-var-environment")).readResolve();
    public static Noticias Noticias;
    static final ModuleMethod lambda$Fn1;
    static final ModuleMethod lambda$Fn10;
    static final ModuleMethod lambda$Fn12;
    static final ModuleMethod lambda$Fn13;
    static final ModuleMethod lambda$Fn14;
    static final ModuleMethod lambda$Fn15;
    static final ModuleMethod lambda$Fn16;
    static final ModuleMethod lambda$Fn17;
    static final ModuleMethod lambda$Fn18;
    static final ModuleMethod lambda$Fn19;
    static final ModuleMethod lambda$Fn2;
    static final ModuleMethod lambda$Fn20;
    static final ModuleMethod lambda$Fn21;
    static final ModuleMethod lambda$Fn22;
    static final ModuleMethod lambda$Fn23;
    static final ModuleMethod lambda$Fn24;
    static final ModuleMethod lambda$Fn25;
    static final ModuleMethod lambda$Fn26;
    static final ModuleMethod lambda$Fn3;
    static final ModuleMethod lambda$Fn4;
    static final ModuleMethod lambda$Fn5;
    static final ModuleMethod lambda$Fn6;
    static final ModuleMethod lambda$Fn7;
    static final ModuleMethod lambda$Fn9;
    public Boolean $Stdebug$Mnform$St;
    public final ModuleMethod $define;
    public HorizontalArrangement HorizontalArrangement1;
    public Label Label1;
    public ListView ListView1;
    public final ModuleMethod Noticias$Initialize;
    public Notifier Notifier1;
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

    public Noticias()
    {
        ModuleInfo.register(this);
        frame frame2 = new frame();
        frame2.main = this;
        android$Mnlog$Mnform = new ModuleMethod(frame2, 3, Lit95, 4097);
        add$Mnto$Mnform$Mnenvironment = new ModuleMethod(frame2, 4, Lit96, 8194);
        lookup$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 5, Lit97, 8193);
        is$Mnbound$Mnin$Mnform$Mnenvironment = new ModuleMethod(frame2, 7, Lit98, 4097);
        add$Mnto$Mnglobal$Mnvar$Mnenvironment = new ModuleMethod(frame2, 8, Lit99, 8194);
        add$Mnto$Mnevents = new ModuleMethod(frame2, 9, Lit100, 8194);
        add$Mnto$Mncomponents = new ModuleMethod(frame2, 10, Lit101, 16388);
        add$Mnto$Mnglobal$Mnvars = new ModuleMethod(frame2, 11, Lit102, 8194);
        add$Mnto$Mnform$Mndo$Mnafter$Mncreation = new ModuleMethod(frame2, 12, Lit103, 4097);
        send$Mnerror = new ModuleMethod(frame2, 13, Lit104, 4097);
        process$Mnexception = new ModuleMethod(frame2, 14, "process-exception", 4097);
        dispatchEvent = new ModuleMethod(frame2, 15, Lit105, 16388);
        lookup$Mnhandler = new ModuleMethod(frame2, 16, Lit106, 8194);
        ModuleMethod modulemethod = new ModuleMethod(frame2, 17, null, 0);
        modulemethod.setProperty("source-location", "/tmp/runtime2895667505349593926.scm:541");
        lambda$Fn1 = modulemethod;
        $define = new ModuleMethod(frame2, 18, "$define", 0);
        lambda$Fn2 = new ModuleMethod(frame2, 19, null, 0);
        lambda$Fn3 = new ModuleMethod(frame2, 20, null, 0);
        lambda$Fn4 = new ModuleMethod(frame2, 21, null, 0);
        lambda$Fn5 = new ModuleMethod(frame2, 22, null, 0);
        lambda$Fn6 = new ModuleMethod(frame2, 23, null, 0);
        lambda$Fn7 = new ModuleMethod(frame2, 24, null, 12291);
        lambda$Fn10 = new ModuleMethod(frame2, 25, null, 12291);
        lambda$Fn9 = new ModuleMethod(frame2, 26, null, 0);
        lambda$Fn12 = new ModuleMethod(frame2, 27, null, 0);
        lambda$Fn14 = new ModuleMethod(frame2, 28, null, 0);
        lambda$Fn13 = new ModuleMethod(frame2, 29, null, 0);
        lambda$Fn15 = new ModuleMethod(frame2, 30, null, 12291);
        lambda$Fn17 = new ModuleMethod(frame2, 31, null, 12291);
        lambda$Fn16 = new ModuleMethod(frame2, 32, null, 0);
        lambda$Fn18 = new ModuleMethod(frame2, 33, null, 0);
        Noticias$Initialize = new ModuleMethod(frame2, 34, Lit53, 0);
        lambda$Fn19 = new ModuleMethod(frame2, 35, null, 0);
        lambda$Fn20 = new ModuleMethod(frame2, 36, null, 0);
        lambda$Fn21 = new ModuleMethod(frame2, 37, null, 0);
        lambda$Fn22 = new ModuleMethod(frame2, 38, null, 0);
        lambda$Fn23 = new ModuleMethod(frame2, 39, null, 0);
        lambda$Fn24 = new ModuleMethod(frame2, 40, null, 0);
        lambda$Fn25 = new ModuleMethod(frame2, 41, null, 0);
        lambda$Fn26 = new ModuleMethod(frame2, 42, null, 0);
        reportarEnfermedad$Click = new ModuleMethod(frame2, 43, Lit83, 0);
        Web1$GotText = new ModuleMethod(frame2, 44, Lit91, 16388);
    }

    static Procedure lambda10()
    {
        return lambda$Fn10;
    }

    static Object lambda11(Object obj, Object obj1, Object obj2)
    {
        frame1 frame1_1 = new frame1();
        frame1_1.end = obj2;
        runtime.addGlobalVarToCurrentFormEnvironment(Lit6, Boolean.TRUE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit7, "");
        runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(obj, obj1), Lit16, "split"));
        runtime.yailForEach(frame1_1.Fn11, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St));
        runtime.callComponentMethod(Lit12, Lit13, LList.list1(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("Aun no hay reportes", runtime.lookupGlobalVarInCurrentFormEnvironment(Lit7, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit18, "join")), Lit19);
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit7, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda13()
    {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), Lit23);
        return runtime.callComponentMethod(Lit21, Lit24, LList.Empty, LList.Empty);
    }

    static Procedure lambda14()
    {
        return lambda$Fn14;
    }

    static Object lambda15()
    {
        runtime.setAndCoerceProperty$Ex(Lit21, Lit22, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit4, runtime.$Stthe$Mnnull$Mnvalue$St), Lit23);
        return runtime.callComponentMethod(Lit21, Lit24, LList.Empty, LList.Empty);
    }

    static Object lambda16(Object obj, Object obj1, Object obj2)
    {
        runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.string$Mnsplit$Mnat$Mnfirst, LList.list2(obj, obj1), Lit25, "split at first"));
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit26, "length of list"), Lit27), Lit28, "=") != Boolean.FALSE)
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St), Lit27), Lit29, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.callYailPrimitive(runtime.string$Mnsplit$Mnat$Mnfirst, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St), obj2), Lit30, "split at first"), Lit31), Lit32, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callComponentMethod(Lit21, Lit33, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit34));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callComponentMethod(Lit21, Lit35, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit36));
        } else
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, "No hay resultados");
        }
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Procedure lambda17()
    {
        return lambda$Fn17;
    }

    static Object lambda18(Object obj, Object obj1, Object obj2)
    {
        runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.string$Mnsplit$Mnat$Mnfirst, LList.list2(obj, obj1), Lit37, "split at first"));
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(runtime.callYailPrimitive(runtime.yail$Mnlist$Mnlength, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit38, "length of list"), Lit27), Lit39, "=") != Boolean.FALSE)
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St), Lit27), Lit40, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.yail$Mnlist$Mnget$Mnitem, LList.list2(runtime.callYailPrimitive(runtime.string$Mnsplit$Mnat$Mnfirst, LList.list2(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St), obj2), Lit41, "split at first"), Lit31), Lit42, "select list item"));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callComponentMethod(Lit21, Lit33, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit43));
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callComponentMethod(Lit21, Lit35, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit44));
        } else
        {
            runtime.addGlobalVarToCurrentFormEnvironment(Lit5, "No hay resultados");
        }
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St);
    }

    static Object lambda19()
    {
        runtime.setAndCoerceProperty$Ex(Lit0, Lit45, "AlertasTempranas", Lit23);
        return runtime.setAndCoerceProperty$Ex(Lit0, Lit46, "Reportes Recientes", Lit23);
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

    static Object lambda20()
    {
        runtime.setAndCoerceProperty$Ex(Lit56, Lit57, Boolean.TRUE, Lit58);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit59, Lit60, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit62, Lit63, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit64, "Enfermedades Reportadas", Lit23);
        return runtime.setAndCoerceProperty$Ex(Lit56, Lit65, Lit31, Lit61);
    }

    static Object lambda21()
    {
        runtime.setAndCoerceProperty$Ex(Lit56, Lit57, Boolean.TRUE, Lit58);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit59, Lit60, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit62, Lit63, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit56, Lit64, "Enfermedades Reportadas", Lit23);
        return runtime.setAndCoerceProperty$Ex(Lit56, Lit65, Lit31, Lit61);
    }

    static Object lambda22()
    {
        runtime.setAndCoerceProperty$Ex(Lit49, Lit68, Lit69, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit49, Lit70, Lit63, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit49, Lit62, Lit63, Lit61);
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit71, Lit72, Lit61);
    }

    static Object lambda23()
    {
        runtime.setAndCoerceProperty$Ex(Lit49, Lit68, Lit69, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit49, Lit70, Lit63, Lit61);
        runtime.setAndCoerceProperty$Ex(Lit49, Lit62, Lit63, Lit61);
        return runtime.setAndCoerceProperty$Ex(Lit49, Lit71, Lit72, Lit61);
    }

    static Object lambda24()
    {
        runtime.setAndCoerceProperty$Ex(Lit75, Lit76, Lit77, Lit61);
        return runtime.setAndCoerceProperty$Ex(Lit75, Lit62, Lit63, Lit61);
    }

    static Object lambda25()
    {
        runtime.setAndCoerceProperty$Ex(Lit75, Lit76, Lit77, Lit61);
        return runtime.setAndCoerceProperty$Ex(Lit75, Lit62, Lit63, Lit61);
    }

    static Object lambda26()
    {
        return runtime.setAndCoerceProperty$Ex(Lit80, Lit64, "Reportar Enfermedad", Lit23);
    }

    static Object lambda27()
    {
        return runtime.setAndCoerceProperty$Ex(Lit80, Lit64, "Reportar Enfermedad", Lit23);
    }

    static Object lambda3()
    {
        return runtime.callYailPrimitive(runtime.get$Mnstart$Mnvalue, LList.Empty, LList.Empty, "get start value");
    }

    static String lambda4()
    {
        return "http://192.168.195.76/alerts/api/reports";
    }

    static String lambda5()
    {
        return "";
    }

    static Boolean lambda6()
    {
        return Boolean.FALSE;
    }

    static String lambda7()
    {
        return "";
    }

    static Object lambda8(Object obj, Object obj1, Object obj2)
    {
        frame0 frame0_1 = new frame0();
        frame0_1.end = obj2;
        runtime.addGlobalVarToCurrentFormEnvironment(Lit6, Boolean.TRUE);
        runtime.addGlobalVarToCurrentFormEnvironment(Lit7, "");
        runtime.addGlobalVarToCurrentFormEnvironment(Lit5, runtime.callYailPrimitive(runtime.string$Mnsplit, LList.list2(obj, obj1), Lit9, "split"));
        runtime.yailForEach(frame0_1.Fn8, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit5, runtime.$Stthe$Mnnull$Mnvalue$St));
        runtime.callComponentMethod(Lit12, Lit13, LList.list1(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("Aun no hay reportes", runtime.lookupGlobalVarInCurrentFormEnvironment(Lit7, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit14, "join")), Lit15);
        return runtime.lookupGlobalVarInCurrentFormEnvironment(Lit7, runtime.$Stthe$Mnnull$Mnvalue$St);
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
        Noticias = this;
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

    public Object Noticias$Initialize()
    {
        runtime.setThisForm();
        Scheme.applyToArgs.apply1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit20, runtime.$Stthe$Mnnull$Mnvalue$St));
        if (runtime.callYailPrimitive(runtime.yail$Mnnot, LList.list1(runtime.callYailPrimitive(runtime.string$Mnempty$Qu, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit47, "is text empty?")), Lit48, "not") != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit49, Lit50, runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St), Lit51);
        }
        return runtime.callComponentMethod(Lit12, Lit13, LList.list1(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit3, runtime.$Stthe$Mnnull$Mnvalue$St)), Lit52);
    }

    public Object Web1$GotText(Object obj, Object obj1, Object obj2, Object obj3)
    {
        runtime.sanitizeComponentData(obj);
        obj = runtime.sanitizeComponentData(obj1);
        runtime.sanitizeComponentData(obj2);
        obj1 = runtime.sanitizeComponentData(obj3);
        runtime.setThisForm();
        if (runtime.callYailPrimitive(runtime.yail$Mnequal$Qu, LList.list2(obj, Lit87), Lit88, "=") != Boolean.FALSE)
        {
            return runtime.addGlobalVarToCurrentFormEnvironment(Lit3, Scheme.applyToArgs.apply4(runtime.lookupGlobalVarInCurrentFormEnvironment(Lit8, runtime.$Stthe$Mnnull$Mnvalue$St), obj1, ",", "}"));
        } else
        {
            return runtime.callComponentMethod(Lit12, Lit13, LList.list1(runtime.callYailPrimitive(strings.string$Mnappend, LList.list2("Aun no hay reportes", obj), Lit89, "join")), Lit90);
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
        return runtime.callYailPrimitive(runtime.open$Mnanother$Mnscreen, LList.list1("NotificarEvento"), Lit82, "open another screen");
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
        Noticias = null;
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
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit3, runtime.callYailPrimitive(runtime.get$Mnstart$Mnvalue, LList.Empty, LList.Empty, "get start value")), consumer);
        } else
        {
            addToGlobalVars(Lit3, lambda$Fn2);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit4, "http://192.168.195.76/alerts/api/reports"), consumer);
        } else
        {
            addToGlobalVars(Lit4, lambda$Fn3);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit5, ""), consumer);
        } else
        {
            addToGlobalVars(Lit5, lambda$Fn4);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit6, Boolean.FALSE), consumer);
        } else
        {
            addToGlobalVars(Lit6, lambda$Fn5);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit7, ""), consumer);
        } else
        {
            addToGlobalVars(Lit7, lambda$Fn6);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit8, lambda$Fn7), consumer);
        } else
        {
            addToGlobalVars(Lit8, lambda$Fn9);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit20, lambda$Fn12), consumer);
        } else
        {
            addToGlobalVars(Lit20, lambda$Fn13);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addGlobalVarToCurrentFormEnvironment(Lit10, lambda$Fn15), consumer);
        } else
        {
            addToGlobalVars(Lit10, lambda$Fn16);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.setAndCoerceProperty$Ex(Lit0, Lit45, "AlertasTempranas", Lit23);
            Values.writeValues(runtime.setAndCoerceProperty$Ex(Lit0, Lit46, "Reportes Recientes", Lit23), consumer);
        } else
        {
            addToFormDoAfterCreation(new Promise(lambda$Fn18));
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit53, Noticias$Initialize);
        } else
        {
            addToFormEnvironment(Lit53, Noticias$Initialize);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Noticias", "Initialize");
        } else
        {
            addToEvents(Lit0, Lit54);
        }
        Label1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit55, Lit56, lambda$Fn19), consumer);
        } else
        {
            addToComponents(Lit0, Lit66, Lit56, lambda$Fn20);
        }
        ListView1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit67, Lit49, lambda$Fn21), consumer);
        } else
        {
            addToComponents(Lit0, Lit73, Lit49, lambda$Fn22);
        }
        HorizontalArrangement1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit74, Lit75, lambda$Fn23), consumer);
        } else
        {
            addToComponents(Lit0, Lit78, Lit75, lambda$Fn24);
        }
        reportarEnfermedad = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit75, Lit79, Lit80, lambda$Fn25), consumer);
        } else
        {
            addToComponents(Lit75, Lit81, Lit80, lambda$Fn26);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit83, reportarEnfermedad$Click);
        } else
        {
            addToFormEnvironment(Lit83, reportarEnfermedad$Click);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "reportarEnfermedad", "Click");
        } else
        {
            addToEvents(Lit80, Lit84);
        }
        Web1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit85, Lit21, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit86, Lit21, Boolean.FALSE);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            runtime.addToCurrentFormEnvironment(Lit91, Web1$GotText);
        } else
        {
            addToFormEnvironment(Lit91, Web1$GotText);
        }
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            EventDispatcher.registerEventForDelegation((HandlesEventDispatching)runtime.$Stthis$Mnform$St, "Web1", "GotText");
        } else
        {
            addToEvents(Lit21, Lit92);
        }
        Notifier1 = null;
        if (runtime.$Stthis$Mnis$Mnthe$Mnrepl$St != Boolean.FALSE)
        {
            Values.writeValues(runtime.addComponentWithinRepl(Lit0, Lit93, Lit12, Boolean.FALSE), consumer);
        } else
        {
            addToComponents(Lit0, Lit94, Lit12, Boolean.FALSE);
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
        Lit107 = (SimpleSymbol)(new SimpleSymbol("any")).readResolve();
        SimpleSymbol simplesymbol = (SimpleSymbol)(new SimpleSymbol("text")).readResolve();
        Lit23 = simplesymbol;
        Lit90 = PairWithPosition.make(simplesymbol, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x4c1a4);
        Lit89 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x4c193), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x4c18d);
        Lit88 = PairWithPosition.make(Lit107, PairWithPosition.make(Lit107, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x4c067), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x4c062);
        Lit82 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x45056);
        int ai[] = new int[2];
        ai[0] = 0xff000000;
        Lit72 = IntNum.make(ai);
        Lit61 = (SimpleSymbol)(new SimpleSymbol("number")).readResolve();
        Lit58 = (SimpleSymbol)(new SimpleSymbol("boolean")).readResolve();
        Lit52 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x17178);
        Lit51 = (SimpleSymbol)(new SimpleSymbol("list")).readResolve();
        Lit48 = PairWithPosition.make(Lit58, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x170bc);
        Lit47 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 0x170a1);
        Lit44 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62486);
        Lit43 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62369);
        Lit42 = PairWithPosition.make(Lit51, PairWithPosition.make(Lit61, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62232), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62226);
        Lit41 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62198), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62192);
        Lit40 = PairWithPosition.make(Lit51, PairWithPosition.make(Lit61, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61973), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61967);
        Lit39 = PairWithPosition.make(Lit107, PairWithPosition.make(Lit107, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61842), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61837);
        Lit38 = PairWithPosition.make(Lit51, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61808);
        Lit37 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61645), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61639);
        Lit36 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62486);
        Lit34 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62369);
        Lit32 = PairWithPosition.make(Lit51, PairWithPosition.make(Lit61, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62232), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62226);
        Lit30 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62198), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 62192);
        Lit29 = PairWithPosition.make(Lit51, PairWithPosition.make(Lit61, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61973), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61967);
        Lit28 = PairWithPosition.make(Lit107, PairWithPosition.make(Lit107, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61842), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61837);
        Lit26 = PairWithPosition.make(Lit51, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61808);
        Lit25 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61645), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 61639);
        Lit19 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 54026);
        Lit18 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 54009), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 54003);
        Lit17 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53795), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53790), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53784);
        Lit16 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53494), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53488);
        Lit15 = PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 54026);
        Lit14 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 54009), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 54003);
        Lit11 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53795), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53790), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53784);
        Lit9 = PairWithPosition.make(Lit23, PairWithPosition.make(Lit23, LList.Empty, "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53494), "/tmp/1431403662893_0.48726725371428536-0/youngandroidproject/../src/appinventor/ai_mafeosza/AlertasTempranas/Noticias.yail", 53488);
    }

    private class frame extends ModuleBody
    {

        Noticias $main;

        public Object apply0(ModuleMethod modulemethod)
        {
            switch (modulemethod.selector)
            {
            case 24: // '\030'
            case 25: // '\031'
            case 30: // '\036'
            case 31: // '\037'
            default:
                return super.apply0(modulemethod);

            case 17: // '\021'
                return Noticias.lambda2();

            case 18: // '\022'
                $main.$define();
                return Values.empty;

            case 19: // '\023'
                return Noticias.lambda3();

            case 20: // '\024'
                return Noticias.lambda4();

            case 21: // '\025'
                return Noticias.lambda5();

            case 22: // '\026'
                return Noticias.lambda6();

            case 23: // '\027'
                return Noticias.lambda7();

            case 26: // '\032'
                return Noticias.lambda10();

            case 27: // '\033'
                return Noticias.lambda13();

            case 28: // '\034'
                return Noticias.lambda15();

            case 29: // '\035'
                return Noticias.lambda14();

            case 32: // ' '
                return Noticias.lambda17();

            case 33: // '!'
                return Noticias.lambda19();

            case 34: // '"'
                return $main.Noticias$Initialize();

            case 35: // '#'
                return Noticias.lambda20();

            case 36: // '$'
                return Noticias.lambda21();

            case 37: // '%'
                return Noticias.lambda22();

            case 38: // '&'
                return Noticias.lambda23();

            case 39: // '\''
                return Noticias.lambda24();

            case 40: // '('
                return Noticias.lambda25();

            case 41: // ')'
                return Noticias.lambda26();

            case 42: // '*'
                return Noticias.lambda27();

            case 43: // '+'
                return $main.reportarEnfermedad$Click();
            }
        }

        public Object apply1(ModuleMethod modulemethod, Object obj)
        {
            switch (modulemethod.selector)
            {
            case 4: // '\004'
            case 6: // '\006'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
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
            case 26: // '\032'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
            default:
                return super.apply3(modulemethod, obj, obj1, obj2);

            case 24: // '\030'
                return Noticias.lambda8(obj, obj1, obj2);

            case 25: // '\031'
                return Noticias.lambda11(obj, obj1, obj2);

            case 30: // '\036'
                return Noticias.lambda16(obj, obj1, obj2);

            case 31: // '\037'
                return Noticias.lambda18(obj, obj1, obj2);
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

            case 44: // ','
                return $main.Web1$GotText(obj, obj1, obj2, obj3);
            }
        }

        public int match0(ModuleMethod modulemethod, CallContext callcontext)
        {
            switch (modulemethod.selector)
            {
            case 24: // '\030'
            case 25: // '\031'
            case 30: // '\036'
            case 31: // '\037'
            default:
                return super.match0(modulemethod, callcontext);

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

            case 37: // '%'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 36: // '$'
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

            case 29: // '\035'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 28: // '\034'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 27: // '\033'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 26: // '\032'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 23: // '\027'
                callcontext.proc = modulemethod;
                callcontext.pc = 0;
                return 0;

            case 22: // '\026'
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
            int i = 0xfff40001;
            modulemethod.selector;
            JVM INSTR tableswitch 3 14: default 72
        //                       3 190
        //                       4 72
        //                       5 166
        //                       6 72
        //                       7 142
        //                       8 72
        //                       9 72
        //                       10 72
        //                       11 72
        //                       12 125
        //                       13 108
        //                       14 84;
               goto _L1 _L2 _L1 _L3 _L1 _L4 _L1 _L1 _L1 _L1 _L5 _L6 _L7
_L1:
            i = super.match1(modulemethod, obj, callcontext);
_L9:
            return i;
_L7:
            if (!(obj instanceof Noticias)) goto _L9; else goto _L8
_L8:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L6:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L5:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L4:
            if (!(obj instanceof Symbol)) goto _L9; else goto _L10
_L10:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L3:
            if (!(obj instanceof Symbol)) goto _L9; else goto _L11
_L11:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
_L2:
            callcontext.value1 = obj;
            callcontext.proc = modulemethod;
            callcontext.pc = 1;
            return 0;
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
            case 26: // '\032'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
            default:
                return super.match3(modulemethod, obj, obj1, obj2, callcontext);

            case 31: // '\037'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;

            case 30: // '\036'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;

            case 25: // '\031'
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.proc = modulemethod;
                callcontext.pc = 3;
                return 0;

            case 24: // '\030'
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

            case 44: // ','
                callcontext.value1 = obj;
                callcontext.value2 = obj1;
                callcontext.value3 = obj2;
                callcontext.value4 = obj3;
                callcontext.proc = modulemethod;
                callcontext.pc = 4;
                return 0;

            case 15: // '\017'
                if (!(obj instanceof Noticias))
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
